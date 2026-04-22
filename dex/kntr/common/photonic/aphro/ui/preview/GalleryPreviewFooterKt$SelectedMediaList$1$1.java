package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GalleryPreviewFooter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$1$1", f = "GalleryPreviewFooter.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class GalleryPreviewFooterKt$SelectedMediaList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $currentSelectedIndex$delegate;
    final /* synthetic */ ImagePreviewState $imagePreviewState;
    final /* synthetic */ AphroState.AphroContent $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalleryPreviewFooterKt$SelectedMediaList$1$1(ImagePreviewState imagePreviewState, AphroState.AphroContent aphroContent, MutableState<Integer> mutableState, Continuation<? super GalleryPreviewFooterKt$SelectedMediaList$1$1> continuation) {
        super(2, continuation);
        this.$imagePreviewState = imagePreviewState;
        this.$state = aphroContent;
        this.$currentSelectedIndex$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GalleryPreviewFooterKt$SelectedMediaList$1$1(this.$imagePreviewState, this.$state, this.$currentSelectedIndex$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ImagePreviewState imagePreviewState = this.$imagePreviewState;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        ImagePreviewItemState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = GalleryPreviewFooterKt$SelectedMediaList$1$1.invokeSuspend$lambda$0(ImagePreviewState.this);
                        return invokeSuspend$lambda$0;
                    }
                });
                final AphroState.AphroContent aphroContent = this.$state;
                final MutableState<Integer> mutableState = this.$currentSelectedIndex$delegate;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$1$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ImagePreviewItemState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(ImagePreviewItemState item, Continuation<? super Unit> continuation) {
                        List $this$indexOfFirst$iv = AphroState.AphroContent.this.getCurrentSelected();
                        int index$iv = 0;
                        Iterator<Asset> it = $this$indexOfFirst$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object item$iv = it.next();
                                Asset it2 = (Asset) item$iv;
                                if (Intrinsics.areEqual(it2.getIdentifier(), item.getAsset().getIdentifier())) {
                                    break;
                                }
                                index$iv++;
                            } else {
                                index$iv = -1;
                                break;
                            }
                        }
                        int index = index$iv;
                        GalleryPreviewFooterKt.SelectedMediaList$lambda$2(mutableState, index);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImagePreviewItemState invokeSuspend$lambda$0(ImagePreviewState $imagePreviewState) {
        return (ImagePreviewItemState) $imagePreviewState.getDataSource().get($imagePreviewState.getCurrentIndex());
    }
}