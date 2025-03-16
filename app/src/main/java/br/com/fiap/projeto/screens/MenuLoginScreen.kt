package br.com.fiap.projeto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.navegacao.R


@Composable
fun MenuLoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(32.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_empresa), // Adicione a imagem na pasta res/drawable
                contentDescription = "Logo da Empresa",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 20.dp)
            )

            CustomButton(text = "Cadastro", onClick = { navController.navigate("cadastro") })
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton(text = "Login", onClick = { navController.navigate("login") })
        }
    }
}

