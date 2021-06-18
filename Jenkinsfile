pipeline {
    agent any
    stages {
        stage('UnitTest non-master branches') {
            when { not { branch "master" } }
            steps {
                sh 'mvn clean test -Dtest=DeepLearningUnitTest'
            }
        }
        stage('E2E tests for master or dryrun branches') {
            when {
                anyOf {
                    expression { env.BRANCH_NAME.contains("master") }
                    expression { env.BRANCH_NAME.contains("dryrun") }
                }
            }
            steps {
                sh 'mvn clean test -Dtest=DeepLearningTrainingTest,DeepLearningPredictTest'
            }
        }
    }
}
