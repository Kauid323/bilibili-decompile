package kntr.base.net.comm.lbs.internal;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: LbRule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"parseBalanceRules", "", "Lkntr/base/net/comm/lbs/internal/LbRule;", RedirectImpKt.REDIRECT_KV_CONFIG, "", "lbs_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LbRuleKt {
    public static final List<LbRule> parseBalanceRules(String config) {
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        try {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            return (List) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(LbRule.Companion.serializer())), config);
        } catch (Exception e) {
            return null;
        }
    }
}