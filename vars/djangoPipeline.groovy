def call(Map pipelineParams) {
    pipeline {
        agent { 
            label 'kubeagent'
        }
        stages {
            stage('Preparation') {
                steps {
                    script {
                        // Load commom functions from /src/ directory
                        def preparation = new preparation()

                        // Clean workspace
                        preparation.clean()

                        // Pull the latest git version
                        preparation.checkoutRepo()

                        // Get commit ID
                        commitId = preparation.getCommitId()
                        echo "Commit ID is <<${commitId}>>"

                        // Get commit meassage
                        commitMsg = preparation.getCommitMsg()
                        echo "Commit message is ${"}${commitMsg}${"}"
                    }
                }
            }
        }
    }
}
