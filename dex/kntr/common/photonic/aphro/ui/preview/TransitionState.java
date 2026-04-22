package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/TransitionState;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "asset", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationPhase", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/common/photonic/aphro/ui/preview/AnimationPhase;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/flow/MutableStateFlow;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAsset", "()Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "getAnimationProgress", "()Landroidx/compose/animation/core/Animatable;", "getAnimationPhase", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TransitionState {
    public static final int $stable = 8;
    private final MutableStateFlow<AnimationPhase> animationPhase;
    private final Animatable<Float, AnimationVector1D> animationProgress;
    private final PreviewableAsset asset;
    private final CoroutineScope coroutineScope;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransitionState copy$default(TransitionState transitionState, CoroutineScope coroutineScope, PreviewableAsset previewableAsset, Animatable animatable, MutableStateFlow mutableStateFlow, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope = transitionState.coroutineScope;
        }
        if ((i & 2) != 0) {
            previewableAsset = transitionState.asset;
        }
        if ((i & 4) != 0) {
            animatable = transitionState.animationProgress;
        }
        if ((i & 8) != 0) {
            mutableStateFlow = transitionState.animationPhase;
        }
        return transitionState.copy(coroutineScope, previewableAsset, animatable, mutableStateFlow);
    }

    public final CoroutineScope component1() {
        return this.coroutineScope;
    }

    public final PreviewableAsset component2() {
        return this.asset;
    }

    public final Animatable<Float, AnimationVector1D> component3() {
        return this.animationProgress;
    }

    public final MutableStateFlow<AnimationPhase> component4() {
        return this.animationPhase;
    }

    public final TransitionState copy(CoroutineScope coroutineScope, PreviewableAsset previewableAsset, Animatable<Float, AnimationVector1D> animatable, MutableStateFlow<AnimationPhase> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(previewableAsset, "asset");
        Intrinsics.checkNotNullParameter(animatable, "animationProgress");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "animationPhase");
        return new TransitionState(coroutineScope, previewableAsset, animatable, mutableStateFlow);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransitionState) {
            TransitionState transitionState = (TransitionState) obj;
            return Intrinsics.areEqual(this.coroutineScope, transitionState.coroutineScope) && Intrinsics.areEqual(this.asset, transitionState.asset) && Intrinsics.areEqual(this.animationProgress, transitionState.animationProgress) && Intrinsics.areEqual(this.animationPhase, transitionState.animationPhase);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.coroutineScope.hashCode() * 31) + this.asset.hashCode()) * 31) + this.animationProgress.hashCode()) * 31) + this.animationPhase.hashCode();
    }

    public String toString() {
        CoroutineScope coroutineScope = this.coroutineScope;
        PreviewableAsset previewableAsset = this.asset;
        Animatable<Float, AnimationVector1D> animatable = this.animationProgress;
        return "TransitionState(coroutineScope=" + coroutineScope + ", asset=" + previewableAsset + ", animationProgress=" + animatable + ", animationPhase=" + this.animationPhase + ")";
    }

    public TransitionState(CoroutineScope coroutineScope, PreviewableAsset asset, Animatable<Float, AnimationVector1D> animatable, MutableStateFlow<AnimationPhase> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(animatable, "animationProgress");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "animationPhase");
        this.coroutineScope = coroutineScope;
        this.asset = asset;
        this.animationProgress = animatable;
        this.animationPhase = mutableStateFlow;
    }

    public /* synthetic */ TransitionState(CoroutineScope coroutineScope, PreviewableAsset previewableAsset, Animatable animatable, MutableStateFlow mutableStateFlow, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, previewableAsset, (i & 4) != 0 ? AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null) : animatable, (i & 8) != 0 ? StateFlowKt.MutableStateFlow(AnimationPhase.Init) : mutableStateFlow);
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final PreviewableAsset getAsset() {
        return this.asset;
    }

    public final Animatable<Float, AnimationVector1D> getAnimationProgress() {
        return this.animationProgress;
    }

    public final MutableStateFlow<AnimationPhase> getAnimationPhase() {
        return this.animationPhase;
    }
}