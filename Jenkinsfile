@Library('pipe-shared-library@master') _

pipeline {
    agent any
    stages {
        
        stage ('Copy File') {
            steps {
                script{
                    def getFile = copy_bin_to_wksp.inputGetFile('deploy_file')
                }
                sh "cat deploy_file"
                sh "ls -ltR"
            }
        }
    }
}
