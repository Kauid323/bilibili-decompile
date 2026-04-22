package kntr.app.digital.preview.api;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: CardPreviewModel.kt */
@SerialName("smelt_guide")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lkntr/app/digital/preview/api/SmeltGuideModel;", "Lkntr/app/digital/preview/api/ModuleItem;", "data", "Lkntr/app/digital/preview/api/SmeltGuideModel$Data;", "<init>", "(Lkntr/app/digital/preview/api/SmeltGuideModel$Data;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/digital/preview/api/SmeltGuideModel$Data;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getData", "()Lkntr/app/digital/preview/api/SmeltGuideModel$Data;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Data", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SmeltGuideModel implements ModuleItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Data data;

    public static /* synthetic */ SmeltGuideModel copy$default(SmeltGuideModel smeltGuideModel, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            data = smeltGuideModel.data;
        }
        return smeltGuideModel.copy(data);
    }

    public final Data component1() {
        return this.data;
    }

    public final SmeltGuideModel copy(Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new SmeltGuideModel(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SmeltGuideModel) && Intrinsics.areEqual(this.data, ((SmeltGuideModel) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "SmeltGuideModel(data=" + this.data + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/SmeltGuideModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/SmeltGuideModel;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SmeltGuideModel> serializer() {
            return SmeltGuideModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SmeltGuideModel(int seen0, Data data, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, SmeltGuideModel$$serializer.INSTANCE.getDescriptor());
        }
        this.data = data;
    }

    public SmeltGuideModel(Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\"\u0012\u0019\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006¢\u0006\u0004\b\b\u0010\tB#\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u001c\u0010\u0013\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006HÆ\u0003J&\u0010\u0014\u001a\u00020\u00002\u001b\b\u0002\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R/\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lkntr/app/digital/preview/api/SmeltGuideModel$Data;", RoomRecommendViewModel.EMPTY_CURSOR, "holdingSmelt", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "<init>", "(Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHoldingSmelt$annotations", "()V", "getHoldingSmelt", "()Z", "component1", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Data {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final boolean holdingSmelt;

        public static /* synthetic */ Data copy$default(Data data, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = data.holdingSmelt;
            }
            return data.copy(z);
        }

        @SerialName("holding_smelt")
        public static /* synthetic */ void getHoldingSmelt$annotations() {
        }

        public final boolean component1() {
            return this.holdingSmelt;
        }

        public final Data copy(boolean z) {
            return new Data(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && this.holdingSmelt == ((Data) obj).holdingSmelt;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.holdingSmelt);
        }

        public String toString() {
            return "Data(holdingSmelt=" + this.holdingSmelt + ")";
        }

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/SmeltGuideModel$Data$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/SmeltGuideModel$Data;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return SmeltGuideModel$Data$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Data(int seen0, boolean holdingSmelt, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (seen0 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 1, SmeltGuideModel$Data$$serializer.INSTANCE.getDescriptor());
            }
            this.holdingSmelt = holdingSmelt;
        }

        public Data(boolean holdingSmelt) {
            this.holdingSmelt = holdingSmelt;
        }

        public final boolean getHoldingSmelt() {
            return this.holdingSmelt;
        }
    }

    public final Data getData() {
        return this.data;
    }
}