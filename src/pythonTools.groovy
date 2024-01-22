def installReq(reqPath) {
  script {
    sh '''
      . venv/bin/activate
      python --version
      pip install -r ${reqPath}
      
    '''
  }
}
