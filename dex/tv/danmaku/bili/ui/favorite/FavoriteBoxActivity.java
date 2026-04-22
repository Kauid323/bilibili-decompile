package tv.danmaku.bili.ui.favorite;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import bili.resource.common.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.moduleservice.appwidget.AutoAddAppWidgetService;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.bilibili.moduleservice.appwidget.IFunctionWidgetGuide;
import com.bilibili.ui.busbound.BusAppcompatActivity;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class FavoriteBoxActivity extends BusAppcompatActivity implements IFunctionWidgetGuide {
    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!BiliAccounts.get(this).isLogin()) {
            ToastHelper.showToastShort(this, R.string.common_global_string_371);
            finish();
        } else {
            tintStatusBar(this);
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add(16908290, SingleFavoritesFragment.newInstance(extractParam()), "SingleFavoritesFragment").commit();
            }
        }
        AutoAddAppWidgetService service = (AutoAddAppWidgetService) BLRouter.INSTANCE.getServices(AutoAddAppWidgetService.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (service != null) {
            service.startFunctionWidgetGuide(this, new GuideScene.Favorites(FavoritesConstsKt.PV_MAIN_FAVORITES_PAGE));
        }
    }

    private Bundle extractParam() {
        Bundle bundleExtra = getIntent().getExtras();
        if (bundleExtra != null) {
            return new Bundle(bundleExtra);
        }
        return new Bundle();
    }

    private void tintStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure() || garb.isPrimaryOnly()) {
            StatusBarCompat.tintStatusBar(activity, ThemeUtils.getThemeAttrColor(activity, androidx.appcompat.R.attr.colorPrimary));
        } else {
            StatusBarCompat.tintStatusBar(activity, garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
        }
        View rootView = activity.findViewById(16908290);
        if (rootView == null) {
            return;
        }
        rootView.setBackgroundResource(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        rootView.setPadding(0, StatusBarCompat.getStatusBarHeight(activity), 0, 0);
    }

    public void onBackPressed() {
        AutoAddAppWidgetService service = (AutoAddAppWidgetService) BLRouter.INSTANCE.getServices(AutoAddAppWidgetService.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        if ((true ^ service.closeFunctionWidgetGuide(this, new GuideScene.Favorites(FavoritesConstsKt.PV_MAIN_FAVORITES_PAGE))) & (service != null)) {
            super.onBackPressed();
        }
    }
}