package tv.danmaku.bili.appwidget.hotword.api;

import java.util.HashSet;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/api/HotWorldConfigHolder;", "", "<init>", "()V", "ids", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getIds", "()Ljava/util/HashSet;", "setIds", "(Ljava/util/HashSet;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotWorldConfigHolder {
    private HashSet<Integer> ids;

    public final HashSet<Integer> getIds() {
        return this.ids;
    }

    public final void setIds(HashSet<Integer> hashSet) {
        this.ids = hashSet;
    }
}