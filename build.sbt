name := "scala-puzzles"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.1.3"
libraryDependencies += "com.softwaremill.diffx" %% "diffx-core" % "0.4.1"
libraryDependencies += "com.beachape" %% "enumeratum" % "1.6.1"
// libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
/*
val circeVersion = "0.12.3"
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)*/
