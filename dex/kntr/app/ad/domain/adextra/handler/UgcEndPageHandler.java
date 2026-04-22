package kntr.app.ad.domain.adextra.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.adextra.AdExtraUgcEndPageQuery;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: UgcEndPageHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lkntr/app/ad/domain/adextra/handler/UgcEndPageHandler;", "Lkntr/app/ad/domain/adextra/handler/AbsHandler;", "Lkntr/app/ad/protocol/adextra/AdExtraUgcEndPageQuery;", "<init>", "()V", "buildExtra", "Lkotlinx/serialization/json/JsonObject;", "query", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UgcEndPageHandler extends AbsHandler<AdExtraUgcEndPageQuery> {
    @Override // kntr.app.ad.domain.adextra.handler.AbsHandler
    public JsonObject buildExtra(AdExtraUgcEndPageQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        boolean z = false;
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        int i = 0;
        Iterable $this$map$iv = query.getCtxAds();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AdExtraUgcEndPageQuery.CtxAd ad = (AdExtraUgcEndPageQuery.CtxAd) item$iv$iv;
            JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
            boolean z2 = z;
            JsonElementBuildersKt.put(builder$iv2, ReportBuildInParam.RESOURCE_ID, Long.valueOf(ad.getResourceId()));
            JsonElementBuildersKt.put(builder$iv2, "source_id", Long.valueOf(ad.getSourceId()));
            JsonElementBuildersKt.put(builder$iv2, ReportBuildInParam.CREATIVE_ID, Long.valueOf(ad.getCreativeId()));
            JsonElementBuildersKt.put(builder$iv2, "index", Integer.valueOf(ad.getIndex()));
            destination$iv$iv.add(builder$iv2.build());
            i = i;
            z = z2;
        }
        builder$iv.put("ctx_ads", new JsonArray((List) destination$iv$iv));
        return builder$iv.build();
    }
}