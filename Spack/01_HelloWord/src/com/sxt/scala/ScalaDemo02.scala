package com.bjsxt.scala

object ScalaDemo02 {
  def main(args: Array[String]): Unit = {
    /**
     * 判断体 if else
     */
   var age = 20
   if(age > 20){
     println("可以看欧美的")
   }else if(age > 18){
     println("可以看国产的")
   }else{
     println("禁止观看")
   }
   
   /**
    *循环   
    * 	while：先判断 后循环
    * 	do while：不管三七二十一，先执行循环体的内容
    */
   var count = 1
   while(count < 102){
     println("第" + count + "次求婚！！！")
     count += 1
   }
   
   do{
     count -= 1
     println("第" + count + "次求婚！！！")
   }while(count >= 2)
   
   
    /**
     * 循环  for循环
     */
//   to和until 的用法
     println(1 to 10)
     println(1.to(10,2))
     
     println(1 until 10)
     println(1.until(10,3))
    
     //统计1 - 100的和
     var sum = 0
     for(elem <- 1 to 100){
       sum += elem
     }
     println(sum)
     
     //统计50以内所有偶数的和
     sum = 0
     for(elem <- 1 to 100;if elem % 2 == 0 && elem < 50){
       sum += elem
     }
     println(sum)
     
     /**
      * 多层for循环
      */
     //打印九九乘法表
     for(i <- 1 until 10){
       for(j <- 1 to 9){
         if(j <= i){
           print(j + "*" + i + "=" + i*j + "\t")
         }
         if(j == i){
           println()
         }
         
       }
     }
     
     
     for(i <- 1 to 9 ; j <- 1 to i){
       print(j + "*" + i + "=" + i*j + "\t")
       if(j == i)
         println()
     }
     
     
     /*
      * 将1 - 100的偶数放在一个集合中保存
      * yield就是将符合条件的元素封装到一个集合中
      * oss集合
      */
     val oss = for(i <- 1 to 100;if i % 2 == 0 ) yield i
     for(elem <- oss){
       println(elem)
     }
     
     
     
     /**
      * Scala函数
      * 声明一个函数使用的def funName(funArgs:Type) : Unit（函数的返回值类型） = {函数体}
      * 
      * 在方法体的最后一行语句的执行结果就是这个函数的返回值，不需要显示使用return去返回
      * 
      * 
      */
     
//     unit
     def add(num1:Int,num2:Int)  {
       num1+num2
     }
     
     val addVal = add(1,2)
     println(addVal)
     
     
     /**
      * 递归函数：
      * 	在函数体又调用了自己本身
      *  计算10的阶乘
      *  10 * 9 * ...* 1
      *  
      *  
      *  为什么递归函数必须声明函数的返回值类型呢？
      */
     
     def fun(num:Int):Int = {
       if(num == 1)
         num
       else{
         num * fun(num -1)
       }
     }
     
     println(fun(5))
     
     /**
      * 包含参数默认值的函数
      * fun3函数有两个参数 
      * 	n1:默认值
      * 	n2:需要用户传入的
      */
     def fun3(n1:Int=10,n2:Int) = {
       n1 + n2
     }
//     fun3(100)
     println(fun3(n2 = 100))
     println(fun3(100,20))
     
     
  }
}












