package code.util

import net.liftweb.http.js.JsCmds
import net.liftweb.http._
import net.liftweb.http.rest.RestHelper

object ResponseService extends RestHelper {

  serve {
    case "shortcut" :: Nil Get request =>

      () => for {
        session <- S.session
        functions <- session.runParams(request).headOption
        response <- serveResponse(functions)
      } yield response

  }

  def shortcut(response: LiftResponse) = {
    val name = S.formFuncName
    S.addFunctionMap(name, () => response)
    val endpoint = s"${S.hostAndPath}/shortcut?$name=_"
    JsCmds.RedirectTo(endpoint)
  }

  private def serveResponse(functions: Any): Option[LiftResponse] = functions match {
    case (response: LiftResponse) :: Nil => Some(response)
    case _ => None
  }

}