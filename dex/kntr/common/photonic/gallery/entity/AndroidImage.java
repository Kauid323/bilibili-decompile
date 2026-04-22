package kntr.common.photonic.gallery.entity;

import android.net.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.gallery.AndroidAsset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.io.Source;

/* compiled from: AndroidImage.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b/\u0010\u001aJ\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\t\u00105\u001a\u00020\u0012HÆ\u0003Jl\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b7\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0018¨\u0006@"}, d2 = {"Lkntr/common/photonic/gallery/entity/AndroidImage;", "Lkntr/common/photonic/gallery/AndroidAsset;", "uri", "Landroid/net/Uri;", "path", "", "contentSize", "Lkntr/common/photonic/ContentSize;", "createTime", "Lkotlinx/datetime/Instant;", "modifyTime", "resolution", "Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "mimeType", "Lkntr/common/photonic/MimeType;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "<init>", "(Landroid/net/Uri;Ljava/lang/String;DLkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkntr/common/photonic/MimeType;Lkntr/common/photonic/AlbumInfo;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUri", "()Landroid/net/Uri;", "getPath", "()Ljava/lang/String;", "getContentSize-QJZHGII", "()D", "D", "getCreateTime", "()Lkotlinx/datetime/Instant;", "getModifyTime", "getResolution", "()Lkntr/common/photonic/Resolution;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identifier", "getIdentifier", "component1", "component2", "component3", "component3-QJZHGII", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-TjxKbpQ", "(Landroid/net/Uri;Ljava/lang/String;DLkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkntr/common/photonic/MimeType;Lkntr/common/photonic/AlbumInfo;)Lkntr/common/photonic/gallery/entity/AndroidImage;", "equals", "", "other", "", "hashCode", "", "toString", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidImage implements AndroidAsset {
    public static final int $stable = 8;
    private final AlbumInfo albumInfo;
    private final double contentSize;
    private final Instant createTime;
    private final MimeType mimeType;
    private final Instant modifyTime;
    private final Orientation orientation;
    private final String path;
    private final Resolution resolution;
    private final Uri uri;

    public /* synthetic */ AndroidImage(Uri uri, String str, double d, Instant instant, Instant instant2, Resolution resolution, Orientation orientation, MimeType mimeType, AlbumInfo albumInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, d, instant, instant2, resolution, orientation, mimeType, albumInfo);
    }

    public final Uri component1() {
        return this.uri;
    }

    public final String component2() {
        return this.path;
    }

    /* renamed from: component3-QJZHGII  reason: not valid java name */
    public final double m2337component3QJZHGII() {
        return this.contentSize;
    }

    public final Instant component4() {
        return this.createTime;
    }

    public final Instant component5() {
        return this.modifyTime;
    }

    public final Resolution component6() {
        return this.resolution;
    }

    public final Orientation component7() {
        return this.orientation;
    }

    public final MimeType component8() {
        return this.mimeType;
    }

    public final AlbumInfo component9() {
        return this.albumInfo;
    }

    /* renamed from: copy-TjxKbpQ  reason: not valid java name */
    public final AndroidImage m2338copyTjxKbpQ(Uri uri, String str, double d, Instant instant, Instant instant2, Resolution resolution, Orientation orientation, MimeType mimeType, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(instant, "createTime");
        Intrinsics.checkNotNullParameter(instant2, "modifyTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        return new AndroidImage(uri, str, d, instant, instant2, resolution, orientation, mimeType, albumInfo, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AndroidImage) {
            AndroidImage androidImage = (AndroidImage) obj;
            return Intrinsics.areEqual(this.uri, androidImage.uri) && Intrinsics.areEqual(this.path, androidImage.path) && ContentSize.m2186equalsimpl0(this.contentSize, androidImage.contentSize) && Intrinsics.areEqual(this.createTime, androidImage.createTime) && Intrinsics.areEqual(this.modifyTime, androidImage.modifyTime) && Intrinsics.areEqual(this.resolution, androidImage.resolution) && this.orientation == androidImage.orientation && Intrinsics.areEqual(this.mimeType, androidImage.mimeType) && Intrinsics.areEqual(this.albumInfo, androidImage.albumInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.uri.hashCode() * 31) + (this.path == null ? 0 : this.path.hashCode())) * 31) + ContentSize.m2190hashCodeimpl(this.contentSize)) * 31) + this.createTime.hashCode()) * 31) + this.modifyTime.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.orientation.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + this.albumInfo.hashCode();
    }

    public String toString() {
        Uri uri = this.uri;
        String str = this.path;
        String m2193toStringimpl = ContentSize.m2193toStringimpl(this.contentSize);
        Instant instant = this.createTime;
        Instant instant2 = this.modifyTime;
        Resolution resolution = this.resolution;
        Orientation orientation = this.orientation;
        MimeType mimeType = this.mimeType;
        return "AndroidImage(uri=" + uri + ", path=" + str + ", contentSize=" + m2193toStringimpl + ", createTime=" + instant + ", modifyTime=" + instant2 + ", resolution=" + resolution + ", orientation=" + orientation + ", mimeType=" + mimeType + ", albumInfo=" + this.albumInfo + ")";
    }

    private AndroidImage(Uri uri, String path, double contentSize, Instant createTime, Instant modifyTime, Resolution resolution, Orientation orientation, MimeType mimeType, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(modifyTime, "modifyTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.uri = uri;
        this.path = path;
        this.contentSize = contentSize;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.resolution = resolution;
        this.orientation = orientation;
        this.mimeType = mimeType;
        this.albumInfo = albumInfo;
    }

    @Override // kntr.common.photonic.Asset
    public /* bridge */ AssetType getAssetType() {
        return Asset.CC.$default$getAssetType(this);
    }

    @Override // kntr.common.photonic.Asset
    public /* bridge */ Resolution getRotatedResolution() {
        return Asset.CC.$default$getRotatedResolution(this);
    }

    public final Uri getUri() {
        return this.uri;
    }

    @Override // kntr.common.photonic.gallery.AndroidAsset
    public String getPath() {
        return this.path;
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

    @Override // kntr.common.photonic.gallery.AndroidAsset
    public AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    @Override // kntr.common.photonic.Asset
    public Object reader(Continuation<? super Source> continuation) {
        return UriUtilKt.readContent(this.uri, continuation);
    }

    @Override // kntr.common.photonic.Asset
    public String getIdentifier() {
        String uri = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }
}