package video.biz.offline.base.infra.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;

/* compiled from: DeprecatedDramaModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedDramaModel;", "", "id", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "videoList", "", "Lvideo/biz/offline/base/infra/model/DeprecatedDramaItemModel;", "<init>", "(JLjava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "getVideoList$annotations", "getVideoList", "()Ljava/util/List;", "transform", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DeprecatedDramaModel {
    private final long id;
    private final String title;
    private final List<DeprecatedDramaItemModel> videoList;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.infra.model.DeprecatedDramaModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DeprecatedDramaModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeprecatedDramaModel copy$default(DeprecatedDramaModel deprecatedDramaModel, long j, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = deprecatedDramaModel.id;
        }
        if ((i & 2) != 0) {
            str = deprecatedDramaModel.title;
        }
        if ((i & 4) != 0) {
            list = deprecatedDramaModel.videoList;
        }
        return deprecatedDramaModel.copy(j, str, list);
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName(RankRouter.BundleKey.ACTION_PARAM_TITLE)
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("video_list")
    public static /* synthetic */ void getVideoList$annotations() {
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final List<DeprecatedDramaItemModel> component3() {
        return this.videoList;
    }

    public final DeprecatedDramaModel copy(long j, String str, List<DeprecatedDramaItemModel> list) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(list, "videoList");
        return new DeprecatedDramaModel(j, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeprecatedDramaModel) {
            DeprecatedDramaModel deprecatedDramaModel = (DeprecatedDramaModel) obj;
            return this.id == deprecatedDramaModel.id && Intrinsics.areEqual(this.title, deprecatedDramaModel.title) && Intrinsics.areEqual(this.videoList, deprecatedDramaModel.videoList);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.title.hashCode()) * 31) + this.videoList.hashCode();
    }

    public String toString() {
        long j = this.id;
        String str = this.title;
        return "DeprecatedDramaModel(id=" + j + ", title=" + str + ", videoList=" + this.videoList + ")";
    }

    /* compiled from: DeprecatedDramaModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedDramaModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedDramaModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeprecatedDramaModel> serializer() {
            return DeprecatedDramaModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeprecatedDramaModel(int seen0, long id, String title, List videoList, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, DeprecatedDramaModel$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.title = title;
        this.videoList = videoList;
    }

    public DeprecatedDramaModel(long id, String title, List<DeprecatedDramaItemModel> list) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(list, "videoList");
        this.id = id;
        this.title = title;
        this.videoList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DeprecatedDramaItemModel$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$infra_debug(DeprecatedDramaModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.videoList);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<DeprecatedDramaItemModel> getVideoList() {
        return this.videoList;
    }

    public final DramaGroupModel transform() {
        long j = this.id;
        String str = this.title;
        Iterable $this$map$iv = this.videoList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DeprecatedDramaItemModel it = (DeprecatedDramaItemModel) item$iv$iv;
            destination$iv$iv.add(it.transform());
        }
        return new DramaGroupModel(j, str, (String) null, CollectionsKt.toMutableList((List) destination$iv$iv), 4, (DefaultConstructorMarker) null);
    }
}