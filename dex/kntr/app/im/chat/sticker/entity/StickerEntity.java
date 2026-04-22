package kntr.app.im.chat.sticker.entity;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: StickerEntity.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rB1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\f\u0010\u0011J\u0006\u0010\u001c\u001a\u00020\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000e\u0010\"\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b#JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006+"}, d2 = {"Lkntr/app/im/chat/sticker/entity/StickerEntity;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "fileName", RoomRecommendViewModel.EMPTY_CURSOR, "cTime", "Lkotlinx/datetime/Instant;", ReportBuildInParam.MID, "resolution", "Lkntr/app/im/chat/sticker/entity/StickerResolution;", "mime", "<init>", "(JLjava/lang/String;Lkotlinx/datetime/Instant;JLkntr/app/im/chat/sticker/entity/StickerResolution;Ljava/lang/String;)V", "Lkntr/common/photonic/Resolution;", "mimeType", "Lkntr/common/photonic/MimeType;", "(Ljava/lang/String;Lkotlinx/datetime/Instant;JLkntr/common/photonic/Resolution;Lkntr/common/photonic/MimeType;)V", "getId", "()J", "getFileName", "()Ljava/lang/String;", "getCTime", "()Lkotlinx/datetime/Instant;", "getMid", "getResolution", "()Lkntr/app/im/chat/sticker/entity/StickerResolution;", "getMime$sticker_debug", "getMimeType", "component1", "component2", "component3", "component4", "component5", "component6", "component6$sticker_debug", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerEntity {
    public static final int $stable = 8;
    private final Instant cTime;
    private final String fileName;
    private final long id;
    private final long mid;
    private final String mime;
    private final StickerResolution resolution;

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.fileName;
    }

    public final Instant component3() {
        return this.cTime;
    }

    public final long component4() {
        return this.mid;
    }

    public final StickerResolution component5() {
        return this.resolution;
    }

    public final String component6$sticker_debug() {
        return this.mime;
    }

    public final StickerEntity copy(long j2, String str, Instant instant, long j3, StickerResolution stickerResolution, String str2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(instant, "cTime");
        Intrinsics.checkNotNullParameter(stickerResolution, "resolution");
        Intrinsics.checkNotNullParameter(str2, "mime");
        return new StickerEntity(j2, str, instant, j3, stickerResolution, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerEntity) {
            StickerEntity stickerEntity = (StickerEntity) obj;
            return this.id == stickerEntity.id && Intrinsics.areEqual(this.fileName, stickerEntity.fileName) && Intrinsics.areEqual(this.cTime, stickerEntity.cTime) && this.mid == stickerEntity.mid && Intrinsics.areEqual(this.resolution, stickerEntity.resolution) && Intrinsics.areEqual(this.mime, stickerEntity.mime);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.fileName.hashCode()) * 31) + this.cTime.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid)) * 31) + this.resolution.hashCode()) * 31) + this.mime.hashCode();
    }

    public String toString() {
        long j2 = this.id;
        String str = this.fileName;
        Instant instant = this.cTime;
        long j3 = this.mid;
        StickerResolution stickerResolution = this.resolution;
        return "StickerEntity(id=" + j2 + ", fileName=" + str + ", cTime=" + instant + ", mid=" + j3 + ", resolution=" + stickerResolution + ", mime=" + this.mime + ")";
    }

    public StickerEntity(long id, String fileName, Instant cTime, long mid, StickerResolution resolution, String mime) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(cTime, "cTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(mime, "mime");
        this.id = id;
        this.fileName = fileName;
        this.cTime = cTime;
        this.mid = mid;
        this.resolution = resolution;
        this.mime = mime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StickerEntity(long j2, String str, Instant instant, long j3, StickerResolution stickerResolution, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, str, instant, j3, stickerResolution, str2);
        long j4;
        if ((i & 1) == 0) {
            j4 = j2;
        } else {
            j4 = 0;
        }
    }

    public final long getId() {
        return this.id;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Instant getCTime() {
        return this.cTime;
    }

    public final long getMid() {
        return this.mid;
    }

    public final StickerResolution getResolution() {
        return this.resolution;
    }

    public final String getMime$sticker_debug() {
        return this.mime;
    }

    public final MimeType getMimeType() {
        return MimeType.Companion.fromString(this.mime);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerEntity(String fileName, Instant cTime, long mid, Resolution resolution, MimeType mimeType) {
        this(0L, fileName, cTime, mid, new StickerResolution(resolution.getWidthPx(), resolution.getHeightPx()), mimeType.toString());
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(cTime, "cTime");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
    }
}