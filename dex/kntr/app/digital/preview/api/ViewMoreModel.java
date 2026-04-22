package kntr.app.digital.preview.api;

import BottomSheetItemData$;
import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CardPreviewModel.kt */
@SerialName("view_more")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lkntr/app/digital/preview/api/ViewMoreModel;", "Lkntr/app/digital/preview/api/ModuleItem;", "data", "Lkntr/app/digital/preview/api/ViewMoreModel$Data;", "<init>", "(Lkntr/app/digital/preview/api/ViewMoreModel$Data;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/digital/preview/api/ViewMoreModel$Data;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getData", "()Lkntr/app/digital/preview/api/ViewMoreModel$Data;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Data", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ViewMoreModel implements ModuleItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Data data;

    public static /* synthetic */ ViewMoreModel copy$default(ViewMoreModel viewMoreModel, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            data = viewMoreModel.data;
        }
        return viewMoreModel.copy(data);
    }

    public final Data component1() {
        return this.data;
    }

    public final ViewMoreModel copy(Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ViewMoreModel(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ViewMoreModel) && Intrinsics.areEqual(this.data, ((ViewMoreModel) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "ViewMoreModel(data=" + this.data + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/ViewMoreModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/ViewMoreModel;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ViewMoreModel> serializer() {
            return ViewMoreModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ViewMoreModel(int seen0, Data data, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, ViewMoreModel$$serializer.INSTANCE.getDescriptor());
        }
        this.data = data;
    }

    public ViewMoreModel(Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B0\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b¢\u0006\u0004\b\n\u0010\u000bB-\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001c\u0010\u0019\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0003J2\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001b\b\u0002\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R/\u0010\u0004\u001a\u00150\u0005j\u0002`\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\t0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lkntr/app/digital/preview/api/ViewMoreModel$Data;", RoomRecommendViewModel.EMPTY_CURSOR, "blockChainLink", RoomRecommendViewModel.EMPTY_CURSOR, "canTransfer", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "<init>", "(Ljava/lang/String;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBlockChainLink$annotations", "()V", "getBlockChainLink", "()Ljava/lang/String;", "getCanTransfer$annotations", "getCanTransfer", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Data {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String blockChainLink;
        private final boolean canTransfer;

        public Data() {
            this((String) null, false, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Data copy$default(Data data, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.blockChainLink;
            }
            if ((i & 2) != 0) {
                z = data.canTransfer;
            }
            return data.copy(str, z);
        }

        @SerialName("block_chain_link")
        public static /* synthetic */ void getBlockChainLink$annotations() {
        }

        @SerialName("can_transfer")
        public static /* synthetic */ void getCanTransfer$annotations() {
        }

        public final String component1() {
            return this.blockChainLink;
        }

        public final boolean component2() {
            return this.canTransfer;
        }

        public final Data copy(String str, boolean z) {
            return new Data(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.blockChainLink, data.blockChainLink) && this.canTransfer == data.canTransfer;
            }
            return false;
        }

        public int hashCode() {
            return ((this.blockChainLink == null ? 0 : this.blockChainLink.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canTransfer);
        }

        public String toString() {
            String str = this.blockChainLink;
            return "Data(blockChainLink=" + str + ", canTransfer=" + this.canTransfer + ")";
        }

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/ViewMoreModel$Data$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/ViewMoreModel$Data;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return ViewMoreModel$Data$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Data(int seen0, String blockChainLink, boolean canTransfer, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.blockChainLink = null;
            } else {
                this.blockChainLink = blockChainLink;
            }
            if ((seen0 & 2) == 0) {
                this.canTransfer = false;
            } else {
                this.canTransfer = canTransfer;
            }
        }

        public Data(String blockChainLink, boolean canTransfer) {
            this.blockChainLink = blockChainLink;
            this.canTransfer = canTransfer;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$preview_debug(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.blockChainLink != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.blockChainLink);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.canTransfer) {
                output.encodeSerializableElement(serialDesc, 1, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.canTransfer));
            }
        }

        public /* synthetic */ Data(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z);
        }

        public final String getBlockChainLink() {
            return this.blockChainLink;
        }

        public final boolean getCanTransfer() {
            return this.canTransfer;
        }
    }

    public final Data getData() {
        return this.data;
    }
}