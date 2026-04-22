package im.base.config;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;

/* compiled from: DDConfigProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lim/base/config/IMConfigSettingProviderModule;", "", "<init>", "()V", "provideIMConfigSettingProvider", "Lim/base/config/IMConfigSettingProvider;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class IMConfigSettingProviderModule {
    public static final IMConfigSettingProviderModule INSTANCE = new IMConfigSettingProviderModule();

    private IMConfigSettingProviderModule() {
    }

    @Provides
    @IntKey(1)
    @IntoMap
    public final IMConfigSettingProvider provideIMConfigSettingProvider() {
        return new DDConfigProvider();
    }
}