package kntr.app.im.chat.stateMachine.builder;

import bili.resource.im.ImRes;
import bili.resource.im.String1_commonMainKt;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMToast;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Instant;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sticker.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$SaveSticker;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.StickerKt$bindSticker$1", f = "Sticker.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {35, 41, 45}, m = "invokeSuspend", n = {"action", "state", "pic", "resolution", "action", "state", "pic", "resolution", "it", "$i$a$-fold-StickerKt$bindSticker$1$toast$1", "action", "state", "pic", "resolution", "it", "$i$a$-fold-StickerKt$bindSticker$1$toast$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class StickerKt$bindSticker$1 extends SuspendLambda implements Function3<ChatAction.SaveSticker, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ StickerManagerService $stickerService;
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerKt$bindSticker$1(StickerManagerService stickerManagerService, Continuation<? super StickerKt$bindSticker$1> continuation) {
        super(3, continuation);
        this.$stickerService = stickerManagerService;
    }

    public final Object invoke(ChatAction.SaveSticker saveSticker, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        StickerKt$bindSticker$1 stickerKt$bindSticker$1 = new StickerKt$bindSticker$1(this.$stickerService, continuation);
        stickerKt$bindSticker$1.L$0 = saveSticker;
        stickerKt$bindSticker$1.L$1 = state;
        return stickerKt$bindSticker$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KPictureModule pic;
        Resolution resolution;
        Object mo1691saveSticker0E7RQCE;
        Object string;
        KPictureModule pic2;
        IMToast.Companion companion;
        Object string2;
        IMToast.Companion companion2;
        final IMToast toast;
        ChatAction.SaveSticker action = (ChatAction.SaveSticker) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("Chat", "保存表情" + action.getPicture());
                pic = action.getPicture();
                if (pic == null) {
                    return state.noChange();
                }
                resolution = new Resolution(pic.getWidth(), pic.getHeight());
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = pic;
                this.L$3 = SpillingKt.nullOutSpilledVariable(resolution);
                this.label = 1;
                mo1691saveSticker0E7RQCE = this.$stickerService.mo1691saveSticker0E7RQCE(pic.getUrl(), resolution, (Continuation) this);
                if (mo1691saveSticker0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                KPictureModule pic3 = (KPictureModule) this.L$2;
                ResultKt.throwOnFailure($result);
                mo1691saveSticker0E7RQCE = ((Result) $result).unbox-impl();
                resolution = (Resolution) this.L$3;
                pic = pic3;
                break;
            case 2:
                int i = this.I$0;
                companion2 = (IMToast.Companion) this.L$5;
                Unit unit = (Unit) this.L$4;
                Resolution resolution2 = (Resolution) this.L$3;
                pic2 = (KPictureModule) this.L$2;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                toast = IMToast.Companion.create$default(companion2, (String) string2, (Instant) null, 2, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.StickerKt$bindSticker$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = StickerKt$bindSticker$1.invokeSuspend$lambda$2(toast, (ChatPageData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case 3:
                int i2 = this.I$0;
                companion = (IMToast.Companion) this.L$5;
                Throwable th = (Throwable) this.L$4;
                Resolution resolution3 = (Resolution) this.L$3;
                pic2 = (KPictureModule) this.L$2;
                ResultKt.throwOnFailure($result);
                string = $result;
                toast = IMToast.Companion.create$default(companion, (String) string, (Instant) null, 2, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.StickerKt$bindSticker$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = StickerKt$bindSticker$1.invokeSuspend$lambda$2(toast, (ChatPageData) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Throwable it = Result.exceptionOrNull-impl(mo1691saveSticker0E7RQCE);
        if (it == null) {
            IMLog.Companion.i("Chat", "保存表情成功" + pic.getUrl());
            IMToast.Companion companion3 = IMToast.Companion;
            StringResource im_global_string_933 = String1_commonMainKt.getIm_global_string_933(ImRes.INSTANCE.getString());
            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
            this.L$1 = state;
            this.L$2 = SpillingKt.nullOutSpilledVariable(pic);
            this.L$3 = SpillingKt.nullOutSpilledVariable(resolution);
            this.L$4 = SpillingKt.nullOutSpilledVariable((Unit) mo1691saveSticker0E7RQCE);
            this.L$5 = companion3;
            this.I$0 = 0;
            this.label = 2;
            string2 = StringResourcesKt.getString(im_global_string_933, this);
            if (string2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            pic2 = pic;
            companion2 = companion3;
            toast = IMToast.Companion.create$default(companion2, (String) string2, (Instant) null, 2, (Object) null);
            return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.StickerKt$bindSticker$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    ChatPageData invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = StickerKt$bindSticker$1.invokeSuspend$lambda$2(toast, (ChatPageData) obj);
                    return invokeSuspend$lambda$2;
                }
            });
        }
        IMLog.Companion.e("Chat", "保存表情失败" + pic.getUrl(), it);
        IMToast.Companion companion4 = IMToast.Companion;
        StringResource im_global_string_934 = String1_commonMainKt.getIm_global_string_934(ImRes.INSTANCE.getString());
        this.L$0 = SpillingKt.nullOutSpilledVariable(action);
        this.L$1 = state;
        this.L$2 = SpillingKt.nullOutSpilledVariable(pic);
        this.L$3 = SpillingKt.nullOutSpilledVariable(resolution);
        this.L$4 = SpillingKt.nullOutSpilledVariable(it);
        this.L$5 = companion4;
        this.I$0 = 0;
        this.label = 3;
        string = StringResourcesKt.getString(im_global_string_934, this);
        if (string == coroutine_suspended) {
            return coroutine_suspended;
        }
        pic2 = pic;
        companion = companion4;
        toast = IMToast.Companion.create$default(companion, (String) string, (Instant) null, 2, (Object) null);
        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.StickerKt$bindSticker$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ChatPageData invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = StickerKt$bindSticker$1.invokeSuspend$lambda$2(toast, (ChatPageData) obj);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$2(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}