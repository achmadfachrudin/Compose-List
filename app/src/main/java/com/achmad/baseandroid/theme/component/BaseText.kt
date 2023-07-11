package com.achmad.baseandroid.theme.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.achmad.baseandroid.theme.BaseColor

@Composable
fun BaseText(
    text: String,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    color: Color = BaseColor.Black,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = MaterialTheme.typography.body2,
    drawableStart: Painter? = null,
    drawableEnd: Painter? = null,
    drawableStartSize: Int = 24,
    drawableEndSize: Int = 24,
    drawableStartPadding: Int = 8,
    drawableEndPadding: Int = 8,
    drawableStartColor: Color? = null,
    drawableEndColor: Color? = null,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement
    ) {
        drawableStart?.let {
            Icon(
                modifier = Modifier
                    .size(drawableStartSize.dp)
                    .padding(
                        top = 0.dp,
                        bottom = 0.dp,
                        start = 0.dp,
                        end = drawableStartPadding.dp
                    ),
                painter = drawableStart,
                tint = drawableStartColor ?: color,
                contentDescription = "",
            )
        }

        Text(
            text = text,
            color = color,
            fontSize = fontSize,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            textAlign = textAlign,
            lineHeight = lineHeight,
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            onTextLayout = onTextLayout,
            style = style
        )

        drawableEnd?.let {
            Icon(
                modifier = Modifier
                    .size(drawableEndSize.dp)
                    .padding(
                        top = 0.dp,
                        bottom = 0.dp,
                        start = drawableEndPadding.dp,
                        end = 0.dp
                    ),
                painter = drawableEnd,
                tint = drawableEndColor ?: color,
                contentDescription = "",
            )
        }
    }
}
