package com.bjsxt.scala

import java.util.Date

object ScalaDemo03 {
  
  def main(args: Array[String]): Unit = {
    //如果在调用函数的时候，全部参数值全部传入，此时默认值会被覆盖
    fun1(200,200)
    //如果想使用函数的默认值，那么在调用函数的时候，参数的个数要小于指定的个数，并且得指定参数名
    println(fun1(num2 = 1000))
    
    println(addMore(1,2,3,4,5,6,7,8))
    fun()
    println(strConcat("hello " , "bjsxt"))
    println(foo(5))
    println(fun5(5))
    
    
    val date = new Date()
     log(date,"log1")
     log(date,"log2")
     log(date,"log3")
     log(date,"log4")
     log(date,"log5")
     
     //_:占位符
     val logWithDate = log(date,_:String)
     logWithDate("log1")
     logWithDate("log2")
     logWithDate("log3")
     logWithDate("log4")
     logWithDate("log5")
     
     println(fun6(funTmp,100))
     
     println(fun6((num:Int)=>num * 900,100))
     
     println(fun7( (num1:Int,num2:Int) => num1 + num2 ) )
     
     println(fun8(100)(100,200))
     
     println(fun9((num1:Int,num2:Int)=>num1+num2)(100,200))
  }
 
  
  /**
   * 含有默认值的函数
   */
  def fun1(num1:Int=100,num2:Int):Int = {
    num1 + num2  
  }
  
  /**
   * 可变参数个数的函数
   * String...  strs
   * 用户在调用addMore函数的时候，传入的参数都被封装到nums这个对象中
   */
   def addMore(nums:Int*) = {
     var sum = 0
     for(elem <- nums){
       sum += elem
     }
     sum
   }
   
   /**
    * 匿名函数
    * 	：没有名字的函数
    */
  val fun = ()=>{
                  println("I Love Angelababy")
                }
  
  //有参数匿名函数  匿名函数是无法显示的制定返回值类型的
  val strConcat = (str1:String,str2:String) => {
     str1 + "~" + str2 
  }
  
  /**
   * 递归函数  函数体内有调用了自己本身
   */
  //使用递归函数 求解10的阶乘    10 * 9 * 8 * 7 *...* 1
  
  def foo(num:Int):Int = {
    if(num == 1) num
    else num * foo(num -1)
  }
  
  
  /**
   * 嵌套函数
   * 	函数内有函数
   */
   def fun5(num:Int)={
      def fun6(a:Int,b:Int):Int={
        if(a == 1){
          b
        }else{
          fun6(a-1,a*b)
        }
      }
      fun6(num,1)
    }
   
   /**
    * 偏应用函数：偏应用函数是一种表达式，不需要提供函数需要的所有参数，只需要提供部分或不提供所需参数
    */
   def log(date:Date,msg:String) = {
     println(date + "-" + msg)
   }
   
   
   /**
    * 高阶函数：
    * 	1、函数的参数是函数  fun1(fun2)   面向函数编程
    * 	2、函数的返回是函数
    */
   
   /**
    * fun6函数的参数有两个
    * 	第一个参数：函数   函数的格式是 只有一个参数并且返回值是Int
    * 	第二个参数：Int类型的值
    * Int => Int表示的是 第一个参数(函数)的格式
    */
   def fun6(ff:Int => Int,num:Int):Int = {
     ff(num)
   }
   
   def funTmp(num:Int) : Int = {
     num * 100
   }
   
   
   //(Int,Int)=>Int
   def fun7(fff:(Int,Int)=>Int):Int = {
     fff(100,100)
   }
   
   
   /**
    * 返回值是函数（函数参数有个，函数返回值是Int）
    */
   def fun8(num:Int):(Int,Int)=>Int = {
     def funT(num1:Int,num2:Int) = {
       num1+num2+num
     }
     funT
   }
   
   /**
    * fun9函数的参数以及返回都是函数
    */
   def fun9(fun:(Int,Int)=>Int):(Int,Int)=>Int = {
     fun
   }
   
    
}


