package kntr.app.tribee.base;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.KDynReplyIcon;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: TribeeResultChannel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lkntr/app/tribee/base/TribeeResultContent;", "", "categoryId", "", "content", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;", "<init>", "(JLcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;)V", "contentData", "", "(J[B)V", "getCategoryId", "()J", "getContent", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeResultContent {
    private final long categoryId;
    private final KTribeeDyn content;

    public static /* synthetic */ TribeeResultContent copy$default(TribeeResultContent tribeeResultContent, long j, KTribeeDyn kTribeeDyn, int i, Object obj) {
        if ((i & 1) != 0) {
            j = tribeeResultContent.categoryId;
        }
        if ((i & 2) != 0) {
            kTribeeDyn = tribeeResultContent.content;
        }
        return tribeeResultContent.copy(j, kTribeeDyn);
    }

    public final long component1() {
        return this.categoryId;
    }

    public final KTribeeDyn component2() {
        return this.content;
    }

    public final TribeeResultContent copy(long j, KTribeeDyn kTribeeDyn) {
        Intrinsics.checkNotNullParameter(kTribeeDyn, "content");
        return new TribeeResultContent(j, kTribeeDyn);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeResultContent) {
            TribeeResultContent tribeeResultContent = (TribeeResultContent) obj;
            return this.categoryId == tribeeResultContent.categoryId && Intrinsics.areEqual(this.content, tribeeResultContent.content);
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.categoryId) * 31) + this.content.hashCode();
    }

    public String toString() {
        long j = this.categoryId;
        return "TribeeResultContent(categoryId=" + j + ", content=" + this.content + ")";
    }

    public TribeeResultContent(long categoryId, KTribeeDyn content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.categoryId = categoryId;
        this.content = content;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final KTribeeDyn getContent() {
        return this.content;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TribeeResultContent(long categoryId, byte[] contentData) {
        this(categoryId, r4);
        KTribeeDyn kTribeeDyn;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        try {
            BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
            $this$decodeFromByteArray$iv.getSerializersModule();
            kTribeeDyn = (KTribeeDyn) $this$decodeFromByteArray$iv.decodeFromByteArray(KTribeeDyn.Companion.serializer(), contentData);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeResultChannel", "Failed to decode TribeeResultContent", e);
            kTribeeDyn = new KTribeeDyn(0L, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (List) null, (KDynReplyIcon) null, 511, (DefaultConstructorMarker) null);
        }
    }
}