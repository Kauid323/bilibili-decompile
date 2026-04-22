package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMMossBusinessException.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lim/base/IMMossBusinessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorMsg", "", "<init>", "(JLjava/lang/String;)V", "getErrorCode", "()J", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMMossBusinessException extends Exception {
    private final long errorCode;
    private final String errorMsg;

    public static /* synthetic */ IMMossBusinessException copy$default(IMMossBusinessException iMMossBusinessException, long j, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = iMMossBusinessException.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = iMMossBusinessException.errorMsg;
        }
        return iMMossBusinessException.copy(j, str);
    }

    public final long component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final IMMossBusinessException copy(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        return new IMMossBusinessException(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMMossBusinessException) {
            IMMossBusinessException iMMossBusinessException = (IMMossBusinessException) obj;
            return this.errorCode == iMMossBusinessException.errorCode && Intrinsics.areEqual(this.errorMsg, iMMossBusinessException.errorMsg);
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.errorCode) * 31) + this.errorMsg.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        long j = this.errorCode;
        return "IMMossBusinessException(errorCode=" + j + ", errorMsg=" + this.errorMsg + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMMossBusinessException(long errorCode, String errorMsg) {
        super(errorMsg);
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public final long getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }
}