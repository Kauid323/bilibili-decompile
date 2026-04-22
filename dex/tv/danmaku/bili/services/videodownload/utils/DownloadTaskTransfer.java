package tv.danmaku.bili.services.videodownload.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.text.format.DateUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import bili.resource.homepage.R;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.preferences.Settings;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.mixin.IFragmentShowHideKt;
import com.bilibili.videodownloader.utils.CustomDirUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.videodownload.TransferTipsDialog;
import tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.services.videodownload.utils.DownloadTaskTransfer;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;

/* compiled from: DownloadTaskTransfer.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u000234B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000eJ\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\bH\u0003J\b\u0010\"\u001a\u00020\u0014H\u0002J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0010J(\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0016H\u0003J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0011\u001a\u00020\u0016H\u0003J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010/\u001a\u00020-H\u0003J\u0010\u00100\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0003J\u0010\u00101\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/DownloadTaskTransfer;", "", "<init>", "()V", "REQ_CODE_SELECT_CUSTOM_DIR", "", "REQ_CODE_TO_TRANSFER_ACTIVITY", "KEY_RECORD_TRANSFERED", "", "KEY_SHOW_TRANSFER_DIALOG", "DIALOG_SHOW_LIMIT_TIME_PER_DAY", "transfer", "Ltv/danmaku/bili/services/videodownload/utils/DownloadTransfer;", "listener", "Ltv/danmaku/bili/services/videodownload/utils/TransferListener;", "checkIsNeedTransfer", "", "ctx", "Landroidx/appcompat/app/AppCompatActivity;", "isProcessing", "", "checkLimit", "Landroid/content/Context;", "checkFilePermission", "file", "Ljava/io/File;", "transferConfirm", FileChooserActivity.PATH, "toTransferActivity", "Landroid/app/Activity;", "doTransfer", AudioIntentHelper.FROM_ACTIVITY, "transferListener", "openFileDocument", "isTransfering", "getProgress", BuildConfig.BUILD_TYPE, "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "isTransfered", "recordTransfered", "getDialogShowRecord", "Ltv/danmaku/bili/services/videodownload/utils/DownloadTaskTransfer$DialogRecord;", "recordDialogShowRecord", "record", "clearDialogShowRecord", "increaseShowRecord", "removeTransfered", "FinishActivityObserve", "DialogRecord", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadTaskTransfer {
    private static final int DIALOG_SHOW_LIMIT_TIME_PER_DAY = 2;
    private static final String KEY_RECORD_TRANSFERED = "video_downloaded_entry_task_transfered";
    private static final String KEY_SHOW_TRANSFER_DIALOG = "video_download_show_transfer_limit";
    private static final int REQ_CODE_SELECT_CUSTOM_DIR = 1090;
    private static final int REQ_CODE_TO_TRANSFER_ACTIVITY = 1091;
    private static TransferListener listener;
    private static DownloadTransfer transfer;
    public static final DownloadTaskTransfer INSTANCE = new DownloadTaskTransfer();
    public static final int $stable = 8;

    /* compiled from: DownloadTaskTransfer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/DownloadTaskTransfer$FinishActivityObserve;", "Landroidx/lifecycle/LifecycleObserver;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "shouldCloseActivity", "", "getShouldCloseActivity", "()Z", "setShouldCloseActivity", "(Z)V", "actRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class FinishActivityObserve implements LifecycleObserver {
        public static final int $stable = 8;
        private final WeakReference<Activity> actRef;
        private boolean shouldCloseActivity;

        private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                Thread thread = Thread.currentThread();
                if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                    IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                    BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                    Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                    if (com.bilibili.kaptbundle.BuildConfig.DEBUG) {
                        throw exp;
                    }
                }
            }
            ((Activity) activity).finish();
        }

        public FinishActivityObserve(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            this.shouldCloseActivity = true;
            this.actRef = new WeakReference<>(activity);
        }

        public final boolean getShouldCloseActivity() {
            return this.shouldCloseActivity;
        }

        public final void setShouldCloseActivity(boolean z) {
            this.shouldCloseActivity = z;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy(LifecycleOwner owner) {
            Activity activity;
            Intrinsics.checkNotNullParameter(owner, "owner");
            if (this.shouldCloseActivity && (activity = this.actRef.get()) != null) {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            }
            owner.getLifecycle().removeObserver(this);
        }
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (com.bilibili.kaptbundle.BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }

    private DownloadTaskTransfer() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkIsNeedTransfer(AppCompatActivity ctx) {
        boolean isFileEmpty;
        File[] listFiles;
        int length;
        boolean limit;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        DownloadTransfer downloadTransfer = transfer;
        boolean permission = true;
        if (downloadTransfer != null && downloadTransfer.isProcessing()) {
            toTransferActivity((Activity) ctx);
        }
        String path = Settings.Download.getDownloadCustomStoragePath((Context) ctx);
        if (StringUtil.isBlank(path)) {
            return;
        }
        File primaryDir = VideoDownloadStorageStrategy.getPrimaryDirectoryFile((Context) ctx);
        File customDir = VideoDownloadStorageStrategy.getCustomDirectory((Context) ctx, path);
        if (primaryDir != null && customDir != null) {
            try {
                if (Intrinsics.areEqual(primaryDir.getCanonicalPath(), customDir.getCanonicalPath())) {
                    return;
                }
            } catch (Throwable th) {
            }
        }
        if (customDir != null) {
            try {
                listFiles = customDir.listFiles();
            } catch (Throwable th2) {
                isFileEmpty = false;
            }
            if (listFiles != null) {
                length = listFiles.length;
                isFileEmpty = length != 0;
                limit = checkLimit((Context) ctx);
                if (limit) {
                    return;
                }
                if (checkFilePermission(new File(path)) && !CustomDirUtils.Companion.isAbandonCustomDir()) {
                    permission = false;
                }
                if (permission && !isFileEmpty && !isTransfered((Context) ctx)) {
                    Intrinsics.checkNotNull(path);
                    transferConfirm(ctx, path);
                    return;
                }
                return;
            }
        }
        length = 0;
        if (length != 0) {
        }
        limit = checkLimit((Context) ctx);
        if (limit) {
        }
    }

    public final boolean isProcessing() {
        DownloadTransfer downloadTransfer = transfer;
        if (downloadTransfer != null) {
            return downloadTransfer.isProcessing();
        }
        return true;
    }

    private final boolean checkLimit(Context ctx) {
        DialogRecord record = getDialogShowRecord(ctx);
        long lastShowData = record.getLastShowData();
        if (lastShowData != 0 && DateUtils.isToday(lastShowData)) {
            return DateUtils.isToday(record.getLastShowData()) && record.getTime() < 2;
        }
        clearDialogShowRecord(ctx);
        return true;
    }

    private final boolean checkFilePermission(File file) {
        if (file == null) {
            return false;
        }
        try {
            File tempFile = new File(file, "test.txt");
            tempFile.createNewFile();
            tempFile.delete();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private final void transferConfirm(final AppCompatActivity ctx, String path) {
        final Fragment transferTipsDialog = new TransferTipsDialog();
        transferTipsDialog.setClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTaskTransfer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadTaskTransfer.transferConfirm$lambda$0(ctx, transferTipsDialog, view);
            }
        });
        if (!IFragmentShowHideKt.isFragmentShown(transferTipsDialog)) {
            increaseShowRecord((Context) ctx);
            transferTipsDialog.show(ctx.getSupportFragmentManager(), "DownloadTaskTransfer");
            Neurons.reportExposure$default(false, "main.my-cache.transfer-toast.0.show", (Map) null, (List) null, 12, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transferConfirm$lambda$0(AppCompatActivity $ctx, TransferTipsDialog $dialog, View it) {
        Neurons.reportClick$default(false, "main.my-cache.transfer-toast.0.click", (Map) null, 4, (Object) null);
        INSTANCE.toTransferActivity((Activity) $ctx);
        $dialog.dismiss();
    }

    private final void toTransferActivity(Activity ctx) {
        Intent i = new Intent(ctx, VideoTaskTransferActivity.class);
        ctx.startActivityForResult(i, REQ_CODE_TO_TRANSFER_ACTIVITY);
    }

    public final void doTransfer(AppCompatActivity activity, TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(transferListener, "transferListener");
        listener = transferListener;
        DownloadTransfer downloadTransfer = transfer;
        boolean z = false;
        if (downloadTransfer != null && downloadTransfer.isProcessing()) {
            z = true;
        }
        if (z) {
            DownloadTransfer downloadTransfer2 = transfer;
            if (downloadTransfer2 != null) {
                downloadTransfer2.setListener(listener);
                return;
            }
            return;
        }
        String rootPath = Settings.Download.getDownloadCustomStoragePath((Context) activity);
        if (StringUtil.isBlank(rootPath)) {
            return;
        }
        File customDir = VideoDownloadStorageStrategy.getCustomDirectory((Context) activity, rootPath);
        boolean hasPermission = checkFilePermission(customDir);
        if (hasPermission) {
            transfer = FileTransfer.INSTANCE;
            DownloadTransfer downloadTransfer3 = transfer;
            if (downloadTransfer3 != null) {
                downloadTransfer3.setListener(listener);
            }
            DownloadTransfer downloadTransfer4 = transfer;
            if (downloadTransfer4 != null) {
                Uri fromFile = Uri.fromFile(customDir);
                Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
                downloadTransfer4.transfer(fromFile);
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(rootPath);
        openFileDocument(activity, rootPath);
    }

    private final void openFileDocument(final AppCompatActivity activity, String path) {
        final FinishActivityObserve observer = new FinishActivityObserve((Activity) activity);
        BiliCommonDialog.Builder builder = new BiliCommonDialog.Builder((Context) activity);
        int i = R.string.homepage_global_string_180;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String string = activity.getString(i, new Object[]{StringsKt.replace$default(path, absolutePath, "", false, 4, (Object) null)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        BiliCommonDialog.Builder contentText = builder.setContentText(string);
        String string2 = activity.getString(R.string.homepage_global_string_375);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        BiliCommonDialog.Builder dialogBuilder = BiliCommonDialog.Builder.setPositiveButton$default(contentText, string2, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.services.videodownload.utils.DownloadTaskTransfer$openFileDocument$dialogBuilder$1
            public void onDialogTextClicked(View view, BiliCommonDialog dialog) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                DownloadTaskTransfer.FinishActivityObserve.this.setShouldCloseActivity(false);
                Intent i2 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                i2.setFlags(64);
                activity.startActivityForResult(i2, 1090);
                dialog.dismiss();
            }
        }, false, (CustomButtonInfo) null, 12, (Object) null);
        dialogBuilder.setCanceledOnTouchOutside(false);
        BiliCommonDialog dialog = dialogBuilder.build();
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        dialog.show(supportFragmentManager, "openFileDocument");
        dialog.getLifecycle().addObserver(observer);
    }

    private final boolean isTransfering() {
        DownloadTransfer downloadTransfer = transfer;
        if (downloadTransfer != null) {
            return downloadTransfer.isProcessing();
        }
        return false;
    }

    public final int getProgress() {
        DownloadTransfer trs = transfer;
        if (trs != null && isTransfering() && trs.getCurrntIndex() > 0) {
            return (trs.getCurrntIndex() * 100) / trs.getEntryCount();
        }
        return 0;
    }

    public final void release() {
        listener = null;
    }

    public final void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Uri uri;
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        switch (requestCode) {
            case REQ_CODE_SELECT_CUSTOM_DIR /* 1090 */:
                if (resultCode == -1) {
                    if (data == null || (uri = data.getData()) == null) {
                        return;
                    }
                    int takeFlags = data.getFlags() & 3;
                    activity.getContentResolver().takePersistableUriPermission(uri, takeFlags);
                    transfer = DocumentTransfer.INSTANCE;
                    DownloadTransfer downloadTransfer = transfer;
                    if (downloadTransfer != null) {
                        downloadTransfer.setListener(listener);
                    }
                    DownloadTransfer downloadTransfer2 = transfer;
                    if (downloadTransfer2 != null) {
                        downloadTransfer2.transfer(uri);
                        return;
                    }
                    return;
                }
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
                return;
            case REQ_CODE_TO_TRANSFER_ACTIVITY /* 1091 */:
                if (resultCode == -1) {
                    activity.recreate();
                    return;
                } else {
                    __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
                    return;
                }
            default:
                return;
        }
    }

    @JvmStatic
    private static final boolean isTransfered(Context ctx) {
        return BiliGlobalPreferenceHelper.getInstance(ctx).optBoolean(KEY_RECORD_TRANSFERED, false);
    }

    @JvmStatic
    public static final void recordTransfered(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        BiliGlobalPreferenceHelper.getInstance(ctx).edit().putBoolean(KEY_RECORD_TRANSFERED, true).apply();
    }

    @JvmStatic
    private static final DialogRecord getDialogShowRecord(Context ctx) {
        String json = BiliGlobalPreferenceHelper.getInstance(ctx).optString(KEY_SHOW_TRANSFER_DIALOG, "{}");
        try {
            Object parseObject = JSON.parseObject(json, DialogRecord.class);
            Intrinsics.checkNotNull(parseObject);
            return (DialogRecord) parseObject;
        } catch (Throwable th) {
            return new DialogRecord();
        }
    }

    @JvmStatic
    private static final void recordDialogShowRecord(Context ctx, DialogRecord record) {
        BiliGlobalPreferenceHelper.getInstance(ctx).edit().putString(KEY_SHOW_TRANSFER_DIALOG, JSON.toJSONString(record)).apply();
    }

    @JvmStatic
    private static final void clearDialogShowRecord(Context ctx) {
        BiliGlobalPreferenceHelper.getInstance(ctx).edit().remove(KEY_SHOW_TRANSFER_DIALOG).apply();
    }

    private final void increaseShowRecord(Context ctx) {
        DialogRecord record = getDialogShowRecord(ctx);
        record.setLastShowData(System.currentTimeMillis());
        record.setTime(record.getTime() + 1);
        recordDialogShowRecord(ctx, record);
    }

    @JvmStatic
    public static final void removeTransfered(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        BiliGlobalPreferenceHelper.getInstance(ctx).edit().remove(KEY_RECORD_TRANSFERED).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DownloadTaskTransfer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/DownloadTaskTransfer$DialogRecord;", "", "<init>", "()V", "lastShowData", "", "getLastShowData", "()J", "setLastShowData", "(J)V", "time", "", "getTime", "()I", "setTime", "(I)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DialogRecord {
        @JSONField(name = "lastShowData")
        private long lastShowData;
        @JSONField(name = "time")
        private int time;

        public final long getLastShowData() {
            return this.lastShowData;
        }

        public final void setLastShowData(long j) {
            this.lastShowData = j;
        }

        public final int getTime() {
            return this.time;
        }

        public final void setTime(int i) {
            this.time = i;
        }
    }
}