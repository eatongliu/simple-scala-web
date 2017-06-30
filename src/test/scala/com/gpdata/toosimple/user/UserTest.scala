package com.gpdata.toosimple.user

import com.gpdata.toosimple.user.service.UserService
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
  * Created by acer_liuyutong on 2017/6/29.
  * 注解的方法，不能用呢？
  */
//@RunWith(classOf[SpringJUnit4ClassRunner])
//@ContextConfiguration(locations = Array({
//  "classpath:applicationContext.xml"
//}))
class UserTest {

  val ioc = new ClassPathXmlApplicationContext("applicationContext.xml")
  val userService: UserService = classOf[UserService].cast(ioc.getBean("userServiceImpl"))

  @Test
  def testFindOne(): Unit ={
    val user = userService.findOne(0)
    println(user)
  }

  @Test
  def testFindAll(): Unit ={
    val users = userService.findAll()
    users.foreach(println)
  }
}
