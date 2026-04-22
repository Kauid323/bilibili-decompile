package tv.danmaku.bili.auth;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.ScopeInfoResponse;

/* compiled from: AuthLoginModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/AuthButtonModel;", "Ltv/danmaku/bili/auth/AuthLoginModel;", "<init>", "()V", "agreement", "Ltv/danmaku/bili/auth/ScopeInfoResponse$Agreement;", "getAgreement", "()Ltv/danmaku/bili/auth/ScopeInfoResponse$Agreement;", "setAgreement", "(Ltv/danmaku/bili/auth/ScopeInfoResponse$Agreement;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthButtonModel implements AuthLoginModel {
    public static final int $stable = 8;
    private ScopeInfoResponse.Agreement agreement;

    public final ScopeInfoResponse.Agreement getAgreement() {
        return this.agreement;
    }

    public final void setAgreement(ScopeInfoResponse.Agreement agreement) {
        this.agreement = agreement;
    }
}