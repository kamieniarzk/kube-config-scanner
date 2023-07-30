package com.example;

import java.io.IOException;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.Config;

@org.springframework.context.annotation.Configuration
class KubernetesApiClientConfiguration {
  
  @Bean
  @ConditionalOnProperty(value = "environment.in-cluster", havingValue = "true")
  ApiClient inClusterApiClient() throws IOException {
    var client = ClientBuilder.cluster().build();
    io.kubernetes.client.openapi.Configuration.setDefaultApiClient(client);
    return client;
  }

  @Bean
  @ConditionalOnProperty(value = "environment.in-cluster", havingValue = "false")
  ApiClient kubeConfigApiClient() throws IOException {
    return Config.defaultClient();
  }
}
