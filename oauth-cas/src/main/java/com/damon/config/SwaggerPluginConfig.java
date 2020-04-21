package com.damon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangshoufa
 * @date 2018年10月9日 下午2:06:55
 *
 */

@Configuration
@EnableSwagger2
@Profile({ "dev" })

public class SwaggerPluginConfig {

	@Autowired
	private Environment env;

	@Bean
	public Docket createRestApi() {
		/*ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("token").description("user token").modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build();
		pars.add(tokenPar.build());

		ParameterBuilder bitaTokenPar = new ParameterBuilder();
		bitaTokenPar.name("bitaToken").description("user bitaToken").modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();
		pars.add(bitaTokenPar.build());*/

		ApiInfo apiInfo = new ApiInfoBuilder().title(env.getProperty("spring.application.name") + " API")
				.contact(env.getProperty("spring.application.name")).version("1.0.RELEASE").build();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
				.apis(RequestHandlerSelectors.basePackage("com.damon")).paths(PathSelectors.any()).build();
	}
}
