package home.sidecenter.recent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentContentPools.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"popItem", "Lhome/sidecenter/recent/RecentContentPool;", "T", "Lhome/sidecenter/recent/RecentContent;", "item", "(Lhome/sidecenter/recent/RecentContentPool;Lhome/sidecenter/recent/RecentContent;)Lhome/sidecenter/recent/RecentContentPool;", "sidecenter_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RecentContentPoolsKt {
    public static final <T extends RecentContent> RecentContentPool<T> popItem(RecentContentPool<T> recentContentPool, T t) {
        Intrinsics.checkNotNullParameter(recentContentPool, "<this>");
        Intrinsics.checkNotNullParameter(t, "item");
        Iterable $this$map$iv = recentContentPool.getShow();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            RecentContent it = (RecentContent) item$iv$iv;
            if (Intrinsics.areEqual(it, t)) {
                RecentContent markDeleted = it.markDeleted();
                Intrinsics.checkNotNull(markDeleted, "null cannot be cast to non-null type T of home.sidecenter.recent.RecentContentPoolsKt.popItem");
                it = markDeleted;
            }
            destination$iv$iv.add(it);
        }
        return recentContentPool.copy(CollectionsKt.filterNotNull(CollectionsKt.plus((List) destination$iv$iv, CollectionsKt.firstOrNull(recentContentPool.getCache()))), CollectionsKt.drop(recentContentPool.getCache(), 1));
    }
}