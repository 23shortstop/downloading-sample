package code.snippet

import code.lib.{Respondent, FileDownloader}
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers._

object RestExample extends Respondent with FileDownloader {

  def download = {
    var text = ""

    "data-name=text" #> SHtml.ajaxText(text, s => text = s) &
      "data-name=download [onclick]" #> downloadInvoke(() => makeResponse(text))
  }

}
