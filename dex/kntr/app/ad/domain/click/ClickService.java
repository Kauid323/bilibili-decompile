package kntr.app.ad.domain.click;

import android.content.Context;
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.click.IClickService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickService.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J.\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tH&J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H&J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH&J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\u0010H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/click/ClickService;", "Lkntr/app/ad/domain/click/IClickService;", "platformContext", "Landroid/content/Context;", "getPlatformContext", "()Landroid/content/Context;", "openBxProgram", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "openWxProgram", "context", "userName", "path", "extData", "openAdWeb", RoomRecommendViewModel.EMPTY_CURSOR, "isInstalled", "doubleJump", "callUpUrl", "jumpUrl", "downloadApk", "addOpenApkInfoIfNeed", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ClickService extends IClickService {
    void addOpenApkInfoIfNeed();

    boolean doubleJump(Context context, String str, String str2);

    boolean downloadApk(Context context, String str);

    Context getPlatformContext();

    void openAdWeb(Context context, String str, boolean z);

    boolean openBxProgram(String str);

    boolean openWxProgram(Context context, String str, String str2, String str3);

    /* compiled from: ClickService.android.kt */
    /* renamed from: kntr.app.ad.domain.click.ClickService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean openWxProgram$default(ClickService clickService, Context context, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str3 = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                return clickService.openWxProgram(context, str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openWxProgram");
        }
    }

    /* compiled from: ClickService.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Map<String, Object> getGlobalReportParams(ClickService $this) {
            return IClickService.CC.$default$getGlobalReportParams($this);
        }

        @Deprecated
        public static boolean hook(ClickService $this, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return IClickService.CC.$default$hook($this, url);
        }

        @Deprecated
        public static boolean shouldReportFee(ClickService $this, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return IClickService.CC.$default$shouldReportFee($this, event);
        }

        @Deprecated
        public static boolean shouldReportThird(ClickService $this, List<String> list) {
            return IClickService.CC.$default$shouldReportThird($this, list);
        }

        @Deprecated
        public static boolean shouldReportUI(ClickService $this, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return IClickService.CC.$default$shouldReportUI($this, event);
        }
    }
}