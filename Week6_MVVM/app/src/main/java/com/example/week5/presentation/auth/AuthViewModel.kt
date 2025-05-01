package com.example.week5.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5.data.model.AuthResult
import com.example.week5.domain.model.User
import com.example.week5.domain.usecase.GetCurrentUserUseCase
import com.example.week5.domain.usecase.GoogleSignInUsecase
import com.example.week5.domain.usecase.SignOutUsecase
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val googleSignInUsecase: GoogleSignInUsecase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val signOutUsecase: SignOutUsecase,
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    var authState: StateFlow<AuthState> = _authState

    init {
        getCurrentUser()
    }

    private fun getCurrentUser(){
        val user = getCurrentUserUseCase()
        if (user != null){
            _authState.value = AuthState.Authenticated(user)
        } else {
            _authState.value = AuthState.Unauthenticated
        }
    }

    fun signInGoogle(account: GoogleSignInAccount){
        _authState.value = AuthState.Loading

        viewModelScope.launch {
            when(val result = googleSignInUsecase(account)){
                is AuthResult.Success -> {
                    var user = User(
                        uid = result.user.uid,
                        name = result.user.name,
                        email = result.user.email,
                        photoUrl = result.user.photoUrl
                    )
                    _authState.value = AuthState.Authenticated(user)
                }
                is AuthResult.Error -> {
                    _authState.value = AuthState.Error(result.message)
                }
                is AuthResult.Canceled -> {
                    _authState.value = AuthState.Canceled
                }
                AuthResult.Loading -> {
                    _authState.value = AuthState.Loading
                }
            }
        }
    }

    fun signOut(){
        _authState.value = AuthState.Loading
        signOutUsecase()
        _authState.value = AuthState.Unauthenticated
    }
}