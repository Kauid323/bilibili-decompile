package im.session.home;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidMainPopupChecker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lim/session/home/AndroidMainPopupCheckerDelegate;", "Lim/session/home/MainPopupChecker;", "context", "Landroid/content/Context;", "delegate", "Lim/session/home/AndroidMainPopupChecker;", "<init>", "(Landroid/content/Context;Lim/session/home/AndroidMainPopupChecker;)V", "checkMainPopup", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidMainPopupCheckerDelegate implements MainPopupChecker {
    public static final int $stable = 8;
    private final Context context;
    private final AndroidMainPopupChecker delegate;

    public AndroidMainPopupCheckerDelegate(Context context, AndroidMainPopupChecker delegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.context = context;
        this.delegate = delegate;
    }

    @Override // im.session.home.MainPopupChecker
    public Object checkMainPopup(Continuation<? super Unit> continuation) {
        Object checkPopupSetting = this.delegate.checkPopupSetting(this.context, continuation);
        return checkPopupSetting == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? checkPopupSetting : Unit.INSTANCE;
    }
}