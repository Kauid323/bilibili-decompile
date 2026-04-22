package im.session.service;

import faceverify.q;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002()B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0006\u0010\rJ\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0013¨\u0006*"}, d2 = {"Lim/session/service/Summary;", "", "prefix", "Lim/session/service/SummaryPrefix;", q.KEY_RES_9_CONTENT, "", "<init>", "(Lim/session/service/SummaryPrefix;Ljava/lang/String;)V", "seen0", "", "contentForDisplay", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILim/session/service/SummaryPrefix;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrefix$annotations", "()V", "getPrefix", "()Lim/session/service/SummaryPrefix;", "getContent", "()Ljava/lang/String;", "getContentForDisplay$annotations", "getContentForDisplay", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "$serializer", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Summary implements Comparable<Summary> {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final String contentForDisplay;
    private final SummaryPrefix prefix;

    public Summary() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ Summary copy$default(Summary summary, SummaryPrefix summaryPrefix, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            summaryPrefix = summary.prefix;
        }
        if ((i2 & 2) != 0) {
            str = summary.content;
        }
        return summary.copy(summaryPrefix, str);
    }

    public static /* synthetic */ void getContentForDisplay$annotations() {
    }

    public static /* synthetic */ void getPrefix$annotations() {
    }

    public final SummaryPrefix component1() {
        return this.prefix;
    }

    public final String component2() {
        return this.content;
    }

    public final Summary copy(SummaryPrefix summaryPrefix, String str) {
        Intrinsics.checkNotNullParameter(summaryPrefix, "prefix");
        Intrinsics.checkNotNullParameter(str, q.KEY_RES_9_CONTENT);
        return new Summary(summaryPrefix, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Summary) {
            Summary summary = (Summary) obj;
            return Intrinsics.areEqual(this.prefix, summary.prefix) && Intrinsics.areEqual(this.content, summary.content);
        }
        return false;
    }

    public int hashCode() {
        return (this.prefix.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        SummaryPrefix summaryPrefix = this.prefix;
        return "Summary(prefix=" + summaryPrefix + ", content=" + this.content + ")";
    }

    /* compiled from: IMMessageSummaryService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/service/Summary$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/service/Summary;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Summary> serializer() {
            return Summary$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Summary(int seen0, SummaryPrefix prefix, String content, String contentForDisplay, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.prefix = new SummaryPrefix((String) null, (SummaryPrefixType) null, 3, (DefaultConstructorMarker) null);
        } else {
            this.prefix = prefix;
        }
        if ((seen0 & 2) == 0) {
            this.content = "";
        } else {
            this.content = content;
        }
        if ((seen0 & 4) == 0) {
            this.contentForDisplay = StringsKt.replace$default(this.content, "\n", ServerSentEventKt.SPACE, false, 4, (Object) null);
        } else {
            this.contentForDisplay = contentForDisplay;
        }
    }

    public Summary(SummaryPrefix prefix, String content) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        this.prefix = prefix;
        this.content = content;
        this.contentForDisplay = StringsKt.replace$default(this.content, "\n", ServerSentEventKt.SPACE, false, 4, (Object) null);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(Summary self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.prefix, new SummaryPrefix((String) null, (SummaryPrefixType) null, 3, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 0, SummaryPrefix$$serializer.INSTANCE, self.prefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.content, "")) {
            output.encodeStringElement(serialDesc, 1, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.contentForDisplay, StringsKt.replace$default(self.content, "\n", ServerSentEventKt.SPACE, false, 4, (Object) null))) {
            output.encodeStringElement(serialDesc, 2, self.contentForDisplay);
        }
    }

    public /* synthetic */ Summary(SummaryPrefix summaryPrefix, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new SummaryPrefix((String) null, (SummaryPrefixType) null, 3, (DefaultConstructorMarker) null) : summaryPrefix, (i2 & 2) != 0 ? "" : str);
    }

    public final SummaryPrefix getPrefix() {
        return this.prefix;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentForDisplay() {
        return this.contentForDisplay;
    }

    @Override // java.lang.Comparable
    public int compareTo(Summary other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.prefix.compareTo(other.prefix);
    }
}