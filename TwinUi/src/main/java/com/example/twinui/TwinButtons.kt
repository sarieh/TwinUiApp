package com.example.twinui

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NormalButton(
    onClick: () -> Unit,
    text: String,
    height: Int
) {

    val pressed = remember { mutableStateOf(false) }
    val clickedBrush = remember {
        mutableStateOf(
            Brush.horizontalGradient(
                listOf(
                    Color(97, 52, 197),
                    Color(115, 58, 216)
                )
            )
        )
    }
    val unClickedBrush = remember {
        mutableStateOf(
            Brush.linearGradient(
                0.0f to Color.Transparent,
                0.9f to Color.Transparent,
                0.91f to Color.Transparent,
                0.92f to Color(67, 36, 136),
                1.0f to Color(67, 36, 136),
                start = Offset(0.0f, 2.0f*height.dp.value),
                end = Offset(0.0f, 2.6f*height.dp.value)
            )
        )
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .padding(top = if (pressed.value) 4.dp else 0.dp)
            .height(height.dp - if (pressed.value) 4.dp else 0.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(50))
            .background(brush = clickedBrush.value)
            .background(brush = if (!pressed.value) unClickedBrush.value else clickedBrush.value)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP -> {
                        pressed.value = !pressed.value
                    }
                }
                true
            },
        elevation = elevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun NegativeButton(
    onClick: () -> Unit,
    text: String,
    height: Int
) {
    val pressed = remember { mutableStateOf(false) }
    val clickedBrush = remember {
        mutableStateOf(
            Brush.linearGradient(
                0.0f to Color.White,
                1.0f to Color.White,
            )
        )
    }
    val unClickedBrush = remember {
        mutableStateOf(
            Brush.linearGradient(
                0.0f to Color.Transparent,
                0.85f to Color.Transparent,
                0.86f to Color(81, 204, 197),
                1.0f to Color(81, 204, 197),
                start = Offset(0.0f, 2.0f*height.dp.value),
                end = Offset(0.0f, 2.6f*height.dp.value)
            )
        )
    }

    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(2.dp, Color(81, 204, 197)),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(81, 204, 197),
            backgroundColor = Color.Unspecified
        ),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .padding(top = if (pressed.value) 4.dp else 0.dp)
            .height(height.dp - if (pressed.value) 4.dp else 0.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(50))
            .background(color = Color.White)
            .background(brush = clickedBrush.value)
            .background(brush = if (!pressed.value) unClickedBrush.value else clickedBrush.value)
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

@Preview
@Composable
fun Tmp() {
    Column {
        NormalButton({}, "text", 50)
        NegativeButton({}, "text", 50)
    }
}