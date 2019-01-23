package definitions

import sbt._
import scommons.sbtplugin.project.CommonPlayModule
import webscalajs.WebScalaJS.autoImport._

object ExamplesServer extends ExamplesModule with CommonPlayModule {

  override val id: String = "scommons-examples-server"

  override val base: File = file("server")

  override def definition: Project = {
    super.definition
      .settings(
        scalaJSProjects := Seq(ExamplesPuzzle15.definition)
      )
  }

  override def runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.runtimeDependencies.value ++ Seq(
      // specify your custom runtime dependencies here
    )
  }

  override def testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.testDependencies.value ++ Seq[ModuleID](
      // specify your custom test dependencies here
    ).map(_ % "it,test")
  }
}
