package kntr.common.paragraph.assetuploader.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderResult.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b\u001cJ8\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010(\u001a\u0004\u0018\u00010)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u00020!X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u00020!X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00102R\u0012\u00105\u001a\u00020!X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00102¨\u00067"}, d2 = {"Lkntr/common/paragraph/assetuploader/base/UploadingAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "originAssetState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "uploadedSize", "Lkntr/common/photonic/ContentSize;", "allSize", "task", "Lkntr/common/paragraph/assetuploader/UploadTask;", "<init>", "(Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;DDLkntr/common/paragraph/assetuploader/UploadTask;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOriginAssetState", "()Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "getUploadedSize-QJZHGII", "()D", "D", "getAllSize-QJZHGII", "getTask$assetuploader_debug", "()Lkntr/common/paragraph/assetuploader/UploadTask;", "uploadedRatio", "", "getUploadedRatio", "component1", "component2", "component2-QJZHGII", "component3", "component3-QJZHGII", "component4", "component4$assetuploader_debug", "copy", "copy-9kyr6hc", "(Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;DDLkntr/common/paragraph/assetuploader/UploadTask;)Lkntr/common/paragraph/assetuploader/base/UploadingAssetUploadState;", "equals", "", "other", "", "hashCode", "", "toString", "", "asset", "Lkntr/common/photonic/Asset;", "getAsset", "()Lkntr/common/photonic/Asset;", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "uploadFinished", "getUploadFinished", "()Z", "uploadSucceed", "getUploadSucceed", "useOrigin", "getUseOrigin", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UploadingAssetUploadState implements AssetUploadState {
    private final double allSize;
    private final OriginAssetUploadState originAssetState;
    private final UploadTask task;
    private final double uploadedSize;

    public /* synthetic */ UploadingAssetUploadState(OriginAssetUploadState originAssetUploadState, double d, double d2, UploadTask uploadTask, DefaultConstructorMarker defaultConstructorMarker) {
        this(originAssetUploadState, d, d2, uploadTask);
    }

    /* renamed from: copy-9kyr6hc$default  reason: not valid java name */
    public static /* synthetic */ UploadingAssetUploadState m2152copy9kyr6hc$default(UploadingAssetUploadState uploadingAssetUploadState, OriginAssetUploadState originAssetUploadState, double d, double d2, UploadTask uploadTask, int i, Object obj) {
        if ((i & 1) != 0) {
            originAssetUploadState = uploadingAssetUploadState.originAssetState;
        }
        if ((i & 2) != 0) {
            d = uploadingAssetUploadState.uploadedSize;
        }
        double d3 = d;
        if ((i & 4) != 0) {
            d2 = uploadingAssetUploadState.allSize;
        }
        double d4 = d2;
        if ((i & 8) != 0) {
            uploadTask = uploadingAssetUploadState.task;
        }
        return uploadingAssetUploadState.m2155copy9kyr6hc(originAssetUploadState, d3, d4, uploadTask);
    }

    public final OriginAssetUploadState component1() {
        return this.originAssetState;
    }

    /* renamed from: component2-QJZHGII  reason: not valid java name */
    public final double m2153component2QJZHGII() {
        return this.uploadedSize;
    }

    /* renamed from: component3-QJZHGII  reason: not valid java name */
    public final double m2154component3QJZHGII() {
        return this.allSize;
    }

    public final UploadTask component4$assetuploader_debug() {
        return this.task;
    }

    /* renamed from: copy-9kyr6hc  reason: not valid java name */
    public final UploadingAssetUploadState m2155copy9kyr6hc(OriginAssetUploadState originAssetUploadState, double d, double d2, UploadTask uploadTask) {
        Intrinsics.checkNotNullParameter(originAssetUploadState, "originAssetState");
        Intrinsics.checkNotNullParameter(uploadTask, "task");
        return new UploadingAssetUploadState(originAssetUploadState, d, d2, uploadTask, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UploadingAssetUploadState) {
            UploadingAssetUploadState uploadingAssetUploadState = (UploadingAssetUploadState) obj;
            return Intrinsics.areEqual(this.originAssetState, uploadingAssetUploadState.originAssetState) && ContentSize.m2186equalsimpl0(this.uploadedSize, uploadingAssetUploadState.uploadedSize) && ContentSize.m2186equalsimpl0(this.allSize, uploadingAssetUploadState.allSize) && Intrinsics.areEqual(this.task, uploadingAssetUploadState.task);
        }
        return false;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Asset getAsset() {
        return this.originAssetState.getAsset();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Resolution getResolution() {
        return this.originAssetState.getResolution();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadFinished() {
        return this.originAssetState.getUploadFinished();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadSucceed() {
        return this.originAssetState.getUploadSucceed();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUseOrigin() {
        return this.originAssetState.getUseOrigin();
    }

    public int hashCode() {
        return (((((this.originAssetState.hashCode() * 31) + ContentSize.m2190hashCodeimpl(this.uploadedSize)) * 31) + ContentSize.m2190hashCodeimpl(this.allSize)) * 31) + this.task.hashCode();
    }

    public String toString() {
        OriginAssetUploadState originAssetUploadState = this.originAssetState;
        String m2193toStringimpl = ContentSize.m2193toStringimpl(this.uploadedSize);
        String m2193toStringimpl2 = ContentSize.m2193toStringimpl(this.allSize);
        return "UploadingAssetUploadState(originAssetState=" + originAssetUploadState + ", uploadedSize=" + m2193toStringimpl + ", allSize=" + m2193toStringimpl2 + ", task=" + this.task + ")";
    }

    private UploadingAssetUploadState(OriginAssetUploadState originAssetState, double uploadedSize, double allSize, UploadTask task) {
        Intrinsics.checkNotNullParameter(originAssetState, "originAssetState");
        Intrinsics.checkNotNullParameter(task, "task");
        this.originAssetState = originAssetState;
        this.uploadedSize = uploadedSize;
        this.allSize = allSize;
        this.task = task;
    }

    public final OriginAssetUploadState getOriginAssetState() {
        return this.originAssetState;
    }

    /* renamed from: getUploadedSize-QJZHGII  reason: not valid java name */
    public final double m2157getUploadedSizeQJZHGII() {
        return this.uploadedSize;
    }

    /* renamed from: getAllSize-QJZHGII  reason: not valid java name */
    public final double m2156getAllSizeQJZHGII() {
        return this.allSize;
    }

    public final UploadTask getTask$assetuploader_debug() {
        return this.task;
    }

    public final double getUploadedRatio() {
        return ContentSize.m2184div4yfSoQ8(this.uploadedSize, this.allSize);
    }
}