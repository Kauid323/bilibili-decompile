package video.biz.offline.base.infra.storage.diskfile.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DramaGroupModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "", "id", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "items", "", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getCover", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DramaGroupModel {
    private final String cover;
    private final long id;
    private List<DramaItemModel> items;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DramaGroupModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ DramaGroupModel copy$default(DramaGroupModel dramaGroupModel, long j, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dramaGroupModel.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = dramaGroupModel.title;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = dramaGroupModel.cover;
        }
        String str4 = str2;
        List<DramaItemModel> list2 = list;
        if ((i & 8) != 0) {
            list2 = dramaGroupModel.items;
        }
        return dramaGroupModel.copy(j2, str3, str4, list2);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.cover;
    }

    public final List<DramaItemModel> component4() {
        return this.items;
    }

    public final DramaGroupModel copy(long j, String str, String str2, List<DramaItemModel> list) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(str2, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(list, "items");
        return new DramaGroupModel(j, str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DramaGroupModel) {
            DramaGroupModel dramaGroupModel = (DramaGroupModel) obj;
            return this.id == dramaGroupModel.id && Intrinsics.areEqual(this.title, dramaGroupModel.title) && Intrinsics.areEqual(this.cover, dramaGroupModel.cover) && Intrinsics.areEqual(this.items, dramaGroupModel.items);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.title.hashCode()) * 31) + this.cover.hashCode()) * 31) + this.items.hashCode();
    }

    /* compiled from: DramaGroupModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DramaGroupModel> serializer() {
            return DramaGroupModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DramaGroupModel(int seen0, long id, String title, String cover, List items, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, DramaGroupModel$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.title = title;
        if ((seen0 & 4) == 0) {
            this.cover = "";
        } else {
            this.cover = cover;
        }
        if ((seen0 & 8) == 0) {
            this.items = new ArrayList();
        } else {
            this.items = items;
        }
    }

    public DramaGroupModel(long id, String title, String cover, List<DramaItemModel> list) {
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(cover, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(list, "items");
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.items = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DramaItemModel$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$infra_debug(DramaGroupModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.cover, "")) {
            output.encodeStringElement(serialDesc, 2, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.items, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.items);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DramaGroupModel(long j, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, r4, r5);
        String str3;
        ArrayList arrayList;
        if ((i & 4) == 0) {
            str3 = str2;
        } else {
            str3 = "";
        }
        if ((i & 8) == 0) {
            arrayList = list;
        } else {
            arrayList = new ArrayList();
        }
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCover() {
        return this.cover;
    }

    public final List<DramaItemModel> getItems() {
        return this.items;
    }

    public final void setItems(List<DramaItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public String toString() {
        long j = this.id;
        String str = this.title;
        String str2 = this.cover;
        return "DramaGroupModel(id=" + j + ", title='" + str + "', cover='" + str2 + "' count=" + this.items.size() + ")";
    }
}