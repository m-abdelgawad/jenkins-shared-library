def call(Map pipelineParams) {
    pipeline {
        agent any
        stages {
            stage('Preparation') {
                steps {
                    script {
                        def myUtils = new buildUtils()
                        myUtils.checkOutFrom(pipelineParams)
                    }
                }
            }
        }
    }
}
