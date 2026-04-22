package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.notice.CommonNoticeBar;

public final class BiliLayoutMainUserCenterNoticeBinding implements ViewBinding {
    public final TintImageView close;
    public final TintTextView content;
    public final TintImageView icNotice;
    public final CommonNoticeBar mineCommonNoticeBar;
    private final CommonNoticeBar rootView;

    private BiliLayoutMainUserCenterNoticeBinding(CommonNoticeBar rootView, TintImageView close, TintTextView content, TintImageView icNotice, CommonNoticeBar mineCommonNoticeBar) {
        this.rootView = rootView;
        this.close = close;
        this.content = content;
        this.icNotice = icNotice;
        this.mineCommonNoticeBar = mineCommonNoticeBar;
    }

    public CommonNoticeBar getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterNoticeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterNoticeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_notice, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterNoticeBinding bind(View rootView) {
        TintTextView content;
        TintImageView icNotice;
        int id = R.id.close;
        TintImageView close = ViewBindings.findChildViewById(rootView, id);
        if (close != null && (content = ViewBindings.findChildViewById(rootView, (id = R.id.content))) != null && (icNotice = ViewBindings.findChildViewById(rootView, (id = R.id.ic_notice))) != null) {
            CommonNoticeBar mineCommonNoticeBar = (CommonNoticeBar) rootView;
            return new BiliLayoutMainUserCenterNoticeBinding((CommonNoticeBar) rootView, close, content, icNotice, mineCommonNoticeBar);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}