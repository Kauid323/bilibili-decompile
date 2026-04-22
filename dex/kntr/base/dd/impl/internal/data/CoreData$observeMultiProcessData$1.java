package kntr.base.dd.impl.internal.data;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kntr.base.dd.impl.internal.model.DDModel;
import kntr.base.dd.impl.internal.model.DDModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoreData.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.data.CoreData$observeMultiProcessData$1", f = "CoreData.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CoreData$observeMultiProcessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoreData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreData$observeMultiProcessData$1(CoreData coreData, Continuation<? super CoreData$observeMultiProcessData$1> continuation) {
        super(2, continuation);
        this.this$0 = coreData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreData$observeMultiProcessData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SharedPreferences sharedPreferences;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                sharedPreferences = this.this$0.sp;
                str = this.this$0.kSaveCacheKey;
                final Flow $this$filter$iv = sharedPreferences.asStringFlow(str);
                final CoreData coreData = this.this$0;
                final CoreData coreData2 = this.this$0;
                this.label = 1;
                if (new Flow<String>() { // from class: kntr.base.dd.impl.internal.data.CoreData$observeMultiProcessData$1$invokeSuspend$$inlined$filter$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector, coreData), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* renamed from: kntr.base.dd.impl.internal.data.CoreData$observeMultiProcessData$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ CoreData this$0;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.base.dd.impl.internal.data.CoreData$observeMultiProcessData$1$invokeSuspend$$inlined$filter$1$2", f = "CoreData.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.base.dd.impl.internal.data.CoreData$observeMultiProcessData$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, CoreData coreData) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = coreData;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                        /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
                        /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            boolean z;
                            boolean z2;
                            String str;
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
                                            String value2 = (String) value;
                                            String str2 = value2;
                                            if (!(str2 == null || StringsKt.isBlank(str2))) {
                                                List parts = StringsKt.split$default(value2, new String[]{":"}, false, 2, 2, (Object) null);
                                                if (parts.size() == 2) {
                                                    Object obj = parts.get(0);
                                                    str = this.this$0.processName;
                                                    if (!Intrinsics.areEqual(obj, str)) {
                                                        Long longOrNull = StringsKt.toLongOrNull((String) parts.get(1));
                                                        if ((longOrNull != null ? longOrNull.longValue() : 0L) > 0) {
                                                            z2 = true;
                                                            if (z2) {
                                                                z = true;
                                                                if (!z) {
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
                                                                } else {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                z2 = false;
                                                if (z2) {
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                            }
                                            break;
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
                }.collect(new FlowCollector() { // from class: kntr.base.dd.impl.internal.data.CoreData$observeMultiProcessData$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
                        if (r6 != false) goto L13;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(String it, Continuation<? super Unit> continuation) {
                        SharedPreferences sharedPreferences2;
                        String str2;
                        SharedPreferences sharedPreferences3;
                        String str3;
                        boolean z;
                        boolean z2;
                        Long longOrNull;
                        long currentV = CoreData.this.getVersion();
                        sharedPreferences2 = CoreData.this.sp;
                        str2 = CoreData.this.kVersionCacheKey;
                        String string$default = SharedPreferences.getString$default(sharedPreferences2, str2, null, 2, null);
                        long newV = (string$default == null || (longOrNull = StringsKt.toLongOrNull(string$default)) == null) ? 0L : longOrNull.longValue();
                        if (newV == currentV) {
                            z2 = CoreData.this.isMock;
                        }
                        sharedPreferences3 = CoreData.this.sp;
                        str3 = CoreData.this.kDataCacheKey;
                        DDModel model = DDModelKt.decodeStringToDDModel(SharedPreferences.getString$default(sharedPreferences3, str3, null, 2, null));
                        if (model != null) {
                            CoreData coreData3 = CoreData.this;
                            z = coreData3.isMock;
                            CoreData.update$default(coreData3, model, false, false, !z && newV < currentV, 4, null);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}