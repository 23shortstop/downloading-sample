package code.snippet

import code.util.DownloadService
import net.liftweb.http._
import net.liftweb.util.Helpers._

import scala.xml.Text

object DownloadExample {

  def exceptionDownload = {
    "data-name=download" #> SHtml.link("",
      () => throw new ResponseShortcutException(response), Text("link"))
  }

  def restDownload = {
    "data-name=download [onclick]" #>
      SHtml.ajaxInvoke(() => DownloadService.pass(response))
  }

  def response = {
    val text = "Hello, World!"

    InMemoryResponse(
      data = text.getBytes("UTF-8"),
      headers =
        "Content-Type" -> "text/plain; charset=utf-8" ::
          "Content-Disposition" ->
            "attachment; filename=\"text.txt\"" ::
          Nil,
      cookies = Nil,
      code = 200
    )
  }
}