addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.12.0")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8.5")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")