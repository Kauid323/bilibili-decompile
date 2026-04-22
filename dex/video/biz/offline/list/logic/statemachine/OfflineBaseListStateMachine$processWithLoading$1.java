package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$processWithLoading$1", f = "OfflineBaseListStateMachine.kt", i = {}, l = {263, 266, 267}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineBaseListStateMachine$processWithLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ OfflineBaseListStateMachine $machine;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineBaseListStateMachine$processWithLoading$1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, OfflineBaseListStateMachine offlineBaseListStateMachine, Continuation<? super OfflineBaseListStateMachine$processWithLoading$1> continuation) {
        super(2, continuation);
        this.$block = function1;
        this.$machine = offlineBaseListStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineBaseListStateMachine$processWithLoading$1(this.$block, this.$machine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Function1<Continuation<? super Unit>, Object> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LogKt.getVBLog().debug("转圈----- loading  start");
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$machine, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = this.$block;
                this.label = 2;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$machine, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                LogKt.getVBLog().debug("转圈----- loading  end");
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                function1 = this.$block;
                this.label = 2;
                if (function1.invoke(this) == coroutine_suspended) {
                }
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$machine, null), (Continuation) this) == coroutine_suspended) {
                }
                LogKt.getVBLog().debug("转圈----- loading  end");
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$machine, null), (Continuation) this) == coroutine_suspended) {
                }
                LogKt.getVBLog().debug("转圈----- loading  end");
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                LogKt.getVBLog().debug("转圈----- loading  end");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineBaseListStateMachine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$processWithLoading$1$1", f = "OfflineBaseListStateMachine.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$processWithLoading$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OfflineBaseListStateMachine $machine;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OfflineBaseListStateMachine offlineBaseListStateMachine, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$machine = offlineBaseListStateMachine;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$machine, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$machine.dispatch(OfflineListAction.ShowLoading.INSTANCE, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineBaseListStateMachine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$processWithLoading$1$2", f = "OfflineBaseListStateMachine.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$processWithLoading$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OfflineBaseListStateMachine $machine;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(OfflineBaseListStateMachine offlineBaseListStateMachine, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$machine = offlineBaseListStateMachine;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$machine, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$machine.dispatch(OfflineListAction.DismissLoading.INSTANCE, (Continuation) this) == coroutine_suspended) {
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
}