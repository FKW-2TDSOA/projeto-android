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
fun Curso1Screen(navController: NavController) {
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
                text = "CURSO 1: Fundamentos da Educação Financeira",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Módulo 1
            Curso1Module(
                title = "Módulo 1: Introdução à Educação Financeira",
                content = """
                    - O que é educação financeira?
                    - Por que é importante entender como administrar suas finanças?
                    - Diferença entre renda, poupança e investimentos.
                """.trimIndent()
            )

            // Módulo 2
            Curso1Module(
                title = "Módulo 2: Gestão de Orçamento Pessoal",
                content = """
                    - Como criar um orçamento eficiente.
                    - Dicas para controlar gastos e priorizar despesas.
                """.trimIndent()
            )

            // Módulo 3
            Curso1Module(
                title = "Módulo 3: Endividamento e Crédito",
                content = """
                    - Como evitar dívidas desnecessárias.
                    - Quando e como usar crédito de forma responsável.
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
fun Curso1Module(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
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
