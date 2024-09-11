package mada.alain.mobiliari.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meuble_table")
data class Meuble(
    @PrimaryKey(autoGenerate = true)
    val nomID: Int = 0,
    val nomMeuble: String,
    val prix: Double,
    val description: String,
    val hauteur: Double,
    val largeur: Double,
    val imageUri : String,
    val modele3DUri : String,
)
