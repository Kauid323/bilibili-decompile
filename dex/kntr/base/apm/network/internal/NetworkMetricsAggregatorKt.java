package kntr.base.apm.network.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetworkMetricsAggregator.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\bH\u0002¨\u0006\t"}, d2 = {"getSet", "", "T", "Lkntr/base/config/SharedPreferences;", "key", "", "default", "mapper", "Lkotlin/Function1;", "network_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetworkMetricsAggregatorKt {
    static /* synthetic */ Set getSet$default(SharedPreferences sharedPreferences, String str, Set set, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: kntr.base.apm.network.internal.NetworkMetricsAggregatorKt$getSet$1
                public final Void invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        return getSet(sharedPreferences, str, set, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> getSet(SharedPreferences $this$getSet, String key, Set<? extends T> set, Function1<? super String, ? extends T> function1) {
        Iterable split$default;
        String it = SharedPreferences.getString$default($this$getSet, key, null, 2, null);
        if (it != null) {
            String str = StringsKt.isBlank(it) ? null : it;
            if (str != null && (split$default = StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null)) != null) {
                Iterable $this$mapNotNull$iv = split$default;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Object it$iv$iv = function1.invoke(element$iv$iv$iv);
                    if (it$iv$iv != null) {
                        destination$iv$iv.add(it$iv$iv);
                    }
                }
                Set<T> set2 = CollectionsKt.toSet((List) destination$iv$iv);
                if (set2 != null) {
                    return set2;
                }
            }
        }
        return set;
    }
}