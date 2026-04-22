package tv.danmaku.bili.quick.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.app.accountui.R;
import com.bilibili.magicasakura.widgets.TintRelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.utils.UiUtils;

/* compiled from: LoginQuickButton.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/quick/ui/LoginQuickButton;", "Lcom/bilibili/magicasakura/widgets/TintRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTvSubmit", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "setText", "", "resId", "", "showProgress", "hideProgress", "setEnabled", "enabled", "", "setTextColor", GarbJsBridgeCallHandlerKt.PURE_THEME, "Landroid/content/res/ColorStateList;", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginQuickButton extends TintRelativeLayout {
    private static final int DEFAULT_HEIGHT = 44;
    private final ProgressBar mProgressBar;
    private final TextView mTvSubmit;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginQuickButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        try {
            i = context.getResources().getDimensionPixelSize(R.dimen.button_height);
        } catch (Resources.NotFoundException e) {
            BLog.w(e.getMessage());
            i = 44;
        }
        int height = i;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, UiUtils.dp2px(context, height)));
        LayoutInflater.from(context).inflate(R.layout.bili_app_layout_btn_quick, (ViewGroup) this);
        View findViewById = findViewById(R.id.tv_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mTvSubmit = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mProgressBar = (ProgressBar) findViewById2;
        this.mProgressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Wh0_u), PorterDuff.Mode.SRC_IN);
        this.mProgressBar.setVisibility(8);
    }

    /* compiled from: LoginQuickButton.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/quick/ui/LoginQuickButton$Companion;", "", "<init>", "()V", "DEFAULT_HEIGHT", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setText(int resId) {
        this.mTvSubmit.setText(resId);
    }

    public final void showProgress() {
        this.mTvSubmit.setVisibility(8);
        this.mProgressBar.setVisibility(0);
    }

    public final void hideProgress() {
        this.mTvSubmit.setVisibility(0);
        this.mProgressBar.setVisibility(8);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.mTvSubmit.setEnabled(enabled);
    }

    public final void setTextColor(ColorStateList color) {
        if (color != null) {
            this.mTvSubmit.setTextColor(color);
        }
    }
}