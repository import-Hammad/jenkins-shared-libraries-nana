#!/usr/bin/env groovy

def call(String imageName) {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'Dockerhub_credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh "docker build -t $imageName ."
        sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
        sh "docker push $imageName"
    }
}
