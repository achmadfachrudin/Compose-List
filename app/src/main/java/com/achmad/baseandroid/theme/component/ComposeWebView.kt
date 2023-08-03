package com.achmad.baseandroid.theme.component

import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ComposeWebView(url: String) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            // Enable JavaScript (if needed)
            settings.javaScriptEnabled = true

            // Set up WebViewClient to handle page navigation
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(request?.url.toString())
                    return true
                }
            }

            // Set up WebChromeClient to handle JavaScript alerts and other UI elements
            webChromeClient = object : WebChromeClient() {
                // You can override other methods here as needed
            }

            // Load the initial URL
            loadUrl(url)
        }
    })
}
