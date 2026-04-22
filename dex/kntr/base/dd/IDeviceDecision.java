package kntr.base.dd;

import java.util.Locale;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;

/* compiled from: IDeviceDecision.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0002\u0013\u0014JC\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH'¢\u0006\u0002\u0010\u000bJI\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\r\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH'¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rH'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\rH'¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/base/dd/IDeviceDecision;", "", "get", "T", "key", "", "serializer", "Lkotlinx/serialization/KSerializer;", "defaultValue", "context", "Lkntr/base/dd/IDeviceDecision$Context;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;Ljava/lang/Object;Lkntr/base/dd/IDeviceDecision$Context;)Ljava/lang/Object;", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/String;Lkotlinx/serialization/KSerializer;Ljava/lang/Object;Lkntr/base/dd/IDeviceDecision$Context;)Lkotlinx/coroutines/flow/Flow;", AppKey.VERSION, "Lkntr/base/dd/IDeviceDecision$Version;", "versions", "keys", "Context", "Version", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDeviceDecision {
    <T> Flow<T> asFlow(String str, KSerializer<T> kSerializer, T t, Context context);

    <T> T get(String str, KSerializer<T> kSerializer, T t, Context context);

    Flow<String> keys();

    Version version();

    Flow<Version> versions();

    /* compiled from: IDeviceDecision.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/IDeviceDecision$Context;", "", "disableCache", "", "trackParams", "", "", "result", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Context {
        boolean disableCache();

        Map<String, String> trackParams(String str);

        /* compiled from: IDeviceDecision.kt */
        /* renamed from: kntr.base.dd.IDeviceDecision$Context$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static boolean $default$disableCache(Context _this) {
                return false;
            }
        }

        /* compiled from: IDeviceDecision.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static boolean disableCache(Context $this) {
                return CC.$default$disableCache($this);
            }
        }
    }

    /* compiled from: IDeviceDecision.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/base/dd/IDeviceDecision$Version;", "", "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", AppKey.VERSION, "", "<init>", "(Lkntr/base/dd/IDeviceDecision$Version$Env;Ljava/lang/String;)V", "getEnv", "()Lkntr/base/dd/IDeviceDecision$Version$Env;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Env", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Version {
        private final Env env;
        private final String version;

        public static /* synthetic */ Version copy$default(Version version, Env env, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                env = version.env;
            }
            if ((i & 2) != 0) {
                str = version.version;
            }
            return version.copy(env, str);
        }

        public final Env component1() {
            return this.env;
        }

        public final String component2() {
            return this.version;
        }

        public final Version copy(Env env, String str) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(str, AppKey.VERSION);
            return new Version(env, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Version) {
                Version version = (Version) obj;
                return this.env == version.env && Intrinsics.areEqual(this.version, version.version);
            }
            return false;
        }

        public int hashCode() {
            return (this.env.hashCode() * 31) + this.version.hashCode();
        }

        public String toString() {
            Env env = this.env;
            return "Version(env=" + env + ", version=" + this.version + ")";
        }

        public Version(Env env, String version) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(version, AppKey.VERSION);
            this.env = env;
            this.version = version;
        }

        public final Env getEnv() {
            return this.env;
        }

        public final String getVersion() {
            return this.version;
        }

        /* compiled from: IDeviceDecision.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lkntr/base/dd/IDeviceDecision$Version$Env;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Prod", "Test", "Companion", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public enum Env {
            Prod("prod"),
            Test("test");
            
            private final String value;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
            public static final Companion Companion = new Companion(null);

            public static EnumEntries<Env> getEntries() {
                return $ENTRIES;
            }

            Env(String value) {
                this.value = value;
            }

            public final String getValue() {
                return this.value;
            }

            /* compiled from: IDeviceDecision.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/dd/IDeviceDecision$Version$Env$Companion;", "", "<init>", "()V", "fromString", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "value", "", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final Env fromString(String value) {
                    String v;
                    Env env = null;
                    if (value != null) {
                        v = value.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(v, "toLowerCase(...)");
                    } else {
                        v = null;
                    }
                    Env[] values = Env.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Env it = values[i];
                        if (Intrinsics.areEqual(it.getValue(), v)) {
                            env = it;
                            break;
                        }
                        i++;
                    }
                    return env == null ? Env.Prod : env;
                }
            }
        }
    }

    /* compiled from: IDeviceDecision.kt */
    /* renamed from: kntr.base.dd.IDeviceDecision$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object get$default(IDeviceDecision iDeviceDecision, String str, KSerializer kSerializer, Object obj, Context context, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                if ((i & 8) != 0) {
                    context = null;
                }
                return iDeviceDecision.get(str, kSerializer, obj, context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }

        public static /* synthetic */ Flow asFlow$default(IDeviceDecision iDeviceDecision, String str, KSerializer kSerializer, Object obj, Context context, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                if ((i & 8) != 0) {
                    context = null;
                }
                return iDeviceDecision.asFlow(str, kSerializer, obj, context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asFlow");
        }
    }

    /* compiled from: IDeviceDecision.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}