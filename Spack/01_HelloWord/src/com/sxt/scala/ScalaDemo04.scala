package com.bjsxt.scala

object ScalaDemo04 {
  def main(args: Array[String]): Unit = {
    println(fun(1)(1))
    println(fun1(1)(1))
    
    //Scala字符串
    val str1 = "hello bjsxt"
    val str2 = "Hello BJSXT"
    println(str1.indexOf("b"))
    println(str1.compareToIgnoreCase(str2))
    
    val strBuilder = new StringBuilder
    strBuilder.append("abc")
    strBuilder.+('d')
    strBuilder + 'd'
    strBuilder.++=("efg")
    strBuilder ++= "efg" 
//    strBuilder.+=('h')
    strBuilder += 'h' 
    strBuilder.append(1.0)
    strBuilder.append(18f)
    println(strBuilder)
    
    /**
     * 数组
     * 创建了一个长度为10，并且泛型为Int的空数组
     */
    val array = new Array[Int](10)
    for(i <- 0 until array.length){
      array(i) = i * i
    }
    //使用for循环遍历数组
    for(i <- 0 until array.length){
      println(array(i))
    }
    
    
    Array.fill(5)("bjsxt").foreach { x => println(x) }
    
    /**
     * 这种方式会调用Array半生对象的apply方法
     */
    val arr2 = Array[String]("s100","s200","s300")
    arr2.map { x => x+"~" }.foreach {  println }
    
     //创建二维数组3*3  长度为3的数组，并且每一个元素的类型又是一个数组
    val array2Array = new Array[Array[String]](3)
    for(i <- 0 until array2Array.length){
      array2Array(i) = new Array[String](3)
    }
    
    for(i <- 0 until array2Array.length;j <- 0 until array2Array(i).length){
       array2Array(i)(j) = i * j + ""
    }
    array2Array.foreach { x => x.foreach { println } }
    
    
    //List集合
    val list1 = List(1,2,3,4,5)
    //Nil实际上表示是一个空的List集合  ::表示往集合中添加元素
    val list2 = 1 :: 2 :: 3:: Nil
    
    list2.foreach { println }
    for(elem <- list2){
      println(elem)
    }
    
    //def filter(p: A => Boolean): Repr   filter过滤函数   如果元素符合函数的条件 返回true 
    val filterList = list2.filter { x => x>2 }
    println("=============================================")
    filterList.foreach { println }
    //count  计算符合条件的元素个数
    
    val nameList = List("Angelababy","Dilireba","zhangxinyi","mochameimei")
    val count = nameList.count { x => x.contains("ba") }
    println(count)
    
    /**
     * hi Angelababy
       hi Dilireba
       hi zhangxinyi
       hi mochameimei
       	分词
     */
    val hiList = nameList
            .map { x => "hi " + x }
    val mapList = hiList.map { x => x.split(" ") }
    mapList.foreach { x=>x.foreach { println } }
    //得到一个集合，集合中每一个元素就是第一个单词  而不是一个数组
    hiList.flatMap { x => x.split(" ") }.foreach { println }
       
    
  }
  
  /**
   *  柯里化函数
			可以理解为高阶函数的简化
   */
  def fun(num1:Int):Int => Int = {
    //匿名函数
    (num2:Int) => num1+num2
  }
  
  //fun1函数实际上也是一个高阶函数，fun1函数是fun函数的简化版
  def fun1(a:Int)(b:Int) = {
    a+b
  }
  
  
}