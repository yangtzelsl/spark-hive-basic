import org.apache.spark.sql.SparkSession

/**
 *
 * @Description: SparkSessionApp
 * @Author luis.liu
 * @Date: 2021/4/26 15:01
 * @Version 1.0
 */
object SparkSessionApp {

  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "hive")
    val sparkSession = SparkSession.builder()
      .appName("SparkSessionApp")
      .config("spark.sql.warehouse.dir", "/tmp/hive/")
            .config("hive.metastore.uris", "thrift://x.x.x.x:9083")
      .enableHiveSupport() //使用到hive一定要开启这个，idea要想连接hive得在pom中加上hive
      .master("local[2]")
      .getOrCreate()
    val showDatabases = sparkSession.sql("show databases")
    println("show databases")
    showDatabases.show

    val useDatabase = sparkSession.sql("use amber_app_dwd")
    println("use amber_app_dwd")
    useDatabase.show()

    val showTables = sparkSession.sql("show tables")
    println("show tables")
    showTables.show()

    val select = sparkSession.sql("select * from dwd_sa_api_users_prod limit 1")
    println("select * from dwd_sa_api_users_prod limit 1")
    select.show()

    sparkSession.stop()
  }

}
