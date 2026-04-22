package kntr.common.ouro.common.ui.toolPanel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewSelectResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AlbumPanel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class AlbumPanelKt$AlbumPanel$3$1$1$1<T> implements FlowCollector {
    final /* synthetic */ AphroViewModel $aphroViewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlbumPanelKt$AlbumPanel$3$1$1$1(AphroViewModel aphroViewModel) {
        this.$aphroViewModel = aphroViewModel;
    }

    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((ImagePreviewSelectResult) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(ImagePreviewSelectResult it, Continuation<? super Unit> continuation) {
        AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1 albumPanelKt$AlbumPanel$3$1$1$1$emit$1;
        if (continuation instanceof AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1) {
            albumPanelKt$AlbumPanel$3$1$1$1$emit$1 = (AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1) continuation;
            if ((albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label -= Integer.MIN_VALUE;
                Object $result = albumPanelKt$AlbumPanel$3$1$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        albumPanelKt$AlbumPanel$3$1$1$1$emit$1.L$0 = it;
                        albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label = 1;
                        if (this.$aphroViewModel.dispatch(new AphroAction.SetSelectedAssets(it.getSelectedAssets()), albumPanelKt$AlbumPanel$3$1$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        albumPanelKt$AlbumPanel$3$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label = 2;
                        if (this.$aphroViewModel.dispatch(new AphroAction.CheckUseOriginImage(it.getUseOriginImage()), albumPanelKt$AlbumPanel$3$1$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        it = (ImagePreviewSelectResult) albumPanelKt$AlbumPanel$3$1$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        albumPanelKt$AlbumPanel$3$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label = 2;
                        if (this.$aphroViewModel.dispatch(new AphroAction.CheckUseOriginImage(it.getUseOriginImage()), albumPanelKt$AlbumPanel$3$1$1$1$emit$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ImagePreviewSelectResult imagePreviewSelectResult = (ImagePreviewSelectResult) albumPanelKt$AlbumPanel$3$1$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        albumPanelKt$AlbumPanel$3$1$1$1$emit$1 = new AlbumPanelKt$AlbumPanel$3$1$1$1$emit$1(this, continuation);
        Object $result2 = albumPanelKt$AlbumPanel$3$1$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (albumPanelKt$AlbumPanel$3$1$1$1$emit$1.label) {
        }
    }
}