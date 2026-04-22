package kntr.app.tribee.publish.service.edit;

import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpusAttachments;
import com.bapis.bilibili.dynamic.common.KTribee;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import java.util.List;
import kntr.app.tribee.base.TribeeContainer;
import kntr.app.tribee.base.TribeeEditContent;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishClosing;
import kntr.app.tribee.publish.TribeePublishContent;
import kntr.app.tribee.publish.TribeePublishEditContent;
import kntr.app.tribee.publish.TribeePublishState;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInitEditServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/TribeePublishState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/TribeePublishEditContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.service.edit.TribeeInitEditServiceImpl$initBlock$1$1", f = "TribeeInitEditServiceImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {46, 39}, m = "invokeSuspend", n = {"state", "snapshot", "editInfo", "state", "snapshot", "editInfo"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class TribeeInitEditServiceImpl$initBlock$1$1 extends SuspendLambda implements Function2<State<TribeePublishEditContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ TribeeInitEditServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInitEditServiceImpl$initBlock$1$1(TribeeInitEditServiceImpl tribeeInitEditServiceImpl, Continuation<? super TribeeInitEditServiceImpl$initBlock$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeInitEditServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeInitEditServiceImpl$initBlock$1$1 = new TribeeInitEditServiceImpl$initBlock$1$1(this.this$0, continuation);
        tribeeInitEditServiceImpl$initBlock$1$1.L$0 = obj;
        return tribeeInitEditServiceImpl$initBlock$1$1;
    }

    public final Object invoke(State<TribeePublishEditContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        TribeePublishEditContent snapshot;
        TribeeEditContent editInfo;
        TribeeContentConverter tribeeContentConverter;
        Object element$iv;
        TribeeContentConverter tribeeContentConverter2;
        Object settingItems;
        TribeeContentConverter tribeeContentConverter3;
        TribeeInfo tribeeInfo;
        KOpus kOpus;
        KTribeePublishConfig kTribeePublishConfig;
        List<KTribeeCategory> list;
        KTribeeCategory kTribeeCategory;
        KTribee tribee;
        TribeeInfo tribeeInfo2;
        Object convert$default;
        TribeeEditContent editInfo2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                snapshot = (TribeePublishEditContent) state.getSnapshot();
                KLog_androidKt.getKLog().i("TribeeInitEditServiceImpl", "init edit content " + snapshot.getContentId());
                editInfo = TribeeContainer.INSTANCE.getAndRemove(snapshot.getContentId());
                if (editInfo != null) {
                    KOpusAttachments attachments = editInfo.getContent().getAttachments();
                    boolean z = false;
                    if (attachments != null && (tribee = attachments.getTribee()) != null) {
                        long tribeeId = tribee.getTribeeId();
                        tribeeInfo2 = this.this$0.tribeeInfo;
                        if (tribeeId == tribeeInfo2.getTribeeId()) {
                            z = true;
                        }
                    }
                    if (z) {
                        KLog_androidKt.getKLog().i("TribeeInitEditServiceImpl", "init edit content " + snapshot.getContentId() + " success");
                        tribeeContentConverter = this.this$0.converter;
                        KOpus content = editInfo.getContent();
                        TribeeInfo tribeeInfo3 = snapshot.getTribeeInfo();
                        KTribeePublishConfig config = editInfo.getConfig();
                        List<KTribeeCategory> categories = editInfo.getCategories();
                        Iterable $this$firstOrNull$iv = editInfo.getCategories();
                        Iterator<T> it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                KTribeeCategory it2 = (KTribeeCategory) element$iv;
                                if (it2.isSelected()) {
                                }
                            } else {
                                element$iv = null;
                            }
                        }
                        KTribeeCategory kTribeeCategory2 = (KTribeeCategory) element$iv;
                        tribeeContentConverter2 = this.this$0.converter;
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(editInfo);
                        this.L$3 = tribeeContentConverter;
                        this.L$4 = content;
                        this.L$5 = tribeeInfo3;
                        this.L$6 = config;
                        this.L$7 = categories;
                        this.L$8 = kTribeeCategory2;
                        this.label = 1;
                        settingItems = tribeeContentConverter2.getSettingItems(editInfo.getEditRsp().getPermission(), editInfo.getContent().getAttachments(), (Continuation) this);
                        if (settingItems == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tribeeContentConverter3 = tribeeContentConverter;
                        tribeeInfo = tribeeInfo3;
                        kOpus = content;
                        kTribeePublishConfig = config;
                        list = categories;
                        kTribeeCategory = kTribeeCategory2;
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(editInfo);
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.label = 2;
                        convert$default = TribeeContentConverter.CC.convert$default(tribeeContentConverter3, kOpus, tribeeInfo, kTribeePublishConfig, false, list, kTribeeCategory, (List) settingItems, false, true, (Continuation) this, 128, null);
                        if (convert$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        editInfo2 = editInfo;
                        final TribeePublishContent content2 = (TribeePublishContent) convert$default;
                        return state.override(new Function1() { // from class: kntr.app.tribee.publish.service.edit.TribeeInitEditServiceImpl$initBlock$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeePublishContent invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeeInitEditServiceImpl$initBlock$1$1.invokeSuspend$lambda$1(TribeePublishContent.this, (TribeePublishEditContent) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                }
                KLog_androidKt.getKLog().e("TribeeInitEditServiceImpl", "Fail to load edit content " + snapshot.getContentId());
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.service.edit.TribeeInitEditServiceImpl$initBlock$1$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TribeePublishClosing invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = TribeeInitEditServiceImpl$initBlock$1$1.invokeSuspend$lambda$2((TribeePublishEditContent) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                settingItems = $result;
                kTribeeCategory = (KTribeeCategory) this.L$8;
                list = (List) this.L$7;
                kTribeePublishConfig = (KTribeePublishConfig) this.L$6;
                tribeeInfo = (TribeeInfo) this.L$5;
                kOpus = (KOpus) this.L$4;
                tribeeContentConverter3 = (TribeeContentConverter) this.L$3;
                editInfo = (TribeeEditContent) this.L$2;
                snapshot = (TribeePublishEditContent) this.L$1;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot);
                this.L$2 = SpillingKt.nullOutSpilledVariable(editInfo);
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.label = 2;
                convert$default = TribeeContentConverter.CC.convert$default(tribeeContentConverter3, kOpus, tribeeInfo, kTribeePublishConfig, false, list, kTribeeCategory, (List) settingItems, false, true, (Continuation) this, 128, null);
                if (convert$default != coroutine_suspended) {
                }
                break;
            case 2:
                editInfo2 = (TribeeEditContent) this.L$2;
                TribeePublishEditContent tribeePublishEditContent = (TribeePublishEditContent) this.L$1;
                ResultKt.throwOnFailure($result);
                convert$default = $result;
                final TribeePublishContent content22 = (TribeePublishContent) convert$default;
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.service.edit.TribeeInitEditServiceImpl$initBlock$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishContent invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeeInitEditServiceImpl$initBlock$1$1.invokeSuspend$lambda$1(TribeePublishContent.this, (TribeePublishEditContent) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$1(TribeePublishContent $content, TribeePublishEditContent $this$override) {
        return $content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishClosing invokeSuspend$lambda$2(TribeePublishEditContent $this$override) {
        return new TribeePublishClosing(null, 1, null);
    }
}