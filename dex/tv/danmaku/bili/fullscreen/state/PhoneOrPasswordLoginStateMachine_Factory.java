package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Factory;

public final class PhoneOrPasswordLoginStateMachine_Factory implements Factory<PhoneOrPasswordLoginStateMachine> {
    public PhoneOrPasswordLoginStateMachine get() {
        return newInstance();
    }

    public static PhoneOrPasswordLoginStateMachine_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PhoneOrPasswordLoginStateMachine newInstance() {
        return new PhoneOrPasswordLoginStateMachine();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final PhoneOrPasswordLoginStateMachine_Factory INSTANCE = new PhoneOrPasswordLoginStateMachine_Factory();

        private InstanceHolder() {
        }
    }
}