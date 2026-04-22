package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u001b"}, d2 = {"Lkntr/base/imageloader/BlurOption;", "", "radius", "Lkntr/base/imageloader/Radius;", "sigma", "Lkntr/base/imageloader/Sigma;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRadius-tNbwJAw", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSigma-UajuqIQ", "component1", "component1-tNbwJAw", "component2", "component2-UajuqIQ", "copy", "copy-spsopnQ", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/base/imageloader/BlurOption;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BlurOption {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final BlurOption UNSET = new BlurOption(Radius.Companion.m1557getUNSETtNbwJAw(), Sigma.Companion.m1571getUNSETUajuqIQ(), null);
    private final Integer radius;
    private final Integer sigma;

    public /* synthetic */ BlurOption(Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2);
    }

    /* renamed from: copy-spsopnQ$default  reason: not valid java name */
    public static /* synthetic */ BlurOption m1439copyspsopnQ$default(BlurOption blurOption, Radius radius, Sigma sigma, int i, Object obj) {
        if ((i & 1) != 0) {
            radius = Radius.m1549boximpl(blurOption.radius);
        }
        if ((i & 2) != 0) {
            sigma = Sigma.m1564boximpl(blurOption.sigma);
        }
        return blurOption.m1442copyspsopnQ(radius.m1556unboximpl(), sigma.m1570unboximpl());
    }

    /* renamed from: component1-tNbwJAw  reason: not valid java name */
    public final Integer m1440component1tNbwJAw() {
        return this.radius;
    }

    /* renamed from: component2-UajuqIQ  reason: not valid java name */
    public final Integer m1441component2UajuqIQ() {
        return this.sigma;
    }

    /* renamed from: copy-spsopnQ  reason: not valid java name */
    public final BlurOption m1442copyspsopnQ(Integer num, Integer num2) {
        return new BlurOption(num, num2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlurOption) {
            BlurOption blurOption = (BlurOption) obj;
            return Radius.m1552equalsimpl0(this.radius, blurOption.radius) && Sigma.m1567equalsimpl0(this.sigma, blurOption.sigma);
        }
        return false;
    }

    public int hashCode() {
        return (Radius.m1553hashCodeimpl(this.radius) * 31) + Sigma.m1568hashCodeimpl(this.sigma);
    }

    public String toString() {
        String m1555toStringimpl = Radius.m1555toStringimpl(this.radius);
        return "BlurOption(radius=" + m1555toStringimpl + ", sigma=" + Sigma.m1569toStringimpl(this.sigma) + ")";
    }

    private BlurOption(Integer radius, Integer sigma) {
        this.radius = radius;
        this.sigma = sigma;
    }

    /* renamed from: getRadius-tNbwJAw  reason: not valid java name */
    public final Integer m1443getRadiustNbwJAw() {
        return this.radius;
    }

    /* renamed from: getSigma-UajuqIQ  reason: not valid java name */
    public final Integer m1444getSigmaUajuqIQ() {
        return this.sigma;
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/imageloader/BlurOption$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/BlurOption;", "getUNSET", "()Lkntr/base/imageloader/BlurOption;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlurOption getUNSET() {
            return BlurOption.UNSET;
        }
    }
}