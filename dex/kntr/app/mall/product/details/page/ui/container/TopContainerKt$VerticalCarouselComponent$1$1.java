package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.animation.core.Easing;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopContainer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class TopContainerKt$VerticalCarouselComponent$1$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TopContainerKt$VerticalCarouselComponent$1$1(Object obj) {
        super(1, obj, Easing.class, "transform", "transform(F)F", 0);
    }

    public final Float invoke(float p0) {
        return Float.valueOf(((Easing) this.receiver).transform(p0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).floatValue());
    }
}