package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.R;

public final class BiliAppActivitySsoBinding implements ViewBinding {
    public final TextView account;
    public final TextView agreement;
    public final TintImageView arrow;
    public final BiliImageView avatar;
    public final Guideline guideline;
    public final BiliImageView image1;
    public final BiliImageView image2;
    public final TintToolbar navTopBar;
    public final TintButton ok;
    public final TintProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;

    private BiliAppActivitySsoBinding(LinearLayout rootView, TextView account, TextView agreement, TintImageView arrow, BiliImageView avatar, Guideline guideline, BiliImageView image1, BiliImageView image2, TintToolbar navTopBar, TintButton ok, TintProgressBar progressBar, TextView text1, TextView text2) {
        this.rootView = rootView;
        this.account = account;
        this.agreement = agreement;
        this.arrow = arrow;
        this.avatar = avatar;
        this.guideline = guideline;
        this.image1 = image1;
        this.image2 = image2;
        this.navTopBar = navTopBar;
        this.ok = ok;
        this.progressBar = progressBar;
        this.text1 = text1;
        this.text2 = text2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivitySsoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivitySsoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_sso, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivitySsoBinding bind(View rootView) {
        TintImageView arrow;
        BiliImageView avatar;
        Guideline guideline;
        BiliImageView image1;
        BiliImageView image2;
        TintToolbar navTopBar;
        TintButton ok;
        TintProgressBar progressBar;
        int id = R.id.account;
        TextView account = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (account != null) {
            id = R.id.agreement;
            TextView agreement = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (agreement != null && (arrow = ViewBindings.findChildViewById(rootView, (id = R.id.arrow))) != null && (avatar = ViewBindings.findChildViewById(rootView, (id = R.id.avatar))) != null && (guideline = ViewBindings.findChildViewById(rootView, (id = R.id.guideline))) != null && (image1 = ViewBindings.findChildViewById(rootView, (id = R.id.image1))) != null && (image2 = ViewBindings.findChildViewById(rootView, (id = R.id.image2))) != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (ok = ViewBindings.findChildViewById(rootView, (id = R.id.ok))) != null && (progressBar = ViewBindings.findChildViewById(rootView, (id = R.id.progress_bar))) != null) {
                id = R.id.text1;
                TextView text1 = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (text1 != null) {
                    id = R.id.text2;
                    TextView text2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (text2 != null) {
                        return new BiliAppActivitySsoBinding((LinearLayout) rootView, account, agreement, arrow, avatar, guideline, image1, image2, navTopBar, ok, progressBar, text1, text2);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}