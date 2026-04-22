package tv.danmaku.bili.ui.main.imagerecognize;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.app.qrcode.image.QRImageDecode;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.homepage.HomePageJumpService;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.resmanager.ResDownloadRequest;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.utils.ExBilowUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;
import tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeApi;
import tv.danmaku.bili.ui.splash.ClipboardJumpHelper;

/* compiled from: ImageRecognizeHelper.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u0010.\u001a\u00020*H\u0003J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u000202H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020*H\u0003J\u0012\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u0005H\u0003J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0005H\u0002J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u0010?\u001a\u0004\u0018\u00010\u0005H\u0003J\u0012\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u000202H\u0003J\b\u0010B\u001a\u00020\u0010H\u0002J\u0012\u0010C\u001a\u00020\u00102\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010F\u001a\u00020(2\u0006\u0010A\u001a\u000202H\u0002J\b\u0010G\u001a\u000200H\u0002J\b\u0010H\u001a\u000200H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\u0018\u0010J\u001a\u00020(2\u0006\u0010.\u001a\u00020*2\u0006\u0010K\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0002J(\u0010S\u001a\u00020(2\u0006\u0010T\u001a\u00020\u00072\u0016\b\u0002\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010VH\u0002J\u001c\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050V2\u0006\u0010X\u001a\u000202H\u0002J\u0015\u0010Y\u001a\u00020(2\u0006\u0010X\u001a\u000202H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020(2\u0006\u0010X\u001a\u000202H\u0000¢\u0006\u0002\b\\R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b<\u0010=R\u000e\u0010M\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ImageRecognizeHelper;", "", "<init>", "()V", "TAG", "", "MAX_IMAGE_SIZE", "", "MODIFY_TIME_INTERVAL_HOUR", "DEFAULT_TIME_OUT_SECONDS", "SERVER_PARSER_ERROR", "PREF_KEY_LAST_RECOGNIZE_FILENAME", "URI_IMAGE_RECOGNIZE_DIALOG", "URI_IMAGE_RECOGNIZE_UP_DIALOG", "DEFAULT_URL_REG", "mHasTimeout", "", "mHasResult", "mQrDecoder", "Lcom/bilibili/app/qrcode/image/QRImageDecode;", "getMQrDecoder", "()Lcom/bilibili/app/qrcode/image/QRImageDecode;", "mQrDecoder$delegate", "Lkotlin/Lazy;", "mClipboardService", "Lcom/bilibili/homepage/HomePageJumpService;", "getMClipboardService", "()Lcom/bilibili/homepage/HomePageJumpService;", "mClipboardService$delegate", "CONJUNCTION_SQL", "DESC", "SELECTION_IMAGE_MIME_TYPE", "SELECTION_ARGS_IMAGE_MIME_TYPE", "", "[Ljava/lang/String;", "COLUMN", "ORDER", "mRecognizeOb", "Landroidx/lifecycle/Observer;", "onStartup", "", "ctx", "Landroid/content/Context;", "doImageRecognize", "imageRecognizeInternal", "startTimeoutCounter", "context", "getTimeoutConfig", "", "fetchImageUrlInfo", "Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "checkBuvid", "imageUrlInfo", "findPicPath", "recognize", FileChooserActivity.PATH, "matchReg", "result", ReportEvent.Tag.API, "Ltv/danmaku/bili/ui/main/imagerecognize/ImageRecognizeApi;", "getApi", "()Ltv/danmaku/bili/ui/main/imagerecognize/ImageRecognizeApi;", "api$delegate", "url", "downloadPic", "data", "canShowDialog", "isInMutiWindowMode", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "showDialog", "getMaxSizeLimit", "getMaxIntervalTime", "isEnable", "saveRecognizeFilename", "filename", "getLastRecognizeFilename", "REASON_NO_PERMISSION", "REASON_PARSE_ERROR", "REASON_SAME_PIC", "REASON_TIME_EXPIRED", "REASON_SAME_SHARER", "REASON_OTHER", "reportNotShow", "reason", InnerPushReceiverKt.KEY_EXTRA, "", "buildReportExtra", "info", "reportDialogClick", "reportDialogClick$core_apinkDebug", "reportDialogShow", "reportDialogShow$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageRecognizeHelper {
    private static final String CONJUNCTION_SQL = "=? or ";
    private static final int DEFAULT_TIME_OUT_SECONDS = 5;
    private static final String DEFAULT_URL_REG = "^https://(b23.tv|(bili2233|bili23|bili33|bili22).cn)/[0-9a-zA-Z]{6,8}$";
    private static final String DESC = " desc";
    private static final int MAX_IMAGE_SIZE = 5;
    private static final int MODIFY_TIME_INTERVAL_HOUR = 2;
    private static final String ORDER = "date_modified desc LIMIT 1";
    private static final String PREF_KEY_LAST_RECOGNIZE_FILENAME = "share.image_last_recognize_file_name";
    private static final int REASON_NO_PERMISSION = 1;
    private static final int REASON_OTHER = 6;
    private static final int REASON_PARSE_ERROR = 2;
    private static final int REASON_SAME_PIC = 3;
    private static final int REASON_SAME_SHARER = 5;
    private static final int REASON_TIME_EXPIRED = 4;
    private static final String SELECTION_IMAGE_MIME_TYPE = "mime_type=? or mime_type=? or mime_type=? or mime_type=? or mime_type=?";
    private static final int SERVER_PARSER_ERROR = 110004;
    private static final String TAG = "ImageRecognizeHelper";
    private static final String URI_IMAGE_RECOGNIZE_DIALOG = "bilibili://main/image-recognize-dialog";
    private static final String URI_IMAGE_RECOGNIZE_UP_DIALOG = "bilibili://main/image-recognize-up-dialog";
    private static boolean mHasResult;
    private static boolean mHasTimeout;
    private static Observer<Integer> mRecognizeOb;
    public static final ImageRecognizeHelper INSTANCE = new ImageRecognizeHelper();
    private static final Lazy mQrDecoder$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda4
        public final Object invoke() {
            QRImageDecode mQrDecoder_delegate$lambda$0;
            mQrDecoder_delegate$lambda$0 = ImageRecognizeHelper.mQrDecoder_delegate$lambda$0();
            return mQrDecoder_delegate$lambda$0;
        }
    });
    private static final Lazy mClipboardService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda5
        public final Object invoke() {
            HomePageJumpService mClipboardService_delegate$lambda$0;
            mClipboardService_delegate$lambda$0 = ImageRecognizeHelper.mClipboardService_delegate$lambda$0();
            return mClipboardService_delegate$lambda$0;
        }
    });
    private static final String[] SELECTION_ARGS_IMAGE_MIME_TYPE = {"image/jpeg", "image/png", "image/jpg", "image/heif", "image/heic"};
    private static final String[] COLUMN = {"_id", "_data", "_size", "date_modified", "_display_name"};
    private static final Lazy api$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda6
        public final Object invoke() {
            ImageRecognizeApi api_delegate$lambda$0;
            api_delegate$lambda$0 = ImageRecognizeHelper.api_delegate$lambda$0();
            return api_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private ImageRecognizeHelper() {
    }

    private final QRImageDecode getMQrDecoder() {
        return (QRImageDecode) mQrDecoder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QRImageDecode mQrDecoder_delegate$lambda$0() {
        return new QRImageDecode();
    }

    private final HomePageJumpService getMClipboardService() {
        return (HomePageJumpService) mClipboardService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomePageJumpService mClipboardService_delegate$lambda$0() {
        return (HomePageJumpService) BLRouter.INSTANCE.get(HomePageJumpService.class, "HomePageJumpService");
    }

    @JvmStatic
    public static final void onStartup(Context ctx) {
        MutableLiveData jumpStatus;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        final Context appCtx = ctx.getApplicationContext();
        if (mRecognizeOb == null) {
            mRecognizeOb = new Observer() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda1
                public final void onChanged(Object obj) {
                    ImageRecognizeHelper.onStartup$lambda$0(appCtx, ((Integer) obj).intValue());
                }
            };
            HomePageJumpService mClipboardService = INSTANCE.getMClipboardService();
            if (mClipboardService == null || (jumpStatus = mClipboardService.getJumpStatus()) == null) {
                return;
            }
            Observer<Integer> observer = mRecognizeOb;
            Intrinsics.checkNotNull(observer);
            jumpStatus.observeForever(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartup$lambda$0(Context $appCtx, int it) {
        if (it == 3) {
            ImageRecognizeHelper imageRecognizeHelper = INSTANCE;
            Intrinsics.checkNotNull($appCtx);
            imageRecognizeHelper.doImageRecognize($appCtx);
        }
    }

    private final void doImageRecognize(final Context ctx) {
        if (!isEnable()) {
            return;
        }
        MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("share_image_recognize", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda7
            public final void onShow() {
                ImageRecognizeHelper.doImageRecognize$lambda$0(ctx);
            }
        }, 1030, false);
        dialogInfo.setMainOnly(false);
        dialogInfo.setRepeat(true);
        MainDialogManager.addDialog(dialogInfo, ctx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doImageRecognize$lambda$0(Context $ctx) {
        INSTANCE.imageRecognizeInternal($ctx);
    }

    private final void imageRecognizeInternal(final Context ctx) {
        mHasTimeout = false;
        mHasResult = false;
        startTimeoutCounter(ctx);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ImageUrlInfo imageRecognizeInternal$lambda$0;
                imageRecognizeInternal$lambda$0 = ImageRecognizeHelper.imageRecognizeInternal$lambda$0(ctx);
                return imageRecognizeInternal$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda3
            public final Object then(Task task) {
                Void imageRecognizeInternal$lambda$1;
                imageRecognizeInternal$lambda$1 = ImageRecognizeHelper.imageRecognizeInternal$lambda$1(ctx, task);
                return imageRecognizeInternal$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageUrlInfo imageRecognizeInternal$lambda$0(Context $ctx) {
        return INSTANCE.fetchImageUrlInfo($ctx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void imageRecognizeInternal$lambda$1(Context $ctx, Task it) {
        mHasResult = true;
        if (!INSTANCE.canShowDialog()) {
            BLog.i(TAG, "Can not show dialog cause clipboard jumped or not foreground.");
            reportNotShow$default(INSTANCE, 6, null, 2, null);
            MainDialogManager.showNextDialog("share_image_recognize", false, $ctx);
            return null;
        } else if (it.isFaulted() || it.getResult() == null || mHasTimeout) {
            BLog.i(TAG, "Can not show dialog cause image fetch error or timeout.");
            MainDialogManager.showNextDialog("share_image_recognize", false, $ctx);
            return null;
        } else {
            ImageRecognizeHelper imageRecognizeHelper = INSTANCE;
            Object result = it.getResult();
            Intrinsics.checkNotNull(result);
            imageRecognizeHelper.showDialog((ImageUrlInfo) result);
            return null;
        }
    }

    private final void startTimeoutCounter(final Context context) {
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ImageRecognizeHelper.startTimeoutCounter$lambda$0(context);
            }
        }, getTimeoutConfig());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTimeoutCounter$lambda$0(Context $context) {
        mHasTimeout = true;
        if (!mHasResult) {
            MainDialogManager.showNextDialog("share_image_recognize", false, $context);
        }
    }

    private final long getTimeoutConfig() {
        int config = 5;
        try {
            String str = (String) ConfigManager.Companion.config().get("share.img_detector_timeout_limit", "5");
            if (str != null) {
                config = Integer.parseInt(str);
            }
        } catch (Exception e) {
        }
        return config * 1000;
    }

    private final ImageUrlInfo fetchImageUrlInfo(Context context) {
        try {
            String path = findPicPath(context);
            if (!TextUtils.isEmpty(path)) {
                BLog.i(TAG, "Image fetch success.");
                Intrinsics.checkNotNull(path);
                saveRecognizeFilename(context, path);
                String result = recognize(path);
                if (!TextUtils.isEmpty(result)) {
                    Intrinsics.checkNotNull(result);
                    if (matchReg(result)) {
                        BLog.i(TAG, "Image QrCode recognize success.");
                        ImageUrlInfo imageUrlInfo = fetchImageUrlInfo(result);
                        if (imageUrlInfo != null && imageUrlInfo.isValid()) {
                            if (!checkBuvid(imageUrlInfo)) {
                                return null;
                            }
                            String imageLocalPath = downloadPic(imageUrlInfo);
                            if (TextUtils.isEmpty(imageLocalPath)) {
                                reportNotShow(6, buildReportExtra(imageUrlInfo));
                                BLog.i(TAG, "Cover download error.");
                                return null;
                            }
                            imageUrlInfo.setImageLocalPath(imageLocalPath);
                            BLog.i(TAG, "Image recognize success.");
                            return imageUrlInfo;
                        }
                        BLog.i(TAG, "Image url info fetch error.");
                        return null;
                    }
                }
                reportNotShow$default(this, 2, null, 2, null);
                BLog.i(TAG, "Image recognize success. But not match regex.");
                return null;
            }
            return null;
        } catch (Exception e) {
            BLog.e(TAG, "Image fetch error.", e);
            return null;
        }
    }

    private final boolean checkBuvid(ImageUrlInfo imageUrlInfo) {
        if (TextUtils.isEmpty(imageUrlInfo.getShareBuvid()) && !imageUrlInfo.isStory()) {
            BLog.i(TAG, "Stop Dialog show cause buvid empty and not story.");
            reportNotShow(6, buildReportExtra(imageUrlInfo));
            return false;
        } else if (TextUtils.equals(imageUrlInfo.getShareBuvid(), BuvidHelper.getBuvid())) {
            BLog.i(TAG, "Stop Dialog show cause buvid same to mine.");
            reportNotShow(5, buildReportExtra(imageUrlInfo));
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0110, code lost:
        if (0 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0113, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String findPicPath(Context context) {
        Cursor query;
        if (!PermissionsChecker.checkSelfPermissions(context, PermissionsChecker.STORAGE_PERMISSIONS)) {
            BLog.i(TAG, "Stop recognize cause has no permission.");
            reportNotShow$default(this, 1, null, 2, null);
            return null;
        }
        Cursor cursor = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    String[] strArr = COLUMN;
                    Bundle $this$findPicPath_u24lambda_u240 = new Bundle();
                    $this$findPicPath_u24lambda_u240.putString("android:query-arg-sql-selection", SELECTION_IMAGE_MIME_TYPE);
                    $this$findPicPath_u24lambda_u240.putStringArray("android:query-arg-sql-selection-args", SELECTION_ARGS_IMAGE_MIME_TYPE);
                    $this$findPicPath_u24lambda_u240.putString("android:query-arg-sql-sort-order", "date_modified desc");
                    $this$findPicPath_u24lambda_u240.putInt("android:query-arg-limit", 1);
                    Unit unit = Unit.INSTANCE;
                    query = contentResolver.query(uri, strArr, $this$findPicPath_u24lambda_u240, null);
                } else {
                    query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, COLUMN, SELECTION_IMAGE_MIME_TYPE, SELECTION_ARGS_IMAGE_MIME_TYPE, ORDER);
                }
                cursor = query;
                if (cursor != null && cursor.moveToFirst()) {
                    String picPath = cursor.getString(cursor.getColumnIndex("_data"));
                    if (TextUtils.equals(picPath, getLastRecognizeFilename(context))) {
                        reportNotShow$default(this, 3, null, 2, null);
                        BLog.i(TAG, "Stop recognize cause picture has recognized.");
                        cursor.close();
                        return null;
                    } else if (TextUtils.isEmpty(picPath)) {
                        reportNotShow$default(this, 6, null, 2, null);
                        BLog.i(TAG, "Stop recognize cause no picture path.");
                        cursor.close();
                        return null;
                    } else {
                        long lastModifyTime = cursor.getLong(cursor.getColumnIndex("date_modified"));
                        if ((System.currentTimeMillis() / 1000) - lastModifyTime > getMaxIntervalTime()) {
                            reportNotShow$default(this, 4, null, 2, null);
                            BLog.i(TAG, "Stop recognize cause picture not fresh.");
                            cursor.close();
                            return null;
                        }
                        long size = cursor.getLong(cursor.getColumnIndex("_size"));
                        if (size <= getMaxSizeLimit()) {
                            cursor.close();
                            return picPath;
                        }
                        reportNotShow$default(this, 6, null, 2, null);
                        BLog.i(TAG, "Stop recognize cause picture too large.");
                        cursor.close();
                        return null;
                    }
                }
            } catch (Exception e) {
                BLog.e(TAG, "Find pic error.", e);
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    private final String recognize(String path) {
        return getMQrDecoder().decode(path);
    }

    private final boolean matchReg(String result) {
        String regex = DEFAULT_URL_REG;
        try {
            String str = (String) ConfigManager.Companion.config().get("share.img_detected_link_regular", DEFAULT_URL_REG);
            if (str != null) {
                regex = str;
            }
            Pattern pattern = Pattern.compile(regex, 2);
            return pattern.matcher(result).find();
        } catch (Exception e) {
            return false;
        }
    }

    private final ImageRecognizeApi getApi() {
        return (ImageRecognizeApi) api$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageRecognizeApi api_delegate$lambda$0() {
        return (ImageRecognizeApi) ServiceGenerator.createService(ImageRecognizeApi.class);
    }

    private final ImageUrlInfo fetchImageUrlInfo(String url) {
        try {
            ImageUrlInfo $this$fetchImageUrlInfo_u24lambda_u240 = (ImageUrlInfo) ExBilowUtil.extractResponseData(ImageRecognizeApi.CC.fetchImageUrlInfo$default(getApi(), url, null, 2, null).execute());
            if ($this$fetchImageUrlInfo_u24lambda_u240 != null) {
                $this$fetchImageUrlInfo_u24lambda_u240.setOriginUrl(url);
                return $this$fetchImageUrlInfo_u24lambda_u240;
            }
            return null;
        } catch (Exception e) {
            if (!(e instanceof BiliApiException) || e.mCode != SERVER_PARSER_ERROR) {
                reportNotShow$default(this, 6, null, 2, null);
            } else {
                reportNotShow$default(this, 2, null, 2, null);
            }
            BLog.i(TAG, "Image url info fetch error.", (Throwable) e);
            return null;
        }
    }

    private final String downloadPic(ImageUrlInfo data) {
        ResRequest reportBizType = new ResDownloadRequest(data.getPicUrl(), (String) null, 2, (DefaultConstructorMarker) null).reportBizType("mtc_image");
        ResManager.downloadSync(reportBizType);
        ResResponse fetch = ResManager.fetch(reportBizType);
        if (fetch != null) {
            return fetch.getPath();
        }
        return null;
    }

    private final boolean canShowDialog() {
        return (ClipboardJumpHelper.isClipboardJumped() || !BiliContext.isForeground() || isInMutiWindowMode(BiliContext.topActivitiy())) ? false : true;
    }

    private final boolean isInMutiWindowMode(Activity activity) {
        return activity != null && Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode();
    }

    private final void showDialog(final ImageUrlInfo data) {
        String str;
        if (data.isUpShare()) {
            str = URI_IMAGE_RECOGNIZE_UP_DIALOG;
        } else {
            str = URI_IMAGE_RECOGNIZE_DIALOG;
        }
        RouteRequest routeRequest = new RouteRequest.Builder(str).extras(new Function1() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showDialog$lambda$0;
                showDialog$lambda$0 = ImageRecognizeHelper.showDialog$lambda$0(ImageUrlInfo.this, (MutableBundleLike) obj);
                return showDialog$lambda$0;
            }
        }).build();
        BLRouter.routeTo$default(routeRequest, (Context) null, 2, (Object) null);
        BLog.i(TAG, "Show Image recognize dialog.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDialog$lambda$0(ImageUrlInfo $data, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        Bundle bundle = new Bundle();
        bundle.putParcelable(ImageRecognizeDialogActivityKt.ARGS_IMAGE_URL_INFO, $data);
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        $this$extras.put(str, bundle);
        return Unit.INSTANCE;
    }

    private final long getMaxSizeLimit() {
        int sizeConfig = 5;
        try {
            String str = (String) ConfigManager.Companion.config().get("share.img_detector_size_limit", "5");
            if (str != null) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(str));
                int it = valueOf.intValue();
                if (!(it > 0)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    sizeConfig = valueOf.intValue();
                }
            }
        } catch (Exception e) {
        }
        return sizeConfig * MisakaHelper.MAX_REPORT_SIZE * 1024;
    }

    private final long getMaxIntervalTime() {
        int interval = 2;
        try {
            String str = (String) ConfigManager.Companion.config().get("share.img_detected_save_time_limit", "2");
            if (str != null) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(str));
                int it = valueOf.intValue();
                if (!(it > 0)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    interval = valueOf.intValue();
                }
            }
        } catch (Exception e) {
        }
        return interval * 60 * 60;
    }

    private final boolean isEnable() {
        boolean switchEnable = Intrinsics.areEqual(ConfigManager.Companion.ab().get("share.img_detector_enable", true), true);
        return switchEnable && !RestrictedMode.isRestrictedMode();
    }

    private final void saveRecognizeFilename(Context context, String filename) {
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(PREF_KEY_LAST_RECOGNIZE_FILENAME, filename).apply();
    }

    private final String getLastRecognizeFilename(Context ctx) {
        String string = BiliGlobalPreferenceHelper.getBLKVSharedPreference(ctx).getString(PREF_KEY_LAST_RECOGNIZE_FILENAME, "");
        return string == null ? "" : string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportNotShow$default(ImageRecognizeHelper imageRecognizeHelper, int i, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        imageRecognizeHelper.reportNotShow(i, map);
    }

    private final void reportNotShow(int reason, Map<String, String> map) {
        Map map2 = new LinkedHashMap();
        map2.put("reason", String.valueOf(reason));
        if (map != null) {
            map2.putAll(map);
        }
        Neurons.reportExposure$default(false, "main.recommend.window.close.show", map2, (List) null, 8, (Object) null);
    }

    private final Map<String, String> buildReportExtra(ImageUrlInfo info) {
        Pair[] pairArr = new Pair[7];
        String shareBuvid = info.getShareBuvid();
        if (shareBuvid == null) {
            shareBuvid = "";
        }
        pairArr[0] = TuplesKt.to("share_buvid", shareBuvid);
        String originUrl = info.getOriginUrl();
        if (originUrl == null) {
            originUrl = "";
        }
        pairArr[1] = TuplesKt.to("url", originUrl);
        pairArr[2] = TuplesKt.to("share_type", String.valueOf(info.getShareType()));
        String shareTime = info.getShareTime();
        if (shareTime == null) {
            shareTime = "";
        }
        pairArr[3] = TuplesKt.to("share_time", shareTime);
        String shareId = info.getShareId();
        if (shareId == null) {
            shareId = "";
        }
        pairArr[4] = TuplesKt.to("share_id", shareId);
        String shareOrigin = info.getShareOrigin();
        if (shareOrigin == null) {
            shareOrigin = "";
        }
        pairArr[5] = TuplesKt.to("share_origin", shareOrigin);
        String extra = info.getExtra();
        pairArr[6] = TuplesKt.to(InnerPushReceiverKt.KEY_EXTRA, extra != null ? extra : "");
        return MapsKt.mapOf(pairArr);
    }

    public final void reportDialogClick$core_apinkDebug(ImageUrlInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Neurons.reportClick(false, "main.recommend.window.0.click", buildReportExtra(info));
    }

    public final void reportDialogShow$core_apinkDebug(ImageUrlInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Neurons.reportExposure$default(false, "main.recommend.window.0.show", buildReportExtra(info), (List) null, 8, (Object) null);
    }
}