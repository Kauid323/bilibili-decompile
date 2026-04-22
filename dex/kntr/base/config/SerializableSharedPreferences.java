package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;

/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e¢\u0006\u0002\u0010\u000fJu\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00112>\b\u0002\u0010\u0012\u001a8\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0017\u0012\u00150\u0017j\u0002`\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0013¢\u0006\u0002\u0010\u001aJ/\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u0002H\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e¢\u0006\u0002\u0010\u001dJ,\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u001f\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/base/config/SerializableSharedPreferences;", "Lkntr/base/config/SharedPreferences;", "spName", "", "multiProcess", "", "<init>", "(Ljava/lang/String;Z)V", "stringType", "Lkotlin/reflect/KClass;", "getValue", "T", "key", "serializer", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;)Ljava/lang/Object;", "initializer", "Lkotlin/Function0;", "repair", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "jsonString", "Ljava/lang/IllegalArgumentException;", "jsonDecodeException", "Lkotlin/IllegalArgumentException;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "setValue", "value", "(Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)Ljava/lang/String;", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "preferences_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SerializableSharedPreferences extends SharedPreferences {
    private final KClass<String> stringType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializableSharedPreferences(String spName, boolean multiProcess) {
        super(spName, multiProcess);
        Intrinsics.checkNotNullParameter(spName, "spName");
        this.stringType = Reflection.getOrCreateKotlinClass(String.class);
    }

    public /* synthetic */ SerializableSharedPreferences(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final <T> T getValue(String key, KSerializer<T> kSerializer) throws SerializationException, IllegalArgumentException {
        Json json;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Object obj = KPreferences.get$default(getSp$preferences_debug(), key, this.stringType, null, 4, null);
        if (obj != null) {
            String it = (String) obj;
            json = KPreferencesKt.json;
            return (T) json.decodeFromString((DeserializationStrategy) kSerializer, it);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ Object getValue$default(SerializableSharedPreferences serializableSharedPreferences, String str, KSerializer kSerializer, Function0 function0, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        return serializableSharedPreferences.getValue(str, kSerializer, function0, function2);
    }

    public final <T> T getValue(String key, KSerializer<T> kSerializer, Function0<? extends T> function0, Function2<? super String, ? super IllegalArgumentException, ? extends T> function2) {
        Object invoke;
        T t;
        Json json;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        String it = (String) KPreferences.get$default(getSp$preferences_debug(), key, this.stringType, null, 4, null);
        if (it != null) {
            try {
                json = KPreferencesKt.json;
                t = (T) json.decodeFromString((DeserializationStrategy) kSerializer, it);
            } catch (IllegalArgumentException e) {
                if (function2 == null || (invoke = function2.invoke(it, e)) == null) {
                    invoke = function0.invoke();
                }
                t = (T) invoke;
            }
            if (t != null) {
                return t;
            }
        }
        return (T) function0.invoke();
    }

    public final <T> String setValue(String key, T t, KSerializer<T> kSerializer) {
        Json json;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        json = KPreferencesKt.json;
        String it = json.encodeToString((SerializationStrategy) kSerializer, t);
        getSp$preferences_debug().set(key, it, this.stringType);
        return it;
    }

    public final <T> Flow<T> asFlow(String key, final KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        final Flow $this$map$iv = asFlow(key, this.stringType);
        return new Flow<T>() { // from class: kntr.base.config.SerializableSharedPreferences$asFlow$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, kSerializer), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.base.config.SerializableSharedPreferences$asFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ KSerializer $serializer$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.base.config.SerializableSharedPreferences$asFlow$$inlined$map$1$2", f = "KPreferences.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.base.config.SerializableSharedPreferences$asFlow$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, KSerializer kSerializer) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$serializer$inlined = kSerializer;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    AnonymousClass1 anonymousClass1;
                    AnonymousClass1 anonymousClass12;
                    Object obj;
                    Json json;
                    if ($completion instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) $completion;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            anonymousClass12 = anonymousClass1;
                            Object $result = anonymousClass12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    Continuation continuation = (Continuation) anonymousClass12;
                                    String it = (String) value;
                                    if (it != null) {
                                        try {
                                            json = KPreferencesKt.json;
                                            obj = json.decodeFromString(this.$serializer$inlined, it);
                                        } catch (Exception e) {
                                            obj = null;
                                        }
                                    } else {
                                        obj = null;
                                    }
                                    anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                                    anonymousClass12.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    anonymousClass12.I$0 = 0;
                                    anonymousClass12.label = 1;
                                    if ($this$map_u24lambda_u245.emit(obj, anonymousClass12) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = anonymousClass12.I$0;
                                    FlowCollector flowCollector = (FlowCollector) anonymousClass12.L$3;
                                    Object obj2 = anonymousClass12.L$2;
                                    AnonymousClass1 anonymousClass13 = (AnonymousClass1) anonymousClass12.L$1;
                                    Object obj3 = anonymousClass12.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1($completion);
                    anonymousClass12 = anonymousClass1;
                    Object $result2 = anonymousClass12.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass12.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }
}