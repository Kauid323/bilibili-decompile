package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.offline.StorageView;

public final class BiliAppFragmentToolbarOfflineBinding implements ViewBinding {
    public final TintLinearLayout bottomEntrance;
    public final TintToolbar navTopBar;
    public final RecyclerView recycler;
    public final TintTextView reserveEntrance;
    private final TintLinearLayout rootView;
    public final StorageView storageView;

    private BiliAppFragmentToolbarOfflineBinding(TintLinearLayout rootView, TintLinearLayout bottomEntrance, TintToolbar navTopBar, RecyclerView recycler, TintTextView reserveEntrance, StorageView storageView) {
        this.rootView = rootView;
        this.bottomEntrance = bottomEntrance;
        this.navTopBar = navTopBar;
        this.recycler = recycler;
        this.reserveEntrance = reserveEntrance;
        this.storageView = storageView;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentToolbarOfflineBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentToolbarOfflineBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_toolbar_offline, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentToolbarOfflineBinding bind(View rootView) {
        TintToolbar navTopBar;
        RecyclerView recycler;
        TintTextView reserveEntrance;
        StorageView storageView;
        int id = R.id.bottom_entrance;
        TintLinearLayout bottomEntrance = ViewBindings.findChildViewById(rootView, id);
        if (bottomEntrance != null && (navTopBar = ViewBindings.findChildViewById(rootView, (id = R.id.nav_top_bar))) != null && (recycler = ViewBindings.findChildViewById(rootView, (id = R.id.recycler))) != null && (reserveEntrance = ViewBindings.findChildViewById(rootView, (id = R.id.reserve_entrance))) != null && (storageView = ViewBindings.findChildViewById(rootView, (id = R.id.storage_view))) != null) {
            return new BiliAppFragmentToolbarOfflineBinding((TintLinearLayout) rootView, bottomEntrance, navTopBar, recycler, reserveEntrance, storageView);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}