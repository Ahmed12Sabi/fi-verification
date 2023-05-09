pipeline {
    environment {
        service_name = "verifications"
        release_version = '1.0'
       
    }

    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.1-eclipse-temurin-17-focal'
                    args '-u root -v /root/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock -v :/usr/src/app -w /usr/src/app'
                }
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
