package tv.danmaku.bili.fullscreen.service;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

public final class ViewModelModule_ProvideTechTrackServiceFactory implements Factory<TechTrackService> {
    private final Provider<SavedStateHandle> savedStateHandleProvider;

    private ViewModelModule_ProvideTechTrackServiceFactory(Provider<SavedStateHandle> savedStateHandleProvider) {
        this.savedStateHandleProvider = savedStateHandleProvider;
    }

    public TechTrackService get() {
        return provideTechTrackService((SavedStateHandle) this.savedStateHandleProvider.get());
    }

    public static ViewModelModule_ProvideTechTrackServiceFactory create(Provider<SavedStateHandle> savedStateHandleProvider) {
        return new ViewModelModule_ProvideTechTrackServiceFactory(savedStateHandleProvider);
    }

    public static TechTrackService provideTechTrackService(SavedStateHandle savedStateHandle) {
        return (TechTrackService) Preconditions.checkNotNullFromProvides(ViewModelModule.INSTANCE.provideTechTrackService(savedStateHandle));
    }
}