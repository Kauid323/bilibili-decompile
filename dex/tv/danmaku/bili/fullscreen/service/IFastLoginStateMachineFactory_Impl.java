package tv.danmaku.bili.fullscreen.service;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import tv.danmaku.bili.fullscreen.state.FastLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.FastLoginStateMachine_Factory;
import tv.danmaku.bili.fullscreen.state.IFastLoginPage;

public final class IFastLoginStateMachineFactory_Impl implements IFastLoginStateMachineFactory {
    private final FastLoginStateMachine_Factory delegateFactory;

    IFastLoginStateMachineFactory_Impl(FastLoginStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IFastLoginStateMachineFactory
    public FastLoginStateMachine create(IFastLoginPage initialState) {
        return this.delegateFactory.get(initialState);
    }

    public static Provider<IFastLoginStateMachineFactory> create(FastLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IFastLoginStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<IFastLoginStateMachineFactory> createFactoryProvider(FastLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IFastLoginStateMachineFactory_Impl(delegateFactory));
    }
}