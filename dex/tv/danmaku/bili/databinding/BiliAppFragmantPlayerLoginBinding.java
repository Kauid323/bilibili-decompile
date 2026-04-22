package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintImageView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.login.LoginEnterLayout;
import tv.danmaku.bili.ui.loginv2.LoginTintAutoCompleteTextView;
import tv.danmaku.bili.ui.loginv2.LoginTintEditText;

public final class BiliAppFragmantPlayerLoginBinding implements ViewBinding {
    public final TintButton btnLogin;
    public final TintButton btnRegister;
    public final LinearLayout buttonLayout;
    public final TintImageView clearName;
    public final LinearLayout clearNameLayout;
    public final TintImageView clearPwd;
    public final LinearLayout clearPwdLayout;
    public final ImageView close;
    public final FrameLayout layoutContent;
    public final LoginEnterLayout layoutLoginEnter;
    public final LinearLayout layoutProgress;
    public final CheckBox logRegCheckbox;
    public final FrameLayout logRegCheckboxContainer;
    public final RelativeLayout loginContent;
    public final FrameLayout loginInputPwdContainer;
    public final View loginRegPop;
    public final TextView loginTipsTitle;
    public final LottieAnimationView lottieLoading;
    public final TextView message;
    public final LinearLayout regInfoContainer;
    private final FrameLayout rootView;
    public final TextView tvLoginAgreement;
    public final FrameLayout userNameLayout;
    public final LoginTintAutoCompleteTextView username;
    public final LoginTintEditText userpwd;

    private BiliAppFragmantPlayerLoginBinding(FrameLayout rootView, TintButton btnLogin, TintButton btnRegister, LinearLayout buttonLayout, TintImageView clearName, LinearLayout clearNameLayout, TintImageView clearPwd, LinearLayout clearPwdLayout, ImageView close, FrameLayout layoutContent, LoginEnterLayout layoutLoginEnter, LinearLayout layoutProgress, CheckBox logRegCheckbox, FrameLayout logRegCheckboxContainer, RelativeLayout loginContent, FrameLayout loginInputPwdContainer, View loginRegPop, TextView loginTipsTitle, LottieAnimationView lottieLoading, TextView message, LinearLayout regInfoContainer, TextView tvLoginAgreement, FrameLayout userNameLayout, LoginTintAutoCompleteTextView username, LoginTintEditText userpwd) {
        this.rootView = rootView;
        this.btnLogin = btnLogin;
        this.btnRegister = btnRegister;
        this.buttonLayout = buttonLayout;
        this.clearName = clearName;
        this.clearNameLayout = clearNameLayout;
        this.clearPwd = clearPwd;
        this.clearPwdLayout = clearPwdLayout;
        this.close = close;
        this.layoutContent = layoutContent;
        this.layoutLoginEnter = layoutLoginEnter;
        this.layoutProgress = layoutProgress;
        this.logRegCheckbox = logRegCheckbox;
        this.logRegCheckboxContainer = logRegCheckboxContainer;
        this.loginContent = loginContent;
        this.loginInputPwdContainer = loginInputPwdContainer;
        this.loginRegPop = loginRegPop;
        this.loginTipsTitle = loginTipsTitle;
        this.lottieLoading = lottieLoading;
        this.message = message;
        this.regInfoContainer = regInfoContainer;
        this.tvLoginAgreement = tvLoginAgreement;
        this.userNameLayout = userNameLayout;
        this.username = username;
        this.userpwd = userpwd;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmantPlayerLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmantPlayerLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragmant_player_login, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmantPlayerLoginBinding bind(View rootView) {
        TintButton btnRegister;
        TintImageView clearName;
        TintImageView clearPwd;
        View loginRegPop;
        LottieAnimationView lottieLoading;
        int id = R.id.btn_login;
        TintButton btnLogin = ViewBindings.findChildViewById(rootView, id);
        if (btnLogin != null && (btnRegister = ViewBindings.findChildViewById(rootView, (id = R.id.btn_register))) != null) {
            id = R.id.button_layout;
            LinearLayout buttonLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (buttonLayout != null && (clearName = ViewBindings.findChildViewById(rootView, (id = R.id.clear_name))) != null) {
                id = R.id.clear_name_layout;
                LinearLayout clearNameLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (clearNameLayout != null && (clearPwd = ViewBindings.findChildViewById(rootView, (id = R.id.clear_pwd))) != null) {
                    id = R.id.clear_pwd_layout;
                    LinearLayout clearPwdLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (clearPwdLayout != null) {
                        id = R.id.close;
                        ImageView close = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (close != null) {
                            id = R.id.layout_content;
                            FrameLayout layoutContent = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                            if (layoutContent != null) {
                                id = R.id.layout_login_enter;
                                LoginEnterLayout layoutLoginEnter = (LoginEnterLayout) ViewBindings.findChildViewById(rootView, id);
                                if (layoutLoginEnter != null) {
                                    id = R.id.layout_progress;
                                    LinearLayout layoutProgress = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                    if (layoutProgress != null) {
                                        id = R.id.log_reg_checkbox;
                                        CheckBox logRegCheckbox = (CheckBox) ViewBindings.findChildViewById(rootView, id);
                                        if (logRegCheckbox != null) {
                                            id = R.id.log_reg_checkbox_container;
                                            FrameLayout logRegCheckboxContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                            if (logRegCheckboxContainer != null) {
                                                id = R.id.login_content;
                                                RelativeLayout loginContent = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                                                if (loginContent != null) {
                                                    id = R.id.login_input_pwd_container;
                                                    FrameLayout loginInputPwdContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                                    if (loginInputPwdContainer != null && (loginRegPop = ViewBindings.findChildViewById(rootView, (id = R.id.login_reg_pop))) != null) {
                                                        id = R.id.login_tips_title;
                                                        TextView loginTipsTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                        if (loginTipsTitle != null && (lottieLoading = ViewBindings.findChildViewById(rootView, (id = R.id.lottie_loading))) != null) {
                                                            id = R.id.message;
                                                            TextView message = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                            if (message != null) {
                                                                id = R.id.reg_info_container;
                                                                LinearLayout regInfoContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                                if (regInfoContainer != null) {
                                                                    id = R.id.tv_login_agreement;
                                                                    TextView tvLoginAgreement = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                    if (tvLoginAgreement != null) {
                                                                        id = R.id.user_name_layout;
                                                                        FrameLayout userNameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                                                        if (userNameLayout != null) {
                                                                            id = R.id.username;
                                                                            LoginTintAutoCompleteTextView username = (LoginTintAutoCompleteTextView) ViewBindings.findChildViewById(rootView, id);
                                                                            if (username != null) {
                                                                                id = R.id.userpwd;
                                                                                LoginTintEditText userpwd = (LoginTintEditText) ViewBindings.findChildViewById(rootView, id);
                                                                                if (userpwd != null) {
                                                                                    return new BiliAppFragmantPlayerLoginBinding((FrameLayout) rootView, btnLogin, btnRegister, buttonLayout, clearName, clearNameLayout, clearPwd, clearPwdLayout, close, layoutContent, layoutLoginEnter, layoutProgress, logRegCheckbox, logRegCheckboxContainer, loginContent, loginInputPwdContainer, loginRegPop, loginTipsTitle, lottieLoading, message, regInfoContainer, tvLoginAgreement, userNameLayout, username, userpwd);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}