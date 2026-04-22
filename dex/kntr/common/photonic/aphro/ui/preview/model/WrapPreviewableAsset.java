package kntr.common.photonic.aphro.ui.preview.model;

import androidx.compose.ui.unit.IntRect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.io.Source;

/* compiled from: PreviewableAsset.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096A¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020*X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010$R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WrapPreviewableAsset;", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "Lkntr/common/photonic/Asset;", "asset", "thumbnailImageSource", "Lkntr/base/imageloader/ImageSource;", "thumbnailRect", "Landroidx/compose/ui/unit/IntRect;", "supportThumbnail", "", "<init>", "(Lkntr/common/photonic/Asset;Lkntr/base/imageloader/ImageSource;Landroidx/compose/ui/unit/IntRect;Z)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getThumbnailImageSource", "()Lkntr/base/imageloader/ImageSource;", "getThumbnailRect", "()Landroidx/compose/ui/unit/IntRect;", "getSupportThumbnail", "()Z", "getRotatedResolution", "Lkntr/common/photonic/Resolution;", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assetType", "Lkntr/common/photonic/AssetType;", "getAssetType", "()Lkntr/common/photonic/AssetType;", "contentSize", "Lkntr/common/photonic/ContentSize;", "getContentSize-QJZHGII", "()D", "createTime", "Lkotlinx/datetime/Instant;", "getCreateTime", "()Lkotlinx/datetime/Instant;", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "mimeType", "Lkntr/common/photonic/MimeType;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "modifyTime", "getModifyTime", "orientation", "Lkntr/common/photonic/Orientation;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "resolution", "getResolution", "()Lkntr/common/photonic/Resolution;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WrapPreviewableAsset implements PreviewableAsset, Asset {
    public static final int $stable = 8;
    private final Asset asset;
    private final boolean supportThumbnail;
    private final ImageSource thumbnailImageSource;
    private final IntRect thumbnailRect;

    @Override // kntr.common.photonic.Asset
    public AssetType getAssetType() {
        return this.asset.getAssetType();
    }

    @Override // kntr.common.photonic.Asset
    /* renamed from: getContentSize-QJZHGII */
    public double mo2158getContentSizeQJZHGII() {
        return this.asset.mo2158getContentSizeQJZHGII();
    }

    @Override // kntr.common.photonic.Asset
    public Instant getCreateTime() {
        return this.asset.getCreateTime();
    }

    @Override // kntr.common.photonic.Asset
    public String getIdentifier() {
        return this.asset.getIdentifier();
    }

    @Override // kntr.common.photonic.Asset
    public MimeType getMimeType() {
        return this.asset.getMimeType();
    }

    @Override // kntr.common.photonic.Asset
    public Instant getModifyTime() {
        return this.asset.getModifyTime();
    }

    @Override // kntr.common.photonic.Asset
    public Orientation getOrientation() {
        return this.asset.getOrientation();
    }

    @Override // kntr.common.photonic.Asset
    public Resolution getResolution() {
        return this.asset.getResolution();
    }

    @Override // kntr.common.photonic.Asset
    public Resolution getRotatedResolution() {
        return this.asset.getRotatedResolution();
    }

    @Override // kntr.common.photonic.Asset
    public Object reader(Continuation<? super Source> continuation) {
        return this.asset.reader(continuation);
    }

    public WrapPreviewableAsset(Asset asset, ImageSource thumbnailImageSource, IntRect thumbnailRect, boolean supportThumbnail) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.asset = asset;
        this.thumbnailImageSource = thumbnailImageSource;
        this.thumbnailRect = thumbnailRect;
        this.supportThumbnail = supportThumbnail;
    }

    public /* synthetic */ WrapPreviewableAsset(Asset asset, ImageSource imageSource, IntRect intRect, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(asset, (i & 2) != 0 ? null : imageSource, (i & 4) != 0 ? null : intRect, (i & 8) != 0 ? false : z);
    }

    public final Asset getAsset() {
        return this.asset;
    }

    @Override // kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset
    public ImageSource getThumbnailImageSource() {
        return this.thumbnailImageSource;
    }

    @Override // kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset
    public IntRect getThumbnailRect() {
        return this.thumbnailRect;
    }

    @Override // kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset
    public boolean getSupportThumbnail() {
        return this.supportThumbnail;
    }
}