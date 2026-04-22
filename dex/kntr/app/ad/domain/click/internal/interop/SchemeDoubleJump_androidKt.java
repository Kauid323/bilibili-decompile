package kntr.app.ad.domain.click.internal.interop;

import java.util.List;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.ClickReportKt;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.util.DeepLinkUtil;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: SchemeDoubleJump.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\bH\u0080@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"schemeDoubleJump", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SchemeDoubleJump_androidKt {
    public static final Object schemeDoubleJump(ClickContext context, String callUpUrl, String jumpUrl, List<String> list, Continuation<? super Boolean> continuation) {
        if (!UtilsKt.isInOpenWhiteList(callUpUrl, list)) {
            ClickReportKt.reportCallUp(context, new CallUpResult.Failure(CallUpFailureReason.AuthFailed.INSTANCE), callUpUrl);
            return Boxing.boxBoolean(false);
        } else if (!DeepLinkUtil.INSTANCE.isApkInstalled(context.getService().getPlatformContext(), callUpUrl)) {
            ClickReportKt.reportCallUp(context, new CallUpResult.Failure(CallUpFailureReason.NotInstalled.INSTANCE), callUpUrl);
            return Boxing.boxBoolean(false);
        } else {
            return Boxing.boxBoolean(context.getService().doubleJump(context.getService().getPlatformContext(), callUpUrl, jumpUrl));
        }
    }
}