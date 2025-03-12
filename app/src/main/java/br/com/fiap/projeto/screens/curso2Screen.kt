package br.com.fiap.projeto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Curso2Screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "CURSO 2: Investimentos e Planejamento Financeiro",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Módulo 1
            Curso2Module(
                title = "Módulo 1: Tipos de Investimentos",
                content = """
                    - Diferenças entre renda fixa e renda variável.
                    - Como escolher o investimento ideal para seu perfil.
                    - Introdução a ações, fundos imobiliários, e CDBs.
                """.trimIndent()
            )

            // Módulo 2
            Curso2Module(
                title = "Módulo 2: Planejamento Financeiro de Longo Prazo",
                content = """
                    - Como definir metas financeiras para o futuro.
                    - Estratégias de poupança e investimentos a longo prazo.
                """.trimIndent()
            )

            // Módulo 3
            Curso2Module(
                title = "Módulo 3: Aposentadoria e Previdência",
                content = """
                    - A importância de planejar para a aposentadoria.
                    - Como funcionam os diferentes tipos de previdência.
                    - Dicas para garantir uma aposentadoria segura.
                """.trimIndent()
            )

            // Botão de Voltar
            Button(
                onClick = {
                    navController.navigate("menu")
                },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Voltar", fontSize = 20.sp, color = Color.Blue)
            }
        }
    }
}

@Composable
fun Curso2Module(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}
