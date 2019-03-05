package me.suttichai.develop.sticky

import me.suttichai.develop.sticky.model.Body
import me.suttichai.develop.sticky.model.Header

fun mock(): MutableList<Header> {
    val headers: MutableList<Header> = mutableListOf()

    var bodies: MutableList<Body>
    for (headerIndex in 1..3) {
        bodies = mutableListOf()
        for (bodyIndex in 1..4) {
            val body = Body("Body: $headerIndex/$bodyIndex")
            bodies.add(body)
        }
        val header = Header("Header: $headerIndex", bodies)
        headers.add(header)
    }

    return headers
}