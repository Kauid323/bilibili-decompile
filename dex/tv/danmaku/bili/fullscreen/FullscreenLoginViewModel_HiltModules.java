package tv.danmaku.bili.fullscreen;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

public final class FullscreenLoginViewModel_HiltModules {
    private FullscreenLoginViewModel_HiltModules() {
    }

    @Module
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class BindsModule {
        @LazyClassKey(FullscreenLoginViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(FullscreenLoginViewModel fullscreenLoginViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class KeyModule {
        private KeyModule() {
        }

        @Provides
        @LazyClassKey(FullscreenLoginViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }
    }
}