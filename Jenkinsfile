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
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'C:\\Users\\jerjose\\Documents\\Jenkins\\workspace\\RestAssured_Testdemo\\src\\test\\reports', reportFiles: 'cucumber_report.html', reportName: 'Extent Reports', reportTitles: ''])
            }
        }
        stage('Deploy'){
            echo 'Deploying'
        }
    }
}
