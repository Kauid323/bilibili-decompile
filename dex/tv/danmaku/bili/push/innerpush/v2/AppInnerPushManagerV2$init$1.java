package tv.danmaku.bili.push.innerpush.v2;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.module.state.PlayState;
import com.bilibili.module.state.PlayStateUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$init$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AppInnerPushManagerV2$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$init$1(AppInnerPushManagerV2 appInnerPushManagerV2, Continuation<? super AppInnerPushManagerV2$init$1> continuation) {
        super(2, continuation);
        this.this$0 = appInnerPushManagerV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$init$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow stateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PlayStateUpdater playStateUpdater = (PlayStateUpdater) BLRouter.get$default(BLRouter.INSTANCE, PlayStateUpdater.class, (String) null, 2, (Object) null);
                if (playStateUpdater != null && (stateFlow = playStateUpdater.getStateFlow()) != null) {
                    final Flow $this$filter$iv = stateFlow;
                    Flow debounce = FlowKt.debounce(new Flow<PlayState>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$init$1$invokeSuspend$$inlined$filter$1
                        public Object collect(FlowCollector collector, Continuation $completion) {
                            Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }

                        /* compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        /* renamed from: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$init$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                            @DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$init$1$invokeSuspend$$inlined$filter$1$2", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                            /* renamed from: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$init$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                Object L$0;
                                Object L$1;
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
                            /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
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
                                                PlayState it = (PlayState) value;
                                                PlayState it2 = !Intrinsics.areEqual(it, PlayState.INVALID.INSTANCE) ? 1 : null;
                                                if (it2 != null) {
                                                    $continuation.label = 1;
                                                    if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                        break;
                                                    } else {
                                                        return coroutine_suspended;
                                                    }
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
                                $continuation = new AnonymousClass1($completion);
                                Object $result2 = $continuation.result;
                                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, 1000L);
                    if (debounce != null) {
                        final AppInnerPushManagerV2 appInnerPushManagerV2 = this.this$0;
                        this.label = 1;
                        if (debounce.collect(new FlowCollector() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$init$1.2
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((PlayState) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(PlayState info, Continuation<? super Unit> continuation) {
                                BLog.i("[InnerPush]AppInnerPushManagerV2", "AppInnerPushManagerV2 play state changed: " + info);
                                AppInnerPushManagerV2.this.onPlayStateChange(info);
                                return Unit.INSTANCE;
                            }
                        }, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
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