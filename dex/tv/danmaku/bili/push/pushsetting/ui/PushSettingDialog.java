package tv.danmaku.bili.push.pushsetting.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.NotificationSettingHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import com.bilibili.lib.neuron.api.Neurons;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.R;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.widget.BaseDialog;

public class PushSettingDialog extends BaseDialog<PushSettingDialog> {
    private static final String PUSH_SETTING_GIF_DAY = "main_push_setting_day.webp";
    private static final String PUSH_SETTING_GIF_NIGHT = "main_push_setting_night.webp";
    public static final String PUSH_SETTING_TRACK_ID = "notificationgrowth.after.pushclick.track";
    private static final String TAG = "PushSettingDialog";
    private boolean afterOnStop;
    private String mAbMsg;
    private Activity mActivity;
    private StaticImageView2 mImageView;
    private String mMessage;
    private String mTitle;
    private String mTypeFrom;
    private LifecycleEventObserver observer;
    private final Runnable routerErrorTrack;

    /* renamed from: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    class AnonymousClass1 implements LifecycleEventObserver {
        AnonymousClass1() {
        }

        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_STOP || (PushSettingDialog.this.afterOnStop && event == Lifecycle.Event.ON_RESUME)) {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("open_success", "1");
                hashMap.put("lifecycle", event.toString());
                Context context = BiliContext.application();
                if (context != null) {
                    hashMap.put("switch_on", NotificationSettingHelper.isNotificationEnable(context) ? "2" : "1");
                }
                Neurons.trackT(true, PushSettingDialog.PUSH_SETTING_TRACK_ID, hashMap, 1, new Function0() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return PushSettingDialog.AnonymousClass1.lambda$onStateChanged$0();
                    }
                });
                if (event == Lifecycle.Event.ON_STOP) {
                    PushSettingDialog.this.afterOnStop = true;
                    HandlerThreads.getHandler(0).removeCallbacks(PushSettingDialog.this.routerErrorTrack);
                    return;
                }
                source.getLifecycle().removeObserver(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Boolean lambda$onStateChanged$0() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$tv-danmaku-bili-push-pushsetting-ui-PushSettingDialog  reason: not valid java name */
    public /* synthetic */ void m1272lambda$new$1$tvdanmakubilipushpushsettinguiPushSettingDialog() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("open_success", "0");
        Neurons.trackT(true, PUSH_SETTING_TRACK_ID, hashMap, 1, new Function0() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog$$ExternalSyntheticLambda0
            public final Object invoke() {
                return PushSettingDialog.lambda$new$0();
            }
        });
        this.mActivity.getLifecycle().removeObserver(this.observer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$new$0() {
        return true;
    }

    public PushSettingDialog(Activity activity, String title, String message, String typeFrom) {
        super(activity, true);
        this.afterOnStop = false;
        this.observer = new AnonymousClass1();
        this.routerErrorTrack = new Runnable() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PushSettingDialog.this.m1272lambda$new$1$tvdanmakubilipushpushsettinguiPushSettingDialog();
            }
        };
        this.mActivity = activity;
        this.mTitle = title;
        this.mMessage = message;
        this.mTypeFrom = typeFrom;
        setOwnerActivity(activity);
        setCanceledOnTouchOutside(false);
    }

    public View onCreateView() {
        View dialogLayout = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_layout_dialog_push_setting, (ViewGroup) null);
        View content = dialogLayout.findViewById(R.id.content);
        content.setBackground(ContextCompat.getDrawable(this.mActivity, com.bilibili.app.comm.baseres.R.drawable.shape_roundrect_solid_white_radius_8));
        TextView title = (TextView) dialogLayout.findViewById(R.id.text1);
        title.setText(this.mTitle);
        TextView message = (TextView) dialogLayout.findViewById(R.id.text2);
        message.setText(this.mMessage);
        View close = dialogLayout.findViewById(R.id.image_close);
        close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PushSettingDialog.this.reportClick(false);
                MainDialogManager.showNextDialog("push_guide", false, PushSettingDialog.this.getContext());
                PushSettingDialog.this.dismiss();
            }
        });
        TextView open = (TextView) dialogLayout.findViewById(R.id.text4);
        open.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PushSettingDialog.this.mActivity instanceof AppCompatActivity) {
                    PushSettingDialog.this.mActivity.getLifecycle().addObserver(PushSettingDialog.this.observer);
                    HandlerThreads.getHandler(0).postDelayed(PushSettingDialog.this.routerErrorTrack, 1000L);
                }
                PushSettingDialog.this.reportClick(true);
                PushSettingDialog.this.openSystemNotificationSetting(PushSettingDialog.this.mActivity);
                MainDialogManager.showNextDialog("push_guide", true, PushSettingDialog.this.getContext());
                PushSettingDialog.this.dismiss();
            }
        });
        this.mImageView = dialogLayout.findViewById(R.id.image);
        recordPushDialogLog(this.mActivity, "push dialog has show.");
        return dialogLayout;
    }

    public void setUiBeforeShow() {
        if (this.mImageView != null && this.mActivity != null) {
            boolean isNightTheme = BiliTheme.isNightTheme(this.mActivity);
            ModResource modResource = ModResourceClient.getInstance().get(this.mActivity, "mainSiteAndroid", "combus_bigImages");
            String path = modResource.getResourceDirPath();
            boolean isAvailable = modResource.isAvailable();
            String str = PUSH_SETTING_GIF_NIGHT;
            if (path == null || !isAvailable) {
                ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.mActivity);
                if (!isNightTheme) {
                    str = PUSH_SETTING_GIF_DAY;
                }
                with.url(AppResUtil.getImageUrl(str)).placeholderImageResId(isNightTheme ? com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_night : com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_day).enableAutoPlayAnimation(true).into(this.mImageView);
                return;
            }
            File imageRes = isNightTheme ? modResource.retrieveFile(PUSH_SETTING_GIF_NIGHT) : modResource.retrieveFile(PUSH_SETTING_GIF_DAY);
            if (imageRes != null) {
                BLog.d(TAG, "use ModManager resource");
                BiliImageLoader.INSTANCE.with(this.mActivity).url(BusinessSplashDefine.FILE_URI_PREFIX + imageRes.getPath()).placeholderImageResId(isNightTheme ? com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_night : com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_day).enableAutoPlayAnimation(true).into(this.mImageView);
                return;
            }
            ImageRequestBuilder with2 = BiliImageLoader.INSTANCE.with(this.mActivity);
            if (!isNightTheme) {
                str = PUSH_SETTING_GIF_DAY;
            }
            with2.url(AppResUtil.getImageUrl(str)).placeholderImageResId(isNightTheme ? com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_night : com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_day).enableAutoPlayAnimation(true).into(this.mImageView);
        }
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setLayout(-1, -2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClick(boolean isOpen) {
        PushSettingReporterKt.reportPushDialogClick(PushDialogType.DIY, this.mTypeFrom, "", isOpen ? "1" : "0", "", this.mAbMsg, 1);
        recordPushDialogLog(this.mActivity, "push dialog has click and is open:" + isOpen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSystemNotificationSetting(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", activity.getPackageName());
            intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        }
        try {
            recordPushDialogLog(this.mActivity, "current build version:" + Build.VERSION.SDK_INT);
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            recordPushDialogLog(this.mActivity, "start app notification settings error:" + e);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
            try {
                recordPushDialogLog(this.mActivity, "try start app notification settings again.");
                activity.startActivity(intent);
            } catch (ActivityNotFoundException e1) {
                recordPushDialogLog(this.mActivity, "start app notification settings error again:" + e);
                e1.printStackTrace();
            }
        }
    }

    private static void recordPushDialogLog(Context context, String message) {
        BLog.i(TAG, message);
    }
}