pipeline {
    environment {
        service_name = 'verifications'
        release_version = '1.0'
       
    }

    agent any

    stages {
        stage('Build') {
            
              
               		docker 'sudo docker build -t fi-verifications:1.0.0 .'     
                    
            
            steps{
                script{
                 sh 'mvn clean install -DskipTests'
                 sh 'ls -l target'
                       
                }
                stash includes: 'target/*.jar', name: 'APP_JAR'

            
            
        }
        }
        stage('Building docker image') {
            steps{
                script {
                    unstash 'APP_JAR'
                    sh 'ls -l'
                    sh 'docker build -f Dockerfile -t ${service_name} .'
                }
            }
        }

        
        stage('Clean') {
            steps{
                 sh 'docker rmi -f ${service_name}'
            }
        }
    }
    post {
        success {
            script {
                echo 'Build Completed' 
            }
        }
    }
}
