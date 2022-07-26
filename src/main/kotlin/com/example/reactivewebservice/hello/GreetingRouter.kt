package com.example.reactivewebservice.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration(proxyBeanMethods = false)
class GreetingRouter {

    @Bean
    fun route(
        greetingHandler: GreetingHandler
    ): RouterFunction<ServerResponse> =
        RouterFunctions.route(
            GET("/hello")
                .and(accept(APPLICATION_JSON)), greetingHandler::hello
        )
}