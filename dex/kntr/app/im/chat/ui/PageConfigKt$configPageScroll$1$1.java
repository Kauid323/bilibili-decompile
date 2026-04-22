package kntr.app.im.chat.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import im.base.IMLog;
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
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1", f = "PageConfig.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageConfigKt$configPageScroll$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageConfigKt$configPageScroll$1$1(LazyListState lazyListState, Continuation<? super PageConfigKt$configPageScroll$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageConfigKt$configPageScroll$1$1(this.$listState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final Flow $this$filter$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyListState lazyListState = this.$listState;
                $this$filter$iv = PageConfigKt.comparing(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        ListScrollingHolder invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PageConfigKt$configPageScroll$1$1.invokeSuspend$lambda$0(lazyListState);
                        return invokeSuspend$lambda$0;
                    }
                })), new AnonymousClass2(null));
                this.label = 1;
                if (new Flow<Boolean>() { // from class: kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$invokeSuspend$$inlined$filter$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$invokeSuspend$$inlined$filter$1$2", f = "PageConfig.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass1 = $continuation;
                                            boolean it = ((Boolean) value).booleanValue();
                                            if (it) {
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
                                            break;
                                        case 1:
                                            int i = $continuation.I$0;
                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                            Object obj = $continuation.L$2;
                                            AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
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
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }.collect(new AnonymousClass4(this.$listState), (Continuation) this) == coroutine_suspended) {
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
    public static final ListScrollingHolder invokeSuspend$lambda$0(LazyListState $listState) {
        return new ListScrollingHolder($listState.getCanScrollBackward(), $listState.isScrollInProgress());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageConfig.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "last", "Lkntr/app/im/chat/ui/ListScrollingHolder;", "next"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$2", f = "PageConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<ListScrollingHolder, ListScrollingHolder, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(ListScrollingHolder listScrollingHolder, ListScrollingHolder listScrollingHolder2, Continuation<? super Boolean> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = listScrollingHolder;
            anonymousClass2.L$1 = listScrollingHolder2;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ListScrollingHolder last = (ListScrollingHolder) this.L$0;
            ListScrollingHolder next = (ListScrollingHolder) this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IMLog.Companion.d("ChatViewModelWrapper", "Last list scroll state " + last + ", next " + next);
                    return Boxing.boxBoolean((last.isScrollInProgress() || next.isScrollInProgress() || last.getCanScrollBackward() || !next.getCanScrollBackward()) ? false : true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageConfig.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass4<T> implements FlowCollector {
        final /* synthetic */ LazyListState $listState;

        AnonymousClass4(LazyListState lazyListState) {
            this.$listState = lazyListState;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit(((Boolean) value).booleanValue(), $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006a A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(boolean it, Continuation<? super Unit> continuation) {
            PageConfigKt$configPageScroll$1$1$4$emit$1 pageConfigKt$configPageScroll$1$1$4$emit$1;
            LazyListState lazyListState;
            if (continuation instanceof PageConfigKt$configPageScroll$1$1$4$emit$1) {
                pageConfigKt$configPageScroll$1$1$4$emit$1 = (PageConfigKt$configPageScroll$1$1$4$emit$1) continuation;
                if ((pageConfigKt$configPageScroll$1$1$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                    pageConfigKt$configPageScroll$1$1$4$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = pageConfigKt$configPageScroll$1$1$4$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (pageConfigKt$configPageScroll$1$1$4$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Duration.Companion companion = Duration.Companion;
                            long duration = DurationKt.toDuration(30, DurationUnit.MILLISECONDS);
                            pageConfigKt$configPageScroll$1$1$4$emit$1.Z$0 = it;
                            pageConfigKt$configPageScroll$1$1$4$emit$1.label = 1;
                            if (DelayKt.delay-VtjQ1oo(duration, pageConfigKt$configPageScroll$1$1$4$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            IMLog.Companion.d("ChatViewModelWrapper", "Scroll to bottom");
                            lazyListState = this.$listState;
                            pageConfigKt$configPageScroll$1$1$4$emit$1.Z$0 = it;
                            pageConfigKt$configPageScroll$1$1$4$emit$1.label = 2;
                            if (lazyListState.scrollToItem(0, 0, pageConfigKt$configPageScroll$1$1$4$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            it = pageConfigKt$configPageScroll$1$1$4$emit$1.Z$0;
                            ResultKt.throwOnFailure($result);
                            IMLog.Companion.d("ChatViewModelWrapper", "Scroll to bottom");
                            lazyListState = this.$listState;
                            pageConfigKt$configPageScroll$1$1$4$emit$1.Z$0 = it;
                            pageConfigKt$configPageScroll$1$1$4$emit$1.label = 2;
                            if (lazyListState.scrollToItem(0, 0, pageConfigKt$configPageScroll$1$1$4$emit$1) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                            boolean it2 = pageConfigKt$configPageScroll$1$1$4$emit$1.Z$0;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            pageConfigKt$configPageScroll$1$1$4$emit$1 = new PageConfigKt$configPageScroll$1$1$4$emit$1(this, continuation);
            Object $result2 = pageConfigKt$configPageScroll$1$1$4$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (pageConfigKt$configPageScroll$1$1$4$emit$1.label) {
            }
        }
    }
}