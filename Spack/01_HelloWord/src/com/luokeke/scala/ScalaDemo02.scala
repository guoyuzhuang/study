package com.luokeke.scala

import java.util.Date

object ScalaDemo02 {
  def main(args: Array[String]): Unit = {

    //    t0();
    //    t1();
    //    t2(20)
    //    t3(20)
    //    t4(20)
    //    t5(9)
//    t6(9);
//    t7();
//    t8()
//    println(t9(10))
//    println(t9(b = 20))
    
//    println(t10(10, 12, 15))
//    println(n1())
//    println(n2(15, 19))
    /*val date = new Date();
    loginfo(date, "测试1")
    loginfo(date, "测试2")
    loginfo(date, "测试3")
    loginfo(date, "测试4")
    
    println("定义一个偏应用函数------------------")
    val logWriter = loginfo(date, _:String)
    logWriter("测试1")
    logWriter("测试2")
    logWriter("测试3")
    logWriter("测试4")*/
//    g1((a:Int) => {println("我是一个高阶函数" + a)})
//    println(g2()(100, 200))
//    println(g3((a:Int, b:Int) => {a * b})(100, 200))
//    str1();
//    array1()
//    list1()
//    list2_count()
//    list3_flatmap()
//    set1()
//    map1()
//    tuple_1()
    
    

  }
  
  def tuple_1 () : Unit = {
    var t1 = new Tuple1(10)
    var t2 = new Tuple2(10, 500)
    var tn = (10, 581, 59)
    var productIterator = tn.productIterator
    while (productIterator.hasNext) {
      println(productIterator.next())
    }
    //元素的翻转，只能是针对二元组
    println(t2)
    println(t2.swap)
    //toString
    println(t2.toString())
  }
  
  def map1 () : Unit = {
    var map1 = Map(1 -> 100, 2 -> 200, (3, 300), ("4", "bjsxt"))//创建map
    println("获取map的值：\t" + map1.get(3).get)
    println("获取map的值：\t" + map1.get("4").get)
    println("获取map的值：\t" + map1.get("40").getOrElse("使用匿名函数，返回要获取的值"))
    println("使用for循环遍历map元素=================")
    for (x <- map1) {
      println("KEY = " + x._1 + "\tvalue = " + x._2)
    }
    println("使用foreach循环遍历map元素=================")
    map1.foreach(x => println("KEY = " + x._1 + "\tvalue = " + x._2))
    println("遍历KEY=================")
    val map_keys = map1.keys
    map_keys.foreach(println)
    println("遍历VALUE=================")
    map1.values.foreach(println)
  }
  
  () => {}
  
  def set1() : Unit = {
    var set1 = Set(1, 2, 3, 4, 4, 5, 3)
    var set2 = Set(1, 2, 3)
    var set3 = Set(5, 8 , 9)
    set1.foreach(println)//循环输出
    println("输出交集数据：=======================")
    var set_intersect = set1.intersect(set3)
    set_intersect.foreach(println)
    println("输出差集数据：=======================")
    set1.diff(set3).foreach(println)
    println("输出差集数据：=======================\n\n")
    set3.diff(set1).foreach(println)
    println("输出子集数据：=======================")
    println(set1.subsetOf(set3))//false
    println(set1.subsetOf(set2))//false
    println(set2.subsetOf(set1))//true
    println("set1的最大值为：" + set1.max)
    println("set1的最小值为：" + set1.min)
    println("将Set1转成数组：=======================")
    var set_list = set1.toList
    set_list.foreach(x => print(x + "\t"))
    println()
    println("将Set1转成字符串：\t" + set1.mkString("\t"))
  }
  
  /**
   * flatmap：压扁扁平,先map再flat
   */
  def list3_flatmap () : Unit = {
    val nameList = List(
    		"hello bjsxt",
    		"hello xasxt",
    		"hello shsxt"
        )
     var c = nameList.map(f => f.split(" "))
     c.foreach(f => println(f))
     var d = nameList.flatMap(f => f.split(" "))
     d.foreach(println)
  }
  
  /**
   * 计算符合提交的元素数量
   */
  def list2_count () : Unit = {
    var list = List(1, 2, 3, 4, 5)
    println(list.count(p => {p > 2}))
  }
  
