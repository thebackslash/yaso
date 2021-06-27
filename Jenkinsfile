pipeline {
    agent any

    tools {
        maven "maven"
    }



    stages {
        stage('Build') {
            steps {



                git 'https://github.com/thebackslash/yaso.git'

                // Run Maven on a Unix agent.
                bat "mvn clean package"

            }

            }
        }

  post {
        failure {
		echo "Application failed ***********"
        }

    }
