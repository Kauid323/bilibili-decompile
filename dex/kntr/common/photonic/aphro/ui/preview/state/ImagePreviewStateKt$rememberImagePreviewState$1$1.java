package kntr.common.photonic.aphro.ui.preview.state;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePreviewState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.state.ImagePreviewStateKt$rememberImagePreviewState$1$1", f = "ImagePreviewState.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePreviewStateKt$rememberImagePreviewState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PreviewableAsset> $dataSource;
    final /* synthetic */ int $initialPage;
    final /* synthetic */ ImagePreviewState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImagePreviewStateKt$rememberImagePreviewState$1$1(ImagePreviewState imagePreviewState, List<? extends PreviewableAsset> list, int i, Continuation<? super ImagePreviewStateKt$rememberImagePreviewState$1$1> continuation) {
        super(2, continuation);
        this.$state = imagePreviewState;
        this.$dataSource = list;
        this.$initialPage = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewStateKt$rememberImagePreviewState$1$1(this.$state, this.$dataSource, this.$initialPage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$state.getDataSource().clear();
                SnapshotStateList<ImagePreviewItemState> dataSource = this.$state.getDataSource();
                Iterable $this$map$iv = this.$dataSource;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    PreviewableAsset it = (PreviewableAsset) item$iv$iv;
                    destination$iv$iv.add(new ImagePreviewItemState(it, null, null, 6, null));
                    $this$map$iv = $this$map$iv;
                }
                dataSource.addAll((List) destination$iv$iv);
                this.label = 1;
                if (PagerState.scrollToPage$default(this.$state.getPagerState(), this.$initialPage, 0.0f, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
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