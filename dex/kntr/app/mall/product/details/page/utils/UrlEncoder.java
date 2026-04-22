package kntr.app.mall.product.details.page.utils;

import java.net.URLEncoder;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlEncoder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkntr/app/mall/product/details/page/utils/UrlEncoder;", "", "<init>", "()V", "encode", "", "str", "encode$product_details_page_debug", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UrlEncoder {
    public static final int $stable = 0;
    public static final UrlEncoder INSTANCE = new UrlEncoder();

    private UrlEncoder() {
    }

    public final String encode$product_details_page_debug(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String encode = URLEncoder.encode(str, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
        return encode;
    }
}