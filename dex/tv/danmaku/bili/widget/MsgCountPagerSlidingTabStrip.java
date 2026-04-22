package tv.danmaku.bili.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class MsgCountPagerSlidingTabStrip extends PagerSlidingTabStrip {
    public MsgCountPagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public MsgCountPagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MsgCountPagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // tv.danmaku.bili.widget.PagerSlidingTabStrip
    protected View generateTab(int position, CharSequence title) {
        RelativeLayout layout = (RelativeLayout) View.inflate(getContext(), com.bilibili.lib.widget.R.layout.bili_widget_layout_tab_with_msg, null);
        TextView tab = (TextView) layout.findViewById(com.bilibili.lib.widget.R.id.tab_title);
        tab.setText(title);
        tab.setGravity(17);
        tab.setEllipsize(TextUtils.TruncateAt.END);
        tab.setSingleLine();
        tab.setPadding(getTabPaddingLeftRight(), 0, getTabPaddingLeftRight(), 0);
        tab.setMaxWidth(getTabTextMaxWidth());
        return layout;
    }

    @Override // tv.danmaku.bili.widget.PagerSlidingTabStrip
    protected float measureTabItemWidth(View tabItemView) {
        TextView tab = (TextView) tabItemView.findViewById(com.bilibili.lib.widget.R.id.tab_title);
        if (tab == null) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        return tab.getPaint().measureText(tab.getText(), 0, tab.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showMsg(int position, int num) {
        if (position >= getTabCount() || position < 0) {
            return;
        }
        if (num <= 0) {
            hideMsg(position);
            return;
        }
        View tabView = getTabAt(position);
        if (tabView instanceof RelativeLayout) {
            MsgView msgView = (MsgView) tabView.findViewById(com.bilibili.lib.widget.R.id.tab_msg_count);
            MsgView msgView2 = msgView;
            if (msgView == null) {
                TintTextView createMsgView = createMsgView();
                ((RelativeLayout) tabView).addView(createMsgView);
                msgView2 = createMsgView;
            }
            msgView2.setVisibility(0);
            setCount(msgView2, num);
        }
    }

    private MsgView createMsgView() {
        MsgView msgView = new MsgView(getContext());
        msgView.setId(com.bilibili.lib.widget.R.id.tab_msg_count);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(7, com.bilibili.lib.widget.R.id.tab_title);
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        msgView.setLayoutParams(layoutParams);
        msgView.setGravity(17);
        msgView.setTextColorById(com.bilibili.app.comm.baseres.R.color.theme_color_primary);
        msgView.setTextSize(2, 9.0f);
        msgView.getPaint().setFakeBoldText(true);
        msgView.setBackgroundColor(getResources().getColor(17170443));
        msgView.setIsRadiusHalfHeight(true);
        msgView.setVisibility(8);
        return msgView;
    }

    private void setCount(MsgView msgView, int num) {
        String count = num >= 99 ? "99+" : String.valueOf(num);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) msgView.getLayoutParams();
        DisplayMetrics dm = msgView.getResources().getDisplayMetrics();
        if (num <= 0 || num >= 10) {
            if (num < 99) {
                lp.height = (int) (dm.density * 14.0f);
                lp.width = -2;
                msgView.setPadding((int) (dm.density * 4.0f), 0, (int) (dm.density * 4.0f), 0);
                if (getShouldExpand()) {
                    lp.rightMargin = -((int) (dm.density * 4.0f));
                }
            } else {
                lp.height = (int) (dm.density * 14.0f);
                lp.width = -2;
                msgView.setPadding((int) (dm.density * 4.0f), 0, (int) (dm.density * 4.0f), 0);
                if (getShouldExpand()) {
                    lp.rightMargin = -((int) (dm.density * 8.0f));
                }
            }
        } else {
            lp.height = (int) (dm.density * 14.0f);
            lp.width = (int) (dm.density * 14.0f);
        }
        msgView.setLayoutParams(lp);
        msgView.setText(count);
    }

    public void hideMsg(int position) {
        View tabView = getTabAt(position);
        MsgView msgView = (MsgView) tabView.findViewById(com.bilibili.lib.widget.R.id.tab_msg_count);
        if (msgView != null) {
            msgView.setVisibility(8);
        }
    }

    public boolean isMsgCountVisible(int position) {
        View tabView = getTabAt(position);
        MsgView msgView = (MsgView) tabView.findViewById(com.bilibili.lib.widget.R.id.tab_msg_count);
        return msgView != null && msgView.getVisibility() == 0;
    }
}