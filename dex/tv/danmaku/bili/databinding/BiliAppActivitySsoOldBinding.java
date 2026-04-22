package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.R;

public final class BiliAppActivitySsoOldBinding implements ViewBinding {
    public final TextView account;
    public final ImageView arrow;
    public final ScalableImageView2 avatar;
    public final Guideline guideline;
    public final BiliImageView image1;
    public final BiliImageView image2;
    public final TintToolbar navTopBar;
    public final TintButton ok;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;

    private BiliAppActivitySsoOldBinding(LinearLayout rootView, TextView account, ImageView arrow, ScalableImageView2 avatar, Guideline guideline, BiliImageView image1, BiliImageView image2, TintToolbar navTopBar, TintButton ok, TextView text1, TextView text2) {
        this.rootView = rootView;
        this.account = account;
        this.arrow = arrow;
        this.avatar = avatar;
        this.guideline = guideline;
        this.image1 = image1;
        this.image2 = image2;
        this.navTopBar = navTopBar;
        this.ok = ok;
        this.text1 = text1;
        this.text2 = text2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivitySsoOldBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivitySsoOldBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_sso_old, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivitySsoOldBinding bind(View rootView) {
        ScalableImageView2 avatar;
        Guideline guideline;
        BiliImageView image1;
        BiliImageView image2;
        TintToolbar navTopBar;
        TintButton ok;
        int id = R.id.account;
        TextView account = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (account != null) {
            id = R.id.arrow;
            ImageView arrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (arrow != null && (avatar = ViewBindings.findChildViewById(rootView, (id = R.id.avatar))) != null && (guideline = ViewBindings.findChildViewById(rootView, (id = R.id.guideline))) != null && (image1 = ViewBindings.findChildViewById(rootView, (id = R.id.image1))) != null && (image2 = ViewBindings.findChildViewById(rootView, (id = R.id.image2))) != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (ok = ViewBindings.findChildViewById(rootView, (id = R.id.ok))) != null) {
                id = R.id.text1;
                TextView text1 = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (text1 != null) {
                    id = R.id.text2;
                    TextView text2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (text2 != null) {
                        return new BiliAppActivitySsoOldBinding((LinearLayout) rootView, account, arrow, avatar, guideline, image1, image2, navTopBar, ok, text1, text2);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}