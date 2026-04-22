package kntr.app.ad.domain.click.internal.action.handlers;

import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.results.WxOpenFailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenResult;
import kntr.app.ad.domain.click.internal.interop.WxProgram_androidKt;
import kntr.app.ad.domain.click.internal.util.Utils_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WxProgramHandler.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0000\u001aP\u0012\u0004\u0012\u00020\u0002\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0004`\b0\u0001H\u0000\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"wxProgramHandler", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkotlin/Function3;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$WxProgram;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "openWxProgram", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", "context", "wxInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "(Lkntr/app/ad/domain/click/internal/ClickContext;Lkntr/app/ad/common/model/AdWxProgramInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WxProgramHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 wxProgramHandler$lambda$0(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new WxProgramHandlerKt$wxProgramHandler$1$1(context, null);
    }

    public static final Function1<ClickContext, Function3<ActionParam.WxProgram, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>> wxProgramHandler() {
        return new Function1() { // from class: kntr.app.ad.domain.click.internal.action.handlers.WxProgramHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Function3 wxProgramHandler$lambda$0;
                wxProgramHandler$lambda$0 = WxProgramHandlerKt.wxProgramHandler$lambda$0((ClickContext) obj);
                return wxProgramHandler$lambda$0;
            }
        };
    }

    public static final Object openWxProgram(ClickContext context, AdWxProgramInfo wxInfo, Continuation<? super WxOpenResult> continuation) {
        context.getStage().info("即将打开微小...");
        String orgId = wxInfo.getOrgId();
        boolean z = false;
        if (!(orgId == null || StringsKt.isBlank(orgId))) {
            String name = wxInfo.getName();
            if (!(name == null || StringsKt.isBlank(name))) {
                String path = wxInfo.getPath();
                if (path == null || StringsKt.isBlank(path)) {
                    z = true;
                }
                if (!z) {
                    if (!Utils_androidKt.isWXAppInstalled(context)) {
                        return new WxOpenResult.Failure(WxOpenFailureReason.NotInstalled.INSTANCE);
                    }
                    String orgId2 = wxInfo.getOrgId();
                    Intrinsics.checkNotNull(orgId2);
                    String name2 = wxInfo.getName();
                    Intrinsics.checkNotNull(name2);
                    String path2 = wxInfo.getPath();
                    Intrinsics.checkNotNull(path2);
                    return WxProgram_androidKt.openWxProgram(context, orgId2, name2, path2, continuation);
                }
            }
        }
        return new WxOpenResult.Failure(new WxOpenFailureReason.InputError("orgId, name, or path is null or empty"));
    }
}