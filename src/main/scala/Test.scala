import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object Test {
  def main(args: Array[String]): Unit = {
    var sc=new SparkContext();
    var input=sc.parallelize(List(List("a",2,3),List("a",5,6),List("b",2,6)));
    var rdd:RDD[(String,(Int))] =input.map(line=>{
      var key=line(0).toString;
      var key1=line(1).toString;
      var v2=line(2).toString.toInt;
      (key+key1,v2)
    });
    var result=rdd.reduceByKey((x,y)=>x+y)
    result.collect().foreach(println);

  }
}
