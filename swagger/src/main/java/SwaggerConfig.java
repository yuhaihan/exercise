import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Configurable;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-07-09 14:35
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 14:35 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Configurable
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 加上了@ApiOperation直接的类才会生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 此路径下的类才会生成接口文档 TODO 需要修改
                .apis(RequestHandlerSelectors.basePackage("com.yu.hai.han.exercise"))
                .build();
    }
}
