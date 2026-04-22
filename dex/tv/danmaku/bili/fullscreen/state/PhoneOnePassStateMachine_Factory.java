package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class PhoneOnePassStateMachine_Factory {
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<IPhoneOnePassLoginService> serviceProvider;

    private PhoneOnePassStateMachine_Factory(Provider<IPhoneOnePassLoginService> serviceProvider, Provider<LoginReportService> loginReportServiceProvider) {
        this.serviceProvider = serviceProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
    }

    public PhoneOnePassStateMachine get(IPhoneOnePassState initial) {
        return newInstance(initial, (IPhoneOnePassLoginService) this.serviceProvider.get(), (LoginReportService) this.loginReportServiceProvider.get());
    }

    public static PhoneOnePassStateMachine_Factory create(Provider<IPhoneOnePassLoginService> serviceProvider, Provider<LoginReportService> loginReportServiceProvider) {
        return new PhoneOnePassStateMachine_Factory(serviceProvider, loginReportServiceProvider);
    }

    public static PhoneOnePassStateMachine newInstance(IPhoneOnePassState initial, IPhoneOnePassLoginService service, LoginReportService loginReportService) {
        return new PhoneOnePassStateMachine(initial, service, loginReportService);
    }
}