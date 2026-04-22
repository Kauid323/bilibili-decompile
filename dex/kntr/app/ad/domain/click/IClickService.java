package kntr.app.ad.domain.click;

import java.util.List;
import java.util.Map;
import kntr.app.ad.protocol.IMotion;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IClickService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0017J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0017J\u001a\u0010\u001c\u001a\u00020\u00192\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH'J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000fH\u0017R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006\"À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/click/IClickService;", RoomRecommendViewModel.EMPTY_CURSOR, "from", "Lkntr/app/ad/domain/click/ClickFrom;", "getFrom$annotations", "()V", "getFrom", "()Lkntr/app/ad/domain/click/ClickFrom;", "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "getReportable$annotations", "getReportable", "()Lkntr/app/ad/protocol/report/IReportable;", "globalReportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getGlobalReportParams$annotations", "getGlobalReportParams", "()Ljava/util/Map;", "motion", "Lkntr/app/ad/protocol/IMotion;", "getMotion$annotations", "getMotion", "()Lkntr/app/ad/protocol/IMotion;", "shouldReportUI", RoomRecommendViewModel.EMPTY_CURSOR, "event", "shouldReportFee", "shouldReportThird", "urls", RoomRecommendViewModel.EMPTY_CURSOR, "processUrl", "url", "hook", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IClickService {
    ClickFrom getFrom();

    Map<String, Object> getGlobalReportParams();

    IMotion getMotion();

    IReportable getReportable();

    boolean hook(String str);

    String processUrl(String str);

    boolean shouldReportFee(String str);

    boolean shouldReportThird(List<String> list);

    boolean shouldReportUI(String str);

    /* compiled from: IClickService.kt */
    /* renamed from: kntr.app.ad.domain.click.IClickService$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static Map $default$getGlobalReportParams(IClickService _this) {
            return null;
        }

        public static boolean $default$shouldReportUI(IClickService _this, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        public static boolean $default$shouldReportFee(IClickService _this, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        public static boolean $default$shouldReportThird(IClickService _this, List urls) {
            return true;
        }

        public static boolean $default$hook(IClickService _this, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return false;
        }
    }

    /* compiled from: IClickService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFrom$annotations() {
        }

        public static /* synthetic */ void getGlobalReportParams$annotations() {
        }

        public static /* synthetic */ void getMotion$annotations() {
        }

        public static /* synthetic */ void getReportable$annotations() {
        }

        @Deprecated
        public static Map<String, Object> getGlobalReportParams(IClickService $this) {
            return CC.$default$getGlobalReportParams($this);
        }

        @Deprecated
        public static boolean shouldReportUI(IClickService $this, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return CC.$default$shouldReportUI($this, event);
        }

        @Deprecated
        public static boolean shouldReportFee(IClickService $this, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return CC.$default$shouldReportFee($this, event);
        }

        @Deprecated
        public static boolean shouldReportThird(IClickService $this, List<String> list) {
            return CC.$default$shouldReportThird($this, list);
        }

        @Deprecated
        public static boolean hook(IClickService $this, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return CC.$default$hook($this, url);
        }
    }
}