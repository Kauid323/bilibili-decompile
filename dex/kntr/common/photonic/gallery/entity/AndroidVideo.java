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
import kntr.common.photonic.VideoAsset;
import kntr.common.photonic.gallery.AndroidAsset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.Instant;
import kotlinx.io.Source;

/* compiled from: AndroidVideo.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J\t\u00102\u001a\u00020\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00104\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b5\u0010\u001dJ\u0010\u00106\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b7\u0010 J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\t\u0010;\u001a\u00020\u0011HÆ\u0003J\t\u0010<\u001a\u00020\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0015HÆ\u0003Jv\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b?\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\r\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001b¨\u0006H"}, d2 = {"Lkntr/common/photonic/gallery/entity/AndroidVideo;", "Lkntr/common/photonic/VideoAsset;", "Lkntr/common/photonic/gallery/AndroidAsset;", "uri", "Landroid/net/Uri;", "path", "", "videoDuration", "Lkotlin/time/Duration;", "contentSize", "Lkntr/common/photonic/ContentSize;", "createTime", "Lkotlinx/datetime/Instant;", "modifyTime", "resolution", "Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "mimeType", "Lkntr/common/photonic/MimeType;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "<init>", "(Landroid/net/Uri;Ljava/lang/String;JDLkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkntr/common/photonic/MimeType;Lkntr/common/photonic/AlbumInfo;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUri", "()Landroid/net/Uri;", "getPath", "()Ljava/lang/String;", "getVideoDuration-UwyO8pc", "()J", "J", "getContentSize-QJZHGII", "()D", "D", "getCreateTime", "()Lkotlinx/datetime/Instant;", "getModifyTime", "getResolution", "()Lkntr/common/photonic/Resolution;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identifier", "getIdentifier", "component1", "component2", "component3", "component3-UwyO8pc", "component4", "component4-QJZHGII", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "copy-pfP_C9g", "(Landroid/net/Uri;Ljava/lang/String;JDLkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkntr/common/photonic/MimeType;Lkntr/common/photonic/AlbumInfo;)Lkntr/common/photonic/gallery/entity/AndroidVideo;", "equals", "", "other", "", "hashCode", "", "toString", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidVideo implements VideoAsset, AndroidAsset {
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
    private final long videoDuration;

    public /* synthetic */ AndroidVideo(Uri uri, String str, long j, double d, Instant instant, Instant instant2, Resolution resolution, Orientation orientation, MimeType mimeType, AlbumInfo albumInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, j, d, instant, instant2, resolution, orientation, mimeType, albumInfo);
    }

    public final Uri component1() {
        return this.uri;
    }

    public final AlbumInfo component10() {
        return this.albumInfo;
    }

    public final String component2() {
        return this.path;
    }

    /* renamed from: component3-UwyO8pc  reason: not valid java name */
    public final long m2340component3UwyO8pc() {
        return this.videoDuration;
    }

    /* renamed from: component4-QJZHGII  reason: not valid java name */
    public final double m2341component4QJZHGII() {
        return this.contentSize;
    }

    public final Instant component5() {
        return this.createTime;
    }

    public final Instant component6() {
        return this.modifyTime;
    }

    public final Resolution component7() {
        return this.resolution;
    }

    public final Orientation component8() {
        return this.orientation;
    }

    public final MimeType component9() {
        return this.mimeType;
    }

    /* renamed from: copy-pfP_C9g  reason: not valid java name */
    public final AndroidVideo m2342copypfP_C9g(Uri uri, String str, long j, double d, Instant instant, Instant instant2, Resolution resolution, Orientation orientation, MimeType mimeType, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(instant, "createTime");
        Intrinsics.checkNotNullParameter(instant2, "modifyTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        return new AndroidVideo(uri, str, j, d, instant, instant2, resolution, orientation, mimeType, albumInfo, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AndroidVideo) {
            AndroidVideo androidVideo = (AndroidVideo) obj;
            return Intrinsics.areEqual(this.uri, androidVideo.uri) && Intrinsics.areEqual(this.path, androidVideo.path) && Duration.equals-impl0(this.videoDuration, androidVideo.videoDuration) && ContentSize.m2186equalsimpl0(this.contentSize, androidVideo.contentSize) && Intrinsics.areEqual(this.createTime, androidVideo.createTime) && Intrinsics.areEqual(this.modifyTime, androidVideo.modifyTime) && Intrinsics.areEqual(this.resolution, androidVideo.resolution) && this.orientation == androidVideo.orientation && Intrinsics.areEqual(this.mimeType, androidVideo.mimeType) && Intrinsics.areEqual(this.albumInfo, androidVideo.albumInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.uri.hashCode() * 31) + (this.path == null ? 0 : this.path.hashCode())) * 31) + Duration.hashCode-impl(this.videoDuration)) * 31) + ContentSize.m2190hashCodeimpl(this.contentSize)) * 31) + this.createTime.hashCode()) * 31) + this.modifyTime.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.orientation.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + this.albumInfo.hashCode();
    }

    public String toString() {
        Uri uri = this.uri;
        String str = this.path;
        String str2 = Duration.toString-impl(this.videoDuration);
        String m2193toStringimpl = ContentSize.m2193toStringimpl(this.contentSize);
        Instant instant = this.createTime;
        Instant instant2 = this.modifyTime;
        Resolution resolution = this.resolution;
        Orientation orientation = this.orientation;
        MimeType mimeType = this.mimeType;
        return "AndroidVideo(uri=" + uri + ", path=" + str + ", videoDuration=" + str2 + ", contentSize=" + m2193toStringimpl + ", createTime=" + instant + ", modifyTime=" + instant2 + ", resolution=" + resolution + ", orientation=" + orientation + ", mimeType=" + mimeType + ", albumInfo=" + this.albumInfo + ")";
    }

    private AndroidVideo(Uri uri, String path, long videoDuration, double contentSize, Instant createTime, Instant modifyTime, Resolution resolution, Orientation orientation, MimeType mimeType, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(modifyTime, "modifyTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.uri = uri;
        this.path = path;
        this.videoDuration = videoDuration;
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

    @Override // kntr.common.photonic.VideoAsset
    /* renamed from: getVideoDuration-UwyO8pc */
    public long mo2200getVideoDurationUwyO8pc() {
        return this.videoDuration;
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