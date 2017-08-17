pipeline {
    agent any
    stages {
        stage('Download sources') {
            steps {
                git credentialsId: 'b2c5042a-d992-49e5-994a-7ae4bfc4a0bf', url: 'git@github.com:coffeine-009/edge.git'
            }
        }
        stage('Release') {
            steps {
                sh "./gradlew clean release"
            }
        }
        stage('Build image') {
            steps {
                script {
                    docker.build('thecoffeine/edge')
                }
            }
        }
        stage("Publish image") {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'thecoffeine') {
                        docker.image('thecoffeine/edge').push('latest')
                    }
                }
            }
        }
    }

    post {
        always {
            archive 'build/libs/**/*.jar'
            junit 'build/test-results/**/*.xml'
            sh "docker rmi thecoffeine/edge registry.hub.docker.com/thecoffeine/edge"
        }
        success {
            slackSend channel: '#release',
                color: 'good',
                message: "@channel Edge server has released. \nVersion:${env.BUILD_NUMBER}."
        }
        failure {
            slackSend channel: '#release',
                color: 'danger',
                message: "@channel Edge server hasn't released. \nVersion:${env.BUILD_NUMBER} is failed."
        }
        unstable {
            slackSend channel: '#release',
                color: 'warning',
                message: "@channel Edge server's build #${env.BUILD_NUMBER} is unstable."
        }
        changed {
            slackSend channel: '#release',
                color: 'warning',
                message: "@channel Edge server's build #${env.BUILD_NUMBER} is changed."
        }
    }
}
