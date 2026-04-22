package kntr.base.neuron.epoch.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.StringsKt;

/* compiled from: KNeuron.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"mPlatformNeuron", "Lkntr/base/neuron/IPlatformNeuron;", "getMPlatformNeuron", "()Lkntr/base/neuron/IPlatformNeuron;", "getSetValue", "", "", "Lkntr/base/config/KConfig;", "key", "defaultValue", "delimiters", "neuron_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KNeuron_androidKt {
    private static final IPlatformNeuron mPlatformNeuron = new KNeuron_androidKt$mPlatformNeuron$1();

    public static final IPlatformNeuron getMPlatformNeuron() {
        return mPlatformNeuron;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set getSetValue$default(KConfig kConfig, String str, Set set, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            str2 = ",";
        }
        return getSetValue(kConfig, str, set, str2);
    }

    private static final Set<String> getSetValue(KConfig $this$getSetValue, String key, Set<String> set, String delimiters) {
        Iterable split$default;
        String config$default = IPlatformConfig.CC.config$default($this$getSetValue, key, null, 2, null);
        if (config$default != null && (split$default = StringsKt.split$default(config$default, new String[]{delimiters}, false, 0, 6, (Object) null)) != null) {
            Iterable $this$map$iv = split$default;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(StringsKt.trim(it).toString());
            }
            Set<String> set2 = CollectionsKt.toSet((List) destination$iv$iv);
            if (set2 != null) {
                return set2;
            }
        }
        return set;
    }
}