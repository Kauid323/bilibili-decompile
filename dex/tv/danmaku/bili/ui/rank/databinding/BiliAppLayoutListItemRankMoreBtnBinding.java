package tv.danmaku.bili.ui.rank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.rank.R;

public final class BiliAppLayoutListItemRankMoreBtnBinding implements ViewBinding {
    private final View rootView;
    public final LinearLayout upMoreContain;
    public final ImageView upMoreExpand;
    public final TintTextView upMoreText;

    private BiliAppLayoutListItemRankMoreBtnBinding(View rootView, LinearLayout upMoreContain, ImageView upMoreExpand, TintTextView upMoreText) {
        this.rootView = rootView;
        this.upMoreContain = upMoreContain;
        this.upMoreExpand = upMoreExpand;
        this.upMoreText = upMoreText;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutListItemRankMoreBtnBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_layout_list_item_rank_more_btn, parent);
        return bind(parent);
    }

    public static BiliAppLayoutListItemRankMoreBtnBinding bind(View rootView) {
        TintTextView upMoreText;
        int id = R.id.up_more_contain;
        LinearLayout upMoreContain = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (upMoreContain != null) {
            id = R.id.up_more_expand;
            ImageView upMoreExpand = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (upMoreExpand != null && (upMoreText = ViewBindings.findChildViewById(rootView, (id = R.id.up_more_text))) != null) {
                return new BiliAppLayoutListItemRankMoreBtnBinding(rootView, upMoreContain, upMoreExpand, upMoreText);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}