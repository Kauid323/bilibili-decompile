package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import tv.danmaku.bili.R;

public final class FragmentHomeUserCenterForceLoginBinding implements ViewBinding {
    public final FragmentContainerView fragmentLoginContainer;
    public final TintImageView ivCustomer;
    public final TintImageView ivSettings;
    public final TintImageView ivTeen;
    private final TintConstraintLayout rootView;

    private FragmentHomeUserCenterForceLoginBinding(TintConstraintLayout rootView, FragmentContainerView fragmentLoginContainer, TintImageView ivCustomer, TintImageView ivSettings, TintImageView ivTeen) {
        this.rootView = rootView;
        this.fragmentLoginContainer = fragmentLoginContainer;
        this.ivCustomer = ivCustomer;
        this.ivSettings = ivSettings;
        this.ivTeen = ivTeen;
    }

    public TintConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeUserCenterForceLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHomeUserCenterForceLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_home_user_center_force_login, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentHomeUserCenterForceLoginBinding bind(View rootView) {
        TintImageView ivCustomer;
        TintImageView ivSettings;
        TintImageView ivTeen;
        int id = R.id.fragment_login_container;
        FragmentContainerView fragmentLoginContainer = ViewBindings.findChildViewById(rootView, id);
        if (fragmentLoginContainer != null && (ivCustomer = ViewBindings.findChildViewById(rootView, (id = R.id.iv_customer))) != null && (ivSettings = ViewBindings.findChildViewById(rootView, (id = R.id.iv_settings))) != null && (ivTeen = ViewBindings.findChildViewById(rootView, (id = R.id.iv_teen))) != null) {
            return new FragmentHomeUserCenterForceLoginBinding((TintConstraintLayout) rootView, fragmentLoginContainer, ivCustomer, ivSettings, ivTeen);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}