package kntr.common.photonic.aphro.ui.preview.save;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaveImageManager.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.save.SaveImageManager", f = "SaveImageManager.android.kt", i = {0, 1, 2, 3}, l = {89, 90, 91, 95}, m = "showPermissionDeniedAlert", n = {"context", "context", "context", "context"}, s = {"L$0", "L$0", "L$0", "L$0"}, v = 1)
public final class SaveImageManager$showPermissionDeniedAlert$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaveImageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveImageManager$showPermissionDeniedAlert$1(SaveImageManager saveImageManager, Continuation<? super SaveImageManager$showPermissionDeniedAlert$1> continuation) {
        super(continuation);
        this.this$0 = saveImageManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object showPermissionDeniedAlert;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showPermissionDeniedAlert = this.this$0.showPermissionDeniedAlert(null, (Continuation) this);
        return showPermissionDeniedAlert;
    }
}