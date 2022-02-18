pipeline {
   agent any

   stages {
      stage('clean') {
        steps {
            echo "==> Clean"
            sh 'docker stop $(docker ps -a -q)'
            sh 'docker rm $(docker ps -a -q)'
            sh 'docker rmi se3/lmcc-backend -f'
            sh './mvnw clean'
        }
      }
      stage('build') {
        steps {
           echo '==> Build'
           sh './mvnw install'
        }
      }
	  stage('test') {
		steps {
			echo '==> Test'
			sh './mvnw test'
		}
	  }
	  stage('deploy') {
        steps {
            echo '==> Deploy'
            sh 'docker build -t se3/lmcc-backend .'
            sh 'docker run -p 8082:8082 se3/lmcc-backend'
        }
      }
   }
}