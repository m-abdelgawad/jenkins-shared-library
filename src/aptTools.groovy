def updatePackages() {
  script {
    sh '''
      apt update
      apt -y upgrade
    '''
  }
}

def installPython() {
  script {
    sh '''
      apt install -y python3 python3-pip build-essential libssl-dev libffi-dev python3-dev python3-venv
      python3 -m venv venv
      . venv/bin/activate
      python --version
    '''
  }
}
