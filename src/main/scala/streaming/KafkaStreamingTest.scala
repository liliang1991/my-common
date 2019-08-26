package streaming

import org.apache.commons.codec.StringDecoder
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka.KafkaUtils
object KafkaStreamingTest {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().appName("spark_kafka").master("local[*]").getOrCreate()
    val beatch=Seconds(5)//秒
    val streamingContext=new StreamingContext(spark.sparkContext,beatch)
      streamingContext.checkpoint("/Users/eric/SparkWorkspace/checkpoint")
    val topics = Array("test").toSet

    val kafkaParams = Map[String, String]("metadata.broker.list" -> "localhost:9092")
    val stream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](streamingContext, kafkaParams, topics)
    stream.foreachRDD(rdd=>{
      rdd.foreach(line=>{
        print(line)
      })
    })

    streamingContext.start()  //spark stream系统启动
    streamingContext.awaitTermination() //

  }
}
