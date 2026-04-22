package tv.danmaku.bili.splash.ad.test;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SplashLiteData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\b\u0081\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0081\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00062"}, d2 = {"Ltv/danmaku/bili/splash/ad/test/SplashLiteData;", "", "id", "", "cardType", "", "type", "beginTime", "", "endTime", "exposeCount", "lastExposeTime", "imageReady", "", "videoReady", "imageHash", "videoHash", "<init>", "(JIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getCardType", "()I", "getType", "getBeginTime", "()Ljava/lang/String;", "getEndTime", "getExposeCount", "getLastExposeTime", "getImageReady", "()Z", "getVideoReady", "getImageHash", "getVideoHash", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashLiteData {
    public static final int $stable = 0;
    private final String beginTime;
    private final int cardType;
    private final String endTime;
    private final int exposeCount;
    private final long id;
    private final String imageHash;
    private final boolean imageReady;
    private final String lastExposeTime;
    private final int type;
    private final String videoHash;
    private final boolean videoReady;

    public SplashLiteData() {
        this(0L, 0, 0, null, null, 0, null, false, false, null, null, 2047, null);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.imageHash;
    }

    public final String component11() {
        return this.videoHash;
    }

    public final int component2() {
        return this.cardType;
    }

    public final int component3() {
        return this.type;
    }

    public final String component4() {
        return this.beginTime;
    }

    public final String component5() {
        return this.endTime;
    }

    public final int component6() {
        return this.exposeCount;
    }

    public final String component7() {
        return this.lastExposeTime;
    }

    public final boolean component8() {
        return this.imageReady;
    }

    public final boolean component9() {
        return this.videoReady;
    }

    public final SplashLiteData copy(long j, int i, int i2, String str, String str2, int i3, String str3, boolean z, boolean z2, String str4, String str5) {
        return new SplashLiteData(j, i, i2, str, str2, i3, str3, z, z2, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashLiteData) {
            SplashLiteData splashLiteData = (SplashLiteData) obj;
            return this.id == splashLiteData.id && this.cardType == splashLiteData.cardType && this.type == splashLiteData.type && Intrinsics.areEqual(this.beginTime, splashLiteData.beginTime) && Intrinsics.areEqual(this.endTime, splashLiteData.endTime) && this.exposeCount == splashLiteData.exposeCount && Intrinsics.areEqual(this.lastExposeTime, splashLiteData.lastExposeTime) && this.imageReady == splashLiteData.imageReady && this.videoReady == splashLiteData.videoReady && Intrinsics.areEqual(this.imageHash, splashLiteData.imageHash) && Intrinsics.areEqual(this.videoHash, splashLiteData.videoHash);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.cardType) * 31) + this.type) * 31) + (this.beginTime == null ? 0 : this.beginTime.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + this.exposeCount) * 31) + (this.lastExposeTime == null ? 0 : this.lastExposeTime.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.imageReady)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.videoReady)) * 31) + (this.imageHash == null ? 0 : this.imageHash.hashCode())) * 31) + (this.videoHash != null ? this.videoHash.hashCode() : 0);
    }

    public String toString() {
        long j = this.id;
        int i = this.cardType;
        int i2 = this.type;
        String str = this.beginTime;
        String str2 = this.endTime;
        int i3 = this.exposeCount;
        String str3 = this.lastExposeTime;
        boolean z = this.imageReady;
        boolean z2 = this.videoReady;
        String str4 = this.imageHash;
        return "SplashLiteData(id=" + j + ", cardType=" + i + ", type=" + i2 + ", beginTime=" + str + ", endTime=" + str2 + ", exposeCount=" + i3 + ", lastExposeTime=" + str3 + ", imageReady=" + z + ", videoReady=" + z2 + ", imageHash=" + str4 + ", videoHash=" + this.videoHash + ")";
    }

    public SplashLiteData(long id, int cardType, int type, String beginTime, String endTime, int exposeCount, String lastExposeTime, boolean imageReady, boolean videoReady, String imageHash, String videoHash) {
        this.id = id;
        this.cardType = cardType;
        this.type = type;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.exposeCount = exposeCount;
        this.lastExposeTime = lastExposeTime;
        this.imageReady = imageReady;
        this.videoReady = videoReady;
        this.imageHash = imageHash;
        this.videoHash = videoHash;
    }

    public /* synthetic */ SplashLiteData(long j, int i, int i2, String str, String str2, int i3, String str3, boolean z, boolean z2, String str4, String str5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? null : str, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? null : str3, (i4 & BR.cover) != 0 ? false : z, (i4 & BR.hallEnterHotText) == 0 ? z2 : false, (i4 & BR.roleType) != 0 ? null : str4, (i4 & MisakaHelper.MAX_REPORT_SIZE) == 0 ? str5 : null);
    }

    public final long getId() {
        return this.id;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final int getType() {
        return this.type;
    }

    public final String getBeginTime() {
        return this.beginTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final int getExposeCount() {
        return this.exposeCount;
    }

    public final String getLastExposeTime() {
        return this.lastExposeTime;
    }

    public final boolean getImageReady() {
        return this.imageReady;
    }

    public final boolean getVideoReady() {
        return this.videoReady;
    }

    public final String getImageHash() {
        return this.imageHash;
    }

    public final String getVideoHash() {
        return this.videoHash;
    }
}