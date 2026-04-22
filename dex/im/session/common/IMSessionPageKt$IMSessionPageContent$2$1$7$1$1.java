package im.session.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class IMSessionPageKt$IMSessionPageContent$2$1$7$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionPageKt$IMSessionPageContent$2$1$7$1$1(Object obj) {
        super(0, obj, IMSessionPageState.class, "refresh", "refresh()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m3286invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m3286invoke() {
        ((IMSessionPageState) this.receiver).refresh();
    }
}