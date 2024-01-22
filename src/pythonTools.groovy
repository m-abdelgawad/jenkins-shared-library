def installReq(reqPath) {
  script {
    sh """
      . venv/bin/activate
      echo "Installing requirements from: ${reqPath}"
      pip install -r ${reqPath}
    """
  }
}

def testDjango() {
  script {
    sh """
      . venv/bin/activate
      python manage.py test
    """
  }
}
