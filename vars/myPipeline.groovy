def call(Map pipelineParams) {
    pipeline {
        agent any
        stages {
            stage('Preparation') {
                steps {
                    script {
                        load 'src/MyFunctions.groovy'
                        preparation(pipelineParams)
                    }
                }
            }
        }
    }
}
