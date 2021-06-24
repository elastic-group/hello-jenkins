pipeline {
    agent any
    stages {
        stage('UnitTest non-master branches') {
            when { not { branch "main" } }
            steps {
                sh 'mvn clean test -Dtest=DeepLearningUnitTest'
            }
        }
        stage('E2E tests for master or dryrun branches') {
            when {
                expression { env.BRANCH_NAME.contains("main") }
            }
            steps {
                sh 'echo "Executing a failing test"'
                sh 'mvn clean test -Dtest=FailingTest'
                sh 'echo "Status was a non zero value"'
            }
        }
    }
}
