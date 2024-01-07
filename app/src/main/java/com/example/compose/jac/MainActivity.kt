package com.example.compose.jac

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.jetchat.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {

            }
            MessageCard(Message("auth1", "body1"))
        }
    }
}

data class Message(val author  : String, val body : String)

@Composable
fun MessageCard(msg : Message) {
    Row(Modifier.padding(all = 2.dp)) {
        Image(
            painter = painterResource(R.drawable.ali),
            contentDescription = "imageDescription",
            modifier = Modifier
                .size(33.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Hello ${msg.author} ")
            Text(text = "Hello ${msg.body} ")
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Conan", "body"))
}