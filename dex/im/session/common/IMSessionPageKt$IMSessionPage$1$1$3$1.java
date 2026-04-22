package im.session.common;

import com.bilibili.lib.brouter.uri.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: IMSessionPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class IMSessionPageKt$IMSessionPage$1$1$3$1 extends FunctionReferenceImpl implements Function2<Uri, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionPageKt$IMSessionPage$1$1$3$1(Object obj) {
        super(2, obj, IMSessionPageState.class, "route", "route(Lcom/bilibili/lib/brouter/uri/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Uri p0, Continuation<? super Unit> continuation) {
        return ((IMSessionPageState) this.receiver).route(p0, continuation);
    }
}