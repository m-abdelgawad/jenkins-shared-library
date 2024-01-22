def updateDebian() {
  script {
      sh '''
          apt update
          apt -y upgrade
      '''
  }
}
