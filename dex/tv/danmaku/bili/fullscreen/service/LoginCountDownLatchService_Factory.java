package tv.danmaku.bili.fullscreen.service;

import dagger.internal.Factory;

public final class LoginCountDownLatchService_Factory implements Factory<LoginCountDownLatchService> {
    public LoginCountDownLatchService get() {
        return newInstance();
    }

    public static LoginCountDownLatchService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LoginCountDownLatchService newInstance() {
        return new LoginCountDownLatchService();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final LoginCountDownLatchService_Factory INSTANCE = new LoginCountDownLatchService_Factory();

        private InstanceHolder() {
        }
    }
}