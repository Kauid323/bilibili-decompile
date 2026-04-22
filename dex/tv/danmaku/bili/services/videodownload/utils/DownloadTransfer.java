package tv.danmaku.bili.services.videodownload.utils;

import android.app.Application;
import android.net.Uri;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.offline.IOfflineManager;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineStatus;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.offline.HybirdOfflineManager;

/* compiled from: DownloadTransfer.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0004J\b\u0010#\u001a\u00020\"H\u0004J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010&\u001a\u00020\u0005H\u0004J\f\u0010'\u001a\u00020\u000f*\u00020(H\u0002J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000fH\u0004J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0004J\u0012\u0010/\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0004J\u001c\u00100\u001a\u00020\u001d2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"02H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u00063"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/DownloadTransfer;", "", "<init>", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "listener", "Ltv/danmaku/bili/services/videodownload/utils/TransferListener;", "getListener", "()Ltv/danmaku/bili/services/videodownload/utils/TransferListener;", "setListener", "(Ltv/danmaku/bili/services/videodownload/utils/TransferListener;)V", "isProcessing", "", "()Z", "setProcessing", "(Z)V", "entryCount", "", "getEntryCount", "()I", "setEntryCount", "(I)V", "currntIndex", "getCurrntIndex", "setCurrntIndex", "transfer", "", "src", "Landroid/net/Uri;", "log", AuthResultCbHelper.ARGS_MSG, "", "getTag", "getPauseDownloadObservable", "Lio/reactivex/rxjava3/core/Observable;", "app", "isDownloading", "Lcom/bilibili/offline/OfflineInfo;", "getForceLoadObservable", "result", "trackSuccess", "costTime", "", "count", "trackFail", "track", "params", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class DownloadTransfer {
    public static final int $stable = 8;
    private final Application application = BiliContext.application();
    private int currntIndex;
    private int entryCount;
    private boolean isProcessing;
    private TransferListener listener;

    public abstract void transfer(Uri uri);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Application getApplication() {
        return this.application;
    }

    public final TransferListener getListener() {
        return this.listener;
    }

    public final void setListener(TransferListener transferListener) {
        this.listener = transferListener;
    }

    public final boolean isProcessing() {
        return this.isProcessing;
    }

    public final void setProcessing(boolean z) {
        this.isProcessing = z;
    }

    public final int getEntryCount() {
        return this.entryCount;
    }

    public final void setEntryCount(int i) {
        this.entryCount = i;
    }

    public final int getCurrntIndex() {
        return this.currntIndex;
    }

    public final void setCurrntIndex(int i) {
        this.currntIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void log(String msg) {
        Intrinsics.checkNotNullParameter(msg, AuthResultCbHelper.ARGS_MSG);
        BLog.i(getTag(), msg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getTag() {
        return DownloadTransferKt.OFFLINE_TRANSFER_TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Observable<Boolean> getPauseDownloadObservable(final Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Observable<Boolean> subscribeOn = Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTransfer$$ExternalSyntheticLambda5
            public final void subscribe(ObservableEmitter observableEmitter) {
                DownloadTransfer.getPauseDownloadObservable$lambda$0(app, this, observableEmitter);
            }
        }).subscribeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "subscribeOn(...)");
        return subscribeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPauseDownloadObservable$lambda$0(final Application $app, final DownloadTransfer this$0, final ObservableEmitter consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        final HybirdOfflineManager manager = new HybirdOfflineManager();
        manager.onStart($app);
        manager.getDownloadingItems(new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTransfer$$ExternalSyntheticLambda1
            public final void onLoadCompleted(List list) {
                DownloadTransfer.getPauseDownloadObservable$lambda$0$0(DownloadTransfer.this, manager, $app, consumer, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPauseDownloadObservable$lambda$0$0(final DownloadTransfer this$0, final HybirdOfflineManager $manager, final Application $app, final ObservableEmitter $consumer, List downloadingItems) {
        ArrayList progressItem = new ArrayList();
        Iterator it = downloadingItems.iterator();
        while (it.hasNext()) {
            OfflineInfo info = (OfflineInfo) it.next();
            Intrinsics.checkNotNull(info);
            if (this$0.isDownloading(info)) {
                progressItem.add(info);
            }
        }
        if (progressItem.isEmpty()) {
            $manager.onStop($app);
            $consumer.onNext(true);
            $consumer.onComplete();
            return;
        }
        $manager.registerDataChangeListener(new IOfflineManager.OfflineDataChangeListener() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTransfer$$ExternalSyntheticLambda3
            public final void onOfflineDataChange(List list) {
                DownloadTransfer.getPauseDownloadObservable$lambda$0$0$0($manager, $app, $consumer, this$0, list);
            }
        });
        $manager.stopAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPauseDownloadObservable$lambda$0$0$0(HybirdOfflineManager $manager, Application $app, ObservableEmitter $consumer, DownloadTransfer this$0, List datas) {
        Intrinsics.checkNotNull(datas);
        List $this$forEach$iv = datas;
        for (Object element$iv : $this$forEach$iv) {
            OfflineInfo info = (OfflineInfo) element$iv;
            Intrinsics.checkNotNull(info);
            if (this$0.isDownloading(info)) {
                return;
            }
        }
        $manager.onStop($app);
        $consumer.onNext(true);
        $consumer.onComplete();
        $manager.release();
    }

    private final boolean isDownloading(OfflineInfo $this$isDownloading) {
        OfflineStatus $this$isDownloading_u24lambda_u240 = $this$isDownloading.offlineStatus;
        if ($this$isDownloading_u24lambda_u240 != null) {
            return $this$isDownloading_u24lambda_u240.code == 1 || $this$isDownloading_u24lambda_u240.code == 5 || $this$isDownloading_u24lambda_u240.code == 3 || $this$isDownloading_u24lambda_u240.code == 6;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Observable<Boolean> getForceLoadObservable(final Application app, final boolean result) {
        Intrinsics.checkNotNullParameter(app, "app");
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTransfer$$ExternalSyntheticLambda4
            public final void subscribe(ObservableEmitter observableEmitter) {
                DownloadTransfer.getForceLoadObservable$lambda$0(app, result, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getForceLoadObservable$lambda$0(final Application $app, final boolean $result, final ObservableEmitter consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        final HybirdOfflineManager manager = new HybirdOfflineManager();
        manager.setForceReLoad();
        manager.onStart($app);
        manager.getDownloadedVideo(new IOfflineManager.OfflineDataLoadListener() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTransfer$$ExternalSyntheticLambda0
            public final void onLoadCompleted(List list) {
                DownloadTransfer.getForceLoadObservable$lambda$0$0(manager, $app, consumer, $result, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getForceLoadObservable$lambda$0$0(HybirdOfflineManager $manager, Application $app, ObservableEmitter $consumer, boolean $result, List it) {
        $manager.onStop($app);
        $consumer.onNext(Boolean.valueOf($result));
        $consumer.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void trackSuccess(long costTime, int count) {
        HashMap params = new HashMap();
        params.put("cost_time", String.valueOf(costTime));
        params.put("count", String.valueOf(count));
        params.put("result", "1");
        track(params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void trackFail(String msg) {
        HashMap params = new HashMap();
        params.put("result", "0");
        params.put(AuthResultCbHelper.ARGS_MSG, msg == null ? "" : msg);
        track(params);
    }

    private final void track(Map<String, String> map) {
        Neurons.trackT$default(false, "main.download.transfer.track", map, 0, new Function0() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTransfer$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean track$lambda$0;
                track$lambda$0 = DownloadTransfer.track$lambda$0();
                return Boolean.valueOf(track$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean track$lambda$0() {
        return true;
    }
}