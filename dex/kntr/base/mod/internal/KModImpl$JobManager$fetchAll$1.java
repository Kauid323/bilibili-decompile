package kntr.base.mod.internal;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.mod.internal.KModImpl;
import kntr.base.moss.api.KMossException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$fetchAll$1", f = "KModImpl.kt", i = {0}, l = {364}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class KModImpl$JobManager$fetchAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $poolName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KModImpl.JobManager this$0;
    final /* synthetic */ KModImpl this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$fetchAll$1(KModImpl.JobManager jobManager, String str, KModImpl kModImpl, Continuation<? super KModImpl$JobManager$fetchAll$1> continuation) {
        super(2, continuation);
        this.this$0 = jobManager;
        this.$poolName = str;
        this.this$1 = kModImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$JobManager$fetchAll$1 = new KModImpl$JobManager$fetchAll$1(this.this$0, this.$poolName, this.this$1, continuation);
        kModImpl$JobManager$fetchAll$1.L$0 = obj;
        return kModImpl$JobManager$fetchAll$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestAllMods;
        String key;
        ReentrantLock reentrantLock;
        KModImpl.JobManager.DownloadAndInstallFlowHolder holder;
        Map entries;
        Flow realDownloadAndInstall;
        String poolName;
        boolean z;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = $this$launch;
                    this.label = 1;
                    requestAllMods = this.this$0.requestAllMods(this.$poolName, (Continuation) this);
                    if (requestAllMods == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    requestAllMods = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map entries2 = (Map) requestAllMods;
            KModImpl.JobManager jobManager = this.this$0;
            KModImpl kModImpl = this.this$1;
            for (Map.Entry element$iv : entries2.entrySet()) {
                String poolName2 = (String) element$iv.getKey();
                Map pool = (Map) element$iv.getValue();
                for (Map.Entry element$iv2 : pool.entrySet()) {
                    String modName = (String) element$iv2.getKey();
                    Pair pair = (Pair) element$iv2.getValue();
                    KModImpl.RemoteModInfo remote = (KModImpl.RemoteModInfo) pair.getSecond();
                    try {
                        if (remote != null) {
                            if (remote.getUrl().length() == 0 ? z2 : false) {
                                poolName = poolName2;
                                z = z2;
                                entries = entries2;
                            } else if (!remote.isAutoDownload()) {
                                poolName = poolName2;
                                z = z2;
                                entries = entries2;
                            }
                            entries2 = entries;
                            poolName2 = poolName;
                            z2 = z;
                        }
                        if (jobManager.getCurrentJobs().containsKey(key)) {
                            entries = entries2;
                            holder = null;
                        } else {
                            try {
                                entries = entries2;
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                realDownloadAndInstall = jobManager.realDownloadAndInstall(pair, true);
                                holder = new KModImpl.JobManager.DownloadAndInstallFlowHolder(jobManager, poolName2, modName, realDownloadAndInstall);
                                jobManager.getCurrentJobs().put(key, holder);
                            } catch (Throwable th2) {
                                th = th2;
                                reentrantLock.unlock();
                                throw th;
                            }
                        }
                        reentrantLock.unlock();
                        if (holder != null) {
                            KModImpl.JobManager.DownloadAndInstallFlowHolder $this$invokeSuspend_u24lambda_u240_u240_u241 = holder;
                            z = true;
                            poolName = poolName2;
                            BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new KModImpl$JobManager$fetchAll$1$1$1$1$1($this$invokeSuspend_u24lambda_u240_u240_u241, kModImpl, null), 3, (Object) null);
                        } else {
                            poolName = poolName2;
                            z = true;
                        }
                        entries2 = entries;
                        poolName2 = poolName;
                        z2 = z;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    key = jobManager.keyOf(poolName2, modName);
                    reentrantLock = jobManager.jobLock;
                    reentrantLock.lock();
                }
            }
            return Unit.INSTANCE;
        } catch (RuntimeException e) {
            KLog_androidKt.getKLog().e("KModJobManager", "updateAll " + this.$poolName + " fail", e);
            return Unit.INSTANCE;
        } catch (KMossException e2) {
            KLog_androidKt.getKLog().e("KModJobManager", "updateAll " + this.$poolName + " fail by moss", e2);
            return Unit.INSTANCE;
        }
    }
}