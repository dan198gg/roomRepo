package com.example.myroomproject

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myroomproject.ui.theme.MyRoomProjectTheme

class UserViewModelFactory(val application: Application):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(application) as T
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val owner=LocalViewModelStoreOwner.current

            owner?.let {
                VMSO->
                val userViewModel1:UserViewModel= viewModel(VMSO,"UserViewModel",UserViewModelFactory(
                    LocalContext.current.applicationContext as Application))
                Main(userViewModel1)
            }
        }
    }
}
@Preview
@Composable
fun Main(vm:UserViewModel= viewModel()){
        val userList by vm.userList.observeAsState()
    Column(modifier = Modifier.fillMaxSize()) {
       OutlinedTextField(vm.userName, onValueChange = {vm.changeName(it)}, modifier = Modifier.padding(5.dp))
       OutlinedTextField(value = vm.userAge.toString(), onValueChange = {vm.changeAge(it)}, modifier = Modifier.padding(5.dp).offset(5.dp,0.dp))
    }
}