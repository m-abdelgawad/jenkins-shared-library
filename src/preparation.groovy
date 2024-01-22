def clean() {
  cleanWs()
}

def checkoutRepo() {
  checkout scm
}

def getCommitId() {
  return sh(returnStdout: true, script: "git rev-parse --short HEAD").trim()
}

def getCommitMsg() {
  return sh(returnStdout: true, script: 'git log -1 --pretty=format:"%s"').trim()
}
