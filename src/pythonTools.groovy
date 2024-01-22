def installReq(reqPath) {
  script {
    sh "pip install -r ${reqPath}"
  }
}
