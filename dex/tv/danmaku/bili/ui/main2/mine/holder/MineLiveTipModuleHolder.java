package tv.danmaku.bili.ui.main2.mine.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class MineLiveTipModuleHolder extends RecyclerView.ViewHolder {
    private BiliImageView mBtnIcon;
    private TintTextView mBtnText;
    private Context mContext;
    private TintTextView mLinkText;
    private View mTipBtnModeContainer;
    private BiliImageView mTipIcon;
    private View mTipIconModeContainer;
    private View mTipLinkModeContainer;
    private View mTipRootContainer;
    private TintTextView mTipText;

    public MineLiveTipModuleHolder(View itemView) {
        super(itemView);
        this.mContext = itemView.getContext();
        this.mTipRootContainer = itemView.findViewById(R.id.tip_root);
        this.mTipIcon = itemView.findViewById(R.id.tip_icon);
        this.mTipText = itemView.findViewById(R.id.tip_text);
        this.mTipBtnModeContainer = itemView.findViewById(R.id.tip_btn_mode);
        this.mTipLinkModeContainer = itemView.findViewById(R.id.tip_link_mode);
        this.mTipIconModeContainer = itemView.findViewById(R.id.tip_icon_mode);
        this.mBtnIcon = itemView.findViewById(R.id.tip_btn_icon);
        this.mBtnText = itemView.findViewById(R.id.tip_btn_text);
        this.mLinkText = itemView.findViewById(R.id.tip_link_text);
    }

    public static MineLiveTipModuleHolder create(ViewGroup parent) {
        return new MineLiveTipModuleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_live_tip, parent, false));
    }

    public void bind(final AccountMine mine) {
        if (mine == null || mine.liveTip == null || !mine.liveTip.isValid()) {
            this.mTipRootContainer.setVisibility(8);
            return;
        }
        final AccountMine.LiveTip liveTip = mine.liveTip;
        this.mTipRootContainer.setVisibility(0);
        if (TextUtils.isEmpty(liveTip.iconUrl)) {
            this.mTipIcon.setVisibility(8);
        } else {
            this.mTipIcon.setVisibility(0);
            BiliImageLoader.INSTANCE.with(this.mContext).url(liveTip.iconUrl).into(this.mTipIcon);
        }
        this.mTipText.setText(liveTip.text);
        if (liveTip.mode == 0 && !TextUtils.isEmpty(liveTip.btnText)) {
            updateBtnVisible(true, false, false);
            if (TextUtils.isEmpty(liveTip.btnIcon)) {
                this.mBtnIcon.setVisibility(8);
            } else {
                this.mBtnIcon.setVisibility(0);
                BiliImageLoader.INSTANCE.with(this.mContext).url(liveTip.btnIcon).into(this.mBtnIcon);
            }
            this.mBtnText.setText(liveTip.btnText);
        } else if (liveTip.mode == 1 && !TextUtils.isEmpty(liveTip.urlText)) {
            updateBtnVisible(false, true, false);
            this.mLinkText.setText(liveTip.urlText);
        } else if (liveTip.mode == 2) {
            updateBtnVisible(false, false, true);
        } else {
            updateBtnVisible(false, false, true);
        }
        this.mTipRootContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineLiveTipModuleHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineLiveTipModuleHolder.this.m2091lambda$bind$0$tvdanmakubiliuimain2mineholderMineLiveTipModuleHolder(liveTip, mine, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bind$0$tv-danmaku-bili-ui-main2-mine-holder-MineLiveTipModuleHolder  reason: not valid java name */
    public /* synthetic */ void m2091lambda$bind$0$tvdanmakubiliuimain2mineholderMineLiveTipModuleHolder(AccountMine.LiveTip liveTip, AccountMine mine, View v) {
        RouteRequest request = new RouteRequest.Builder(liveTip.url).build();
        BLRouter.routeTo(request, this.mContext);
        String liveType = mine.firstLiveTime > 0 ? "11" : MineReporter.LIVE_TYPE_UPPER_NO_LIVE;
        MineReporter.reportMineModuleButtonClick(liveTip.btnText, MineReporter.PUBLISH_TYPE_UPPER, liveType, Long.valueOf(liveTip.id));
    }

    private void updateBtnVisible(boolean btnVisible, boolean linkVisible, boolean iconVisible) {
        this.mTipBtnModeContainer.setVisibility(btnVisible ? 0 : 8);
        this.mTipLinkModeContainer.setVisibility(linkVisible ? 0 : 8);
        this.mTipIconModeContainer.setVisibility(iconVisible ? 0 : 8);
    }
}