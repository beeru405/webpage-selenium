pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Your build steps (e.g., Maven build)
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Your test steps (e.g., running Selenium tests)
                    sh 'mvn test'
                }
            }
        }
    }
}
