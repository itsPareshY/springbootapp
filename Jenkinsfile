pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        echo 'Test'
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/itsPareshY/springbootapp.git']]])
      }
    }

  }
}
