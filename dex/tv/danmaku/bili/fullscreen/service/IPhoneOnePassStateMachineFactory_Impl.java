package tv.danmaku.bili.fullscreen.service;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import tv.danmaku.bili.fullscreen.state.IPhoneOnePassState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine_Factory;

public final class IPhoneOnePassStateMachineFactory_Impl implements IPhoneOnePassStateMachineFactory {
    private final PhoneOnePassStateMachine_Factory delegateFactory;

    IPhoneOnePassStateMachineFactory_Impl(PhoneOnePassStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IPhoneOnePassStateMachineFactory
    public PhoneOnePassStateMachine create(IPhoneOnePassState initialState) {
        return this.delegateFactory.get(initialState);
    }

    public static Provider<IPhoneOnePassStateMachineFactory> create(PhoneOnePassStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IPhoneOnePassStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<IPhoneOnePassStateMachineFactory> createFactoryProvider(PhoneOnePassStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IPhoneOnePassStateMachineFactory_Impl(delegateFactory));
    }
}