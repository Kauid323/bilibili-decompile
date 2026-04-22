package kntr.common.paragraph.assetuploader.impl;

import java.util.Arrays;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.KilobytesSizeSerializer;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: ImageAssetWrapper.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0097@¢\u0006\u0002\u0010\nJ\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0013\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010-\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/ImageAssetWrapper;", "Lkntr/common/photonic/Asset;", "byteArray", "", "<init>", "([B)V", "getByteArray", "()[B", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "createTime", "Lkotlinx/datetime/Instant;", "getCreateTime", "()Lkotlinx/datetime/Instant;", "modifyTime", "getModifyTime", "mimeType", "Lkntr/common/photonic/MimeType;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "contentSize", "Lkntr/common/photonic/ContentSize;", "getContentSize-QJZHGII", "()D", "equals", "", "other", "", "orientation", "Lkntr/common/photonic/Orientation;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "hashCode", "", "component1", "copy", "toString", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageAssetWrapper implements Asset {
    private final byte[] byteArray;

    public static /* synthetic */ ImageAssetWrapper copy$default(ImageAssetWrapper imageAssetWrapper, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = imageAssetWrapper.byteArray;
        }
        return imageAssetWrapper.copy(bArr);
    }

    public final byte[] component1() {
        return this.byteArray;
    }

    public final ImageAssetWrapper copy(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        return new ImageAssetWrapper(bArr);
    }

    public String toString() {
        return "ImageAssetWrapper(byteArray=" + Arrays.toString(this.byteArray) + ")";
    }

    public ImageAssetWrapper(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        this.byteArray = byteArray;
    }

    @Override // kntr.common.photonic.Asset
    public /* bridge */ AssetType getAssetType() {
        return Asset.CC.$default$getAssetType(this);
    }

    @Override // kntr.common.photonic.Asset
    public /* bridge */ Resolution getRotatedResolution() {
        return Asset.CC.$default$getRotatedResolution(this);
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    @Override // kntr.common.photonic.Asset
    public Object reader(Continuation<? super Source> continuation) {
        Sink buffer = new Buffer();
        Sink.-CC.write$default(buffer, this.byteArray, 0, 0, 6, (Object) null);
        return buffer;
    }

    @Override // kntr.common.photonic.Asset
    public Resolution getResolution() {
        return new Resolution(0, 0);
    }

    @Override // kntr.common.photonic.Asset
    public String getIdentifier() {
        return String.valueOf(Arrays.hashCode(this.byteArray));
    }

    @Override // kntr.common.photonic.Asset
    public Instant getCreateTime() {
        return Clock.System.INSTANCE.now();
    }

    @Override // kntr.common.photonic.Asset
    public Instant getModifyTime() {
        return Clock.System.INSTANCE.now();
    }

    @Override // kntr.common.photonic.Asset
    public MimeType getMimeType() {
        return new MimeType(AssetType.Image, "");
    }

    @Override // kntr.common.photonic.Asset
    /* renamed from: getContentSize-QJZHGII  reason: not valid java name */
    public double mo2158getContentSizeQJZHGII() {
        return ((ContentSize) KilobytesSizeSerializer.INSTANCE.getUnit().getToContentSize().invoke(Double.valueOf(this.byteArray.length))).m2195unboximpl();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ImageAssetWrapper imageAssetWrapper = (ImageAssetWrapper) other;
        return Arrays.equals(this.byteArray, ((ImageAssetWrapper) other).byteArray);
    }

    @Override // kntr.common.photonic.Asset
    public Orientation getOrientation() {
        return Orientation.Normal;
    }

    public int hashCode() {
        return Arrays.hashCode(this.byteArray);
    }
}