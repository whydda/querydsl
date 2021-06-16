package jpa.querydsl.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import jpa.querydsl.entity.QUser
import jpa.querydsl.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import javax.annotation.Resource

interface UserRepository : JpaRepository<User, String> {
    fun findByEmail(email: String): User?
}

@Repository
class UserRepositorySupport(

    @Resource(name = "jpaQueryFactory")
    val query: JPAQueryFactory

) : QuerydslRepositorySupport(User::class.java) {

    fun findByEmail(email: String): User? {
        return query.selectFrom(QUser.user)
            .where(QUser.user.email.eq(email))
            .fetchOne()
    }

}