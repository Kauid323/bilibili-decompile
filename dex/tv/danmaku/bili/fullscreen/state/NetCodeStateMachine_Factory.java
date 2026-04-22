package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.NetCodeLoginService;

public final class NetCodeStateMachine_Factory {
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<NetCodeLoginService> netCodeServiceProvider;

    private NetCodeStateMachine_Factory(Provider<LoginReportService> loginReportServiceProvider, Provider<NetCodeLoginService> netCodeServiceProvider) {
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.netCodeServiceProvider = netCodeServiceProvider;
    }

    public NetCodeStateMachine get(NetCodeState initialState) {
        return newInstance(initialState, (LoginReportService) this.loginReportServiceProvider.get(), (NetCodeLoginService) this.netCodeServiceProvider.get());
    }

    public static NetCodeStateMachine_Factory create(Provider<LoginReportService> loginReportServiceProvider, Provider<NetCodeLoginService> netCodeServiceProvider) {
        return new NetCodeStateMachine_Factory(loginReportServiceProvider, netCodeServiceProvider);
    }

    public static NetCodeStateMachine newInstance(NetCodeState initialState, LoginReportService loginReportService, NetCodeLoginService netCodeService) {
        return new NetCodeStateMachine(initialState, loginReportService, netCodeService);
    }
}