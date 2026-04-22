package video.biz.offline.base.infra.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.model.DramaItemModel;

/* compiled from: DeprecatedDramaModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB=\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J1\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedDramaItemModel;", "", "avid", "", "position", "section", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "<init>", "(JJJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvid$annotations", "()V", "getAvid", "()J", "getPosition$annotations", "getPosition", "getSection$annotations", "getSection", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "transform", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DeprecatedDramaItemModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long avid;
    private final long position;
    private final long section;
    private final String title;

    @SerialName("avid")
    public static /* synthetic */ void getAvid$annotations() {
    }

    @SerialName("position")
    public static /* synthetic */ void getPosition$annotations() {
    }

    @SerialName("section")
    public static /* synthetic */ void getSection$annotations() {
    }

    @SerialName(RankRouter.BundleKey.ACTION_PARAM_TITLE)
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final long component1() {
        return this.avid;
    }

    public final long component2() {
        return this.position;
    }

    public final long component3() {
        return this.section;
    }

    public final String component4() {
        return this.title;
    }

    public final DeprecatedDramaItemModel copy(long j, long j2, long j3, String str) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        return new DeprecatedDramaItemModel(j, j2, j3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeprecatedDramaItemModel) {
            DeprecatedDramaItemModel deprecatedDramaItemModel = (DeprecatedDramaItemModel) obj;
            return this.avid == deprecatedDramaItemModel.avid && this.position == deprecatedDramaItemModel.position && this.section == deprecatedDramaItemModel.section && Intrinsics.areEqual(this.title, deprecatedDramaItemModel.title);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.position)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.section)) * 31) + this.title.hashCode();
    }

    public String toString() {
        long j = this.avid;
        long j2 = this.position;
        long j3 = this.section;
        return "DeprecatedDramaItemModel(avid=" + j + ", position=" + j2 + ", section=" + j3 + ", title=" + this.title + ")";
    }

    /* compiled from: DeprecatedDramaModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedDramaItemModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedDramaItemModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeprecatedDramaItemModel> serializer() {
            return DeprecatedDramaItemModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeprecatedDramaItemModel(int seen0, long avid, long position, long section, String title, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, DeprecatedDramaItemModel$$serializer.INSTANCE.getDescriptor());
        }
        this.avid = avid;
        this.position = position;
        this.section = section;
        this.title = title;
    }

    public DeprecatedDramaItemModel(long avid, long position, long section, String title) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        this.avid = avid;
        this.position = position;
        this.section = section;
        this.title = title;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$infra_debug(DeprecatedDramaItemModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.avid);
        output.encodeLongElement(serialDesc, 1, self.position);
        output.encodeLongElement(serialDesc, 2, self.section);
        output.encodeStringElement(serialDesc, 3, self.title);
    }

    public final long getAvid() {
        return this.avid;
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getSection() {
        return this.section;
    }

    public final String getTitle() {
        return this.title;
    }

    public final DramaItemModel transform() {
        return new DramaItemModel(this.avid, 0L, this.title, this.section, this.position);
    }
}