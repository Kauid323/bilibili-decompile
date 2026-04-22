package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppAddWidgetGuideToastBinding implements ViewBinding {
    public final TintTextView btnAdd;
    public final TintButton btnCancel;
    public final ConstraintLayout container;
    public final Group group;
    private final FrameLayout rootView;
    public final TintTextView subTitle;
    public final TintTextView title;

    private BiliAppAddWidgetGuideToastBinding(FrameLayout rootView, TintTextView btnAdd, TintButton btnCancel, ConstraintLayout container, Group group, TintTextView subTitle, TintTextView title) {
        this.rootView = rootView;
        this.btnAdd = btnAdd;
        this.btnCancel = btnCancel;
        this.container = container;
        this.group = group;
        this.subTitle = subTitle;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppAddWidgetGuideToastBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppAddWidgetGuideToastBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_add_widget_guide_toast, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppAddWidgetGuideToastBinding bind(View rootView) {
        TintButton btnCancel;
        ConstraintLayout container;
        Group group;
        TintTextView subTitle;
        TintTextView title;
        int id = R.id.btn_add;
        TintTextView btnAdd = ViewBindings.findChildViewById(rootView, id);
        if (btnAdd != null && (btnCancel = ViewBindings.findChildViewById(rootView, (id = R.id.btn_cancel))) != null && (container = ViewBindings.findChildViewById(rootView, (id = R.id.container))) != null && (group = ViewBindings.findChildViewById(rootView, (id = R.id.group))) != null && (subTitle = ViewBindings.findChildViewById(rootView, (id = R.id.sub_title))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliAppAddWidgetGuideToastBinding((FrameLayout) rootView, btnAdd, btnCancel, container, group, subTitle, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}