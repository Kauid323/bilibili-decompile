package kntr.app.oversea.translation.setting.guidance;

import java.util.Iterator;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.localization.Locale;
import kntr.base.localization.LocaleKt;
import kntr.base.localization.Localization;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ExistingUserGuidanceData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceRemoteConfig;", "", "<init>", "()V", "cachedLanguageMap", "", "", "Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;", "systemLanguageData", "getSystemLanguageData", "()Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;", "currentLanguageData", "getCurrentLanguageData", "normalizedSystemLocale", "Lkntr/base/localization/Locale;", "getNormalizedSystemLocale", "()Lkntr/base/localization/Locale;", "remoteConfigMap", "getRemoteConfigMap", "()Ljava/util/Map;", "translation-setting-guidance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExistingUserGuidanceRemoteConfig {
    private static Map<String, ExistingUserGuidanceData> cachedLanguageMap;
    public static final ExistingUserGuidanceRemoteConfig INSTANCE = new ExistingUserGuidanceRemoteConfig();
    public static final int $stable = 8;

    private ExistingUserGuidanceRemoteConfig() {
    }

    public final ExistingUserGuidanceData getSystemLanguageData() {
        try {
            return getRemoteConfigMap().get(getNormalizedSystemLocale().toLanguageTag());
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("ExistingUserGuidanceConfig", "Failed to find language config for " + getNormalizedSystemLocale(), e);
            return null;
        }
    }

    public final ExistingUserGuidanceData getCurrentLanguageData() {
        Locale currentLocal = Localization.INSTANCE.getCurrent();
        try {
            ExistingUserGuidanceData data = getRemoteConfigMap().get(currentLocal.toLanguageTag());
            if (data != null) {
                data.setLangChineseName(LocaleKt.getChineseName(getNormalizedSystemLocale()));
            }
            return data;
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("ExistingUserGuidanceConfig", "Failed to find language config for " + currentLocal, e);
            return null;
        }
    }

    private final Locale getNormalizedSystemLocale() {
        Object obj;
        Iterator<T> it = Localization.INSTANCE.getSUPPORTED_LIST().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Locale it2 = (Locale) obj;
            if (Intrinsics.areEqual(it2, LocaleKt.getNormalized(Localization.INSTANCE.getSYSTEM()))) {
                break;
            }
        }
        Locale locale = (Locale) obj;
        return locale == null ? Localization.INSTANCE.getDEFAULT() : locale;
    }

    private final Map<String, ExistingUserGuidanceData> getRemoteConfigMap() {
        if (cachedLanguageMap != null) {
            Map<String, ExistingUserGuidanceData> map = cachedLanguageMap;
            Intrinsics.checkNotNull(map);
            return map;
        }
        String configString = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "dd_localization_existing_user_guidance", null, 2, null);
        String str = configString;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                Json this_$iv = Json.Default;
                this_$iv.getSerializersModule();
                return (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, ExistingUserGuidanceData.Companion.serializer()), configString);
            } catch (Exception e) {
                KLog_androidKt.getKLog().e("ExistingUserGuidanceConfig", "Failed to parse language config: " + configString, e);
                return MapsKt.emptyMap();
            }
        }
        return MapsKt.emptyMap();
    }
}