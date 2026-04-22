package kntr.base.dd.impl.internal.data;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.model.DDProp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreData.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\u009b\u0001\u0010\u0004\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\b0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u0005\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\b0\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r28\u0010\u000e\u001a4\u0012\u0015\u0012\u0013\u0018\u0001H\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000fH\u0082\b¨\u0006\u0014"}, d2 = {"isEqual", "", "Lkntr/base/dd/impl/internal/model/DDProp;", "other", "diffWith", "Lkotlin/Pair;", "", "", "E", "", "", "oldMap", "keySelector", "Lkotlin/Function1;", "isUpdated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CoreDataKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isEqual(DDProp $this$isEqual, DDProp other) {
        return other != null && Intrinsics.areEqual($this$isEqual.getName(), other.getName()) && Intrinsics.areEqual($this$isEqual.getDefault(), other.getDefault()) && Intrinsics.areEqual($this$isEqual.getTrack(), other.getTrack()) && Intrinsics.areEqual($this$isEqual.getCache(), other.getCache());
    }

    private static final <E> Pair<Map<String, E>, Set<String>> diffWith(List<? extends E> list, Map<String, ? extends E> map, Function1<? super E, String> function1, Function2<? super E, ? super E, Boolean> function2) {
        Map newMap = new LinkedHashMap();
        Set oldKeys = CollectionsKt.toMutableSet(map.keySet());
        Set updatedKeys = new LinkedHashSet();
        List<? extends E> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            String key = (String) function1.invoke(element$iv);
            if (key != null) {
                newMap.put(key, element$iv);
                if (oldKeys.contains(key)) {
                    oldKeys.remove(key);
                    if (((Boolean) function2.invoke(map.get(key), element$iv)).booleanValue()) {
                        updatedKeys.add(key);
                    }
                } else {
                    updatedKeys.add(key);
                }
            }
        }
        updatedKeys.addAll(oldKeys);
        return TuplesKt.to(newMap, updatedKeys);
    }
}