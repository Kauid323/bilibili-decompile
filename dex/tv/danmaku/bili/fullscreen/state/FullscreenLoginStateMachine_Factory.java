package tv.danmaku.bili.fullscreen.state;

import dagger.internal.Provider;
import java.util.List;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IPhoneService;
import tv.danmaku.bili.fullscreen.service.ISmsLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.TechTrackService;

public final class FullscreenLoginStateMachine_Factory {
    private final Provider<LoginExpType> loginExpProvider;
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<PasswordLoginStateMachine> passwordStateMachineProvider;
    private final Provider<IPhoneService> phoneServiceProvider;
    private final Provider<IPhoneOnePassStateMachineFactory> phoneStateMachineProvider;
    private final Provider<ISmsLoginStateMachineFactory> smsStateMachineProvider;
    private final Provider<TechTrackService> techTrackServiceProvider;

    private FullscreenLoginStateMachine_Factory(Provider<LoginExpType> loginExpProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<IPhoneService> phoneServiceProvider, Provider<TechTrackService> techTrackServiceProvider, Provider<IPhoneOnePassStateMachineFactory> phoneStateMachineProvider, Provider<ISmsLoginStateMachineFactory> smsStateMachineProvider, Provider<PasswordLoginStateMachine> passwordStateMachineProvider) {
        this.loginExpProvider = loginExpProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.phoneServiceProvider = phoneServiceProvider;
        this.techTrackServiceProvider = techTrackServiceProvider;
        this.phoneStateMachineProvider = phoneStateMachineProvider;
        this.smsStateMachineProvider = smsStateMachineProvider;
        this.passwordStateMachineProvider = passwordStateMachineProvider;
    }

    public FullscreenLoginStateMachine get(List<? extends ValidLoginType> validLoginTypes, IFullscreenLoginState initial) {
        return newInstance(validLoginTypes, initial, (LoginExpType) this.loginExpProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (IPhoneService) this.phoneServiceProvider.get(), (TechTrackService) this.techTrackServiceProvider.get(), (IPhoneOnePassStateMachineFactory) this.phoneStateMachineProvider.get(), (ISmsLoginStateMachineFactory) this.smsStateMachineProvider.get(), this.passwordStateMachineProvider);
    }

    public static FullscreenLoginStateMachine_Factory create(Provider<LoginExpType> loginExpProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<IPhoneService> phoneServiceProvider, Provider<TechTrackService> techTrackServiceProvider, Provider<IPhoneOnePassStateMachineFactory> phoneStateMachineProvider, Provider<ISmsLoginStateMachineFactory> smsStateMachineProvider, Provider<PasswordLoginStateMachine> passwordStateMachineProvider) {
        return new FullscreenLoginStateMachine_Factory(loginExpProvider, loginReportServiceProvider, phoneServiceProvider, techTrackServiceProvider, phoneStateMachineProvider, smsStateMachineProvider, passwordStateMachineProvider);
    }

    public static FullscreenLoginStateMachine newInstance(List<? extends ValidLoginType> validLoginTypes, IFullscreenLoginState initial, LoginExpType loginExp, LoginReportService loginReportService, IPhoneService phoneService, TechTrackService techTrackService, IPhoneOnePassStateMachineFactory phoneStateMachineProvider, ISmsLoginStateMachineFactory smsStateMachineProvider, javax.inject.Provider<PasswordLoginStateMachine> passwordStateMachineProvider) {
        return new FullscreenLoginStateMachine(validLoginTypes, initial, loginExp, loginReportService, phoneService, techTrackService, phoneStateMachineProvider, smsStateMachineProvider, passwordStateMachineProvider);
    }
}