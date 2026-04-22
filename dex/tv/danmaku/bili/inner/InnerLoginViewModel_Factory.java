package tv.danmaku.bili.inner;

import dagger.internal.Factory;
import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.LoginCountDownLatchService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class InnerLoginViewModel_Factory implements Factory<InnerLoginViewModel> {
    private final Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider;
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<InnerLoginStateMachine> stateMachineProvider;

    private InnerLoginViewModel_Factory(Provider<InnerLoginStateMachine> stateMachineProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider) {
        this.stateMachineProvider = stateMachineProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.loginCountDownLatchServiceProvider = loginCountDownLatchServiceProvider;
    }

    public InnerLoginViewModel get() {
        return newInstance((InnerLoginStateMachine) this.stateMachineProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (LoginCountDownLatchService) this.loginCountDownLatchServiceProvider.get());
    }

    public static InnerLoginViewModel_Factory create(Provider<InnerLoginStateMachine> stateMachineProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<LoginCountDownLatchService> loginCountDownLatchServiceProvider) {
        return new InnerLoginViewModel_Factory(stateMachineProvider, loginReportServiceProvider, loginCountDownLatchServiceProvider);
    }

    public static InnerLoginViewModel newInstance(InnerLoginStateMachine stateMachine, LoginReportService loginReportService, LoginCountDownLatchService loginCountDownLatchService) {
        return new InnerLoginViewModel(stateMachine, loginReportService, loginCountDownLatchService);
    }
}