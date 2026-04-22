package kntr.common.share.common.ui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.SharePanelHandler;
import kntr.common.share.common.SharePanelStyle;
import kntr.common.share.common.ShareParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePanelScope.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u001b\b\u0002\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R-\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkntr/common/share/common/ui/SharePanelScope;", "", "ctx", "Lkntr/common/share/common/ShareLocalContext;", "params", "Lkntr/common/share/common/ShareParams;", "style", "Lkntr/common/share/common/SharePanelStyle;", "handler", "Lkotlin/Function1;", "Lkntr/common/share/common/SharePanelHandler;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkntr/common/share/common/ShareLocalContext;Lkntr/common/share/common/ShareParams;Lkntr/common/share/common/SharePanelStyle;Lkotlin/jvm/functions/Function1;)V", "getCtx", "()Lkntr/common/share/common/ShareLocalContext;", "getParams", "()Lkntr/common/share/common/ShareParams;", "setParams", "(Lkntr/common/share/common/ShareParams;)V", "getStyle", "()Lkntr/common/share/common/SharePanelStyle;", "setStyle", "(Lkntr/common/share/common/SharePanelStyle;)V", "getHandler", "()Lkotlin/jvm/functions/Function1;", "setHandler", "(Lkotlin/jvm/functions/Function1;)V", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePanelScope {
    public static final int $stable = 8;
    private final ShareLocalContext ctx;
    private Function1<? super SharePanelHandler, Unit> handler;
    private ShareParams params;
    private SharePanelStyle style;

    public SharePanelScope(ShareLocalContext ctx, ShareParams params, SharePanelStyle style, Function1<? super SharePanelHandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(style, "style");
        this.ctx = ctx;
        this.params = params;
        this.style = style;
        this.handler = function1;
    }

    public /* synthetic */ SharePanelScope(ShareLocalContext shareLocalContext, ShareParams shareParams, SharePanelStyle sharePanelStyle, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareLocalContext, shareParams, (i & 4) != 0 ? new SharePanelStyle(null, false, 3, null) : sharePanelStyle, (i & 8) != 0 ? null : function1);
    }

    public final ShareLocalContext getCtx() {
        return this.ctx;
    }

    public final ShareParams getParams() {
        return this.params;
    }

    public final void setParams(ShareParams shareParams) {
        Intrinsics.checkNotNullParameter(shareParams, "<set-?>");
        this.params = shareParams;
    }

    public final SharePanelStyle getStyle() {
        return this.style;
    }

    public final void setStyle(SharePanelStyle sharePanelStyle) {
        Intrinsics.checkNotNullParameter(sharePanelStyle, "<set-?>");
        this.style = sharePanelStyle;
    }

    public final Function1<SharePanelHandler, Unit> getHandler() {
        return this.handler;
    }

    public final void setHandler(Function1<? super SharePanelHandler, Unit> function1) {
        this.handler = function1;
    }
}