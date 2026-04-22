package tv.danmaku.bili.fullscreen.service;

import dagger.internal.Factory;
import dagger.internal.Provider;

public final class LoginReportService_Factory implements Factory<LoginReportService> {
    private final Provider<String> spmidProvider;

    private LoginReportService_Factory(Provider<String> spmidProvider) {
        this.spmidProvider = spmidProvider;
    }

    public LoginReportService get() {
        return newInstance((String) this.spmidProvider.get());
    }

    public static LoginReportService_Factory create(Provider<String> spmidProvider) {
        return new LoginReportService_Factory(spmidProvider);
    }

    public static LoginReportService newInstance(String spmid) {
        return new LoginReportService(spmid);
    }
}