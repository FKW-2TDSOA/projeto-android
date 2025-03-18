package br.com.fiap.navegandoentretelas.sreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import br.com.fiap.projeto.screens.CustomButton

@Composable
fun LoginScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val isLoading = remember { mutableStateOf(false) }
    val errorState = remember { mutableStateOf("") }
    val showWelcomePopup = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ícone de Voltar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { navController.navigate("menuLogin") } // Voltar para a tela principal
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Voltar",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.logo_empresa),
                contentDescription = "Logo da Empresa",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 20.dp)
            )

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
                        text = "LOGIN",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00BFA6)
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

                    if (errorState.value.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = errorState.value,
                            color = Color.Red,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        LaunchedEffect(errorState.value) {
                            kotlinx.coroutines.delay(3000)
                            errorState.value = ""
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    CustomButton(
                        text = if (isLoading.value) "Carregando..." else "Entrar",
                        onClick = {
                            val cliente = Cliente(
                                id = "",
                                nome = "",
                                email = email.value,
                                senha = senha.value
                            )
                            isLoading.value = true

                            val service = RetrofitFactory().getClienteService()
                            service.getClientes()?.enqueue(object : Callback<List<Cliente?>?> {
                                override fun onResponse(call: Call<List<Cliente?>?>, response: Response<List<Cliente?>?>) {
                                    isLoading.value = false
                                    if (response.isSuccessful) {
                                        val usuarioLogado = response.body()?.find { it?.email == email.value && it?.senha == senha.value }
                                        if (usuarioLogado != null) {
                                            showWelcomePopup.value = true
                                        } else {
                                            errorState.value = "Usuário ou senha inválidos."
                                        }
                                    } else {
                                        errorState.value = "Erro ao verificar login."
                                    }
                                }

                                override fun onFailure(call: Call<List<Cliente?>?>, t: Throwable) {
                                    isLoading.value = false
                                    errorState.value = "Falha na conexão."
                                }
                            })
                        },
                        enabled = !isLoading.value
                    )
                }
            }
        }
    }

    if (showWelcomePopup.value) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {},
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            containerColor = Color.Black,
            title = {
                Text(
                    text = "Bem-vindo!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00BFA6)
                )
            },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_empresa),
                        contentDescription = "Logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CircularProgressIndicator(color = Color(0xFF00BFA6))
                }
            }
        )

        LaunchedEffect(Unit) {
            kotlinx.coroutines.delay(2000)
            showWelcomePopup.value = false
            navController.navigate("menu") {
                popUpTo("login") { inclusive = true }
            }
        }
    }
}

