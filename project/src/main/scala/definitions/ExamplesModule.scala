package definitions

import common.Libs
import org.scoverage.coveralls.Imports.CoverallsKeys._
import sbt.Keys._
import sbt._
import scommons.sbtplugin.project.CommonModule

trait ExamplesModule extends CommonModule {

  override val repoName = "scommons-examples"

  val scommonsServiceVersion: String = Libs.scommonsServiceVersion
  val scommonsNodejsVersion: String = Libs.scommonsNodejsVersion
  val scommonsReactVersion: String = Libs.scommonsReactVersion
  val scommonsClientVersion: String = Libs.scommonsClientVersion
  val scommonsApiVersion: String = Libs.scommonsApiVersion
  
  override def definition: Project = {
    super.definition
      .settings(ExamplesModule.settings: _*)
  }
}

object ExamplesModule {

  val settings: Seq[Setting[_]] = Seq(
    organization := "org.scommons.examples",

    coverallsService := GitHubActionsCI.jobId.map(_ => GitHubActionsCI)
  )
}
