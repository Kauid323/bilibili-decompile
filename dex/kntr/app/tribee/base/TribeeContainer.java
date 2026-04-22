package kntr.app.tribee.base;

import java.util.LinkedHashMap;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeContainer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\tH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/base/TribeeContainer;", "", "<init>", "()V", "MAX_CACHE_SIZE", "", "map", "Ljava/util/LinkedHashMap;", "", "Lkntr/app/tribee/base/TribeeEditContent;", "Lkotlin/collections/LinkedHashMap;", "put", "id", "content", "getAndRemove", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeContainer {
    private static final int MAX_CACHE_SIZE = 10;
    public static final TribeeContainer INSTANCE = new TribeeContainer();
    private static final LinkedHashMap<String, TribeeEditContent> map = new LinkedHashMap<>(10);

    private TribeeContainer() {
    }

    public final TribeeEditContent put(String id, TribeeEditContent content) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(content, "content");
        TribeeEditContent old = map.put(id, content);
        if (map.size() > 10) {
            Set<String> keySet = map.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            Object first = CollectionsKt.first(keySet);
            Intrinsics.checkNotNullExpressionValue(first, "first(...)");
            String eldestKey = (String) first;
            map.remove(eldestKey);
        }
        return old;
    }

    public final TribeeEditContent getAndRemove(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        TribeeEditContent content = map.get(id);
        map.remove(id);
        return content;
    }
}