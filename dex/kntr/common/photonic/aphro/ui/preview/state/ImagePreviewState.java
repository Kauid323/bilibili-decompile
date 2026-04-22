package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Rect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.aphro.ui.preview.ExitTransitionState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ImagePreviewState.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J=\u00108\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u00109\u001a\u00020+2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0006HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0019¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0016\u00100\u001a\u0004\u0018\u0001018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006?"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "", "dataSource", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewItemState;", "initialAssetIndex", "", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;ILandroidx/compose/foundation/pager/PagerState;Landroidx/compose/animation/core/AnimationSpec;)V", "getDataSource", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getInitialAssetIndex", "()I", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "currentIndex", "getCurrentIndex", "currentResolution", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/common/photonic/Resolution;", "getCurrentResolution", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "currentItem", "getCurrentItem", "()Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewItemState;", "currentImageSource", "Lkntr/base/imageloader/ImageSource;", "getCurrentImageSource", "currentPictureRect", "Landroidx/compose/ui/geometry/Rect;", "getCurrentPictureRect", "animation", "Lkntr/common/photonic/aphro/ui/preview/state/AnimationState;", "getAnimation", "()Lkntr/common/photonic/aphro/ui/preview/state/AnimationState;", "isAnimating", "", "isAnimating$ui_debug", "()Z", "isExiting", "isExiting$ui_debug", "exitTransitionState", "Lkntr/common/photonic/aphro/ui/preview/ExitTransitionState;", "getExitTransitionState$ui_debug", "()Lkntr/common/photonic/aphro/ui/preview/ExitTransitionState;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final float DISMISS_THRESHOLD = 150.0f;
    public static final float DISMISS_VELOCITY_THRESHOLD = 800.0f;
    private final AnimationState animation;
    private final AnimationSpec<Float> animationSpec;
    private final MutableStateFlow<ImageSource> currentImageSource;
    private final MutableStateFlow<Rect> currentPictureRect;
    private final MutableStateFlow<Resolution> currentResolution;
    private final SnapshotStateList<ImagePreviewItemState> dataSource;
    private final int initialAssetIndex;
    private final PagerState pagerState;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImagePreviewState copy$default(ImagePreviewState imagePreviewState, SnapshotStateList snapshotStateList, int i, PagerState pagerState, AnimationSpec animationSpec, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            snapshotStateList = imagePreviewState.dataSource;
        }
        if ((i2 & 2) != 0) {
            i = imagePreviewState.initialAssetIndex;
        }
        if ((i2 & 4) != 0) {
            pagerState = imagePreviewState.pagerState;
        }
        if ((i2 & 8) != 0) {
            animationSpec = imagePreviewState.animationSpec;
        }
        return imagePreviewState.copy(snapshotStateList, i, pagerState, animationSpec);
    }

    public final SnapshotStateList<ImagePreviewItemState> component1() {
        return this.dataSource;
    }

    public final int component2() {
        return this.initialAssetIndex;
    }

    public final PagerState component3() {
        return this.pagerState;
    }

    public final AnimationSpec<Float> component4() {
        return this.animationSpec;
    }

    public final ImagePreviewState copy(SnapshotStateList<ImagePreviewItemState> snapshotStateList, int i, PagerState pagerState, AnimationSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(snapshotStateList, "dataSource");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ImagePreviewState(snapshotStateList, i, pagerState, animationSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImagePreviewState) {
            ImagePreviewState imagePreviewState = (ImagePreviewState) obj;
            return Intrinsics.areEqual(this.dataSource, imagePreviewState.dataSource) && this.initialAssetIndex == imagePreviewState.initialAssetIndex && Intrinsics.areEqual(this.pagerState, imagePreviewState.pagerState) && Intrinsics.areEqual(this.animationSpec, imagePreviewState.animationSpec);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.dataSource.hashCode() * 31) + this.initialAssetIndex) * 31) + this.pagerState.hashCode()) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        SnapshotStateList<ImagePreviewItemState> snapshotStateList = this.dataSource;
        int i = this.initialAssetIndex;
        PagerState pagerState = this.pagerState;
        return "ImagePreviewState(dataSource=" + snapshotStateList + ", initialAssetIndex=" + i + ", pagerState=" + pagerState + ", animationSpec=" + this.animationSpec + ")";
    }

    public ImagePreviewState(SnapshotStateList<ImagePreviewItemState> snapshotStateList, int initialAssetIndex, PagerState pagerState, AnimationSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(snapshotStateList, "dataSource");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.dataSource = snapshotStateList;
        this.initialAssetIndex = initialAssetIndex;
        this.pagerState = pagerState;
        this.animationSpec = animationSpec;
        this.currentResolution = StateFlowKt.MutableStateFlow(Resolution.Companion.getZero());
        this.currentImageSource = StateFlowKt.MutableStateFlow((Object) null);
        this.currentPictureRect = StateFlowKt.MutableStateFlow((Object) null);
        this.animation = new AnimationState(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ ImagePreviewState(SnapshotStateList snapshotStateList, int i, PagerState pagerState, AnimationSpec animationSpec, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapshotStateList, i, pagerState, (i2 & 8) != 0 ? (AnimationSpec) AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null) : animationSpec);
    }

    public final SnapshotStateList<ImagePreviewItemState> getDataSource() {
        return this.dataSource;
    }

    public final int getInitialAssetIndex() {
        return this.initialAssetIndex;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final int getCurrentIndex() {
        return this.pagerState.getCurrentPage();
    }

    public final MutableStateFlow<Resolution> getCurrentResolution() {
        return this.currentResolution;
    }

    public final ImagePreviewItemState getCurrentItem() {
        return (ImagePreviewItemState) CollectionsKt.getOrNull(this.dataSource, getCurrentIndex());
    }

    public final MutableStateFlow<ImageSource> getCurrentImageSource() {
        return this.currentImageSource;
    }

    public final MutableStateFlow<Rect> getCurrentPictureRect() {
        return this.currentPictureRect;
    }

    public final AnimationState getAnimation() {
        return this.animation;
    }

    public final boolean isAnimating$ui_debug() {
        return ((Boolean) this.animation.isAnimating().getValue()).booleanValue();
    }

    public final boolean isExiting$ui_debug() {
        return ((Boolean) this.animation.isExiting().getValue()).booleanValue();
    }

    public final ExitTransitionState getExitTransitionState$ui_debug() {
        Rect sourceRect;
        ImageSource imageSource = (ImageSource) this.currentImageSource.getValue();
        if (imageSource == null || (sourceRect = (Rect) this.currentPictureRect.getValue()) == null) {
            return null;
        }
        return new ExitTransitionState(imageSource, sourceRect);
    }

    /* compiled from: ImagePreviewState.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState$Companion;", "", "<init>", "()V", "DISMISS_THRESHOLD", "", "DISMISS_VELOCITY_THRESHOLD", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}