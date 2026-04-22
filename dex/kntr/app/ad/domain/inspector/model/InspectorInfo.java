package kntr.app.ad.domain.inspector.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.inspector.core.util.DateTimeUtils;
import kntr.app.ad.domain.inspector.core.work.Pipeline;
import kntr.app.ad.domain.inspector.core.work.Pipeline$$serializer;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: InspectorInfo.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tBS\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\b\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J'\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00065"}, d2 = {"Lkntr/app/ad/domain/inspector/model/InspectorInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "adSlot", "Lkntr/app/ad/common/model/AdSlot;", "adData", "Lkntr/app/ad/domain/inspector/model/AdData;", "dirty", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/ad/common/model/AdSlot;Lkntr/app/ad/domain/inspector/model/AdData;J)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "pipeline", "Lkntr/app/ad/domain/inspector/core/work/Pipeline;", "timestamp", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/ad/common/model/AdSlot;Lkntr/app/ad/domain/inspector/model/AdData;JLjava/lang/String;Lkntr/app/ad/domain/inspector/core/work/Pipeline;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdSlot", "()Lkntr/app/ad/common/model/AdSlot;", "getAdData", "()Lkntr/app/ad/domain/inspector/model/AdData;", "getDirty", "()J", "getId", "()Ljava/lang/String;", "value", "getPipeline", "()Lkntr/app/ad/domain/inspector/core/work/Pipeline;", "setPipeline$inspector_debug", "(Lkntr/app/ad/domain/inspector/core/work/Pipeline;)V", "getTimestamp", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "$serializer", "Companion", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class InspectorInfo {
    private final AdData adData;
    private final AdSlot adSlot;
    private final long dirty;
    private final String id;
    private Pipeline pipeline;
    private final long timestamp;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.model.InspectorInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = InspectorInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null};

    public static /* synthetic */ InspectorInfo copy$default(InspectorInfo inspectorInfo, AdSlot adSlot, AdData adData, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            adSlot = inspectorInfo.adSlot;
        }
        if ((i & 2) != 0) {
            adData = inspectorInfo.adData;
        }
        if ((i & 4) != 0) {
            j2 = inspectorInfo.dirty;
        }
        return inspectorInfo.copy(adSlot, adData, j2);
    }

    public final AdSlot component1() {
        return this.adSlot;
    }

    public final AdData component2() {
        return this.adData;
    }

    public final long component3() {
        return this.dirty;
    }

    public final InspectorInfo copy(AdSlot adSlot, AdData adData, long j2) {
        Intrinsics.checkNotNullParameter(adSlot, "adSlot");
        Intrinsics.checkNotNullParameter(adData, "adData");
        return new InspectorInfo(adSlot, adData, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InspectorInfo) {
            InspectorInfo inspectorInfo = (InspectorInfo) obj;
            return this.adSlot == inspectorInfo.adSlot && Intrinsics.areEqual(this.adData, inspectorInfo.adData) && this.dirty == inspectorInfo.dirty;
        }
        return false;
    }

    public int hashCode() {
        return (((this.adSlot.hashCode() * 31) + this.adData.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.dirty);
    }

    public String toString() {
        AdSlot adSlot = this.adSlot;
        AdData adData = this.adData;
        return "InspectorInfo(adSlot=" + adSlot + ", adData=" + adData + ", dirty=" + this.dirty + ")";
    }

    /* compiled from: InspectorInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/inspector/model/InspectorInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<InspectorInfo> serializer() {
            return InspectorInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ InspectorInfo(int seen0, AdSlot adSlot, AdData adData, long dirty, String id, Pipeline pipeline, long timestamp, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, InspectorInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.adSlot = adSlot;
        this.adData = adData;
        if ((seen0 & 4) == 0) {
            this.dirty = 0L;
        } else {
            this.dirty = dirty;
        }
        if ((seen0 & 8) == 0) {
            this.id = this.adData.getAdcb();
        } else {
            this.id = id;
        }
        if ((seen0 & 16) == 0) {
            this.pipeline = new Pipeline(this.id, null, null, null, null, 30, null);
        } else {
            this.pipeline = pipeline;
        }
        if ((seen0 & 32) == 0) {
            this.timestamp = DateTimeUtils.INSTANCE.currentTimeMillis();
        } else {
            this.timestamp = timestamp;
        }
    }

    public InspectorInfo(AdSlot adSlot, AdData adData, long dirty) {
        Intrinsics.checkNotNullParameter(adSlot, "adSlot");
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.adSlot = adSlot;
        this.adData = adData;
        this.dirty = dirty;
        this.id = this.adData.getAdcb();
        this.pipeline = new Pipeline(this.id, null, null, null, null, 30, null);
        this.timestamp = DateTimeUtils.INSTANCE.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("kntr.app.ad.common.model.AdSlot", AdSlot.values());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$inspector_debug(InspectorInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.adSlot);
        output.encodeSerializableElement(serialDesc, 1, AdData$$serializer.INSTANCE, self.adData);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.dirty != 0) {
            output.encodeLongElement(serialDesc, 2, self.dirty);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.id, self.adData.getAdcb())) {
            output.encodeStringElement(serialDesc, 3, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.pipeline, new Pipeline(self.id, null, null, null, null, 30, null))) {
            output.encodeSerializableElement(serialDesc, 4, Pipeline$$serializer.INSTANCE, self.pipeline);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.timestamp != DateTimeUtils.INSTANCE.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 5, self.timestamp);
        }
    }

    public /* synthetic */ InspectorInfo(AdSlot adSlot, AdData adData, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adSlot, adData, (i & 4) != 0 ? 0L : j2);
    }

    public final AdSlot getAdSlot() {
        return this.adSlot;
    }

    public final AdData getAdData() {
        return this.adData;
    }

    public final long getDirty() {
        return this.dirty;
    }

    public final String getId() {
        return this.id;
    }

    public final Pipeline getPipeline() {
        return this.pipeline;
    }

    public final void setPipeline$inspector_debug(Pipeline pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, "<set-?>");
        this.pipeline = pipeline;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}