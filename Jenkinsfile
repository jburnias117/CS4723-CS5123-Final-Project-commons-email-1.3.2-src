pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
            	 echo 'Building package..'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
            	 echo 'Beginning test stage for id (WAG__)..'
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') { 
            steps {
            	 echo 'Deliver stage (WAG__)..'
                sh './jenkins/scripts/deliver.sh' 
            }
        }
    }
}
