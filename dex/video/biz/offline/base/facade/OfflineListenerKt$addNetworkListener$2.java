package video.biz.offline.base.facade;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kntr.base.reachability.KReachabilityKt;
import kntr.base.reachability.NetWorkState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.infra.download.PauseType;
import video.biz.offline.base.infra.utils.Config;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineListener.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.OfflineListenerKt$addNetworkListener$2", f = "OfflineListener.kt", i = {}, l = {DynModuleType.module_onetime_notice_VALUE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineListenerKt$addNetworkListener$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineListenerKt$addNetworkListener$2(Continuation<? super OfflineListenerKt$addNetworkListener$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineListenerKt$addNetworkListener$2(continuation);
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
                if (FlowKt.drop(FlowKt.distinctUntilChanged(KReachabilityKt.getKReachability().currentStateFlow()), 1).collect(new FlowCollector() { // from class: video.biz.offline.base.facade.OfflineListenerKt$addNetworkListener$2.1

                    /* compiled from: OfflineListener.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                    /* renamed from: video.biz.offline.base.facade.OfflineListenerKt$addNetworkListener$2$1$WhenMappings */
                    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                    public static final /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[NetWorkState.values().length];
                            try {
                                iArr[NetWorkState.NotReachable.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[NetWorkState.ViaWiFi.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((NetWorkState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(NetWorkState state, Continuation<? super Unit> continuation) {
                        Object startAll;
                        LogKt.getVBLog().info("Network state changed: " + state);
                        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                            case 1:
                                Object pauseAll = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().pauseAll(PauseType.PAUSE_NETWORK_ERROR, continuation);
                                return pauseAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? pauseAll : Unit.INSTANCE;
                            case 2:
                                boolean autoResumption = Config.Companion.getAutoResumption();
                                LogKt.getVBLog().info("Auto resumption is " + autoResumption);
                                return (autoResumption && (startAll = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().startAll(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? startAll : Unit.INSTANCE;
                            default:
                                Object pauseAll2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().pauseAll(PauseType.PAUSE_NOT_WIFI, continuation);
                                return pauseAll2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? pauseAll2 : Unit.INSTANCE;
                        }
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
}