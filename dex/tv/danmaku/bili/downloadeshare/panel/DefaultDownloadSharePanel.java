package tv.danmaku.bili.downloadeshare.panel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.DownloadShareContext;
import tv.danmaku.bili.downloadeshare.DownloadShareParameter;
import tv.danmaku.bili.downloadeshare.report.DownloadShareReporter;
import tv.danmaku.bili.downloadeshare.utils.DownloadShareHelper;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.widget.dialog.CommonDialogUtilsKt;

/* compiled from: DefaultDownloadSharePanel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006("}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/DefaultDownloadSharePanel;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "shareContext", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/downloadeshare/DownloadShareContext;)V", "themeResId", "", "(Landroid/content/Context;ILtv/danmaku/bili/downloadeshare/DownloadShareContext;)V", "mFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "mShareContext", "mSuperMenu", "Lcom/bilibili/app/comm/supermenu/SuperMenu;", "mMenuGrid", "Lcom/bilibili/app/comm/supermenu/core/MenuGrid;", "sharePlatformArr", "", "", "[Ljava/lang/String;", "sharePlatformArrHD", "initDialogStyle", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initShareMenuView", ReportEvent.EVENT_TYPE_SHOW, "onStart", "obtainShareMenus", "", "Lcom/bilibili/app/comm/supermenu/core/IMenu;", "dismiss", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DefaultDownloadSharePanel extends AlertDialog {
    public static final Companion Companion = new Companion(null);
    private static final int DIALOG_HEIGHT = 155;
    private static final int DIALOG_WIDTH = 295;
    private FragmentActivity mFragmentActivity;
    private MenuGrid mMenuGrid;
    private DownloadShareContext mShareContext;
    private SuperMenu mSuperMenu;
    private final String[] sharePlatformArr;
    private final String[] sharePlatformArrHD;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDownloadSharePanel(Context context, DownloadShareContext shareContext) {
        this(context, 0, shareContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDownloadSharePanel(Context context, int themeResId, DownloadShareContext shareContext) {
        super(context, themeResId);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        this.sharePlatformArr = new String[]{"WEIXIN", "WEIXIN_MONMENT", "QQ", "QZONE"};
        this.sharePlatformArrHD = new String[]{"WEIXIN", "WEIXIN_MONMENT"};
        this.mShareContext = shareContext;
        FragmentActivity fragmentActivity = ContextUtilKt.findTypedActivityOrNull(context, FragmentActivity.class);
        if (fragmentActivity != null) {
            this.mFragmentActivity = fragmentActivity;
        }
        initDialogStyle();
    }

    private final void initDialogStyle() {
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        Window $this$initDialogStyle_u24lambda_u240 = getWindow();
        if ($this$initDialogStyle_u24lambda_u240 != null) {
            $this$initDialogStyle_u24lambda_u240.addFlags(MisakaHelper.MAX_REPORT_SIZE);
            $this$initDialogStyle_u24lambda_u240.setDimAmount(0.0f);
            $this$initDialogStyle_u24lambda_u240.setGravity(17);
            $this$initDialogStyle_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_dialog_downloaded_share);
        this.mMenuGrid = findViewById(R.id.share_super_menu);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.downloadeshare.panel.DefaultDownloadSharePanel$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultDownloadSharePanel.this.dismiss();
                }
            });
        }
        initShareMenuView();
    }

    private final void initShareMenuView() {
        final Activity activity = this.mFragmentActivity;
        if (activity == null) {
            return;
        }
        this.mSuperMenu = SuperMenu.with(activity);
        SuperMenu $this$initShareMenuView_u24lambda_u240 = this.mSuperMenu;
        if ($this$initShareMenuView_u24lambda_u240 != null) {
            $this$initShareMenuView_u24lambda_u240.attach(this.mMenuGrid);
            $this$initShareMenuView_u24lambda_u240.setClickItemDismiss(false);
            $this$initShareMenuView_u24lambda_u240.addMenus(obtainShareMenus());
            $this$initShareMenuView_u24lambda_u240.itemClickListener(new OnMenuItemClickListenerV2() { // from class: tv.danmaku.bili.downloadeshare.panel.DefaultDownloadSharePanel$$ExternalSyntheticLambda0
                public final boolean onItemClick(IMenuItem iMenuItem) {
                    boolean initShareMenuView$lambda$0$0;
                    initShareMenuView$lambda$0$0 = DefaultDownloadSharePanel.initShareMenuView$lambda$0$0(activity, this, iMenuItem);
                    return initShareMenuView$lambda$0$0;
                }
            });
        }
        SuperMenu superMenu = this.mSuperMenu;
        if (superMenu != null) {
            superMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initShareMenuView$lambda$0$0(FragmentActivity $activity, DefaultDownloadSharePanel this$0, IMenuItem it) {
        DownloadShareParameter parameter;
        DownloadShareParameter parameter2;
        DownloadShareParameter parameter3;
        String id = it.getItemId();
        if (id != null) {
            if (!DownloadShareHelper.INSTANCE.checkInstalledThirdPartChannel(id, (Context) $activity)) {
                Context context = (Context) $activity;
                Application application = BiliContext.application();
                ToastHelper.showToast(context, application != null ? application.getString(bili.resource.share.R.string.share_global_string_33) : null, 0, 17);
                return true;
            }
            DownloadShareContext downloadShareContext = this$0.mShareContext;
            DownloadShareParameter parameter4 = downloadShareContext != null ? downloadShareContext.getParameter() : null;
            DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
            String valueOf = String.valueOf(parameter4 != null ? Long.valueOf(parameter4.getAvid()) : null);
            DownloadShareContext downloadShareContext2 = this$0.mShareContext;
            String spmid = (downloadShareContext2 == null || (parameter3 = downloadShareContext2.getParameter()) == null) ? null : parameter3.getSpmid();
            DownloadShareContext downloadShareContext3 = this$0.mShareContext;
            String objectExtraFields = (downloadShareContext3 == null || (parameter2 = downloadShareContext3.getParameter()) == null) ? null : parameter2.getObjectExtraFields();
            DownloadShareContext downloadShareContext4 = this$0.mShareContext;
            if (downloadShareContext4 != null && (parameter = downloadShareContext4.getParameter()) != null) {
                r2 = parameter.getSid();
            }
            downloadShareReporter.reportDownloadShareMenuItemClick(valueOf, id, spmid, objectExtraFields, r2);
            ShareDirectHelper.Companion.openThirdApp((Activity) $activity, id);
            this$0.dismiss();
            return true;
        }
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        DownloadShareParameter parameter;
        DownloadShareParameter parameter2;
        DownloadShareParameter parameter3;
        DownloadShareParameter parameter4;
        super.show();
        DownloadShareReporter downloadShareReporter = DownloadShareReporter.INSTANCE;
        DownloadShareContext downloadShareContext = this.mShareContext;
        String str = null;
        String valueOf = String.valueOf((downloadShareContext == null || (parameter4 = downloadShareContext.getParameter()) == null) ? null : Long.valueOf(parameter4.getAvid()));
        DownloadShareContext downloadShareContext2 = this.mShareContext;
        String spmid = (downloadShareContext2 == null || (parameter3 = downloadShareContext2.getParameter()) == null) ? null : parameter3.getSpmid();
        DownloadShareContext downloadShareContext3 = this.mShareContext;
        String objectExtraFields = (downloadShareContext3 == null || (parameter2 = downloadShareContext3.getParameter()) == null) ? null : parameter2.getObjectExtraFields();
        DownloadShareContext downloadShareContext4 = this.mShareContext;
        if (downloadShareContext4 != null && (parameter = downloadShareContext4.getParameter()) != null) {
            str = parameter.getSid();
        }
        downloadShareReporter.reportDownloadShareMenuShow(valueOf, spmid, objectExtraFields, str);
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
                $this$onStart_u24lambda_u240.width = CommonDialogUtilsKt.dp2px(295, context);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                $this$onStart_u24lambda_u240.height = CommonDialogUtilsKt.dp2px(155, context2);
            }
            window.setAttributes($this$onStart_u24lambda_u240);
        }
    }

    private final List<IMenu> obtainShareMenus() {
        String[] strArr;
        ShareMenuBuilderV2 from = ShareMenuBuilderV2.from(this.mFragmentActivity);
        if (AppBuildConfig.Companion.isHDApp()) {
            strArr = this.sharePlatformArrHD;
        } else {
            strArr = this.sharePlatformArr;
        }
        List<IMenu> buildWithNoInstallCheck = from.addLine(strArr).hasShareTitle(false).buildWithNoInstallCheck();
        Intrinsics.checkNotNullExpressionValue(buildWithNoInstallCheck, "buildWithNoInstallCheck(...)");
        return buildWithNoInstallCheck;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        SuperMenu superMenu;
        SuperMenu superMenu2 = this.mSuperMenu;
        boolean z = false;
        if (superMenu2 != null && superMenu2.isShowing()) {
            z = true;
        }
        if (z && (superMenu = this.mSuperMenu) != null) {
            superMenu.cancel();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (DownloadShareHelper.INSTANCE.isOutOfBounds(getWindow(), ev)) {
            dismiss();
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    /* compiled from: DefaultDownloadSharePanel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/DefaultDownloadSharePanel$Companion;", "", "<init>", "()V", "DIALOG_WIDTH", "", "DIALOG_HEIGHT", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}