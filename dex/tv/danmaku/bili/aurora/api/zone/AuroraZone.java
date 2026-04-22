package tv.danmaku.bili.aurora.api.zone;

import com.bilibili.lib.rpc.aurora.AuroraRoute;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.aurora.internal.config.AuroraConfig;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: AuroraZone.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0012R+\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\t0\"j\b\u0012\u0004\u0012\u00020\t`#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010&R3\u0010-\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Ltv/danmaku/bili/aurora/api/zone/AuroraZone;", "Lcom/bilibili/lib/rpc/aurora/AuroraRoute;", "<init>", "()V", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "event", "", "isRouteBroken", "(Lcom/bilibili/lib/rpc/track/model/NetworkEvent;)Z", "", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "findRoute", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "isEnabled", "()Z", "", "skipHosts", "()Ljava/util/List;", "onAuroraReq", "", "onAuroraResp", "(Lcom/bilibili/lib/rpc/track/model/NetworkEvent;)V", "pathRoute", "zone", "updateRoute", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clearRoute", "(Ljava/lang/String;Ljava/lang/String;)V", "enabled", "Z", "skipHosts$delegate", "Lkotlin/Lazy;", "getSkipHosts", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator$delegate", "getComparator", "()Ljava/util/Comparator;", "comparator", "j$/util/concurrent/ConcurrentHashMap", "Ljava/util/SortedMap;", "routes$delegate", "getRoutes", "()Lj$/util/concurrent/ConcurrentHashMap;", "routes", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuroraZone implements AuroraRoute {
    public static final AuroraZone INSTANCE = new AuroraZone();
    private static final boolean enabled = INSTANCE.isEnabled();
    private static final Lazy skipHosts$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.aurora.api.zone.AuroraZone$$ExternalSyntheticLambda0
        public final Object invoke() {
            List skipHosts_delegate$lambda$0;
            skipHosts_delegate$lambda$0 = AuroraZone.skipHosts_delegate$lambda$0();
            return skipHosts_delegate$lambda$0;
        }
    });
    private static final Lazy comparator$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.aurora.api.zone.AuroraZone$$ExternalSyntheticLambda1
        public final Object invoke() {
            Comparator comparator_delegate$lambda$0;
            comparator_delegate$lambda$0 = AuroraZone.comparator_delegate$lambda$0();
            return comparator_delegate$lambda$0;
        }
    });
    private static final Lazy routes$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.aurora.api.zone.AuroraZone$$ExternalSyntheticLambda2
        public final Object invoke() {
            ConcurrentHashMap routes_delegate$lambda$0;
            routes_delegate$lambda$0 = AuroraZone.routes_delegate$lambda$0();
            return routes_delegate$lambda$0;
        }
    });

    private AuroraZone() {
    }

    private final List<String> getSkipHosts() {
        return (List) skipHosts$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List skipHosts_delegate$lambda$0() {
        return INSTANCE.skipHosts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparator comparator_delegate$lambda$0() {
        final Comparator comparator = new Comparator() { // from class: tv.danmaku.bili.aurora.api.zone.AuroraZone$comparator_delegate$lambda$0$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String it = (String) t2;
                String it2 = (String) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it.length()), Integer.valueOf(it2.length()));
            }
        };
        return new Comparator() { // from class: tv.danmaku.bili.aurora.api.zone.AuroraZone$comparator_delegate$lambda$0$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                String it = (String) t;
                String it2 = (String) t2;
                return ComparisonsKt.compareValues(it, it2);
            }
        };
    }

    private final Comparator<String> getComparator() {
        return (Comparator) comparator$delegate.getValue();
    }

    private final ConcurrentHashMap<String, SortedMap<String, String>> getRoutes() {
        return (ConcurrentHashMap) routes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap routes_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    public String onAuroraReq(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (enabled && !getSkipHosts().contains(host)) {
            if (host.length() == 0) {
                return "";
            }
            if (path.length() == 0) {
                return "";
            }
            try {
                String zone = findRoute(host, path);
                BLog.v("net.aurora.zone", "findRoute host=" + host + ", path=" + path + ", zone=" + zone);
                return zone;
            } catch (Exception e) {
                BLog.e("net.aurora.zone", e);
                return "";
            }
        }
        return "";
    }

    public void onAuroraResp(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (enabled && !getSkipHosts().contains(event.getHost())) {
            try {
                if (isRouteBroken(event)) {
                    int httpCode = event.getHttpCode();
                    String url = event.getUrl();
                    String host = event.getHost();
                    BLog.w("net.aurora.zone", "clearRoute httpCode=" + httpCode + ", url=" + url + ", host=" + host + ", path=" + event.getPath() + ", zone=" + event.getZone());
                    String host2 = event.getHost();
                    Intrinsics.checkNotNullExpressionValue(host2, "getHost(...)");
                    String path = event.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    clearRoute(host2, path);
                } else {
                    String pathRoute = event.getHeader().getAuroraPathRoute();
                    String zone = event.getHeader().getAuroraZone();
                    Intrinsics.checkNotNull(pathRoute);
                    if (!(pathRoute.length() == 0)) {
                        BLog.i("net.aurora.zone", "updateRoute in url=" + event.getUrl() + ", pathRoute=" + pathRoute + ", zone=" + zone);
                        String host3 = event.getHost();
                        Intrinsics.checkNotNullExpressionValue(host3, "getHost(...)");
                        Intrinsics.checkNotNull(zone);
                        updateRoute(host3, pathRoute, zone);
                    }
                }
            } catch (Exception e) {
                BLog.e("net.aurora.zone", e);
            }
        }
    }

    private final boolean isRouteBroken(NetworkEvent event) {
        int httpCode = event.getHttpCode();
        if (400 <= httpCode && httpCode < 600) {
            String zone = event.getZone();
            Intrinsics.checkNotNullExpressionValue(zone, "getZone(...)");
            if (zone.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public final void updateRoute(String host, String pathRoute, String zone) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(pathRoute, "pathRoute");
        Intrinsics.checkNotNullParameter(zone, "zone");
        ConcurrentMap $this$getOrPut$iv = getRoutes();
        Object obj = $this$getOrPut$iv.get(host);
        Object default$iv = obj;
        if (obj == null) {
            SortedMap synchronizedSortedMap = DesugarCollections.synchronizedSortedMap(new TreeMap(INSTANCE.getComparator()));
            Object putIfAbsent = $this$getOrPut$iv.putIfAbsent(host, synchronizedSortedMap);
            default$iv = synchronizedSortedMap;
            if (putIfAbsent != null) {
                default$iv = putIfAbsent;
            }
        }
        SortedMap table = (SortedMap) default$iv;
        Intrinsics.checkNotNull(table);
        table.put(pathRoute, zone);
    }

    private final String findRoute(String host, String path) {
        String str;
        String str2;
        SortedMap table = (SortedMap) getRoutes().get(host);
        if (table == null) {
            return "";
        }
        Set keySet = table.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        Iterator it = keySet.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String it2 = (String) next;
            Intrinsics.checkNotNull(it2);
            if (StringsKt.contains$default(path, it2, false, 2, (Object) null)) {
                str = next;
                break;
            }
        }
        String it3 = str;
        return (it3 == null || (str2 = (String) table.get(it3)) == null) ? "" : str2;
    }

    public final void clearRoute(String host, String path) {
        String str;
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        Object zone = null;
        SortedMap table = (SortedMap) getRoutes().get(host);
        if (table != null) {
            Set keySet = table.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            Iterator it = keySet.iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String it2 = (String) next;
                Intrinsics.checkNotNull(it2);
                if (StringsKt.contains$default(path, it2, false, 2, (Object) null)) {
                    str = next;
                    break;
                }
            }
            String it3 = str;
            r2 = it3 != null ? it3 : null;
            if (r2 != null) {
                zone = table.remove(r2);
            }
        }
        if (r2 != null) {
            BLog.w("net.aurora.zone", "clearRoute evict pathRoute=" + ((Object) r2) + ", zone=" + zone);
        }
    }

    private final boolean isEnabled() {
        Boolean routeEnabled = AuroraConfig.INSTANCE.getRouteEnabled();
        boolean enabled2 = routeEnabled != null ? routeEnabled.booleanValue() : true;
        BLog.i("net.aurora.zone", "enabled=" + enabled2);
        return enabled2;
    }

    private final List<String> skipHosts() {
        String routeSkipHosts = AuroraConfig.INSTANCE.getRouteSkipHosts();
        if (routeSkipHosts == null) {
            routeSkipHosts = AuroraConfig.ROUTE_SKIP_HOSTS;
        }
        List list = StringsKt.split$default(routeSkipHosts, new String[]{","}, false, 0, 6, (Object) null);
        BLog.i("net.aurora.zone", "skip hosts=" + CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return list;
    }
}