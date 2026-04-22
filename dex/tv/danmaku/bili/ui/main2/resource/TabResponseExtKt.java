package tv.danmaku.bili.ui.main2.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.datetime.Clock;
import tv.danmaku.bili.BR;

/* compiled from: TabResponseExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"filterNotExpired", "", "T", "Ltv/danmaku/bili/ui/main2/resource/IHomeTab;", "now", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TabResponseExtKt {
    public static /* synthetic */ List filterNotExpired$default(List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Clock.System.INSTANCE.now().getEpochSeconds();
        }
        return filterNotExpired(list, j);
    }

    public static final <T extends IHomeTab> List<T> filterNotExpired(List<? extends T> list, long now) {
        ArrayList arrayList;
        if (list == null) {
            arrayList = null;
        } else {
            List<? extends T> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                IHomeTab it = (IHomeTab) element$iv$iv;
                if (it.getExpiredAt() == 0 || it.getExpiredAt() > now) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            arrayList = (List) destination$iv$iv;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}