package tv.danmaku.bili.appwidget.guide.utils;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: ReportHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a$\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u001a,\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a4\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007\u001a$\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u001a(\u0010\u000f\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u001a\"\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003¨\u0006\u0011"}, d2 = {"reportGuidePopShow", "", FavoritesConstsKt.SPMID, "", "type", "reportGuidePopClick", "choice", "", "reportGuideBannerShow", "contentId", "reportGuideBannerClick", "reportAutoAddGuideRequest", LoginReporterV2.Show.SIGNUP_KEY_CODE, "isShow", "reportGuideWindowShow", "reportGuideWindowClick", "reportAutoAddSuccess", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReportHelperKt {
    public static /* synthetic */ void reportGuidePopShow$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        reportGuidePopShow(str, str2);
    }

    public static final void reportGuidePopShow(String spmid, String type) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportGuidePopShow_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuidePopShow_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        $this$reportGuidePopShow_u24lambda_u240.put("type", type);
        Map map = MapsKt.build($this$reportGuidePopShow_u24lambda_u240);
        Neurons.reportExposure$default(false, "app.add-to-desk.guide-pop.0.show", map, (List) null, 8, (Object) null);
    }

    public static final void reportGuidePopClick(String spmid, int choice) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Map $this$reportGuidePopClick_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuidePopClick_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        $this$reportGuidePopClick_u24lambda_u240.put("type", "function");
        $this$reportGuidePopClick_u24lambda_u240.put("choice", String.valueOf(choice));
        Map map = MapsKt.build($this$reportGuidePopClick_u24lambda_u240);
        Neurons.reportClick(false, "app.add-to-desk.guide-pop.0.click", map);
    }

    public static /* synthetic */ void reportGuideBannerShow$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        reportGuideBannerShow(str, str2, str3);
    }

    public static final void reportGuideBannerShow(String spmid, String type, String contentId) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportGuideBannerShow_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuideBannerShow_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        if (contentId != null) {
            String str = (String) $this$reportGuideBannerShow_u24lambda_u240.put("content_id", contentId);
        }
        $this$reportGuideBannerShow_u24lambda_u240.put("type", type);
        Map map = MapsKt.build($this$reportGuideBannerShow_u24lambda_u240);
        Neurons.reportExposure$default(false, "app.add-to-desk.guide-banner.0.show", map, (List) null, 8, (Object) null);
    }

    public static /* synthetic */ void reportGuideBannerClick$default(String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        reportGuideBannerClick(str, str2, str3, i);
    }

    public static final void reportGuideBannerClick(String spmid, String type, String contentId, int choice) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportGuideBannerClick_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuideBannerClick_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        $this$reportGuideBannerClick_u24lambda_u240.put("type", type);
        $this$reportGuideBannerClick_u24lambda_u240.put("choice", String.valueOf(choice));
        if (contentId != null) {
            $this$reportGuideBannerClick_u24lambda_u240.put("content_id", contentId);
        }
        Map map = MapsKt.build($this$reportGuideBannerClick_u24lambda_u240);
        Neurons.reportClick(false, "app.add-to-desk.guide-banner.0.click", map);
    }

    public static /* synthetic */ void reportAutoAddGuideRequest$default(String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        reportAutoAddGuideRequest(str, str2, str3, i, i2);
    }

    public static final void reportAutoAddGuideRequest(String spmid, String contentId, String type, int code, int isShow) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportAutoAddGuideRequest_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportAutoAddGuideRequest_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        if (contentId != null) {
            String str = (String) $this$reportAutoAddGuideRequest_u24lambda_u240.put("content_id", contentId);
        }
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("type", type);
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("reason", String.valueOf(code));
        $this$reportAutoAddGuideRequest_u24lambda_u240.put("is_show", String.valueOf(isShow));
        Map map = MapsKt.build($this$reportAutoAddGuideRequest_u24lambda_u240);
        Neurons.reportClick(false, "app.add-to-desk.pop.client.click", map);
    }

    public static /* synthetic */ void reportGuideWindowShow$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        reportGuideWindowShow(str, str2, str3);
    }

    public static final void reportGuideWindowShow(String spmid, String type, String contentId) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportGuideWindowShow_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuideWindowShow_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        $this$reportGuideWindowShow_u24lambda_u240.put("type", type);
        if (contentId != null) {
            $this$reportGuideWindowShow_u24lambda_u240.put("content_id", contentId);
        }
        Map map = MapsKt.build($this$reportGuideWindowShow_u24lambda_u240);
        Neurons.reportExposure$default(false, "app.add-to-desk.sec-pop.0.show", map, (List) null, 8, (Object) null);
    }

    public static /* synthetic */ void reportGuideWindowClick$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        reportGuideWindowClick(str, str2, str3);
    }

    public static final void reportGuideWindowClick(String spmid, String type, String contentId) {
        Map $this$reportGuideWindowClick_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportGuideWindowClick_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid == null ? "" : spmid);
        $this$reportGuideWindowClick_u24lambda_u240.put("type", type != null ? type : "");
        if (contentId != null) {
            String str = (String) $this$reportGuideWindowClick_u24lambda_u240.put("content_id", contentId);
        }
        $this$reportGuideWindowClick_u24lambda_u240.put("choice", "1");
        Map map = MapsKt.build($this$reportGuideWindowClick_u24lambda_u240);
        Neurons.reportClick(false, "app.add-to-desk.sec-pop.0.click", map);
    }

    public static /* synthetic */ void reportAutoAddSuccess$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        reportAutoAddSuccess(str, str2, str3);
    }

    public static final void reportAutoAddSuccess(String spmid, String type, String contentId) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(type, "type");
        Map $this$reportAutoAddSuccess_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$reportAutoAddSuccess_u24lambda_u240.put(FavoritesConstsKt.SPMID, spmid);
        $this$reportAutoAddSuccess_u24lambda_u240.put("type", type);
        if (contentId != null) {
            $this$reportAutoAddSuccess_u24lambda_u240.put("content_id", contentId);
        }
        Map map = MapsKt.build($this$reportAutoAddSuccess_u24lambda_u240);
        Neurons.reportClick(false, "app.add-to-desk.pop.add-success.click", map);
    }
}