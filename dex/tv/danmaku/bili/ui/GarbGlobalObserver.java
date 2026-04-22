package tv.danmaku.bili.ui;

import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.util.NightTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: GarbGlobalObserver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/GarbGlobalObserver;", "Lcom/bilibili/lib/ui/garb/GarbWatcher$Observer;", "<init>", "()V", "init", "", "onSkinChange", "skin", "Lcom/bilibili/lib/ui/garb/Garb;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbGlobalObserver implements GarbWatcher.Observer {
    public static final int $stable = 0;
    public static final GarbGlobalObserver INSTANCE = new GarbGlobalObserver();

    private GarbGlobalObserver() {
    }

    public final void init() {
        GarbWatcher.INSTANCE.subscribe(this);
    }

    public void onSkinChange(Garb skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        BiliWebView.Companion.setWebViewNightMode(NightTheme.isNightTheme(BiliContext.application()));
    }
}