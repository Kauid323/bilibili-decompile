package tv.danmaku.bili.report.biz.api.consume.sample;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: ProtocolSample.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/sample/ProtocolSample;", "", "protocol", "", "sample", "", "<init>", "(Ljava/lang/String;I)V", "getProtocol", "()Ljava/lang/String;", "setProtocol", "(Ljava/lang/String;)V", "getSample", "()I", "setSample", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ProtocolSample {
    public static final Companion Companion = new Companion(null);
    private String protocol;
    private int sample;

    public ProtocolSample() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ ProtocolSample copy$default(ProtocolSample protocolSample, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = protocolSample.protocol;
        }
        if ((i2 & 2) != 0) {
            i = protocolSample.sample;
        }
        return protocolSample.copy(str, i);
    }

    public final String component1() {
        return this.protocol;
    }

    public final int component2() {
        return this.sample;
    }

    public final ProtocolSample copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "protocol");
        return new ProtocolSample(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProtocolSample) {
            ProtocolSample protocolSample = (ProtocolSample) obj;
            return Intrinsics.areEqual(this.protocol, protocolSample.protocol) && this.sample == protocolSample.sample;
        }
        return false;
    }

    public int hashCode() {
        return (this.protocol.hashCode() * 31) + this.sample;
    }

    public String toString() {
        String str = this.protocol;
        return "ProtocolSample(protocol=" + str + ", sample=" + this.sample + ")";
    }

    public ProtocolSample(String protocol, int sample) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
        this.sample = sample;
    }

    public /* synthetic */ ProtocolSample(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getSample() {
        return this.sample;
    }

    public final void setProtocol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.protocol = str;
    }

    public final void setSample(int i) {
        this.sample = i;
    }

    /* compiled from: ProtocolSample.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/biz/api/consume/sample/ProtocolSample$Companion;", "", "<init>", "()V", "parse", "", "Ltv/danmaku/bili/report/biz/api/consume/sample/ProtocolSample;", "config", "", "parseConfig", "find", "protocol", "rules", "matches", "", "rule", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<ProtocolSample> parse(String config) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (StringsKt.isBlank(config)) {
                return null;
            }
            return parseConfig(config);
        }

        private final List<ProtocolSample> parseConfig(String config) {
            try {
                Iterable list = JSON.parseArray(config, ProtocolSample.class);
                if (list == null) {
                    return null;
                }
                Iterable $this$filterNot$iv = list;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    ProtocolSample it = (ProtocolSample) element$iv$iv;
                    if (!StringsKt.isBlank(it.getProtocol())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            } catch (Exception e) {
                return null;
            }
        }

        public final ProtocolSample find(String protocol, List<ProtocolSample> list) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(list, "rules");
            List<ProtocolSample> $this$firstOrNull$iv = list;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    ProtocolSample it2 = (ProtocolSample) element$iv;
                    if (ProtocolSample.Companion.matches(protocol, it2)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            return (ProtocolSample) element$iv;
        }

        private final boolean matches(String protocol, ProtocolSample rule) {
            return Intrinsics.areEqual(rule.getProtocol(), protocol);
        }
    }
}