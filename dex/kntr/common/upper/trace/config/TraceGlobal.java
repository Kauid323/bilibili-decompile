package kntr.common.upper.trace.config;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.TraceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: TraceGlobal.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u000bR+\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u000bR+\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u000bR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010&\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020%8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lkntr/common/upper/trace/config/TraceGlobal;", "", "<init>", "()V", "appTraceID", "", "getAppTraceID", "()Ljava/lang/String;", AppKey.UID, "getUid", "setUid", "(Ljava/lang/String;)V", "extendParams", "", "getExtendParams", "()Ljava/util/Map;", "<set-?>", AppKey.VERSION, "getVersion", "setVersion", "version$delegate", "Lkntr/common/upper/trace/config/TraceGlobal$MapDelegate;", "versionCode", "getVersionCode", "setVersionCode", "versionCode$delegate", "biliAppId", "getBiliAppId", "setBiliAppId", "biliAppId$delegate", "", "enableTimeOffset", "getEnableTimeOffset", "()Z", "setEnableTimeOffset", "(Z)V", "enableTimeOffset$delegate", "", "timeOffset", "getTimeOffset", "()J", "setTimeOffset", "(J)V", "timeOffset$delegate", "MapDelegate", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceGlobal {
    private static String uid;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TraceGlobal.class, AppKey.VERSION, "getVersion()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TraceGlobal.class, "versionCode", "getVersionCode()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TraceGlobal.class, "biliAppId", "getBiliAppId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TraceGlobal.class, "enableTimeOffset", "getEnableTimeOffset()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TraceGlobal.class, "timeOffset", "getTimeOffset()J", 0))};
    public static final TraceGlobal INSTANCE = new TraceGlobal();
    private static final String appTraceID = TraceUtils.INSTANCE.newTraceID();
    private static final Map<String, String> extendParams = new LinkedHashMap();
    private static final MapDelegate version$delegate = new MapDelegate(AppKey.VERSION, "");
    private static final MapDelegate versionCode$delegate = new MapDelegate(AppKey.VERSION_CODE, "");
    private static final MapDelegate biliAppId$delegate = new MapDelegate(AppKey.BILI_APP_ID, "");
    private static final MapDelegate enableTimeOffset$delegate = new MapDelegate(EventKey.EVENT_ENABLE_TIME_OFFSET, false);
    private static final MapDelegate timeOffset$delegate = new MapDelegate(EventKey.EVENT_TIME_OFFSET, 0L);

    private TraceGlobal() {
    }

    public final String getAppTraceID() {
        return appTraceID;
    }

    public final String getUid() {
        return uid;
    }

    public final void setUid(String str) {
        uid = str;
    }

    public final Map<String, String> getExtendParams() {
        return extendParams;
    }

    public final String getVersion() {
        return (String) version$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        version$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final String getVersionCode() {
        return (String) versionCode$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setVersionCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        versionCode$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final String getBiliAppId() {
        return (String) biliAppId$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setBiliAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        biliAppId$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final boolean getEnableTimeOffset() {
        return ((Boolean) enableTimeOffset$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final void setEnableTimeOffset(boolean z) {
        enableTimeOffset$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z));
    }

    public final long getTimeOffset() {
        return ((Number) timeOffset$delegate.getValue(this, $$delegatedProperties[4])).longValue();
    }

    public final void setTimeOffset(long j) {
        timeOffset$delegate.setValue(this, $$delegatedProperties[4], Long.valueOf(j));
    }

    /* compiled from: TraceGlobal.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002¢\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/upper/trace/config/TraceGlobal$MapDelegate;", "T", "", "key", "", "default", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getDefault", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    private static final class MapDelegate<T> {

        /* renamed from: default  reason: not valid java name */
        private final T f61default;
        private final String key;

        public MapDelegate(String key, T t) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.f61default = t;
        }

        public final String getKey() {
            return this.key;
        }

        public final T getDefault() {
            return this.f61default;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Long] */
        /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Integer] */
        public final T getValue(Object thisRef, KProperty<?> kProperty) {
            T t;
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            T t2 = this.f61default;
            if (t2 instanceof Integer) {
                String str = TraceGlobal.INSTANCE.getExtendParams().get(this.key);
                T valueOf = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
                t = valueOf != null ? valueOf : null;
                return t == null ? this.f61default : t;
            } else if (t2 instanceof Long) {
                String str2 = TraceGlobal.INSTANCE.getExtendParams().get(this.key);
                T valueOf2 = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
                t = valueOf2 != null ? valueOf2 : null;
                return t == null ? this.f61default : t;
            } else if (t2 instanceof Boolean) {
                String str3 = TraceGlobal.INSTANCE.getExtendParams().get(this.key);
                T valueOf3 = str3 != null ? Boolean.valueOf(Boolean.parseBoolean(str3)) : null;
                t = valueOf3 != null ? valueOf3 : null;
                return t == null ? this.f61default : t;
            } else {
                String str4 = TraceGlobal.INSTANCE.getExtendParams().get(this.key);
                t = str4 != null ? str4 : null;
                return t == null ? this.f61default : t;
            }
        }

        public final void setValue(Object thisRef, KProperty<?> kProperty, T t) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            TraceGlobal.INSTANCE.getExtendParams().put(this.key, String.valueOf(t));
        }
    }
}