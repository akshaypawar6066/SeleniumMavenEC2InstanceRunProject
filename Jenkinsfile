pipeline {
    agent any

    stages {
                stage('Starting Selenium Grid') {
            steps {
                sh 'docker-compose up -d hub chrome firefox'
            }

    }
    
                stage('Execute test cases on Chrome Browser') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true test'
            }
            
            post { 
        always { 
          emailext attachLog: true, attachmentsPattern: '/index.html', body: '''<h1> Hi Team,</h1> 
<p>Please find the details below for the build execution.<br>$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:<br>Check console output at $BUILD_URL to view the results.<br>

Thanks!<br>
Automation Team.''', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!-Customized E-mail Notification of Docker Based Project  Using Jenkins Pipeline On ChromeBrowser and Exutes on EC2', to: 'akshaypawar6066@gmail.com'
        }
    }
    }
    
        stage('Make Infra Down') {
            steps {
                sh 'docker-compose down'
            }
    
}

}
    
}