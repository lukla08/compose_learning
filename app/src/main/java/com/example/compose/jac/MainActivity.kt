package com.example.compose.jac

import  android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.jetchat.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxWidth()) {
                    MessageCard(Message("auuuu", "body1"))
                }
            }
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
        Spacer(modifier = Modifier
            .width(18.dp)
            .border(16.dp, MaterialTheme.colorScheme.primary, CircleShape))
        Column {
            Text(text = "Hello ${msg.author} sds ")
            Text(text = "Hello ${msg.body} ")
            SimpleFilledTextFieldSample()
            StyledTextField()
            CustomCheckboxExample()
            CheckboxWithLabelExample()
            RadioButtonSample()
//            GradientTextField()
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Conan", "body"))
}

@Composable
fun SimpleFilledTextFieldSample() {
    var text1 by remember {mutableStateOf<String>("")}

    Text(text = "")

    var text  =  remember { ""}

    TextField(
        value = text1,
        onValueChange = { text1 = it },
        label = { Text("Label112") }
    )
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text2 by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        leadingIcon = {icon()},
//        trailingIcon = { icon2() },
//        placeholder = { Text("sds")},
        value = text,
        onValueChange = { text = it },
//        label = { Text("dasdasd1 ") }
    )
}

@Composable fun icon() {
    Text("Asdad1")
}

@Composable fun icon2() {
    Text("Asdad")
}

@Composable
fun StyledTextField() {
    var value by remember { mutableStateOf("Hello\nWorld\nInvisible") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Enter text") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun GradientTextField() {
    val rainbowColors: List<Color> = listOf()

    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    TextField(
        value = text, onValueChange = { text = it }, textStyle = TextStyle(brush = brush)
    )}


@Preview
@Composable
fun CustomCheckboxExample() {
    val checked = remember { mutableStateOf(false) }


    Column {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked },
            colors = CheckboxDefaults.colors()
        )
        Text("Custom checkbox is ${if (checked.value) "checked" else "unchecked"}")
    }
}

@Preview
@Composable
fun CheckboxWithLabelExample() {
    val checked = remember { mutableStateOf(false) }

    Row {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked }
        )
        Text("Label for checkbox")
    }
}

@Composable
fun RadioButtonSample() {
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

