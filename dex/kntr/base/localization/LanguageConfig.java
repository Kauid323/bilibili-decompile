package kntr.base.localization;

import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: LanguageConfig.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkntr/base/localization/LanguageConfig;", "", "<init>", "()V", "TAG", "", "remoteLanguageConfig", "", "Lkntr/base/localization/AiTranslateConfig;", "getRemoteLanguageConfig", "()Ljava/util/List;", "isSupportAiTranslate", "", "locale", "Lkntr/base/localization/Locale;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LanguageConfig {
    public static final int $stable = 0;
    public static final LanguageConfig INSTANCE = new LanguageConfig();
    private static final String TAG = "LanguageConfig";

    private LanguageConfig() {
    }

    public final List<AiTranslateConfig> getRemoteLanguageConfig() {
        String configString = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "dd_localization_language_config", null, 2, null);
        String str = configString;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                Json this_$iv = Json.Default;
                this_$iv.getSerializersModule();
                return (List) this_$iv.decodeFromString(new ArrayListSerializer(AiTranslateConfig.Companion.serializer()), configString);
            } catch (Exception e) {
                KLog_androidKt.getKLog().e(TAG, "Failed to parse language config: " + configString, e);
                return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.emptyList();
    }

    public final boolean isSupportAiTranslate(Locale locale) {
        Object obj;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Iterator<T> it = getRemoteLanguageConfig().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            AiTranslateConfig it2 = (AiTranslateConfig) obj;
            if (Intrinsics.areEqual(it2.getLanguageTag(), locale.toLanguageTag())) {
                break;
            }
        }
        AiTranslateConfig aiTranslateConfig = (AiTranslateConfig) obj;
        if (aiTranslateConfig != null) {
            return aiTranslateConfig.getSupportAiTranslate();
        }
        return false;
    }
}