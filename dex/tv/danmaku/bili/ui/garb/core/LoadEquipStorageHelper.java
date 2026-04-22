package tv.danmaku.bili.ui.garb.core;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.downloader.DownloadRequest;
import com.bilibili.lib.downloader.core.DownloadListener;
import com.bilibili.lib.downloader.core.DownloadProcessor;
import com.bilibili.lib.downloader.core.ProcessorBuilder;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.GarbManagerDelegateKt;
import tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;

/* compiled from: LoadEquipStorageHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001c\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0016\u001a\u00020\u000eJ\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/garb/core/LoadEquipStorageHelper;", "", "<init>", "()V", "KEY_LOAD_EQUIP_CONFIG", "", "LOAD_EQUIP_CHILD_DIR_NAME", "sProcessor", "Lcom/bilibili/lib/downloader/core/DownloadProcessor;", "getSProcessor", "()Lcom/bilibili/lib/downloader/core/DownloadProcessor;", "sProcessor$delegate", "Lkotlin/Lazy;", "acceptGrab", "", "garb", "Ltv/danmaku/bili/ui/garb/model/GarbData;", "listener", "Ltv/danmaku/bili/ui/garb/core/LoadEquipStorageHelper$Listener;", "acceptEquip", "equip", "Ltv/danmaku/bili/ui/garb/model/GarbData$LoadEquip;", "unsnatchLoadEquip", "download", "getEquipFile", "Ljava/io/File;", "readEquip", "saveEquip", "getDir", "notifyLoadEquipChange", "Listener", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoadEquipStorageHelper {
    private static final String KEY_LOAD_EQUIP_CONFIG = "garb_load_equip_conf";
    private static final String LOAD_EQUIP_CHILD_DIR_NAME = "load_equip";
    public static final LoadEquipStorageHelper INSTANCE = new LoadEquipStorageHelper();
    private static final Lazy sProcessor$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            DownloadProcessor sProcessor_delegate$lambda$0;
            sProcessor_delegate$lambda$0 = LoadEquipStorageHelper.sProcessor_delegate$lambda$0();
            return sProcessor_delegate$lambda$0;
        }
    });

    /* compiled from: LoadEquipStorageHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/core/LoadEquipStorageHelper$Listener;", "", "onDownloadError", "", "errMsg", "", "onDownloadSuccess", "isCanceled", "", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Listener {
        boolean isCanceled();

        void onDownloadError(String str);

        void onDownloadSuccess();
    }

    private LoadEquipStorageHelper() {
    }

    private final DownloadProcessor getSProcessor() {
        return (DownloadProcessor) sProcessor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadProcessor sProcessor_delegate$lambda$0() {
        return ProcessorBuilder.INSTANCE.create(1).attach(BiliContext.application());
    }

    public final void acceptGrab(GarbData garb, Listener listener) {
        if (garb != null) {
            INSTANCE.acceptEquip(garb.getLoadEquip(), listener);
        }
    }

    public static /* synthetic */ void acceptEquip$default(LoadEquipStorageHelper loadEquipStorageHelper, GarbData.LoadEquip loadEquip, Listener listener, int i, Object obj) {
        if ((i & 2) != 0) {
            listener = null;
        }
        loadEquipStorageHelper.acceptEquip(loadEquip, listener);
    }

    public final void acceptEquip(GarbData.LoadEquip equip, Listener listener) {
        if (equip == null) {
            unsnatchLoadEquip();
            return;
        }
        GarbData.LoadEquip originEquip = INSTANCE.readEquip();
        if (Intrinsics.areEqual(equip, originEquip)) {
            File file = new File(INSTANCE.getDir(), String.valueOf(equip.getId()));
            if (!file.exists()) {
                INSTANCE.download(equip, listener);
            }
        } else if (equip.isIllegal()) {
            INSTANCE.unsnatchLoadEquip();
        } else if (equip.isNeedUpdate(originEquip)) {
            INSTANCE.saveEquip(equip);
            INSTANCE.download(equip, listener);
        }
    }

    public final void unsnatchLoadEquip() {
        Application app = BiliContext.application();
        if (app == null) {
            return;
        }
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).edit().remove(KEY_LOAD_EQUIP_CONFIG).apply();
        notifyLoadEquipChange();
    }

    public final void download(GarbData.LoadEquip equip, final Listener listener) {
        if (equip == null) {
            return;
        }
        File parentFile = new File(getDir());
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        File file = new File(parentFile, equip.getFileName());
        if (file.exists()) {
            file.delete();
        }
        DownloadRequest request = new DownloadRequest(equip.getUrl()).setDestFile(file).setListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper$download$request$1
            public void onComplete(DownloadRequest request2) {
                LoadEquipStorageHelper.Listener listener2 = LoadEquipStorageHelper.Listener.this;
                if (listener2 != null) {
                    listener2.onDownloadSuccess();
                }
                LoadEquipStorageHelper.INSTANCE.notifyLoadEquipChange();
            }

            public void onFailed(DownloadRequest request2, int errorCode, String errorMessage) {
                LoadEquipStorageHelper.Listener listener2 = LoadEquipStorageHelper.Listener.this;
                if (listener2 != null) {
                    listener2.onDownloadError(errorMessage);
                }
            }

            public void onProgress(DownloadRequest request2, long totalBytes, long downloadedBytes, int progress, long bytesPerSecond) {
            }

            public boolean isCanceled() {
                LoadEquipStorageHelper.Listener listener2 = LoadEquipStorageHelper.Listener.this;
                if (listener2 != null) {
                    return listener2.isCanceled();
                }
                return false;
            }
        }).setDeleteDestFileOnFailure(true);
        DownloadProcessor sProcessor = getSProcessor();
        Intrinsics.checkNotNull(request);
        sProcessor.add(request);
    }

    public final File getEquipFile() {
        GarbData.LoadEquip equip = readEquip();
        if (equip == null) {
            return null;
        }
        File result = new File(getDir(), equip.getFileName());
        if (result.exists()) {
            return result;
        }
        return null;
    }

    private final GarbData.LoadEquip readEquip() {
        Application app = BiliContext.application();
        if (app == null) {
            return null;
        }
        try {
            String json = BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).getString(KEY_LOAD_EQUIP_CONFIG, null);
            return (GarbData.LoadEquip) JSONObject.parseObject(json, GarbData.LoadEquip.class);
        } catch (Exception e) {
            return null;
        }
    }

    private final void saveEquip(GarbData.LoadEquip equip) {
        Application app;
        if (equip == null || (app = BiliContext.application()) == null) {
            return;
        }
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).edit().putString(KEY_LOAD_EQUIP_CONFIG, JSONObject.toJSONString(equip)).apply();
    }

    private final String getDir() {
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return null;
        }
        return GarbStorageHelper.INSTANCE.buildDirName(ctx) + "/load_equip";
    }

    public final void notifyLoadEquipChange() {
        Context application = BiliContext.application();
        if (application == null) {
            return;
        }
        Context ctx = application;
        String actionName = ctx.getPackageName() + ".garb.LOAD_EQUIP_CHANGE";
        try {
            Intent intent = new Intent(actionName);
            intent.setPackage(ctx.getPackageName());
            ctx.sendBroadcast(intent);
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "load equip send broadcast error!");
        }
    }
}