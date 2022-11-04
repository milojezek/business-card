package eu.milo4apps.mybusinesscard

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.milo4apps.mybusinesscard.ui.theme.AndroidGreen
import eu.milo4apps.mybusinesscard.ui.theme.MyBusinessCardTheme
import eu.milo4apps.mybusinesscard.ui.theme.TealDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = TealDark
                ) {
                    BusinessCard("Eduard Smith",
                        "Junior Android Developer",
                        "(+123) 123 456 789",
                        "mysuperemail@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String,
                 title: String,
                 phoneNumber: String,
                 emailAddress: String
) {
    val imgLogo = painterResource(id = R.drawable.ic_android_img)
    val imgPhone = painterResource(id = R.drawable.ic_phone)
    val imgEmail = painterResource(id = R.drawable.ic_email)

    // LOGO - NAME - TITLE
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp)
    ) {
        Image(
            painter = imgLogo,
            contentDescription = null,
            modifier = Modifier
                .width(75.dp)
                .height(75.dp)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = Color.White
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AndroidGreen
        )
    }

    // CONTACT INFO - PHONE - EMAIL
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .padding(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Image(
                painter = imgPhone,
                contentDescription = null,
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 18.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = imgEmail,
                contentDescription = null
            )
            Text(
                text = emailAddress,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBusinessCardTheme {
        BusinessCard("Eduard Smith",
            "Junior Android Developer",
            "(+123) 123 456 789",
            "mysuperemail@gmail.com"
        )
    }
}