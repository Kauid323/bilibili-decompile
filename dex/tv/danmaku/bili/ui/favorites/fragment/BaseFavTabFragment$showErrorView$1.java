package tv.danmaku.bili.ui.favorites.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import tv.danmaku.bili.BR;

/* compiled from: BaseFavTabFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final /* synthetic */ class BaseFavTabFragment$showErrorView$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseFavTabFragment$showErrorView$1(Object obj) {
        super(0, obj, BaseFavTabFragment.class, "onCleanInvalidClick", "onCleanInvalidClick()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1624invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m1624invoke() {
        ((BaseFavTabFragment) this.receiver).onCleanInvalidClick();
    }
}