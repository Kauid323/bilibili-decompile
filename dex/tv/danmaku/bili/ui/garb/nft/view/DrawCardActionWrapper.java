package tv.danmaku.bili.ui.garb.nft.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;

/* compiled from: DLCDrawCardViewManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0083\u0001\u0012&\b\u0002\u0010\u0002\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011R8\u0010\u0002\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DrawCardActionWrapper;", "", "switchToResult", "Lkotlin/Function3;", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "Ltv/danmaku/bili/ui/garb/api/DLCItem;", "", "", "drawAgain", "Lkotlin/Function0;", "goBack", "purchase", "Lkotlin/Function1;", "", "goGraphic", "", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getSwitchToResult", "()Lkotlin/jvm/functions/Function3;", "setSwitchToResult", "(Lkotlin/jvm/functions/Function3;)V", "getDrawAgain", "()Lkotlin/jvm/functions/Function0;", "setDrawAgain", "(Lkotlin/jvm/functions/Function0;)V", "getGoBack", "setGoBack", "getPurchase", "()Lkotlin/jvm/functions/Function1;", "setPurchase", "(Lkotlin/jvm/functions/Function1;)V", "getGoGraphic", "setGoGraphic", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DrawCardActionWrapper {
    public static final int $stable = 8;
    private Function0<Unit> drawAgain;
    private Function0<Unit> goBack;
    private Function1<? super String, Unit> goGraphic;
    private Function1<? super Integer, Unit> purchase;
    private Function3<? super DLCCardShareModel, ? super DLCItem, ? super Boolean, Unit> switchToResult;

    public DrawCardActionWrapper() {
        this(null, null, null, null, null, 31, null);
    }

    public DrawCardActionWrapper(Function3<? super DLCCardShareModel, ? super DLCItem, ? super Boolean, Unit> function3, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Integer, Unit> function1, Function1<? super String, Unit> function12) {
        this.switchToResult = function3;
        this.drawAgain = function0;
        this.goBack = function02;
        this.purchase = function1;
        this.goGraphic = function12;
    }

    public /* synthetic */ DrawCardActionWrapper(Function3 function3, Function0 function0, Function0 function02, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function3, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : function02, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function12);
    }

    public final Function3<DLCCardShareModel, DLCItem, Boolean, Unit> getSwitchToResult() {
        return this.switchToResult;
    }

    public final void setSwitchToResult(Function3<? super DLCCardShareModel, ? super DLCItem, ? super Boolean, Unit> function3) {
        this.switchToResult = function3;
    }

    public final Function0<Unit> getDrawAgain() {
        return this.drawAgain;
    }

    public final void setDrawAgain(Function0<Unit> function0) {
        this.drawAgain = function0;
    }

    public final Function0<Unit> getGoBack() {
        return this.goBack;
    }

    public final void setGoBack(Function0<Unit> function0) {
        this.goBack = function0;
    }

    public final Function1<Integer, Unit> getPurchase() {
        return this.purchase;
    }

    public final void setPurchase(Function1<? super Integer, Unit> function1) {
        this.purchase = function1;
    }

    public final Function1<String, Unit> getGoGraphic() {
        return this.goGraphic;
    }

    public final void setGoGraphic(Function1<? super String, Unit> function1) {
        this.goGraphic = function1;
    }
}