package mada.alain.mobiliari.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Query("DELETE FROM user WHERE id = :id")
    suspend fun deleteUserById(id: Int)
}

