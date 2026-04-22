package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote;

import android.graphics.Rect;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommandDanmakuSent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommercialEventChanged;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OGVDubbingResult;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OGVTimelineMaterialChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OnlineInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PUGVInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlayerControlBarChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PreferenceChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.SceneBizChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.ShipChainChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.UserInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.VideoDetailStateChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.WorkInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender;
import tv.danmaku.biliplayerv2.service.interact.biz.model.AdDanmakuBean;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsDanmaku;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.TransformParams;

/* compiled from: RemoteServiceHandler.kt */
@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J.\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0005H&J\u001c\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J*\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u0018H&J \u0010(\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0018H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020 H&J\u0018\u0010,\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H&J\"\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014H&J\u0016\u00105\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u000107H&J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H&J\u0010\u0010;\u001a\u00020\u00032\u0006\u00109\u001a\u00020<H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0005H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0005H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0005H&J\u0010\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020CH&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010B\u001a\u00020EH&J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010B\u001a\u00020GH&J\u0010\u0010H\u001a\u00020\u00032\u0006\u0010B\u001a\u00020IH&J\u0018\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u0017H&J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010B\u001a\u00020NH&J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020/H&J\u0010\u0010Q\u001a\u00020\u00032\u0006\u0010B\u001a\u00020RH&J?\u0010S\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00182+\b\u0002\u0010T\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020W0V¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020\u0003\u0018\u00010UH&J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0017H&J?\u0010]\u001a\u00020\u00032\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00170_2\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010_2\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010_H&¢\u0006\u0002\u0010bJ0\u0010c\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\u0018H&J\u001e\u0010g\u001a\u00020\u00032\b\u0010h\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010j\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010VH'J1\u0010k\u001a\u00020\u00032'\u0010T\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020/0V¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020\u00030UH&J\u0010\u0010l\u001a\u00020\u00032\u0006\u0010P\u001a\u00020mH&J5\u0010n\u001a\u00020\u00032\b\u0010o\u001a\u0004\u0018\u00010\u00172\b\u0010p\u001a\u0004\u0018\u00010\u00172\b\u0010q\u001a\u0004\u0018\u00010\u00142\b\u0010r\u001a\u0004\u0018\u00010sH&¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020\u0003H&J*\u0010v\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00142\b\b\u0002\u0010w\u001a\u00020\u0014H&J&\u0010x\u001a\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020y0V2\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014H&J\u0010\u0010z\u001a\u00020\u00032\u0006\u0010{\u001a\u00020WH&J$\u0010z\u001a\u00020\u00032\b\u0010|\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010}\u001a\u0004\u0018\u00010\u0001H&J:\u0010z\u001a\u00020\u00032\b\u0010|\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010}\u001a\u0004\u0018\u00010\u00012\u0014\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u007f\u0018\u00010\u0016H&J\u0012\u0010\u0080\u0001\u001a\u00020\u00032\u0007\u0010\u0081\u0001\u001a\u00020\u0017H&J\t\u0010\u0082\u0001\u001a\u00020\u0017H&J\t\u0010\u0083\u0001\u001a\u00020\u0003H&J\u0012\u0010\u0084\u0001\u001a\u00020\u00032\u0007\u0010B\u001a\u00030\u0085\u0001H&J\u0012\u0010\u0086\u0001\u001a\u00020\u00032\u0007\u0010B\u001a\u00030\u0087\u0001H&J\u0011\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0018H&J\u0013\u0010\u0089\u0001\u001a\u00020\u00032\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H&J\u0012\u0010\u008c\u0001\u001a\u00020\u00032\u0007\u0010\u008d\u0001\u001a\u00020\u0005H&J\u0013\u0010\u008e\u0001\u001a\u00020\u00032\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H&J\u0012\u0010\u0091\u0001\u001a\u00020\u00032\u0007\u00109\u001a\u00030\u0092\u0001H&J\u0012\u0010\u0093\u0001\u001a\u00020\u00032\u0007\u0010B\u001a\u00030\u0094\u0001H&J\u0012\u0010\u0095\u0001\u001a\u00020\u00032\u0007\u0010B\u001a\u00030\u0096\u0001H&J\u001b\u0010\u0097\u0001\u001a\u00020\u00032\u0007\u0010\u0098\u0001\u001a\u00020\u00182\u0007\u0010\u0099\u0001\u001a\u00020\u0018H&J<\u0010\u009a\u0001\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u00182\u0006\u0010'\u001a\u00020\u00182\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0003\u0010\u009c\u0001J\u0012\u0010\u009d\u0001\u001a\u00020\u00032\u0007\u0010B\u001a\u00030\u009e\u0001H&J\u0015\u0010\u009f\u0001\u001a\u00020\u00032\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H&J\u001d\u0010¢\u0001\u001a\u00020\u00032\u0007\u0010£\u0001\u001a\u00020\u00052\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0017H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006¥\u0001À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "", "onStart", "", "multiPlayer", "", "onStop", "onBindPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "getChronosMessageSender", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/protocol/IChronosRpcSender;", "updateDanmakuParam", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "restore", "onPlayerClockChanged", "speed", "", "currentPosition", "", "errors", "", "", "", "onVideoSeeking", "previewPosition", "type", "onVideoSpeeding", "status", "onVideoSizeChanged", "renderBounds", "Landroid/graphics/Rect;", "transformParams", "Ltv/danmaku/render/core/TransformParams;", "dispatchRpcGesture", "x", "y", "gesture", "state", "dispatchRpcTouch", "action", "onViewPortUpdate", "viewPort", "setCommandDanmakus", "danmakus", "", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsDanmaku;", "configChronos", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "avid", "cid", "initChronosView", "view", "Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;", "updateCurrentWorkInfo", "param", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Response;", "notifyWorkInfoChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/WorkInfoChange$Request;", "onSegmentSettingChanged", "enabled", "onForcedChapterGuide", "onEyesProtectionModeChanged", "onOnlineInfoChanged", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OnlineInfoChange$Request;", "sendOnlineDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDanmakuSent$Request;", "onSceneAndBizChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/SceneBizChange$Request;", "onVideoDetailStateChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/VideoDetailStateChange$Request;", "updateCurrentWorkChanged", "workId", "videoId", "updateRelationshipChainChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ShipChainChange$Request;", "onCommandDanmakuDeleted", "commandDanmaku", "onAccountStateChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/UserInfoChange$Request;", "requestRpcDanmakuList", "onComplete", "Lkotlin/Function1;", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "Lkotlin/ParameterName;", "name", "result", "reCallDanmaku", "danmakuId", "deleteDanmaku", "danmakuIds", "", "userHashArray", "contents", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V", "likeDanmaku", "liked", "likeCount", "replyCount", "onBusinessDataChanged", LoginSceneProcessor.BIZ_KEY, "data", "getCommandDanmakus", "getChronosCommandDanmakus", "appendCommandDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$CommandDanmakuSendResponse;", "appendFilters", "shieldUserId", "regexFilter", "nativeId", "onSuccess", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Runnable;)V", "filtersChanged", "setDanmakuExposureParam", "replyDanmakuId", "adDanmakuExposureRequest", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "addDanmaku", "item", "dmId", "extra", "emoExtra", "", "restorePackage", "token", "onSaveState", "toBackground", "onPreferenceChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PreferenceChange$Request;", "onPlayerControlBarChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlayerControlBarChange$Request;", "onNetWorkSateChanged", "onWindowInsetChanged", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "onDanmakuVisibleChanged", "visible", "setVisibleRect", "rect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "onOgvTimelineMaterialChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVTimelineMaterialChange$Request;", "onPUGVInfoChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PUGVInfoChange$Request;", "onDubbingPanelChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVDubbingResult$Request;", "onPlayerComponentsHeightChanged", "panelHeight", "totalHeight", "onReceiveChronosGestureAction", "touchAction", "(FFLjava/lang/Integer;ILjava/lang/Integer;)V", "onCommercialEventChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommercialEventChanged$Request;", "setCidCheckIntercept", "intercept", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IChronosRemoteCidCheckIntercept;", "onPermissionChanged", "granted", "permission", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IRemoteHandler {
    void adDanmakuExposureRequest(List<? extends AdDanmakuBean> list, long j, long j2);

    void addDanmaku(String str, int i, Object obj);

    void addDanmaku(String str, int i, Object obj, Map<String, byte[]> map);

    void addDanmaku(CommentItem commentItem);

    void appendCommandDanmaku(ChronosDanmakuSender.CommandDanmakuSendResponse commandDanmakuSendResponse);

    void appendFilters(String str, String str2, Long l, Runnable runnable);

    void configChronos(ViewProgressDetail viewProgressDetail, long j, long j2);

    void deleteDanmaku(String[] strArr, String[] strArr2, String[] strArr3);

    boolean dispatchRpcGesture(float f, float f2, int i, int i2);

    void dispatchRpcTouch(float f, float f2, int i);

    void filtersChanged();

    void getChronosCommandDanmakus(Function1<? super List<CommandsDanmaku>, Unit> function1);

    IChronosRpcSender getChronosMessageSender();

    @Deprecated(message = "use getChronosCommandDanmakus")
    List<CommandsDanmaku> getCommandDanmakus();

    void initChronosView(EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner);

    void likeDanmaku(String str, boolean z, String str2, int i, int i2);

    void notifyWorkInfoChanged(WorkInfoChange.Request request);

    void onAccountStateChanged(UserInfoChange.Request request);

    void onBindPlayerContainer(PlayerContainer playerContainer);

    void onBusinessDataChanged(String str, Object obj);

    void onCommandDanmakuDeleted(CommandsDanmaku commandsDanmaku);

    void onCommercialEventChanged(CommercialEventChanged.Request request);

    void onDanmakuVisibleChanged(boolean z);

    void onDubbingPanelChanged(OGVDubbingResult.Request request);

    void onEyesProtectionModeChanged(boolean z);

    void onForcedChapterGuide(boolean z);

    void onNetWorkSateChanged(int i);

    void onOgvTimelineMaterialChanged(OGVTimelineMaterialChange.Request request);

    void onOnlineInfoChanged(OnlineInfoChange.Request request);

    void onPUGVInfoChanged(PUGVInfoChange.Request request);

    void onPermissionChanged(boolean z, String str);

    void onPlayerClockChanged(float f, long j, Map<String, Integer> map);

    void onPlayerComponentsHeightChanged(int i, int i2);

    void onPlayerControlBarChanged(PlayerControlBarChange.Request request);

    void onPreferenceChanged(PreferenceChange.Request request);

    void onReceiveChronosGestureAction(float f, float f2, Integer num, int i, Integer num2);

    String onSaveState();

    void onSceneAndBizChanged(SceneBizChange.Request request);

    void onSegmentSettingChanged(boolean z);

    void onStart(boolean z);

    void onStop();

    void onVideoDetailStateChanged(VideoDetailStateChange.Request request);

    void onVideoSeeking(long j, long j2);

    void onVideoSizeChanged(Rect rect, TransformParams transformParams);

    void onVideoSpeeding(boolean z);

    void onViewPortUpdate(Rect rect);

    void onWindowInsetChanged(WindowInset windowInset);

    void reCallDanmaku(String str);

    void requestRpcDanmakuList(int i, Function1<? super List<? extends CommentItem>, Unit> function1);

    void restorePackage(String str);

    void sendOnlineDanmaku(CommandDanmakuSent.Request request);

    void setCidCheckIntercept(IChronosRemoteCidCheckIntercept iChronosRemoteCidCheckIntercept);

    void setCommandDanmakus(List<CommandsDanmaku> list);

    void setDanmakuExposureParam(long j, long j2, long j3, long j4);

    void setVisibleRect(DanmakuConfigChange.VisibleRect visibleRect);

    void toBackground();

    void updateCurrentWorkChanged(String str, String str2);

    void updateCurrentWorkInfo(GetWorkInfo.Response response);

    void updateDanmakuParam(DanmakuParams danmakuParams, boolean z);

    void updateRelationshipChainChanged(ShipChainChange.Request request);

    /* compiled from: RemoteServiceHandler.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onStart$default(IRemoteHandler iRemoteHandler, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStart");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iRemoteHandler.onStart(z);
        }

        public static /* synthetic */ void updateDanmakuParam$default(IRemoteHandler iRemoteHandler, DanmakuParams danmakuParams, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDanmakuParam");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iRemoteHandler.updateDanmakuParam(danmakuParams, z);
        }

        public static /* synthetic */ boolean dispatchRpcGesture$default(IRemoteHandler iRemoteHandler, float f, float f2, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    i2 = 0;
                }
                return iRemoteHandler.dispatchRpcGesture(f, f2, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchRpcGesture");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void requestRpcDanmakuList$default(IRemoteHandler iRemoteHandler, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestRpcDanmakuList");
            }
            if ((i2 & 1) != 0) {
                i = 1;
            }
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            iRemoteHandler.requestRpcDanmakuList(i, function1);
        }

        public static /* synthetic */ void deleteDanmaku$default(IRemoteHandler iRemoteHandler, String[] strArr, String[] strArr2, String[] strArr3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteDanmaku");
            }
            if ((i & 2) != 0) {
                strArr2 = null;
            }
            if ((i & 4) != 0) {
                strArr3 = null;
            }
            iRemoteHandler.deleteDanmaku(strArr, strArr2, strArr3);
        }

        public static /* synthetic */ void onBusinessDataChanged$default(IRemoteHandler iRemoteHandler, String str, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBusinessDataChanged");
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            iRemoteHandler.onBusinessDataChanged(str, obj);
        }

        public static /* synthetic */ void setDanmakuExposureParam$default(IRemoteHandler iRemoteHandler, long j, long j2, long j3, long j4, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuExposureParam");
            }
            iRemoteHandler.setDanmakuExposureParam(j, j2, j3, (i & 8) != 0 ? -1L : j4);
        }
    }
}