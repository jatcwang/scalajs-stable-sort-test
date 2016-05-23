import sbt.Keys._

enablePlugins(ScalaJSPlugin)

name := "TravelPlan2"

version := "1.0"

scalaVersion := "2.11.8"

lazy val root = project.in(file(".")).aggregate(mmJs, mmJvm)

lazy val mastermind = crossProject.in(file(".")).settings(
  scalaVersion := "2.11.8",
  scalacOptions += "-target:jvm-1.8",

  libraryDependencies ++= Seq(
    "org.scalacheck" %%% "scalacheck" % "1.12.5" % "test",
    "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test"
  )
)

lazy val mmJvm = mastermind.jvm
lazy val mmJs = mastermind.js

