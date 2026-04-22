package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.util.LongSparseArray;
import androidx.lifecycle.Lifecycle;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineType;
import com.bilibili.offline.StorageInfo;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HybirdOfflineManager.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0016\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\nH\u0016J\u0016\u0010!\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0016J\u0018\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0006\u0010'\u001a\u00020\nJ\b\u0010(\u001a\u00020\nH\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020-H\u0016J\u001e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0018J\u0010\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102J\u0010\u00103\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102J0\u00104\u001a\u00020\n2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010#2\u0006\u00106\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u000107J\u000e\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0018J\u0016\u0010:\u001a\u00020\n2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010<J\u0018\u0010=\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u00152\u0006\u0010?\u001a\u00020\u0007J\u0012\u0010@\u001a\u0004\u0018\u00010\u00152\b\u0010A\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Ltv/danmaku/bili/ui/offline/HybirdOfflineManager;", "Lcom/bilibili/offline/IOfflineManager;", "<init>", "()V", "mVideoManager", "Ltv/danmaku/bili/ui/offline/VideoOfflineManager;", "isDownloadingVideoLoaded", "", "isDownloadedVideoLoaded", "getDownloadedVideo", "", "listener", "Lcom/bilibili/offline/IOfflineManager$OfflineDataLoadListener;", "getDownloadingItems", "getDownloadingItemsForDownloadPage", "notifyDownloadingLoaded", "hybirdList", "", "Lcom/bilibili/offline/OfflineInfo;", "search", "query", "", "notifyDownloadedLoaded", "page", "", "pageSize", "getDownloadedItems", "start", "offlineInfo", "netType", "startAll", "stop", "stopAll", "delete", "offlineInfos", "", "play", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "setForceReLoad", "release", "getPrimaryStorageInfo", "Lcom/bilibili/offline/StorageInfo;", "getSecondaryStorageInfo", "registerDataChangeListener", "Lcom/bilibili/offline/IOfflineManager$OfflineDataChangeListener;", "unRegisterDataChangeListener", "supportFd", "onStart", "context", "Landroid/content/Context;", "onStop", "updateDanmaku", "checkedInfo", "ignoreDrama", "Ltv/danmaku/bili/ui/offline/VideoOfflineManager$DanmakuUpdateListener;", "changeVideoDownloadingTaskCount", "taskCount", "updateVideoPlayable", "modifiedInfoMap", "Landroid/util/LongSparseArray;", "setInterruptTransformTempFile", "key", "interruptTransformTempFile", "findDownloadingEntryKey", "info", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HybirdOfflineManager implements IOfflineManager {
    public static final int $stable = 8;
    private boolean isDownloadedVideoLoaded;
    private boolean isDownloadingVideoLoaded;
    private final VideoOfflineManager mVideoManager = new VideoOfflineManager();

    public final void getDownloadedVideo(IOfflineManager.OfflineDataLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoManager.getDownloadedItems(0, 0, listener);
    }

    public final void getDownloadingItems(final IOfflineManager.OfflineDataLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final List hybirdList = new ArrayList();
        this.mVideoManager.getDownloadingItems(0, 0, new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.HybirdOfflineManager$$ExternalSyntheticLambda1
            public final void onLoadCompleted(List list) {
                HybirdOfflineManager.getDownloadingItems$lambda$0(hybirdList, this, listener, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDownloadingItems$lambda$0(List $hybirdList, HybirdOfflineManager this$0, IOfflineManager.OfflineDataLoadListener $listener, List videoList) {
        if (videoList == null) {
            return;
        }
        $hybirdList.addAll(videoList);
        this$0.isDownloadingVideoLoaded = true;
        this$0.notifyDownloadingLoaded($hybirdList, $listener);
    }

    public final void getDownloadingItemsForDownloadPage(final IOfflineManager.OfflineDataLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final List hybirdList = new ArrayList();
        this.mVideoManager.getDownloadingItemsForDownloadPage(new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.HybirdOfflineManager$$ExternalSyntheticLambda2
            public final void onLoadCompleted(List list) {
                HybirdOfflineManager.getDownloadingItemsForDownloadPage$lambda$0(hybirdList, this, listener, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDownloadingItemsForDownloadPage$lambda$0(List $hybirdList, HybirdOfflineManager this$0, IOfflineManager.OfflineDataLoadListener $listener, List videoList) {
        if (videoList == null) {
            return;
        }
        $hybirdList.addAll(videoList);
        this$0.isDownloadingVideoLoaded = true;
        this$0.notifyDownloadingLoaded($hybirdList, $listener);
    }

    private final void notifyDownloadingLoaded(List<OfflineInfo> list, IOfflineManager.OfflineDataLoadListener listener) {
        if (this.isDownloadingVideoLoaded) {
            this.isDownloadingVideoLoaded = false;
            Collections.sort(list, OfflineUtil.INSTANCE.getASCEND_BY_SORT_INDEX());
            listener.onLoadCompleted(list);
        }
    }

    public final void search(String query, final IOfflineManager.OfflineDataLoadListener listener) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        final String keyword = query.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(keyword, "toLowerCase(...)");
        final List hybirdList = new ArrayList();
        this.mVideoManager.getDownloadedItems(0, 0, new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.ui.offline.HybirdOfflineManager$$ExternalSyntheticLambda0
            public final void onLoadCompleted(List list) {
                HybirdOfflineManager.search$lambda$0(keyword, hybirdList, this, listener, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void search$lambda$0(String $keyword, List $hybirdList, HybirdOfflineManager this$0, IOfflineManager.OfflineDataLoadListener $listener, List videoList) {
        boolean z;
        OfflineInfo[] offlineInfoArr;
        boolean z2;
        if (videoList == null) {
            return;
        }
        Iterator it = videoList.iterator();
        while (it.hasNext()) {
            OfflineInfo info = (OfflineInfo) it.next();
            String str = info.title;
            if (str != null) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (lowerCase != null && StringsKt.contains$default(lowerCase, $keyword, false, 2, (Object) null)) {
                    z = true;
                    if (!z) {
                        $hybirdList.add(info);
                    } else {
                        Collection $this$toTypedArray$iv = info.pages;
                        for (OfflineInfo page : (OfflineInfo[]) $this$toTypedArray$iv.toArray(new OfflineInfo[0])) {
                            if (page != null) {
                                String str2 = page.title;
                                if (str2 != null) {
                                    Locale locale2 = Locale.getDefault();
                                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                                    String lowerCase2 = str2.toLowerCase(locale2);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    if (lowerCase2 != null && StringsKt.contains$default(lowerCase2, $keyword, false, 2, (Object) null)) {
                                        z2 = true;
                                        if (!z2) {
                                            String pageTitle = OfflineUtil.getPageTitle(page);
                                            Locale locale3 = Locale.getDefault();
                                            Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                                            String lowerCase3 = pageTitle.toLowerCase(locale3);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                            if (!StringsKt.contains$default(lowerCase3, $keyword, false, 2, (Object) null)) {
                                            }
                                        }
                                        page.pages = new ArrayList(1);
                                        page.pages.add(page);
                                        $hybirdList.add(page);
                                    }
                                }
                                z2 = false;
                                if (!z2) {
                                }
                                page.pages = new ArrayList(1);
                                page.pages.add(page);
                                $hybirdList.add(page);
                            }
                        }
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        this$0.isDownloadedVideoLoaded = true;
        this$0.notifyDownloadedLoaded($hybirdList, $listener);
    }

    private final void notifyDownloadedLoaded(List<OfflineInfo> list, IOfflineManager.OfflineDataLoadListener listener) {
        if (this.isDownloadedVideoLoaded) {
            this.isDownloadedVideoLoaded = false;
            Collections.sort(list, OfflineUtil.DECEND_BY_MODIFY_TIME);
            listener.onLoadCompleted(list);
        }
    }

    public void getDownloadingItems(int page, int pageSize, IOfflineManager.OfflineDataLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void getDownloadedItems(int page, int pageSize, IOfflineManager.OfflineDataLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void start(OfflineInfo offlineInfo, int netType) {
        Intrinsics.checkNotNullParameter(offlineInfo, "offlineInfo");
        OfflineType offlineType = offlineInfo.offlineType;
        boolean z = false;
        if (offlineType != null && offlineType.type == OfflineType.TYPE_AUDIO) {
            z = true;
        }
        if (!z) {
            this.mVideoManager.start(offlineInfo, netType);
        }
    }

    public void startAll(int netType) {
        this.mVideoManager.startAll(netType);
    }

    public void stop(OfflineInfo offlineInfo) {
        Intrinsics.checkNotNullParameter(offlineInfo, "offlineInfo");
        OfflineType offlineType = offlineInfo.offlineType;
        boolean z = false;
        if (offlineType != null && offlineType.type == OfflineType.TYPE_AUDIO) {
            z = true;
        }
        if (!z) {
            this.mVideoManager.stop(offlineInfo);
        }
    }

    public void stopAll() {
        this.mVideoManager.stopAll();
    }

    public void delete(Collection<OfflineInfo> collection) {
        Intrinsics.checkNotNullParameter(collection, "offlineInfos");
        List videoList = new ArrayList();
        for (OfflineInfo info : collection) {
            OfflineType offlineType = info.offlineType;
            boolean z = false;
            if (offlineType != null && offlineType.type == OfflineType.TYPE_AUDIO) {
                z = true;
            }
            if (!z) {
                videoList.add(info);
            }
        }
        this.mVideoManager.delete(videoList);
    }

    public void play(Lifecycle lifecycle, OfflineInfo offlineInfo) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(offlineInfo, "offlineInfo");
        OfflineType offlineType = offlineInfo.offlineType;
        boolean z = false;
        if (offlineType != null && offlineType.type == OfflineType.TYPE_AUDIO) {
            z = true;
        }
        if (!z) {
            this.mVideoManager.play(lifecycle, offlineInfo);
        }
    }

    public final void setForceReLoad() {
        this.mVideoManager.setForceReload(true);
    }

    public void release() {
        this.mVideoManager.release();
    }

    public StorageInfo getPrimaryStorageInfo() {
        return null;
    }

    public StorageInfo getSecondaryStorageInfo() {
        return null;
    }

    public void registerDataChangeListener(IOfflineManager.OfflineDataChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoManager.registerDataChangeListener(listener);
    }

    public void unRegisterDataChangeListener(IOfflineManager.OfflineDataChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoManager.unRegisterDataChangeListener(listener);
    }

    public final void start(OfflineInfo offlineInfo, boolean supportFd, int netType) {
        Intrinsics.checkNotNullParameter(offlineInfo, "offlineInfo");
        OfflineType offlineType = offlineInfo.offlineType;
        boolean z = false;
        if (offlineType != null && offlineType.type == OfflineType.TYPE_AUDIO) {
            z = true;
        }
        if (!z) {
            this.mVideoManager.start(offlineInfo, supportFd, netType);
        }
    }

    public final void onStart(Context context) {
        if (context == null) {
            return;
        }
        this.mVideoManager.onStart(context);
    }

    public final void onStop(Context context) {
        if (context == null) {
            return;
        }
        this.mVideoManager.onStop(context);
    }

    public final void updateDanmaku(Collection<OfflineInfo> collection, boolean ignoreDrama, int netType, VideoOfflineManager.DanmakuUpdateListener listener) {
        if (collection == null) {
            return;
        }
        this.mVideoManager.updateDanmaku(collection, ignoreDrama, netType, listener);
    }

    public final void changeVideoDownloadingTaskCount(int taskCount) {
        this.mVideoManager.changeDownloadingTaskCount(taskCount);
    }

    public final void updateVideoPlayable(LongSparseArray<OfflineInfo> longSparseArray) {
        VideoOfflineManager videoOfflineManager = this.mVideoManager;
        if (longSparseArray == null) {
            return;
        }
        videoOfflineManager.updateVideoPlayable(longSparseArray);
    }

    public final void setInterruptTransformTempFile(String key, boolean interruptTransformTempFile) {
        this.mVideoManager.setInterruptTransformTempFile(key, interruptTransformTempFile);
    }

    public final String findDownloadingEntryKey(OfflineInfo info) {
        VideoDownloadEntry entry = this.mVideoManager.findDownloadingEntry(info);
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }
}