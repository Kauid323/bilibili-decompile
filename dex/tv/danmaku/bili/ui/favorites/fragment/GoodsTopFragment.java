package tv.danmaku.bili.ui.favorites.fragment;

import android.os.Bundle;
import android.view.View;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.SubTab;

/* compiled from: GoodsTopFragment.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/GoodsTopFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GoodsTopFragment extends FavoritesTopTabBaseFragment {
    public static final int $stable = 8;

    @Override // tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        List<SubTab> subTabs = getSubTabs();
        if ((subTabs != null ? subTabs.size() : 0) <= 1) {
            ListExtentionsKt.gone(getBinding().topContainer);
        }
    }
}