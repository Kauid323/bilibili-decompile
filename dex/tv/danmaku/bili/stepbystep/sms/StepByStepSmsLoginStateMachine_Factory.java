package tv.danmaku.bili.stepbystep.sms;

import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

public final class StepByStepSmsLoginStateMachine_Factory {
    private final Provider<LoginReportService> reportServiceProvider;
    private final Provider<ISmsLoginService> smsLoginServiceProvider;

    private StepByStepSmsLoginStateMachine_Factory(Provider<ISmsLoginService> smsLoginServiceProvider, Provider<LoginReportService> reportServiceProvider) {
        this.smsLoginServiceProvider = smsLoginServiceProvider;
        this.reportServiceProvider = reportServiceProvider;
    }

    public StepByStepSmsLoginStateMachine get(String reportLoginType) {
        return newInstance((ISmsLoginService) this.smsLoginServiceProvider.get(), (LoginReportService) this.reportServiceProvider.get(), reportLoginType);
    }

    public static StepByStepSmsLoginStateMachine_Factory create(Provider<ISmsLoginService> smsLoginServiceProvider, Provider<LoginReportService> reportServiceProvider) {
        return new StepByStepSmsLoginStateMachine_Factory(smsLoginServiceProvider, reportServiceProvider);
    }

    public static StepByStepSmsLoginStateMachine newInstance(ISmsLoginService smsLoginService, LoginReportService reportService, String reportLoginType) {
        return new StepByStepSmsLoginStateMachine(smsLoginService, reportService, reportLoginType);
    }
}