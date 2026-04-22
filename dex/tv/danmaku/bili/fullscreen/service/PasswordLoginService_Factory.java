package tv.danmaku.bili.fullscreen.service;

import dagger.internal.Factory;

public final class PasswordLoginService_Factory implements Factory<PasswordLoginService> {
    public PasswordLoginService get() {
        return newInstance();
    }

    public static PasswordLoginService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PasswordLoginService newInstance() {
        return new PasswordLoginService();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final PasswordLoginService_Factory INSTANCE = new PasswordLoginService_Factory();

        private InstanceHolder() {
        }
    }
}