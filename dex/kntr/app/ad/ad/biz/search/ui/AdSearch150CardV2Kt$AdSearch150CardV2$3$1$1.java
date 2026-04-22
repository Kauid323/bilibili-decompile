package kntr.app.ad.ad.biz.search.ui;

import kntr.app.ad.ad.biz.search.vm.AdSearch150CardModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: AdSearch150CardV2.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AdSearch150CardV2Kt$AdSearch150CardV2$3$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSearch150CardV2Kt$AdSearch150CardV2$3$1$1(Object obj) {
        super(1, obj, AdSearch150CardModel.class, "onChooseButtonClick", "onChooseButtonClick(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int p0) {
        ((AdSearch150CardModel) this.receiver).onChooseButtonClick(p0);
    }
}