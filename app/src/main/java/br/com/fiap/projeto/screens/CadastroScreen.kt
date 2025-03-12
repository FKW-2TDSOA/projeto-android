package br.com.fiap.navegandoentretelas.sreens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projeto.model.Cliente
import br.com.fiap.projeto.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import br.com.fiap.navegacao.R

@Composable
fun CadastroScreen(navController: NavController) {

    val nome = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val isLoading = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF6200EE))
                    .padding(vertical = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.corinthians),
                    contentDescription = "Imagem de IMC",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "CADASTRO",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Main
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 16.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Seus dados",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6200EE)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = nome.value,
                        onValueChange = { nome.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "Seu nome") },
                        label = { Text("Nome") },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "Seu email") },
                        label = { Text("Email") },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = senha.value,
                        onValueChange = { senha.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "Sua senha") },
                        label = { Text("Senha") },
                        shape = RoundedCornerShape(12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            val cliente = Cliente(
                                id = "",
                                nome = nome.value,
                                email = email.value,
                                senha = senha.value
                            )
                            isLoading.value = true

                            val service = RetrofitFactory().getClienteService()
                            service.criarCliente(cliente)?.enqueue(object : Callback<Cliente?> {
                                override fun onResponse(call: Call<Cliente?>, response: Response<Cliente?>) {
                                    isLoading.value = false
                                    if (response.isSuccessful) {
                                        navController.navigate("menu")
                                    } else {
                                        Log.e("Cadastro", "Erro ao cadastrar: ${response.message()}")
                                    }
                                }

                                override fun onFailure(call: Call<Cliente?>, t: Throwable) {
                                    isLoading.value = false
                                    Log.e("Cadastro", "Falha na requisição: ${t.message}")
                                }
                            })
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        enabled = !isLoading.value
                    ) {
                        if (isLoading.value) {
                            Text(text = "Carregando...", fontSize = 18.sp, color = Color.White)
                        } else {
                            Text(text = "Cadastrar", fontSize = 18.sp, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
