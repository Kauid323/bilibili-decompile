package kntr.app.tribee.publish.draft;

import com.bapis.bilibili.dynamic.common.KOpus;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishContent;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* compiled from: TribeeDraftService.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"saveDraft", "", "Lkntr/app/tribee/publish/draft/TribeeDraftService;", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "converter", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "content", "Lkntr/app/tribee/publish/TribeePublishContent;", "(Lkntr/app/tribee/publish/draft/TribeeDraftService;Lkntr/app/tribee/publish/TribeeInfo;Lkntr/app/tribee/publish/service/TribeeContentConverter;Lkntr/app/tribee/publish/TribeePublishContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDraftServiceKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object saveDraft(TribeeDraftService $this$saveDraft, TribeeInfo tribeeInfo, TribeeContentConverter converter, TribeePublishContent content, Continuation<? super Unit> continuation) {
        TribeeDraftServiceKt$saveDraft$1 tribeeDraftServiceKt$saveDraft$1;
        TribeeInfo tribeeInfo2;
        TribeeContentConverter converter2;
        TribeeDraftContent tribeeDraftContent;
        TribeeDraftService $this$saveDraft2;
        TribeeInfo tribeeInfo3;
        Object obj;
        TribeePublishContent content2 = content;
        if (continuation instanceof TribeeDraftServiceKt$saveDraft$1) {
            tribeeDraftServiceKt$saveDraft$1 = (TribeeDraftServiceKt$saveDraft$1) continuation;
            if ((tribeeDraftServiceKt$saveDraft$1.label & Integer.MIN_VALUE) != 0) {
                tribeeDraftServiceKt$saveDraft$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeDraftServiceKt$saveDraft$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeDraftServiceKt$saveDraft$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (content2 != null) {
                            TribeeInfo tribeeInfo4 = content.getTribeeInfo();
                            tribeeDraftServiceKt$saveDraft$1.L$0 = $this$saveDraft;
                            tribeeInfo2 = tribeeInfo;
                            tribeeDraftServiceKt$saveDraft$1.L$1 = tribeeInfo2;
                            tribeeDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter);
                            tribeeDraftServiceKt$saveDraft$1.L$3 = content2;
                            tribeeDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(content);
                            tribeeDraftServiceKt$saveDraft$1.L$5 = tribeeInfo4;
                            tribeeDraftServiceKt$saveDraft$1.I$0 = 0;
                            tribeeDraftServiceKt$saveDraft$1.label = 1;
                            converter2 = converter;
                            Object convert = converter2.convert(content2, true, tribeeDraftServiceKt$saveDraft$1);
                            if (convert == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            tribeeInfo3 = tribeeInfo4;
                            obj = convert;
                            $this$saveDraft2 = $this$saveDraft;
                            tribeeDraftContent = new TribeeDraftContent(tribeeInfo3, (KOpus) obj, content2.getSendToFollowing(), content2.getSelectedCategoryId());
                            TribeeDraftContent draft = tribeeDraftContent;
                            tribeeDraftServiceKt$saveDraft$1.L$0 = SpillingKt.nullOutSpilledVariable($this$saveDraft2);
                            tribeeDraftServiceKt$saveDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(tribeeInfo2);
                            tribeeDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter2);
                            tribeeDraftServiceKt$saveDraft$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                            tribeeDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(draft);
                            tribeeDraftServiceKt$saveDraft$1.L$5 = null;
                            tribeeDraftServiceKt$saveDraft$1.label = 2;
                            return $this$saveDraft2.saveDraft(tribeeInfo2, draft, tribeeDraftServiceKt$saveDraft$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        tribeeInfo2 = tribeeInfo;
                        converter2 = converter;
                        tribeeDraftContent = null;
                        $this$saveDraft2 = $this$saveDraft;
                        TribeeDraftContent draft2 = tribeeDraftContent;
                        tribeeDraftServiceKt$saveDraft$1.L$0 = SpillingKt.nullOutSpilledVariable($this$saveDraft2);
                        tribeeDraftServiceKt$saveDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(tribeeInfo2);
                        tribeeDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter2);
                        tribeeDraftServiceKt$saveDraft$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                        tribeeDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(draft2);
                        tribeeDraftServiceKt$saveDraft$1.L$5 = null;
                        tribeeDraftServiceKt$saveDraft$1.label = 2;
                        if ($this$saveDraft2.saveDraft(tribeeInfo2, draft2, tribeeDraftServiceKt$saveDraft$1) == coroutine_suspended) {
                        }
                    case 1:
                        int i = tribeeDraftServiceKt$saveDraft$1.I$0;
                        TribeePublishContent tribeePublishContent = (TribeePublishContent) tribeeDraftServiceKt$saveDraft$1.L$4;
                        content2 = (TribeePublishContent) tribeeDraftServiceKt$saveDraft$1.L$3;
                        tribeeInfo2 = (TribeeInfo) tribeeDraftServiceKt$saveDraft$1.L$1;
                        $this$saveDraft2 = (TribeeDraftService) tribeeDraftServiceKt$saveDraft$1.L$0;
                        ResultKt.throwOnFailure($result);
                        tribeeInfo3 = (TribeeInfo) tribeeDraftServiceKt$saveDraft$1.L$5;
                        converter2 = (TribeeContentConverter) tribeeDraftServiceKt$saveDraft$1.L$2;
                        obj = $result;
                        tribeeDraftContent = new TribeeDraftContent(tribeeInfo3, (KOpus) obj, content2.getSendToFollowing(), content2.getSelectedCategoryId());
                        TribeeDraftContent draft22 = tribeeDraftContent;
                        tribeeDraftServiceKt$saveDraft$1.L$0 = SpillingKt.nullOutSpilledVariable($this$saveDraft2);
                        tribeeDraftServiceKt$saveDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(tribeeInfo2);
                        tribeeDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter2);
                        tribeeDraftServiceKt$saveDraft$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                        tribeeDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(draft22);
                        tribeeDraftServiceKt$saveDraft$1.L$5 = null;
                        tribeeDraftServiceKt$saveDraft$1.label = 2;
                        if ($this$saveDraft2.saveDraft(tribeeInfo2, draft22, tribeeDraftServiceKt$saveDraft$1) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        TribeeDraftContent tribeeDraftContent2 = (TribeeDraftContent) tribeeDraftServiceKt$saveDraft$1.L$4;
                        TribeePublishContent tribeePublishContent2 = (TribeePublishContent) tribeeDraftServiceKt$saveDraft$1.L$3;
                        TribeeContentConverter tribeeContentConverter = (TribeeContentConverter) tribeeDraftServiceKt$saveDraft$1.L$2;
                        TribeeInfo tribeeInfo5 = (TribeeInfo) tribeeDraftServiceKt$saveDraft$1.L$1;
                        TribeeDraftService tribeeDraftService = (TribeeDraftService) tribeeDraftServiceKt$saveDraft$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeDraftServiceKt$saveDraft$1 = new TribeeDraftServiceKt$saveDraft$1(continuation);
        Object $result2 = tribeeDraftServiceKt$saveDraft$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeDraftServiceKt$saveDraft$1.label) {
        }
    }
}