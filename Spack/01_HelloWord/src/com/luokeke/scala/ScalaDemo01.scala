package com.luokeke.scala;

object ScalaDemo01 {
  def main(args : Array[String]) : Unit = {
    println("测试一下新方法")
    var a = 10
    a = 12
    val b = 99
    val p1 = new Person("luokeke", 100)
    println("p1的名称为：" + p1.name)
    println("p1的年龄为：" + p1.age)
    
    val p2 = new Person("luokeke", "张三李四", 100)
    println("p1的名称为：" + p1.name)
    p2.sayLove()
    Person.sayName()
  }
}
class Person(var n : String, var a : Int) {
  val name = n
  var age = a
  
  def this(a:String, b:String, c:Int) = {
    this(a, c);
    println("新写的重构方法")
  }
  
  def sayLove() = {
    println("system love method：" + name)
  }
}

/**
 * object Person是peroson类的伴生对象，在这个对象中所声明一切属性都是静态的
 * 所以我们在创建main函数的时候，将main函数放在伴生对象中
 * 
 * 伴生对象还提供了apply方方法  方便创建或者写复杂的代码
 */
object Person {
  def apply(a:String, b:Int) = {
    new Person(a, b)
  }
  
  def sayName() = {
    println("say name Angelababy ")
  }
}