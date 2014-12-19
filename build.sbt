import sbtrelease.Version

name := "sbt-release-playground"
organization  := "com.vlach"
scalaVersion  := "2.11.4"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := Some("Artifactory Realm" at "http://artifactory.funkypandagame.com:8081/artifactory/funkypanda")
publishMavenStyle := true

artifact in (Compile, assembly) := {
  val art = (artifact in (Compile, assembly)).value
  art.copy(`classifier` = Some("assembly"))
}

addArtifact(artifact in (Compile, assembly), assembly)

// disable publishing the main jar produced by `package`
publishArtifact in (Compile, packageBin) := false

// disable publishing the main API jar
publishArtifact in (Compile, packageDoc) := false

// disable publishing the main sources jar
publishArtifact in (Compile, packageSrc) := false

releaseSettings

ReleaseKeys.nextVersion := { ver => Version(ver).map(_.bumpBugfix.string).getOrElse(sbtrelease.versionFormatError) }

ReleaseKeys.commitMessage <<= (version in ThisBuild) map (v => "v%s" format v)