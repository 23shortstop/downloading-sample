package code.lib

import net.liftweb.http.S._
import net.liftweb.http.js.JsCmds
import net.liftweb.http.{LiftResponse, S}

trait FileDownloader {

  def downloadInvoke(response: () => LiftResponse) = {
    fmapFunc(NFuncHolder(response))(makeDownloadCall)
  }

  private def makeDownloadCall(funcName: String) = {
    JsCmds.RedirectTo(s"${S.hostAndPath}/download_request?$funcName=_")
  }

}
