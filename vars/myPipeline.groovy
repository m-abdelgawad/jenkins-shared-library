def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Preparation') {
                steps {
                    script {
                        MyFunctions.preparation(pipelineParams)
                    }
                }
            }

            stage('Testing') {
                steps {
                    script {
                    }
                }
            }

            stage('Building') {
                steps {
                    script {
                    }
                }
            }

            stage('Deploying') {
                steps {
                    script {
                    }
                }
            }
        }
    }
}
