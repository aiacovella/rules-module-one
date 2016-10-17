name := "rules-module-one"

scalaVersion in ThisBuild := "2.11.8"

version in ThisBuild := "1.0-SNAPSHOT"

organization in ThisBuild := "com.foo"

scalacOptions in ThisBuild   := List(
  "-encoding",
  "UTF8",
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xlint",
  "-language:postfixOps",
  "-language:higherKinds")

libraryDependencies ++= Seq(
  "com.foo"         % "rules-spi_2.11"    % Versions.RulesSpi
)

fork in run := true