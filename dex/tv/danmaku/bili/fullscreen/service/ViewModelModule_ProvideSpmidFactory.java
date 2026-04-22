package tv.danmaku.bili.fullscreen.service;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

public final class ViewModelModule_ProvideSpmidFactory implements Factory<String> {
    private final Provider<SavedStateHandle> savedStateHandleProvider;

    private ViewModelModule_ProvideSpmidFactory(Provider<SavedStateHandle> savedStateHandleProvider) {
        this.savedStateHandleProvider = savedStateHandleProvider;
    }

    public String get() {
        return provideSpmid((SavedStateHandle) this.savedStateHandleProvider.get());
    }

    public static ViewModelModule_ProvideSpmidFactory create(Provider<SavedStateHandle> savedStateHandleProvider) {
        return new ViewModelModule_ProvideSpmidFactory(savedStateHandleProvider);
    }

    public static String provideSpmid(SavedStateHandle savedStateHandle) {
        return (String) Preconditions.checkNotNullFromProvides(ViewModelModule.INSTANCE.provideSpmid(savedStateHandle));
    }
}