package kntr.common.photonic.aphro.ui.preview.save;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaveImageManager.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.save.SaveImageManager", f = "SaveImageManager.android.kt", i = {0, 0, 0, 1, 1, 1}, l = {77, 81}, m = "checkPermission", n = {"state", "context", "authorization", "state", "context", "authorization"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class SaveImageManager$checkPermission$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaveImageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveImageManager$checkPermission$1(SaveImageManager saveImageManager, Continuation<? super SaveImageManager$checkPermission$1> continuation) {
        super(continuation);
        this.this$0 = saveImageManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkPermission(null, null, (Continuation) this);
    }
}