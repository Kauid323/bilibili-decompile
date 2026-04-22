package tv.danmaku.bili.core.test;

import android.content.Context;
import android.view.View;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/core/test/保密的答题预览分享页;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "clickTime", "", "removeCnt", "Ljava/lang/Runnable;", "onClick", "", "v", "Landroid/view/View;", "getButtonText", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
/* renamed from: tv.danmaku.bili.core.test.保密的答题预览分享页  reason: contains not printable characters */
public final class C0005 extends AbsButtonTestItem {
    public static final int $stable = 8;
    private int clickTime;
    private final Runnable removeCnt = new Runnable() { // from class: tv.danmaku.bili.core.test.保密的答题预览分享页$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C0005.removeCnt$lambda$0(C0005.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeCnt$lambda$0(C0005 this$0) {
        ToastHelper.showToastShort(FoundationAlias.getFapp(), "你都没签保密协议你怎么敢跳");
        this$0.clickTime = 0;
    }

    public void onClick(View v) {
        this.clickTime++;
        if (v != null) {
            v.removeCallbacks(this.removeCnt);
        }
        if (this.clickTime < 10) {
            if (v != null) {
                v.postDelayed(this.removeCnt, 500L);
                return;
            }
            return;
        }
        this.removeCnt.run();
        RouteRequest routeRequest = RouteRequestKt.toRouteRequest("bilibili://test/gala/share/quiz");
        Intrinsics.checkNotNull(v);
        BLRouter.routeTo(routeRequest, v.getContext());
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "保密的答题预览分享页";
    }
}