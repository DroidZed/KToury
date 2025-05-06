package tn.droidzed.ktoury.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tn.droidzed.ktoury.entities.User
import tn.droidzed.ktoury.repo.UserRepo

@Service
class UserServiceImpl @Autowired constructor(private val repo: UserRepo) : UserService {

    override fun getUserById(id: Long): User? = repo.findById(id).orElse(null)

    override fun createUser(user: User): User = repo.save(user)

    override fun deleteUserById(id: Long) = repo.deleteById(id)

    override fun updateUserById(id: Long, user: User): User? = if (!repo.existsById(id)) null
    else repo.save(user)
}
