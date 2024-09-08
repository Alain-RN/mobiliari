package mada.alain.mobiliari.db

class UserRepository(private val userDao: UserDao) {
    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun deleteUserById(id: Int) {
        userDao.deleteUserById(id)
    }
}
