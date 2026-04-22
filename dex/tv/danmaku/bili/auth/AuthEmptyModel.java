package tv.danmaku.bili.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: AuthLoginModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/auth/AuthEmptyModel;", "Ltv/danmaku/bili/auth/AuthLoginModel;", "status", "", "<init>", "(Ljava/lang/Integer;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "showLoading", "", "showFailed", "showSuccess", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthEmptyModel implements AuthLoginModel {
    public static final int $stable = 0;
    private final Integer status;

    public AuthEmptyModel() {
        this(null, 1, null);
    }

    public AuthEmptyModel(Integer status) {
        this.status = status;
    }

    public /* synthetic */ AuthEmptyModel(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final boolean showLoading() {
        Integer num = this.status;
        return num != null && num.intValue() == 3;
    }

    public final boolean showFailed() {
        Integer num = this.status;
        return num != null && num.intValue() == 2;
    }

    public final boolean showSuccess() {
        Integer num = this.status;
        return num != null && num.intValue() == 1;
    }
}