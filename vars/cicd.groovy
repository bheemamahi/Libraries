def newGit(repo)
{
  git "https://github.com/intelliqittrainings/$(repo).git"
}
def newMaven()
{
  sh "mvn package"
}
def newDeploy(jobname,ipaddress,context)
{
  sh "scp /var/lib/jenkins/workspace/$(jobname)/webapp/target/webapp.war ubuntu@$(ipaddress):/var/lib/tomcat9/webapps/$(context).war"
}
def runSelenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/$(jobname)/testing.jar"
}

def newEmail(body,subject,mailid)
{
   mail bcc: '', body: "$(body)", cc: '', from: '', replyTo: '', subject: "$(subject)", to: "$(mailid)"
}
