def inputGetFile(String savedfile = null) {
    def filedata = null
    def filename = null

    if (savedfile == null) {
        def inputFile = input message: 'Upload file', parameters: [base64File(name: 'uploadDeployFile'), string(name: 'filename', defaultValue: "deploy_file")]
        filedata = inputFile['uploadDeployFile']
        filename = inputFile['filename']
    } else {
        def inputFile = input message: 'Upload file', parameters: [base64File(name: 'uploadDeployFile')]
        filedata = inputFile
        filename = savedfile
    }

    withEnv(["FILEDATA=${filedata}"]) {
        sh "echo ${FILEDATA} | base64 -d > ${filename}"
    }

    return filename
}
