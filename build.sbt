import definitions._
import scommons.sbtplugin.project.CommonModule

lazy val `scommons-examples` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(ExamplesModule.settings: _*)
  .settings(
    ideaExcludeFolders += s"${baseDirectory.value}/docs/_site"
  )
  .aggregate(
    `scommons-examples-puzzle15`,
    `scommons-examples-server`
)

lazy val `scommons-examples-puzzle15` = ExamplesPuzzle15.definition
lazy val `scommons-examples-server` = ExamplesServer.definition
