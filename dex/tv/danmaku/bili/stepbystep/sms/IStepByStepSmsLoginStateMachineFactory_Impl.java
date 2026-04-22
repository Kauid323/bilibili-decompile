package tv.danmaku.bili.stepbystep.sms;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;

public final class IStepByStepSmsLoginStateMachineFactory_Impl implements IStepByStepSmsLoginStateMachineFactory {
    private final StepByStepSmsLoginStateMachine_Factory delegateFactory;

    IStepByStepSmsLoginStateMachineFactory_Impl(StepByStepSmsLoginStateMachine_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginStateMachineFactory
    public StepByStepSmsLoginStateMachine create(String reportLoginType) {
        return this.delegateFactory.get(reportLoginType);
    }

    public static Provider<IStepByStepSmsLoginStateMachineFactory> create(StepByStepSmsLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IStepByStepSmsLoginStateMachineFactory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<IStepByStepSmsLoginStateMachineFactory> createFactoryProvider(StepByStepSmsLoginStateMachine_Factory delegateFactory) {
        return InstanceFactory.create(new IStepByStepSmsLoginStateMachineFactory_Impl(delegateFactory));
    }
}