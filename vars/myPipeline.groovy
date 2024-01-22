def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Preparation') {
                steps {
                    script {
                        echo pipelineParams['name']
                    }
                }
            }
        }
    }
}
