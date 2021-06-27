pipeline {
    agent any

    tools {
        maven "maven"
    }



    stages {
        stage('Build') {
            steps {

                git branch: 'main', url: 'https://github.com/thebackslash/yaso.git'

                // Run Maven on a Unix agent.
                bat "mvn clean package"
                bat "docker image build -t jaso ."
                bat "docker run jaso:latest"

            }

            }
        }

  post {
   success {
                      junit '**/target/surefire-reports/TEST-*.xml'
                      archiveArtifacts 'yaso-webapp/target/*.war'
                  }
        failure {
		echo "Application failed ***********"
        }

    }
}