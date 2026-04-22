package kntr.base.net.comm.flowcontrol.internal.backoff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

/* compiled from: PathRule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006)"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;", "", "host", "", "path", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHost$annotations", "()V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getPath$annotations", "getPath", "setPath", "invalid", "", "matches", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$flow_control_debug", "Companion", "$serializer", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class PathRule {
    public static final Companion Companion = new Companion(null);
    private String host;
    private String path;

    public PathRule() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PathRule copy$default(PathRule pathRule, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pathRule.host;
        }
        if ((i & 2) != 0) {
            str2 = pathRule.path;
        }
        return pathRule.copy(str, str2);
    }

    @SerialName("host")
    public static /* synthetic */ void getHost$annotations() {
    }

    @SerialName("path")
    public static /* synthetic */ void getPath$annotations() {
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.path;
    }

    public final PathRule copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(str2, "path");
        return new PathRule(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PathRule) {
            PathRule pathRule = (PathRule) obj;
            return Intrinsics.areEqual(this.host, pathRule.host) && Intrinsics.areEqual(this.path, pathRule.path);
        }
        return false;
    }

    public int hashCode() {
        return (this.host.hashCode() * 31) + this.path.hashCode();
    }

    public String toString() {
        String str = this.host;
        return "PathRule(host=" + str + ", path=" + this.path + ")";
    }

    public /* synthetic */ PathRule(int seen0, String host, String path, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.host = "";
        } else {
            this.host = host;
        }
        if ((seen0 & 2) == 0) {
            this.path = "";
        } else {
            this.path = path;
        }
    }

    public PathRule(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        this.host = host;
        this.path = path;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$flow_control_debug(PathRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.host, "")) {
            output.encodeStringElement(serialDesc, 0, self.host);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.path, "")) {
            output.encodeStringElement(serialDesc, 1, self.path);
        }
    }

    public /* synthetic */ PathRule(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    /* compiled from: PathRule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¨\u0006\u0010"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule$Companion;", "", "<init>", "()V", "parse", "", "Lkntr/base/net/comm/flowcontrol/internal/backoff/PathRule;", RedirectImpKt.REDIRECT_KV_CONFIG, "", "matches", "", "host", "path", "rules", "serializer", "Lkotlinx/serialization/KSerializer;", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PathRule> serializer() {
            return PathRule$$serializer.INSTANCE;
        }

        public final List<PathRule> parse(String config) {
            Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
            try {
                Json this_$iv = Json.Default;
                this_$iv.getSerializersModule();
                Iterable list = (List) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(PathRule.Companion.serializer())), config);
                if (list == null) {
                    return null;
                }
                Iterable $this$filterNot$iv = list;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    PathRule it = (PathRule) element$iv$iv;
                    if (!it.invalid()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            } catch (Exception e) {
                return null;
            }
        }

        public final boolean matches(String host, String path, List<PathRule> list) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(list, "rules");
            List<PathRule> $this$any$iv = list;
            if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                PathRule it = (PathRule) element$iv;
                if (it.matches(host, path)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean invalid() {
        String str = this.host;
        return str == null || StringsKt.isBlank(str);
    }

    public final boolean matches(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        if (Intrinsics.areEqual(this.host, host)) {
            String str = this.path;
            return str == null || str.length() == 0 ? true : Intrinsics.areEqual(this.path, path);
        }
        return false;
    }
}