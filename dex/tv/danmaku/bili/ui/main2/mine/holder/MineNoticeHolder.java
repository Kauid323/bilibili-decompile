package tv.danmaku.bili.ui.main2.mine.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;
import tv.danmaku.bili.ui.notice.CommonNoticeBar;
import tv.danmaku.bili.ui.notice.api.BiliNotice;

public class MineNoticeHolder extends RecyclerView.ViewHolder {
    private CommonNoticeBar mCommonNoticeBar;
    private IMineItemClickListener mItemClickListener;

    public MineNoticeHolder(View itemView, IMineItemClickListener onMineItemClickListener) {
        super(itemView);
        this.mCommonNoticeBar = (CommonNoticeBar) itemView.findViewById(R.id.mine_common_notice_bar);
        this.mItemClickListener = onMineItemClickListener;
    }

    public static MineNoticeHolder create(ViewGroup parent, IMineItemClickListener onMineItemClickListener) {
        return new MineNoticeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_notice, parent, false), onMineItemClickListener);
    }

    public void bind(BiliNotice result) {
        this.mCommonNoticeBar.updateNotice(result, new CommonNoticeBar.ICloseClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineNoticeHolder$$ExternalSyntheticLambda0
            @Override // tv.danmaku.bili.ui.notice.CommonNoticeBar.ICloseClickListener
            public final void onClick() {
                MineNoticeHolder.this.m2100lambda$bind$0$tvdanmakubiliuimain2mineholderMineNoticeHolder();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bind$0$tv-danmaku-bili-ui-main2-mine-holder-MineNoticeHolder  reason: not valid java name */
    public /* synthetic */ void m2100lambda$bind$0$tvdanmakubiliuimain2mineholderMineNoticeHolder() {
        if (this.mItemClickListener != null) {
            this.mItemClickListener.onNoticeItemClickClose();
        }
    }
}