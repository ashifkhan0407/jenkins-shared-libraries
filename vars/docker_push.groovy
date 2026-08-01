def call(String imageName, String tag) {

    withCredentials([usernamePassword(
        credentialsId: 'dockerhubcred',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {

        sh """
            echo "\$dockerHubPass" | docker login -u "\$dockerHubUser" --password-stdin
            docker push \$dockerHubUser/${imageName}:${tag}
        """
    }

}
