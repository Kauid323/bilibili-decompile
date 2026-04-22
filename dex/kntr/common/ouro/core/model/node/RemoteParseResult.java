package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/model/node/RemoteParseResult;", "", "<init>", "()V", "raw", "", "getRaw", "()Ljava/lang/String;", "url", "getUrl", "Lkntr/common/ouro/core/model/node/EmoteParseResult;", "Lkntr/common/ouro/core/model/node/LinkParseResult;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class RemoteParseResult {
    public /* synthetic */ RemoteParseResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getRaw();

    public abstract String getUrl();

    private RemoteParseResult() {
    }
}