package com.anand

import java.net.InetSocketAddress
import com.twitter.finagle.Http
import com.twitter.finagle.builder.{Server, ServerBuilder }

class ApiServer {
  val response = new ApiResponse
  val address = new InetSocketAddress(9000)
  def start: Server = ServerBuilder()
    .stack(Http.server)
    .bindTo(address)
    .name("HttpServer")
    .build(response)
}
