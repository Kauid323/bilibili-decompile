package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\tH&J'\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H&¢\u0006\u0002\u0010\u0016J-\u0010\u0012\u001a\u00020\u0017\"\b\b\u0000\u0010\u0013*\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0018\u001a\u0002H\u0013H&¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u0001H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lkntr/base/net/Request;", "", "<init>", "()V", "protocol", "Lkntr/base/net/UrlProtocol;", "getProtocol", "()Lkntr/base/net/UrlProtocol;", "host", "", "getHost", "()Ljava/lang/String;", "path", "getPath", "url", "getUrl", "header", "name", "tag", "T", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "instance", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)V", "copy", "Lkntr/base/net/MutableRequest;", "source", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class Request {
    public abstract MutableRequest copy();

    public abstract String getHost();

    public abstract String getPath();

    public abstract UrlProtocol getProtocol();

    public abstract String getUrl();

    public abstract String header(String str);

    public abstract Object source();

    public abstract <T> T tag(KClass<T> kClass);

    public abstract <T> void tag(KClass<T> kClass, T t);
}