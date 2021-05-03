package com.example.twinui

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NormalButton(
    onClick: () -> Unit,
    text: String,
    height: Dp
) {

    var pressed = remember { mutableStateOf(false) }
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(115, 58, 216)),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .padding(top = if (pressed.value) 4.dp else 0.dp)
            .height(height - if (pressed.value) 4.dp else 0.dp)
            .clip(shape = RoundedCornerShape(50))
            .fillMaxWidth()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP -> {
                        pressed.value = !pressed.value
                    }
                }
                true
            }
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun NegativeButton(
    onClick: () -> Unit,
    text: String,
    height: Dp
) {
    var pressed = remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(2.dp, Color(81, 204, 197)),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(81, 204, 197),
            backgroundColor = Color(255, 255, 255)
        ),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .clip(shape = RoundedCornerShape(50))
            .padding(top = if (pressed.value) 4.dp else 0.dp)
            .height(height - if (pressed.value) 4.dp else 0.dp)
            .fillMaxWidth()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP -> {
                        pressed.value = !pressed.value
                    }
                }
                true
            }
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}