package kntr.common.ouro.common.ui.toolPanel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewSelectResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlbumPanel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$AlbumPanel$3$1$1$1", f = "AlbumPanel.kt", i = {0, 1}, l = {113, ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT}, m = "emit", n = {"it", "it"}, s = {"L$0", "L$0"}, v = 1)
public final class AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumPanelKt$AlbumPanel$3$1$1$1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1(AlbumPanelKt$AlbumPanel$3$1$1$1<? super T> albumPanelKt$AlbumPanel$3$1$1$1, Continuation<? super AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = albumPanelKt$AlbumPanel$3$1$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ImagePreviewSelectResult) null, (Continuation) this);
    }
}