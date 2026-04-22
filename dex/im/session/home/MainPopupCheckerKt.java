package im.session.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: MainPopupChecker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"defaultPopupChecker", "Lim/session/home/MainPopupChecker;", "getDefaultPopupChecker", "()Lim/session/home/MainPopupChecker;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MainPopupCheckerKt {
    private static final MainPopupChecker defaultPopupChecker = new MainPopupChecker() { // from class: im.session.home.MainPopupCheckerKt$defaultPopupChecker$1
        @Override // im.session.home.MainPopupChecker
        public final Object checkMainPopup(Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    };

    public static final MainPopupChecker getDefaultPopupChecker() {
        return defaultPopupChecker;
    }
}