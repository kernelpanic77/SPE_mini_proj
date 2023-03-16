pipeline {
  agent any
  environment {
      dockerhub=credentials('45f02e99-ddb4-42fc-a324-e725dd954339')
  }
  stages {
    stage('Test Maven') {
      steps {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '773624ab-341d-4f64-a086-3b8be0f06165', url: 'https://github.com/kernelpanic77/SPE_mini_proj']])
        sh "mvn clean"
        sh "mvn test"
      }
    }
    stage ('Build Maven'){
        steps {
            sh "mvn package"
        }
    }
    stage ('Build Image'){
        steps {
            sh "docker build -t kernelpanic77/devops-calculator ."
        }
    }
    stage ('Push Image'){
        steps {
            sh "echo $dockerhub_PSW | docker login -u $dockerhub_USR --password-stdin"
            sh 'docker push kernelpanic77/devops-calculator:latest'
        }
    }
    stage ('Ansible - Deploy Container'){
        steps {
            echo ("Invoking calculator-deploy.yml ansible playbook")
            ansiblePlaybook colorized:true, disableHostChecking:true, installation:'Ansible', inventory:'inventory', playbook:'calculator-deploy.yml'
        }
    }
  }
}