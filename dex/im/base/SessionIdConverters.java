package im.base;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.xiaomi.mipush.sdk.Constants;
import im.base.model.SessionId;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: SessionIdConverter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B(\b\u0007\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006R-\u0010\n\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\r\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lim/base/SessionIdConverters;", "", "converterMap", "", "", "Lim/base/SessionIdConverter;", "Lim/base/model/SessionId;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Ljava/util/Map;)V", "kMap", "Lkotlin/reflect/KClass;", "Lcom/bapis/bilibili/app/im/v1/KSessionId$IId;", "map", "convertToSessionId", "kSessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "convertToKSessionId", "id", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionIdConverters {
    private final Map<KClass<? extends KSessionId.IId>, SessionIdConverter<SessionId>> kMap;
    private final Map<KClass<? extends SessionId>, SessionIdConverter<SessionId>> map;

    @Inject
    public SessionIdConverters(Map<Integer, SessionIdConverter<SessionId>> map) {
        Intrinsics.checkNotNullParameter(map, "converterMap");
        Iterable $this$associateBy$iv = map.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            SessionIdConverter it = (SessionIdConverter) element$iv$iv;
            destination$iv$iv.put(it.getKType(), element$iv$iv);
        }
        this.kMap = destination$iv$iv;
        Iterable $this$associateBy$iv2 = map.values();
        int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv2, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv2);
        for (Object element$iv$iv2 : $this$associateBy$iv2) {
            SessionIdConverter it2 = (SessionIdConverter) element$iv$iv2;
            destination$iv$iv2.put(it2.getType(), element$iv$iv2);
        }
        this.map = destination$iv$iv2;
        IMLog.Companion.i("KSessionIdConverter", "Registered KSessionId converter: " + CollectionsKt.joinToString$default(this.kMap.entrySet(), "\n", "[", "]", 0, (CharSequence) null, new Function1() { // from class: im.base.SessionIdConverters$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0;
                _init_$lambda$0 = SessionIdConverters._init_$lambda$0((Map.Entry) obj);
                return _init_$lambda$0;
            }
        }, 24, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String simpleName = ((KClass) it.getKey()).getSimpleName();
        return simpleName + " -> " + Reflection.getOrCreateKotlinClass(it.getValue().getClass()).getQualifiedName() + Constants.ACCEPT_TIME_SEPARATOR_SP;
    }

    public final SessionId convertToSessionId(KSessionId kSessionId) {
        SessionId convertToSessionId;
        Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
        KSessionId.IId id = kSessionId.getId();
        if (id == null) {
            return SessionId.Unknown.INSTANCE;
        }
        SessionIdConverter converter = this.kMap.get(Reflection.getOrCreateKotlinClass(id.getClass()));
        return (converter == null || (convertToSessionId = converter.convertToSessionId(kSessionId)) == null) ? SessionId.Unknown.INSTANCE : convertToSessionId;
    }

    public final KSessionId convertToKSessionId(SessionId id) {
        KSessionId convertToKSessionId;
        Intrinsics.checkNotNullParameter(id, "id");
        SessionIdConverter converter = this.map.get(Reflection.getOrCreateKotlinClass(id.getClass()));
        return (converter == null || (convertToKSessionId = converter.convertToKSessionId(id)) == null) ? new KSessionId((KSessionId.IId) null, 1, (DefaultConstructorMarker) null) : convertToKSessionId;
    }
}