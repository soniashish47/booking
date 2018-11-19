name := """play-java"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.11"

lazy val commonSettings = Seq(
  autoScalaLibrary := false,
  javaSource in Compile := baseDirectory.value / "src" / "main" / "java",
  ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    // testing
    "junit"             % "junit"           % "4.12"  % Test,
    "com.novocode"      % "junit-interface" % "0.11"  % Test,
    //"org.mockito" % "mockito-core" % "2.10.0",
    // jdbc
    javaJdbc,
    "redis.clients" % "jedis" % "2.8.1",
    "mysql" % "mysql-connector-java" % "5.1.36",
    "net.logstash.logback" % "logstash-logback-encoder" % "4.5.1",
    "com.google.gcm" % "gcm-server" % "1.0.0",
    "com.notnoop.apns" % "apns" % "0.1.6",
    "com.google.code.gson" % "gson" % "2.7",
    "org.springframework" % "spring-expression" % "4.3.0.RELEASE",
    "org.springframework" % "spring-context" % "4.3.0.RELEASE",
    "org.apache.httpcomponents" % "httpclient" % "4.5.2",
    "org.apache.httpcomponents" % "httpmime" % "4.3.1",
    javaWs,
    ws,
    filters,
    "org.mindrot" % "jbcrypt" % "0.3m",
    "org.apache.pdfbox" % "pdfbox" % "2.0.1",
    "com.google.guava" % "guava" % "19.0",
    "org.mockito" % "mockito-core" % "2.10.0" % "test",
    "io.swagger" %% "swagger-play2" % "1.5.3",
    "org.webjars" %% "webjars-play" % "2.5.0-4",
    "org.webjars" % "swagger-ui" % "2.2.0",
    "org.bouncycastle" % "bcprov-jdk15on" % "1.57",
    "nl.martijndwars" % "web-push" % "3.0.1",
    "io.ebean" % "ebean" % "11.22.6"
  )
)

playEbeanModels in Compile := Seq("models.*")

lazy val root = (project in file("."))
  .enablePlugins (PlayEbean, PlayJava)
  .settings(commonSettings: _*)


routesGenerator := InjectedRoutesGenerator