package mada.alain.mobiliari.db

import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MeubleViewModel(private val repository: MeubleRepository) : ViewModel() {

    private val _meubles = MutableStateFlow<List<Meuble>>(emptyList())
    val meubles : StateFlow<List<Meuble>> get() = _meubles
    fun getAllMeubles() {
        viewModelScope.launch {
            val userList = repository.getAllMeubles()
            _meubles.value = userList // Met à jour la liste des utilisateurs
        }
    }

    fun insert(meuble: Meuble) = viewModelScope.launch {
        repository.insertMeuble(meuble)
    }

    private val _meuble = MutableLiveData<Meuble?>()
    val meuble: LiveData<Meuble?> = _meuble
    fun getMeuble(id: Int){
        viewModelScope.launch {
            val meubleResult = repository.getMeubleById(id)

            _meuble.postValue(meubleResult)
        }
    }

    fun delete(id : Int) = viewModelScope.launch {
        repository.deleteMeuble(id)
        val meubleList = repository.getAllMeubles()
        _meubles.value = meubleList// Met à jour la liste des utilisateurs
    }
}
