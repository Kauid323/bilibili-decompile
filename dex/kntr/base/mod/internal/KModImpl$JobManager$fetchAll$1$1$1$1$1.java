package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.ModEvent;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$fetchAll$1$1$1$1$1", f = "KModImpl.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class KModImpl$JobManager$fetchAll$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KModImpl.JobManager.DownloadAndInstallFlowHolder $this_run;
    int label;
    final /* synthetic */ KModImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$fetchAll$1$1$1$1$1(KModImpl.JobManager.DownloadAndInstallFlowHolder downloadAndInstallFlowHolder, KModImpl kModImpl, Continuation<? super KModImpl$JobManager$fetchAll$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$this_run = downloadAndInstallFlowHolder;
        this.this$0 = kModImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KModImpl$JobManager$fetchAll$1$1$1$1$1(this.$this_run, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$fetchAll$1$1$1$1$1$1", f = "KModImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$fetchAll$1$1$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ModEvent.FetchEvent, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ KModImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(KModImpl kModImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = kModImpl;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(ModEvent.FetchEvent fetchEvent, Continuation<? super Boolean> continuation) {
            return create(fetchEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            boolean isTerminal;
            ModEvent.FetchEvent it = (ModEvent.FetchEvent) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    isTerminal = this.this$0.isTerminal(it);
                    return Boxing.boxBoolean(!isTerminal);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collect(FlowKt.takeWhile(this.$this_run.subscribeFlow(), new AnonymousClass1(this.this$0, null)), (Continuation) this) == coroutine_suspended) {
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