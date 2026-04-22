package kntr.app.im.chat.sticker.manage;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.PermissionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerManagerPage$5$1$2$1", f = "StickerManagerPage.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerManagerPageKt$StickerManagerPage$5$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BPermissionState $galleryPermission;
    final /* synthetic */ MutableState<PermissionStatus> $savedPermissionStatus;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerPageKt$StickerManagerPage$5$1$2$1(BPermissionState bPermissionState, MutableState<PermissionStatus> mutableState, Continuation<? super StickerManagerPageKt$StickerManagerPage$5$1$2$1> continuation) {
        super(2, continuation);
        this.$galleryPermission = bPermissionState;
        this.$savedPermissionStatus = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerPageKt$StickerManagerPage$5$1$2$1(this.$galleryPermission, this.$savedPermissionStatus, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final BPermissionState bPermissionState = this.$galleryPermission;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerManagerPage$5$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        PermissionStatus invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StickerManagerPageKt$StickerManagerPage$5$1$2$1.invokeSuspend$lambda$0(bPermissionState);
                        return invokeSuspend$lambda$0;
                    }
                });
                final MutableState<PermissionStatus> mutableState = this.$savedPermissionStatus;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerManagerPage$5$1$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((PermissionStatus) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(PermissionStatus it, Continuation<? super Unit> continuation) {
                        mutableState.setValue(it);
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
    public static final PermissionStatus invokeSuspend$lambda$0(BPermissionState $galleryPermission) {
        return (PermissionStatus) $galleryPermission.getCurrentStatus().getValue();
    }
}