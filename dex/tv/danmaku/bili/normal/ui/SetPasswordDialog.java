package tv.danmaku.bili.normal.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bilibili.app.accountui.R;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import java.lang.Character;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.SetPasswordContract;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.theme.BiliTheme;

/* compiled from: SetPasswordDialog.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002ABB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0014J\u0012\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\u0012\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0017\u0010(\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0016J<\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020\u001fH\u0002J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020\nH\u0002J\u000e\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Ltv/danmaku/bili/normal/ui/SetPasswordDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Ltv/danmaku/bili/normal/ui/SetPasswordContract$View;", "Landroid/text/InputFilter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPwdType", "", "mTitle", "Landroid/widget/TextView;", "mSubTitle", "mTips", "mEdPassword", "Landroid/widget/EditText;", "mExitBtn", "mCommitBtn", "mCloseBtn", "Landroid/widget/ImageView;", "mIvPwdLabel", "mSetPasswordPresenter", "Ltv/danmaku/bili/normal/ui/SetPasswordPresenter;", "isExitStatus", "", "mProgressBar", "Lcom/bilibili/magicasakura/widgets/TintProgressBar;", "isSuccessClose", "mTipsEnable", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onClick", "v", "Landroid/view/View;", "setPwdSucceed", "dismiss", "showTips", "tips", "", "resId", "(Ljava/lang/Integer;)V", "getContextSelf", "showProgress", "hideProgress", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "initViews", "isChinese", "c", "", "getThemeColor", "setLogoutListener", "l", "Ltv/danmaku/bili/normal/ui/SetPasswordContract$LogoutListener;", "Companion", "BiggerDotPasswordTransformationMethod", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SetPasswordDialog extends AppCompatDialog implements View.OnClickListener, SetPasswordContract.View, InputFilter {
    public static final int PASSWORD_TYPE_INVISIBLE = 2;
    public static final int PASSWORD_TYPE_VISIBLE = 1;
    private boolean isExitStatus;
    private boolean isSuccessClose;
    private ImageView mCloseBtn;
    private TextView mCommitBtn;
    private EditText mEdPassword;
    private TextView mExitBtn;
    private ImageView mIvPwdLabel;
    private TintProgressBar mProgressBar;
    private int mPwdType;
    private SetPasswordPresenter mSetPasswordPresenter;
    private TextView mSubTitle;
    private TextView mTips;
    private boolean mTipsEnable;
    private TextView mTitle;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPasswordDialog(Context context) {
        super(context, R.style.SetPwdDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPwdType = 1;
        this.mTipsEnable = true;
        this.mSetPasswordPresenter = new SetPasswordPresenter(this);
    }

    /* compiled from: SetPasswordDialog.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/normal/ui/SetPasswordDialog$Companion;", "", "<init>", "()V", "PASSWORD_TYPE_VISIBLE", "", "PASSWORD_TYPE_INVISIBLE", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_dialog_set_password);
        initViews();
        LoginReporterV2.Show.report(LoginReporterV2.Show.MAIN_SETTING_EXIT_POPUP_SHOW);
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setLayout(-1, -2);
        }
        EditText editText = this.mEdPassword;
        Intrinsics.checkNotNull(editText);
        editText.requestFocus();
        EditText editText2 = this.mEdPassword;
        Intrinsics.checkNotNull(editText2);
        editText2.postDelayed(new Runnable() { // from class: tv.danmaku.bili.normal.ui.SetPasswordDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SetPasswordDialog.onStart$lambda$0(SetPasswordDialog.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(SetPasswordDialog this$0) {
        InputMethodManagerHelper.showSoftInput(this$0.getContext(), this$0.mEdPassword, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i;
        HashMap<String, String> generateSingleParamMaps;
        HashMap<String, String> generateSingleParamMaps2;
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i2 = R.id.im_close;
        if (valueOf != null && valueOf.intValue() == i2) {
            cancel();
            if (this.isExitStatus) {
                generateSingleParamMaps2 = LoginReporterV2.generateSingleParamMaps("step", "2");
            } else {
                generateSingleParamMaps2 = LoginReporterV2.generateSingleParamMaps("step", "1");
            }
            LoginReporterV2.Click.report(LoginReporterV2.Click.MAIN_SETTING_EXIT_CLOSE_CLICK, generateSingleParamMaps2);
            return;
        }
        int i3 = R.id.btn_yes;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (this.isExitStatus) {
                generateSingleParamMaps = LoginReporterV2.generateSingleParamMaps("step", "2");
            } else {
                generateSingleParamMaps = LoginReporterV2.generateSingleParamMaps("step", "1");
            }
            LoginReporterV2.Click.report(LoginReporterV2.Click.MAIN_SETTING_EXIT_SUBMIT_CLICK, generateSingleParamMaps);
            EditText editText = this.mEdPassword;
            Intrinsics.checkNotNull(editText);
            String pwd = editText.getText().toString();
            SetPasswordPresenter setPasswordPresenter = this.mSetPasswordPresenter;
            Intrinsics.checkNotNull(setPasswordPresenter);
            String tips = setPasswordPresenter.checkPassword(pwd);
            if (TextUtils.isEmpty(tips)) {
                SetPasswordPresenter setPasswordPresenter2 = this.mSetPasswordPresenter;
                Intrinsics.checkNotNull(setPasswordPresenter2);
                setPasswordPresenter2.setPassword(pwd);
                return;
            }
            TextView textView = this.mTips;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(0);
            TextView textView2 = this.mTips;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(tips);
            return;
        }
        int i4 = R.id.btn_no;
        if (valueOf != null && valueOf.intValue() == i4) {
            if (!this.isExitStatus) {
                this.isExitStatus = true;
                TextView textView3 = this.mExitBtn;
                Intrinsics.checkNotNull(textView3);
                textView3.setText(getContext().getString(bili.resource.account.R.string.account_global_string_140));
                TextView textView4 = this.mTitle;
                Intrinsics.checkNotNull(textView4);
                textView4.setText(getContext().getString(bili.resource.account.R.string.account_global_string_155));
                String str = getContext().getResources().getString(bili.resource.account.R.string.account_global_string_52);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                SpannableStringBuilder styleStr = new SpannableStringBuilder(str);
                styleStr.setSpan(new ForegroundColorSpan(getThemeColor()), 10, 13, 34);
                styleStr.setSpan(new ForegroundColorSpan(getThemeColor()), 15, 21, 34);
                TextView textView5 = this.mSubTitle;
                Intrinsics.checkNotNull(textView5);
                textView5.setText(styleStr);
                LoginReporterV2.Click.report(LoginReporterV2.Click.MAIN_SETTING_EXIT_QUIT_1ST_CLICK);
                return;
            }
            cancel();
            SetPasswordPresenter setPasswordPresenter3 = this.mSetPasswordPresenter;
            Intrinsics.checkNotNull(setPasswordPresenter3);
            setPasswordPresenter3.callLogout();
            LoginReporterV2.Click.report(LoginReporterV2.Click.MAIN_SETTING_EXIT_QUIT_2ND_CLICK);
            return;
        }
        int i5 = R.id.iv_pwd_label;
        if (valueOf != null && valueOf.intValue() == i5) {
            if (this.mPwdType == 1) {
                i = 2;
            } else {
                i = 1;
            }
            this.mPwdType = i;
            switch (this.mPwdType) {
                case 1:
                    ImageView imageView = this.mIvPwdLabel;
                    Intrinsics.checkNotNull(imageView);
                    imageView.setImageResource(R.drawable.ic_password_visible);
                    this.mTipsEnable = false;
                    EditText editText2 = this.mEdPassword;
                    Intrinsics.checkNotNull(editText2);
                    editText2.setTransformationMethod(null);
                    EditText editText3 = this.mEdPassword;
                    Intrinsics.checkNotNull(editText3);
                    EditText editText4 = this.mEdPassword;
                    Intrinsics.checkNotNull(editText4);
                    editText3.setSelection(editText4.length());
                    this.mTipsEnable = true;
                    return;
                case 2:
                    ImageView imageView2 = this.mIvPwdLabel;
                    Intrinsics.checkNotNull(imageView2);
                    imageView2.setImageResource(R.drawable.ic_password_invisible);
                    this.mTipsEnable = false;
                    EditText editText5 = this.mEdPassword;
                    Intrinsics.checkNotNull(editText5);
                    editText5.setTransformationMethod(BiggerDotPasswordTransformationMethod.INSTANCE);
                    EditText editText6 = this.mEdPassword;
                    Intrinsics.checkNotNull(editText6);
                    EditText editText7 = this.mEdPassword;
                    Intrinsics.checkNotNull(editText7);
                    editText6.setSelection(editText7.length());
                    this.mTipsEnable = true;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.View
    public void setPwdSucceed() {
        InputMethodManagerHelper.hideSoftInput(getContext(), this.mEdPassword, 1);
        SetPasswordPresenter setPasswordPresenter = this.mSetPasswordPresenter;
        Intrinsics.checkNotNull(setPasswordPresenter);
        setPasswordPresenter.callLogout();
        this.isSuccessClose = true;
        cancel();
    }

    public void dismiss() {
        super.dismiss();
        if (this.isSuccessClose) {
            LoginReporterV2.Show.report(LoginReporterV2.Show.MAIN_SETTING_EXIT_SUCCESS_SHOW, LoginReporterV2.generateSingleParamMaps("method", "3"));
        } else {
            LoginReporterV2.Show.report(LoginReporterV2.Show.MAIN_SETTING_EXIT_SUCCESS_SHOW, LoginReporterV2.generateSingleParamMaps("method", "2"));
        }
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.View
    public void showTips(String tips) {
        TextView textView = this.mTips;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(0);
        TextView textView2 = this.mTips;
        Intrinsics.checkNotNull(textView2);
        textView2.setText(tips);
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.View
    public void showTips(Integer resId) {
        Context context = getContext();
        Intrinsics.checkNotNull(resId);
        ToastHelper.showToastShort(context, resId.intValue());
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.View
    public Context getContextSelf() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.View
    public void showProgress() {
        TintProgressBar tintProgressBar = this.mProgressBar;
        Intrinsics.checkNotNull(tintProgressBar);
        tintProgressBar.setVisibility(0);
        ImageView imageView = this.mIvPwdLabel;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        TextView textView = this.mCommitBtn;
        Intrinsics.checkNotNull(textView);
        textView.setTextColor(getContext().getResources().getColor(com.bilibili.lib.theme.R.color.Ga4));
        TextView textView2 = this.mExitBtn;
        Intrinsics.checkNotNull(textView2);
        textView2.setEnabled(false);
    }

    @Override // tv.danmaku.bili.normal.ui.SetPasswordContract.View
    public void hideProgress() {
        TintProgressBar tintProgressBar = this.mProgressBar;
        Intrinsics.checkNotNull(tintProgressBar);
        tintProgressBar.setVisibility(8);
        ImageView imageView = this.mIvPwdLabel;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(0);
        TextView textView = this.mExitBtn;
        Intrinsics.checkNotNull(textView);
        textView.setEnabled(true);
        switch (this.mPwdType) {
            case 1:
                ImageView imageView2 = this.mIvPwdLabel;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setImageResource(R.drawable.ic_password_visible);
                break;
            case 2:
                ImageView imageView3 = this.mIvPwdLabel;
                Intrinsics.checkNotNull(imageView3);
                imageView3.setImageResource(R.drawable.ic_password_invisible);
                break;
        }
        TextView textView2 = this.mCommitBtn;
        Intrinsics.checkNotNull(textView2);
        textView2.setTextColor(getThemeColor());
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String filtered = "";
        if (source != null) {
            for (int i = start; i < end; i++) {
                char character = source.charAt(i);
                if (!Character.isWhitespace(character) && !isChinese(character)) {
                    filtered = filtered + character;
                }
            }
        }
        return filtered;
    }

    /* compiled from: SetPasswordDialog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/normal/ui/SetPasswordDialog$BiggerDotPasswordTransformationMethod;", "Landroid/text/method/PasswordTransformationMethod;", "<init>", "()V", "getTransformation", "", "source", "view", "Landroid/view/View;", "DOT", "", "BIGGER_DOT", "PasswordCharSequence", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class BiggerDotPasswordTransformationMethod extends PasswordTransformationMethod {
        private static final char BIGGER_DOT = 9679;
        private static final char DOT = 8226;
        public static final BiggerDotPasswordTransformationMethod INSTANCE = new BiggerDotPasswordTransformationMethod();
        public static final int $stable = 8;

        private BiggerDotPasswordTransformationMethod() {
        }

        @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence source, View view) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(view, "view");
            CharSequence transformation = super.getTransformation(source, view);
            Intrinsics.checkNotNullExpressionValue(transformation, "getTransformation(...)");
            return new PasswordCharSequence(transformation);
        }

        /* compiled from: SetPasswordDialog.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002J\u0019\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0096\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u000e\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/normal/ui/SetPasswordDialog$BiggerDotPasswordTransformationMethod$PasswordCharSequence;", "", "transformation", "<init>", "(Ljava/lang/CharSequence;)V", "getTransformation", "()Ljava/lang/CharSequence;", "get", "", "index", "", "subSequence", "startIndex", "endIndex", "length", "getLength", "()I", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        private static final class PasswordCharSequence implements CharSequence {
            private final CharSequence transformation;

            public int getLength() {
                return this.transformation.length();
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return this.transformation.subSequence(i, i2);
            }

            public PasswordCharSequence(CharSequence transformation) {
                Intrinsics.checkNotNullParameter(transformation, "transformation");
                this.transformation = transformation;
            }

            @Override // java.lang.CharSequence
            public final /* bridge */ char charAt(int index) {
                return get(index);
            }

            @Override // java.lang.CharSequence
            public final /* bridge */ int length() {
                return getLength();
            }

            public final CharSequence getTransformation() {
                return this.transformation;
            }

            public char get(int index) {
                if (this.transformation.charAt(index) == 8226) {
                    return BiggerDotPasswordTransformationMethod.BIGGER_DOT;
                }
                return this.transformation.charAt(index);
            }
        }
    }

    private final void initViews() {
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.mSubTitle = (TextView) findViewById(R.id.tv_sub_title);
        this.mTips = (TextView) findViewById(R.id.tv_tips);
        this.mEdPassword = (EditText) findViewById(R.id.ed_pwd);
        this.mCloseBtn = (ImageView) findViewById(R.id.im_close);
        this.mCommitBtn = (TextView) findViewById(R.id.btn_yes);
        this.mExitBtn = (TextView) findViewById(R.id.btn_no);
        this.mProgressBar = findViewById(R.id.progress_bar);
        this.mIvPwdLabel = (ImageView) findViewById(R.id.iv_pwd_label);
        ImageView imageView = this.mCloseBtn;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(this);
        TextView textView = this.mCommitBtn;
        Intrinsics.checkNotNull(textView);
        textView.setOnClickListener(this);
        TextView textView2 = this.mExitBtn;
        Intrinsics.checkNotNull(textView2);
        textView2.setOnClickListener(this);
        ImageView imageView2 = this.mIvPwdLabel;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setOnClickListener(this);
        TintProgressBar tintProgressBar = this.mProgressBar;
        Intrinsics.checkNotNull(tintProgressBar);
        tintProgressBar.getIndeterminateDrawable().setColorFilter(getThemeColor(), PorterDuff.Mode.MULTIPLY);
        EditText editText = this.mEdPassword;
        Intrinsics.checkNotNull(editText);
        editText.setFilters(new InputFilter[]{this, new InputFilter.LengthFilter(20)});
        EditText editText2 = this.mEdPassword;
        Intrinsics.checkNotNull(editText2);
        editText2.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.normal.ui.SetPasswordDialog$initViews$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean z;
                TextView textView3;
                TextView textView4;
                z = SetPasswordDialog.this.mTipsEnable;
                if (z) {
                    textView3 = SetPasswordDialog.this.mTips;
                    Intrinsics.checkNotNull(textView3);
                    textView3.setVisibility(8);
                    textView4 = SetPasswordDialog.this.mTips;
                    Intrinsics.checkNotNull(textView4);
                    textView4.setText("");
                }
            }
        });
        this.mPwdType = 1;
        ImageView imageView3 = this.mIvPwdLabel;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setImageResource(R.drawable.ic_password_visible);
        EditText editText3 = this.mEdPassword;
        Intrinsics.checkNotNull(editText3);
        editText3.setTransformationMethod(null);
        if (BiliTheme.isNightTheme(getContext())) {
            TextView textView3 = this.mCommitBtn;
            Intrinsics.checkNotNull(textView3);
            textView3.setTextColor(getContext().getResources().getColor(com.bilibili.lib.theme.R.color.Pi5));
        }
        TextView textView4 = this.mTips;
        Intrinsics.checkNotNull(textView4);
        textView4.setTextColor(getThemeColor());
    }

    private final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return Intrinsics.areEqual(ub, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || Intrinsics.areEqual(ub, Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || Intrinsics.areEqual(ub, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || Intrinsics.areEqual(ub, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || Intrinsics.areEqual(ub, Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || Intrinsics.areEqual(ub, Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || Intrinsics.areEqual(ub, Character.UnicodeBlock.GENERAL_PUNCTUATION);
    }

    private final int getThemeColor() {
        if (BiliTheme.isNightTheme(getContext())) {
            return getContext().getResources().getColor(com.bilibili.lib.theme.R.color.Pi5);
        }
        return ThemeUtils.getColorById(getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary);
    }

    public final void setLogoutListener(SetPasswordContract.LogoutListener l) {
        Intrinsics.checkNotNullParameter(l, "l");
        SetPasswordPresenter setPasswordPresenter = this.mSetPasswordPresenter;
        Intrinsics.checkNotNull(setPasswordPresenter);
        setPasswordPresenter.setLogoutListener(l);
    }
}