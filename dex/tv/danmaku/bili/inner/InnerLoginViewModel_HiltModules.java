package tv.danmaku.bili.inner;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

public final class InnerLoginViewModel_HiltModules {
    private InnerLoginViewModel_HiltModules() {
    }

    @Module
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class BindsModule {
        @LazyClassKey(InnerLoginViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(InnerLoginViewModel innerLoginViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class KeyModule {
        private KeyModule() {
        }

        @Provides
        @LazyClassKey(InnerLoginViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }
    }
}