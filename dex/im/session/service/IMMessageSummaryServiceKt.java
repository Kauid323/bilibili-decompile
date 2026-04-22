package im.session.service;

import bili.resource.im.ImRes;
import bili.resource.im.String0_commonMainKt;
import com.bapis.bilibili.app.im.v1.KMsgSummaryPrefixType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionType;
import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionPageData;
import im.session.model.IMSessionPartialPage;
import im.setting.UtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0007\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0002\u0010\u000b\u001a\u001a\u0010\f\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0010H\u0002\u001a\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0080@¢\u0006\u0002\u0010\u001f\u001a\u000e\u0010 \u001a\u00020\u0014H\u0080@¢\u0006\u0002\u0010!\" \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\"\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016\" \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001a0\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u0006\""}, d2 = {"collectFirstSummary", "Lim/session/model/IMSessionPageData;", "Lim/session/service/IMSummaryCacheService;", UtilsKt.DATA_KEY, "(Lim/session/service/IMSummaryCacheService;Lim/session/model/IMSessionPageData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lim/session/model/IMSessionPartialPage;", "partialData", "(Lim/session/service/IMSummaryCacheService;Lim/session/model/IMSessionPartialPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lim/session/model/IMSessionCard;", "sessions", "(Lim/session/service/IMSummaryCacheService;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "or", "Lim/session/service/Summary;", "other", "removeUnread", "Lcom/bapis/bilibili/app/im/v1/KMsgSummaryPrefixType;", "sessionDDMap", "", "Lcom/bapis/bilibili/app/im/v1/KSessionType;", "", "getSessionDDMap", "()Ljava/util/Map;", "sessionEmptyUnread", "getSessionEmptyUnread", "sessionResMap", "Lorg/jetbrains/compose/resources/StringResource;", "getSessionResMap", "getDefaultSummaryOfFold", "foldId", "Lcom/bapis/bilibili/app/im/v1/KSessionId$KFoldId;", "(Lcom/bapis/bilibili/app/im/v1/KSessionId$KFoldId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReadActionToast", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMMessageSummaryServiceKt {
    private static final Map<KSessionType, String> sessionDDMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(KSessionType.SESSION_TYPE_DUSTBIN.INSTANCE, "im_bff.session_dustbin_empty_unread"), TuplesKt.to(KSessionType.SESSION_TYPE_UNFOLLOWED.INSTANCE, "im_bff.session_unfollowed_empty_unread"), TuplesKt.to(KSessionType.SESSION_TYPE_STRANGER.INSTANCE, "im_bff.session_stranger_empty_unread"), TuplesKt.to(KSessionType.SESSION_TYPE_GROUP_FOLD.INSTANCE, "im_bff.session_group_fold_empty_unread")});
    private static final Map<KSessionType, String> sessionEmptyUnread;
    private static final Map<KSessionType, StringResource> sessionResMap;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectFirstSummary(IMSummaryCacheService $this$collectFirstSummary, IMSessionPageData data, Continuation<? super IMSessionPageData> continuation) {
        IMMessageSummaryServiceKt$collectFirstSummary$1 iMMessageSummaryServiceKt$collectFirstSummary$1;
        IMSessionPageData data2;
        Object obj;
        if (continuation instanceof IMMessageSummaryServiceKt$collectFirstSummary$1) {
            iMMessageSummaryServiceKt$collectFirstSummary$1 = (IMMessageSummaryServiceKt$collectFirstSummary$1) continuation;
            if ((iMMessageSummaryServiceKt$collectFirstSummary$1.label & Integer.MIN_VALUE) != 0) {
                iMMessageSummaryServiceKt$collectFirstSummary$1.label -= Integer.MIN_VALUE;
                Object $result = iMMessageSummaryServiceKt$collectFirstSummary$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMMessageSummaryServiceKt$collectFirstSummary$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "will observe summary for " + data.getSessions().size());
                        List<IMSessionCard> sessions = data.getSessions();
                        iMMessageSummaryServiceKt$collectFirstSummary$1.L$0 = SpillingKt.nullOutSpilledVariable($this$collectFirstSummary);
                        iMMessageSummaryServiceKt$collectFirstSummary$1.L$1 = data;
                        iMMessageSummaryServiceKt$collectFirstSummary$1.label = 1;
                        Object collectFirstSummary = collectFirstSummary($this$collectFirstSummary, sessions, (Continuation<? super List<IMSessionCard>>) iMMessageSummaryServiceKt$collectFirstSummary$1);
                        if (collectFirstSummary == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data2 = data;
                        obj = collectFirstSummary;
                        break;
                    case 1:
                        data2 = (IMSessionPageData) iMMessageSummaryServiceKt$collectFirstSummary$1.L$1;
                        IMSummaryCacheService iMSummaryCacheService = (IMSummaryCacheService) iMMessageSummaryServiceKt$collectFirstSummary$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List newSessions = (List) obj;
                IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "override state. newSession count " + newSessions.size());
                return IMSessionPageData.copy$default(data2, null, null, null, null, newSessions, null, null, null, null, null, false, 2031, null);
            }
        }
        iMMessageSummaryServiceKt$collectFirstSummary$1 = new IMMessageSummaryServiceKt$collectFirstSummary$1(continuation);
        Object $result2 = iMMessageSummaryServiceKt$collectFirstSummary$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMMessageSummaryServiceKt$collectFirstSummary$1.label) {
        }
        List newSessions2 = (List) obj;
        IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "override state. newSession count " + newSessions2.size());
        return IMSessionPageData.copy$default(data2, null, null, null, null, newSessions2, null, null, null, null, null, false, 2031, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectFirstSummary(IMSummaryCacheService $this$collectFirstSummary, IMSessionPartialPage partialData, Continuation<? super IMSessionPartialPage> continuation) {
        IMMessageSummaryServiceKt$collectFirstSummary$2 iMMessageSummaryServiceKt$collectFirstSummary$2;
        Object collectFirstSummary;
        if (continuation instanceof IMMessageSummaryServiceKt$collectFirstSummary$2) {
            iMMessageSummaryServiceKt$collectFirstSummary$2 = (IMMessageSummaryServiceKt$collectFirstSummary$2) continuation;
            if ((iMMessageSummaryServiceKt$collectFirstSummary$2.label & Integer.MIN_VALUE) != 0) {
                iMMessageSummaryServiceKt$collectFirstSummary$2.label -= Integer.MIN_VALUE;
                Object $result = iMMessageSummaryServiceKt$collectFirstSummary$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMMessageSummaryServiceKt$collectFirstSummary$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "will observe summary for " + partialData.getItems().size());
                        List<IMSessionCard> items = partialData.getItems();
                        iMMessageSummaryServiceKt$collectFirstSummary$2.L$0 = SpillingKt.nullOutSpilledVariable($this$collectFirstSummary);
                        iMMessageSummaryServiceKt$collectFirstSummary$2.L$1 = partialData;
                        iMMessageSummaryServiceKt$collectFirstSummary$2.label = 1;
                        collectFirstSummary = collectFirstSummary($this$collectFirstSummary, items, (Continuation<? super List<IMSessionCard>>) iMMessageSummaryServiceKt$collectFirstSummary$2);
                        if (collectFirstSummary == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        partialData = (IMSessionPartialPage) iMMessageSummaryServiceKt$collectFirstSummary$2.L$1;
                        IMSummaryCacheService iMSummaryCacheService = (IMSummaryCacheService) iMMessageSummaryServiceKt$collectFirstSummary$2.L$0;
                        ResultKt.throwOnFailure($result);
                        collectFirstSummary = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List newSessions = (List) collectFirstSummary;
                IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "override state. newSession count " + newSessions.size());
                return IMSessionPartialPage.copy$default(partialData, newSessions, null, 2, null);
            }
        }
        iMMessageSummaryServiceKt$collectFirstSummary$2 = new IMMessageSummaryServiceKt$collectFirstSummary$2(continuation);
        Object $result2 = iMMessageSummaryServiceKt$collectFirstSummary$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMMessageSummaryServiceKt$collectFirstSummary$2.label) {
        }
        List newSessions2 = (List) collectFirstSummary;
        IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "override state. newSession count " + newSessions2.size());
        return IMSessionPartialPage.copy$default(partialData, newSessions2, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object collectFirstSummary(IMSummaryCacheService $this$collectFirstSummary, List<IMSessionCard> list, Continuation<? super List<IMSessionCard>> continuation) {
        return CoroutineScopeKt.coroutineScope(new IMMessageSummaryServiceKt$collectFirstSummary$4(list, $this$collectFirstSummary, null), continuation);
    }

    public static final Summary or(Summary $this$or, Summary other) {
        return $this$or == null ? other : other == null ? $this$or : (Summary) RangesKt.coerceAtLeast($this$or, other);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KMsgSummaryPrefixType removeUnread(KMsgSummaryPrefixType $this$removeUnread) {
        if (($this$removeUnread instanceof KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_MENTIONED) || ($this$removeUnread instanceof KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_NOTIFICATION) || ($this$removeUnread instanceof KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_UNREAD)) {
            return KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_NONE.INSTANCE;
        }
        return $this$removeUnread;
    }

    public static final Map<KSessionType, String> getSessionDDMap() {
        return sessionDDMap;
    }

    static {
        Map $this$mapValues$iv = sessionDDMap;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            String v = (String) ((Map.Entry) element$iv$iv$iv).getValue();
            destination$iv$iv.put(key, IPlatformConfig.-CC.config$default(KConfig.INSTANCE, v, (String) null, 2, (Object) null));
        }
        sessionEmptyUnread = destination$iv$iv;
        sessionResMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(KSessionType.SESSION_TYPE_DUSTBIN.INSTANCE, String0_commonMainKt.getIm_global_string_277(ImRes.INSTANCE.getString())), TuplesKt.to(KSessionType.SESSION_TYPE_UNFOLLOWED.INSTANCE, String0_commonMainKt.getIm_global_string_365(ImRes.INSTANCE.getString())), TuplesKt.to(KSessionType.SESSION_TYPE_STRANGER.INSTANCE, String0_commonMainKt.getIm_global_string_368(ImRes.INSTANCE.getString())), TuplesKt.to(KSessionType.SESSION_TYPE_GROUP_FOLD.INSTANCE, String0_commonMainKt.getIm_global_string_150(ImRes.INSTANCE.getString()))});
    }

    public static final Map<KSessionType, String> getSessionEmptyUnread() {
        return sessionEmptyUnread;
    }

    public static final Map<KSessionType, StringResource> getSessionResMap() {
        return sessionResMap;
    }

    public static final Object getDefaultSummaryOfFold(KSessionId.KFoldId foldId, Continuation<? super String> continuation) {
        String str = sessionEmptyUnread.get(foldId.getValue().getType());
        if (str == null) {
            StringResource it = sessionResMap.get(foldId.getValue().getType());
            if (it != null) {
                Object suspendGetString = ImRes.INSTANCE.suspendGetString(it, continuation);
                return suspendGetString == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspendGetString : (String) suspendGetString;
            }
            return null;
        }
        return str;
    }

    public static final Object getReadActionToast(Continuation<? super String> continuation) {
        return ImRes.INSTANCE.suspendGetString(String0_commonMainKt.getIm_global_string_444(ImRes.INSTANCE.getString()), continuation);
    }
}