package tv.danmaku.bili.downloadeshare.panel;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.downloadsharecommon.R;
import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.DownloadShareParameter;
import tv.danmaku.bili.downloadeshare.SizeConversion;
import tv.danmaku.bili.downloadeshare.panel.DownloadVideoPanel;
import tv.danmaku.bili.downloadeshare.utils.DownloadShareHelper;
import tv.danmaku.bili.downloadeshare.view.LightCircleProgressView;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.widget.dialog.CommonDialogUtilsKt;

/* compiled from: DefaultDownloadVideoPanel.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0013\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0003H\u0000¢\u0006\u0002\b$R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/DefaultDownloadVideoPanel;", "Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "mCircleProgress", "Ltv/danmaku/bili/downloadeshare/view/LightCircleProgressView;", "mDownloadParam", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "mVideoSize", "", "mDownloadStateChangeListener", "Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel$DownloadStateChangeListener;", "onStart", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", ReportEvent.EVENT_TYPE_SHOW, "downloadInfo", "Lcom/bilibili/lib/downloadshare/api/DownloadShareInfo;", "param", "listener", "setProgress", "progress", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "lifecycle$downloadsharecommon_debug", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DefaultDownloadVideoPanel extends DownloadVideoPanel {
    public static final Companion Companion = new Companion(null);
    private static final int DIALOG_HEIGHT = 109;
    private static final int DIALOG_WIDTH = 175;
    public static final String TAG = "DownloadShareVideoPanel";
    private LightCircleProgressView mCircleProgress;
    private DownloadShareParameter mDownloadParam;
    private DownloadVideoPanel.DownloadStateChangeListener mDownloadStateChangeListener;
    private long mVideoSize;

    /* compiled from: DefaultDownloadVideoPanel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/DefaultDownloadVideoPanel$Companion;", "", "<init>", "()V", "TAG", "", "DIALOG_WIDTH", "", "DIALOG_HEIGHT", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDownloadVideoPanel(Context context) {
        this(context, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDownloadVideoPanel(Context context, int themeResId) {
        super(context, themeResId);
        Intrinsics.checkNotNullParameter(context, "context");
        Activity activity = ContextUtilKt.findActivityOrNull(context);
        if (activity != null) {
            setOwnerActivity(activity);
        }
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        Window $this$_init__u24lambda_u241 = getWindow();
        if ($this$_init__u24lambda_u241 != null) {
            $this$_init__u24lambda_u241.addFlags(MisakaHelper.MAX_REPORT_SIZE);
            $this$_init__u24lambda_u241.setDimAmount(0.0f);
            $this$_init__u24lambda_u241.setBackgroundDrawable(new ColorDrawable(0));
            $this$_init__u24lambda_u241.setGravity(17);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        WindowManager.LayoutParams $this$onStart_u24lambda_u240;
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            Window window2 = getWindow();
            if (window2 == null || ($this$onStart_u24lambda_u240 = window2.getAttributes()) == null) {
                $this$onStart_u24lambda_u240 = null;
            } else {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                $this$onStart_u24lambda_u240.width = CommonDialogUtilsKt.dp2px(175, context);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                $this$onStart_u24lambda_u240.height = CommonDialogUtilsKt.dp2px(109, context2);
            }
            window.setAttributes($this$onStart_u24lambda_u240);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        Lifecycle lifecycle$downloadsharecommon_debug;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_dialog_download_video);
        TextView textView = (TextView) findViewById(R.id.downloading);
        if (textView != null) {
            textView.setText(getContext().getString(bili.resource.share.R.string.share_global_string_40, SizeConversion.Companion.byteToSize(Long.valueOf(this.mVideoSize))));
        }
        this.mCircleProgress = (LightCircleProgressView) findViewById(R.id.progress);
        View findViewById = findViewById(R.id.close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.downloadeshare.panel.DefaultDownloadVideoPanel$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultDownloadVideoPanel.onCreate$lambda$0(DefaultDownloadVideoPanel.this, view);
                }
            });
        }
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity == null || (lifecycle$downloadsharecommon_debug = lifecycle$downloadsharecommon_debug(ownerActivity)) == null) {
            return;
        }
        lifecycle$downloadsharecommon_debug.addObserver(new LifecycleObserver() { // from class: tv.danmaku.bili.downloadeshare.panel.DefaultDownloadVideoPanel$onCreate$2
            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener;
                downloadStateChangeListener = DefaultDownloadVideoPanel.this.mDownloadStateChangeListener;
                if (downloadStateChangeListener != null) {
                    downloadStateChangeListener.onSilentDownload();
                }
                DefaultDownloadVideoPanel.this.dismiss();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener;
                downloadStateChangeListener = DefaultDownloadVideoPanel.this.mDownloadStateChangeListener;
                if (downloadStateChangeListener != null) {
                    downloadStateChangeListener.onSilentDownload();
                }
                DefaultDownloadVideoPanel.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DefaultDownloadVideoPanel this$0, View it) {
        DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener = this$0.mDownloadStateChangeListener;
        if (downloadStateChangeListener != null) {
            downloadStateChangeListener.onDownloadCanceled();
        }
        this$0.dismiss();
        this$0.onDestroy();
    }

    private final void onDestroy() {
        this.mCircleProgress = null;
        this.mDownloadParam = null;
        this.mDownloadStateChangeListener = null;
        this.mVideoSize = 0L;
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
        LightCircleProgressView lightCircleProgressView = this.mCircleProgress;
        if (lightCircleProgressView != null) {
            lightCircleProgressView.setProgress(progress);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (DownloadShareHelper.INSTANCE.isOutOfBounds(getWindow(), ev)) {
            dismiss();
            DownloadVideoPanel.DownloadStateChangeListener downloadStateChangeListener = this.mDownloadStateChangeListener;
            if (downloadStateChangeListener != null) {
                downloadStateChangeListener.onSilentDownload();
            }
            return true;
        }
        return super.dispatchTouchEvent(ev);
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
}