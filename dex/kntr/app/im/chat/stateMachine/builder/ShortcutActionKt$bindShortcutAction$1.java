package kntr.app.im.chat.stateMachine.builder;

import bili.resource.im.ImRes;
import bili.resource.im.String0_commonMainKt;
import bili.resource.im.String1_commonMainKt;
import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import com.bapis.bilibili.app.im.v1.KShortcutType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.State;
import im.base.IMToast;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.ConversationService;
import kntr.app.im.chat.di.module.personal.PersonalChat;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import org.jetbrains.compose.resources.StringResource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShortcutAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$ShortcutClick;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1", f = "ShortcutAction.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER}, l = {30, 33, 37, 37, 43, 45, 49, 49, 55, 61, 61, 67}, m = "invokeSuspend", n = {"action", "state", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$1", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$2", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$2", "action", "state", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$3", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$4", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$4", "action", "state", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$6", "action", "state", "it", "$i$a$-fold-ShortcutActionKt$bindShortcutAction$1$6", "action", "state"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"}, v = 1)
public final class ShortcutActionKt$bindShortcutAction$1 extends SuspendLambda implements Function3<ChatAction.ShortcutClick, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ ConversationService $conversationService;
    final /* synthetic */ PersonalChat $sessionId;
    final /* synthetic */ FlowReduxStateMachine<ChatPageData, ChatAction> $stateMachine;
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortcutActionKt$bindShortcutAction$1(ConversationService conversationService, FlowReduxStateMachine<ChatPageData, ChatAction> flowReduxStateMachine, PersonalChat personalChat, Continuation<? super ShortcutActionKt$bindShortcutAction$1> continuation) {
        super(3, continuation);
        this.$conversationService = conversationService;
        this.$stateMachine = flowReduxStateMachine;
        this.$sessionId = personalChat;
    }

    public final Object invoke(ChatAction.ShortcutClick shortcutClick, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        ShortcutActionKt$bindShortcutAction$1 shortcutActionKt$bindShortcutAction$1 = new ShortcutActionKt$bindShortcutAction$1(this.$conversationService, this.$stateMachine, this.$sessionId, continuation);
        shortcutActionKt$bindShortcutAction$1.L$0 = shortcutClick;
        shortcutActionKt$bindShortcutAction$1.L$1 = state;
        return shortcutActionKt$bindShortcutAction$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x028b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x032c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x032d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object mo1355disallowPushIoAF18A;
        Object mo1356followUserIoAF18A;
        Object mo1354blockUserIoAF18A;
        Throwable it;
        Object suspendGetString;
        Throwable it2;
        int i;
        Throwable th;
        IMToast.Companion companion;
        IMToast.Companion companion2;
        String str;
        Object obj;
        IMToast.Companion companion3;
        String it3;
        Object create$default;
        Throwable it4;
        Object suspendGetString2;
        Throwable it5;
        int i2;
        Throwable th2;
        IMToast.Companion companion4;
        IMToast.Companion companion5;
        Object suspendGetString3;
        Object create$default2;
        Throwable it6;
        Object suspendGetString4;
        Throwable it7;
        int i3;
        Throwable th3;
        IMToast.Companion companion6;
        Object create$default3;
        ChatAction.ShortcutClick action = (ChatAction.ShortcutClick) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KShortcutType shortcutType = action.getShortcutType();
                if (Intrinsics.areEqual(shortcutType, KShortcutType.SHORTCUT_TYPE_BLOCK.INSTANCE)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.label = 1;
                    mo1354blockUserIoAF18A = this.$conversationService.mo1354blockUserIoAF18A((Continuation) this);
                    if (mo1354blockUserIoAF18A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = Result.exceptionOrNull-impl(mo1354blockUserIoAF18A);
                    if (it != null) {
                        String it8 = (String) mo1354blockUserIoAF18A;
                        companion2 = IMToast.Companion;
                        str = it8.length() > 0 ? it8 : null;
                        if (str == null) {
                            ImRes imRes = ImRes.INSTANCE;
                            StringResource im_global_string_108 = String0_commonMainKt.getIm_global_string_108(ImRes.INSTANCE.getString());
                            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(it8);
                            this.L$3 = companion2;
                            this.I$0 = 0;
                            this.label = 2;
                            Object suspendGetString5 = imRes.suspendGetString(im_global_string_108, this);
                            if (suspendGetString5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = suspendGetString5;
                            companion3 = companion2;
                            it3 = it8;
                            companion2 = companion3;
                            str = (String) obj;
                        }
                        final IMToast toast = IMToast.Companion.create$default(companion2, str, (Instant) null, 2, (Object) null);
                        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                ChatPageData invokeSuspend$lambda$0$1;
                                invokeSuspend$lambda$0$1 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$0$1(toast, (ChatPageData) obj2);
                                return invokeSuspend$lambda$0$1;
                            }
                        });
                    }
                    IMToast.Companion companion7 = IMToast.Companion;
                    ImRes imRes2 = ImRes.INSTANCE;
                    StringResource im_global_string_218 = String0_commonMainKt.getIm_global_string_218(ImRes.INSTANCE.getString());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$3 = it;
                    this.L$4 = companion7;
                    this.I$0 = 0;
                    this.label = 3;
                    suspendGetString = imRes2.suspendGetString(im_global_string_218, this);
                    if (suspendGetString == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it2 = it;
                    i = 0;
                    th = it2;
                    companion = companion7;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it2);
                    this.L$3 = null;
                    this.L$4 = null;
                    this.I$0 = i;
                    this.label = 4;
                    create$default = IMToast.Companion.create$default(companion, th, (String) suspendGetString, (Instant) null, (Function2) null, this, 12, (Object) null);
                    if (create$default != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    final IMToast toast2 = (IMToast) create$default;
                    return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            ChatPageData invokeSuspend$lambda$1$0;
                            invokeSuspend$lambda$1$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$1$0(toast2, (ChatPageData) obj2);
                            return invokeSuspend$lambda$1$0;
                        }
                    });
                } else if (!Intrinsics.areEqual(shortcutType, KShortcutType.SHORTCUT_TYPE_FOLLOW.INSTANCE)) {
                    if (!Intrinsics.areEqual(shortcutType, KShortcutType.SHORTCUT_TYPE_PUSH_DISABLE.INSTANCE)) {
                        if (Intrinsics.areEqual(shortcutType, KShortcutType.SHORTCUT_TYPE_PUSH_ENABLE.INSTANCE)) {
                            FlowReduxStateMachine<ChatPageData, ChatAction> flowReduxStateMachine = this.$stateMachine;
                            long talkerUid = this.$sessionId.getTalkerUid();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                            this.L$1 = state;
                            this.label = 12;
                            if (flowReduxStateMachine.dispatch(new ChatAction.RouteTo("bilibili://im/setting/chat/personal/" + talkerUid), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return state.noChange();
                        }
                        return state.noChange();
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.label = 9;
                    mo1355disallowPushIoAF18A = this.$conversationService.mo1355disallowPushIoAF18A((Continuation) this);
                    if (mo1355disallowPushIoAF18A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it6 = Result.exceptionOrNull-impl(mo1355disallowPushIoAF18A);
                    if (it6 != null) {
                        final IMToast toast3 = IMToast.Companion.create$default(IMToast.Companion, (String) mo1355disallowPushIoAF18A, (Instant) null, 2, (Object) null);
                        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj2) {
                                ChatPageData invokeSuspend$lambda$4$0;
                                invokeSuspend$lambda$4$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$4$0(toast3, (ChatPageData) obj2);
                                return invokeSuspend$lambda$4$0;
                            }
                        });
                    }
                    IMToast.Companion companion8 = IMToast.Companion;
                    ImRes imRes3 = ImRes.INSTANCE;
                    StringResource im_global_string_932 = String1_commonMainKt.getIm_global_string_932(ImRes.INSTANCE.getString());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it6);
                    this.L$3 = it6;
                    this.L$4 = companion8;
                    this.I$0 = 0;
                    this.label = 10;
                    suspendGetString4 = imRes3.suspendGetString(im_global_string_932, this);
                    if (suspendGetString4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it7 = it6;
                    i3 = 0;
                    th3 = it7;
                    companion6 = companion8;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it7);
                    this.L$3 = null;
                    this.L$4 = null;
                    this.I$0 = i3;
                    this.label = 11;
                    create$default3 = IMToast.Companion.create$default(companion6, th3, (String) suspendGetString4, (Instant) null, (Function2) null, this, 12, (Object) null);
                    if (create$default3 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    final IMToast toast4 = (IMToast) create$default3;
                    return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2) {
                            ChatPageData invokeSuspend$lambda$5$0;
                            invokeSuspend$lambda$5$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$5$0(toast4, (ChatPageData) obj2);
                            return invokeSuspend$lambda$5$0;
                        }
                    });
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.label = 5;
                    mo1356followUserIoAF18A = this.$conversationService.mo1356followUserIoAF18A((Continuation) this);
                    if (mo1356followUserIoAF18A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it4 = Result.exceptionOrNull-impl(mo1356followUserIoAF18A);
                    if (it4 != null) {
                        companion5 = IMToast.Companion;
                        ImRes imRes4 = ImRes.INSTANCE;
                        StringResource im_global_string_195 = String0_commonMainKt.getIm_global_string_195(ImRes.INSTANCE.getString());
                        this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                        this.L$1 = state;
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Unit) mo1356followUserIoAF18A);
                        this.L$3 = companion5;
                        this.I$0 = 0;
                        this.label = 6;
                        suspendGetString3 = imRes4.suspendGetString(im_global_string_195, this);
                        if (suspendGetString3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final IMToast toast5 = IMToast.Companion.create$default(companion5, (String) suspendGetString3, (Instant) null, 2, (Object) null);
                        return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                ChatPageData invokeSuspend$lambda$2$0;
                                invokeSuspend$lambda$2$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$2$0(toast5, (ChatPageData) obj2);
                                return invokeSuspend$lambda$2$0;
                            }
                        });
                    }
                    IMToast.Companion companion9 = IMToast.Companion;
                    ImRes imRes5 = ImRes.INSTANCE;
                    StringResource im_global_string_517 = String0_commonMainKt.getIm_global_string_517(ImRes.INSTANCE.getString());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it4);
                    this.L$3 = it4;
                    this.L$4 = companion9;
                    this.I$0 = 0;
                    this.label = 7;
                    suspendGetString2 = imRes5.suspendGetString(im_global_string_517, this);
                    if (suspendGetString2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it5 = it4;
                    i2 = 0;
                    th2 = it5;
                    companion4 = companion9;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it5);
                    this.L$3 = null;
                    this.L$4 = null;
                    this.I$0 = i2;
                    this.label = 8;
                    create$default2 = IMToast.Companion.create$default(companion4, th2, (String) suspendGetString2, (Instant) null, (Function2) null, this, 12, (Object) null);
                    if (create$default2 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    final IMToast toast6 = (IMToast) create$default2;
                    return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj2) {
                            ChatPageData invokeSuspend$lambda$3$0;
                            invokeSuspend$lambda$3$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$3$0(toast6, (ChatPageData) obj2);
                            return invokeSuspend$lambda$3$0;
                        }
                    });
                }
            case 1:
                ResultKt.throwOnFailure($result);
                mo1354blockUserIoAF18A = ((Result) $result).unbox-impl();
                it = Result.exceptionOrNull-impl(mo1354blockUserIoAF18A);
                if (it != null) {
                }
                break;
            case 2:
                int i4 = this.I$0;
                companion3 = (IMToast.Companion) this.L$3;
                ResultKt.throwOnFailure($result);
                it3 = (String) this.L$2;
                obj = $result;
                companion2 = companion3;
                str = (String) obj;
                final IMToast toast7 = IMToast.Companion.create$default(companion2, str, (Instant) null, 2, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        ChatPageData invokeSuspend$lambda$0$1;
                        invokeSuspend$lambda$0$1 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$0$1(toast7, (ChatPageData) obj2);
                        return invokeSuspend$lambda$0$1;
                    }
                });
            case 3:
                int i5 = this.I$0;
                ResultKt.throwOnFailure($result);
                i = i5;
                companion = (IMToast.Companion) this.L$4;
                th = (Throwable) this.L$3;
                it2 = (Throwable) this.L$2;
                suspendGetString = $result;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(it2);
                this.L$3 = null;
                this.L$4 = null;
                this.I$0 = i;
                this.label = 4;
                create$default = IMToast.Companion.create$default(companion, th, (String) suspendGetString, (Instant) null, (Function2) null, this, 12, (Object) null);
                if (create$default != coroutine_suspended) {
                }
                break;
            case 4:
                int i6 = this.I$0;
                Throwable th4 = (Throwable) this.L$2;
                ResultKt.throwOnFailure($result);
                create$default = $result;
                final IMToast toast22 = (IMToast) create$default;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        ChatPageData invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$1$0(toast22, (ChatPageData) obj2);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            case 5:
                ResultKt.throwOnFailure($result);
                mo1356followUserIoAF18A = ((Result) $result).unbox-impl();
                it4 = Result.exceptionOrNull-impl(mo1356followUserIoAF18A);
                if (it4 != null) {
                }
                break;
            case 6:
                int i7 = this.I$0;
                companion5 = (IMToast.Companion) this.L$3;
                Unit unit = (Unit) this.L$2;
                ResultKt.throwOnFailure($result);
                suspendGetString3 = $result;
                final IMToast toast52 = IMToast.Companion.create$default(companion5, (String) suspendGetString3, (Instant) null, 2, (Object) null);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        ChatPageData invokeSuspend$lambda$2$0;
                        invokeSuspend$lambda$2$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$2$0(toast52, (ChatPageData) obj2);
                        return invokeSuspend$lambda$2$0;
                    }
                });
            case 7:
                int i8 = this.I$0;
                ResultKt.throwOnFailure($result);
                i2 = i8;
                companion4 = (IMToast.Companion) this.L$4;
                th2 = (Throwable) this.L$3;
                it5 = (Throwable) this.L$2;
                suspendGetString2 = $result;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(it5);
                this.L$3 = null;
                this.L$4 = null;
                this.I$0 = i2;
                this.label = 8;
                create$default2 = IMToast.Companion.create$default(companion4, th2, (String) suspendGetString2, (Instant) null, (Function2) null, this, 12, (Object) null);
                if (create$default2 != coroutine_suspended) {
                }
                break;
            case 8:
                int i9 = this.I$0;
                Throwable th5 = (Throwable) this.L$2;
                ResultKt.throwOnFailure($result);
                create$default2 = $result;
                final IMToast toast62 = (IMToast) create$default2;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj2) {
                        ChatPageData invokeSuspend$lambda$3$0;
                        invokeSuspend$lambda$3$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$3$0(toast62, (ChatPageData) obj2);
                        return invokeSuspend$lambda$3$0;
                    }
                });
            case 9:
                ResultKt.throwOnFailure($result);
                mo1355disallowPushIoAF18A = ((Result) $result).unbox-impl();
                it6 = Result.exceptionOrNull-impl(mo1355disallowPushIoAF18A);
                if (it6 != null) {
                }
                break;
            case 10:
                int i10 = this.I$0;
                ResultKt.throwOnFailure($result);
                i3 = i10;
                companion6 = (IMToast.Companion) this.L$4;
                th3 = (Throwable) this.L$3;
                it7 = (Throwable) this.L$2;
                suspendGetString4 = $result;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(it7);
                this.L$3 = null;
                this.L$4 = null;
                this.I$0 = i3;
                this.label = 11;
                create$default3 = IMToast.Companion.create$default(companion6, th3, (String) suspendGetString4, (Instant) null, (Function2) null, this, 12, (Object) null);
                if (create$default3 != coroutine_suspended) {
                }
                break;
            case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                int i11 = this.I$0;
                Throwable th6 = (Throwable) this.L$2;
                ResultKt.throwOnFailure($result);
                create$default3 = $result;
                final IMToast toast42 = (IMToast) create$default3;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ShortcutActionKt$bindShortcutAction$1$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj2) {
                        ChatPageData invokeSuspend$lambda$5$0;
                        invokeSuspend$lambda$5$0 = ShortcutActionKt$bindShortcutAction$1.invokeSuspend$lambda$5$0(toast42, (ChatPageData) obj2);
                        return invokeSuspend$lambda$5$0;
                    }
                });
            case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                ResultKt.throwOnFailure($result);
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0$1(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$1$0(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$2$0(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$3$0(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$4$0(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$5$0(IMToast $toast, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : $toast, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : null, (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}