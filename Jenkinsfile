pipeline {
    agent any
    
    tools{
        maven "MAVEN_HOME"
    }
    
    stages{
        stage('Build'){
            steps{
                bat "mvn clean compile"
            }
        }
        stage('RunGetTag'){
            steps{
                bat "mvn test -Dcucumber.options=\"--tags @get\""
            }
        }
        stage('RunPostPutTag'){
            steps{
                bat "mvn test -Dcucumber.options=\"--tags @post,@put\""
            }
        }
        stage('Reports'){
            steps{
                //add reporting steps here
            }
        }
        stage('Deploy'){
            echo 'Deploying'
        }
    }
}
