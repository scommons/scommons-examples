package common

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

object Libs {

  val scommonsServiceVersion = "0.1.0-SNAPSHOT"
  val scommonsClientVersion = "0.1.0-SNAPSHOT"

  val akkaVersion = "2.5.6"
  private val playVer = "2.6.7"

  //////////////////////////////////////////////////////////////////////////////
  // jvm dependencies

  lazy val scommonsServicePlay = Def.setting("org.scommons.service" %% "scommons-service-play" % scommonsServiceVersion)
  lazy val scommonsClientAssets = Def.setting("org.scommons.client" %% "scommons-client-assets" % scommonsClientVersion)

  lazy val play = Def.setting("com.typesafe.play" %% "play" % playVer)
  lazy val scaldiPlay = Def.setting("org.scaldi" %% "scaldi-play" % "0.5.17")

  lazy val logback = Def.setting("ch.qos.logback" % "logback-classic" % "1.1.7")
  lazy val slf4jApi = Def.setting("org.slf4j" % "slf4j-api" % "1.7.12")
  lazy val log4jToSlf4j = Def.setting("org.apache.logging.log4j" % "log4j-to-slf4j" % "2.2")
  lazy val jclOverSlf4j = Def.setting("org.slf4j" % "jcl-over-slf4j" % "1.7.12")

  //////////////////////////////////////////////////////////////////////////////
  // js dependencies

  lazy val scommonsClientUi = Def.setting("org.scommons.client" %%% "scommons-client-ui" % scommonsClientVersion)
}
