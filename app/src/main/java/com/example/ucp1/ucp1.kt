package com.example.latihaninput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@Preview (showBackground = true )
@Composable

fun ucp1(modifier: Modifier = Modifier){
    HeaderSection()
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arival by remember { mutableStateOf("") }
    var transportasi by remember { mutableStateOf("") }

    var originsv by remember { mutableStateOf("") }
    var departuresv by remember { mutableStateOf("") }
    var arivalsv by remember { mutableStateOf("") }
    var transportasisv by remember { mutableStateOf("") }

    val listJk = listOf("Bus", "Ship", "Train", "Plane")

    Column (modifier = modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier .padding(60.dp))
        OutlinedTextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = origin,
            onValueChange = {origin = it},
            label = { Text("origin")},
            placeholder = { Text("surabaya")
            }


        )

        OutlinedTextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = departure,
            onValueChange = {departure = it},
            label = { Text("Departure")},
            placeholder = { Text("12 Januari 2024")}

        )

        OutlinedTextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = arival,
            onValueChange = {arival = it},
            label = { Text("Arrival")},
            placeholder = { Text("29 Desember 2025")}

        )

            Text("Choose Transportation", fontSize = 15.sp, )

            Row(verticalAlignment = Alignment.CenterVertically) {
                listJk.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = transportasi == item,
                            onClick = {
                                transportasi = item
                            }
                        )
                        Text(item)
                    }
                }

            }



        Button ( modifier = Modifier .fillMaxWidth(),
            onClick = {
            originsv = origin
            departuresv = departure
            arivalsv = arival
            transportasisv = transportasi

        }) {
            Text("Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()


        ){
            DetailSurat(judul = "Origin", isinya = originsv)
            DetailSurat(judul = "Departure", isinya = departuresv)
            DetailSurat(judul = "Arrival", isinya = arivalsv)
            DetailSurat(judul = "Transport", isinya = transportasisv)

        }


    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .padding(15.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
                )
                Text (
                    text = "Muhamad Adri",
                    color = Color.White
                )

                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )

                Text(
                    text = "Kabupaten Tanggerang",
                    color = Color.White
                )
            }
            Box(
                contentAlignment = Alignment.BottomStart
            ){
                Image(
                    painter = painterResource(id = R.drawable.poto1),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}


@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
    ){

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.1f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }



    }
}
