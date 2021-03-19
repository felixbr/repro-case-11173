Global / onChangedBuildSource := ReloadOnSourceChanges
ThisBuild / turbo := true

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        scalaVersion := "3.0.0-RC1"
      )
    ),
    name := "issue-11173-repro-case",
    version := "0.1.0",
    libraryDependencies ++= (
      List(
        ("co.fs2" %% "fs2-core" % "3.0.0-M9").withDottyCompat(scalaVersion.value)
      )
    )
  )

// format: off
scalacOptions ++= List( // useful compiler flags for scala
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
)
// format: on

addCommandAlias("scalafmtFormatAll", "; root/scalafmtAll ; root/scalafmtSbt")
addCommandAlias("scalafmtValidateAll", "; root/scalafmtCheckAll ; root/scalafmtSbtCheck")
