package kntr.base.net.comm.muiltidomain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"parse", "", "Lkntr/base/net/comm/muiltidomain/RuleConfig;", RedirectImpKt.REDIRECT_KV_CONFIG, "", "multi_domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MultiDomainKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<RuleConfig> parse(String config) {
        try {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            Iterable list = (List) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(RuleConfig.Companion.serializer())), config);
            if (list == null) {
                return null;
            }
            Iterable $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                RuleConfig it = (RuleConfig) element$iv$iv;
                if (it.valid()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        } catch (Exception e) {
            return null;
        }
    }
}