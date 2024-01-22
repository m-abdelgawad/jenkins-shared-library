def call(Map pipelineParams) {

    // Load commom functions from /src/ directory
    def wsTools = new wsTools()
    def gitTools = new gitTools()
    def osTools = new osTools()
    
    pipeline {
        agent { 
            label 'kubeagent'
        }
        stages {
            
            stage('Preparation') {
                steps {
                    script {
                        
                        // Clean workspace
                        wsTools.clean()

                        // Pull the latest git version
                        gitTools.checkoutRepo()

                        // Get commit ID
                        commitId = gitTools.getCommitId()
                        echo "Commit ID is \'${commitId}\'"

                        // Get commit meassage
                        commitMsg = gitTools.getCommitMsg()
                        echo "Commit message is \'${commitMsg}\'"

                        // Set new image name
                        newImage = pipelineParams['dockerhubRepo'] + ":" + commitId
                        echo "New image tag will be \'${newImage}\'"
                    } // end script
                } // end steps
            } // end stage Preparation

            stage('Testing') {
                steps {
                    script {
                        // update image os
                        osTools.updateAptPackages()
                    } // end script
                } // end steps
            } // end stage Testing
            
        } // end stages
    } // end pipeline
} // end call function
