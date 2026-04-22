package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.MutableState;
import im.base.IMLog;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.camera.CameraCaptureLauncher;
import kntr.common.photonic.permission.BPermissionState;
import kntr.common.photonic.permission.PermissionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$PictureContent$5$7$1$1", f = "ChatBottomSheet.kt", i = {2}, l = {434, 436, 439}, m = "invokeSuspend", n = {"request"}, s = {"L$0"}, v = 1)
public final class ChatBottomSheetKt$PictureContent$5$7$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ CameraCaptureLauncher $cameraCaptureLauncher;
    final /* synthetic */ BPermissionState $cameraPermissionState;
    final /* synthetic */ MutableState<PermissionStatus> $savedCameraPermissionStatus;
    final /* synthetic */ MutableState<Boolean> $showCameraPermissionDialog;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$PictureContent$5$7$1$1(MutableState<PermissionStatus> mutableState, BPermissionState bPermissionState, MutableState<Boolean> mutableState2, CameraCaptureLauncher cameraCaptureLauncher, ChatActionHandler chatActionHandler, Continuation<? super ChatBottomSheetKt$PictureContent$5$7$1$1> continuation) {
        super(2, continuation);
        this.$savedCameraPermissionStatus = mutableState;
        this.$cameraPermissionState = bPermissionState;
        this.$showCameraPermissionDialog = mutableState2;
        this.$cameraCaptureLauncher = cameraCaptureLauncher;
        this.$actionHandler = chatActionHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$PictureContent$5$7$1$1(this.$savedCameraPermissionStatus, this.$cameraPermissionState, this.$showCameraPermissionDialog, this.$cameraCaptureLauncher, this.$actionHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object invokeSuspend$checkStatusAndPerform;
        Object requestAuthorization;
        PermissionStatus request;
        Object PictureContent$lambda$10$6$0$doLaunchCamera;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                invokeSuspend$checkStatusAndPerform = invokeSuspend$checkStatusAndPerform(this.$showCameraPermissionDialog, this.$cameraCaptureLauncher, this.$actionHandler, (PermissionStatus) this.$savedCameraPermissionStatus.getValue(), (Continuation) this);
                if (invokeSuspend$checkStatusAndPerform == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (invokeSuspend$checkStatusAndPerform == PermissionStatus.Undetermined) {
                    IMLog.Companion.w("ChatBottomSheet", "未获取相机权限，尝试请求权限");
                    this.label = 2;
                    requestAuthorization = this.$cameraPermissionState.requestAuthorization((Continuation) this);
                    if (requestAuthorization == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request = (PermissionStatus) requestAuthorization;
                    if (request.isGranted()) {
                        this.$savedCameraPermissionStatus.setValue(PermissionStatus.Denied);
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(request);
                        this.label = 3;
                        PictureContent$lambda$10$6$0$doLaunchCamera = ChatBottomSheetKt.PictureContent$lambda$10$6$0$doLaunchCamera(this.$cameraCaptureLauncher, this.$actionHandler, (Continuation) this);
                        if (PictureContent$lambda$10$6$0$doLaunchCamera == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                invokeSuspend$checkStatusAndPerform = $result;
                if (invokeSuspend$checkStatusAndPerform == PermissionStatus.Undetermined) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                requestAuthorization = $result;
                request = (PermissionStatus) requestAuthorization;
                if (request.isGranted()) {
                }
                return Unit.INSTANCE;
            case 3:
                PermissionStatus permissionStatus = (PermissionStatus) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object invokeSuspend$checkStatusAndPerform(MutableState<Boolean> mutableState, CameraCaptureLauncher cameraCaptureLauncher, ChatActionHandler $actionHandler, PermissionStatus status, Continuation<? super PermissionStatus> continuation) {
        ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1 chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1;
        Object PictureContent$lambda$10$6$0$doLaunchCamera;
        if (continuation instanceof ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1) {
            chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1 = (ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1) continuation;
            if ((chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.label & Integer.MIN_VALUE) != 0) {
                chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.label -= Integer.MIN_VALUE;
                Object $result = chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("ChatBottomSheet", "相机权限: " + status);
                        if (status.isGranted()) {
                            chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$0 = SpillingKt.nullOutSpilledVariable(mutableState);
                            chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$1 = SpillingKt.nullOutSpilledVariable(cameraCaptureLauncher);
                            chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$2 = SpillingKt.nullOutSpilledVariable($actionHandler);
                            chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$3 = status;
                            chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.label = 1;
                            PictureContent$lambda$10$6$0$doLaunchCamera = ChatBottomSheetKt.PictureContent$lambda$10$6$0$doLaunchCamera(cameraCaptureLauncher, $actionHandler, chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1);
                            if (PictureContent$lambda$10$6$0$doLaunchCamera == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return status;
                        } else if (status == PermissionStatus.Denied) {
                            mutableState.setValue(Boxing.boxBoolean(true));
                            return status;
                        } else {
                            return status;
                        }
                    case 1:
                        PermissionStatus status2 = (PermissionStatus) chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$3;
                        ChatActionHandler chatActionHandler = (ChatActionHandler) chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$2;
                        CameraCaptureLauncher cameraCaptureLauncher2 = (CameraCaptureLauncher) chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$1;
                        MutableState mutableState2 = (MutableState) chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return status2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1 = new ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1(continuation);
        Object $result2 = chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1.label) {
        }
    }
}