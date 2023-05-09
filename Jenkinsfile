pipeline {
    environment {
        service_name = "verifications"
        #docker_registry = 'nd21.serviceurl.in'
        #DOCKER_REGISTRY_CRED = credentials('jenkins-nd21-docker-secret-key-id')
        release_version = '1.0'
        #sonar_url = 'https://gyankosh.serviceurl.in/sonar'
        #sonar_auth_token = '1e46dde6fd3767a5b38783115b2653391d92bf88'
        #sonar_project_key = 'Sonar-fiverification-fi-verification-master'
    }

    parameters {
        string defaultValue: 'master', name: 'branchName'
        booleanParam defaultValue: true, name: 'SONAR'
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
