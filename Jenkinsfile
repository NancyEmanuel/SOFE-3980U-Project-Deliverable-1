pipeline {
  environment {
    DOCKER_IMAGE = 'okikioschool/binarycalculator-lab4:latest'
    DOCKER_CONFIG = "${WORKSPACE}/.docker" // Use a path within the Jenkins workspace
  }

  // agent { kubernetes {} }
  agent any
  tools {
    maven 'maven' 
  }
  stages {
    stage ('Init') {
      steps {
        sh 'echo "Start of Job"'
        sh 'ls -la'
      }
    }
    stage ('test') {
      steps {
        sh 'mvn clean test -f ./SOFE3980U-ProjectDeliverable1/pom.xml'
      }
    }
    stage ('build') {
      steps {
        sh 'mvn package -DskipTests -f ./SOFE3980U-ProjectDeliverable1/pom.xml'
      }
    }
    // stage('Build and push image to Docker Hub') {
    //   steps {
    //     script {
          
          // withCredentials([usernamePassword(credentialsId: 'docker-registry-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
          //   // Use workspace directory to avoid read-only file system issue
          //   sh "mkdir -p ${DOCKER_CONFIG}"
          //   sh "echo '{\"auths\":{\"https://index.docker.io/v1/\":{\"username\":\"\$DOCKER_USER\",\"password\":\"\$DOCKER_PASSWORD\"}}}' > ${DOCKER_CONFIG}/config.json"
          // }
          // // Define the pod template for Kaniko, mounting the workspace directory
          // podTemplate(containers: [
          //   containerTemplate(
          //     name: 'kaniko',
          //     image: 'gcr.io/kaniko-project/executor:latest',
          //     command: 'cat',
          //     ttyEnabled: true,
          //     volumeMounts: [
          //       volumeMount(mountPath: '/kaniko/.docker', name: 'docker-config')
          //     ]
          //   )],
          //   volumes: [
          //     hostPathVolume(hostPath: "${DOCKER_CONFIG}", name: 'docker-config')
          //   ]
          // ) {
          //   container('kaniko') {
          //     sh """
          //     /kaniko/executor --context ${WORKSPACE}/BinaryCalculatorWebapp/ \
          //                       --dockerfile ${WORKSPACE}/BinaryCalculatorWebapp/Dockerfile \
          //                       --destination ${DOCKER_IMAGE}
          //     """
          //   }
          // }

//           podTemplate(yaml: """
// apiVersion: v1
// kind: Pod
// spec:
//   containers:
//   - name: kaniko
//     image: gcr.io/kaniko-project/executor:latest
//     command:
//     - /busybox/cat
//     tty: true
//     volumeMounts:
//     - name: docker-config
//       mountPath: /kaniko/.docker/
//   volumes:
//   - name: docker-config
//     secret:
//       secretName: kaniko-secret
// """, name: 'kaniko') {
          //   container(name: 'kaniko', shell: '/busybox/sh') {
          //     sh """
          //     /kaniko/executor --context ${WORKSPACE}/BinaryCalculatorWebapp/ \
          //                       --dockerfile ${WORKSPACE}/BinaryCalculatorWebapp/Dockerfile \
          //                       --destination ${DOCKER_IMAGE}
          //     """
          //   }
          // }
          // sh "docker login -u $DOCKER_CREDS_USR -p $DOCKER_CREDS_PSW"
          // sh "docker build -t ${DOCKER_IMAGE} ./BinaryCalculatorWebapp/"
          // sh "docker push ${DOCKER_IMAGE}"
    //     }
    //   }
    // }
    stage ('Deploy') {
      steps {
        sh 'echo "bye bye"'
      }
    }
  }
}