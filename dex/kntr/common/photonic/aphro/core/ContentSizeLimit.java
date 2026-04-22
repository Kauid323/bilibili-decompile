package kntr.common.photonic.aphro.core;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006 "}, d2 = {"Lkntr/common/photonic/aphro/core/ContentSizeLimit;", "", "maxLimit", "Lkntr/common/photonic/ContentSize;", "toastOnExceeded", "", "animatedImageMaxLimit", "animatedImageToastOnExceeded", "<init>", "(DLjava/lang/String;DLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxLimit-QJZHGII", "()D", "D", "getToastOnExceeded", "()Ljava/lang/String;", "getAnimatedImageMaxLimit-QJZHGII", "getAnimatedImageToastOnExceeded", "component1", "component1-QJZHGII", "component2", "component3", "component3-QJZHGII", "component4", "copy", "copy-B3MAfaU", "(DLjava/lang/String;DLjava/lang/String;)Lkntr/common/photonic/aphro/core/ContentSizeLimit;", "equals", "", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ContentSizeLimit {
    public static final int $stable = 0;
    private final double animatedImageMaxLimit;
    private final String animatedImageToastOnExceeded;
    private final double maxLimit;
    private final String toastOnExceeded;

    public /* synthetic */ ContentSizeLimit(double d, String str, double d2, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, str, d2, str2);
    }

    /* renamed from: copy-B3MAfaU$default  reason: not valid java name */
    public static /* synthetic */ ContentSizeLimit m2215copyB3MAfaU$default(ContentSizeLimit contentSizeLimit, double d, String str, double d2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = contentSizeLimit.maxLimit;
        }
        double d3 = d;
        if ((i & 2) != 0) {
            str = contentSizeLimit.toastOnExceeded;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            d2 = contentSizeLimit.animatedImageMaxLimit;
        }
        double d4 = d2;
        if ((i & 8) != 0) {
            str2 = contentSizeLimit.animatedImageToastOnExceeded;
        }
        return contentSizeLimit.m2218copyB3MAfaU(d3, str3, d4, str2);
    }

    /* renamed from: component1-QJZHGII  reason: not valid java name */
    public final double m2216component1QJZHGII() {
        return this.maxLimit;
    }

    public final String component2() {
        return this.toastOnExceeded;
    }

    /* renamed from: component3-QJZHGII  reason: not valid java name */
    public final double m2217component3QJZHGII() {
        return this.animatedImageMaxLimit;
    }

    public final String component4() {
        return this.animatedImageToastOnExceeded;
    }

    /* renamed from: copy-B3MAfaU  reason: not valid java name */
    public final ContentSizeLimit m2218copyB3MAfaU(double d, String str, double d2, String str2) {
        return new ContentSizeLimit(d, str, d2, str2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentSizeLimit) {
            ContentSizeLimit contentSizeLimit = (ContentSizeLimit) obj;
            return ContentSize.m2186equalsimpl0(this.maxLimit, contentSizeLimit.maxLimit) && Intrinsics.areEqual(this.toastOnExceeded, contentSizeLimit.toastOnExceeded) && ContentSize.m2186equalsimpl0(this.animatedImageMaxLimit, contentSizeLimit.animatedImageMaxLimit) && Intrinsics.areEqual(this.animatedImageToastOnExceeded, contentSizeLimit.animatedImageToastOnExceeded);
        }
        return false;
    }

    public int hashCode() {
        return (((((ContentSize.m2190hashCodeimpl(this.maxLimit) * 31) + (this.toastOnExceeded == null ? 0 : this.toastOnExceeded.hashCode())) * 31) + ContentSize.m2190hashCodeimpl(this.animatedImageMaxLimit)) * 31) + (this.animatedImageToastOnExceeded != null ? this.animatedImageToastOnExceeded.hashCode() : 0);
    }

    public String toString() {
        String m2193toStringimpl = ContentSize.m2193toStringimpl(this.maxLimit);
        String str = this.toastOnExceeded;
        String m2193toStringimpl2 = ContentSize.m2193toStringimpl(this.animatedImageMaxLimit);
        return "ContentSizeLimit(maxLimit=" + m2193toStringimpl + ", toastOnExceeded=" + str + ", animatedImageMaxLimit=" + m2193toStringimpl2 + ", animatedImageToastOnExceeded=" + this.animatedImageToastOnExceeded + ")";
    }

    private ContentSizeLimit(double maxLimit, String toastOnExceeded, double animatedImageMaxLimit, String animatedImageToastOnExceeded) {
        this.maxLimit = maxLimit;
        this.toastOnExceeded = toastOnExceeded;
        this.animatedImageMaxLimit = animatedImageMaxLimit;
        this.animatedImageToastOnExceeded = animatedImageToastOnExceeded;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ContentSizeLimit(double d, String str, double d2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, str, r5, r7, null);
        double d3;
        String str3;
        if ((i & 4) == 0) {
            d3 = d2;
        } else {
            d3 = d;
        }
        if ((i & 8) == 0) {
            str3 = str2;
        } else {
            str3 = str;
        }
    }

    /* renamed from: getMaxLimit-QJZHGII  reason: not valid java name */
    public final double m2220getMaxLimitQJZHGII() {
        return this.maxLimit;
    }

    public final String getToastOnExceeded() {
        return this.toastOnExceeded;
    }

    /* renamed from: getAnimatedImageMaxLimit-QJZHGII  reason: not valid java name */
    public final double m2219getAnimatedImageMaxLimitQJZHGII() {
        return this.animatedImageMaxLimit;
    }

    public final String getAnimatedImageToastOnExceeded() {
        return this.animatedImageToastOnExceeded;
    }
}