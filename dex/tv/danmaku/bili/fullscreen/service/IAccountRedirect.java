package tv.danmaku.bili.fullscreen.service;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\n\u000b\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "", "redirectUrl", "", "getRedirectUrl", "()Ljava/lang/String;", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "Ltv/danmaku/bili/fullscreen/service/AccountNoRedirect;", "Ltv/danmaku/bili/fullscreen/service/AccountRedirectSecurity;", "Ltv/danmaku/bili/fullscreen/service/AccountRedirectVerify;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IAccountRedirect {
    Intent getIntent(Context context);

    String getRedirectUrl();
}