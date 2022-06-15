package com.pfzam

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.pfzam.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureRouting()
    configureSerialization()
}