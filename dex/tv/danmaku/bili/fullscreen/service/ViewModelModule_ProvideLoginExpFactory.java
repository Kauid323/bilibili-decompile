package tv.danmaku.bili.fullscreen.service;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;

public final class ViewModelModule_ProvideLoginExpFactory implements Factory<LoginExpType> {
    private final Provider<SavedStateHandle> savedStateHandleProvider;

    private ViewModelModule_ProvideLoginExpFactory(Provider<SavedStateHandle> savedStateHandleProvider) {
        this.savedStateHandleProvider = savedStateHandleProvider;
    }

    public LoginExpType get() {
        return provideLoginExp((SavedStateHandle) this.savedStateHandleProvider.get());
    }

    public static ViewModelModule_ProvideLoginExpFactory create(Provider<SavedStateHandle> savedStateHandleProvider) {
        return new ViewModelModule_ProvideLoginExpFactory(savedStateHandleProvider);
    }

    public static LoginExpType provideLoginExp(SavedStateHandle savedStateHandle) {
        return (LoginExpType) Preconditions.checkNotNullFromProvides(ViewModelModule.INSTANCE.provideLoginExp(savedStateHandle));
    }
}