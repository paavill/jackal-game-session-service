package ru.rsreu.jackal.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
data class EnterpriseServiceConfiguration(
    @Value("\${enterprise.base_url}")
    val baseUrl: String,

    @Value("\${enterprise.not_started_url}")
    val notStartedApiUrl: String
)