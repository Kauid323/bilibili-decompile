package kntr.common.ouro.common.service;

import com.bapis.bilibili.relation.interfaces.KAtGroup;
import com.bapis.bilibili.relation.interfaces.KAtItem;
import com.bapis.bilibili.relation.interfaces.KAtSearchReply;
import com.bapis.bilibili.relation.interfaces.KAtSearchReq;
import com.bapis.bilibili.relation.interfaces.KRelationInterfaceMoss;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.moss.api.KCallOptions;
import kntr.common.ouro.core.model.node.AtMentionUser;
import kntr.common.ouro.core.model.node.OfficialVerifyType;
import kntr.common.ouro.core.plugin.atMention.AtMentionService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: CommonAtMentionServiceImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/common/ouro/common/service/CommonAtMentionServiceImpl;", "Lkntr/common/ouro/core/plugin/atMention/AtMentionService;", "<init>", "()V", "search", "Lkotlin/Result;", "", "Lkntr/common/ouro/core/model/node/AtMentionUser;", "keyword", "", "search-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "service_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonAtMentionServiceImpl implements AtMentionService {
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0169  */
    @Override // kntr.common.ouro.core.plugin.atMention.AtMentionService
    /* renamed from: search-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1884searchgIAlus(String keyword, Continuation<? super Result<? extends List<AtMentionUser>>> continuation) {
        CommonAtMentionServiceImpl$search$1 commonAtMentionServiceImpl$search$1;
        CommonAtMentionServiceImpl$search$1 commonAtMentionServiceImpl$search$12;
        Object atSearch;
        Object result;
        if (continuation instanceof CommonAtMentionServiceImpl$search$1) {
            commonAtMentionServiceImpl$search$1 = (CommonAtMentionServiceImpl$search$1) continuation;
            if ((commonAtMentionServiceImpl$search$1.label & Integer.MIN_VALUE) != 0) {
                commonAtMentionServiceImpl$search$1.label -= Integer.MIN_VALUE;
                commonAtMentionServiceImpl$search$12 = commonAtMentionServiceImpl$search$1;
                Object $result = commonAtMentionServiceImpl$search$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (commonAtMentionServiceImpl$search$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KAtSearchReq req = new KAtSearchReq(CommonAtMentionServiceImplKt.access$mid((AccountState) KAccountStoreKt.getAccountHolder().getState().getValue()), keyword, 0, 4, (DefaultConstructorMarker) null);
                        try {
                            Result.Companion companion = Result.Companion;
                            KRelationInterfaceMoss kRelationInterfaceMoss = new KRelationInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            commonAtMentionServiceImpl$search$12.L$0 = SpillingKt.nullOutSpilledVariable(keyword);
                            commonAtMentionServiceImpl$search$12.L$1 = SpillingKt.nullOutSpilledVariable(req);
                            commonAtMentionServiceImpl$search$12.I$0 = 0;
                            commonAtMentionServiceImpl$search$12.I$1 = 0;
                            commonAtMentionServiceImpl$search$12.label = 1;
                            atSearch = kRelationInterfaceMoss.atSearch(req, commonAtMentionServiceImpl$search$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            result = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            JobKt.ensureActive(commonAtMentionServiceImpl$search$12.getContext());
                            if (Result.m2643isSuccessimpl(result)) {
                            }
                        }
                        if (atSearch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result = Result.m2636constructorimpl((KAtSearchReply) atSearch);
                        JobKt.ensureActive(commonAtMentionServiceImpl$search$12.getContext());
                        if (Result.m2643isSuccessimpl(result)) {
                            return Result.m2636constructorimpl(result);
                        }
                        Result.Companion companion3 = Result.Companion;
                        KAtSearchReply it = (KAtSearchReply) result;
                        Iterable $this$flatMap$iv = it.getGroups();
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$flatMap$iv) {
                            KAtGroup group = (KAtGroup) element$iv$iv;
                            Iterable $this$map$iv = group.getItems();
                            CommonAtMentionServiceImpl$search$1 commonAtMentionServiceImpl$search$13 = commonAtMentionServiceImpl$search$12;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            Iterable $this$mapTo$iv$iv = $this$map$iv;
                            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                                KAtItem item = (KAtItem) item$iv$iv;
                                destination$iv$iv2.add(new AtMentionUser(item.getMid(), item.getName(), item.getFace(), CommonAtMentionServiceImplKt.access$fromInt(OfficialVerifyType.Companion, item.getOfficialVerifyType())));
                                $this$map$iv = $this$map$iv;
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                $result = $result;
                            }
                            Iterable list$iv$iv = (List) destination$iv$iv2;
                            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                            commonAtMentionServiceImpl$search$12 = commonAtMentionServiceImpl$search$13;
                        }
                        return Result.m2636constructorimpl(CollectionsKt.take((List) destination$iv$iv, 20));
                    case 1:
                        int i = commonAtMentionServiceImpl$search$12.I$1;
                        int i2 = commonAtMentionServiceImpl$search$12.I$0;
                        KAtSearchReq kAtSearchReq = (KAtSearchReq) commonAtMentionServiceImpl$search$12.L$1;
                        String str = (String) commonAtMentionServiceImpl$search$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            atSearch = $result;
                            result = Result.m2636constructorimpl((KAtSearchReply) atSearch);
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            result = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            JobKt.ensureActive(commonAtMentionServiceImpl$search$12.getContext());
                            if (Result.m2643isSuccessimpl(result)) {
                            }
                        }
                        JobKt.ensureActive(commonAtMentionServiceImpl$search$12.getContext());
                        if (Result.m2643isSuccessimpl(result)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        commonAtMentionServiceImpl$search$1 = new CommonAtMentionServiceImpl$search$1(this, continuation);
        commonAtMentionServiceImpl$search$12 = commonAtMentionServiceImpl$search$1;
        Object $result2 = commonAtMentionServiceImpl$search$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (commonAtMentionServiceImpl$search$12.label) {
        }
    }
}