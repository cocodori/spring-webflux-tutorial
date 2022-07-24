package com.example.reactivewebservice.hello

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GreetingClient {

    // Spring Boot 는 `WebClient.Builder`인스턴스를 자동 구성한다.
    // 이를 사용하여 구성 요소에 대한 전용 `WebClient`를 만들 수 있다.
    private val webClient = WebClient.builder()
        .baseUrl("http://localhost:8080")
        .build()

    fun getMessage(): Mono<String> =
        this.webClient
            .get()
            .uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Greeting::class.java)
            .map { it.message }

}