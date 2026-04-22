package video.biz.offline.list.logic.utils;

import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String0_commonMainKt;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.Map;
import kntr.base.reachability.KReachabilityKt;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.bili.videopage.common.helper.BangumiRoutes;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.OfflineLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;
import video.interfacee.bridge.freeBandwidth.KFreeBandwidthKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087@¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a.\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u001a\n\u0010\u001a\u001a\u00020\u0005*\u00020\b\u001a\n\u0010\u001b\u001a\u00020\u0005*\u00020\u001c¨\u0006\u001d"}, d2 = {"resolveEntityPLRoute", "Lcom/bilibili/lib/brouter/uri/Uri;", "key", "", "downloading", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plRoute", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "resolveBasePLRoute", "resolveDetailRoute", "aid", "", "resolveVipRoute", "type", "Lvideo/biz/offline/list/logic/utils/VipFromType;", "resolveBandwidthRoute", "checkNetworkState", "scope", "Lkotlinx/coroutines/CoroutineScope;", "machine", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "hasFreeBrandWidthError", "continueAction", "Lkotlin/Function0;", "", "hasDownloadingError", "canRetry", "Lvideo/biz/offline/base/model/error/DownloadErrorType;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UtilsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveEntityPLRoute(String key, boolean downloading, Continuation<? super Uri> continuation) {
        UtilsKt$resolveEntityPLRoute$1 utilsKt$resolveEntityPLRoute$1;
        Object videoByKey;
        OfflineVideoEntity offlineVideoEntity;
        if (continuation instanceof UtilsKt$resolveEntityPLRoute$1) {
            utilsKt$resolveEntityPLRoute$1 = (UtilsKt$resolveEntityPLRoute$1) continuation;
            if ((utilsKt$resolveEntityPLRoute$1.label & Integer.MIN_VALUE) != 0) {
                utilsKt$resolveEntityPLRoute$1.label -= Integer.MIN_VALUE;
                Object $result = utilsKt$resolveEntityPLRoute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (utilsKt$resolveEntityPLRoute$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                        utilsKt$resolveEntityPLRoute$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        utilsKt$resolveEntityPLRoute$1.Z$0 = downloading;
                        utilsKt$resolveEntityPLRoute$1.label = 1;
                        videoByKey = offlineFacadeImpl.getVideoByKey(key, utilsKt$resolveEntityPLRoute$1);
                        if (videoByKey == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        downloading = utilsKt$resolveEntityPLRoute$1.Z$0;
                        String str = (String) utilsKt$resolveEntityPLRoute$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videoByKey = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                offlineVideoEntity = (OfflineVideoEntity) videoByKey;
                if (offlineVideoEntity == null) {
                    return plRoute(offlineVideoEntity, downloading);
                }
                return null;
            }
        }
        utilsKt$resolveEntityPLRoute$1 = new UtilsKt$resolveEntityPLRoute$1(continuation);
        Object $result2 = utilsKt$resolveEntityPLRoute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (utilsKt$resolveEntityPLRoute$1.label) {
        }
        offlineVideoEntity = (OfflineVideoEntity) videoByKey;
        if (offlineVideoEntity == null) {
        }
    }

    public static final Uri plRoute(OfflineVideoEntity $this$plRoute, boolean downloading) {
        String sourceid;
        Intrinsics.checkNotNullParameter($this$plRoute, "<this>");
        Builder urlBuild = UrisKt.toUri("bilibili://music/playlist/playpage/0").buildUpon();
        urlBuild.appendQueryParameter("from_spmid", BangumiRoutes.SPMID_MAIN_CACHE);
        urlBuild.appendQueryParameter(VideoOfflineManager.EXTRA_PLAYLIST_TYPE, downloading ? "1025" : "1024");
        urlBuild.appendQueryParameter("otype", $this$plRoute.getBizType() == OfflineVideoEntity.BizType.UGC ? "2" : "24");
        if ($this$plRoute.getBizType() == OfflineVideoEntity.BizType.UGC) {
            sourceid = String.valueOf($this$plRoute.getVideoId());
        } else {
            sourceid = String.valueOf($this$plRoute.getGroupId());
        }
        urlBuild.appendQueryParameter("sourceid", sourceid);
        urlBuild.appendQueryParameter("avid", String.valueOf($this$plRoute.getAid()));
        urlBuild.appendQueryParameter("bvid", $this$plRoute.getBvid());
        urlBuild.appendQueryParameter("cid", String.valueOf($this$plRoute.getCid()));
        if ($this$plRoute.getBizType() == OfflineVideoEntity.BizType.OGV) {
            urlBuild.appendQueryParameter("epid", String.valueOf($this$plRoute.getEpisodeId()));
            Map extra = MapsKt.mapOf(TuplesKt.to("ep_id", String.valueOf($this$plRoute.getEpisodeId())));
            urlBuild.appendQueryParameter("extra_content", extra.toString());
        }
        return urlBuild.build();
    }

    public static /* synthetic */ Uri resolveBasePLRoute$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return resolveBasePLRoute(z);
    }

    public static final Uri resolveBasePLRoute(boolean downloading) {
        Builder urlBuild = UrisKt.toUri("bilibili://music/playlist/playpage/0").buildUpon();
        urlBuild.appendQueryParameter("from_spmid", BangumiRoutes.SPMID_MAIN_CACHE);
        urlBuild.appendQueryParameter(VideoOfflineManager.EXTRA_PLAYLIST_TYPE, downloading ? "1025" : "1024");
        return urlBuild.build();
    }

    public static final Uri resolveDetailRoute(long aid) {
        return UrisKt.toUri("bilibili://video/" + aid).buildUpon().build();
    }

    public static final Uri resolveVipRoute(VipFromType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return UrisKt.toUri("bilibili://user_center/vip/buy/26?appSubId=" + type.getValue()).buildUpon().build();
    }

    public static final Uri resolveBandwidthRoute() {
        return UrisKt.toUri("https://www.bilibili.com/blackboard/activity-new-freedata.html").buildUpon().build();
    }

    public static /* synthetic */ boolean checkNetworkState$default(CoroutineScope coroutineScope, OfflineBaseListStateMachine offlineBaseListStateMachine, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return checkNetworkState(coroutineScope, offlineBaseListStateMachine, z, function0);
    }

    public static final boolean checkNetworkState(CoroutineScope scope, OfflineBaseListStateMachine machine, boolean hasFreeBrandWidthError, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(machine, "machine");
        Intrinsics.checkNotNullParameter(function0, "continueAction");
        if (!KReachabilityKt.getKReachability().isReachable()) {
            machine.getToastFlow().tryEmit(PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1122(PlayerbaseresRes.INSTANCE.getString())));
            return false;
        } else if (KReachabilityKt.getKReachability().isReachableViaWWAN()) {
            if (Config.Companion.getHitFreeBandWidthFix865() && Config.Companion.getEnableDownloadWithWWAN()) {
                new OfflineLog().info("enableDownloadWithWWAN = true, skip check network");
                return true;
            } else if (!KFreeBandwidthKt.getKFreeBandwidth().isFreeBandwidthActive()) {
                BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UtilsKt$checkNetworkState$1(machine, function0, null), 3, (Object) null);
                return false;
            } else if (!hasFreeBrandWidthError) {
                machine.getToastFlow().tryEmit(PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1136(PlayerbaseresRes.INSTANCE.getString())));
                return true;
            } else {
                BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UtilsKt$checkNetworkState$2(machine, function0, hasFreeBrandWidthError, null), 3, (Object) null);
                return false;
            }
        } else {
            return true;
        }
    }

    public static final boolean hasDownloadingError(OfflineVideoEntity $this$hasDownloadingError) {
        Intrinsics.checkNotNullParameter($this$hasDownloadingError, "<this>");
        int errorNumber = OfflineError.INSTANCE.getErrorNumber($this$hasDownloadingError.getErrorCode());
        return 10000 <= errorNumber && errorNumber < 10009;
    }

    public static final boolean canRetry(DownloadErrorType $this$canRetry) {
        Intrinsics.checkNotNullParameter($this$canRetry, "<this>");
        return $this$canRetry == DownloadErrorType.NOT_WIFI || $this$canRetry == DownloadErrorType.NETWORK_DISCONNECT || $this$canRetry == DownloadErrorType.LOGOUT;
    }
}