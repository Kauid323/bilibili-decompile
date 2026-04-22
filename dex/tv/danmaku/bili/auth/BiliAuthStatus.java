package tv.danmaku.bili.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthStatus;", "", "<init>", "()V", "currentStatus", "", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "currentFailMsg", "", "getCurrentFailMsg", "()Ljava/lang/String;", "setCurrentFailMsg", "(Ljava/lang/String;)V", "currentErrorCode", "getCurrentErrorCode", "setCurrentErrorCode", "currentName", "getCurrentName", "setCurrentName", "currentCardCode", "getCurrentCardCode", "setCurrentCardCode", "requestId", "getRequestId", "setRequestId", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthStatus {
    private int currentErrorCode;
    private int currentStatus = 3;
    private String currentFailMsg = "";
    private String currentName = "";
    private String currentCardCode = "";
    private String requestId = "";

    public final int getCurrentStatus() {
        return this.currentStatus;
    }

    public final void setCurrentStatus(int i) {
        this.currentStatus = i;
    }

    public final String getCurrentFailMsg() {
        return this.currentFailMsg;
    }

    public final void setCurrentFailMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentFailMsg = str;
    }

    public final int getCurrentErrorCode() {
        return this.currentErrorCode;
    }

    public final void setCurrentErrorCode(int i) {
        this.currentErrorCode = i;
    }

    public final String getCurrentName() {
        return this.currentName;
    }

    public final void setCurrentName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentName = str;
    }

    public final String getCurrentCardCode() {
        return this.currentCardCode;
    }

    public final void setCurrentCardCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentCardCode = str;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }
}