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

releaseSettings