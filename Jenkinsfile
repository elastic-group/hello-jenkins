pipeline {
    agent any
    stages {
        stage('UnitTest') {
            when { not { branch "master" } }
            steps {
                sh 'mvn clean test -Dtest=DeepLearningUnitTest'
            }
        }
        stage('TrainingTest') {
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
