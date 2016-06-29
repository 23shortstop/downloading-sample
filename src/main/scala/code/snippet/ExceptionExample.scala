package code.snippet

import code.lib.Respondent
import net.liftweb.http._
import net.liftweb.util.Helpers._
import scala.xml.Text

object ExceptionExample extends Respondent {

  def download = {
    var text = ""

    "data-name=text" #> SHtml.ajaxText(text, s => text = s) &
      "data-name=download" #> SHtml.link("",
      () => throw new ResponseShortcutException(makeResponse(text)), Text("link"))
  }

}