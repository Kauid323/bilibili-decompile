package tv.danmaku.bili.ui.rank.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.ui.menu.IFloatMenuItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tv.danmaku.bili.ui.rank.RankVideoListFragment;
import tv.danmaku.bili.ui.rank.menu.PromoMenuWindow;
import tv.danmaku.bili.ui.rank.model.RankModel;

public abstract class ViewHolderBase extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static final int HUNDRED_MILLION = 100000000;
    private static final int TEN_THOUSAND = 10000;
    protected boolean hasHeader;
    protected WeakReference<RankVideoListFragment> mFragment;
    protected String mTitle;

    public abstract void bind(RankModel rankModel, WeakReference<RankVideoListFragment> weakReference);

    public ViewHolderBase(View itemView, String title) {
        super(itemView);
        this.mTitle = title;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRank() {
        if (this.hasHeader) {
            return getAbsoluteAdapterPosition();
        }
        return getAbsoluteAdapterPosition() + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showPromoMenu(View v, String avId) {
        if (isFragmentEnabled()) {
            Context context = v.getContext();
            List<IFloatMenuItem> menus = new ArrayList<>();
            menus.add(PromoMenuWindow.createWatchLaterMenuItem(context, this.mTitle, avId));
            PromoMenuWindow.show(context, v, menus);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFragmentEnabled() {
        return (this.mFragment == null || this.mFragment.get() == null) ? false : true;
    }

    public static String formatTimeWithHour(long position) {
        return formatTimeWithHour(position, false);
    }

    public static String formatTimeWithHour(long position, boolean showHourWhenZero) {
        long totalSeconds = position / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        return (hours > 0 || showHourWhenZero) ? String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)) : String.format(Locale.US, "%02d:%02d", Long.valueOf(minutes), Long.valueOf(seconds));
    }
}