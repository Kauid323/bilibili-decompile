package im.base.config;

import dagger.Module;
import dagger.Provides;
import im.base.IMLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IMConfigSettingProvider.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\t\u0012\u00070\t¢\u0006\u0002\b\n0\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lim/base/config/IMConfigSettingModule;", "", "<init>", "()V", "provideSetting", "Lim/base/config/IMConfigSetting;", "map", "", "", "Lim/base/config/IMConfigSettingProvider;", "Lkotlin/jvm/JvmSuppressWildcards;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class IMConfigSettingModule {
    public static final IMConfigSettingModule INSTANCE = new IMConfigSettingModule();

    private IMConfigSettingModule() {
    }

    @Provides
    @Singleton
    public final IMConfigSetting provideSetting(Map<Integer, IMConfigSettingProvider> map) {
        IMConfigSetting result;
        Intrinsics.checkNotNullParameter(map, "map");
        Iterable $this$sortedByDescending$iv = map.entrySet();
        Iterator it = CollectionsKt.asSequence(CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: im.base.config.IMConfigSettingModule$provideSetting$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Map.Entry it2 = (Map.Entry) t2;
                Map.Entry it3 = (Map.Entry) t;
                return ComparisonsKt.compareValues((Integer) it2.getKey(), (Integer) it3.getKey());
            }
        })).iterator();
        while (true) {
            if (!it.hasNext()) {
                result = null;
                break;
            }
            Map.Entry it2 = (Map.Entry) it.next();
            result = ((IMConfigSettingProvider) it2.getValue()).getIMConfigSetting();
            IMLog.Companion.i("IMConfigSetting", it2.getKey() + " -> " + Reflection.getOrCreateKotlinClass(it2.getValue().getClass()).getSimpleName() + " provides IMConfigSetting: " + result);
            if (result != null) {
                break;
            }
        }
        IMConfigSetting result2 = result;
        return result2 == null ? new IMConfigSetting(false, false, 0L, 0L, 15, null) : result2;
    }
}