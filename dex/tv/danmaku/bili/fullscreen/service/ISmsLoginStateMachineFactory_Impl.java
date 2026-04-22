package tv.danmaku.bili.fullscreen.service;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import tv.danmaku.bili.fullscreen.state.ISmsLoginPageState;
import tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine_Factory;

public final class ISmsLoginStateMachineFactory_Impl implements ISmsLoginStateMachineFactory {
    private final SmsLoginStateMachine_Factory delegateFactory;

    ISmsLoginStateMachineFactory_Impl(SmsLoginStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.fullscreen.service.ISmsLoginStateMachineFactory
    public SmsLoginStateMachine create(ISmsLoginPageState initialState) {
        return this.delegateFactory.get(initialState);
    }

    public static Provider<ISmsLoginStateMachineFactory> create(SmsLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new ISmsLoginStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<ISmsLoginStateMachineFactory> createFactoryProvider(SmsLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new ISmsLoginStateMachineFactory_Impl(delegateFactory));
    }
}