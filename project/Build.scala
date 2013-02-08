import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "computer-database-jpa"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      javaCore,
      javaJdbc,
      javaJpa,
      "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
	  "postgresql" % "postgresql" % "9.1-901.jdbc4"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      ebeanEnabled := false   
    )

}
            
