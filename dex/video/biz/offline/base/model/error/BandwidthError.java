package video.biz.offline.base.model.error;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DownloadException.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/base/model/error/BandwidthError;", "Lvideo/biz/offline/base/model/error/OfflineErrorCode;", "code", "", "<init>", "(I)V", "getCode", "()I", "errorCode", "getErrorCode", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BandwidthError implements OfflineErrorCode {
    public static final int $stable = 0;
    private final int code;

    public static /* synthetic */ BandwidthError copy$default(BandwidthError bandwidthError, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bandwidthError.code;
        }
        return bandwidthError.copy(i);
    }

    public final int component1() {
        return this.code;
    }

    public final BandwidthError copy(int i) {
        return new BandwidthError(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BandwidthError) && this.code == ((BandwidthError) obj).code;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return "BandwidthError(code=" + this.code + ")";
    }

    public BandwidthError(int code) {
        this.code = code;
    }

    @Override // video.biz.offline.base.model.error.OfflineErrorCode
    public int getCode() {
        return this.code;
    }

    public final int getErrorCode() {
        return OfflineError.INSTANCE.generateErrorCode(OfflineErrorType.BANDWIDTH_ERROR, this);
    }
}