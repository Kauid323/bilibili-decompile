package kntr.app.deepsearch.base.model.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchToast.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", RoomRecommendViewModel.EMPTY_CURSOR, "errorMsg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLjava/lang/String;)V", "getErrorCode", "()J", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchException extends Exception {
    private final long errorCode;
    private final String errorMsg;

    public static /* synthetic */ DeepSearchException copy$default(DeepSearchException deepSearchException, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = deepSearchException.errorCode;
        }
        if ((i & 2) != 0) {
            str = deepSearchException.errorMsg;
        }
        return deepSearchException.copy(j2, str);
    }

    public final long component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final DeepSearchException copy(long j2, String str) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        return new DeepSearchException(j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchException) {
            DeepSearchException deepSearchException = (DeepSearchException) obj;
            return this.errorCode == deepSearchException.errorCode && Intrinsics.areEqual(this.errorMsg, deepSearchException.errorMsg);
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.errorCode) * 31) + this.errorMsg.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        long j2 = this.errorCode;
        return "DeepSearchException(errorCode=" + j2 + ", errorMsg=" + this.errorMsg + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchException(long errorCode, String errorMsg) {
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