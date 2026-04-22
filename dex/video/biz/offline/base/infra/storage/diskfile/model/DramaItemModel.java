package video.biz.offline.base.infra.storage.diskfile.model;

import ComposableSingletons$CustomBottomSheetKt$;
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
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DramaGroupModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nBE\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\fHÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006,"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "", "aid", "", "cid", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "section", "idx", "<init>", "(JJLjava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAid", "()J", "getCid", "getTitle", "()Ljava/lang/String;", "getSection", "getIdx", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DramaItemModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long aid;
    private final long cid;
    private final long idx;
    private final long section;
    private final String title;

    public final long component1() {
        return this.aid;
    }

    public final long component2() {
        return this.cid;
    }

    public final String component3() {
        return this.title;
    }

    public final long component4() {
        return this.section;
    }

    public final long component5() {
        return this.idx;
    }

    public final DramaItemModel copy(long j, long j2, String str, long j3, long j4) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        return new DramaItemModel(j, j2, str, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DramaItemModel) {
            DramaItemModel dramaItemModel = (DramaItemModel) obj;
            return this.aid == dramaItemModel.aid && this.cid == dramaItemModel.cid && Intrinsics.areEqual(this.title, dramaItemModel.title) && this.section == dramaItemModel.section && this.idx == dramaItemModel.idx;
        }
        return false;
    }

    public int hashCode() {
        return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid)) * 31) + this.title.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.section)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.idx);
    }

    public String toString() {
        long j = this.aid;
        long j2 = this.cid;
        String str = this.title;
        long j3 = this.section;
        return "DramaItemModel(aid=" + j + ", cid=" + j2 + ", title=" + str + ", section=" + j3 + ", idx=" + this.idx + ")";
    }

    /* compiled from: DramaGroupModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DramaItemModel> serializer() {
            return DramaItemModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DramaItemModel(int seen0, long aid, long cid, String title, long section, long idx, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, DramaItemModel$$serializer.INSTANCE.getDescriptor());
        }
        this.aid = aid;
        this.cid = cid;
        if ((seen0 & 4) == 0) {
            this.title = "";
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.section = 0L;
        } else {
            this.section = section;
        }
        if ((seen0 & 16) == 0) {
            this.idx = 0L;
        } else {
            this.idx = idx;
        }
    }

    public DramaItemModel(long aid, long cid, String title, long section, long idx) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        this.aid = aid;
        this.cid = cid;
        this.title = title;
        this.section = section;
        this.idx = idx;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$infra_debug(DramaItemModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.aid);
        output.encodeLongElement(serialDesc, 1, self.cid);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.title, "")) {
            output.encodeStringElement(serialDesc, 2, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.section != 0) {
            output.encodeLongElement(serialDesc, 3, self.section);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.idx != 0) {
            output.encodeLongElement(serialDesc, 4, self.idx);
        }
    }

    public /* synthetic */ DramaItemModel(long j, long j2, String str, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? 0L : j3, (i & 16) != 0 ? 0L : j4);
    }

    public final long getAid() {
        return this.aid;
    }

    public final long getCid() {
        return this.cid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getSection() {
        return this.section;
    }

    public final long getIdx() {
        return this.idx;
    }
}