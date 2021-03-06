package definitions

import sbt._
import scommons.sbtplugin.project.CommonClientModule

object ExamplesPuzzle15 extends ExamplesModule with CommonClientModule {

  override val id = "scommons-examples-puzzle15"

  override val base: File = file("puzzle15")

  override def runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.runtimeDependencies.value ++ Seq(
      // specify your custom runtime dependencies here
    )
  }
  
  override def testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.testDependencies.value ++ Seq[ModuleID](
      // specify your custom test dependencies here
    ).map(_ % "test")
  }
}
