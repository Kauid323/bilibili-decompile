package video.biz.offline.base.facade.client;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;
import video.base.log.LogKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.client.IOfflineClient;
import video.biz.offline.base.facade.service.IOfflineService;
import video.biz.offline.base.facade.service.VideoDownloadServiceV2;
import video.biz.offline.base.facade.utils.FacadeExtKt;
import video.biz.offline.base.facade.utils.Notifier;
import video.biz.offline.base.infra.download.PauseType;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.storage.DataStorageWrapperKt;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.base.model.model.ResolveParam;
import video.biz.offline.base.model.model.StorageInfoModel;

/* compiled from: VideoDownloadClientV2.kt */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0010\b\u0007\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0001rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\u000e\u0010!\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J/\u0010%\u001a\u0004\u0018\u0001H&\"\u0004\b\u0000\u0010&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b)H\u0082\b¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0015H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\u0016\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0096@¢\u0006\u0002\u00100J(\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/03022\f\u00104\u001a\b\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00106J\u0014\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0302H\u0016J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020/03H\u0096@¢\u0006\u0002\u0010\"J$\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/03022\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J$\u0010>\u001a\b\u0012\u0004\u0012\u00020/032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0096@¢\u0006\u0002\u0010?J$\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/03022\u0006\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J$\u0010B\u001a\b\u0012\u0004\u0012\u00020/032\u0006\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0096@¢\u0006\u0002\u0010?J\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020/03H\u0096@¢\u0006\u0002\u0010\"J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020/03H\u0096@¢\u0006\u0002\u0010\"J$\u0010E\u001a\b\u0012\u0004\u0012\u00020/032\u0006\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010HJ\u001c\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/03022\u0006\u0010J\u001a\u00020;H\u0016J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020/032\u0006\u0010J\u001a\u00020;H\u0096@¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u0004\u0018\u00010/2\u0006\u0010N\u001a\u00020=H\u0096@¢\u0006\u0002\u0010OJ\"\u0010P\u001a\b\u0012\u0004\u0012\u00020/032\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020=03H\u0096@¢\u0006\u0002\u00106J\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020/032\u0006\u0010<\u001a\u00020=H\u0096@¢\u0006\u0002\u0010OJ\u001c\u0010S\u001a\u00020\u00152\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020=03H\u0096@¢\u0006\u0002\u00106J\u001c\u0010T\u001a\u00020\u00152\f\u0010U\u001a\b\u0012\u0004\u0012\u00020/03H\u0082@¢\u0006\u0002\u00106J \u0010V\u001a\u00020\u00152\u0010\b\u0002\u0010U\u001a\n\u0012\u0004\u0012\u00020/\u0018\u000103H\u0082@¢\u0006\u0002\u00106J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020X03H\u0016J\b\u0010Y\u001a\u00020\u0015H\u0016J\u001c\u0010Z\u001a\u00020\u00152\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\\03H\u0096@¢\u0006\u0002\u00106J\u0016\u0010]\u001a\u00020\u00152\u0006\u0010N\u001a\u00020=H\u0096@¢\u0006\u0002\u0010OJ\u0016\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020`H\u0096@¢\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020\u00152\u0006\u0010N\u001a\u00020=H\u0096@¢\u0006\u0002\u0010OJ\u000e\u0010c\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010d\u001a\u00020\u00152\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020=03H\u0016J\u0016\u0010e\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0096@¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\"J \u0010j\u001a\u00020\u00152\b\u0010k\u001a\u0004\u0018\u00010=2\u0006\u0010l\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010mJ\u0018\u0010n\u001a\u00020\u00152\u0006\u0010o\u001a\u00020g2\u0006\u0010p\u001a\u00020gH\u0002J\b\u0010q\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lvideo/biz/offline/base/facade/client/VideoDownloadClientV2;", "Landroid/content/ServiceConnection;", "Lvideo/biz/offline/base/facade/IOfflineFacade;", "<init>", "()V", "dataStorage", "Lvideo/biz/offline/base/infra/storage/DataStorageWrapper;", "serviceProxy", "Lvideo/biz/offline/base/facade/service/IOfflineService;", "getServiceProxy", "()Lvideo/biz/offline/base/facade/service/IOfflineService;", "serviceProxyFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "processing", "", "callback", "video/biz/offline/base/facade/client/VideoDownloadClientV2$callback$1", "Lvideo/biz/offline/base/facade/client/VideoDownloadClientV2$callback$1;", "broadcastReceiverMediaMounted", "Landroid/content/BroadcastReceiver;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "bindService", "context", "Landroid/content/Context;", "unbindService", "callUnregisterClient", "initBind", "checkBind", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerBroadcastReceiver", "unregisterBroadcastReceiver", "safeServiceProxyCall", "T", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "init", "release", "checkIfNotInDB", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addVideos", "Lkotlinx/coroutines/flow/Flow;", "", "params", "Lvideo/biz/offline/base/model/model/ResolveParam;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVideosFlow", "getAllVideos", "getVideosFlowByGroupId", "groupId", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "getVideosByGroupId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByVideoId", "videoId", "getVideosByVideoId", "getDownloadedVideos", "getDownloadingVideos", "getUnDownloadVideos", "includePause", "includeError", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByPageId", "pageId", "getVideosByPageId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByKeys", "keys", "search", "removeVideo", "addDownload", "videos", "downloadVideosIfNeed", "getStorageInfo", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "resetMigrate", "updateAuthCode", "list", "Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "pause", "pauseAll", "type", "Lvideo/biz/offline/base/infra/download/PauseType;", "(Lvideo/biz/offline/base/infra/download/PauseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "startAll", "updateDanmaku", "setMaxConcurrent", "max", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyDownloadCountChanged", "handleUpdateVideo", "str", "forceUpdate", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleServiceTimeout", "startId", "fgsType", "resetAndMigrate", "Companion", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDownloadClientV2 implements ServiceConnection, IOfflineFacade {
    private volatile boolean processing;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final DataStorageWrapper dataStorage = new DataStorageWrapper();
    private final MutableStateFlow<IOfflineService> serviceProxyFlow = StateFlowKt.MutableStateFlow((Object) null);
    private final VideoDownloadClientV2$callback$1 callback = new IOfflineClient.Stub() { // from class: video.biz.offline.base.facade.client.VideoDownloadClientV2$callback$1
        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onUpdateVideo(String entryList, boolean forceUpdate) {
            BuildersKt.runBlocking(Dispatchers.getIO(), new VideoDownloadClientV2$callback$1$onUpdateVideo$1(VideoDownloadClientV2.this, entryList, forceUpdate, null));
        }

        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onDownloadComplete(String entryList) {
            BuildersKt.runBlocking(Dispatchers.getIO(), new VideoDownloadClientV2$callback$1$onDownloadComplete$1(VideoDownloadClientV2.this, entryList, null));
        }

        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onDownloadError(String entryList) {
            BuildersKt.runBlocking(Dispatchers.getIO(), new VideoDownloadClientV2$callback$1$onDownloadError$1(VideoDownloadClientV2.this, entryList, null));
        }

        @Override // video.biz.offline.base.facade.client.IOfflineClient
        public void onServiceTimeout(int startId, int fgsType) {
            VideoDownloadClientV2.this.handleServiceTimeout(startId, fgsType);
        }
    };
    private final BroadcastReceiver broadcastReceiverMediaMounted = new BroadcastReceiver() { // from class: video.biz.offline.base.facade.client.VideoDownloadClientV2$broadcastReceiverMediaMounted$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            LogKt.getVBLog().info("VideoDownloadClientV2 receive broadcast media mounted or unmounted: " + intent.getAction());
            String action = intent.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -1514214344:
                        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                            VideoDownloadClientV2.this.resetAndMigrate();
                            return;
                        }
                        return;
                    case -625887599:
                        if (action.equals("android.intent.action.MEDIA_EJECT")) {
                            VideoDownloadClientV2.this.resetAndMigrate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Application) ctx).registerReceiver(receiver, filter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IOfflineService getServiceProxy() {
        return (IOfflineService) this.serviceProxyFlow.getValue();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        LogKt.getVBLog().info("VideoDownloadClientV2 service connected, client:" + hashCode());
        this.serviceProxyFlow.setValue(IOfflineService.Stub.asInterface(service));
        try {
            IOfflineService $this$onServiceConnected_u24lambda_u240 = getServiceProxy();
            if ($this$onServiceConnected_u24lambda_u240 != null) {
                $this$onServiceConnected_u24lambda_u240.registerClient(this.callback);
                Unit unit = Unit.INSTANCE;
            }
        } catch (RemoteException e$iv) {
            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
        } catch (Exception e$iv2) {
            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        LogKt.getVBLog().info("VideoDownloadClientV2 service disconnected, client:" + hashCode());
        this.serviceProxyFlow.setValue((Object) null);
    }

    private final void bindService(Context context) {
        try {
            context.bindService(new Intent(context, VideoDownloadServiceV2.class), this, 1);
            LogKt.getVBLog().info("VideoDownloadClientV2 bindService, client: " + hashCode());
        } catch (SecurityException e) {
            LogKt.getVBLog().error(String.valueOf(e.getMessage()), e);
        }
    }

    private final void unbindService(Context context) {
        LogKt.getVBLog().info("VideoDownloadClientV2 call unbindService, client:" + hashCode());
        if (getServiceProxy() == null) {
            LogKt.getVBLog().info("VideoDownloadClientV2 not bound, return client:" + hashCode());
            return;
        }
        callUnregisterClient();
        context.unbindService(this);
    }

    private final void callUnregisterClient() {
        try {
            IOfflineService $this$callUnregisterClient_u24lambda_u240 = getServiceProxy();
            if ($this$callUnregisterClient_u24lambda_u240 != null) {
                $this$callUnregisterClient_u24lambda_u240.unregisterClient(this.callback);
                Unit unit = Unit.INSTANCE;
            }
        } catch (RemoteException e$iv) {
            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
        } catch (Exception e$iv2) {
            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
        }
        this.serviceProxyFlow.setValue((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initBind() {
        LogKt.getVBLog().info("VideoDownloadClientV2 init bind service, client: " + hashCode());
        try {
            Companion.startService(FoundationAlias.getFapp());
            bindService(FoundationAlias.getFapp());
        } catch (RemoteException e) {
            IVBLog vBLog = LogKt.getVBLog();
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            vBLog.error(message, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b0 -> B:37:0x00e7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c1 -> B:37:0x00e7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c9 -> B:37:0x00e7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkBind(Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$checkBind$1 videoDownloadClientV2$checkBind$1;
        int i;
        int i2;
        VideoDownloadClientV2 videoDownloadClientV2;
        RemoteException e;
        String message;
        if (continuation instanceof VideoDownloadClientV2$checkBind$1) {
            videoDownloadClientV2$checkBind$1 = (VideoDownloadClientV2$checkBind$1) continuation;
            if ((videoDownloadClientV2$checkBind$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$checkBind$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$checkBind$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$checkBind$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        i = 5;
                        i2 = 0;
                        videoDownloadClientV2 = this;
                        break;
                    case 1:
                        int i3 = videoDownloadClientV2$checkBind$1.I$3;
                        int i4 = videoDownloadClientV2$checkBind$1.I$2;
                        i2 = videoDownloadClientV2$checkBind$1.I$1;
                        i = videoDownloadClientV2$checkBind$1.I$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            videoDownloadClientV2 = this;
                        } catch (RemoteException e2) {
                            e = e2;
                            videoDownloadClientV2 = this;
                            IVBLog vBLog = LogKt.getVBLog();
                            message = e.getMessage();
                            if (message == null) {
                                message = "";
                            }
                            vBLog.error(message, e);
                            i2++;
                            if (i2 < i) {
                            }
                        } catch (TimeoutCancellationException e3) {
                            videoDownloadClientV2 = this;
                            LogKt.getVBLog().error("VideoDownloadClientV2 binding service timed out, client: " + videoDownloadClientV2.hashCode());
                            i2++;
                            if (i2 < i) {
                            }
                        }
                        i2++;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i2 < i) {
                    int it = i2;
                    if (videoDownloadClientV2.getServiceProxy() != null) {
                        return Unit.INSTANCE;
                    }
                    LogKt.getVBLog().info("VideoDownloadClientV2 serviceProxy is null, try to bind service, client: " + videoDownloadClientV2.hashCode());
                    try {
                    } catch (TimeoutCancellationException e4) {
                        LogKt.getVBLog().error("VideoDownloadClientV2 binding service timed out, client: " + videoDownloadClientV2.hashCode());
                        i2++;
                        if (i2 < i) {
                        }
                    } catch (RemoteException e5) {
                        e = e5;
                        IVBLog vBLog2 = LogKt.getVBLog();
                        message = e.getMessage();
                        if (message == null) {
                        }
                        vBLog2.error(message, e);
                        i2++;
                        if (i2 < i) {
                        }
                    }
                    Companion.startService(FoundationAlias.getFapp());
                    videoDownloadClientV2.bindService(FoundationAlias.getFapp());
                    Duration.Companion companion = Duration.Companion;
                    videoDownloadClientV2$checkBind$1.I$0 = i;
                    videoDownloadClientV2$checkBind$1.I$1 = i2;
                    videoDownloadClientV2$checkBind$1.I$2 = it;
                    videoDownloadClientV2$checkBind$1.I$3 = 0;
                    videoDownloadClientV2$checkBind$1.label = 1;
                    if (TimeoutKt.withTimeout-KLykuaI(DurationKt.toDuration(20, DurationUnit.SECONDS), new VideoDownloadClientV2$checkBind$2$1(videoDownloadClientV2, null), videoDownloadClientV2$checkBind$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2++;
                    if (i2 < i) {
                        LogKt.getVBLog().error("VideoDownloadClientV2 failed to bind service after 5 retries, client: " + videoDownloadClientV2.hashCode());
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        videoDownloadClientV2$checkBind$1 = new VideoDownloadClientV2$checkBind$1(this, continuation);
        Object $result2 = videoDownloadClientV2$checkBind$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$checkBind$1.label) {
        }
        if (i2 < i) {
        }
    }

    private final void registerBroadcastReceiver() {
        IntentFilter mediaMountedFilter = new IntentFilter();
        mediaMountedFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        mediaMountedFilter.addAction("android.intent.action.MEDIA_EJECT");
        mediaMountedFilter.addDataScheme("file");
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(FoundationAlias.getFapp(), this.broadcastReceiverMediaMounted, mediaMountedFilter);
    }

    private final void unregisterBroadcastReceiver() {
        FoundationAlias.getFapp().unregisterReceiver(this.broadcastReceiverMediaMounted);
    }

    private final <T> T safeServiceProxyCall(Function1<? super IOfflineService, ? extends T> function1) {
        try {
            IOfflineService serviceProxy = getServiceProxy();
            if (serviceProxy != null) {
                return (T) function1.invoke(serviceProxy);
            }
            return null;
        } catch (RemoteException e) {
            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e.getMessage(), e);
            return null;
        } catch (Exception e2) {
            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e2.getMessage(), e2);
            return null;
        }
    }

    @Override // video.biz.offline.base.facade.IOfflineFacade
    public void init() {
        registerBroadcastReceiver();
        LogKt.getVBLog().info("VideoDownloadClientV2 init");
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new VideoDownloadClientV2$init$1(this, null), 3, (Object) null);
    }

    @Override // video.biz.offline.base.facade.IOfflineFacade
    public void release() {
        LogKt.getVBLog().info("VideoDownloadClientV2 release");
        unregisterBroadcastReceiver();
        if (getServiceProxy() != null) {
            unbindService(FoundationAlias.getFapp());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object checkIfNotInDB(OfflineVideoEntity videoEntity, Continuation<? super Boolean> continuation) {
        VideoDownloadClientV2$checkIfNotInDB$1 videoDownloadClientV2$checkIfNotInDB$1;
        Object checkIfNotInDB;
        if (continuation instanceof VideoDownloadClientV2$checkIfNotInDB$1) {
            videoDownloadClientV2$checkIfNotInDB$1 = (VideoDownloadClientV2$checkIfNotInDB$1) continuation;
            if ((videoDownloadClientV2$checkIfNotInDB$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$checkIfNotInDB$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$checkIfNotInDB$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$checkIfNotInDB$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DataStorageWrapper dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$checkIfNotInDB$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        videoDownloadClientV2$checkIfNotInDB$1.label = 1;
                        checkIfNotInDB = dataStorageWrapper.checkIfNotInDB(videoEntity, videoDownloadClientV2$checkIfNotInDB$1);
                        if (checkIfNotInDB == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) videoDownloadClientV2$checkIfNotInDB$1.L$0;
                        ResultKt.throwOnFailure($result);
                        checkIfNotInDB = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean inDB = ((Boolean) checkIfNotInDB).booleanValue();
                LogKt.getVBLog().info("OfflineFacadeImpl checkIfInDB: " + inDB);
                return Boxing.boxBoolean(inDB);
            }
        }
        videoDownloadClientV2$checkIfNotInDB$1 = new VideoDownloadClientV2$checkIfNotInDB$1(this, continuation);
        Object $result2 = videoDownloadClientV2$checkIfNotInDB$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$checkIfNotInDB$1.label) {
        }
        boolean inDB2 = ((Boolean) checkIfNotInDB).booleanValue();
        LogKt.getVBLog().info("OfflineFacadeImpl checkIfInDB: " + inDB2);
        return Boxing.boxBoolean(inDB2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018a  */
    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object addVideos(List<ResolveParam> list, Continuation<? super Flow<? extends List<OfflineVideoEntity>>> continuation) {
        Continuation<? super Flow<? extends List<OfflineVideoEntity>>> videoDownloadClientV2$addVideos$1;
        Object downloadedVideos;
        Object unDownloadVideos$default;
        Object obj;
        Collection collection;
        List completes;
        List needDownloads;
        List needUpdateItems;
        Object addVideos;
        List needDownloads2;
        List needUpdateItems2;
        List completes2;
        if (continuation instanceof VideoDownloadClientV2$addVideos$1) {
            videoDownloadClientV2$addVideos$1 = (VideoDownloadClientV2$addVideos$1) continuation;
            if ((videoDownloadClientV2$addVideos$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$addVideos$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$addVideos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$addVideos$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 download params: " + list);
                        DataStorageWrapper dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$addVideos$1.L$0 = list;
                        videoDownloadClientV2$addVideos$1.label = 1;
                        downloadedVideos = dataStorageWrapper.getDownloadedVideos(videoDownloadClientV2$addVideos$1);
                        if (downloadedVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Collection collection2 = (Collection) downloadedVideos;
                        DataStorageWrapper dataStorageWrapper2 = this.dataStorage;
                        videoDownloadClientV2$addVideos$1.L$0 = list;
                        videoDownloadClientV2$addVideos$1.L$1 = collection2;
                        videoDownloadClientV2$addVideos$1.label = 2;
                        unDownloadVideos$default = DataStorageWrapper.getUnDownloadVideos$default(dataStorageWrapper2, true, false, 0, videoDownloadClientV2$addVideos$1, 4, null);
                        if (unDownloadVideos$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = unDownloadVideos$default;
                        collection = collection2;
                        completes = CollectionsKt.plus(collection, (Iterable) obj);
                        Pair<List<OfflineVideoEntity>, List<OfflineVideoEntity>> resolveDownloadAndUpdateItems = FacadeExtKt.resolveDownloadAndUpdateItems(list, completes);
                        needDownloads = (List) resolveDownloadAndUpdateItems.component1();
                        needUpdateItems = (List) resolveDownloadAndUpdateItems.component2();
                        if (!needUpdateItems.isEmpty()) {
                            DataStorageWrapper dataStorageWrapper3 = this.dataStorage;
                            videoDownloadClientV2$addVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            videoDownloadClientV2$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(completes);
                            videoDownloadClientV2$addVideos$1.L$2 = needDownloads;
                            videoDownloadClientV2$addVideos$1.L$3 = needUpdateItems;
                            videoDownloadClientV2$addVideos$1.label = 3;
                            if (dataStorageWrapper3.updateVideos(needUpdateItems, true, videoDownloadClientV2$addVideos$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        LogKt.getVBLog().info("VideoDownloadClientV2 download real count: " + needDownloads.size() + ", update count: " + needUpdateItems.size());
                        DataStorageWrapper dataStorageWrapper4 = this.dataStorage;
                        videoDownloadClientV2$addVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(completes);
                        videoDownloadClientV2$addVideos$1.L$2 = needDownloads;
                        videoDownloadClientV2$addVideos$1.L$3 = SpillingKt.nullOutSpilledVariable(needUpdateItems);
                        videoDownloadClientV2$addVideos$1.label = 4;
                        addVideos = dataStorageWrapper4.addVideos(needDownloads, videoDownloadClientV2$addVideos$1);
                        if (addVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List list2 = needDownloads;
                        needDownloads2 = needUpdateItems;
                        needUpdateItems2 = completes;
                        completes2 = list2;
                        Flow flow = (Flow) addVideos;
                        videoDownloadClientV2$addVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(needUpdateItems2);
                        videoDownloadClientV2$addVideos$1.L$2 = SpillingKt.nullOutSpilledVariable(completes2);
                        videoDownloadClientV2$addVideos$1.L$3 = SpillingKt.nullOutSpilledVariable(needDownloads2);
                        videoDownloadClientV2$addVideos$1.L$4 = flow;
                        videoDownloadClientV2$addVideos$1.label = 5;
                        return addDownload(completes2, videoDownloadClientV2$addVideos$1) != coroutine_suspended ? coroutine_suspended : flow;
                    case 1:
                        list = (List) videoDownloadClientV2$addVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        downloadedVideos = $result;
                        Collection collection22 = (Collection) downloadedVideos;
                        DataStorageWrapper dataStorageWrapper22 = this.dataStorage;
                        videoDownloadClientV2$addVideos$1.L$0 = list;
                        videoDownloadClientV2$addVideos$1.L$1 = collection22;
                        videoDownloadClientV2$addVideos$1.label = 2;
                        unDownloadVideos$default = DataStorageWrapper.getUnDownloadVideos$default(dataStorageWrapper22, true, false, 0, videoDownloadClientV2$addVideos$1, 4, null);
                        if (unDownloadVideos$default != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        collection = (Collection) videoDownloadClientV2$addVideos$1.L$1;
                        list = (List) videoDownloadClientV2$addVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        completes = CollectionsKt.plus(collection, (Iterable) obj);
                        Pair<List<OfflineVideoEntity>, List<OfflineVideoEntity>> resolveDownloadAndUpdateItems2 = FacadeExtKt.resolveDownloadAndUpdateItems(list, completes);
                        needDownloads = (List) resolveDownloadAndUpdateItems2.component1();
                        needUpdateItems = (List) resolveDownloadAndUpdateItems2.component2();
                        if (!needUpdateItems.isEmpty()) {
                        }
                        LogKt.getVBLog().info("VideoDownloadClientV2 download real count: " + needDownloads.size() + ", update count: " + needUpdateItems.size());
                        DataStorageWrapper dataStorageWrapper42 = this.dataStorage;
                        videoDownloadClientV2$addVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(completes);
                        videoDownloadClientV2$addVideos$1.L$2 = needDownloads;
                        videoDownloadClientV2$addVideos$1.L$3 = SpillingKt.nullOutSpilledVariable(needUpdateItems);
                        videoDownloadClientV2$addVideos$1.label = 4;
                        addVideos = dataStorageWrapper42.addVideos(needDownloads, videoDownloadClientV2$addVideos$1);
                        if (addVideos == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        needUpdateItems = (List) videoDownloadClientV2$addVideos$1.L$3;
                        needDownloads = (List) videoDownloadClientV2$addVideos$1.L$2;
                        completes = (List) videoDownloadClientV2$addVideos$1.L$1;
                        list = (List) videoDownloadClientV2$addVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 download real count: " + needDownloads.size() + ", update count: " + needUpdateItems.size());
                        DataStorageWrapper dataStorageWrapper422 = this.dataStorage;
                        videoDownloadClientV2$addVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(completes);
                        videoDownloadClientV2$addVideos$1.L$2 = needDownloads;
                        videoDownloadClientV2$addVideos$1.L$3 = SpillingKt.nullOutSpilledVariable(needUpdateItems);
                        videoDownloadClientV2$addVideos$1.label = 4;
                        addVideos = dataStorageWrapper422.addVideos(needDownloads, videoDownloadClientV2$addVideos$1);
                        if (addVideos == coroutine_suspended) {
                        }
                        break;
                    case 4:
                        List needDownloads3 = (List) videoDownloadClientV2$addVideos$1.L$2;
                        list = (List) videoDownloadClientV2$addVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        addVideos = $result;
                        needDownloads2 = (List) videoDownloadClientV2$addVideos$1.L$3;
                        needUpdateItems2 = (List) videoDownloadClientV2$addVideos$1.L$1;
                        completes2 = needDownloads3;
                        Flow flow2 = (Flow) addVideos;
                        videoDownloadClientV2$addVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(needUpdateItems2);
                        videoDownloadClientV2$addVideos$1.L$2 = SpillingKt.nullOutSpilledVariable(completes2);
                        videoDownloadClientV2$addVideos$1.L$3 = SpillingKt.nullOutSpilledVariable(needDownloads2);
                        videoDownloadClientV2$addVideos$1.L$4 = flow2;
                        videoDownloadClientV2$addVideos$1.label = 5;
                        if (addDownload(completes2, videoDownloadClientV2$addVideos$1) != coroutine_suspended) {
                        }
                        break;
                    case 5:
                        Flow flow3 = (Flow) videoDownloadClientV2$addVideos$1.L$4;
                        List list3 = (List) videoDownloadClientV2$addVideos$1.L$3;
                        List list4 = (List) videoDownloadClientV2$addVideos$1.L$2;
                        List list5 = (List) videoDownloadClientV2$addVideos$1.L$1;
                        List list6 = (List) videoDownloadClientV2$addVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return flow3;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$addVideos$1 = new VideoDownloadClientV2$addVideos$1(this, continuation);
        Object $result2 = videoDownloadClientV2$addVideos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$addVideos$1.label) {
        }
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Flow<List<OfflineVideoEntity>> getAllVideosFlow() {
        return this.dataStorage.getAllVideosFlow();
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getAllVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getAllVideos(continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Flow<List<OfflineVideoEntity>> getVideosFlowByGroupId(long groupId, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        return this.dataStorage.getVideosFlowByGroupId(groupId, keyword);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getVideosByGroupId(long groupId, String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getVideosByGroupId(groupId, keyword, continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Flow<List<OfflineVideoEntity>> getVideosFlowByVideoId(long videoId, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        return this.dataStorage.getVideosFlowByVideoId(videoId, keyword);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getVideosByVideoId(long videoId, String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getVideosByVideoId(videoId, keyword, continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getDownloadedVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getDownloadedVideos(continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getDownloadingVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getDownloadingVideos(continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getUnDownloadVideos(boolean includePause, boolean includeError, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return DataStorageWrapper.getUnDownloadVideos$default(this.dataStorage, includePause, includeError, 0, continuation, 4, null);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Flow<List<OfflineVideoEntity>> getVideosFlowByPageId(long pageId) {
        return this.dataStorage.getVideosFlowByPageId(pageId);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getVideosByPageId(long pageId, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getVideosByPageId(pageId, continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getVideoByKey(String key, Continuation<? super OfflineVideoEntity> continuation) {
        return this.dataStorage.getVideoByKey(key, continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object getVideosByKeys(List<String> list, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.getVideosByKeys(list, continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object search(String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return this.dataStorage.search(keyword, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084 A[Catch: Exception -> 0x008c, RemoteException -> 0x00af, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00af, Exception -> 0x008c, blocks: (B:23:0x007e, B:25:0x0084), top: B:39:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f5 A[RETURN] */
    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object removeVideo(List<String> list, Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$removeVideo$1 videoDownloadClientV2$removeVideo$1;
        DataStorageWrapper dataStorageWrapper;
        IOfflineService $this$removeVideo_u24lambda_u240;
        if (continuation instanceof VideoDownloadClientV2$removeVideo$1) {
            videoDownloadClientV2$removeVideo$1 = (VideoDownloadClientV2$removeVideo$1) continuation;
            if ((videoDownloadClientV2$removeVideo$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$removeVideo$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$removeVideo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$removeVideo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (list.isEmpty()) {
                            return Unit.INSTANCE;
                        }
                        LogKt.getVBLog().info("VideoDownloadClientV2 do remove, keys: " + list);
                        videoDownloadClientV2$removeVideo$1.L$0 = list;
                        videoDownloadClientV2$removeVideo$1.label = 1;
                        if (checkBind(videoDownloadClientV2$removeVideo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            $this$removeVideo_u24lambda_u240 = getServiceProxy();
                            if ($this$removeVideo_u24lambda_u240 != null) {
                                $this$removeVideo_u24lambda_u240.stopDownload(list, true);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (RemoteException e$iv) {
                            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                        } catch (Exception e$iv2) {
                            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
                        }
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$removeVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$removeVideo$1.label = 2;
                        if (dataStorageWrapper.removeVideo(list, videoDownloadClientV2$removeVideo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        videoDownloadClientV2$removeVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$removeVideo$1.label = 3;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$removeVideo$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        list = (List) videoDownloadClientV2$removeVideo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$removeVideo_u24lambda_u240 = getServiceProxy();
                        if ($this$removeVideo_u24lambda_u240 != null) {
                        }
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$removeVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$removeVideo$1.label = 2;
                        if (dataStorageWrapper.removeVideo(list, videoDownloadClientV2$removeVideo$1) == coroutine_suspended) {
                        }
                        videoDownloadClientV2$removeVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$removeVideo$1.label = 3;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$removeVideo$1, 1, null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        list = (List) videoDownloadClientV2$removeVideo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videoDownloadClientV2$removeVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        videoDownloadClientV2$removeVideo$1.label = 3;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$removeVideo$1, 1, null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        List list2 = (List) videoDownloadClientV2$removeVideo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$removeVideo$1 = new VideoDownloadClientV2$removeVideo$1(this, continuation);
        Object $result2 = videoDownloadClientV2$removeVideo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$removeVideo$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addDownload(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
        LogKt.getVBLog().info("VideoDownloadClientV2 add download called, downloadVideosIfNeed");
        Object downloadVideosIfNeed = downloadVideosIfNeed(list, continuation);
        return downloadVideosIfNeed == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? downloadVideosIfNeed : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5 A[LOOP:1: B:35:0x00df->B:37:0x00e5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012f A[Catch: Exception -> 0x013a, RemoteException -> 0x015b, TRY_LEAVE, TryCatch #6 {RemoteException -> 0x015b, Exception -> 0x013a, blocks: (B:47:0x0129, B:49:0x012f), top: B:98:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0277 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0278  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadVideosIfNeed(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$downloadVideosIfNeed$1 videoDownloadClientV2$downloadVideosIfNeed$1;
        VideoDownloadClientV2$downloadVideosIfNeed$1 videoDownloadClientV2$downloadVideosIfNeed$12;
        List<OfflineVideoEntity> list2;
        List<OfflineVideoEntity> list3;
        Object obj;
        DataStorageWrapper dataStorageWrapper;
        List<OfflineVideoEntity> list4;
        List<OfflineVideoEntity> list5;
        List<OfflineVideoEntity> list6;
        List<OfflineVideoEntity> list7;
        Integer count;
        IOfflineService $this$downloadVideosIfNeed_u24lambda_u242;
        if (continuation instanceof VideoDownloadClientV2$downloadVideosIfNeed$1) {
            videoDownloadClientV2$downloadVideosIfNeed$1 = (VideoDownloadClientV2$downloadVideosIfNeed$1) continuation;
            if ((videoDownloadClientV2$downloadVideosIfNeed$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$downloadVideosIfNeed$1.label -= Integer.MIN_VALUE;
                videoDownloadClientV2$downloadVideosIfNeed$12 = videoDownloadClientV2$downloadVideosIfNeed$1;
                Object $result = videoDownloadClientV2$downloadVideosIfNeed$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$downloadVideosIfNeed$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (this.processing) {
                            LogKt.getVBLog().info("VideoDownloadClientV2 downloadVideosIfNeed is processing, return");
                            return Unit.INSTANCE;
                        } else if (list == null) {
                            DataStorageWrapper dataStorageWrapper2 = this.dataStorage;
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            videoDownloadClientV2$downloadVideosIfNeed$12.label = 1;
                            Object unDownloadVideos = dataStorageWrapper2.getUnDownloadVideos(false, false, 10, videoDownloadClientV2$downloadVideosIfNeed$12);
                            if (unDownloadVideos == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = unDownloadVideos;
                            list2 = list;
                            Iterable $this$filter$iv = (Iterable) obj;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
                                if (!(it.getState() instanceof OfflineVideoEntity.State.DOWNLOADING)) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            list3 = (List) destination$iv$iv;
                            Iterable $this$forEach$iv = list3;
                            for (Object element$iv : $this$forEach$iv) {
                                OfflineVideoEntity it2 = (OfflineVideoEntity) element$iv;
                                it2.setState(OfflineVideoEntity.State.PENDING.INSTANCE);
                            }
                            dataStorageWrapper = this.dataStorage;
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = list3;
                            videoDownloadClientV2$downloadVideosIfNeed$12.label = 2;
                            if (dataStorageWrapper.updateVideos(list3, true, videoDownloadClientV2$downloadVideosIfNeed$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            List<OfflineVideoEntity> list8 = list3;
                            list4 = list2;
                            list5 = list8;
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = list5;
                            videoDownloadClientV2$downloadVideosIfNeed$12.label = 3;
                            if (checkBind(videoDownloadClientV2$downloadVideosIfNeed$12) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list6 = list4;
                            list7 = list5;
                            Integer num = null;
                            try {
                                $this$downloadVideosIfNeed_u24lambda_u242 = getServiceProxy();
                                if ($this$downloadVideosIfNeed_u24lambda_u242 != null) {
                                    num = Boxing.boxInt($this$downloadVideosIfNeed_u24lambda_u242.getCurrentTaskCount());
                                }
                            } catch (RemoteException e$iv) {
                                LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                            } catch (Exception e$iv2) {
                                LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
                            }
                            count = num;
                            if (count != null) {
                                LogKt.getVBLog().error("VideoDownloadClientV2 downloadVideosIfNeed count is null");
                                return Unit.INSTANCE;
                            }
                            LogKt.getVBLog().info("VideoDownloadClientV2 downloadVideosIfNeed size:" + list7.size() + " count:" + count);
                            if (count.intValue() < 10) {
                                try {
                                    IOfflineService $this$downloadVideosIfNeed_u24lambda_u243 = getServiceProxy();
                                    if ($this$downloadVideosIfNeed_u24lambda_u243 != null) {
                                        StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
                                        Object value$iv = CollectionsKt.take(list7, 10 - count.intValue());
                                        $this$encodeToString$iv.getSerializersModule();
                                        try {
                                            try {
                                                $this$downloadVideosIfNeed_u24lambda_u243.addDownload($this$encodeToString$iv.encodeToString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), value$iv));
                                                Unit unit = Unit.INSTANCE;
                                            } catch (RemoteException e) {
                                                e$iv = e;
                                                LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = SpillingKt.nullOutSpilledVariable(list7);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.L$2 = SpillingKt.nullOutSpilledVariable(count);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.label = 4;
                                                if (notifyDownloadCountChanged(videoDownloadClientV2$downloadVideosIfNeed$12) == coroutine_suspended) {
                                                }
                                            } catch (Exception e2) {
                                                e$iv = e2;
                                                LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv.getMessage(), e$iv);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = SpillingKt.nullOutSpilledVariable(list7);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.L$2 = SpillingKt.nullOutSpilledVariable(count);
                                                videoDownloadClientV2$downloadVideosIfNeed$12.label = 4;
                                                if (notifyDownloadCountChanged(videoDownloadClientV2$downloadVideosIfNeed$12) == coroutine_suspended) {
                                                }
                                            }
                                        } catch (RemoteException e3) {
                                            e$iv = e3;
                                        } catch (Exception e4) {
                                            e$iv = e4;
                                        }
                                    }
                                } catch (RemoteException e5) {
                                    e$iv = e5;
                                } catch (Exception e6) {
                                    e$iv = e6;
                                }
                            }
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = SpillingKt.nullOutSpilledVariable(list7);
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$2 = SpillingKt.nullOutSpilledVariable(count);
                            videoDownloadClientV2$downloadVideosIfNeed$12.label = 4;
                            return notifyDownloadCountChanged(videoDownloadClientV2$downloadVideosIfNeed$12) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        } else {
                            list2 = list;
                            list3 = list2;
                            Iterable $this$forEach$iv2 = list3;
                            while (r11.hasNext()) {
                            }
                            dataStorageWrapper = this.dataStorage;
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = list3;
                            videoDownloadClientV2$downloadVideosIfNeed$12.label = 2;
                            if (dataStorageWrapper.updateVideos(list3, true, videoDownloadClientV2$downloadVideosIfNeed$12) == coroutine_suspended) {
                            }
                        }
                    case 1:
                        list2 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        Iterable $this$filter$iv2 = (Iterable) obj;
                        Collection destination$iv$iv2 = new ArrayList();
                        while (r15.hasNext()) {
                        }
                        list3 = (List) destination$iv$iv2;
                        Iterable $this$forEach$iv22 = list3;
                        while (r11.hasNext()) {
                        }
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                        videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = list3;
                        videoDownloadClientV2$downloadVideosIfNeed$12.label = 2;
                        if (dataStorageWrapper.updateVideos(list3, true, videoDownloadClientV2$downloadVideosIfNeed$12) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        list5 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$1;
                        list4 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$0;
                        ResultKt.throwOnFailure($result);
                        videoDownloadClientV2$downloadVideosIfNeed$12.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                        videoDownloadClientV2$downloadVideosIfNeed$12.L$1 = list5;
                        videoDownloadClientV2$downloadVideosIfNeed$12.label = 3;
                        if (checkBind(videoDownloadClientV2$downloadVideosIfNeed$12) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        list6 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$0;
                        list7 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$1;
                        Integer num2 = null;
                        $this$downloadVideosIfNeed_u24lambda_u242 = getServiceProxy();
                        if ($this$downloadVideosIfNeed_u24lambda_u242 != null) {
                        }
                        count = num2;
                        if (count != null) {
                        }
                        break;
                    case 4:
                        Integer num3 = (Integer) videoDownloadClientV2$downloadVideosIfNeed$12.L$2;
                        List list9 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$1;
                        List list10 = (List) videoDownloadClientV2$downloadVideosIfNeed$12.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$downloadVideosIfNeed$1 = new VideoDownloadClientV2$downloadVideosIfNeed$1(this, continuation);
        videoDownloadClientV2$downloadVideosIfNeed$12 = videoDownloadClientV2$downloadVideosIfNeed$1;
        Object $result2 = videoDownloadClientV2$downloadVideosIfNeed$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$downloadVideosIfNeed$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object downloadVideosIfNeed$default(VideoDownloadClientV2 videoDownloadClientV2, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return videoDownloadClientV2.downloadVideosIfNeed(list, continuation);
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public List<StorageInfoModel> getStorageInfo() {
        return this.dataStorage.getStorageInfo();
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public void resetMigrate() {
        this.dataStorage.resetMigrate();
    }

    @Override // video.biz.offline.base.facade.protocol.IDataStorage
    public Object updateAuthCode(List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation) {
        Object updateAuthCode = this.dataStorage.updateAuthCode(list, continuation);
        return updateAuthCode == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateAuthCode : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090 A[Catch: Exception -> 0x009c, RemoteException -> 0x00bf, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00bf, Exception -> 0x009c, blocks: (B:20:0x008a, B:22:0x0090), top: B:42:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014d A[RETURN] */
    @Override // video.biz.offline.base.facade.protocol.IOperationList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object pause(String key, Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$pause$1 videoDownloadClientV2$pause$1;
        Object videoByKey;
        IOfflineService $this$pause_u24lambda_u240;
        OfflineVideoEntity it;
        if (continuation instanceof VideoDownloadClientV2$pause$1) {
            videoDownloadClientV2$pause$1 = (VideoDownloadClientV2$pause$1) continuation;
            if ((videoDownloadClientV2$pause$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$pause$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$pause$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$pause$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 pause key: " + key);
                        this.processing = true;
                        videoDownloadClientV2$pause$1.L$0 = key;
                        videoDownloadClientV2$pause$1.label = 1;
                        if (checkBind(videoDownloadClientV2$pause$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            $this$pause_u24lambda_u240 = getServiceProxy();
                            if ($this$pause_u24lambda_u240 != null) {
                                $this$pause_u24lambda_u240.stopDownload(CollectionsKt.listOf(key), false);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (RemoteException e$iv) {
                            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                        } catch (Exception e$iv2) {
                            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
                        }
                        DataStorageWrapper dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$pause$1.L$0 = key;
                        videoDownloadClientV2$pause$1.label = 2;
                        videoByKey = dataStorageWrapper.getVideoByKey(key, videoDownloadClientV2$pause$1);
                        if (videoByKey == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = (OfflineVideoEntity) videoByKey;
                        if (it != null) {
                            it.setState(DataStorageWrapperKt.videoPauseState$default(it, null, 1, null));
                            DataStorageWrapper dataStorageWrapper2 = this.dataStorage;
                            List<OfflineVideoEntity> listOf = CollectionsKt.listOf(it);
                            videoDownloadClientV2$pause$1.L$0 = key;
                            videoDownloadClientV2$pause$1.L$1 = SpillingKt.nullOutSpilledVariable(it);
                            videoDownloadClientV2$pause$1.I$0 = 0;
                            videoDownloadClientV2$pause$1.label = 3;
                            if (dataStorageWrapper2.updateVideos(listOf, true, videoDownloadClientV2$pause$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        LogKt.getVBLog().info("VideoDownloadClientV2 pause " + key + " download next, downloadVideosIfNeed");
                        this.processing = false;
                        videoDownloadClientV2$pause$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        videoDownloadClientV2$pause$1.L$1 = null;
                        videoDownloadClientV2$pause$1.label = 4;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$pause$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        key = (String) videoDownloadClientV2$pause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$pause_u24lambda_u240 = getServiceProxy();
                        if ($this$pause_u24lambda_u240 != null) {
                        }
                        DataStorageWrapper dataStorageWrapper3 = this.dataStorage;
                        videoDownloadClientV2$pause$1.L$0 = key;
                        videoDownloadClientV2$pause$1.label = 2;
                        videoByKey = dataStorageWrapper3.getVideoByKey(key, videoDownloadClientV2$pause$1);
                        if (videoByKey == coroutine_suspended) {
                        }
                        it = (OfflineVideoEntity) videoByKey;
                        if (it != null) {
                        }
                        LogKt.getVBLog().info("VideoDownloadClientV2 pause " + key + " download next, downloadVideosIfNeed");
                        this.processing = false;
                        videoDownloadClientV2$pause$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        videoDownloadClientV2$pause$1.L$1 = null;
                        videoDownloadClientV2$pause$1.label = 4;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$pause$1, 1, null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        key = (String) videoDownloadClientV2$pause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videoByKey = $result;
                        it = (OfflineVideoEntity) videoByKey;
                        if (it != null) {
                        }
                        LogKt.getVBLog().info("VideoDownloadClientV2 pause " + key + " download next, downloadVideosIfNeed");
                        this.processing = false;
                        videoDownloadClientV2$pause$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        videoDownloadClientV2$pause$1.L$1 = null;
                        videoDownloadClientV2$pause$1.label = 4;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$pause$1, 1, null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        int i = videoDownloadClientV2$pause$1.I$0;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) videoDownloadClientV2$pause$1.L$1;
                        key = (String) videoDownloadClientV2$pause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 pause " + key + " download next, downloadVideosIfNeed");
                        this.processing = false;
                        videoDownloadClientV2$pause$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        videoDownloadClientV2$pause$1.L$1 = null;
                        videoDownloadClientV2$pause$1.label = 4;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$pause$1, 1, null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 4:
                        String str = (String) videoDownloadClientV2$pause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$pause$1 = new VideoDownloadClientV2$pause$1(this, continuation);
        Object $result2 = videoDownloadClientV2$pause$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$pause$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c A[Catch: Exception -> 0x0094, RemoteException -> 0x00b7, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00b7, Exception -> 0x0094, blocks: (B:20:0x0086, B:22:0x008c), top: B:58:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015b A[LOOP:1: B:45:0x0155->B:47:0x015b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0198 A[LOOP:2: B:49:0x0192->B:51:0x0198, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01dc  */
    @Override // video.biz.offline.base.facade.protocol.IOperationList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object pauseAll(PauseType type, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> videoDownloadClientV2$pauseAll$1;
        PauseType type2;
        Object unDownloadVideos$default;
        IOfflineService $this$pauseAll_u24lambda_u240;
        List videos;
        DataStorageWrapper dataStorageWrapper;
        if (continuation instanceof VideoDownloadClientV2$pauseAll$1) {
            videoDownloadClientV2$pauseAll$1 = (VideoDownloadClientV2$pauseAll$1) continuation;
            if ((videoDownloadClientV2$pauseAll$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$pauseAll$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$pauseAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$pauseAll$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 pause all videos, type: " + type);
                        this.processing = true;
                        videoDownloadClientV2$pauseAll$1.L$0 = type;
                        videoDownloadClientV2$pauseAll$1.label = 1;
                        if (checkBind(videoDownloadClientV2$pauseAll$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        type2 = type;
                        try {
                            $this$pauseAll_u24lambda_u240 = getServiceProxy();
                            if ($this$pauseAll_u24lambda_u240 != null) {
                                $this$pauseAll_u24lambda_u240.stopAll();
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (RemoteException e$iv) {
                            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                        } catch (Exception e$iv2) {
                            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
                        }
                        DataStorageWrapper dataStorageWrapper2 = this.dataStorage;
                        videoDownloadClientV2$pauseAll$1.L$0 = type2;
                        videoDownloadClientV2$pauseAll$1.label = 2;
                        unDownloadVideos$default = DataStorageWrapper.getUnDownloadVideos$default(dataStorageWrapper2, true, true, 0, videoDownloadClientV2$pauseAll$1, 4, null);
                        if (unDownloadVideos$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Iterable $this$filter$iv = (Iterable) unDownloadVideos$default;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
                            int errorCode = OfflineError.INSTANCE.getErrorNumber(it.getErrorCode());
                            Iterable $this$filter$iv2 = $this$filter$iv;
                            if (it.getStateValue() != 6 || errorCode == DownloadErrorType.NETWORK_DISCONNECT.getCode()) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv2;
                        }
                        videos = (List) destination$iv$iv;
                        List $this$map$iv = videos;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            OfflineVideoEntity it2 = (OfflineVideoEntity) item$iv$iv;
                            it2.setState(DataStorageWrapperKt.videoPauseState(it2, type2));
                            destination$iv$iv2.add(Unit.INSTANCE);
                        }
                        ArrayList arrayList = (List) destination$iv$iv2;
                        IVBLog vBLog = LogKt.getVBLog();
                        List $this$map$iv2 = videos;
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        for (Object item$iv$iv2 : $this$map$iv2) {
                            destination$iv$iv3.add(((OfflineVideoEntity) item$iv$iv2).getKey());
                        }
                        vBLog.info("VideoDownloadClientV2 downloadVideosIfNeed pause all " + ((List) destination$iv$iv3));
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$pauseAll$1.L$0 = SpillingKt.nullOutSpilledVariable(type2);
                        videoDownloadClientV2$pauseAll$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                        videoDownloadClientV2$pauseAll$1.label = 3;
                        if (dataStorageWrapper.updateVideos(videos, true, videoDownloadClientV2$pauseAll$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.processing = false;
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        type2 = (PauseType) videoDownloadClientV2$pauseAll$1.L$0;
                        $this$pauseAll_u24lambda_u240 = getServiceProxy();
                        if ($this$pauseAll_u24lambda_u240 != null) {
                        }
                        DataStorageWrapper dataStorageWrapper22 = this.dataStorage;
                        videoDownloadClientV2$pauseAll$1.L$0 = type2;
                        videoDownloadClientV2$pauseAll$1.label = 2;
                        unDownloadVideos$default = DataStorageWrapper.getUnDownloadVideos$default(dataStorageWrapper22, true, true, 0, videoDownloadClientV2$pauseAll$1, 4, null);
                        if (unDownloadVideos$default == coroutine_suspended) {
                        }
                        Iterable $this$filter$iv3 = (Iterable) unDownloadVideos$default;
                        Collection destination$iv$iv4 = new ArrayList();
                        while (r8.hasNext()) {
                        }
                        videos = (List) destination$iv$iv4;
                        List $this$map$iv3 = videos;
                        Collection destination$iv$iv22 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        while (r10.hasNext()) {
                        }
                        ArrayList arrayList2 = (List) destination$iv$iv22;
                        IVBLog vBLog2 = LogKt.getVBLog();
                        List $this$map$iv22 = videos;
                        Collection destination$iv$iv32 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10));
                        while (r10.hasNext()) {
                        }
                        vBLog2.info("VideoDownloadClientV2 downloadVideosIfNeed pause all " + ((List) destination$iv$iv32));
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$pauseAll$1.L$0 = SpillingKt.nullOutSpilledVariable(type2);
                        videoDownloadClientV2$pauseAll$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                        videoDownloadClientV2$pauseAll$1.label = 3;
                        if (dataStorageWrapper.updateVideos(videos, true, videoDownloadClientV2$pauseAll$1) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        type2 = (PauseType) videoDownloadClientV2$pauseAll$1.L$0;
                        unDownloadVideos$default = $result;
                        Iterable $this$filter$iv32 = (Iterable) unDownloadVideos$default;
                        Collection destination$iv$iv42 = new ArrayList();
                        while (r8.hasNext()) {
                        }
                        videos = (List) destination$iv$iv42;
                        List $this$map$iv32 = videos;
                        Collection destination$iv$iv222 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv32, 10));
                        while (r10.hasNext()) {
                        }
                        ArrayList arrayList22 = (List) destination$iv$iv222;
                        IVBLog vBLog22 = LogKt.getVBLog();
                        List $this$map$iv222 = videos;
                        Collection destination$iv$iv322 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv222, 10));
                        while (r10.hasNext()) {
                        }
                        vBLog22.info("VideoDownloadClientV2 downloadVideosIfNeed pause all " + ((List) destination$iv$iv322));
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$pauseAll$1.L$0 = SpillingKt.nullOutSpilledVariable(type2);
                        videoDownloadClientV2$pauseAll$1.L$1 = SpillingKt.nullOutSpilledVariable(videos);
                        videoDownloadClientV2$pauseAll$1.label = 3;
                        if (dataStorageWrapper.updateVideos(videos, true, videoDownloadClientV2$pauseAll$1) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        List list = (List) videoDownloadClientV2$pauseAll$1.L$1;
                        PauseType pauseType = (PauseType) videoDownloadClientV2$pauseAll$1.L$0;
                        ResultKt.throwOnFailure($result);
                        this.processing = false;
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$pauseAll$1 = new VideoDownloadClientV2$pauseAll$1(this, continuation);
        Object $result2 = videoDownloadClientV2$pauseAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$pauseAll$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    @Override // video.biz.offline.base.facade.protocol.IOperationList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object start(String key, Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$start$1 videoDownloadClientV2$start$1;
        Object videoByKey;
        OfflineVideoEntity it;
        if (continuation instanceof VideoDownloadClientV2$start$1) {
            videoDownloadClientV2$start$1 = (VideoDownloadClientV2$start$1) continuation;
            if ((videoDownloadClientV2$start$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$start$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$start$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$start$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 start key: " + key);
                        DataStorageWrapper dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$start$1.L$0 = key;
                        videoDownloadClientV2$start$1.label = 1;
                        videoByKey = dataStorageWrapper.getVideoByKey(key, videoDownloadClientV2$start$1);
                        if (videoByKey == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = (OfflineVideoEntity) videoByKey;
                        if (it != null) {
                            LogKt.getVBLog().info("VideoDownloadClientV2 downloadVideosIfNeed  start one " + key + " download next");
                            List<OfflineVideoEntity> listOf = CollectionsKt.listOf(it);
                            videoDownloadClientV2$start$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                            videoDownloadClientV2$start$1.L$1 = SpillingKt.nullOutSpilledVariable(it);
                            videoDownloadClientV2$start$1.I$0 = 0;
                            videoDownloadClientV2$start$1.label = 2;
                            if (downloadVideosIfNeed(listOf, videoDownloadClientV2$start$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        key = (String) videoDownloadClientV2$start$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videoByKey = $result;
                        it = (OfflineVideoEntity) videoByKey;
                        if (it != null) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        int i = videoDownloadClientV2$start$1.I$0;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) videoDownloadClientV2$start$1.L$1;
                        String str = (String) videoDownloadClientV2$start$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$start$1 = new VideoDownloadClientV2$start$1(this, continuation);
        Object $result2 = videoDownloadClientV2$start$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$start$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b A[RETURN] */
    @Override // video.biz.offline.base.facade.protocol.IOperationList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startAll(Continuation<? super Unit> continuation) {
        Continuation<? super Unit> videoDownloadClientV2$startAll$1;
        Object unDownloadVideos$default;
        List videos;
        if (continuation instanceof VideoDownloadClientV2$startAll$1) {
            videoDownloadClientV2$startAll$1 = (VideoDownloadClientV2$startAll$1) continuation;
            if ((videoDownloadClientV2$startAll$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$startAll$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$startAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$startAll$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DataStorageWrapper dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$startAll$1.label = 1;
                        unDownloadVideos$default = DataStorageWrapper.getUnDownloadVideos$default(dataStorageWrapper, true, true, 0, videoDownloadClientV2$startAll$1, 4, null);
                        if (unDownloadVideos$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Iterable $this$sortedBy$iv = (Iterable) unDownloadVideos$default;
                        videos = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: video.biz.offline.base.facade.client.VideoDownloadClientV2$startAll$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                OfflineVideoEntity it = (OfflineVideoEntity) t;
                                OfflineVideoEntity it2 = (OfflineVideoEntity) t2;
                                return ComparisonsKt.compareValues(Long.valueOf(it.getCreateTime()), Long.valueOf(it2.getCreateTime()));
                            }
                        });
                        LogKt.getVBLog().info("VideoDownloadClientV2 downloadVideosIfNeed  start all videos size: " + videos.size());
                        videoDownloadClientV2$startAll$1.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                        videoDownloadClientV2$startAll$1.label = 2;
                        if (downloadVideosIfNeed(videos, videoDownloadClientV2$startAll$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        unDownloadVideos$default = $result;
                        Iterable $this$sortedBy$iv2 = (Iterable) unDownloadVideos$default;
                        videos = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: video.biz.offline.base.facade.client.VideoDownloadClientV2$startAll$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                OfflineVideoEntity it = (OfflineVideoEntity) t;
                                OfflineVideoEntity it2 = (OfflineVideoEntity) t2;
                                return ComparisonsKt.compareValues(Long.valueOf(it.getCreateTime()), Long.valueOf(it2.getCreateTime()));
                            }
                        });
                        LogKt.getVBLog().info("VideoDownloadClientV2 downloadVideosIfNeed  start all videos size: " + videos.size());
                        videoDownloadClientV2$startAll$1.L$0 = SpillingKt.nullOutSpilledVariable(videos);
                        videoDownloadClientV2$startAll$1.label = 2;
                        if (downloadVideosIfNeed(videos, videoDownloadClientV2$startAll$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        List list = (List) videoDownloadClientV2$startAll$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$startAll$1 = new VideoDownloadClientV2$startAll$1(this, continuation);
        Object $result2 = videoDownloadClientV2$startAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$startAll$1.label) {
        }
    }

    @Override // video.biz.offline.base.facade.protocol.IOperationList
    public void updateDanmaku(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "keys");
        LogKt.getVBLog().info("VideoDownloadClientV2 updateDanmaku called, keys: " + list);
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new VideoDownloadClientV2$updateDanmaku$1(this, list, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0 A[Catch: Exception -> 0x00b8, RemoteException -> 0x00da, TRY_LEAVE, TryCatch #3 {RemoteException -> 0x00da, Exception -> 0x00b8, blocks: (B:21:0x00aa, B:23:0x00b0), top: B:73:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0162 A[LOOP:0: B:47:0x015c->B:49:0x0162, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ba A[Catch: Exception -> 0x01c1, RemoteException -> 0x01e2, TRY_LEAVE, TryCatch #4 {RemoteException -> 0x01e2, Exception -> 0x01c1, blocks: (B:57:0x01b4, B:59:0x01ba), top: B:71:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0224 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0225  */
    @Override // video.biz.offline.base.facade.protocol.IOperationList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setMaxConcurrent(int max, Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$setMaxConcurrent$1 videoDownloadClientV2$setMaxConcurrent$1;
        int excess;
        List list;
        int excess2;
        List<String> takeLast;
        List downloading;
        List<String> list2;
        Object videosByKeys;
        List downloading2;
        int max2;
        int excess3;
        List needPending;
        DataStorageWrapper dataStorageWrapper;
        IOfflineService $this$setMaxConcurrent_u24lambda_u242;
        if (continuation instanceof VideoDownloadClientV2$setMaxConcurrent$1) {
            videoDownloadClientV2$setMaxConcurrent$1 = (VideoDownloadClientV2$setMaxConcurrent$1) continuation;
            if ((videoDownloadClientV2$setMaxConcurrent$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$setMaxConcurrent$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$setMaxConcurrent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$setMaxConcurrent$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 setMaxConcurrent : " + max);
                        this.processing = true;
                        videoDownloadClientV2$setMaxConcurrent$1.I$0 = max;
                        videoDownloadClientV2$setMaxConcurrent$1.label = 1;
                        if (checkBind(videoDownloadClientV2$setMaxConcurrent$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        excess = max;
                        try {
                            IOfflineService $this$setMaxConcurrent_u24lambda_u240 = getServiceProxy();
                            list = $this$setMaxConcurrent_u24lambda_u240 == null ? $this$setMaxConcurrent_u24lambda_u240.getDownloadingKeys() : null;
                        } catch (RemoteException e$iv) {
                            LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv.getMessage(), e$iv);
                            list = null;
                        } catch (Exception e$iv2) {
                            LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv2.getMessage(), e$iv2);
                            list = null;
                        }
                        if (list == null) {
                            list = CollectionsKt.emptyList();
                        }
                        List downloading3 = list;
                        excess2 = excess >= Config.Companion.getMaxConcurrent() ? downloading3.size() - excess : 0;
                        takeLast = excess2 <= 0 ? CollectionsKt.takeLast(downloading3, excess2) : CollectionsKt.emptyList();
                        if (takeLast.isEmpty()) {
                            DataStorageWrapper dataStorageWrapper2 = this.dataStorage;
                            videoDownloadClientV2$setMaxConcurrent$1.L$0 = SpillingKt.nullOutSpilledVariable(downloading3);
                            videoDownloadClientV2$setMaxConcurrent$1.L$1 = takeLast;
                            videoDownloadClientV2$setMaxConcurrent$1.I$0 = excess;
                            videoDownloadClientV2$setMaxConcurrent$1.I$1 = excess2;
                            videoDownloadClientV2$setMaxConcurrent$1.label = 2;
                            videosByKeys = dataStorageWrapper2.getVideosByKeys(takeLast, videoDownloadClientV2$setMaxConcurrent$1);
                            if (videosByKeys == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            downloading2 = downloading3;
                            max2 = excess;
                            excess3 = excess2;
                            needPending = (List) videosByKeys;
                            List $this$map$iv = needPending;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                OfflineVideoEntity it = (OfflineVideoEntity) item$iv$iv;
                                it.setState(OfflineVideoEntity.State.PENDING.INSTANCE);
                                destination$iv$iv.add(Unit.INSTANCE);
                                $result = $result;
                            }
                            ArrayList arrayList = (List) destination$iv$iv;
                            dataStorageWrapper = this.dataStorage;
                            videoDownloadClientV2$setMaxConcurrent$1.L$0 = SpillingKt.nullOutSpilledVariable(downloading2);
                            videoDownloadClientV2$setMaxConcurrent$1.L$1 = takeLast;
                            videoDownloadClientV2$setMaxConcurrent$1.L$2 = SpillingKt.nullOutSpilledVariable(needPending);
                            videoDownloadClientV2$setMaxConcurrent$1.I$0 = max2;
                            videoDownloadClientV2$setMaxConcurrent$1.I$1 = excess3;
                            videoDownloadClientV2$setMaxConcurrent$1.label = 3;
                            if (dataStorageWrapper.updateVideos(needPending, true, videoDownloadClientV2$setMaxConcurrent$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            list2 = takeLast;
                            excess2 = excess3;
                            downloading = downloading2;
                            excess = max2;
                            try {
                                $this$setMaxConcurrent_u24lambda_u242 = getServiceProxy();
                                if ($this$setMaxConcurrent_u24lambda_u242 != null) {
                                    $this$setMaxConcurrent_u24lambda_u242.setMaxConcurrent(excess, list2);
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (RemoteException e$iv3) {
                                LogKt.getVBLog().error("RemoteException in serviceProxy call : " + e$iv3.getMessage(), e$iv3);
                            } catch (Exception e$iv4) {
                                LogKt.getVBLog().error("Unexpected exception in serviceProxy call: " + e$iv4.getMessage(), e$iv4);
                            }
                            this.processing = false;
                            videoDownloadClientV2$setMaxConcurrent$1.L$0 = SpillingKt.nullOutSpilledVariable(downloading);
                            videoDownloadClientV2$setMaxConcurrent$1.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                            videoDownloadClientV2$setMaxConcurrent$1.L$2 = null;
                            videoDownloadClientV2$setMaxConcurrent$1.I$0 = excess;
                            videoDownloadClientV2$setMaxConcurrent$1.I$1 = excess2;
                            videoDownloadClientV2$setMaxConcurrent$1.label = 4;
                            return downloadVideosIfNeed$default(this, null, videoDownloadClientV2$setMaxConcurrent$1, 1, null) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        downloading = downloading3;
                        list2 = takeLast;
                        $this$setMaxConcurrent_u24lambda_u242 = getServiceProxy();
                        if ($this$setMaxConcurrent_u24lambda_u242 != null) {
                        }
                        this.processing = false;
                        videoDownloadClientV2$setMaxConcurrent$1.L$0 = SpillingKt.nullOutSpilledVariable(downloading);
                        videoDownloadClientV2$setMaxConcurrent$1.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                        videoDownloadClientV2$setMaxConcurrent$1.L$2 = null;
                        videoDownloadClientV2$setMaxConcurrent$1.I$0 = excess;
                        videoDownloadClientV2$setMaxConcurrent$1.I$1 = excess2;
                        videoDownloadClientV2$setMaxConcurrent$1.label = 4;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$setMaxConcurrent$1, 1, null) == coroutine_suspended) {
                        }
                    case 1:
                        int max3 = videoDownloadClientV2$setMaxConcurrent$1.I$0;
                        ResultKt.throwOnFailure($result);
                        excess = max3;
                        IOfflineService $this$setMaxConcurrent_u24lambda_u2402 = getServiceProxy();
                        if ($this$setMaxConcurrent_u24lambda_u2402 == null) {
                        }
                        if (list == null) {
                        }
                        List downloading32 = list;
                        if (excess >= Config.Companion.getMaxConcurrent()) {
                        }
                        if (excess2 <= 0) {
                        }
                        if (takeLast.isEmpty()) {
                        }
                        break;
                    case 2:
                        excess3 = videoDownloadClientV2$setMaxConcurrent$1.I$1;
                        max2 = videoDownloadClientV2$setMaxConcurrent$1.I$0;
                        takeLast = (List) videoDownloadClientV2$setMaxConcurrent$1.L$1;
                        ResultKt.throwOnFailure($result);
                        downloading2 = (List) videoDownloadClientV2$setMaxConcurrent$1.L$0;
                        videosByKeys = $result;
                        needPending = (List) videosByKeys;
                        List $this$map$iv2 = needPending;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        while (r17.hasNext()) {
                        }
                        ArrayList arrayList2 = (List) destination$iv$iv2;
                        dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$setMaxConcurrent$1.L$0 = SpillingKt.nullOutSpilledVariable(downloading2);
                        videoDownloadClientV2$setMaxConcurrent$1.L$1 = takeLast;
                        videoDownloadClientV2$setMaxConcurrent$1.L$2 = SpillingKt.nullOutSpilledVariable(needPending);
                        videoDownloadClientV2$setMaxConcurrent$1.I$0 = max2;
                        videoDownloadClientV2$setMaxConcurrent$1.I$1 = excess3;
                        videoDownloadClientV2$setMaxConcurrent$1.label = 3;
                        if (dataStorageWrapper.updateVideos(needPending, true, videoDownloadClientV2$setMaxConcurrent$1) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        excess3 = videoDownloadClientV2$setMaxConcurrent$1.I$1;
                        max2 = videoDownloadClientV2$setMaxConcurrent$1.I$0;
                        List list3 = (List) videoDownloadClientV2$setMaxConcurrent$1.L$2;
                        list2 = (List) videoDownloadClientV2$setMaxConcurrent$1.L$1;
                        downloading2 = (List) videoDownloadClientV2$setMaxConcurrent$1.L$0;
                        ResultKt.throwOnFailure($result);
                        excess2 = excess3;
                        downloading = downloading2;
                        excess = max2;
                        $this$setMaxConcurrent_u24lambda_u242 = getServiceProxy();
                        if ($this$setMaxConcurrent_u24lambda_u242 != null) {
                        }
                        this.processing = false;
                        videoDownloadClientV2$setMaxConcurrent$1.L$0 = SpillingKt.nullOutSpilledVariable(downloading);
                        videoDownloadClientV2$setMaxConcurrent$1.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                        videoDownloadClientV2$setMaxConcurrent$1.L$2 = null;
                        videoDownloadClientV2$setMaxConcurrent$1.I$0 = excess;
                        videoDownloadClientV2$setMaxConcurrent$1.I$1 = excess2;
                        videoDownloadClientV2$setMaxConcurrent$1.label = 4;
                        if (downloadVideosIfNeed$default(this, null, videoDownloadClientV2$setMaxConcurrent$1, 1, null) == coroutine_suspended) {
                        }
                        break;
                    case 4:
                        int i = videoDownloadClientV2$setMaxConcurrent$1.I$1;
                        int i2 = videoDownloadClientV2$setMaxConcurrent$1.I$0;
                        List list4 = (List) videoDownloadClientV2$setMaxConcurrent$1.L$1;
                        List list5 = (List) videoDownloadClientV2$setMaxConcurrent$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$setMaxConcurrent$1 = new VideoDownloadClientV2$setMaxConcurrent$1(this, continuation);
        Object $result2 = videoDownloadClientV2$setMaxConcurrent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$setMaxConcurrent$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyDownloadCountChanged(Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$notifyDownloadCountChanged$1 videoDownloadClientV2$notifyDownloadCountChanged$1;
        Object allVideos;
        Object downloadedVideos;
        int total;
        if (continuation instanceof VideoDownloadClientV2$notifyDownloadCountChanged$1) {
            videoDownloadClientV2$notifyDownloadCountChanged$1 = (VideoDownloadClientV2$notifyDownloadCountChanged$1) continuation;
            if ((videoDownloadClientV2$notifyDownloadCountChanged$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$notifyDownloadCountChanged$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$notifyDownloadCountChanged$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$notifyDownloadCountChanged$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DataStorageWrapper dataStorageWrapper = this.dataStorage;
                        videoDownloadClientV2$notifyDownloadCountChanged$1.label = 1;
                        allVideos = dataStorageWrapper.getAllVideos(videoDownloadClientV2$notifyDownloadCountChanged$1);
                        if (allVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int total2 = ((List) allVideos).size();
                        DataStorageWrapper dataStorageWrapper2 = this.dataStorage;
                        videoDownloadClientV2$notifyDownloadCountChanged$1.I$0 = total2;
                        videoDownloadClientV2$notifyDownloadCountChanged$1.label = 2;
                        downloadedVideos = dataStorageWrapper2.getDownloadedVideos(videoDownloadClientV2$notifyDownloadCountChanged$1);
                        if (downloadedVideos != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        total = total2;
                        int downloaded = ((List) downloadedVideos).size();
                        int downloading = total - downloaded;
                        LogKt.getVBLog().info("VideoDownloadClientV2 notifyDownloadCountChanged total:" + total + " downloading:" + downloading + " downloaded:" + downloaded);
                        Notifier.INSTANCE.update(FoundationAlias.getFapp(), total, downloading, downloaded);
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        allVideos = $result;
                        int total22 = ((List) allVideos).size();
                        DataStorageWrapper dataStorageWrapper22 = this.dataStorage;
                        videoDownloadClientV2$notifyDownloadCountChanged$1.I$0 = total22;
                        videoDownloadClientV2$notifyDownloadCountChanged$1.label = 2;
                        downloadedVideos = dataStorageWrapper22.getDownloadedVideos(videoDownloadClientV2$notifyDownloadCountChanged$1);
                        if (downloadedVideos != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        total = videoDownloadClientV2$notifyDownloadCountChanged$1.I$0;
                        ResultKt.throwOnFailure($result);
                        downloadedVideos = $result;
                        int downloaded2 = ((List) downloadedVideos).size();
                        int downloading2 = total - downloaded2;
                        LogKt.getVBLog().info("VideoDownloadClientV2 notifyDownloadCountChanged total:" + total + " downloading:" + downloading2 + " downloaded:" + downloaded2);
                        Notifier.INSTANCE.update(FoundationAlias.getFapp(), total, downloading2, downloaded2);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        videoDownloadClientV2$notifyDownloadCountChanged$1 = new VideoDownloadClientV2$notifyDownloadCountChanged$1(this, continuation);
        Object $result2 = videoDownloadClientV2$notifyDownloadCountChanged$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$notifyDownloadCountChanged$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleUpdateVideo(String str, boolean forceUpdate, Continuation<? super Unit> continuation) {
        VideoDownloadClientV2$handleUpdateVideo$1 videoDownloadClientV2$handleUpdateVideo$1;
        List entryList;
        List entryList2;
        if (continuation instanceof VideoDownloadClientV2$handleUpdateVideo$1) {
            videoDownloadClientV2$handleUpdateVideo$1 = (VideoDownloadClientV2$handleUpdateVideo$1) continuation;
            if ((videoDownloadClientV2$handleUpdateVideo$1.label & Integer.MIN_VALUE) != 0) {
                videoDownloadClientV2$handleUpdateVideo$1.label -= Integer.MIN_VALUE;
                Object $result = videoDownloadClientV2$handleUpdateVideo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (videoDownloadClientV2$handleUpdateVideo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("VideoDownloadClientV2 handleUpdateVideo force: " + forceUpdate + " entityStr: " + str);
                        String str2 = str;
                        if (!(str2 == null || str2.length() == 0)) {
                            Json this_$iv = EntryScannerKt.getOfflineJson();
                            this_$iv.getSerializersModule();
                            entryList = (List) this_$iv.decodeFromString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), str);
                            if (!entryList.isEmpty()) {
                                DataStorageWrapper dataStorageWrapper = this.dataStorage;
                                videoDownloadClientV2$handleUpdateVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                videoDownloadClientV2$handleUpdateVideo$1.L$1 = entryList;
                                videoDownloadClientV2$handleUpdateVideo$1.Z$0 = forceUpdate;
                                videoDownloadClientV2$handleUpdateVideo$1.label = 1;
                                if (dataStorageWrapper.updateVideos(entryList, forceUpdate, videoDownloadClientV2$handleUpdateVideo$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                entryList2 = entryList;
                                entryList = entryList2;
                                break;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        boolean forceUpdate2 = videoDownloadClientV2$handleUpdateVideo$1.Z$0;
                        entryList2 = (List) videoDownloadClientV2$handleUpdateVideo$1.L$1;
                        String str3 = (String) videoDownloadClientV2$handleUpdateVideo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        entryList = entryList2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LogKt.getVBLog().info("VideoDownloadClientV2 updateVideo complete, size: " + entryList.size());
                return Unit.INSTANCE;
            }
        }
        videoDownloadClientV2$handleUpdateVideo$1 = new VideoDownloadClientV2$handleUpdateVideo$1(this, continuation);
        Object $result2 = videoDownloadClientV2$handleUpdateVideo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (videoDownloadClientV2$handleUpdateVideo$1.label) {
        }
        LogKt.getVBLog().info("VideoDownloadClientV2 updateVideo complete, size: " + entryList.size());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleServiceTimeout(int startId, int fgsType) {
        LogKt.getVBLog().info("VideoDownloadClientV2 handleServiceTimeout startId: " + startId + " fgsType: " + fgsType);
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new VideoDownloadClientV2$handleServiceTimeout$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAndMigrate() {
        LogKt.getVBLog().info("VideoDownloadClientV2 resetAndMigrate called, client: " + hashCode());
        BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new VideoDownloadClientV2$resetAndMigrate$1(this, null), 3, (Object) null);
    }

    /* compiled from: VideoDownloadClientV2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/facade/client/VideoDownloadClientV2$Companion;", "", "<init>", "()V", "startService", "", "context", "Landroid/content/Context;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startService(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                LogKt.getVBLog().info("VideoDownloadClientV2 call start service, client " + hashCode());
                context.startService(new Intent(context, VideoDownloadServiceV2.class));
            } catch (Exception e) {
                IVBLog vBLog = LogKt.getVBLog();
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                vBLog.error(message, e);
            }
        }
    }
}