def updateAptPackages() {
  script {
      sh '''
          apt update
          apt -y upgrade
      '''
  }
}
