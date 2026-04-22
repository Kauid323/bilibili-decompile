package kntr.base.router.target;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Response;
import kotlin.Metadata;
import kotlin.reflect.KType;

/* compiled from: RouterTargetContext.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/base/router/target/RouterTargetContext;", "", "find", "Lkntr/base/router/target/RouterTarget;", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "contextUnsafe", "type", "Lkotlin/reflect/KType;", "getUri", "()Lcom/bilibili/lib/brouter/uri/Uri;", "launch", "Lkntr/base/router/Response;", "getUriParam", "", "key", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface RouterTargetContext {
    Object contextUnsafe(KType kType);

    RouterTarget find(Uri uri);

    Uri getUri();

    String getUriParam(String str);

    Response launch(Uri uri);
}