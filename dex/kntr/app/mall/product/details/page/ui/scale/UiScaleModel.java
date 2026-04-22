package kntr.app.mall.product.details.page.ui.scale;

import kntr.app.mall.product.details.page.utils.ConstsKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ProvideUiScale.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "", "scale", "", "<init>", "(F)V", "getScale", "()F", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UiScaleModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final float scale;

    public UiScaleModel(float scale) {
        this.scale = scale;
    }

    public final float getScale() {
        return this.scale;
    }

    /* compiled from: ProvideUiScale.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel$Companion;", "", "<init>", "()V", "create", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "screenWidthDp", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UiScaleModel create(float screenWidthDp) {
            float scale = screenWidthDp / ((float) ConstsKt.DEFAULT_UI_SCREEN_WIDTH);
            return new UiScaleModel(scale);
        }
    }
}