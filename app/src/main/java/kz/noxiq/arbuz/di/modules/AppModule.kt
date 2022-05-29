package kz.noxiq.arbuz.di.modules

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        DataModule::class,
    ]
)
class AppModule