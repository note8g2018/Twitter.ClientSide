package com.coolme.me.twitterclientside

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolme.me.twitterclientside.dataLayer.model.Screen
import com.coolme.me.twitterclientside.dataLayer.model.UserRealm
import com.coolme.me.twitterclientside.dataLayer.userInterface.UserLDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavHostShoVM @Inject constructor(
    private val userLDB: UserLDB,
                                      ) : ViewModel()
{
    var isLoading by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Screen.Login.route)
        private set

    init
    {
        viewModelScope.launch {
            val userRealm : UserRealm? = userLDB.getUserRealm()
            if(userRealm != null)
            {
                if(userRealm.isLogin)
                {
                    startDestination = Screen.Wall.route
                }
            }
            isLoading = false
        }
    }
}