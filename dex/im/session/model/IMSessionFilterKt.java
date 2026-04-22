package im.session.model;

import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionFilter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"filters", "", "Lim/session/model/IMSessionFilter;", "Lim/session/model/IMSessionFilterConfig;", "currentFilterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionFilterKt {
    public static final List<IMSessionFilter> filters(IMSessionFilterConfig $this$filters) {
        Object element$iv;
        if ($this$filters == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = $this$filters.getFilters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionFilter it = (IMSessionFilter) item$iv$iv;
            destination$iv$iv.add(new IMSessionFilter(it.getType(), it.getName(), Intrinsics.areEqual(it.getType(), $this$filters.getCurrentFilter())));
        }
        List result = CollectionsKt.toMutableList((List) destination$iv$iv);
        if (result.isEmpty()) {
            result.add(new IMSessionFilter());
        }
        List $this$firstOrNull$iv = result;
        Iterator<T> it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                element$iv = it2.next();
                if (((IMSessionFilter) element$iv).isSelected()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        if (element$iv == null) {
            IMSessionFilter newFilter = IMSessionFilter.copy$default(result.get(0), null, null, true, 3, null);
            result.set(0, newFilter);
        }
        return result;
    }

    public static final KSessionFilterType currentFilterType(List<IMSessionFilter> list) {
        Object element$iv;
        KSessionFilterType type;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<IMSessionFilter> $this$firstOrNull$iv = list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                IMSessionFilter it2 = (IMSessionFilter) element$iv;
                if (it2.isSelected()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        IMSessionFilter currentFilter = (IMSessionFilter) element$iv;
        return (currentFilter == null || (type = currentFilter.getType()) == null) ? KSessionFilterType.FILTER_DEFAULT.INSTANCE : type;
    }
}