package tv.danmaku.bili.ui.watchlater.consts;

import android.content.Context;
import android.content.SharedPreferences;
import bili.resource.homepage.R;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.base.BiliContext;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterConsts.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"#\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"allTabName", "", "getAllTabName", "()Ljava/lang/String;", "continueTabName", "getContinueTabName", "tabList", "Ltv/danmaku/bili/ui/watchlater/consts/Tabs;", "getTabList", "()Ltv/danmaku/bili/ui/watchlater/consts/Tabs;", "tabList$delegate", "Lkotlin/Lazy;", "<set-?>", "", "watchLaterInitialPage", "getWatchLaterInitialPage", "()I", "setWatchLaterInitialPage", "(I)V", "watchLaterInitialPage$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "bottomSheetItems", "", "getBottomSheetItems", "()Ljava/util/List;", "bottomDeleteSheetItems", "Lkotlin/Pair;", "getBottomDeleteSheetItems", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterConstsKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(WatchLaterConstsKt.class, "watchLaterInitialPage", "getWatchLaterInitialPage()I", 1))};
    private static final Lazy tabList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.watchlater.consts.WatchLaterConstsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Tabs tabList_delegate$lambda$0;
            tabList_delegate$lambda$0 = WatchLaterConstsKt.tabList_delegate$lambda$0();
            return tabList_delegate$lambda$0;
        }
    });
    private static final SharedPreferencesField watchLaterInitialPage$delegate = new SharedPreferencesField("watch_later_initial_page_index", 0, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final List<Integer> bottomSheetItems = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.homepage_global_string_109), Integer.valueOf(R.string.homepage_global_string_110), Integer.valueOf(bili.resource.favorites.R.string.favorites_global_string_103)});
    private static final List<Pair<Integer, Integer>> bottomDeleteSheetItems = CollectionsKt.listOf(new Pair(Integer.valueOf(com.bilibili.iconfont.R.drawable.ref_trash_delete_line_500), Integer.valueOf(bili.resource.common.R.string.common_global_string_113)));

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getAllTabName() {
        Object context = BiliContext.topActivity();
        if (context == null) {
            context = BiliContext.application();
            Intrinsics.checkNotNull(context);
        }
        String string = ((Context) context).getString(R.string.homepage_global_string_107);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getContinueTabName() {
        Object context = BiliContext.topActivity();
        if (context == null) {
            context = BiliContext.application();
            Intrinsics.checkNotNull(context);
        }
        String string = ((Context) context).getString(bili.resource.favorites.R.string.favorites_global_string_233);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final Tabs getTabList() {
        return (Tabs) tabList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tabs tabList_delegate$lambda$0() {
        return new Tabs(null, 1, null);
    }

    public static final int getWatchLaterInitialPage() {
        return ((Number) watchLaterInitialPage$delegate.getValue((Object) null, $$delegatedProperties[0])).intValue();
    }

    public static final void setWatchLaterInitialPage(int i) {
        watchLaterInitialPage$delegate.setValue((Object) null, $$delegatedProperties[0], Integer.valueOf(i));
    }

    public static final List<Integer> getBottomSheetItems() {
        return bottomSheetItems;
    }

    public static final List<Pair<Integer, Integer>> getBottomDeleteSheetItems() {
        return bottomDeleteSheetItems;
    }
}