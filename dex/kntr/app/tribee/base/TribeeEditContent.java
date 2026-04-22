package kntr.app.tribee.base;

import com.bapis.bilibili.dynamic.common.KArticle;
import com.bapis.bilibili.dynamic.common.KCreateAttachCard;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpusAttachments;
import com.bapis.bilibili.dynamic.common.KOpusContent;
import com.bapis.bilibili.dynamic.common.KOpusSource;
import com.bapis.bilibili.dynamic.common.KPlusRedDot;
import com.bapis.bilibili.dynamic.common.KPubInfo;
import com.bapis.bilibili.dynamic.common.KPublishSetting;
import com.bapis.bilibili.dynamic.common.KPublishYellowBar;
import com.bapis.bilibili.dynamic.common.KShareChannel;
import com.bapis.bilibili.dynamic.common.KTranslateResult;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermission;
import com.bapis.bilibili.dynamic.common.KVersion;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KCreatePageCommercialInfo;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KGetEditDynInfoRsp;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: TribeeContainer.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u001c\u001a\u00020\tH\u0007J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lkntr/app/tribee/base/TribeeEditContent;", "", "id", "", "editRsp", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KGetEditDynInfoRsp;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KGetEditDynInfoRsp;)V", "editData", "", "(Ljava/lang/String;[B)V", "getId", "()Ljava/lang/String;", "getEditRsp", "()Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KGetEditDynInfoRsp;", "content", "Lcom/bapis/bilibili/dynamic/common/KOpus;", "getContent", "()Lcom/bapis/bilibili/dynamic/common/KOpus;", RedirectImpKt.REDIRECT_KV_CONFIG, "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "getConfig", "()Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "getCategories", "()Ljava/util/List;", "getEditData", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeEditContent {
    private final KGetEditDynInfoRsp editRsp;
    private final String id;

    public static /* synthetic */ TribeeEditContent copy$default(TribeeEditContent tribeeEditContent, String str, KGetEditDynInfoRsp kGetEditDynInfoRsp, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tribeeEditContent.id;
        }
        if ((i & 2) != 0) {
            kGetEditDynInfoRsp = tribeeEditContent.editRsp;
        }
        return tribeeEditContent.copy(str, kGetEditDynInfoRsp);
    }

    public final String component1() {
        return this.id;
    }

    public final KGetEditDynInfoRsp component2() {
        return this.editRsp;
    }

    public final TribeeEditContent copy(String str, KGetEditDynInfoRsp kGetEditDynInfoRsp) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(kGetEditDynInfoRsp, "editRsp");
        return new TribeeEditContent(str, kGetEditDynInfoRsp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TribeeEditContent) {
            TribeeEditContent tribeeEditContent = (TribeeEditContent) obj;
            return Intrinsics.areEqual(this.id, tribeeEditContent.id) && Intrinsics.areEqual(this.editRsp, tribeeEditContent.editRsp);
        }
        return false;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.editRsp.hashCode();
    }

    public String toString() {
        String str = this.id;
        return "TribeeEditContent(id=" + str + ", editRsp=" + this.editRsp + ")";
    }

    public TribeeEditContent(String id, KGetEditDynInfoRsp editRsp) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(editRsp, "editRsp");
        this.id = id;
        this.editRsp = editRsp;
    }

    public final String getId() {
        return this.id;
    }

    public final KGetEditDynInfoRsp getEditRsp() {
        return this.editRsp;
    }

    public final KOpus getContent() {
        KOpus opus = this.editRsp.getOpus();
        return opus == null ? new KOpus(0L, (KOpusSource) null, (String) null, 0L, (String) null, (KOpusContent) null, (List) null, (KPubInfo) null, (KArticle) null, (KVersion) null, 0L, (KOpusAttachments) null, (KTranslateResult) null, (String) null, 16383, (DefaultConstructorMarker) null) : opus;
    }

    public final KTribeePublishConfig getConfig() {
        KTribeePublishConfig tribeeSetting = this.editRsp.getTribeeSetting();
        return tribeeSetting == null ? new KTribeePublishConfig(0L, 0L, 0L, 0L, 0L, 31, (DefaultConstructorMarker) null) : tribeeSetting;
    }

    public final List<KTribeeCategory> getCategories() {
        return this.editRsp.getTribeeCategories();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TribeeEditContent(String id, byte[] editData) {
        this(id, r5);
        KGetEditDynInfoRsp kGetEditDynInfoRsp;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(editData, "editData");
        try {
            BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
            $this$decodeFromByteArray$iv.getSerializersModule();
            kGetEditDynInfoRsp = (KGetEditDynInfoRsp) $this$decodeFromByteArray$iv.decodeFromByteArray(KGetEditDynInfoRsp.Companion.serializer(), editData);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeContainer", "decode editData error: " + e);
            kGetEditDynInfoRsp = new KGetEditDynInfoRsp((List) null, 0L, 0L, (List) null, (KCreateAttachCard) null, (KPublishSetting) null, (KUpPermission) null, (KShareChannel) null, (KPublishYellowBar) null, (KPlusRedDot) null, 0L, (String) null, 0L, (KCreatePageCommercialInfo) null, (KTribeePublishConfig) null, (KOpus) null, 0L, 0, (List) null, 524287, (DefaultConstructorMarker) null);
        }
    }

    public final byte[] getEditData() {
        BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
        Object value$iv = this.editRsp;
        $this$encodeToByteArray$iv.getSerializersModule();
        return $this$encodeToByteArray$iv.encodeToByteArray(KGetEditDynInfoRsp.Companion.serializer(), value$iv);
    }
}