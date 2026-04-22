package kntr.app.ad.domain.click;

import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.click.internal.ActionFeeEvent;
import kntr.app.ad.domain.click.internal.ActionUiEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clicker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/domain/click/DefaultButtonClickListener;", "Lkntr/app/ad/domain/click/IButtonClickListener;", "buttonArg", "Lkntr/app/ad/domain/click/ClickArg;", "cardArg", "<init>", "(Lkntr/app/ad/domain/click/ClickArg;Lkntr/app/ad/domain/click/ClickArg;)V", "onButtonStart", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/IClickContext;", "onButtonAnswered", "onButtonLost", "onCardStart", "onCardAnswered", "onCardLost", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DefaultButtonClickListener implements IButtonClickListener {
    private final ClickArg buttonArg;
    private final ClickArg cardArg;

    public DefaultButtonClickListener(ClickArg buttonArg, ClickArg cardArg) {
        Intrinsics.checkNotNullParameter(cardArg, "cardArg");
        this.buttonArg = buttonArg;
        this.cardArg = cardArg;
    }

    @Override // kntr.app.ad.domain.click.IButtonClickListener
    public void onButtonStart(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IClickContext.CC.reportFee$default(context, ActionFeeEvent.BUTTON_CLICK, null, 2, null);
        IClickContext.CC.reportUi$default(context, ActionUiEvent.BUTTON_CLICK, null, 2, null);
    }

    @Override // kntr.app.ad.domain.click.IButtonClickListener
    public void onButtonAnswered(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ClickArg clickArg = this.buttonArg;
        context.reportMMA(clickArg != null ? clickArg.getClickUrls() : null);
    }

    @Override // kntr.app.ad.domain.click.IButtonClickListener
    public void onButtonLost(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // kntr.app.ad.domain.click.IButtonClickListener
    public void onCardStart(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // kntr.app.ad.domain.click.IButtonClickListener
    public void onCardAnswered(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.reportMMA(this.cardArg.getClickUrls());
    }

    @Override // kntr.app.ad.domain.click.IButtonClickListener
    public void onCardLost(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IClickContext.CC.reportUi$default(context, ActionUiEvent.JUMP_URL_ERROR, null, 2, null);
    }
}