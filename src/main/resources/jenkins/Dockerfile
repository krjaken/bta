FROM jenkins/jenkins:jdk11
COPY --chown=jenkins:jenkins executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy
COPY --chown=jenkins:jenkins basic-security.groovy /usr/share/jenkins/ref/init.groovy.d/basic-security.groovy