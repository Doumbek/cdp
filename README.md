mvn clean test
allure generate target/allure-results -o allure-report --clean
allure open
