package br.com.fiap.projeto.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00BFA6)), // Verde financeiro
        modifier = Modifier
            .fillMaxWidth() // O botão agora ocupa toda a largura disponível
            .height(55.dp), // Aumentando a altura para acomodar texto maior
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(5.dp),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            maxLines = 1, // Garante que o texto fique em uma linha
            modifier = Modifier.padding(horizontal = 8.dp) // Adiciona padding lateral para evitar cortes
        )
    }
}

