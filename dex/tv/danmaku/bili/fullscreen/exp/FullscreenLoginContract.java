package tv.danmaku.bili.fullscreen.exp;

import android.content.Intent;
import android.os.Bundle;
import com.bilibili.app.comm.list.common.contract.RouterResultContract;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.blrouter.MutableBundleLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.FullscreenLoginActivityKt;

/* compiled from: FullscreenLoginExp.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fullscreen/exp/FullscreenLoginContract;", "Lcom/bilibili/app/comm/list/common/contract/RouterResultContract;", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "", "<init>", "()V", "parseResult", "resultCode", "", "intent", "Landroid/content/Intent;", "buildBundle", "bundleLike", "Lcom/bilibili/lib/blrouter/MutableBundleLike;", "input", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginContract extends RouterResultContract<LoginExpType, Unit> {
    public static final int $stable = RouterResultContract.$stable;

    public FullscreenLoginContract() {
        super(FullscreenLoginActivityKt.FullscreenLoginPageUrl);
    }

    public /* bridge */ /* synthetic */ Object parseResult(int resultCode, Intent intent) {
        m1046parseResult(resultCode, intent);
        return Unit.INSTANCE;
    }

    /* renamed from: parseResult  reason: collision with other method in class */
    public void m1046parseResult(int resultCode, Intent intent) {
    }

    public void buildBundle(MutableBundleLike bundleLike, LoginExpType input) {
        Intrinsics.checkNotNullParameter(bundleLike, "bundleLike");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle $this$buildBundle_u24lambda_u240 = new Bundle();
        $this$buildBundle_u24lambda_u240.putParcelable(FullscreenLoginExp.KEY_LOGIN_EXP, input == null ? LoginExpType.CONTROL : input);
        Unit unit = Unit.INSTANCE;
        bundleLike.put(str, $this$buildBundle_u24lambda_u240);
        bundleLike.put("from_spmid", FullscreenLoginExp.SPMID_STARTUP_EXP);
    }
}