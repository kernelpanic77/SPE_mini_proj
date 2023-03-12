pipeline {
  agent any
  stages {
    stage('Test Maven') {
      steps {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '773624ab-341d-4f64-a086-3b8be0f06165', url: 'https://github.com/kernelpanic77/SPE_mini_proj']])
        sh "mvn test"
      }
    }
  }
}