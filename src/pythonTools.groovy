def installReq(reqPath) {
  script {
    sh """
      . venv/bin/activate
      python --version
      echo "Installing requirements from: ${reqPath}"
      pip install -r ${reqPath}
    """
  }
}
