package im.session.base;

import faceverify.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMConversationDraftService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lim/session/base/ConversationDraftHolder;", "", "prefix", "", q.KEY_RES_9_CONTENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPrefix", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationDraftHolder {
    private final String content;
    private final String prefix;

    public static /* synthetic */ ConversationDraftHolder copy$default(ConversationDraftHolder conversationDraftHolder, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = conversationDraftHolder.prefix;
        }
        if ((i2 & 2) != 0) {
            str2 = conversationDraftHolder.content;
        }
        return conversationDraftHolder.copy(str, str2);
    }

    public final String component1() {
        return this.prefix;
    }

    public final String component2() {
        return this.content;
    }

    public final ConversationDraftHolder copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(str2, q.KEY_RES_9_CONTENT);
        return new ConversationDraftHolder(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConversationDraftHolder) {
            ConversationDraftHolder conversationDraftHolder = (ConversationDraftHolder) obj;
            return Intrinsics.areEqual(this.prefix, conversationDraftHolder.prefix) && Intrinsics.areEqual(this.content, conversationDraftHolder.content);
        }
        return false;
    }

    public int hashCode() {
        return (this.prefix.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        String str = this.prefix;
        return "ConversationDraftHolder(prefix=" + str + ", content=" + this.content + ")";
    }

    public ConversationDraftHolder(String prefix, String content) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        this.prefix = prefix;
        this.content = content;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getContent() {
        return this.content;
    }
}