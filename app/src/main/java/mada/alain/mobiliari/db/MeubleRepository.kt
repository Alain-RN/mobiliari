package mada.alain.mobiliari.db
class MeubleRepository(private val meubleDao: MeubleDao) {

    suspend fun insertMeuble(meuble: Meuble) {
        meubleDao.insertMeuble(meuble)
    }

    suspend fun getAllMeubles(): List<Meuble> {
        return meubleDao.getAllMeubles()
    }

    suspend fun getMeubleById(id: Int): Meuble? {
        return meubleDao.getMeubleById(id)
    }

    suspend fun deleteMeuble(id : Int) {
        meubleDao.deleteMeuble(id)
    }
}
