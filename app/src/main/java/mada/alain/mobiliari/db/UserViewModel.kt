package mada.alain.mobiliari.db

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    data class tmpUser(val email: String, val password: String)
    var username : String = ""

    // Ajouter un utilisateur
    fun addUser(username: String, email: String, password: String) {

        if(username.isBlank() || email.isBlank() || password.isBlank()) {
            return
        }

        viewModelScope.launch {
            val userList = repository.getAllUsers()

            val usersName = userList.map { it.username }

            val user = User(username = username, email = email, password = password)
            // Mettre en rouge le champ Username et Email si existe deja
            if(!usersName.contains(user.username)) {
                repository.insert(user)
            }
        }
    }

    // Authentication
    var textOuv = mutableStateOf(false)
    fun logIn(email: String, password: String) {
        viewModelScope.launch {

            val userList = repository.getAllUsers()
            val usersEmail = userList.map { it.email }

            val tmpUser = tmpUser(email = email, password = password)

            // Mettre en rouge le champ Username et Email si existe deja
            if(usersEmail.contains(tmpUser.email)){

                val tmpIndex = usersEmail.indexOf(tmpUser.email)

                if(userList[tmpIndex].password == tmpUser.password){
                    textOuv.value = true
                    username = userList[tmpIndex].username
                }else{
                    textOuv.value = false
                }
            }
            // Si l'email n'existe pas
        }
    }
    // supprimer user
    fun deleteUser(id : Int) {
        viewModelScope.launch {
            repository.deleteUserById(id)

            val userList = repository.getAllUsers()
            _users.value = userList // Met à jour la liste des utilisateurs
        }
    }

    // All User
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users

    fun getAllUsers() {
        viewModelScope.launch {
            val userList = repository.getAllUsers()
            _users.value = userList // Met à jour la liste des utilisateurs
        }
    }
}
