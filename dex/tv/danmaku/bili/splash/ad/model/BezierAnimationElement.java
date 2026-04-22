package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SplashBezierAnimationElement.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003Jß\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\t\u0010M\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001e¨\u0006N"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/BezierAnimationElement;", "", "type", "", "guideImageUrl", "", "guideImageMd5", "guideShowTime", "", "guideShowDuration", "imageUrl", "imageMd5", "duration", "width", "height", "position", "Ltv/danmaku/bili/splash/ad/model/BezierPoint;", "list", "", "Ltv/danmaku/bili/splash/ad/model/BezierAnimationItem;", "topImageUrl", "topImageMd5", "lineColor", "topImageWidth", "topImageHeight", "imageWidth", "imageHeight", "<init>", "(ILjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JIILtv/danmaku/bili/splash/ad/model/BezierPoint;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V", "getType", "()I", "getGuideImageUrl", "()Ljava/lang/String;", "getGuideImageMd5", "getGuideShowTime", "()J", "getGuideShowDuration", "getImageUrl", "getImageMd5", "getDuration", "getWidth", "getHeight", "getPosition", "()Ltv/danmaku/bili/splash/ad/model/BezierPoint;", "getList", "()Ljava/util/List;", "getTopImageUrl", "getTopImageMd5", "getLineColor", "getTopImageWidth", "getTopImageHeight", "getImageWidth", "getImageHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BezierAnimationElement {
    public static final int $stable = 8;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("guide_image_md5")
    private final String guideImageMd5;
    @SerializedName("guide_image_url")
    private final String guideImageUrl;
    @SerializedName("guide_show_duration")
    private final long guideShowDuration;
    @SerializedName("guide_show_time")
    private final long guideShowTime;
    @SerializedName("height")
    private final int height;
    @SerializedName("image_height")
    private final int imageHeight;
    @SerializedName("image_md5")
    private final String imageMd5;
    @SerializedName("image_url")
    private final String imageUrl;
    @SerializedName("image_width")
    private final int imageWidth;
    @SerializedName("line_color")
    private final String lineColor;
    @SerializedName("list")
    private final List<BezierAnimationItem> list;
    @SerializedName("position")
    private final BezierPoint position;
    @SerializedName("top_image_height")
    private final int topImageHeight;
    @SerializedName("top_image_md5")
    private final String topImageMd5;
    @SerializedName("top_image_url")
    private final String topImageUrl;
    @SerializedName("top_image_width")
    private final int topImageWidth;
    @SerializedName("type")
    private final int type;
    @SerializedName("width")
    private final int width;

    public BezierAnimationElement() {
        this(0, null, null, 0L, 0L, null, null, 0L, 0, 0, null, null, null, null, null, 0, 0, 0, 0, 524287, null);
    }

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.height;
    }

    public final BezierPoint component11() {
        return this.position;
    }

    public final List<BezierAnimationItem> component12() {
        return this.list;
    }

    public final String component13() {
        return this.topImageUrl;
    }

    public final String component14() {
        return this.topImageMd5;
    }

    public final String component15() {
        return this.lineColor;
    }

    public final int component16() {
        return this.topImageWidth;
    }

    public final int component17() {
        return this.topImageHeight;
    }

    public final int component18() {
        return this.imageWidth;
    }

    public final int component19() {
        return this.imageHeight;
    }

    public final String component2() {
        return this.guideImageUrl;
    }

    public final String component3() {
        return this.guideImageMd5;
    }

    public final long component4() {
        return this.guideShowTime;
    }

    public final long component5() {
        return this.guideShowDuration;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.imageMd5;
    }

    public final long component8() {
        return this.duration;
    }

    public final int component9() {
        return this.width;
    }

    public final BezierAnimationElement copy(int i, String str, String str2, long j, long j2, String str3, String str4, long j3, int i2, int i3, BezierPoint bezierPoint, List<BezierAnimationItem> list, String str5, String str6, String str7, int i4, int i5, int i6, int i7) {
        return new BezierAnimationElement(i, str, str2, j, j2, str3, str4, j3, i2, i3, bezierPoint, list, str5, str6, str7, i4, i5, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BezierAnimationElement) {
            BezierAnimationElement bezierAnimationElement = (BezierAnimationElement) obj;
            return this.type == bezierAnimationElement.type && Intrinsics.areEqual(this.guideImageUrl, bezierAnimationElement.guideImageUrl) && Intrinsics.areEqual(this.guideImageMd5, bezierAnimationElement.guideImageMd5) && this.guideShowTime == bezierAnimationElement.guideShowTime && this.guideShowDuration == bezierAnimationElement.guideShowDuration && Intrinsics.areEqual(this.imageUrl, bezierAnimationElement.imageUrl) && Intrinsics.areEqual(this.imageMd5, bezierAnimationElement.imageMd5) && this.duration == bezierAnimationElement.duration && this.width == bezierAnimationElement.width && this.height == bezierAnimationElement.height && Intrinsics.areEqual(this.position, bezierAnimationElement.position) && Intrinsics.areEqual(this.list, bezierAnimationElement.list) && Intrinsics.areEqual(this.topImageUrl, bezierAnimationElement.topImageUrl) && Intrinsics.areEqual(this.topImageMd5, bezierAnimationElement.topImageMd5) && Intrinsics.areEqual(this.lineColor, bezierAnimationElement.lineColor) && this.topImageWidth == bezierAnimationElement.topImageWidth && this.topImageHeight == bezierAnimationElement.topImageHeight && this.imageWidth == bezierAnimationElement.imageWidth && this.imageHeight == bezierAnimationElement.imageHeight;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.type * 31) + (this.guideImageUrl == null ? 0 : this.guideImageUrl.hashCode())) * 31) + (this.guideImageMd5 == null ? 0 : this.guideImageMd5.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.guideShowTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.guideShowDuration)) * 31) + (this.imageUrl == null ? 0 : this.imageUrl.hashCode())) * 31) + (this.imageMd5 == null ? 0 : this.imageMd5.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + this.width) * 31) + this.height) * 31) + (this.position == null ? 0 : this.position.hashCode())) * 31) + (this.list == null ? 0 : this.list.hashCode())) * 31) + (this.topImageUrl == null ? 0 : this.topImageUrl.hashCode())) * 31) + (this.topImageMd5 == null ? 0 : this.topImageMd5.hashCode())) * 31) + (this.lineColor != null ? this.lineColor.hashCode() : 0)) * 31) + this.topImageWidth) * 31) + this.topImageHeight) * 31) + this.imageWidth) * 31) + this.imageHeight;
    }

    public String toString() {
        int i = this.type;
        String str = this.guideImageUrl;
        String str2 = this.guideImageMd5;
        long j = this.guideShowTime;
        long j2 = this.guideShowDuration;
        String str3 = this.imageUrl;
        String str4 = this.imageMd5;
        long j3 = this.duration;
        int i2 = this.width;
        int i3 = this.height;
        BezierPoint bezierPoint = this.position;
        List<BezierAnimationItem> list = this.list;
        String str5 = this.topImageUrl;
        String str6 = this.topImageMd5;
        String str7 = this.lineColor;
        int i4 = this.topImageWidth;
        int i5 = this.topImageHeight;
        int i6 = this.imageWidth;
        return "BezierAnimationElement(type=" + i + ", guideImageUrl=" + str + ", guideImageMd5=" + str2 + ", guideShowTime=" + j + ", guideShowDuration=" + j2 + ", imageUrl=" + str3 + ", imageMd5=" + str4 + ", duration=" + j3 + ", width=" + i2 + ", height=" + i3 + ", position=" + bezierPoint + ", list=" + list + ", topImageUrl=" + str5 + ", topImageMd5=" + str6 + ", lineColor=" + str7 + ", topImageWidth=" + i4 + ", topImageHeight=" + i5 + ", imageWidth=" + i6 + ", imageHeight=" + this.imageHeight + ")";
    }

    public BezierAnimationElement(int type, String guideImageUrl, String guideImageMd5, long guideShowTime, long guideShowDuration, String imageUrl, String imageMd5, long duration, int width, int height, BezierPoint position, List<BezierAnimationItem> list, String topImageUrl, String topImageMd5, String lineColor, int topImageWidth, int topImageHeight, int imageWidth, int imageHeight) {
        this.type = type;
        this.guideImageUrl = guideImageUrl;
        this.guideImageMd5 = guideImageMd5;
        this.guideShowTime = guideShowTime;
        this.guideShowDuration = guideShowDuration;
        this.imageUrl = imageUrl;
        this.imageMd5 = imageMd5;
        this.duration = duration;
        this.width = width;
        this.height = height;
        this.position = position;
        this.list = list;
        this.topImageUrl = topImageUrl;
        this.topImageMd5 = topImageMd5;
        this.lineColor = lineColor;
        this.topImageWidth = topImageWidth;
        this.topImageHeight = topImageHeight;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public /* synthetic */ BezierAnimationElement(int i, String str, String str2, long j, long j2, String str3, String str4, long j3, int i2, int i3, BezierPoint bezierPoint, List list, String str5, String str6, String str7, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : str2, (i8 & 8) != 0 ? 0L : j, (i8 & 16) != 0 ? 0L : j2, (i8 & 32) != 0 ? null : str3, (i8 & 64) != 0 ? null : str4, (i8 & BR.cover) == 0 ? j3 : 0L, (i8 & BR.hallEnterHotText) != 0 ? 30 : i2, (i8 & BR.roleType) != 0 ? 0 : i3, (i8 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? null : bezierPoint, (i8 & 2048) != 0 ? null : list, (i8 & 4096) != 0 ? null : str5, (i8 & 8192) != 0 ? null : str6, (i8 & RingBuffer.CONSUME_SIZE) != 0 ? null : str7, (i8 & 32768) != 0 ? 0 : i4, (i8 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? 0 : i5, (i8 & 131072) != 0 ? 0 : i6, (i8 & 262144) != 0 ? 0 : i7);
    }

    public final int getType() {
        return this.type;
    }

    public final String getGuideImageUrl() {
        return this.guideImageUrl;
    }

    public final String getGuideImageMd5() {
        return this.guideImageMd5;
    }

    public final long getGuideShowTime() {
        return this.guideShowTime;
    }

    public final long getGuideShowDuration() {
        return this.guideShowDuration;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getImageMd5() {
        return this.imageMd5;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final BezierPoint getPosition() {
        return this.position;
    }

    public final List<BezierAnimationItem> getList() {
        return this.list;
    }

    public final String getTopImageUrl() {
        return this.topImageUrl;
    }

    public final String getTopImageMd5() {
        return this.topImageMd5;
    }

    public final String getLineColor() {
        return this.lineColor;
    }

    public final int getTopImageWidth() {
        return this.topImageWidth;
    }

    public final int getTopImageHeight() {
        return this.topImageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }
}