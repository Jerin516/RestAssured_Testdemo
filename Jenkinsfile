pipeline {
    agent any
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
      sh 'mvn test'
                }
        }
        stage('Deploy'){
          steps{
      echo 'Deploying'
                }
        }
}
}
