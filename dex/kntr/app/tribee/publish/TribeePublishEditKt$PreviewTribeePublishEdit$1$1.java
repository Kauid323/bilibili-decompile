package kntr.app.tribee.publish;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.MutableState;
import com.bapis.bilibili.dynamic.common.KCreateInitCheckScene;
import com.bapis.bilibili.dynamic.common.KMetaDataCtrl;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KRepostInitCheck;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KFeedMoss;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KGetEditDynInfoReq;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KGetEditDynInfoRsp;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import kntr.app.tribee.base.TribeeContainer;
import kntr.app.tribee.base.TribeeEditContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishEdit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishEditKt$PreviewTribeePublishEdit$1$1", f = "TribeePublishEdit.kt", i = {0, 0, 0}, l = {110}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-TribeePublishEditKt$PreviewTribeePublishEdit$1$1$1"}, s = {"L$0", "L$3", "I$0"}, v = 1)
public final class TribeePublishEditKt$PreviewTribeePublishEdit$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedDispatcher $backHandler;
    final /* synthetic */ String $id;
    final /* synthetic */ MutableState<TribeeEditContent> $initState$delegate;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishEditKt$PreviewTribeePublishEdit$1$1(String str, MutableState<TribeeEditContent> mutableState, OnBackPressedDispatcher onBackPressedDispatcher, Continuation<? super TribeePublishEditKt$PreviewTribeePublishEdit$1$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$initState$delegate = mutableState;
        this.$backHandler = onBackPressedDispatcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeePublishEditKt$PreviewTribeePublishEdit$1$1 = new TribeePublishEditKt$PreviewTribeePublishEdit$1$1(this.$id, this.$initState$delegate, this.$backHandler, continuation);
        tribeePublishEditKt$PreviewTribeePublishEdit$1$1.L$0 = obj;
        return tribeePublishEditKt$PreviewTribeePublishEdit$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object m2636constructorimpl;
        String str;
        MutableState<TribeeEditContent> mutableState;
        Object editDynInfo;
        KGetEditDynInfoRsp result;
        KOpus opus;
        KTribeePublishConfig config;
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    str = this.$id;
                    mutableState = this.$initState$delegate;
                    Result.Companion companion = Result.Companion;
                    KFeedMoss kFeedMoss = new KFeedMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    KGetEditDynInfoReq kGetEditDynInfoReq = new KGetEditDynInfoReq(Long.parseLong(str), KCreateInitCheckScene.CREATE_INIT_CHECK_SCENE_TRIBEE.INSTANCE, new KMetaDataCtrl((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "edit.tribee", (String) null, 0, 0, (String) null, 0, (String) null, 8127, (DefaultConstructorMarker) null), (KRepostInitCheck) null, (String) null, 24, (DefaultConstructorMarker) null);
                    this.L$0 = $this$LaunchedEffect;
                    this.L$1 = str;
                    this.L$2 = mutableState;
                    this.L$3 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                    this.I$0 = 0;
                    this.label = 1;
                    editDynInfo = kFeedMoss.getEditDynInfo(kGetEditDynInfoReq, this);
                    if (editDynInfo != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$3;
                    mutableState = (MutableState) this.L$2;
                    str = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    editDynInfo = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            result = (KGetEditDynInfoRsp) editDynInfo;
            opus = result.getOpus();
            config = result.getTribeeSetting();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (!(opus != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (config != null) {
            TribeeEditContent it = new TribeeEditContent(str, result);
            TribeeContainer.INSTANCE.put(str, it);
            mutableState.setValue(it);
            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
            OnBackPressedDispatcher onBackPressedDispatcher = this.$backHandler;
            if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
                JobKt.ensureActive($this$LaunchedEffect.getCoroutineContext());
                onBackPressedDispatcher.onBackPressed();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}