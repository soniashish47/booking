name := """play-java"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.11"

lazy val commonSettings = Seq(
  autoScalaLibrary := false,
  javaSource in Compile := baseDirectory.value / "src" / "main" / "java",

  libraryDependencies ++= Seq(
    "junit"             % "junit"           % "4.12"  % Test,
    javaJdbc,
    "mysql" % "mysql-connector-java" % "5.1.36",
    "net.logstash.logback" % "logstash-logback-encoder" % "4.5.1",
    javaWs,
    ws,
    filters
  )
)

playEbeanModels in Compile := Seq("models.*")

lazy val root = (project in file("."))
  .enablePlugins (PlayEbean, PlayJava)
  .settings(commonSettings: _*)
