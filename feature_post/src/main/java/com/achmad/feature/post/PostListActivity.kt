package com.achmad.feature.post

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.achmad.baseandroid.theme.BaseComposeTheme
import com.achmad.feature.post.data.model.PostItem
import com.achmad.feature.post.di.buildDaggerPostComponent
import com.google.android.play.core.splitcompat.SplitCompat
import javax.inject.Inject

class PostListActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: PostListViewModel

    private fun inject() {
        buildDaggerPostComponent(this.applicationContext).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        setContent {
            BaseComposeTheme {
                PostListPageCompose(
                    viewModel = viewModel,
                    onItemClick = { goToDetail(it) }
                )
            }
        }
    }

    private fun goToDetail(post: PostItem) {
        startActivity(PostDetailActivity.createIntent(this, post))
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        SplitCompat.installActivity(context)
    }
}
