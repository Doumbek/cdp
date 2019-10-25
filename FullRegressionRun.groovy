properties([
        buildDiscarder(
                logRotator(numToKeepStr: '10')),
        parameters([
                choice(choices: ['aws'], name: 'ENV'),
                choice(choices: ['regression'], name: 'SUITE'),
                choice(choices: ['chrome'], name: 'BROWSER'),
                string(defaultValue: 'autoqa', name: 'PREFIX'),
                string(defaultValue: 'master', name: 'BRANCH')]),
])

node('automation') {

    def REGRESSION_RESULTS_JOB_NAME = "3_results_regression_Merchandising-portals_autoqa"

    stage('Clone TAF') {
        deleteDir()
        git url: 'git@github.com:CarteraCommerce/auto-merch-portal-tests.git',
                credentialsId: 'cartera-devops-release-ssh-key',
                branch: "${params.BRANCH}",
                poll: false,
                changelog: false
    }

    stage('Run regression') {
        wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
            withMaven(maven: 'maven-3.5.3') {
                sh "mvn -U clean integration-test -DENV=${params.ENV} -DSUITE=${params.SUITE} -DBROWSER=${params.BROWSER} -DPREFIX=${params.PREFIX}"
            }
        }
    }

    stage('Publish results') {
        sh "zip -qr allure-result.zip target/allure-results"
        archiveArtifacts allowEmptyArchive: true, artifacts: 'allure-result.zip'
        build job: REGRESSION_RESULTS_JOB_NAME,
                parameters: [
                        string(name: 'JOB_NAME_WITH_RESULTS', value: env.JOB_BASE_NAME),
                        booleanParam(name: 'CLEAR_TARGET', value: true)],
                wait: true,
                propagate: false
    }

    stage('Rerun regression') {
        final String testNgResultsXml = readFile "${env.WORKSPACE}/target/surefire-reports/testng-results.xml"
        println parseFailedITCaseScopeFrom(testNgResultsXml)
    }








    stage('Generate report') {
        allure includeProperties: false,
                results: [[path: 'target/allure-results']]
    }

}

def parseFailedITCaseScopeFrom(final String testNgResultsXml) {

    def results = new XmlSlurper().parseText(testNgResultsXml)

    def failedTestMethod = { node -> node['@status'] == 'FAIL' }
    def parentClassName = { node -> node.parent()['@name'].text() }
    def shortParentClassName = { name -> name.tokenize(".").last() }

    return fullClassNames = results.'**'
            .findAll(failedTestMethod)
            .collect(parentClassName)
            .collect(shortParentClassName)
            .unique(false)
            .join(";")

}













//def regressionJobName = "Merchandising-portals-regression-rerun"
//
//stage('Run regression') {
//    build job: regressionJobName,
//            parameters: [
//                    string(name: 'ENV', value: 'aws'),
//                    string(name: 'PREFIX', value: 'autoqa'),
//                    string(name: 'SUITE', value: 'regression'),
//                    string(name: 'COMPONENTS', value: "${COMPONENTS}"),
//                    string(name: 'BROWSER', value: 'chrome')],
//            wait: true,
//            propagate: false
//}
//
//stage('Update report') {
//    build job: '3_results_regression_Merchandising-portals_autoqa',
//            parameters: [
//                    string(name: 'JOB_NAME_WITH_RESULTS', value: regressionJobName),
//                    booleanParam(name: 'CLEAR_TARGET', value: false)],
//            wait: true,
//            propagate: false
//}

