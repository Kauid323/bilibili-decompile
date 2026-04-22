package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.Offset;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AnimationState.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\nHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JÁ\u0001\u0010(\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001aR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001a¨\u0006/"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/state/AnimationState;", "", "gestureOffsetX", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "gestureOffsetY", "gestureScale", "gestureBackgroundAlpha", "isDragging", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "totalDragOffset", "Landroidx/compose/ui/geometry/Offset;", "lastDragTime", "", "velocityY", "isAnimating", "isExiting", "<init>", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;)V", "getGestureOffsetX", "()Landroidx/compose/animation/core/Animatable;", "getGestureOffsetY", "getGestureScale", "getGestureBackgroundAlpha", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getTotalDragOffset", "getLastDragTime", "getVelocityY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AnimationState {
    public static final int $stable = 8;
    private final Animatable<Float, AnimationVector1D> gestureBackgroundAlpha;
    private final Animatable<Float, AnimationVector1D> gestureOffsetX;
    private final Animatable<Float, AnimationVector1D> gestureOffsetY;
    private final Animatable<Float, AnimationVector1D> gestureScale;
    private final MutableStateFlow<Boolean> isAnimating;
    private final MutableStateFlow<Boolean> isDragging;
    private final MutableStateFlow<Boolean> isExiting;
    private final MutableStateFlow<Long> lastDragTime;
    private final MutableStateFlow<Offset> totalDragOffset;
    private final MutableStateFlow<Float> velocityY;

    public AnimationState() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final Animatable<Float, AnimationVector1D> component1() {
        return this.gestureOffsetX;
    }

    public final MutableStateFlow<Boolean> component10() {
        return this.isExiting;
    }

    public final Animatable<Float, AnimationVector1D> component2() {
        return this.gestureOffsetY;
    }

    public final Animatable<Float, AnimationVector1D> component3() {
        return this.gestureScale;
    }

    public final Animatable<Float, AnimationVector1D> component4() {
        return this.gestureBackgroundAlpha;
    }

    public final MutableStateFlow<Boolean> component5() {
        return this.isDragging;
    }

    public final MutableStateFlow<Offset> component6() {
        return this.totalDragOffset;
    }

    public final MutableStateFlow<Long> component7() {
        return this.lastDragTime;
    }

    public final MutableStateFlow<Float> component8() {
        return this.velocityY;
    }

    public final MutableStateFlow<Boolean> component9() {
        return this.isAnimating;
    }

    public final AnimationState copy(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Animatable<Float, AnimationVector1D> animatable3, Animatable<Float, AnimationVector1D> animatable4, MutableStateFlow<Boolean> mutableStateFlow, MutableStateFlow<Offset> mutableStateFlow2, MutableStateFlow<Long> mutableStateFlow3, MutableStateFlow<Float> mutableStateFlow4, MutableStateFlow<Boolean> mutableStateFlow5, MutableStateFlow<Boolean> mutableStateFlow6) {
        Intrinsics.checkNotNullParameter(animatable, "gestureOffsetX");
        Intrinsics.checkNotNullParameter(animatable2, "gestureOffsetY");
        Intrinsics.checkNotNullParameter(animatable3, "gestureScale");
        Intrinsics.checkNotNullParameter(animatable4, "gestureBackgroundAlpha");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "isDragging");
        Intrinsics.checkNotNullParameter(mutableStateFlow2, "totalDragOffset");
        Intrinsics.checkNotNullParameter(mutableStateFlow3, "lastDragTime");
        Intrinsics.checkNotNullParameter(mutableStateFlow4, "velocityY");
        Intrinsics.checkNotNullParameter(mutableStateFlow5, "isAnimating");
        Intrinsics.checkNotNullParameter(mutableStateFlow6, "isExiting");
        return new AnimationState(animatable, animatable2, animatable3, animatable4, mutableStateFlow, mutableStateFlow2, mutableStateFlow3, mutableStateFlow4, mutableStateFlow5, mutableStateFlow6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimationState) {
            AnimationState animationState = (AnimationState) obj;
            return Intrinsics.areEqual(this.gestureOffsetX, animationState.gestureOffsetX) && Intrinsics.areEqual(this.gestureOffsetY, animationState.gestureOffsetY) && Intrinsics.areEqual(this.gestureScale, animationState.gestureScale) && Intrinsics.areEqual(this.gestureBackgroundAlpha, animationState.gestureBackgroundAlpha) && Intrinsics.areEqual(this.isDragging, animationState.isDragging) && Intrinsics.areEqual(this.totalDragOffset, animationState.totalDragOffset) && Intrinsics.areEqual(this.lastDragTime, animationState.lastDragTime) && Intrinsics.areEqual(this.velocityY, animationState.velocityY) && Intrinsics.areEqual(this.isAnimating, animationState.isAnimating) && Intrinsics.areEqual(this.isExiting, animationState.isExiting);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.gestureOffsetX.hashCode() * 31) + this.gestureOffsetY.hashCode()) * 31) + this.gestureScale.hashCode()) * 31) + this.gestureBackgroundAlpha.hashCode()) * 31) + this.isDragging.hashCode()) * 31) + this.totalDragOffset.hashCode()) * 31) + this.lastDragTime.hashCode()) * 31) + this.velocityY.hashCode()) * 31) + this.isAnimating.hashCode()) * 31) + this.isExiting.hashCode();
    }

    public String toString() {
        Animatable<Float, AnimationVector1D> animatable = this.gestureOffsetX;
        Animatable<Float, AnimationVector1D> animatable2 = this.gestureOffsetY;
        Animatable<Float, AnimationVector1D> animatable3 = this.gestureScale;
        Animatable<Float, AnimationVector1D> animatable4 = this.gestureBackgroundAlpha;
        MutableStateFlow<Boolean> mutableStateFlow = this.isDragging;
        MutableStateFlow<Offset> mutableStateFlow2 = this.totalDragOffset;
        MutableStateFlow<Long> mutableStateFlow3 = this.lastDragTime;
        MutableStateFlow<Float> mutableStateFlow4 = this.velocityY;
        MutableStateFlow<Boolean> mutableStateFlow5 = this.isAnimating;
        return "AnimationState(gestureOffsetX=" + animatable + ", gestureOffsetY=" + animatable2 + ", gestureScale=" + animatable3 + ", gestureBackgroundAlpha=" + animatable4 + ", isDragging=" + mutableStateFlow + ", totalDragOffset=" + mutableStateFlow2 + ", lastDragTime=" + mutableStateFlow3 + ", velocityY=" + mutableStateFlow4 + ", isAnimating=" + mutableStateFlow5 + ", isExiting=" + this.isExiting + ")";
    }

    public AnimationState(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Animatable<Float, AnimationVector1D> animatable3, Animatable<Float, AnimationVector1D> animatable4, MutableStateFlow<Boolean> mutableStateFlow, MutableStateFlow<Offset> mutableStateFlow2, MutableStateFlow<Long> mutableStateFlow3, MutableStateFlow<Float> mutableStateFlow4, MutableStateFlow<Boolean> mutableStateFlow5, MutableStateFlow<Boolean> mutableStateFlow6) {
        Intrinsics.checkNotNullParameter(animatable, "gestureOffsetX");
        Intrinsics.checkNotNullParameter(animatable2, "gestureOffsetY");
        Intrinsics.checkNotNullParameter(animatable3, "gestureScale");
        Intrinsics.checkNotNullParameter(animatable4, "gestureBackgroundAlpha");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "isDragging");
        Intrinsics.checkNotNullParameter(mutableStateFlow2, "totalDragOffset");
        Intrinsics.checkNotNullParameter(mutableStateFlow3, "lastDragTime");
        Intrinsics.checkNotNullParameter(mutableStateFlow4, "velocityY");
        Intrinsics.checkNotNullParameter(mutableStateFlow5, "isAnimating");
        Intrinsics.checkNotNullParameter(mutableStateFlow6, "isExiting");
        this.gestureOffsetX = animatable;
        this.gestureOffsetY = animatable2;
        this.gestureScale = animatable3;
        this.gestureBackgroundAlpha = animatable4;
        this.isDragging = mutableStateFlow;
        this.totalDragOffset = mutableStateFlow2;
        this.lastDragTime = mutableStateFlow3;
        this.velocityY = mutableStateFlow4;
        this.isAnimating = mutableStateFlow5;
        this.isExiting = mutableStateFlow6;
    }

    public /* synthetic */ AnimationState(Animatable animatable, Animatable animatable2, Animatable animatable3, Animatable animatable4, MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, MutableStateFlow mutableStateFlow3, MutableStateFlow mutableStateFlow4, MutableStateFlow mutableStateFlow5, MutableStateFlow mutableStateFlow6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null) : animatable, (i & 2) != 0 ? AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null) : animatable2, (i & 4) != 0 ? AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null) : animatable3, (i & 8) != 0 ? AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null) : animatable4, (i & 16) != 0 ? StateFlowKt.MutableStateFlow(false) : mutableStateFlow, (i & 32) != 0 ? StateFlowKt.MutableStateFlow(Offset.box-impl(Offset.Companion.getZero-F1C5BW0())) : mutableStateFlow2, (i & 64) != 0 ? StateFlowKt.MutableStateFlow(0L) : mutableStateFlow3, (i & 128) != 0 ? StateFlowKt.MutableStateFlow(Float.valueOf(0.0f)) : mutableStateFlow4, (i & 256) != 0 ? StateFlowKt.MutableStateFlow(false) : mutableStateFlow5, (i & 512) != 0 ? StateFlowKt.MutableStateFlow(false) : mutableStateFlow6);
    }

    public final Animatable<Float, AnimationVector1D> getGestureOffsetX() {
        return this.gestureOffsetX;
    }

    public final Animatable<Float, AnimationVector1D> getGestureOffsetY() {
        return this.gestureOffsetY;
    }

    public final Animatable<Float, AnimationVector1D> getGestureScale() {
        return this.gestureScale;
    }

    public final Animatable<Float, AnimationVector1D> getGestureBackgroundAlpha() {
        return this.gestureBackgroundAlpha;
    }

    public final MutableStateFlow<Boolean> isDragging() {
        return this.isDragging;
    }

    public final MutableStateFlow<Offset> getTotalDragOffset() {
        return this.totalDragOffset;
    }

    public final MutableStateFlow<Long> getLastDragTime() {
        return this.lastDragTime;
    }

    public final MutableStateFlow<Float> getVelocityY() {
        return this.velocityY;
    }

    public final MutableStateFlow<Boolean> isAnimating() {
        return this.isAnimating;
    }

    public final MutableStateFlow<Boolean> isExiting() {
        return this.isExiting;
    }
}