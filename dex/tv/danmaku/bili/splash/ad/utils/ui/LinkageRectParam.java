package tv.danmaku.bili.splash.ad.utils.ui;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BusinessSplashAnimatorHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Ltv/danmaku/bili/splash/ad/utils/ui/LinkageRectParam;", "", "originWidth", "", "originHeight", "targetWidth", "targetHeight", "targetLeftMargin", "targetRightMargin", "targetTopMargin", "targetBottomMargin", "targetRadius", "<init>", "(IIIIIIIII)V", "getOriginWidth", "()I", "getOriginHeight", "getTargetWidth", "getTargetHeight", "getTargetLeftMargin", "getTargetRightMargin", "getTargetTopMargin", "getTargetBottomMargin", "getTargetRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LinkageRectParam {
    private final int originHeight;
    private final int originWidth;
    private final int targetBottomMargin;
    private final int targetHeight;
    private final int targetLeftMargin;
    private final int targetRadius;
    private final int targetRightMargin;
    private final int targetTopMargin;
    private final int targetWidth;

    public LinkageRectParam() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, BR.roleTitle, null);
    }

    public final int component1() {
        return this.originWidth;
    }

    public final int component2() {
        return this.originHeight;
    }

    public final int component3() {
        return this.targetWidth;
    }

    public final int component4() {
        return this.targetHeight;
    }

    public final int component5() {
        return this.targetLeftMargin;
    }

    public final int component6() {
        return this.targetRightMargin;
    }

    public final int component7() {
        return this.targetTopMargin;
    }

    public final int component8() {
        return this.targetBottomMargin;
    }

    public final int component9() {
        return this.targetRadius;
    }

    public final LinkageRectParam copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new LinkageRectParam(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LinkageRectParam) {
            LinkageRectParam linkageRectParam = (LinkageRectParam) obj;
            return this.originWidth == linkageRectParam.originWidth && this.originHeight == linkageRectParam.originHeight && this.targetWidth == linkageRectParam.targetWidth && this.targetHeight == linkageRectParam.targetHeight && this.targetLeftMargin == linkageRectParam.targetLeftMargin && this.targetRightMargin == linkageRectParam.targetRightMargin && this.targetTopMargin == linkageRectParam.targetTopMargin && this.targetBottomMargin == linkageRectParam.targetBottomMargin && this.targetRadius == linkageRectParam.targetRadius;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.originWidth * 31) + this.originHeight) * 31) + this.targetWidth) * 31) + this.targetHeight) * 31) + this.targetLeftMargin) * 31) + this.targetRightMargin) * 31) + this.targetTopMargin) * 31) + this.targetBottomMargin) * 31) + this.targetRadius;
    }

    public String toString() {
        int i = this.originWidth;
        int i2 = this.originHeight;
        int i3 = this.targetWidth;
        int i4 = this.targetHeight;
        int i5 = this.targetLeftMargin;
        int i6 = this.targetRightMargin;
        int i7 = this.targetTopMargin;
        int i8 = this.targetBottomMargin;
        return "LinkageRectParam(originWidth=" + i + ", originHeight=" + i2 + ", targetWidth=" + i3 + ", targetHeight=" + i4 + ", targetLeftMargin=" + i5 + ", targetRightMargin=" + i6 + ", targetTopMargin=" + i7 + ", targetBottomMargin=" + i8 + ", targetRadius=" + this.targetRadius + ")";
    }

    public LinkageRectParam(int originWidth, int originHeight, int targetWidth, int targetHeight, int targetLeftMargin, int targetRightMargin, int targetTopMargin, int targetBottomMargin, int targetRadius) {
        this.originWidth = originWidth;
        this.originHeight = originHeight;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
        this.targetLeftMargin = targetLeftMargin;
        this.targetRightMargin = targetRightMargin;
        this.targetTopMargin = targetTopMargin;
        this.targetBottomMargin = targetBottomMargin;
        this.targetRadius = targetRadius;
    }

    public /* synthetic */ LinkageRectParam(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? Resources.getSystem().getDisplayMetrics().widthPixels : i, (i10 & 2) != 0 ? Resources.getSystem().getDisplayMetrics().heightPixels : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & BR.cover) != 0 ? 0 : i8, (i10 & BR.hallEnterHotText) == 0 ? i9 : 0);
    }

    public final int getOriginWidth() {
        return this.originWidth;
    }

    public final int getOriginHeight() {
        return this.originHeight;
    }

    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public final int getTargetLeftMargin() {
        return this.targetLeftMargin;
    }

    public final int getTargetRightMargin() {
        return this.targetRightMargin;
    }

    public final int getTargetTopMargin() {
        return this.targetTopMargin;
    }

    public final int getTargetBottomMargin() {
        return this.targetBottomMargin;
    }

    public final int getTargetRadius() {
        return this.targetRadius;
    }
}