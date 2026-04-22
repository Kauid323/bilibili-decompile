package tv.danmaku.bili.fullscreen.service;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import tv.danmaku.bili.fullscreen.state.IOverseaLoginState;
import tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine_Factory;

public final class IOverseaLoginStateMachineFactory_Impl implements IOverseaLoginStateMachineFactory {
    private final OverseaLoginStateMachine_Factory delegateFactory;

    IOverseaLoginStateMachineFactory_Impl(OverseaLoginStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IOverseaLoginStateMachineFactory
    public OverseaLoginStateMachine create(IOverseaLoginState initial) {
        return this.delegateFactory.get(initial);
    }

    public static Provider<IOverseaLoginStateMachineFactory> create(OverseaLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IOverseaLoginStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<IOverseaLoginStateMachineFactory> createFactoryProvider(OverseaLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IOverseaLoginStateMachineFactory_Impl(delegateFactory));
    }
}