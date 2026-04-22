package im.session.service;

import com.bapis.bilibili.app.im.v1.KMsgSummary;
import faceverify.q;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002#$B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lim/session/service/SummaryPrefix;", "", q.KEY_RES_9_CONTENT, "", "prefixType", "Lim/session/service/SummaryPrefixType;", "<init>", "(Ljava/lang/String;Lim/session/service/SummaryPrefixType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lim/session/service/SummaryPrefixType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContent", "()Ljava/lang/String;", "getPrefixType", "()Lim/session/service/SummaryPrefixType;", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "Companion", "$serializer", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SummaryPrefix implements Comparable<SummaryPrefix> {
    private final String content;
    private final SummaryPrefixType prefixType;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.service.SummaryPrefix$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SummaryPrefix._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public SummaryPrefix() {
        this((String) null, (SummaryPrefixType) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SummaryPrefix copy$default(SummaryPrefix summaryPrefix, String str, SummaryPrefixType summaryPrefixType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = summaryPrefix.content;
        }
        if ((i2 & 2) != 0) {
            summaryPrefixType = summaryPrefix.prefixType;
        }
        return summaryPrefix.copy(str, summaryPrefixType);
    }

    public final String component1() {
        return this.content;
    }

    public final SummaryPrefixType component2() {
        return this.prefixType;
    }

    public final SummaryPrefix copy(String str, SummaryPrefixType summaryPrefixType) {
        Intrinsics.checkNotNullParameter(str, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(summaryPrefixType, "prefixType");
        return new SummaryPrefix(str, summaryPrefixType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SummaryPrefix) {
            SummaryPrefix summaryPrefix = (SummaryPrefix) obj;
            return Intrinsics.areEqual(this.content, summaryPrefix.content) && this.prefixType == summaryPrefix.prefixType;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + this.prefixType.hashCode();
    }

    public String toString() {
        String str = this.content;
        return "SummaryPrefix(content=" + str + ", prefixType=" + this.prefixType + ")";
    }

    public /* synthetic */ SummaryPrefix(int seen0, String content, SummaryPrefixType prefixType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.content = "";
        } else {
            this.content = content;
        }
        if ((seen0 & 2) == 0) {
            this.prefixType = SummaryPrefixType.None;
        } else {
            this.prefixType = prefixType;
        }
    }

    public SummaryPrefix(String content, SummaryPrefixType prefixType) {
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(prefixType, "prefixType");
        this.content = content;
        this.prefixType = prefixType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("im.session.service.SummaryPrefixType", SummaryPrefixType.values());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(SummaryPrefix self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.content, "")) {
            output.encodeStringElement(serialDesc, 0, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.prefixType != SummaryPrefixType.None) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.prefixType);
        }
    }

    public /* synthetic */ SummaryPrefix(String str, SummaryPrefixType summaryPrefixType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? SummaryPrefixType.None : summaryPrefixType);
    }

    public final String getContent() {
        return this.content;
    }

    public final SummaryPrefixType getPrefixType() {
        return this.prefixType;
    }

    /* compiled from: IMMessageSummaryService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000b"}, d2 = {"Lim/session/service/SummaryPrefix$Companion;", "", "<init>", "()V", "from", "Lim/session/service/SummaryPrefix;", "prefixType", "Lcom/bapis/bilibili/app/im/v1/KMsgSummary;", "toPrefix", "serializer", "Lkotlinx/serialization/KSerializer;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SummaryPrefix> serializer() {
            return SummaryPrefix$$serializer.INSTANCE;
        }

        public final SummaryPrefix from(KMsgSummary prefixType) {
            Intrinsics.checkNotNullParameter(prefixType, "prefixType");
            SummaryPrefixType type = SummaryPrefixType.Companion.fromKType(prefixType.getPrefixType());
            return new SummaryPrefix(prefixType.getPrefixText(), type);
        }

        public final SummaryPrefix toPrefix(KMsgSummary $this$toPrefix) {
            if ($this$toPrefix != null) {
                return SummaryPrefix.Companion.from($this$toPrefix);
            }
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(SummaryPrefix other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.prefixType.getPriority(), other.prefixType.getPriority());
    }
}