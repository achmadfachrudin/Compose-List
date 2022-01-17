package com.achmad.feature.post.di

import android.content.Context
import com.achmad.baseandroid.di.FeaturePostDependencies
import com.achmad.feature.post.PostListActivity
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
@Component(dependencies = [FeaturePostDependencies::class])
interface PostComponent {
    fun inject(target: PostListActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun dependencies(dependencies: FeaturePostDependencies): Builder
        fun build(): PostComponent
    }
}

fun buildDaggerPostComponent(context: Context): PostComponent {
    return DaggerPostComponent.builder()
        .context(context)
        .dependencies(
            EntryPointAccessors.fromApplication(
                context,
                FeaturePostDependencies::class.java
            )
        )
        .build()
}
