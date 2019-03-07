package me.suttichai.develop.sticky

import me.suttichai.develop.sticky.model.Body
import me.suttichai.develop.sticky.model.Header

fun mock(): MutableList<Header> {
    val headers: MutableList<Header> = mutableListOf()

    var bodies: MutableList<Body>
    for (headerIndex in 1..4) {
        bodies = mutableListOf()
        for (bodyIndex in 1..8) {
            val body = Body("Body: $headerIndex/$bodyIndex")
            bodies.add(body)
        }
        val header = Header("Header: $headerIndex", "section$headerIndex", bodies)
        headers.add(header)
    }

    return headers
}

fun convertItemByHeaders(headers: MutableList<Header>): MutableList<Item<*>> {
    val items: MutableList<Item<*>> = mutableListOf()

    for (header in headers) {
        val itemHeader: Item<Header> = Item(header, HEADER_TYPE)
        items.add(itemHeader)
        for (body in header.bodies) {
            val itemBody: Item<Body> = Item(body, BODY_TYPE)
            items.add(itemBody)
        }
    }

    return items
}