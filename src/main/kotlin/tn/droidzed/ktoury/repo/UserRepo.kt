package tn.droidzed.ktoury.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tn.droidzed.ktoury.entities.User

@Repository
interface UserRepo : JpaRepository<User, Long>
