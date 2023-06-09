pipeline {
    agent any


    stages {
        stage("Clone the project") {
            steps {
                git branch: 'main', url: 'https://github.com/AnuhyaMuppavarapu/ForexUser.git'
            }
        }

        stage('Build') {
            steps {
                echo ' compile'
            }
        }

        stage('Test') {
            steps {
                echo ' test'
            }
        }

        stage('Package') {
            steps {
                echo ' package'
            }
        }
    }
}
