package curtains;

import android.view.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Listeners.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\b"}, d2 = {"Lcurtains/KeyEventInterceptor;", "", "intercept", "Lcurtains/DispatchState;", "keyEvent", "Landroid/view/KeyEvent;", "dispatch", "Lkotlin/Function1;", "curtains_release"}, k = 1, mv = {1, 4, 1})
public interface KeyEventInterceptor {
    DispatchState intercept(KeyEvent keyEvent, Function1<? super KeyEvent, ? extends DispatchState> function1);
}