def call(Map pipelineParams) {
    pipeline {
        agent any
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
