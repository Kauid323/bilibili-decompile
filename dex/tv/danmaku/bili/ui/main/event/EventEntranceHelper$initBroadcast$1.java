package tv.danmaku.bili.ui.main.event;

import android.app.Application;
import com.bapis.bilibili.broadcast.message.main.TopActivityReply;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.ObjectUtils;
import com.bilibili.lib.biliid.utils.Md5Utils;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.lib.okdownloader.BiliDownloader;
import com.bilibili.lib.okdownloader.DownloadListener;
import com.bilibili.lib.okdownloader.DownloadRequest;
import com.bilibili.lib.okdownloader.TaskFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;

/* compiled from: EventEntranceHelper.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"tv/danmaku/bili/ui/main/event/EventEntranceHelper$initBroadcast$1", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/broadcast/message/main/TopActivityReply;", "onNext", "", "value", "onError", "t", "Lcom/bilibili/lib/moss/api/MossException;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventEntranceHelper$initBroadcast$1 implements MossResponseHandler<TopActivityReply> {
    public /* synthetic */ void onCompleted() {
        MossResponseHandler.-CC.$default$onCompleted(this);
    }

    public /* synthetic */ void onHeaders(Map map) {
        MossResponseHandler.-CC.$default$onHeaders(this, map);
    }

    public /* synthetic */ long onNextForAck(Object obj) {
        return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
    }

    public /* synthetic */ void onUpstreamAck(Long l) {
        MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
    }

    public /* synthetic */ void onValid() {
        MossResponseHandler.-CC.$default$onValid(this);
    }

    public void onNext(TopActivityReply value) {
        final EventEntranceModel data;
        BLog.i("EventEntranceHelper", value != null ? value.toString() : null);
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        data = EventEntranceHelper.INSTANCE.mapping(value);
        EventEntranceModel eventEntranceModel = EventEntranceHelper.entranceInfo;
        boolean changed = !ObjectUtils.equals(eventEntranceModel != null ? eventEntranceModel.getHash() : null, data != null ? data.getHash() : null);
        if (changed) {
            EventEntranceHelper eventEntranceHelper = EventEntranceHelper.INSTANCE;
            EventEntranceHelper.isChanged = changed;
        }
        if (changed) {
            Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$$ExternalSyntheticLambda0
                public final void subscribe(ObservableEmitter observableEmitter) {
                    EventEntranceHelper$initBroadcast$1.onNext$lambda$0(context, data, observableEmitter);
                }
            }).subscribeOn(Schedulers.io()).subscribe(new EventEntranceHelper$initBroadcast$1$onNext$2(data, context), new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$3
                public final void accept(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    BLog.i("EventEntranceHelper", it);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNext$lambda$0(Application $context, final EventEntranceModel $data, final ObservableEmitter it) {
        EventEntranceModel.Online online;
        EventEntranceModel.Animate animate;
        String icon;
        EventEntranceModel.Online online2;
        EventEntranceModel.Animate animate2;
        Intrinsics.checkNotNullParameter(it, "it");
        File filesDir = $context.getFilesDir();
        File mainTopMenuFile = new File((filesDir != null ? filesDir.getParent() : null) + File.separator + "MainTopMenu");
        if (!mainTopMenuFile.exists()) {
            mainTopMenuFile.mkdir();
        }
        String str = "";
        String fileNameString = Md5Utils.encoderByMd5(($data == null || (online2 = $data.getOnline()) == null || (animate2 = online2.getAnimate()) == null || (r2 = animate2.getIcon()) == null) ? "" : "");
        File downloadFile = new File(mainTopMenuFile.getAbsolutePath() + File.separator + fileNameString);
        if (downloadFile.exists()) {
            BLog.i("EventEntranceHelper", "download loading res is exit filePath  is " + downloadFile.getAbsolutePath());
            it.onNext(downloadFile.getAbsolutePath());
            it.onComplete();
            return;
        }
        TaskFactory taskFactory = BiliDownloader.Companion.get($context);
        if ($data != null && (online = $data.getOnline()) != null && (animate = online.getAnimate()) != null && (icon = animate.getIcon()) != null) {
            str = icon;
        }
        DownloadRequest create = taskFactory.create(str, "event_entrance");
        String absolutePath = mainTopMenuFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        DownloadRequest into = create.into(absolutePath);
        Intrinsics.checkNotNull(fileNameString);
        into.fileName(fileNameString).addListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$1$1
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
                EventEntranceModel.Online online3;
                EventEntranceModel.Animate animate3;
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
                it.onNext("");
                it.onComplete();
                EventEntranceModel eventEntranceModel = $data;
                BLog.i("EventEntranceHelper", "download loading res error  url is " + ((eventEntranceModel == null || (online3 = eventEntranceModel.getOnline()) == null || (animate3 = online3.getAnimate()) == null) ? null : animate3.getIcon()) + " error codes is " + list);
            }
        }).build().execute();
    }

    public void onError(MossException t) {
    }
}