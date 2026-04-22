package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReply;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerCoroutineKt;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.ControlContainerObserver;
import tv.danmaku.biliplayerv2.service.IPlayerClockChangedObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuParamsChangeObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuSeniorModeChangeObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuSettingsChangedObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRpcMessageSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper.ChronosAsyncMessage;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper.ChronosSyncMessage;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.BusinessDataChanged;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommandDanmakuDeleted;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommandDanmakuSent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommandDmListRequest;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommercialEventChanged;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuDeleted;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuFilterChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuLiked;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuList;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuRecall;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuSent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DeviceInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DmViewChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.FeatureListChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.GestureEventReceived;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.NetworkChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OGVDubbingResult;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OGVTimelineMaterialChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OnVideoSeeking;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OnVideoSpeeding;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OnlineInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PUGVInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PermissionChanged;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlaybackStatusChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlayerComponentsHeight;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlayerControlBarChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PreferenceChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.RestoreState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.SaveState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.SceneBizChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.ScreenStateChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.ShipChainChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.TouchEventReceive;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.UserInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.VideoDetailStateChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.VideoSizeChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.ViewProgressChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.WorkChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.WorkInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.model.AdDanmakuBean;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItemFactory;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.AttentionCard;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.DmResource;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ShowTime;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoGuide;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoViewPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsDanmaku;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.TransformParams;

