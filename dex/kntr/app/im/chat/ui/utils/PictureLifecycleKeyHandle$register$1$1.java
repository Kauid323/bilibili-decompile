package kntr.app.im.chat.ui.utils;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureLifecycleKeyHandle.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1", f = "PictureLifecycleKeyHandle.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureLifecycleKeyHandle$register$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    int label;
    final /* synthetic */ PictureLifecycleKeyHandle this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureLifecycleKeyHandle$register$1$1(LifecycleOwner lifecycleOwner, PictureLifecycleKeyHandle pictureLifecycleKeyHandle, Continuation<? super PictureLifecycleKeyHandle$register$1$1> continuation) {
        super(2, continuation);
        this.$lifecycleOwner = lifecycleOwner;
        this.this$0 = pictureLifecycleKeyHandle;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureLifecycleKeyHandle$register$1$1(this.$lifecycleOwner, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PictureLifecycleKeyHandle pictureLifecycleKeyHandle = this.this$0;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PictureLifecycleKeyHandle$register$1$1.invokeSuspend$lambda$0(PictureLifecycleKeyHandle.this);
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                });
                final Flow $this$map$iv = this.$lifecycleOwner.getLifecycle().getCurrentStateFlow();
                Flow flowCombine = FlowKt.flowCombine(snapshotFlow, new Flow<Boolean>() { // from class: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$invokeSuspend$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$invokeSuspend$$inlined$map$1$2", f = "PictureLifecycleKeyHandle.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
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

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
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
                                            FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Boolean boxBoolean = Boxing.boxBoolean(it.isAtLeast(Lifecycle.State.RESUMED));
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$map_u24lambda_u245.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 1:
                                            int i = $continuation.I$0;
                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                            Object obj = $continuation.L$2;
                                            AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                            Object value2 = $continuation.L$0;
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

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, new AnonymousClass3(null));
                final PictureLifecycleKeyHandle pictureLifecycleKeyHandle2 = this.this$0;
                this.label = 1;
                if (flowCombine.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1.4
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                        MutableState mutableState;
                        mutableState = PictureLifecycleKeyHandle.this.innerState;
                        mutableState.setValue(Boxing.boxBoolean(it));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(PictureLifecycleKeyHandle this$0) {
        MutableState mutableState;
        mutableState = this$0.pageState;
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PictureLifecycleKeyHandle.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "a", "b"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$3", f = "PictureLifecycleKeyHandle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$1$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        /* synthetic */ boolean Z$1;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
        }

        public final Object invoke(boolean z, boolean z2, Continuation<? super Boolean> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.Z$0 = z;
            anonymousClass3.Z$1 = z2;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            boolean a = this.Z$0;
            boolean b = this.Z$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    return Boxing.boxBoolean(a && b);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}