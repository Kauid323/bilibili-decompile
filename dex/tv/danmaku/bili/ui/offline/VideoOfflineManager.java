package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.util.LongSparseArray;
import androidx.collection.ArrayMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import bili.resource.playerbaseres.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.StringUtil;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import com.bilibili.offline.OfflineType;
import com.bilibili.offline.StorageInfo;
import com.bilibili.playerbizcommonv2.utils.NumberExtensionKt;
import com.bilibili.ugc.offline.drama.DramaInfo;
import com.bilibili.ugc.offline.drama.DramaManager;
import com.bilibili.ugc.offline.drama.DramaMetaOperator;
import com.bilibili.ugc.offline.drama.DramaVideo;
import com.bilibili.videodownloader.client.VideoDownloadClient;
import com.bilibili.videodownloader.client.VideoDownloadNotifyListener;
import com.bilibili.videodownloader.model.VerificationCodeKt;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.model.progress.AvDownloadProgress;
import com.bilibili.videodownloader.model.progress.SeasonDownloadProgress;
import com.bilibili.videodownloader.model.progress.VideoDownloadProgress;
import com.bilibili.videodownloader.model.season.Episode;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoOfflineManager.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\t\f\b\u0007\u0018\u0000 \u007f2\u00020\u0001:\u0002~\u007fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0005J\"\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010*\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\u0012J\"\u00102\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0012H\u0016J \u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0012J\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u0005H\u0002J\u001e\u0010;\u001a\u0004\u0018\u00010-2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u00109\u001a\u00020\u0017H\u0002J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u00109\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0002J&\u0010>\u001a\u0004\u0018\u00010-2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u00109\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0002J\u0014\u0010?\u001a\u00020-2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J(\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002J\u0014\u0010H\u001a\u00020-2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0018\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020-2\u0006\u0010K\u001a\u00020'H\u0016J\u0010\u0010L\u001a\u00020\"2\u0006\u0010K\u001a\u00020'H\u0016J\u0010\u0010M\u001a\u00020\"2\u0006\u0010J\u001a\u00020-H\u0016J\b\u0010N\u001a\u00020\"H\u0016J\u0016\u0010O\u001a\u00020\"2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020-0QH\u0016J\u0018\u0010R\u001a\u00020\"2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020-H\u0016J0\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020C2\u0006\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020C2\u0006\u0010Z\u001a\u00020C2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u00020\"2\b\u0010]\u001a\u0004\u0018\u00010^J\u0010\u0010_\u001a\u00020\"2\b\u0010]\u001a\u0004\u0018\u00010^J\b\u0010`\u001a\u00020\"H\u0016J\n\u0010a\u001a\u0004\u0018\u00010bH\u0016J\n\u0010c\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010d\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010e\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001cH\u0016J \u0010I\u001a\u00020\"2\b\u0010J\u001a\u0004\u0018\u00010-2\u0006\u0010f\u001a\u00020\u00052\u0006\u0010K\u001a\u00020'J.\u0010g\u001a\u00020\"2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020-0Q2\u0006\u0010i\u001a\u00020\u00052\u0006\u0010K\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u001aJ.\u0010j\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f0k2\u0006\u0010l\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u0005H\u0002J\u0014\u0010m\u001a\u00020\u00172\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0014\u0010n\u001a\u00020o2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0014\u0010p\u001a\u00020q2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0016\u0010r\u001a\u0004\u0018\u00010s2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0016\u0010t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\b\u0010J\u001a\u0004\u0018\u00010-J \u0010u\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010-2\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H\u0002J\u000e\u0010v\u001a\u00020\"2\u0006\u0010w\u001a\u00020'J\u0014\u0010x\u001a\u00020\"2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020-0zJ\u0018\u0010{\u001a\u00020\"2\b\u0010|\u001a\u0004\u0018\u00010C2\u0006\u0010}\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/¨\u0006\u0080\u0001"}, d2 = {"Ltv/danmaku/bili/ui/offline/VideoOfflineManager;", "Lcom/bilibili/offline/IOfflineManager;", "<init>", "()V", "mForceReload", "", "mLoadTaskCalled", "mAllEntriesLoaded", "mNotifyListener", "tv/danmaku/bili/ui/offline/VideoOfflineManager$mNotifyListener$1", "Ltv/danmaku/bili/ui/offline/VideoOfflineManager$mNotifyListener$1;", "mDownloadClient", "tv/danmaku/bili/ui/offline/VideoOfflineManager$mDownloadClient$1", "Ltv/danmaku/bili/ui/offline/VideoOfflineManager$mDownloadClient$1;", "mRawEntries", "", "Lcom/bilibili/videodownloader/model/VideoDownloadEntry;", "mDownloadingListeners", "Lcom/bilibili/offline/IOfflineManager$OfflineDataLoadListener;", "mDownloadingForDownloadPageListeners", "mDownloadedListeners", "mPageListeners", "", "", "Lkotlin/Pair;", "mDanmakuListener", "Ltv/danmaku/bili/ui/offline/VideoOfflineManager$DanmakuUpdateListener;", "mDataChangeListener", "Lcom/bilibili/offline/IOfflineManager$OfflineDataChangeListener;", "mDramaMetaOperator", "Lcom/bilibili/ugc/offline/drama/DramaMetaOperator;", "mDramaLoadedListener", "Lcom/bilibili/ugc/offline/drama/DramaManager$OnDramaMetaLoadedListener;", "notifyAllDataLoaded", "", "setForceReload", "forceReload", "getDownloadingItems", "page", "", "pageSize", "listener", "getDownloadingItemsForDownloadPage", "allDownloadingOfflineInfoForDownloadPage", "", "Lcom/bilibili/offline/OfflineInfo;", "getAllDownloadingOfflineInfoForDownloadPage", "()Ljava/util/List;", "allDownloadingOfflineInfo", "getAllDownloadingOfflineInfo", "getDownloadedItems", "allDownloadedOfflineInfo", "getAllDownloadedOfflineInfo", "getPagesById", "parentId", LoginSceneProcessor.SCENE_KEY, "getDownloadPageByGroupId", "groupId", "isCompleted", "updateOfflineInfo", "entry", "getDownloadPageByGroupId2", "updateOfflineInfo2", "convert2OfflineInfo", "createDramaOfflineInfo", "id", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "dramaVideo", "Lcom/bilibili/ugc/offline/drama/DramaVideo;", "pageEntry", "Lcom/bilibili/videodownloader/model/VideoDownloadAVPageEntry;", "createEntryOfflineInfo", "start", "info", "netType", "startAll", "stop", "stopAll", "delete", "infoList", "", "play", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "offlineInfo", "routeToPlayList", "avid", "cid", "bvid", "dataKey", "isDownloaded", "onStart", "context", "Landroid/content/Context;", "onStop", "release", "getPrimaryStorageInfo", "Lcom/bilibili/offline/StorageInfo;", "getSecondaryStorageInfo", "registerDataChangeListener", "unRegisterDataChangeListener", "supportFd", "updateDanmaku", "checkedInfo", "ignoreDrama", "groupDownloadedRawEntries", "", "onlyDownloaded", "getRealId", "getOfflineType", "Lcom/bilibili/offline/OfflineType;", "getOfflineStatus", "Lcom/bilibili/offline/OfflineStatus;", "getTypeInfo", "", "findDownloadingEntry", "isEquals", "changeDownloadingTaskCount", "taskCount", "updateVideoPlayable", "modifiedInfoMap", "Landroid/util/LongSparseArray;", "setInterruptTransformTempFile", "key", "interruptTransformTempFile", "DanmakuUpdateListener", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoOfflineManager implements IOfflineManager {
    private static final String CACHE_SPMID = "main.my-cache.0.0";
    public static final String EXTRA_PLAYLIST_TYPE = "page_type";
    public static final String EXTRA_URI_PARAM_OFFLINE_DATA_KEY = "offline_data_kay";
    private static final String KEY_FROM_SPMID = "from_spmid";
    public static final String MULTITYPE_PLAYLIST_PLAYPAGE = "bilibili://music/playlist/playpage/";
    public static final int PLAY_LIST_TYPE_DOWNLOADED = 1024;
    public static final int PLAY_LIST_TYPE_DOWNLOADING = 1025;
    private static final String TAG = "VideoOfflineManager";
    private boolean mAllEntriesLoaded;
    private DanmakuUpdateListener mDanmakuListener;
    private IOfflineManager.OfflineDataChangeListener mDataChangeListener;
    private final VideoOfflineManager$mDownloadClient$1 mDownloadClient;
    private final List<IOfflineManager.OfflineDataLoadListener> mDownloadedListeners;
    private final List<IOfflineManager.OfflineDataLoadListener> mDownloadingForDownloadPageListeners;
    private final List<IOfflineManager.OfflineDataLoadListener> mDownloadingListeners;
    private DramaManager.OnDramaMetaLoadedListener mDramaLoadedListener;
    private DramaMetaOperator mDramaMetaOperator;
    private boolean mForceReload;
    private boolean mLoadTaskCalled;
    private final VideoOfflineManager$mNotifyListener$1 mNotifyListener = new VideoDownloadNotifyListener<VideoDownloadEntry<?>>() { // from class: tv.danmaku.bili.ui.offline.VideoOfflineManager$mNotifyListener$1
        public void onNotifyEntriesChanged(List<VideoDownloadEntry<?>> list) {
            IOfflineManager.OfflineDataChangeListener offlineDataChangeListener;
            OfflineInfo convert2OfflineInfo;
            Intrinsics.checkNotNullParameter(list, "entries");
            List infoList = new ArrayList();
            for (VideoDownloadEntry entry : list) {
                convert2OfflineInfo = VideoOfflineManager.this.convert2OfflineInfo(entry);
                infoList.add(convert2OfflineInfo);
            }
            offlineDataChangeListener = VideoOfflineManager.this.mDataChangeListener;
            if (offlineDataChangeListener != null) {
                offlineDataChangeListener.onOfflineDataChange(infoList);
            }
        }

        public void onNotifyEntriesLoaded() {
            VideoOfflineManager.this.mAllEntriesLoaded = true;
            VideoOfflineManager.this.notifyAllDataLoaded();
        }
    };
    private final Map<Long, Pair<Long, IOfflineManager.OfflineDataLoadListener>> mPageListeners;
    private final List<VideoDownloadEntry<?>> mRawEntries;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: VideoOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/offline/VideoOfflineManager$DanmakuUpdateListener;", "", "onUpdateSuccess", "", "count", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DanmakuUpdateListener {
        void onUpdateSuccess(int i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.bili.ui.offline.VideoOfflineManager$mNotifyListener$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [tv.danmaku.bili.ui.offline.VideoOfflineManager$mDownloadClient$1] */
    public VideoOfflineManager() {
        final VideoOfflineManager$mNotifyListener$1 videoOfflineManager$mNotifyListener$1 = this.mNotifyListener;
        this.mDownloadClient = new VideoDownloadClient<VideoDownloadEntry<?>>(videoOfflineManager$mNotifyListener$1) { // from class: tv.danmaku.bili.ui.offline.VideoOfflineManager$mDownloadClient$1
            protected void onNotifyServiceConnected() {
                boolean z;
                boolean z2;
                z = VideoOfflineManager.this.mLoadTaskCalled;
                if (!z) {
                    z2 = VideoOfflineManager.this.mForceReload;
                    callLoadTasks(z2);
                    VideoOfflineManager.this.mForceReload = false;
                    VideoOfflineManager.this.mLoadTaskCalled = true;
                }
                callLoadAllDownloadEntries();
            }

            protected VideoDownloadEntry<?> updateDownloadEntry(VideoDownloadProgress<?> videoDownloadProgress) {
                List<VideoDownloadAVPageEntry> list;
                Intrinsics.checkNotNullParameter(videoDownloadProgress, "downloadProgress");
                list = VideoOfflineManager.this.mRawEntries;
                for (VideoDownloadAVPageEntry videoDownloadAVPageEntry : list) {
                    if (Intrinsics.areEqual(((VideoDownloadEntry) videoDownloadAVPageEntry).mKey, videoDownloadProgress.mKey)) {
                        if ((videoDownloadAVPageEntry instanceof VideoDownloadAVPageEntry) && (videoDownloadProgress instanceof AvDownloadProgress)) {
                            videoDownloadAVPageEntry.updateDownloadEntry(videoDownloadProgress);
                        }
                        if ((videoDownloadAVPageEntry instanceof VideoDownloadSeasonEpEntry) && (videoDownloadProgress instanceof SeasonDownloadProgress)) {
                            ((VideoDownloadSeasonEpEntry) videoDownloadAVPageEntry).updateDownloadEntry((SeasonDownloadProgress) videoDownloadProgress);
                        }
                        if (!videoDownloadAVPageEntry.isDanmakuUpdateBegin() && !videoDownloadAVPageEntry.isDanmakuUpdateEnd()) {
                            return videoDownloadAVPageEntry;
                        }
                    }
                }
                return null;
            }

            protected void receiveDownloadEntryList(ArrayList<VideoDownloadEntry<?>> arrayList) {
                List list;
                Intrinsics.checkNotNullParameter(arrayList, "entryList");
                list = VideoOfflineManager.this.mRawEntries;
                list.addAll(arrayList);
            }

            public List<VideoDownloadEntry<?>> getRawEntries() {
                List<VideoDownloadEntry<?>> list;
                list = VideoOfflineManager.this.mRawEntries;
                return list;
            }

            public void clearRawEntries() {
                List list;
                List list2;
                List list3;
                Map map;
                list = VideoOfflineManager.this.mRawEntries;
                list.clear();
                VideoOfflineManager.this.mAllEntriesLoaded = false;
                list2 = VideoOfflineManager.this.mDownloadingListeners;
                list2.clear();
                list3 = VideoOfflineManager.this.mDownloadedListeners;
                list3.clear();
                map = VideoOfflineManager.this.mPageListeners;
                map.clear();
                VideoOfflineManager.this.mDanmakuListener = null;
            }

            protected void recordNewDownloadEntry(VideoDownloadEntry<?> videoDownloadEntry) {
                Intrinsics.checkNotNullParameter(videoDownloadEntry, "entry");
            }

            protected void onNotifyDanmakuUpdate(int number) {
                VideoOfflineManager.DanmakuUpdateListener danmakuUpdateListener;
                danmakuUpdateListener = VideoOfflineManager.this.mDanmakuListener;
                if (danmakuUpdateListener != null) {
                    danmakuUpdateListener.onUpdateSuccess(number);
                }
                VideoOfflineManager.this.mDanmakuListener = null;
            }
        };
        this.mRawEntries = new ArrayList();
        this.mDownloadingListeners = new ArrayList();
        this.mDownloadingForDownloadPageListeners = new ArrayList();
        this.mDownloadedListeners = new ArrayList();
        this.mPageListeners = new LinkedHashMap();
        this.mDramaLoadedListener = new DramaManager.OnDramaMetaLoadedListener() { // from class: tv.danmaku.bili.ui.offline.VideoOfflineManager$$ExternalSyntheticLambda0
            public final void onDramaMetaLoaded(DramaMetaOperator dramaMetaOperator) {
                VideoOfflineManager.mDramaLoadedListener$lambda$0(VideoOfflineManager.this, dramaMetaOperator);
            }
        };
        DramaManager.getInstance().registerDramaMetaLoadedListener(this.mDramaLoadedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDramaLoadedListener$lambda$0(VideoOfflineManager this$0, DramaMetaOperator operator) {
        this$0.mDramaLoadedListener = null;
        this$0.mDramaMetaOperator = operator;
        this$0.notifyAllDataLoaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAllDataLoaded() {
        if (this.mDramaMetaOperator == null || !this.mAllEntriesLoaded) {
            return;
        }
        if (!this.mDownloadingListeners.isEmpty()) {
            for (IOfflineManager.OfflineDataLoadListener listener : this.mDownloadingListeners) {
                listener.onLoadCompleted(getAllDownloadingOfflineInfo());
            }
            this.mDownloadingListeners.clear();
        }
        if (!this.mDownloadingForDownloadPageListeners.isEmpty()) {
            for (IOfflineManager.OfflineDataLoadListener listener2 : this.mDownloadingForDownloadPageListeners) {
                listener2.onLoadCompleted(getAllDownloadingOfflineInfoForDownloadPage());
            }
            this.mDownloadingForDownloadPageListeners.clear();
        }
        if (!this.mDownloadedListeners.isEmpty()) {
            for (IOfflineManager.OfflineDataLoadListener listener3 : this.mDownloadedListeners) {
                listener3.onLoadCompleted(getAllDownloadedOfflineInfo());
            }
            this.mDownloadedListeners.clear();
        }
        if (!this.mPageListeners.isEmpty()) {
            for (Map.Entry<Long, Pair<Long, IOfflineManager.OfflineDataLoadListener>> entry : this.mPageListeners.entrySet()) {
                long key = entry.getKey().longValue();
                Pair value = entry.getValue();
                ((IOfflineManager.OfflineDataLoadListener) value.getSecond()).onLoadCompleted(getDownloadPageByGroupId2(key, ((Number) value.getFirst()).longValue()));
            }
            this.mPageListeners.clear();
        }
    }

    public final void setForceReload(boolean forceReload) {
        this.mForceReload = forceReload;
    }

    public void getDownloadingItems(int page, int pageSize, IOfflineManager.OfflineDataLoadListener listener) {
        if (listener == null) {
            return;
        }
        if (this.mAllEntriesLoaded && this.mDramaMetaOperator != null) {
            listener.onLoadCompleted(getAllDownloadingOfflineInfo());
        } else {
            this.mDownloadingListeners.add(listener);
        }
    }

    public final void getDownloadingItemsForDownloadPage(IOfflineManager.OfflineDataLoadListener listener) {
        if (listener == null) {
            return;
        }
        if (this.mAllEntriesLoaded && this.mDramaMetaOperator != null) {
            listener.onLoadCompleted(getAllDownloadingOfflineInfoForDownloadPage());
        } else {
            this.mDownloadingForDownloadPageListeners.add(listener);
        }
    }

    private final List<OfflineInfo> getAllDownloadingOfflineInfoForDownloadPage() {
        HashMap cidGroupByAvid = new HashMap();
        for (VideoDownloadEntry entry : this.mRawEntries) {
            if (!entry.isCompleted() && !entry.isRemovingOrRemoved()) {
                if (cidGroupByAvid.get(Long.valueOf(entry.getAvid())) == null) {
                    cidGroupByAvid.put(Long.valueOf(entry.getAvid()), new ArrayList());
                }
                ArrayList arrayList = (ArrayList) cidGroupByAvid.get(Long.valueOf(entry.getAvid()));
                if (arrayList != null) {
                    arrayList.add(Long.valueOf(entry.getCid()));
                }
            }
        }
        List downloading = new ArrayList();
        Iterator<VideoDownloadEntry<?>> it = this.mRawEntries.iterator();
        while (it.hasNext()) {
            VideoDownloadAVPageEntry videoDownloadAVPageEntry = (VideoDownloadEntry) it.next();
            if (!videoDownloadAVPageEntry.isCompleted() && !videoDownloadAVPageEntry.isRemovingOrRemoved()) {
                OfflineInfo info = convert2OfflineInfo(videoDownloadAVPageEntry);
                if (videoDownloadAVPageEntry instanceof VideoDownloadAVPageEntry) {
                    ArrayList arrayList2 = (ArrayList) cidGroupByAvid.get(Long.valueOf(videoDownloadAVPageEntry.getAvid()));
                    int size = arrayList2 != null ? arrayList2.size() : 0;
                    Object typeInfo = info.typeInfo;
                    if ((typeInfo instanceof DramaVideo) && size > 1) {
                        info.title = ((VideoDownloadEntry) videoDownloadAVPageEntry).mTitle;
                        DramaVideo dramaVideo = (DramaVideo) typeInfo;
                        Page page = videoDownloadAVPageEntry.mPageData;
                        dramaVideo.title = (page == null || (r8 = page.title) == null) ? "" : "";
                    }
                }
                downloading.add(info);
            }
        }
        return downloading;
    }

    private final List<OfflineInfo> getAllDownloadingOfflineInfo() {
        List downloading = new ArrayList();
        for (VideoDownloadEntry entry : this.mRawEntries) {
            if (!entry.isCompleted() && !entry.isRemovingOrRemoved()) {
                downloading.add(convert2OfflineInfo(entry));
            }
        }
        return downloading;
    }

    public void getDownloadedItems(int page, int pageSize, IOfflineManager.OfflineDataLoadListener listener) {
        if (listener == null) {
            return;
        }
        if (this.mAllEntriesLoaded && this.mDramaMetaOperator != null) {
            listener.onLoadCompleted(getAllDownloadedOfflineInfo());
        } else {
            this.mDownloadedListeners.add(listener);
        }
    }

    private final List<OfflineInfo> getAllDownloadedOfflineInfo() {
        LogHelper.i(TAG, "getAllDownloadedOfflineInfo raw entry size = " + this.mRawEntries.size());
        Map arrayMap = new ArrayMap();
        for (VideoDownloadEntry entry : this.mRawEntries) {
            if (entry.isCompleted()) {
                OfflineInfo info = convert2OfflineInfo(entry);
                List infoList = (List) arrayMap.get(Long.valueOf(info.id));
                if (infoList == null) {
                    infoList = new ArrayList();
                    arrayMap.put(Long.valueOf(info.id), infoList);
                }
                infoList.add(info);
            }
        }
        List groupList = new ArrayList();
        for (List<OfflineInfo> children : arrayMap.values()) {
            OfflineInfo group = null;
            for (OfflineInfo child : children) {
                if (child != null && (group == null || group.modifyTime < child.modifyTime)) {
                    group = child;
                }
            }
            if (group != null) {
                Intrinsics.checkNotNull(children);
                group.pages = children;
            }
            groupList.add(group);
        }
        Collections.sort(groupList, OfflineUtil.DECEND_BY_MODIFY_TIME);
        LogHelper.i(TAG, "getAllDownloadedOfflineInfo groupList size = " + groupList.size());
        return groupList;
    }

    public final void getPagesById(long parentId, long scene, IOfflineManager.OfflineDataLoadListener listener) {
        if (listener == null) {
            return;
        }
        if (this.mAllEntriesLoaded && this.mDramaMetaOperator != null) {
            listener.onLoadCompleted(getDownloadPageByGroupId2(parentId, scene));
        } else {
            this.mPageListeners.put(Long.valueOf(parentId), new Pair<>(Long.valueOf(scene), listener));
        }
    }

    private final List<OfflineInfo> getDownloadPageByGroupId(long groupId, boolean isCompleted) {
        OfflineInfo info;
        OfflineInfo info2;
        List downloadedPages = new ArrayList();
        if (isCompleted) {
            for (VideoDownloadEntry entry : this.mRawEntries) {
                if (entry.isCompleted() && (info2 = updateOfflineInfo(entry, groupId)) != null) {
                    downloadedPages.add(info2);
                }
            }
        } else {
            for (VideoDownloadEntry entry2 : this.mRawEntries) {
                if (!entry2.isCompleted() && (info = updateOfflineInfo(entry2, groupId)) != null) {
                    downloadedPages.add(info);
                }
            }
        }
        Collections.sort(downloadedPages, OfflineUtil.INSTANCE.getASCEND_BY_SORT_INDEX());
        return downloadedPages;
    }

    private final OfflineInfo updateOfflineInfo(VideoDownloadEntry<?> videoDownloadEntry, long groupId) {
        OfflineInfo info = convert2OfflineInfo(videoDownloadEntry);
        if (info.id != groupId) {
            return null;
        }
        Object typeInfo = info.typeInfo;
        if (typeInfo instanceof DramaVideo) {
            info.sortIndex = ((DramaVideo) typeInfo).createSortedKey();
        } else {
            info.sortIndex = videoDownloadEntry.getSortedKeyInGroup();
        }
        info.offlineType = new OfflineType(OfflineType.TYPE_PAGE);
        return info;
    }

    private final List<OfflineInfo> getDownloadPageByGroupId2(long groupId, long scene) {
        OfflineInfo info;
        List downloadedPages = new ArrayList();
        Map downloadListById = new LinkedHashMap();
        for (VideoDownloadEntry entry : this.mRawEntries) {
            if (entry.isCompleted() && (info = updateOfflineInfo2(entry, groupId, scene)) != null) {
                if (info.id != entry.getAvid() && scene == 1) {
                    if (((List) downloadListById.get(Long.valueOf(entry.getAvid()))) == null) {
                        downloadListById.put(Long.valueOf(entry.getAvid()), new ArrayList());
                    }
                    List list = (List) downloadListById.get(Long.valueOf(entry.getAvid()));
                    if (list != null) {
                        list.add(info);
                    }
                } else {
                    info.pages.add(info);
                    downloadedPages.add(info);
                }
            }
        }
        for (Map.Entry entry2 : downloadListById.entrySet()) {
            long avid = ((Number) entry2.getKey()).longValue();
            List<OfflineInfo> list2 = (List) entry2.getValue();
            OfflineInfo group = null;
            for (OfflineInfo page : list2) {
                if (page != null && (group == null || group.modifyTime < page.modifyTime)) {
                    group = page;
                }
            }
            if (group != null) {
                group.pages = list2;
            }
            if (group != null) {
                group.id = avid;
            }
            if (group != null) {
                downloadedPages.add(group);
            }
        }
        Collections.sort(downloadedPages, OfflineUtil.INSTANCE.getASCEND_BY_SORT_INDEX());
        return downloadedPages;
    }

    private final OfflineInfo updateOfflineInfo2(VideoDownloadEntry<?> videoDownloadEntry, long groupId, long scene) {
        OfflineInfo createEntryOfflineInfo;
        OfflineInfo offlineInfo = null;
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            DramaMetaOperator operator = this.mDramaMetaOperator;
            if (operator != null) {
                androidx.core.util.Pair drama = operator.getDramaByAvId(((VideoDownloadAVPageEntry) videoDownloadEntry).mAvid);
                if (drama != null) {
                    if (scene == 1) {
                        DramaVideo dramaVideo = new DramaVideo();
                        dramaVideo.avid = ((DramaVideo) drama.second).avid;
                        dramaVideo.title = ((DramaVideo) drama.second).title;
                        dramaVideo.section = ((DramaVideo) drama.second).section;
                        dramaVideo.position = ((DramaVideo) drama.second).position;
                        DramaInfo dramaInfo = (DramaInfo) drama.first;
                        long j = dramaInfo.dramaId;
                        String str = dramaInfo.dramaTitle;
                        Intrinsics.checkNotNullExpressionValue(str, "dramaTitle");
                        createEntryOfflineInfo = createDramaOfflineInfo(j, str, dramaVideo, (VideoDownloadAVPageEntry) videoDownloadEntry);
                    } else {
                        createEntryOfflineInfo = createEntryOfflineInfo(videoDownloadEntry);
                    }
                    offlineInfo = createEntryOfflineInfo;
                }
            } else {
                BLog.w(TAG, "convert2OfflineInfo == null");
            }
        }
        if (offlineInfo == null) {
            offlineInfo = createEntryOfflineInfo(videoDownloadEntry);
        }
        boolean z = false;
        if (offlineInfo != null && offlineInfo.id == groupId) {
            z = true;
        }
        if (z && offlineInfo != null) {
            OfflineInfo result = offlineInfo;
            Object typeInfo = result.typeInfo;
            if (typeInfo instanceof DramaVideo) {
                result.sortIndex = ((DramaVideo) typeInfo).createSortedKey();
            } else {
                result.sortIndex = videoDownloadEntry.getSortedKeyInGroup();
            }
            result.offlineType = new OfflineType(OfflineType.TYPE_PAGE);
            return result;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfflineInfo convert2OfflineInfo(VideoDownloadEntry<?> videoDownloadEntry) {
        OfflineInfo offlineInfo = null;
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            DramaMetaOperator operator = this.mDramaMetaOperator;
            if (operator != null) {
                androidx.core.util.Pair drama = operator.getDramaByAvId(((VideoDownloadAVPageEntry) videoDownloadEntry).mAvid);
                if (drama != null) {
                    DramaInfo dramaInfo = (DramaInfo) drama.first;
                    DramaVideo dramaVideo = new DramaVideo();
                    dramaVideo.avid = ((DramaVideo) drama.second).avid;
                    dramaVideo.title = ((DramaVideo) drama.second).title;
                    dramaVideo.section = ((DramaVideo) drama.second).section;
                    dramaVideo.position = ((DramaVideo) drama.second).position;
                    long j = dramaInfo.dramaId;
                    String str = dramaInfo.dramaTitle;
                    Intrinsics.checkNotNullExpressionValue(str, "dramaTitle");
                    offlineInfo = createDramaOfflineInfo(j, str, dramaVideo, (VideoDownloadAVPageEntry) videoDownloadEntry);
                }
            } else {
                BLog.w(TAG, "convert2OfflineInfo == null");
            }
        }
        return offlineInfo == null ? createEntryOfflineInfo(videoDownloadEntry) : offlineInfo;
    }

    private final OfflineInfo createDramaOfflineInfo(long id, String title, DramaVideo dramaVideo, VideoDownloadAVPageEntry pageEntry) {
        Page page = pageEntry.mPageData;
        dramaVideo.cid = page != null ? page.cid : 0L;
        OfflineInfo $this$createDramaOfflineInfo_u24lambda_u240 = new OfflineInfo();
        $this$createDramaOfflineInfo_u24lambda_u240.id = id;
        $this$createDramaOfflineInfo_u24lambda_u240.title = title;
        $this$createDramaOfflineInfo_u24lambda_u240.cover = pageEntry.mCover;
        $this$createDramaOfflineInfo_u24lambda_u240.danmaku = pageEntry.mDanmakuCount;
        $this$createDramaOfflineInfo_u24lambda_u240.totalBytes = pageEntry.mTotalBytes;
        $this$createDramaOfflineInfo_u24lambda_u240.downloadedBytes = pageEntry.mDownloadedBytes;
        $this$createDramaOfflineInfo_u24lambda_u240.duration = pageEntry.mTotalTimeMilli;
        $this$createDramaOfflineInfo_u24lambda_u240.sortIndex = pageEntry.mTimeCreated;
        $this$createDramaOfflineInfo_u24lambda_u240.createTime = pageEntry.mTimeCreated;
        $this$createDramaOfflineInfo_u24lambda_u240.modifyTime = pageEntry.mTimeStamp;
        $this$createDramaOfflineInfo_u24lambda_u240.typeInfo = dramaVideo;
        $this$createDramaOfflineInfo_u24lambda_u240.offlineStatus = getOfflineStatus((VideoDownloadEntry) pageEntry);
        $this$createDramaOfflineInfo_u24lambda_u240.offlineType = new OfflineType(OfflineType.TYPE_DRAMA);
        $this$createDramaOfflineInfo_u24lambda_u240.setBvid(pageEntry.getBvid());
        $this$createDramaOfflineInfo_u24lambda_u240.canPlayInAdvance = pageEntry.mCanPlayInAdvance;
        $this$createDramaOfflineInfo_u24lambda_u240.errorCode = pageEntry.mLastErrorCode;
        $this$createDramaOfflineInfo_u24lambda_u240.fdErrorCode = pageEntry.mFdErrorCode;
        $this$createDramaOfflineInfo_u24lambda_u240.setVideoQuality(pageEntry.mVideoQuality);
        $this$createDramaOfflineInfo_u24lambda_u240.setAudioQuality(pageEntry.mAudioQuality);
        $this$createDramaOfflineInfo_u24lambda_u240.setOwnerId(pageEntry.mOwnerId);
        $this$createDramaOfflineInfo_u24lambda_u240.setOwnerName(pageEntry.ownerName);
        $this$createDramaOfflineInfo_u24lambda_u240.setCacheVersionCode(pageEntry.cacheVersionCode);
        $this$createDramaOfflineInfo_u24lambda_u240.dolbyReportAppSubId = pageEntry.getDolbyReportAppSubId();
        $this$createDramaOfflineInfo_u24lambda_u240.setChargeVideo(pageEntry.isChargeVideo);
        return $this$createDramaOfflineInfo_u24lambda_u240;
    }

    private final OfflineInfo createEntryOfflineInfo(VideoDownloadEntry<?> videoDownloadEntry) {
        Integer intOrNull;
        Integer intOrNull2;
        OfflineInfo info = new OfflineInfo();
        info.id = getRealId(videoDownloadEntry);
        info.title = videoDownloadEntry.mTitle;
        info.cover = videoDownloadEntry.mCover;
        info.offlineStatus = getOfflineStatus(videoDownloadEntry);
        info.offlineType = getOfflineType(videoDownloadEntry);
        info.danmaku = videoDownloadEntry.mDanmakuCount;
        info.totalBytes = videoDownloadEntry.mTotalBytes;
        info.downloadedBytes = videoDownloadEntry.mDownloadedBytes;
        info.sortIndex = videoDownloadEntry.mTimeCreated;
        info.createTime = videoDownloadEntry.mTimeCreated;
        info.modifyTime = videoDownloadEntry.mTimeStamp;
        info.typeInfo = getTypeInfo(videoDownloadEntry);
        info.duration = videoDownloadEntry.mTotalTimeMilli;
        info.setBvid(videoDownloadEntry.getBvid());
        info.canPlayInAdvance = videoDownloadEntry.mCanPlayInAdvance;
        info.errorCode = videoDownloadEntry.mLastErrorCode;
        info.fdErrorCode = videoDownloadEntry.mFdErrorCode;
        info.setVideoQuality(videoDownloadEntry.mVideoQuality);
        info.setAudioQuality(videoDownloadEntry.mAudioQuality);
        info.dolbyReportAppSubId = videoDownloadEntry.getDolbyReportAppSubId();
        long mid = BiliAccounts.get(BiliContext.application()).mid();
        if (videoDownloadEntry.invalidMidInfo == null || videoDownloadEntry.invalidMidInfo.size() <= 0) {
            videoDownloadEntry.invalidMidInfo = new HashMap();
        }
        info.setVerificationPlayable(!videoDownloadEntry.invalidMidInfo.containsKey(String.valueOf(mid)));
        int i = 0;
        if (videoDownloadEntry instanceof VideoDownloadSeasonEpEntry) {
            String str = (String) videoDownloadEntry.invalidMidInfo.get(String.valueOf(mid));
            info.seasonCode = (str == null || (intOrNull2 = StringsKt.toIntOrNull(str)) == null) ? 0 : intOrNull2.intValue();
            if (((VideoDownloadSeasonEpEntry) videoDownloadEntry).mEpisode != null) {
                info.sortIndex = ((VideoDownloadSeasonEpEntry) videoDownloadEntry).mEpisode.sortIndex;
            }
        }
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            info.setOwnerId(((VideoDownloadAVPageEntry) videoDownloadEntry).mOwnerId);
            info.setOwnerName(((VideoDownloadAVPageEntry) videoDownloadEntry).ownerName);
            info.setChargeVideo(((VideoDownloadAVPageEntry) videoDownloadEntry).isChargeVideo);
            String str2 = (String) videoDownloadEntry.invalidMidInfo.get(String.valueOf(mid));
            if (str2 != null && (intOrNull = StringsKt.toIntOrNull(str2)) != null) {
                i = intOrNull.intValue();
            }
            info.setVerificationCode(VerificationCodeKt.toVerificationCode(i));
        }
        info.setCacheVersionCode(videoDownloadEntry.cacheVersionCode);
        return info;
    }

    public void start(OfflineInfo info, int netType) {
        Intrinsics.checkNotNullParameter(info, "info");
        VideoDownloadEntry entry = findDownloadingEntry(info);
        if (entry == null) {
            return;
        }
        callResumeDownloadEntry(entry.getKey(), netType);
    }

    public void startAll(int netType) {
        String it;
        List verified = new ArrayList();
        for (VideoDownloadEntry entry : this.mRawEntries) {
            if (entry.isStopped() && (it = entry.getKey()) != null) {
                verified.add(it);
            }
        }
        List $this$toTypedArray$iv = verified;
        callResumeDownloadEntries((String[]) $this$toTypedArray$iv.toArray(new String[0]), netType);
    }

    public void stop(OfflineInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        VideoDownloadEntry it = findDownloadingEntry(info);
        if (it != null) {
            callStopDownloadEntry(it.getKey());
        }
    }

    public void stopAll() {
        callStopAll();
    }

    public void delete(Collection<OfflineInfo> collection) {
        List flatList;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(collection, "infoList");
        List<OfflineInfo> flatList2 = new ArrayList();
        for (OfflineInfo info : collection) {
            if (info.getPageCount() == 0) {
                flatList2.add(info);
            } else {
                flatList2.addAll(CollectionsKt.filterNotNull(info.pages));
            }
        }
        List removeList = new ArrayList();
        HashMap dramaVideoCid = new HashMap();
        HashMap rawEntriesByAvid = new HashMap();
        for (OfflineInfo info2 : flatList2) {
            for (VideoDownloadEntry entry : this.mRawEntries) {
                if (rawEntriesByAvid.get(Long.valueOf(entry.getAvid())) == null) {
                    rawEntriesByAvid.put(Long.valueOf(entry.getAvid()), new ArrayList());
                }
                ArrayList arrayList2 = (ArrayList) rawEntriesByAvid.get(Long.valueOf(entry.getAvid()));
                if (arrayList2 != null) {
                    arrayList2.add(Long.valueOf(entry.getCid()));
                }
                if (isEquals(info2, entry)) {
                    Object typeInfo = info2.typeInfo;
                    if (typeInfo instanceof DramaVideo) {
                        if (dramaVideoCid.get(Long.valueOf(entry.getAvid())) == null) {
                            dramaVideoCid.put(Long.valueOf(entry.getAvid()), new Pair(Long.valueOf(info2.id), new ArrayList()));
                        }
                        Pair pair = (Pair) dramaVideoCid.get(Long.valueOf(entry.getAvid()));
                        if (pair != null && (arrayList = (ArrayList) pair.getSecond()) != null) {
                            arrayList.add(Long.valueOf(entry.getCid()));
                        }
                    }
                    removeList.add(entry);
                }
            }
        }
        HashMap $this$forEach$iv = dramaVideoCid;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            ArrayList arrayList3 = (ArrayList) rawEntriesByAvid.get(element$iv.getKey());
            if ((arrayList3 != null ? arrayList3.size() : 0) != ((ArrayList) ((Pair) element$iv.getValue()).getSecond()).size()) {
                flatList = flatList2;
            } else {
                DramaMetaOperator dramaMetaOperator = this.mDramaMetaOperator;
                if (dramaMetaOperator != null) {
                    flatList = flatList2;
                    dramaMetaOperator.deleteAv(((Number) ((Pair) element$iv.getValue()).getFirst()).longValue(), ((Number) element$iv.getKey()).longValue());
                } else {
                    flatList = flatList2;
                }
            }
            flatList2 = flatList;
        }
        callRemoveDownloadEntries(removeList);
    }

    public void play(Lifecycle lifecycle, OfflineInfo offlineInfo) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(offlineInfo, "offlineInfo");
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), (CoroutineContext) null, (CoroutineStart) null, new VideoOfflineManager$play$1(this, offlineInfo, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeToPlayList(final String avid, final String cid, final String bvid, final String dataKey, final boolean isDownloaded) {
        RouteRequest.Builder request = new RouteRequest.Builder("bilibili://music/playlist/playpage/0");
        request.extras(new Function1() { // from class: tv.danmaku.bili.ui.offline.VideoOfflineManager$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit routeToPlayList$lambda$0;
                routeToPlayList$lambda$0 = VideoOfflineManager.routeToPlayList$lambda$0(avid, cid, bvid, dataKey, isDownloaded, (MutableBundleLike) obj);
                return routeToPlayList$lambda$0;
            }
        });
        BLRouter.routeTo(request.build(), FoundationAlias.getFapp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit routeToPlayList$lambda$0(String $avid, String $cid, String $bvid, String $dataKey, boolean $isDownloaded, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if (StringUtil.isNotBlank($avid)) {
            $this$extras.put("avid", $avid);
        }
        if (StringUtil.isNotBlank($cid)) {
            $this$extras.put("cid", $cid);
        }
        if (StringUtil.isNotBlank($bvid)) {
            $this$extras.put("bvid", $bvid);
        }
        $this$extras.put(EXTRA_URI_PARAM_OFFLINE_DATA_KEY, $dataKey);
        $this$extras.put("from_spmid", "main.my-cache.0.0");
        $this$extras.put(EXTRA_PLAYLIST_TYPE, $isDownloaded ? "1024" : "1025");
        return Unit.INSTANCE;
    }

    public final void onStart(Context context) {
        bindService(context);
    }

    public final void onStop(Context context) {
        unbindService(context);
    }

    public void release() {
        this.mDataChangeListener = null;
        DramaManager.getInstance().unregisterDramaMetaLoadedListener(this.mDramaLoadedListener);
        onDestroy();
    }

    public StorageInfo getPrimaryStorageInfo() {
        return null;
    }

    public StorageInfo getSecondaryStorageInfo() {
        return null;
    }

    public void registerDataChangeListener(IOfflineManager.OfflineDataChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDataChangeListener = listener;
    }

    public void unRegisterDataChangeListener(IOfflineManager.OfflineDataChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDataChangeListener = null;
    }

    public final void start(OfflineInfo info, boolean supportFd, int netType) {
        VideoDownloadEntry entry = findDownloadingEntry(info);
        if (entry == null) {
            return;
        }
        callResumeDownloadEntry(entry.getKey(), supportFd, netType);
    }

    public final void updateDanmaku(Collection<OfflineInfo> collection, boolean ignoreDrama, int netType, DanmakuUpdateListener listener) {
        Intrinsics.checkNotNullParameter(collection, "checkedInfo");
        List entryList = new ArrayList();
        Map downloadedEntries = groupDownloadedRawEntries(true, ignoreDrama);
        for (OfflineInfo info : collection) {
            List<VideoDownloadEntry<?>> group = downloadedEntries.get(Long.valueOf(info.id));
            if (group != null) {
                if (info.getPageCount() == 0) {
                    for (VideoDownloadEntry entry : group) {
                        if (isEquals(info, entry)) {
                            entryList.add(entry);
                        }
                    }
                } else {
                    entryList.addAll(group);
                }
            }
        }
        String[] keys = new String[entryList.size()];
        int size = entryList.size();
        for (int i = 0; i < size; i++) {
            keys[i] = ((VideoDownloadEntry) entryList.get(i)).getKey();
        }
        this.mDanmakuListener = listener;
        callUpdateDanmaku(keys, netType);
    }

    private final Map<Long, List<VideoDownloadEntry<?>>> groupDownloadedRawEntries(boolean onlyDownloaded, boolean ignoreDrama) {
        Map downloadedRawEntries = new ArrayMap();
        Iterator<VideoDownloadEntry<?>> it = this.mRawEntries.iterator();
        while (it.hasNext()) {
            VideoDownloadAVPageEntry videoDownloadAVPageEntry = (VideoDownloadEntry) it.next();
            if (!onlyDownloaded || videoDownloadAVPageEntry.isCompleted()) {
                long groupId = -1;
                if ((videoDownloadAVPageEntry instanceof VideoDownloadAVPageEntry) && !ignoreDrama) {
                    long avid = videoDownloadAVPageEntry.mAvid;
                    DramaMetaOperator dramaMetaOperator = this.mDramaMetaOperator;
                    Intrinsics.checkNotNull(dramaMetaOperator);
                    androidx.core.util.Pair drama = dramaMetaOperator.getDramaByAvId(avid);
                    if (drama != null) {
                        groupId = ((DramaInfo) drama.first).dramaId;
                    }
                }
                if (groupId == -1) {
                    groupId = getRealId(videoDownloadAVPageEntry);
                }
                List group = downloadedRawEntries.get(Long.valueOf(groupId));
                if (group == null) {
                    group = new ArrayList();
                    downloadedRawEntries.put(Long.valueOf(groupId), group);
                }
                group.add(videoDownloadAVPageEntry);
            }
        }
        return downloadedRawEntries;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getRealId(VideoDownloadEntry<?> videoDownloadEntry) {
        String seasonId;
        Long longOrNull;
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            return ((VideoDownloadAVPageEntry) videoDownloadEntry).mAvid;
        }
        if (!(videoDownloadEntry instanceof VideoDownloadSeasonEpEntry) || (seasonId = ((VideoDownloadSeasonEpEntry) videoDownloadEntry).mSeasonId) == null || (longOrNull = StringsKt.toLongOrNull(seasonId)) == null) {
            return -1L;
        }
        return longOrNull.longValue();
    }

    private final OfflineType getOfflineType(VideoDownloadEntry<?> videoDownloadEntry) {
        int type = OfflineType.TYPE_VIDEO;
        String typeName = "";
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            type = OfflineType.TYPE_VIDEO;
        }
        if (videoDownloadEntry instanceof VideoDownloadSeasonEpEntry) {
            type = OfflineType.TYPE_BANGUMI;
            typeName = OfflineUtil.INSTANCE.getBangumiTypeName(((VideoDownloadSeasonEpEntry) videoDownloadEntry).mEpisode.seasonType);
        }
        return new OfflineType(type, typeName);
    }

    private final OfflineStatus getOfflineStatus(VideoDownloadEntry<?> videoDownloadEntry) {
        Context context = BiliContext.application();
        OfflineStatus status = new OfflineStatus();
        if (videoDownloadEntry.isStopped()) {
            status.code = 2;
            OfflineUtil offlineUtil = OfflineUtil.INSTANCE;
            Intrinsics.checkNotNull(context);
            status.message = offlineUtil.getErrInfo(context, videoDownloadEntry);
        } else if (videoDownloadEntry.isInQueue()) {
            status.code = 1;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(R.string.playerbaseres_global_string_544);
        } else if (videoDownloadEntry.isDownloading()) {
            status.code = 3;
            String speed = NumberExtensionKt.toFileSize(videoDownloadEntry.mSpeed);
            boolean fdForbade = FreeDataManager.getInstance().isFreeDataForbade(context, FreeDataManager.ForbadeType.VIDEO_DOWNLOAD);
            if (videoDownloadEntry.mExpectedNetworkType == 10010 && !fdForbade) {
                Intrinsics.checkNotNull(context);
                status.message = context.getString(bili.resource.homepage.R.string.homepage_global_string_343, speed);
            } else {
                Intrinsics.checkNotNull(context);
                status.message = context.getString(tv.danmaku.bili.R.string.offline_downloading_speed, speed);
            }
        } else if (videoDownloadEntry.isCompleted()) {
            status.code = 4;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(bili.resource.common.R.string.common_global_string_173);
        } else if (videoDownloadEntry.isStopping()) {
            status.code = 6;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(R.string.playerbaseres_global_string_606);
        } else if (videoDownloadEntry.isRemoved()) {
            status.code = 8;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(bili.resource.downloads.R.string.downloads_global_string_3);
        } else if (videoDownloadEntry.isRemoving()) {
            status.code = 7;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(bili.resource.favorites.R.string.favorites_global_string_156);
        } else if (videoDownloadEntry.isDeleteFailed()) {
            status.code = 9;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(bili.resource.common.R.string.common_global_string_52);
        } else if (videoDownloadEntry.isPreparing()) {
            status.code = 5;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(bili.resource.downloads.R.string.downloads_global_string_68);
        } else {
            status.code = 0;
            Intrinsics.checkNotNull(context);
            status.message = context.getString(bili.resource.downloads.R.string.downloads_global_string_18);
        }
        return status;
    }

    private final Object getTypeInfo(VideoDownloadEntry<?> videoDownloadEntry) {
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            return ((VideoDownloadAVPageEntry) videoDownloadEntry).mPageData;
        }
        if (videoDownloadEntry instanceof VideoDownloadSeasonEpEntry) {
            return ((VideoDownloadSeasonEpEntry) videoDownloadEntry).mEpisode;
        }
        return null;
    }

    public final VideoDownloadEntry<?> findDownloadingEntry(OfflineInfo info) {
        for (VideoDownloadEntry entry : this.mRawEntries) {
            if (!entry.isCompleted() && isEquals(info, entry)) {
                return entry;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isEquals(OfflineInfo info, VideoDownloadEntry<?> videoDownloadEntry) {
        boolean z;
        if (info == null || videoDownloadEntry == null) {
            return false;
        }
        if ((info.typeInfo instanceof Page) && (videoDownloadEntry instanceof VideoDownloadAVPageEntry)) {
            Page page = ((VideoDownloadAVPageEntry) videoDownloadEntry).mPageData;
            if (page != null) {
                Page page2 = (Page) info.typeInfo;
                Intrinsics.checkNotNull(page2);
                if (page2.cid == page.cid) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        if ((info.typeInfo instanceof Episode) && (videoDownloadEntry instanceof VideoDownloadSeasonEpEntry)) {
            Episode episode = (Episode) info.typeInfo;
            Intrinsics.checkNotNull(episode);
            if (episode.id == ((VideoDownloadSeasonEpEntry) videoDownloadEntry).mEpisode.id) {
                return true;
            }
        }
        if ((info.typeInfo instanceof DramaVideo) && (videoDownloadEntry instanceof VideoDownloadAVPageEntry)) {
            DramaVideo dramaVideo = (DramaVideo) info.typeInfo;
            Intrinsics.checkNotNull(dramaVideo);
            if (dramaVideo.avid == ((VideoDownloadAVPageEntry) videoDownloadEntry).mAvid) {
                DramaVideo dramaVideo2 = (DramaVideo) info.typeInfo;
                Intrinsics.checkNotNull(dramaVideo2);
                return dramaVideo2.cid == ((VideoDownloadAVPageEntry) videoDownloadEntry).getCid();
            }
            return false;
        }
        return false;
    }

    public final void changeDownloadingTaskCount(int taskCount) {
        callChangeDownloadingTaskCount(taskCount);
    }

    public final void updateVideoPlayable(LongSparseArray<OfflineInfo> longSparseArray) {
        OfflineInfo offlineInfo;
        Intrinsics.checkNotNullParameter(longSparseArray, "modifiedInfoMap");
        ArrayList entryList = new ArrayList();
        long mid = BiliAccounts.get(BiliContext.application()).mid();
        Iterator<VideoDownloadEntry<?>> it = this.mRawEntries.iterator();
        while (it.hasNext()) {
            VideoDownloadAVPageEntry videoDownloadAVPageEntry = (VideoDownloadEntry) it.next();
            if (videoDownloadAVPageEntry instanceof VideoDownloadSeasonEpEntry) {
                OfflineInfo offlineInfo2 = longSparseArray.get(((VideoDownloadSeasonEpEntry) videoDownloadAVPageEntry).mEpisode.id);
                if (offlineInfo2 != null) {
                    if (offlineInfo2.getVerificationPlayable()) {
                        if (((VideoDownloadEntry) videoDownloadAVPageEntry).invalidMidInfo.containsKey(String.valueOf(mid))) {
                            ((VideoDownloadEntry) videoDownloadAVPageEntry).invalidMidInfo.remove(String.valueOf(mid));
                            entryList.add(videoDownloadAVPageEntry);
                        }
                    } else {
                        HashMap hashMap = ((VideoDownloadEntry) videoDownloadAVPageEntry).invalidMidInfo;
                        Intrinsics.checkNotNullExpressionValue(hashMap, "invalidMidInfo");
                        hashMap.put(String.valueOf(mid), String.valueOf(offlineInfo2.seasonCode));
                        entryList.add(videoDownloadAVPageEntry);
                    }
                }
            } else if ((videoDownloadAVPageEntry instanceof VideoDownloadAVPageEntry) && (offlineInfo = longSparseArray.get(videoDownloadAVPageEntry.mAvid)) != null) {
                videoDownloadAVPageEntry.setVerificationCode(offlineInfo.getVerificationCode().getCode());
                if (offlineInfo.getVerificationPlayable()) {
                    if (((VideoDownloadEntry) videoDownloadAVPageEntry).invalidMidInfo.containsKey(String.valueOf(mid))) {
                        ((VideoDownloadEntry) videoDownloadAVPageEntry).invalidMidInfo.remove(String.valueOf(mid));
                        entryList.add(videoDownloadAVPageEntry);
                    }
                } else {
                    HashMap hashMap2 = ((VideoDownloadEntry) videoDownloadAVPageEntry).invalidMidInfo;
                    Intrinsics.checkNotNullExpressionValue(hashMap2, "invalidMidInfo");
                    hashMap2.put(String.valueOf(mid), String.valueOf(offlineInfo.getVerificationCode().getCode()));
                    entryList.add(videoDownloadAVPageEntry);
                }
            }
        }
        if (entryList.size() != 0) {
            callUpdateAccessInfo(entryList);
        }
    }

    public final void setInterruptTransformTempFile(String key, boolean interruptTransformTempFile) {
        callInterruptTransformTempFile(key, interruptTransformTempFile);
    }

    /* compiled from: VideoOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/offline/VideoOfflineManager$Companion;", "", "<init>", "()V", "TAG", "", "CACHE_SPMID", "KEY_FROM_SPMID", "EXTRA_URI_PARAM_OFFLINE_DATA_KEY", "EXTRA_PLAYLIST_TYPE", "PLAY_LIST_TYPE_DOWNLOADED", "", "PLAY_LIST_TYPE_DOWNLOADING", "MULTITYPE_PLAYLIST_PLAYPAGE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}