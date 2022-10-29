package org.serratec.ecommerce.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean // 'Instanciar' o método
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.serratec.ecommerce.api"))
				.paths(PathSelectors.any()) // Quais são os paths que você quer fazer a documentação
				.build()
				.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("API REST IN PEACE")
				.description("API para um sistema de ecommerce desenvolvida por alunos da turma 08(02.2022) do Serratec. Projeto realizado para aprovação na matéria de API Restful.")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/license/LICENSE-2.0")
				.version("1.0.0")
				.contact(new Contact("Serratec", "www.serratec.org.br", "amelhorturma4ever@gmail.com"))
				.build();
		return apiInfo;
	}
}
