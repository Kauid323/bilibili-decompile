package tv.danmaku.bili.ui.garb;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
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
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionRoomFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2", f = "CollectionRoomFragment.kt", i = {}, l = {BR.onNegativeClick}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CollectionRoomFragment$initNoticeBar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $vmid;
    int label;
    final /* synthetic */ CollectionRoomFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionRoomFragment$initNoticeBar$2(CollectionRoomFragment collectionRoomFragment, long j, Continuation<? super CollectionRoomFragment$initNoticeBar$2> continuation) {
        super(2, continuation);
        this.this$0 = collectionRoomFragment;
        this.$vmid = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionRoomFragment$initNoticeBar$2(this.this$0, this.$vmid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectionRoomFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ long $vmid;
        final /* synthetic */ CollectionRoomFragment this$0;

        AnonymousClass2(CollectionRoomFragment collectionRoomFragment, long j) {
            this.this$0 = collectionRoomFragment;
            this.$vmid = j;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Lifecycle.Event event, Continuation<? super Unit> continuation) {
            CollectionRoomFragment$initNoticeBar$2$2$emit$1 collectionRoomFragment$initNoticeBar$2$2$emit$1;
            boolean z;
            Object refreshNoticeBar;
            AnonymousClass2 anonymousClass2;
            if (continuation instanceof CollectionRoomFragment$initNoticeBar$2$2$emit$1) {
                collectionRoomFragment$initNoticeBar$2$2$emit$1 = (CollectionRoomFragment$initNoticeBar$2$2$emit$1) continuation;
                if ((collectionRoomFragment$initNoticeBar$2$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    collectionRoomFragment$initNoticeBar$2$2$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = collectionRoomFragment$initNoticeBar$2$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (collectionRoomFragment$initNoticeBar$2$2$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            z = this.this$0.noticeUiNeedRefresh;
                            if (z) {
                                CollectionRoomFragment collectionRoomFragment = this.this$0;
                                long j = this.$vmid;
                                collectionRoomFragment$initNoticeBar$2$2$emit$1.label = 1;
                                refreshNoticeBar = collectionRoomFragment.refreshNoticeBar(j, collectionRoomFragment$initNoticeBar$2$2$emit$1);
                                if (refreshNoticeBar == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass2 = this;
                                anonymousClass2.this$0.noticeUiNeedRefresh = false;
                                break;
                            }
                            break;
                        case 1:
                            anonymousClass2 = this;
                            ResultKt.throwOnFailure($result);
                            anonymousClass2.this$0.noticeUiNeedRefresh = false;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            collectionRoomFragment$initNoticeBar$2$2$emit$1 = new CollectionRoomFragment$initNoticeBar$2$2$emit$1(this, continuation);
            Object $result2 = collectionRoomFragment$initNoticeBar$2$2$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (collectionRoomFragment$initNoticeBar$2$2$emit$1.label) {
            }
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((Lifecycle.Event) value, (Continuation<? super Unit>) $completion);
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Lifecycle lifecycle = this.this$0.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
                final Flow $this$filter$iv = LifecycleKt.getEventFlow(lifecycle);
                this.label = 1;
                if (new Flow<Lifecycle.Event>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2$invokeSuspend$$inlined$filter$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2$invokeSuspend$$inlined$filter$1$2", f = "CollectionRoomFragment.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
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
                                            Lifecycle.Event it = (Lifecycle.Event) value;
                                            Lifecycle.Event it2 = it == Lifecycle.Event.ON_RESUME ? 1 : null;
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
                }.collect(new AnonymousClass2(this.this$0, this.$vmid), (Continuation) this) == coroutine_suspended) {
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