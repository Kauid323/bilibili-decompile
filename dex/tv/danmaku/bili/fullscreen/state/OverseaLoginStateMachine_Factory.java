package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.ISmsLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class OverseaLoginStateMachine_Factory {
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<ISmsLoginStateMachineFactory> smsStateMachineProvider;

    private OverseaLoginStateMachine_Factory(Provider<LoginReportService> loginReportServiceProvider, Provider<ISmsLoginStateMachineFactory> smsStateMachineProvider) {
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.smsStateMachineProvider = smsStateMachineProvider;
    }

    public OverseaLoginStateMachine get(IOverseaLoginState initialState) {
        return newInstance(initialState, (LoginReportService) this.loginReportServiceProvider.get(), (ISmsLoginStateMachineFactory) this.smsStateMachineProvider.get());
    }

    public static OverseaLoginStateMachine_Factory create(Provider<LoginReportService> loginReportServiceProvider, Provider<ISmsLoginStateMachineFactory> smsStateMachineProvider) {
        return new OverseaLoginStateMachine_Factory(loginReportServiceProvider, smsStateMachineProvider);
    }

    public static OverseaLoginStateMachine newInstance(IOverseaLoginState initialState, LoginReportService loginReportService, ISmsLoginStateMachineFactory smsStateMachineProvider) {
        return new OverseaLoginStateMachine(initialState, loginReportService, smsStateMachineProvider);
    }
}