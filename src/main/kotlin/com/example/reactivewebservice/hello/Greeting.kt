package com.example.reactivewebservice.hello

class Greeting(
    val message: String
) {
    override fun toString(): String {
        return "Greeting(message='$message')"
    }
}