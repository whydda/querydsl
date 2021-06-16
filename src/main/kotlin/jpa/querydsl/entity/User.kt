package jpa.querydsl.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(

    @Id
    val id: String,
    val password: String = "password",
    val name: String,
    val mobile: String? = null,
    val email: String? = null

)