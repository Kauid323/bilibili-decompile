package tv.danmaku.bili.ui.main2.resource;

import com.bilibili.app.comm.list.common.campus.HomeCampusSwitchKt;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.homepage.startdust.secondary.BasePrimaryMultiPageFragment;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.recommendmode.RecommendMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;
import tv.danmaku.bili.ui.main2.MainTransaction;

/* compiled from: HomeTabReporter.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u001a\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u001a\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0007*\u00020\u0001H\u0002\u001a\u0006\u0010\u0017\u001a\u00020\f\u001a\u0016\u0010\u0018\u001a\u00020\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000e\u001a\u001a\u0010\u001b\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015\u001a\u0016\u0010\u001d\u001a\u00020\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000e\u001a\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"isHomeTabBuild", "", "isRemoteHomeTabSaved", "hasCampusTabReported", "hasTabSaveReported", "hasTabBuildReported", "TAG", "", "samplerValue", "", "KEY_TYPE", "onHomeTabBuildPages", "", "pages", "", "Lcom/bilibili/lib/homepage/startdust/secondary/BasePrimaryMultiPageFragment$PageInfo;", "onHomeTabResponseSaved", "tabs", "onHomeTabFilterOut", "tabName", "getExtraParams", "", "toReportString", "onHomeTabResponseSavedWithCampusTab", "reportGetGameMenu", CommonMenuBottomSheetKt.KEY_ITEMS, "Ltv/danmaku/bili/ui/main2/resource/MenuItem;", "reportGameMenuShow", "params", "reportBuildMenu", "isFirstBuildMenu", "reportMenuInvalid", "item", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeTabReporterKt {
    private static final String KEY_TYPE = "event_type";
    private static final String TAG = "HomeTabReporter";
    private static volatile boolean hasCampusTabReported;
    private static volatile boolean hasTabBuildReported;
    private static volatile boolean hasTabSaveReported;
    private static boolean isFirstBuildMenu;
    private static volatile boolean isHomeTabBuild;
    private static volatile boolean isRemoteHomeTabSaved;
    private static final int samplerValue;

    static {
        Integer intOrNull;
        String str = (String) ConfigManager.Companion.config().get("main.home_tab_reporter_sampler", LoginQualityMonitor.CHECK_CODE_NET_CMOBILE_NO);
        samplerValue = (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 100 : intOrNull.intValue();
        isFirstBuildMenu = true;
    }

    public static final void onHomeTabBuildPages(List<BasePrimaryMultiPageFragment.PageInfo> list) {
        Sequence asSequence;
        Sequence filterNotNull;
        Sequence map;
        isHomeTabBuild = true;
        String tabs = (list == null || (asSequence = CollectionsKt.asSequence(list)) == null || (filterNotNull = SequencesKt.filterNotNull(asSequence)) == null || (map = SequencesKt.map(filterNotNull, new Function1() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                String onHomeTabBuildPages$lambda$0;
                onHomeTabBuildPages$lambda$0 = HomeTabReporterKt.onHomeTabBuildPages$lambda$0((BasePrimaryMultiPageFragment.PageInfo) obj);
                return onHomeTabBuildPages$lambda$0;
            }
        })) == null || (tabs = SequencesKt.joinToString$default(map, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)) == null) ? "" : "";
        BLog.i(TAG, "onHomeTabBuildPages :" + tabs);
        if (hasTabBuildReported) {
            return;
        }
        hasTabBuildReported = true;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(KEY_TYPE, "tab_display");
        pairArr[1] = TuplesKt.to("from_cache", isRemoteHomeTabSaved ? "false" : "true");
        pairArr[2] = TuplesKt.to("tabs", tabs);
        pairArr[3] = TuplesKt.to("app_first_start", EnvironmentManager.getInstance().isFirstStart() ? "true" : "false");
        Neurons.trackT$default(false, "main.homepage.tab.show.track", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean onHomeTabBuildPages$lambda$1;
                onHomeTabBuildPages$lambda$1 = HomeTabReporterKt.onHomeTabBuildPages$lambda$1();
                return Boolean.valueOf(onHomeTabBuildPages$lambda$1);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onHomeTabBuildPages$lambda$0(BasePrimaryMultiPageFragment.PageInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onHomeTabBuildPages$lambda$1() {
        return Random.Default.nextInt(100) < samplerValue;
    }

    public static final void onHomeTabResponseSaved(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "tabs");
        isRemoteHomeTabSaved = true;
        if (hasTabSaveReported) {
            return;
        }
        hasTabSaveReported = true;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(KEY_TYPE, "tab_api");
        pairArr[1] = TuplesKt.to("tabs", CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        pairArr[2] = TuplesKt.to("app_first_start", EnvironmentManager.getInstance().isFirstStart() ? "true" : "false");
        Neurons.trackT$default(false, "main.homepage.tab.show.track", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda6
            public final Object invoke() {
                boolean onHomeTabResponseSaved$lambda$0;
                onHomeTabResponseSaved$lambda$0 = HomeTabReporterKt.onHomeTabResponseSaved$lambda$0();
                return Boolean.valueOf(onHomeTabResponseSaved$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onHomeTabResponseSaved$lambda$0() {
        return Random.Default.nextInt(100) < samplerValue;
    }

    public static final void onHomeTabFilterOut(String tabName) {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(KEY_TYPE, "tab_filtered_out");
        pairArr[1] = TuplesKt.to("tabs", tabName);
        pairArr[2] = TuplesKt.to("app_first_start", EnvironmentManager.getInstance().isFirstStart() ? "true" : "false");
        Map $this$onHomeTabFilterOut_u24lambda_u240 = MapsKt.mutableMapOf(pairArr);
        $this$onHomeTabFilterOut_u24lambda_u240.putAll(getExtraParams());
        Unit unit = Unit.INSTANCE;
        Neurons.trackT$default(false, "main.homepage.tab.show.track", $this$onHomeTabFilterOut_u24lambda_u240, 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean onHomeTabFilterOut$lambda$1;
                onHomeTabFilterOut$lambda$1 = HomeTabReporterKt.onHomeTabFilterOut$lambda$1();
                return Boolean.valueOf(onHomeTabFilterOut$lambda$1);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onHomeTabFilterOut$lambda$1() {
        return Random.Default.nextInt(100) < samplerValue;
    }

    private static final Map<String, String> getExtraParams() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("recommend_mode", toReportString(RecommendMode.isRecommendModeEnable())), TuplesKt.to("home_campus_switch", toReportString(HomeCampusSwitchKt.canShowHomeCampusTab()))});
    }

    private static final String toReportString(boolean $this$toReportString) {
        return $this$toReportString ? "1" : "2";
    }

    public static final void onHomeTabResponseSavedWithCampusTab() {
        if (hasCampusTabReported) {
            return;
        }
        hasCampusTabReported = true;
        Neurons.reportExposure$default(false, "main.homepage.tab-list.get-judge.show", MapsKt.mapOf(TuplesKt.to("get_judge", isHomeTabBuild ? "cache" : "issue")), (List) null, 8, (Object) null);
    }

    public static final void reportGetGameMenu(List<? extends MenuItem> list) {
        Object obj;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str = ((MenuItem) next).url;
                Intrinsics.checkNotNullExpressionValue(str, "url");
                if (StringsKt.contains$default(str, AppConfig.HOST_GAME_CENTER, false, 2, (Object) null)) {
                    obj = next;
                    break;
                }
            }
            MenuItem it2 = (MenuItem) obj;
            if (it2 != null) {
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to(KEY_TYPE, "get_game_menu");
                String str2 = it2.iconUrl;
                if (str2 == null) {
                    str2 = "";
                }
                pairArr[1] = TuplesKt.to("icon", str2);
                String str3 = it2.animatorIconUrl;
                if (str3 == null) {
                    str3 = "";
                }
                pairArr[2] = TuplesKt.to("animate_icon", str3);
                String str4 = it2.url;
                pairArr[3] = TuplesKt.to(AudioIntentHelper.ARGS_URI, str4 != null ? str4 : "");
                pairArr[4] = TuplesKt.to(MainTransaction.ARGS_ANCHOR_TAB_ID, it2.id);
                Neurons.trackT$default(false, "home_top_menu_show_track", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        boolean reportGetGameMenu$lambda$1$0;
                        reportGetGameMenu$lambda$1$0 = HomeTabReporterKt.reportGetGameMenu$lambda$1$0();
                        return Boolean.valueOf(reportGetGameMenu$lambda$1$0);
                    }
                }, 8, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportGetGameMenu$lambda$1$0() {
        return true;
    }

    public static final void reportGameMenuShow(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        Map map2 = new LinkedHashMap();
        map2.putAll(map);
        map2.put(KEY_TYPE, "game_menu_show");
        Neurons.trackT$default(false, "home_top_menu_show_track", map2, 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda4
            public final Object invoke() {
                boolean reportGameMenuShow$lambda$0;
                reportGameMenuShow$lambda$0 = HomeTabReporterKt.reportGameMenuShow$lambda$0();
                return Boolean.valueOf(reportGameMenuShow$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportGameMenuShow$lambda$0() {
        return true;
    }

    public static final void reportBuildMenu(List<? extends MenuItem> list) {
        Object obj;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str = ((MenuItem) next).url;
                Intrinsics.checkNotNullExpressionValue(str, "url");
                if (StringsKt.contains$default(str, AppConfig.HOST_GAME_CENTER, false, 2, (Object) null)) {
                    obj = next;
                    break;
                }
            }
            MenuItem it2 = (MenuItem) obj;
            if (it2 != null) {
                Pair[] pairArr = new Pair[6];
                pairArr[0] = TuplesKt.to(KEY_TYPE, "build_menu");
                String str2 = it2.iconUrl;
                if (str2 == null) {
                    str2 = "";
                }
                pairArr[1] = TuplesKt.to("icon", str2);
                String str3 = it2.animatorIconUrl;
                if (str3 == null) {
                    str3 = "";
                }
                pairArr[2] = TuplesKt.to("animate_icon", str3);
                String str4 = it2.url;
                pairArr[3] = TuplesKt.to(AudioIntentHelper.ARGS_URI, str4 != null ? str4 : "");
                pairArr[4] = TuplesKt.to(MainTransaction.ARGS_ANCHOR_TAB_ID, it2.id);
                pairArr[5] = TuplesKt.to("cold_launch_build", String.valueOf(isFirstBuildMenu));
                Neurons.trackT$default(false, "home_top_menu_show_track", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        boolean reportBuildMenu$lambda$1$0;
                        reportBuildMenu$lambda$1$0 = HomeTabReporterKt.reportBuildMenu$lambda$1$0();
                        return Boolean.valueOf(reportBuildMenu$lambda$1$0);
                    }
                }, 8, (Object) null);
            }
        }
        if (isFirstBuildMenu) {
            isFirstBuildMenu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportBuildMenu$lambda$1$0() {
        return true;
    }

    public static final void reportMenuInvalid(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to(KEY_TYPE, "invalid_menu");
        String str = item.iconUrl;
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("icon", str);
        String str2 = item.animatorIconUrl;
        if (str2 == null) {
            str2 = "";
        }
        pairArr[2] = TuplesKt.to("animate_icon", str2);
        String str3 = item.url;
        pairArr[3] = TuplesKt.to(AudioIntentHelper.ARGS_URI, str3 != null ? str3 : "");
        pairArr[4] = TuplesKt.to(MainTransaction.ARGS_ANCHOR_TAB_ID, item.id);
        Neurons.trackT$default(false, "home_top_menu_show_track", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean reportMenuInvalid$lambda$0;
                reportMenuInvalid$lambda$0 = HomeTabReporterKt.reportMenuInvalid$lambda$0();
                return Boolean.valueOf(reportMenuInvalid$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportMenuInvalid$lambda$0() {
        return true;
    }
}