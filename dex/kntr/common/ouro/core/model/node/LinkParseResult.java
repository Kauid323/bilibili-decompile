package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/core/model/node/LinkParseResult;", "Lkntr/common/ouro/core/model/node/RemoteParseResult;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "type", "", "getType", "()I", "bizId", "getBizId", "icon", "getIcon", "Lkntr/common/ouro/core/model/node/OpusParseResult;", "Lkntr/common/ouro/core/model/node/UnrecognizedUrlResult;", "Lkntr/common/ouro/core/model/node/VideoParseResult;", "Lkntr/common/ouro/core/model/node/WhitelistUrlParseResult;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class LinkParseResult extends RemoteParseResult {
    public /* synthetic */ LinkParseResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getBizId();

    public abstract String getIcon();

    public abstract String getTitle();

    public abstract int getType();

    private LinkParseResult() {
        super(null);
    }
}