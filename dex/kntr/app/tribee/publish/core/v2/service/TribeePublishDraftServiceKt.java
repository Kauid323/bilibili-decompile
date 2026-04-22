package kntr.app.tribee.publish.core.v2.service;

import com.bapis.bilibili.dynamic.common.KOpus;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.SerializableNodeStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* compiled from: TribeePublishDraftService.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"saveDraft", "", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "converter", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "(Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishDraftServiceKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object saveDraft(TribeePublishDraftService $this$saveDraft, TribeeInfo tribeeInfo, TribeePublishDataConverter converter, TribeePublishContent content, Continuation<? super Unit> continuation) {
        TribeePublishDraftServiceKt$saveDraft$1 tribeePublishDraftServiceKt$saveDraft$1;
        TribeeInfo tribeeInfo2;
        TribeePublishDataConverter converter2;
        TribeeDraftContent tribeeDraftContent;
        TribeePublishDraftService $this$saveDraft2;
        TribeeInfo tribeeInfo3;
        Object obj;
        TribeePublishContent content2 = content;
        if (continuation instanceof TribeePublishDraftServiceKt$saveDraft$1) {
            tribeePublishDraftServiceKt$saveDraft$1 = (TribeePublishDraftServiceKt$saveDraft$1) continuation;
            if ((tribeePublishDraftServiceKt$saveDraft$1.label & Integer.MIN_VALUE) != 0) {
                tribeePublishDraftServiceKt$saveDraft$1.label -= Integer.MIN_VALUE;
                Object $result = tribeePublishDraftServiceKt$saveDraft$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeePublishDraftServiceKt$saveDraft$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (content2 != null) {
                            TribeeInfo tribeeInfo4 = content.getTribeeInfo();
                            tribeePublishDraftServiceKt$saveDraft$1.L$0 = $this$saveDraft;
                            tribeeInfo2 = tribeeInfo;
                            tribeePublishDraftServiceKt$saveDraft$1.L$1 = tribeeInfo2;
                            tribeePublishDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter);
                            tribeePublishDraftServiceKt$saveDraft$1.L$3 = content2;
                            tribeePublishDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(content);
                            tribeePublishDraftServiceKt$saveDraft$1.L$5 = tribeeInfo4;
                            tribeePublishDraftServiceKt$saveDraft$1.I$0 = 0;
                            tribeePublishDraftServiceKt$saveDraft$1.label = 1;
                            converter2 = converter;
                            Object convert = converter2.convert(content2, true, tribeePublishDraftServiceKt$saveDraft$1);
                            if (convert == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            tribeeInfo3 = tribeeInfo4;
                            obj = convert;
                            $this$saveDraft2 = $this$saveDraft;
                            tribeeDraftContent = new TribeeDraftContent(tribeeInfo3, (KOpus) obj, SerializableNodeStorage.Companion.fromNodeStorage(content2.getContent(), content2.getLocalImageState()), content2.getSendToFollowing(), content2.getSelectedCategoryId());
                            TribeeDraftContent draft = tribeeDraftContent;
                            tribeePublishDraftServiceKt$saveDraft$1.L$0 = SpillingKt.nullOutSpilledVariable($this$saveDraft2);
                            tribeePublishDraftServiceKt$saveDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(tribeeInfo2);
                            tribeePublishDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter2);
                            tribeePublishDraftServiceKt$saveDraft$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                            tribeePublishDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(draft);
                            tribeePublishDraftServiceKt$saveDraft$1.L$5 = null;
                            tribeePublishDraftServiceKt$saveDraft$1.label = 2;
                            return $this$saveDraft2.saveDraft(tribeeInfo2, draft, tribeePublishDraftServiceKt$saveDraft$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        tribeeInfo2 = tribeeInfo;
                        converter2 = converter;
                        tribeeDraftContent = null;
                        $this$saveDraft2 = $this$saveDraft;
                        TribeeDraftContent draft2 = tribeeDraftContent;
                        tribeePublishDraftServiceKt$saveDraft$1.L$0 = SpillingKt.nullOutSpilledVariable($this$saveDraft2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(tribeeInfo2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(draft2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$5 = null;
                        tribeePublishDraftServiceKt$saveDraft$1.label = 2;
                        if ($this$saveDraft2.saveDraft(tribeeInfo2, draft2, tribeePublishDraftServiceKt$saveDraft$1) == coroutine_suspended) {
                        }
                    case 1:
                        int i = tribeePublishDraftServiceKt$saveDraft$1.I$0;
                        TribeePublishContent tribeePublishContent = (TribeePublishContent) tribeePublishDraftServiceKt$saveDraft$1.L$4;
                        content2 = (TribeePublishContent) tribeePublishDraftServiceKt$saveDraft$1.L$3;
                        tribeeInfo2 = (TribeeInfo) tribeePublishDraftServiceKt$saveDraft$1.L$1;
                        $this$saveDraft2 = (TribeePublishDraftService) tribeePublishDraftServiceKt$saveDraft$1.L$0;
                        ResultKt.throwOnFailure($result);
                        tribeeInfo3 = (TribeeInfo) tribeePublishDraftServiceKt$saveDraft$1.L$5;
                        converter2 = (TribeePublishDataConverter) tribeePublishDraftServiceKt$saveDraft$1.L$2;
                        obj = $result;
                        tribeeDraftContent = new TribeeDraftContent(tribeeInfo3, (KOpus) obj, SerializableNodeStorage.Companion.fromNodeStorage(content2.getContent(), content2.getLocalImageState()), content2.getSendToFollowing(), content2.getSelectedCategoryId());
                        TribeeDraftContent draft22 = tribeeDraftContent;
                        tribeePublishDraftServiceKt$saveDraft$1.L$0 = SpillingKt.nullOutSpilledVariable($this$saveDraft2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(tribeeInfo2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$2 = SpillingKt.nullOutSpilledVariable(converter2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$3 = SpillingKt.nullOutSpilledVariable(content2);
                        tribeePublishDraftServiceKt$saveDraft$1.L$4 = SpillingKt.nullOutSpilledVariable(draft22);
                        tribeePublishDraftServiceKt$saveDraft$1.L$5 = null;
                        tribeePublishDraftServiceKt$saveDraft$1.label = 2;
                        if ($this$saveDraft2.saveDraft(tribeeInfo2, draft22, tribeePublishDraftServiceKt$saveDraft$1) == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        TribeeDraftContent tribeeDraftContent2 = (TribeeDraftContent) tribeePublishDraftServiceKt$saveDraft$1.L$4;
                        TribeePublishContent tribeePublishContent2 = (TribeePublishContent) tribeePublishDraftServiceKt$saveDraft$1.L$3;
                        TribeePublishDataConverter tribeePublishDataConverter = (TribeePublishDataConverter) tribeePublishDraftServiceKt$saveDraft$1.L$2;
                        TribeeInfo tribeeInfo5 = (TribeeInfo) tribeePublishDraftServiceKt$saveDraft$1.L$1;
                        TribeePublishDraftService tribeePublishDraftService = (TribeePublishDraftService) tribeePublishDraftServiceKt$saveDraft$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeePublishDraftServiceKt$saveDraft$1 = new TribeePublishDraftServiceKt$saveDraft$1(continuation);
        Object $result2 = tribeePublishDraftServiceKt$saveDraft$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeePublishDraftServiceKt$saveDraft$1.label) {
        }
    }
}