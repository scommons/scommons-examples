package controllers

import javax.inject.Inject

import play.api.mvc._
import scommons.play.controllers.BasePageController

class Puzzle15Controller @Inject()(components: ControllerComponents, finder: AssetsFinder)
  extends BasePageController(components, finder, "/scommons-examples", "scommons-examples-puzzle15")
