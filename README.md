mvn -Dtest=FirstTest -Dbrowser=mazilla verify
mvn -Dtest=FirstTest -Dbrowser=google verify
mvn -Dtest=FirstTest verify
mvn -Dtest=FirstTest -Dbrowser=lol verify //уйдёт в дефолт
по дефолту запускается в google 
