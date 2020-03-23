pipeline {
    agent any
    
    tools{
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
              
              cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                }
        }
        stage('Deploy'){
          steps{
      echo 'Deploying'
                }
        }
}
}