/* compiled from: RemoteServiceHandler.kt */
@Metadata(d1 = {"\u0000£\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0003*\t!&),/258;\u0018\u0000 ÷\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002÷\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010=\u001a\u00020>H\u0016J\u0016\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0016J9\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001a2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020F2\b\u0010H\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020LH\u0016J\u0018\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0017H\u0016J\u0010\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020\u0017H\u0016J\u0010\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\nH\u0016J\b\u0010U\u001a\u00020@H\u0016J\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020@H\u0016J\u0010\u0010Y\u001a\u00020@2\u0006\u0010K\u001a\u00020ZH\u0016J:\u0010[\u001a\u00020@2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020W0\u00122\f\u0010]\u001a\b\u0012\u0004\u0012\u00020W0\u00122\f\u0010^\u001a\b\u0012\u0004\u0012\u00020W0\u00122\u0006\u0010_\u001a\u00020\u0017H\u0016J\u0018\u0010`\u001a\u00020@2\u0006\u0010a\u001a\u00020\u001a2\u0006\u0010b\u001a\u00020cH\u0016J\u0010\u0010d\u001a\u00020@2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020@2\u0006\u0010e\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020@2\u0006\u0010j\u001a\u00020\u0017H\u0016J\u0010\u0010k\u001a\u00020@2\u0006\u0010j\u001a\u00020\u0017H\u0016J\u0010\u0010l\u001a\u00020@2\u0006\u0010j\u001a\u00020\u0017H\u0016J\u0010\u0010m\u001a\u00020@2\u0006\u0010K\u001a\u00020\u0010H\u0016J\u0010\u0010n\u001a\u00020@2\u0006\u0010K\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020@2\u0006\u0010K\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020@2\u0006\u0010K\u001a\u00020sH\u0016J\u0010\u0010t\u001a\u00020@2\u0006\u0010K\u001a\u00020uH\u0016J\u0018\u0010v\u001a\u00020@2\u0006\u0010w\u001a\u00020W2\u0006\u0010x\u001a\u00020WH\u0016J\u0010\u0010y\u001a\u00020@2\u0006\u0010K\u001a\u00020zH\u0016J\u0010\u0010{\u001a\u00020@2\u0006\u0010|\u001a\u00020\u0013H\u0016J\u0010\u0010}\u001a\u00020@2\u0006\u0010K\u001a\u00020~H\u0016JC\u0010\u007f\u001a\u00020@2\u0007\u0010\u0080\u0001\u001a\u00020F20\u0010\u0081\u0001\u001a+\u0012\u001e\u0012\u001c\u0012\u0005\u0012\u00030\u0084\u00010\u0083\u0001¢\u0006\u000f\b\u0085\u0001\u0012\n\b\u0086\u0001\u0012\u0005\b\b(\u0087\u0001\u0012\u0004\u0012\u00020@\u0018\u00010\u0082\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020@2\u0007\u0010\u0089\u0001\u001a\u00020WH\u0016JC\u0010\u008a\u0001\u001a\u00020@2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020W0\u008c\u00012\u0010\u0010\u008d\u0001\u001a\u000b\u0012\u0004\u0012\u00020W\u0018\u00010\u008c\u00012\u0010\u0010\u008e\u0001\u001a\u000b\u0012\u0004\u0012\u00020W\u0018\u00010\u008c\u0001H\u0016¢\u0006\u0003\u0010\u008f\u0001J5\u0010\u0090\u0001\u001a\u00020@2\u0006\u0010x\u001a\u00020W2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0007\u0010\u0089\u0001\u001a\u00020W2\u0007\u0010\u0092\u0001\u001a\u00020F2\u0007\u0010\u0093\u0001\u001a\u00020FH\u0016J \u0010\u0094\u0001\u001a\u00020@2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010W2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0010\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0083\u0001H\u0017J8\u0010\u0099\u0001\u001a\u00020@2-\u0010\u0081\u0001\u001a(\u0012\u001d\u0012\u001b\u0012\u0004\u0012\u00020\u00130\u0083\u0001¢\u0006\u000f\b\u0085\u0001\u0012\n\b\u0086\u0001\u0012\u0005\b\b(\u0087\u0001\u0012\u0004\u0012\u00020@0\u0082\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020@2\u0007\u0010|\u001a\u00030\u009b\u0001H\u0016J<\u0010\u009c\u0001\u001a\u00020@2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010W2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010W2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010c2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016¢\u0006\u0003\u0010¢\u0001J\t\u0010£\u0001\u001a\u00020@H\u0016J-\u0010¤\u0001\u001a\u00020@2\u0007\u0010\u0089\u0001\u001a\u00020c2\u0007\u0010¥\u0001\u001a\u00020c2\u0007\u0010¦\u0001\u001a\u00020c2\u0007\u0010§\u0001\u001a\u00020cH\u0016J,\u0010¨\u0001\u001a\u00020@2\u000f\u0010©\u0001\u001a\n\u0012\u0005\u0012\u00030ª\u00010\u0083\u00012\u0007\u0010¥\u0001\u001a\u00020c2\u0007\u0010¦\u0001\u001a\u00020cH\u0016J\u0013\u0010«\u0001\u001a\u00020@2\b\u0010¬\u0001\u001a\u00030\u0084\u0001H\u0016J)\u0010«\u0001\u001a\u00020@2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u0080\u0001\u001a\u00020F2\n\u0010®\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016JB\u0010«\u0001\u001a\u00020@2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u0080\u0001\u001a\u00020F2\n\u0010®\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0017\u0010¯\u0001\u001a\u0012\u0012\u0004\u0012\u00020W\u0012\u0005\u0012\u00030±\u0001\u0018\u00010°\u0001H\u0016J\u0012\u0010²\u0001\u001a\u00020@2\u0007\u0010³\u0001\u001a\u00020WH\u0002J\u0012\u0010´\u0001\u001a\u00020@2\u0007\u0010³\u0001\u001a\u00020WH\u0016J\u0011\u0010µ\u0001\u001a\u00020@2\u0006\u0010G\u001a\u00020FH\u0016J\u0013\u0010¶\u0001\u001a\u00020@2\b\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u0012\u0010¹\u0001\u001a\u00020@2\u0007\u0010º\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010»\u0001\u001a\u00020@2\u0007\u0010¼\u0001\u001a\u00020\u0015H\u0016J\u001a\u0010½\u0001\u001a\u00020@2\u000f\u0010©\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J'\u0010¾\u0001\u001a\u00020@2\n\u0010¿\u0001\u001a\u0005\u0018\u00010À\u00012\u0007\u0010¥\u0001\u001a\u00020c2\u0007\u0010¦\u0001\u001a\u00020cH\u0016J0\u0010`\u001a\u00020@2\u0006\u0010a\u001a\u00020\u001a2\u0006\u0010b\u001a\u00020c2\u0016\u0010Ä\u0001\u001a\u0011\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020F\u0018\u00010°\u0001H\u0016J\u001b\u0010Å\u0001\u001a\u00020@2\u0007\u0010Æ\u0001\u001a\u00020c2\u0007\u0010\u0080\u0001\u001a\u00020cH\u0016J\u0012\u0010Ç\u0001\u001a\u00020@2\u0007\u0010È\u0001\u001a\u00020\u0017H\u0016J*\u0010É\u0001\u001a\u00020@2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0013\u0010N\u001a\u000f\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020W0Ë\u0001H\u0016J\u0013\u0010Ì\u0001\u001a\u00020@2\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0016J\u0012\u0010Ï\u0001\u001a\u00020@2\u0007\u0010|\u001a\u00030\u009b\u0001H\u0016J\u0012\u0010Ð\u0001\u001a\u00020@2\u0007\u0010e\u001a\u00030Ñ\u0001H\u0016J\u0012\u0010Ò\u0001\u001a\u00020@2\u0007\u0010K\u001a\u00030Ó\u0001H\u0016J\u0012\u0010Ô\u0001\u001a\u00020@2\u0007\u0010K\u001a\u00030Õ\u0001H\u0016J\u001b\u0010Ö\u0001\u001a\u00020@2\u0007\u0010×\u0001\u001a\u00020F2\u0007\u0010Ø\u0001\u001a\u00020FH\u0016J\u0014\u0010Ù\u0001\u001a\u00020@2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u001fH\u0016J\u001d\u0010Û\u0001\u001a\u00020@2\u0007\u0010Ü\u0001\u001a\u00020\u00172\t\u0010Ý\u0001\u001a\u0004\u0018\u00010WH\u0016J'\u0010Þ\u0001\u001a\u00020@2\n\u0010¿\u0001\u001a\u0005\u0018\u00010À\u00012\u0007\u0010¥\u0001\u001a\u00020c2\u0007\u0010¦\u0001\u001a\u00020cH\u0002J\u001b\u0010ß\u0001\u001a\u00020@2\u0007\u0010¥\u0001\u001a\u00020c2\u0007\u0010¦\u0001\u001a\u00020cH\u0002J\t\u0010à\u0001\u001a\u00020@H\u0002J\t\u0010á\u0001\u001a\u00020@H\u0002J\u0012\u0010â\u0001\u001a\u00020@2\u0007\u0010ã\u0001\u001a\u00020\u0017H\u0002J \u0010ä\u0001\u001a\u00020@2\t\u0010å\u0001\u001a\u0004\u0018\u00010\u00152\n\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001H\u0016J)\u0010è\u0001\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0016J\"\u0010é\u0001\u001a\u00020@2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001a2\u0007\u0010ê\u0001\u001a\u00020FH\u0016J\t\u0010ë\u0001\u001a\u00020@H\u0002J\t\u0010ì\u0001\u001a\u00020@H\u0002J\u0012\u0010í\u0001\u001a\u00020@2\u0007\u0010î\u0001\u001a\u00020FH\u0002J\t\u0010ï\u0001\u001a\u00020@H\u0002J\u0012\u0010ð\u0001\u001a\u00020@2\u0007\u0010ñ\u0001\u001a\u00020\u0017H\u0002J\t\u0010ò\u0001\u001a\u00020@H\u0002J\u0013\u0010ó\u0001\u001a\u00020\u001a2\b\u0010ô\u0001\u001a\u00030õ\u0001H\u0002J\r\u0010ö\u0001\u001a\u00020F*\u00020WH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R\u0017\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ø\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "Ltv/danmaku/biliplayerv2/service/IPlayerClockChangedObserver;", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$Callback;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFilterContainer$DanmakuFilterChangedListener;", "chronosService", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IChronosRemoteService;", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IChronosRemoteService;)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mScheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "mAddCustomDanmakuReq", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$Request;", "mOnlineInfoReq", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OnlineInfoChange$Request;", "mCommandDms", "", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsDanmaku;", "mChronosViewPort", "Landroid/graphics/Rect;", "mMultiDanmaku", "", "mIsRun", "displayDensity", "", "chronosView", "Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;", "cidCheckEnable", "cidCheckIntercept", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IChronosRemoteCidCheckIntercept;", "messageSenderImpl", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$messageSenderImpl$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$messageSenderImpl$1;", "mChronosRpcSender", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageSender;", "mSubtitleChangedObserver", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mSubtitleChangedObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mSubtitleChangedObserver$1;", "mDanmakuParamsObserver", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mDanmakuParamsObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mDanmakuParamsObserver$1;", "mControlContainerObserver", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mControlContainerObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mControlContainerObserver$1;", "mPlayerSettingsObserver", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mPlayerSettingsObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mPlayerSettingsObserver$1;", "mDanmakuSettingsObserver", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mDanmakuSettingsObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mDanmakuSettingsObserver$1;", "mVideoPlayEventListener", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mVideoPlayEventListener$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mVideoPlayEventListener$1;", "mDanmakuSeniorModeSwitchObserve", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mDanmakuSeniorModeSwitchObserve$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mDanmakuSeniorModeSwitchObserve$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$mPlayerStateObserver$1;", "getChronosMessageSender", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/protocol/IChronosRpcSender;", "initChronosView", "", "view", "onReceiveChronosGestureAction", "x", "y", "gesture", "", "state", "touchAction", "(FFLjava/lang/Integer;ILjava/lang/Integer;)V", "onCommercialEventChanged", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommercialEventChanged$Request;", "updateDanmakuParam", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "restore", "onStart", "multiPlayer", "onBindPlayerContainer", "playerContainer", "onStop", "onSaveState", "", "toBackground", "onPlayerControlBarChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlayerControlBarChange$Request;", "onDanmakuFilterChanged", "userHashList", "regexList", "contentList", "force", "onPlayerClockChanged", "speed", "currentPosition", "", "updateCurrentWorkInfo", "param", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Response;", "notifyWorkInfoChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/WorkInfoChange$Request;", "onSegmentSettingChanged", "enabled", "onForcedChapterGuide", "onEyesProtectionModeChanged", "onOnlineInfoChanged", "sendOnlineDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDanmakuSent$Request;", "onSceneAndBizChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/SceneBizChange$Request;", "onVideoDetailStateChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/VideoDetailStateChange$Request;", "onPreferenceChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PreferenceChange$Request;", "updateCurrentWorkChanged", "workId", "videoId", "updateRelationshipChainChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ShipChainChange$Request;", "onCommandDanmakuDeleted", "commandDanmaku", "onAccountStateChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/UserInfoChange$Request;", "requestRpcDanmakuList", "type", "onComplete", "Lkotlin/Function1;", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "Lkotlin/ParameterName;", "name", "result", "reCallDanmaku", "danmakuId", "deleteDanmaku", "danmakuIds", "", "userHashArray", "contents", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V", "likeDanmaku", "liked", "likeCount", "replyCount", "onBusinessDataChanged", LoginSceneProcessor.BIZ_KEY, "data", "", "getCommandDanmakus", "getChronosCommandDanmakus", "appendCommandDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/ChronosDanmakuSender$CommandDanmakuSendResponse;", "appendFilters", "shieldUserId", "regexFilter", "nativeId", "onSuccess", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Runnable;)V", "filtersChanged", "setDanmakuExposureParam", "avid", "cid", "replyDanmakuId", "adDanmakuExposureRequest", "danmakus", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "addDanmaku", "item", "dmId", "extra", "emoExtra", "", "", "save", "token", "restorePackage", "onNetWorkSateChanged", "onWindowInsetChanged", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "onDanmakuVisibleChanged", "visible", "onViewPortUpdate", "viewPort", "setCommandDanmakus", "configChronos", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "playbackStatusRequestFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlaybackStatusChange$Request;", "errors", "onVideoSeeking", "previewPosition", "onVideoSpeeding", "status", "onDanmakuSendSuccess", "commentItem", "Ljava/util/HashMap;", "setVisibleRect", "rect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "onCommandDanmakuSentSuccess", "onOgvTimelineMaterialChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVTimelineMaterialChange$Request;", "onPUGVInfoChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PUGVInfoChange$Request;", "onDubbingPanelChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVDubbingResult$Request;", "onPlayerComponentsHeightChanged", "panelHeight", "totalHeight", "setCidCheckIntercept", "intercept", "onPermissionChanged", "granted", "permission", "configCommandDanmaku", "configExposureDanmaku", "configOnlineInfoParam", "configAppPlayerSetting", "scheduleClockChanged", "playing", "onVideoSizeChanged", "renderBounds", "transformParams", "Ltv/danmaku/render/core/TransformParams;", "dispatchRpcGesture", "dispatchRpcTouch", "action", "stopScheduledFuture", "cancelScheduledFuture", "updateSubtitleLocationWithViewport", "bottomBlock", "onMaskVisibleChanged", "onDanmakuFoldSwitchChanged", "enable", "onDanmakuFilterSwitchChanged", "safeToRadians", "degree", "", "safeToInt", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RemoteServiceHandler implements IRemoteHandler, IPlayerClockChangedObserver, ChronosDanmakuSender.Callback, DanmakuFilterContainer.DanmakuFilterChangedListener {
    private static final int DANMAKU_FROM_AD = 101;
    private static final int DANMAKU_FROM_MESSAGE_CENTER = 100;
    private static final int DANMAKU_REPLY_FROM_MESSAGE_CENTER = 102;
    private static final int ERROR_CODE_RESOLVE = -5001;
    private static final String TAG = "RemoteServiceHandler";
    private final IChronosRemoteService chronosService;
    private EnhancedChronosPackageRunner<?> chronosView;
    private final boolean cidCheckEnable;
    private IChronosRemoteCidCheckIntercept cidCheckIntercept;
    private float displayDensity;
    private AddCustomDanmaku.Request mAddCustomDanmakuReq;
    private final ChronosMessageSender mChronosRpcSender;
    private Rect mChronosViewPort;
    private List<CommandsDanmaku> mCommandDms;
    private final RemoteServiceHandler$mControlContainerObserver$1 mControlContainerObserver;
    private final RemoteServiceHandler$mDanmakuParamsObserver$1 mDanmakuParamsObserver;
    private final RemoteServiceHandler$mDanmakuSeniorModeSwitchObserve$1 mDanmakuSeniorModeSwitchObserve;
    private final RemoteServiceHandler$mDanmakuSettingsObserver$1 mDanmakuSettingsObserver;
    private boolean mIsRun;
    private boolean mMultiDanmaku;
    private OnlineInfoChange.Request mOnlineInfoReq;
    private PlayerContainer mPlayerContainer;
    private final RemoteServiceHandler$mPlayerSettingsObserver$1 mPlayerSettingsObserver;
    private final RemoteServiceHandler$mPlayerStateObserver$1 mPlayerStateObserver;
    private ScheduledFuture<?> mScheduledFuture;
    private final RemoteServiceHandler$mSubtitleChangedObserver$1 mSubtitleChangedObserver;
    private final RemoteServiceHandler$mVideoPlayEventListener$1 mVideoPlayEventListener;
    private final RemoteServiceHandler$messageSenderImpl$1 messageSenderImpl;
    private final MutableSharedFlow<PlaybackStatusChange.Request> playbackStatusRequestFlow;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Boolean> hitLeakFix$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean hitLeakFix_delegate$lambda$0;
            hitLeakFix_delegate$lambda$0 = RemoteServiceHandler.hitLeakFix_delegate$lambda$0();
            return Boolean.valueOf(hitLeakFix_delegate$lambda$0);
        }
    });
    private static final ScheduledThreadPoolExecutor sStatusRepeatExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda3
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread sStatusRepeatExecutor$lambda$0;
            sStatusRepeatExecutor$lambda$0 = RemoteServiceHandler.sStatusRepeatExecutor$lambda$0(runnable);
            return sStatusRepeatExecutor$lambda$0;
        }
    });

    /* JADX WARN: Type inference failed for: r0v10, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mDanmakuParamsObserver$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mControlContainerObserver$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mPlayerSettingsObserver$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mDanmakuSettingsObserver$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mVideoPlayEventListener$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mDanmakuSeniorModeSwitchObserve$1] */
    /* JADX WARN: Type inference failed for: r0v16, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mPlayerStateObserver$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$messageSenderImpl$1] */
    public RemoteServiceHandler(IChronosRemoteService chronosService) {
        Intrinsics.checkNotNullParameter(chronosService, "chronosService");
        this.chronosService = chronosService;
        this.mCommandDms = new ArrayList();
        this.mIsRun = true;
        this.displayDensity = 1.0f;
        this.cidCheckEnable = ConfigManager.Companion.isHitFF("ff_danmaku_sent_cid_check");
        this.messageSenderImpl = new ChronosRpcMessageSender() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$messageSenderImpl$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRpcMessageSender
            public <T, U> Pair<U, Map<String, byte[]>> sendMessageSync(ChronosSyncMessage<T, U> chronosSyncMessage) {
                EnhancedChronosPackageRunner enhancedChronosPackageRunner;
                Intrinsics.checkNotNullParameter(chronosSyncMessage, "chronosSyncMessage");
                BLog.d("RemoteServiceHandler", "sendMessageSync " + chronosSyncMessage.getRequest());
                enhancedChronosPackageRunner = RemoteServiceHandler.this.chronosView;
                if (enhancedChronosPackageRunner != null) {
                    return enhancedChronosPackageRunner.sendMessageSync(chronosSyncMessage.getRequest(), chronosSyncMessage.getExtra(), chronosSyncMessage.getResponse(), chronosSyncMessage.getTimeout());
                }
                return null;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRpcMessageSender
            public <T, U> void sendMessageAsync(ChronosAsyncMessage<T, U> chronosAsyncMessage) {
                EnhancedChronosPackageRunner enhancedChronosPackageRunner;
                EnhancedChronosPackageRunner enhancedChronosPackageRunner2;
                Intrinsics.checkNotNullParameter(chronosAsyncMessage, "chronosAsyncMsg");
                BLog.d("RemoteServiceHandler", "sendMessageAsync " + chronosAsyncMessage.getRequest());
                if (chronosAsyncMessage.getOnComplete() != null || chronosAsyncMessage.getOnError() != null) {
                    enhancedChronosPackageRunner = RemoteServiceHandler.this.chronosView;
                    if (enhancedChronosPackageRunner != null) {
                        enhancedChronosPackageRunner.sendMessageAsync(chronosAsyncMessage.getRequest(), chronosAsyncMessage.getExtra(), chronosAsyncMessage.getResponse(), chronosAsyncMessage.getOnComplete(), chronosAsyncMessage.getOnError());
                        return;
                    }
                    return;
                }
                enhancedChronosPackageRunner2 = RemoteServiceHandler.this.chronosView;
                if (enhancedChronosPackageRunner2 != null) {
                    enhancedChronosPackageRunner2.sendMessageAsync(chronosAsyncMessage.getRequest(), chronosAsyncMessage.getExtra());
                }
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRpcMessageSender
            public boolean isChronosValid() {
                EnhancedChronosPackageRunner enhancedChronosPackageRunner;
                enhancedChronosPackageRunner = RemoteServiceHandler.this.chronosView;
                return enhancedChronosPackageRunner != null && enhancedChronosPackageRunner.isValid();
            }
        };
        this.mChronosRpcSender = new ChronosMessageSender(this.messageSenderImpl);
        this.mSubtitleChangedObserver = new RemoteServiceHandler$mSubtitleChangedObserver$1(this);
        this.mDanmakuParamsObserver = new IDanmakuParamsChangeObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mDanmakuParamsObserver$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuParamsChangeObserver
            public void onChanged(DanmakuParams params) {
                Intrinsics.checkNotNullParameter(params, "params");
                IRemoteHandler.CC.updateDanmakuParam$default(RemoteServiceHandler.this, params, false, 2, null);
            }
        };
        this.mControlContainerObserver = new ControlContainerObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mControlContainerObserver$1
            @Override // tv.danmaku.biliplayerv2.service.ControlContainerObserver
            public void onControlContainerChanged(ControlContainerType state, ScreenModeType screenType) {
                ChronosMessageSender chronosMessageSender;
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(screenType, "screenType");
                ScreenStateChange.Request req = new ScreenStateChange.Request();
                req.setFullScreen(Boolean.valueOf(screenType == ScreenModeType.LANDSCAPE_FULLSCREEN || screenType == ScreenModeType.VERTICAL_FULLSCREEN));
                chronosMessageSender = RemoteServiceHandler.this.mChronosRpcSender;
                IChronosRpcSender.CC.sendAsyncMessage$default(chronosMessageSender, req, null, 2, null);
            }
        };
        this.mPlayerSettingsObserver = new PlayerSettingChangeObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mPlayerSettingsObserver$1
            @Override // tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver
            public void onChange(String key) {
                PlayerContainer playerContainer;
                Intrinsics.checkNotNullParameter(key, "key");
                switch (key.hashCode()) {
                    case -899891919:
                        if (key.equals(DanmakuKeys.PREF_DANMAKU_FOLD)) {
                            RemoteServiceHandler remoteServiceHandler = RemoteServiceHandler.this;
                            playerContainer = RemoteServiceHandler.this.mPlayerContainer;
                            if (playerContainer == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                                playerContainer = null;
                            }
                            remoteServiceHandler.onDanmakuFoldSwitchChanged(playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_FOLD, true));
                            return;
                        }
                        return;
                    case -717005701:
                        if (key.equals(DanmakuKeys.KEY_DANMAKU_MASK_SWITCH)) {
                            RemoteServiceHandler.this.onMaskVisibleChanged();
                            return;
                        }
                        return;
                    case 1127870354:
                        if (key.equals(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST)) {
                            RemoteServiceHandler.this.onDanmakuFilterSwitchChanged();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mDanmakuSettingsObserver = new IDanmakuSettingsChangedObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mDanmakuSettingsObserver$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuSettingsChangedObserver
            public void onParamChanged(DanmakuConfig.DanmakuOptionName name, DanmakuParams params) {
                ChronosMessageSender chronosMessageSender;
                ChronosMessageSender chronosMessageSender2;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(params, "params");
                DanmakuConfigChange.Request it = DanmakuConfigChange.Request.Companion.create(name, params);
                if (it != null) {
                    chronosMessageSender2 = RemoteServiceHandler.this.mChronosRpcSender;
                    chronosMessageSender2.onDanmakuConfigChanged(it);
                }
                DanmakuFilterChange.Request it2 = DanmakuFilterChange.Request.Companion.create(name, params);
                if (it2 != null) {
                    chronosMessageSender = RemoteServiceHandler.this.mChronosRpcSender;
                    chronosMessageSender.onDanmakuFilterChanged(it2);
                }
            }
        };
        this.mVideoPlayEventListener = new VideoDirectorObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mVideoPlayEventListener$1
            @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
            public /* synthetic */ void onItemCompleted(Video.PlayableParams playableParams) {
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            }

            @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
            public /* synthetic */ void onItemStart(Video.PlayableParams playableParams) {
                Intrinsics.checkNotNullParameter(playableParams, "item");
            }

            @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
            public /* synthetic */ void onPlayableParamsChanged(Video.PlayableParams playableParams) {
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            }

            @Override // tv.danmaku.biliplayerv2.service.ResolveListener
            public /* synthetic */ void onResolveSucceed(Video.PlayableParams playableParams) {
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            }

            @Override // tv.danmaku.biliplayerv2.service.ResolveListener
            public void onResolveFailed(Video.PlayableParams playableParams, String errorMsg) {
                PlayerContainer playerContainer;
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
                playerContainer = RemoteServiceHandler.this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                int position = playerContainer.getPlayerCoreService().getCurrentPosition();
                RemoteServiceHandler.this.onPlayerClockChanged(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, position, MapsKt.mapOf(new Pair(errorMsg == null ? "" : errorMsg, -5001)));
            }

            @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
            public void onItemWillChange(Video.PlayableParams playableParams, Video.PlayableParams old) {
                List list;
                Intrinsics.checkNotNullParameter(playableParams, "new");
                list = RemoteServiceHandler.this.mCommandDms;
                list.clear();
            }
        };
        this.mDanmakuSeniorModeSwitchObserve = new IDanmakuSeniorModeChangeObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mDanmakuSeniorModeSwitchObserve$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuSeniorModeChangeObserver
            public void onSwitchChange(int i) {
                ChronosMessageSender chronosMessageSender;
                DanmakuFilterChange.Request it = DanmakuFilterChange.Request.Companion.create(DanmakuConfig.DanmakuOptionName.DANMAKU_SENIOR_MODE, (DanmakuConfig.DanmakuOptionName) Integer.valueOf(i));
                if (it != null) {
                    chronosMessageSender = RemoteServiceHandler.this.mChronosRpcSender;
                    chronosMessageSender.onDanmakuFilterChanged(it);
                }
            }
        };
        this.mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$mPlayerStateObserver$1
            @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
            public void onPlayerStateChanged(int state) {
                switch (state) {
                    case 0:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                        RemoteServiceHandler.this.cancelScheduledFuture();
                        return;
                    default:
                        return;
                }
            }
        };
        this.playbackStatusRequestFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    /* compiled from: RemoteServiceHandler.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/RemoteServiceHandler$Companion;", "", "<init>", "()V", "TAG", "", "ERROR_CODE_RESOLVE", "", "DANMAKU_FROM_MESSAGE_CENTER", "DANMAKU_FROM_AD", "DANMAKU_REPLY_FROM_MESSAGE_CENTER", "hitLeakFix", "", "getHitLeakFix", "()Z", "hitLeakFix$delegate", "Lkotlin/Lazy;", "sStatusRepeatExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHitLeakFix() {
            return ((Boolean) RemoteServiceHandler.hitLeakFix$delegate.getValue()).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitLeakFix_delegate$lambda$0() {
        boolean it = DeviceDecision.INSTANCE.getBoolean("ff_story_leak_fix_875", true);
        BLog.i(TAG, "hitLeakFix = " + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread sStatusRepeatExecutor$lambda$0(Runnable r) {
        Thread thread = new Thread(r, "playbackStatusThread");
        thread.setDaemon(true);
        return thread;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public IChronosRpcSender getChronosMessageSender() {
        return this.mChronosRpcSender;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void initChronosView(EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner) {
        this.chronosView = enhancedChronosPackageRunner;
        this.mChronosRpcSender.onChronosValid();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onReceiveChronosGestureAction(float x, float y, Integer gesture, int state, Integer touchAction) {
        if (touchAction != null) {
            int it = touchAction.intValue();
            dispatchRpcTouch(x, y, it);
        } else if (gesture != null) {
            int it2 = gesture.intValue();
            dispatchRpcGesture(x, y, it2, state);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onCommercialEventChanged(CommercialEventChanged.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void updateDanmakuParam(DanmakuParams params, boolean restore) {
        Video.DanmakuResolveParams danmakuParams;
        Intrinsics.checkNotNullParameter(params, "params");
        DmViewReply dmReply = params.getDmViewReply();
        if (dmReply == null) {
            return;
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        if (currentPlayableParams == null || (danmakuParams = currentPlayableParams.getDanmakuResolveParams()) == null) {
            return;
        }
        BLog.i("update dmview params", "workid=" + danmakuParams.getAvid() + ", videoid=" + danmakuParams.getCid());
        DmViewChange.Request dmReq = new DmViewChange.Request();
        dmReq.setWorkId(String.valueOf(danmakuParams.getAvid()));
        dmReq.setVideoId(String.valueOf(danmakuParams.getCid()));
        this.mChronosRpcSender.sendAsyncMessage(dmReq, MapsKt.mapOf(TuplesKt.to("reply", dmReply.toByteArray())));
        if (restore) {
            DanmakuConfigChange.Request config = DanmakuConfigChange.Request.Companion.create(params);
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer3 = null;
            }
            config.setMaskEnabled(Boolean.valueOf(playerContainer3.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, true)));
            this.mChronosRpcSender.onDanmakuConfigChanged(config);
            DanmakuFilterChange.Request filters = DanmakuFilterChange.Request.Companion.create(params);
            this.mChronosRpcSender.onDanmakuFilterChanged(filters);
        } else {
            onMaskVisibleChanged();
        }
        DanmakuFilterContainer danmakuFilterContainer = this.chronosService.getDanmakuFilterContainer();
        List<String> reportFilterContentList = dmReply.getReportFilterContentList();
        Intrinsics.checkNotNullExpressionValue(reportFilterContentList, "getReportFilterContentList(...)");
        danmakuFilterContainer.setDmViewRegexFilters(reportFilterContentList, !restore);
        onDanmakuFoldSwitchChanged(dmReply.getPlayerConfig().getDanmukuPlayerConfig().getPlayerDanmakuEnableHerdDm());
        BLog.i(TAG, ": danmaku params changed, resolve danmaku filter.");
        DanmakuFilterContainer danmakuFilterContainer2 = this.chronosService.getDanmakuFilterContainer();
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        danmakuFilterContainer2.loadLocalFilters(playerContainer2.getContext());
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onStart(boolean multiPlayer) {
        DisplayMetrics displayMetrics;
        this.mIsRun = true;
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        Resources resources = playerContainer.getContext().getResources();
        this.displayDensity = (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1.0f : displayMetrics.density;
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getInteractLayerService().registerDanmakuSeniorModeChangeObserve(this.mDanmakuSeniorModeSwitchObserve);
        this.chronosService.getDanmakuFilterContainer().setDanmakuFilterChangedListener(this);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer4 = null;
        }
        playerContainer4.getInteractLayerService().addSubtitleChangedObserver(this.mSubtitleChangedObserver);
        PlayerContainer playerContainer5 = this.mPlayerContainer;
        if (playerContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer5 = null;
        }
        playerContainer5.getInteractLayerService().addDanmakuParamsChangedObserver(this.mDanmakuParamsObserver);
        PlayerContainer playerContainer6 = this.mPlayerContainer;
        if (playerContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer6 = null;
        }
        playerContainer6.getPlayerSettingService().addPlayerSettingChangeObserver(this.mPlayerSettingsObserver, DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, DanmakuKeys.PREF_DANMAKU_FOLD);
        PlayerContainer playerContainer7 = this.mPlayerContainer;
        if (playerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer7 = null;
        }
        playerContainer7.getInteractLayerService().addDanmakuSettingsChangedObserver(this.mDanmakuSettingsObserver);
        if (!multiPlayer) {
            ChronosDanmakuSender danmakuSender = new ChronosDanmakuSender(this);
            PlayerContainer playerContainer8 = this.mPlayerContainer;
            if (playerContainer8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer8 = null;
            }
            playerContainer8.getInteractLayerService().setDanmakuSender(danmakuSender);
            PlayerContainer playerContainer9 = this.mPlayerContainer;
            if (playerContainer9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer9 = null;
            }
            playerContainer9.getControlContainerService().registerState(this.mControlContainerObserver);
            PlayerContainer playerContainer10 = this.mPlayerContainer;
            if (playerContainer10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer10 = null;
            }
            playerContainer10.getPlayerCoreService().addPlayerClockChangedObserver(this);
            PlayerContainer playerContainer11 = this.mPlayerContainer;
            if (playerContainer11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer11 = null;
            }
            PlayerContainerKt.getPlayDirector(playerContainer11).addVideoDirectorObserver(this.mVideoPlayEventListener);
            PlayerContainer playerContainer12 = this.mPlayerContainer;
            if (playerContainer12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer2 = playerContainer12;
            }
            playerContainer2.getPlayerCoreService().registerState(this.mPlayerStateObserver, 6, 8, 7, 0, 10);
        } else {
            PlayerContainer playerContainer13 = this.mPlayerContainer;
            if (playerContainer13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer13 = null;
            }
            if (playerContainer13.getInteractLayerService().getMainSubtitle() != null) {
                RemoteServiceHandler$mSubtitleChangedObserver$1 remoteServiceHandler$mSubtitleChangedObserver$1 = this.mSubtitleChangedObserver;
                PlayerContainer playerContainer14 = this.mPlayerContainer;
                if (playerContainer14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer14 = null;
                }
                SubtitleItem mainSubtitle = playerContainer14.getInteractLayerService().getMainSubtitle();
                PlayerContainer playerContainer15 = this.mPlayerContainer;
                if (playerContainer15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainer2 = playerContainer15;
                }
                remoteServiceHandler$mSubtitleChangedObserver$1.onSubtitleChanged(mainSubtitle, playerContainer2.getInteractLayerService().getInitViceSubtitle());
            }
        }
        this.mMultiDanmaku = multiPlayer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onBindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer), (CoroutineContext) null, (CoroutineStart) null, new RemoteServiceHandler$onBindPlayerContainer$1(this, playerContainer, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onStop() {
        this.mIsRun = false;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getInteractLayerService().unregisterDanmakuSeniorModeChangeObserve(this.mDanmakuSeniorModeSwitchObserve);
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        playerContainer2.getInteractLayerService().removeSubtitleChangedObserver(this.mSubtitleChangedObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getControlContainerService().unregisterState(this.mControlContainerObserver);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer4 = null;
        }
        playerContainer4.getInteractLayerService().removeDanmakuParamsChangedObserver(this.mDanmakuParamsObserver);
        PlayerContainer playerContainer5 = this.mPlayerContainer;
        if (playerContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer5 = null;
        }
        playerContainer5.getPlayerSettingService().removePlayerSettingChangeObserver(this.mPlayerSettingsObserver);
        PlayerContainer playerContainer6 = this.mPlayerContainer;
        if (playerContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer6 = null;
        }
        playerContainer6.getInteractLayerService().removeDanmakuSettingsChangedObserver(this.mDanmakuSettingsObserver);
        PlayerContainer playerContainer7 = this.mPlayerContainer;
        if (playerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer7 = null;
        }
        playerContainer7.getPlayerCoreService().removePlayerClockChangedObserver(this);
        PlayerContainer playerContainer8 = this.mPlayerContainer;
        if (playerContainer8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer8 = null;
        }
        PlayerContainerKt.getPlayDirector(playerContainer8).removeVideoDirectorObserver(this.mVideoPlayEventListener);
        PlayerContainer playerContainer9 = this.mPlayerContainer;
        if (playerContainer9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer9 = null;
        }
        playerContainer9.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
        this.chronosService.getDanmakuFilterContainer().release();
        stopScheduledFuture();
        this.chronosView = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public String onSaveState() {
        String token = String.valueOf(System.currentTimeMillis());
        save(token);
        return token;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void toBackground() {
        stopScheduledFuture();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onPlayerControlBarChanged(PlayerControlBarChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, PlayerControlBarChange.Response.class, null, null, 24, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer.DanmakuFilterChangedListener
    public void onDanmakuFilterChanged(List<String> list, List<String> list2, List<String> list3, boolean force) {
        Intrinsics.checkNotNullParameter(list, "userHashList");
        Intrinsics.checkNotNullParameter(list2, "regexList");
        Intrinsics.checkNotNullParameter(list3, "contentList");
        if (!force) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            if (!playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true)) {
                BLog.d(TAG, "danmaku block list disable");
                return;
            }
        }
        DanmakuFilterChange.Request $this$onDanmakuFilterChanged_u24lambda_u240 = new DanmakuFilterChange.Request();
        List<String> $this$toTypedArray$iv = list;
        $this$onDanmakuFilterChanged_u24lambda_u240.setUserHashBlockList((String[]) $this$toTypedArray$iv.toArray(new String[0]));
        List<String> $this$toTypedArray$iv2 = list2;
        $this$onDanmakuFilterChanged_u24lambda_u240.setRegexBlockList((String[]) $this$toTypedArray$iv2.toArray(new String[0]));
        List<String> $this$toTypedArray$iv3 = list3;
        $this$onDanmakuFilterChanged_u24lambda_u240.setContentBlockList((String[]) $this$toTypedArray$iv3.toArray(new String[0]));
        $this$onDanmakuFilterChanged_u24lambda_u240.setBlockEnable(true);
        this.mChronosRpcSender.onDanmakuFilterChanged($this$onDanmakuFilterChanged_u24lambda_u240);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerClockChangedObserver
    public void onPlayerClockChanged(float speed, long currentPosition) {
        onPlayerClockChanged(speed, currentPosition, null);
        scheduleClockChanged(speed > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void updateCurrentWorkInfo(GetWorkInfo.Response param) {
        Intrinsics.checkNotNullParameter(param, "param");
        WorkInfoChange.Request req = new WorkInfoChange.Request();
        req.setWorkId(param.getWorkId());
        req.setWorkTitle(param.getWorkTitle());
        req.setVideoList(param.getVideoList());
        req.setVideoId(param.getVideoId());
        req.setVideoTitle(param.getVideoTitle());
        req.setDuration(param.getDuration());
        req.setUpperId(param.getUpperId());
        req.setUpperName(param.getUpperName());
        req.setUpperAvatar(param.getUpperAvatar());
        req.setSessionId(param.getSessionId());
        req.setEpId(param.getEpId());
        req.setSeasonId(param.getSeasonId());
        req.setSeasonType(param.getSeasonType());
        req.setHasPaymentToast(param.getHasPaymentToast());
        req.setControlList(param.getControlList());
        req.setCommercial(param.getCommercial());
        req.setAttachment(param.getAttachment());
        req.setWorkState(param.getWorkState());
        notifyWorkInfoChanged(req);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void notifyWorkInfoChanged(WorkInfoChange.Request param) {
        Intrinsics.checkNotNullParameter(param, "param");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, param, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onSegmentSettingChanged(boolean enabled) {
        FeatureListChange.Request req = new FeatureListChange.Request();
        req.setChapterGuide(Boolean.valueOf(enabled));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onForcedChapterGuide(boolean enabled) {
        FeatureListChange.Request req = new FeatureListChange.Request();
        req.setForcedChapterGuide(Boolean.valueOf(enabled));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onEyesProtectionModeChanged(boolean enabled) {
        FeatureListChange.Request req = new FeatureListChange.Request();
        req.setEyesProtectionMode(Boolean.valueOf(enabled));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onOnlineInfoChanged(OnlineInfoChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.mOnlineInfoReq = req;
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void sendOnlineDanmaku(CommandDanmakuSent.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onSceneAndBizChanged(SceneBizChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onVideoDetailStateChanged(VideoDetailStateChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        List<VideoDetailStateChange.FollowState> followStates = req.getFollowStates();
        if ((followStates == null || followStates.isEmpty()) && req.getReserveState() == null && req.getClockInState() == null && req.getUpChargeState() == null && req.getVoteState() == null) {
            return;
        }
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onPreferenceChanged(PreferenceChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void updateCurrentWorkChanged(String workId, String videoId) {
        Intrinsics.checkNotNullParameter(workId, "workId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        WorkChange.Request $this$updateCurrentWorkChanged_u24lambda_u240 = new WorkChange.Request();
        $this$updateCurrentWorkChanged_u24lambda_u240.setWorkId(workId);
        $this$updateCurrentWorkChanged_u24lambda_u240.setVideoId(videoId);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, $this$updateCurrentWorkChanged_u24lambda_u240, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void updateRelationshipChainChanged(ShipChainChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onCommandDanmakuDeleted(CommandsDanmaku commandDanmaku) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(commandDanmaku, "commandDanmaku");
        List commands = this.mCommandDms;
        Iterator<T> it = commands.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            CommandsDanmaku it2 = (CommandsDanmaku) obj;
            if (it2.getId() == commandDanmaku.getId()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        CommandsDanmaku item = (CommandsDanmaku) obj;
        if (item == null) {
            return;
        }
        commands.remove(item);
        CommandDanmakuDeleted.Request req = new CommandDanmakuDeleted.Request();
        req.setDanmakuId(commandDanmaku.getIdStr());
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onAccountStateChanged(UserInfoChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void requestRpcDanmakuList(int type, final Function1<? super List<? extends CommentItem>, Unit> function1) {
        DanmakuList.Request req = new DanmakuList.Request();
        req.setType(Integer.valueOf(type));
        this.mChronosRpcSender.requestDanmakuList(req, new Function2() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit requestRpcDanmakuList$lambda$0;
                requestRpcDanmakuList$lambda$0 = RemoteServiceHandler.requestRpcDanmakuList$lambda$0(function1, (DanmakuList.Response) obj, (Map) obj2);
                return requestRpcDanmakuList$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit requestRpcDanmakuList$lambda$1;
                requestRpcDanmakuList$lambda$1 = RemoteServiceHandler.requestRpcDanmakuList$lambda$1((Integer) obj, (String) obj2);
                return requestRpcDanmakuList$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestRpcDanmakuList$lambda$0(Function1 $onComplete, DanmakuList.Response response, Map map) {
        Iterable danmakuList;
        Long longOrNull;
        List result = new ArrayList();
        if (response != null && (danmakuList = response.getDanmakuList()) != null) {
            Iterable $this$forEach$iv = danmakuList;
            for (Object element$iv : $this$forEach$iv) {
                DanmakuList.DanmakuItem it = (DanmakuList.DanmakuItem) element$iv;
                CommentItem item = CommentItemFactory.createComment(it.getMode());
                item.setTimeInMilliSeconds(it.getAppearanceTime());
                item.setBody(it.getContent());
                item.setDamakuSenderHash(it.getUserHash());
                item.weight = it.getWeight();
                item.setDmId(it.getDanmakuId());
                String oid = it.getOid();
                item.cid = (oid == null || (longOrNull = StringsKt.toLongOrNull(oid)) == null) ? 0L : longOrNull.longValue();
                item.showReply = Intrinsics.areEqual(it.getReplyable(), true);
                Intrinsics.checkNotNullExpressionValue(item, "apply(...)");
                result.add(item);
            }
        }
        if ($onComplete != null) {
            $onComplete.invoke(result);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestRpcDanmakuList$lambda$1(Integer code, String desc) {
        BLog.d(TAG, "requestRpcDanmakuList error, code=" + code + ", desc=" + desc);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void reCallDanmaku(String danmakuId) {
        Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
        DanmakuRecall.Request req = new DanmakuRecall.Request();
        req.setDanmakuId(danmakuId);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void deleteDanmaku(String[] danmakuIds, String[] userHashArray, String[] contents) {
        Intrinsics.checkNotNullParameter(danmakuIds, "danmakuIds");
        DanmakuDeleted.Request req = new DanmakuDeleted.Request();
        req.setDanmakuIds(danmakuIds);
        req.setUserHashArray(userHashArray);
        req.setContents(contents);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void likeDanmaku(String videoId, boolean liked, String danmakuId, int likeCount, int replyCount) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
        if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
            return;
        }
        DanmakuLiked.Request req = new DanmakuLiked.Request();
        req.setVideoId(videoId);
        req.setDanmakuId(danmakuId);
        req.setLiked(Boolean.valueOf(liked));
        req.setLikeCount(Integer.valueOf(likeCount));
        req.setReplyCount(Integer.valueOf(replyCount));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onBusinessDataChanged(String business, Object data) {
        BusinessDataChanged.Request req = new BusinessDataChanged.Request();
        req.setBusiness(business);
        req.setData(data);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    @Deprecated(message = "use getChronosCommandDanmakus")
    public List<CommandsDanmaku> getCommandDanmakus() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.mCommandDms);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void getChronosCommandDanmakus(final Function1<? super List<CommandsDanmaku>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        this.mChronosRpcSender.sendAsyncMessage(new CommandDmListRequest.Request(), null, CommandDmListRequest.Response.class, new Function2() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit chronosCommandDanmakus$lambda$0;
                chronosCommandDanmakus$lambda$0 = RemoteServiceHandler.getChronosCommandDanmakus$lambda$0(function1, (CommandDmListRequest.Response) obj, (Map) obj2);
                return chronosCommandDanmakus$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit chronosCommandDanmakus$lambda$1;
                chronosCommandDanmakus$lambda$1 = RemoteServiceHandler.getChronosCommandDanmakus$lambda$1((Integer) obj, (String) obj2);
                return chronosCommandDanmakus$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getChronosCommandDanmakus$lambda$0(Function1 $onComplete, CommandDmListRequest.Response response, Map map) {
        List emptyList;
        Iterable danmakuList;
        Long longOrNull;
        Long longOrNull2;
        Long longOrNull3;
        List<CommandDmListRequest.CommandDmItem> danmakuList2;
        BLog.i(TAG, "getChronosCommandDanmakus success, " + ((response == null || (danmakuList2 = response.getDanmakuList()) == null) ? null : Integer.valueOf(danmakuList2.size())));
        if (response == null || (danmakuList = response.getDanmakuList()) == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Iterable $this$map$iv = danmakuList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                CommandDmListRequest.CommandDmItem it = (CommandDmListRequest.CommandDmItem) item$iv$iv;
                CommandsDanmaku $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240 = new CommandsDanmaku();
                String danmakuId = it.getDanmakuId();
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setId((danmakuId == null || (longOrNull3 = StringsKt.toLongOrNull(danmakuId)) == null) ? 0L : longOrNull3.longValue());
                String oid = it.getOid();
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setOid((oid == null || (longOrNull2 = StringsKt.toLongOrNull(oid)) == null) ? 0L : longOrNull2.longValue());
                String mid = it.getMid();
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setMid((mid == null || (longOrNull = StringsKt.toLongOrNull(mid)) == null) ? 0L : longOrNull.longValue());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setCommand(it.getCommand());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setContent(it.getContent());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setProgress((int) it.getProgress());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setCtime(it.getCtime());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setMtime(it.getMtime());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setExtra(it.getExtra());
                $this$getChronosCommandDanmakus_u24lambda_u240_u240_u240.setIdStr(it.getDanmakuId());
                destination$iv$iv.add($this$getChronosCommandDanmakus_u24lambda_u240_u240_u240);
            }
            emptyList = (List) destination$iv$iv;
        }
        List result = emptyList;
        $onComplete.invoke(result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getChronosCommandDanmakus$lambda$1(Integer code, String desc) {
        BLog.e(TAG, "getChronosCommandDanmakus error, code=" + code + ", desc=" + desc);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void appendCommandDanmaku(ChronosDanmakuSender.CommandDanmakuSendResponse commandDanmaku) {
        Intrinsics.checkNotNullParameter(commandDanmaku, "commandDanmaku");
        onCommandDanmakuSentSuccess(commandDanmaku);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void appendFilters(String shieldUserId, String regexFilter, Long nativeId, Runnable onSuccess) {
        DanmakuFilterContainer danmakuFilterContainer = this.chronosService.getDanmakuFilterContainer();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        danmakuFilterContainer.appendFilters(playerContainer.getContext(), shieldUserId, regexFilter, nativeId, onSuccess);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void filtersChanged() {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        Collection collection;
        Collection collection2;
        Collection collection3;
        DanmakuFilterChange.Request filters = new DanmakuFilterChange.Request();
        DanmakuFilterContainer danmakuFilterContainer = this.chronosService.getDanmakuFilterContainer();
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        Triple filtersTripleList = danmakuFilterContainer.resolveDanamkuFilters(playerContainer.getContext(), null, null);
        if (filtersTripleList == null || (collection3 = (List) filtersTripleList.getFirst()) == null) {
            strArr = null;
        } else {
            Collection $this$toTypedArray$iv = collection3;
            strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        }
        filters.setUserHashBlockList(strArr);
        if (filtersTripleList == null || (collection2 = (List) filtersTripleList.getSecond()) == null) {
            strArr2 = null;
        } else {
            Collection $this$toTypedArray$iv2 = collection2;
            strArr2 = (String[]) $this$toTypedArray$iv2.toArray(new String[0]);
        }
        filters.setRegexBlockList(strArr2);
        if (filtersTripleList == null || (collection = (List) filtersTripleList.getThird()) == null) {
            strArr3 = null;
        } else {
            Collection $this$toTypedArray$iv3 = collection;
            strArr3 = (String[]) $this$toTypedArray$iv3.toArray(new String[0]);
        }
        filters.setContentBlockList(strArr3);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        boolean open = playerContainer2.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true);
        filters.setBlockEnable(Boolean.valueOf(open));
        this.mChronosRpcSender.onDanmakuFilterChanged(filters);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void setDanmakuExposureParam(long danmakuId, long avid, long cid, long replyDanmakuId) {
        if (danmakuId <= 0) {
            return;
        }
        AddCustomDanmaku.CustomDanmaku customDanmakuParam = new AddCustomDanmaku.CustomDanmaku();
        customDanmakuParam.setDanmakuId(String.valueOf(danmakuId));
        customDanmakuParam.setType(Integer.valueOf(replyDanmakuId > 0 ? 102 : 100));
        customDanmakuParam.setExtra(null);
        AddCustomDanmaku.Request $this$setDanmakuExposureParam_u24lambda_u241 = new AddCustomDanmaku.Request();
        $this$setDanmakuExposureParam_u24lambda_u241.setVideoId(cid > 0 ? String.valueOf(cid) : null);
        $this$setDanmakuExposureParam_u24lambda_u241.setWorkId(avid > 0 ? String.valueOf(avid) : null);
        $this$setDanmakuExposureParam_u24lambda_u241.setDms(new AddCustomDanmaku.CustomDanmaku[]{customDanmakuParam});
        this.mAddCustomDanmakuReq = $this$setDanmakuExposureParam_u24lambda_u241;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdFloatViewExtra] */
    /* JADX WARN: Type inference failed for: r11v12, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdDanmakuExtra] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdFloatViewCommonExtra] */
    /* JADX WARN: Type inference failed for: r11v6, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdFloatViewCommerceExtra] */
    /* JADX WARN: Type inference failed for: r11v7, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdFloatViewGotExtra] */
    /* JADX WARN: Type inference failed for: r11v8, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdFloatViewAnswerExtra] */
    /* JADX WARN: Type inference failed for: r11v9, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku$AdFloatViewPermanentExtra] */
    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void adDanmakuExposureRequest(List<? extends AdDanmakuBean> list, long avid, long cid) {
        List danmakus;
        boolean z;
        Object obj;
        List danmakus2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(danmakus2, "danmakus");
        AddCustomDanmaku.Request $this$adDanmakuExposureRequest_u24lambda_u240 = new AddCustomDanmaku.Request();
        boolean z2 = false;
        $this$adDanmakuExposureRequest_u24lambda_u240.setWorkId(String.valueOf(avid));
        $this$adDanmakuExposureRequest_u24lambda_u240.setVideoId(String.valueOf(cid));
        List $this$map$iv = danmakus2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AdDanmakuBean adDanmaku = (AdDanmakuBean) item$iv$iv;
            AddCustomDanmaku.CustomDanmaku $this$adDanmakuExposureRequest_u24lambda_u240_u240_u240 = new AddCustomDanmaku.CustomDanmaku();
            $this$adDanmakuExposureRequest_u24lambda_u240_u240_u240.setDanmakuId(String.valueOf(adDanmaku.hashCode()));
            $this$adDanmakuExposureRequest_u24lambda_u240_u240_u240.setType(101);
            if (adDanmaku instanceof AdDanmakuBean.AdDm) {
                obj = new AddCustomDanmaku.AdDanmakuExtra();
                danmakus = danmakus2;
                z = z2;
                obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                obj.setCover(((AdDanmakuBean.AdDm) adDanmaku).getCover());
                obj.setAdLogo(((AdDanmakuBean.AdDm) adDanmaku).getAdverLogo());
                obj.setAdTag(((AdDanmakuBean.AdDm) adDanmaku).getAdTag());
                obj.setTitle(((AdDanmakuBean.AdDm) adDanmaku).getDanmuTitle());
                obj.setDesc(((AdDanmakuBean.AdDm) adDanmaku).getDesc());
                obj.setBgColor(((AdDanmakuBean.AdDm) adDanmaku).getDanmuColor());
                obj.setAppearanceTime(Long.valueOf(((AdDanmakuBean.AdDm) adDanmaku).getDanmuBegin()));
                obj.setDuration(Long.valueOf(((AdDanmakuBean.AdDm) adDanmaku).getDanmuLife()));
                obj.setYLocation(Float.valueOf(((AdDanmakuBean.AdDm) adDanmaku).getRealDanmuHeight()));
            } else {
                danmakus = danmakus2;
                z = z2;
                if (adDanmaku instanceof AdDanmakuBean.AdFloatView) {
                    obj = new AddCustomDanmaku.AdFloatViewExtra();
                    obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                    obj.setImageUrl(((AdDanmakuBean.AdFloatView) adDanmaku).getImage_url());
                    obj.setBgColor(((AdDanmakuBean.AdFloatView) adDanmaku).getBg_color());
                    obj.setAdNotes(((AdDanmakuBean.AdFloatView) adDanmaku).getAd_notes());
                    obj.setTitle(((AdDanmakuBean.AdFloatView) adDanmaku).getTitle());
                    obj.setButtonText(((AdDanmakuBean.AdFloatView) adDanmaku).getButton_text());
                    obj.setAppearanceTime(((AdDanmakuBean.AdFloatView) adDanmaku).getAppearance_time());
                    obj.setDuration(((AdDanmakuBean.AdFloatView) adDanmaku).getDuration());
                } else if (adDanmaku instanceof AdDanmakuBean.AdFloatViewPermanent) {
                    obj = new AddCustomDanmaku.AdFloatViewPermanentExtra();
                    obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                    obj.setImageUrl(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getImage_url());
                    obj.setBgColor(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getBg_color());
                    obj.setTitle(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getTitle());
                    obj.setAppearanceTime(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getAppearance_time());
                    obj.setDuration(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getDuration());
                    obj.setFoldTime(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getFold_time());
                    obj.setHeight(((AdDanmakuBean.AdFloatViewPermanent) adDanmaku).getHeight());
                } else if (adDanmaku instanceof AdDanmakuBean.AdFloatViewAnswer) {
                    obj = new AddCustomDanmaku.AdFloatViewAnswerExtra();
                    obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                    obj.setBallId(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getBall_id());
                    obj.setQuestionImageUrl(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getQuestion_image_url());
                    obj.setQuestion(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getQuestion());
                    obj.setSelections(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getSelections());
                    obj.setAppearanceTime(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getAppearance_time());
                    obj.setDuration(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getDuration());
                    obj.setState(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getState());
                    obj.setFailedNotes(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getFailed_notes());
                    obj.setSucceedNotes(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getSucceed_notes());
                    obj.setSucceedBtnText(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getSucceed_btn_text());
                    obj.setSucceedImageUrl(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getSucceed_image_url());
                    obj.setGotNotes(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getGot_notes());
                    obj.setGotBtnText(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getGot_btn_text());
                    obj.setGotImageUrl(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getGot_image_url());
                    obj.setAdTagImageUrl(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getAd_tag_image_url());
                    obj.setAdTagText(((AdDanmakuBean.AdFloatViewAnswer) adDanmaku).getAd_tag_text());
                } else if (adDanmaku instanceof AdDanmakuBean.AdFloatViewGot) {
                    obj = new AddCustomDanmaku.AdFloatViewGotExtra();
                    obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                    obj.setBallId(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getBall_id());
                    obj.setImageUrl(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getImage_url());
                    obj.setNotes(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getNotes());
                    obj.setBtnText(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getBtn_text());
                    obj.setAppearanceTime(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getAppearance_time());
                    obj.setDuration(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getDuration());
                    obj.setState(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getState());
                    obj.setSucceedNotes(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getSucceed_notes());
                    obj.setSucceedBtnText(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getSucceed_btn_text());
                    obj.setSucceedImageUrl(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getSucceed_image_url());
                    obj.setGotNotes(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getGot_notes());
                    obj.setGotBtnText(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getGot_btn_text());
                    obj.setGotImageUrl(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getGot_image_url());
                    obj.setAdTagImageUrl(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getAd_tag_image_url());
                    obj.setAdTagText(((AdDanmakuBean.AdFloatViewGot) adDanmaku).getAd_tag_text());
                } else if (adDanmaku instanceof AdDanmakuBean.AdFloatViewCommerce) {
                    obj = new AddCustomDanmaku.AdFloatViewCommerceExtra();
                    obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                    obj.setImageUrl(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getImage_url());
                    obj.setImageWidth(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getImage_width());
                    obj.setImageHeight(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getImage_height());
                    obj.setAdNotes(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getAd_notes());
                    obj.setTitle(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getTitle());
                    obj.setAppearanceTime(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getAppearance_time());
                    obj.setDuration(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getDuration());
                    obj.setButtonText(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getButton_text());
                    obj.setPriceDesc(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getPrice_desc());
                    obj.setPriceSymbol(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getPrice_symbol());
                    obj.setCurPrice(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getCur_price());
                    obj.setOriPrice(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getOri_price());
                    obj.setDesc(((AdDanmakuBean.AdFloatViewCommerce) adDanmaku).getDesc());
                } else if (adDanmaku instanceof AdDanmakuBean.AdFloatViewCommon) {
                    obj = new AddCustomDanmaku.AdFloatViewCommonExtra();
                    obj.setCardType(Integer.valueOf(adDanmaku.getCardType()));
                    obj.setImageUrl(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getImage_url());
                    obj.setImageWidth(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getImage_width());
                    obj.setImageHeight(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getImage_height());
                    obj.setAdNotes(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getAd_notes());
                    obj.setTitle(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getTitle());
                    obj.setDesc(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getDesc());
                    obj.setButtonText(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getButton_text());
                    obj.setAppearanceTime(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getAppearance_time());
                    obj.setDuration(((AdDanmakuBean.AdFloatViewCommon) adDanmaku).getDuration());
                } else {
                    obj = 0;
                }
            }
            $this$adDanmakuExposureRequest_u24lambda_u240_u240_u240.setExtra(obj);
            destination$iv$iv.add($this$adDanmakuExposureRequest_u24lambda_u240_u240_u240);
            z2 = z;
            danmakus2 = danmakus;
        }
        Collection $this$toTypedArray$iv = (List) destination$iv$iv;
        $this$adDanmakuExposureRequest_u24lambda_u240.setDms((AddCustomDanmaku.CustomDanmaku[]) $this$toTypedArray$iv.toArray(new AddCustomDanmaku.CustomDanmaku[0]));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, $this$adDanmakuExposureRequest_u24lambda_u240, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void addDanmaku(CommentItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        AddCustomDanmaku.NormalExtra extra = new AddCustomDanmaku.NormalExtra();
        extra.setAppearanceTime(Long.valueOf(item.mTimeMilli));
        extra.setMode(Integer.valueOf(item.getCommentType()));
        extra.setFontSize(Integer.valueOf(item.mSize));
        extra.setColor(Integer.valueOf(item.getViewTextColor() & DanmakuConfig.COLOR_DEFAULT));
        extra.setUserHash(item.mDamakuSenderHash);
        extra.setContent(item.getText());
        extra.setCtime(Long.valueOf(item.ctime));
        extra.setAction(item.action);
        extra.setPool(Integer.valueOf(item.pool));
        extra.setWeight(Integer.valueOf(item.weight));
        extra.setAttr(Integer.valueOf(item.attr));
        extra.setAnimation(item.animation);
        addDanmaku(item.mRemoteDmId, 104, extra);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void addDanmaku(String dmId, int type, Object extra) {
        addDanmaku(dmId, type, extra, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void addDanmaku(String dmId, int type, Object extra, Map<String, byte[]> map) {
        Map emoExtra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        AddCustomDanmaku.CustomDanmaku customDanmakusParam = new AddCustomDanmaku.CustomDanmaku();
        customDanmakusParam.setDanmakuId(dmId);
        customDanmakusParam.setType(Integer.valueOf(type));
        customDanmakusParam.setExtra(extra);
        AddCustomDanmaku.Request req = new AddCustomDanmaku.Request();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
        Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
        req.setWorkId(String.valueOf(displayParams != null ? Long.valueOf(displayParams.getAvid()) : null));
        req.setVideoId(String.valueOf(displayParams != null ? Long.valueOf(displayParams.getCid()) : null));
        req.setDms(new AddCustomDanmaku.CustomDanmaku[]{customDanmakusParam});
        this.mChronosRpcSender.sendAsyncMessage(req, emoExtra);
    }

    private final void save(String token) {
        SaveState.Request req = new SaveState.Request();
        req.setToken(token);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void restorePackage(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        RestoreState.Request req = new RestoreState.Request();
        req.setToken(token);
        PlayerContainer playerContainer = null;
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer = playerContainer2;
        }
        scheduleClockChanged(playerContainer.getPlayerCoreService().getState() == 4);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onNetWorkSateChanged(int state) {
        NetworkChange.Request req = new NetworkChange.Request();
        req.setState(Integer.valueOf(state));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onWindowInsetChanged(WindowInset windowInset) {
        Intrinsics.checkNotNullParameter(windowInset, "windowInset");
        DeviceInfoChange.Request req = new DeviceInfoChange.Request();
        DeviceInfoChange.SafeArea $this$onWindowInsetChanged_u24lambda_u240_u240 = new DeviceInfoChange.SafeArea();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        $this$onWindowInsetChanged_u24lambda_u240_u240.setTop(Float.valueOf(DpUtils.px2dp(playerContainer.getContext(), windowInset.getTopPadding())));
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        $this$onWindowInsetChanged_u24lambda_u240_u240.setLeft(Float.valueOf(DpUtils.px2dp(playerContainer2.getContext(), windowInset.getLeftPadding())));
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        $this$onWindowInsetChanged_u24lambda_u240_u240.setRight(Float.valueOf(DpUtils.px2dp(playerContainer3.getContext(), windowInset.getRightPadding())));
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer4 = null;
        }
        $this$onWindowInsetChanged_u24lambda_u240_u240.setBottom(Float.valueOf(DpUtils.px2dp(playerContainer4.getContext(), windowInset.getBottomPadding())));
        req.setSafeArea($this$onWindowInsetChanged_u24lambda_u240_u240);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onDanmakuVisibleChanged(boolean visible) {
        this.mChronosRpcSender.onDanmakuVisibilityChanged(visible);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r0.hasSubtitleHeight() == true) goto L15;
     */
    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewPortUpdate(Rect viewPort) {
        boolean z;
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        this.mChronosViewPort = viewPort;
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        if (!playerContainer.getInteractLayerService().isCustomSubtitleMargin()) {
            int i = 0;
            if (!this.mMultiDanmaku) {
                PlayerContainer playerContainer3 = this.mPlayerContainer;
                if (playerContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer3 = null;
                }
                SubtitleItem mainSubtitle = playerContainer3.getInteractLayerService().getMainSubtitle();
                if (mainSubtitle != null) {
                    z = true;
                }
                z = false;
                if (z) {
                    PlayerContainer playerContainer4 = this.mPlayerContainer;
                    if (playerContainer4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer2 = playerContainer4;
                    }
                    i = playerContainer2.getInteractLayerService().getSubtitleBottomMargin();
                    int bottomFix = i;
                    updateSubtitleLocationWithViewport(bottomFix);
                }
            }
            if (!this.mMultiDanmaku) {
                PlayerContainer playerContainer5 = this.mPlayerContainer;
                if (playerContainer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer5 = null;
                }
                if (playerContainer5.getControlContainerService().isShowing()) {
                    PlayerContainer playerContainer6 = this.mPlayerContainer;
                    if (playerContainer6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer2 = playerContainer6;
                    }
                    i = playerContainer2.getControlContainerService().getBottomSubtitleBlock();
                }
            }
            int bottomFix2 = i;
            updateSubtitleLocationWithViewport(bottomFix2);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void setCommandDanmakus(List<CommandsDanmaku> list) {
        this.mCommandDms.clear();
        boolean z = false;
        if (list != null && (!list.isEmpty())) {
            z = true;
        }
        if (z) {
            this.mCommandDms.addAll(list);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void configChronos(ViewProgressDetail viewProgressDetail, long avid, long cid) {
        if (viewProgressDetail == null) {
            return;
        }
        configCommandDanmaku(viewProgressDetail, avid, cid);
        configExposureDanmaku(avid, cid);
        configAppPlayerSetting();
        configOnlineInfoParam();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onPlayerClockChanged(float speed, long currentPosition, Map<String, Integer> map) {
        Map errors = EnhancedUnmodifiabilityKt.unmodifiable(map);
        PlaybackStatusChange.Request req = new PlaybackStatusChange.Request();
        req.setPlaybackRate(Float.valueOf(speed));
        req.setCurrentTime(Long.valueOf(currentPosition));
        req.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        req.setError(errors);
        BLog.d(TAG, "OnPlaybackStatusChanged, current time=" + req.getCurrentTime() + " " + speed);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainer), (CoroutineContext) null, (CoroutineStart) null, new RemoteServiceHandler$onPlayerClockChanged$1(this, req, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onVideoSeeking(long previewPosition, long type) {
        OnVideoSeeking.Request req = new OnVideoSeeking.Request();
        req.setPreviewTime(Long.valueOf(previewPosition));
        req.setSeekType(Long.valueOf(type));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onVideoSpeeding(boolean status) {
        OnVideoSpeeding.Request req = new OnVideoSpeeding.Request();
        req.setStatus(status ? 1 : 2);
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender.Callback
    public void onDanmakuSendSuccess(CommentItem commentItem, HashMap<String, String> hashMap) {
        Boolean isCidValid;
        Video.DisplayParams displayParams;
        Intrinsics.checkNotNullParameter(hashMap, "params");
        if (this.cidCheckEnable) {
            IChronosRemoteCidCheckIntercept iChronosRemoteCidCheckIntercept = this.cidCheckIntercept;
            if (iChronosRemoteCidCheckIntercept != null) {
                isCidValid = Boolean.valueOf(iChronosRemoteCidCheckIntercept.isCurrentCidValid(commentItem != null ? Long.valueOf(commentItem.cid) : null));
            } else {
                isCidValid = null;
            }
            if (isCidValid != null && !isCidValid.booleanValue()) {
                return;
            }
            if (isCidValid == null) {
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
                if (!Intrinsics.areEqual((currentPlayableParams == null || (displayParams = currentPlayableParams.getDisplayParams()) == null) ? null : Long.valueOf(displayParams.getCid()), commentItem != null ? Long.valueOf(commentItem.cid) : null)) {
                    return;
                }
            }
        }
        if (commentItem != null) {
            DanmakuSent.Request req = new DanmakuSent.Request();
            req.setDanmakuId(commentItem.mRemoteDmId);
            req.setAppearanceTime(Long.valueOf(commentItem.mTimeMilli));
            String str = hashMap.get("mode");
            req.setMode(str != null ? Integer.valueOf(safeToInt(str)) : null);
            req.setContent(commentItem.getText());
            req.setActions(commentItem.action);
            req.setFontColor(Integer.valueOf(commentItem.getViewTextColor()));
            req.setFontSize(Integer.valueOf(commentItem.mSize));
            req.setUserHash(commentItem.mDamakuSenderHash);
            req.setAnimation(commentItem.animation);
            req.setColorful(commentItem.colorful);
            req.setVideoId(String.valueOf(commentItem.cid));
            IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void setVisibleRect(DanmakuConfigChange.VisibleRect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        DanmakuConfigChange.Request req = new DanmakuConfigChange.Request();
        req.setVisibleRect(rect);
        this.mChronosRpcSender.onDanmakuConfigChanged(req);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender.Callback
    public void onCommandDanmakuSentSuccess(ChronosDanmakuSender.CommandDanmakuSendResponse commandDanmaku) {
        Intrinsics.checkNotNullParameter(commandDanmaku, "commandDanmaku");
        CommandsDanmaku commandDm = new CommandsDanmaku();
        String id = commandDanmaku.getId();
        commandDm.setId(id != null ? Long.parseLong(id) : -1L);
        String content = commandDanmaku.getContent();
        if (content == null) {
            content = "";
        }
        commandDm.setContent(content);
        String extra = commandDanmaku.getExtra();
        if (extra == null) {
            extra = "";
        }
        commandDm.setExtra(extra);
        Long oid = commandDanmaku.getOid();
        commandDm.setOid(oid != null ? oid.longValue() : -1L);
        Long mid = commandDanmaku.getMid();
        commandDm.setMid(mid != null ? mid.longValue() : -1L);
        String command = commandDanmaku.getCommand();
        if (command == null) {
            command = "";
        }
        commandDm.setCommand(command);
        Long progress = commandDanmaku.getProgress();
        commandDm.setProgress(progress != null ? (int) progress.longValue() : 0);
        String idStr = commandDanmaku.getIdStr();
        commandDm.setIdStr(idStr != null ? idStr : "");
        this.mCommandDms.add(commandDm);
        CommandDanmakuSent.Request req = new CommandDanmakuSent.Request();
        req.setDanmakuId(commandDanmaku.getIdStr());
        req.setAppearanceTime(commandDanmaku.getProgress());
        req.setType(commandDanmaku.getType());
        req.setCommand(commandDanmaku.getCommand());
        req.setUserId(String.valueOf(commandDanmaku.getMid()));
        req.setVideoId(String.valueOf(commandDanmaku.getOid()));
        req.setContent(commandDanmaku.getContent());
        req.setState(commandDanmaku.getState());
        req.setExtra(commandDanmaku.getExtra());
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onOgvTimelineMaterialChanged(OGVTimelineMaterialChange.Request param) {
        Intrinsics.checkNotNullParameter(param, "param");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, param, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onPUGVInfoChanged(PUGVInfoChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onDubbingPanelChanged(OGVDubbingResult.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onPlayerComponentsHeightChanged(int panelHeight, int totalHeight) {
        PlayerComponentsHeight.Request req = new PlayerComponentsHeight.Request();
        req.setPanelHeight((int) (panelHeight / this.displayDensity));
        req.setTotalHeight((int) (totalHeight / this.displayDensity));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void setCidCheckIntercept(IChronosRemoteCidCheckIntercept intercept) {
        this.cidCheckIntercept = intercept;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onPermissionChanged(boolean granted, String permission) {
        PermissionChanged.Request req = new PermissionChanged.Request();
        req.setType(permission);
        req.setGranted(Boolean.valueOf(granted));
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    private final void configCommandDanmaku(ViewProgressDetail viewProgressDetail, long avid, long cid) {
        ViewProgressReply it;
        VideoGuide videoGuide;
        VideoViewPoint videoPoint;
        Iterable videoPointList;
        DmResource dmResource;
        AttentionCard attentionCard;
        Iterable showTimeList;
        ViewProgressChange.Request req = new ViewProgressChange.Request();
        List attentionList = new ArrayList();
        if (viewProgressDetail != null && (dmResource = viewProgressDetail.getDmResource()) != null && (attentionCard = dmResource.getAttentionCard()) != null && (showTimeList = attentionCard.getShowTimeList()) != null) {
            Iterable $this$forEach$iv = showTimeList;
            for (Object element$iv : $this$forEach$iv) {
                ShowTime it2 = (ShowTime) element$iv;
                ViewProgressChange.Attention attention = new ViewProgressChange.Attention();
                attention.setStartTime(Integer.valueOf(it2.getStartTime()));
                attention.setEndTime(Integer.valueOf(it2.getEndTime()));
                attention.setPosX(Double.valueOf(it2.getPosX()));
                attention.setPosY(Double.valueOf(it2.getPosY()));
                attentionList.add(attention);
            }
        }
        ViewProgressChange.VideoGuide $this$configCommandDanmaku_u24lambda_u241 = new ViewProgressChange.VideoGuide();
        $this$configCommandDanmaku_u24lambda_u241.setAttentions(attentionList);
        req.setVideoGuide($this$configCommandDanmaku_u24lambda_u241);
        req.setWorkId(String.valueOf(avid));
        req.setVideoId(String.valueOf(cid));
        req.setVideoPoints(new ArrayList<>());
        if (viewProgressDetail != null && (videoGuide = viewProgressDetail.getVideoGuide()) != null && (videoPoint = videoGuide.getVideoPoint()) != null && (videoPointList = videoPoint.getVideoPointList()) != null) {
            Iterable $this$forEach$iv2 = videoPointList;
            for (Object element$iv2 : $this$forEach$iv2) {
                VideoPoint it3 = (VideoPoint) element$iv2;
                ViewProgressChange.VideoPoint point = new ViewProgressChange.VideoPoint();
                point.setContent(it3.getContent());
                point.setCover(it3.getCover());
                point.setFrom(Long.valueOf(it3.getFrom()));
                point.setTo(Long.valueOf(it3.getTo()));
                point.setType(Integer.valueOf(it3.getType()));
                ArrayList<ViewProgressChange.VideoPoint> videoPoints = req.getVideoPoints();
                if (videoPoints != null) {
                    videoPoints.add(point);
                }
            }
        }
        if ((viewProgressDetail != null ? viewProgressDetail.getOriginData() : null) instanceof ViewProgressReply) {
            Object originData = viewProgressDetail.getOriginData();
            it = originData instanceof ViewProgressReply ? (ViewProgressReply) originData : null;
            if (it != null) {
                this.mChronosRpcSender.sendAsyncMessage(req, MapsKt.mapOf(TuplesKt.to("unitereply", it.toByteArray())));
                return;
            }
            return;
        }
        Object originData2 = viewProgressDetail != null ? viewProgressDetail.getOriginData() : null;
        it = originData2 instanceof com.bapis.bilibili.app.view.v1.ViewProgressReply ? (com.bapis.bilibili.app.view.v1.ViewProgressReply) originData2 : null;
        if (it != null) {
            this.mChronosRpcSender.sendAsyncMessage(req, MapsKt.mapOf(TuplesKt.to("reply", it.toByteArray())));
        }
    }

    private final void configExposureDanmaku(long avid, long cid) {
        AddCustomDanmaku.Request it = this.mAddCustomDanmakuReq;
        if (it != null) {
            if (Intrinsics.areEqual(String.valueOf(avid), it.getWorkId()) && Intrinsics.areEqual(String.valueOf(cid), it.getVideoId())) {
                BLog.i(TAG, ": danmaku exposure request from message center.");
                IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, it, null, 2, null);
                return;
            }
            BLog.i(TAG, ": danmaku exposure reset.");
            this.mAddCustomDanmakuReq = null;
        }
    }

    private final void configOnlineInfoParam() {
        OnlineInfoChange.Request req = this.mOnlineInfoReq;
        if (req == null) {
            return;
        }
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
        this.mOnlineInfoReq = null;
    }

    private final void configAppPlayerSetting() {
        DanmakuConfigChange.Request danmakuConfig = new DanmakuConfigChange.Request();
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        danmakuConfig.setCommonDanmakuInteraction(Boolean.valueOf(playerContainer.getPlayerSettingService().getCloudConfig().enableDanmakuInteraction()));
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        danmakuConfig.setCommonDanmakuMonospaced(Boolean.valueOf(playerContainer2.getPlayerSettingService().getCloudConfig().enableDanmakuMonospaced()));
        this.mChronosRpcSender.onDanmakuConfigChanged(danmakuConfig);
    }

    private final void scheduleClockChanged(boolean playing) {
        if (playing) {
            if (this.mScheduledFuture != null || !this.mIsRun) {
                if (Companion.getHitLeakFix()) {
                    cancelScheduledFuture();
                    return;
                }
                return;
            }
            this.mScheduledFuture = sStatusRepeatExecutor.scheduleAtFixedRate(new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteServiceHandler.scheduleClockChanged$lambda$0(RemoteServiceHandler.this);
                }
            }, 0L, 1L, TimeUnit.SECONDS);
            BLog.i(TAG, "scheduleClockChanged task run: " + this);
            return;
        }
        cancelScheduledFuture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleClockChanged$lambda$0(RemoteServiceHandler this$0) {
        float speed;
        PlayerContainer playerContainer = this$0.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        if (playerContainer.getPlayerCoreService().getState() == 4) {
            PlayerContainer playerContainer2 = this$0.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer2 = null;
            }
            speed = playerContainer2.getPlayerCoreService().getPlaySpeed(true);
        } else {
            speed = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        PlayerContainer playerContainer3 = this$0.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        int position = playerContainer3.getPlayerCoreService().getCurrentPosition();
        this$0.onPlayerClockChanged(speed, position, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void onVideoSizeChanged(Rect renderBounds, TransformParams transformParams) {
        if (renderBounds != null && transformParams != null) {
            VideoSizeChange.Request req = new VideoSizeChange.Request();
            req.setOrigin(new float[]{renderBounds.left / this.displayDensity, renderBounds.top / this.displayDensity});
            req.setSize(new int[]{(int) (renderBounds.width() / this.displayDensity), (int) (renderBounds.height() / this.displayDensity)});
            req.setTranslation(new float[]{transformParams.getTranslationX() / this.displayDensity, transformParams.getTranslationY() / this.displayDensity});
            req.setRotation(Float.valueOf(safeToRadians(transformParams.getRotation())));
            req.setScale(new float[]{transformParams.getScaleX(), transformParams.getScaleY()});
            IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public boolean dispatchRpcGesture(float x, float y, int gesture, int state) {
        Point chronosSize = this.chronosService.getChronosSize();
        if (chronosSize == null) {
            return false;
        }
        float px = x / chronosSize.x;
        float py = y / chronosSize.y;
        GestureEventReceived.Request req = new GestureEventReceived.Request();
        req.setState(Integer.valueOf(state));
        req.setGesture(Integer.valueOf(gesture));
        if (px >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && py >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            req.setLocation(new float[]{px, py});
        }
        return this.mChronosRpcSender.onGestureEventReceived(req);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler
    public void dispatchRpcTouch(float x, float y, int action) {
        Point chronosSize = this.chronosService.getChronosSize();
        if (chronosSize == null) {
            return;
        }
        float px = x / chronosSize.x;
        float py = y / chronosSize.y;
        TouchEventReceive.Request req = new TouchEventReceive.Request();
        req.setAction(Integer.valueOf(action));
        if (px >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && py >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            req.setLocation(new float[]{px, py});
        }
        IChronosRpcSender.CC.sendAsyncMessage$default(this.mChronosRpcSender, req, null, 2, null);
    }

    private final void stopScheduledFuture() {
        cancelScheduledFuture();
        sStatusRepeatExecutor.purge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelScheduledFuture() {
        ScheduledFuture<?> scheduledFuture = this.mScheduledFuture;
        boolean z = false;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            z = true;
        }
        if (z) {
            BLog.i(TAG, "scheduleClockChanged task cancel: " + this);
            ScheduledFuture<?> scheduledFuture2 = this.mScheduledFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            this.mScheduledFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubtitleLocationWithViewport(int bottomBlock) {
        int viewPortTranslate;
        int i;
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        boolean z = false;
        if (playerContainer.getInteractLayerService().isCustomSubtitleMargin()) {
            i = bottomBlock;
        } else {
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer3 = null;
            }
            int containerHeight = playerContainer3.getInteractLayerService().getChronosInteractContainer().getChronosContainer().getHeight();
            if (!this.mMultiDanmaku) {
                Rect rect = this.mChronosViewPort;
                int height = containerHeight - (rect != null ? rect.height() : 0);
                Rect rect2 = this.mChronosViewPort;
                viewPortTranslate = Math.max(height - (rect2 != null ? rect2.top : 0), 0);
            } else {
                viewPortTranslate = 0;
            }
            i = viewPortTranslate + bottomBlock;
        }
        int containerHeight2 = i;
        DanmakuConfigChange.Request req = new DanmakuConfigChange.Request();
        DanmakuConfigChange.SubtitleConfig subtitleConfig = new DanmakuConfigChange.SubtitleConfig();
        subtitleConfig.setBottomMargin(Float.valueOf(containerHeight2 / this.displayDensity));
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        SubtitleItem mainSubtitle = playerContainer2.getInteractLayerService().getMainSubtitle();
        if (mainSubtitle != null && mainSubtitle.hasSubtitleHeight()) {
            z = true;
        }
        subtitleConfig.setFixedBottomMargin(Boolean.valueOf(z));
        req.setSubtitleConfig(subtitleConfig);
        this.mChronosRpcSender.onDanmakuConfigChanged(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMaskVisibleChanged() {
        DanmakuConfigChange.Request req = new DanmakuConfigChange.Request();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        req.setMaskEnabled(Boolean.valueOf(playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, true)));
        this.mChronosRpcSender.onDanmakuConfigChanged(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDanmakuFoldSwitchChanged(boolean enable) {
        DanmakuConfigChange.Request req = new DanmakuConfigChange.Request();
        req.setFoldDanmakuEnabled(Boolean.valueOf(enable));
        this.mChronosRpcSender.onDanmakuConfigChanged(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDanmakuFilterSwitchChanged() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        boolean open = playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true);
        if (open) {
            DanmakuFilterContainer danmakuFilterContainer = this.chronosService.getDanmakuFilterContainer();
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer2 = playerContainer3;
            }
            danmakuFilterContainer.loadLocalFilters(playerContainer2.getContext());
            return;
        }
        DanmakuFilterChange.Request req = new DanmakuFilterChange.Request();
        req.setUserHashBlockList(new String[0]);
        req.setRegexBlockList(new String[0]);
        req.setContentBlockList(new String[0]);
        req.setBlockEnable(Boolean.valueOf(open));
        this.mChronosRpcSender.onDanmakuFilterChanged(req);
    }

    private final float safeToRadians(double degree) {
        double radians = Math.toRadians(degree);
        if (Double.isNaN(radians)) {
            radians = 0.0d;
        }
        return (float) radians;
    }

    private final int safeToInt(String $this$safeToInt) {
        try {
            return Integer.parseInt($this$safeToInt);
        } catch (Exception e) {
            return 0;
        }
    }
}