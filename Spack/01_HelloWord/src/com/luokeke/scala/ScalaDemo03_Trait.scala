package com.luokeke.scala


object ScalaDemo03_Trait {
  def main(args: Array[String]): Unit = {
    var l = new Luokeke()
    l.read("luokeke")
    l.write("luokeke")
  }
}

trait Read {
  var readType = "Read"
  
  //trait自带方法不实现，集成该trait需要实现该方法
  def equle() : Boolean
  val gem = "m"
  def read(name : String) : Unit = {
    println(name + " Reading")
  }
}

trait Write {
  var writeType = "Write"
  val gem = "m"
  def write (name : String) : Unit = {
    println(name + " Writeing")
  }
}

class Luokeke() extends Read with Write {
  override val gem = "f"
  def equle() : Boolean = {
    true
  }
}
object Luokeke {
  def apply() : Unit = {
    new Luokeke()
  }
}