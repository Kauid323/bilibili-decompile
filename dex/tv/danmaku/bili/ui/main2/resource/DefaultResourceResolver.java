package tv.danmaku.bili.ui.main2.resource;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.homepage.R;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.drawableresolver.IDrawableResolver;
import com.bilibili.lib.drawableresolver.StaticStateInfo;
import com.bilibili.lib.drawableresolver.StaticStateListVectorDrawableResolver;
import com.bilibili.lib.drawableresolver.StaticVectorDrawableResolver;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.teenagersmode.TeenagersMode;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class DefaultResourceResolver {
    public static final String ACTIVITY = "bilibili://following/home_bottom_tab_activity_tab";
    public static final String BOTTOM_PUBLISH_URL = "bilibili://uper/center_plus?relation_from=center_plus&tab_index=2";
    public static final String BOTTOM_SUB_TAB_CREATE = "bilibili://uper/user_center/add_archive/?from=2";
    public static final String BOTTOM_SUB_TAB_LIVE = "activity://liveStreaming/home";
    public static final String BOTTOM_SUB_TAB_TAKE_PICTURE = "bilibili://uper/user_center/add_archive/?from=1";
    public static final String BOTTOM_SUB_TAB_UPLOAD = "bilibili://uper/user_center/add_archive/?from=0";
    public static final String CHANNEL = "bilibili://pegasus/channel";
    public static final String FOLLOWING = "bilibili://following/home";
    public static final String FOLLOWING_TAB_ID = "dynamic";
    public static final String HOME = "bilibili://main/home";
    public static final String HOME_BANGUMI = "bilibili://pgc/home";
    public static final String HOME_BANGUMI_TAB_ID = "bangumi";
    public static final String HOME_BANGUMI_V2 = "bilibili://pgc/bangumi_v2";
    public static final String HOME_CATEGORY = "bilibili://main/top_category";
    public static final String HOME_CINEMA = "bilibili://pgc/home?home_flow_type=2";
    public static final String HOME_CINEMA_TAB = "bilibili://pgc/cinema-tab";
    public static final String HOME_CINEMA_TAB_ID = "film";
    public static final String HOME_CINEMA_TAB_V2 = "bilibili://pgc/cinema_v2";
    public static final String HOME_HOTTOPIC = "bilibili://pegasus/hottopic";
    public static final String HOME_HOTTOPIC_TAB_ID = "hottopic";
    public static final String HOME_LIVE = "bilibili://live/home";
    public static final String HOME_LIVE_TAB_ID = "直播tab";
    public static final String HOME_PROMO = "bilibili://pegasus/promo";
    public static final String HOME_PROMO_TAB_ID = "推荐tab";
    public static final String HOME_TAB_ID = "home";
    public static final String MALL = "bilibili://mall/home";
    public static final String MALL_HOMEPAGE = "bilibili://mall/homepage";
    public static final String MALL_TAB_ID = "会员购Bottom";
    public static final String MENU_GAME = "action://game_center/home/menu";
    public static final String MENU_IM = "action://link/home/menu";
    public static final String USER_CENTER = "bilibili://user_center/mine";
    public static final String USER_CENTER_TAB_ID = "我的Bottom";

    public static List<PrimaryPage> forPrimaryPages() {
        List<PrimaryPage> pages = new ArrayList<>();
        Context context = BiliContext.application();
        if (context == null) {
            return pages;
        }
        pages.add(new PrimaryPage("200", context.getResources().getString(R.string.homepage_global_string_2), getTabIcon("bilibili://main/home"), "bilibili://main/home", 1, "home"));
        pages.add(new PrimaryPage("202", context.getResources().getString(bili.resource.share.R.string.share_global_string_38), getTabIcon(FOLLOWING), FOLLOWING, 1, "dynamic"));
        PrimaryPage publish = new PrimaryPage();
        publish.isPublish = true;
        publish.id = "606";
        publish.url = BOTTOM_PUBLISH_URL;
        publish.title = context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_837);
        publish.from = 1;
        pages.add(publish);
        pages.add(new PrimaryPage("203", context.getResources().getString(R.string.homepage_global_string_9), getTabIcon(MALL), MALL, 1, MALL_TAB_ID));
        pages.add(new PrimaryPage("204", context.getResources().getString(R.string.homepage_global_string_12), getTabIcon(USER_CENTER), USER_CENTER, 1, USER_CENTER_TAB_ID));
        return pages;
    }

    public static List<MenuItem> forHomeTopMenus() {
        List<MenuItem> menuItems = new ArrayList<>();
        Context context = BiliContext.application();
        if (context == null) {
            return menuItems;
        }
        menuItems.add(new MenuItem(LoginReporterV2.Show.LOGIN_SUCCEED_FIRST_THIRD_PHONE, context.getResources().getString(bili.resource.share.R.string.share_global_string_35), getTabIcon(MENU_IM), MENU_IM, 1));
        return menuItems;
    }

    public static List<SecondaryPage> forHomeSubPages() {
        List<SecondaryPage> secondaryPages = new ArrayList<>();
        Context context = BiliContext.application();
        secondaryPages.add(new SecondaryPage("20", context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_273), HOME_LIVE, 1, HOME_LIVE_TAB_ID));
        secondaryPages.add(new SecondaryPage(LoginReporterV2.Show.LOGIN_SUCCEED_QUICK_AFTER_REGISTER, context.getResources().getString(R.string.homepage_global_string_11), HOME_PROMO, 1, HOME_PROMO_TAB_ID));
        secondaryPages.add(new SecondaryPage(LoginReporterV2.Show.LOGIN_SUCCEED_SMS_NO_IDENTITY_FROM_SMS_LOGIN_DIALOG, context.getResources().getString(R.string.homepage_global_string_3), HOME_HOTTOPIC, 1, HOME_HOTTOPIC_TAB_ID));
        secondaryPages.add(new SecondaryPage("30", context.getResources().getString(R.string.homepage_global_string_1), HOME_BANGUMI, 1, "bangumi"));
        secondaryPages.add(new SecondaryPage(BiliAuthConstants.SOURCE_EVENT_PC_GAME, context.getResources().getString(R.string.homepage_global_string_4), HOME_CINEMA, 1, HOME_CINEMA_TAB_ID));
        return secondaryPages;
    }

    public static MoreCategoryItem forCategoryItem() {
        if (TeenagersMode.getInstance().getEntranceState("channel") == 0) {
            return null;
        }
        return new MoreCategoryItem("bilibili://main/top_category", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IDrawableResolver getTabIcon(String url) {
        Context context = BiliContext.application();
        if (UriUtils.equals("bilibili://main/home", url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_home_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_home_default).build());
        }
        if (UriUtils.equals(CHANNEL, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_partition_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_partition_default).build());
        }
        if (UriUtils.equals(FOLLOWING, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_moments_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_moments_default).build());
        }
        if (UriUtils.equals(MALL, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_shopping_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_shopping_default).build());
        }
        if (UriUtils.equals(USER_CENTER, url)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_mine_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_mine_default).build());
        }
        if (!TextUtils.isEmpty(url) && url.startsWith(ACTIVITY)) {
            return new StaticStateListVectorDrawableResolver(context, new StaticStateInfo.Builder().selected(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_activity_selected).normal(com.bilibili.app.comm.baseres.R.drawable.ic_vector_tab_bar_activity_default).build());
        }
        if (UriUtils.equals("action://game_center/home/menu", url)) {
            return new StaticVectorDrawableResolver(context, tv.danmaku.bili.widget.R.drawable.ic_vector_menu_game);
        }
        if (UriUtils.equals(MENU_IM, url)) {
            return new StaticVectorDrawableResolver(context, tv.danmaku.bili.R.drawable.ic_vector_menu_im);
        }
        return null;
    }

    private DefaultResourceResolver() {
    }

    public static List<MainResourceManager.DialogItem> forDefaultDialogItems() {
        Context context = BiliContext.application();
        if (context == null) {
            return null;
        }
        List<MainResourceManager.DialogItem> items = new ArrayList<>();
        items.add(new MainResourceManager.DialogItem(context.getResources().getString(R.string.homepage_global_string_154), BOTTOM_SUB_TAB_LIVE, tv.danmaku.bili.R.drawable.ic_home_bottom_sub_live));
        items.add(new MainResourceManager.DialogItem(context.getResources().getString(bili.resource.following.R.string.following_global_string_353), BOTTOM_SUB_TAB_TAKE_PICTURE, tv.danmaku.bili.R.drawable.ic_home_bottom_sub_take_picture));
        items.add(new MainResourceManager.DialogItem(context.getResources().getString(R.string.homepage_global_string_367), BOTTOM_SUB_TAB_UPLOAD, tv.danmaku.bili.R.drawable.ic_home_bottom_sub_upload));
        items.add(new MainResourceManager.DialogItem(context.getResources().getString(R.string.homepage_global_string_140), BOTTOM_SUB_TAB_CREATE, tv.danmaku.bili.R.drawable.ic_home_bottom_sub_create));
        return items;
    }
}