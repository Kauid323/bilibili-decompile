package tv.danmaku.bili.ui.splash.brand.reporter;

import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfo;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.common.search.QueryItem;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashReporter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011J\u001c\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u001c\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001cH\u0007¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/reporter/BrandSplashReporter;", "", "<init>", "()V", "reportBrandSplashShow", "", "brand", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "reportNonBrandSplashShow", "reportSettingPageShow", "reportSettingTabClick", "source", "", "reportCustomBrandSplashClicked", "id", "", "isChecked", "", "reportEnterPreviewPage", "isCustomMode", "reportCustomSwitchClicked", "open", "reportSaveButtonClicked", "list", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "reportSplashSearchWordClick", "param", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashReporter {
    public static final int $stable = 0;
    public static final BrandSplashReporter INSTANCE = new BrandSplashReporter();

    private BrandSplashReporter() {
    }

    @JvmStatic
    public static final void reportBrandSplashShow(BrandShowInfo brand) {
        Intrinsics.checkNotNullParameter(brand, "brand");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("open_screen_mode", String.valueOf(brand.getReportFlag()));
        pairArr[1] = TuplesKt.to("open_screen_id", String.valueOf(brand.getId()));
        pairArr[2] = TuplesKt.to("screen_type", brand.isVipSplash() ? "2" : "1");
        pairArr[3] = TuplesKt.to("open_screen_type", Intrinsics.areEqual(brand.getMode(), BrandSplashKt.MODE_FULL) ? "2" : "1");
        QueryItem queryItem = brand.getQueryItem();
        pairArr[4] = TuplesKt.to("flash_screen_query_id", queryItem != null ? String.valueOf(queryItem.getId()) : null);
        pairArr[5] = TuplesKt.to("open_screen_typename", brand.getSource());
        Neurons.reportExposure$default(false, "main.open-screen.load.0.show", MapsKt.mapOf(pairArr), (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void reportNonBrandSplashShow() {
        Neurons.reportExposure$default(false, "main.open-screen.load.0.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("open_screen_mode", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE), TuplesKt.to("open_screen_type", "1")}), (List) null, 8, (Object) null);
    }

    public final void reportSettingPageShow() {
        Neurons.reportExposure$default(false, "main.setting.open-screen.mode-tab.show", (Map) null, (List) null, 12, (Object) null);
    }

    public final void reportSettingTabClick(String source) {
        if (source == null) {
            return;
        }
        Neurons.reportClick(false, "main.setting.open-screen.self-mode-tab.click", MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, source)));
    }

    public final void reportCustomBrandSplashClicked(long id, String source, boolean isChecked) {
        Intrinsics.checkNotNullParameter(source, "source");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("screen_id", String.valueOf(id));
        pairArr[1] = TuplesKt.to("screen_typename", source);
        pairArr[2] = TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, isChecked ? "choose" : SplashCustomReporterKt.STATE_CANCEL);
        Neurons.reportClick(false, "main.setting.open-screen.self-check.click", MapsKt.mapOf(pairArr));
    }

    public final void reportEnterPreviewPage(long id, String source, boolean isCustomMode) {
        Intrinsics.checkNotNullParameter(source, "source");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("screen_id", String.valueOf(id));
        pairArr[1] = TuplesKt.to("screen_typename", source);
        pairArr[2] = TuplesKt.to("screen_mode", isCustomMode ? "self" : "default");
        Neurons.reportClick(false, "main.setting.open-screen.self-pic.click", MapsKt.mapOf(pairArr));
    }

    public final void reportCustomSwitchClicked(boolean open) {
        Neurons.reportClick(false, "main.setting.open-screen.mode-switch.click", MapsKt.mapOf(TuplesKt.to("open_screen_mode", open ? "1" : "0")));
    }

    public final void reportSaveButtonClicked(boolean isCustomMode, List<BrandSplash> list) {
        List list2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(list2, "list");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("screen_num", String.valueOf(list2.size()));
        pairArr[1] = TuplesKt.to("is_custom_on", isCustomMode ? "1" : "0");
        List $this$filter$iv = list2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            BrandSplash it = (BrandSplash) element$iv$iv;
            if (Intrinsics.areEqual(it.getSource(), BrandSplashSource.BRAND.getValue())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        pairArr[2] = TuplesKt.to("screen_id", CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence reportSaveButtonClicked$lambda$1;
                reportSaveButtonClicked$lambda$1 = BrandSplashReporter.reportSaveButtonClicked$lambda$1((BrandSplash) obj);
                return reportSaveButtonClicked$lambda$1;
            }
        }, 30, (Object) null));
        List $this$filter$iv2 = list2;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            BrandSplash it2 = (BrandSplash) element$iv$iv2;
            if (Intrinsics.areEqual(it2.getSource(), BrandSplashSource.VIP.getValue())) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        pairArr[3] = TuplesKt.to("vip_screen_id", CollectionsKt.joinToString$default((List) destination$iv$iv2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence reportSaveButtonClicked$lambda$3;
                reportSaveButtonClicked$lambda$3 = BrandSplashReporter.reportSaveButtonClicked$lambda$3((BrandSplash) obj);
                return reportSaveButtonClicked$lambda$3;
            }
        }, 30, (Object) null));
        List $this$filter$iv3 = list2;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv3) {
            BrandSplash it3 = (BrandSplash) element$iv$iv3;
            if (Intrinsics.areEqual(it3.getSource(), BrandSplashSource.DLC.getValue())) {
                destination$iv$iv3.add(element$iv$iv3);
            }
        }
        pairArr[4] = TuplesKt.to("dlc_screen_id", CollectionsKt.joinToString$default((List) destination$iv$iv3, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                CharSequence reportSaveButtonClicked$lambda$5;
                reportSaveButtonClicked$lambda$5 = BrandSplashReporter.reportSaveButtonClicked$lambda$5((BrandSplash) obj);
                return reportSaveButtonClicked$lambda$5;
            }
        }, 30, (Object) null));
        Neurons.reportClick(false, "main.setting.open-screen.self-save.click", MapsKt.mapOf(pairArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportSaveButtonClicked$lambda$1(BrandSplash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BrandSplashKt.getUniqueId(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportSaveButtonClicked$lambda$3(BrandSplash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BrandSplashKt.getUniqueId(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportSaveButtonClicked$lambda$5(BrandSplash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BrandSplashKt.getUniqueId(it);
    }

    @JvmStatic
    public static final void reportSplashSearchWordClick(Map<String, String> map) {
        Map param = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(param, "param");
        Neurons.reportClick(false, "main.open-screen.load.usefulness.click", param);
    }
}