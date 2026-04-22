package kntr.common.ouro.core.plugin.pasteboard;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroUniversalLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroPasteboardState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lkntr/common/ouro/core/plugin/pasteboard/LinkParsingTask;", "", "url", "", "node", "Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "status", "Lkntr/common/ouro/core/plugin/pasteboard/ParsingStatus;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/node/OuroUniversalLink;Lkntr/common/ouro/core/plugin/pasteboard/ParsingStatus;)V", "getUrl", "()Ljava/lang/String;", "getNode", "()Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "getStatus", "()Lkntr/common/ouro/core/plugin/pasteboard/ParsingStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LinkParsingTask {
    private final OuroUniversalLink node;
    private final ParsingStatus status;
    private final String url;

    public static /* synthetic */ LinkParsingTask copy$default(LinkParsingTask linkParsingTask, String str, OuroUniversalLink ouroUniversalLink, ParsingStatus parsingStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkParsingTask.url;
        }
        if ((i & 2) != 0) {
            ouroUniversalLink = linkParsingTask.node;
        }
        if ((i & 4) != 0) {
            parsingStatus = linkParsingTask.status;
        }
        return linkParsingTask.copy(str, ouroUniversalLink, parsingStatus);
    }

    public final String component1() {
        return this.url;
    }

    public final OuroUniversalLink component2() {
        return this.node;
    }

    public final ParsingStatus component3() {
        return this.status;
    }

    public final LinkParsingTask copy(String str, OuroUniversalLink ouroUniversalLink, ParsingStatus parsingStatus) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(ouroUniversalLink, "node");
        Intrinsics.checkNotNullParameter(parsingStatus, "status");
        return new LinkParsingTask(str, ouroUniversalLink, parsingStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LinkParsingTask) {
            LinkParsingTask linkParsingTask = (LinkParsingTask) obj;
            return Intrinsics.areEqual(this.url, linkParsingTask.url) && Intrinsics.areEqual(this.node, linkParsingTask.node) && Intrinsics.areEqual(this.status, linkParsingTask.status);
        }
        return false;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.node.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        String str = this.url;
        OuroUniversalLink ouroUniversalLink = this.node;
        return "LinkParsingTask(url=" + str + ", node=" + ouroUniversalLink + ", status=" + this.status + ")";
    }

    public LinkParsingTask(String url, OuroUniversalLink node, ParsingStatus status) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(status, "status");
        this.url = url;
        this.node = node;
        this.status = status;
    }

    public final String getUrl() {
        return this.url;
    }

    public final OuroUniversalLink getNode() {
        return this.node;
    }

    public final ParsingStatus getStatus() {
        return this.status;
    }
}