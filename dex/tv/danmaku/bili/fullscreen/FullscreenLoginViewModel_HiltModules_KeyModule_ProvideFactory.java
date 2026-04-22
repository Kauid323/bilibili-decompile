package tv.danmaku.bili.fullscreen;

import dagger.internal.Factory;
import tv.danmaku.bili.fullscreen.FullscreenLoginViewModel_HiltModules;

public final class FullscreenLoginViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* renamed from: get */
    public Boolean m1043get() {
        return Boolean.valueOf(provide());
    }

    public static FullscreenLoginViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return FullscreenLoginViewModel_HiltModules.KeyModule.provide();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final FullscreenLoginViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new FullscreenLoginViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}