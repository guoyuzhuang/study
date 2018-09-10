package com.luokeke.scala

object ScalaDemo04_Match {
  
  def main(args: Array[String]): Unit = {
//    match1(2 + "")
    /*{//隐式值
      implicit val name = "luokeke"
      implicit val age = 100
      sayName
      sayName_luokeke
    }*/
    {
      //隐式视图
      implicit def intToString (n : Int) = {n + ""}
      sayName(10)
    }
  }
  
  /**
   * 隐式值
   */
  def sayName(implicit name : String) : Unit = {
    println(name + " 开始说话了")
  }
  
  def sayName_luokeke(implicit name : String, age : Int) : Unit = {
    println(name + " 的年龄为 " + age)
  }
  
  def match1 (x : Any) : Unit = {
    x match {
      case 1 => {println("这个值是1")}
      case x : Int => {println("这个值是Int类型")}
      case _ => {println("这个是最后才匹配到的")}
    }
  }
}