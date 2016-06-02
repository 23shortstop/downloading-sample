package code.util

import net.liftweb.http.js.JsCmds
import net.liftweb.http._
import net.liftweb.http.rest.RestHelper

object ResponseService extends RestHelper {

  serve {
    case "shortcut" :: Nil Get request =>

      () => for {
        session <- S.session
        function <- session.runParams(request).headOption
        response <- function.asInstanceOf[List[LiftResponse]].headOption
      } yield response

  }

  def shortcut(response: LiftResponse) = {
    val name = S.formFuncName
    S.addFunctionMap(name, () => response)
    val endpoint = s"${S.hostAndPath}/shortcut?$name=_"
    JsCmds.RedirectTo(endpoint)
  }

}