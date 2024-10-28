package com.example.teksedit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki Laki", "Perempuan")
    var confNama by remember { mutableStateOf("") }
    var confEmail by remember { mutableStateOf("") }
    var confAlamat by remember { mutableStateOf("") }
    var confNotelepon by remember { mutableStateOf("") }
    var confGender by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "Isi nama anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row (modifier = Modifier.fillMaxWidth()){
            dataGender.forEach{selectedGender->
                Row(verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {gender = selectedGender }
                    )
                    Text(text = selectedGender)}
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Isi email anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "Isi alamat anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "Isi No Telepon anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        Button(onClick = {
            confNama = nama
            confEmail = email
            confAlamat = alamat
            confNotelepon = notelepon
            confGender = gender
        } ) {
            Text(text = "Simpan")
        }

        TampilanData(
            param = "nama",
            argu = confNama)
        TampilanData(
            param = "email",
            argu = confEmail)
        TampilanData(
            param = "alamat",
            argu = confAlamat)
        TampilanData(
            param = "no telepon",
            argu = confNotelepon)
        TampilanData(
            param = "Gender",
            argu = confGender
        )

    }

}

@Composable
fun TampilanData(
    param: String, argu: String
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.1f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}
