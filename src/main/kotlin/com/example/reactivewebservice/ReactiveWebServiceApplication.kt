package com.example.reactivewebservice

import com.example.reactivewebservice.hello.GreetingClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveWebServiceApplication

fun main(args: Array<String>) {
    val context = runApplication<ReactiveWebServiceApplication>(*args)
    val greetingClient = context.getBean(GreetingClient::class.java)
    println(">> message=${greetingClient.getMessage().block()}")
}
