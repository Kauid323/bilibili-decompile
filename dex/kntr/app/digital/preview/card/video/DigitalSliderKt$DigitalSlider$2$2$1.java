package kntr.app.digital.preview.card.video;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DigitalSlider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class DigitalSliderKt$DigitalSlider$2$2$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalSliderKt$DigitalSlider$2$2$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
        super(1, Intrinsics.Kotlin.class, "scaleToOffset", "DigitalSlider$lambda$1$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
        this.$valueRange = closedFloatingPointRange;
        this.$minPx = floatRef;
        this.$maxPx = floatRef2;
    }

    public final Float invoke(float p0) {
        float DigitalSlider$lambda$1$scaleToOffset;
        DigitalSlider$lambda$1$scaleToOffset = DigitalSliderKt.DigitalSlider$lambda$1$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, p0);
        return Float.valueOf(DigitalSlider$lambda$1$scaleToOffset);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).floatValue());
    }
}