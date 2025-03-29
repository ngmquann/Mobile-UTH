package com.example.week5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week5.ui.theme.Week5Theme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val googleAuthClient = GoogleAuthClient(this)

        setContent {
            Week5Theme {
                var isSignIn by rememberSaveable {
                    mutableStateOf(googleAuthClient.isSignIn())
                }

                var result by remember {
                    mutableStateOf("")
                }

                Box(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
//                    if (isSignIn) {
//                        OutlinedButton(onClick = {
//                            lifecycleScope.launch {
//                                googleAuthClient.signOut()
//                                isSignIn = false
//                            }
//                        }) {
//                            Text(
//                                text = "Sign Out",
//                                fontSize = 16.sp,
//                                modifier = Modifier.padding(
//                                    horizontal = 24.dp, vertical = 4.dp
//                                )
//                            )
//                        }
//                    } else {
//                        ElevatedButton(
//                            onClick = {
//                                lifecycleScope.launch {
//                                    val r = googleAuthClient.signIn()
//                                    if (r) result = "success" else result = "fail"
//                                }
//                            },
//                            colors = ButtonDefaults.elevatedButtonColors(Color(0xff2196F3)),
//                            modifier = Modifier.fillMaxWidth()
//                        ) {
//                            Text(
//                                "Login by Gmail",
//                                style = TextStyle(
//                                    fontWeight = FontWeight.W700,
//                                    fontSize = 22.sp,
//                                    color = Color.White
//                                )
//                            )
//                        }
//                        if (result == "fail") {
//                            Box(
//                                modifier = Modifier
//                                    .padding(16.dp)
//                                    .background(Color(0xffEB9797), RoundedCornerShape(10.dp)),
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Column(
//                                    modifier = Modifier.padding(1.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//                                ) {
//                                    Text(
//                                        "Google Sign-In Failed",
//                                        style = TextStyle(
//                                            fontWeight = FontWeight.W700,
//                                            fontSize = 20.sp,
//                                        ),
//                                    )
//                                    Text(
//                                        "User canceled the Google sign-in process.",
//                                        style = TextStyle(
//                                            fontWeight = FontWeight.W400,
//                                            fontSize = 20.sp,
//                                            textAlign = TextAlign.Center
//                                        ),
//                                    )
//                                }
//                            }
//                        } else if (result == "success") {
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(16.dp)
//                                    .background(Color(0xff4AABD2), RoundedCornerShape(10.dp)),
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Column(
//                                    modifier = Modifier.padding(1.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally
//                                ) {
//                                    Text(
//                                        "Success!",
//                                        style = TextStyle(
//                                            fontWeight = FontWeight.W700,
//                                            fontSize = 20.sp,
//                                        ),
//                                    )
//                                    Text(
//                                        "Hi sample@gmail.com",
//                                        style = TextStyle(
//                                            fontWeight = FontWeight.W700,
//                                            fontSize = 20.sp,
//                                        ),
//                                    )
//                                    Text(
//                                        "Welcome to UTHSmartTasks",
//                                        style = TextStyle(
//                                            fontWeight = FontWeight.W400,
//                                            fontSize = 20.sp,
//                                            textAlign = TextAlign.Center
//                                        ),
//                                    )
//                                }
//                            }
//                        }
//                    }
                    Column {
                        ElevatedButton(
                            onClick = {
                                lifecycleScope.launch {
                                    val r = googleAuthClient.signIn()
                                    if (r) result = "success" else result = "fail"
                                }
                            },
                            colors = ButtonDefaults.elevatedButtonColors(Color(0xff2196F3)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "Login by Gmail",
                                style = TextStyle(
                                    fontWeight = FontWeight.W700,
                                    fontSize = 22.sp,
                                    color = Color.White
                                )
                            )
                        }
                        if (result == "fail") {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(Color(0xffEB9797), RoundedCornerShape(10.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "Google Sign-In Failed",
                                        style = TextStyle(
                                            fontWeight = FontWeight.W700,
                                            fontSize = 20.sp,
                                        ),
                                    )
                                    Text(
                                        "User canceled the Google sign-in process.",
                                        style = TextStyle(
                                            fontWeight = FontWeight.W400,
                                            fontSize = 20.sp,
                                            textAlign = TextAlign.Center
                                        ),
                                    )
                                }
                            }
                        } else if (result == "success") {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .background(Color(0xff4AABD2), RoundedCornerShape(10.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "Success!",
                                        style = TextStyle(
                                            fontWeight = FontWeight.W700,
                                            fontSize = 20.sp,
                                        ),
                                    )
                                    Text(
                                        "Hi sample@gmail.com",
                                        style = TextStyle(
                                            fontWeight = FontWeight.W700,
                                            fontSize = 20.sp,
                                        ),
                                    )
                                    Text(
                                        "Welcome to UTHSmartTasks",
                                        style = TextStyle(
                                            fontWeight = FontWeight.W400,
                                            fontSize = 20.sp,
                                            textAlign = TextAlign.Center
                                        ),
                                    )
                                }
                            }
                        }
                    }

                }



//                Column(
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(20.dp),
//                ) {
//
//
//                }
            }
        }
    }
}

