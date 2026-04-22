package tv.danmaku.bili.ui.main2;

import android.content.Context;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ILoginDispatcher.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"getLoginDispatcher", "Ltv/danmaku/bili/ui/main2/ILoginDispatcher;", "ctx", "Landroid/content/Context;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ILoginDispatcherKt {
    public static final ILoginDispatcher getLoginDispatcher(Context ctx) {
        return new NavigationLoginDispatcherV2(ctx);
    }
}