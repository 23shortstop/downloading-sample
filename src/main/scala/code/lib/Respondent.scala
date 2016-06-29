package code.lib

import net.liftweb.http.InMemoryResponse

trait Respondent {

  def makeResponse(text: String,
                   fileName: String = "text.txt"): InMemoryResponse = {
    InMemoryResponse(
      data = text.getBytes("UTF-8"),
      headers = "Content-Type" -> "text/plain; charset=utf-8" ::
          "Content-Disposition" -> s"attachment; filename=$fileName" ::
          Nil,
      cookies = Nil,
      code = 200
    )
  }

}
