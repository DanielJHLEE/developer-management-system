package com.dev.developer_management_system.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
                OpenAPI openAPI = new OpenAPI()
            .info(new Info()
                .title("🚀 개발자 인력 관리 Backend API")
                .description("""
                    <b>개발자 인력 관리 프로그램 백엔드 API 명세서</b><br>
                    <i>Spring Boot + JPA + Swagger(OpenAPI 3.0)</i><br>
                    <span style='color:#007ACC;'>모든 주요 기능(User_mst, Projects, Projects_history, skills) 엔드포인트 포함</span>
                    """)
                .version("v1.0.0")
            );
            
        return openAPI;
    }
}
