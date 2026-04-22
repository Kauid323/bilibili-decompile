package tv.danmaku.bili.fullscreen.service;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

public final class ViewModelModule_ProvidePhoneServiceFactory implements Factory<IPhoneService> {
    private final Provider<LoginReportService> loginReportServiceProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<TechTrackService> techTrackServiceProvider;

    private ViewModelModule_ProvidePhoneServiceFactory(Provider<SavedStateHandle> savedStateHandleProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<TechTrackService> techTrackServiceProvider) {
        this.savedStateHandleProvider = savedStateHandleProvider;
        this.loginReportServiceProvider = loginReportServiceProvider;
        this.techTrackServiceProvider = techTrackServiceProvider;
    }

    public IPhoneService get() {
        return providePhoneService((SavedStateHandle) this.savedStateHandleProvider.get(), (LoginReportService) this.loginReportServiceProvider.get(), (TechTrackService) this.techTrackServiceProvider.get());
    }

    public static ViewModelModule_ProvidePhoneServiceFactory create(Provider<SavedStateHandle> savedStateHandleProvider, Provider<LoginReportService> loginReportServiceProvider, Provider<TechTrackService> techTrackServiceProvider) {
        return new ViewModelModule_ProvidePhoneServiceFactory(savedStateHandleProvider, loginReportServiceProvider, techTrackServiceProvider);
    }

    public static IPhoneService providePhoneService(SavedStateHandle savedStateHandle, LoginReportService loginReportService, TechTrackService techTrackService) {
        return (IPhoneService) Preconditions.checkNotNullFromProvides(ViewModelModule.INSTANCE.providePhoneService(savedStateHandle, loginReportService, techTrackService));
    }
}