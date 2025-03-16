package br.com.fiap.projeto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun Curso2Screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Fundo escuro
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Adiciona rolagem
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
                    onClick = { navController.navigate("menu") } // Voltar para o menu
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back), // Ícone de voltar
                        contentDescription = "Voltar",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.logo_empresa), // Logo
                contentDescription = "Logo da Empresa",
                modifier = Modifier
                    .size(180.dp)
                    .padding(bottom = 20.dp)
            )

            Text(
                text = "CURSO 2: Investimentos e Planejamento Financeiro",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00BFA6),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Curso2Module(
                title = "Módulo 1: Tipos de Investimentos",
                content = """
                    - Diferenças entre renda fixa e renda variável.
                    - Como escolher o investimento ideal para seu perfil.
                    - Introdução a ações, fundos imobiliários, e CDBs.
                """.trimIndent()
            )

            Curso2Module(
                title = "Módulo 2: Planejamento Financeiro de Longo Prazo",
                content = """
                    - Como definir metas financeiras para o futuro.
                    - Estratégias de poupança e investimentos a longo prazo.
                """.trimIndent()
            )

            Curso2Module(
                title = "Módulo 3: Aposentadoria e Previdência",
                content = """
                    - A importância de planejar para a aposentadoria.
                    - Como funcionam os diferentes tipos de previdência.
                    - Dicas para garantir uma aposentadoria segura.
                """.trimIndent()
            )

            Spacer(modifier = Modifier.height(24.dp)) // Espaço extra no final para melhorar a rolagem
        }
    }
}

@Composable
fun Curso2Module(title: String, content: String) {
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
                color = Color(0xFF00BFA6)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

