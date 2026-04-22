package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.common.chronoscommon.message.DispatcherContext;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosResponseWrapper;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.AdDanmakuEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.EventReport;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetAudioTrack;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetCurrentWorkSource;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDanmakuFilter;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDeviceInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDmView;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetFeatureLists;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetLocalDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetPlayerComponentsHeight;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetSceneAndBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetVideoSize;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetViewProgress;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.InvokeCommandDetailPanel;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.MuteVideo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NativeLogger;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyCommercialEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyDanmakuExperiment;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyDanmakuSent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.OpenUrlScheme;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.RegisterGestureEvents;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReplyDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportSubtitle;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ShowPlayerWebView;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ShowToast;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.SwitchAudioTrack;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.URLRequest;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UnzipFile;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateClipboard;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateCurrentWork;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateDanmakuInputPanel;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateDanmakuSwitch;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateFullscreenState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePlaybackStatus;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePlayerControlBar;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePreference;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateShipChain;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateUIMode;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateVideoDetailState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosMessageHandler.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 (2Â\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012f\u0012d\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u000ej\u0011`\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012Z\u0012X\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u000ej\u0011`\u0017¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0001j\b\u0012\u0004\u0012\u00020\u0007`\u0018:\u0001(B=\u0012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012 \u0010\u001d\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e\u0018\u00010\n¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010#\u001a\u00020\u0010\"\u0004\b\u0000\u0010$2\u0010\u0010%\u001a\f\u0012\u0004\u0012\u0002H$\u0012\u0002\b\u00030\u001eJ\u001e\u0010&\u001a\u00020\u0010\"\u0004\b\u0000\u0010$2\u0010\u0010%\u001a\f\u0012\u0004\u0012\u0002H$\u0012\u0002\b\u00030\u001eJÍ\u0001\u0010'\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2J\u0010\u0011\u001aF\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`\u00122>\u0010\u0016\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`\u0017H\u0096\u0002R\u0012\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageHandler;", "Lkotlin/Function6;", "Lcom/bilibili/common/chronoscommon/message/DispatcherContext;", "Lkotlin/ParameterName;", "name", "context", "Ljava/lang/Class;", "", "type", "args", "", "", "", "extra", "Lkotlin/Function2;", "result", "", "onComplete", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerComplete;", "", "code", "description", "onError", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerError;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/HandlerInvoker;", "chronosPkgRunner", "Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;", "localService", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ISampleLocalService;", "businessMessageHandlers", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "<init>", "(Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ISampleLocalService;Ljava/util/Map;)V", "sChronosRequest", "", "addRequestHandler", "Request", "handler", "removeRequestHandler", "invoke", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosMessageHandler implements Function6<DispatcherContext, Class<Object>, Object, Map<String, ? extends byte[]>, Function2<? super Object, ? super Map<String, ? extends byte[]>, ? extends Unit>, Function2<? super Integer, ? super String, ? extends Unit>, Unit> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ChronosRpcHandler";
    private final Map<Class<?>, ChronosRequestHandler<?, ?>> businessMessageHandlers;
    private final EnhancedChronosPackageRunner<?> chronosPkgRunner;
    private final ISampleLocalService localService;
    private final List<Object> sChronosRequest;

    public ChronosMessageHandler(EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner, ISampleLocalService localService, Map<Class<?>, ? extends ChronosRequestHandler<?, ?>> map) {
        Iterable values;
        Map businessMessageHandlers = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(enhancedChronosPackageRunner, "chronosPkgRunner");
        Intrinsics.checkNotNullParameter(localService, "localService");
        this.chronosPkgRunner = enhancedChronosPackageRunner;
        this.localService = localService;
        this.businessMessageHandlers = businessMessageHandlers;
        this.sChronosRequest = CollectionsKt.mutableListOf(new Object[]{NativeLogger.Request.class, GetVideoSize.Request.class, GetWorkInfo.Request.class, UpdateCurrentWork.Request.class, URLRequest.Request.class, UpdateDanmakuSwitch.Request.class, UnzipFile.Request.class, UpdateFullscreenState.Request.class, GetSceneAndBiz.Request.class, GetDmView.Request.class, GetDanmakuConfig.Request.class, GetDanmakuFilter.Request.class, GetViewProgress.Request.class, GetLocalDanmaku.Request.class, GetCurrentWorkSource.Request.class, EventReport.Request.class, UpdateShipChain.Request.class, UpdatePlaybackStatus.Request.class, UpdateUIMode.Request.class, ShowToast.Request.class, OpenUrlScheme.Request.class, RegisterGestureEvents.Request.class, ReportDanmaku.Request.class, ReportSubtitle.Request.class, UpdateVideoDetailState.Request.class, UpdateClipboard.Request.class, AdDanmakuEvent.Request.class, ReplyDanmaku.Request.class, UpdatePlayerControlBar.Request.class, UpdatePreference.Request.class, ShowPlayerWebView.Request.class, GetDeviceInfo.Request.class, GetFeatureLists.Request.class, GetPlayerComponentsHeight.Request.class, InvokeCommandDetailPanel.Request.class, MuteVideo.Request.class, GetAudioTrack.Request.class, SwitchAudioTrack.Request.class, InvokeCommandDetailPanel.Request.class, UpdateDanmakuInputPanel.Request.class, NotifyDanmakuExperiment.Request.class, NotifyDanmakuSent.Request.class, SwitchAudioTrack.Request.class, NotifyCommercialEvent.Request.class});
        Iterable $this$forEach$iv = this.sChronosRequest;
        for (Object element$iv : $this$forEach$iv) {
            EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner2 = this.chronosPkgRunner;
            Intrinsics.checkNotNull(element$iv, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            enhancedChronosPackageRunner2.setHandler((Class) element$iv, this);
        }
        Map<Class<?>, ChronosRequestHandler<?, ?>> map2 = this.businessMessageHandlers;
        if (map2 == null || (values = map2.values()) == null) {
            return;
        }
        Iterable<ChronosRequestHandler> $this$forEach$iv2 = values;
        for (ChronosRequestHandler handler : $this$forEach$iv2) {
            addRequestHandler(handler);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        invoke((DispatcherContext) p1, (Class) p2, p3, (Map) p4, (Function2) p5, (Function2) p6);
        return Unit.INSTANCE;
    }

    public final <Request> void addRequestHandler(final ChronosRequestHandler<Request, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        this.chronosPkgRunner.setHandler(chronosRequestHandler.getRequestClass(), new Function6() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageHandler$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                Unit addRequestHandler$lambda$0;
                addRequestHandler$lambda$0 = ChronosMessageHandler.addRequestHandler$lambda$0(ChronosRequestHandler.this, (DispatcherContext) obj, (Class) obj2, obj3, (Map) obj4, (Function2) obj5, (Function2) obj6);
                return addRequestHandler$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addRequestHandler$lambda$0(ChronosRequestHandler $handler, DispatcherContext dispatcherContext, Class cls, Object args, Map map, Function2 onComplete, Function2 onError) {
        Intrinsics.checkNotNullParameter(cls, "<unused var>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!$handler.getRequestNullable() && args == null) {
            onError.invoke(Integer.valueOf((int) RpcException.PACKAGE_MSG_NOT_SUPPORT_METHOD), "Request is null!");
            return Unit.INSTANCE;
        }
        ChronosResponseWrapper returned = $handler.handle(args);
        if (returned instanceof ChronosResponseWrapper.Success) {
            onComplete.invoke(((ChronosResponseWrapper.Success) returned).getResponse(), (Object) null);
        } else if (!(returned instanceof ChronosResponseWrapper.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            onError.invoke(((ChronosResponseWrapper.Failure) returned).getCode(), ((ChronosResponseWrapper.Failure) returned).getDescription());
        }
        return Unit.INSTANCE;
    }

    public final <Request> void removeRequestHandler(ChronosRequestHandler<Request, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        this.chronosPkgRunner.setHandler(chronosRequestHandler.getRequestClass(), (Function6) null);
    }

    public void invoke(DispatcherContext context, Class<Object> cls, Object args, Map<String, byte[]> map, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        BLog.d(TAG, "chronos rpc receive:" + cls + " args=" + args + ", extra=" + extra);
        if (Intrinsics.areEqual(cls, NativeLogger.Request.class)) {
            this.localService.nativeLogger(args instanceof NativeLogger.Request ? (NativeLogger.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetVideoSize.Request.class)) {
            this.localService.updateVideoSize(args instanceof GetVideoSize.Request ? (GetVideoSize.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetWorkInfo.Request.class)) {
            this.localService.getCurrentWorkInfo(args instanceof GetWorkInfo.Request ? (GetWorkInfo.Request) args : null, function2, function22);
        } else if (Intrinsics.areEqual(cls, UpdateCurrentWork.Request.class)) {
            this.localService.updateCurrentWork(args instanceof UpdateCurrentWork.Request ? (UpdateCurrentWork.Request) args : null, function2, function22);
        } else if (Intrinsics.areEqual(cls, URLRequest.Request.class)) {
            this.localService.httpUrlRequest(args instanceof URLRequest.Request ? (URLRequest.Request) args : null, context, function2, function22);
        } else if (Intrinsics.areEqual(cls, UpdateDanmakuSwitch.Request.class)) {
            this.localService.updateDanmakuSwitch(args instanceof UpdateDanmakuSwitch.Request ? (UpdateDanmakuSwitch.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, UnzipFile.Request.class)) {
            this.localService.unzipFile(args instanceof UnzipFile.Request ? (UnzipFile.Request) args : null, function2, function22);
        } else if (Intrinsics.areEqual(cls, UpdateFullscreenState.Request.class)) {
            this.localService.updatePlayerFullScreenState(args instanceof UpdateFullscreenState.Request ? (UpdateFullscreenState.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetSceneAndBiz.Request.class)) {
            this.localService.getSceneAndBiz(args instanceof GetSceneAndBiz.Request ? (GetSceneAndBiz.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetDmView.Request.class)) {
            this.localService.getDmView(args instanceof GetDmView.Request ? (GetDmView.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetDanmakuConfig.Request.class)) {
            this.localService.getDanmakuConfig(args instanceof GetDanmakuConfig.Request ? (GetDanmakuConfig.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetDanmakuFilter.Request.class)) {
            this.localService.getDanmakuFilter(args instanceof GetDanmakuFilter.Request ? (GetDanmakuFilter.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetViewProgress.Request.class)) {
            this.localService.getViewProgress(args instanceof GetViewProgress.Request ? (GetViewProgress.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetLocalDanmaku.Request.class)) {
            this.localService.getLocalDanmaku(args instanceof GetLocalDanmaku.Request ? (GetLocalDanmaku.Request) args : null, function2, function22);
        } else if (Intrinsics.areEqual(cls, GetDeviceInfo.Request.class)) {
            this.localService.getDeviceInfo(args instanceof GetDeviceInfo.Request ? (GetDeviceInfo.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetFeatureLists.Request.class)) {
            this.localService.getFeatureLists(args instanceof GetFeatureLists.Request ? (GetFeatureLists.Request) args : null, function2);
        } else if (Intrinsics.areEqual(cls, GetCurrentWorkSource.Request.class)) {
            this.localService.getCurrentWorkSource(args instanceof GetCurrentWorkSource.Request ? (GetCurrentWorkSource.Request) args : null, function2);
        }
        if (this.localService instanceof ILocalService) {
            if (!Intrinsics.areEqual(cls, EventReport.Request.class)) {
                if (!Intrinsics.areEqual(cls, UpdateShipChain.Request.class)) {
                    if (!Intrinsics.areEqual(cls, UpdatePlaybackStatus.Request.class)) {
                        if (!Intrinsics.areEqual(cls, UpdateUIMode.Request.class)) {
                            if (!Intrinsics.areEqual(cls, ShowToast.Request.class)) {
                                if (!Intrinsics.areEqual(cls, OpenUrlScheme.Request.class)) {
                                    if (!Intrinsics.areEqual(cls, ReportDanmaku.Request.class)) {
                                        if (!Intrinsics.areEqual(cls, ReportSubtitle.Request.class)) {
                                            if (!Intrinsics.areEqual(cls, UpdateVideoDetailState.Request.class)) {
                                                if (!Intrinsics.areEqual(cls, UpdateClipboard.Request.class)) {
                                                    if (!Intrinsics.areEqual(cls, AdDanmakuEvent.Request.class)) {
                                                        if (!Intrinsics.areEqual(cls, ReplyDanmaku.Request.class)) {
                                                            if (!Intrinsics.areEqual(cls, UpdatePlayerControlBar.Request.class)) {
                                                                if (!Intrinsics.areEqual(cls, UpdatePreference.Request.class)) {
                                                                    if (!Intrinsics.areEqual(cls, ShowPlayerWebView.Request.class)) {
                                                                        if (!Intrinsics.areEqual(cls, GetPlayerComponentsHeight.Request.class)) {
                                                                            if (!Intrinsics.areEqual(cls, InvokeCommandDetailPanel.Request.class)) {
                                                                                if (!Intrinsics.areEqual(cls, MuteVideo.Request.class)) {
                                                                                    if (!Intrinsics.areEqual(cls, GetAudioTrack.Request.class)) {
                                                                                        if (!Intrinsics.areEqual(cls, SwitchAudioTrack.Request.class)) {
                                                                                            if (!Intrinsics.areEqual(cls, InvokeCommandDetailPanel.Request.class)) {
                                                                                                if (!Intrinsics.areEqual(cls, UpdateDanmakuInputPanel.Request.class)) {
                                                                                                    if (!Intrinsics.areEqual(cls, NotifyDanmakuExperiment.Request.class)) {
                                                                                                        if (!Intrinsics.areEqual(cls, NotifyDanmakuSent.Request.class)) {
                                                                                                            if (Intrinsics.areEqual(cls, NotifyCommercialEvent.Request.class)) {
                                                                                                                Intrinsics.checkNotNull(args, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyCommercialEvent.Request");
                                                                                                                ((ILocalService) this.localService).notifyCommercialEvent((NotifyCommercialEvent.Request) args, function2);
                                                                                                                return;
                                                                                                            }
                                                                                                            return;
                                                                                                        }
                                                                                                        Intrinsics.checkNotNull(args, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyDanmakuSent.Request");
                                                                                                        ((ILocalService) this.localService).notifyDanmakuSent((NotifyDanmakuSent.Request) args, function2);
                                                                                                        return;
                                                                                                    }
                                                                                                    Intrinsics.checkNotNull(args, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyDanmakuExperiment.Request");
                                                                                                    ((ILocalService) this.localService).notifyDanmakuExperiment((NotifyDanmakuExperiment.Request) args, function2);
                                                                                                    return;
                                                                                                }
                                                                                                Intrinsics.checkNotNull(args, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateDanmakuInputPanel.Request");
                                                                                                ((ILocalService) this.localService).updateDanmakuInputPanel((UpdateDanmakuInputPanel.Request) args, function2);
                                                                                                return;
                                                                                            }
                                                                                            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.InvokeCommandDetailPanel.Request");
                                                                                            ((ILocalService) this.localService).invokeCommandDetailPanel((InvokeCommandDetailPanel.Request) args, function2);
                                                                                            return;
                                                                                        }
                                                                                        ((ILocalService) this.localService).switchAudioIndex(args instanceof SwitchAudioTrack.Request ? (SwitchAudioTrack.Request) args : null, function2, function22);
                                                                                        return;
                                                                                    }
                                                                                    ((ILocalService) this.localService).getAudioStreams(args instanceof GetAudioTrack.Request ? (GetAudioTrack.Request) args : null, function2);
                                                                                    return;
                                                                                }
                                                                                ((ILocalService) this.localService).setVideoMute(args instanceof MuteVideo.Request ? (MuteVideo.Request) args : null, function2);
                                                                                return;
                                                                            }
                                                                            ((ILocalService) this.localService).invokeCommandDetailPanel(args instanceof InvokeCommandDetailPanel.Request ? (InvokeCommandDetailPanel.Request) args : null, function2);
                                                                            return;
                                                                        }
                                                                        ((ILocalService) this.localService).getPlayerComponentsHeight(args instanceof GetPlayerComponentsHeight.Request ? (GetPlayerComponentsHeight.Request) args : null, function2);
                                                                        return;
                                                                    }
                                                                    ((ILocalService) this.localService).showPlayerWebView(args instanceof ShowPlayerWebView.Request ? (ShowPlayerWebView.Request) args : null, function2);
                                                                    return;
                                                                }
                                                                ((ILocalService) this.localService).updatePreference(args instanceof UpdatePreference.Request ? (UpdatePreference.Request) args : null, function2);
                                                                return;
                                                            }
                                                            ((ILocalService) this.localService).updatePlayerControlBar(args instanceof UpdatePlayerControlBar.Request ? (UpdatePlayerControlBar.Request) args : null, function2);
                                                            return;
                                                        }
                                                        ((ILocalService) this.localService).replyDanmaku(args instanceof ReplyDanmaku.Request ? (ReplyDanmaku.Request) args : null, function2);
                                                        return;
                                                    }
                                                    ((ILocalService) this.localService).adDanmakuEvent(args instanceof AdDanmakuEvent.Request ? (AdDanmakuEvent.Request) args : null, function2, function22);
                                                    return;
                                                }
                                                ((ILocalService) this.localService).updateClipboard(args instanceof UpdateClipboard.Request ? (UpdateClipboard.Request) args : null, function2, function22);
                                                return;
                                            }
                                            ((ILocalService) this.localService).staffFollowStateChange(args instanceof UpdateVideoDetailState.Request ? (UpdateVideoDetailState.Request) args : null, function2);
                                            return;
                                        }
                                        ((ILocalService) this.localService).reportSubtitle(args instanceof ReportSubtitle.Request ? (ReportSubtitle.Request) args : null, function2);
                                        return;
                                    }
                                    ((ILocalService) this.localService).reportDanmaku(args instanceof ReportDanmaku.Request ? (ReportDanmaku.Request) args : null, function2);
                                    return;
                                }
                                ((ILocalService) this.localService).openRouteUrl(args instanceof OpenUrlScheme.Request ? (OpenUrlScheme.Request) args : null, function2);
                                return;
                            }
                            ((ILocalService) this.localService).showToast(args instanceof ShowToast.Request ? (ShowToast.Request) args : null, function2);
                            return;
                        }
                        ((ILocalService) this.localService).updateUiMode(args instanceof UpdateUIMode.Request ? (UpdateUIMode.Request) args : null, function2);
                        return;
                    }
                    ((ILocalService) this.localService).updatePlayBackStatus(args instanceof UpdatePlaybackStatus.Request ? (UpdatePlaybackStatus.Request) args : null, function2);
                    return;
                }
                ((ILocalService) this.localService).updateRelationshipChain(args instanceof UpdateShipChain.Request ? (UpdateShipChain.Request) args : null, function2);
                return;
            }
            ((ILocalService) this.localService).eventReport(args instanceof EventReport.Request ? (EventReport.Request) args : null, function2);
        }
    }

    /* compiled from: ChronosMessageHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageHandler$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}