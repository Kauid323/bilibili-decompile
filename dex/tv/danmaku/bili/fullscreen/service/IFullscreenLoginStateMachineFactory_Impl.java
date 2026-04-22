package tv.danmaku.bili.fullscreen.service;

import dagger.internal.InstanceFactory;
import java.util.List;
import javax.inject.Provider;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine_Factory;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

public final class IFullscreenLoginStateMachineFactory_Impl implements IFullscreenLoginStateMachineFactory {
    private final FullscreenLoginStateMachine_Factory delegateFactory;

    IFullscreenLoginStateMachineFactory_Impl(FullscreenLoginStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IFullscreenLoginStateMachineFactory
    public FullscreenLoginStateMachine create(List<? extends ValidLoginType> validTypes, IFullscreenLoginState initial) {
        return this.delegateFactory.get(validTypes, initial);
    }

    public static Provider<IFullscreenLoginStateMachineFactory> create(FullscreenLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IFullscreenLoginStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<IFullscreenLoginStateMachineFactory> createFactoryProvider(FullscreenLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IFullscreenLoginStateMachineFactory_Impl(delegateFactory));
    }
}