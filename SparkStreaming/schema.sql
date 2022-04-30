create database spark;
DROP TABLE IF EXISTS spark.song;
CREATE TABLE IF NOT EXISTS spark.song (
	title varchar(100) PRIMARY KEY,
    lyrics varchar(5000),
    sentiment integer,
    tf_vector varchar(5000),
    idf_vector varchar(5000),
    processed varchar(100) DEFAULT '0'
);

DROP TABLE IF EXISTS spark.tweet;
CREATE TABLE IF NOT EXISTS spark.tweet (
	tweet_id varchar(100) PRIMARY KEY,
    tweet_text varchar(5000),
    sentiment integer,
    tf_vector varchar(5000),
    idf_vector varchar(5000),
    processed varchar(100) DEFAULT '0'
);