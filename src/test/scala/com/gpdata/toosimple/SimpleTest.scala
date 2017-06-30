package com.gpdata.toosimple

import org.junit.Test
import com.gpdata.toosimple.user.entity.User
import com.gpdata.toosimple.utils.JsonUtil


class SimpleTest {
  @Test
  def test1(): Unit ={
    val user = new User
    user.setCreateDate(new java.util.Date())
    val string = JsonUtil.toJsonString(user)
    println(string)
  }

  @Test
  def test2(): Unit ={
    val man = new User()
    man.userId = 1
    man.username = "lyt"
    println(JsonUtil.toJsonString(man))
  }

  @Test
  def test3(): Unit ={

  }
}
