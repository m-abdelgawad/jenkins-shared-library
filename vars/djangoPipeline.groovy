def call(Map pipelineParams) {

    // Load common functions from /src/ directory
    def wsTools = new wsTools()
    def gitTools = new gitTools()
    def aptTools = new aptTools()
    def pythonTools = new pythonTools()
    
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
                        aptTools.updatePackages()

                        // Install Python
                        aptTools.installPython()

                        // Install requirements packages
                        pythonTools.installReq("req.txt")
                        
                    } // end script
                } // end steps
            } // end stage Testing
            
        } // end stages
    } // end pipeline
} // end call function
