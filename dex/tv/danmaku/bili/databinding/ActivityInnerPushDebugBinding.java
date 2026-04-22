package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.R;

public final class ActivityInnerPushDebugBinding implements ViewBinding {
    public final Button btnCleanExposeCount;
    public final Button btnCleanPush;
    public final Button btnGeneratePush;
    public final Button btnLoadLocalBidExposeCount;
    public final Button btnLoadLocalCommonExposeCount;
    public final Button btnLoadLocalInnerPush;
    public final Button btnLoadLocalInnerPushConfig;
    public final TitleInputItemBinding itemBid;
    public final TitleInputItemBinding itemDisplayType;
    public final TitleInputItemBinding itemDuration;
    public final TitleInputItemBinding itemExpire;
    public final TitleInputItemBinding itemJob;
    public final TitleInputItemBinding itemLevel;
    public final TitleInputItemBinding itemQuery;
    public final TintToolbar navTopBar;
    private final LinearLayout rootView;
    public final TextView tvExpInfo;

    private ActivityInnerPushDebugBinding(LinearLayout rootView, Button btnCleanExposeCount, Button btnCleanPush, Button btnGeneratePush, Button btnLoadLocalBidExposeCount, Button btnLoadLocalCommonExposeCount, Button btnLoadLocalInnerPush, Button btnLoadLocalInnerPushConfig, TitleInputItemBinding itemBid, TitleInputItemBinding itemDisplayType, TitleInputItemBinding itemDuration, TitleInputItemBinding itemExpire, TitleInputItemBinding itemJob, TitleInputItemBinding itemLevel, TitleInputItemBinding itemQuery, TintToolbar navTopBar, TextView tvExpInfo) {
        this.rootView = rootView;
        this.btnCleanExposeCount = btnCleanExposeCount;
        this.btnCleanPush = btnCleanPush;
        this.btnGeneratePush = btnGeneratePush;
        this.btnLoadLocalBidExposeCount = btnLoadLocalBidExposeCount;
        this.btnLoadLocalCommonExposeCount = btnLoadLocalCommonExposeCount;
        this.btnLoadLocalInnerPush = btnLoadLocalInnerPush;
        this.btnLoadLocalInnerPushConfig = btnLoadLocalInnerPushConfig;
        this.itemBid = itemBid;
        this.itemDisplayType = itemDisplayType;
        this.itemDuration = itemDuration;
        this.itemExpire = itemExpire;
        this.itemJob = itemJob;
        this.itemLevel = itemLevel;
        this.itemQuery = itemQuery;
        this.navTopBar = navTopBar;
        this.tvExpInfo = tvExpInfo;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityInnerPushDebugBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityInnerPushDebugBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_inner_push_debug, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityInnerPushDebugBinding bind(View rootView) {
        View itemBid;
        int id = R.id.btn_clean_expose_count;
        Button btnCleanExposeCount = (Button) ViewBindings.findChildViewById(rootView, id);
        if (btnCleanExposeCount != null) {
            id = R.id.btn_clean_push;
            Button btnCleanPush = (Button) ViewBindings.findChildViewById(rootView, id);
            if (btnCleanPush != null) {
                id = R.id.btn_generate_push;
                Button btnGeneratePush = (Button) ViewBindings.findChildViewById(rootView, id);
                if (btnGeneratePush != null) {
                    id = R.id.btn_load_local_bid_expose_count;
                    Button btnLoadLocalBidExposeCount = (Button) ViewBindings.findChildViewById(rootView, id);
                    if (btnLoadLocalBidExposeCount != null) {
                        id = R.id.btn_load_local_common_expose_count;
                        Button btnLoadLocalCommonExposeCount = (Button) ViewBindings.findChildViewById(rootView, id);
                        if (btnLoadLocalCommonExposeCount != null) {
                            id = R.id.btn_load_local_inner_push;
                            Button btnLoadLocalInnerPush = (Button) ViewBindings.findChildViewById(rootView, id);
                            if (btnLoadLocalInnerPush != null) {
                                id = R.id.btn_load_local_inner_push_config;
                                Button btnLoadLocalInnerPushConfig = (Button) ViewBindings.findChildViewById(rootView, id);
                                if (btnLoadLocalInnerPushConfig != null && (itemBid = ViewBindings.findChildViewById(rootView, (id = R.id.item_bid))) != null) {
                                    TitleInputItemBinding binding_itemBid = TitleInputItemBinding.bind(itemBid);
                                    id = R.id.item_display_type;
                                    View itemDisplayType = ViewBindings.findChildViewById(rootView, id);
                                    if (itemDisplayType != null) {
                                        TitleInputItemBinding binding_itemDisplayType = TitleInputItemBinding.bind(itemDisplayType);
                                        id = R.id.item_duration;
                                        View itemDuration = ViewBindings.findChildViewById(rootView, id);
                                        if (itemDuration != null) {
                                            TitleInputItemBinding binding_itemDuration = TitleInputItemBinding.bind(itemDuration);
                                            id = R.id.item_expire;
                                            View itemExpire = ViewBindings.findChildViewById(rootView, id);
                                            if (itemExpire != null) {
                                                TitleInputItemBinding binding_itemExpire = TitleInputItemBinding.bind(itemExpire);
                                                id = R.id.item_job;
                                                View itemJob = ViewBindings.findChildViewById(rootView, id);
                                                if (itemJob != null) {
                                                    TitleInputItemBinding binding_itemJob = TitleInputItemBinding.bind(itemJob);
                                                    id = R.id.item_level;
                                                    View itemLevel = ViewBindings.findChildViewById(rootView, id);
                                                    if (itemLevel != null) {
                                                        TitleInputItemBinding binding_itemLevel = TitleInputItemBinding.bind(itemLevel);
                                                        id = R.id.item_query;
                                                        View itemQuery = ViewBindings.findChildViewById(rootView, id);
                                                        if (itemQuery != null) {
                                                            TitleInputItemBinding binding_itemQuery = TitleInputItemBinding.bind(itemQuery);
                                                            id = R.id.nav_top_bar;
                                                            TintToolbar navTopBar = ViewBindings.findChildViewById(rootView, id);
                                                            if (navTopBar != null) {
                                                                id = R.id.tv_exp_info;
                                                                TextView tvExpInfo = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                if (tvExpInfo != null) {
                                                                    return new ActivityInnerPushDebugBinding((LinearLayout) rootView, btnCleanExposeCount, btnCleanPush, btnGeneratePush, btnLoadLocalBidExposeCount, btnLoadLocalCommonExposeCount, btnLoadLocalInnerPush, btnLoadLocalInnerPushConfig, binding_itemBid, binding_itemDisplayType, binding_itemDuration, binding_itemExpire, binding_itemJob, binding_itemLevel, binding_itemQuery, navTopBar, tvExpInfo);
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