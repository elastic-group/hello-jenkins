pipeline {
    agent any
    stages {
        stage('UnitTest') {
            steps {
                sh 'mvn clean test -Dtest=DeepLearningUnitTest'
            }
        }
        stage('TrainingTest') {
            steps {
                sh 'mvn clean test -Dtest=DeepLearningTrainingTest'
            }
        }
        stage('PredictTest') {
            steps {
                sh 'mvn clean test -Dtest=DeepLearningPredictTest'
            }
        }
    }
}
