#!/usr/bin/env groovy

def call() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'Dockerhub_credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t piratehammad/demo-app:jma-2.0 .'
        sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
        sh 'docker push piratehammad/demo-app:jma-2.0'
    }
}
