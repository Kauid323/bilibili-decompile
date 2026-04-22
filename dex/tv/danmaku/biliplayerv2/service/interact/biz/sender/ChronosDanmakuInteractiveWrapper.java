package tv.danmaku.biliplayerv2.service.interact.biz.sender;

import android.content.Context;
import bili.resource.playerbaseres.R;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.PageViewTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsBlockApiService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosDanmakuInteractiveWrapper.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jr\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002JP\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuInteractiveWrapper;", "", "<init>", "()V", "TAG", "", "reportDanmaku", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "dmId", "oid", "reason", "shieldUser", "", "shieldUserId", "callBack", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/OnInteractiveCallBack;", "needReportAndGetBlockData", "blockUser", "rResponse", "Lcom/bilibili/okretro/GeneralResponse;", "dmContent", "isUpUser", "onComplete", "danmakuUserId", "sResponse", "toast", "message", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosDanmakuInteractiveWrapper {
    private String TAG = "ChronosDanmakuInteractiveWrapper";

    /* JADX WARN: Multi-variable type inference failed */
    public final void reportDanmaku(PlayerContainer playerContainer, String dmId, String oid, String reason, boolean shieldUser, String shieldUserId, OnInteractiveCallBack callBack, boolean needReportAndGetBlockData, boolean blockUser, GeneralResponse<String> generalResponse, String dmContent) {
        Video.DisplayParams displayParams;
        long cid;
        Ref.BooleanRef isReportAndBlockCompleted;
        long cid2;
        int i;
        Ref.BooleanRef isShiedUserCompleted;
        int i2;
        IRemoteHandler remoteHandler;
        String[] strArr;
        String fromSpmid;
        String spmid;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(dmId, "dmId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (oid == null || (longOrNull = StringsKt.toLongOrNull(oid)) == null) {
            Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
            if (currentPlayableParams != null && (displayParams = currentPlayableParams.getDisplayParams()) != null) {
                cid = displayParams.getCid();
            } else {
                return;
            }
        } else {
            cid = longOrNull.longValue();
        }
        Video.PlayableParams currentPlayableParams2 = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        Video.ReportCommonParams reportCommonParams = currentPlayableParams2 != null ? currentPlayableParams2.getReportCommonParams() : null;
        String spmid2 = (reportCommonParams == null || (spmid = reportCommonParams.getSpmid()) == null) ? "" : spmid;
        String fromSpmid2 = (reportCommonParams == null || (fromSpmid = reportCommonParams.getFromSpmid()) == null) ? "" : fromSpmid;
        Ref.BooleanRef isReportAndBlockCompleted2 = new Ref.BooleanRef();
        Ref.BooleanRef isShiedUserCompleted2 = new Ref.BooleanRef();
        Ref.ObjectRef reportAndGetBlockRegexResponse = new Ref.ObjectRef();
        Ref.ObjectRef shieldUserAndBlockResponse = new Ref.ObjectRef();
        if (shieldUser) {
            cid2 = cid;
            i = 1;
            isShiedUserCompleted = isShiedUserCompleted2;
            isReportAndBlockCompleted = isReportAndBlockCompleted2;
            reportDanmaku$shieldUserAndBlock(shieldUserId, shieldUserAndBlockResponse, isShiedUserCompleted2, generalResponse, isReportAndBlockCompleted2, this, playerContainer, shieldUser, dmId, reportAndGetBlockRegexResponse, callBack, playerContainer.getContext());
        } else {
            isReportAndBlockCompleted = isReportAndBlockCompleted2;
            cid2 = cid;
            i = 1;
            isShiedUserCompleted = isShiedUserCompleted2;
            isShiedUserCompleted.element = true;
        }
        if (needReportAndGetBlockData) {
            i2 = i;
            reportDanmaku$reportAndGetBlockData(cid2, spmid2, fromSpmid2, dmId, reason, shieldUser, reportAndGetBlockRegexResponse, isReportAndBlockCompleted, isShiedUserCompleted, this, playerContainer, shieldUserId, shieldUserAndBlockResponse, callBack, playerContainer.getContext());
        } else {
            boolean z = i;
            Ref.BooleanRef isReportAndBlockCompleted3 = isReportAndBlockCompleted;
            isReportAndBlockCompleted3.element = z;
            reportDanmaku$tryToDoComplete(isShiedUserCompleted, isReportAndBlockCompleted3, this, playerContainer, shieldUser, dmId, shieldUserId, reportAndGetBlockRegexResponse, shieldUserAndBlockResponse, callBack, generalResponse);
            i2 = z;
        }
        boolean isUpUser = isUpUser(playerContainer);
        if (blockUser) {
            IRemoteHandler remoteHandler2 = playerContainer.getInteractLayerService().getRemoteHandler();
            if (remoteHandler2 != null) {
                if (isUpUser) {
                    strArr = new String[i2];
                    strArr[0] = dmId;
                } else {
                    strArr = new String[0];
                }
                remoteHandler2.deleteDanmaku(strArr, new String[]{shieldUserId}, new String[]{dmContent != null ? dmContent : ""});
            }
        } else if (isUpUser && (remoteHandler = playerContainer.getInteractLayerService().getRemoteHandler()) != null) {
            IRemoteHandler.CC.deleteDanmaku$default(remoteHandler, new String[]{dmId}, null, new String[]{dmContent != null ? dmContent : ""}, 2, null);
        }
    }

    public static final void reportDanmaku$tryToDoComplete(Ref.BooleanRef isShiedUserCompleted, Ref.BooleanRef isReportAndBlockCompleted, ChronosDanmakuInteractiveWrapper this$0, PlayerContainer $playerContainer, boolean $shieldUser, String $dmId, String $shieldUserId, Ref.ObjectRef<GeneralResponse<String>> objectRef, Ref.ObjectRef<GeneralResponse<String>> objectRef2, OnInteractiveCallBack $callBack, GeneralResponse<String> generalResponse) {
        if (isShiedUserCompleted.element && isReportAndBlockCompleted.element) {
            this$0.onComplete($playerContainer, $shieldUser, $dmId, $shieldUserId, generalResponse == null ? (GeneralResponse) objectRef.element : generalResponse, (GeneralResponse) objectRef2.element, $callBack);
            isReportAndBlockCompleted.element = false;
            isShiedUserCompleted.element = false;
            objectRef.element = null;
            objectRef2.element = null;
        }
    }

    private static final void reportDanmaku$reportAndGetBlockData(long cid, String spmid, String fromSpmid, final String $dmId, String $reason, final boolean $shieldUser, final Ref.ObjectRef<GeneralResponse<String>> objectRef, final Ref.BooleanRef isReportAndBlockCompleted, final Ref.BooleanRef isShiedUserCompleted, final ChronosDanmakuInteractiveWrapper this$0, final PlayerContainer $playerContainer, final String $shieldUserId, final Ref.ObjectRef<GeneralResponse<String>> objectRef2, final OnInteractiveCallBack $callBack, Context context) {
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        String actionId = currentPolarisActionId;
        ((KeywordsBlockApiService) ServiceGenerator.createService(KeywordsBlockApiService.class)).report(BiliAccounts.get(context).getAccessKey(), cid, spmid, fromSpmid, $dmId, $reason, Boolean.valueOf($shieldUser), actionId).enqueue(new BiliApiCallback<GeneralResponse<String>>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuInteractiveWrapper$reportDanmaku$reportAndGetBlockData$1
            public void onSuccess(GeneralResponse<String> generalResponse) {
                Intrinsics.checkNotNullParameter(generalResponse, "result");
                objectRef.element = generalResponse;
                isReportAndBlockCompleted.element = true;
                ChronosDanmakuInteractiveWrapper.reportDanmaku$tryToDoComplete(isShiedUserCompleted, isReportAndBlockCompleted, this$0, $playerContainer, $shieldUser, $dmId, $shieldUserId, objectRef, objectRef2, $callBack, (r23 & 1024) != 0 ? null : null);
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                isReportAndBlockCompleted.element = true;
                ChronosDanmakuInteractiveWrapper.reportDanmaku$tryToDoComplete(isShiedUserCompleted, isReportAndBlockCompleted, this$0, $playerContainer, $shieldUser, $dmId, $shieldUserId, objectRef, objectRef2, $callBack, (r23 & 1024) != 0 ? null : null);
            }
        });
    }

    private static final void reportDanmaku$shieldUserAndBlock(final String $shieldUserId, final Ref.ObjectRef<GeneralResponse<String>> objectRef, final Ref.BooleanRef isShiedUserCompleted, final GeneralResponse<String> generalResponse, final Ref.BooleanRef isReportAndBlockCompleted, final ChronosDanmakuInteractiveWrapper this$0, final PlayerContainer $playerContainer, final boolean $shieldUser, final String $dmId, final Ref.ObjectRef<GeneralResponse<String>> objectRef2, final OnInteractiveCallBack $callBack, Context context) {
        ((KeywordsBlockApiService) ServiceGenerator.createService(KeywordsBlockApiService.class)).add(BiliAccounts.get(context).getAccessKey(), 2, $shieldUserId).enqueue(new BiliApiCallback<GeneralResponse<String>>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuInteractiveWrapper$reportDanmaku$shieldUserAndBlock$1
            public void onSuccess(GeneralResponse<String> generalResponse2) {
                Intrinsics.checkNotNullParameter(generalResponse2, "result");
                objectRef.element = generalResponse2;
                isShiedUserCompleted.element = true;
                ChronosDanmakuInteractiveWrapper.reportDanmaku$tryToDoComplete(isShiedUserCompleted, isReportAndBlockCompleted, this$0, $playerContainer, $shieldUser, $dmId, $shieldUserId, objectRef2, objectRef, $callBack, generalResponse);
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                isShiedUserCompleted.element = true;
                ChronosDanmakuInteractiveWrapper.reportDanmaku$tryToDoComplete(isShiedUserCompleted, isReportAndBlockCompleted, this$0, $playerContainer, $shieldUser, $dmId, $shieldUserId, objectRef2, objectRef, $callBack, (r23 & 1024) != 0 ? null : null);
            }
        });
    }

    private final boolean isUpUser(PlayerContainer playerContainer) {
        Video.DisplayParams displayParams;
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        long upMid = (currentPlayableParams == null || (displayParams = currentPlayableParams.getDisplayParams()) == null) ? 0L : displayParams.getMid();
        return upMid == BiliAccounts.get(FoundationAlias.getFapp()).mid();
    }

    private static final void onComplete$showReportWithoutShieldUserToast(GeneralResponse<String> generalResponse, ChronosDanmakuInteractiveWrapper this$0, PlayerContainer $playerContainer, Context context) {
        if (generalResponse != null) {
            String rResponseMessage = generalResponse.message;
            String str = rResponseMessage;
            if (!(str == null || StringsKt.isBlank(str))) {
                this$0.toast($playerContainer, rResponseMessage);
                return;
            }
            String string = context.getString(R.string.playerbaseres_global_string_2203);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this$0.toast($playerContainer, string);
            return;
        }
        String string2 = context.getString(R.string.playerbaseres_global_string_736);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this$0.toast($playerContainer, string2);
    }

    private static final String onComplete$shieldUser(String $danmakuUserId, boolean shieldSucceed) {
        if (shieldSucceed) {
            return $danmakuUserId;
        }
        return null;
    }

    private static final void onComplete$showReportAndShieldUserToast(GeneralResponse<String> generalResponse, GeneralResponse<String> generalResponse2, ChronosDanmakuInteractiveWrapper this$0, PlayerContainer $playerContainer, Context context, boolean reportSuccess, boolean shieldSuccess) {
        String msg = null;
        boolean z = false;
        if (shieldSuccess && !reportSuccess) {
            msg = generalResponse != null ? generalResponse.message : null;
            String str = msg;
            if (str == null || StringsKt.isBlank(str)) {
                z = true;
            }
            if (z) {
                msg = context.getString(R.string.playerbaseres_global_string_736);
            }
        } else if (!shieldSuccess && reportSuccess) {
            msg = generalResponse2 != null ? generalResponse2.message : null;
            String str2 = msg;
            if (str2 == null || StringsKt.isBlank(str2)) {
                z = true;
            }
            if (z) {
                msg = context.getString(R.string.playerbaseres_global_string_108);
            }
        } else if (!shieldSuccess && !reportSuccess) {
            msg = context.getString(bili.resource.common.R.string.common_global_string_90);
        } else if (shieldSuccess && reportSuccess) {
            msg = context.getString(bili.resource.common.R.string.common_global_string_106);
        }
        if (msg != null) {
            String it = msg;
            this$0.toast($playerContainer, it);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onComplete(PlayerContainer playerContainer, boolean shieldUser, String dmId, String danmakuUserId, GeneralResponse<String> generalResponse, GeneralResponse<String> generalResponse2, OnInteractiveCallBack callBack) {
        boolean z;
        boolean shieldSucceed;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Long nativeId;
        String it;
        String it2;
        BLog.i(this.TAG, ": onComplete.");
        boolean z2 = true;
        boolean reportSucceed = generalResponse != null && generalResponse.code == 0;
        boolean isOwner = isUpUser(playerContainer);
        Integer nativeType = null;
        if (isOwner) {
            if (!reportSucceed) {
                if (!(generalResponse != null && generalResponse.code == 36204)) {
                }
            }
            BLog.i(this.TAG, "delete danmaku: " + dmId + " after report, succeed: " + reportSucceed + ", code: " + (generalResponse != null ? Integer.valueOf(generalResponse.code) : null));
            IRemoteHandler remoteHandler = playerContainer.getInteractLayerService().getRemoteHandler();
            if (remoteHandler != null) {
                IRemoteHandler.CC.deleteDanmaku$default(remoteHandler, new String[]{dmId}, null, null, 6, null);
            }
        }
        if (shieldUser) {
            if (reportSucceed) {
                String str = generalResponse != null ? (String) generalResponse.data : null;
                if (!(str == null || str.length() == 0)) {
                    z = true;
                    boolean getBlockDataSucceed = z;
                    if (generalResponse2 != null || generalResponse2.code != 0) {
                        z2 = false;
                    }
                    shieldSucceed = z2;
                    if (generalResponse != null || (it2 = (String) generalResponse.data) == null) {
                        jSONObject = null;
                    } else {
                        jSONObject = JSONObject.parseObject(it2);
                    }
                    JSONObject jsonObj = jSONObject;
                    if (generalResponse2 != null || (it = (String) generalResponse2.data) == null) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = JSONObject.parseObject(it);
                    }
                    JSONObject shieldResponse = jSONObject2;
                    String blockRegex = (getBlockDataSucceed || jsonObj == null) ? null : jsonObj.getString("block");
                    if (!shieldSucceed) {
                        nativeId = shieldResponse != null ? shieldResponse.getLong("id") : null;
                    } else {
                        nativeId = 0L;
                    }
                    if (shieldSucceed) {
                        nativeType = 0;
                    } else if (shieldResponse != null) {
                        nativeType = shieldResponse.getInteger("type");
                    }
                    BLog.i(this.TAG, ": report with shield, blockRegex: " + blockRegex + ", nativeId: " + nativeId + ", nativeType: " + nativeType);
                    callBack.onReportDanmakuSuccess(blockRegex, onComplete$shieldUser(danmakuUserId, shieldSucceed), nativeId == null ? nativeId.longValue() : 0L, nativeType == null ? nativeType.intValue() : 0);
                    onComplete$showReportAndShieldUserToast(generalResponse, generalResponse2, this, playerContainer, playerContainer.getContext(), reportSucceed, shieldSucceed);
                    return;
                }
            }
            z = false;
            boolean getBlockDataSucceed2 = z;
            if (generalResponse2 != null) {
            }
            z2 = false;
            shieldSucceed = z2;
            if (generalResponse != null) {
            }
            jSONObject = null;
            JSONObject jsonObj2 = jSONObject;
            if (generalResponse2 != null) {
            }
            jSONObject2 = null;
            JSONObject shieldResponse2 = jSONObject2;
            String blockRegex2 = (getBlockDataSucceed2 || jsonObj2 == null) ? null : jsonObj2.getString("block");
            if (!shieldSucceed) {
            }
            if (shieldSucceed) {
            }
            BLog.i(this.TAG, ": report with shield, blockRegex: " + blockRegex2 + ", nativeId: " + nativeId + ", nativeType: " + nativeType);
            callBack.onReportDanmakuSuccess(blockRegex2, onComplete$shieldUser(danmakuUserId, shieldSucceed), nativeId == null ? nativeId.longValue() : 0L, nativeType == null ? nativeType.intValue() : 0);
            onComplete$showReportAndShieldUserToast(generalResponse, generalResponse2, this, playerContainer, playerContainer.getContext(), reportSucceed, shieldSucceed);
            return;
        }
        BLog.i(this.TAG, ": report without shield.");
        onComplete$showReportWithoutShieldUserToast(generalResponse, this, playerContainer, playerContainer.getContext());
    }

    private final void toast(PlayerContainer playerContainer, String message) {
        Context context = playerContainer.getContext();
        if (message.length() == 0) {
            return;
        }
        if (playerContainer.getControlContainerService().getScreenModeType() == ScreenModeType.THUMB) {
            ToastHelper.showToastShort(context, message);
            return;
        }
        PlayerToast toast = new PlayerToast.Builder().location(32).setExtraString(PlayerToastConfig.EXTRA_TITLE, message).toastItemType(17).duration(PlayerToastConfig.DURATION_5).build();
        playerContainer.getToastService().showToast(toast);
    }
}