package org.exercise.middleware.fastdfs;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * @ClassName: TrackerServerPool
 * @Description:  TrackerServer 对象池
 * @Author: Gavin
 * @Create: 2020-07-09 13:57
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 13:57 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Slf4j
public class TrackerServerPool {

    /**
     * TrackerServer 配置文件路径
     */
    private static final String FASTDFS_CONFIG_PATH = "config.properties";

    /**
     * 最大连接数 default 8.
     */
    @Value("${max_storage_connection}")
    private static int maxStorageConnection;

    /**
     * TrackerServer 对象池.
     * GenericObjectPool 没有无参构造
     */
    private static GenericObjectPool<TrackerServer> trackerServerPool;

    private TrackerServerPool(){};

    private static synchronized GenericObjectPool<TrackerServer> getObjectPool(){
        if(trackerServerPool == null){
            try {
                // 加载配置文件
                ClientGlobal.initByProperties(FASTDFS_CONFIG_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }

            if(log.isDebugEnabled()){
                log.debug("ClientGlobal configInfo: {}", ClientGlobal.configInfo());
            }

            // Pool配置
            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setMinIdle(2);
            if(maxStorageConnection > 0){
                poolConfig.setMaxTotal(maxStorageConnection);
            }

            trackerServerPool = new GenericObjectPool<>(new TrackerServerFactory(), poolConfig);
        }
        return trackerServerPool;
    }

    /**
     * 获取 TrackerServer
     * @return TrackerServer
     * @throws FastDFSException
     */
    public static TrackerServer borrowObject() throws FastDFSException {
        TrackerServer trackerServer = null;
        try {
            trackerServer = getObjectPool().borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FastDFSException){
                throw (FastDFSException) e;
            }
        }
        return trackerServer;
    }

    /**
     * 回收 TrackerServer
     * @param trackerServer 需要回收的 TrackerServer
     */
    public static void returnObject(TrackerServer trackerServer){

        getObjectPool().returnObject(trackerServer);
    }


}
