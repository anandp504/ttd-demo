package com.anand

import com.twitter.finagle.Service
import org.apache.log4j.LogManager
import com.twitter.finagle.http._
import com.twitter.finagle.http.path.{/, /:, Path, Root}
import com.twitter.util.Future
import scala.language.postfixOps


class ApiResponse extends Service[Request, Response] {

  private val log = LogManager.getLogger(this.getClass)

  def apply(request: Request): Future[Response] = {

    request.method match {
      case Method.Get => {
        Path(request.path) match {
          case Root / "org" / "search" / channel => Future.value {
            println("channel = " + channel)
            val response = Response(Version.Http11, Status.Ok)
            response.contentString = HttpResponse.responseWithLocation
            response.setContentTypeJson()
            response
          }
          case _ =>
            println("Path not found")
            Future value Response(Version.Http11, Status.NotFound)
        }
      }
      case _ => Future value Response(Version.Http11, Status.NotFound)
    }
  }
}


