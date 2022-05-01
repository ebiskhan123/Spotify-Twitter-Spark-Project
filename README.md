
##  CSYE 7200 Project repo
|Member|  NUID| 
|-------|--|
|      Ebenezer Ajay Williams | 002166250  |
|      Vasudha Banargad | 00-  |
|      Tanay Saxena | 00  |

**Repo Outline**
| Folder | Stack | Description |
|--|--|--|
| *DataRetrievingService* | Java,Spring Boot , Apache Kafka | Service to retrieve data from the Spotify, MusixMatch and Twitter APIs|
| *SparkStreaming* | Scala, Spark, Spark ML , Apache Kafka, MySql | Reads Data from Apache Kafka and compares the cosine similarity between the lyrics and tweet text. Also extracts the sentiment of the lyrics and each tweet |
| *Presentation* |  -| Contains the presentation documents |
| *Dashboard* | Java,Spring Boot, JavaScript | Acts as a Rest API for the data Stored in the MySql DB and the Dashboard which shows the relationship between the tweets and songs along with the sentiment of the lyrics and songs|

## Project outline 
![alt text](https://github.com/tanaysaxena97/CSYE7200FinalProject/blob/main/Presentation/Blank%20diagram.png =250x250)

## Steps to set up the pipeline 
First Download and install Xaamp 
Use the following links to do so.
**XAAMP:** https://www.apachefriends.org/download.html
**Kafka:** https://www.apache.org/dyn/closer.cgi?path=/kafka/3.1.0/kafka_2.13-3.1.0.tgz

After Downloading kafka.
```bash
$ tar -xzf kafka_2.13-3.1.0.tgz
$ cd kafka_2.13-3.1.0
```
Start Zookeeper.
```bash
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```
Start Kafka Server.
```bash
$ bin/kafka-server-start.sh config/server.properties
```
Create tweets-topic
````
bin/kafka-topics.sh --create --topic tweets-topic --bootstrap-server localhost:9092
````
Create songs-topic
````
bin/kafka-topics.sh --create --topic songs-topic --bootstrap-server localhost:9092
````


Navigate into the DataRetrievingService directory and run.
````
mvn spring-boot:run
````

Open 2 instances of Spark Streaming service and run the main function in **SparkStreamingSongs.scala** in one instance and **SparkStreamingTweets.scala** in the other instance.

Now navigate to the Dashboard directory and run
````
mvn spring-boot:run
````

Now navigate to the front-end folder and open index.html to view the output.
Refresh the dashboard to view updated stats.


**Final output**
Bar Chart showing the number of tweets related to the top 50 songs.

![alt text](https://github.com/tanaysaxena97/CSYE7200FinalProject/blob/finalfinish/bar%20chart.png?raw=true)

Pie Chart showing the sentiment of tweets and songs.

![alt text](https://github.com/tanaysaxena97/CSYE7200FinalProject/blob/main/Presentation/Sentiment.jpeg?raw=true)
