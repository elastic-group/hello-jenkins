pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
    }
}
