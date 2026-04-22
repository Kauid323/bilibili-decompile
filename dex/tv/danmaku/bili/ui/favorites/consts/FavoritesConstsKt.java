package tv.danmaku.bili.ui.favorites.consts;

import android.content.SharedPreferences;
import bili.resource.favorites.R;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesConsts.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b6\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"-\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\"-\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\n\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020#X\u0086T¢\u0006\u0002\n\u0000\"!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b%\u0010\n\"+\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\"\u000e\u00100\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010O\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010f\u001a\u000201X\u0086T¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"FAVORITES_TAB_TYPE_ALL", "", "FAVORITES_TAB_TYPE_VIDEO", "FAVORITES_TAB_TYPE_ARTICLE", "FAVORITES_TAB_TYPE_SONGS", "FOLLOW_TAB_ID", "followTabBottomSheetItems", "", "Lkotlin/Pair;", "getFollowTabBottomSheetItems", "()Ljava/util/List;", "followTabBottomSheetItems$delegate", "Lkotlin/Lazy;", "favTabArticleBottomSheetItems", "getFavTabArticleBottomSheetItems", "favTabArticleBottomSheetItems$delegate", "LOAD_MORE_OFFSET", "TYPE_FAV_VIDEO", "TYPE_FAV_ARTICLE", "TYPE_FAV_AUDIO", "TYPE_OGV_AID", "TYPE_OGV_EPID", "CARD_TYPE_VIDEO", "CARD_TYPE_AUDIO", "CARD_TYPE_ARTICLE", "CARD_TYPE_FOOTER", "CARD_TYPE_INVALID_VIDEO", "TAG_TYPE_PINK", "TAG_TYPE_GRAY", "PAY_LOAD_START_MANAGE", "PAY_LOAD_QUIT_MANAGE", "PAY_LOAD_CHECKED", "PAY_LOAD_UNCHECKED", "PAY_LOAD_OTHER", "FAV_ANIMATION_DURATION", "", "supportFavCardType", "getSupportFavCardType", "supportFavCardType$delegate", "<set-?>", "", "hasShowGuideWindow", "getHasShowGuideWindow", "()Z", "setHasShowGuideWindow", "(Z)V", "hasShowGuideWindow$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "ROUTE_RECOMMEND", "", "BATCH_ADD_WATCH_LATER_SP_MID", "KEY_SUB_TABS", "KEY_FAV_TAB_ID", "KEY_SEARCH_URL", "KEY_RED_DOT", "KEY_TAB_NAME", "KEY_SECOND_TAB_NAME", "KEY_DEFAULT_TAB_ID", "PV_MAIN_FAVORITES_PAGE", "FAV_CONTENT_CARD_SHOW", "FAV_CONTENT_CARD_CLICK", "FAV_FIRST_BUTTON_CLICK", "FAV_LONG_PRESS_BUTTON_CLICK", "FAV_SEC_BUTTON_CLICK", "FAV_TAB_SHOW", "FAV_CLEAR_INVALID_PANEL_CLICK", "FAV_FOLDER_TAB_ID", "FAV_FROM_SPMID", "FAV_LAYOUT_CHANGE_BUTTON_CLICK", "FAV_CREATE_FAVORITE_BUTTON_CLICK", "OID", "PLAYLIST_ID", "FAV_TYPE", "TAB_NAME", "SECOND_TAB_NAME", "IS_LAST_SEEN", "IS_ACQUIESCE", "POS", "FROM_SPMID", "IS_RENEWAL", "IS_END", "USER_STATE", "BUTTON_NAME", "LONG_PRESS_TYPE", "JUMP_TYPE", "SPMID", "ACTION_ID", "IS_VALID", "LAYOUT_TYPE", "JUMP_FOLDER_PAGE", "JUMP_DETAIL_PAGE", "CLEAR_INVALID_UP", "CLEAR_INVALID_SEARCH", "CLEAR_INVALID_CLEAR", "CLEAR_INVALID_CLEAR_ALL", "BUTTON_SEARCH", "BUTTON_ADD", "BUTTON_MANAGE", "BUTTON_CLEAR_INVALID", "BUTTON_NAME_ALL", "BUTTON_NAME_DELETE", "BUTTON_NAME_MOVE", "BUTTON_NAME_COPY", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesConstsKt {
    public static final String ACTION_ID = "action_id";
    public static final String BATCH_ADD_WATCH_LATER_SP_MID = "main.my-fav.sec-page.add";
    public static final String BUTTON_ADD = "1";
    public static final String BUTTON_CLEAR_INVALID = "3";
    public static final String BUTTON_MANAGE = "2";
    public static final String BUTTON_NAME = "button_name";
    public static final String BUTTON_NAME_ALL = "全部";
    public static final String BUTTON_NAME_COPY = "复制到";
    public static final String BUTTON_NAME_DELETE = "删除";
    public static final String BUTTON_NAME_MOVE = "移动到";
    public static final String BUTTON_SEARCH = "0";
    public static final int CARD_TYPE_ARTICLE = 3;
    public static final int CARD_TYPE_AUDIO = 2;
    public static final int CARD_TYPE_FOOTER = 4;
    public static final int CARD_TYPE_INVALID_VIDEO = 5;
    public static final int CARD_TYPE_VIDEO = 1;
    public static final String CLEAR_INVALID_CLEAR = "clear";
    public static final String CLEAR_INVALID_CLEAR_ALL = "clear_all";
    public static final String CLEAR_INVALID_SEARCH = "search";
    public static final String CLEAR_INVALID_UP = "up";
    public static final int FAVORITES_TAB_TYPE_ALL = 101;
    public static final int FAVORITES_TAB_TYPE_ARTICLE = 103;
    public static final int FAVORITES_TAB_TYPE_SONGS = 120;
    public static final int FAVORITES_TAB_TYPE_VIDEO = 102;
    public static final long FAV_ANIMATION_DURATION = 200;
    public static final String FAV_CLEAR_INVALID_PANEL_CLICK = "main.my-fav.content-card.invalid-card-panel.click";
    public static final String FAV_CONTENT_CARD_CLICK = "main.my-fav.content-card.0.click";
    public static final String FAV_CONTENT_CARD_SHOW = "main.my-fav.content-card.0.show";
    public static final String FAV_CREATE_FAVORITE_BUTTON_CLICK = "main.my-fav.create-favorite-button.0.click";
    public static final String FAV_FIRST_BUTTON_CLICK = "main.my-fav.first-button.0.click";
    public static final int FAV_FOLDER_TAB_ID = 100;
    public static final String FAV_FROM_SPMID = "main.my-fav.0.0";
    public static final String FAV_LAYOUT_CHANGE_BUTTON_CLICK = "main.my-fav.layout-change-button.0.click";
    public static final String FAV_LONG_PRESS_BUTTON_CLICK = "main.my-fav.long-press-button.0.click";
    public static final String FAV_SEC_BUTTON_CLICK = "main.my-fav.sec-button.button.click";
    public static final String FAV_TAB_SHOW = "main.my-fav.tab.0.show";
    public static final String FAV_TYPE = "fav_type";
    public static final int FOLLOW_TAB_ID = 234;
    public static final String FROM_SPMID = "from_spmid";
    public static final String IS_ACQUIESCE = "is_acquiesce";
    public static final String IS_END = "is_end";
    public static final String IS_LAST_SEEN = "is_lastseen";
    public static final String IS_RENEWAL = "is_renewal";
    public static final String IS_VALID = "is_valid";
    public static final String JUMP_DETAIL_PAGE = "2";
    public static final String JUMP_FOLDER_PAGE = "1";
    public static final String JUMP_TYPE = "jump_type";
    public static final String KEY_DEFAULT_TAB_ID = "default_tab";
    public static final String KEY_FAV_TAB_ID = "key_favorites_tab_id";
    public static final String KEY_RED_DOT = "key_red_dot";
    public static final String KEY_SEARCH_URL = "search_uri";
    public static final String KEY_SECOND_TAB_NAME = "second_tab_name";
    public static final String KEY_SUB_TABS = "sub_tab";
    public static final String KEY_TAB_NAME = "tab_name";
    public static final String LAYOUT_TYPE = "layout_type";
    public static final int LOAD_MORE_OFFSET = 2;
    public static final String LONG_PRESS_TYPE = "long_press_type";
    public static final String OID = "oid";
    public static final int PAY_LOAD_CHECKED = 3;
    public static final int PAY_LOAD_OTHER = 5;
    public static final int PAY_LOAD_QUIT_MANAGE = 2;
    public static final int PAY_LOAD_START_MANAGE = 1;
    public static final int PAY_LOAD_UNCHECKED = 4;
    public static final String PLAYLIST_ID = "playlist_id";
    public static final String POS = "pos";
    public static final String PV_MAIN_FAVORITES_PAGE = "main.my-fav.0.0.pv";
    public static final String ROUTE_RECOMMEND = "bilibili://home?bottom_tab_name=首页&tab_id=推荐tab";
    public static final String SECOND_TAB_NAME = "second_tab_name";
    public static final String SPMID = "spmid";
    public static final String TAB_NAME = "tab_name";
    public static final int TAG_TYPE_GRAY = 2;
    public static final int TAG_TYPE_PINK = 1;
    public static final int TYPE_FAV_ARTICLE = 302;
    public static final int TYPE_FAV_AUDIO = 12;
    public static final int TYPE_FAV_VIDEO = 2;
    public static final int TYPE_OGV_AID = 42;
    public static final int TYPE_OGV_EPID = 24;
    public static final String USER_STATE = "user_state";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(FavoritesConstsKt.class, "hasShowGuideWindow", "getHasShowGuideWindow()Z", 1))};
    private static final Lazy followTabBottomSheetItems$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            List followTabBottomSheetItems_delegate$lambda$0;
            followTabBottomSheetItems_delegate$lambda$0 = FavoritesConstsKt.followTabBottomSheetItems_delegate$lambda$0();
            return followTabBottomSheetItems_delegate$lambda$0;
        }
    });
    private static final Lazy favTabArticleBottomSheetItems$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            List favTabArticleBottomSheetItems_delegate$lambda$0;
            favTabArticleBottomSheetItems_delegate$lambda$0 = FavoritesConstsKt.favTabArticleBottomSheetItems_delegate$lambda$0();
            return favTabArticleBottomSheetItems_delegate$lambda$0;
        }
    });
    private static final Lazy supportFavCardType$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            List supportFavCardType_delegate$lambda$0;
            supportFavCardType_delegate$lambda$0 = FavoritesConstsKt.supportFavCardType_delegate$lambda$0();
            return supportFavCardType_delegate$lambda$0;
        }
    });
    private static final SharedPreferencesField hasShowGuideWindow$delegate = new SharedPreferencesField("favorites_folder_show_guide", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    public static final List<Pair<Integer, Integer>> getFollowTabBottomSheetItems() {
        return (List) followTabBottomSheetItems$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List followTabBottomSheetItems_delegate$lambda$0() {
        return CollectionsKt.listOf(new Pair(Integer.valueOf(R.string.favorites_global_string_176), Integer.valueOf(tv.danmaku.bili.R.drawable.ic_vector_heart_collect_off_line)));
    }

    public static final List<Pair<Integer, Integer>> getFavTabArticleBottomSheetItems() {
        return (List) favTabArticleBottomSheetItems$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List favTabArticleBottomSheetItems_delegate$lambda$0() {
        return CollectionsKt.listOf(new Pair(Integer.valueOf(R.string.favorites_global_string_26), Integer.valueOf(tv.danmaku.bili.R.drawable.ic_vector_star_fav_off_line)));
    }

    public static final List<Integer> getSupportFavCardType() {
        return (List) supportFavCardType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List supportFavCardType_delegate$lambda$0() {
        return CollectionsKt.listOf(new Integer[]{2, 302, 12, 42, 42});
    }

    public static final boolean getHasShowGuideWindow() {
        return ((Boolean) hasShowGuideWindow$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final void setHasShowGuideWindow(boolean z) {
        hasShowGuideWindow$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}