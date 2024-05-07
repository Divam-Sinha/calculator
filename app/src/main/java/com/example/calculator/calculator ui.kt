package com.example.calculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Calculator() {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.c), contentDescription = "c")
        Spacer(modifier = Modifier.height(9.dp))
        Text(text = "PERSONAL CALCULATOR", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
    }
    var num1 by remember {
        mutableStateOf("")
    }

    var num2 by remember {
        mutableStateOf("")
    }
    var Output by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 245.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = num1, onValueChange = {
            num1 = it;
        })
        Spacer(modifier = Modifier.height(23.dp))
        TextField(value = num2, onValueChange = {
            num2 = it;
        })
        Spacer(modifier = Modifier.height(23.dp))
        Row(modifier = Modifier.padding(8.dp)) {
            Button(
                onClick = {
                    var Result = num1.toInt() + num2.toInt()
                    Output = Result.toString()
                },
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Text(text = "ADD")
            }
            Button(onClick = {
                var Result = num1.toInt() - num2.toInt()
                Output = Result.toString()
            }, modifier = Modifier.padding(end = 5.dp)) {
                Text(text = "Sub")
            }
            Button(onClick = {
                var Result = num1.toInt() * num2.toInt()
                Output = Result.toString()
            }, modifier = Modifier.padding(end = 5.dp)) {
                Text(text = "Mul")
            }
            Button(onClick = {
                var Result = num1.toInt() / num2.toInt()
                Output = Result.toString()
            }, modifier = Modifier.padding(end = 5.dp)) {
                Text(text = "Div")
            }
        }


        OutlinedTextField(value = Output, onValueChange = {
            Output = it
        },
            label = {
                Text(text = "OUTPUT")
            })
    }


}