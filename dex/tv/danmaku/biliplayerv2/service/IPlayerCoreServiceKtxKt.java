package tv.danmaku.biliplayerv2.service;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.service.PlayerSeekObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreServiceKtx.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015\u001a\u001a\u0010\u0017\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u001b\u001a\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u0003\u001a\u001a\u0010\u001d\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 \"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005\"\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006!"}, d2 = {"bufferingFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "getBufferingFlow", "(Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;)Lkotlinx/coroutines/flow/Flow;", "seekFlow", "getSeekFlow", "playerStateFlow", "", "getPlayerStateFlow", "playerErrorEventFlow", "Ltv/danmaku/biliplayerv2/service/PlayerErrorEvent;", "getPlayerErrorEventFlow", "retainOnAssetUpdateListener", "", "listener", "Ltv/danmaku/biliplayerv2/service/OnAssetUpdateListener;", "(Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;Ltv/danmaku/biliplayerv2/service/OnAssetUpdateListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progressInRangeStateFlow", "startMillis", "", "endMillis", "awaitProgress", "progressMs", "(Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSeekCompletion", "(Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requiringSafeConnectionEventFlow", "retainPlaySourceObserver", "observer", "Ltv/danmaku/biliplayerv2/service/IPlayerSourceObserver;", "(Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;Ltv/danmaku/biliplayerv2/service/IPlayerSourceObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IPlayerCoreServiceKtxKt {
    public static final Flow<Boolean> getBufferingFlow(IPlayerCoreService $this$bufferingFlow) {
        Intrinsics.checkNotNullParameter($this$bufferingFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new IPlayerCoreServiceKtxKt$bufferingFlow$1($this$bufferingFlow, null))));
    }

    public static final Flow<Boolean> getSeekFlow(IPlayerCoreService $this$seekFlow) {
        Intrinsics.checkNotNullParameter($this$seekFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new IPlayerCoreServiceKtxKt$seekFlow$1($this$seekFlow, null))));
    }

    public static final Flow<Integer> getPlayerStateFlow(IPlayerCoreService $this$playerStateFlow) {
        Intrinsics.checkNotNullParameter($this$playerStateFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new IPlayerCoreServiceKtxKt$playerStateFlow$1($this$playerStateFlow, null))));
    }

    public static final Flow<PlayerErrorEvent> getPlayerErrorEventFlow(IPlayerCoreService $this$playerErrorEventFlow) {
        Intrinsics.checkNotNullParameter($this$playerErrorEventFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.callbackFlow(new IPlayerCoreServiceKtxKt$playerErrorEventFlow$1($this$playerErrorEventFlow, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object retainOnAssetUpdateListener(IPlayerCoreService $this$retainOnAssetUpdateListener, OnAssetUpdateListener listener, Continuation<? super Unit> continuation) {
        IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1 iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1;
        try {
            if (continuation instanceof IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1) {
                iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1 = (IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1) continuation;
                if ((iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.label & Integer.MIN_VALUE) != 0) {
                    iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.label -= Integer.MIN_VALUE;
                    Object $result = iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            $this$retainOnAssetUpdateListener.setAssetUpdateListener(listener);
                            iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.L$0 = $this$retainOnAssetUpdateListener;
                            iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.label = 1;
                            if (DelayKt.awaitCancellation(iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            $this$retainOnAssetUpdateListener = (IPlayerCoreService) iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw new KotlinNothingValueException();
                }
            }
            switch (iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.label) {
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            $this$retainOnAssetUpdateListener.setAssetUpdateListener(null);
            throw th;
        }
        iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1 = new IPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1(continuation);
        Object $result2 = iPlayerCoreServiceKtxKt$retainOnAssetUpdateListener$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static final Flow<Boolean> progressInRangeStateFlow(IPlayerCoreService $this$progressInRangeStateFlow, long startMillis, long endMillis) {
        Intrinsics.checkNotNullParameter($this$progressInRangeStateFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new IPlayerCoreServiceKtxKt$progressInRangeStateFlow$1($this$progressInRangeStateFlow, startMillis, endMillis, null))));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$awaitProgress$2$observer$1] */
    public static final Object awaitProgress(final IPlayerCoreService $this$awaitProgress, long progressMs, Continuation<? super Unit> continuation) {
        if ($this$awaitProgress.getCurrentPosition() > progressMs) {
            return Unit.INSTANCE;
        }
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        final ?? r0 = new PlayerProgressRangeObserver() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$awaitProgress$2$observer$1
            @Override // tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver
            public void onRangeStateChanged(boolean isActive, int currentPosition) {
                if (!isActive) {
                    Result.Companion companion = Result.Companion;
                    it.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                    $this$awaitProgress.unregisterPlayerProgressRangeObserver(this);
                }
            }
        };
        $this$awaitProgress.registerPlayerProgressRangeObserver((PlayerProgressRangeObserver) r0, -1L, progressMs);
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$awaitProgress$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it2) {
                IPlayerCoreService.this.unregisterPlayerProgressRangeObserver(r0);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$awaitSeekCompletion$2$seekObserver$1] */
    public static final Object awaitSeekCompletion(final IPlayerCoreService $this$awaitSeekCompletion, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        final ?? r6 = new PlayerSeekObserver() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$awaitSeekCompletion$2$seekObserver$1
            @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
            public /* synthetic */ void onSeekStart(long j) {
                PlayerSeekObserver.CC.$default$onSeekStart(this, j);
            }

            @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
            public void onSeekComplete(long position) {
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                $this$awaitSeekCompletion.unregisterSeekObserver(this);
            }
        };
        $this$awaitSeekCompletion.registerSeekObserver((PlayerSeekObserver) r6);
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.biliplayerv2.service.IPlayerCoreServiceKtxKt$awaitSeekCompletion$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it2) {
                IPlayerCoreService.this.unregisterSeekObserver(r6);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public static final Flow<Unit> requiringSafeConnectionEventFlow(IPlayerCoreService $this$requiringSafeConnectionEventFlow) {
        Intrinsics.checkNotNullParameter($this$requiringSafeConnectionEventFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.callbackFlow(new IPlayerCoreServiceKtxKt$requiringSafeConnectionEventFlow$1($this$requiringSafeConnectionEventFlow, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object retainPlaySourceObserver(IPlayerCoreService $this$retainPlaySourceObserver, IPlayerSourceObserver observer, Continuation<? super Unit> continuation) {
        IPlayerCoreServiceKtxKt$retainPlaySourceObserver$1 iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1;
        IPlayerCoreService $this$retainPlaySourceObserver2;
        IPlayerSourceObserver observer2;
        if (continuation instanceof IPlayerCoreServiceKtxKt$retainPlaySourceObserver$1) {
            iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1 = (IPlayerCoreServiceKtxKt$retainPlaySourceObserver$1) continuation;
            if ((iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.label & Integer.MIN_VALUE) != 0) {
                iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.label -= Integer.MIN_VALUE;
                Object $result = iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$retainPlaySourceObserver.addPlayerSourceObserver(observer);
                        try {
                            iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.L$0 = $this$retainPlaySourceObserver;
                            iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.L$1 = observer;
                            iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.label = 1;
                            if (DelayKt.awaitCancellation(iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$retainPlaySourceObserver2 = $this$retainPlaySourceObserver;
                            observer2 = observer;
                            throw new KotlinNothingValueException();
                        } catch (Throwable th) {
                            th = th;
                            $this$retainPlaySourceObserver2 = $this$retainPlaySourceObserver;
                            observer2 = observer;
                            $this$retainPlaySourceObserver2.removePlayerSourceObserver(observer2);
                            throw th;
                        }
                    case 1:
                        observer2 = (IPlayerSourceObserver) iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.L$1;
                        $this$retainPlaySourceObserver2 = (IPlayerCoreService) iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            throw new KotlinNothingValueException();
                        } catch (Throwable th2) {
                            th = th2;
                            $this$retainPlaySourceObserver2.removePlayerSourceObserver(observer2);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1 = new IPlayerCoreServiceKtxKt$retainPlaySourceObserver$1(continuation);
        Object $result2 = iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iPlayerCoreServiceKtxKt$retainPlaySourceObserver$1.label) {
        }
    }
}