package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.INetCodeStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class SmsLoginStateMachine_Factory {
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<INetCodeStateMachineFactory> netCodeStateMachineProvider;
    private final Provider<ISmsLoginService> smsLoginServiceProvider;

    private SmsLoginStateMachine_Factory(Provider<ISmsLoginService> smsLoginServiceProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<INetCodeStateMachineFactory> netCodeStateMachineProvider) {
        this.smsLoginServiceProvider = smsLoginServiceProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.netCodeStateMachineProvider = netCodeStateMachineProvider;
    }

    public SmsLoginStateMachine get(ISmsLoginPageState initialState) {
        return newInstance(initialState, (ISmsLoginService) this.smsLoginServiceProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (INetCodeStateMachineFactory) this.netCodeStateMachineProvider.get());
    }

    public static SmsLoginStateMachine_Factory create(Provider<ISmsLoginService> smsLoginServiceProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<INetCodeStateMachineFactory> netCodeStateMachineProvider) {
        return new SmsLoginStateMachine_Factory(smsLoginServiceProvider, loginReportServiceProvider, netCodeStateMachineProvider);
    }

    public static SmsLoginStateMachine newInstance(ISmsLoginPageState initialState, ISmsLoginService smsLoginService, LoginReportService loginReportService, INetCodeStateMachineFactory netCodeStateMachineProvider) {
        return new SmsLoginStateMachine(initialState, smsLoginService, loginReportService, netCodeStateMachineProvider);
    }
}