import common.Common
import definitions._

lazy val `scommons-examples` = (project in file("."))
  .settings(Common.settings)
  .settings(
    ideaExcludeFolders += s"${baseDirectory.value}/docs/_site"
  )
  .aggregate(
    `scommons-examples-puzzle15`,
    `scommons-examples-server`
)

lazy val `scommons-examples-puzzle15` = ExamplesPuzzle15.definition
lazy val `scommons-examples-server` = ExamplesServer.definition
