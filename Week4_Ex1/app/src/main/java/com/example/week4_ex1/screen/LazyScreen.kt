package com.example.week4_ex1.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.week4_ex1.component.CardComponent
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyScreen(navController: NavController) {
    val sampleQuotes = listOf(
        "01 | The only way to do great work is to love what you do. - Steve Jobs",
        "02 | Success is not final, failure is not fatal: it is the courage to continue that counts. - Winston Churchill",
        "03 | Don’t watch the clock; do what it does. Keep going. - Sam Levenson",
        "04 | Believe you can and you’re halfway there. - Theodore Roosevelt",
        "05 | Your time is limited, so don’t waste it living someone else’s life. - Steve Jobs",
        "06 | The future depends on what you do today. - Mahatma Gandhi",
        "07 | If you want to achieve greatness stop asking for permission. - Anonymous",
        "08 | The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
        "09 | Do what you can, with what you have, where you are. - Theodore Roosevelt",
        "10 | I have not failed. I've just found 10,000 ways that won't work. - Thomas Edison",
        "11 | It always seems impossible until it's done. - Nelson Mandela",
        "12 | Everything you’ve ever wanted is on the other side of fear. - George Addair",
        "13 | If you can dream it, you can do it. - Walt Disney",
        "14 | Success usually comes to those who are too busy to be looking for it. - Henry David Thoreau",
        "15 | Hardships often prepare ordinary people for an extraordinary destiny. - C.S. Lewis",
        "16 | Dream big and dare to fail. - Norman Vaughan",
        "17 | It does not matter how slowly you go as long as you do not stop. - Confucius",
        "18 | Whether you think you can or you think you can’t, you’re right. - Henry Ford",
        "19 | Act as if what you do makes a difference. It does. - William James",
        "20 | Start where you are. Use what you have. Do what you can. - Arthur Ashe",
        "21 | The best way to predict the future is to create it. - Peter Drucker",
        "22 | Don’t count the days, make the days count. - Muhammad Ali",
        "23 | Quality means doing it right when no one is looking. - Henry Ford",
        "24 | Be not afraid of life. Believe that life is worth living, and your belief will help create the fact. - William James",
        "25 | Do what you love and you will never work a day in your life. - Confucius",
        "26 | What lies behind us and what lies before us are tiny matters compared to what lies within us. - Ralph Waldo Emerson",
        "27 | Courage is resistance to fear, mastery of fear – not absence of fear. - Mark Twain",
        "28 | Don’t let what you cannot do interfere with what you can do. - John Wooden",
        "29 | We become what we think about. - Earl Nightingale",
        "30 | If you’re going through hell, keep going. - Winston Churchill",
        "31 | Work like hell. I mean you just have to put in 80 to 100 hour weeks every week. - Elon Musk",
        "32 | The only place where success comes before work is in the dictionary. - Vidal Sassoon",
        "33 | Perseverance is not a long race; it is many short races one after the other. - Walter Elliot",
        "34 | A journey of a thousand miles must begin with a single step. - Lao Tzu",
        "35 | What you get by achieving your goals is not as important as what you become by achieving your goals. - Zig Ziglar",
        "36 | Opportunities don’t happen. You create them. - Chris Grosser",
        "37 | Failure will never overtake me if my determination to succeed is strong enough. - Og Mandino",
        "38 | Success is how high you bounce when you hit bottom. - George S. Patton",
        "39 | The way to get started is to quit talking and begin doing. - Walt Disney",
        "40 | You miss 100% of the shots you don’t take. - Wayne Gretzky",
        "41 | Go confidently in the direction of your dreams. Live the life you have imagined. - Henry David Thoreau",
        "42 | Keep your face always toward the sunshine—and shadows will fall behind you. - Walt Whitman",
        "43 | The best revenge is massive success. - Frank Sinatra",
        "44 | The only thing standing between you and your goal is the story you keep telling yourself. - Jordan Belfort",
        "45 | The best preparation for tomorrow is doing your best today. - H. Jackson Brown Jr.",
        "46 | We generate fears while we sit. We overcome them by action. - Dr. Henry Link",
        "47 | You don’t have to be great to start, but you have to start to be great. - Zig Ziglar",
        "48 | Hustle beats talent when talent doesn’t hustle. - Ross Simmonds",
        "49 | If you want something you've never had, you must be willing to do something you've never done. - Thomas Jefferson",
        "50 | When something is important enough, you do it even if the odds are not in your favor. - Elon Musk",
        "51 | Push yourself, because no one else is going to do it for you. - Anonymous",
        "52 | Success is not just about making money. It’s about making a difference. - Unknown",
        "53 | Live as if you were to die tomorrow. Learn as if you were to live forever. - Mahatma Gandhi",
        "54 | You only live once, but if you do it right, once is enough. - Mae West",
        "55 | What we think, we become. - Buddha",
        "56 | If opportunity doesn’t knock, build a door. - Milton Berle",
        "57 | Never give up on a dream just because of the time it will take to accomplish it. The time will pass anyway. - Earl Nightingale",
        "58 | Be yourself; everyone else is already taken. - Oscar Wilde",
        "59 | Success is getting what you want. Happiness is wanting what you get. - Dale Carnegie",
        "60 | Do what you feel in your heart to be right – for you’ll be criticized anyway. - Eleanor Roosevelt",
        "61 | Happiness is not something ready-made. It comes from your own actions. - Dalai Lama",
        "62 | Be the change that you wish to see in the world. - Mahatma Gandhi",
        "63 | The only impossible journey is the one you never begin. - Tony Robbins",
        "64 | Make each day your masterpiece. - John Wooden",
        "65 | It is during our darkest moments that we must focus to see the light. - Aristotle",
        "66 | The secret of getting ahead is getting started. - Mark Twain",
        "67 | You must expect great things of yourself before you can do them. - Michael Jordan",
        "68 | Happiness is not by chance, but by choice. - Jim Rohn",
        "69 | There are no limits to what you can accomplish, except the limits you place on your own thinking. - Brian Tracy",
        "70 | You don’t have to see the whole staircase, just take the first step. - Martin Luther King Jr."
    )

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "LazyColumn",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = Color(0xFF2196F3),
                            fontWeight = FontWeight.W600
                        )
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = Color(0xFF09B4FF),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { navController.popBackStack() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            tint = Color.White,
                            contentDescription = "Localized description",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
            )
        }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(sampleQuotes) { quote ->
                CardComponent(
                    content = quote,
                    onClick = {
                        navController.navigate("detail/$quote")
                    }
                )
            }
        }
    }
}