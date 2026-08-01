def call(String imageName, String tag, String dockerUser) {

    sh """
        docker build -t ${imageName}:${tag} .
        docker tag ${imageName}:${tag} ${dockerUser}/${imageName}:${tag}
    """

}
