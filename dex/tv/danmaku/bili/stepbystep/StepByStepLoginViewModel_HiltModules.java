package tv.danmaku.bili.stepbystep;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

public final class StepByStepLoginViewModel_HiltModules {
    private StepByStepLoginViewModel_HiltModules() {
    }

    @Module
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class BindsModule {
        @LazyClassKey(StepByStepLoginViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(StepByStepLoginViewModel stepByStepLoginViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class KeyModule {
        private KeyModule() {
        }

        @Provides
        @LazyClassKey(StepByStepLoginViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }
    }
}