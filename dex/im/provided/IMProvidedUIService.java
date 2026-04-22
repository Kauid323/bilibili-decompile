package im.provided;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import faceverify.q;
import kotlin.Metadata;

/* compiled from: IMProvidedUIService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\r\u0010\u0007\u001a\u00020\bH'¢\u0006\u0002\u0010\tR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lim/provided/IMProvidedUIService;", "", "needShow", "Landroidx/compose/runtime/State;", "", "getNeedShow", "()Landroidx/compose/runtime/State;", q.KEY_RES_9_CONTENT, "", "(Landroidx/compose/runtime/Composer;I)V", "provided-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMProvidedUIService {
    void content(Composer composer, int i2);

    /* renamed from: getNeedShow */
    State<Boolean> mo3218getNeedShow();
}