create database spark;
DROP TABLE IF EXISTS spark.song;
CREATE TABLE IF NOT EXISTS spark.song (
	title varchar(100),
    lyrics varchar(5000),
    sentiment integer,
    tf_vector varchar(5000),
    idf_vector varchar(5000)
);

DROP TABLE IF EXISTS spark.tweet;
CREATE TABLE IF NOT EXISTS spark.tweet (
	tweet_id varchar(100),
    tweet_text varchar(5000),
    sentiment integer,
    tf_vector varchar(5000),
    idf_vector varchar(5000)
);