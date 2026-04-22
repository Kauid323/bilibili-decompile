package kntr.app.deepsearch.history.ui;

import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.history.DSHistoryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HistoryPageKt$HistoryPage$dispatcher$1$1 extends FunctionReferenceImpl implements Function1<DSHistoryAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HistoryPageKt$HistoryPage$dispatcher$1$1(Object obj) {
        super(1, obj, DSHistoryViewModel.class, "dispatch", "dispatch(Lkntr/app/deepsearch/base/model/history/DSHistoryAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DSHistoryAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DSHistoryAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DSHistoryViewModel) this.receiver).dispatch(p0);
    }
}