package tv.danmaku.bili.ui.answer;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.supermenu.SuperMenu;
import com.bilibili.app.comm.supermenu.core.IMenuPanel;
import com.bilibili.app.comm.supermenu.core.MenuView;
import com.bilibili.app.comm.supermenu.share.v2.SharePanelShowCallback;
import com.bilibili.droid.DimenUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AnswerLandscapeShareDialog.kt */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\t\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerLandscapeShareDialog;", "Landroid/app/AlertDialog;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "fromSpmid", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "showCallback", "tv/danmaku/bili/ui/answer/AnswerLandscapeShareDialog$showCallback$1", "Ltv/danmaku/bili/ui/answer/AnswerLandscapeShareDialog$showCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AnswerLandscapeShareDialog extends AlertDialog {
    private static final String TAG = "AnswerLandscapeShareDialog";
    private final Activity activity;
    private final String fromSpmid;
    private final AnswerLandscapeShareDialog$showCallback$1 showCallback;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v4, types: [tv.danmaku.bili.ui.answer.AnswerLandscapeShareDialog$showCallback$1] */
    public AnswerLandscapeShareDialog(Activity activity, String fromSpmid) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        this.activity = activity;
        this.fromSpmid = fromSpmid;
        this.showCallback = new SharePanelShowCallback() { // from class: tv.danmaku.bili.ui.answer.AnswerLandscapeShareDialog$showCallback$1
            public void onShowSuccess(SuperMenu superMenu) {
                Intrinsics.checkNotNullParameter(superMenu, "superMenu");
                BLog.i("AnswerLandscapeShareDialog", "onShowSuccess");
            }

            public boolean onShowFailed(int code, String message) {
                AnswerLandscapeShareDialog.this.cancel();
                BLog.i("AnswerLandscapeShareDialog", "onShowFailed code: " + code + ", message: " + message);
                return false;
            }

            public void onPanelDismiss() {
                AnswerLandscapeShareDialog.this.cancel();
                BLog.i("AnswerLandscapeShareDialog", "onPanelDismiss");
            }
        };
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(131080);
            window.setSoftInputMode(18);
            WindowCompat.setDecorFitsSystemWindows(window, false);
            WindowInsetsControllerCompat $this$onCreate_u24lambda_u240 = WindowCompat.getInsetsController(window, window.getDecorView());
            $this$onCreate_u24lambda_u240.hide(WindowInsetsCompat.Type.systemBars());
            $this$onCreate_u24lambda_u240.setSystemBarsBehavior(2);
        }
        FrameLayout root = new FrameLayout(getContext());
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        IMenuPanel menuView = new MenuView(getContext());
        FrameLayout.LayoutParams $this$onCreate_u24lambda_u242_u240 = new FrameLayout.LayoutParams(-1, -2);
        $this$onCreate_u24lambda_u242_u240.gravity = 80;
        menuView.setLayoutParams($this$onCreate_u24lambda_u242_u240);
        View $this$setPadding$iv = (View) menuView;
        int size$iv = DimenUtilsKt.dpToPx(8.0f);
        $this$setPadding$iv.setPadding(size$iv, size$iv, size$iv, size$iv);
        menuView.setBackgroundColor(ContextCompat.getColor(menuView.getContext(), R.color.black_alpha50));
        root.addView((View) menuView);
        setContentView(root);
        root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerLandscapeShareDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnswerLandscapeShareDialog.this.cancel();
            }
        });
        ShareToGetInvitationCodeUtil.INSTANCE.shareWithPanel(this.activity, this.fromSpmid, menuView, this.showCallback);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window $this$onStart_u24lambda_u240 = getWindow();
        if ($this$onStart_u24lambda_u240 != null) {
            $this$onStart_u24lambda_u240.setWindowAnimations(common.shareapi.R.style.socialize_shareboard_animation);
            $this$onStart_u24lambda_u240.setLayout(-1, -1);
            $this$onStart_u24lambda_u240.setDimAmount(0.0f);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* compiled from: AnswerLandscapeShareDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerLandscapeShareDialog$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}