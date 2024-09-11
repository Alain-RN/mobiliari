package mada.alain.mobiliari.db

import androidx.room.*

@Dao
interface MeubleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeuble(meuble: Meuble)

    @Query("DELETE FROM meuble_table WHERE nomID = :id")
    suspend fun deleteMeuble(id: Int)

    @Query("SELECT * FROM meuble_table")
    suspend fun getAllMeubles(): List<Meuble>

    @Query("SELECT * FROM meuble_table WHERE nomID = :id")
    suspend fun getMeubleById(id: Int): Meuble?
}
