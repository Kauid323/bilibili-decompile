package kntr.common.photonic.aphro.ui.preview.save;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaveImageManager.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.save.SaveImageManager", f = "SaveImageManager.android.kt", i = {0, 0}, l = {69}, m = "saveImage-0E7RQCE", n = {"asset", "platformContext"}, s = {"L$0", "L$1"}, v = 1)
public final class SaveImageManager$saveImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaveImageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveImageManager$saveImage$1(SaveImageManager saveImageManager, Continuation<? super SaveImageManager$saveImage$1> continuation) {
        super(continuation);
        this.this$0 = saveImageManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m2317saveImage0E7RQCE = this.this$0.m2317saveImage0E7RQCE(null, null, (Continuation) this);
        return m2317saveImage0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m2317saveImage0E7RQCE : Result.m2635boximpl(m2317saveImage0E7RQCE);
    }
}