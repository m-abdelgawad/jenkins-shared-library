def call(Map pipelineParams) {
    pipeline {
        agent any
        stages {
            stage('Preparation') {
                steps {
                    script {
                        def myUtils = new org.demo.buildUtils()
                        myUtils.checkOutFrom(repo)
                    }
                }
            }
        }
    }
}
