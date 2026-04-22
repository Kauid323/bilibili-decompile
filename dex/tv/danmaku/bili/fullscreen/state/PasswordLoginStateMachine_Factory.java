package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Factory;
import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.IPasswordLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class PasswordLoginStateMachine_Factory implements Factory<PasswordLoginStateMachine> {
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<IPasswordLoginService> loginServiceProvider;

    private PasswordLoginStateMachine_Factory(Provider<IPasswordLoginService> loginServiceProvider, Provider<LoginReportService> loginReportServiceProvider) {
        this.loginServiceProvider = loginServiceProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
    }

    public PasswordLoginStateMachine get() {
        return newInstance((IPasswordLoginService) this.loginServiceProvider.get(), (LoginReportService) this.loginReportServiceProvider.get());
    }

    public static PasswordLoginStateMachine_Factory create(Provider<IPasswordLoginService> loginServiceProvider, Provider<LoginReportService> loginReportServiceProvider) {
        return new PasswordLoginStateMachine_Factory(loginServiceProvider, loginReportServiceProvider);
    }

    public static PasswordLoginStateMachine newInstance(IPasswordLoginService loginService, LoginReportService loginReportService) {
        return new PasswordLoginStateMachine(loginService, loginReportService);
    }
}