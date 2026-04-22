package kntr.app.deepsearch.service;

import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeout;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.di.DeepSearchCoroutineScope;
import kntr.app.deepsearch.di.DeepSearchScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: DeepSearchTimeoutServiceImp.kt */
@DeepSearchScope
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/app/deepsearch/service/DeepSearchTimeoutServiceImp;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "timeoutInterval", RoomRecommendViewModel.EMPTY_CURSOR, "greetTimeoutJob", "Lkotlinx/coroutines/Job;", "greetFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeout;", "timeoutJob", "flow", "greetTimeoutFlow", "Lkotlinx/coroutines/flow/Flow;", "timeoutFlow", "launchTimeout", RoomRecommendViewModel.EMPTY_CURSOR, "cancelTimeout", "greetLaunchTimeout", "greetCancelTimeout", "configTimeoutInterval", "interval", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTimeoutServiceImp implements DeepSearchTimeoutService {
    public static final int $stable = 8;
    private final MutableSharedFlow<DeepSearchTimeout> flow;
    private final MutableSharedFlow<DeepSearchTimeout> greetFlow;
    private Job greetTimeoutJob;
    private final CoroutineScope scope;
    private long timeoutInterval;
    private Job timeoutJob;

    @Inject
    public DeepSearchTimeoutServiceImp(@DeepSearchCoroutineScope CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.timeoutInterval = 30000L;
        this.greetFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.flow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public Flow<DeepSearchTimeout> greetTimeoutFlow() {
        return this.greetFlow;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public Flow<DeepSearchTimeout> timeoutFlow() {
        return this.flow;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public void launchTimeout() {
        cancelTimeout();
        this.timeoutJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DeepSearchTimeoutServiceImp$launchTimeout$1(this, null), 3, (Object) null);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public void cancelTimeout() {
        Job job = this.timeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.timeoutJob = null;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public void greetLaunchTimeout() {
        greetCancelTimeout();
        this.greetTimeoutJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DeepSearchTimeoutServiceImp$greetLaunchTimeout$1(this, null), 3, (Object) null);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public void greetCancelTimeout() {
        Job job = this.greetTimeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.greetTimeoutJob = null;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService
    public void configTimeoutInterval(long interval) {
        this.timeoutInterval = interval > 0 ? interval : 30000L;
    }
}