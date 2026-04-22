package kntr.app.ad.domain.click;

import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.click.internal.ActionFeeEvent;
import kntr.app.ad.domain.click.internal.ActionUiEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clicker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/DefaultCardClickListener;", "Lkntr/app/ad/domain/click/ICardClickListener;", "arg", "Lkntr/app/ad/domain/click/ClickArg;", "<init>", "(Lkntr/app/ad/domain/click/ClickArg;)V", "onStart", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/IClickContext;", "onAnswered", "onLost", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DefaultCardClickListener implements ICardClickListener {
    private final ClickArg arg;

    public DefaultCardClickListener(ClickArg arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        this.arg = arg;
    }

    @Override // kntr.app.ad.domain.click.ICardClickListener
    public void onStart(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.reportMMA(this.arg.getClickUrls());
        IClickContext.CC.reportFee$default(context, ActionFeeEvent.CLICK, null, 2, null);
    }

    @Override // kntr.app.ad.domain.click.ICardClickListener
    public void onAnswered(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // kntr.app.ad.domain.click.ICardClickListener
    public void onLost(IClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IClickContext.CC.reportUi$default(context, ActionUiEvent.JUMP_URL_ERROR, null, 2, null);
    }
}