package tv.danmaku.bili.ui.watchlater.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TYPE_CLEAN_INVALID", "", "TYPE_CLEAN_WATCHED", "toResourceString", "", "", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterItem;", "filterNotItem", "predication", "Lkotlin/Function1;", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterViewModelKt {
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