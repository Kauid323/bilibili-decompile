package tv.danmaku.bili.stepbystep;

import dagger.internal.Factory;
import tv.danmaku.bili.stepbystep.StepByStepLoginViewModel_HiltModules;

public final class StepByStepLoginViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    /* renamed from: get */
    public Boolean m1495get() {
        return Boolean.valueOf(provide());
    }

    public static StepByStepLoginViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return StepByStepLoginViewModel_HiltModules.KeyModule.provide();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final StepByStepLoginViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new StepByStepLoginViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}