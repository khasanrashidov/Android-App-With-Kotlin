package com.example.myapplicationformp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationformp.ui.theme.MyApplicationForMPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationForMPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

//@Composable
//fun MyApp() {
//    MaterialTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Column(
//                modifier = Modifier.padding(8.dp)
//            ) {
//                NameCard()
//                Spacer(modifier = Modifier.padding(16.dp))
//                ListOfSkills()
//            }
//
//
//        }
//    }
//}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { Home(navController) }
                    composable("about") { About(navController) }
                }
                Spacer(modifier = Modifier.weight(1f)) // Pushes the navigation buttons to the bottom
                NavigationBar(navController = navController)
            }
        }
    }
}

@Composable
fun NavigationBar(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        NavigationButton("Home") {
            navController.navigate("home")
        }
        Spacer(modifier = Modifier.width(16.dp))
        NavigationButton("About Me") {
            navController.navigate("about")
        }
    }
}

@Composable
fun NavigationButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6C757D),
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun Home(navController: NavHostController) {
    NameCard()
}

@Composable
fun About(navController: NavHostController) {
    Column {
        Text(
            text = "Hey there! My name is Khasan Rashidov, and I'm passionate about all things software engineering. Currently, I'm pursuing my degree in Computer Science while also diving deep into the world of coding and development.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "As a software engineer, I thrive on the challenge of turning ideas into reality through elegant and efficient code. With a keen interest in various programming languages and technologies, I am proficient in Kotlin, Python, C, C++, C#, TypeScript, and more.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "In addition to my technical skills, I am dedicated to continuous learning and growth, always seeking new opportunities to expand my knowledge and refine my craft. Whether it's developing applications, optimizing algorithms, or solving complex problems, I'm always up for the challenge.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Feel free to reach out to me via email at k.rashidov2@student.inha.uz or give me a call at +998 90 675 60 75. Let's connect and explore the exciting possibilities in the world of software engineering together!",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }

}


@Composable
fun NameCard() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    var profileName by rememberSaveable { mutableStateOf("Khasan Rashidov") }
    var profileSpecialty by rememberSaveable { mutableStateOf("Software Engineer") }
    var profileID by rememberSaveable { mutableStateOf("ID: U2010223") }
    var profileEmail by rememberSaveable { mutableStateOf("Email: k.rashidov2@student.inha.uz") }
    var profilePhone by rememberSaveable { mutableStateOf("Phone: +998 90 675 60 75") }
    var profilePhoto by rememberSaveable {
        mutableIntStateOf(
            R.drawable.myprofilephoto
        )
    }

    Surface(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFF8F9FA),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = profilePhoto),
                    contentDescription = "My Profile Picture",
                    modifier = Modifier
                        .size(116.dp)
                        .padding(16.dp)
                        .clip(CircleShape)
                        .border(2.dp, color, CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(CenterVertically)
                ) {
                    Text(
                        text = profileName,
                        style = MaterialTheme.typography.headlineSmall,
                        color = color
                    )
                    Text(
                        text = profileSpecialty,
                        style = MaterialTheme.typography.bodyMedium,
                        color = color
                    )
                    Text(
                        text = profileID,
                        style = MaterialTheme.typography.bodyMedium,
                        color = color
                    )
                }
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = profileEmail, style = MaterialTheme.typography.bodyLarge)
                Text(text = profilePhone, style = MaterialTheme.typography.bodyLarge)
            }

            Button(
                onClick = {
                    profileName = profileName.reversed()
                },
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6C757D),
                    contentColor = Color.White
                )
            )
            {
                Text(text = "Reverse Name")
            }

            var photoChanged by remember { mutableStateOf(false) }
            Button(
                onClick = {
                    profilePhoto = if (photoChanged) {
                        R.drawable.myprofilephoto
                    } else {
                        R.drawable.myprofilephoto2
                    }
                    photoChanged = !photoChanged
                },
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6C757D),
                    contentColor = Color.White
                )
            )
            {
                Text(text = "Change Photo")
            }
        }
    }
}

@Composable
fun ListOfSkills() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    var skills by remember {
        mutableStateOf(
            listOf(
                "Kotlin",
                "Python",
                "C",
                "C++",
                "C#",
                "TypeScript",
                "HTML, CSS, JavaScript",
                "MS SQL Server",
                "MySQL",
                "SQLite",
                "PostgreSQL"
            )
        )
    }

    Column {
        Text(
            text = "Skills",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
        ) {
            items(skills) { item ->
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp,
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyApp()
}
