package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bilibili.bus.Violet;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.moduleservice.ugc.IMultiEvent;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerWindowManager;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.router.PlayerRouteUris;
import tv.danmaku.biliplayerv2.service.FunctionWidgetToken;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.SeekService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.gesture.GestureInterceptShield;
import tv.danmaku.biliplayerv2.service.gesture.GestureInterceptor;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractModeObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.AdDanmakuDelegate;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.RpcException;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.SampleKt;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.AdDanmakuEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.EventReport;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetAudioTrack;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetPlayerComponentsHeight;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.InvokeCommandDetailPanel;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.MuteVideo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyCommercialEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyDanmakuExperiment;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyDanmakuSent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.OpenUrlScheme;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReplyDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ReportSubtitle;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ShowPlayerWebView;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.ShowToast;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.SwitchAudioTrack;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateClipboard;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateCurrentWork;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateDanmakuInputPanel;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePlaybackStatus;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePlayerControlBar;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdatePreference;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateShipChain;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateUIMode;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateVideoDetailState;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFeedbackInfoKt;
import tv.danmaku.biliplayerv2.service.interact.biz.widget.ChronosDanmakuReportBottomSheet;
import tv.danmaku.biliplayerv2.service.interact.biz.widget.ChronosReportFunctionWidget;
import tv.danmaku.biliplayerv2.service.interact.biz.widget.IChronosDanmakuReportCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.widget.SubtitleReportFunctionWidget;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: LocalServiceHandler.kt */
@Metadata(d1 = {"\u0000Õ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0018\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001{B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u009e\u0001\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'2>\u0010(\u001a:\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`,H\u0016J\u009e\u0001\u0010-\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010.2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'2>\u0010(\u001a:\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`,H\u0016J^\u0010/\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001002J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u00101\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001022J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u00103\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001042J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u00105\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001062J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u00107\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u0001082J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u00109\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010:2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0017J\u0018\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020:2\u0006\u0010<\u001a\u00020\u0013H\u0002J^\u0010=\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010>2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010?\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010@2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010A\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010B2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J\u009e\u0001\u0010C\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010D2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'2>\u0010(\u001a:\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`,H\u0016J\u009e\u0001\u0010E\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010F2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'2>\u0010(\u001a:\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`,H\u0016J^\u0010G\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010H2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010I\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010J2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010K\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010L2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010M\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010N2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010O\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010P2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010Q\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010R2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J\\\u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020U2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J\\\u0010V\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020W2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J\\\u0010X\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020Y2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010Z\u001a\u00020\u001b2\b\u0010T\u001a\u0004\u0018\u00010[2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J^\u0010\\\u001a\u00020\u001b2\b\u0010T\u001a\u0004\u0018\u00010]2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J\u009e\u0001\u0010^\u001a\u00020\u001b2\b\u0010T\u001a\u0004\u0018\u00010_2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'2>\u0010(\u001a:\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`,H\u0016J\\\u0010`\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020a2J\u0010\u001e\u001aF\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001b0\u001fj\u0002`'H\u0016J\u0010\u0010b\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020\u001bH\u0016J\u0016\u0010f\u001a\u00020\u001b2\f\u0010g\u001a\b\u0012\u0002\b\u0003\u0018\u00010hH\u0016J\u0010\u0010i\u001a\u00020\u001b2\u0006\u0010j\u001a\u00020\u000bH\u0016J\u0010\u0010k\u001a\u00020\u001b2\u0006\u0010j\u001a\u00020\u000bH\u0016J\b\u0010l\u001a\u00020dH\u0016J\n\u0010m\u001a\u0004\u0018\u00010nH\u0016J\u0010\u0010o\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u00020\u001b2\u0006\u0010u\u001a\u00020dH\u0002J\b\u0010v\u001a\u00020dH\u0002J\u0012\u0010w\u001a\u00020\u001b2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\b\u0010z\u001a\u00020\u001bH\u0002R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006|"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/LocalServiceHandler;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/SampleLocalServiceHandler;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalHandler;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalService;", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "chronosService", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;)V", "mInteractModeObserverList", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractModeObserver;", "kotlin.jvm.PlatformType", "mGestureInterceptShield", "Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptShield;", "mSeekServiceClient", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "Ltv/danmaku/biliplayerv2/service/SeekService;", "currentUiMode", "", "mPendingLoginActionList", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "mOnTouchListener", "tv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/LocalServiceHandler$mOnTouchListener$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/LocalServiceHandler$mOnTouchListener$1;", "getCurrentWorkInfo", "", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Request;", "onComplete", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerComplete;", "onError", "", "code", "description", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerError;", "updateCurrentWork", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateCurrentWork$Request;", "eventReport", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/EventReport$Request;", "updateRelationshipChain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateShipChain$Request;", "updatePlayBackStatus", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePlaybackStatus$Request;", "updateUiMode", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateUIMode$Request;", "showToast", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ShowToast$Request;", "openRouteUrl", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$Request;", "openUrlByContainerType", "address", "reportDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportDanmaku$Request;", "reportSubtitle", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReportSubtitle$Request;", "staffFollowStateChange", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateVideoDetailState$Request;", "updateClipboard", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateClipboard$Request;", "adDanmakuEvent", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/AdDanmakuEvent$Request;", "replyDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ReplyDanmaku$Request;", "updatePlayerControlBar", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePlayerControlBar$Request;", "updatePreference", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePreference$Request;", "showPlayerWebView", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/ShowPlayerWebView$Request;", "getPlayerComponentsHeight", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetPlayerComponentsHeight$Request;", "invokeCommandDetailPanel", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/InvokeCommandDetailPanel$Request;", "updateDanmakuInputPanel", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateDanmakuInputPanel$Request;", "notifyDanmakuExperiment", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyDanmakuExperiment$Request;", "notifyDanmakuSent", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyDanmakuSent$Request;", "setVideoMute", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/MuteVideo$Request;", "getAudioStreams", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetAudioTrack$Request;", "switchAudioIndex", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/SwitchAudioTrack$Request;", "notifyCommercialEvent", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyCommercialEvent$Request;", "onStart", "multiPlayer", "", "onStop", "initChronosView", "chronosView", "Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;", "addInteractModeObserver", "observer", "removeInteractModeObserver", "isInteractiveMode", "getRpcInvokeObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;", "showSubtitleReportPanel", "config", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/SubtitleReportFunctionWidget$Configuration;", "showReportPanel", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/ChronosReportFunctionWidget$Configuration;", "dispatchInteractMode", "interactMode", "needShowReportBottomSheetDialog", "onChange", "topic", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "handlePendingLoginActions", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LocalServiceHandler extends SampleLocalServiceHandler implements ILocalHandler, ILocalService, PassportObserver {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<String> DANMAKU_FEEDBACK_H5_URL$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda1
        public final Object invoke() {
            String DANMAKU_FEEDBACK_H5_URL_delegate$lambda$0;
            DANMAKU_FEEDBACK_H5_URL_delegate$lambda$0 = LocalServiceHandler.DANMAKU_FEEDBACK_H5_URL_delegate$lambda$0();
            return DANMAKU_FEEDBACK_H5_URL_delegate$lambda$0;
        }
    });
    public static final String TAG = "LocalServiceHandler";
    private String currentUiMode;
    private final GestureInterceptShield mGestureInterceptShield;
    private Collections.SafeIteratorList<InteractModeObserver> mInteractModeObserverList;
    private final LocalServiceHandler$mOnTouchListener$1 mOnTouchListener;
    private final LinkedList<Runnable> mPendingLoginActionList;
    private final PlayerServiceManager.Client<SeekService> mSeekServiceClient;

    /* compiled from: LocalServiceHandler.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenModeType.values().length];
            try {
                iArr[ScreenModeType.THUMB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ScreenModeType.VERTICAL_FULLSCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ScreenModeType.LANDSCAPE_FULLSCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v8, types: [tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$mOnTouchListener$1] */
    public LocalServiceHandler(final IChronosLocalService chronosService) {
        super(chronosService);
        Intrinsics.checkNotNullParameter(chronosService, "chronosService");
        this.mInteractModeObserverList = Collections.safeIteratorList(new LinkedList());
        this.mGestureInterceptShield = new GestureInterceptShield();
        this.mSeekServiceClient = new PlayerServiceManager.Client<>();
        this.currentUiMode = UpdateUIMode.NORMAL;
        this.mPendingLoginActionList = new LinkedList<>();
        this.mOnTouchListener = new GestureInterceptor() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$mOnTouchListener$1
            @Override // tv.danmaku.biliplayerv2.service.gesture.GestureInterceptor
            public void onIntercept(MotionEvent event) {
                IChronosLocalService.this.dispatchTouchEvent(event);
            }
        };
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler, tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getCurrentWorkInfo(GetWorkInfo.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
        GetWorkInfo.Response result = mRpcInvokeObserver != null ? mRpcInvokeObserver.onRpcGetWorkInfo() : null;
        if (PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams() != null && result != null) {
            result.setSessionId(getMPlayerContainer().getReporterService().getSession());
        }
        BLog.i("LocalServiceHandler", "getCurrentWorkInfo, result=" + (result != null ? JsonUtilKt.toJson(result) : null));
        if (result == null) {
            function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), "workInfo is null");
        } else {
            function2.invoke(result, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler, tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void updateCurrentWork(UpdateCurrentWork.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        BLog.i("LocalServiceHandler", "updateCurrentWork, request=" + (req != null ? JsonUtilKt.toJson(req) : null));
        if (!TextUtils.isEmpty(req != null ? req.getVideoId() : null)) {
            if (!TextUtils.isEmpty(req != null ? req.getWorkId() : null)) {
                RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
                boolean success = mRpcInvokeObserver != null ? mRpcInvokeObserver.onUpdateCurrentWork(req) : false;
                if (success) {
                    RpcInvokeObserver mRpcInvokeObserver2 = getMRpcInvokeObserver();
                    function2.invoke(mRpcInvokeObserver2 != null ? mRpcInvokeObserver2.onRpcGetCurrentWork() : null, (Object) null);
                    return;
                }
                function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), "update current work failed");
                return;
            }
        }
        RpcInvokeObserver mRpcInvokeObserver3 = getMRpcInvokeObserver();
        function2.invoke(mRpcInvokeObserver3 != null ? mRpcInvokeObserver3.onRpcGetCurrentWork() : null, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void eventReport(final EventReport.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        String event;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null || (event = req.getName()) == null) {
            return;
        }
        switch (req.getType()) {
            case 0:
                Map<String, String> extendsArgs = req.getExtendsArgs();
                if (extendsArgs == null) {
                    extendsArgs = MapsKt.emptyMap();
                }
                Neurons.reportClick(false, event, extendsArgs);
                break;
            case 1:
                Map<String, String> extendsArgs2 = req.getExtendsArgs();
                if (extendsArgs2 == null) {
                    extendsArgs2 = MapsKt.emptyMap();
                }
                Neurons.reportExposure$default(false, event, extendsArgs2, (List) null, 8, (Object) null);
                break;
            case 2:
                IReporterService reporterService = getMPlayerContainer().getReporterService();
                Map<String, String> extendsArgs3 = req.getExtendsArgs();
                if (extendsArgs3 == null) {
                    extendsArgs3 = MapsKt.emptyMap();
                }
                reporterService.report(new NeuronsEvents.NormalEventV2(event, extendsArgs3));
                break;
            case 3:
                Map<String, String> extendsArgs4 = req.getExtendsArgs();
                if (extendsArgs4 == null) {
                    extendsArgs4 = MapsKt.emptyMap();
                }
                Neurons.reportTracker(false, event, extendsArgs4);
                break;
            case 4:
                Map map = new LinkedHashMap();
                Map it = req.getExtendsArgs();
                if (it != null) {
                    map.putAll(it);
                }
                Integer statusCode = req.getStatusCode();
                map.put("status_code", String.valueOf(statusCode != null ? statusCode.intValue() : 0));
                Integer totalTime = req.getTotalTime();
                map.put("total_time", String.valueOf(totalTime != null ? totalTime.intValue() : 0));
                String it2 = req.getGroupKey();
                if (it2 != null) {
                    map.put("group_key", it2);
                }
                Neurons.trackT$default(true, event, map, 0, new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        boolean eventReport$lambda$2;
                        eventReport$lambda$2 = LocalServiceHandler.eventReport$lambda$2(EventReport.Request.this);
                        return Boolean.valueOf(eventReport$lambda$2);
                    }
                }, 8, (Object) null);
                break;
        }
        function2.invoke((Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eventReport$lambda$2(EventReport.Request $req) {
        Float sample = $req.getSample();
        return SampleKt.sample(sample != null ? sample.floatValue() : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 100);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updateRelationshipChain(UpdateShipChain.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Boolean followSeasonState;
        RpcInvokeObserver mRpcInvokeObserver;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Boolean likeState = req != null ? req.getLikeState() : null;
        Boolean dislikeState = req != null ? req.getDislikeState() : null;
        Boolean coinState = req != null ? req.getCoinState() : null;
        Boolean followState = req != null ? req.getFollowState() : null;
        Boolean favoriteState = req != null ? req.getFavoriteState() : null;
        RpcInvokeObserver mRpcInvokeObserver2 = getMRpcInvokeObserver();
        if (mRpcInvokeObserver2 != null) {
            mRpcInvokeObserver2.onUpdateRelationshipChain(req);
        }
        if (Intrinsics.areEqual(likeState, true) && Intrinsics.areEqual(coinState, true) && Intrinsics.areEqual(favoriteState, true)) {
            RpcInvokeObserver mRpcInvokeObserver3 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver3 != null) {
                mRpcInvokeObserver3.onTriggerTripleLike();
            }
            RpcInvokeObserver mRpcInvokeObserver4 = getMRpcInvokeObserver();
            function2.invoke(mRpcInvokeObserver4 != null ? mRpcInvokeObserver4.getRelationshipChain() : null, (Object) null);
            return;
        }
        boolean likeAction = false;
        if (likeState != null) {
            boolean it = likeState.booleanValue();
            likeAction = it;
            RpcInvokeObserver mRpcInvokeObserver5 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver5 != null) {
                mRpcInvokeObserver5.onUpdateLikeState(it);
            }
        }
        if (dislikeState != null) {
            boolean it2 = dislikeState.booleanValue();
            if (!likeAction && (mRpcInvokeObserver = getMRpcInvokeObserver()) != null) {
                mRpcInvokeObserver.onUpdateDislikeState(it2);
            }
        }
        if (coinState != null) {
            boolean it3 = coinState.booleanValue();
            RpcInvokeObserver mRpcInvokeObserver6 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver6 != null) {
                mRpcInvokeObserver6.onUpdateCoinState(it3);
            }
        }
        if (followState != null) {
            boolean it4 = followState.booleanValue();
            RpcInvokeObserver mRpcInvokeObserver7 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver7 != null) {
                mRpcInvokeObserver7.onUpdateFollowState(it4);
            }
        }
        if (favoriteState != null) {
            boolean it5 = favoriteState.booleanValue();
            RpcInvokeObserver mRpcInvokeObserver8 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver8 != null) {
                mRpcInvokeObserver8.onUpdateFavoState(it5);
            }
        }
        if (req != null && (followSeasonState = req.getFollowSeasonState()) != null) {
            boolean it6 = followSeasonState.booleanValue();
            RpcInvokeObserver mRpcInvokeObserver9 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver9 != null) {
                mRpcInvokeObserver9.onUpdateSeasonFollowState(it6);
            }
        }
        RpcInvokeObserver mRpcInvokeObserver10 = getMRpcInvokeObserver();
        function2.invoke(mRpcInvokeObserver10 != null ? mRpcInvokeObserver10.getRelationshipChain() : null, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updatePlayBackStatus(UpdatePlaybackStatus.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        int seekPosition;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        IPlayerCoreService coreService = getMPlayerContainer().getPlayerCoreService();
        if ((req != null ? req.getCurrentTime() : null) != null) {
            try {
                Long currentTime = req.getCurrentTime();
                seekPosition = currentTime != null ? (int) currentTime.longValue() : 0;
            } catch (Exception e) {
                seekPosition = 0;
            }
            coreService.seekTo(seekPosition);
        }
        if ((req != null ? req.getPlaybackRate() : null) != null) {
            float speed = 1.0f;
            try {
                Float playbackRate = req.getPlaybackRate();
                if (playbackRate != null) {
                    speed = playbackRate.floatValue();
                }
            } catch (Exception e2) {
            }
            if (speed == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                coreService.pause();
            } else {
                if (IPlayerCoreService.CC.getPlaySpeed$default(coreService, false, 1, null) == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                }
                coreService.setPlaySpeed(speed);
                coreService.resume();
            }
        }
        UpdatePlaybackStatus.Response status = new UpdatePlaybackStatus.Response();
        status.setCurrentTime(Long.valueOf(coreService.getCurrentPosition()));
        status.setPlaybackRate(coreService.getState() == 4 ? Float.valueOf(coreService.getPlaySpeed(true)) : Float.valueOf((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN));
        status.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        if ((req != null ? req.getCurrentQn() : null) == null) {
            status.setCurrentQn(Integer.valueOf(coreService.getCurrentQuality()));
        }
        BLog.d("LocalServiceHandler", "UpdatePlaybackStatus, current time=" + status.getCurrentTime() + ", current qn=" + status.getCurrentQn());
        function2.invoke(status, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updateUiMode(UpdateUIMode.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (!TextUtils.isEmpty(req != null ? req.getUiMode() : null)) {
            String uiMode = req != null ? req.getUiMode() : null;
            Intrinsics.checkNotNull(uiMode);
            this.currentUiMode = uiMode;
            dispatchInteractMode(Intrinsics.areEqual(this.currentUiMode, UpdateUIMode.INTERACTIVE));
            String str = this.currentUiMode;
            if (Intrinsics.areEqual(str, UpdateUIMode.INTERACTIVE)) {
                this.mGestureInterceptShield.setGestureInterceptor(getMPlayerContainer().getFunctionWidgetService(), this.mOnTouchListener);
                this.mGestureInterceptShield.show(getMPlayerContainer().getFunctionWidgetService());
            } else if (Intrinsics.areEqual(str, UpdateUIMode.INTERACTIVE_WITHOUT_TOAST)) {
                this.mGestureInterceptShield.setGestureInterceptor(getMPlayerContainer().getFunctionWidgetService(), this.mOnTouchListener);
                this.mGestureInterceptShield.show(getMPlayerContainer().getFunctionWidgetService());
                getMPlayerContainer().getToastService().removeAllToast();
            } else {
                this.mGestureInterceptShield.setGestureInterceptor(getMPlayerContainer().getFunctionWidgetService(), null);
                this.mGestureInterceptShield.dismiss(getMPlayerContainer().getFunctionWidgetService());
            }
        }
        getChronosService().syncUIMode(this.currentUiMode);
        UpdateUIMode.Response mode = new UpdateUIMode.Response();
        mode.setUiMode(this.currentUiMode);
        function2.invoke(mode, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void showToast(ShowToast.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        PlayerToast toast = new PlayerToast.Builder().toastItemType(17).location(32).duration(PlayerToastConfig.DURATION_2).setExtraString(PlayerToastConfig.EXTRA_TITLE, (req == null || (r1 = req.getMessage()) == null) ? "" : "").build();
        getMPlayerContainer().getToastService().showToast(toast);
        function2.invoke((Object) null, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void openRouteUrl(final OpenUrlScheme.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        IMiniPlayerWindowManager iMiniPlayerWindowManager;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null) {
            return;
        }
        final String it = req.getAddress();
        boolean z = false;
        if (it != null) {
            if (Intrinsics.areEqual(req.getNeedPausePlay(), true) && (iMiniPlayerWindowManager = (IMiniPlayerWindowManager) BLRouter.get$default(BLRouter.INSTANCE, IMiniPlayerWindowManager.class, (String) null, 2, (Object) null)) != null) {
                iMiniPlayerWindowManager.setIgnorePauseEnable(false);
            }
            if (Intrinsics.areEqual(req.getNeedLogin(), true) && !BiliAccounts.get(getMPlayerContainer().getContext()).isLogin()) {
                PlayerRouteUris.Routers.toMainLogin$default(PlayerRouteUris.Routers.INSTANCE, getMPlayerContainer().getContext(), null, 2, null);
                this.mPendingLoginActionList.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocalServiceHandler.this.openUrlByContainerType(req, it);
                    }
                });
                return;
            }
            openUrlByContainerType(req, it);
            return;
        }
        LocalServiceHandler $this$openRouteUrl_u24lambda_u241 = this;
        String scheme = req.getScheme();
        if (scheme == null) {
            return;
        }
        RpcInvokeObserver mRpcInvokeObserver = $this$openRouteUrl_u24lambda_u241.getMRpcInvokeObserver();
        if (mRpcInvokeObserver != null) {
            Uri parse = Uri.parse(scheme);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            if (mRpcInvokeObserver.openURLSchema(parse, req.getExtra())) {
                z = true;
            }
        }
        if (!z) {
            RouteRequest request = new RouteRequest.Builder(scheme).build();
            BLRouter.routeTo(request, $this$openRouteUrl_u24lambda_u241.getMPlayerContainer().getContext());
        }
        function2.invoke((Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrlByContainerType(OpenUrlScheme.Request req, String address) {
        BLog.i("LocalServiceHandler", "url from chronos = [" + address + "]");
        Integer containerType = req.getContainerType();
        if (containerType != null && containerType.intValue() == 2) {
            RouteRequest request = new RouteRequest.Builder("bilibili://video/player_web_dialog").data(Uri.parse(address)).build();
            BLRouter.routeTo(request, getMPlayerContainer().getContext());
            return;
        }
        RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
        boolean z = false;
        if (mRpcInvokeObserver != null && mRpcInvokeObserver.openURLScheme(address, req.getBiz(), req.getContainerType(), req.getExtra(), req.getScreenState())) {
            z = true;
        }
        if (!z) {
            RouteRequest request2 = new RouteRequest.Builder(address).build();
            BLRouter.routeTo(request2, getMPlayerContainer().getContext());
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void reportDanmaku(final ReportDanmaku.Request req, final Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Integer type;
        int type2;
        String danmakuId;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null || (type = req.getType()) == null || (type2 = type.intValue()) != 0 || (danmakuId = req.getDanmakuId()) == null) {
            return;
        }
        final Function2 onResult = new Function2() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit reportDanmaku$lambda$0;
                reportDanmaku$lambda$0 = LocalServiceHandler.reportDanmaku$lambda$0(function2, ((Boolean) obj).booleanValue(), (Boolean) obj2);
                return reportDanmaku$lambda$0;
            }
        };
        ScreenModeType screenModeType = getMPlayerContainer().getControlContainerService().getScreenModeType();
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
        Video.ReportCommonParams reportParam = currentPlayableParams != null ? currentPlayableParams.getReportCommonParams() : null;
        boolean reportMessageFromStory = getChronosService().getSceneAndBiz().getFirst() == ChronosScene.SCENE_STORY && screenModeType == ScreenModeType.VERTICAL_FULLSCREEN;
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("aid", String.valueOf(reportParam != null ? reportParam.getAvid() : 0L));
        String oid = req.getOid();
        if (oid == null) {
            oid = "";
        }
        pairArr[1] = TuplesKt.to("cid", oid);
        String content = req.getContent();
        if (content == null) {
            content = "";
        }
        pairArr[2] = TuplesKt.to("dmcontent", content);
        pairArr[3] = TuplesKt.to("dmid", danmakuId);
        String spmid = reportParam != null ? reportParam.getSpmid() : null;
        if (spmid == null) {
            spmid = "";
        }
        pairArr[4] = TuplesKt.to("from_spmid", spmid);
        int i = WhenMappings.$EnumSwitchMapping$0[screenModeType.ordinal()];
        String str = UpdateUIMode.NORMAL;
        switch (i) {
            case 1:
                break;
            case 2:
                if (!reportMessageFromStory) {
                    str = "vertical_player";
                    break;
                }
                break;
            case 3:
                str = X86IjkRequest.POOL;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        pairArr[5] = TuplesKt.to(LoginSceneProcessor.SCENE_KEY, str);
        String userHash = req.getUserHash();
        if (userHash == null) {
            userHash = "";
        }
        pairArr[6] = TuplesKt.to("dmuid", userHash);
        pairArr[7] = TuplesKt.to("biz_from", "danmaku");
        Map reportConfig = MapsKt.mapOf(pairArr);
        Integer action = req.getAction();
        if (action != null && action.intValue() == 1) {
            if (getChronosService().getSceneAndBiz().getFirst() == ChronosScene.SCENE_STORY) {
                getChronosService().hideControlContainer();
            } else {
                getMPlayerContainer().getControlContainerService().hide();
            }
            Video.PlayableParams currentPlayableParams2 = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
            Video.DanmakuResolveParams dmParams = currentPlayableParams2 != null ? currentPlayableParams2.getDanmakuResolveParams() : null;
            RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
            if (mRpcInvokeObserver != null) {
                mRpcInvokeObserver.onShowDanmakuFeedback(DanmakuFeedbackInfoKt.transform(req, dmParams != null ? Long.valueOf(dmParams.getAvid()) : null), Companion.getDANMAKU_FEEDBACK_H5_URL(), reportConfig, new Function8() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                        Unit reportDanmaku$lambda$1;
                        reportDanmaku$lambda$1 = LocalServiceHandler.reportDanmaku$lambda$1(LocalServiceHandler.this, req, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Boolean) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7, (GeneralResponse) obj8);
                        return reportDanmaku$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        if (Companion.getDANMAKU_FEEDBACK_H5_URL().length() > 0) {
            BLog.i("LocalServiceHandler", "showDanmakuFeedbackWebview, url: " + Companion.getDANMAKU_FEEDBACK_H5_URL() + ", config: " + reportConfig);
            RpcInvokeObserver mRpcInvokeObserver2 = getMRpcInvokeObserver();
            if (mRpcInvokeObserver2 != null) {
                mRpcInvokeObserver2.showDanmakuFeedbackWebview(Companion.getDANMAKU_FEEDBACK_H5_URL(), reportConfig, new Function8() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                        Unit reportDanmaku$lambda$2;
                        reportDanmaku$lambda$2 = LocalServiceHandler.reportDanmaku$lambda$2(LocalServiceHandler.this, req, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Boolean) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7, (GeneralResponse) obj8);
                        return reportDanmaku$lambda$2;
                    }
                });
            }
            return;
        }
        boolean needShowBottomSheet = needShowReportBottomSheetDialog();
        if (needShowBottomSheet) {
            if (type2 == 0) {
                boolean shieldUser = getMPlayerContainer().getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, true);
                final ChronosDanmakuReportBottomSheet danmakuReportDialog = new ChronosDanmakuReportBottomSheet(getMPlayerContainer().getContext(), new IChronosDanmakuReportCallback() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$reportDanmaku$danmakuReportDialog$1
                    @Override // tv.danmaku.biliplayerv2.service.interact.biz.widget.IChronosDanmakuReportCallback
                    public void onChronosDanmakuReport(String danmakuId2, String reason, String shieldUserId, boolean shieldUser2, String oid2) {
                        Intrinsics.checkNotNullParameter(danmakuId2, "danmakuId");
                        Intrinsics.checkNotNullParameter(reason, "reason");
                        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
                        BLog.i("LocalServiceHandler", "ChronosDanmakuReport: danmakuId: " + danmakuId2 + ", reason: " + reason + ", shieldUser: " + shieldUser2 + ", shieldUserId: " + shieldUserId);
                        IChronosLocalService.CC.reportDanmaku$default(LocalServiceHandler.this.getChronosService(), danmakuId2, reason, shieldUser2, shieldUserId, oid2, false, false, null, null, 480, null);
                    }
                }, 0, 4, null);
                danmakuReportDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        LocalServiceHandler.reportDanmaku$lambda$3(onResult, danmakuReportDialog, dialogInterface);
                    }
                });
                String content2 = req.getContent();
                String str2 = content2 == null ? "" : content2;
                Long appearanceTime = req.getAppearanceTime();
                long longValue = appearanceTime != null ? appearanceTime.longValue() : 0L;
                Long duration = req.getDuration();
                long longValue2 = duration != null ? duration.longValue() : 0L;
                String userHash2 = req.getUserHash();
                danmakuReportDialog.setReportedDanmaku(danmakuId, type2, str2, longValue, longValue2, userHash2 == null ? "" : userHash2, shieldUser, req.getOid());
                danmakuReportDialog.show();
                return;
            }
            return;
        }
        String oid2 = req.getOid();
        String content3 = req.getContent();
        String str3 = content3 == null ? "" : content3;
        Long appearanceTime2 = req.getAppearanceTime();
        long longValue3 = appearanceTime2 != null ? appearanceTime2.longValue() : 0L;
        Long duration2 = req.getDuration();
        long longValue4 = duration2 != null ? duration2.longValue() : 0L;
        String userHash3 = req.getUserHash();
        ChronosReportFunctionWidget.Configuration config = new ChronosReportFunctionWidget.Configuration(type2, danmakuId, oid2, str3, longValue3, longValue4, userHash3 == null ? "" : userHash3, new Function2() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit reportDanmaku$lambda$4;
                reportDanmaku$lambda$4 = LocalServiceHandler.reportDanmaku$lambda$4(onResult, ((Integer) obj).intValue(), (Boolean) obj2);
                return reportDanmaku$lambda$4;
            }
        });
        showReportPanel(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDanmaku$lambda$0(Function2 $onComplete, boolean success, Boolean block) {
        ReportDanmaku.Response result = new ReportDanmaku.Response();
        result.setSuccess(Boolean.valueOf(success));
        result.setBlock(block);
        $onComplete.invoke(result, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDanmaku$lambda$1(LocalServiceHandler this$0, ReportDanmaku.Request $req, boolean result, boolean blockUser, Boolean shieldUser, String dmId, String reason, String shieldUserId, String oid, GeneralResponse rResponse) {
        Intrinsics.checkNotNullParameter(dmId, "dmId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        this$0.getChronosService().reportDanmaku(dmId, reason, shieldUser != null ? shieldUser.booleanValue() : false, shieldUserId, oid, false, blockUser, rResponse, $req.getContent());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDanmaku$lambda$2(LocalServiceHandler this$0, ReportDanmaku.Request $req, boolean result, boolean blockUser, Boolean shieldUser, String dmId, String reason, String shieldUserId, String oid, GeneralResponse rResponse) {
        Intrinsics.checkNotNullParameter(dmId, "dmId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        this$0.getChronosService().reportDanmaku(dmId, reason, shieldUser != null ? shieldUser.booleanValue() : false, shieldUserId, oid, false, blockUser, rResponse, $req.getContent());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportDanmaku$lambda$3(Function2 $onResult, ChronosDanmakuReportBottomSheet $danmakuReportDialog, DialogInterface it) {
        $onResult.invoke(Boolean.valueOf($danmakuReportDialog.getDismissReason() == 1), Boolean.valueOf($danmakuReportDialog.getShieldUser()));
    }

    @JvmStatic
    private static ClipData __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(Object obj) {
        ClipData.Item itemAt;
        CharSequence text;
        Intrinsics.checkNotNullParameter(obj, "obj");
        ClipData data = ((ClipboardManager) obj).getPrimaryClip();
        String str = null;
        if (!(data instanceof ClipData)) {
            data = null;
        }
        if (data != null && (itemAt = data.getItemAt(0)) != null && (text = itemAt.getText()) != null) {
            str = text.toString();
        }
        BLog.d("privacy", "getPrimaryClip: clipdata = " + str);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDanmaku$lambda$4(Function2 $onResult, int closeReason, Boolean shieldUser) {
        $onResult.invoke(Boolean.valueOf(closeReason == 1), shieldUser);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void reportSubtitle(ReportSubtitle.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        boolean z;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (getMPlayerContainer().getControlContainerService().getScreenModeType() == ScreenModeType.THUMB) {
            ReportSubtitle.Response result = new ReportSubtitle.Response();
            RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
            if (mRpcInvokeObserver != null) {
                z = Boolean.valueOf(mRpcInvokeObserver.showSubtitleReportDialog(req != null ? req.getPrimary() : null, req != null ? req.getSecondary() : null));
            } else {
                z = false;
            }
            result.setSuccess(z);
            function2.invoke(result, (Object) null);
            return;
        }
        SubtitleReportFunctionWidget.Configuration config = new SubtitleReportFunctionWidget.Configuration(req != null ? req.getPrimary() : null, req != null ? req.getSecondary() : null);
        showSubtitleReportPanel(config);
        ReportSubtitle.Response result2 = new ReportSubtitle.Response();
        result2.setSuccess(true);
        function2.invoke(result2, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void staffFollowStateChange(UpdateVideoDetailState.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        UpdateVideoDetailState.VoteState it;
        UpdateVideoDetailState.CheckInState it2;
        RpcInvokeObserver mRpcInvokeObserver;
        UpdateVideoDetailState.ReserveState it3;
        RpcInvokeObserver mRpcInvokeObserver2;
        List it4;
        RpcInvokeObserver mRpcInvokeObserver3;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req != null && (it4 = req.getFollowStates()) != null && (mRpcInvokeObserver3 = getMRpcInvokeObserver()) != null) {
            mRpcInvokeObserver3.onUpdateStaffFollowState(it4);
        }
        if (req != null && (it3 = req.getReserveState()) != null && (mRpcInvokeObserver2 = getMRpcInvokeObserver()) != null) {
            mRpcInvokeObserver2.onUpdateReserveState(it3);
        }
        if (req != null && (it2 = req.getClockInState()) != null && (mRpcInvokeObserver = getMRpcInvokeObserver()) != null) {
            mRpcInvokeObserver.onUpdateClockInState(it2);
        }
        if (req != null && (it = req.getVoteState()) != null) {
            Violet.INSTANCE.sendMsg(new IMultiEvent.VoteDanmakuChangeEvent(it.getVoteId(), it.getOptionIndex()));
        }
        function2.invoke((Object) null, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updateClipboard(UpdateClipboard.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        String content = req != null ? req.getContent() : null;
        if (content != null) {
            String it = content;
            try {
                Object systemService = getMPlayerContainer().getContext().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipboardManager cm = (ClipboardManager) systemService;
                cm.setPrimaryClip(ClipData.newPlainText("chronos-pkg", it));
                function2.invoke(new UpdateClipboard.Response(), (Object) null);
                return;
            } catch (Exception e) {
                function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), e.toString());
                return;
            }
        }
        LocalServiceHandler $this$updateClipboard_u24lambda_u241 = this;
        try {
            Object systemService2 = $this$updateClipboard_u24lambda_u241.getMPlayerContainer().getContext().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardManager cm2 = (ClipboardManager) systemService2;
            ClipData mClipData = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(cm2);
            if (mClipData != null) {
                if (mClipData.getItemCount() > 0) {
                    UpdateClipboard.Response result = new UpdateClipboard.Response();
                    result.setContent((String) mClipData.getItemAt(0).getText());
                    function2.invoke(result, (Object) null);
                } else {
                    function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), "clipboard is empty");
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), e2.toString());
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void adDanmakuEvent(AdDanmakuEvent.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        AdDanmakuDelegate delegate = getChronosService().getAdDanmakuDelegate();
        if (delegate == null) {
            function22.invoke(-1, (Object) null);
        }
        if (req == null || delegate == null) {
            return;
        }
        delegate.onEvent(req);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void replyDanmaku(ReplyDanmaku.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        RpcInvokeObserver mRpcInvokeObserver;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if ((req != null ? req.getDanmakuId() : null) != null && req.getContent() != null && req.getAppearanceTime() != null && req.getUserHash() != null && (mRpcInvokeObserver = getMRpcInvokeObserver()) != null) {
            String danmakuId = req.getDanmakuId();
            Intrinsics.checkNotNull(danmakuId);
            String content = req.getContent();
            Intrinsics.checkNotNull(content);
            Long appearanceTime = req.getAppearanceTime();
            Intrinsics.checkNotNull(appearanceTime);
            long longValue = appearanceTime.longValue();
            String userHash = req.getUserHash();
            Intrinsics.checkNotNull(userHash);
            mRpcInvokeObserver.onDanmakuReply(danmakuId, content, longValue, userHash);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updatePlayerControlBar(UpdatePlayerControlBar.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null) {
            return;
        }
        Boolean tinyProgress = req.getTinyProgress();
        if (tinyProgress != null) {
            boolean it = tinyProgress.booleanValue();
            if (it) {
                SeekService service = this.mSeekServiceClient.getService();
                if (service != null) {
                    service.tryToShowSimpleProgress();
                }
            } else {
                SeekService service2 = this.mSeekServiceClient.getService();
                if (service2 != null) {
                    service2.hideSimpleProgress();
                }
            }
            function2.invoke((Object) null, (Object) null);
            return;
        }
        Boolean display = req.getDisplay();
        if (display != null) {
            boolean it2 = display.booleanValue();
            if (it2) {
                getMPlayerContainer().getControlContainerService().show();
            } else {
                getMPlayerContainer().getControlContainerService().hide();
            }
            function2.invoke((Object) null, (Object) null);
            return;
        }
        LocalServiceHandler $this$updatePlayerControlBar_u24lambda_u242 = this;
        UpdatePlayerControlBar.Response result = new UpdatePlayerControlBar.Response();
        result.setDisplay(Boolean.valueOf($this$updatePlayerControlBar_u24lambda_u242.getMPlayerContainer().getControlContainerService().isShowing()));
        SeekService service3 = $this$updatePlayerControlBar_u24lambda_u242.mSeekServiceClient.getService();
        result.setTinyProgress(service3 != null ? Boolean.valueOf(service3.isSimpleProgressShowing()) : null);
        function2.invoke(result, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updatePreference(UpdatePreference.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null) {
            return;
        }
        RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
        UpdatePreference.Response result = mRpcInvokeObserver != null ? mRpcInvokeObserver.updatePreference(req.getKey(), req.getValue()) : null;
        if (result != null) {
            UpdatePreference.Response $this$updatePreference_u24lambda_u240 = result;
            function2.invoke($this$updatePreference_u24lambda_u240, (Object) null);
            return;
        }
        IPlayerSettingService settingService = getMPlayerContainer().getPlayerSettingService();
        if (req.getValue() != null) {
            settingService.putString(req.getKey(), String.valueOf(req.getValue()));
        }
        String returnValue = settingService.getString(req.getKey(), "");
        if (returnValue.length() == 0) {
            function2.invoke((Object) null, (Object) null);
            return;
        }
        UpdatePreference.Response $this$updatePreference_u24lambda_u241 = new UpdatePreference.Response();
        $this$updatePreference_u24lambda_u241.setValue(returnValue);
        function2.invoke($this$updatePreference_u24lambda_u241, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void showPlayerWebView(ShowPlayerWebView.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        String it;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req != null && (it = req.getUrl()) != null) {
            RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
            if (mRpcInvokeObserver != null) {
                mRpcInvokeObserver.showPlayerWebView(it);
            }
            function2.invoke((Object) null, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void getPlayerComponentsHeight(GetPlayerComponentsHeight.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        int[] pair;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        GetPlayerComponentsHeight.Response result = new GetPlayerComponentsHeight.Response();
        RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
        if (mRpcInvokeObserver == null || (pair = mRpcInvokeObserver.getPlayerComponentsHeight()) == null) {
            function2.invoke(result, (Object) null);
            return;
        }
        result.setPanelHeight(Integer.valueOf((int) (pair[0] / getDisplayDensity())));
        result.setTotalHeight(Integer.valueOf((int) (pair[1] / getDisplayDensity())));
        function2.invoke(result, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void invokeCommandDetailPanel(InvokeCommandDetailPanel.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        RpcInvokeObserver mRpcInvokeObserver;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null || req.getType() == null || (mRpcInvokeObserver = getMRpcInvokeObserver()) == null) {
            return;
        }
        mRpcInvokeObserver.onInvokeDanmakuInputPanel(req.getParams());
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void updateDanmakuInputPanel(UpdateDanmakuInputPanel.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(request, WAuthErrorMsg.ERROR_MESSAGE_REQUEST);
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
        if (mRpcInvokeObserver != null) {
            mRpcInvokeObserver.updateDanmakuInputPanel(request.getInputText(), request.getShowState(), request.getGetDmProperty(), function2);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void notifyDanmakuExperiment(NotifyDanmakuExperiment.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(request, WAuthErrorMsg.ERROR_MESSAGE_REQUEST);
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Map $this$forEach$iv = request.getState();
        if ($this$forEach$iv == null) {
            return;
        }
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            String experimentName = element$iv.getKey();
            boolean isHit = element$iv.getValue().booleanValue();
            RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
            if (mRpcInvokeObserver != null) {
                mRpcInvokeObserver.notifyDanmakuExperiment(experimentName, isHit);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void notifyDanmakuSent(NotifyDanmakuSent.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(request, WAuthErrorMsg.ERROR_MESSAGE_REQUEST);
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        RpcInvokeObserver mRpcInvokeObserver = getMRpcInvokeObserver();
        if (mRpcInvokeObserver != null) {
            mRpcInvokeObserver.notifyDanmakuSent(request.getCid());
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void setVideoMute(MuteVideo.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (request == null) {
            return;
        }
        if (request.isMute()) {
            getMPlayerContainer().getPlayerCoreService().setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        } else {
            getMPlayerContainer().getPlayerCoreService().setVolume(1.0f, 1.0f);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void getAudioStreams(GetAudioTrack.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        GetAudioTrack.Response response = new GetAudioTrack.Response();
        response.setAudioStreams(ArraysKt.toTypedArray(getMPlayerContainer().getPlayerCoreService().getAudioStreamsIndex()));
        response.setCurrentAudioIndex(Integer.valueOf(getMPlayerContainer().getPlayerCoreService().getCurrentAudioIndex()));
        response.setDefaultAudioIndex(Integer.valueOf(getMPlayerContainer().getPlayerCoreService().getDefaultAudioIndex()));
        function2.invoke(response, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void switchAudioIndex(SwitchAudioTrack.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        if (request == null) {
            return;
        }
        IPlayerCoreService playerCoreService = getMPlayerContainer().getPlayerCoreService();
        String audioIndex = request.getAudioIndex();
        int result = playerCoreService.setAudioIndex(audioIndex != null ? StringsKt.toIntOrNull(audioIndex) : null);
        SwitchAudioTrack.Response response = new SwitchAudioTrack.Response();
        response.setSuccess(result == 0);
        function2.invoke(response, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalService
    public void notifyCommercialEvent(NotifyCommercialEvent.Request request, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(request, WAuthErrorMsg.ERROR_MESSAGE_REQUEST);
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        AdDanmakuDelegate delegate = getChronosService().getAdDanmakuDelegate();
        if (delegate != null) {
            delegate.onNotifyCommercialEvent(request);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler, tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler
    public void onStart(boolean multiPlayer) {
        BiliAccounts.get(getMPlayerContainer().getContext()).subscribe(this, new Topic[]{Topic.SIGN_IN});
        super.onStart(multiPlayer);
        getMPlayerContainer().getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(SeekService.class), this.mSeekServiceClient);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler, tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler
    public void onStop() {
        BiliAccounts.get(getMPlayerContainer().getContext()).unsubscribe(this, new Topic[]{Topic.SIGN_IN});
        this.mPendingLoginActionList.clear();
        super.onStop();
        unregisterRpcInvokeObserver();
        getMPlayerContainer().getPlayerServiceManager().unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(SeekService.class), this.mSeekServiceClient);
        this.mInteractModeObserverList.clear();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler, tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void initChronosView(EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner) {
        if (enhancedChronosPackageRunner != null) {
            setMMessageHandler(new ChronosMessageHandler(enhancedChronosPackageRunner, this, getMBusinessMessageHandler()));
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler
    public void addInteractModeObserver(InteractModeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mInteractModeObserverList.contains(observer)) {
            this.mInteractModeObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler
    public void removeInteractModeObserver(InteractModeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mInteractModeObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler
    public boolean isInteractiveMode() {
        return Intrinsics.areEqual(this.currentUiMode, UpdateUIMode.INTERACTIVE);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler
    public RpcInvokeObserver getRpcInvokeObserver() {
        return getMRpcInvokeObserver();
    }

    private final void showSubtitleReportPanel(SubtitleReportFunctionWidget.Configuration config) {
        IFunctionContainer.LayoutParams layoutParams;
        int i;
        ScreenModeType screenModeType = getMPlayerContainer().getControlContainerService().getScreenModeType();
        if (screenModeType == ScreenModeType.VERTICAL_FULLSCREEN) {
            layoutParams = new IFunctionContainer.LayoutParams(-1, (int) DpUtils.dp2px(getMPlayerContainer().getContext(), 400.0f));
        } else {
            layoutParams = new IFunctionContainer.LayoutParams((int) DpUtils.dp2px(getMPlayerContainer().getContext(), 364.0f), -1);
        }
        if (screenModeType == ScreenModeType.VERTICAL_FULLSCREEN) {
            i = 8;
        } else {
            i = 4;
        }
        layoutParams.setLayoutType(i);
        boolean originScene = getChronosService().getSceneAndBiz().getFirst() == ChronosScene.SCENE_STORY;
        if (!originScene) {
            getMPlayerContainer().getControlContainerService().hide();
        } else {
            getChronosService().hideControlContainer();
        }
        FunctionWidgetToken token = getMPlayerContainer().getFunctionWidgetService().showWidget(SubtitleReportFunctionWidget.class, layoutParams);
        if (token != null) {
            getMPlayerContainer().getFunctionWidgetService().updateFunctionWidgetConfiguration(token, config);
        }
    }

    private final void showReportPanel(ChronosReportFunctionWidget.Configuration config) {
        IFunctionContainer.LayoutParams layoutParams;
        int i;
        Context context = getMPlayerContainer().getContext();
        if (getMPlayerContainer().getControlContainerService().getScreenModeType() == ScreenModeType.THUMB) {
            return;
        }
        if (!BiliAccounts.get(context).isLogin()) {
            PlayerRouteUris.Routers.login$default(PlayerRouteUris.Routers.INSTANCE, context, PlayerRouteUris.Routers.REQUEST_CODE_LOGIN_DANMAKU_MANAGER, null, 4, null);
            return;
        }
        ScreenModeType screenModeType = getMPlayerContainer().getControlContainerService().getScreenModeType();
        if (screenModeType == ScreenModeType.VERTICAL_FULLSCREEN) {
            layoutParams = new IFunctionContainer.LayoutParams(-1, (int) DpUtils.dp2px(getMPlayerContainer().getContext(), 380.0f));
        } else {
            layoutParams = new IFunctionContainer.LayoutParams((int) DpUtils.dp2px(getMPlayerContainer().getContext(), 320.0f), -1);
        }
        if (screenModeType == ScreenModeType.VERTICAL_FULLSCREEN) {
            i = 8;
        } else {
            i = 4;
        }
        layoutParams.setLayoutType(i);
        boolean originSceneFromStory = getChronosService().getSceneAndBiz().getFirst() == ChronosScene.SCENE_STORY;
        if (!originSceneFromStory) {
            getMPlayerContainer().getControlContainerService().hide();
        } else {
            getChronosService().hideControlContainer();
        }
        FunctionWidgetToken mSubtitleReportToken = getMPlayerContainer().getFunctionWidgetService().showWidget(ChronosReportFunctionWidget.class, layoutParams);
        if (mSubtitleReportToken != null) {
            getMPlayerContainer().getFunctionWidgetService().updateFunctionWidgetConfiguration(mSubtitleReportToken, config);
        }
    }

    private final void dispatchInteractMode(final boolean interactMode) {
        this.mInteractModeObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((InteractModeObserver) obj).onInteractModeChanged(interactMode);
            }
        });
    }

    private final boolean needShowReportBottomSheetDialog() {
        ScreenModeType screenModeType = getMPlayerContainer().getControlContainerService().getScreenModeType();
        boolean reportFromThumb = screenModeType == ScreenModeType.THUMB;
        boolean reportMessageFromStory = getChronosService().getSceneAndBiz().getFirst() == ChronosScene.SCENE_STORY && screenModeType == ScreenModeType.VERTICAL_FULLSCREEN;
        return reportFromThumb || reportMessageFromStory;
    }

    public void onChange(Topic topic) {
        if (topic == Topic.SIGN_IN) {
            handlePendingLoginActions();
        }
    }

    private final synchronized void handlePendingLoginActions() {
        Iterable $this$forEach$iv = this.mPendingLoginActionList;
        for (Object element$iv : $this$forEach$iv) {
            Runnable it = (Runnable) element$iv;
            HandlerThreads.postDelayed(0, it, 500L);
        }
        this.mPendingLoginActionList.clear();
    }

    /* compiled from: LocalServiceHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/LocalServiceHandler$Companion;", "", "<init>", "()V", "TAG", "", "DANMAKU_FEEDBACK_H5_URL", "getDANMAKU_FEEDBACK_H5_URL", "()Ljava/lang/String;", "DANMAKU_FEEDBACK_H5_URL$delegate", "Lkotlin/Lazy;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getDANMAKU_FEEDBACK_H5_URL() {
            return (String) LocalServiceHandler.DANMAKU_FEEDBACK_H5_URL$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DANMAKU_FEEDBACK_H5_URL_delegate$lambda$0() {
        String dd = DeviceDecision.INSTANCE.dd("dd_danmaku_feedback_h5_url", "");
        return dd == null ? "" : dd;
    }
}