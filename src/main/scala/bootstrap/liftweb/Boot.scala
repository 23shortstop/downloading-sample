package bootstrap.liftweb

import net.liftweb._
import code.util.DownloadService
import http._
import sitemap._
import net.liftmodules.{FoBo, JQueryModule}
import net.liftweb.http.js.jquery._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("code")

    LiftRules.dispatch.append(DownloadService)

    // Build SiteMap
    val entries = List(
      Menu.i("Home") / "index",
      Menu.i("Exception Download") / "download" / "exception",
      Menu.i("REST Download") / "download" / "rest")

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMap(SiteMap(entries:_*))

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    //Init the jQuery module, see http://liftweb.net/jquery for more information.
    LiftRules.jsArtifacts = JQueryArtifacts
    JQueryModule.InitParam.JQuery=JQueryModule.JQuery191
    JQueryModule.init()

    FoBo.InitParam.JQuery = FoBo.JQuery1111
    FoBo.init()

  }
}