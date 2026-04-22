package kntr.base.ktor.ignet.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.ktor.ignet.IgnetHttpEngine;
import kotlin.Metadata;

/* compiled from: KtorClient.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"getBiliKtorHttpClientEngine", "Lio/ktor/client/engine/HttpClientEngine;", "ktor-ignet-engine_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KtorClient_androidKt {
    public static final HttpClientEngine getBiliKtorHttpClientEngine() {
        return new IgnetHttpEngine(new HttpClientEngineConfig());
    }
}