package com.gpdata.toosimple.user.service.impl

import com.gpdata.toosimple.user.entity.User
import com.gpdata.toosimple.user.mapper.UserMapper
import com.gpdata.toosimple.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by acer_liuyutong on 2017/6/29.
  */
@Service
class UserServiceImpl @Autowired() (userMapper: UserMapper) extends UserService{

  override def findOne(userId: Long): User = userMapper.getOne(userId)

  override def findAll(): Array[User] = userMapper.getAll
}
