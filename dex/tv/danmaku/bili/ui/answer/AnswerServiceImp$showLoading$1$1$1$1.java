package tv.danmaku.bili.ui.answer;

import android.content.DialogInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import tv.danmaku.bili.BR;

/* compiled from: AnswerServiceImp.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class AnswerServiceImp$showLoading$1$1$1$1 implements DialogInterface.OnDismissListener {
    final /* synthetic */ CoroutineScope $$this$launch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnswerServiceImp$showLoading$1$1$1$1(CoroutineScope coroutineScope) {
        this.$$this$launch = coroutineScope;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface it) {
        CoroutineScopeKt.cancel$default(this.$$this$launch, (CancellationException) null, 1, (Object) null);
    }
}