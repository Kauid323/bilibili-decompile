package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: GSharePanel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lkntr/common/share/common/SharePanelHandler;", "", "<init>", "()V", "onChangeChannelList", "Lkotlin/Function1;", "Lkntr/common/share/common/ChannelList;", "getOnChangeChannelList", "()Lkotlin/jvm/functions/Function1;", "setOnChangeChannelList", "(Lkotlin/jvm/functions/Function1;)V", "onProvideContent", "Lkntr/common/share/common/ShareTarget;", "Lkntr/common/share/common/ShareContent;", "getOnProvideContent", "setOnProvideContent", "onClick", "", "getOnClick", "setOnClick", "onShare", "Lkotlin/Function2;", "Lkntr/common/share/common/ShareResult;", "", "getOnShare", "()Lkotlin/jvm/functions/Function2;", "setOnShare", "(Lkotlin/jvm/functions/Function2;)V", "onPanelDismiss", "Lkotlin/Function0;", "getOnPanelDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnPanelDismiss", "(Lkotlin/jvm/functions/Function0;)V", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePanelHandler {
    public static final int $stable = 8;
    private Function1<? super ChannelList, ChannelList> onChangeChannelList;
    private Function1<? super ShareTarget, Boolean> onClick;
    private Function0<Unit> onPanelDismiss;
    private Function1<? super ShareTarget, ShareContent> onProvideContent;
    private Function2<? super ShareTarget, ? super ShareResult, Unit> onShare;

    public final Function1<ChannelList, ChannelList> getOnChangeChannelList() {
        return this.onChangeChannelList;
    }

    public final void setOnChangeChannelList(Function1<? super ChannelList, ChannelList> function1) {
        this.onChangeChannelList = function1;
    }

    public final Function1<ShareTarget, ShareContent> getOnProvideContent() {
        return this.onProvideContent;
    }

    public final void setOnProvideContent(Function1<? super ShareTarget, ShareContent> function1) {
        this.onProvideContent = function1;
    }

    public final Function1<ShareTarget, Boolean> getOnClick() {
        return this.onClick;
    }

    public final void setOnClick(Function1<? super ShareTarget, Boolean> function1) {
        this.onClick = function1;
    }

    public final Function2<ShareTarget, ShareResult, Unit> getOnShare() {
        return this.onShare;
    }

    public final void setOnShare(Function2<? super ShareTarget, ? super ShareResult, Unit> function2) {
        this.onShare = function2;
    }

    public final Function0<Unit> getOnPanelDismiss() {
        return this.onPanelDismiss;
    }

    public final void setOnPanelDismiss(Function0<Unit> function0) {
        this.onPanelDismiss = function0;
    }
}