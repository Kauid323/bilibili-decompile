package im.base.config;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMConfigSettingModule_ProvideSettingFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lim/base/config/IMConfigSettingModule_ProvideSettingFactory;", "Ldagger/internal/Factory;", "Lim/base/config/IMConfigSetting;", "mapProvider", "Ljavax/inject/Provider;", "", "", "Lim/base/config/IMConfigSettingProvider;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMConfigSettingModule_ProvideSettingFactory implements Factory<IMConfigSetting> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Map<Integer, IMConfigSettingProvider>> mapProvider;

    public IMConfigSettingModule_ProvideSettingFactory(Provider<Map<Integer, IMConfigSettingProvider>> provider) {
        Intrinsics.checkNotNullParameter(provider, "mapProvider");
        this.mapProvider = provider;
    }

    /* renamed from: get */
    public IMConfigSetting m3108get() {
        Companion companion = Companion;
        Object obj = this.mapProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.provideSetting((Map) obj);
    }

    /* compiled from: IMConfigSettingModule_ProvideSettingFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u0007J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007¨\u0006\u000e"}, d2 = {"Lim/base/config/IMConfigSettingModule_ProvideSettingFactory$Companion;", "", "<init>", "()V", "create", "Lim/base/config/IMConfigSettingModule_ProvideSettingFactory;", "mapProvider", "Ljavax/inject/Provider;", "", "", "Lim/base/config/IMConfigSettingProvider;", "provideSetting", "Lim/base/config/IMConfigSetting;", "map", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMConfigSettingModule_ProvideSettingFactory create(Provider<Map<Integer, IMConfigSettingProvider>> provider) {
            Intrinsics.checkNotNullParameter(provider, "mapProvider");
            return new IMConfigSettingModule_ProvideSettingFactory(provider);
        }

        @JvmStatic
        public final IMConfigSetting provideSetting(Map<Integer, ? extends IMConfigSettingProvider> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return IMConfigSettingModule.INSTANCE.provideSetting(map);
        }
    }

    @JvmStatic
    public static final IMConfigSettingModule_ProvideSettingFactory create(Provider<Map<Integer, IMConfigSettingProvider>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final IMConfigSetting provideSetting(Map<Integer, ? extends IMConfigSettingProvider> map) {
        return Companion.provideSetting(map);
    }
}