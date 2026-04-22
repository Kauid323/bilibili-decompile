package tv.danmaku.bili.fullscreen.exp;

import android.content.Intent;
import com.bilibili.app.comm.list.common.contract.RouteRequestResultContract;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FullscreenLoginExp.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/fullscreen/exp/FullscreenLoginExpDialogContract;", "Lcom/bilibili/app/comm/list/common/contract/RouteRequestResultContract;", "", "request", "Lcom/bilibili/lib/blrouter/RouteRequest;", "<init>", "(Lcom/bilibili/lib/blrouter/RouteRequest;)V", "parseResult", "resultCode", "", "intent", "Landroid/content/Intent;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginExpDialogContract extends RouteRequestResultContract<Unit, Unit> {
    public static final int $stable = RouteRequestResultContract.$stable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginExpDialogContract(RouteRequest request) {
        super(request);
        Intrinsics.checkNotNullParameter(request, "request");
    }

    public /* bridge */ /* synthetic */ Object parseResult(int resultCode, Intent intent) {
        m1047parseResult(resultCode, intent);
        return Unit.INSTANCE;
    }

    /* renamed from: parseResult  reason: collision with other method in class */
    public void m1047parseResult(int resultCode, Intent intent) {
    }
}