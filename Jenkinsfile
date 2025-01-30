pipeline {
    agent any  // Runs on any available agent

    environment {
        SERVER_USER = 'your-ssh-user'
        SERVER_HOST = 'your-server-ip'
        SERVER_CREDENTIALS = 'your-server-ssh-credentials'  // Jenkins SSH credentials ID
        APP_NAME = 'jenkins-webapp-cicd-test-2025.jar'
        REPO_URL = 'https://github.com/anupseth/jenkins-webapp-cicd-test-2025.git'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: REPO_URL
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'  // Build the JAR file
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'  // Run unit tests
            }
        }

//         stage('Code Analysis') {
//             steps {
//                 withSonarQubeEnv('SonarQube') {  // Ensure SonarQube is configured in Jenkins
//                     sh 'mvn sonar:sonar'
//                 }
//             }
//         }

//         stage('Deploy to Server') {
//             steps {
//                 sshagent([SERVER_CREDENTIALS]) {
//                     sh """
//                         scp target/*.jar ${SERVER_USER}@${SERVER_HOST}:/home/${SERVER_USER}/${APP_NAME}
//                         ssh ${SERVER_USER}@${SERVER_HOST} "nohup java -jar /home/${SERVER_USER}/${APP_NAME} > /dev/null 2>&1 &"
//                     """
//                 }
//             }
//         }
//     }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'Pipeline completed successfully'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
