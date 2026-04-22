package kntr.base.localization;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Locale.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b\"\u001e\u0010\t\u001a\u00020\u0004*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\b\"\u001e\u0010\u000b\u001a\u00020\u0004*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\u000b\u0010\b\"\u001e\u0010\r\u001a\u00020\u0004*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\r\u0010\b\"\u001e\u0010\u000f\u001a\u00020\u0005*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0013\u001a\u00020\u0002*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"traditionalChineseRegions", "", "", "isEnglish", "", "Lkntr/base/localization/Locale;", "isEnglish$annotations", "(Lkntr/base/localization/Locale;)V", "(Lkntr/base/localization/Locale;)Z", "isChinese", "isChinese$annotations", "isTraditionalChinese", "isTraditionalChinese$annotations", "isSimplifiedChinese", "isSimplifiedChinese$annotations", "normalized", "getNormalized$annotations", "getNormalized", "(Lkntr/base/localization/Locale;)Lkntr/base/localization/Locale;", "chineseName", "getChineseName", "(Lkntr/base/localization/Locale;)Ljava/lang/String;", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocaleKt {
    private static final Set<String> traditionalChineseRegions = SetsKt.setOf(new String[]{"HK", "TW", "MO"});

    public static /* synthetic */ void getNormalized$annotations(Locale locale) {
    }

    public static /* synthetic */ void isChinese$annotations(Locale locale) {
    }

    public static /* synthetic */ void isEnglish$annotations(Locale locale) {
    }

    public static /* synthetic */ void isSimplifiedChinese$annotations(Locale locale) {
    }

    public static /* synthetic */ void isTraditionalChinese$annotations(Locale locale) {
    }

    public static final boolean isEnglish(Locale $this$isEnglish) {
        Intrinsics.checkNotNullParameter($this$isEnglish, "<this>");
        return Intrinsics.areEqual($this$isEnglish.getLanguage(), "en");
    }

    public static final boolean isChinese(Locale $this$isChinese) {
        Intrinsics.checkNotNullParameter($this$isChinese, "<this>");
        return Intrinsics.areEqual($this$isChinese.getLanguage(), "zh");
    }

    public static final boolean isTraditionalChinese(Locale $this$isTraditionalChinese) {
        Intrinsics.checkNotNullParameter($this$isTraditionalChinese, "<this>");
        if (isChinese($this$isTraditionalChinese)) {
            if (!Intrinsics.areEqual($this$isTraditionalChinese.getScript(), Locale.Companion.getTRADITIONAL_CHINESE().getScript())) {
                Set<String> set = traditionalChineseRegions;
                String upperCase = $this$isTraditionalChinese.getRegion().toUpperCase(java.util.Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (set.contains(upperCase)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean isSimplifiedChinese(Locale $this$isSimplifiedChinese) {
        Intrinsics.checkNotNullParameter($this$isSimplifiedChinese, "<this>");
        return isChinese($this$isSimplifiedChinese) && !isTraditionalChinese($this$isSimplifiedChinese);
    }

    public static final Locale getNormalized(Locale $this$normalized) {
        Intrinsics.checkNotNullParameter($this$normalized, "<this>");
        return isTraditionalChinese($this$normalized) ? Locale.Companion.getTRADITIONAL_CHINESE() : isSimplifiedChinese($this$normalized) ? Locale.Companion.getSIMPLIFIED_CHINESE() : new Locale($this$normalized.getLanguage());
    }

    public static final String getChineseName(Locale $this$chineseName) {
        Intrinsics.checkNotNullParameter($this$chineseName, "<this>");
        return Intrinsics.areEqual($this$chineseName, Locale.Companion.getSIMPLIFIED_CHINESE()) ? "简体中文" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getTRADITIONAL_CHINESE()) ? "繁體中文" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getENGLISH()) ? "英语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getFRENCH()) ? "法语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getGERMAN()) ? "德语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getITALIAN()) ? "意大利语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getJAPANESE()) ? "日语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getSPANISH()) ? "西班牙语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getRUSSIAN()) ? "俄语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getKOREAN()) ? "韩语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getPORTUGUESE()) ? "葡萄牙语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getARABIC()) ? "阿拉伯语" : Intrinsics.areEqual($this$chineseName, Locale.Companion.getTHAI()) ? "泰语" : "中文";
    }
}