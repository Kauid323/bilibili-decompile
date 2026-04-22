package video.interfacee.bridge.freeBandwidth;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFreeBandwidth.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lvideo/interfacee/bridge/freeBandwidth/BandwidthResult;", "", "url", "", "success", "", "errorCode", "", "<init>", "(Ljava/lang/String;ZI)V", "getUrl", "()Ljava/lang/String;", "getSuccess", "()Z", "getErrorCode", "()I", "toString", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "bridge_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BandwidthResult {
    private final int errorCode;
    private final boolean success;
    private final String url;

    public static /* synthetic */ BandwidthResult copy$default(BandwidthResult bandwidthResult, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bandwidthResult.url;
        }
        if ((i2 & 2) != 0) {
            z = bandwidthResult.success;
        }
        if ((i2 & 4) != 0) {
            i = bandwidthResult.errorCode;
        }
        return bandwidthResult.copy(str, z, i);
    }

    public final String component1() {
        return this.url;
    }

    public final boolean component2() {
        return this.success;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final BandwidthResult copy(String str, boolean z, int i) {
        return new BandwidthResult(str, z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BandwidthResult) {
            BandwidthResult bandwidthResult = (BandwidthResult) obj;
            return Intrinsics.areEqual(this.url, bandwidthResult.url) && this.success == bandwidthResult.success && this.errorCode == bandwidthResult.errorCode;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success)) * 31) + this.errorCode;
    }

    public BandwidthResult(String url, boolean success, int errorCode) {
        this.url = url;
        this.success = success;
        this.errorCode = errorCode;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        String str = this.url;
        boolean z = this.success;
        return "BandwidthResult(url='" + str + "', success=" + z + ", errorCode=" + this.errorCode + ")";
    }
}