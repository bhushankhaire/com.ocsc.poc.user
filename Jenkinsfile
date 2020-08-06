pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "jenkins-maven"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/bhushankhaire/com.ocsc.poc.user.git'

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
        stage('BUild Docker image') {
            when { branch "master" }
            steps {
                sh '''
                    docker login -u "bhushapkhaire" -p "bhuson@1987"
                    docker build --no-cache -f Dockerfile -t user:latest2 .
                    docker tag user:latest2 bhushapkhaire/user:latest2
                    docker push bhushapkhaire/user:latest2
                    docker rmi user:latest2
                '''
            }
        }

    }
}
