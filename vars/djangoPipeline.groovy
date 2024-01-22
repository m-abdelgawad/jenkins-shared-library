def call(Map pipelineParams) {
    pipeline {
        agent { 
            label 'kubeagent' 
        }
        stages {
            stage('Preparation') {
                steps {
                    script {
                        def preparation = new preparation()
                        preparation.clean()
                    }
                }
            }
        }
    }
}
