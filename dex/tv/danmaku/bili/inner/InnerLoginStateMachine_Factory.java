package tv.danmaku.bili.inner;

import dagger.internal.Factory;
import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.IFastLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IOverseaLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IPhoneService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.TechTrackService;
import tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginStateMachine;

public final class InnerLoginStateMachine_Factory implements Factory<InnerLoginStateMachine> {
    private final Provider<IFastLoginStateMachineFactory> fastLoginStateMachineProvider;
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<IOverseaLoginStateMachineFactory> overseaStateMachineProvider;
    private final Provider<PhoneOrPasswordLoginStateMachine> phoneOrPasswordStateMachineProvider;
    private final Provider<IPhoneService> phoneServiceProvider;
    private final Provider<IPhoneOnePassStateMachineFactory> phoneStateMachineProvider;
    private final Provider<TechTrackService> techTrackServiceProvider;

    private InnerLoginStateMachine_Factory(Provider<IPhoneService> phoneServiceProvider, Provider<TechTrackService> techTrackServiceProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<IPhoneOnePassStateMachineFactory> phoneStateMachineProvider, Provider<IFastLoginStateMachineFactory> fastLoginStateMachineProvider, Provider<PhoneOrPasswordLoginStateMachine> phoneOrPasswordStateMachineProvider, Provider<IOverseaLoginStateMachineFactory> overseaStateMachineProvider) {
        this.phoneServiceProvider = phoneServiceProvider;
        this.techTrackServiceProvider = techTrackServiceProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.phoneStateMachineProvider = phoneStateMachineProvider;
        this.fastLoginStateMachineProvider = fastLoginStateMachineProvider;
        this.phoneOrPasswordStateMachineProvider = phoneOrPasswordStateMachineProvider;
        this.overseaStateMachineProvider = overseaStateMachineProvider;
    }

    public InnerLoginStateMachine get() {
        return newInstance((IPhoneService) this.phoneServiceProvider.get(), (TechTrackService) this.techTrackServiceProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (IPhoneOnePassStateMachineFactory) this.phoneStateMachineProvider.get(), (IFastLoginStateMachineFactory) this.fastLoginStateMachineProvider.get(), this.phoneOrPasswordStateMachineProvider, (IOverseaLoginStateMachineFactory) this.overseaStateMachineProvider.get());
    }

    public static InnerLoginStateMachine_Factory create(Provider<IPhoneService> phoneServiceProvider, Provider<TechTrackService> techTrackServiceProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<IPhoneOnePassStateMachineFactory> phoneStateMachineProvider, Provider<IFastLoginStateMachineFactory> fastLoginStateMachineProvider, Provider<PhoneOrPasswordLoginStateMachine> phoneOrPasswordStateMachineProvider, Provider<IOverseaLoginStateMachineFactory> overseaStateMachineProvider) {
        return new InnerLoginStateMachine_Factory(phoneServiceProvider, techTrackServiceProvider, loginReportServiceProvider, phoneStateMachineProvider, fastLoginStateMachineProvider, phoneOrPasswordStateMachineProvider, overseaStateMachineProvider);
    }

    public static InnerLoginStateMachine newInstance(IPhoneService phoneService, TechTrackService techTrackService, LoginReportService loginReportService, IPhoneOnePassStateMachineFactory phoneStateMachineProvider, IFastLoginStateMachineFactory fastLoginStateMachineProvider, javax.inject.Provider<PhoneOrPasswordLoginStateMachine> phoneOrPasswordStateMachineProvider, IOverseaLoginStateMachineFactory overseaStateMachineProvider) {
        return new InnerLoginStateMachine(phoneService, techTrackService, loginReportService, phoneStateMachineProvider, fastLoginStateMachineProvider, phoneOrPasswordStateMachineProvider, overseaStateMachineProvider);
    }
}