#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {
    def script
    
    Docker(script) {
        this.script = script
    }
    
    def buildDockerImage() {
        script.echo "building the docker image"
        script.withCredentials([
            script.usernamePassword(
                credentialsId: 'docker-hub-repo',
                passwordVariable: 'PASS',
                usernameVariable: 'USER'
            )
        ]) {
            script.sh 'docker build -t piratehammad/demo-app:jma-2.0 .'
            script.sh "echo \$PASS | docker login -u \$USER --password-stdin"
            script.sh 'docker push piratehammad/demo-app:jma-2.0'
        }
    }
}
