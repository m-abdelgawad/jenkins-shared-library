def call(Map pipelineParams) {
    pipeline {
        agent { 
            label 'kubeagent'
        }
        stages {
            stage('Preparation') {
                steps {
                    script {
                        // Load commom functions from /src/ directory
                        def preparation = new preparation()
                        preparation.clean()
                    }
                }
            }
        }
    }
}
