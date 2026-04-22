package kntr.app.digital.preview.share;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareDialogService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.share.ShareDialogService$Content$1$1", f = "ShareDialogService.kt", i = {}, l = {160, 161}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ShareDialogService$Content$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $cardImageLoadSuccess$delegate;
    final /* synthetic */ GraphicsLayer $graphicsLayer;
    final /* synthetic */ MutableState<Boolean> $imageUiDrawn$delegate;
    Object L$0;
    int label;
    final /* synthetic */ ShareDialogService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogService$Content$1$1(ShareDialogService shareDialogService, GraphicsLayer graphicsLayer, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super ShareDialogService$Content$1$1> continuation) {
        super(2, continuation);
        this.this$0 = shareDialogService;
        this.$graphicsLayer = graphicsLayer;
        this.$cardImageLoadSuccess$delegate = mutableState;
        this.$imageUiDrawn$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareDialogService$Content$1$1(this.this$0, this.$graphicsLayer, this.$cardImageLoadSuccess$delegate, this.$imageUiDrawn$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareDialogService.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.share.ShareDialogService$Content$1$1$2", f = "ShareDialogService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.share.ShareDialogService$Content$1$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Boolean> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            boolean it = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    return Boxing.boxBoolean(it);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object imageBitmap;
        ShareDialogService shareDialogService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final MutableState<Boolean> mutableState = this.$cardImageLoadSuccess$delegate;
                final MutableState<Boolean> mutableState2 = this.$imageUiDrawn$delegate;
                this.label = 1;
                if (FlowKt.first(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.share.ShareDialogService$Content$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ShareDialogService$Content$1$1.invokeSuspend$lambda$0(mutableState, mutableState2);
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                }), new AnonymousClass2(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ShareDialogService shareDialogService2 = this.this$0;
                this.L$0 = shareDialogService2;
                this.label = 2;
                imageBitmap = this.$graphicsLayer.toImageBitmap((Continuation) this);
                if (imageBitmap != coroutine_suspended) {
                    return coroutine_suspended;
                }
                shareDialogService = shareDialogService2;
                shareDialogService.setImage((ImageBitmap) imageBitmap);
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                ShareDialogService shareDialogService22 = this.this$0;
                this.L$0 = shareDialogService22;
                this.label = 2;
                imageBitmap = this.$graphicsLayer.toImageBitmap((Continuation) this);
                if (imageBitmap != coroutine_suspended) {
                }
                break;
            case 2:
                shareDialogService = (ShareDialogService) this.L$0;
                ResultKt.throwOnFailure($result);
                imageBitmap = $result;
                shareDialogService.setImage((ImageBitmap) imageBitmap);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(MutableState $cardImageLoadSuccess$delegate, MutableState $imageUiDrawn$delegate) {
        boolean Content$lambda$1;
        boolean Content$lambda$4;
        Content$lambda$1 = ShareDialogService.Content$lambda$1($cardImageLoadSuccess$delegate);
        if (Content$lambda$1) {
            Content$lambda$4 = ShareDialogService.Content$lambda$4($imageUiDrawn$delegate);
            if (Content$lambda$4) {
                return true;
            }
        }
        return false;
    }
}