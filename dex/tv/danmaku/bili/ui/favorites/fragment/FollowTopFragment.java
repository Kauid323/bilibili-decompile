package tv.danmaku.bili.ui.favorites.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bili.resource.favorites.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.SubTab;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;

/* compiled from: FollowTopFragment.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/fragment/FollowTopFragment;", "Ltv/danmaku/bili/ui/favorites/fragment/FavoritesTopTabBaseFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initUI", "onRetryClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowTopFragment extends FavoritesTopTabBaseFragment {
    public static final int $stable = 8;

    @Override // tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    private final void initUI() {
        getBinding();
        List<SubTab> subTabs = getSubTabs();
        if (subTabs == null || subTabs.isEmpty()) {
            FavoritesTopTabBaseFragment.showEmptyView$default(this, R.string.favorites_global_string_175, R.string.favorites_global_string_163, null, 4, null);
        } else {
            hideEmptyView();
        }
    }

    @Override // tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabBaseFragment
    public void onRetryClick() {
        WatchLaterRouterKt.routerTo$default(FavoritesConstsKt.ROUTE_RECOMMEND, getContext(), (Map) null, 4, (Object) null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}