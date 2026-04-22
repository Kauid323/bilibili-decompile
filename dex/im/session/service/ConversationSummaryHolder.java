package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/session/service/ConversationSummaryHolder;", "", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "draftSummary", "Lim/session/service/Summary;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lim/session/service/Summary;)V", "getSessionId", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getDraftSummary", "()Lim/session/service/Summary;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSummaryHolder {
    private final Summary draftSummary;
    private final KSessionId sessionId;

    public static /* synthetic */ ConversationSummaryHolder copy$default(ConversationSummaryHolder conversationSummaryHolder, KSessionId kSessionId, Summary summary, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kSessionId = conversationSummaryHolder.sessionId;
        }
        if ((i2 & 2) != 0) {
            summary = conversationSummaryHolder.draftSummary;
        }
        return conversationSummaryHolder.copy(kSessionId, summary);
    }

    public final KSessionId component1() {
        return this.sessionId;
    }

    public final Summary component2() {
        return this.draftSummary;
    }

    public final ConversationSummaryHolder copy(KSessionId kSessionId, Summary summary) {
        Intrinsics.checkNotNullParameter(kSessionId, "sessionId");
        return new ConversationSummaryHolder(kSessionId, summary);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConversationSummaryHolder) {
            ConversationSummaryHolder conversationSummaryHolder = (ConversationSummaryHolder) obj;
            return Intrinsics.areEqual(this.sessionId, conversationSummaryHolder.sessionId) && Intrinsics.areEqual(this.draftSummary, conversationSummaryHolder.draftSummary);
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + (this.draftSummary == null ? 0 : this.draftSummary.hashCode());
    }

    public String toString() {
        KSessionId kSessionId = this.sessionId;
        return "ConversationSummaryHolder(sessionId=" + kSessionId + ", draftSummary=" + this.draftSummary + ")";
    }

    public ConversationSummaryHolder(KSessionId sessionId, Summary draftSummary) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.draftSummary = draftSummary;
    }

    public /* synthetic */ ConversationSummaryHolder(KSessionId kSessionId, Summary summary, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSessionId, (i2 & 2) != 0 ? null : summary);
    }

    public final KSessionId getSessionId() {
        return this.sessionId;
    }

    public final Summary getDraftSummary() {
        return this.draftSummary;
    }
}