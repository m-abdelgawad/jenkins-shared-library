def call(Map varsMap) {

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
            
            // stage('Preparation') {
            //     steps {
            //         script {
                        
            //             // Clean workspace
            //             wsTools.clean()

            //             // Pull the latest git version
            //             gitTools.checkoutRepo()

            //             // Get commit ID
            //             commitId = gitTools.getCommitId()
            //             echo "Commit ID is \'${commitId}\'"

            //             // Get commit meassage
            //             commitMsg = gitTools.getCommitMsg()
            //             echo "Commit message is \'${commitMsg}\'"

            //             // Set new image name
            //             newImage = varsMap['dockerhubRepo'] + ":" + commitId
            //             echo "New image tag will be \'${newImage}\'"
                        
            //         } // end script
            //     } // end steps
            // } // end stage Preparation

            // stage('Testing') {
            //     steps {
            //         script {
            //             // update image os
            //             aptTools.updatePackages()

            //             // Install Python
            //             aptTools.installPython()

            //             // Install requirements packages
            //             pythonTools.installReq(varsMap['reqPath'])

            //             // Test the app
            //             pythonTools.testDjango()
                        
            //         } // end script
            //     } // end steps
            // } // end stage Testing

            stage('Build') {
                steps {
                    script {
                        sh """
                            apt install ca-certificates curl gnupg
                            install -m 0755 -d /etc/apt/keyrings
                            curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg
                            chmod a+r /etc/apt/keyrings/docker.gpg
                            echo \
                              "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/debian \
                              "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
                              tee /etc/apt/sources.list.d/docker.list > /dev/null
                            apt update
                            apt install -y docker-ce-cli docker-compose-plugin
                        """
                    } // end script
                } // end steps
            } // end stage Testing
            
        } // end stages
    } // end pipeline
} // end call function
