package com.gpdata.toosimple.user.mapper

import com.gpdata.toosimple.user.entity.User

/**
  * Created by acer_liuyutong on 2017/6/29.
  */
trait UserMapper {
  def getOne(userId: Long): User
  def getAll: Array[User]
}
