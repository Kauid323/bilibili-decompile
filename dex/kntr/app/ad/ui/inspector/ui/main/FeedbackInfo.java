package kntr.app.ad.ui.inspector.ui.main;

import java.util.List;
import java.util.Map;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.inspector.core.serializer.StageTypeSerializer;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeedbackScreen.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 *2\u00020\u0001:\u0002)*B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t0\u0007¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t0\u0007HÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\rHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/FeedbackInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "adSlot", "Lkntr/app/ad/common/model/AdSlot;", "adRaw", "Lkotlinx/serialization/json/JsonElement;", "jobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/model/StageType;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/ad/common/model/AdSlot;Lkotlinx/serialization/json/JsonElement;Ljava/util/Map;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/ad/common/model/AdSlot;Lkotlinx/serialization/json/JsonElement;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdSlot", "()Lkntr/app/ad/common/model/AdSlot;", "getAdRaw", "()Lkotlinx/serialization/json/JsonElement;", "getJobs", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$ad_inspector_debug", "$serializer", "Companion", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class FeedbackInfo {
    private final JsonElement adRaw;
    private final AdSlot adSlot;
    private final Map<StageType, List<JsonElement>> jobs;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = FeedbackInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackInfo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = FeedbackInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackInfo copy$default(FeedbackInfo feedbackInfo, AdSlot adSlot, JsonElement jsonElement, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            adSlot = feedbackInfo.adSlot;
        }
        if ((i & 2) != 0) {
            jsonElement = feedbackInfo.adRaw;
        }
        if ((i & 4) != 0) {
            map = feedbackInfo.jobs;
        }
        return feedbackInfo.copy(adSlot, jsonElement, map);
    }

    public final AdSlot component1() {
        return this.adSlot;
    }

    public final JsonElement component2() {
        return this.adRaw;
    }

    public final Map<StageType, List<JsonElement>> component3() {
        return this.jobs;
    }

    public final FeedbackInfo copy(AdSlot adSlot, JsonElement jsonElement, Map<StageType, ? extends List<? extends JsonElement>> map) {
        Intrinsics.checkNotNullParameter(adSlot, "adSlot");
        Intrinsics.checkNotNullParameter(map, "jobs");
        return new FeedbackInfo(adSlot, jsonElement, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FeedbackInfo) {
            FeedbackInfo feedbackInfo = (FeedbackInfo) obj;
            return this.adSlot == feedbackInfo.adSlot && Intrinsics.areEqual(this.adRaw, feedbackInfo.adRaw) && Intrinsics.areEqual(this.jobs, feedbackInfo.jobs);
        }
        return false;
    }

    public int hashCode() {
        return (((this.adSlot.hashCode() * 31) + (this.adRaw == null ? 0 : this.adRaw.hashCode())) * 31) + this.jobs.hashCode();
    }

    public String toString() {
        AdSlot adSlot = this.adSlot;
        JsonElement jsonElement = this.adRaw;
        return "FeedbackInfo(adSlot=" + adSlot + ", adRaw=" + jsonElement + ", jobs=" + this.jobs + ")";
    }

    /* compiled from: FeedbackScreen.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/FeedbackInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/ui/inspector/ui/main/FeedbackInfo;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FeedbackInfo> serializer() {
            return FeedbackInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FeedbackInfo(int seen0, AdSlot adSlot, JsonElement adRaw, Map jobs, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, FeedbackInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.adSlot = adSlot;
        this.adRaw = adRaw;
        if ((seen0 & 4) == 0) {
            this.jobs = MapsKt.emptyMap();
        } else {
            this.jobs = jobs;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackInfo(AdSlot adSlot, JsonElement adRaw, Map<StageType, ? extends List<? extends JsonElement>> map) {
        Intrinsics.checkNotNullParameter(adSlot, "adSlot");
        Intrinsics.checkNotNullParameter(map, "jobs");
        this.adSlot = adSlot;
        this.adRaw = adRaw;
        this.jobs = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("kntr.app.ad.common.model.AdSlot", AdSlot.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new LinkedHashMapSerializer(StageTypeSerializer.INSTANCE, new ArrayListSerializer(BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$ad_inspector_debug(FeedbackInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.adSlot);
        output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.adRaw);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.jobs, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.jobs);
        }
    }

    public /* synthetic */ FeedbackInfo(AdSlot adSlot, JsonElement jsonElement, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adSlot, jsonElement, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final AdSlot getAdSlot() {
        return this.adSlot;
    }

    public final JsonElement getAdRaw() {
        return this.adRaw;
    }

    public final Map<StageType, List<JsonElement>> getJobs() {
        return this.jobs;
    }
}