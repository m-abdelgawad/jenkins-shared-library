def clean() {
  cleanWs()
}

def checkoutRepo() {
  checkout scm
}

def getCommitId() {
  return sh(returnStdout: true, script: "git rev-parse --short HEAD").trim()
}
