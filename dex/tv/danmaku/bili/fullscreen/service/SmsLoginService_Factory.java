package tv.danmaku.bili.fullscreen.service;

import dagger.internal.Factory;

public final class SmsLoginService_Factory implements Factory<SmsLoginService> {
    public SmsLoginService get() {
        return newInstance();
    }

    public static SmsLoginService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SmsLoginService newInstance() {
        return new SmsLoginService();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final SmsLoginService_Factory INSTANCE = new SmsLoginService_Factory();

        private InstanceHolder() {
        }
    }
}