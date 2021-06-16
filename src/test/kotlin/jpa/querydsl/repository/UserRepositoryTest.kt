package jpa.querydsl.repository;

import jpa.querydsl.entity.User
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userRepositorySupport: UserRepositorySupport

    @Before("")
    fun setup() {
        userRepository.save(User(id = "whydda", name = "Byeon", email = "whydda@a.com"))
    }

    @After("")
    private fun tearDown() {
        userRepository.deleteAll()
    }

    @Test
    fun findByEmailTest() {
        val user = userRepository.findByEmail("whydda@a.com")
        println(user)
        Assertions.assertEquals("whydda", user?.id)
    }

    @Test
    fun findByEmailWithQuerydslTest() {
        val user = userRepositorySupport.findByEmail("whydda@a.com")
        println(user)
        Assertions.assertEquals("whydda", user?.id)
    }
}