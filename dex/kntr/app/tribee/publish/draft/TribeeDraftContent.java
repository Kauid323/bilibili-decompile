package kntr.app.tribee.publish.draft;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpus$;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeeInfo$$serializer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: TribeeDraftContent.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB?\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\rHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lkntr/app/tribee/publish/draft/TribeeDraftContent;", "", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "opusContent", "Lcom/bapis/bilibili/dynamic/common/KOpus;", "sendToFollowing", "", "selectedCategoryId", "", "<init>", "(Lkntr/app/tribee/publish/TribeeInfo;Lcom/bapis/bilibili/dynamic/common/KOpus;ZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/tribee/publish/TribeeInfo;Lcom/bapis/bilibili/dynamic/common/KOpus;ZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTribeeInfo", "()Lkntr/app/tribee/publish/TribeeInfo;", "getOpusContent", "()Lcom/bapis/bilibili/dynamic/common/KOpus;", "getSendToFollowing", "()Z", "getSelectedCategoryId", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class TribeeDraftContent {
    public static final Companion Companion = new Companion(null);
    private final KOpus opusContent;
    private final long selectedCategoryId;
    private final boolean sendToFollowing;
    private final TribeeInfo tribeeInfo;

    public static /* synthetic */ TribeeDraftContent copy$default(TribeeDraftContent tribeeDraftContent, TribeeInfo tribeeInfo, KOpus kOpus, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeeInfo = tribeeDraftContent.tribeeInfo;
        }
        if ((i & 2) != 0) {
            kOpus = tribeeDraftContent.opusContent;
        }
        KOpus kOpus2 = kOpus;
        if ((i & 4) != 0) {
            z = tribeeDraftContent.sendToFollowing;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = tribeeDraftContent.selectedCategoryId;
        }
        return tribeeDraftContent.copy(tribeeInfo, kOpus2, z2, j);
    }

    public final TribeeInfo component1() {
        return this.tribeeInfo;
    }

    public final KOpus component2() {
        return this.opusContent;
    }

    public final boolean component3() {
        return this.sendToFollowing;
    }

    public final long component4() {
        return this.selectedCategoryId;
    }

    public final TribeeDraftContent copy(TribeeInfo tribeeInfo, KOpus kOpus, boolean z, long j) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(kOpus, "opusContent");
        return new TribeeDraftContent(tribeeInfo, kOpus, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeDraftContent) {
            TribeeDraftContent tribeeDraftContent = (TribeeDraftContent) obj;
            return Intrinsics.areEqual(this.tribeeInfo, tribeeDraftContent.tribeeInfo) && Intrinsics.areEqual(this.opusContent, tribeeDraftContent.opusContent) && this.sendToFollowing == tribeeDraftContent.sendToFollowing && this.selectedCategoryId == tribeeDraftContent.selectedCategoryId;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.tribeeInfo.hashCode() * 31) + this.opusContent.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sendToFollowing)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.selectedCategoryId);
    }

    public String toString() {
        TribeeInfo tribeeInfo = this.tribeeInfo;
        KOpus kOpus = this.opusContent;
        boolean z = this.sendToFollowing;
        return "TribeeDraftContent(tribeeInfo=" + tribeeInfo + ", opusContent=" + kOpus + ", sendToFollowing=" + z + ", selectedCategoryId=" + this.selectedCategoryId + ")";
    }

    /* compiled from: TribeeDraftContent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/publish/draft/TribeeDraftContent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/tribee/publish/draft/TribeeDraftContent;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TribeeDraftContent> serializer() {
            return TribeeDraftContent$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TribeeDraftContent(int seen0, TribeeInfo tribeeInfo, KOpus opusContent, boolean sendToFollowing, long selectedCategoryId, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, TribeeDraftContent$$serializer.INSTANCE.getDescriptor());
        }
        this.tribeeInfo = tribeeInfo;
        this.opusContent = opusContent;
        this.sendToFollowing = sendToFollowing;
        if ((seen0 & 8) == 0) {
            this.selectedCategoryId = 0L;
        } else {
            this.selectedCategoryId = selectedCategoryId;
        }
    }

    public TribeeDraftContent(TribeeInfo tribeeInfo, KOpus opusContent, boolean sendToFollowing, long selectedCategoryId) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(opusContent, "opusContent");
        this.tribeeInfo = tribeeInfo;
        this.opusContent = opusContent;
        this.sendToFollowing = sendToFollowing;
        this.selectedCategoryId = selectedCategoryId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(TribeeDraftContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, TribeeInfo$$serializer.INSTANCE, self.tribeeInfo);
        output.encodeSerializableElement(serialDesc, 1, KOpus$.serializer.INSTANCE, self.opusContent);
        output.encodeBooleanElement(serialDesc, 2, self.sendToFollowing);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.selectedCategoryId != 0) {
            output.encodeLongElement(serialDesc, 3, self.selectedCategoryId);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TribeeDraftContent(TribeeInfo tribeeInfo, KOpus kOpus, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tribeeInfo, kOpus, z, r4);
        long j2;
        if ((i & 8) == 0) {
            j2 = j;
        } else {
            j2 = 0;
        }
    }

    public final TribeeInfo getTribeeInfo() {
        return this.tribeeInfo;
    }

    public final KOpus getOpusContent() {
        return this.opusContent;
    }

    public final boolean getSendToFollowing() {
        return this.sendToFollowing;
    }

    public final long getSelectedCategoryId() {
        return this.selectedCategoryId;
    }
}