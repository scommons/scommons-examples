import definitions._
import scommons.sbtplugin.project.CommonModule
import scommons.sbtplugin.project.CommonModule.ideExcludedDirectories

lazy val `scommons-examples` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(ExamplesModule.settings: _*)
  .settings(
    ideExcludedDirectories += baseDirectory.value / "docs" / "_site"
  )
  .aggregate(
    `scommons-examples-puzzle15`,
    `scommons-examples-server`
)

lazy val `scommons-examples-puzzle15` = ExamplesPuzzle15.definition
lazy val `scommons-examples-server` = ExamplesServer.definition