  def list1() : Unit = {
    var list1 = List(1,2,3,4)
    var list2 = 1::2::3::4::Nil
    println(list1.filter(p => p > 2))
    list1.foreach(println)
    list1.map(x => x + "------------").foreach(println)
  }
  
  /**
   * list学习
   */
  def array1() : Unit = {
    var arr1 = new Array[String](10)
    for (i <- 1 to arr1.length) {
      arr1(i - 1) = (i * i + "")
    }
    
    for (i <- 0 until arr1.length) {
      println(arr1(i))
    }
    
    for (i <- arr1) {
      println("值为：" + i)
    }
    
    println("使用foreach来打印")
    arr1.foreach(x => println("使用foreach来打印\t" + x))
    arr1.foreach(printlnL)
  }
//  x => println("使用foreach来打印\t" + x)
  
  def printlnL(a : String) : Unit = {
    println("使用自定义方法答应\t" + a)
  }
  
  def str1() : Unit = {
    var s1 = "luokeke";
    var s2 = "luokeke";
    println(s1.equals(s2))
    println("sdfsdfs".equals("sdfsdf"))
  }
  
  /**
   * 函数的请求参数为一个有两个Int参数并且返回值也为Int的函数
   * 函数的返回值为一个有两个Int参数并且返回值也为Int的函数
   */
  def g3(f: (Int, Int) => Int) : ((Int, Int) => Int) = {
    f
  }
  
  def g2() : ((Int, Int) => Int) = {
    (a:Int, b:Int) => {a + b}
  }
  
  /**
   * 高阶函数学习
   * 	函数的参数是函数
   *  函数的返回值是函数
   *  	就叫做高阶函数
   */
  def g1(f : (Int) => Unit) = {
    f(100)
    println("调用了第一个高阶函数")
  }
  
  /**
   * 偏应用函数学习
   */
  def loginfo(date:Date, msg:String) : Unit = {
    println(date + "\t" + msg)
  }
  
  /**
   * 匿名函数学习
   */
  val n1 = () => {3}
  val n2 = (a:Int, b:Int) => {a * b}
  
  /**
   * 可变参数函数
   */
  def t10(a:Int*) : Int = {
    var sum = 0
    for (i <- a) {
      sum = sum + i
    }
    sum
  }
  
  /**
   * 参数为默认值的函数
   */
  def t9(a:Int = 10, b:Int) : Int = {
    a + b
  }
  
  def t9(a:Int) : Int = {
    if (a == 1) {
      return a
    } else {
      return a * t9(a - 1)
    }
  }
  
  def t8() {
    var i = 10;
    while(i > 0) {
      println(i)
      i -= 1
    }
    
    
    i = 10;
    do{
      println("打印一个执行sql：" + i)
      i -= 2;
    }while(i > 0)
  }

  def t7(): Unit = {
    var list1 = for (i <- 1 to 10; if (i > 5)) yield i
    for (i <- list1) {
      println(i)
    }
  }

  def t6(n: Int): Unit = {
    for (i <- 1 to n; j <- 1 to i) {
      print(j + "*" + i + "=" + j * i + "\t")
    }
  }

  def t5(n: Int): Unit = {
    for (i <- 1 to n) {
      for (j <- 1 to i) {
        print(j + "*" + i + "=" + j * i + "\t")
      }
      println()
    }
  }

  def t0() = {
    var age = 20
    if (age > 20) {
      println("您已经20岁以上啦")
    } else if (age <= 20 && age > 18) {
      println("成年人")
    } else {
      println("你还太小")
    }
  }

  def t1() = {
    for (elem <- 1 to 10) {
      println(elem)
    }
  }

  def t2(n: Int): Unit = {
    for (elem <- 1 until n) {
      println(elem)
    }
  }

  def t3(n: Int): Unit = {
    println("t3***********************")
    for (elem <- 1 until (n, 2)) {
      println(elem)
    }
  }

  def t4(n: Int): Unit = {
    println("t4***********************")
    for (elem <- 1 until n; if elem % 3 == 0) {
      println(elem)
    }
  }
}

class ScalaDemo02 {

}