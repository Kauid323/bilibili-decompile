package kntr.common.photonic.aphro.ui.preview.model;

import androidx.compose.ui.unit.IntRect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.Pixel;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.io.Source;

/* compiled from: WebImageAsset.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GBS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u00020)H\u0000¢\u0006\u0002\b3J\t\u00104\u001a\u00020\u0003HÂ\u0003J\u0010\u00105\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b6\u0010\u0016J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jn\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b?\u0010@J\u0013\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006H"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "url", "", "contentSize", "Lkntr/common/photonic/ContentSize;", "createTime", "Lkotlinx/datetime/Instant;", "modifyTime", "resolution", "Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "mimeType", "Lkntr/common/photonic/MimeType;", "thumbnailRect", "Landroidx/compose/ui/unit/IntRect;", "thumbnailImageSource", "Lkntr/base/imageloader/ImageSource;", "<init>", "(Ljava/lang/String;DLkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkntr/common/photonic/MimeType;Landroidx/compose/ui/unit/IntRect;Lkntr/base/imageloader/ImageSource;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentSize-QJZHGII", "()D", "D", "getCreateTime", "()Lkotlinx/datetime/Instant;", "getModifyTime", "getResolution", "()Lkntr/common/photonic/Resolution;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "getThumbnailRect", "()Landroidx/compose/ui/unit/IntRect;", "getThumbnailImageSource", "()Lkntr/base/imageloader/ImageSource;", "identifier", "getIdentifier", "()Ljava/lang/String;", "supportThumbnail", "", "getSupportThumbnail", "()Z", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "Lkntr/base/imageloader/ImageRequest;", "expectResolution", "animated", "request$ui_debug", "component1", "component2", "component2-QJZHGII", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-58rQf18", "(Ljava/lang/String;DLkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkntr/common/photonic/MimeType;Landroidx/compose/ui/unit/IntRect;Lkntr/base/imageloader/ImageSource;)Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset;", "equals", "other", "", "hashCode", "", "toString", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WebImageAsset implements PreviewableAsset {
    private final double contentSize;
    private final Instant createTime;
    private final MimeType mimeType;
    private final Instant modifyTime;
    private final Orientation orientation;
    private final Resolution resolution;
    private final ImageSource thumbnailImageSource;
    private final IntRect thumbnailRect;
    private final String url;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ WebImageAsset(String str, double d, Instant instant, Instant instant2, Resolution resolution, Orientation orientation, MimeType mimeType, IntRect intRect, ImageSource imageSource, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, instant, instant2, resolution, orientation, mimeType, intRect, imageSource);
    }

    private final String component1() {
        return this.url;
    }

    /* renamed from: component2-QJZHGII  reason: not valid java name */
    public final double m2315component2QJZHGII() {
        return this.contentSize;
    }

    public final Instant component3() {
        return this.createTime;
    }

    public final Instant component4() {
        return this.modifyTime;
    }

    public final Resolution component5() {
        return this.resolution;
    }

    public final Orientation component6() {
        return this.orientation;
    }

    public final MimeType component7() {
        return this.mimeType;
    }

    public final IntRect component8() {
        return this.thumbnailRect;
    }

    public final ImageSource component9() {
        return this.thumbnailImageSource;
    }

    /* renamed from: copy-58rQf18  reason: not valid java name */
    public final WebImageAsset m2316copy58rQf18(String str, double d, Instant instant, Instant instant2, Resolution resolution, Orientation orientation, MimeType mimeType, IntRect intRect, ImageSource imageSource) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(instant, "createTime");
        Intrinsics.checkNotNullParameter(instant2, "modifyTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new WebImageAsset(str, d, instant, instant2, resolution, orientation, mimeType, intRect, imageSource, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebImageAsset) {
            WebImageAsset webImageAsset = (WebImageAsset) obj;
            return Intrinsics.areEqual(this.url, webImageAsset.url) && ContentSize.m2186equalsimpl0(this.contentSize, webImageAsset.contentSize) && Intrinsics.areEqual(this.createTime, webImageAsset.createTime) && Intrinsics.areEqual(this.modifyTime, webImageAsset.modifyTime) && Intrinsics.areEqual(this.resolution, webImageAsset.resolution) && this.orientation == webImageAsset.orientation && Intrinsics.areEqual(this.mimeType, webImageAsset.mimeType) && Intrinsics.areEqual(this.thumbnailRect, webImageAsset.thumbnailRect) && Intrinsics.areEqual(this.thumbnailImageSource, webImageAsset.thumbnailImageSource);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.url.hashCode() * 31) + ContentSize.m2190hashCodeimpl(this.contentSize)) * 31) + this.createTime.hashCode()) * 31) + this.modifyTime.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.orientation.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + (this.thumbnailRect == null ? 0 : this.thumbnailRect.hashCode())) * 31) + (this.thumbnailImageSource != null ? this.thumbnailImageSource.hashCode() : 0);
    }

    public String toString() {
        String str = this.url;
        String m2193toStringimpl = ContentSize.m2193toStringimpl(this.contentSize);
        Instant instant = this.createTime;
        Instant instant2 = this.modifyTime;
        Resolution resolution = this.resolution;
        Orientation orientation = this.orientation;
        MimeType mimeType = this.mimeType;
        IntRect intRect = this.thumbnailRect;
        return "WebImageAsset(url=" + str + ", contentSize=" + m2193toStringimpl + ", createTime=" + instant + ", modifyTime=" + instant2 + ", resolution=" + resolution + ", orientation=" + orientation + ", mimeType=" + mimeType + ", thumbnailRect=" + intRect + ", thumbnailImageSource=" + this.thumbnailImageSource + ")";
    }

    private WebImageAsset(String url, double contentSize, Instant createTime, Instant modifyTime, Resolution resolution, Orientation orientation, MimeType mimeType, IntRect thumbnailRect, ImageSource thumbnailImageSource) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(modifyTime, "modifyTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.url = url;
        this.contentSize = contentSize;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.resolution = resolution;
        this.orientation = orientation;
        this.mimeType = mimeType;
        this.thumbnailRect = thumbnailRect;
        this.thumbnailImageSource = thumbnailImageSource;
    }

    @Override // kntr.common.photonic.Asset
    public /* bridge */ AssetType getAssetType() {
        return Asset.CC.$default$getAssetType(this);
    }

    @Override // kntr.common.photonic.Asset
    public /* bridge */ Resolution getRotatedResolution() {
        return Asset.CC.$default$getRotatedResolution(this);
    }

    @Override // kntr.common.photonic.Asset
    /* renamed from: getContentSize-QJZHGII */
    public double mo2158getContentSizeQJZHGII() {
        return this.contentSize;
    }

    @Override // kntr.common.photonic.Asset
    public Instant getCreateTime() {
        return this.createTime;
    }

    @Override // kntr.common.photonic.Asset
    public Instant getModifyTime() {
        return this.modifyTime;
    }

    @Override // kntr.common.photonic.Asset
    public Resolution getResolution() {
        return this.resolution;
    }

    @Override // kntr.common.photonic.Asset
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // kntr.common.photonic.Asset
    public MimeType getMimeType() {
        return this.mimeType;
    }

    @Override // kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset
    public IntRect getThumbnailRect() {
        return this.thumbnailRect;
    }

    @Override // kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset
    public ImageSource getThumbnailImageSource() {
        return this.thumbnailImageSource;
    }

    /* compiled from: WebImageAsset.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WebImageAsset$Companion;", "", "<init>", "()V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.common.photonic.Asset
    public String getIdentifier() {
        return this.url;
    }

    @Override // kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset
    public boolean getSupportThumbnail() {
        return true;
    }

    @Override // kntr.common.photonic.Asset
    public Object reader(Continuation<? super Source> continuation) {
        return WebImageAssetKt.downloadImage(this, continuation);
    }

    public final ImageRequest request$ui_debug(Resolution expectResolution, boolean animated) {
        ImageRequest $this$request_u24lambda_u240 = new ImageRequest(this.url);
        $this$request_u24lambda_u240.autoPlay(animated);
        if (expectResolution != null) {
            $this$request_u24lambda_u240.m1493requestWidth3VbuI34(Pixel.m1517constructorimpl(expectResolution.getWidthPx()));
            $this$request_u24lambda_u240.m1488requestHeight3VbuI34(Pixel.m1517constructorimpl(expectResolution.getHeightPx()));
        } else {
            $this$request_u24lambda_u240.useOrigin(true);
        }
        return $this$request_u24lambda_u240;
    }
}