package kntr.base.dd.impl.internal.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.IDeviceDecisionUpdater;
import kntr.base.dd.IDeviceDecisionUtils;
import kntr.base.dd.impl.IDDConstArgs;
import kntr.base.dd.impl.IDDContainer;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kntr.base.dd.impl.internal.common.UtilsKt;
import kntr.base.dd.impl.internal.data.CoreDataType;
import kntr.base.dd.impl.internal.data.DataCenter;
import kntr.base.dd.impl.internal.data.ICoreData;
import kntr.base.dd.impl.internal.debugger.DDDebugger;
import kntr.base.dd.impl.internal.decide.DecisionCenter;
import kntr.base.dd.impl.internal.decide.IDDResult;
import kntr.base.dd.impl.internal.decide.IDecisionCenter;
import kntr.base.dd.impl.internal.file.DDFileSystem;
import kntr.base.dd.impl.internal.model.DDNode;
import kntr.base.dd.impl.internal.model.RemoteMockModel;
import kntr.base.dd.impl.internal.property.PropertyCenter;
import kntr.base.dd.impl.internal.update.UpdateEngine;
import kntr.base.dd.internal.IDeviceDecisionDebugger;
import kntr.base.dd.internal.IDeviceDecisionDefault;
import kntr.base.utils.CoroutineExKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DDContainer.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0016J\u0006\u0010\"\u001a\u00020#J?\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u0006\u0010&\u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H%0(2\b\u0010)\u001a\u0004\u0018\u0001H%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0002\u0010,JE\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H%0\u001f\"\u0004\b\u0000\u0010%2\u0006\u0010&\u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H%0(2\b\u0010)\u001a\u0004\u0018\u0001H%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0002\u0010.J,\u0010/\u001a\u000600j\u0002`12\u0006\u00102\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u000104H\u0096@¢\u0006\u0002\u00105J$\u00106\u001a\u000600j\u0002`12\u0006\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u000104H\u0096@¢\u0006\u0002\u00107J*\u00108\u001a\u000600j\u0002`12\u0006\u0010\u001c\u001a\u00020!2\u000e\u00103\u001a\n\u0018\u000104j\u0004\u0018\u0001`9H\u0096@¢\u0006\u0002\u00107J\u001c\u0010/\u001a\u000600j\u0002`12\u0006\u00102\u001a\u00020!2\u0006\u0010:\u001a\u00020!H\u0016J\u0018\u0010;\u001a\u00020#2\u0006\u00102\u001a\u00020!2\u0006\u00103\u001a\u000204H\u0016J\u0016\u0010<\u001a\u00020!2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0016J\b\u0010@\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lkntr/base/dd/impl/internal/container/DDContainer;", "Lkntr/base/dd/impl/IDDContainer;", "args", "Lkntr/base/dd/impl/IDDConstArgs;", "defaultConfig", "Lkntr/base/dd/internal/IDeviceDecisionDefault;", "<init>", "(Lkntr/base/dd/impl/IDDConstArgs;Lkntr/base/dd/internal/IDeviceDecisionDefault;)V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "canPerformUpdate", "", "fs", "Lkntr/base/dd/impl/internal/file/DDFileSystem;", "dataCenter", "Lkntr/base/dd/impl/internal/data/DataCenter;", "propertyCenter", "Lkntr/base/dd/impl/internal/property/PropertyCenter;", "decisionCenter", "Lkntr/base/dd/impl/internal/decide/DecisionCenter;", "updateEngine", "Lkntr/base/dd/impl/internal/update/UpdateEngine;", "debugger", "Lkntr/base/dd/impl/internal/debugger/DDDebugger;", "getProperty", "Lkntr/base/dd/IDeviceDecisionProperty;", "getDebugger", "Lkntr/base/dd/internal/IDeviceDecisionDebugger;", AppKey.VERSION, "Lkntr/base/dd/IDeviceDecision$Version;", "versions", "Lkotlinx/coroutines/flow/Flow;", "keys", "", "start", "", "get", "T", "key", "serializer", "Lkotlinx/serialization/KSerializer;", "defaultValue", "context", "Lkntr/base/dd/IDeviceDecision$Context;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;Ljava/lang/Object;Lkntr/base/dd/IDeviceDecision$Context;)Ljava/lang/Object;", "asFlow", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;Ljava/lang/Object;Lkntr/base/dd/IDeviceDecision$Context;)Lkotlinx/coroutines/flow/Flow;", "update", "Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "Lkntr/base/dd/impl/internal/container/UpdateResult;", "from", "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateToLatest", "(Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fallback", "Lkntr/base/dd/impl/internal/common/DDEnv;", "remoteData", "changeEnv", "dumpAsJson", "components", "", "Lkntr/base/dd/IDeviceDecisionUtils$DumpComponent;", "observeDefaultConfigKey", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDContainer implements IDDContainer {
    private final boolean canPerformUpdate;
    private final DataCenter dataCenter;
    private final DDDebugger debugger;
    private final DecisionCenter decisionCenter;
    private final IDeviceDecisionDefault defaultConfig;
    private final DDFileSystem fs;
    private final CoroutineScope ioScope;
    private final PropertyCenter propertyCenter;
    private final UpdateEngine updateEngine;

    public DDContainer(IDDConstArgs args, IDeviceDecisionDefault defaultConfig) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(defaultConfig, "defaultConfig");
        this.defaultConfig = defaultConfig;
        this.ioScope = CoroutineExKt.createIOScope();
        this.canPerformUpdate = args.canPerformUpdate();
        this.fs = new DDFileSystem(args.getCacheDirectory());
        this.dataCenter = new DataCenter(new DataCenter.PresetData(args.getPresetData(), args.getPresetVersion()), args.appEnvProvider(), null, 4, null);
        this.propertyCenter = new PropertyCenter(CollectionsKt.toSet(DDContainerKt.access$getObservableNames(args, this.defaultConfig)), args.getDefaultProps(), this.dataCenter, null, 8, null);
        this.decisionCenter = new DecisionCenter(this.dataCenter, this.propertyCenter, null, 4, null);
        this.updateEngine = new UpdateEngine(DDContainerKt.access$getHost(args, this.defaultConfig), args.getAppKey(), this.fs, this.dataCenter, this.canPerformUpdate);
        this.debugger = new DDDebugger(this.dataCenter, this.propertyCenter);
    }

    @Override // kntr.base.dd.impl.IDDContainer
    public IDeviceDecisionProperty getProperty() {
        return this.propertyCenter;
    }

    @Override // kntr.base.dd.impl.IDDContainer
    public IDeviceDecisionDebugger getDebugger() {
        return this.debugger;
    }

    @Override // kntr.base.dd.IDeviceDecision
    public IDeviceDecision.Version version() {
        return new IDeviceDecision.Version(this.dataCenter.getEnv(), String.valueOf(this.dataCenter.currentData().getVersion()));
    }

    @Override // kntr.base.dd.IDeviceDecision
    public Flow<IDeviceDecision.Version> versions() {
        return this.dataCenter.getFlow().getVersions();
    }

    @Override // kntr.base.dd.IDeviceDecision
    public Flow<String> keys() {
        return this.decisionCenter.getKeys();
    }

    public final void start() {
        if (this.canPerformUpdate) {
            BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new DDContainer$start$1(this, null), 3, (Object) null);
            observeDefaultConfigKey();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    @Override // kntr.base.dd.IDeviceDecision
    public <T> T get(String key, KSerializer<T> kSerializer, T t, IDeviceDecision.Context context) {
        T t2;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        IDDResult result = this.decisionCenter.decide(key, context);
        T t3 = (T) false;
        if (Intrinsics.areEqual(kSerializer, BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE))) {
            ?? r3 = t3;
            if (t instanceof Boolean) {
                r3 = (T) ((Boolean) t);
            }
            return (T) Boolean.valueOf(DDContainerKt.access$toBoolean(result, r3 != 0 ? r3.booleanValue() : true));
        }
        Boolean hit = result.getHit();
        if (hit != null) {
            if (Intrinsics.areEqual(hit, false)) {
                return null;
            }
            if (!Intrinsics.areEqual(hit, true)) {
                throw new NoWhenBranchMatchedException();
            }
            String value = result.getValue();
            if (value != null) {
                if (Intrinsics.areEqual(kSerializer, BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE))) {
                    t2 = value;
                } else if (Intrinsics.areEqual(kSerializer, BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE))) {
                    Integer intOrNull = StringsKt.toIntOrNull(value);
                    t2 = t3;
                    if (intOrNull != null) {
                        int it = intOrNull.intValue();
                        t2 = Integer.valueOf(it);
                    }
                } else if (Intrinsics.areEqual(kSerializer, BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE))) {
                    Long longOrNull = StringsKt.toLongOrNull(value);
                    t2 = t3;
                    if (longOrNull != null) {
                        long it2 = longOrNull.longValue();
                        t2 = Long.valueOf(it2);
                    }
                } else if (Intrinsics.areEqual(kSerializer, BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE))) {
                    Float floatOrNull = StringsKt.toFloatOrNull(value);
                    t2 = t3;
                    if (floatOrNull != null) {
                        float it3 = floatOrNull.floatValue();
                        t2 = Float.valueOf(it3);
                    }
                } else if (Intrinsics.areEqual(kSerializer, BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE))) {
                    Double doubleOrNull = StringsKt.toDoubleOrNull(value);
                    t2 = t3;
                    if (doubleOrNull != null) {
                        double it4 = doubleOrNull.doubleValue();
                        t2 = Double.valueOf(it4);
                    }
                } else {
                    try {
                        Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.dd.impl.internal.container.DDContainer$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit unit;
                                unit = DDContainer.get$lambda$0$4((JsonBuilder) obj);
                                return unit;
                            }
                        }, 1, (Object) null);
                        t2 = (T) json.decodeFromString((DeserializationStrategy) kSerializer, value);
                    } catch (Exception e) {
                        DDConst.logE$default(DDConst.INSTANCE, "Failed to decode key: \"" + key + "\" using serializer: " + Reflection.getOrCreateKotlinClass(kSerializer.getClass()).getSimpleName() + ". Error: " + e.getMessage(), null, 2, null);
                        t2 = t3;
                    }
                }
                if (t2 != null) {
                    return t2;
                }
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit get$lambda$0$4(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }

    @Override // kntr.base.dd.IDeviceDecision
    public <T> Flow<T> asFlow(final String key, final KSerializer<T> kSerializer, final T t, final IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        final Flow $this$filter$iv = this.decisionCenter.getKeys();
        final Flow $this$map$iv = new Flow<String>() { // from class: kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$filter$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, key), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$filter$1$2", f = "DDContainer.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$key$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    String it = (String) value;
                                    if (!StringsKt.contains$default(it, this.$key$inlined, false, 2, (Object) null)) {
                                        break;
                                    } else {
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        return FlowKt.onStart(new Flow<T>() { // from class: kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, this, key, kSerializer, t, context), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ IDeviceDecision.Context $context$inlined;
                final /* synthetic */ Object $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ KSerializer $serializer$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DDContainer this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$map$1$2", f = "DDContainer.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.base.dd.impl.internal.container.DDContainer$asFlow$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DDContainer dDContainer, String str, KSerializer kSerializer, Object obj, IDeviceDecision.Context context) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = dDContainer;
                    this.$key$inlined = str;
                    this.$serializer$inlined = kSerializer;
                    this.$defaultValue$inlined = obj;
                    this.$context$inlined = context;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) $completion;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            $continuation = anonymousClass1;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    String str = (String) value;
                                    Object obj = this.this$0.get(this.$key$inlined, this.$serializer$inlined, this.$defaultValue$inlined, this.$context$inlined);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(obj, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj2 = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj3 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        }, new DDContainer$asFlow$3(this, key, kSerializer, t, context, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    @Override // kntr.base.dd.IDeviceDecisionUpdater
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object update(String from, String version, IDeviceDecision.Version.Env env, Continuation<? super IDeviceDecisionUpdater.Result> continuation) {
        Continuation<? super Result<Unit>> dDContainer$update$1;
        Object mo1365updateyxL6bBk;
        if (continuation instanceof DDContainer$update$1) {
            dDContainer$update$1 = (DDContainer$update$1) continuation;
            if ((dDContainer$update$1.label & Integer.MIN_VALUE) != 0) {
                dDContainer$update$1.label -= Integer.MIN_VALUE;
                Object $result = dDContainer$update$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dDContainer$update$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        UpdateEngine updateEngine = this.updateEngine;
                        IDeviceDecision.Version.Env env2 = env == null ? this.dataCenter.getEnv() : env;
                        dDContainer$update$1.L$0 = SpillingKt.nullOutSpilledVariable(from);
                        dDContainer$update$1.L$1 = SpillingKt.nullOutSpilledVariable(version);
                        dDContainer$update$1.L$2 = SpillingKt.nullOutSpilledVariable(env);
                        dDContainer$update$1.label = 1;
                        mo1365updateyxL6bBk = updateEngine.mo1365updateyxL6bBk(from, version, env2, false, dDContainer$update$1);
                        if (mo1365updateyxL6bBk == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        IDeviceDecision.Version.Env env3 = (IDeviceDecision.Version.Env) dDContainer$update$1.L$2;
                        String str = (String) dDContainer$update$1.L$1;
                        String str2 = (String) dDContainer$update$1.L$0;
                        ResultKt.throwOnFailure($result);
                        mo1365updateyxL6bBk = ((Result) $result).m2645unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return DDContainerKt.asUpdaterResult(mo1365updateyxL6bBk);
            }
        }
        dDContainer$update$1 = new DDContainer$update$1(this, continuation);
        Object $result2 = dDContainer$update$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dDContainer$update$1.label) {
        }
        return DDContainerKt.asUpdaterResult(mo1365updateyxL6bBk);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    @Override // kntr.base.dd.IDeviceDecisionUpdater
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateToLatest(String from, IDeviceDecision.Version.Env env, Continuation<? super IDeviceDecisionUpdater.Result> continuation) {
        Continuation<? super Result<Unit>> dDContainer$updateToLatest$1;
        Object mo1365updateyxL6bBk;
        if (continuation instanceof DDContainer$updateToLatest$1) {
            dDContainer$updateToLatest$1 = (DDContainer$updateToLatest$1) continuation;
            if ((dDContainer$updateToLatest$1.label & Integer.MIN_VALUE) != 0) {
                dDContainer$updateToLatest$1.label -= Integer.MIN_VALUE;
                Object $result = dDContainer$updateToLatest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dDContainer$updateToLatest$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (StringsKt.isBlank(from)) {
                            return new IDeviceDecisionUpdater.Result.Error("`from` is require params.");
                        }
                        UpdateEngine updateEngine = this.updateEngine;
                        IDeviceDecision.Version.Env env2 = env == null ? this.dataCenter.getEnv() : env;
                        dDContainer$updateToLatest$1.L$0 = SpillingKt.nullOutSpilledVariable(from);
                        dDContainer$updateToLatest$1.L$1 = SpillingKt.nullOutSpilledVariable(env);
                        dDContainer$updateToLatest$1.label = 1;
                        mo1365updateyxL6bBk = updateEngine.mo1365updateyxL6bBk(from, "", env2, true, dDContainer$updateToLatest$1);
                        if (mo1365updateyxL6bBk == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        IDeviceDecision.Version.Env env3 = (IDeviceDecision.Version.Env) dDContainer$updateToLatest$1.L$1;
                        String str = (String) dDContainer$updateToLatest$1.L$0;
                        ResultKt.throwOnFailure($result);
                        mo1365updateyxL6bBk = ((Result) $result).m2645unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return DDContainerKt.asUpdaterResult(mo1365updateyxL6bBk);
            }
        }
        dDContainer$updateToLatest$1 = new DDContainer$updateToLatest$1(this, continuation);
        Object $result2 = dDContainer$updateToLatest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dDContainer$updateToLatest$1.label) {
        }
        return DDContainerKt.asUpdaterResult(mo1365updateyxL6bBk);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    @Override // kntr.base.dd.IDeviceDecisionUpdater
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fallback(String version, IDeviceDecision.Version.Env env, Continuation<? super IDeviceDecisionUpdater.Result> continuation) {
        DDContainer$fallback$1 dDContainer$fallback$1;
        Object obj;
        if (continuation instanceof DDContainer$fallback$1) {
            dDContainer$fallback$1 = (DDContainer$fallback$1) continuation;
            if ((dDContainer$fallback$1.label & Integer.MIN_VALUE) != 0) {
                dDContainer$fallback$1.label -= Integer.MIN_VALUE;
                Object $result = dDContainer$fallback$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dDContainer$fallback$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        UpdateEngine updateEngine = this.updateEngine;
                        IDeviceDecision.Version.Env env2 = env == null ? this.dataCenter.getEnv() : env;
                        dDContainer$fallback$1.L$0 = SpillingKt.nullOutSpilledVariable(version);
                        dDContainer$fallback$1.L$1 = SpillingKt.nullOutSpilledVariable(env);
                        dDContainer$fallback$1.label = 1;
                        Object mo1364fallback0E7RQCE = updateEngine.mo1364fallback0E7RQCE(version, env2, dDContainer$fallback$1);
                        if (mo1364fallback0E7RQCE == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = mo1364fallback0E7RQCE;
                        break;
                    case 1:
                        IDeviceDecision.Version.Env env3 = (IDeviceDecision.Version.Env) dDContainer$fallback$1.L$1;
                        String str = (String) dDContainer$fallback$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).m2645unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return DDContainerKt.asUpdaterResult(obj);
            }
        }
        dDContainer$fallback$1 = new DDContainer$fallback$1(this, continuation);
        Object $result2 = dDContainer$fallback$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dDContainer$fallback$1.label) {
        }
        return DDContainerKt.asUpdaterResult(obj);
    }

    @Override // kntr.base.dd.IDeviceDecisionUpdater
    public IDeviceDecisionUpdater.Result update(String from, String remoteData) {
        Long version;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        if (StringsKt.isBlank(from)) {
            return DDContainerKt.createUpdateError("`from` is require params.");
        }
        Utils.Companion companion = Utils.Companion;
        Object obj = null;
        try {
            Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
            json$iv.getSerializersModule();
            obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(RemoteMockModel.Companion.serializer()), remoteData);
        } catch (Exception e$iv) {
            DDConst dDConst = DDConst.INSTANCE;
            String message = e$iv.getMessage();
            if (message == null) {
                message = "undefined";
            }
            DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
        }
        RemoteMockModel model = (RemoteMockModel) obj;
        if (model == null) {
            return DDContainerKt.createUpdateError("remote data is invalid.");
        }
        long currentTimestamp = UtilsKt.currentTimestamp();
        String validTime = model.getValidTime();
        long j = 60;
        long expiredTime = currentTimestamp + (((validTime == null || (longOrNull = StringsKt.toLongOrNull(validTime)) == null) ? 24L : longOrNull.longValue()) * j * j * 1000);
        ICoreData mockData = this.dataCenter.dataWithType(CoreDataType.MOCK);
        DDNode node = mockData.node(model.getName());
        long ver = ((node == null || (version = node.getVersion()) == null) ? mockData.getVersion() : version.longValue()) + 1;
        mockData.updateWithNode(new DDNode(model.getName(), (String) null, (DDNode) null, (DDNode) null, model.getValue(), (String) null, (String) null, (String) null, Long.valueOf(ver), String.valueOf(expiredTime), 238, (DefaultConstructorMarker) null));
        DDConst.INSTANCE.logI("update(" + from + ", " + remoteData + ") success.");
        return IDeviceDecisionUpdater.Result.Success.INSTANCE;
    }

    @Override // kntr.base.dd.IDeviceDecisionUtils
    public void changeEnv(String from, IDeviceDecision.Version.Env env) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(env, "env");
        DDConst.INSTANCE.logI(from + " change env to " + env.getValue() + ".");
        this.dataCenter.changeEnv(env);
    }

    @Override // kntr.base.dd.IDeviceDecisionUtils
    public String dumpAsJson(List<? extends IDeviceDecisionUtils.DumpComponent> list) {
        Json json;
        String str;
        DDContainer dDContainer = this;
        Intrinsics.checkNotNullParameter(list, "components");
        if (list.isEmpty()) {
            return "{}";
        }
        Map map = new LinkedHashMap();
        char c = 0;
        IDeviceDecision.Context context = null;
        if (list.contains(IDeviceDecisionUtils.DumpComponent.Properties)) {
            Iterable $this$map$iv = dDContainer.propertyCenter.getAllPropNames();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                Pair[] pairArr = new Pair[2];
                pairArr[c] = TuplesKt.to("n", it);
                String str2 = IDeviceDecisionProperty.CC.get$default(dDContainer.propertyCenter, it, null, 2, null);
                if (str2 == null) {
                    str2 = "";
                }
                pairArr[1] = TuplesKt.to("v", str2);
                destination$iv$iv.add(MapsKt.mapOf(pairArr));
                c = 0;
            }
            map.put("p", (List) destination$iv$iv);
        }
        if (list.contains(IDeviceDecisionUtils.DumpComponent.Values)) {
            Iterable $this$map$iv2 = dDContainer.dataCenter.currentData().nodeKeys();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                String it2 = (String) item$iv$iv2;
                Iterable $this$map$iv3 = $this$map$iv2;
                IDDResult result = IDecisionCenter.CC.decide$default(dDContainer.decisionCenter, it2, context, 2, context);
                String value = (Intrinsics.areEqual(result.getHit(), true) && result.getValue() == null) ? "true" : result.getValue();
                Pair[] pairArr2 = new Pair[2];
                pairArr2[0] = TuplesKt.to("n", it2);
                pairArr2[1] = TuplesKt.to("v", value == null ? "" : value);
                destination$iv$iv2.add(MapsKt.mapOf(pairArr2));
                $this$map$iv2 = $this$map$iv3;
                context = null;
                dDContainer = this;
            }
            map.put("v", (List) destination$iv$iv2);
        }
        Utils.Companion companion = Utils.Companion;
        Json json$iv = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.dd.impl.internal.container.DDContainer$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit dumpAsJson$lambda$2;
                dumpAsJson$lambda$2 = DDContainer.dumpAsJson$lambda$2((JsonBuilder) obj);
                return dumpAsJson$lambda$2;
            }
        }, 1, (Object) null);
        if (json$iv == null) {
            try {
                json = Json.Default;
            } catch (Exception e$iv) {
                DDConst dDConst = DDConst.INSTANCE;
                String message = e$iv.getMessage();
                if (message == null) {
                    message = "undefined";
                }
                DDConst.logE$default(dDConst, "encodeToString error ," + message, null, 2, null);
                str = null;
            }
        } else {
            json = json$iv;
        }
        StringFormat $this$encodeToString$iv$iv = (StringFormat) json;
        $this$encodeToString$iv$iv.getSerializersModule();
        str = $this$encodeToString$iv$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE))), map);
        return str == null ? "{}" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dumpAsJson$lambda$2(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setPrettyPrint(true);
        $this$Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    private final void observeDefaultConfigKey() {
        BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new DDContainer$observeDefaultConfigKey$1(this, null), 3, (Object) null);
    }
}