//class AuthenticationManager(
//    private val context: Context
//) {
//    private val auth = Firebase.auth
//
//    private fun createNonce(): String {
//        val rawNonce = UUID.randomUUID().toString()
//        val bytes = rawNonce.toByteArray()
//        val md = MessageDigest.getInstance("SHA-256")
//        val digest = md.digest(bytes)
//
//        return digest.fold("") { str, it ->
//            str + "%02x".format(it)
//        }
//    }
//
//    fun signInWithGoogle(): Flow<AuthResponse> = callbackFlow {
//        var googleOption = GetGoogleIdOption.Builder()
//            .setFilterByAuthorizedAccounts(true)
//            .setServerClientId(context.getString(R.string.web_client_id))
//            .setAutoSelectEnabled(false)
//            .setNonce(createNonce())
//            .build()
//
//        val request = GetCredentialRequest.Builder()
//            .addCredentialOption(googleOption)
//            .build()
//
//        try {
//            val credentialManager = CredentialManager.create(context)
//            val result = credentialManager.getCredential(
//                context = context,
//                request = request
//            )
//
//            val credential = result.credential
//            if (credential is CustomCredential) {
//                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
//                    try {
//                        val googleIdTokenCredential = GoogleIdTokenCredential
//                            .createFrom(credential.data)
//
//                        // Sign in to firebase
//                        val firebaseCredential =
//                            GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)
//                        auth.signInWithCredential(firebaseCredential)
//                            .addOnCompleteListener { task ->
//                                if (task.isSuccessful) {
//                                    trySend(AuthResponse.Success).isSuccess
//                                } else {
//                                    trySend(AuthResponse.Error(errorMessage = task.exception?.message)).isFailure
//                                }
//                            }
//                    } catch (e: GoogleIdTokenParsingException) {
//                        trySend(AuthResponse.Error(errorMessage = e.message)).isFailure
//                    }
//                } else {
//                    // Catch any unrecognized custom credential type here.
//                    trySend(AuthResponse.Error(errorMessage = "Unexpected type of credential")).isFailure
//                }
//            }
//        } catch (e: Exception) {
//            trySend(AuthResponse.Error(errorMessage = e.message)).isFailure
//        }
//    }
//    fun createIntent(onSuccess: (IntentSenderRequest) -> Unit) {
//        // Creating the request
//        val request = GetSignInIntentRequest.builder()
//            .setServerClientId(context.getString(R.string.web_client_id))
//            .build()
//
//        // Gathering the SignInIntent
//        Identity.getSignInClient(context)
//            .getSignInIntent(request)
//            .addOnSuccessListener { result: PendingIntent ->
//                // Handling the response
//                try {
//                    onSuccess(
//                        IntentSenderRequest.Builder(
//                            result.intentSender
//                        ).build()
//                    )
//
//                } catch (e: IntentSender.SendIntentException) {
//                    Log.e("Google Sign-in", "failed")
//                }
//            }
//            .addOnFailureListener { exception: Exception? ->
//                exception?.message?.let { Log.e("Google Sign-in failed", it) }
//            }
//    }
//}
//
//interface AuthResponse {
//    data object Success : AuthResponse
//    data class Error(val errorMessage: String?) : AuthResponse
//}

//@Composable
//fun Greeting(modifier: Modifier = Modifier) {
//
//    var isSignIn by rememberSaveable {
//        mutableStateOf(googleAuthClient.isSignIn())
//    }
//
//    var result = ""
//
//    if (isSignIn) {
//        OutlinedButton(onClick = {
//            lifecycleScope.launch {
//                googleAuthClient.signOut()
//                isSignIn = false
//            }
//        }) {
//            Text(
//                text = "Sign Out",
//                fontSize = 16.sp,
//                modifier = Modifier.padding(
//                    horizontal = 24.dp, vertical = 4.dp
//                )
//            )
//        }
//    }
//
//    Column(
//        verticalArrangement = Arrangement.Center,
//        modifier = modifier
//            .fillMaxSize()
//            .padding(20.dp),
//    ) {
//        ElevatedButton(
//            onClick = {
//            },
//            colors = ButtonDefaults.elevatedButtonColors(Color(0xff2196F3)),
//            modifier = modifier.fillMaxWidth()
//        ) {
//            Text(
//                "Login by Gmail",
//                style = TextStyle(
//                    fontWeight = FontWeight.W700,
//                    fontSize = 22.sp,
//                    color = Color.White
//                )
//            )
//        }
//        if (result == "fail") {
//            Box(
//                modifier = modifier
//                    .padding(16.dp)
//                    .background(Color(0xffEB9797), RoundedCornerShape(10.dp)),
//                contentAlignment = Alignment.Center
//            ) {
//                Column(
//                    modifier = modifier.padding(1.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        "Google Sign-In Failed",
//                        style = TextStyle(
//                            fontWeight = FontWeight.W700,
//                            fontSize = 20.sp,
//                        ),
//                    )
//                    Text(
//                        "User canceled the Google sign-in process.",
//                        style = TextStyle(
//                            fontWeight = FontWeight.W400,
//                            fontSize = 20.sp,
//                            textAlign = TextAlign.Center
//                        ),
//                    )
//                }
//            }
//        } else if (result == "success") {
//            Box(
//                modifier = modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//                    .background(Color(0xff4AABD2), RoundedCornerShape(10.dp)),
//                contentAlignment = Alignment.Center
//            ) {
//                Column(
//                    modifier = modifier.padding(1.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        "Success!",
//                        style = TextStyle(
//                            fontWeight = FontWeight.W700,
//                            fontSize = 20.sp,
//                        ),
//                    )
//                    Text(
//                        "Hi sample@gmail.com",
//                        style = TextStyle(
//                            fontWeight = FontWeight.W700,
//                            fontSize = 20.sp,
//                        ),
//                    )
//                    Text(
//                        "Welcome to UTHSmartTasks",
//                        style = TextStyle(
//                            fontWeight = FontWeight.W400,
//                            fontSize = 20.sp,
//                            textAlign = TextAlign.Center
//                        ),
//                    )
//                }
//            }
//        }
//
//    }
//}