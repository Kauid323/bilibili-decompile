package tv.danmaku.bili.fullscreen.service;

import dagger.internal.Factory;

public final class PhoneOnePassLoginService_Factory implements Factory<PhoneOnePassLoginService> {
    public PhoneOnePassLoginService get() {
        return newInstance();
    }

    public static PhoneOnePassLoginService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PhoneOnePassLoginService newInstance() {
        return new PhoneOnePassLoginService();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final PhoneOnePassLoginService_Factory INSTANCE = new PhoneOnePassLoginService_Factory();

        private InstanceHolder() {
        }
    }
}