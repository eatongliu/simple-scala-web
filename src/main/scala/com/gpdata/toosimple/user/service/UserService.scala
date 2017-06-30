package com.gpdata.toosimple.user.service

import com.gpdata.toosimple.user.entity.User

/**
  * Created by acer_liuyutong on 2017/6/29.
  */
trait UserService {
  def findOne(userId: Long): User
  def findAll(): Array[User]
}
