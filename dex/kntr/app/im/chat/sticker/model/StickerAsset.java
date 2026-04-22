package kntr.app.im.chat.sticker.model;

import kntr.app.im.chat.sticker.asset.StickerAssetFinder;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.io.CoreKt;
import kotlinx.io.Source;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.PathsKt;

/* compiled from: StickerAsset.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAsset;", "Lkntr/common/photonic/Asset;", "entity", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "contentSize", "Lkntr/common/photonic/ContentSize;", "<init>", "(Lkntr/app/im/chat/sticker/entity/StickerEntity;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEntity$sticker_debug", "()Lkntr/app/im/chat/sticker/entity/StickerEntity;", "getContentSize-QJZHGII", "()D", "D", "identifier", RoomRecommendViewModel.EMPTY_CURSOR, "getIdentifier", "()Ljava/lang/String;", "createTime", "Lkotlinx/datetime/Instant;", "getCreateTime", "()Lkotlinx/datetime/Instant;", "modifyTime", "getModifyTime", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "mimeType", "Lkntr/common/photonic/MimeType;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerAsset implements Asset {
    public static final int $stable = 8;
    private final double contentSize;
    private final StickerEntity entity;
    private final MimeType mimeType;
    private final Resolution resolution;

    public /* synthetic */ StickerAsset(StickerEntity stickerEntity, double d, DefaultConstructorMarker defaultConstructorMarker) {
        this(stickerEntity, d);
    }

    private StickerAsset(StickerEntity entity, double contentSize) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.entity = entity;
        this.contentSize = contentSize;
        this.resolution = new Resolution(this.entity.getResolution().getWidthPx(), this.entity.getResolution().getHeightPx());
        this.mimeType = this.entity.getMimeType();
    }

    public /* bridge */ AssetType getAssetType() {
        return Asset.-CC.$default$getAssetType(this);
    }

    public /* bridge */ Resolution getRotatedResolution() {
        return Asset.-CC.$default$getRotatedResolution(this);
    }

    public final StickerEntity getEntity$sticker_debug() {
        return this.entity;
    }

    /* renamed from: getContentSize-QJZHGII  reason: not valid java name */
    public double m1690getContentSizeQJZHGII() {
        return this.contentSize;
    }

    public String getIdentifier() {
        return this.entity.getFileName();
    }

    public Instant getCreateTime() {
        return this.entity.getCTime();
    }

    public Instant getModifyTime() {
        return getCreateTime();
    }

    public Resolution getResolution() {
        return this.resolution;
    }

    public Orientation getOrientation() {
        return Orientation.Normal;
    }

    public MimeType getMimeType() {
        return this.mimeType;
    }

    public Object reader(Continuation<? super Source> continuation) {
        return CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source(PathsKt.Path(StickerAssetFinder.Companion.getStickerSaveRoot$default(StickerAssetFinder.Companion, null, 1, null), new String[]{this.entity.getFileName()})));
    }
}