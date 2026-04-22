package kntr.base.neuron.internal.model.pb;

import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.internal.model.pb.KAppExposureInfo;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0011\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppExposureInfo;", "", "contentInfos", "", "Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContentInfos$annotations", "()V", "getContentInfos", "()Ljava/util/List;", "contentInfosArray", "", "()[Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "KAppExposureContentInfo", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class KAppExposureInfo {
    public static final String targetPath = "/AppExposureInfo";
    private final List<KAppExposureContentInfo> contentInfos;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KAppExposureInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = KAppExposureInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public KAppExposureInfo() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KAppExposureInfo copy$default(KAppExposureInfo kAppExposureInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = kAppExposureInfo.contentInfos;
        }
        return kAppExposureInfo.copy(list);
    }

    @SerialName("contentInfos")
    @ProtoNumber(number = 1)
    @ProtoPacked
    public static /* synthetic */ void getContentInfos$annotations() {
    }

    public final List<KAppExposureContentInfo> component1() {
        return this.contentInfos;
    }

    public final KAppExposureInfo copy(List<KAppExposureContentInfo> list) {
        Intrinsics.checkNotNullParameter(list, "contentInfos");
        return new KAppExposureInfo(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KAppExposureInfo) && Intrinsics.areEqual(this.contentInfos, ((KAppExposureInfo) obj).contentInfos);
    }

    public int hashCode() {
        return this.contentInfos.hashCode();
    }

    public String toString() {
        return "KAppExposureInfo(contentInfos=" + this.contentInfos + ")";
    }

    public /* synthetic */ KAppExposureInfo(int seen0, List contentInfos, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.contentInfos = CollectionsKt.emptyList();
        } else {
            this.contentInfos = contentInfos;
        }
    }

    public KAppExposureInfo(List<KAppExposureContentInfo> list) {
        Intrinsics.checkNotNullParameter(list, "contentInfos");
        this.contentInfos = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(KAppExposureInfo$KAppExposureContentInfo$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$neuron_debug(KAppExposureInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.contentInfos, CollectionsKt.emptyList())) {
            z = false;
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.contentInfos);
        }
    }

    public /* synthetic */ KAppExposureInfo(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<KAppExposureContentInfo> getContentInfos() {
        return this.contentInfos;
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppExposureInfo;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<KAppExposureInfo> serializer() {
            return KAppExposureInfo$$serializer.INSTANCE;
        }
    }

    public final KAppExposureContentInfo[] contentInfosArray() {
        Collection $this$toTypedArray$iv = this.contentInfos;
        return (KAppExposureContentInfo[]) $this$toTypedArray$iv.toArray(new KAppExposureContentInfo[0]);
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0003()*B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0011\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo;", "", "eventId", "", "extendedFields", "", "Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEventId$annotations", "()V", "getEventId", "()Ljava/lang/String;", "getExtendedFields$annotations", "getExtendedFields", "()Ljava/util/List;", "extendedFieldsArray", "", "()[Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "KExtendedFieldsEntry", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class KAppExposureContentInfo {
        public static final String targetPath = "/AppExposureInfo.AppExposureContentInfo";
        private final String eventId;
        private final List<KExtendedFieldsEntry> extendedFields;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KAppExposureInfo$KAppExposureContentInfo$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = KAppExposureInfo.KAppExposureContentInfo._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public KAppExposureContentInfo() {
            this((String) null, (List) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ KAppExposureContentInfo copy$default(KAppExposureContentInfo kAppExposureContentInfo, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = kAppExposureContentInfo.eventId;
            }
            if ((i & 2) != 0) {
                list = kAppExposureContentInfo.extendedFields;
            }
            return kAppExposureContentInfo.copy(str, list);
        }

        @SerialName("eventId")
        @ProtoNumber(number = 1)
        public static /* synthetic */ void getEventId$annotations() {
        }

        @SerialName("extendedFields")
        @ProtoNumber(number = 2)
        @ProtoPacked
        public static /* synthetic */ void getExtendedFields$annotations() {
        }

        public final String component1() {
            return this.eventId;
        }

        public final List<KExtendedFieldsEntry> component2() {
            return this.extendedFields;
        }

        public final KAppExposureContentInfo copy(String str, List<KExtendedFieldsEntry> list) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Intrinsics.checkNotNullParameter(list, "extendedFields");
            return new KAppExposureContentInfo(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KAppExposureContentInfo) {
                KAppExposureContentInfo kAppExposureContentInfo = (KAppExposureContentInfo) obj;
                return Intrinsics.areEqual(this.eventId, kAppExposureContentInfo.eventId) && Intrinsics.areEqual(this.extendedFields, kAppExposureContentInfo.extendedFields);
            }
            return false;
        }

        public int hashCode() {
            return (this.eventId.hashCode() * 31) + this.extendedFields.hashCode();
        }

        public String toString() {
            String str = this.eventId;
            return "KAppExposureContentInfo(eventId=" + str + ", extendedFields=" + this.extendedFields + ")";
        }

        public /* synthetic */ KAppExposureContentInfo(int seen0, String eventId, List extendedFields, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.eventId = "";
            } else {
                this.eventId = eventId;
            }
            if ((seen0 & 2) == 0) {
                this.extendedFields = CollectionsKt.emptyList();
            } else {
                this.extendedFields = extendedFields;
            }
        }

        public KAppExposureContentInfo(String eventId, List<KExtendedFieldsEntry> list) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(list, "extendedFields");
            this.eventId = eventId;
            this.extendedFields = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$neuron_debug(KAppExposureContentInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.eventId, "")) {
                output.encodeStringElement(serialDesc, 0, self.eventId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.extendedFields, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.extendedFields);
            }
        }

        public /* synthetic */ KAppExposureContentInfo(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final List<KExtendedFieldsEntry> getExtendedFields() {
            return this.extendedFields;
        }

        /* compiled from: info_raw.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<KAppExposureContentInfo> serializer() {
                return KAppExposureInfo$KAppExposureContentInfo$$serializer.INSTANCE;
            }
        }

        public final KExtendedFieldsEntry[] extendedFieldsArray() {
            Collection $this$toTypedArray$iv = this.extendedFields;
            return (KExtendedFieldsEntry[]) $this$toTypedArray$iv.toArray(new KExtendedFieldsEntry[0]);
        }

        /* compiled from: info_raw.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry;", "", "key", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getKey", "()Ljava/lang/String;", "getValue$annotations", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class KExtendedFieldsEntry {
            public static final Companion Companion = new Companion(null);
            public static final String targetPath = "/AppExposureInfo.AppExposureContentInfo.ExtendedFieldsEntry";
            private final String key;
            private final String value;

            public KExtendedFieldsEntry() {
                this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ KExtendedFieldsEntry copy$default(KExtendedFieldsEntry kExtendedFieldsEntry, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = kExtendedFieldsEntry.key;
                }
                if ((i & 2) != 0) {
                    str2 = kExtendedFieldsEntry.value;
                }
                return kExtendedFieldsEntry.copy(str, str2);
            }

            @SerialName("key")
            @ProtoNumber(number = 1)
            public static /* synthetic */ void getKey$annotations() {
            }

            @SerialName("value")
            @ProtoNumber(number = 2)
            public static /* synthetic */ void getValue$annotations() {
            }

            public final String component1() {
                return this.key;
            }

            public final String component2() {
                return this.value;
            }

            public final KExtendedFieldsEntry copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(str2, "value");
                return new KExtendedFieldsEntry(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof KExtendedFieldsEntry) {
                    KExtendedFieldsEntry kExtendedFieldsEntry = (KExtendedFieldsEntry) obj;
                    return Intrinsics.areEqual(this.key, kExtendedFieldsEntry.key) && Intrinsics.areEqual(this.value, kExtendedFieldsEntry.value);
                }
                return false;
            }

            public int hashCode() {
                return (this.key.hashCode() * 31) + this.value.hashCode();
            }

            public String toString() {
                String str = this.key;
                return "KExtendedFieldsEntry(key=" + str + ", value=" + this.value + ")";
            }

            public /* synthetic */ KExtendedFieldsEntry(int seen0, String key, String value, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.key = "";
                } else {
                    this.key = key;
                }
                if ((seen0 & 2) == 0) {
                    this.value = "";
                } else {
                    this.value = value;
                }
            }

            public KExtendedFieldsEntry(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                this.key = key;
                this.value = value;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$neuron_debug(KExtendedFieldsEntry self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.key, "")) {
                    output.encodeStringElement(serialDesc, 0, self.key);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.value, "")) {
                    output.encodeStringElement(serialDesc, 1, self.value);
                }
            }

            public /* synthetic */ KExtendedFieldsEntry(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
            }

            public final String getKey() {
                return this.key;
            }

            public final String getValue() {
                return this.value;
            }

            /* compiled from: info_raw.kt */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<KExtendedFieldsEntry> serializer() {
                    return KAppExposureInfo$KAppExposureContentInfo$KExtendedFieldsEntry$$serializer.INSTANCE;
                }
            }
        }
    }
}