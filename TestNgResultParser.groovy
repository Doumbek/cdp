//def testNgFailed = new File("./target/surefire-reports/testng-results.xml")
String testNgFailed = new File("./target/surefire-reports/testng-results.xml").text
//println testNgFailed.text

//def results = new XmlParser().parse(testNgFailed)
def results = new XmlSlurper().parseText(testNgFailed)
println "Total cases is ${results['@total']}"

def failedTestMethod = { node -> node['@status'] == 'FAIL' }
def parentClassName = { node -> node.parent()['@name'].text() }
def shortParentClassName = { name -> name.tokenize(".").last() }

def fullClassNames = results.'**'
        .findAll(failedTestMethod)
        .collect(parentClassName)
        .collect(shortParentClassName)
        .unique(false)
        .join(";")

println fullClassNames
