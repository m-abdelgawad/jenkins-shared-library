// src/MyFunctions.groovy

class MyFunctions {
    static def preparation(Map params) {
        echo "Hello from preparation! Accessing pipelineParams: ${params}"
        // Add your preparation steps here
    }

    static def testing(Map params) {
        echo "Hello from testing! Accessing pipelineParams: ${params}"
        // Add your testing steps here
    }

    static def building(Map params) {
        echo "Hello from building! Accessing pipelineParams: ${params}"
        // Add your building steps here
    }

    static def deploying(Map params) {
        echo "Hello from deploying! Accessing pipelineParams: ${params}"
        // Add your deploying steps here
    }
}
