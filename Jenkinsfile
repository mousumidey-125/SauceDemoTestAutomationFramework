pipeline {
    agent any
    
    tools {
        maven 'Maven3'
    }
    
    parameters {
        choice(name: 'SUITE', choices: ['testng.xml', 'smoke.xml', 'regression.xml'], description: 'Select which suite to run')
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
                bat 'mvn test'
            }
        }
        
        stage('Report') {
            steps {
                archiveArtifacts artifacts: 'reports/*.html', allowEmptyArchive: true
            }
        }
    }
    
    post {
        always {
            testNG()
        }
    }
}