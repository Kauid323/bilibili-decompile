package kntr.app.mall.product.details.page.vm;

import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.ProductShopDetailsShopItem;
import kntr.app.mall.product.details.page.utils.UrlEncoder;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PageActionHandler.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001Bi\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u0017\u0010\u001f\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b J\u001f\u0010!\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\b$J7\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0006H\u0000¢\u0006\u0002\b/J?\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00062\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0000¢\u0006\u0002\b7R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lkntr/app/mall/product/details/page/vm/PageActionHandler;", "", "routerProvider", "Lkotlin/Function0;", "Lkntr/base/router/Router;", "itemsId", "", "trackId", "msource", "from", "isAd", "fromSpmid", "isHalfScreen", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "value", "shopId", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "commonParams", "", "handleSearch", "", "searchText", "handleSearch$product_details_page_debug", "handleShopItemClick", "item", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "handleShopItemClick$product_details_page_debug", "handleGoToCommentList", "handleGoToCommentList$product_details_page_debug", "handleGoToCommentDetail", "comment", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "handleGoToCommentDetail$product_details_page_debug", "handleVideoDetail", "itemId", "", "courseId", "lessonId", "sectionId", "handleVideoDetail$product_details_page_debug", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "pushTo", "url", "pushTo$product_details_page_debug", "trackEvent", "eventId", "extra", "", "isClick", "", "force", "trackEvent$product_details_page_debug", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PageActionHandler {
    public static final int $stable = 8;
    private Map<String, String> commonParams;
    private final String from;
    private final String fromSpmid;
    private final String isAd;
    private final String isHalfScreen;
    private final String itemsId;
    private final String msource;
    private final Function0<Router> routerProvider;
    private String shopId;
    private final String trackId;

    public PageActionHandler(Function0<Router> function0, String itemsId, String trackId, String msource, String from, String isAd, String fromSpmid, String isHalfScreen) {
        Intrinsics.checkNotNullParameter(function0, "routerProvider");
        this.routerProvider = function0;
        this.itemsId = itemsId;
        this.trackId = trackId;
        this.msource = msource;
        this.from = from;
        this.isAd = isAd;
        this.fromSpmid = fromSpmid;
        this.isHalfScreen = isHalfScreen;
        Pair[] pairArr = new Pair[8];
        String str = this.trackId;
        pairArr[0] = TuplesKt.to("track_id", str == null ? "" : str);
        String str2 = this.msource;
        pairArr[1] = TuplesKt.to("msource", str2 == null ? "" : str2);
        String str3 = this.from;
        pairArr[2] = TuplesKt.to("from", str3 == null ? "" : str3);
        String str4 = this.itemsId;
        pairArr[3] = TuplesKt.to("itemsId", str4 == null ? "" : str4);
        String str5 = this.isAd;
        pairArr[4] = TuplesKt.to("is_ad", str5 == null ? "" : str5);
        pairArr[5] = TuplesKt.to("is_na", "1");
        String str6 = this.fromSpmid;
        pairArr[6] = TuplesKt.to("from_spmid", str6 == null ? "" : str6);
        String str7 = this.isHalfScreen;
        pairArr[7] = TuplesKt.to("is_half_screen", str7 != null ? str7 : "");
        this.commonParams = MapsKt.mutableMapOf(pairArr);
    }

    public /* synthetic */ PageActionHandler(Function0 function0, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String value) {
        String str = value;
        if (str == null || str.length() == 0) {
            return;
        }
        this.commonParams.put("shopId", value);
        this.commonParams.put("merchant_id", value);
        this.shopId = value;
    }

    public final void handleSearch$product_details_page_debug(String searchText) {
        String searchUrl = "bilibili://mall/web?url=" + UrlEncoder.INSTANCE.encode$product_details_page_debug("https://mall.bilibili.com/neul-next/index.html?page=flow_searchResult&goFrom=na&noTitleBar=1&from=detail&keyword=param");
        String targetUrl = "bilibili://mall/search?from=detail&placeholder=" + UrlEncoder.INSTANCE.encode$product_details_page_debug(searchText == null ? "" : searchText) + "&searchUrl=" + UrlEncoder.INSTANCE.encode$product_details_page_debug(searchUrl);
        pushTo$product_details_page_debug(targetUrl);
    }

    public final void handleShopItemClick$product_details_page_debug(ProductShopDetailsShopItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String jumpUrl = item.getJumpUrl();
        String str = jumpUrl;
        if (!(str == null || str.length() == 0)) {
            pushTo$product_details_page_debug(jumpUrl);
        }
    }

    public final void handleGoToCommentList$product_details_page_debug(String itemsId) {
        String str = itemsId;
        if (str == null || str.length() == 0) {
            return;
        }
        String jumpUrl = "https://mall.bilibili.com/neul/index.html?page=mall_commentlist&noTitleBar=1&goFrom=na&from=detail_merchant&itemsId=" + itemsId;
        pushTo$product_details_page_debug(jumpUrl);
    }

    public final void handleGoToCommentDetail$product_details_page_debug(String itemsId, CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        String str = itemsId;
        if (str == null || str.length() == 0) {
            return;
        }
        String jumpUrl = "https://mall.bilibili.com/neul/index.html?page=mall_commentlist&noTitleBar=1&goFrom=na&from=detail_merchant&itemsId=" + itemsId + "&ugcId=" + comment.getUgcId();
        pushTo$product_details_page_debug(jumpUrl);
    }

    public final void handleVideoDetail$product_details_page_debug(Long itemId, Long courseId, Long lessonId, Long sectionId) {
        String url = "bilibili://mall/coursedetail?itemId=" + itemId + "&courseId=" + courseId + "&lessonId=" + lessonId;
        if ((sectionId != null ? sectionId.longValue() : 0L) > 0) {
            url = url + "&locationSectionId=" + sectionId;
        }
        pushTo$product_details_page_debug(url);
    }

    public final void pushTo$product_details_page_debug(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = UrisKt.toUri(url);
        Iterable $this$associateWith$iv = uri.getQueryParameterNames();
        Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
        Map destination$iv$iv = result$iv;
        for (Object element$iv$iv : $this$associateWith$iv) {
            String it = (String) element$iv$iv;
            destination$iv$iv.put(element$iv$iv, uri.getQueryParameter(it));
        }
        Map originalParams = MapsKt.toMutableMap(destination$iv$iv);
        CharSequence charSequence = (CharSequence) originalParams.get("track_id");
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            String str = this.trackId;
            if (!(str == null || str.length() == 0)) {
                originalParams.put("track_id", this.trackId);
            }
        }
        CharSequence charSequence2 = (CharSequence) originalParams.get("msource");
        if (charSequence2 == null || charSequence2.length() == 0) {
            String str2 = this.msource;
            if (!(str2 == null || str2.length() == 0)) {
                originalParams.put("msource", this.msource);
            }
        }
        CharSequence charSequence3 = (CharSequence) originalParams.get("from");
        if (charSequence3 == null || charSequence3.length() == 0) {
            String str3 = this.from;
            if (!((str3 == null || str3.length() == 0) ? true : true)) {
                originalParams.put("from", this.from);
            }
        }
        Builder newUri = uri.buildUpon().clearQuery();
        for (Map.Entry entry : originalParams.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            newUri.appendQueryParameter(key, value);
        }
        Router router = (Router) this.routerProvider.invoke();
        router.launch(newUri.build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackEvent$product_details_page_debug$default(PageActionHandler pageActionHandler, String str, Map map, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        pageActionHandler.trackEvent$product_details_page_debug(str, map, z, z2);
    }

    public final void trackEvent$product_details_page_debug(String eventId, Map<String, String> map, boolean isClick, boolean force) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Map merged = MapsKt.plus(this.commonParams, map);
        if (isClick) {
            KNeuron.INSTANCE.reportClick(force, eventId, merged);
        } else {
            KNeuron.INSTANCE.reportExposure(force, eventId, merged);
        }
    }
}