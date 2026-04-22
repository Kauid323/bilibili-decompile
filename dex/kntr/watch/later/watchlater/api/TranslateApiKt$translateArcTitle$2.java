package kntr.watch.later.watchlater.api;

import com.bapis.bilibili.app.translation.v1.KTranslatedField;
import com.bapis.bilibili.app.translation.v1.KTranslationMoss;
import com.bapis.bilibili.app.translation.v1.KTranslationSimpleReply;
import com.bapis.bilibili.app.translation.v1.KTranslationSimpleReq;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TranslateApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.api.TranslateApiKt$translateArcTitle$2", f = "TranslateApi.kt", i = {0}, l = {84}, m = "invokeSuspend", n = {"req"}, s = {"L$0"}, v = 1)
final class TranslateApiKt$translateArcTitle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ TranslatableData $data;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslateApiKt$translateArcTitle$2(TranslatableData translatableData, Continuation<? super TranslateApiKt$translateArcTitle$2> continuation) {
        super(2, continuation);
        this.$data = translatableData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranslateApiKt$translateArcTitle$2(this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object translationSimple;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KTranslationSimpleReq req = new KTranslationSimpleReq(this.$data.getBizType(), this.$data.getBizId(), "", CollectionsKt.listOf("title"), CollectionsKt.listOf(this.$data.getOriginTitle()));
                this.L$0 = SpillingKt.nullOutSpilledVariable(req);
                this.label = 1;
                translationSimple = new KTranslationMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).translationSimple(req, (Continuation) this);
                if (translationSimple != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                KTranslationSimpleReq kTranslationSimpleReq = (KTranslationSimpleReq) this.L$0;
                ResultKt.throwOnFailure($result);
                translationSimple = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List reply = ((KTranslationSimpleReply) translationSimple).getResults();
        KTranslatedField kTranslatedField = (KTranslatedField) CollectionsKt.getOrNull(reply, 0);
        if (kTranslatedField != null) {
            return kTranslatedField.getTranslatedText();
        }
        return null;
    }
}