# marketPlace_comp6442
# Description: This is a back-end system for group assignment of comp6442, and developed by Xuan He(u7382548)
# Project dependencies: SpringBoot, Maven, MySQL, JToken.
# Project features: 
# Instructions:
  1. Run MarketApplication.java to test whether everything is good.
  2. Enter 'mvn clean package' command in IDE terminal.
  3. Copy the produced jar file 'sever-0.0.1-SNAPSHOT.jar' in 'Target' folder to linux server with exposed public IP.
  4. Enter 'java -jar sever-0.0.1-SNAPSHOT.jar' in the terminal of linux server to run the back-end system.
  5. Use command 'nohup java -jar sever-0.0.1-SNAPSHOT.jar --spring.profiles.active=product --server.port=8080 &' to run the system in the back stage.
  6. To terminate the system, use command << kill -9 `ps -ef | grep sever-0.0.1-SNAPSHOT.jar | grep -v 'grep' ` >>.
