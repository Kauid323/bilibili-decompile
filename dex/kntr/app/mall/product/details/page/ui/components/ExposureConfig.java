package kntr.app.mall.product.details.page.ui.components;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkntr/app/mall/product/details/page/ui/components/ExposureConfig;", "", "repeatable", "", "visibleProportion", "", "visiblePixelAbsolute", "", "visibleDuration", "", "<init>", "(ZFIJ)V", "getRepeatable", "()Z", "getVisibleProportion", "()F", "getVisiblePixelAbsolute", "()I", "getVisibleDuration", "()J", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExposureConfig {
    public static final int $stable = 0;
    private final boolean repeatable;
    private final long visibleDuration;
    private final int visiblePixelAbsolute;
    private final float visibleProportion;

    public ExposureConfig() {
        this(false, 0.0f, 0, 0L, 15, null);
    }

    public ExposureConfig(boolean repeatable, float visibleProportion, int visiblePixelAbsolute, long visibleDuration) {
        this.repeatable = repeatable;
        this.visibleProportion = visibleProportion;
        this.visiblePixelAbsolute = visiblePixelAbsolute;
        this.visibleDuration = visibleDuration;
    }

    public /* synthetic */ ExposureConfig(boolean z, float f, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? 0L : j);
    }

    public final boolean getRepeatable() {
        return this.repeatable;
    }

    public final float getVisibleProportion() {
        return this.visibleProportion;
    }

    public final int getVisiblePixelAbsolute() {
        return this.visiblePixelAbsolute;
    }

    public final long getVisibleDuration() {
        return this.visibleDuration;
    }
}