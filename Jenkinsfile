pipeline {
    agent any
    
    tool{
        maven "MAVEN_HOME"
    }
    stages {
stage('testing pipeline'){
          steps{
      echo 'test1'
                }
}
    stage('Build'){
          steps{
      echo 'Building'
                }
        }
        stage('Test'){
          steps{
      bat 'mvn test'
                }
        }
        stage('Deploy'){
          steps{
      echo 'Deploying'
                }
        }
}
}
