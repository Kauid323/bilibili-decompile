package tv.danmaku.bili.ui.main2.mine.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.servercomm.ServerClock;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;
import tv.danmaku.bili.ui.main2.mine.widgets.MineBannedItemView;

public class MineSilenceHolder extends RecyclerView.ViewHolder {
    private MineBannedItemView mBannedItemView;
    private IMineItemClickListener mItemClickListener;

    public MineSilenceHolder(View itemView, IMineItemClickListener onMineItemClickListener) {
        super(itemView);
        this.mBannedItemView = (MineBannedItemView) itemView.findViewById(R.id.mine_banned_entry);
        this.mItemClickListener = onMineItemClickListener;
    }

    public static MineSilenceHolder create(ViewGroup parent, IMineItemClickListener onMineItemClickListener) {
        return new MineSilenceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_silence, parent, false), onMineItemClickListener);
    }

    public void bind(AccountMine accountMine) {
        if (accountMine != null) {
            if (accountMine.silence == 1) {
                long curTime = ServerClock.unreliableNow() / 1000;
                long endTime = accountMine.end_time;
                boolean expire = false;
                if (endTime != 0) {
                    expire = curTime >= endTime;
                }
                this.mBannedItemView.setType(expire ? 2 : 1, new MineBannedItemView.IClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineSilenceHolder.1
                    @Override // tv.danmaku.bili.ui.main2.mine.widgets.MineBannedItemView.IClickListener
                    public void onClick() {
                        if (MineSilenceHolder.this.mBannedItemView.isClickable() && MineSilenceHolder.this.mItemClickListener != null) {
                            MineSilenceHolder.this.mItemClickListener.onSilenceItemClick();
                        }
                    }
                });
                return;
            }
        }
        this.mBannedItemView.setType(0, null);
    }
}