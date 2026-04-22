package tv.danmaku.bili.quick.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: initOnePassLoginLog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginError;", "", "time", "", "list", "", "Ltv/danmaku/bili/quick/core/OnePassLoginErrorData;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTime", "()Ljava/lang/String;", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginError {
    public static final int $stable = 0;
    private final List<OnePassLoginErrorData> list;
    private final String time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnePassLoginError copy$default(OnePassLoginError onePassLoginError, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onePassLoginError.time;
        }
        if ((i & 2) != 0) {
            list = onePassLoginError.list;
        }
        return onePassLoginError.copy(str, list);
    }

    public final String component1() {
        return this.time;
    }

    public final List<OnePassLoginErrorData> component2() {
        return this.list;
    }

    public final OnePassLoginError copy(String str, List<OnePassLoginErrorData> list) {
        Intrinsics.checkNotNullParameter(str, "time");
        Intrinsics.checkNotNullParameter(list, "list");
        return new OnePassLoginError(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnePassLoginError) {
            OnePassLoginError onePassLoginError = (OnePassLoginError) obj;
            return Intrinsics.areEqual(this.time, onePassLoginError.time) && Intrinsics.areEqual(this.list, onePassLoginError.list);
        }
        return false;
    }

    public int hashCode() {
        return (this.time.hashCode() * 31) + this.list.hashCode();
    }

    public String toString() {
        String str = this.time;
        return "OnePassLoginError(time=" + str + ", list=" + this.list + ")";
    }

    public OnePassLoginError(String time, List<OnePassLoginErrorData> list) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(list, "list");
        this.time = time;
        this.list = list;
    }

    public final String getTime() {
        return this.time;
    }

    public final List<OnePassLoginErrorData> getList() {
        return this.list;
    }
}