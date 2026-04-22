package kntr.watch.later.watchlater.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\u001a,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "TYPE_CLEAN_INVALID", "", "TYPE_CLEAN_WATCHED", "toResourceString", "", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "filterNotItem", "predication", "Lkotlin/Function1;", "", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterViewModelKt {
    private static final String TAG = "WatchLaterViewModel";
    public static final int TYPE_CLEAN_INVALID = 1;
    public static final int TYPE_CLEAN_WATCHED = 2;

    public static final String toResourceString(List<WatchLaterItem> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<WatchLaterItem> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            WatchLaterItem it = (WatchLaterItem) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(it.getAid()));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final List<WatchLaterItem> filterNotItem(List<WatchLaterItem> list, Function1<? super WatchLaterItem, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predication");
        List<WatchLaterItem> $this$filterNot$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            WatchLaterItem it = (WatchLaterItem) element$iv$iv;
            if (!((Boolean) function1.invoke(it)).booleanValue()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List list2 = CollectionsKt.toMutableList((List) destination$iv$iv);
        while (!list2.isEmpty() && ((WatchLaterItem) CollectionsKt.first(list2)).getCardType() == 1) {
            list2.remove(0);
        }
        return list2;
    }
}