package kntr.app.ad.domain.inspector.core.work;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\u000bBo\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\n\u0010\u0011J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060(H\u0002J\u001b\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010*\u001a\u00020 H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020 H\u0016J\u001d\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00062\u0006\u0010*\u001a\u00020 H\u0000¢\u0006\u0002\b1J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003JS\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\rHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0001¢\u0006\u0002\bDR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u000e\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u001b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006G"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/Pipeline;", "Lkntr/app/ad/domain/inspector/core/work/IPipeline;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "preparationJobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/IJob;", "drawingJobs", "impressionJobs", "interactingJobs", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "name", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getPreparationJobs", "()Ljava/util/List;", "getDrawingJobs", "getImpressionJobs", "getInteractingJobs", "getName", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "()V", "stages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/model/StageType;", "Lkntr/app/ad/domain/inspector/core/work/Stage;", "getStages$annotations", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "getAllJobs", RoomRecommendViewModel.EMPTY_CURSOR, "getJobsByType", "type", "getJobsByType$inspector_debug", "getStage", "Lkntr/app/ad/domain/inspector/core/work/IStage;", "addJobToStage", RoomRecommendViewModel.EMPTY_CURSOR, "job", "addJobToStage$inspector_debug", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "$serializer", "Companion", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Pipeline implements IPipeline {
    private final CoroutineScope coroutineScope;
    private final List<IJob> drawingJobs;
    private final String id;
    private final List<IJob> impressionJobs;
    private final List<IJob> interactingJobs;
    private final String name;
    private final List<IJob> preparationJobs;
    private final Map<StageType, Stage> stages;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.Pipeline$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = Pipeline._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.Pipeline$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = Pipeline._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.Pipeline$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = Pipeline._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.Pipeline$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = Pipeline._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), null};

    /* compiled from: Pipeline.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StageType.values().length];
            try {
                iArr[StageType.PREPARATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[StageType.DRAWING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[StageType.IMPRESSION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[StageType.INTERACTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ Pipeline copy$default(Pipeline pipeline, String str, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pipeline.id;
        }
        List<IJob> list5 = list;
        if ((i & 2) != 0) {
            list5 = pipeline.preparationJobs;
        }
        List list6 = list5;
        List<IJob> list7 = list2;
        if ((i & 4) != 0) {
            list7 = pipeline.drawingJobs;
        }
        List list8 = list7;
        List<IJob> list9 = list3;
        if ((i & 8) != 0) {
            list9 = pipeline.impressionJobs;
        }
        List list10 = list9;
        List<IJob> list11 = list4;
        if ((i & 16) != 0) {
            list11 = pipeline.interactingJobs;
        }
        return pipeline.copy(str, list6, list8, list10, list11);
    }

    @Transient
    private static /* synthetic */ void getCoroutineScope$annotations() {
    }

    @Transient
    private static /* synthetic */ void getStages$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final List<IJob> component2() {
        return this.preparationJobs;
    }

    public final List<IJob> component3() {
        return this.drawingJobs;
    }

    public final List<IJob> component4() {
        return this.impressionJobs;
    }

    public final List<IJob> component5() {
        return this.interactingJobs;
    }

    public final Pipeline copy(String str, List<IJob> list, List<IJob> list2, List<IJob> list3, List<IJob> list4) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(list, "preparationJobs");
        Intrinsics.checkNotNullParameter(list2, "drawingJobs");
        Intrinsics.checkNotNullParameter(list3, "impressionJobs");
        Intrinsics.checkNotNullParameter(list4, "interactingJobs");
        return new Pipeline(str, list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pipeline) {
            Pipeline pipeline = (Pipeline) obj;
            return Intrinsics.areEqual(this.id, pipeline.id) && Intrinsics.areEqual(this.preparationJobs, pipeline.preparationJobs) && Intrinsics.areEqual(this.drawingJobs, pipeline.drawingJobs) && Intrinsics.areEqual(this.impressionJobs, pipeline.impressionJobs) && Intrinsics.areEqual(this.interactingJobs, pipeline.interactingJobs);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.preparationJobs.hashCode()) * 31) + this.drawingJobs.hashCode()) * 31) + this.impressionJobs.hashCode()) * 31) + this.interactingJobs.hashCode();
    }

    public String toString() {
        String str = this.id;
        List<IJob> list = this.preparationJobs;
        List<IJob> list2 = this.drawingJobs;
        List<IJob> list3 = this.impressionJobs;
        return "Pipeline(id=" + str + ", preparationJobs=" + list + ", drawingJobs=" + list2 + ", impressionJobs=" + list3 + ", interactingJobs=" + this.interactingJobs + ")";
    }

    /* compiled from: Pipeline.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/Pipeline$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/inspector/core/work/Pipeline;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Pipeline> serializer() {
            return Pipeline$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Pipeline(int seen0, String id, List preparationJobs, List drawingJobs, List impressionJobs, List interactingJobs, String name, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, Pipeline$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        if ((seen0 & 2) == 0) {
            this.preparationJobs = new ArrayList();
        } else {
            this.preparationJobs = preparationJobs;
        }
        if ((seen0 & 4) == 0) {
            this.drawingJobs = new ArrayList();
        } else {
            this.drawingJobs = drawingJobs;
        }
        if ((seen0 & 8) == 0) {
            this.impressionJobs = new ArrayList();
        } else {
            this.impressionJobs = impressionJobs;
        }
        if ((seen0 & 16) == 0) {
            this.interactingJobs = new ArrayList();
        } else {
            this.interactingJobs = interactingJobs;
        }
        if ((seen0 & 32) == 0) {
            this.name = "Pipeline_" + getId();
        } else {
            this.name = name;
        }
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
        this.stages = new LinkedHashMap();
    }

    public Pipeline(String id, List<IJob> list, List<IJob> list2, List<IJob> list3, List<IJob> list4) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(list, "preparationJobs");
        Intrinsics.checkNotNullParameter(list2, "drawingJobs");
        Intrinsics.checkNotNullParameter(list3, "impressionJobs");
        Intrinsics.checkNotNullParameter(list4, "interactingJobs");
        this.id = id;
        this.preparationJobs = list;
        this.drawingJobs = list2;
        this.impressionJobs = list3;
        this.interactingJobs = list4;
        this.name = "Pipeline_" + getId();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
        this.stages = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IJob.class), new Annotation[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IJob.class), new Annotation[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IJob.class), new Annotation[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IJob.class), new Annotation[0]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d6, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7.getName(), "Pipeline_" + r7.getId()) == false) goto L23;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void write$Self$inspector_debug(Pipeline self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        boolean z = false;
        output.encodeStringElement(serialDesc, 0, self.getId());
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.preparationJobs, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.preparationJobs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.drawingJobs, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.drawingJobs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.impressionJobs, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.impressionJobs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.interactingJobs, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.interactingJobs);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5)) {
        }
        z = true;
        if (z) {
            output.encodeStringElement(serialDesc, 5, self.getName());
        }
    }

    public /* synthetic */ Pipeline(String str, List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new ArrayList() : list2, (i & 8) != 0 ? new ArrayList() : list3, (i & 16) != 0 ? new ArrayList() : list4);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IPipeline
    public String getId() {
        return this.id;
    }

    public final List<IJob> getPreparationJobs() {
        return this.preparationJobs;
    }

    public final List<IJob> getDrawingJobs() {
        return this.drawingJobs;
    }

    public final List<IJob> getImpressionJobs() {
        return this.impressionJobs;
    }

    public final List<IJob> getInteractingJobs() {
        return this.interactingJobs;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IPipeline
    public String getName() {
        return this.name;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IPipeline
    public Status getStatus() {
        Iterable $this$any$iv;
        IJob it;
        Iterable $this$any$iv2;
        IJob it2;
        IJob it3;
        List allJobs = getAllJobs();
        if (allJobs.isEmpty()) {
            return Status.PENDING;
        }
        List $this$any$iv3 = allJobs;
        boolean z = true;
        if (!($this$any$iv3 instanceof Collection) || !$this$any$iv3.isEmpty()) {
            Iterator<T> it4 = $this$any$iv3.iterator();
            while (true) {
                if (it4.hasNext()) {
                    Object element$iv = it4.next();
                    IJob it5 = (IJob) element$iv;
                    if (it5.getData().getStatus() == Status.FAILED) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        $this$any$iv = 1;
                        break;
                    }
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
        } else {
            $this$any$iv = null;
        }
        if ($this$any$iv != null) {
            return Status.FAILED;
        }
        List $this$any$iv4 = allJobs;
        if (!($this$any$iv4 instanceof Collection) || !$this$any$iv4.isEmpty()) {
            Iterator<T> it6 = $this$any$iv4.iterator();
            while (true) {
                if (it6.hasNext()) {
                    Object element$iv2 = it6.next();
                    IJob it7 = (IJob) element$iv2;
                    if (it7.getData().getStatus() == Status.RUNNING) {
                        it2 = 1;
                        continue;
                    } else {
                        it2 = null;
                        continue;
                    }
                    if (it2 != null) {
                        $this$any$iv2 = 1;
                        break;
                    }
                } else {
                    $this$any$iv2 = null;
                    break;
                }
            }
        } else {
            $this$any$iv2 = null;
        }
        if ($this$any$iv2 != null) {
            return Status.RUNNING;
        }
        List $this$all$iv = allJobs;
        if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
            Iterator<T> it8 = $this$all$iv.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    break;
                }
                Object element$iv3 = it8.next();
                IJob it9 = (IJob) element$iv3;
                if (it9.getData().getStatus() == Status.SUCCESS) {
                    it3 = 1;
                    continue;
                } else {
                    it3 = null;
                    continue;
                }
                if (it3 == null) {
                    z = false;
                    break;
                }
            }
        }
        return z ? Status.SUCCESS : Status.PENDING;
    }

    private final List<IJob> getAllJobs() {
        return CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(this.preparationJobs, this.drawingJobs), this.impressionJobs), this.interactingJobs);
    }

    public final List<IJob> getJobsByType$inspector_debug(StageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return this.preparationJobs;
            case 2:
                return this.drawingJobs;
            case 3:
                return this.impressionJobs;
            case 4:
                return this.interactingJobs;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IPipeline
    public IStage getStage(StageType type) {
        Stage stage;
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$getOrPut$iv = this.stages;
        Stage stage2 = $this$getOrPut$iv.get(type);
        if (stage2 == null) {
            stage = new Stage(this, type);
            $this$getOrPut$iv.put(type, stage);
        } else {
            stage = stage2;
        }
        return stage;
    }

    public final void addJobToStage$inspector_debug(IJob job, StageType type) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(type, "type");
        List jobs = getJobsByType$inspector_debug(type);
        jobs.add(job);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Pipeline$addJobToStage$1(job, this, null), 3, (Object) null);
    }
}