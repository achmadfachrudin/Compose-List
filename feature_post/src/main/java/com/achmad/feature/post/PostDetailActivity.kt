package com.achmad.feature.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.achmad.baseandroid.theme.BaseComposeTheme
import com.achmad.feature.post.data.model.User
import com.google.android.play.core.splitcompat.SplitCompat

class PostDetailActivity : ComponentActivity() {

    companion object {
        private const val BUNDLE_KEY_POST = "BUNDLE_KEY_POST"

        fun createIntent(
            context: Context,
            user: User,
        ): Intent {
            return Intent(context, PostDetailActivity::class.java).apply {
                putExtra(BUNDLE_KEY_POST, user)
            }
        }
    }

    private val user by lazy {
        intent.getParcelableExtra<User>(BUNDLE_KEY_POST)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseComposeTheme {
                PostDetailPageCompose(user)
            }
        }
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        SplitCompat.installActivity(context)
    }
}
