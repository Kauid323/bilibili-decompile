package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntOffset;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: ImageScrollState.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\u001fJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J4\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*H\u0080@¢\u0006\u0004\b,\u0010-J\"\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020(H\u0080@¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001cH\u0080@¢\u0006\u0004\b4\u00105R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u00066"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/state/ImageScrollState;", "", "<init>", "()V", "_scale", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "horizontalScrollState", "Landroidx/compose/foundation/ScrollState;", "getHorizontalScrollState", "()Landroidx/compose/foundation/ScrollState;", "verticalScrollState", "getVerticalScrollState", "scale", "getScale", "()F", "isScaled", "", "()Z", "imageSize", "Landroidx/compose/ui/geometry/Size;", "J", "containerSize", "imageScaledSize", "getImageScaledSize-NH-jbRc", "()J", "updateImageSize", "", "size", "updateImageSize-uvyYCjk", "(J)V", "updateContainerSize", "updateContainerSize-uvyYCjk", "getMaxScrollX", "", "getMaxScrollY", "updateScale", "newScale", "centroid", "Landroidx/compose/ui/geometry/Offset;", "boxCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "imageCoordinates", "updateScale-YqVAtuI$ui_debug", "(FJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToScale", "targetScale", "focalPoint", "animateToScale-d-4ec7I$ui_debug", "(FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "reset$ui_debug", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageScrollState {
    public static final int $stable = 0;
    private final Animatable<Float, AnimationVector1D> _scale = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
    private final ScrollState horizontalScrollState = new ScrollState(0);
    private final ScrollState verticalScrollState = new ScrollState(0);
    private long imageSize = Size.Companion.getUnspecified-NH-jbRc();
    private long containerSize = Size.Companion.getUnspecified-NH-jbRc();

    public final ScrollState getHorizontalScrollState() {
        return this.horizontalScrollState;
    }

    public final ScrollState getVerticalScrollState() {
        return this.verticalScrollState;
    }

    public final float getScale() {
        return ((Number) this._scale.getValue()).floatValue();
    }

    public final boolean isScaled() {
        return ((Number) this._scale.getValue()).floatValue() > 1.0f;
    }

    /* renamed from: getImageScaledSize-NH-jbRc  reason: not valid java name */
    public final long m2320getImageScaledSizeNHjbRc() {
        return Size.times-7Ah8Wj8(this.imageSize, getScale());
    }

    /* renamed from: updateImageSize-uvyYCjk  reason: not valid java name */
    public final void m2322updateImageSizeuvyYCjk(long j) {
        this.imageSize = j;
    }

    /* renamed from: updateContainerSize-uvyYCjk  reason: not valid java name */
    public final void m2321updateContainerSizeuvyYCjk(long j) {
        this.containerSize = j;
    }

    public final int getMaxScrollX() {
        if (!isScaled() || Size.equals-impl0(this.imageSize, Size.Companion.getUnspecified-NH-jbRc()) || Size.equals-impl0(this.containerSize, Size.Companion.getUnspecified-NH-jbRc())) {
            return 0;
        }
        int bits$iv$iv$iv = (int) (this.imageSize >> 32);
        float scaledWidth = Float.intBitsToFloat(bits$iv$iv$iv) * getScale();
        int bits$iv$iv$iv2 = (int) (this.containerSize >> 32);
        float maxScroll = RangesKt.coerceAtLeast((scaledWidth - Float.intBitsToFloat(bits$iv$iv$iv2)) / 2.0f, 0.0f);
        return (int) maxScroll;
    }

    public final int getMaxScrollY() {
        if (!isScaled() || Size.equals-impl0(this.imageSize, Size.Companion.getUnspecified-NH-jbRc()) || Size.equals-impl0(this.containerSize, Size.Companion.getUnspecified-NH-jbRc())) {
            return 0;
        }
        int bits$iv$iv$iv = (int) (this.imageSize & 4294967295L);
        float scaledHeight = Float.intBitsToFloat(bits$iv$iv$iv) * getScale();
        int bits$iv$iv$iv2 = (int) (4294967295L & this.containerSize);
        float maxScroll = RangesKt.coerceAtLeast((scaledHeight - Float.intBitsToFloat(bits$iv$iv$iv2)) / 2.0f, 0.0f);
        return (int) maxScroll;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0436 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x04ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04ad  */
    /* renamed from: updateScale-YqVAtuI$ui_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m2323updateScaleYqVAtuI$ui_debug(float newScale, long j, LayoutCoordinates boxCoordinates, LayoutCoordinates imageCoordinates, Continuation<? super Unit> continuation) {
        ImageScrollState$updateScale$1 imageScrollState$updateScale$1;
        ImageScrollState$updateScale$1 imageScrollState$updateScale$12;
        float newScale2;
        Object obj;
        float newScale3;
        long scaledCenterPoint;
        long contentOffset;
        long contentOffset2;
        float scaleFactor;
        long centroidInBox;
        long scaledContentSize;
        LayoutCoordinates boxCoordinates2;
        LayoutCoordinates imageCoordinates2;
        long offsetDelta;
        long offsetDelta2;
        float clampedScale;
        ScrollState scrollState;
        ScrollState scrollState2;
        ImageScrollState imageScrollState;
        float offsetX;
        float offsetY;
        float scaleFactor2;
        Object obj2;
        long offsetDelta3;
        float offsetX2;
        float expectedOffsetY;
        Object obj3;
        float expectedOffsetX;
        long offsetDelta4;
        long scaledCenterPoint2;
        float newScale4;
        long centroidInImage;
        long scaledContentSize2;
        long contentSize;
        long centroidInBox2;
        long contentOffset3;
        float newScale5 = newScale;
        long j2 = j;
        LayoutCoordinates boxCoordinates3 = boxCoordinates;
        LayoutCoordinates imageCoordinates3 = imageCoordinates;
        if (continuation instanceof ImageScrollState$updateScale$1) {
            imageScrollState$updateScale$1 = (ImageScrollState$updateScale$1) continuation;
            if ((imageScrollState$updateScale$1.label & Integer.MIN_VALUE) != 0) {
                imageScrollState$updateScale$1.label -= Integer.MIN_VALUE;
                Object $result = imageScrollState$updateScale$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (imageScrollState$updateScale$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (boxCoordinates3 == null) {
                            return Unit.INSTANCE;
                        }
                        if (imageCoordinates3 == null) {
                            return Unit.INSTANCE;
                        }
                        float clampedScale2 = RangesKt.coerceIn(newScale5, 1.0f, 5.0f);
                        if (clampedScale2 <= 1.0f) {
                            Animatable<Float, AnimationVector1D> animatable = this._scale;
                            Float boxFloat = Boxing.boxFloat(clampedScale2);
                            imageScrollState$updateScale$1.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates);
                            imageScrollState$updateScale$1.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates);
                            imageScrollState$updateScale$1.F$0 = newScale5;
                            imageScrollState$updateScale$1.J$0 = j2;
                            imageScrollState$updateScale$1.F$1 = clampedScale2;
                            imageScrollState$updateScale$1.label = 1;
                            if (animatable.snapTo(boxFloat, imageScrollState$updateScale$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            clampedScale = clampedScale2;
                            scrollState = this.horizontalScrollState;
                            imageScrollState$updateScale$1.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates3);
                            imageScrollState$updateScale$1.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates3);
                            imageScrollState$updateScale$1.F$0 = newScale5;
                            imageScrollState$updateScale$1.J$0 = j2;
                            imageScrollState$updateScale$1.F$1 = clampedScale;
                            imageScrollState$updateScale$1.label = 2;
                            if (scrollState.scrollTo(0, imageScrollState$updateScale$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            scrollState2 = this.verticalScrollState;
                            imageScrollState$updateScale$1.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates3);
                            imageScrollState$updateScale$1.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates3);
                            imageScrollState$updateScale$1.F$0 = newScale5;
                            imageScrollState$updateScale$1.J$0 = j2;
                            imageScrollState$updateScale$1.F$1 = clampedScale;
                            imageScrollState$updateScale$1.label = 3;
                            if (scrollState2.scrollTo(0, imageScrollState$updateScale$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        int x$iv = this.horizontalScrollState.getValue();
                        int y$iv = this.verticalScrollState.getValue();
                        long contentOffset4 = IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L));
                        long contentSize2 = m2320getImageScaledSizeNHjbRc();
                        long it = imageCoordinates3.windowToLocal-MK-Hz9U(boxCoordinates3.localToWindow-MK-Hz9U(j2));
                        int bits$iv$iv$iv = (int) (it >> 32);
                        ImageScrollState$updateScale$1 imageScrollState$updateScale$13 = imageScrollState$updateScale$1;
                        int bits$iv$iv$iv2 = (int) (contentSize2 >> 32);
                        float x$iv2 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Float.intBitsToFloat(bits$iv$iv$iv), 0.0f), Float.intBitsToFloat(bits$iv$iv$iv2));
                        int bits$iv$iv$iv3 = (int) (it & 4294967295L);
                        int bits$iv$iv$iv4 = (int) (contentSize2 & 4294967295L);
                        float y$iv2 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Float.intBitsToFloat(bits$iv$iv$iv3), 0.0f), Float.intBitsToFloat(bits$iv$iv$iv4));
                        long v1$iv$iv = Float.floatToRawIntBits(x$iv2);
                        int $i$f$Offset = Float.floatToRawIntBits(y$iv2);
                        long v2$iv$iv = $i$f$Offset;
                        long centroidInImage2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                        float scaleFactor3 = clampedScale2 / ((Number) this._scale.getValue()).floatValue();
                        long scaledCenterPoint3 = Offset.times-tuRUvjQ(centroidInImage2, scaleFactor3);
                        long scaledContentSize3 = Size.times-7Ah8Wj8(contentSize2, scaleFactor3);
                        long offsetDelta5 = Offset.minus-MK-Hz9U(centroidInImage2, scaledCenterPoint3);
                        Animatable<Float, AnimationVector1D> animatable2 = this._scale;
                        Float boxFloat2 = Boxing.boxFloat(clampedScale2);
                        imageScrollState$updateScale$12 = imageScrollState$updateScale$13;
                        imageScrollState$updateScale$12.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates);
                        imageScrollState$updateScale$12.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates);
                        imageScrollState$updateScale$12.F$0 = newScale5;
                        imageScrollState$updateScale$12.J$0 = j2;
                        imageScrollState$updateScale$12.F$1 = clampedScale2;
                        imageScrollState$updateScale$12.J$1 = contentOffset4;
                        imageScrollState$updateScale$12.J$2 = contentSize2;
                        imageScrollState$updateScale$12.J$3 = j;
                        imageScrollState$updateScale$12.J$4 = centroidInImage2;
                        imageScrollState$updateScale$12.F$2 = scaleFactor3;
                        imageScrollState$updateScale$12.J$5 = scaledCenterPoint3;
                        imageScrollState$updateScale$12.J$6 = scaledContentSize3;
                        imageScrollState$updateScale$12.J$7 = offsetDelta5;
                        imageScrollState$updateScale$12.label = 4;
                        if (animatable2.snapTo(boxFloat2, imageScrollState$updateScale$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        newScale2 = newScale;
                        obj = coroutine_suspended;
                        newScale3 = scaleFactor3;
                        scaledCenterPoint = scaledCenterPoint3;
                        contentOffset = contentOffset4;
                        contentOffset2 = contentSize2;
                        scaleFactor = clampedScale2;
                        centroidInBox = j;
                        scaledContentSize = scaledContentSize3;
                        boxCoordinates2 = boxCoordinates;
                        imageCoordinates2 = imageCoordinates;
                        offsetDelta = offsetDelta5;
                        offsetDelta2 = centroidInImage2;
                        float clampedScale3 = newScale3;
                        long centroidInImage3 = offsetDelta2;
                        imageScrollState = this;
                        long centroidInBox3 = centroidInBox;
                        long centroidInBox4 = offsetDelta >> 32;
                        int bits$iv$iv$iv5 = (int) centroidInBox4;
                        float value = imageScrollState.horizontalScrollState.getValue() + Float.intBitsToFloat(bits$iv$iv$iv5);
                        int bits$iv$iv$iv6 = (int) (scaledContentSize >> 32);
                        long contentOffset5 = contentOffset;
                        int bits$iv$iv$iv7 = (int) (contentOffset2 >> 32);
                        float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv6) - Float.intBitsToFloat(bits$iv$iv$iv7);
                        float f = 2;
                        float expectedOffsetX2 = value + (intBitsToFloat / f);
                        int bits$iv$iv$iv8 = (int) (offsetDelta & 4294967295L);
                        float value2 = imageScrollState.verticalScrollState.getValue() + Float.intBitsToFloat(bits$iv$iv$iv8);
                        int bits$iv$iv$iv9 = (int) (scaledContentSize & 4294967295L);
                        long contentSize3 = contentOffset2;
                        int bits$iv$iv$iv10 = (int) (contentOffset2 & 4294967295L);
                        float expectedOffsetY2 = value2 + ((Float.intBitsToFloat(bits$iv$iv$iv9) - Float.intBitsToFloat(bits$iv$iv$iv10)) / f);
                        offsetX = RangesKt.coerceIn(expectedOffsetX2, 0.0f, imageScrollState.horizontalScrollState.getMaxValue());
                        offsetY = RangesKt.coerceIn(expectedOffsetY2, 0.0f, imageScrollState.verticalScrollState.getMaxValue());
                        imageScrollState$updateScale$12.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates2);
                        imageScrollState$updateScale$12.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates2);
                        imageScrollState$updateScale$12.F$0 = newScale2;
                        imageScrollState$updateScale$12.J$0 = j2;
                        imageScrollState$updateScale$12.F$1 = scaleFactor;
                        long j3 = j2;
                        imageScrollState$updateScale$12.J$1 = contentOffset5;
                        imageScrollState$updateScale$12.J$2 = contentSize3;
                        imageScrollState$updateScale$12.J$3 = centroidInBox3;
                        imageScrollState$updateScale$12.J$4 = centroidInImage3;
                        scaleFactor2 = clampedScale3;
                        imageScrollState$updateScale$12.F$2 = scaleFactor2;
                        long centroidInImage4 = scaledCenterPoint;
                        imageScrollState$updateScale$12.J$5 = centroidInImage4;
                        long scaledCenterPoint4 = scaledContentSize;
                        imageScrollState$updateScale$12.J$6 = scaledCenterPoint4;
                        long scaledContentSize4 = offsetDelta;
                        imageScrollState$updateScale$12.J$7 = scaledContentSize4;
                        imageScrollState$updateScale$12.F$3 = expectedOffsetX2;
                        imageScrollState$updateScale$12.F$4 = expectedOffsetY2;
                        imageScrollState$updateScale$12.F$5 = offsetX;
                        imageScrollState$updateScale$12.F$6 = offsetY;
                        float newScale6 = newScale2;
                        imageScrollState$updateScale$12.label = 5;
                        obj2 = obj;
                        if (imageScrollState.horizontalScrollState.scrollTo((int) offsetX, imageScrollState$updateScale$12) != obj2) {
                            return obj2;
                        }
                        offsetDelta3 = scaledContentSize4;
                        offsetX2 = offsetX;
                        expectedOffsetY = expectedOffsetY2;
                        obj3 = obj2;
                        expectedOffsetX = expectedOffsetX2;
                        offsetDelta4 = j3;
                        scaledCenterPoint2 = centroidInImage4;
                        newScale4 = newScale6;
                        centroidInImage = centroidInImage3;
                        scaledContentSize2 = scaledCenterPoint4;
                        contentSize = contentSize3;
                        centroidInBox2 = centroidInBox3;
                        contentOffset3 = contentOffset5;
                        imageScrollState$updateScale$12.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates2);
                        imageScrollState$updateScale$12.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates2);
                        imageScrollState$updateScale$12.F$0 = newScale4;
                        imageScrollState$updateScale$12.J$0 = offsetDelta4;
                        imageScrollState$updateScale$12.F$1 = scaleFactor;
                        imageScrollState$updateScale$12.J$1 = contentOffset3;
                        imageScrollState$updateScale$12.J$2 = contentSize;
                        imageScrollState$updateScale$12.J$3 = centroidInBox2;
                        imageScrollState$updateScale$12.J$4 = centroidInImage;
                        imageScrollState$updateScale$12.F$2 = scaleFactor2;
                        imageScrollState$updateScale$12.J$5 = scaledCenterPoint2;
                        imageScrollState$updateScale$12.J$6 = scaledContentSize2;
                        imageScrollState$updateScale$12.J$7 = offsetDelta3;
                        imageScrollState$updateScale$12.F$3 = expectedOffsetX;
                        imageScrollState$updateScale$12.F$4 = expectedOffsetY;
                        imageScrollState$updateScale$12.F$5 = offsetX2;
                        imageScrollState$updateScale$12.F$6 = offsetY;
                        imageScrollState$updateScale$12.label = 6;
                        Object obj4 = obj3;
                        return imageScrollState.verticalScrollState.scrollTo((int) offsetY, imageScrollState$updateScale$12) != obj4 ? obj4 : Unit.INSTANCE;
                    case 1:
                        clampedScale = imageScrollState$updateScale$1.F$1;
                        j2 = imageScrollState$updateScale$1.J$0;
                        newScale5 = imageScrollState$updateScale$1.F$0;
                        imageCoordinates3 = (LayoutCoordinates) imageScrollState$updateScale$1.L$1;
                        boxCoordinates3 = (LayoutCoordinates) imageScrollState$updateScale$1.L$0;
                        ResultKt.throwOnFailure($result);
                        scrollState = this.horizontalScrollState;
                        imageScrollState$updateScale$1.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates3);
                        imageScrollState$updateScale$1.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates3);
                        imageScrollState$updateScale$1.F$0 = newScale5;
                        imageScrollState$updateScale$1.J$0 = j2;
                        imageScrollState$updateScale$1.F$1 = clampedScale;
                        imageScrollState$updateScale$1.label = 2;
                        if (scrollState.scrollTo(0, imageScrollState$updateScale$1) == coroutine_suspended) {
                        }
                        scrollState2 = this.verticalScrollState;
                        imageScrollState$updateScale$1.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates3);
                        imageScrollState$updateScale$1.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates3);
                        imageScrollState$updateScale$1.F$0 = newScale5;
                        imageScrollState$updateScale$1.J$0 = j2;
                        imageScrollState$updateScale$1.F$1 = clampedScale;
                        imageScrollState$updateScale$1.label = 3;
                        if (scrollState2.scrollTo(0, imageScrollState$updateScale$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        clampedScale = imageScrollState$updateScale$1.F$1;
                        j2 = imageScrollState$updateScale$1.J$0;
                        newScale5 = imageScrollState$updateScale$1.F$0;
                        imageCoordinates3 = (LayoutCoordinates) imageScrollState$updateScale$1.L$1;
                        boxCoordinates3 = (LayoutCoordinates) imageScrollState$updateScale$1.L$0;
                        ResultKt.throwOnFailure($result);
                        scrollState2 = this.verticalScrollState;
                        imageScrollState$updateScale$1.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates3);
                        imageScrollState$updateScale$1.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates3);
                        imageScrollState$updateScale$1.F$0 = newScale5;
                        imageScrollState$updateScale$1.J$0 = j2;
                        imageScrollState$updateScale$1.F$1 = clampedScale;
                        imageScrollState$updateScale$1.label = 3;
                        if (scrollState2.scrollTo(0, imageScrollState$updateScale$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        float clampedScale4 = imageScrollState$updateScale$1.F$1;
                        long j4 = imageScrollState$updateScale$1.J$0;
                        float f2 = imageScrollState$updateScale$1.F$0;
                        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) imageScrollState$updateScale$1.L$1;
                        LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) imageScrollState$updateScale$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 4:
                        long offsetDelta6 = imageScrollState$updateScale$1.J$7;
                        long scaledContentSize5 = imageScrollState$updateScale$1.J$6;
                        long scaledCenterPoint5 = imageScrollState$updateScale$1.J$5;
                        float scaleFactor4 = imageScrollState$updateScale$1.F$2;
                        long scaledCenterPoint6 = imageScrollState$updateScale$1.J$4;
                        long centroidInBox5 = imageScrollState$updateScale$1.J$3;
                        long contentSize4 = imageScrollState$updateScale$1.J$2;
                        long contentOffset6 = imageScrollState$updateScale$1.J$1;
                        scaleFactor = imageScrollState$updateScale$1.F$1;
                        j2 = imageScrollState$updateScale$1.J$0;
                        float newScale7 = imageScrollState$updateScale$1.F$0;
                        imageCoordinates2 = (LayoutCoordinates) imageScrollState$updateScale$1.L$1;
                        boxCoordinates2 = (LayoutCoordinates) imageScrollState$updateScale$1.L$0;
                        ResultKt.throwOnFailure($result);
                        newScale2 = newScale7;
                        newScale3 = scaleFactor4;
                        offsetDelta = offsetDelta6;
                        scaledContentSize = scaledContentSize5;
                        scaledCenterPoint = scaledCenterPoint5;
                        offsetDelta2 = scaledCenterPoint6;
                        centroidInBox = centroidInBox5;
                        obj = coroutine_suspended;
                        imageScrollState$updateScale$12 = imageScrollState$updateScale$1;
                        contentOffset = contentOffset6;
                        contentOffset2 = contentSize4;
                        float clampedScale32 = newScale3;
                        long centroidInImage32 = offsetDelta2;
                        imageScrollState = this;
                        long centroidInBox32 = centroidInBox;
                        long centroidInBox42 = offsetDelta >> 32;
                        int bits$iv$iv$iv52 = (int) centroidInBox42;
                        float value3 = imageScrollState.horizontalScrollState.getValue() + Float.intBitsToFloat(bits$iv$iv$iv52);
                        int bits$iv$iv$iv62 = (int) (scaledContentSize >> 32);
                        long contentOffset52 = contentOffset;
                        int bits$iv$iv$iv72 = (int) (contentOffset2 >> 32);
                        float intBitsToFloat2 = Float.intBitsToFloat(bits$iv$iv$iv62) - Float.intBitsToFloat(bits$iv$iv$iv72);
                        float f3 = 2;
                        float expectedOffsetX22 = value3 + (intBitsToFloat2 / f3);
                        int bits$iv$iv$iv82 = (int) (offsetDelta & 4294967295L);
                        float value22 = imageScrollState.verticalScrollState.getValue() + Float.intBitsToFloat(bits$iv$iv$iv82);
                        int bits$iv$iv$iv92 = (int) (scaledContentSize & 4294967295L);
                        long contentSize32 = contentOffset2;
                        int bits$iv$iv$iv102 = (int) (contentOffset2 & 4294967295L);
                        float expectedOffsetY22 = value22 + ((Float.intBitsToFloat(bits$iv$iv$iv92) - Float.intBitsToFloat(bits$iv$iv$iv102)) / f3);
                        offsetX = RangesKt.coerceIn(expectedOffsetX22, 0.0f, imageScrollState.horizontalScrollState.getMaxValue());
                        offsetY = RangesKt.coerceIn(expectedOffsetY22, 0.0f, imageScrollState.verticalScrollState.getMaxValue());
                        imageScrollState$updateScale$12.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates2);
                        imageScrollState$updateScale$12.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates2);
                        imageScrollState$updateScale$12.F$0 = newScale2;
                        imageScrollState$updateScale$12.J$0 = j2;
                        imageScrollState$updateScale$12.F$1 = scaleFactor;
                        long j32 = j2;
                        imageScrollState$updateScale$12.J$1 = contentOffset52;
                        imageScrollState$updateScale$12.J$2 = contentSize32;
                        imageScrollState$updateScale$12.J$3 = centroidInBox32;
                        imageScrollState$updateScale$12.J$4 = centroidInImage32;
                        scaleFactor2 = clampedScale32;
                        imageScrollState$updateScale$12.F$2 = scaleFactor2;
                        long centroidInImage42 = scaledCenterPoint;
                        imageScrollState$updateScale$12.J$5 = centroidInImage42;
                        long scaledCenterPoint42 = scaledContentSize;
                        imageScrollState$updateScale$12.J$6 = scaledCenterPoint42;
                        long scaledContentSize42 = offsetDelta;
                        imageScrollState$updateScale$12.J$7 = scaledContentSize42;
                        imageScrollState$updateScale$12.F$3 = expectedOffsetX22;
                        imageScrollState$updateScale$12.F$4 = expectedOffsetY22;
                        imageScrollState$updateScale$12.F$5 = offsetX;
                        imageScrollState$updateScale$12.F$6 = offsetY;
                        float newScale62 = newScale2;
                        imageScrollState$updateScale$12.label = 5;
                        obj2 = obj;
                        if (imageScrollState.horizontalScrollState.scrollTo((int) offsetX, imageScrollState$updateScale$12) != obj2) {
                        }
                        break;
                    case 5:
                        float clampedScale5 = imageScrollState$updateScale$1.F$6;
                        float offsetX3 = imageScrollState$updateScale$1.F$5;
                        float expectedOffsetY3 = imageScrollState$updateScale$1.F$4;
                        float expectedOffsetX3 = imageScrollState$updateScale$1.F$3;
                        long offsetDelta7 = imageScrollState$updateScale$1.J$7;
                        long scaledContentSize6 = imageScrollState$updateScale$1.J$6;
                        long scaledCenterPoint7 = imageScrollState$updateScale$1.J$5;
                        float offsetY2 = imageScrollState$updateScale$1.F$2;
                        long scaledCenterPoint8 = imageScrollState$updateScale$1.J$4;
                        long centroidInBox6 = imageScrollState$updateScale$1.J$3;
                        long contentSize5 = imageScrollState$updateScale$1.J$2;
                        long contentOffset7 = imageScrollState$updateScale$1.J$1;
                        scaleFactor = imageScrollState$updateScale$1.F$1;
                        offsetDelta4 = imageScrollState$updateScale$1.J$0;
                        float newScale8 = imageScrollState$updateScale$1.F$0;
                        boxCoordinates2 = (LayoutCoordinates) imageScrollState$updateScale$1.L$0;
                        ResultKt.throwOnFailure($result);
                        imageCoordinates2 = (LayoutCoordinates) imageScrollState$updateScale$1.L$1;
                        expectedOffsetX = expectedOffsetX3;
                        offsetDelta3 = offsetDelta7;
                        offsetX2 = offsetX3;
                        expectedOffsetY = expectedOffsetY3;
                        scaledContentSize2 = scaledContentSize6;
                        scaledCenterPoint2 = scaledCenterPoint7;
                        centroidInImage = scaledCenterPoint8;
                        contentSize = contentSize5;
                        scaleFactor2 = offsetY2;
                        imageScrollState = this;
                        obj3 = coroutine_suspended;
                        newScale4 = newScale8;
                        imageScrollState$updateScale$12 = imageScrollState$updateScale$1;
                        contentOffset3 = contentOffset7;
                        offsetY = clampedScale5;
                        centroidInBox2 = centroidInBox6;
                        imageScrollState$updateScale$12.L$0 = SpillingKt.nullOutSpilledVariable(boxCoordinates2);
                        imageScrollState$updateScale$12.L$1 = SpillingKt.nullOutSpilledVariable(imageCoordinates2);
                        imageScrollState$updateScale$12.F$0 = newScale4;
                        imageScrollState$updateScale$12.J$0 = offsetDelta4;
                        imageScrollState$updateScale$12.F$1 = scaleFactor;
                        imageScrollState$updateScale$12.J$1 = contentOffset3;
                        imageScrollState$updateScale$12.J$2 = contentSize;
                        imageScrollState$updateScale$12.J$3 = centroidInBox2;
                        imageScrollState$updateScale$12.J$4 = centroidInImage;
                        imageScrollState$updateScale$12.F$2 = scaleFactor2;
                        imageScrollState$updateScale$12.J$5 = scaledCenterPoint2;
                        imageScrollState$updateScale$12.J$6 = scaledContentSize2;
                        imageScrollState$updateScale$12.J$7 = offsetDelta3;
                        imageScrollState$updateScale$12.F$3 = expectedOffsetX;
                        imageScrollState$updateScale$12.F$4 = expectedOffsetY;
                        imageScrollState$updateScale$12.F$5 = offsetX2;
                        imageScrollState$updateScale$12.F$6 = offsetY;
                        imageScrollState$updateScale$12.label = 6;
                        Object obj42 = obj3;
                        if (imageScrollState.verticalScrollState.scrollTo((int) offsetY, imageScrollState$updateScale$12) != obj42) {
                        }
                        break;
                    case 6:
                        float f4 = imageScrollState$updateScale$1.F$6;
                        float f5 = imageScrollState$updateScale$1.F$5;
                        float f6 = imageScrollState$updateScale$1.F$4;
                        float f7 = imageScrollState$updateScale$1.F$3;
                        long j5 = imageScrollState$updateScale$1.J$7;
                        long j6 = imageScrollState$updateScale$1.J$6;
                        long j7 = imageScrollState$updateScale$1.J$5;
                        float f8 = imageScrollState$updateScale$1.F$2;
                        long scaledCenterPoint9 = imageScrollState$updateScale$1.J$4;
                        long j8 = imageScrollState$updateScale$1.J$3;
                        long j9 = imageScrollState$updateScale$1.J$2;
                        long j10 = imageScrollState$updateScale$1.J$1;
                        float scaleFactor5 = imageScrollState$updateScale$1.F$1;
                        long j11 = imageScrollState$updateScale$1.J$0;
                        float f9 = imageScrollState$updateScale$1.F$0;
                        LayoutCoordinates layoutCoordinates3 = (LayoutCoordinates) imageScrollState$updateScale$1.L$1;
                        LayoutCoordinates layoutCoordinates4 = (LayoutCoordinates) imageScrollState$updateScale$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        imageScrollState$updateScale$1 = new ImageScrollState$updateScale$1(this, continuation);
        Object $result2 = imageScrollState$updateScale$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (imageScrollState$updateScale$1.label) {
        }
    }

    /* renamed from: animateToScale-d-4ec7I$ui_debug$default  reason: not valid java name */
    public static /* synthetic */ Object m2318animateToScaled4ec7I$ui_debug$default(ImageScrollState imageScrollState, float f, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.Companion.getZero-F1C5BW0();
        }
        return imageScrollState.m2319animateToScaled4ec7I$ui_debug(f, j, continuation);
    }

    /* renamed from: animateToScale-d-4ec7I$ui_debug  reason: not valid java name */
    public final Object m2319animateToScaled4ec7I$ui_debug(float targetScale, long j, Continuation<? super Unit> continuation) {
        float clampedScale = RangesKt.coerceIn(targetScale, 1.0f, 5.0f);
        if (clampedScale <= 1.0f) {
            Object coroutineScope = CoroutineScopeKt.coroutineScope(new ImageScrollState$animateToScale$2(this, null), continuation);
            return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
        }
        float scaleDelta = clampedScale / ((Number) this._scale.getValue()).floatValue();
        int bits$iv$iv$iv = (int) (this.containerSize >> 32);
        float currentCenterX = this.horizontalScrollState.getValue() + (Float.intBitsToFloat(bits$iv$iv$iv) / 2.0f);
        int bits$iv$iv$iv2 = (int) (this.containerSize & 4294967295L);
        float currentCenterY = this.verticalScrollState.getValue() + (Float.intBitsToFloat(bits$iv$iv$iv2) / 2.0f);
        int bits$iv$iv$iv3 = (int) (j >> 32);
        int bits$iv$iv$iv4 = (int) (j >> 32);
        float newCenterX = Float.intBitsToFloat(bits$iv$iv$iv3) + ((currentCenterX - Float.intBitsToFloat(bits$iv$iv$iv4)) * scaleDelta);
        int bits$iv$iv$iv5 = (int) (j & 4294967295L);
        int bits$iv$iv$iv6 = (int) (j & 4294967295L);
        float newCenterY = Float.intBitsToFloat(bits$iv$iv$iv5) + ((currentCenterY - Float.intBitsToFloat(bits$iv$iv$iv6)) * scaleDelta);
        int bits$iv$iv$iv7 = (int) (this.containerSize >> 32);
        float newScrollX = RangesKt.coerceAtLeast(newCenterX - (Float.intBitsToFloat(bits$iv$iv$iv7) / 2.0f), 0.0f);
        int bits$iv$iv$iv8 = (int) (this.containerSize & 4294967295L);
        float newScrollY = RangesKt.coerceAtLeast(newCenterY - (Float.intBitsToFloat(bits$iv$iv$iv8) / 2.0f), 0.0f);
        Object coroutineScope2 = CoroutineScopeKt.coroutineScope(new ImageScrollState$animateToScale$3(this, clampedScale, newScrollX, newScrollY, null), continuation);
        return coroutineScope2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope2 : Unit.INSTANCE;
    }

    public final Object reset$ui_debug(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ImageScrollState$reset$2(this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}