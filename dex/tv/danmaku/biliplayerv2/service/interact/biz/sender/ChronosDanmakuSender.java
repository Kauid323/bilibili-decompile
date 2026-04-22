package tv.danmaku.biliplayerv2.service.interact.biz.sender;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import bolts.Task;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.bson.dsl.JsonObjectBuilder;
import com.bilibili.commons.RandomUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.util.Objects;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.pvtracker.PageViewTracker;
import com.google.gson.JsonObject;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.HttpException;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.router.PlayerRouteUris;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiService;
import tv.danmaku.biliplayerv2.service.interact.core.sender.DanmakuSendParams;
import tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.utils.DanmakuSendHelper;
import tv.danmaku.biliplayerv2.widget.function.danmaku.api.DanmakuApiService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: ChronosDanmakuSender.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J1\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011Jc\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u001bJL\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001dj\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015`\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J8\u0010 \u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J,\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001dj\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015`\u001e2\u0006\u0010\f\u001a\u00020\rH\u0002J6\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001dj\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015`\u001eH\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\n\u001a\u00020\u000bH\u0002JE\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002000/2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u00101J1\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010.\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u00103JE\u00104\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002000/2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00105J?\u00106\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u00107\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u00010\u00102\u0006\u0010,\u001a\u00020-2\u0006\u00109\u001a\u00020:H\u0002¢\u0006\u0002\u0010;J*\u0010<\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010=\u001a\u00020-2\b\b\u0002\u0010>\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender;", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/IDanmakuSender;", "mCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$Callback;", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$Callback;)V", "send", "", "playerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "context", "Landroid/content/Context;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "sendV2", LoginSceneProcessor.SCENE_KEY, "", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;Ljava/lang/Long;)Z", "onSend", "", "danmakuText", "", "playtime", "cid", "avid", "spmid", "fromSpmid", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "createSendParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "rnd", "createSendParamsV2", "createSendParamsMapV2", "dispatchDanmakuSendSuccess", "commentItem", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "dispatchCommandDanmakuSendSuccess", "commandDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$CommandDanmakuSendResponse;", "signOut", "Lbolts/Task;", "Ljava/lang/Void;", "sendCommandDanmaku", "type", "", "content", "", "", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;ILjava/util/Map;Ljava/lang/Long;)Z", "sendUpDanmaku", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)Z", "onSendCommandDanmaku", "(Landroid/content/Context;Ltv/danmaku/biliplayerv2/IPlayerContainer;ILjava/util/Map;Ljava/lang/Long;)Z", "createSendCommandParams", "plat", "progress", "data", "Lcom/alibaba/fastjson/JSONObject;", "(JJILjava/lang/Long;ILcom/alibaba/fastjson/JSONObject;)Ljava/lang/String;", "onSendCommandDanmakuReportResult", "code", "dmid", "Companion", "Callback", "CommandDanmakuSendResponse", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosDanmakuSender implements IDanmakuSender {
    public static final String COMMAND_DANMAKU_FOLLOW = "#ATTENTION#";
    public static final String COMMAND_DANMAKU_MARK = "#GOODSLIKE#";
    public static final String COMMAND_DANMAKU_MARK_VOTE = "#GOODSLIKEVOTE#";
    public static final String COMMAND_DANMAKU_RELEVANT = "#LINK#";
    public static final String COMMAND_DANMAKU_SCORE = "#GRADE#";
    public static final String COMMAND_DANMAKU_VOTE = "#VOTE#";
    private static final int COMMAND_MAX_LENGTH = 300;
    public static final int COMMAND_TYPE_COMMERCIAL_TIME = 20;
    public static final int COMMAND_TYPE_FOLLOW = 5;
    public static final int COMMAND_TYPE_MARK = 18;
    public static final int COMMAND_TYPE_MARK_VOTE = 19;
    public static final int COMMAND_TYPE_RELEVANT = 2;
    public static final int COMMAND_TYPE_SCORE = 11;
    public static final int COMMAND_TYPE_VOTE = 9;
    public static final Companion Companion = new Companion(null);
    public static final String KEY_AUTO_CREATE = "auto_create";
    public static final String KEY_CMTIME_END = "end_time";
    public static final String KEY_CMTIME_ID = "material_id";
    public static final String KEY_CMTIME_START = "start_time";
    public static final String KEY_CMTIME_TYPE = "cmtime_type";
    public static final String KEY_CMTIME_UP_SLOGAN = "up_slogan";
    public static final String KEY_CMTIME_USER_REPLY = "dm_key_word";
    public static final String KEY_COUNT_DOWN = "count_down";
    public static final String KEY_FUNCTION_TYPE = "type";
    public static final String KEY_MARK_DANMAKU = "keyword";
    public static final String KEY_MARK_GOODS_ID_STR = "item_id_str";
    public static final String KEY_UPOWER_OPEN = "upower_open";
    public static final String KEY_VOTE_CUSTOM = "has_self_def";
    public static final String KEY_VOTE_OPTIONA = "optionA";
    public static final String KEY_VOTE_OPTIONB = "optionB";
    public static final String KEY_VOTE_OPTIONC = "optionC";
    public static final String KEY_VOTE_OPTIOND = "optionD";
    public static final String KEY_VOTE_QUESTION = "question";
    public static final String KEY_VOTE_TYPE = "vote_type";
    private static final String TAG = "ChronosDanmakuSender";
    private final Callback mCallback;

    /* compiled from: ChronosDanmakuSender.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$Callback;", "", "onDanmakuSendSuccess", "", "commentItem", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onCommandDanmakuSentSuccess", "commandDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$CommandDanmakuSendResponse;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Callback {
        void onCommandDanmakuSentSuccess(CommandDanmakuSendResponse commandDanmakuSendResponse);

        void onDanmakuSendSuccess(CommentItem commentItem, HashMap<String, String> hashMap);
    }

    public ChronosDanmakuSender(Callback mCallback) {
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.mCallback = mCallback;
    }

    /* compiled from: ChronosDanmakuSender.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$Companion;", "", "<init>", "()V", "COMMAND_MAX_LENGTH", "", "TAG", "", "COMMAND_TYPE_RELEVANT", "COMMAND_TYPE_FOLLOW", "COMMAND_TYPE_VOTE", "COMMAND_TYPE_SCORE", "COMMAND_TYPE_MARK", "COMMAND_TYPE_MARK_VOTE", "COMMAND_TYPE_COMMERCIAL_TIME", "KEY_AUTO_CREATE", "KEY_COUNT_DOWN", "KEY_UPOWER_OPEN", "KEY_FUNCTION_TYPE", "KEY_MARK_DANMAKU", "KEY_MARK_GOODS_ID_STR", "KEY_VOTE_QUESTION", "KEY_VOTE_OPTIONA", "KEY_VOTE_OPTIONB", "KEY_VOTE_OPTIONC", "KEY_VOTE_OPTIOND", "KEY_VOTE_CUSTOM", "KEY_VOTE_TYPE", "KEY_CMTIME_START", "KEY_CMTIME_END", "KEY_CMTIME_UP_SLOGAN", "KEY_CMTIME_USER_REPLY", "KEY_CMTIME_TYPE", "KEY_CMTIME_ID", "COMMAND_DANMAKU_RELEVANT", "COMMAND_DANMAKU_FOLLOW", "COMMAND_DANMAKU_VOTE", "COMMAND_DANMAKU_SCORE", "COMMAND_DANMAKU_MARK", "COMMAND_DANMAKU_MARK_VOTE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean send(IPlayerContainer playerContainer, Context context, DanmakuSendParams params) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(params, "params");
        return sendV2(playerContainer, context, params, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean sendV2(IPlayerContainer playerContainer, Context context, DanmakuSendParams params, Long scene) {
        String str;
        Object[] objArr;
        String fromSpmid;
        String spmid;
        String replace$default;
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(params, "params");
        String danmaku = params.getDanmaku();
        String message = (danmaku == null || (replace$default = StringsKt.replace$default(danmaku, "\r", "", false, 4, (Object) null)) == null) ? null : StringsKt.replace$default(replace$default, VideoFile.TREE_END, "", false, 4, (Object) null);
        if (TextUtils.isEmpty(message)) {
            DanmakuSendHelper.INSTANCE.toast(playerContainer, context != null ? context.getString(R.string.playerbaseres_global_string_586) : null);
            return false;
        }
        if ((message != null ? message.length() : 0) > 100) {
            DanmakuSendHelper.INSTANCE.toast(playerContainer, context != null ? context.getString(R.string.playerbaseres_global_string_804) : null);
            return false;
        }
        long playtime = params.getPosition();
        if (playtime < 0) {
            DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, null, null, false);
            return true;
        }
        Intrinsics.checkNotNull(message);
        if (!Connectivity.isConnected(Connectivity.getActiveNetworkInfo(context != null ? context.getApplicationContext() : null))) {
            DanmakuSendHelper.INSTANCE.toast(playerContainer, context != null ? context.getString(bili.resource.common.R.string.common_global_string_250) : null);
            DanmakuSendHelper.onSendDanmakuReportResult$default(DanmakuSendHelper.INSTANCE, playerContainer, "-1", params.getNewType(), null, 8, null);
            return false;
        }
        Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        long avid = params.getAvid();
        long cid = params.getCid();
        Video.ReportCommonParams reportParams = playableParams != null ? playableParams.getReportCommonParams() : null;
        onSend(playerContainer, context, message, params, playtime, cid, avid, (reportParams == null || (spmid = reportParams.getSpmid()) == null) ? "" : spmid, (reportParams == null || (fromSpmid = reportParams.getFromSpmid()) == null) ? "" : fromSpmid, scene);
        String newType = params.getNewType();
        String modeForReport = DanmakuSendHelper.INSTANCE.getModeForReport(params.getDanmakuType());
        String valueOf = String.valueOf(params.getDanmakuSize());
        String valueOf2 = String.valueOf(params.getDanmakuColor());
        if (params.isCheerTime()) {
            str = "1";
        } else {
            str = "0";
        }
        ArrayList stringList = CollectionsKt.arrayListOf(new String[]{"is_locked", "1", "new_ui", newType, "msg", message, "mode", modeForReport, "size", valueOf, "color", valueOf2, "danmaku_type", "0", "is_cheer_time", str});
        String rDanmakuId = params.getParentDanmakuId();
        if (rDanmakuId != null) {
            stringList.add("r_dmid");
            stringList.add(rDanmakuId);
        }
        stringList.add("is_cheer_time");
        if (params.isCheerTime()) {
            objArr = "1";
        } else {
            objArr = "0";
        }
        stringList.add(objArr);
        Boolean checkboxChecked = params.getCheerCheckbox();
        if (checkboxChecked != null) {
            stringList.add("cheer_checkbox");
            stringList.add(checkboxChecked.booleanValue() ? "1" : "0");
        }
        String it = PageViewTracker.getInstance().currentPolarisActionId();
        if (it != null) {
            stringList.add("scm_action_id");
            stringList.add(it);
        }
        IReporterService reporterService = playerContainer.getReporterService();
        ArrayList $this$toTypedArray$iv = stringList;
        String[] strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        reporterService.report(new NeuronsEvents.NormalEvent(EventId.player_neuron_dm_send_send, (String[]) Arrays.copyOf(strArr, strArr.length)));
        return true;
    }

    static /* synthetic */ void onSend$default(ChronosDanmakuSender chronosDanmakuSender, IPlayerContainer iPlayerContainer, Context context, String str, DanmakuSendParams danmakuSendParams, long j, long j2, long j3, String str2, String str3, Long l, int i, Object obj) {
        Long l2;
        if ((i & 512) == 0) {
            l2 = l;
        } else {
            l2 = null;
        }
        chronosDanmakuSender.onSend(iPlayerContainer, context, str, danmakuSendParams, j, j2, j3, str2, str3, l2);
    }

    private final void onSend(final IPlayerContainer playerContainer, final Context context, final String danmakuText, final DanmakuSendParams params, long playtime, long cid, long avid, String spmid, String fromSpmid, Long scene) {
        String accessKey;
        BiliCall sendDanmakuV2$default;
        Context finalContext = context != null ? context.getApplicationContext() : null;
        if (finalContext == null) {
            DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, null, null, false);
            return;
        }
        final CommentItem commentItem = DanmakuSendHelper.INSTANCE.obtainDanmakuItem(params.getDanmakuType(), danmakuText, playtime, params.getDanmakuSize(), params.getDanmakuColor());
        if (commentItem != null) {
            commentItem.mSentFromMe = true;
        }
        if (commentItem != null) {
            commentItem.cid = cid;
        }
        String rnd = String.valueOf(RandomUtils.nextInt());
        if (commentItem != null) {
            commentItem.mRemoteDmId = DanmakuSendHelper.FAKE_PREFIX + System.currentTimeMillis();
        }
        if (!BiliAccounts.get(context).isLogin() || TextUtils.isEmpty(BiliAccounts.get(context).getAccessKey()) || BiliAccounts.get(context).mid() == 0) {
            accessKey = "";
        } else {
            String accessKey2 = BiliAccounts.get(context).getAccessKey();
            Intrinsics.checkNotNullExpressionValue(accessKey2, "getAccessKey(...)");
            accessKey = accessKey2;
        }
        final HashMap reportParams = createSendParams(danmakuText, params, playtime, cid, rnd);
        Object createService = ServiceGenerator.createService(DanmakuApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        DanmakuApiService service = (DanmakuApiService) createService;
        long tmpScene = scene != null ? scene.longValue() : 0L;
        BLog.i(TAG, "sendDanmaku: avid=" + avid + ", cid=" + cid + ", scene=" + scene);
        if (tmpScene <= 0) {
            sendDanmakuV2$default = service.sendDanmaku(accessKey, avid, cid, spmid, fromSpmid, reportParams);
        } else {
            String requestParamsV2Text = createSendParamsV2(danmakuText, params, playtime, avid, cid, rnd);
            Long postType = params.getPostType();
            sendDanmakuV2$default = DanmakuApiService.CC.sendDanmakuV2$default(service, accessKey, tmpScene, spmid, fromSpmid, postType != null ? postType.longValue() : 1L, requestParamsV2Text, null, createSendParamsMapV2(params), 64, null);
        }
        BiliCall call = sendDanmakuV2$default;
        call.enqueue(new BiliApiDataCallback<DanmakuSendHelper.DanmakuSendResponse>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender$onSend$1
            public void onDataSuccess(DanmakuSendHelper.DanmakuSendResponse data) {
                Long dmid;
                CommentItem commentItem2;
                String dmContent;
                CommentItem commentItem3 = CommentItem.this;
                if (commentItem3 != null) {
                    commentItem3.mRemoteDmId = data != null ? data.getDmidStr() : null;
                }
                CommentItem commentItem4 = CommentItem.this;
                if (commentItem4 != null) {
                    commentItem4.action = data != null ? data.getAction() : null;
                }
                CommentItem commentItem5 = CommentItem.this;
                if (commentItem5 != null) {
                    commentItem5.animation = data != null ? data.getAnimation() : null;
                }
                CommentItem commentItem6 = CommentItem.this;
                if (commentItem6 != null) {
                    commentItem6.colorful = data != null ? data.getColorful() : null;
                }
                if (((data == null || (dmContent = data.getDmContent()) == null || !(StringsKt.isBlank(dmContent) ^ true)) ? false : true) && (commentItem2 = CommentItem.this) != null) {
                    commentItem2.mText = data.getDmContent();
                }
                if (data != null ? Intrinsics.areEqual(data.getVisible(), true) : false) {
                    DanmakuSendHelper.INSTANCE.onSendDanmakuSuccess(context, CommentItem.this);
                } else {
                    BLog.w("ChronosDanmakuSender", "danmaku send success, but server say that it is not visible");
                }
                this.dispatchDanmakuSendSuccess(CommentItem.this, reportParams);
                DanmakuSendHelper.INSTANCE.onSendDanmakuReportResult(playerContainer, "0", params.getNewType(), (data == null || (dmid = data.getDmid()) == null || (r4 = String.valueOf(dmid.longValue())) == null) ? "" : "");
                if (params.getHasExpression() && data != null) {
                    playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_player_dm_send_preview_click_player, "content", danmakuText, "dmid", String.valueOf(data.getDmid()), "is_success", "1"));
                }
                BLog.i("ChronosDanmakuSender", "sendDanmaku succeed");
            }

            public void onError(Throwable t) {
                Response response;
                Intrinsics.checkNotNullParameter(t, "t");
                if (!params.getHandleError()) {
                    return;
                }
                if (params.getHasExpression()) {
                    playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_player_dm_send_preview_click_player, "content", danmakuText, "is_success", "0"));
                }
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
                            DanmakuSendHelper.onSendDanmakuReportResult$default(DanmakuSendHelper.INSTANCE, playerContainer, String.valueOf(code), params.getNewType(), null, 8, null);
                            return;
                        default:
                            switch (code) {
                                case -101:
                                case -2:
                                    this.signOut(context);
                                    String string2 = context.getString(R.string.playerbaseres_global_string_906);
                                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                    errorMsg = string2;
                                    break;
                            }
                    }
                }
                DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, errorMsg, null, false);
                DanmakuSendHelper.onSendDanmakuReportResult$default(DanmakuSendHelper.INSTANCE, playerContainer, String.valueOf(code), params.getNewType(), null, 8, null);
                BLog.e("ChronosDanmakuSender", "sendDanmaku failed: " + t);
            }
        });
    }

    private final HashMap<String, String> createSendParams(String danmakuText, DanmakuSendParams params, long playtime, long cid, String rnd) {
        String str;
        int it;
        HashMap reportParams = new HashMap();
        reportParams.put("type", "1");
        reportParams.put("oid", String.valueOf(cid));
        reportParams.put("progress", String.valueOf(playtime));
        reportParams.put("color", String.valueOf(params.getDanmakuColor()));
        reportParams.put("msg", danmakuText);
        reportParams.put("fontsize", String.valueOf(params.getDanmakuSize()));
        reportParams.put("mode", String.valueOf(params.getDanmakuType()));
        reportParams.put("pool", "0");
        reportParams.put("plat", "2");
        reportParams.put("checkbox_type", String.valueOf(params.getCheckboxType()));
        HashMap hashMap = reportParams;
        if (params.getAvatarId() == null || params.getAvatarType() == null) {
            str = "";
        } else {
            JsonObject jsonObject$iv$iv = new JsonObject();
            JsonObject builder$iv$iv = JsonObjectBuilder.constructor-impl(jsonObject$iv$iv);
            JsonObjectBuilder.kv-impl(builder$iv$iv, "id", params.getAvatarId());
            JsonObjectBuilder.kv-impl(builder$iv$iv, "avatar_type", params.getAvatarType());
            str = Objects.toJsonString(builder$iv$iv);
        }
        hashMap.put("avatar", str);
        if (!TextUtils.isEmpty(rnd)) {
            reportParams.put("rnd", rnd);
        }
        if (!TextUtils.isEmpty(params.getParentDanmakuId())) {
            String parentDanmakuId = params.getParentDanmakuId();
            Intrinsics.checkNotNull(parentDanmakuId);
            reportParams.put("parent_id", parentDanmakuId);
        }
        Integer colorful = params.getColorful();
        if (colorful != null && (it = colorful.intValue()) > 0) {
            reportParams.put("colorful", String.valueOf(it));
        }
        String it2 = PageViewTracker.getInstance().currentPolarisActionId();
        if (it2 != null) {
            reportParams.put("scm_action_id", it2);
        }
        String it3 = params.getExtra();
        if (it3 != null) {
            reportParams.put("hive_extra", it3);
        }
        return reportParams;
    }

    private final String createSendParamsV2(String danmakuText, DanmakuSendParams params, long playtime, long avid, long cid, String rnd) {
        String requestParams;
        DanmakuSendHelper.DanmakuSendRequestV2.Text requestText = new DanmakuSendHelper.DanmakuSendRequestV2.Text();
        requestText.setType(1L);
        requestText.setOid(cid);
        requestText.setMsg(danmakuText);
        requestText.setAid(avid);
        requestText.setProgress(playtime);
        requestText.setColor(params.getDanmakuColor());
        requestText.setFontSize(params.getDanmakuSize());
        requestText.setPool(0L);
        requestText.setMode(params.getDanmakuType());
        requestText.setPlat(2L);
        requestText.setCheckboxType(params.getCheckboxType());
        if (!TextUtils.isEmpty(rnd)) {
            Long longOrNull = StringsKt.toLongOrNull(rnd);
            requestText.setRnd(longOrNull != null ? longOrNull.longValue() : 0L);
        }
        if (!TextUtils.isEmpty(params.getParentDanmakuId())) {
            String parentDanmakuId = params.getParentDanmakuId();
            requestText.setParentId(parentDanmakuId != null ? StringsKt.toLongOrNull(parentDanmakuId) : null);
        }
        String it = PageViewTracker.getInstance().currentPolarisActionId();
        if (it != null) {
            requestText.setActionId(it);
        }
        try {
            requestParams = JSONObject.toJSONString(requestText);
        } catch (Exception e) {
            requestParams = "";
        }
        Intrinsics.checkNotNull(requestParams);
        return requestParams;
    }

    private final HashMap<String, String> createSendParamsMapV2(DanmakuSendParams params) {
        HashMap reportParams = new HashMap();
        String it = params.getExtra();
        if (it != null) {
            reportParams.put("hive_extra", it);
        }
        return reportParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchDanmakuSendSuccess(CommentItem commentItem, HashMap<String, String> hashMap) {
        this.mCallback.onDanmakuSendSuccess(commentItem, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchCommandDanmakuSendSuccess(CommandDanmakuSendResponse commandDanmaku) {
        this.mCallback.onCommandDanmakuSentSuccess(commandDanmaku);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Task<Void> signOut(final Context context) {
        Task<Void> callInBackground = Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void signOut$lambda$0;
                signOut$lambda$0 = ChronosDanmakuSender.signOut$lambda$0(context);
                return signOut$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(callInBackground, "callInBackground(...)");
        return callInBackground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void signOut$lambda$0(Context $context) {
        BiliAccounts.get($context).logout("ChronosDanmakuSender_signOut");
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean sendCommandDanmaku(IPlayerContainer playerContainer, Context context, int type, Map<String, ? extends Object> map, Long scene) {
        Map content = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(content, "content");
        return onSendCommandDanmaku(context, playerContainer, type, content, scene);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender
    public boolean sendUpDanmaku(IPlayerContainer playerContainer, Context context, String content, Long scene) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(content, "content");
        HashMap map = new HashMap();
        map.put("msg", content);
        return onSendCommandDanmaku(context, playerContainer, 1, map, scene);
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x0046 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean onSendCommandDanmaku(final Context context, final IPlayerContainer playerContainer, int type, Map<String, ? extends Object> map, Long scene) {
        Video.DisplayParams video2;
        Map reportParams;
        final int i;
        BiliCall call;
        String fromSpmid;
        String spmid;
        Map content = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Context finalContext = context != null ? context.getApplicationContext() : null;
        if (finalContext == null) {
            DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, null, null, false);
            return false;
        }
        Map jSONObject = new JSONObject();
        Map jSONObject2 = new JSONObject();
        Iterable $this$forEach$iv = content.entrySet();
        Iterator it = $this$forEach$iv.iterator();
        boolean autoCreate = false;
        int countDown = 10;
        while (autoCreate) {
            Object element$iv = it.next();
            Map.Entry it2 = (Map.Entry) element$iv;
            if (it2.getValue() instanceof String) {
                Object value = it2.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                if (((String) value).length() > 300) {
                    DanmakuSendHelper.INSTANCE.toast(playerContainer, context.getString(R.string.playerbaseres_global_string_804));
                    return false;
                }
            }
            jSONObject.put(it2.getKey(), it2.getValue());
            if (!Intrinsics.areEqual(it2.getKey(), KEY_VOTE_CUSTOM)) {
                jSONObject2.put(it2.getKey(), it2.getValue());
            }
            if (type == 5) {
                if (Intrinsics.areEqual(it2.getKey(), KEY_AUTO_CREATE)) {
                    Object value2 = it2.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Boolean");
                    autoCreate = ((Boolean) value2).booleanValue();
                }
                if (Intrinsics.areEqual(it2.getKey(), KEY_COUNT_DOWN)) {
                    Object value3 = it2.getValue();
                    Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Int");
                    countDown = ((Integer) value3).intValue();
                }
            }
        }
        Map reportParams2 = new LinkedHashMap();
        if (jSONObject.containsKey(KEY_VOTE_CUSTOM)) {
            reportParams2.put("is_selfDef", String.valueOf(jSONObject.get(KEY_VOTE_CUSTOM)));
        }
        reportParams2.put("is_locked", "1");
        reportParams2.put("msg", jSONObject2.toString());
        reportParams2.put("danmaku_type", String.valueOf(type));
        String it3 = PageViewTracker.getInstance().currentPolarisActionId();
        if (it3 != null) {
            reportParams2.put("scm_action_id", it3);
        }
        int progress = playerContainer.getPlayerCoreService().getCurrentPosition();
        if (progress < 0) {
            DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, null, null, false);
            return true;
        } else if (!Connectivity.isConnected(Connectivity.getActiveNetworkInfo(context.getApplicationContext()))) {
            DanmakuSendHelper.INSTANCE.toast(playerContainer, context.getString(bili.resource.common.R.string.common_global_string_250));
            onSendCommandDanmakuReportResult$default(this, playerContainer, type, -1, null, 8, null);
            return false;
        } else {
            String accessKey = "";
            if (BiliAccounts.get(context).isLogin() && !TextUtils.isEmpty(BiliAccounts.get(context).getAccessKey()) && BiliAccounts.get(context).mid() != 0) {
                String accessKey2 = BiliAccounts.get(context).getAccessKey();
                Intrinsics.checkNotNullExpressionValue(accessKey2, "getAccessKey(...)");
                accessKey = accessKey2;
            }
            Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
            if (playableParams != null && (video2 = playableParams.getDisplayParams()) != null) {
                Object createService = ServiceGenerator.createService(InteractApiService.class);
                Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
                InteractApiService service = (InteractApiService) createService;
                long tmpScene = scene != null ? scene.longValue() : 0L;
                Video.ReportCommonParams reportCommonParams = playableParams.getReportCommonParams();
                if (tmpScene > 0) {
                    String accessKey3 = accessKey;
                    reportParams = reportParams2;
                    i = type;
                    String cmd = createSendCommandParams(video2.getAvid(), video2.getCid(), Integer.parseInt("2"), Long.valueOf(progress), type, jSONObject);
                    call = InteractApiService.CC.sendCommandDanmakuV2$default(service, accessKey3, tmpScene, (reportCommonParams == null || (spmid = reportCommonParams.getSpmid()) == null) ? "" : spmid, (reportCommonParams == null || (fromSpmid = reportCommonParams.getFromSpmid()) == null) ? "" : fromSpmid, 2L, null, cmd, 32, null);
                } else {
                    String accessKey4 = accessKey;
                    reportParams = reportParams2;
                    i = type;
                    String jSONObject3 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
                    call = service.sendCommandDanmaku(accessKey4, String.valueOf(video2.getAvid()), String.valueOf(video2.getCid()), "2", progress, type, jSONObject3, autoCreate, countDown);
                }
                call.enqueue(new BiliApiDataCallback<CommandDanmakuSendResponse>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender$onSendCommandDanmaku$3
                    public void onDataSuccess(ChronosDanmakuSender.CommandDanmakuSendResponse data) {
                        ChronosDanmakuSender.this.onSendCommandDanmakuReportResult(playerContainer, i, 0, (data == null || (r3 = data.getIdStr()) == null) ? "" : "");
                        if (data != null) {
                            ChronosDanmakuSender.this.dispatchCommandDanmakuSendSuccess(data);
                        }
                        DanmakuSendHelper.INSTANCE.toast(playerContainer, context.getString(R.string.playerbaseres_global_string_1075));
                    }

                    public void onError(Throwable t) {
                        Response response;
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
                            String message = ((BiliApiException) t).getMessage();
                            if (message == null) {
                                message = errorMsg;
                            }
                            errorMsg = message;
                            switch (code) {
                                case DanmakuSendHelper.ERROR_NEED_BIND_PHONE /* 61001 */:
                                case DanmakuSendHelper.ERROR_NEED_LEGAL_PHONE /* 61002 */:
                                    PlayerRouteUris.Routers.INSTANCE.gotoAuthority(context, code, errorMsg);
                                    DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, errorMsg, null, true);
                                    ChronosDanmakuSender.onSendCommandDanmakuReportResult$default(ChronosDanmakuSender.this, playerContainer, i, code, null, 8, null);
                                    return;
                                default:
                                    switch (code) {
                                        case -101:
                                        case -2:
                                            ChronosDanmakuSender.this.signOut(context);
                                            String string2 = context.getString(R.string.playerbaseres_global_string_906);
                                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                            errorMsg = string2;
                                            break;
                                    }
                            }
                        }
                        DanmakuSendHelper.INSTANCE.onSendDanmakuFailed(playerContainer, errorMsg, null, false);
                        ChronosDanmakuSender.onSendCommandDanmakuReportResult$default(ChronosDanmakuSender.this, playerContainer, i, code, null, 8, null);
                    }
                });
                playerContainer.getReporterService().report(new NeuronsEvents.NormalEventV2(EventId.player_neuron_dm_send_send, reportParams));
                return true;
            }
            return false;
        }
    }

    private final String createSendCommandParams(long avid, long cid, int plat, Long progress, int type, JSONObject data) {
        Map jSONObject = new JSONObject();
        jSONObject.put("aid", Long.valueOf(avid));
        jSONObject.put("cid", Long.valueOf(cid));
        jSONObject.put("plat", Integer.valueOf(plat));
        jSONObject.put("progress", progress);
        jSONObject.put("type", Integer.valueOf(type));
        jSONObject.put("data", data.toJSONString());
        String jSONString = jSONObject.toJSONString();
        return jSONString == null ? "" : jSONString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void onSendCommandDanmakuReportResult$default(ChronosDanmakuSender chronosDanmakuSender, IPlayerContainer iPlayerContainer, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str = "";
        }
        chronosDanmakuSender.onSendCommandDanmakuReportResult(iPlayerContainer, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSendCommandDanmakuReportResult(IPlayerContainer playerContainer, int type, int code, String dmid) {
        playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_neuron_dm_send_send_result, "danmaku_type", String.valueOf(type), "code", String.valueOf(code), "dmid", dmid));
    }

    /* compiled from: ChronosDanmakuSender.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\"\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006-"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$CommandDanmakuSendResponse;", "", "id", "", "oid", "", RankRouter.BundleKey.AUTHOR_SPACE_MID, "type", "", "command", "content", "progress", "state", "extra", "idStr", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getOid", "()Ljava/lang/Long;", "setOid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMid", "setMid", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCommand", "setCommand", "getContent", "setContent", "getProgress", "setProgress", "getState", "setState", "getExtra", "setExtra", "getIdStr", "setIdStr", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CommandDanmakuSendResponse {
        @JSONField(name = "command")
        private String command;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "extra")
        private String extra;
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "idStr")
        private String idStr;
        @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
        private Long mid;
        @JSONField(name = "oid")
        private Long oid;
        @JSONField(name = "progress")
        private Long progress;
        @JSONField(name = "state")
        private Integer state;
        @JSONField(name = "type")
        private Integer type;

        public CommandDanmakuSendResponse() {
            this(null, null, null, null, null, null, null, null, null, null, IjkMediaPlayerTracker.BLIJK_EV_BUFFERING_END, null);
        }

        public CommandDanmakuSendResponse(String id, Long oid, Long mid, Integer type, String command, String content, Long progress, Integer state, String extra, String idStr) {
            this.id = id;
            this.oid = oid;
            this.mid = mid;
            this.type = type;
            this.command = command;
            this.content = content;
            this.progress = progress;
            this.state = state;
            this.extra = extra;
            this.idStr = idStr;
        }

        public /* synthetic */ CommandDanmakuSendResponse(String str, Long l, Long l2, Integer num, String str2, String str3, Long l3, Integer num2, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : num2, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : str4, (i & 512) == 0 ? str5 : null);
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final Long getOid() {
            return this.oid;
        }

        public final void setOid(Long l) {
            this.oid = l;
        }

        public final Long getMid() {
            return this.mid;
        }

        public final void setMid(Long l) {
            this.mid = l;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public final String getCommand() {
            return this.command;
        }

        public final void setCommand(String str) {
            this.command = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final Long getProgress() {
            return this.progress;
        }

        public final void setProgress(Long l) {
            this.progress = l;
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer num) {
            this.state = num;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }

        public final String getIdStr() {
            return this.idStr;
        }

        public final void setIdStr(String str) {
            this.idStr = str;
        }
    }
}