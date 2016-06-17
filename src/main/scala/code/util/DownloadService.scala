package code.util

import net.liftweb.http.S.AFuncHolder
import net.liftweb.http.js.JsCmds
import net.liftweb.http._
import net.liftweb.http.rest.RestHelper

object DownloadService extends RestHelper {

  serve {
    case "response" :: responseName :: Nil Get request =>

      () => for {
        session <- S.session
        function <- session.findFunc(responseName)
        response <- serveResponse(function, responseName)
      } yield response

  }

  def pass(response: LiftResponse) = {
    val name = S.formFuncName
    S.addFunctionMap(name, () => response)
    val endpoint = s"${S.hostAndPath}/response/$name"
    JsCmds.RedirectTo(endpoint)
  }

  private def serveResponse(function: AFuncHolder, funcName: String): Option[LiftResponse] = {
    function.apply(List(funcName)) match {
      case (response: LiftResponse) :: Nil => Some(response)
      case _ => None
    }
  }

}