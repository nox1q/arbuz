package kz.noxiq.arbuz.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.noxiq.arbuz.ui.stash.StashFragment
import kz.noxiq.arbuz.ui.submit_order.SubmitOrderFragment
import kz.noxiq.arbuz.ui.watermelon_selection.WatermelonSelectionFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSubmitOrderFragment(): SubmitOrderFragment

    @ContributesAndroidInjector
    abstract fun contributeWatermelonSelectionFragment(): WatermelonSelectionFragment

    @ContributesAndroidInjector
    abstract fun contributeStashFragment(): StashFragment

}