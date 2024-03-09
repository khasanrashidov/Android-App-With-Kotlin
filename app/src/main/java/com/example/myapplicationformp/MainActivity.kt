package com.example.myapplicationformp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun MyApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                NameCard()
                Spacer(modifier = Modifier.padding(16.dp))
                ListOfSkills()
            }


        }
    }
}

@Composable
fun NameCard() {
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
                        .border(2.dp, Color(0xFF6C757D), CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(CenterVertically)
                ) {
                    Text(text = profileName, style = MaterialTheme.typography.headlineSmall)
                    Text(text = profileSpecialty, style = MaterialTheme.typography.bodyMedium)
                    Text(text = profileID, style = MaterialTheme.typography.bodyMedium)
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
                    if (photoChanged) {
                        profilePhoto = R.drawable.myprofilephoto
                    } else {
                        profilePhoto = R.drawable.myprofilephoto2
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
                        bottom = 8.dp
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
