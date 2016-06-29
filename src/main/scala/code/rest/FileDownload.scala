package code.rest

import net.liftweb.http._
import net.liftweb.http.rest.RestHelper

object FileDownload extends RestHelper {

  serve {
    case "download_request" :: Nil Get request =>

      () => for {
        session <- S.session
        functions <- session.runParams(request).headOption
        response <- serveResponse(functions)
      } yield response

  }

  private def serveResponse(functions: Any): Option[LiftResponse] = functions match {
    case (response: LiftResponse) :: Nil => Some(response)
    case _ => None
  }

}