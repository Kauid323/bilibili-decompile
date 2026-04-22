package tv.danmaku.bili.ui.main.event;

import android.app.Activity;
import android.app.Application;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.ObjectUtils;
import com.bilibili.lib.biliid.utils.Md5Utils;
import com.bilibili.lib.okdownloader.BiliDownloader;
import com.bilibili.lib.okdownloader.DownloadListener;
import com.bilibili.lib.okdownloader.DownloadRequest;
import com.bilibili.okretro.BiliApiDataCallback;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;
import tv.danmaku.bili.ui.main2.MainFragment;

/* compiled from: EventEntranceHelper.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"tv/danmaku/bili/ui/main/event/EventEntranceHelper$checkActivityEntrance$1", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel;", "onDataSuccess", "", "data", "onError", "t", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventEntranceHelper$checkActivityEntrance$1 extends BiliApiDataCallback<EventEntranceModel> {
    final /* synthetic */ Function0<Unit> $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventEntranceHelper$checkActivityEntrance$1(Function0<Unit> function0) {
        this.$listener = function0;
    }

    public void onDataSuccess(final EventEntranceModel data) {
        EventEntranceHelper eventEntranceHelper = EventEntranceHelper.INSTANCE;
        EventEntranceHelper.needUpdate = false;
        BLog.i("EventEntranceHelper", "http response : " + (data != null ? data.toString() : null));
        if (data != null) {
            Function0<Unit> function0 = this.$listener;
            final Application context = BiliContext.application();
            if (context != null) {
                EventEntranceModel eventEntranceModel = EventEntranceHelper.entranceInfo;
                boolean changed = !ObjectUtils.equals(eventEntranceModel != null ? eventEntranceModel.getHash() : null, data.getHash());
                if (changed) {
                    EventEntranceHelper eventEntranceHelper2 = EventEntranceHelper.INSTANCE;
                    EventEntranceHelper.isChanged = changed;
                }
                Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$$ExternalSyntheticLambda0
                    public final void subscribe(ObservableEmitter observableEmitter) {
                        EventEntranceHelper$checkActivityEntrance$1.onDataSuccess$lambda$0$0(context, data, observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2(data, context, function0), new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$3
                    public final void accept(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        BLog.i("EventEntranceHelper", it);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDataSuccess$lambda$0$0(Application $context, final EventEntranceModel $data, final ObservableEmitter it) {
        EventEntranceModel.Animate animate;
        EventEntranceModel.Animate animate2;
        Intrinsics.checkNotNullParameter(it, "it");
        File filesDir = $context.getFilesDir();
        String downLoadUrl = null;
        File mainTopMenuFile = new File((filesDir != null ? filesDir.getParent() : null) + File.separator + "MainTopMenu");
        if (!mainTopMenuFile.exists()) {
            mainTopMenuFile.mkdir();
        }
        EventEntranceModel.Online online = $data.getOnline();
        String fileNameString = Md5Utils.encoderByMd5((online == null || (animate2 = online.getAnimate()) == null || (r1 = animate2.getIcon()) == null) ? "" : "");
        File downloadFile = new File(mainTopMenuFile.getAbsolutePath() + File.separator + fileNameString);
        if (downloadFile.exists()) {
            BLog.i("EventEntranceHelper", "download loading res is exit filePath  is " + downloadFile.getAbsolutePath());
            it.onNext(downloadFile.getAbsolutePath());
            it.onComplete();
            return;
        }
        EventEntranceModel.Online online2 = $data.getOnline();
        if (online2 != null && (animate = online2.getAnimate()) != null) {
            downLoadUrl = animate.getIcon();
        }
        String str = downLoadUrl;
        if (str == null || StringsKt.isBlank(str)) {
            it.onNext("");
            it.onComplete();
            BLog.i("EventEntranceHelper", "download loading res error, url is null");
            return;
        }
        DownloadRequest create = BiliDownloader.Companion.get($context).create(downLoadUrl, "HomeEvent");
        String absolutePath = mainTopMenuFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        DownloadRequest into = create.into(absolutePath);
        Intrinsics.checkNotNull(fileNameString);
        into.fileName(fileNameString).addListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$1$1
            public /* synthetic */ void onCancel(String str2) {
                DownloadListener.-CC.$default$onCancel(this, str2);
            }

            public /* synthetic */ void onCheck(String str2) {
                DownloadListener.-CC.$default$onCheck(this, str2);
            }

            public /* synthetic */ void onLoading(String str2, long j, long j2, long j3, int i) {
                DownloadListener.-CC.$default$onLoading(this, str2, j, j2, j3, i);
            }

            public /* synthetic */ void onPause(String str2, long j, long j2) {
                DownloadListener.-CC.$default$onPause(this, str2, j, j2);
            }

            public /* synthetic */ void onRetry(String str2, int i) {
                DownloadListener.-CC.$default$onRetry(this, str2, i);
            }

            public /* synthetic */ void onStart(String str2) {
                DownloadListener.-CC.$default$onStart(this, str2);
            }

            public /* synthetic */ void onWait(String str2) {
                DownloadListener.-CC.$default$onWait(this, str2);
            }

            public void onFinish(String taskId, String filePath, String fileName) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onFinish(this, taskId, filePath, fileName);
                it.onNext(filePath + File.separator + fileName);
                it.onComplete();
                BLog.i("EventEntranceHelper", "download loading res success filePath  is " + filePath + " --file name is " + fileName);
            }

            public void onError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
                EventEntranceModel.Animate animate3;
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
                it.onNext("");
                it.onComplete();
                EventEntranceModel.Online online3 = $data.getOnline();
                BLog.i("EventEntranceHelper", "download loading res error  url is " + ((online3 == null || (animate3 = online3.getAnimate()) == null) ? null : animate3.getIcon()) + " error codes is " + list);
            }
        }).build().execute();
    }

    public void onError(Throwable t) {
        EventEntranceModel.Online online;
        boolean isMain;
        EventEntranceHelper eventEntranceHelper = EventEntranceHelper.INSTANCE;
        EventEntranceHelper.isChecked = true;
        Long l = null;
        BLog.i("EventEntranceHelper", "onError, msg = " + (t != null ? t.getMessage() : null));
        if (t instanceof BiliApiException) {
            BLog.i("EventEntranceHelper", "checkActivityEntrance onError with BiliApiException, code = " + ((BiliApiException) t).mCode);
            if (((BiliApiException) t).mCode == -404 && EventEntranceHelper.entranceInfo != null) {
                EventEntranceHelper eventEntranceHelper2 = EventEntranceHelper.INSTANCE;
                EventEntranceHelper.entranceInfo = null;
                EventEntranceHelper eventEntranceHelper3 = EventEntranceHelper.INSTANCE;
                EventEntranceHelper.isChanged = true;
                EventEntranceHelper.INSTANCE.saveCache();
                isMain = EventEntranceHelper.INSTANCE.isMain();
                if (isMain) {
                    Activity activity = BiliContext.topActivitiy();
                    Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type tv.danmaku.bili.MainActivityV2");
                    MainActivityV2 activityV2 = (MainActivityV2) activity;
                    MainFragment mainFragment = activityV2.getMainFragment();
                    if (mainFragment != null) {
                        mainFragment.tryUpdateCurrentTopMenu(0);
                    }
                } else {
                    EventEntranceHelper eventEntranceHelper4 = EventEntranceHelper.INSTANCE;
                    EventEntranceHelper.needUpdate = true;
                }
            }
        }
        EventEntranceHelper eventEntranceHelper5 = EventEntranceHelper.INSTANCE;
        EventEntranceModel eventEntranceModel = EventEntranceHelper.entranceInfo;
        if (eventEntranceModel != null && (online = eventEntranceModel.getOnline()) != null) {
            l = online.getInterval();
        }
        EventEntranceHelper.mLastLoopInterval = l;
        EventEntranceHelper.INSTANCE.loop();
    }
}