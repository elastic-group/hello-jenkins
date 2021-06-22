pipeline {
    agent any
    parameters {
        choice(name: "AlwaysUse", choices: "global_common.properties", description: "Global common properties")
        choice(name: "TestAction", choices: ["STOP_IF_FAILED", "SKIP_TESTS", "IGNORE_FAILURES"], description: "Action to perform for tests")
        string(name: "MaxPollTimes", defaultValue: "3", description: "Max number of times to retry")
    }

    stages {
        stage('UnitTest non-master branches') {
            when { not { branch "main" } }
            steps {
                sh 'mvn clean test -Dtest=DeepLearningUnitTest'
            }
        }
        stage('E2E tests for master or dryrun branches') {
            when {
                anyOf {
                    expression { env.BRANCH_NAME.contains("main") }
                    expression { env.BRANCH_NAME.contains("dryrun") }
                }
            }
            steps {
                sh 'mvn clean test -Dtest=DeepLearningTrainingTest,DeepLearningPredictTest'
            }
        }
    }
}
