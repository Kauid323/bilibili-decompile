package video.biz.offline.base.facade.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.bilibili.lib.spy.generated.android_app_Service;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.base.log.LogKt;
import video.biz.offline.base.facade.client.IOfflineClient;
import video.biz.offline.base.facade.notification.OfflineNotificationHelper;
import video.biz.offline.base.facade.service.IOfflineService;
import video.biz.offline.base.facade.utils.SerialHelperKt;
import video.biz.offline.base.infra.download.DownloadProgressCallback;
import video.biz.offline.base.infra.download.OperationDispatcher;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.common.resolver.model.DashMedia;
import video.common.resolver.model.DashResource;
import video.common.resolver.model.PlayIndex;
import video.common.resolver.model.Stream;
import video.common.resolver.model.StreamContent;
import video.common.resolver.model.StreamInfo;
import video.common.resolver.model.VodInfo;

/* compiled from: VideoDownloadServiceV2.kt */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J3\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001f\u0018\u00010\u001eH\u0014¢\u0006\u0002\u0010 J\"\u0010!\u001a\u00020\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"H\u0016J\u0012\u0010)\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010\u001fH\u0002J \u0010+\u001a\u00020\u00182\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0018H\u0002J\u0012\u00101\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010\u001fH\u0002J \u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\"2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u000105H\u0002J\b\u00106\u001a\u00020\"H\u0002J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f05H\u0002J\"\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\"H\u0002J\u0016\u0010>\u001a\u00020\u00182\f\u0010?\u001a\b\u0012\u0004\u0012\u00020:05H\u0002J/\u0010@\u001a\u0004\u0018\u0001HA\"\u0004\b\u0000\u0010A2\u0017\u0010B\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\bDH\u0082\b¢\u0006\u0002\u0010ER\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lvideo/biz/offline/base/facade/service/VideoDownloadServiceV2;", "Landroid/app/Service;", "<init>", "()V", "binder", "video/biz/offline/base/facade/service/VideoDownloadServiceV2$binder$1", "Lvideo/biz/offline/base/facade/service/VideoDownloadServiceV2$binder$1;", "clientProxy", "Lvideo/biz/offline/base/facade/client/IOfflineClient;", "dispatcher", "Lvideo/biz/offline/base/infra/download/OperationDispatcher;", "notificationHelper", "Lvideo/biz/offline/base/facade/notification/OfflineNotificationHelper;", "getNotificationHelper", "()Lvideo/biz/offline/base/facade/notification/OfflineNotificationHelper;", "notificationHelper$delegate", "Lkotlin/Lazy;", "isDestroy", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "dump", "", "fd", "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "", "", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "onStartCommand", "", "flags", "startId", "onCreate", "onDestroy", "onTimeout", "fgsType", "handleAddDownload", "str", "handleStopDownload", "list", "", "isRemove", "", "handleStopAll", "handleUpdatedDanmaku", "handleMaxConcurrent", "maxConcurrent", "keys", "", "handleCurrentTaskCount", "handleDownloadingKeys", "saveIndexFile", "entity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "vodInfo", "Lvideo/common/resolver/model/VodInfo;", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "updateNotification", "videos", "safeClientProxyCall", "T", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDownloadServiceV2 extends android_app_Service {
    public static final int $stable = 8;
    private IOfflineClient clientProxy;
    private final VideoDownloadServiceV2$binder$1 binder = new IOfflineService.Stub() { // from class: video.biz.offline.base.facade.service.VideoDownloadServiceV2$binder$1
        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void registerClient(IOfflineClient callback) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 registerClient called: " + callback);
            VideoDownloadServiceV2.this.clientProxy = callback;
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void unregisterClient(IOfflineClient callback) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 unregisterClient called: " + callback);
            VideoDownloadServiceV2.this.clientProxy = null;
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void addDownload(String videos) {
            VideoDownloadServiceV2.this.handleAddDownload(videos);
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void stopDownload(List<String> list, boolean isRemove) {
            VideoDownloadServiceV2.this.handleStopDownload(list, isRemove);
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void stopAll() {
            VideoDownloadServiceV2.this.handleStopAll();
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void setMaxConcurrent(int max, List<String> list) {
            VideoDownloadServiceV2.this.handleMaxConcurrent(max, list);
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public List<String> getDownloadingKeys() {
            List<String> handleDownloadingKeys;
            handleDownloadingKeys = VideoDownloadServiceV2.this.handleDownloadingKeys();
            return handleDownloadingKeys;
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public int getCurrentTaskCount() {
            int handleCurrentTaskCount;
            handleCurrentTaskCount = VideoDownloadServiceV2.this.handleCurrentTaskCount();
            return handleCurrentTaskCount;
        }

        @Override // video.biz.offline.base.facade.service.IOfflineService
        public void updateDanmaku(String videos) {
            VideoDownloadServiceV2.this.handleUpdatedDanmaku(videos);
        }
    };
    private final OperationDispatcher dispatcher = new OperationDispatcher(new DownloadProgressCallback() { // from class: video.biz.offline.base.facade.service.VideoDownloadServiceV2$dispatcher$1
        @Override // video.biz.offline.base.infra.download.DownloadProgressCallback
        public void addDownload(List<OfflineVideoEntity> list) {
            Intrinsics.checkNotNullParameter(list, "videos");
            LogKt.getVBLog().info("VideoDownloadServiceV2 addDownload videos: " + list.size());
        }

        @Override // video.biz.offline.base.infra.download.DownloadProgressCallback
        public void playViewDidResolved(OfflineVideoEntity entity, VodInfo vodInfo, int qn) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            VideoDownloadServiceV2.this.saveIndexFile(entity, vodInfo, qn);
        }

        @Override // video.biz.offline.base.infra.download.DownloadProgressCallback
        public Object updateVideo(List<OfflineVideoEntity> list, boolean force, Continuation<? super Unit> continuation) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 updateVideo: videos: " + list + " force: " + force);
            VideoDownloadServiceV2 this_$iv = VideoDownloadServiceV2.this;
            try {
                IOfflineClient $this$updateVideo_u24lambda_u240 = this_$iv.clientProxy;
                if ($this$updateVideo_u24lambda_u240 != null) {
                    StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
                    $this$encodeToString$iv.getSerializersModule();
                    $this$updateVideo_u24lambda_u240.onUpdateVideo($this$encodeToString$iv.encodeToString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), list), force);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RemoteException e$iv) {
                LogKt.getVBLog().error("VideoDownloadServiceV2 remoteException in clientProxy call : " + e$iv.getMessage(), e$iv);
            } catch (Exception e$iv2) {
                LogKt.getVBLog().error("VideoDownloadServiceV2 unexpected exception in clientProxy call: " + e$iv2.getMessage(), e$iv2);
            }
            VideoDownloadServiceV2 this_$iv2 = VideoDownloadServiceV2.this;
            List<OfflineVideoEntity> $this$filterNot$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterNot$iv) {
                OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
                if (!it.getDownloaded()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            this_$iv2.updateNotification((List) destination$iv$iv);
            return Unit.INSTANCE;
        }

        @Override // video.biz.offline.base.infra.download.DownloadProgressCallback
        public void downloadComplete(OfflineVideoEntity video2) {
            Intrinsics.checkNotNullParameter(video2, "video");
            LogKt.getVBLog().info("VideoDownloadServiceV2 downloadComplete: video: " + video2);
            VideoDownloadServiceV2 this_$iv = VideoDownloadServiceV2.this;
            try {
                IOfflineClient $this$downloadComplete_u24lambda_u242 = this_$iv.clientProxy;
                if ($this$downloadComplete_u24lambda_u242 != null) {
                    StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
                    Object value$iv = CollectionsKt.listOf(video2);
                    $this$encodeToString$iv.getSerializersModule();
                    $this$downloadComplete_u24lambda_u242.onDownloadComplete($this$encodeToString$iv.encodeToString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), value$iv));
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RemoteException e$iv) {
                LogKt.getVBLog().error("VideoDownloadServiceV2 remoteException in clientProxy call : " + e$iv.getMessage(), e$iv);
            } catch (Exception e$iv2) {
                LogKt.getVBLog().error("VideoDownloadServiceV2 unexpected exception in clientProxy call: " + e$iv2.getMessage(), e$iv2);
            }
            VideoDownloadServiceV2 this_$iv2 = VideoDownloadServiceV2.this;
            this_$iv2.updateNotification(CollectionsKt.listOf(video2));
        }

        @Override // video.biz.offline.base.infra.download.DownloadProgressCallback
        public Object downloadError(OfflineVideoEntity video2, Continuation<? super Unit> continuation) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 downloadError: video: " + video2);
            VideoDownloadServiceV2 this_$iv = VideoDownloadServiceV2.this;
            try {
                IOfflineClient $this$downloadError_u24lambda_u243 = this_$iv.clientProxy;
                if ($this$downloadError_u24lambda_u243 != null) {
                    StringFormat $this$encodeToString$iv = EntryScannerKt.getOfflineJson();
                    Object value$iv = CollectionsKt.listOf(video2);
                    $this$encodeToString$iv.getSerializersModule();
                    $this$downloadError_u24lambda_u243.onDownloadError($this$encodeToString$iv.encodeToString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), value$iv));
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RemoteException e$iv) {
                LogKt.getVBLog().error("VideoDownloadServiceV2 remoteException in clientProxy call : " + e$iv.getMessage(), e$iv);
            } catch (Exception e$iv2) {
                LogKt.getVBLog().error("VideoDownloadServiceV2 unexpected exception in clientProxy call: " + e$iv2.getMessage(), e$iv2);
            }
            VideoDownloadServiceV2 this_$iv2 = VideoDownloadServiceV2.this;
            this_$iv2.updateNotification(CollectionsKt.listOf(video2));
            return Unit.INSTANCE;
        }
    });
    private final Lazy notificationHelper$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.facade.service.VideoDownloadServiceV2$$ExternalSyntheticLambda0
        public final Object invoke() {
            OfflineNotificationHelper notificationHelper_delegate$lambda$0;
            notificationHelper_delegate$lambda$0 = VideoDownloadServiceV2.notificationHelper_delegate$lambda$0(VideoDownloadServiceV2.this);
            return notificationHelper_delegate$lambda$0;
        }
    });
    private final AtomicBoolean isDestroy = new AtomicBoolean(false);

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfflineNotificationHelper getNotificationHelper() {
        return (OfflineNotificationHelper) this.notificationHelper$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineNotificationHelper notificationHelper_delegate$lambda$0(VideoDownloadServiceV2 this$0) {
        return new OfflineNotificationHelper((Service) this$0, OfflineScopeKt.getDownloadScope(), new VideoDownloadServiceV2$notificationHelper$2$1(this$0, null));
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        LogKt.getVBLog().info("VideoDownloadServiceV2 dump called");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LogKt.getVBLog().info("VideoDownloadServiceV2 onStartCommand intent: " + intent + " action: " + (intent != null ? intent.getAction() : null));
        return 1;
    }

    public void onCreate() {
        super.onCreate();
        LogKt.getVBLog().info("VideoDownloadServiceV2 onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        LogKt.getVBLog().info("VideoDownloadServiceV2 onDestroy");
        getNotificationHelper().release();
        this.isDestroy.set(true);
    }

    public void onTimeout(int startId, int fgsType) {
        super.onTimeout(startId, fgsType);
        LogKt.getVBLog().info("VideoDownloadServiceV2 timeout called, startId: " + startId + ", fgsType: " + fgsType);
        BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$onTimeout$1(this, startId, fgsType, null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAddDownload(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 handleAddDownload entryList string is null or empty");
            return;
        }
        Json this_$iv = EntryScannerKt.getOfflineJson();
        this_$iv.getSerializersModule();
        List entryList = (List) this_$iv.decodeFromString(new ArrayListSerializer(OfflineVideoEntity.Companion.serializer()), str);
        if (entryList.isEmpty()) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 handleAddDownload entryList is empty");
        } else {
            BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$handleAddDownload$1(this, entryList, null), 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStopDownload(List<String> list, boolean isRemove) {
        LogKt.getVBLog().info("VideoDownloadServiceV2 handleStopDownload list: " + list);
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 handleStopDownload list is empty");
        } else {
            BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$handleStopDownload$1(this, list, isRemove, null), 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStopAll() {
        BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$handleStopAll$1(this, null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUpdatedDanmaku(String str) {
        List entryList = SerialHelperKt.parseEntityList(str);
        this.dispatcher.updateDanmaku(entryList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMaxConcurrent(int maxConcurrent, List<String> list) {
        LogKt.getVBLog().info("VideoDownloadServiceV2 setMaxConcurrent " + maxConcurrent + " keys: " + list);
        BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$handleMaxConcurrent$1(this, maxConcurrent, list, null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int handleCurrentTaskCount() {
        return ((Number) BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$handleCurrentTaskCount$1(this, null), 1, (Object) null)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> handleDownloadingKeys() {
        return (List) BuildersKt.runBlocking$default((CoroutineContext) null, new VideoDownloadServiceV2$handleDownloadingKeys$1(this, null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void saveIndexFile(OfflineVideoEntity entity, VodInfo vodInfo, int qn) {
        Object obj;
        PlayIndex playIndex;
        Stream it;
        LogKt.getVBLog().info("VideoDownloadServiceV2 saveIndexFile entity: " + entity + " vodInfo: " + vodInfo + " qn: " + qn);
        if (vodInfo == null || qn == 0) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 can not save index file, vodInfo is null or qn is 0");
            return;
        }
        Iterator<T> it2 = vodInfo.getStreamList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            StreamInfo streamInfo = ((Stream) obj).getStreamInfo();
            if (streamInfo == null || streamInfo.getQuality() != qn) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        Stream stream = (Stream) obj;
        StreamInfo streamInfo2 = stream != null ? stream.getStreamInfo() : null;
        if (stream == null || streamInfo2 == null) {
            LogKt.getVBLog().info("VideoDownloadServiceV2 can not save index file, stream is null");
            return;
        }
        StreamContent streamContent = stream.getStreamContent();
        if (streamContent instanceof StreamContent.Dash) {
            DashMedia dash = ((StreamContent.Dash) streamContent).getValue();
            DashResource $this$saveIndexFile_u24lambda_u241 = new DashResource();
            DashMedia videoIndex = DashMedia.copy$default(dash, streamInfo2.getQuality(), null, null, 0, 0, null, 0L, 0, false, null, 0, 0, null, null, 16382, null);
            $this$saveIndexFile_u24lambda_u241.setVideoList(CollectionsKt.mutableListOf(new DashMedia[]{videoIndex}));
            DashMedia it3 = VideoDownloadServiceV2Kt.access$audioRes(vodInfo, entity.getVideoInfo().getAudioType() > 0);
            playIndex = $this$saveIndexFile_u24lambda_u241;
            if (it3 != null) {
                $this$saveIndexFile_u24lambda_u241.setAudioList(CollectionsKt.mutableListOf(new DashMedia[]{it3}));
                playIndex = $this$saveIndexFile_u24lambda_u241;
            }
        } else if (streamContent instanceof StreamContent.Segment) {
            List segmentList = ((StreamContent.Segment) streamContent).getValue().getSegmentList();
            playIndex = VideoDownloadServiceV2Kt.toPlayIndex(streamInfo2, segmentList);
        } else {
            playIndex = null;
        }
        Object index = playIndex;
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new VideoDownloadServiceV2$saveIndexFile$1(index, entity, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNotification(List<OfflineVideoEntity> list) {
        getNotificationHelper().updateNotifications(list);
    }

    private final <T> T safeClientProxyCall(Function1<? super IOfflineClient, ? extends T> function1) {
        try {
            IOfflineClient iOfflineClient = this.clientProxy;
            if (iOfflineClient != null) {
                return (T) function1.invoke(iOfflineClient);
            }
            return null;
        } catch (RemoteException e) {
            LogKt.getVBLog().error("VideoDownloadServiceV2 remoteException in clientProxy call : " + e.getMessage(), e);
            return null;
        } catch (Exception e2) {
            LogKt.getVBLog().error("VideoDownloadServiceV2 unexpected exception in clientProxy call: " + e2.getMessage(), e2);
            return null;
        }
    }
}