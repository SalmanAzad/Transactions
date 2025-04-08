package com.bank.transactions.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiConfig {
  @Bean
  fun apiInfo(): OpenAPI =
    OpenAPI()
      .info(
        Info()
          .title("Transaction Service API")
          .description("API for creation and retrieval of transactions")
          .version("1.0.0")
      )
}
