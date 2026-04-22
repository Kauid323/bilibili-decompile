package kntr.app.im.chat.service.sender.image;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.io.CoreKt;
import kotlinx.io.Source;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* compiled from: LocalImageAsset.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b)\u0010\u0011J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003JB\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u00067"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "Lkntr/common/photonic/Asset;", "path", "Lkotlinx/io/files/Path;", "contentSize", "Lkntr/common/photonic/ContentSize;", "mimeType", "Lkntr/common/photonic/MimeType;", "resolution", "Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "<init>", "(Lkotlinx/io/files/Path;DLkntr/common/photonic/MimeType;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPath$biz_debug", "()Lkotlinx/io/files/Path;", "getContentSize-QJZHGII", "()D", "D", "getMimeType", "()Lkntr/common/photonic/MimeType;", "getResolution", "()Lkntr/common/photonic/Resolution;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "identifier", RoomRecommendViewModel.EMPTY_CURSOR, "getIdentifier", "()Ljava/lang/String;", "createTime", "Lkotlinx/datetime/Instant;", "getCreateTime", "()Lkotlinx/datetime/Instant;", "modifyTime", "getModifyTime", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component1$biz_debug", "component2", "component2-QJZHGII", "component3", "component4", "component5", "copy", "copy-0XCtKjw", "(Lkotlinx/io/files/Path;DLkntr/common/photonic/MimeType;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;)Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalImageAsset implements Asset {
    public static final int $stable = 0;
    private final double contentSize;
    private final MimeType mimeType;
    private final Orientation orientation;
    private final Path path;
    private final Resolution resolution;

    public /* synthetic */ LocalImageAsset(Path path, double d, MimeType mimeType, Resolution resolution, Orientation orientation, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, d, mimeType, resolution, orientation);
    }

    /* renamed from: copy-0XCtKjw$default  reason: not valid java name */
    public static /* synthetic */ LocalImageAsset m1596copy0XCtKjw$default(LocalImageAsset localImageAsset, Path path, double d, MimeType mimeType, Resolution resolution, Orientation orientation, int i, Object obj) {
        if ((i & 1) != 0) {
            path = localImageAsset.path;
        }
        if ((i & 2) != 0) {
            d = localImageAsset.contentSize;
        }
        double d2 = d;
        if ((i & 4) != 0) {
            mimeType = localImageAsset.mimeType;
        }
        MimeType mimeType2 = mimeType;
        if ((i & 8) != 0) {
            resolution = localImageAsset.resolution;
        }
        Resolution resolution2 = resolution;
        if ((i & 16) != 0) {
            orientation = localImageAsset.orientation;
        }
        return localImageAsset.m1598copy0XCtKjw(path, d2, mimeType2, resolution2, orientation);
    }

    public final Path component1$biz_debug() {
        return this.path;
    }

    /* renamed from: component2-QJZHGII  reason: not valid java name */
    public final double m1597component2QJZHGII() {
        return this.contentSize;
    }

    public final MimeType component3() {
        return this.mimeType;
    }

    public final Resolution component4() {
        return this.resolution;
    }

    public final Orientation component5() {
        return this.orientation;
    }

    /* renamed from: copy-0XCtKjw  reason: not valid java name */
    public final LocalImageAsset m1598copy0XCtKjw(Path path, double d, MimeType mimeType, Resolution resolution, Orientation orientation) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new LocalImageAsset(path, d, mimeType, resolution, orientation, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalImageAsset) {
            LocalImageAsset localImageAsset = (LocalImageAsset) obj;
            return Intrinsics.areEqual(this.path, localImageAsset.path) && ContentSize.equals-impl0(this.contentSize, localImageAsset.contentSize) && Intrinsics.areEqual(this.mimeType, localImageAsset.mimeType) && Intrinsics.areEqual(this.resolution, localImageAsset.resolution) && this.orientation == localImageAsset.orientation;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.path.hashCode() * 31) + ContentSize.hashCode-impl(this.contentSize)) * 31) + this.mimeType.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.orientation.hashCode();
    }

    public String toString() {
        Path path = this.path;
        String str = ContentSize.toString-impl(this.contentSize);
        MimeType mimeType = this.mimeType;
        Resolution resolution = this.resolution;
        return "LocalImageAsset(path=" + path + ", contentSize=" + str + ", mimeType=" + mimeType + ", resolution=" + resolution + ", orientation=" + this.orientation + ")";
    }

    private LocalImageAsset(Path path, double contentSize, MimeType mimeType, Resolution resolution, Orientation orientation) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.path = path;
        this.contentSize = contentSize;
        this.mimeType = mimeType;
        this.resolution = resolution;
        this.orientation = orientation;
    }

    public /* bridge */ AssetType getAssetType() {
        return Asset.-CC.$default$getAssetType(this);
    }

    public /* bridge */ Resolution getRotatedResolution() {
        return Asset.-CC.$default$getRotatedResolution(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LocalImageAsset(Path path, double d, MimeType mimeType, Resolution resolution, Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, d, mimeType, r6, r7, null);
        Resolution resolution2;
        Orientation orientation2;
        if ((i & 8) == 0) {
            resolution2 = resolution;
        } else {
            resolution2 = Resolution.Companion.getZero();
        }
        if ((i & 16) == 0) {
            orientation2 = orientation;
        } else {
            orientation2 = Orientation.Normal;
        }
    }

    public final Path getPath$biz_debug() {
        return this.path;
    }

    /* renamed from: getContentSize-QJZHGII  reason: not valid java name */
    public double m1599getContentSizeQJZHGII() {
        return this.contentSize;
    }

    public MimeType getMimeType() {
        return this.mimeType;
    }

    public Resolution getResolution() {
        return this.resolution;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public String getIdentifier() {
        return this.path.toString();
    }

    public Instant getCreateTime() {
        return Instant.Companion.getDISTANT_PAST();
    }

    public Instant getModifyTime() {
        return Instant.Companion.getDISTANT_PAST();
    }

    public Object reader(Continuation<? super Source> continuation) {
        return CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source(this.path));
    }
}