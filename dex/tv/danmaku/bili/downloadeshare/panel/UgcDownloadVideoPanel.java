package tv.danmaku.bili.downloadeshare.panel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bilibili.app.comm.supermenu.SuperMenu;
import com.bilibili.app.comm.supermenu.core.IMenu;
import com.bilibili.app.comm.supermenu.core.IMenuItem;
import com.bilibili.app.comm.supermenu.core.MenuGrid;
import com.bilibili.app.comm.supermenu.core.ShareMenuBuilderV2;
import com.bilibili.app.comm.supermenu.core.listeners.OnMenuItemClickListenerV2;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.downloadsharecommon.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.downloadshare.ShareDirectHelper;
import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.DownloadShareParameter;
import tv.danmaku.bili.downloadeshare.SizeConversion;
import tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel;
import tv.danmaku.bili.downloadeshare.report.DownloadShareReporter;
import tv.danmaku.bili.downloadeshare.utils.DownloadShareHelper;
import tv.danmaku.bili.downloadeshare.view.LightCircleProgressView;
import tv.danmaku.bili.downloadeshare.view.RectangleProgressView;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: UgcDownloadVideoPanel.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 B2\u00020\u0001:\u0001BB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020(H\u0014J\b\u0010,\u001a\u00020(H\u0002J\u0013\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0003H\u0000¢\u0006\u0002\b/J\b\u00100\u001a\u00020(H\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020(H\u0002J\u0006\u00107\u001a\u00020(J \u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u001dH\u0016J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020AH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006C"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/UgcDownloadVideoPanel;", "Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "mRectangleProgress", "Ltv/danmaku/bili/downloadeshare/view/RectangleProgressView;", "mLightCircleProgress", "Ltv/danmaku/bili/downloadeshare/view/LightCircleProgressView;", "mDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mDownloadParam", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "mVideoSize", "", "mDownloadVideoPanelLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "mDownloadSharePanelLayout", "mPanelPaddingValue", "mSuperMenu", "Lcom/bilibili/app/comm/supermenu/SuperMenu;", "mMenuGrid", "Lcom/bilibili/app/comm/supermenu/core/MenuGrid;", "mDownloadStateChangeListener", "Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel$DownloadStateChangeListener;", "value", "", "isSharePanel", "()Z", "sharePlatformArr", "", "", "[Ljava/lang/String;", "sharePlatformArrHD", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "initDownloadVideoPanelUi", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "lifecycle$downloadsharecommon_debug", "initDownloadSharePanelUi", "obtainShareMenus", "", "Lcom/bilibili/app/comm/supermenu/core/IMenu;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "onDestroy", "showSharePanel", ReportEvent.EVENT_TYPE_SHOW, "downloadInfo", "Lcom/bilibili/lib/downloadshare/api/DownloadShareInfo;", "param", "listener", "setProgress", "progress", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UgcDownloadVideoPanel extends DownloadVideoPanel {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "DownloadShareVideoPanel";
    private boolean isSharePanel;
    private DialogInterface.OnDismissListener mDismissListener;
    private DownloadShareParameter mDownloadParam;
    private final View mDownloadSharePanelLayout;
    private DownloadVideoPanel.DownloadStateChangeListener mDownloadStateChangeListener;
    private final View mDownloadVideoPanelLayout;
    private LightCircleProgressView mLightCircleProgress;
    private MenuGrid mMenuGrid;
    private final int mPanelPaddingValue;
    private RectangleProgressView mRectangleProgress;
    private SuperMenu mSuperMenu;
    private long mVideoSize;
    private final String[] sharePlatformArr;
    private final String[] sharePlatformArrHD;

    /* compiled from: UgcDownloadVideoPanel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/UgcDownloadVideoPanel$Companion;", "", "<init>", "()V", "TAG", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isSharePanel() {
        return this.isSharePanel;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UgcDownloadVideoPanel(Context context) {
        this(context, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcDownloadVideoPanel(Context context, int themeResId) {
        super(context, themeResId);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDownloadVideoPanelLayout = getLayoutInflater().inflate(R.layout.bili_ugc_dialog_download_video, (ViewGroup) null);
        this.mDownloadSharePanelLayout = getLayoutInflater().inflate(R.layout.bili_ugc_dialog_downloaded_share, (ViewGroup) null);
        this.mPanelPaddingValue = (int) DownloadShareHelper.INSTANCE.dp2px(getContext(), 12.0f);
        this.sharePlatformArr = new String[]{"WEIXIN", "WEIXIN_MONMENT", "QQ", "QZONE"};
        this.sharePlatformArrHD = new String[]{"WEIXIN", "WEIXIN_MONMENT"};
        Activity activity = ContextUtilKt.findActivityOrNull(context);
        if (activity != null) {
            setOwnerActivity(activity);
        }
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        Window $this$_init__u24lambda_u241 = getWindow();
        if ($this$_init__u24lambda_u241 != null) {
            $this$_init__u24lambda_u241.setFlags(32, 32);
            $this$_init__u24lambda_u241.addFlags(MisakaHelper.MAX_REPORT_SIZE);
            $this$_init__u24lambda_u241.setDimAmount(0.0f);
            $this$_init__u24lambda_u241.setBackgroundDrawable(new ColorDrawable(0));
            $this$_init__u24lambda_u241.setGravity(80);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDownloadVideoPanelUi();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        View decorView;
        WindowManager.LayoutParams $this$onStart_u24lambda_u240;
        Window window = getWindow();
        if (window != null) {
            Window window2 = getWindow();
            if (window2 == null || ($this$onStart_u24lambda_u240 = window2.getAttributes()) == null) {
                $this$onStart_u24lambda_u240 = null;
            } else {
                $this$onStart_u24lambda_u240.height = (int) DownloadShareHelper.INSTANCE.dp2px(getContext(), 76.0f);
                $this$onStart_u24lambda_u240.width = -1;
            }
            window.setAttributes($this$onStart_u24lambda_u240);
        }
        Window window3 = getWindow();
        if (window3 != null && (decorView = window3.getDecorView()) != null) {
            decorView.setPadding(this.mPanelPaddingValue, 0, this.mPanelPaddingValue, this.mPanelPaddingValue);
        }
        super.onStart();
    }

    private final void initDownloadVideoPanelUi() {
        Lifecycle lifecycle$downloadsharecommon_debug;
        this.isSharePanel = false;
        setContentView(this.mDownloadVideoPanelLayout);
        TextView textView = (TextView) this.mDownloadVideoPanelLayout.findViewById(R.id.downloading);
        if (textView != null) {
            textView.setText(getContext().getString(bili.resource.share.R.string.share_global_string_40, SizeConversion.Companion.byteToSize(Long.valueOf(this.mVideoSize))));
        }
        this.mRectangleProgress = (RectangleProgressView) this.mDownloadVideoPanelLayout.findViewById(R.id.rectangle_progress);
        this.mLightCircleProgress = (LightCircleProgressView) this.mDownloadVideoPanelLayout.findViewById(R.id.light_progress);
        View findViewById = this.mDownloadVideoPanelLayout.findViewById(R.id.close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.downloadeshare.panel.UgcDownloadVideoPanel$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UgcDownloadVideoPanel.initDownloadVideoPanelUi$lambda$0(UgcDownloadVideoPanel.this, view);
                }
            });
        }
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity == null || (lifecycle$downloadsharecommon_debug = lifecycle$downloadsharecommon_debug(ownerActivity)) == null) {
            return;
        }
        lifecycle$downloadsharecommon_debug.addObserver(new LifecycleObserver() { // from class: tv.danmaku.bili.downloadeshare.panel.UgcDownloadVideoPanel$initDownloadVideoPanelUi$2
            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener;
                downloadStateChangeListener = UgcDownloadVideoPanel.this.mDownloadStateChangeListener;
                if (downloadStateChangeListener != null) {
                    downloadStateChangeListener.onSilentDownload();
                }
                UgcDownloadVideoPanel.this.dismiss();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener;
                downloadStateChangeListener = UgcDownloadVideoPanel.this.mDownloadStateChangeListener;
                if (downloadStateChangeListener != null) {
                    downloadStateChangeListener.onSilentDownload();
                }
                UgcDownloadVideoPanel.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDownloadVideoPanelUi$lambda$0(UgcDownloadVideoPanel this$0, View it) {
        DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener = this$0.mDownloadStateChangeListener;
        if (downloadStateChangeListener != null) {
            downloadStateChangeListener.onDownloadCanceled();
        }
        this$0.dismiss();
        this$0.onDestroy();
    }

    public final Lifecycle lifecycle$downloadsharecommon_debug(Context $this$lifecycle) {
        Intrinsics.checkNotNullParameter($this$lifecycle, "<this>");
        ContextWrapper c = $this$lifecycle instanceof ContextWrapper ? (ContextWrapper) $this$lifecycle : null;
        while (c != null) {
            if (c instanceof LifecycleOwner) {
                return ((LifecycleOwner) c).getLifecycle();
            }
            Context baseContext = c.getBaseContext();
            c = baseContext instanceof ContextWrapper ? (ContextWrapper) baseContext : null;
        }
        return null;
    }

    private final void initDownloadSharePanelUi() {
        this.isSharePanel = true;
        setContentView(this.mDownloadSharePanelLayout);
        this.mMenuGrid = this.mDownloadSharePanelLayout.findViewById(R.id.share_super_menu);
        ImageView imageView = (ImageView) this.mDownloadSharePanelLayout.findViewById(R.id.iv_close);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.downloadeshare.panel.UgcDownloadVideoPanel$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UgcDownloadVideoPanel.this.dismiss();
                }
            });
        }
        final Activity activity = getOwnerActivity();
        if (activity != null) {
            this.mSuperMenu = SuperMenu.with(activity);
            SuperMenu $this$initDownloadSharePanelUi_u24lambda_u241_u240 = this.mSuperMenu;
            if ($this$initDownloadSharePanelUi_u24lambda_u241_u240 != null) {
                $this$initDownloadSharePanelUi_u24lambda_u241_u240.attach(this.mMenuGrid);
                $this$initDownloadSharePanelUi_u24lambda_u241_u240.setClickItemDismiss(false);
                $this$initDownloadSharePanelUi_u24lambda_u241_u240.addMenus(obtainShareMenus(activity));
                $this$initDownloadSharePanelUi_u24lambda_u241_u240.itemClickListener(new OnMenuItemClickListenerV2() { // from class: tv.danmaku.bili.downloadeshare.panel.UgcDownloadVideoPanel$$ExternalSyntheticLambda2
                    public final boolean onItemClick(IMenuItem iMenuItem) {
                        boolean initDownloadSharePanelUi$lambda$1$0$0;
                        initDownloadSharePanelUi$lambda$1$0$0 = UgcDownloadVideoPanel.initDownloadSharePanelUi$lambda$1$0$0(activity, this, iMenuItem);
                        return initDownloadSharePanelUi$lambda$1$0$0;
                    }
                });
            }
            SuperMenu superMenu = this.mSuperMenu;
            if (superMenu != null) {
                superMenu.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initDownloadSharePanelUi$lambda$1$0$0(Activity $activity, UgcDownloadVideoPanel this$0, IMenuItem menuItem) {
        String id = menuItem.getItemId();
        if (id != null) {
            if (!DownloadShareHelper.INSTANCE.checkInstalledThirdPartChannel(id, $activity)) {
                Activity activity = $activity;
                Application application = BiliContext.application();
                ToastHelper.showToast(activity, application != null ? application.getString(bili.resource.share.R.string.share_global_string_33) : null, 0, 17);
                return true;
            }
            DownloadShareParameter parameter = this$0.mDownloadParam;
            DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
            String valueOf = String.valueOf(parameter != null ? Long.valueOf(parameter.getAvid()) : null);
            DownloadShareParameter downloadShareParameter = this$0.mDownloadParam;
            String spmid = downloadShareParameter != null ? downloadShareParameter.getSpmid() : null;
            DownloadShareParameter downloadShareParameter2 = this$0.mDownloadParam;
            String objectExtraFields = downloadShareParameter2 != null ? downloadShareParameter2.getObjectExtraFields() : null;
            DownloadShareParameter downloadShareParameter3 = this$0.mDownloadParam;
            downloadShareReporter.reportDownloadShareMenuItemClick(valueOf, id, spmid, objectExtraFields, downloadShareParameter3 != null ? downloadShareParameter3.getSid() : null);
            ShareDirectHelper.Companion.openThirdApp($activity, id);
            this$0.dismiss();
            return true;
        }
        return true;
    }

    private final List<IMenu> obtainShareMenus(Activity activity) {
        String[] strArr;
        ShareMenuBuilderV2 from = ShareMenuBuilderV2.from(activity);
        if (AppBuildConfig.Companion.isHDApp()) {
            strArr = this.sharePlatformArrHD;
        } else {
            strArr = this.sharePlatformArr;
        }
        List<IMenu> buildWithNoInstallCheck = from.addLine(strArr).hasShareTitle(false).buildWithNoInstallCheck();
        Intrinsics.checkNotNullExpressionValue(buildWithNoInstallCheck, "buildWithNoInstallCheck(...)");
        return buildWithNoInstallCheck;
    }

    private final void onDestroy() {
        this.mRectangleProgress = null;
        this.mLightCircleProgress = null;
        this.mDismissListener = null;
        this.mDownloadParam = null;
        this.mVideoSize = 0L;
    }

    public final void showSharePanel() {
        View decorView;
        WindowManager.LayoutParams $this$showSharePanel_u24lambda_u240;
        Window window = getWindow();
        if (window != null) {
            Window window2 = getWindow();
            if (window2 == null || ($this$showSharePanel_u24lambda_u240 = window2.getAttributes()) == null) {
                $this$showSharePanel_u24lambda_u240 = null;
            } else {
                $this$showSharePanel_u24lambda_u240.height = -2;
                $this$showSharePanel_u24lambda_u240.width = -1;
            }
            window.setAttributes($this$showSharePanel_u24lambda_u240);
        }
        Window window3 = getWindow();
        if (window3 != null && (decorView = window3.getDecorView()) != null) {
            decorView.setPadding(this.mPanelPaddingValue, 0, this.mPanelPaddingValue, this.mPanelPaddingValue);
        }
        initDownloadSharePanelUi();
        DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
        DownloadShareParameter downloadShareParameter = this.mDownloadParam;
        String valueOf = String.valueOf(downloadShareParameter != null ? Long.valueOf(downloadShareParameter.getAvid()) : null);
        DownloadShareParameter downloadShareParameter2 = this.mDownloadParam;
        DownloadShareReporter.reportDownloadShareMenuShow$default(downloadShareReporter, valueOf, null, null, downloadShareParameter2 != null ? downloadShareParameter2.getSid() : null, 6, null);
    }

    @Override // tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel
    public void show(DownloadShareInfo downloadInfo, DownloadShareParameter param, DownloadVideoPanel.DownloadStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mDownloadStateChangeListener = listener;
        this.mVideoSize = downloadInfo.getSize();
        this.mDownloadParam = param;
        super.show();
    }

    @Override // tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel
    public void setProgress(int progress) {
        RectangleProgressView rectangleProgressView = this.mRectangleProgress;
        if (rectangleProgressView != null) {
            rectangleProgressView.setProgress(progress);
        }
        LightCircleProgressView lightCircleProgressView = this.mLightCircleProgress;
        if (lightCircleProgressView != null) {
            lightCircleProgressView.setProgress(progress);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (DownloadShareHelper.INSTANCE.isOutOfBounds(getWindow(), ev)) {
            Activity ownerActivity = getOwnerActivity();
            if (ownerActivity != null) {
                ownerActivity.dispatchTouchEvent(ev);
            }
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }
}