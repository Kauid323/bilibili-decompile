package kntr.common.ouro.common.ui.toolPanel;

import android.app.Activity;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncher_androidKt;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlbumPanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$AlbumPanel$4$6$1$1", f = "AlbumPanel.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AlbumPanelKt$AlbumPanel$4$6$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AphroState.AphroContent $album;
    final /* synthetic */ int $index;
    final /* synthetic */ String $key;
    final /* synthetic */ AphroSelectOption $option;
    final /* synthetic */ Activity $platformContext;
    final /* synthetic */ Router $router;
    final /* synthetic */ List<PreviewableAsset> $totalDataSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AlbumPanelKt$AlbumPanel$4$6$1$1(Router router, List<? extends PreviewableAsset> list, int i, AphroState.AphroContent aphroContent, AphroSelectOption aphroSelectOption, String str, Activity activity, Continuation<? super AlbumPanelKt$AlbumPanel$4$6$1$1> continuation) {
        super(2, continuation);
        this.$router = router;
        this.$totalDataSource = list;
        this.$index = i;
        this.$album = aphroContent;
        this.$option = aphroSelectOption;
        this.$key = str;
        this.$platformContext = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumPanelKt$AlbumPanel$4$6$1$1(this.$router, this.$totalDataSource, this.$index, this.$album, this.$option, this.$key, this.$platformContext, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (ImagePreviewLauncher_androidKt.launchImagePreview$default(this.$router, this.$totalDataSource, this.$index, new ImagePreviewType.Gallery(this.$album.getCurrentSelected(), this.$album.getUseOriginImage(), this.$option, this.$key), this.$platformContext, null, (Continuation) this, 32, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}