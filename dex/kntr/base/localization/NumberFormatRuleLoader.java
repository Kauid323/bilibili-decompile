package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/base/localization/NumberFormatRuleLoader;", "", "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "ruleFromConfig", "Lkntr/base/localization/NumberFormatRule;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NumberFormatRuleLoader {
    public static final NumberFormatRuleLoader INSTANCE = new NumberFormatRuleLoader();
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.localization.NumberFormatRuleLoader$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = NumberFormatRuleLoader.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);

    private NumberFormatRuleLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    public final NumberFormatRule ruleFromConfig() {
        try {
            String jsonContent = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "localization.number_format_rule", null, 2, null);
            if (jsonContent != null) {
                Json this_$iv = json;
                this_$iv.getSerializersModule();
                NumberFormatRule numberFormatRule = (NumberFormatRule) this_$iv.decodeFromString(NumberFormatRule.Companion.serializer(), jsonContent);
                if (numberFormatRule != null) {
                    return numberFormatRule;
                }
            }
            return NumberFormatRule.Companion.getDEFAULT();
        } catch (Exception e) {
            KLog_androidKt.getKLog().w("NumberFormat", "Failed to load number format rule from config: " + e.getMessage());
            return NumberFormatRule.Companion.getDEFAULT();
        }
    }
}