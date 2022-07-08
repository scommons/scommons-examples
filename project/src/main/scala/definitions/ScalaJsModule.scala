package definitions

import sbt.Keys._
import sbt._
import scommons.sbtplugin.project.CommonClientModule

trait ScalaJsModule extends ExamplesModule with CommonClientModule {

  override def definition: Project = {
    super.definition
      .settings(
        scalaVersion := "2.13.5"
      )
  }
}
