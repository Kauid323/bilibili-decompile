package kntr.app.im.chat.sticker;

import androidx.compose.runtime.MutableState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.PermissionStatus;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sticker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.StickerKt$StickerPanel$2$2$1$1$1$1$1", f = "Sticker.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerKt$StickerPanel$2$2$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BPermissionState $galleryPermission;
    final /* synthetic */ Router $route;
    final /* synthetic */ MutableState<PermissionStatus> $savedPermissionStatus;
    final /* synthetic */ MutableState<Boolean> $showPermissionDialog;
    int label;

    /* compiled from: Sticker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionStatus.values().length];
            try {
                iArr[PermissionStatus.Granted.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PermissionStatus.Limited.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PermissionStatus.Restricted.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PermissionStatus.Denied.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PermissionStatus.Undetermined.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerKt$StickerPanel$2$2$1$1$1$1$1(MutableState<PermissionStatus> mutableState, Router router, MutableState<Boolean> mutableState2, BPermissionState bPermissionState, Continuation<? super StickerKt$StickerPanel$2$2$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$savedPermissionStatus = mutableState;
        this.$route = router;
        this.$showPermissionDialog = mutableState2;
        this.$galleryPermission = bPermissionState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerKt$StickerPanel$2$2$1$1$1$1$1(this.$savedPermissionStatus, this.$route, this.$showPermissionDialog, this.$galleryPermission, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object requestAuthorization;
        PermissionStatus currentStatus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                switch (WhenMappings.$EnumSwitchMapping$0[((PermissionStatus) this.$savedPermissionStatus.getValue()).ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        this.$route.launch(UrisKt.toUri("bilibili://im/sticker/add-select"));
                        break;
                    case 4:
                        this.$showPermissionDialog.setValue(Boxing.boxBoolean(true));
                        break;
                    case 5:
                        this.label = 1;
                        requestAuthorization = this.$galleryPermission.requestAuthorization((Continuation) this);
                        if (requestAuthorization == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        currentStatus = (PermissionStatus) requestAuthorization;
                        if (!currentStatus.isGranted()) {
                            this.$route.launch(UrisKt.toUri("bilibili://im/sticker/add-select"));
                            break;
                        } else {
                            this.$savedPermissionStatus.setValue(PermissionStatus.Denied);
                            this.$showPermissionDialog.setValue(Boxing.boxBoolean(true));
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                requestAuthorization = $result;
                currentStatus = (PermissionStatus) requestAuthorization;
                if (!currentStatus.isGranted()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}