package tv.danmaku.biliplayerv2.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import bolts.Task;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.commons.RandomUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.PageViewTracker;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.HttpException;
import retrofit2.Response;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.router.PlayerRouteUris;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItemFactory;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentParseException;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.utils.DanmakuSendHelper;
import tv.danmaku.biliplayerv2.widget.function.danmaku.api.DanmakuApiService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: DanmakuSendHelper.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003567B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005J*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\tJR\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\tJt\u0010$\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0002J0\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005J\u0016\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper;", "", "<init>", "()V", "ERROR_NEED_BIND_PHONE", "", "ERROR_NEED_LEGAL_PHONE", "MAX_INPUT_LENGTH", "FAKE_PREFIX", "", "onSendDanmakuSuccess", "", "context", "Landroid/content/Context;", "commentItem", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "getModeForReport", "mode", "onSendDanmakuFailed", "playerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "message", "authority", "", "onSendDanmakuReportResult", "code", "newType", "dmid", "toast", "hintMsg", "sendDanmaku", "danmakuMessage", "danmakuType", "danmakuSize", "danmakuColor", "parentDanmakuId", "onSend", "danmakuText", "playtime", "", "cid", "avid", "spmid", "fromSpmid", "parentDanmamkuId", "obtainDanmakuItem", "commentType", "playTimeMS", "textSize", "color", "signOut", "Lbolts/Task;", "Ljava/lang/Void;", "DanmakuSendResponse", "Colorful", "DanmakuSendRequestV2", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuSendHelper {
    public static final int ERROR_NEED_BIND_PHONE = 61001;
    public static final int ERROR_NEED_LEGAL_PHONE = 61002;
    public static final String FAKE_PREFIX = "fake-";
    public static final DanmakuSendHelper INSTANCE = new DanmakuSendHelper();
    public static final int MAX_INPUT_LENGTH = 100;

    private DanmakuSendHelper() {
    }

    public final void onSendDanmakuSuccess(Context context, CommentItem commentItem) {
        if (commentItem == null) {
            return;
        }
        commentItem.setDamakuSenderHash(BiliAccounts.get(context).mid());
    }

    public final String getModeForReport(int mode) {
        switch (mode) {
            case 1:
            case 6:
                return "3";
            case 2:
            case 3:
            default:
                return "-1";
            case 4:
                return "4";
            case 5:
                return "2";
        }
    }

    public final void onSendDanmakuFailed(IPlayerContainer playerContainer, String message, CommentItem commentItem, boolean authority) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        if (authority) {
            playerContainer.getPlayerCoreService().pause();
        }
        if (commentItem != null) {
            playerContainer.getInteractLayerService().blockDanmakuOnScreen(commentItem);
        }
        if (!TextUtils.isEmpty(message) && !authority) {
            toast(playerContainer, message);
        }
    }

    public static /* synthetic */ void onSendDanmakuReportResult$default(DanmakuSendHelper danmakuSendHelper, IPlayerContainer iPlayerContainer, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "";
        }
        danmakuSendHelper.onSendDanmakuReportResult(iPlayerContainer, str, str2, str3);
    }

    public final void onSendDanmakuReportResult(IPlayerContainer playerContainer, String code, String newType, String dmid) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(newType, "newType");
        Intrinsics.checkNotNullParameter(dmid, "dmid");
        playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_neuron_dm_send_send_result, "is_locked", "1", "new_ui", newType, "danmaku_type", "0", "code", code, "dmid", dmid));
    }

    public final void toast(IPlayerContainer playerContainer, String hintMsg) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        String str = hintMsg;
        if (str == null || str.length() == 0) {
            return;
        }
        PlayerToast toast = new PlayerToast.Builder().location(32).setExtraString(PlayerToastConfig.EXTRA_TITLE, hintMsg).toastItemType(17).duration(PlayerToastConfig.DURATION_5).build();
        playerContainer.getToastService().showToast(toast);
    }

    public final boolean sendDanmaku(IPlayerContainer playerContainer, Context context, String danmakuMessage, int danmakuType, int danmakuSize, int danmakuColor, String newType, String parentDanmakuId) {
        NeuronsEvents.NormalEvent reportEvent;
        String fromSpmid;
        String spmid;
        String replace$default;
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(newType, "newType");
        String message = (danmakuMessage == null || (replace$default = StringsKt.replace$default(danmakuMessage, "\r", "", false, 4, (Object) null)) == null) ? null : StringsKt.replace$default(replace$default, VideoFile.TREE_END, "", false, 4, (Object) null);
        if (TextUtils.isEmpty(message)) {
            toast(playerContainer, context != null ? context.getString(R.string.playerbaseres_global_string_586) : null);
            return false;
        }
        if ((message != null ? message.length() : 0) > 100) {
            toast(playerContainer, context != null ? context.getString(R.string.playerbaseres_global_string_804) : null);
            return false;
        }
        long playtime = playerContainer.getPlayerCoreService().getCurrentPosition();
        if (playtime < 0) {
            onSendDanmakuFailed(playerContainer, null, null, false);
            return true;
        }
        Intrinsics.checkNotNull(message);
        if (!Connectivity.isConnected(Connectivity.getActiveNetworkInfo(context != null ? context.getApplicationContext() : null))) {
            toast(playerContainer, context != null ? context.getString(bili.resource.common.R.string.common_global_string_250) : null);
            onSendDanmakuReportResult$default(this, playerContainer, "-1", newType, null, 8, null);
            return false;
        }
        Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        Video.DisplayParams params = playableParams != null ? playableParams.getDisplayParams() : null;
        Video.ReportCommonParams reportCommonParams = playableParams != null ? playableParams.getReportCommonParams() : null;
        onSend(playerContainer, context, message, danmakuType, danmakuSize, danmakuColor, playtime, params != null ? params.getCid() : 0L, params != null ? params.getAvid() : 0L, (reportCommonParams == null || (spmid = reportCommonParams.getSpmid()) == null) ? "" : spmid, (reportCommonParams == null || (fromSpmid = reportCommonParams.getFromSpmid()) == null) ? "" : fromSpmid, newType, parentDanmakuId);
        if (parentDanmakuId == null) {
            List eventParams = CollectionsKt.mutableListOf(new String[]{"is_locked", "1", "new_ui", newType, "msg", message, "mode", getModeForReport(danmakuType), "size", String.valueOf(danmakuSize), "color", String.valueOf(danmakuColor), "danmaku_type", "0"});
            String it = PageViewTracker.getInstance().currentPolarisActionId();
            if (it != null) {
                eventParams.add("action_id");
                eventParams.add(it);
            }
            List $this$toTypedArray$iv = eventParams;
            String[] strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            reportEvent = new NeuronsEvents.NormalEvent(EventId.player_neuron_dm_send_send, (String[]) Arrays.copyOf(strArr, strArr.length));
        } else {
            List eventParams2 = CollectionsKt.mutableListOf(new String[]{"msg", message, "mode", getModeForReport(danmakuType), "size", String.valueOf(danmakuSize), "color", String.valueOf(danmakuColor), "danmaku_type", "0", "r_dmid", parentDanmakuId});
            String it2 = PageViewTracker.getInstance().currentPolarisActionId();
            if (it2 != null) {
                eventParams2.add("action_id");
                eventParams2.add(it2);
            }
            List $this$toTypedArray$iv2 = eventParams2;
            String[] strArr2 = (String[]) $this$toTypedArray$iv2.toArray(new String[0]);
            reportEvent = new NeuronsEvents.NormalEvent(EventId.player_neuron_dm_send_send, (String[]) Arrays.copyOf(strArr2, strArr2.length));
        }
        playerContainer.getReporterService().report(reportEvent);
        return true;
    }

    private final void onSend(final IPlayerContainer playerContainer, final Context context, String danmakuText, int danmakuType, int danmakuSize, int danmakuColor, long playtime, long cid, long avid, String spmid, String fromSpmid, final String newType, String parentDanmamkuId) {
        Context finalContext = context != null ? context.getApplicationContext() : null;
        if (finalContext == null) {
            onSendDanmakuFailed(playerContainer, null, null, false);
            return;
        }
        final CommentItem commentItem = obtainDanmakuItem(danmakuType, danmakuText, playtime, danmakuSize, danmakuColor);
        if (commentItem != null) {
            commentItem.mSentFromMe = true;
        }
        String rnd = String.valueOf(RandomUtils.nextInt());
        HashMap params = new HashMap();
        params.put("type", "1");
        params.put("oid", String.valueOf(cid));
        params.put("progress", String.valueOf(playtime));
        params.put("color", String.valueOf(danmakuColor));
        params.put("msg", danmakuText);
        params.put("fontsize", String.valueOf(danmakuSize));
        params.put("mode", String.valueOf(danmakuType));
        params.put("pool", "0");
        params.put("plat", "2");
        if (!TextUtils.isEmpty(rnd)) {
            params.put("rnd", rnd);
        }
        if (!TextUtils.isEmpty(parentDanmamkuId)) {
            Intrinsics.checkNotNull(parentDanmamkuId);
            params.put("parent_id", parentDanmamkuId);
        }
        String it = PageViewTracker.getInstance().currentPolarisActionId();
        if (it != null) {
            params.put("action_id", it);
        }
        if (commentItem != null) {
            commentItem.mRemoteDmId = FAKE_PREFIX + System.currentTimeMillis();
        }
        String accessKey = "";
        if (BiliAccounts.get(context).isLogin() && !TextUtils.isEmpty(BiliAccounts.get(context).getAccessKey()) && BiliAccounts.get(context).mid() != 0) {
            String accessKey2 = BiliAccounts.get(context).getAccessKey();
            Intrinsics.checkNotNullExpressionValue(accessKey2, "getAccessKey(...)");
            accessKey = accessKey2;
        }
        ((DanmakuApiService) ServiceGenerator.createService(DanmakuApiService.class)).sendDanmaku(accessKey, avid, cid, spmid, fromSpmid, params).enqueue(new BiliApiDataCallback<DanmakuSendResponse>() { // from class: tv.danmaku.biliplayerv2.utils.DanmakuSendHelper$onSend$2
            public void onDataSuccess(DanmakuSendHelper.DanmakuSendResponse data) {
                Long dmid;
                CommentItem commentItem2 = CommentItem.this;
                if (commentItem2 != null) {
                    commentItem2.mRemoteDmId = data != null ? data.getDmidStr() : null;
                }
                CommentItem commentItem3 = CommentItem.this;
                if (commentItem3 != null) {
                    commentItem3.action = data != null ? data.getAction() : null;
                }
                if (data != null ? Intrinsics.areEqual(data.getVisible(), true) : false) {
                    DanmakuSendHelper.INSTANCE.onSendDanmakuSuccess(context, CommentItem.this);
                } else {
                    PlayerLog.w(PlayerContainerKt.TAG, "danmaku send success, but server say that it is not visible");
                }
                DanmakuSendHelper.INSTANCE.onSendDanmakuReportResult(playerContainer, "0", newType, (data == null || (dmid = data.getDmid()) == null || (r3 = String.valueOf(dmid.longValue())) == null) ? "" : "");
            }

            public void onError(Throwable t) {
                Response response;
                Intrinsics.checkNotNullParameter(t, "t");
                int code = -1;
                String errorMsg = context.getString(R.string.playerbaseres_global_string_467);
                Intrinsics.checkNotNullExpressionValue(errorMsg, "getString(...)");
                HttpException httpException = t instanceof HttpException ? (HttpException) t : null;
                if ((httpException == null || (response = httpException.response()) == null || response.code() != 500) ? false : true) {
                    errorMsg = "";
                }
                if (t instanceof SocketTimeoutException) {
                    String string = context.getString(R.string.playerbaseres_global_string_1327);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    errorMsg = string;
                }
                if (t instanceof BiliApiException) {
                    code = ((BiliApiException) t).mCode;
                    String message = t.getMessage();
                    if (message == null) {
                        message = errorMsg;
                    }
                    errorMsg = message;
                    switch (code) {
                        case DanmakuSendHelper.ERROR_NEED_BIND_PHONE /* 61001 */:
                        case DanmakuSendHelper.ERROR_NEED_LEGAL_PHONE /* 61002 */:
                            PlayerRouteUris.Routers.INSTANCE.gotoAuthority(context, code, errorMsg);
                            DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, errorMsg, CommentItem.this, true);
                            DanmakuSendHelper.onSendDanmakuReportResult$default(DanmakuSendHelper.INSTANCE, playerContainer, String.valueOf(code), newType, null, 8, null);
                            return;
                        default:
                            switch (code) {
                                case -101:
                                case -2:
                                    DanmakuSendHelper.INSTANCE.signOut(context);
                                    String string2 = context.getString(R.string.playerbaseres_global_string_906);
                                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                    errorMsg = string2;
                                    break;
                            }
                    }
                }
                DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, errorMsg, null, false);
                DanmakuSendHelper.onSendDanmakuReportResult$default(DanmakuSendHelper.INSTANCE, playerContainer, String.valueOf(code), newType, null, 8, null);
            }
        });
    }

    public final CommentItem obtainDanmakuItem(int commentType, String message, long playTimeMS, int textSize, int color) {
        Intrinsics.checkNotNullParameter(message, "message");
        CommentItem item = CommentItemFactory.createComment(commentType);
        try {
            Intrinsics.checkNotNull(item);
            item.setTimeInMilliSeconds(playTimeMS);
            item.setBody(message);
            item.setSize(textSize);
            item.setTextColor(color);
            return item;
        } catch (CommentParseException e) {
            PlayerLog.d(PlayerContainerKt.TAG, "Comment parse error:" + e.getMessage());
            return null;
        }
    }

    /* compiled from: DanmakuSendHelper.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003Jb\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020.HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006?"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendResponse;", "Landroid/os/Parcelable;", "dmid", "", "dmidStr", "", "visible", "", "action", "animation", "dmContent", "colorful", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDmid", "()Ljava/lang/Long;", "setDmid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDmidStr", "()Ljava/lang/String;", "setDmidStr", "(Ljava/lang/String;)V", "getVisible", "()Ljava/lang/Boolean;", "setVisible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAction", "setAction", "getAnimation", "setAnimation", "getDmContent", "setDmContent", "getColorful", "()Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "setColorful", "(Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;)V", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;)Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendResponse;", "equals", "other", "", "hashCode", "toString", "CREATOR", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuSendResponse implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = "action")
        private String action;
        @JSONField(name = "animation")
        private String animation;
        @JSONField(name = "colorful_src")
        private Colorful colorful;
        @JSONField(name = "dm_content")
        private String dmContent;
        @JSONField(name = "dmid")
        private Long dmid;
        @JSONField(name = "dmid_str")
        private String dmidStr;
        @JSONField(name = "visible")
        private Boolean visible;

        public DanmakuSendResponse() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ DanmakuSendResponse copy$default(DanmakuSendResponse danmakuSendResponse, Long l, String str, Boolean bool, String str2, String str3, String str4, Colorful colorful, int i, Object obj) {
            if ((i & 1) != 0) {
                l = danmakuSendResponse.dmid;
            }
            if ((i & 2) != 0) {
                str = danmakuSendResponse.dmidStr;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                bool = danmakuSendResponse.visible;
            }
            Boolean bool2 = bool;
            if ((i & 8) != 0) {
                str2 = danmakuSendResponse.action;
            }
            String str6 = str2;
            if ((i & 16) != 0) {
                str3 = danmakuSendResponse.animation;
            }
            String str7 = str3;
            if ((i & 32) != 0) {
                str4 = danmakuSendResponse.dmContent;
            }
            String str8 = str4;
            if ((i & 64) != 0) {
                colorful = danmakuSendResponse.colorful;
            }
            return danmakuSendResponse.copy(l, str5, bool2, str6, str7, str8, colorful);
        }

        public final Long component1() {
            return this.dmid;
        }

        public final String component2() {
            return this.dmidStr;
        }

        public final Boolean component3() {
            return this.visible;
        }

        public final String component4() {
            return this.action;
        }

        public final String component5() {
            return this.animation;
        }

        public final String component6() {
            return this.dmContent;
        }

        public final Colorful component7() {
            return this.colorful;
        }

        public final DanmakuSendResponse copy(Long l, String str, Boolean bool, String str2, String str3, String str4, Colorful colorful) {
            return new DanmakuSendResponse(l, str, bool, str2, str3, str4, colorful);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DanmakuSendResponse) {
                DanmakuSendResponse danmakuSendResponse = (DanmakuSendResponse) obj;
                return Intrinsics.areEqual(this.dmid, danmakuSendResponse.dmid) && Intrinsics.areEqual(this.dmidStr, danmakuSendResponse.dmidStr) && Intrinsics.areEqual(this.visible, danmakuSendResponse.visible) && Intrinsics.areEqual(this.action, danmakuSendResponse.action) && Intrinsics.areEqual(this.animation, danmakuSendResponse.animation) && Intrinsics.areEqual(this.dmContent, danmakuSendResponse.dmContent) && Intrinsics.areEqual(this.colorful, danmakuSendResponse.colorful);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.dmid == null ? 0 : this.dmid.hashCode()) * 31) + (this.dmidStr == null ? 0 : this.dmidStr.hashCode())) * 31) + (this.visible == null ? 0 : this.visible.hashCode())) * 31) + (this.action == null ? 0 : this.action.hashCode())) * 31) + (this.animation == null ? 0 : this.animation.hashCode())) * 31) + (this.dmContent == null ? 0 : this.dmContent.hashCode())) * 31) + (this.colorful != null ? this.colorful.hashCode() : 0);
        }

        public String toString() {
            Long l = this.dmid;
            String str = this.dmidStr;
            Boolean bool = this.visible;
            String str2 = this.action;
            String str3 = this.animation;
            String str4 = this.dmContent;
            return "DanmakuSendResponse(dmid=" + l + ", dmidStr=" + str + ", visible=" + bool + ", action=" + str2 + ", animation=" + str3 + ", dmContent=" + str4 + ", colorful=" + this.colorful + ")";
        }

        public DanmakuSendResponse(Long dmid, String dmidStr, Boolean visible, String action, String animation, String dmContent, Colorful colorful) {
            this.dmid = dmid;
            this.dmidStr = dmidStr;
            this.visible = visible;
            this.action = action;
            this.animation = animation;
            this.dmContent = dmContent;
            this.colorful = colorful;
        }

        public /* synthetic */ DanmakuSendResponse(Long l, String str, Boolean bool, String str2, String str3, String str4, Colorful colorful, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : colorful);
        }

        public final Long getDmid() {
            return this.dmid;
        }

        public final void setDmid(Long l) {
            this.dmid = l;
        }

        public final String getDmidStr() {
            return this.dmidStr;
        }

        public final void setDmidStr(String str) {
            this.dmidStr = str;
        }

        public final Boolean getVisible() {
            return this.visible;
        }

        public final void setVisible(Boolean bool) {
            this.visible = bool;
        }

        public final String getAction() {
            return this.action;
        }

        public final void setAction(String str) {
            this.action = str;
        }

        public final String getAnimation() {
            return this.animation;
        }

        public final void setAnimation(String str) {
            this.animation = str;
        }

        public final String getDmContent() {
            return this.dmContent;
        }

        public final void setDmContent(String str) {
            this.dmContent = str;
        }

        public final Colorful getColorful() {
            return this.colorful;
        }

        public final void setColorful(Colorful colorful) {
            this.colorful = colorful;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DanmakuSendResponse(Parcel parcel) {
            this(Long.valueOf(parcel.readLong()), parcel.readString(), Boolean.valueOf(parcel.readInt() == 1), parcel.readString(), parcel.readString(), parcel.readString(), (Colorful) parcel.readParcelable(Colorful.class.getClassLoader()));
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            Long l = this.dmid;
            dest.writeLong(l != null ? l.longValue() : 0L);
            dest.writeString(this.dmidStr);
            dest.writeInt(Intrinsics.areEqual(this.visible, true) ? 1 : 0);
            dest.writeString(this.action);
            dest.writeString(this.animation);
            dest.writeString(this.dmContent);
            dest.writeParcelable(this.colorful, flags);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DanmakuSendHelper.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendResponse;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendResponse;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class CREATOR implements Parcelable.Creator<DanmakuSendResponse> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public DanmakuSendResponse createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DanmakuSendResponse(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DanmakuSendResponse[] newArray(int size) {
                return new DanmakuSendResponse[size];
            }
        }
    }

    /* compiled from: DanmakuSendHelper.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType", "()Ljava/lang/Long;", "setType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "src", "", "getSrc", "()Ljava/lang/String;", "setSrc", "(Ljava/lang/String;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Colorful implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        @JSONField(name = "src")
        private String src;
        @JSONField(name = "type")
        private Long type;

        public Colorful() {
        }

        public final Long getType() {
            return this.type;
        }

        public final void setType(Long l) {
            this.type = l;
        }

        public final String getSrc() {
            return this.src;
        }

        public final void setSrc(String str) {
            this.src = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Colorful(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.type = Long.valueOf(parcel.readLong());
            this.src = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long l = this.type;
            parcel.writeLong(l != null ? l.longValue() : 0L);
            parcel.writeString(this.src);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: DanmakuSendHelper.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class CREATOR implements Parcelable.Creator<Colorful> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public Colorful createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Colorful(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Colorful[] newArray(int size) {
                return new Colorful[size];
            }
        }
    }

    /* compiled from: DanmakuSendHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2;", "", "<init>", "()V", LoginSceneProcessor.SCENE_KEY, "", "getScene", "()J", "setScene", "(J)V", "postType", "getPostType", "setPostType", "text", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Text;", "getText", "()Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Text;", "setText", "(Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Text;)V", "cmd", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Cmd;", "getCmd", "()Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Cmd;", "setCmd", "(Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Cmd;)V", "Text", "Cmd", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuSendRequestV2 {
        @JSONField(name = "cmd")
        private Cmd cmd;
        @JSONField(name = "post_type")
        private long postType;
        @JSONField(name = LoginSceneProcessor.SCENE_KEY)
        private long scene;
        @JSONField(name = "text")
        private Text text;

        public final long getScene() {
            return this.scene;
        }

        public final void setScene(long j) {
            this.scene = j;
        }

        public final long getPostType() {
            return this.postType;
        }

        public final void setPostType(long j) {
            this.postType = j;
        }

        public final Text getText() {
            return this.text;
        }

        public final void setText(Text text) {
            this.text = text;
        }

        public final Cmd getCmd() {
            return this.cmd;
        }

        public final void setCmd(Cmd cmd) {
            this.cmd = cmd;
        }

        /* compiled from: DanmakuSendHelper.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b8\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001e\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001e\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\"\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\"\u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b;\u00103\"\u0004\b<\u00105R \u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R \u0010@\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R \u0010C\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012¨\u0006F"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Text;", "", "<init>", "()V", "type", "", "getType", "()J", "setType", "(J)V", "oid", "getOid", "setOid", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "aid", "getAid", "setAid", "bvid", "getBvid", "setBvid", "progress", "getProgress", "setProgress", "color", "getColor", "setColor", "fontSize", "getFontSize", "setFontSize", "pool", "getPool", "setPool", "mode", "getMode", "setMode", "rnd", "getRnd", "setRnd", "plat", "getPlat", "setPlat", "checkboxType", "getCheckboxType", "setCheckboxType", "teenagersMode", "getTeenagersMode", "()Ljava/lang/Long;", "setTeenagersMode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "build", "getBuild", "setBuild", "parentId", "getParentId", "setParentId", "mobiApp", "getMobiApp", "setMobiApp", "devidce", "getDevidce", "setDevidce", "actionId", "getActionId", "setActionId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Text {
            @JSONField(name = "action_id")
            private String actionId;
            @JSONField(name = "aid")
            private long aid;
            @JSONField(name = "build")
            private Long build;
            @JSONField(name = "bvid")
            private String bvid;
            @JSONField(name = "checkbox_type")
            private long checkboxType;
            @JSONField(name = "color")
            private long color;
            @JSONField(name = "device")
            private String devidce;
            @JSONField(name = "fontsize")
            private long fontSize;
            @JSONField(name = "mobi_app")
            private String mobiApp;
            @JSONField(name = "mode")
            private long mode;
            @JSONField(name = "msg")
            private String msg = "";
            @JSONField(name = "oid")
            private long oid;
            @JSONField(name = "parent_id")
            private Long parentId;
            @JSONField(name = "plat")
            private long plat;
            @JSONField(name = "pool")
            private long pool;
            @JSONField(name = "progress")
            private long progress;
            @JSONField(name = "rnd")
            private long rnd;
            @JSONField(name = "teenagers_mode")
            private Long teenagersMode;
            @JSONField(name = "type")
            private long type;

            public final long getType() {
                return this.type;
            }

            public final void setType(long j) {
                this.type = j;
            }

            public final long getOid() {
                return this.oid;
            }

            public final void setOid(long j) {
                this.oid = j;
            }

            public final String getMsg() {
                return this.msg;
            }

            public final void setMsg(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.msg = str;
            }

            public final long getAid() {
                return this.aid;
            }

            public final void setAid(long j) {
                this.aid = j;
            }

            public final String getBvid() {
                return this.bvid;
            }

            public final void setBvid(String str) {
                this.bvid = str;
            }

            public final long getProgress() {
                return this.progress;
            }

            public final void setProgress(long j) {
                this.progress = j;
            }

            public final long getColor() {
                return this.color;
            }

            public final void setColor(long j) {
                this.color = j;
            }

            public final long getFontSize() {
                return this.fontSize;
            }

            public final void setFontSize(long j) {
                this.fontSize = j;
            }

            public final long getPool() {
                return this.pool;
            }

            public final void setPool(long j) {
                this.pool = j;
            }

            public final long getMode() {
                return this.mode;
            }

            public final void setMode(long j) {
                this.mode = j;
            }

            public final long getRnd() {
                return this.rnd;
            }

            public final void setRnd(long j) {
                this.rnd = j;
            }

            public final long getPlat() {
                return this.plat;
            }

            public final void setPlat(long j) {
                this.plat = j;
            }

            public final long getCheckboxType() {
                return this.checkboxType;
            }

            public final void setCheckboxType(long j) {
                this.checkboxType = j;
            }

            public final Long getTeenagersMode() {
                return this.teenagersMode;
            }

            public final void setTeenagersMode(Long l) {
                this.teenagersMode = l;
            }

            public final Long getBuild() {
                return this.build;
            }

            public final void setBuild(Long l) {
                this.build = l;
            }

            public final Long getParentId() {
                return this.parentId;
            }

            public final void setParentId(Long l) {
                this.parentId = l;
            }

            public final String getMobiApp() {
                return this.mobiApp;
            }

            public final void setMobiApp(String str) {
                this.mobiApp = str;
            }

            public final String getDevidce() {
                return this.devidce;
            }

            public final void setDevidce(String str) {
                this.devidce = str;
            }

            public final String getActionId() {
                return this.actionId;
            }

            public final void setActionId(String str) {
                this.actionId = str;
            }
        }

        /* compiled from: DanmakuSendHelper.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001a¨\u0006%"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$DanmakuSendRequestV2$Cmd;", "", "<init>", "()V", "type", "", "getType", "()J", "setType", "(J)V", "aid", "getAid", "setAid", "cid", "getCid", "setCid", "progress", "getProgress", "setProgress", "plat", "getPlat", "setPlat", "build", "getBuild", "()Ljava/lang/Long;", "setBuild", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "data", "", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "dmid", "getDmid", "setDmid", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Cmd {
            @JSONField(name = "aid")
            private long aid;
            @JSONField(name = "build")
            private Long build;
            @JSONField(name = "cid")
            private long cid;
            @JSONField(name = "data")
            private String data = "";
            @JSONField(name = "dmid")
            private Long dmid;
            @JSONField(name = "plat")
            private long plat;
            @JSONField(name = "progress")
            private long progress;
            @JSONField(name = "type")
            private long type;

            public final long getType() {
                return this.type;
            }

            public final void setType(long j) {
                this.type = j;
            }

            public final long getAid() {
                return this.aid;
            }

            public final void setAid(long j) {
                this.aid = j;
            }

            public final long getCid() {
                return this.cid;
            }

            public final void setCid(long j) {
                this.cid = j;
            }

            public final long getProgress() {
                return this.progress;
            }

            public final void setProgress(long j) {
                this.progress = j;
            }

            public final long getPlat() {
                return this.plat;
            }

            public final void setPlat(long j) {
                this.plat = j;
            }

            public final Long getBuild() {
                return this.build;
            }

            public final void setBuild(Long l) {
                this.build = l;
            }

            public final String getData() {
                return this.data;
            }

            public final void setData(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.data = str;
            }

            public final Long getDmid() {
                return this.dmid;
            }

            public final void setDmid(Long l) {
                this.dmid = l;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Task<Void> signOut(final Context context) {
        Task<Void> callInBackground = Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.utils.DanmakuSendHelper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void signOut$lambda$0;
                signOut$lambda$0 = DanmakuSendHelper.signOut$lambda$0(context);
                return signOut$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(callInBackground, "callInBackground(...)");
        return callInBackground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void signOut$lambda$0(Context $context) {
        BiliAccounts.get($context).logout("DanmakuSendHelper_signOut");
        return null;
    }
}