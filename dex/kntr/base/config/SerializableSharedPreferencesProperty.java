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
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;

/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002Bs\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012>\b\u0002\u0010\f\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0017\u0012\u00150\u0011j\u0002`\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015B}\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012>\b\u0002\u0010\f\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0017\u0012\u00150\u0011j\u0002`\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0019J$\u0010\u001a\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0096\u0002¢\u0006\u0002\u0010\u001eJ,\u0010\u001f\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010!\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\f\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0017\u0012\u00150\u0011j\u0002`\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkntr/base/config/SerializableSharedPreferencesProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "sp", "Lkntr/base/config/SerializableSharedPreferences;", "serializer", "Lkotlinx/serialization/KSerializer;", "key", "", "initializer", "Lkotlin/Function0;", "repair", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "jsonString", "Ljava/lang/IllegalArgumentException;", "jsonDecodeException", "Lkotlin/IllegalArgumentException;", "<init>", "(Lkntr/base/config/SerializableSharedPreferences;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "spName", "multiProcess", "", "(Ljava/lang/String;ZLkotlinx/serialization/KSerializer;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "preferences_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SerializableSharedPreferencesProperty<T> implements ReadWriteProperty<Object, T> {
    private final Function0<T> initializer;
    private final String key;
    private final Function2<String, IllegalArgumentException, T> repair;
    private final KSerializer<T> serializer;
    private final SerializableSharedPreferences sp;

    /* JADX WARN: Multi-variable type inference failed */
    public SerializableSharedPreferencesProperty(SerializableSharedPreferences sp, KSerializer<T> kSerializer, String key, Function0<? extends T> function0, Function2<? super String, ? super IllegalArgumentException, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        this.sp = sp;
        this.serializer = kSerializer;
        this.key = key;
        this.initializer = function0;
        this.repair = function2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SerializableSharedPreferencesProperty(SerializableSharedPreferences serializableSharedPreferences, KSerializer kSerializer, String str, Function0 function0, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serializableSharedPreferences, kSerializer, str, function0, r5);
        Function2 function22;
        if ((i & 16) == 0) {
            function22 = function2;
        } else {
            function22 = null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SerializableSharedPreferencesProperty(String str, boolean z, KSerializer kSerializer, String str2, Function0 function0, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, kSerializer, str2, function0, r6);
        Function2 function22;
        if ((i & 32) == 0) {
            function22 = function2;
        } else {
            function22 = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializableSharedPreferencesProperty(String spName, boolean multiProcess, KSerializer<T> kSerializer, String key, Function0<? extends T> function0, Function2<? super String, ? super IllegalArgumentException, ? extends T> function2) {
        this(new SerializableSharedPreferences(spName, multiProcess), kSerializer, key, function0, function2);
        Intrinsics.checkNotNullParameter(spName, "spName");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "initializer");
    }

    public T getValue(Object thisRef, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return (T) this.sp.getValue(this.key, this.serializer, this.initializer, this.repair);
    }

    public void setValue(Object thisRef, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        this.sp.setValue(this.key, t, this.serializer);
    }

    public final Flow<T> asFlow() {
        final Flow $this$map$iv = this.sp.asFlow(this.key, Reflection.getOrCreateKotlinClass(String.class));
        return new Flow<T>() { // from class: kntr.base.config.SerializableSharedPreferencesProperty$asFlow$$inlined$map$1
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector, this), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.base.config.SerializableSharedPreferencesProperty$asFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ SerializableSharedPreferencesProperty this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.base.config.SerializableSharedPreferencesProperty$asFlow$$inlined$map$1$2", f = "KPreferences.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.base.config.SerializableSharedPreferencesProperty$asFlow$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, SerializableSharedPreferencesProperty serializableSharedPreferencesProperty) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = serializableSharedPreferencesProperty;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    SerializableSharedPreferences serializableSharedPreferences;
                    String str;
                    KSerializer<T> kSerializer;
                    Function0<? extends T> function0;
                    Function2<? super String, ? super IllegalArgumentException, ? extends T> function2;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    String str2 = (String) value;
                                    serializableSharedPreferences = this.this$0.sp;
                                    str = this.this$0.key;
                                    kSerializer = this.this$0.serializer;
                                    function0 = this.this$0.initializer;
                                    function2 = this.this$0.repair;
                                    Object value2 = serializableSharedPreferences.getValue(str, kSerializer, function0, function2);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(value2, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
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
    }
}