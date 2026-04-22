package tv.danmaku.bili.fullscreen.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bilibili.lib.accountsui.web.AccountVerifyWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/AccountRedirectVerify;", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "redirectUrl", "", "<init>", "(Ljava/lang/String;)V", "getRedirectUrl", "()Ljava/lang/String;", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountRedirectVerify implements IAccountRedirect {
    public static final int $stable = 0;
    private final String redirectUrl;

    public static /* synthetic */ AccountRedirectVerify copy$default(AccountRedirectVerify accountRedirectVerify, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accountRedirectVerify.redirectUrl;
        }
        return accountRedirectVerify.copy(str);
    }

    public final String component1() {
        return this.redirectUrl;
    }

    public final AccountRedirectVerify copy(String str) {
        Intrinsics.checkNotNullParameter(str, "redirectUrl");
        return new AccountRedirectVerify(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountRedirectVerify) && Intrinsics.areEqual(this.redirectUrl, ((AccountRedirectVerify) obj).redirectUrl);
    }

    public int hashCode() {
        return this.redirectUrl.hashCode();
    }

    public String toString() {
        return "AccountRedirectVerify(redirectUrl=" + this.redirectUrl + ")";
    }

    public AccountRedirectVerify(String redirectUrl) {
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        this.redirectUrl = redirectUrl;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IAccountRedirect
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override // tv.danmaku.bili.fullscreen.service.IAccountRedirect
    public Intent getIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent $this$getIntent_u24lambda_u240 = new Intent(context, AccountVerifyWebActivity.class);
        $this$getIntent_u24lambda_u240.setData(Uri.parse(getRedirectUrl()));
        return $this$getIntent_u24lambda_u240;
    }
}