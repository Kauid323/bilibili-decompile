package tv.danmaku.bili.fullscreen.service;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/AccountNoRedirect;", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "<init>", "()V", "redirectUrl", "", "getRedirectUrl", "()Ljava/lang/String;", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountNoRedirect implements IAccountRedirect {
    public static final int $stable = 0;
    public static final AccountNoRedirect INSTANCE = new AccountNoRedirect();

    private AccountNoRedirect() {
    }

    @Override // tv.danmaku.bili.fullscreen.service.IAccountRedirect
    public String getRedirectUrl() {
        return "";
    }

    @Override // tv.danmaku.bili.fullscreen.service.IAccountRedirect
    public Intent getIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }
}