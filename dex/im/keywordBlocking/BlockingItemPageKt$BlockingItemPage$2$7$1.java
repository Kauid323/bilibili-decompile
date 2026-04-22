package im.keywordBlocking;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BlockingItemPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class BlockingItemPageKt$BlockingItemPage$2$7$1 extends FunctionReferenceImpl implements Function1<KBAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockingItemPageKt$BlockingItemPage$2$7$1(Object obj) {
        super(1, obj, KBViewModel.class, "dispatchAction", "dispatchAction(Lim/keywordBlocking/KBAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((KBAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(KBAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((KBViewModel) this.receiver).dispatchAction(p0);
    }
}