pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    parameters {
        choice(name: 'SUITE', choices: ['smoke.xml', 'regression.xml', 'testng.xml'], description: 'Select which suite to run')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/mousumidey-125/SauceDemoTestAutomationFramework'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat "mvn test -DsuiteFile=${params.SUITE}"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'reports/*.html', allowEmptyArchive: true
            testNG()
        }
        failure {
            emailext (
                subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build failed. Check console output at ${env.BUILD_URL}",
                to: "mousumidey125@gmail.com"
            )
        }
    }
}