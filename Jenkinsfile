pipeline {   
    environment { 
		registryUrl="https://bom.ocir.io"
		registry = "bom.ocir.io/yzguo69kabyn/bkhaire/com.ocsc.poc.user"
        	registryCredential = 'bom-ocir-oi'
		dockerImage = '' 
    }
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "jenkins-maven"
    }
    stages {
        stage('Cloning our Git') {
            steps { 
                git 'https://github.com/bhushankhaire/com.ocsc.poc.user.git'
            }
        } 
        stage('Maven Build') {
            steps {
                // Get some code from a GitHub repository
                //git 'https://github.com/bhushankhaire/com.ocsc.poc.user.git'
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    //junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
	stage('Upload our image to OCIR') { 
            steps { 
                script { 
	                  docker.withRegistry(registryUrl, registryCredential ) { 
	                  dockerImage.push() 
                   }
                } 
            }
        } 
        stage('Cleaning up local docker image') { 
            steps { 
                sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        }
	stage('Deploy to OKE') {
         /* Deploy the image to OKE*/
        steps {
        
        	    sh 'sh /var/lib/jenkins/workspace/com.ocsc.poc.user/deploy.sh'
           }
         }
    }
}
