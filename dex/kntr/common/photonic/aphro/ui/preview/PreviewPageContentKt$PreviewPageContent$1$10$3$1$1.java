package kntr.common.photonic.aphro.ui.preview;

import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPageContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$PreviewPageContent$1$10$3$1$1", f = "PreviewPageContent.kt", i = {0, 0, 0}, l = {263}, m = "invokeSuspend", n = {"asset", "it", "$i$a$-let-PreviewPageContentKt$PreviewPageContent$1$10$3$1$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class PreviewPageContentKt$PreviewPageContent$1$10$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AphroViewModel $aphroViewModel;
    final /* synthetic */ AphroAssetsState.AphroContent $assetsState;
    final /* synthetic */ ImagePreviewState $imagePreviewState;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewPageContentKt$PreviewPageContent$1$10$3$1$1(AphroAssetsState.AphroContent aphroContent, ImagePreviewState imagePreviewState, AphroViewModel aphroViewModel, Continuation<? super PreviewPageContentKt$PreviewPageContent$1$10$3$1$1> continuation) {
        super(2, continuation);
        this.$assetsState = aphroContent;
        this.$imagePreviewState = imagePreviewState;
        this.$aphroViewModel = aphroViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewPageContentKt$PreviewPageContent$1$10$3$1$1(this.$assetsState, this.$imagePreviewState, this.$aphroViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ImagePreviewState imagePreviewState = this.$imagePreviewState;
                Iterator<T> it = this.$assetsState.getAssetList().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        Asset it2 = (Asset) obj;
                        if (Intrinsics.areEqual(it2.getIdentifier(), ((ImagePreviewItemState) imagePreviewState.getDataSource().get(imagePreviewState.getCurrentIndex())).getAsset().getIdentifier())) {
                        }
                    } else {
                        obj = null;
                    }
                }
                Asset asset = (Asset) obj;
                if (asset != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(asset);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(asset);
                    this.I$0 = 0;
                    this.label = 1;
                    if (this.$aphroViewModel.dispatch(new AphroAction.SelectAsset(asset), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i = this.I$0;
                Asset asset2 = (Asset) this.L$1;
                Asset asset3 = (Asset) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}