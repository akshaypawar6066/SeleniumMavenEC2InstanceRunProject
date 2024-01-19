pipeline {
    agent any

    stages {
        stage('Creating Image') {
            steps {
               bat "docker build -t=seleniumjenkinsdockerimage ."
            }
        }
        
                stage('Starting Selenium Grid') {
            steps {
                bat 'docker-compose up -d hub chrome firefox'
            }

    }
    
                stage('Execute test cases on Chrome Browser') {
            steps {
                bat 'docker-compose up cucumber-tests-chrome'
            }
            
            post { 
        always { 
          emailext attachLog: true, attachmentsPattern: '/htmlReportsChrome/SparkReport/index.html', body: '''<h1> Hi Team,</h1> 
<p>Please find the details below for the build execution.<br>$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:<br>Check console output at $BUILD_URL to view the results.<br>

Thanks!<br>
Automation Team.''', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!-Customized E-mail Notification of Docker Based Project  Using Jenkins Pipeline On ChromeBrowser', to: 'akshaypawar6066@gmail.com'
        }
    }
    }
    
}


    
}