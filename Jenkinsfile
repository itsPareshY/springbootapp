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
            echo 'sh mvn -T 1 org.jacoco:jacoco-maven-plugin:prepare-agent verify -Dmaven.test.failure.ignore=true'
            }
        }
    stage('Integration Test') {
        steps {
          echo 'Integration Tests'
            }
    }
     stage('Deploy Artifacts to repo/nexus append CL # to artifact') {
             steps {
               echo 'mvn deploy -B -Dprepare-docker -Dinvoker.skip=true -Dmaven.test.skip=true -Dmaven.main.skip=true'
                 }
         }
     stage('Dockerize and upload to nexus') {
             steps {
               echo 'use docker file'
                 }
         }
     stage('Deploy on AT env and run Automation Test') {
             steps {
               echo 'Integration Tests'
                 }
         }
     stage('Reverts Artifacts if AT failed') {
             steps {
               echo 'Integration Tests'
                 }
         }
     stage('Deploy on Staging if AT passed') {
             steps {
               echo 'Integration Tests'
                 }
         }

  }
}
