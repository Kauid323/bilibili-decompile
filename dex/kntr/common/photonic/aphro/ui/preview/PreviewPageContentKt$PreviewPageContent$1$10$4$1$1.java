package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.foundation.pager.PagerState;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPageContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.PreviewPageContentKt$PreviewPageContent$1$10$4$1$1", f = "PreviewPageContent.kt", i = {0}, l = {304}, m = "invokeSuspend", n = {"index"}, s = {"I$0"}, v = 1)
public final class PreviewPageContentKt$PreviewPageContent$1$10$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Asset $asset;
    final /* synthetic */ ImagePreviewState $imagePreviewState;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewPageContentKt$PreviewPageContent$1$10$4$1$1(ImagePreviewState imagePreviewState, Asset asset, Continuation<? super PreviewPageContentKt$PreviewPageContent$1$10$4$1$1> continuation) {
        super(2, continuation);
        this.$imagePreviewState = imagePreviewState;
        this.$asset = asset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewPageContentKt$PreviewPageContent$1$10$4$1$1(this.$imagePreviewState, this.$asset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int index;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List $this$indexOfFirst$iv = this.$imagePreviewState.getDataSource();
                Asset asset = this.$asset;
                int index$iv = 0;
                Iterator it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object item$iv = it.next();
                        ImagePreviewItemState it2 = (ImagePreviewItemState) item$iv;
                        if (!Intrinsics.areEqual(it2.getAsset().getIdentifier(), asset.getIdentifier())) {
                            index$iv++;
                        }
                    } else {
                        index$iv = -1;
                    }
                }
                int index2 = index$iv;
                if (index2 != -1) {
                    this.I$0 = index2;
                    this.label = 1;
                    if (PagerState.scrollToPage$default(this.$imagePreviewState.getPagerState(), index2, 0.0f, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index = index2;
                    break;
                }
                break;
            case 1:
                index = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}