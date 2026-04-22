package tv.danmaku.bili.fullscreen.service;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import tv.danmaku.bili.fullscreen.state.NetCodeState;
import tv.danmaku.bili.fullscreen.state.NetCodeStateMachine;
import tv.danmaku.bili.fullscreen.state.NetCodeStateMachine_Factory;

public final class INetCodeStateMachineFactory_Impl implements INetCodeStateMachineFactory {
    private final NetCodeStateMachine_Factory delegateFactory;

    INetCodeStateMachineFactory_Impl(NetCodeStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.fullscreen.service.INetCodeStateMachineFactory
    public NetCodeStateMachine create(NetCodeState initialState) {
        return this.delegateFactory.get(initialState);
    }

    public static Provider<INetCodeStateMachineFactory> create(NetCodeStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new INetCodeStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<INetCodeStateMachineFactory> createFactoryProvider(NetCodeStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new INetCodeStateMachineFactory_Impl(delegateFactory));
    }
}