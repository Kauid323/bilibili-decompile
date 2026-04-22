package kntr.app.tribee.publish.core.v2.service;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpus$;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo$$serializer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.SerializableNodeStorage;
import kntr.common.ouro.core.model.SerializableNodeStorage$$serializer;
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

/* compiled from: TribeePublishDraftService.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBI\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J;\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000fHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lkntr/app/tribee/publish/core/v2/service/TribeeDraftContent;", "", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "opusContent", "Lcom/bapis/bilibili/dynamic/common/KOpus;", "document", "Lkntr/common/ouro/core/model/SerializableNodeStorage;", "sendToFollowing", "", "selectedCategoryId", "", "<init>", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lcom/bapis/bilibili/dynamic/common/KOpus;Lkntr/common/ouro/core/model/SerializableNodeStorage;ZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lcom/bapis/bilibili/dynamic/common/KOpus;Lkntr/common/ouro/core/model/SerializableNodeStorage;ZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTribeeInfo", "()Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "getOpusContent", "()Lcom/bapis/bilibili/dynamic/common/KOpus;", "getDocument", "()Lkntr/common/ouro/core/model/SerializableNodeStorage;", "getSendToFollowing", "()Z", "getSelectedCategoryId", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class TribeeDraftContent {
    public static final Companion Companion = new Companion(null);
    private final SerializableNodeStorage document;
    private final KOpus opusContent;
    private final long selectedCategoryId;
    private final boolean sendToFollowing;
    private final TribeeInfo tribeeInfo;

    public static /* synthetic */ TribeeDraftContent copy$default(TribeeDraftContent tribeeDraftContent, TribeeInfo tribeeInfo, KOpus kOpus, SerializableNodeStorage serializableNodeStorage, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            tribeeInfo = tribeeDraftContent.tribeeInfo;
        }
        if ((i & 2) != 0) {
            kOpus = tribeeDraftContent.opusContent;
        }
        KOpus kOpus2 = kOpus;
        if ((i & 4) != 0) {
            serializableNodeStorage = tribeeDraftContent.document;
        }
        SerializableNodeStorage serializableNodeStorage2 = serializableNodeStorage;
        if ((i & 8) != 0) {
            z = tribeeDraftContent.sendToFollowing;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            j = tribeeDraftContent.selectedCategoryId;
        }
        return tribeeDraftContent.copy(tribeeInfo, kOpus2, serializableNodeStorage2, z2, j);
    }

    public final TribeeInfo component1() {
        return this.tribeeInfo;
    }

    public final KOpus component2() {
        return this.opusContent;
    }

    public final SerializableNodeStorage component3() {
        return this.document;
    }

    public final boolean component4() {
        return this.sendToFollowing;
    }

    public final long component5() {
        return this.selectedCategoryId;
    }

    public final TribeeDraftContent copy(TribeeInfo tribeeInfo, KOpus kOpus, SerializableNodeStorage serializableNodeStorage, boolean z, long j) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(kOpus, "opusContent");
        Intrinsics.checkNotNullParameter(serializableNodeStorage, "document");
        return new TribeeDraftContent(tribeeInfo, kOpus, serializableNodeStorage, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeDraftContent) {
            TribeeDraftContent tribeeDraftContent = (TribeeDraftContent) obj;
            return Intrinsics.areEqual(this.tribeeInfo, tribeeDraftContent.tribeeInfo) && Intrinsics.areEqual(this.opusContent, tribeeDraftContent.opusContent) && Intrinsics.areEqual(this.document, tribeeDraftContent.document) && this.sendToFollowing == tribeeDraftContent.sendToFollowing && this.selectedCategoryId == tribeeDraftContent.selectedCategoryId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.tribeeInfo.hashCode() * 31) + this.opusContent.hashCode()) * 31) + this.document.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sendToFollowing)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.selectedCategoryId);
    }

    public String toString() {
        TribeeInfo tribeeInfo = this.tribeeInfo;
        KOpus kOpus = this.opusContent;
        SerializableNodeStorage serializableNodeStorage = this.document;
        boolean z = this.sendToFollowing;
        return "TribeeDraftContent(tribeeInfo=" + tribeeInfo + ", opusContent=" + kOpus + ", document=" + serializableNodeStorage + ", sendToFollowing=" + z + ", selectedCategoryId=" + this.selectedCategoryId + ")";
    }

    /* compiled from: TribeePublishDraftService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/publish/core/v2/service/TribeeDraftContent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/tribee/publish/core/v2/service/TribeeDraftContent;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
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

    public /* synthetic */ TribeeDraftContent(int seen0, TribeeInfo tribeeInfo, KOpus opusContent, SerializableNodeStorage document, boolean sendToFollowing, long selectedCategoryId, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, TribeeDraftContent$$serializer.INSTANCE.getDescriptor());
        }
        this.tribeeInfo = tribeeInfo;
        this.opusContent = opusContent;
        this.document = document;
        this.sendToFollowing = sendToFollowing;
        if ((seen0 & 16) == 0) {
            this.selectedCategoryId = 0L;
        } else {
            this.selectedCategoryId = selectedCategoryId;
        }
    }

    public TribeeDraftContent(TribeeInfo tribeeInfo, KOpus opusContent, SerializableNodeStorage document, boolean sendToFollowing, long selectedCategoryId) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(opusContent, "opusContent");
        Intrinsics.checkNotNullParameter(document, "document");
        this.tribeeInfo = tribeeInfo;
        this.opusContent = opusContent;
        this.document = document;
        this.sendToFollowing = sendToFollowing;
        this.selectedCategoryId = selectedCategoryId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(TribeeDraftContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, TribeeInfo$$serializer.INSTANCE, self.tribeeInfo);
        output.encodeSerializableElement(serialDesc, 1, KOpus$.serializer.INSTANCE, self.opusContent);
        output.encodeSerializableElement(serialDesc, 2, SerializableNodeStorage$$serializer.INSTANCE, self.document);
        output.encodeBooleanElement(serialDesc, 3, self.sendToFollowing);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.selectedCategoryId != 0) {
            output.encodeLongElement(serialDesc, 4, self.selectedCategoryId);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TribeeDraftContent(TribeeInfo tribeeInfo, KOpus kOpus, SerializableNodeStorage serializableNodeStorage, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tribeeInfo, kOpus, serializableNodeStorage, z, r5);
        long j2;
        if ((i & 16) == 0) {
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

    public final SerializableNodeStorage getDocument() {
        return this.document;
    }

    public final boolean getSendToFollowing() {
        return this.sendToFollowing;
    }

    public final long getSelectedCategoryId() {
        return this.selectedCategoryId;
    }
}