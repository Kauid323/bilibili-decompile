package tv.danmaku.bili.stepbystep;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.LoginCountDownLatchService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.stepbystep.sms.IStepByStepSmsLoginStateMachineFactory;

public final class StepByStepLoginViewModel_Factory implements Factory<StepByStepLoginViewModel> {
    private final Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider;
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IStepByStepSmsLoginStateMachineFactory> stateSmsMachineFactoryProvider;

    private StepByStepLoginViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider, Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<IStepByStepSmsLoginStateMachineFactory> stateSmsMachineFactoryProvider) {
        this.savedStateHandleProvider = savedStateHandleProvider;
        this.loginCountDownLatchServiceProvider = loginCountDownLatchServiceProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.stateSmsMachineFactoryProvider = stateSmsMachineFactoryProvider;
    }

    public StepByStepLoginViewModel get() {
        return newInstance((SavedStateHandle) this.savedStateHandleProvider.get(), (LoginCountDownLatchService) this.loginCountDownLatchServiceProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (IStepByStepSmsLoginStateMachineFactory) this.stateSmsMachineFactoryProvider.get());
    }

    public static StepByStepLoginViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider, Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<IStepByStepSmsLoginStateMachineFactory> stateSmsMachineFactoryProvider) {
        return new StepByStepLoginViewModel_Factory(savedStateHandleProvider, loginCountDownLatchServiceProvider, loginReportServiceProvider, stateSmsMachineFactoryProvider);
    }

    public static StepByStepLoginViewModel newInstance(SavedStateHandle savedStateHandle, LoginCountDownLatchService loginCountDownLatchService, LoginReportService loginReportService, IStepByStepSmsLoginStateMachineFactory stateSmsMachineFactory) {
        return new StepByStepLoginViewModel(savedStateHandle, loginCountDownLatchService, loginReportService, stateSmsMachineFactory);
    }
}