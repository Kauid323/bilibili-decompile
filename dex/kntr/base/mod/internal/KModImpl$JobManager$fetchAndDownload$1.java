package kntr.base.mod.internal;

import java.util.concurrent.locks.ReentrantLock;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$fetchAndDownload$1", f = "KModImpl.kt", i = {0, 0}, l = {222}, m = "invokeSuspend", n = {"$this$flow", "key"}, s = {"L$0", "L$1"}, v = 1)
public final class KModImpl$JobManager$fetchAndDownload$1 extends SuspendLambda implements Function2<FlowCollector<? super ModEvent.FetchEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modName;
    final /* synthetic */ String $poolName;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KModImpl.JobManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$fetchAndDownload$1(KModImpl.JobManager jobManager, String str, String str2, Continuation<? super KModImpl$JobManager$fetchAndDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = jobManager;
        this.$poolName = str;
        this.$modName = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$JobManager$fetchAndDownload$1 = new KModImpl$JobManager$fetchAndDownload$1(this.this$0, this.$poolName, this.$modName, continuation);
        kModImpl$JobManager$fetchAndDownload$1.L$0 = obj;
        return kModImpl$JobManager$fetchAndDownload$1;
    }

    public final Object invoke(FlowCollector<? super ModEvent.FetchEvent> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow realFetchAndDownload;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String key = this.this$0.keyOf(this.$poolName, this.$modName);
                ReentrantLock reentrantLock = this.this$0.jobLock;
                KModImpl.JobManager jobManager = this.this$0;
                String str = this.$poolName;
                String str2 = this.$modName;
                reentrantLock.lock();
                try {
                    KModImpl.JobManager.DownloadAndInstallFlowHolder it = jobManager.getCurrentJobs().get(key);
                    if (it == null) {
                        realFetchAndDownload = jobManager.realFetchAndDownload(str, str2);
                        it = new KModImpl.JobManager.DownloadAndInstallFlowHolder(jobManager, str, str2, realFetchAndDownload);
                        jobManager.getCurrentJobs().put(key, it);
                    }
                    reentrantLock.unlock();
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(key);
                    this.label = 1;
                    if (FlowKt.collect(FlowKt.takeWhile(FlowKt.onEach(it.subscribeFlow(), new AnonymousClass2($this$flow, null)), new AnonymousClass3(null)), (Continuation) this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            case 1:
                String str3 = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$fetchAndDownload$1$2", f = "KModImpl.kt", i = {0}, l = {220}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
    /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$fetchAndDownload$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ModEvent.FetchEvent, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<ModEvent.FetchEvent> $$this$flow;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(FlowCollector<? super ModEvent.FetchEvent> flowCollector, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$$this$flow = flowCollector;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$$this$flow, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(ModEvent.FetchEvent fetchEvent, Continuation<? super Unit> continuation) {
            return create(fetchEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ModEvent.FetchEvent it = (ModEvent.FetchEvent) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.label = 1;
                    if (this.$$this$flow.emit(it, (Continuation) this) == coroutine_suspended) {
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
    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$fetchAndDownload$1$3", f = "KModImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$fetchAndDownload$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<ModEvent.FetchEvent, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(ModEvent.FetchEvent fetchEvent, Continuation<? super Boolean> continuation) {
            return create(fetchEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ModEvent.FetchEvent it = (ModEvent.FetchEvent) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    return Boxing.boxBoolean(((it instanceof ModEvent.Failure) || (it instanceof ModEvent.Succeed)) ? false : true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}