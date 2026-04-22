package tv.danmaku.bili.push.pushsetting.manufacturer;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: ManufacturerCallbackData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/manufacturer/ManufacturerCallbackData;", "", "hasShow", "", "showFrom", "", "success", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", "pushType", "<init>", "(ZLjava/lang/String;ZII)V", "getHasShow", "()Z", "getShowFrom", "()Ljava/lang/String;", "getSuccess", "getCode", "()I", "getPushType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ManufacturerCallbackData {
    public static final int $stable = 0;
    private final int code;
    private final boolean hasShow;
    private final int pushType;
    private final String showFrom;
    private final boolean success;

    public static /* synthetic */ ManufacturerCallbackData copy$default(ManufacturerCallbackData manufacturerCallbackData, boolean z, String str, boolean z2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = manufacturerCallbackData.hasShow;
        }
        if ((i3 & 2) != 0) {
            str = manufacturerCallbackData.showFrom;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            z2 = manufacturerCallbackData.success;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            i = manufacturerCallbackData.code;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = manufacturerCallbackData.pushType;
        }
        return manufacturerCallbackData.copy(z, str2, z3, i4, i2);
    }

    public final boolean component1() {
        return this.hasShow;
    }

    public final String component2() {
        return this.showFrom;
    }

    public final boolean component3() {
        return this.success;
    }

    public final int component4() {
        return this.code;
    }

    public final int component5() {
        return this.pushType;
    }

    public final ManufacturerCallbackData copy(boolean z, String str, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "showFrom");
        return new ManufacturerCallbackData(z, str, z2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ManufacturerCallbackData) {
            ManufacturerCallbackData manufacturerCallbackData = (ManufacturerCallbackData) obj;
            return this.hasShow == manufacturerCallbackData.hasShow && Intrinsics.areEqual(this.showFrom, manufacturerCallbackData.showFrom) && this.success == manufacturerCallbackData.success && this.code == manufacturerCallbackData.code && this.pushType == manufacturerCallbackData.pushType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasShow) * 31) + this.showFrom.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success)) * 31) + this.code) * 31) + this.pushType;
    }

    public String toString() {
        boolean z = this.hasShow;
        String str = this.showFrom;
        boolean z2 = this.success;
        int i = this.code;
        return "ManufacturerCallbackData(hasShow=" + z + ", showFrom=" + str + ", success=" + z2 + ", code=" + i + ", pushType=" + this.pushType + ")";
    }

    public ManufacturerCallbackData(boolean hasShow, String showFrom, boolean success, int code, int pushType) {
        Intrinsics.checkNotNullParameter(showFrom, "showFrom");
        this.hasShow = hasShow;
        this.showFrom = showFrom;
        this.success = success;
        this.code = code;
        this.pushType = pushType;
    }

    public final boolean getHasShow() {
        return this.hasShow;
    }

    public final String getShowFrom() {
        return this.showFrom;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getPushType() {
        return this.pushType;
    }
}