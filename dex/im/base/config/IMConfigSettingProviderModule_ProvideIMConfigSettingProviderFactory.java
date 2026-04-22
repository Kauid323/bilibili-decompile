package im.base.config;

import dagger.internal.Factory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lim/base/config/IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory;", "Ldagger/internal/Factory;", "Lim/base/config/IMConfigSettingProvider;", "<init>", "()V", "get", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory implements Factory<IMConfigSettingProvider> {
    public static final Companion Companion = new Companion(null);
    private static final IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory INSTANCE = new IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory();

    /* renamed from: get */
    public IMConfigSettingProvider m3109get() {
        return Companion.provideIMConfigSettingProvider();
    }

    /* compiled from: IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lim/base/config/IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory$Companion;", "", "<init>", "()V", "INSTANCE", "Lim/base/config/IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory;", "create", "provideIMConfigSettingProvider", "Lim/base/config/IMConfigSettingProvider;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory create() {
            return IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory.INSTANCE;
        }

        @JvmStatic
        public final IMConfigSettingProvider provideIMConfigSettingProvider() {
            return IMConfigSettingProviderModule.INSTANCE.provideIMConfigSettingProvider();
        }
    }

    @JvmStatic
    public static final IMConfigSettingProviderModule_ProvideIMConfigSettingProviderFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final IMConfigSettingProvider provideIMConfigSettingProvider() {
        return Companion.provideIMConfigSettingProvider();
    }
}