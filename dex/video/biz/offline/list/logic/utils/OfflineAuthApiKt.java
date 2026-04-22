package video.biz.offline.list.logic.utils;

import com.bapis.bilibili.app.viewunite.v1.KCacheAuthenticationReply;
import com.bapis.bilibili.app.viewunite.v1.KCacheAuthenticationReq;
import com.bapis.bilibili.app.viewunite.v1.KCacheCode;
import com.bapis.bilibili.app.viewunite.v1.KCachePlayAv;
import com.bapis.bilibili.app.viewunite.v1.KCachePlayAvRly;
import com.bapis.bilibili.app.viewunite.v1.KViewMoss;
import com.bilibili.ktor.CommonParamsKt;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.OfflineLog;
import video.biz.offline.base.model.db.OfflineDatabaseKt;
import video.biz.offline.base.model.model.AuthCode;
import video.biz.offline.list.logic.model.AvAuthResult;
import video.biz.offline.list.logic.model.EpAuthItem;
import video.biz.offline.list.logic.model.EpAuthResult;

/* compiled from: OfflineAuthApi.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001H\u0082@¢\u0006\u0002\u0010\u000b\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u0007\u001a\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0087@¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"avAuthWithLimit", "", "Lvideo/biz/offline/list/logic/model/AvAuthResult;", "avList", "", "limit", "", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAddAvAuthResult", "cachePlayAvs", "Lcom/bapis/bilibili/app/viewunite/v1/KCachePlayAv;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "epAuthWithLimit", "Lvideo/biz/offline/list/logic/model/EpAuthItem;", "offlineList", "Lvideo/biz/offline/list/logic/utils/EpisodeParam;", "epAuth", "Lcom/bilibili/ktor/KApiResponse;", "Lvideo/biz/offline/list/logic/model/EpAuthResult;", "EP_AUTH_URL", "", "VIDEO_AUTH_BATCH_LIMIT", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineAuthApiKt {
    public static final String EP_AUTH_URL = "https://api.bilibili.com/pgc/player/api/v2/cache/play";
    public static final int VIDEO_AUTH_BATCH_LIMIT = 30;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object avAuthWithLimit(List<Long> list, int limit, Continuation<? super List<AvAuthResult>> continuation) {
        OfflineAuthApiKt$avAuthWithLimit$1 offlineAuthApiKt$avAuthWithLimit$1;
        try {
            if (continuation instanceof OfflineAuthApiKt$avAuthWithLimit$1) {
                offlineAuthApiKt$avAuthWithLimit$1 = (OfflineAuthApiKt$avAuthWithLimit$1) continuation;
                if ((offlineAuthApiKt$avAuthWithLimit$1.label & Integer.MIN_VALUE) != 0) {
                    offlineAuthApiKt$avAuthWithLimit$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineAuthApiKt$avAuthWithLimit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineAuthApiKt$avAuthWithLimit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            List reqList = CollectionsKt.chunked(list, limit, new Function1() { // from class: video.biz.offline.list.logic.utils.OfflineAuthApiKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    List avAuthWithLimit$lambda$0;
                                    avAuthWithLimit$lambda$0 = OfflineAuthApiKt.avAuthWithLimit$lambda$0((List) obj);
                                    return avAuthWithLimit$lambda$0;
                                }
                            });
                            offlineAuthApiKt$avAuthWithLimit$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            offlineAuthApiKt$avAuthWithLimit$1.L$1 = SpillingKt.nullOutSpilledVariable(reqList);
                            offlineAuthApiKt$avAuthWithLimit$1.I$0 = limit;
                            offlineAuthApiKt$avAuthWithLimit$1.label = 1;
                            Object coroutineScope = CoroutineScopeKt.coroutineScope(new OfflineAuthApiKt$avAuthWithLimit$2(reqList, null), offlineAuthApiKt$avAuthWithLimit$1);
                            if (coroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return coroutineScope;
                        case 1:
                            int limit2 = offlineAuthApiKt$avAuthWithLimit$1.I$0;
                            List list2 = (List) offlineAuthApiKt$avAuthWithLimit$1.L$1;
                            List list3 = (List) offlineAuthApiKt$avAuthWithLimit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (offlineAuthApiKt$avAuthWithLimit$1.label) {
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable e2) {
            new OfflineLog().error("avAuthWithLimit error: " + e2.getMessage());
            return CollectionsKt.emptyList();
        }
        offlineAuthApiKt$avAuthWithLimit$1 = new OfflineAuthApiKt$avAuthWithLimit$1(continuation);
        Object $result2 = offlineAuthApiKt$avAuthWithLimit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static /* synthetic */ Object avAuthWithLimit$default(List list, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 30;
        }
        return avAuthWithLimit(list, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List avAuthWithLimit$lambda$0(List batch) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        List $this$map$iv = batch;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            long id = ((Number) item$iv$iv).longValue();
            destination$iv$iv.add(new KCachePlayAv(id));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object tryAddAvAuthResult(List<KCachePlayAv> list, Continuation<? super List<AvAuthResult>> continuation) {
        OfflineAuthApiKt$tryAddAvAuthResult$1 offlineAuthApiKt$tryAddAvAuthResult$1;
        Object cacheAuthentication;
        KCacheAuthenticationReq request;
        Map itemMap;
        OfflineAuthApiKt$tryAddAvAuthResult$1 offlineAuthApiKt$tryAddAvAuthResult$12;
        Object $result;
        KCacheAuthenticationReq request2;
        AvAuthResult avAuthResult;
        if (continuation instanceof OfflineAuthApiKt$tryAddAvAuthResult$1) {
            offlineAuthApiKt$tryAddAvAuthResult$1 = (OfflineAuthApiKt$tryAddAvAuthResult$1) continuation;
            if ((offlineAuthApiKt$tryAddAvAuthResult$1.label & Integer.MIN_VALUE) != 0) {
                offlineAuthApiKt$tryAddAvAuthResult$1.label -= Integer.MIN_VALUE;
                Object $result2 = offlineAuthApiKt$tryAddAvAuthResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineAuthApiKt$tryAddAvAuthResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        KCacheAuthenticationReq request3 = new KCacheAuthenticationReq(list);
                        KViewMoss kViewMoss = new KViewMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        offlineAuthApiKt$tryAddAvAuthResult$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        offlineAuthApiKt$tryAddAvAuthResult$1.L$1 = SpillingKt.nullOutSpilledVariable(request3);
                        offlineAuthApiKt$tryAddAvAuthResult$1.label = 1;
                        cacheAuthentication = kViewMoss.cacheAuthentication(request3, offlineAuthApiKt$tryAddAvAuthResult$1);
                        if (cacheAuthentication != coroutine_suspended) {
                            request = request3;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        request = (KCacheAuthenticationReq) offlineAuthApiKt$tryAddAvAuthResult$1.L$1;
                        List list2 = (List) offlineAuthApiKt$tryAddAvAuthResult$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        cacheAuthentication = $result2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                itemMap = ((KCacheAuthenticationReply) cacheAuthentication).getItem();
                if (!itemMap.isEmpty()) {
                    new OfflineLog().info("itemMap is null");
                    return CollectionsKt.emptyList();
                }
                Collection destination$iv$iv = new ArrayList();
                for (Map.Entry element$iv$iv$iv : itemMap.entrySet()) {
                    Map itemMap2 = itemMap;
                    long avid = ((Number) element$iv$iv$iv.getKey()).longValue();
                    KCachePlayAvRly playable = (KCachePlayAvRly) element$iv$iv$iv.getValue();
                    if (playable == null) {
                        offlineAuthApiKt$tryAddAvAuthResult$12 = offlineAuthApiKt$tryAddAvAuthResult$1;
                        $result = $result2;
                        request2 = request;
                        new OfflineLog().info("item error :" + avid + " " + playable);
                        avAuthResult = null;
                    } else {
                        offlineAuthApiKt$tryAddAvAuthResult$12 = offlineAuthApiKt$tryAddAvAuthResult$1;
                        $result = $result2;
                        request2 = request;
                        KCacheCode code = playable.getCode();
                        if (Intrinsics.areEqual(code, KCacheCode.PLAY.INSTANCE)) {
                            avAuthResult = new AvAuthResult(avid, AuthCode.Pass);
                        } else if (Intrinsics.areEqual(code, KCacheCode.UPOWERSTATE_INACTIVE.INSTANCE)) {
                            new OfflineLog().info(avid + " -> UPOWERSTATE_INACTIVE");
                            avAuthResult = new AvAuthResult(avid, AuthCode.ChargeError);
                        } else {
                            avAuthResult = null;
                        }
                    }
                    if (avAuthResult != null) {
                        destination$iv$iv.add(avAuthResult);
                    }
                    itemMap = itemMap2;
                    offlineAuthApiKt$tryAddAvAuthResult$1 = offlineAuthApiKt$tryAddAvAuthResult$12;
                    $result2 = $result;
                    request = request2;
                }
                return (List) destination$iv$iv;
            }
        }
        offlineAuthApiKt$tryAddAvAuthResult$1 = new OfflineAuthApiKt$tryAddAvAuthResult$1(continuation);
        Object $result22 = offlineAuthApiKt$tryAddAvAuthResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineAuthApiKt$tryAddAvAuthResult$1.label) {
        }
        itemMap = ((KCacheAuthenticationReply) cacheAuthentication).getItem();
        if (!itemMap.isEmpty()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092 A[Catch: all -> 0x0174, CancellationException -> 0x017a, TryCatch #10 {CancellationException -> 0x017a, all -> 0x0174, blocks: (B:30:0x0084, B:31:0x008c, B:33:0x0092, B:35:0x00a1), top: B:81:0x0084 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object epAuthWithLimit(List<EpisodeParam> list, int limit, Continuation<? super List<EpAuthItem>> continuation) {
        OfflineAuthApiKt$epAuthWithLimit$1 offlineAuthApiKt$epAuthWithLimit$1;
        OfflineAuthApiKt$epAuthWithLimit$1 offlineAuthApiKt$epAuthWithLimit$12;
        ArrayList result;
        Object obj;
        Iterable $this$forEach$iv;
        int limit2;
        OfflineAuthApiKt$epAuthWithLimit$1 offlineAuthApiKt$epAuthWithLimit$13;
        int limit3 = limit;
        if (continuation instanceof OfflineAuthApiKt$epAuthWithLimit$1) {
            offlineAuthApiKt$epAuthWithLimit$1 = (OfflineAuthApiKt$epAuthWithLimit$1) continuation;
            if ((offlineAuthApiKt$epAuthWithLimit$1.label & Integer.MIN_VALUE) != 0) {
                offlineAuthApiKt$epAuthWithLimit$1.label -= Integer.MIN_VALUE;
                offlineAuthApiKt$epAuthWithLimit$12 = offlineAuthApiKt$epAuthWithLimit$1;
                Object $result = offlineAuthApiKt$epAuthWithLimit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineAuthApiKt$epAuthWithLimit$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (list.isEmpty()) {
                            return CollectionsKt.emptyList();
                        }
                        result = new ArrayList();
                        try {
                            try {
                                offlineAuthApiKt$epAuthWithLimit$12.L$0 = SpillingKt.nullOutSpilledVariable(list);
                                offlineAuthApiKt$epAuthWithLimit$12.L$1 = result;
                                offlineAuthApiKt$epAuthWithLimit$12.I$0 = limit3;
                                offlineAuthApiKt$epAuthWithLimit$12.label = 1;
                                Object coroutineScope = CoroutineScopeKt.coroutineScope(new OfflineAuthApiKt$epAuthWithLimit$2(list, limit3, null), offlineAuthApiKt$epAuthWithLimit$12);
                                if (coroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = coroutineScope;
                                try {
                                    Iterable $this$forEach$iv2 = (Iterable) obj;
                                    for (Object element$iv : $this$forEach$iv2) {
                                        KApiResponse.BusinessFailure businessFailure = (KApiResponse) element$iv;
                                        if (businessFailure instanceof KApiResponse.BusinessFailure) {
                                            $this$forEach$iv = $this$forEach$iv2;
                                            int code = businessFailure.getCode();
                                            limit2 = limit3;
                                            try {
                                                String message = businessFailure.getMessage();
                                                offlineAuthApiKt$epAuthWithLimit$13 = offlineAuthApiKt$epAuthWithLimit$12;
                                                try {
                                                    new OfflineLog().error("epAuthWithLimit error: " + new IllegalStateException("code:" + code + ",message:" + message).getMessage());
                                                    $this$forEach$iv2 = $this$forEach$iv;
                                                    limit3 = limit2;
                                                    offlineAuthApiKt$epAuthWithLimit$12 = offlineAuthApiKt$epAuthWithLimit$13;
                                                } catch (CancellationException e) {
                                                    e = e;
                                                    throw e;
                                                } catch (Throwable th) {
                                                    e = th;
                                                    new OfflineLog().error("epAuthWithLimit error: " + e.getMessage());
                                                    return CollectionsKt.emptyList();
                                                }
                                            } catch (CancellationException e2) {
                                                e = e2;
                                                throw e;
                                            } catch (Throwable th2) {
                                                e = th2;
                                                new OfflineLog().error("epAuthWithLimit error: " + e.getMessage());
                                                return CollectionsKt.emptyList();
                                            }
                                        } else {
                                            $this$forEach$iv = $this$forEach$iv2;
                                            limit2 = limit3;
                                            offlineAuthApiKt$epAuthWithLimit$13 = offlineAuthApiKt$epAuthWithLimit$12;
                                            if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                                                Exception it = ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                                                new OfflineLog().error("epAuthWithLimit error: " + it.getMessage());
                                            } else if (!(businessFailure instanceof KApiResponse.Success)) {
                                                throw new NoWhenBranchMatchedException();
                                            } else {
                                                EpAuthResult authResult = (EpAuthResult) ((KApiResponse.Success) businessFailure).getData();
                                                List it2 = authResult.getEpAuthList();
                                                if (it2 != null) {
                                                    result.addAll(it2);
                                                }
                                            }
                                            $this$forEach$iv2 = $this$forEach$iv;
                                            limit3 = limit2;
                                            offlineAuthApiKt$epAuthWithLimit$12 = offlineAuthApiKt$epAuthWithLimit$13;
                                        }
                                    }
                                    return result;
                                } catch (CancellationException e3) {
                                    e = e3;
                                } catch (Throwable th3) {
                                    e = th3;
                                }
                            } catch (CancellationException e4) {
                                e = e4;
                                throw e;
                            } catch (Throwable th4) {
                                e = th4;
                                new OfflineLog().error("epAuthWithLimit error: " + e.getMessage());
                                return CollectionsKt.emptyList();
                            }
                        } catch (CancellationException e5) {
                            e = e5;
                        } catch (Throwable th5) {
                            e = th5;
                        }
                    case 1:
                        limit3 = offlineAuthApiKt$epAuthWithLimit$12.I$0;
                        result = (List) offlineAuthApiKt$epAuthWithLimit$12.L$1;
                        List list2 = (List) offlineAuthApiKt$epAuthWithLimit$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            Iterable $this$forEach$iv22 = (Iterable) obj;
                            while (r9.hasNext()) {
                            }
                            return result;
                        } catch (CancellationException e6) {
                            e = e6;
                            throw e;
                        } catch (Throwable th6) {
                            e = th6;
                            new OfflineLog().error("epAuthWithLimit error: " + e.getMessage());
                            return CollectionsKt.emptyList();
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineAuthApiKt$epAuthWithLimit$1 = new OfflineAuthApiKt$epAuthWithLimit$1(continuation);
        offlineAuthApiKt$epAuthWithLimit$12 = offlineAuthApiKt$epAuthWithLimit$1;
        Object $result2 = offlineAuthApiKt$epAuthWithLimit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineAuthApiKt$epAuthWithLimit$12.label) {
        }
    }

    public static /* synthetic */ Object epAuthWithLimit$default(List list, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 30;
        }
        return epAuthWithLimit(list, i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object epAuth(List<EpisodeParam> list, Continuation<? super KApiResponse<EpAuthResult>> continuation) {
        OfflineAuthApiKt$epAuth$1 offlineAuthApiKt$epAuth$1;
        OfflineAuthApiKt$epAuth$1 offlineAuthApiKt$epAuth$12;
        List offlineList;
        Object suspendGetKtorHttpClient;
        HttpClient ktorHttpClient;
        List offlineList2;
        Object body$iv;
        KType kType;
        List offlineList3;
        KType kType2;
        KType kType3;
        Object bodyNullable;
        if (continuation instanceof OfflineAuthApiKt$epAuth$1) {
            offlineAuthApiKt$epAuth$1 = (OfflineAuthApiKt$epAuth$1) continuation;
            if ((offlineAuthApiKt$epAuth$1.label & Integer.MIN_VALUE) != 0) {
                offlineAuthApiKt$epAuth$1.label -= Integer.MIN_VALUE;
                offlineAuthApiKt$epAuth$12 = offlineAuthApiKt$epAuth$1;
                Object $result = offlineAuthApiKt$epAuth$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineAuthApiKt$epAuth$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (OfflineDatabaseKt.getParallelismFixFallback()) {
                            ktorHttpClient = KtorClientKt.getKtorHttpClient();
                            offlineList2 = list;
                            HttpClient $this$post$iv = ktorHttpClient;
                            HttpMessageBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, EP_AUTH_URL);
                            CommonParamsKt.forceCommonParamsToQuery(httpRequestBuilder.getUrl());
                            HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
                            body$iv = Json.Default.encodeToString(BuiltinSerializersKt.ListSerializer(EpisodeParam.Companion.serializer()), offlineList2);
                            if (body$iv == null) {
                                httpRequestBuilder.setBody(NullBody.INSTANCE);
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                                try {
                                    kType2 = Reflection.typeOf(String.class);
                                } catch (Throwable th) {
                                    kType2 = null;
                                }
                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                            } else if (body$iv instanceof OutgoingContent) {
                                httpRequestBuilder.setBody(body$iv);
                                httpRequestBuilder.setBodyType((TypeInfo) null);
                            } else {
                                httpRequestBuilder.setBody(body$iv);
                                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                try {
                                    kType = Reflection.typeOf(String.class);
                                } catch (Throwable th2) {
                                    kType = null;
                                }
                                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                            }
                            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                            offlineAuthApiKt$epAuth$12.L$0 = SpillingKt.nullOutSpilledVariable(offlineList2);
                            offlineAuthApiKt$epAuth$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                            offlineAuthApiKt$epAuth$12.L$2 = SpillingKt.nullOutSpilledVariable(EP_AUTH_URL);
                            offlineAuthApiKt$epAuth$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                            offlineAuthApiKt$epAuth$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                            offlineAuthApiKt$epAuth$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                            offlineAuthApiKt$epAuth$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                            offlineAuthApiKt$epAuth$12.I$0 = 0;
                            offlineAuthApiKt$epAuth$12.I$1 = 0;
                            offlineAuthApiKt$epAuth$12.I$2 = 0;
                            offlineAuthApiKt$epAuth$12.I$3 = 0;
                            offlineAuthApiKt$epAuth$12.label = 2;
                            $result = httpStatement.execute(offlineAuthApiKt$epAuth$12);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            offlineList3 = offlineList2;
                            HttpResponse $this$body$iv = (HttpResponse) $result;
                            HttpClientCall call = $this$body$iv.getCall();
                            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                            try {
                                kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(EpAuthResult.class)));
                            } catch (Throwable th3) {
                                kType3 = null;
                            }
                            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                            offlineAuthApiKt$epAuth$12.L$0 = SpillingKt.nullOutSpilledVariable(offlineList3);
                            offlineAuthApiKt$epAuth$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv);
                            offlineAuthApiKt$epAuth$12.L$2 = null;
                            offlineAuthApiKt$epAuth$12.L$3 = null;
                            offlineAuthApiKt$epAuth$12.L$4 = null;
                            offlineAuthApiKt$epAuth$12.L$5 = null;
                            offlineAuthApiKt$epAuth$12.L$6 = null;
                            offlineAuthApiKt$epAuth$12.I$0 = 0;
                            offlineAuthApiKt$epAuth$12.label = 3;
                            bodyNullable = call.bodyNullable(typeInfo, offlineAuthApiKt$epAuth$12);
                            if (bodyNullable != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (bodyNullable == null) {
                                return (KApiResponse) bodyNullable;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<video.biz.offline.list.logic.model.EpAuthResult>");
                        }
                        offlineList = list;
                        offlineAuthApiKt$epAuth$12.L$0 = offlineList;
                        offlineAuthApiKt$epAuth$12.label = 1;
                        suspendGetKtorHttpClient = KtorClientKt.suspendGetKtorHttpClient(offlineAuthApiKt$epAuth$12);
                        if (suspendGetKtorHttpClient == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        HttpClient httpClient = (HttpClient) suspendGetKtorHttpClient;
                        offlineList2 = offlineList;
                        ktorHttpClient = httpClient;
                        HttpClient $this$post$iv2 = ktorHttpClient;
                        HttpMessageBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                        HttpRequestKt.url(httpRequestBuilder2, EP_AUTH_URL);
                        CommonParamsKt.forceCommonParamsToQuery(httpRequestBuilder2.getUrl());
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder2, ContentType.Application.INSTANCE.getJson());
                        body$iv = Json.Default.encodeToString(BuiltinSerializersKt.ListSerializer(EpisodeParam.Companion.serializer()), offlineList2);
                        if (body$iv == null) {
                        }
                        httpRequestBuilder2.setMethod(HttpMethod.Companion.getPost());
                        HttpStatement httpStatement2 = new HttpStatement(httpRequestBuilder2, $this$post$iv2);
                        offlineAuthApiKt$epAuth$12.L$0 = SpillingKt.nullOutSpilledVariable(offlineList2);
                        offlineAuthApiKt$epAuth$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv2);
                        offlineAuthApiKt$epAuth$12.L$2 = SpillingKt.nullOutSpilledVariable(EP_AUTH_URL);
                        offlineAuthApiKt$epAuth$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv2);
                        offlineAuthApiKt$epAuth$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv2);
                        offlineAuthApiKt$epAuth$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder2);
                        offlineAuthApiKt$epAuth$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv2);
                        offlineAuthApiKt$epAuth$12.I$0 = 0;
                        offlineAuthApiKt$epAuth$12.I$1 = 0;
                        offlineAuthApiKt$epAuth$12.I$2 = 0;
                        offlineAuthApiKt$epAuth$12.I$3 = 0;
                        offlineAuthApiKt$epAuth$12.label = 2;
                        $result = httpStatement2.execute(offlineAuthApiKt$epAuth$12);
                        if ($result == coroutine_suspended) {
                        }
                    case 1:
                        offlineList = (List) offlineAuthApiKt$epAuth$12.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendGetKtorHttpClient = $result;
                        HttpClient httpClient2 = (HttpClient) suspendGetKtorHttpClient;
                        offlineList2 = offlineList;
                        ktorHttpClient = httpClient2;
                        HttpClient $this$post$iv22 = ktorHttpClient;
                        HttpMessageBuilder httpRequestBuilder22 = new HttpRequestBuilder();
                        HttpRequestKt.url(httpRequestBuilder22, EP_AUTH_URL);
                        CommonParamsKt.forceCommonParamsToQuery(httpRequestBuilder22.getUrl());
                        HttpMessagePropertiesKt.contentType(httpRequestBuilder22, ContentType.Application.INSTANCE.getJson());
                        body$iv = Json.Default.encodeToString(BuiltinSerializersKt.ListSerializer(EpisodeParam.Companion.serializer()), offlineList2);
                        if (body$iv == null) {
                        }
                        httpRequestBuilder22.setMethod(HttpMethod.Companion.getPost());
                        HttpStatement httpStatement22 = new HttpStatement(httpRequestBuilder22, $this$post$iv22);
                        offlineAuthApiKt$epAuth$12.L$0 = SpillingKt.nullOutSpilledVariable(offlineList2);
                        offlineAuthApiKt$epAuth$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv22);
                        offlineAuthApiKt$epAuth$12.L$2 = SpillingKt.nullOutSpilledVariable(EP_AUTH_URL);
                        offlineAuthApiKt$epAuth$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv22);
                        offlineAuthApiKt$epAuth$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv22);
                        offlineAuthApiKt$epAuth$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder22);
                        offlineAuthApiKt$epAuth$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv22);
                        offlineAuthApiKt$epAuth$12.I$0 = 0;
                        offlineAuthApiKt$epAuth$12.I$1 = 0;
                        offlineAuthApiKt$epAuth$12.I$2 = 0;
                        offlineAuthApiKt$epAuth$12.I$3 = 0;
                        offlineAuthApiKt$epAuth$12.label = 2;
                        $result = httpStatement22.execute(offlineAuthApiKt$epAuth$12);
                        if ($result == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int $i$f$body = offlineAuthApiKt$epAuth$12.I$3;
                        int i = offlineAuthApiKt$epAuth$12.I$2;
                        int i2 = offlineAuthApiKt$epAuth$12.I$1;
                        int i3 = offlineAuthApiKt$epAuth$12.I$0;
                        HttpClient httpClient3 = (HttpClient) offlineAuthApiKt$epAuth$12.L$6;
                        HttpRequestBuilder httpRequestBuilder3 = (HttpRequestBuilder) offlineAuthApiKt$epAuth$12.L$5;
                        HttpClient httpClient4 = (HttpClient) offlineAuthApiKt$epAuth$12.L$4;
                        HttpClient httpClient5 = (HttpClient) offlineAuthApiKt$epAuth$12.L$3;
                        String str = (String) offlineAuthApiKt$epAuth$12.L$2;
                        HttpClient httpClient6 = (HttpClient) offlineAuthApiKt$epAuth$12.L$1;
                        ResultKt.throwOnFailure($result);
                        offlineList3 = (List) offlineAuthApiKt$epAuth$12.L$0;
                        HttpResponse $this$body$iv2 = (HttpResponse) $result;
                        HttpClientCall call2 = $this$body$iv2.getCall();
                        KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(EpAuthResult.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                        offlineAuthApiKt$epAuth$12.L$0 = SpillingKt.nullOutSpilledVariable(offlineList3);
                        offlineAuthApiKt$epAuth$12.L$1 = SpillingKt.nullOutSpilledVariable($this$body$iv2);
                        offlineAuthApiKt$epAuth$12.L$2 = null;
                        offlineAuthApiKt$epAuth$12.L$3 = null;
                        offlineAuthApiKt$epAuth$12.L$4 = null;
                        offlineAuthApiKt$epAuth$12.L$5 = null;
                        offlineAuthApiKt$epAuth$12.L$6 = null;
                        offlineAuthApiKt$epAuth$12.I$0 = 0;
                        offlineAuthApiKt$epAuth$12.label = 3;
                        bodyNullable = call2.bodyNullable(typeInfo2, offlineAuthApiKt$epAuth$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int i4 = offlineAuthApiKt$epAuth$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) offlineAuthApiKt$epAuth$12.L$1;
                        List list2 = (List) offlineAuthApiKt$epAuth$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineAuthApiKt$epAuth$1 = new OfflineAuthApiKt$epAuth$1(continuation);
        offlineAuthApiKt$epAuth$12 = offlineAuthApiKt$epAuth$1;
        Object $result2 = offlineAuthApiKt$epAuth$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineAuthApiKt$epAuth$12.label) {
        }
    }
}