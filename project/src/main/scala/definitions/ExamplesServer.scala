package definitions

import com.typesafe.sbt.digest.Import.digest
import com.typesafe.sbt.gzip.Import.gzip
import com.typesafe.sbt.web.SbtWeb.autoImport._
import common.{Libs, TestLibs}
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import play.sbt.routes.RoutesKeys
import play.sbt.{PlayImport, PlayLayoutPlugin, PlayScala}
import sbt._
import scommons.sbtplugin.WebpackAssetsPlugin.autoImport._
import scoverage.ScoverageKeys.coverageExcludedPackages
import webscalajs.WebScalaJS.autoImport._

import scalajsbundler.sbtplugin.WebScalaJSBundlerPlugin

object ExamplesServer extends BasicModule {

  override val id: String = "scommons-examples-server"

  override def base: File = file(id)

  override def definition: Project = {
    super.definition
      .enablePlugins(PlayScala, WebScalaJSBundlerPlugin)
      .disablePlugins(PlayLayoutPlugin)
      .configs(IntegrationTest)
      .settings(Defaults.itSettings: _*)
      .settings(
        RoutesKeys.routesImport -= "controllers.Assets.Asset", //remove unused import warning from routes file
        coverageExcludedPackages := "<empty>;Reverse.*;router.*",

        scalaJSProjects := Seq(ExamplesPuzzle15.definition),
        pipelineStages in Assets := Seq(scalaJSPipeline),
        pipelineStages := Seq(digest, gzip),

        // Expose as sbt-web assets some webpack build files of the `client` project
        webpackAssets in fastOptJS ++= WebpackAssets.ofProject(fastOptJS, ExamplesPuzzle15.definition) { build => (build / "styles").*** }.value,
        webpackAssets in fullOptJS ++= WebpackAssets.ofProject(fullOptJS, ExamplesPuzzle15.definition) { build => (build / "styles").*** }.value
      )
  }

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-service", "scommons-service-play", None)
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsServicePlay.value,
    Libs.scommonsClientAssets.value,

    PlayImport.guice,
    Libs.play.value,
    Libs.scaldiPlay.value,
    Libs.slf4jApi.value,
    Libs.logback.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    TestLibs.scalaTestPlusPlay.value,
    TestLibs.akkaStreamTestKit.value,
    TestLibs.mockito.value
  ).map(_ % "it,test"))
}
