package tv.danmaku.bili.quick.core;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: OnePassLoginPathLinkManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhoneData;", "", "netType", "Ltv/danmaku/bili/quick/core/NetType;", "hasSim", "", "isPad", "<init>", "(Ltv/danmaku/bili/quick/core/NetType;ZZ)V", "netTypeString", "", "(Ljava/lang/String;ZZ)V", "getNetType", "()Ltv/danmaku/bili/quick/core/NetType;", "getHasSim", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginPhoneData {
    public static final int $stable = 0;
    private final boolean hasSim;
    private final boolean isPad;
    private final NetType netType;

    public static /* synthetic */ OnePassLoginPhoneData copy$default(OnePassLoginPhoneData onePassLoginPhoneData, NetType netType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            netType = onePassLoginPhoneData.netType;
        }
        if ((i & 2) != 0) {
            z = onePassLoginPhoneData.hasSim;
        }
        if ((i & 4) != 0) {
            z2 = onePassLoginPhoneData.isPad;
        }
        return onePassLoginPhoneData.copy(netType, z, z2);
    }

    public final NetType component1() {
        return this.netType;
    }

    public final boolean component2() {
        return this.hasSim;
    }

    public final boolean component3() {
        return this.isPad;
    }

    public final OnePassLoginPhoneData copy(NetType netType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(netType, "netType");
        return new OnePassLoginPhoneData(netType, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnePassLoginPhoneData) {
            OnePassLoginPhoneData onePassLoginPhoneData = (OnePassLoginPhoneData) obj;
            return this.netType == onePassLoginPhoneData.netType && this.hasSim == onePassLoginPhoneData.hasSim && this.isPad == onePassLoginPhoneData.isPad;
        }
        return false;
    }

    public int hashCode() {
        return (((this.netType.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasSim)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isPad);
    }

    public String toString() {
        NetType netType = this.netType;
        boolean z = this.hasSim;
        return "OnePassLoginPhoneData(netType=" + netType + ", hasSim=" + z + ", isPad=" + this.isPad + ")";
    }

    public OnePassLoginPhoneData(NetType netType, boolean hasSim, boolean isPad) {
        Intrinsics.checkNotNullParameter(netType, "netType");
        this.netType = netType;
        this.hasSim = hasSim;
        this.isPad = isPad;
    }

    public final NetType getNetType() {
        return this.netType;
    }

    public final boolean getHasSim() {
        return this.hasSim;
    }

    public final boolean isPad() {
        return this.isPad;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OnePassLoginPhoneData(String netTypeString, boolean hasSim, boolean isPad) {
        this(r0, hasSim, isPad);
        NetType netType;
        Intrinsics.checkNotNullParameter(netTypeString, "netTypeString");
        switch (netTypeString.hashCode()) {
            case BR.banner /* 49 */:
                if (netTypeString.equals("1")) {
                    netType = NetType.Mobile;
                    break;
                }
                netType = NetType.None;
                break;
            case BR.bannerControl /* 50 */:
                if (netTypeString.equals("2")) {
                    netType = NetType.Unicom;
                    break;
                }
                netType = NetType.None;
                break;
            case BR.bannerItemDataList /* 51 */:
                if (netTypeString.equals("3")) {
                    netType = NetType.Telecom;
                    break;
                }
                netType = NetType.None;
                break;
            default:
                netType = NetType.None;
                break;
        }
    }
}