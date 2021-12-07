pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        echo 'Test'
        checkout([$class: 'GitSCM',
        branches: [[name: '*/master']],
        extensions: [],
        userRemoteConfigs: [[url: 'https://github.com/itsPareshY/springbootapp.git']]
        ])
      }
    }
    stage('Build') {
    steps {
        //sh 'mvn clean install'
        echo 'Build'
        }
    }
    stage('Junit') {
        steps {
            echo 'Junit'
            }
        }
    stage('Integration Test') {
        steps {
          echo 'Integration Tests'
            }
    }
     stage('Artifacts') {
             steps {
               echo 'Integration Tests'
                 }
         }
     stage('Deploy on AT env') {
             steps {
               echo 'Integration Tests'
                 }
         }
     stage('Automation Test') {
             steps {
               echo 'Integration Tests'
                 }
         }
     stage('Upload Artifacts') {
             steps {
               echo 'Integration Tests'
                 }
         }
     stage('Deploy') {
             steps {
               echo 'Integration Tests'
                 }
         }

  }
}
