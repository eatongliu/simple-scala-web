package com.gpdata.toosimple.user.controller

import com.gpdata.toosimple.user.service.UserService
import com.gpdata.toosimple.utils.BeanResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod, RestController}

/**
  * Created by acer_liuyutong on 2017/6/29.
  */
@RestController
@RequestMapping(value = Array("/user"))
class UserController @Autowired() (userService: UserService) {

  @RequestMapping(value = Array("/{userId}"),
    method = Array(RequestMethod.GET),
    produces = Array(MediaType.APPLICATION_JSON_UTF8_VALUE))
  def findOne(@PathVariable userId: Long): BeanResult ={
    try {

      BeanResult.success(userService.findOne(userId))
    } catch {
      case _: Exception => BeanResult.error("查询异常！")
    }
  }

  @RequestMapping(value = Array("/"),
    method = Array(RequestMethod.GET),
    produces = Array(MediaType.APPLICATION_JSON_UTF8_VALUE))
  def findAll(): BeanResult ={
    try {
      BeanResult.success(userService.findAll())
    } catch {
      case _: Exception => BeanResult.error("查询异常！")
    }
  }

}
