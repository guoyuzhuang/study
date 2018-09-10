package com.bjsxt.scala

/**
 * 结束符：在java中每一行代码必须以分号结尾
 * 在scala中每一代码可以以分号结尾，也可以不，但是如果在一行中有多个表达是，那么表达式之间必须使用分号来分割
 */
object ScalaDemo01 {
   def main(args: Array[String]): Unit = {
     val a = 10
     val p = Person("Fanbing",19)
     
     val p3 = new Person("a","b",19)
     println(p.name)
     println(p.age)
     p.sayLove()
     Person.sayName()
   }
}


//Person类默认的构造函数是无参数
/**
 * 有参数构造函数
 * 
 * 创建多个构造函数
 */
class Person(var n:String,var a:Int){
  val name = n
  var age = a
  
  //重写的构造函数体内必须调用之前的构造函数
  def this(a:String, b:String,c:Int) = {
    this(a,c)
    println("新的构造函数")
  }
  
  
  def sayLove() = {
    println("I Love " + name)
  }
}

/**
 * object Person是peroson类的伴生对象，在这个对象中所声明一切属性都是静态的
 * 所以我们在创建main函数的时候，将main函数放在伴生对象中
 * 
 * 伴生对象还提供了apply方方法  方便创建或者写复杂的代码
 */
object Person{
  def apply(a:String,b:Int) = {
     new Person(a,b)
  }
  
  def sayName() = {
    println("say name Angelababy")
  }
}

