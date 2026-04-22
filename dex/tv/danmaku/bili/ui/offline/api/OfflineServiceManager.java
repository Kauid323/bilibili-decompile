package tv.danmaku.bili.ui.offline.api;

import ComposableSingletons$CustomBottomSheetKt$;
import android.util.LongSparseArray;
import com.bapis.bilibili.app.viewunite.v1.CacheAuthenticationReply;
import com.bapis.bilibili.app.viewunite.v1.CacheAuthenticationReq;
import com.bapis.bilibili.app.viewunite.v1.CacheCode;
import com.bapis.bilibili.app.viewunite.v1.CachePlayAv;
import com.bapis.bilibili.app.viewunite.v1.CachePlayAvRly;
import com.bapis.bilibili.app.viewunite.v1.ViewMoss;
import com.bapis.bilibili.app.viewunite.v1.ViewuniteMossKtxKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.bilibili.playerbizcommonv2.utils.PlayerExtensionsKt;
import com.bilibili.videodownloader.model.VerificationCode;
import com.bilibili.videodownloader.utils.log.LogHelper;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import tv.danmaku.bili.ui.offline.api.EpPlayableV2;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineServiceManager.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nH\u0082@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0007J\n\u0010\"\u001a\u00020#*\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/OfflineServiceManager;", "", "<init>", "()V", "VIDEO_VERIFY_MAX_SIZE", "", "TAG", "", "videoVerifyReqCatching", "Lkotlin/Result;", "", "Ltv/danmaku/bili/ui/offline/api/OfflineServiceManager$VideoVerifyResult;", "avList", "", "limit", "videoVerifyReqCatching-0E7RQCE", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAddVideoVerifyResult", "cachePlayAvs", "Lcom/bapis/bilibili/app/viewunite/v1/CachePlayAv;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryEpPlayableV2Catching", "Ltv/danmaku/bili/ui/offline/api/OgvApiResponseV2;", "offlineList", "Lcom/google/gson/JsonArray;", "queryEpPlayableV2Catching-gIAlu-s", "(Lcom/google/gson/JsonArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapEpPlayableV2List", "Landroid/util/LongSparseArray;", "data", "Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$EpPlayableParams;", "reportChangeTaskCount", "", WatchLaterReporterKt.KEY_NUM, "toPlayable", "", "Lcom/bilibili/videodownloader/model/VerificationCode;", "VideoVerifyResult", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineServiceManager {
    public static final int $stable = 0;
    public static final OfflineServiceManager INSTANCE = new OfflineServiceManager();
    private static final String TAG = "OfflineServiceManager";
    public static final int VIDEO_VERIFY_MAX_SIZE = 30;

    /* compiled from: OfflineServiceManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CacheCode.values().length];
            try {
                iArr[CacheCode.PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CacheCode.UPOWERSTATE_INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private OfflineServiceManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* renamed from: videoVerifyReqCatching-0E7RQCE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1375videoVerifyReqCatching0E7RQCE(List<Long> list, int limit, Continuation<? super Result<? extends List<VideoVerifyResult>>> continuation) {
        OfflineServiceManager$videoVerifyReqCatching$1 offlineServiceManager$videoVerifyReqCatching$1;
        if (continuation instanceof OfflineServiceManager$videoVerifyReqCatching$1) {
            offlineServiceManager$videoVerifyReqCatching$1 = (OfflineServiceManager$videoVerifyReqCatching$1) continuation;
            if ((offlineServiceManager$videoVerifyReqCatching$1.label & Integer.MIN_VALUE) != 0) {
                offlineServiceManager$videoVerifyReqCatching$1.label -= Integer.MIN_VALUE;
                Object $result = offlineServiceManager$videoVerifyReqCatching$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineServiceManager$videoVerifyReqCatching$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        offlineServiceManager$videoVerifyReqCatching$1.label = 1;
                        Object suspendRunCatching = PlayerExtensionsKt.suspendRunCatching(new OfflineServiceManager$videoVerifyReqCatching$2(limit, list, null), offlineServiceManager$videoVerifyReqCatching$1);
                        if (suspendRunCatching == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return suspendRunCatching;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineServiceManager$videoVerifyReqCatching$1 = new OfflineServiceManager$videoVerifyReqCatching$1(this, continuation);
        Object $result2 = offlineServiceManager$videoVerifyReqCatching$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineServiceManager$videoVerifyReqCatching$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryAddVideoVerifyResult(List<CachePlayAv> list, Continuation<? super List<VideoVerifyResult>> continuation) {
        OfflineServiceManager$tryAddVideoVerifyResult$1 offlineServiceManager$tryAddVideoVerifyResult$1;
        Object suspendCacheAuthentication;
        Map itemMap;
        VideoVerifyResult videoVerifyResult;
        if (continuation instanceof OfflineServiceManager$tryAddVideoVerifyResult$1) {
            offlineServiceManager$tryAddVideoVerifyResult$1 = (OfflineServiceManager$tryAddVideoVerifyResult$1) continuation;
            if ((offlineServiceManager$tryAddVideoVerifyResult$1.label & Integer.MIN_VALUE) != 0) {
                offlineServiceManager$tryAddVideoVerifyResult$1.label -= Integer.MIN_VALUE;
                Object $result = offlineServiceManager$tryAddVideoVerifyResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineServiceManager$tryAddVideoVerifyResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CacheAuthenticationReq request = CacheAuthenticationReq.newBuilder().addAllAv(list).build();
                        ViewMoss viewMoss = new ViewMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                        Intrinsics.checkNotNull(request);
                        offlineServiceManager$tryAddVideoVerifyResult$1.label = 1;
                        suspendCacheAuthentication = ViewuniteMossKtxKt.suspendCacheAuthentication(viewMoss, request, offlineServiceManager$tryAddVideoVerifyResult$1);
                        if (suspendCacheAuthentication == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        suspendCacheAuthentication = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CacheAuthenticationReply cacheAuthenticationReply = (CacheAuthenticationReply) suspendCacheAuthentication;
                itemMap = cacheAuthenticationReply == null ? cacheAuthenticationReply.getItemMap() : null;
                if (!(itemMap != null || itemMap.isEmpty())) {
                    LogHelper.i(TAG, "itemMap is empty");
                    return CollectionsKt.emptyList();
                }
                Map destination$iv$iv = new LinkedHashMap();
                for (Map.Entry element$iv$iv : itemMap.entrySet()) {
                    Long avid = (Long) element$iv$iv.getKey();
                    CachePlayAvRly playable = (CachePlayAvRly) element$iv$iv.getValue();
                    LogHelper.i(TAG, "item map: " + avid + " " + (playable != null ? Boxing.boxInt(playable.getCodeValue()) : null));
                    if ((avid == null || playable == null) ? false : true) {
                        destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                    }
                }
                Collection destination$iv$iv2 = new ArrayList(destination$iv$iv.size());
                for (Map.Entry entry : destination$iv$iv.entrySet()) {
                    Long avid2 = (Long) entry.getKey();
                    CachePlayAvRly playable2 = (CachePlayAvRly) entry.getValue();
                    if (avid2 != null && playable2 != null) {
                        CacheCode code = playable2.getCode();
                        switch (code == null ? -1 : WhenMappings.$EnumSwitchMapping$0[code.ordinal()]) {
                            case 1:
                                videoVerifyResult = new VideoVerifyResult(avid2.longValue(), VerificationCode.Pass);
                                continue;
                            case 2:
                                LogHelper.i(TAG, avid2 + " -> UPOWERSTATE_INACTIVE");
                                videoVerifyResult = new VideoVerifyResult(avid2.longValue(), VerificationCode.ChargeError);
                                continue;
                            default:
                                videoVerifyResult = null;
                                continue;
                        }
                    } else {
                        LogHelper.i(TAG, "item error :" + avid2 + " " + playable2);
                        videoVerifyResult = null;
                    }
                    destination$iv$iv2.add(videoVerifyResult);
                }
                return (List) destination$iv$iv2;
            }
        }
        offlineServiceManager$tryAddVideoVerifyResult$1 = new OfflineServiceManager$tryAddVideoVerifyResult$1(this, continuation);
        Object $result2 = offlineServiceManager$tryAddVideoVerifyResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineServiceManager$tryAddVideoVerifyResult$1.label) {
        }
        CacheAuthenticationReply cacheAuthenticationReply2 = (CacheAuthenticationReply) suspendCacheAuthentication;
        if (cacheAuthenticationReply2 == null) {
        }
        if (!(itemMap != null || itemMap.isEmpty())) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* renamed from: queryEpPlayableV2Catching-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1374queryEpPlayableV2CatchinggIAlus(JsonArray offlineList, Continuation<? super Result<OgvApiResponseV2>> continuation) {
        OfflineServiceManager$queryEpPlayableV2Catching$1 offlineServiceManager$queryEpPlayableV2Catching$1;
        if (continuation instanceof OfflineServiceManager$queryEpPlayableV2Catching$1) {
            offlineServiceManager$queryEpPlayableV2Catching$1 = (OfflineServiceManager$queryEpPlayableV2Catching$1) continuation;
            if ((offlineServiceManager$queryEpPlayableV2Catching$1.label & Integer.MIN_VALUE) != 0) {
                offlineServiceManager$queryEpPlayableV2Catching$1.label -= Integer.MIN_VALUE;
                Object $result = offlineServiceManager$queryEpPlayableV2Catching$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineServiceManager$queryEpPlayableV2Catching$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String accessKey = BiliAccounts.get(FoundationAlias.getFapp()).getAccessKey();
                        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), JsonUtilKt.toJson(offlineList));
                        offlineServiceManager$queryEpPlayableV2Catching$1.label = 1;
                        Object suspendRunCatching = PlayerExtensionsKt.suspendRunCatching(new OfflineServiceManager$queryEpPlayableV2Catching$2(accessKey, requestBody, null), offlineServiceManager$queryEpPlayableV2Catching$1);
                        if (suspendRunCatching == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return suspendRunCatching;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineServiceManager$queryEpPlayableV2Catching$1 = new OfflineServiceManager$queryEpPlayableV2Catching$1(this, continuation);
        Object $result2 = offlineServiceManager$queryEpPlayableV2Catching$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineServiceManager$queryEpPlayableV2Catching$1.label) {
        }
    }

    public final LongSparseArray<Integer> mapEpPlayableV2List(List<EpPlayableV2.EpPlayableParams> list) {
        LongSparseArray epPlayableMap = new LongSparseArray();
        List<EpPlayableV2.EpPlayableParams> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            for (EpPlayableV2.EpPlayableParams param : list) {
                epPlayableMap.put(param.getEpId(), Integer.valueOf(param.getPlayableType()));
            }
        }
        return epPlayableMap;
    }

    @JvmStatic
    public static final void reportChangeTaskCount(int num) {
        String accessKey = BiliAccounts.get(FoundationAlias.getFapp()).getAccessKey();
        ((OfflineAppService) ServiceGenerator.createService(OfflineAppService.class)).reportTaskCountChange(accessKey, num).enqueue();
    }

    /* compiled from: OfflineServiceManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/OfflineServiceManager$VideoVerifyResult;", "", "avid", "", "code", "Lcom/bilibili/videodownloader/model/VerificationCode;", "<init>", "(JLcom/bilibili/videodownloader/model/VerificationCode;)V", "getAvid", "()J", "getCode", "()Lcom/bilibili/videodownloader/model/VerificationCode;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideoVerifyResult {
        public static final int $stable = 0;
        private final long avid;
        private final VerificationCode code;

        public static /* synthetic */ VideoVerifyResult copy$default(VideoVerifyResult videoVerifyResult, long j, VerificationCode verificationCode, int i, Object obj) {
            if ((i & 1) != 0) {
                j = videoVerifyResult.avid;
            }
            if ((i & 2) != 0) {
                verificationCode = videoVerifyResult.code;
            }
            return videoVerifyResult.copy(j, verificationCode);
        }

        public final long component1() {
            return this.avid;
        }

        public final VerificationCode component2() {
            return this.code;
        }

        public final VideoVerifyResult copy(long j, VerificationCode verificationCode) {
            Intrinsics.checkNotNullParameter(verificationCode, "code");
            return new VideoVerifyResult(j, verificationCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VideoVerifyResult) {
                VideoVerifyResult videoVerifyResult = (VideoVerifyResult) obj;
                return this.avid == videoVerifyResult.avid && this.code == videoVerifyResult.code;
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid) * 31) + this.code.hashCode();
        }

        public String toString() {
            long j = this.avid;
            return "VideoVerifyResult(avid=" + j + ", code=" + this.code + ")";
        }

        public VideoVerifyResult(long avid, VerificationCode code) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.avid = avid;
            this.code = code;
        }

        public final long getAvid() {
            return this.avid;
        }

        public final VerificationCode getCode() {
            return this.code;
        }
    }

    public final boolean toPlayable(VerificationCode $this$toPlayable) {
        Intrinsics.checkNotNullParameter($this$toPlayable, "<this>");
        return $this$toPlayable == VerificationCode.Pass;
    }
}