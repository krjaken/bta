# BTA LV
test task for BTA

# How to run
___
___
## Run tests locally
### Requirements:
* Java 11 installed

for run tests locally:
- click on test or execute ```mvn clean test``` command
___
## Run tests inside Jenkins
### Requirements
* Docker installed
* Docker compose installed
* port 8080 and 5000 is allowed on your PC

for run tests inside Jenkins:
- run ```docker-compose up -d --build``` in directory where located [docker-compose.yml](docker-compose.yml) file
- open local [jenkins host](http://localhost:8080) in your web browser
- go to pipelines and run BTA pipeline
    - after test execution, test report will be available in Allure report by link in your finished pipeline

---
# Docker Services description
## Jenkins
Here used Docker deployed Jenkins with skipped security policy, based on https://www.linkedin.com/pulse/automating-jenkins-binary-installation-mohamed-mostafa/ tutorial. The main goal is show how exactly test project works