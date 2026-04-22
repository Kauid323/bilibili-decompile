package tv.danmaku.bili.ui.main2.resource;

import android.content.Context;
import bili.resource.homepage.R;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.drawableresolver.IDrawableResolver;
import com.bilibili.lib.drawableresolver.StaticStateInfo;
import com.bilibili.lib.drawableresolver.StaticStateListVectorDrawableResolver;
import com.bilibili.lib.drawableresolver.StaticVectorDrawableResolver;
import com.bilibili.lib.homepage.util.UriUtils;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
public class LessonsModeResourceResolver {
    static final String BANGUMI_SWITCHER = "home_bangumi";
    static final String CHANNEL_SWITCHER = "channel_tab";
    static final String DYNAMIC_SWITCHER = "dynamic_tab";
    static final String GAME_SWITCHER = "game";
    static final String MALL_SWITCHER = "mall_tab";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PrimaryPage> forPrimaryPages() {
        List<PrimaryPage> pages = new ArrayList<>();
        Context context = BiliContext.application();
        if (context == null) {
            return pages;
        }
        pages.add(new PrimaryPage("200", context.getResources().getString(R.string.homepage_global_string_2), getTabIcon("bilibili://main/home"), "bilibili://main/home", 1, "home"));
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS, CHANNEL_SWITCHER)) {
            pages.add(new PrimaryPage(LoginQualityMonitor.CHECK_CODE_NET_TELECOM_OK, context.getResources().getString(bili.resource.following.R.string.following_global_string_87), getTabIcon(DefaultResourceResolver.CHANNEL), DefaultResourceResolver.CHANNEL, 1));
        }
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS, DYNAMIC_SWITCHER)) {
            pages.add(new PrimaryPage("202", context.getResources().getString(bili.resource.share.R.string.share_global_string_38), getTabIcon(DefaultResourceResolver.FOLLOWING), DefaultResourceResolver.FOLLOWING, 1, "dynamic"));
        }
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS, MALL_SWITCHER)) {
            pages.add(new PrimaryPage("203", context.getResources().getString(R.string.homepage_global_string_9), getTabIcon(DefaultResourceResolver.MALL), DefaultResourceResolver.MALL, 1, DefaultResourceResolver.MALL_TAB_ID));
        }
        pages.add(new PrimaryPage("204", context.getResources().getString(R.string.homepage_global_string_12), getTabIcon(DefaultResourceResolver.USER_CENTER), DefaultResourceResolver.USER_CENTER, 1, DefaultResourceResolver.USER_CENTER_TAB_ID));
        return pages;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<MenuItem> forHomeTopMenus() {
        List<MenuItem> menuItems = new ArrayList<>();
        Context context = BiliContext.application();
        if (context == null) {
            return menuItems;
        }
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS, "game")) {
            menuItems.add(new MenuItem("36", context.getResources().getString(bili.resource.others.R.string.others_global_string_72), getTabIcon("action://game_center/home/menu"), "action://game_center/home/menu", 1));
        }
        menuItems.add(new MenuItem(LoginReporterV2.Show.LOGIN_SUCCEED_FIRST_THIRD_PHONE, context.getResources().getString(bili.resource.share.R.string.share_global_string_35), getTabIcon(DefaultResourceResolver.MENU_IM), DefaultResourceResolver.MENU_IM, 1));
        return menuItems;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<SecondaryPage> forHomeSubPages() {
        List<SecondaryPage> secondaryPages = new ArrayList<>();
        Context context = BiliContext.application();
        if (context == null) {
            return secondaryPages;
        }
        secondaryPages.add(new SecondaryPage("20", context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_273), DefaultResourceResolver.HOME_LIVE, 1, DefaultResourceResolver.HOME_LIVE_TAB_ID));
        secondaryPages.add(new SecondaryPage(LoginReporterV2.Show.LOGIN_SUCCEED_QUICK_AFTER_REGISTER, context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_392), DefaultResourceResolver.HOME_PROMO, 1, DefaultResourceResolver.HOME_PROMO_TAB_ID));
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS)) {
            secondaryPages.add(new SecondaryPage(LoginReporterV2.Show.LOGIN_SUCCEED_SMS_NO_IDENTITY_FROM_SMS_LOGIN_DIALOG, context.getResources().getString(R.string.homepage_global_string_3), DefaultResourceResolver.HOME_HOTTOPIC, 1, DefaultResourceResolver.HOME_HOTTOPIC_TAB_ID));
        }
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS)) {
            secondaryPages.add(new SecondaryPage("30", context.getResources().getString(R.string.homepage_global_string_1), DefaultResourceResolver.HOME_BANGUMI, 1, "bangumi"));
        }
        if (!RestrictedMode.isEnable(RestrictedType.LESSONS)) {
            secondaryPages.add(new SecondaryPage(BiliAuthConstants.SOURCE_EVENT_PC_GAME, context.getResources().getString(R.string.homepage_global_string_4), DefaultResourceResolver.HOME_CINEMA, 1, DefaultResourceResolver.HOME_CINEMA_TAB_ID));
        }
        return secondaryPages;
    }

    static IDrawableResolver getTabIcon(String url) {
        Context context = BiliContext.application();
        if (UriUtils.equals("bilibili://main/home", url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_home_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_home_default).build());
        }
        if (UriUtils.equals(DefaultResourceResolver.CHANNEL, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_partition_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_partition_default).build());
        }
        if (UriUtils.equals(DefaultResourceResolver.FOLLOWING, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_moments_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_moments_default).build());
        }
        if (UriUtils.equals(DefaultResourceResolver.MALL, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_shopping_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_shopping_default).build());
        }
        if (UriUtils.equals(DefaultResourceResolver.USER_CENTER, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_mine_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_mine_default).build());
        }
        if (UriUtils.equals("action://game_center/home/menu", url)) {
            return new StaticVectorDrawableResolver(context, tv.danmaku.bili.widget.R.drawable.ic_vector_menu_game);
        }
        if (UriUtils.equals(DefaultResourceResolver.MENU_IM, url)) {
            return new StaticVectorDrawableResolver(context, tv.danmaku.bili.R.drawable.ic_vector_menu_im);
        }
        return null;
    }

    private LessonsModeResourceResolver() {
    }
}