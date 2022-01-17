buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(PluginClassPath.androidGradlePlugin)
        classpath(PluginClassPath.kotlinGradlePlugin)
        classpath(PluginClassPath.hiltGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class.java) {
    setDelete(rootProject.buildDir)
}
