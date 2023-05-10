pipeline {
    environment {
        service_name = "verifications"
        release_version = '1.0'
       
    }

    agent any

    stages {
        stage('Build') {
            
                agent {
               		docker 'sudo docker build -t fi-verifications .'     
                    
            }
            steps{
                                stash includes: 'target/*.jar', name: 'APP_JAR'

            }
            
        }

        stage('Building docker image') {
            steps{
                script {
                    unstash 'APP_JAR'
                    sh 'ls -l'
                    sh "docker build -f Dockerfile -t ${service_name} ."
                }
            }
        }

        
        stage('Clean') {
            steps{
                 sh "docker rmi -f ${service_name}"
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
