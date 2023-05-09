pipeline {
    environment {
        service_name = "verifications"
        docker_registry = 'nd21.serviceurl.in'
        DOCKER_REGISTRY_CRED = credentials('jenkins-nd21-docker-secret-key-id')
        release_version = '1.0'
        sonar_url = 'https://gyankosh.serviceurl.in/sonar'
        sonar_auth_token = '1e46dde6fd3767a5b38783115b2653391d92bf88'
        sonar_project_key = 'Sonar-fiverification-fi-verification-master'
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
                    args '-u root -v /root/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock -v "$pwd":/usr/src/app -w /usr/src/app'
                }
            }
            steps {
                script{
                    if (params.SONAR) {
                        sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${sonar_project_key} -Dsonar.login=${sonar_auth_token} -Dsonar.host.url=${sonar_url} -Dsonar.qualitygate.wait=true -U"
                        sh 'ls -l target'
                    } else {
                        sh 'mvn -B clean package -U'
                        sh 'ls -l target'
                    }
                }
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

        stage('Pushing docker image') {
            steps{
                script {
                    if (params.branchName == 'master') {
                       env.tagName = 'latest'
                    } 
                    sh 'docker login $docker_registry -u $DOCKER_REGISTRY_CRED_USR -p $DOCKER_REGISTRY_CRED_PSW'
                    sh "docker tag ${service_name} ${docker_registry}/${service_name}:${tagName}"
                    sh "docker push ${docker_registry}/${service_name}:${tagName}"

                    sh "docker tag ${service_name} ${docker_registry}/${service_name}:${release_version}.${env.BUILD_NUMBER}"
                    sh "docker push ${docker_registry}/${service_name}:${release_version}.${env.BUILD_NUMBER}"
                    sh "docker logout ${docker_registry}"
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
                if (params.branchName == 'master') {
                    build wait: false, job: 'deploy-vms', parameters: [string(name: 'branchName', value:"${branchName}"),string(name: 'DEPLOY_TO', value: 'DEV'), string(name: 'tagName', value: "${release_version}.${env.BUILD_NUMBER}")]
                }
            }
        }
    }
}
