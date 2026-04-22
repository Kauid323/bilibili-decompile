package tv.danmaku.bili.quick.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: initOnePassLoginLog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginErrorData;", "", "phaseStatus", "", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPhaseStatus", "()Ljava/lang/String;", "getError", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginErrorData {
    public static final int $stable = 0;
    private final String error;
    private final String phaseStatus;

    public static /* synthetic */ OnePassLoginErrorData copy$default(OnePassLoginErrorData onePassLoginErrorData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onePassLoginErrorData.phaseStatus;
        }
        if ((i & 2) != 0) {
            str2 = onePassLoginErrorData.error;
        }
        return onePassLoginErrorData.copy(str, str2);
    }

    public final String component1() {
        return this.phaseStatus;
    }

    public final String component2() {
        return this.error;
    }

    public final OnePassLoginErrorData copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "phaseStatus");
        Intrinsics.checkNotNullParameter(str2, "error");
        return new OnePassLoginErrorData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnePassLoginErrorData) {
            OnePassLoginErrorData onePassLoginErrorData = (OnePassLoginErrorData) obj;
            return Intrinsics.areEqual(this.phaseStatus, onePassLoginErrorData.phaseStatus) && Intrinsics.areEqual(this.error, onePassLoginErrorData.error);
        }
        return false;
    }

    public int hashCode() {
        return (this.phaseStatus.hashCode() * 31) + this.error.hashCode();
    }

    public String toString() {
        String str = this.phaseStatus;
        return "OnePassLoginErrorData(phaseStatus=" + str + ", error=" + this.error + ")";
    }

    public OnePassLoginErrorData(String phaseStatus, String error) {
        Intrinsics.checkNotNullParameter(phaseStatus, "phaseStatus");
        Intrinsics.checkNotNullParameter(error, "error");
        this.phaseStatus = phaseStatus;
        this.error = error;
    }

    public final String getPhaseStatus() {
        return this.phaseStatus;
    }

    public final String getError() {
        return this.error;
    }
}