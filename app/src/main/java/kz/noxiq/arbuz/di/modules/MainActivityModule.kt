package kz.noxiq.arbuz.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.noxiq.arbuz.MainActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}