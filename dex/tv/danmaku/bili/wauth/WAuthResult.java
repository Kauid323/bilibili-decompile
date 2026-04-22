package tv.danmaku.bili.wauth;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WAuthInvoker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\""}, d2 = {"Ltv/danmaku/bili/wauth/WAuthResult;", "", "success", "", "bizSeq", "", "idCardAuthData", "certPwdData", "errorCode", "message", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getBizSeq", "()Ljava/lang/String;", "getIdCardAuthData", "getCertPwdData", "getErrorCode", "getMessage", "isUninstall", "isCancel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WAuthResult {
    private final String bizSeq;
    private final String certPwdData;
    private final String errorCode;
    private final String idCardAuthData;
    private final String message;
    private final boolean success;

    public static /* synthetic */ WAuthResult copy$default(WAuthResult wAuthResult, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = wAuthResult.success;
        }
        if ((i & 2) != 0) {
            str = wAuthResult.bizSeq;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = wAuthResult.idCardAuthData;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = wAuthResult.certPwdData;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = wAuthResult.errorCode;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = wAuthResult.message;
        }
        return wAuthResult.copy(z, str6, str7, str8, str9, str5);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.bizSeq;
    }

    public final String component3() {
        return this.idCardAuthData;
    }

    public final String component4() {
        return this.certPwdData;
    }

    public final String component5() {
        return this.errorCode;
    }

    public final String component6() {
        return this.message;
    }

    public final WAuthResult copy(boolean z, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "bizSeq");
        Intrinsics.checkNotNullParameter(str2, "idCardAuthData");
        Intrinsics.checkNotNullParameter(str3, "certPwdData");
        Intrinsics.checkNotNullParameter(str4, "errorCode");
        Intrinsics.checkNotNullParameter(str5, "message");
        return new WAuthResult(z, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WAuthResult) {
            WAuthResult wAuthResult = (WAuthResult) obj;
            return this.success == wAuthResult.success && Intrinsics.areEqual(this.bizSeq, wAuthResult.bizSeq) && Intrinsics.areEqual(this.idCardAuthData, wAuthResult.idCardAuthData) && Intrinsics.areEqual(this.certPwdData, wAuthResult.certPwdData) && Intrinsics.areEqual(this.errorCode, wAuthResult.errorCode) && Intrinsics.areEqual(this.message, wAuthResult.message);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success) * 31) + this.bizSeq.hashCode()) * 31) + this.idCardAuthData.hashCode()) * 31) + this.certPwdData.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        boolean z = this.success;
        String str = this.bizSeq;
        String str2 = this.idCardAuthData;
        String str3 = this.certPwdData;
        String str4 = this.errorCode;
        return "WAuthResult(success=" + z + ", bizSeq=" + str + ", idCardAuthData=" + str2 + ", certPwdData=" + str3 + ", errorCode=" + str4 + ", message=" + this.message + ")";
    }

    public WAuthResult(boolean success, String bizSeq, String idCardAuthData, String certPwdData, String errorCode, String message) {
        Intrinsics.checkNotNullParameter(bizSeq, "bizSeq");
        Intrinsics.checkNotNullParameter(idCardAuthData, "idCardAuthData");
        Intrinsics.checkNotNullParameter(certPwdData, "certPwdData");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(message, "message");
        this.success = success;
        this.bizSeq = bizSeq;
        this.idCardAuthData = idCardAuthData;
        this.certPwdData = certPwdData;
        this.errorCode = errorCode;
        this.message = message;
    }

    public /* synthetic */ WAuthResult(boolean z, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) == 0 ? str5 : "");
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getBizSeq() {
        return this.bizSeq;
    }

    public final String getIdCardAuthData() {
        return this.idCardAuthData;
    }

    public final String getCertPwdData() {
        return this.certPwdData;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean isUninstall() {
        return Intrinsics.areEqual(this.errorCode, WAuthErrorMsg.ERROR_CODE_UNINSTALLED);
    }

    public final boolean isCancel() {
        return Intrinsics.areEqual(this.errorCode, "1") || Intrinsics.areEqual(this.errorCode, WAuthErrorMsg.CODE_WAUTH_CANCEL);
    }
}