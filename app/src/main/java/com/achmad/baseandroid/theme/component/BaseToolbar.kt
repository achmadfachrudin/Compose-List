package com.achmad.baseandroid.theme.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.achmad.baseandroid.R
import com.achmad.baseandroid.theme.BaseColor
import com.achmad.baseandroid.theme.BaseComposeTheme

@Preview
@Composable
fun BaseToolbar(
    title: String = "",
    showLeftButton: Boolean = true,
    showRightButton: Boolean = false,
    leftButtonImage: Painter = painterResource(id = R.drawable.ic_arrow_left),
    rightButtonImage: Painter = painterResource(id = R.drawable.ic_arrow_right),
    onLeftButtonClick: () -> Unit = {},
    onRightButtonClick: () -> Unit = {},
    elevation: Dp = 4.dp,
) {
    BaseComposeTheme {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    color = BaseColor.GreyMedium,
                )
            },
            navigationIcon = if (showLeftButton) {
                {
                    IconButton(onClick = onLeftButtonClick) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = leftButtonImage,
                            contentDescription = "",
                            tint = BaseColor.GreyMedium,
                        )
                    }
                }
            } else {
                null
            },
            actions = {
                if (showRightButton) {
                    IconButton(onClick = onRightButtonClick) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = rightButtonImage,
                            contentDescription = "",
                        )
                    }
                }
            },
            backgroundColor = BaseColor.White,
            elevation = elevation,
        )
    }
}
