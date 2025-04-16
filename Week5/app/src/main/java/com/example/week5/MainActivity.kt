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
import androidx.compose.material3.Button
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

                var name by remember {
                    mutableStateOf("")
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
                    Column {
                        ElevatedButton(
                            onClick = {
                                lifecycleScope.launch {
                                    val r = googleAuthClient.signIn()
                                    if (r) {
                                        result = "success"
                                        name = googleAuthClient.getName().toString()
                                    } else {
                                        result = "fail"
                                    }
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
                                        "Hi $name",
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

                                    ElevatedButton(
                                        onClick = {
                                            lifecycleScope.launch {
                                                googleAuthClient.signOut()
                                                result = ""
                                                name = ""
                                            }
                                        },
                                        colors = ButtonDefaults.elevatedButtonColors(Color.Red),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            "Logout",
                                            style = TextStyle(
                                                fontWeight = FontWeight.W700,
                                                fontSize = 22.sp,
                                                color = Color.White
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}