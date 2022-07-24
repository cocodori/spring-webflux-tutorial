package com.example.reactivewebservice.hello

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class GreetingHandler {
    fun hello(request: ServerRequest): Mono<ServerResponse> {
        val greeting = Greeting("Hello Spring!")
        val contentTypeApplicationJson = MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE)

        return ServerResponse.ok()
            .contentType(contentTypeApplicationJson)
            .body(BodyInserters.fromValue(greeting))
    }
}