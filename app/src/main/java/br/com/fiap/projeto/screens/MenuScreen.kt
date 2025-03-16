package br.com.fiap.projeto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import br.com.fiap.navegacao.R

@Composable
fun MenuScreen(navController: NavController) {
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
                    .padding(bottom = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { navController.navigate("menuLogin") } // Voltar para o menu de login
                ) {
                    Text("Sair", color = Color.White)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.logo_empresa),
                contentDescription = "Logo da Empresa",
                modifier = Modifier
                    .size(180.dp)
                    .padding(bottom = 20.dp)
            )

            Text(
                text = "MENU",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00BFA6),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            CustomButton(
                text = "MÓDULO 1: Fundamentos",
                onClick = { navController.navigate("curso1") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton(
                text = "MÓDULO 2: Investimentos",
                onClick = { navController.navigate("curso2") }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
