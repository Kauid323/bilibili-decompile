package tv.danmaku.bili.fullscreen;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.service.IFullscreenLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.LoginCountDownLatchService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class FullscreenLoginViewModel_Factory implements Factory<FullscreenLoginViewModel> {
    private final Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider;
    private final Provider<LoginExpType> loginExpGroupProvider;
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<IFullscreenLoginStateMachineFactory> stateMachineProvider;

    private FullscreenLoginViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider, Provider<IFullscreenLoginStateMachineFactory> stateMachineProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<LoginExpType> loginExpGroupProvider, Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider) {
        this.savedStateHandleProvider = savedStateHandleProvider;
        this.stateMachineProvider = stateMachineProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.loginExpGroupProvider = loginExpGroupProvider;
        this.loginCountDownLatchServiceProvider = loginCountDownLatchServiceProvider;
    }

    public FullscreenLoginViewModel get() {
        return newInstance((SavedStateHandle) this.savedStateHandleProvider.get(), (IFullscreenLoginStateMachineFactory) this.stateMachineProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (LoginExpType) this.loginExpGroupProvider.get(), (LoginCountDownLatchService) this.loginCountDownLatchServiceProvider.get());
    }

    public static FullscreenLoginViewModel_Factory create(Provider<SavedStateHandle> savedStateHandleProvider, Provider<IFullscreenLoginStateMachineFactory> stateMachineProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<LoginExpType> loginExpGroupProvider, Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider) {
        return new FullscreenLoginViewModel_Factory(savedStateHandleProvider, stateMachineProvider, loginReportServiceProvider, loginExpGroupProvider, loginCountDownLatchServiceProvider);
    }

    public static FullscreenLoginViewModel newInstance(SavedStateHandle savedStateHandle, IFullscreenLoginStateMachineFactory stateMachineProvider, LoginReportService loginReportService, LoginExpType loginExpGroup, LoginCountDownLatchService loginCountDownLatchService) {
        return new FullscreenLoginViewModel(savedStateHandle, stateMachineProvider, loginReportService, loginExpGroup, loginCountDownLatchService);
    }
}