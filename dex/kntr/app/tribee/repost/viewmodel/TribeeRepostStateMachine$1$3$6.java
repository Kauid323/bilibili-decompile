package kntr.app.tribee.repost.viewmodel;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KFootHoverToast;
import com.bapis.bilibili.app.dynamic.v2.KOptionItem;
import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsResp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.page.introBottomSheet.IntroBottomSheetState;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "<unused var>", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction$ShowIntroBottomSheet;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$6", f = "TribeeRepostStateMachine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {170, 171, 172, 176, 180}, m = "invokeSuspend", n = {"state", "item", "toast", "avatarUrl", "upName", "state", "item", "toast", "avatarUrl", "upName", "avatarRightText", "state", "item", "toast", "avatarUrl", "upName", "avatarRightText", "avatarBottomText", "intro", "state", "item", "toast", "avatarUrl", "upName", "avatarRightText", "avatarBottomText", "intro", "desc", "state", "item", "toast", "avatarUrl", "upName", "avatarRightText", "avatarBottomText", "intro", "desc", "buttonText"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 1)
public final class TribeeRepostStateMachine$1$3$6 extends SuspendLambda implements Function3<TribeeRepostStateAction.ShowIntroBottomSheet, State<TribeeRepostState.TribeeRepostContentState>, Continuation<? super ChangedState<? extends TribeeRepostState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeRepostStateMachine$1$3$6(Continuation<? super TribeeRepostStateMachine$1$3$6> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeRepostStateAction.ShowIntroBottomSheet showIntroBottomSheet, State<TribeeRepostState.TribeeRepostContentState> state, Continuation<? super ChangedState<? extends TribeeRepostState>> continuation) {
        TribeeRepostStateMachine$1$3$6 tribeeRepostStateMachine$1$3$6 = new TribeeRepostStateMachine$1$3$6(continuation);
        tribeeRepostStateMachine$1$3$6.L$0 = state;
        return tribeeRepostStateMachine$1$3$6.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0239 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0286 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object string;
        KOptionItem item;
        Ref.ObjectRef upName;
        KFootHoverToast toast;
        String avatarUrl;
        String it;
        boolean z;
        Object string2;
        KFootHoverToast toast2;
        KOptionItem item2;
        Ref.ObjectRef upName2;
        String avatarRightText;
        String avatarBottomText;
        Ref.ObjectRef intro;
        Object string3;
        KOptionItem item3;
        KFootHoverToast toast3;
        String avatarUrl2;
        Ref.ObjectRef intro2;
        Ref.ObjectRef desc;
        Object string4;
        KOptionItem item4;
        KFootHoverToast toast4;
        String avatarUrl3;
        Ref.ObjectRef upName3;
        String avatarRightText2;
        String avatarRightText3;
        Ref.ObjectRef intro3;
        Ref.ObjectRef intro4;
        String it2;
        Object string5;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef intro5;
        String avatarBottomText2;
        String avatarRightText4;
        Ref.ObjectRef upName4;
        String avatarUrl4;
        KFootHoverToast toast5;
        Ref.ObjectRef buttonText;
        Ref.ObjectRef desc2;
        String it3;
        String it4;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterator it5 = ((TribeeRepostState.TribeeRepostContentState) state.getSnapshot()).getData().getItems().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (((KOptionItem) obj).getBizType() == 1) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                        }
                    } else {
                        obj = null;
                    }
                }
                KOptionItem item5 = (KOptionItem) obj;
                KFootHoverToast toast6 = item5 != null ? item5.getToast() : null;
                KRepostOpus2TribeeOptionsResp.KRenderParams params = ((TribeeRepostState.TribeeRepostContentState) state.getSnapshot()).getData().getParams();
                String avatarUrl5 = params != null ? params.getFaceUrl() : null;
                Ref.ObjectRef upName5 = new Ref.ObjectRef();
                upName5.element = "";
                KRepostOpus2TribeeOptionsResp.KRenderParams params2 = ((TribeeRepostState.TribeeRepostContentState) state.getSnapshot()).getData().getParams();
                if (params2 != null && (it = params2.getNickname()) != null) {
                    upName5.element = it;
                }
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item5);
                this.L$2 = toast6;
                this.L$3 = avatarUrl5;
                this.L$4 = upName5;
                this.label = 1;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_51(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                    return coroutine_suspended;
                }
                item = item5;
                upName = upName5;
                String str = avatarUrl5;
                toast = toast6;
                avatarUrl = str;
                String avatarRightText5 = (String) string;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item);
                this.L$2 = toast;
                this.L$3 = avatarUrl;
                this.L$4 = upName;
                this.L$5 = avatarRightText5;
                this.label = 2;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_52(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                toast2 = toast;
                item2 = item;
                upName2 = upName;
                avatarRightText = avatarRightText5;
                avatarBottomText = (String) string2;
                intro = new Ref.ObjectRef();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item2);
                this.L$2 = toast2;
                this.L$3 = avatarUrl;
                this.L$4 = upName2;
                this.L$5 = avatarRightText;
                this.L$6 = avatarBottomText;
                this.L$7 = intro;
                this.L$8 = intro;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_53(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                item3 = item2;
                toast3 = toast2;
                avatarUrl2 = avatarUrl;
                intro2 = intro;
                intro.element = string3;
                if (toast3 != null && (it2 = toast3.getTitle()) != null) {
                    intro2.element = it2;
                }
                desc = new Ref.ObjectRef();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item3);
                this.L$2 = toast3;
                this.L$3 = avatarUrl2;
                this.L$4 = upName2;
                this.L$5 = avatarRightText;
                this.L$6 = avatarBottomText;
                this.L$7 = intro2;
                this.L$8 = desc;
                this.L$9 = desc;
                this.label = 4;
                string4 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_54(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string4 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                item4 = item3;
                toast4 = toast3;
                avatarUrl3 = avatarUrl2;
                upName3 = upName2;
                avatarRightText2 = avatarRightText;
                avatarRightText3 = avatarBottomText;
                intro3 = intro2;
                intro4 = desc;
                desc.element = string4;
                if (toast4 != null && (it3 = toast4.getSubtitle()) != null) {
                    intro4.element = it3;
                }
                Ref.ObjectRef buttonText2 = new Ref.ObjectRef();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item4);
                this.L$2 = toast4;
                this.L$3 = avatarUrl3;
                this.L$4 = upName3;
                this.L$5 = avatarRightText2;
                this.L$6 = avatarRightText3;
                this.L$7 = intro3;
                this.L$8 = intro4;
                this.L$9 = buttonText2;
                this.L$10 = buttonText2;
                this.label = 5;
                string5 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_55(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string5 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = buttonText2;
                intro5 = intro3;
                avatarBottomText2 = avatarRightText3;
                avatarRightText4 = avatarRightText2;
                upName4 = upName3;
                avatarUrl4 = avatarUrl3;
                toast5 = toast4;
                buttonText = objectRef;
                desc2 = intro4;
                objectRef.element = string5;
                if (toast5 != null && (it4 = toast5.getConfirmText()) != null) {
                    buttonText.element = it4;
                }
                final String str2 = avatarUrl4;
                final Ref.ObjectRef objectRef2 = upName4;
                final String str3 = avatarRightText4;
                final String str4 = avatarBottomText2;
                final Ref.ObjectRef objectRef3 = intro5;
                final Ref.ObjectRef objectRef4 = desc2;
                final Ref.ObjectRef objectRef5 = buttonText;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$6$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$5;
                        invokeSuspend$lambda$5 = TribeeRepostStateMachine$1$3$6.invokeSuspend$lambda$5(str2, objectRef2, str3, str4, objectRef3, objectRef4, objectRef5, (TribeeRepostState.TribeeRepostContentState) obj2);
                        return invokeSuspend$lambda$5;
                    }
                });
            case 1:
                upName = (Ref.ObjectRef) this.L$4;
                avatarUrl = (String) this.L$3;
                KFootHoverToast toast7 = (KFootHoverToast) this.L$2;
                ResultKt.throwOnFailure($result);
                item = (KOptionItem) this.L$1;
                toast = toast7;
                string = $result;
                String avatarRightText52 = (String) string;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item);
                this.L$2 = toast;
                this.L$3 = avatarUrl;
                this.L$4 = upName;
                this.L$5 = avatarRightText52;
                this.label = 2;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_52(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 != coroutine_suspended) {
                }
                break;
            case 2:
                String avatarUrl6 = (String) this.L$3;
                KFootHoverToast toast8 = (KFootHoverToast) this.L$2;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                toast2 = toast8;
                item2 = (KOptionItem) this.L$1;
                avatarRightText = (String) this.L$5;
                upName2 = (Ref.ObjectRef) this.L$4;
                avatarUrl = avatarUrl6;
                avatarBottomText = (String) string2;
                intro = new Ref.ObjectRef();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item2);
                this.L$2 = toast2;
                this.L$3 = avatarUrl;
                this.L$4 = upName2;
                this.L$5 = avatarRightText;
                this.L$6 = avatarBottomText;
                this.L$7 = intro;
                this.L$8 = intro;
                this.label = 3;
                string3 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_53(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string3 != coroutine_suspended) {
                }
                break;
            case 3:
                intro = (Ref.ObjectRef) this.L$8;
                intro2 = (Ref.ObjectRef) this.L$7;
                avatarBottomText = (String) this.L$6;
                avatarRightText = (String) this.L$5;
                upName2 = (Ref.ObjectRef) this.L$4;
                String avatarUrl7 = (String) this.L$3;
                KFootHoverToast toast9 = (KFootHoverToast) this.L$2;
                ResultKt.throwOnFailure($result);
                item3 = (KOptionItem) this.L$1;
                toast3 = toast9;
                avatarUrl2 = avatarUrl7;
                string3 = $result;
                intro.element = string3;
                if (toast3 != null) {
                    intro2.element = it2;
                    break;
                }
                desc = new Ref.ObjectRef();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item3);
                this.L$2 = toast3;
                this.L$3 = avatarUrl2;
                this.L$4 = upName2;
                this.L$5 = avatarRightText;
                this.L$6 = avatarBottomText;
                this.L$7 = intro2;
                this.L$8 = desc;
                this.L$9 = desc;
                this.label = 4;
                string4 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_54(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string4 != coroutine_suspended) {
                }
                break;
            case 4:
                desc = (Ref.ObjectRef) this.L$9;
                intro4 = (Ref.ObjectRef) this.L$8;
                intro3 = (Ref.ObjectRef) this.L$7;
                avatarRightText3 = (String) this.L$6;
                avatarRightText2 = (String) this.L$5;
                String avatarUrl8 = (String) this.L$3;
                KFootHoverToast toast10 = (KFootHoverToast) this.L$2;
                ResultKt.throwOnFailure($result);
                item4 = (KOptionItem) this.L$1;
                toast4 = toast10;
                avatarUrl3 = avatarUrl8;
                upName3 = (Ref.ObjectRef) this.L$4;
                string4 = $result;
                desc.element = string4;
                if (toast4 != null) {
                    intro4.element = it3;
                    break;
                }
                Ref.ObjectRef buttonText22 = new Ref.ObjectRef();
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(item4);
                this.L$2 = toast4;
                this.L$3 = avatarUrl3;
                this.L$4 = upName3;
                this.L$5 = avatarRightText2;
                this.L$6 = avatarRightText3;
                this.L$7 = intro3;
                this.L$8 = intro4;
                this.L$9 = buttonText22;
                this.L$10 = buttonText22;
                this.label = 5;
                string5 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_55(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string5 != coroutine_suspended) {
                }
                break;
            case 5:
                objectRef = (Ref.ObjectRef) this.L$10;
                String avatarUrl9 = (String) this.L$3;
                KFootHoverToast toast11 = (KFootHoverToast) this.L$2;
                KOptionItem kOptionItem = (KOptionItem) this.L$1;
                ResultKt.throwOnFailure($result);
                desc2 = (Ref.ObjectRef) this.L$8;
                intro5 = (Ref.ObjectRef) this.L$7;
                avatarBottomText2 = (String) this.L$6;
                avatarRightText4 = (String) this.L$5;
                upName4 = (Ref.ObjectRef) this.L$4;
                avatarUrl4 = avatarUrl9;
                toast5 = toast11;
                string5 = $result;
                buttonText = (Ref.ObjectRef) this.L$9;
                objectRef.element = string5;
                if (toast5 != null) {
                    buttonText.element = it4;
                    break;
                }
                final String str22 = avatarUrl4;
                final Ref.ObjectRef objectRef22 = upName4;
                final String str32 = avatarRightText4;
                final String str42 = avatarBottomText2;
                final Ref.ObjectRef objectRef32 = intro5;
                final Ref.ObjectRef objectRef42 = desc2;
                final Ref.ObjectRef objectRef52 = buttonText;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$1$3$6$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$5;
                        invokeSuspend$lambda$5 = TribeeRepostStateMachine$1$3$6.invokeSuspend$lambda$5(str22, objectRef22, str32, str42, objectRef32, objectRef42, objectRef52, (TribeeRepostState.TribeeRepostContentState) obj2);
                        return invokeSuspend$lambda$5;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeRepostState.TribeeRepostContentState invokeSuspend$lambda$5(String $avatarUrl, Ref.ObjectRef $upName, String $avatarRightText, String $avatarBottomText, Ref.ObjectRef $intro, Ref.ObjectRef $desc, Ref.ObjectRef $buttonText, TribeeRepostState.TribeeRepostContentState $this$mutate) {
        TribeeRepostState.TribeeRepostContentState copy;
        copy = $this$mutate.copy((r30 & 1) != 0 ? $this$mutate.uiAction : null, (r30 & 2) != 0 ? $this$mutate.data : null, (r30 & 4) != 0 ? $this$mutate.introBottomSheetState : new IntroBottomSheetState($avatarUrl == null ? "" : $avatarUrl, (String) $upName.element, $avatarRightText, $avatarBottomText, (String) $intro.element, (String) $desc.element, (String) $buttonText.element), (r30 & 8) != 0 ? $this$mutate.showSelectTribeeBottomSheet : false, (r30 & 16) != 0 ? $this$mutate.editRepostMainTextBottomSheetState : null, (r30 & 32) != 0 ? $this$mutate.editRepostTitleTextBottomSheetState : null, (r30 & 64) != 0 ? $this$mutate.enableRepostToFollowing : false, (r30 & 128) != 0 ? $this$mutate.enableRepostWithSource : false, (r30 & 256) != 0 ? $this$mutate.repostMainText : null, (r30 & 512) != 0 ? $this$mutate.repostTitleText : null, (r30 & 1024) != 0 ? $this$mutate.selectedTribee : null, (r30 & 2048) != 0 ? $this$mutate.selectedPartition : null, (r30 & 4096) != 0 ? $this$mutate.enableClickPageRepost : false, (r30 & 8192) != 0 ? $this$mutate.hasLoadedSelectTribeeBottomSheet : false);
        return copy;
    }
}