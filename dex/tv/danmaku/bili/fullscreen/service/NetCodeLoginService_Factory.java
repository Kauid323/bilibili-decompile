package tv.danmaku.bili.fullscreen.service;

import dagger.internal.Factory;

public final class NetCodeLoginService_Factory implements Factory<NetCodeLoginService> {
    public NetCodeLoginService get() {
        return newInstance();
    }

    public static NetCodeLoginService_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NetCodeLoginService newInstance() {
        return new NetCodeLoginService();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final NetCodeLoginService_Factory INSTANCE = new NetCodeLoginService_Factory();

        private InstanceHolder() {
        }
    }
}