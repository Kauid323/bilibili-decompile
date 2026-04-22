package tv.danmaku.bili.inner;

import dagger.internal.Factory;
import tv.danmaku.bili.inner.InnerLoginViewModel_HiltModules;

public final class InnerLoginViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* renamed from: get */
    public Boolean m1157get() {
        return Boolean.valueOf(provide());
    }

    public static InnerLoginViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return InnerLoginViewModel_HiltModules.KeyModule.provide();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final InnerLoginViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new InnerLoginViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}