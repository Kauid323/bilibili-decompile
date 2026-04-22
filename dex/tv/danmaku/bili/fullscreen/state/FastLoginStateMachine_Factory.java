package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class FastLoginStateMachine_Factory {
    private final Provider<LoginReportService> loginReportServiceProvider;

    private FastLoginStateMachine_Factory(Provider<LoginReportService> loginReportServiceProvider) {
        this.loginReportServiceProvider = loginReportServiceProvider;
    }

    public FastLoginStateMachine get(IFastLoginPage initialState) {
        return newInstance(initialState, (LoginReportService) this.loginReportServiceProvider.get());
    }

    public static FastLoginStateMachine_Factory create(Provider<LoginReportService> loginReportServiceProvider) {
        return new FastLoginStateMachine_Factory(loginReportServiceProvider);
    }

    public static FastLoginStateMachine newInstance(IFastLoginPage initialState, LoginReportService loginReportService) {
        return new FastLoginStateMachine(initialState, loginReportService);
    }
}