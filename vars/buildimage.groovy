#!/usr/bin/env groovy

def call() {
    echo "deploying the app"
    withCredentials ([usernamePassword(credentialsID: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS")]){
        sh 'docker build -t piratehammad/nana_practice_jenkins_2:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'}}'
        sh 'docker push piratehammad/nana_practice_jenkins_2:jma-2.0')])

}