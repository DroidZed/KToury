package tn.droidzed.ktoury.services

import tn.droidzed.ktoury.entities.User

interface UserService {

    fun getUserById(id: Long) : User?
    fun createUser(user: User) : User
    fun deleteUserById(id: Long)
    fun updateUserById(id: Long, user: User) : User?
}
