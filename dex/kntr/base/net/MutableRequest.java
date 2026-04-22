package kntr.base.net;

import java.util.HashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH&J\u0018\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH&J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH&J-\u0010\u001f\u001a\u00020\u001c\"\b\b\u0000\u0010 *\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042\u0006\u0010\"\u001a\u0002H H\u0016¢\u0006\u0002\u0010#J'\u0010\u001f\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u0004H\u0016¢\u0006\u0002\u0010$R\u001e\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0017\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006%"}, d2 = {"Lkntr/base/net/MutableRequest;", "Lkntr/base/net/Request;", "tags", "", "Lkotlin/reflect/KClass;", "", "<init>", "(Ljava/util/Map;)V", "protocol", "Lkntr/base/net/UrlProtocol;", "getProtocol", "()Lkntr/base/net/UrlProtocol;", "setProtocol", "(Lkntr/base/net/UrlProtocol;)V", "host", "", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "url", "getUrl", "setUrl", "header", "name", "", "value", "query", "tag", "T", "type", "instance", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)V", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class MutableRequest extends Request {
    private final Map<KClass<?>, Object> tags;

    public MutableRequest() {
        this(null, 1, null);
    }

    @Override // kntr.base.net.Request
    public abstract String getHost();

    @Override // kntr.base.net.Request
    public abstract String getPath();

    @Override // kntr.base.net.Request
    public abstract UrlProtocol getProtocol();

    @Override // kntr.base.net.Request
    public abstract String getUrl();

    @Override // kntr.base.net.Request
    public abstract String header(String str);

    public abstract void header(String str, String str2);

    public abstract void query(String str, String str2);

    public abstract void setHost(String str);

    public abstract void setPath(String str);

    public abstract void setProtocol(UrlProtocol urlProtocol);

    public abstract void setUrl(String str);

    public MutableRequest(Map<KClass<?>, Object> map) {
        Intrinsics.checkNotNullParameter(map, "tags");
        this.tags = map;
    }

    public /* synthetic */ MutableRequest(HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HashMap() : hashMap);
    }

    @Override // kntr.base.net.Request
    public <T> void tag(KClass<T> kClass, T t) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(t, "instance");
        this.tags.put(kClass, t);
    }

    @Override // kntr.base.net.Request
    public <T> T tag(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        T t = (T) this.tags.get(kClass);
        if (t == null) {
            return null;
        }
        return t;
    }
}