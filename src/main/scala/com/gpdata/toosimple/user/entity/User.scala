package com.gpdata.toosimple.user.entity

import java.util.Date

import scala.beans.BeanProperty

/**
  * Created by acer_liuyutong on 2017/6/29.
  */
class User {
  case class User (userId: Long, userName: String)

  @BeanProperty var userId: Long = _
  @BeanProperty var username: String = _
  @BeanProperty var password: String = _
  @BeanProperty var email: String = _
  @BeanProperty var createDate: Date = _

  override def toString = s"User($userId, $username, $password, $email, $createDate)"
}
