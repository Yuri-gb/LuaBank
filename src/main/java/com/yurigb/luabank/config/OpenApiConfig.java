package com.yurigb.luabank.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

        private static final String SECURITY_SCHEME_NAME = "bearerAuth";
        @Value("${URL_API}")
        private String URL_API;

        @Bean
        public OpenAPI customOpenAPI() {

                return new OpenAPI()

                                .info(new Info()
                                                .title("🌙 LuaBank API")
                                                .version("2.0.0")
                                                .description("""
                                                                API REST bancária desenvolvida com Spring Boot.

                                                                Funcionalidades:
                                                                • Cadastro de contas
                                                                • Autenticação JWT
                                                                • Consulta de perfil
                                                                • Consulta de saldo
                                                                • Transferências Pix
                                                                • Gerenciamento de chaves Pix
                                                                • Extrato paginado

                                                                Tecnologias:
                                                                • Java 21
                                                                • Spring Boot
                                                                • Spring Security
                                                                • JWT
                                                                • PostgreSQL
                                                                • Docker
                                                                • Swagger/OpenAPI
                                                                """)
                                                .contact(new Contact()
                                                                .name("Yuri Gabriel")
                                                                .url("https://github.com/Yuri-gb")
                                                                .email("yurichagas08@gmail.com"))
                                                .license(new License()
                                                                .name("MIT License")))

                                .addServersItem(new Server()
                                                .url(URL_API)
                                                .description("Ambiente de Produção"))

                                .addSecurityItem(
                                                new SecurityRequirement()
                                                                .addList(SECURITY_SCHEME_NAME))

                                .components(
                                                new Components()
                                                                .addSecuritySchemes(
                                                                                SECURITY_SCHEME_NAME,
                                                                                new SecurityScheme()
                                                                                                .name(SECURITY_SCHEME_NAME)
                                                                                                .type(SecurityScheme.Type.HTTP)
                                                                                                .scheme("bearer")
                                                                                                .bearerFormat("JWT")
                                                                                                .description("""
                                                                                                                Informe apenas o token JWT.

                                                                                                                Exemplo:

                                                                                                                eyJhbGciOiJIUzI1NiJ9...
                                                                                                                """)));
        }
}