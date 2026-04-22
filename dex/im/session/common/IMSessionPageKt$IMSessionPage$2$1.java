package im.session.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: IMSessionPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class IMSessionPageKt$IMSessionPage$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionPageKt$IMSessionPage$2$1(Object obj) {
        super(0, obj, IMSessionPageState.class, "dismissBottomSheet", "dismissBottomSheet()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m3283invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m3283invoke() {
        ((IMSessionPageState) this.receiver).dismissBottomSheet();
    }
}