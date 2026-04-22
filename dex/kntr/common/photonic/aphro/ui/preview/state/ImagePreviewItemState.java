package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewItemState;", "", "asset", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "loadOriginImage", "Landroidx/compose/runtime/MutableState;", "", "retryCount", "Landroidx/compose/runtime/MutableIntState;", "<init>", "(Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableIntState;)V", "getAsset", "()Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "getLoadOriginImage", "()Landroidx/compose/runtime/MutableState;", "getRetryCount", "()Landroidx/compose/runtime/MutableIntState;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewItemState {
    public static final int $stable = 0;
    private final PreviewableAsset asset;
    private final MutableState<Boolean> loadOriginImage;
    private final MutableIntState retryCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImagePreviewItemState copy$default(ImagePreviewItemState imagePreviewItemState, PreviewableAsset previewableAsset, MutableState mutableState, MutableIntState mutableIntState, int i, Object obj) {
        if ((i & 1) != 0) {
            previewableAsset = imagePreviewItemState.asset;
        }
        if ((i & 2) != 0) {
            mutableState = imagePreviewItemState.loadOriginImage;
        }
        if ((i & 4) != 0) {
            mutableIntState = imagePreviewItemState.retryCount;
        }
        return imagePreviewItemState.copy(previewableAsset, mutableState, mutableIntState);
    }

    public final PreviewableAsset component1() {
        return this.asset;
    }

    public final MutableState<Boolean> component2() {
        return this.loadOriginImage;
    }

    public final MutableIntState component3() {
        return this.retryCount;
    }

    public final ImagePreviewItemState copy(PreviewableAsset previewableAsset, MutableState<Boolean> mutableState, MutableIntState mutableIntState) {
        Intrinsics.checkNotNullParameter(previewableAsset, "asset");
        Intrinsics.checkNotNullParameter(mutableState, "loadOriginImage");
        Intrinsics.checkNotNullParameter(mutableIntState, "retryCount");
        return new ImagePreviewItemState(previewableAsset, mutableState, mutableIntState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImagePreviewItemState) {
            ImagePreviewItemState imagePreviewItemState = (ImagePreviewItemState) obj;
            return Intrinsics.areEqual(this.asset, imagePreviewItemState.asset) && Intrinsics.areEqual(this.loadOriginImage, imagePreviewItemState.loadOriginImage) && Intrinsics.areEqual(this.retryCount, imagePreviewItemState.retryCount);
        }
        return false;
    }

    public int hashCode() {
        return (((this.asset.hashCode() * 31) + this.loadOriginImage.hashCode()) * 31) + this.retryCount.hashCode();
    }

    public String toString() {
        PreviewableAsset previewableAsset = this.asset;
        MutableState<Boolean> mutableState = this.loadOriginImage;
        return "ImagePreviewItemState(asset=" + previewableAsset + ", loadOriginImage=" + mutableState + ", retryCount=" + this.retryCount + ")";
    }

    public ImagePreviewItemState(PreviewableAsset asset, MutableState<Boolean> mutableState, MutableIntState retryCount) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(mutableState, "loadOriginImage");
        Intrinsics.checkNotNullParameter(retryCount, "retryCount");
        this.asset = asset;
        this.loadOriginImage = mutableState;
        this.retryCount = retryCount;
    }

    public /* synthetic */ ImagePreviewItemState(PreviewableAsset previewableAsset, MutableState mutableState, MutableIntState mutableIntState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(previewableAsset, (i & 2) != 0 ? SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null) : mutableState, (i & 4) != 0 ? SnapshotIntStateKt.mutableIntStateOf(0) : mutableIntState);
    }

    public final PreviewableAsset getAsset() {
        return this.asset;
    }

    public final MutableState<Boolean> getLoadOriginImage() {
        return this.loadOriginImage;
    }

    public final MutableIntState getRetryCount() {
        return this.retryCount;
    }
}