package tv.danmaku.bili.ui.main2.resource;

import android.content.SharedPreferences;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.lib.blrouter.BLRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: HomeTabServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"+\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"TAG", "", "getHomeTabServiceImpl", "Ltv/danmaku/bili/ui/main2/resource/HomeTabServiceImpl;", "<set-?>", "", "spFirstRequestTime", "getSpFirstRequestTime", "()J", "setSpFirstRequestTime", "(J)V", "spFirstRequestTime$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "spSelectedIds", "getSpSelectedIds", "()Ljava/lang/String;", "setSpSelectedIds", "(Ljava/lang/String;)V", "spSelectedIds$delegate", "getSelectedInterestIds", "setSelectedInterestIds", "", "selectedIds", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeTabServiceImplKt {
    private static final String TAG = "HomeTabServiceImpl";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(HomeTabServiceImplKt.class, "spFirstRequestTime", "getSpFirstRequestTime()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(HomeTabServiceImplKt.class, "spSelectedIds", "getSpSelectedIds()Ljava/lang/String;", 1))};
    private static final SharedPreferencesField spFirstRequestTime$delegate = new SharedPreferencesField("pref_interest_tab_request_time", 0L, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final SharedPreferencesField spSelectedIds$delegate = new SharedPreferencesField("pref_selected_interest_ids", "", (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    public static final HomeTabServiceImpl getHomeTabServiceImpl() {
        Object obj = BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        if (obj instanceof HomeTabServiceImpl) {
            return (HomeTabServiceImpl) obj;
        }
        return null;
    }

    public static final long getSpFirstRequestTime() {
        return ((Number) spFirstRequestTime$delegate.getValue((Object) null, $$delegatedProperties[0])).longValue();
    }

    public static final void setSpFirstRequestTime(long j) {
        spFirstRequestTime$delegate.setValue((Object) null, $$delegatedProperties[0], Long.valueOf(j));
    }

    public static final String getSpSelectedIds() {
        return (String) spSelectedIds$delegate.getValue((Object) null, $$delegatedProperties[1]);
    }

    public static final void setSpSelectedIds(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        spSelectedIds$delegate.setValue((Object) null, $$delegatedProperties[1], str);
    }

    public static final String getSelectedInterestIds() {
        String str = null;
        if (getSpFirstRequestTime() != 0 && System.currentTimeMillis() - getSpFirstRequestTime() < 86400000) {
            String spSelectedIds = getSpSelectedIds();
            if (!StringsKt.isBlank(spSelectedIds)) {
                str = spSelectedIds;
            }
            return str;
        }
        setSpFirstRequestTime(0L);
        setSpSelectedIds("");
        return null;
    }

    public static final void setSelectedInterestIds(String selectedIds) {
        Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
        setSpFirstRequestTime(System.currentTimeMillis());
        setSpSelectedIds(selectedIds);
    }
}