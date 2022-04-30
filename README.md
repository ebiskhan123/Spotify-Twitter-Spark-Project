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


