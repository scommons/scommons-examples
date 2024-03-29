package definitions

import com.typesafe.sbt.web.SbtWeb
import common.Libs
import sbt._
import scommons.sbtplugin.project.CommonClientModule
import scoverage.ScoverageKeys._
import webscalajs.ScalaJSWeb

object ExamplesPuzzle15 extends ExamplesModule with CommonClientModule {

  override val id = "scommons-examples-puzzle15"

  override val base: File = file("puzzle15")

  override def definition: Project = {
    super.definition
      .enablePlugins(ScalaJSWeb, SbtWeb)
      .settings(
        coverageExcludedPackages := coverageExcludedPackages.value +
          ";scommons.examples.puzzle15.Puzzle15Main"
      )
  }

  override def runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.runtimeDependencies.value ++ Seq(
      // specify your custom runtime dependencies here
    ) ++ {
      if (coverageEnabled.value) Seq(
        Libs.scalaJsJavaSecureRandom.value
      )
      else Nil
    }
  }
  
  override def testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.testDependencies.value ++ Seq[ModuleID](
      // specify your custom test dependencies here
    ).map(_ % "test")
  }
}
