package tv.danmaku.biliplayerv2.service.interact.biz.container;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bapis.bilibili.app.distribution.GetUserPreferenceReply;
import com.bapis.bilibili.app.viewunite.v1.FragmentParam;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.common.chronoscommon.ChronosConfigManager;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.common.chronoscommon.EnhancedChronosRenderer;
import com.bilibili.common.chronoscommon.EnhancedChronosView;
import com.bilibili.common.chronoscommon.EnhancedChronosViewKt;
import com.bilibili.common.chronoscommon.RenderMode;
import com.bilibili.common.chronoscommon.TransparencyMode;
import com.bilibili.common.chronoscommon.plugins.NetworkPlugin;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.pvtracker.PageViewTracker;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.FrameRenderedInfo;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IRenderLayer;
import tv.danmaku.biliplayerv2.service.IWindowInsetObserver;
import tv.danmaku.biliplayerv2.service.RenderContainerMatrixChangedObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.service.interact.biz.ChronosSaveState;
import tv.danmaku.biliplayerv2.service.interact.biz.DanmakuCommandPanelsObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.DanmakuInteractionObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.IWatchPointsLoadListener;
import tv.danmaku.biliplayerv2.service.interact.biz.OnChronosReadyCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.ViewProgressObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.AdDanmakuDelegate;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosConfig;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.PackageResult;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.LocalServiceHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateUIMode;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.SceneBizChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IChronosRemoteService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.Chronos;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoGuide;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoViewPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.IMultiDanmakuCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuInteractiveWrapper;
import tv.danmaku.biliplayerv2.service.interact.biz.share.ChronosShareManager;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsPanel;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailConfig;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.TransformParams;

/* compiled from: ChronosInteractContainer.kt */
@Metadata(d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002FQ\u0018\u0000 ×\u00012\u00020\u0001:\u0002×\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010[\u001a\u00020\\H\u0002J\u0012\u0010]\u001a\u00020\\2\b\u0010^\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010_\u001a\u00020\\2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aJ,\u0010c\u001a\u00020\\2\b\u0010d\u001a\u0004\u0018\u00010\r2\b\u0010e\u001a\u0004\u0018\u00010#2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0016J\u0012\u0010i\u001a\u00020\\2\b\u0010j\u001a\u0004\u0018\u00010\rH\u0016J$\u0010k\u001a\u00020\\2\b\u0010l\u001a\u0004\u0018\u00010#2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J:\u0010k\u001a\u00020\\2\b\u0010l\u001a\u0004\u0018\u00010#2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010p2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020s\u0018\u00010rH\u0016J\u0010\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020\u0019H\u0016J\b\u0010v\u001a\u00020\\H\u0016J\u0012\u0010w\u001a\u00020\\2\b\u0010x\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010y\u001a\u00020\\2\u0006\u0010z\u001a\u00020=H\u0016J\u0010\u0010{\u001a\u00020\\2\u0006\u0010z\u001a\u00020=H\u0016J\u001c\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\\2\u0007\u0010\u0083\u0001\u001a\u000204H\u0016J\u000b\u0010\u0084\u0001\u001a\u0004\u0018\u00010XH\u0016J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010ZH\u0016J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0017H\u0016J\u000b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u0089\u0001\u001a\u00020\u000fH\u0016J;\u0010\u008a\u0001\u001a\u00020\\2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020g2\u0007\u0010\u008e\u0001\u001a\u00020\u000f2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0rH\u0016J\t\u0010\u008f\u0001\u001a\u00020\\H\u0016J\t\u0010\u0090\u0001\u001a\u00020\\H\u0016J\t\u0010\u0091\u0001\u001a\u00020\\H\u0016Jg\u0010\u0092\u0001\u001a\u00020\\2\u0007\u0010\u0093\u0001\u001a\u00020#2\u0007\u0010\u0094\u0001\u001a\u00020#2\u0007\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0096\u0001\u001a\u00020#2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u0098\u0001\u001a\u00020\u000f2\u0007\u0010\u0099\u0001\u001a\u00020\u000f2\u0010\u0010\u009a\u0001\u001a\u000b\u0012\u0004\u0012\u00020#\u0018\u00010\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010\u009d\u0001\u001a\u00020\\2\u0007\u0010\u009e\u0001\u001a\u00020\u000fH\u0016J\u000b\u0010\u009f\u0001\u001a\u0004\u0018\u00010!H\u0016J\u000b\u0010 \u0001\u001a\u0004\u0018\u00010%H\u0016J\t\u0010¡\u0001\u001a\u00020\u000fH\u0016J\t\u0010¢\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010£\u0001\u001a\u00020\\2\u0007\u0010\u009e\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010¤\u0001\u001a\u00020\\2\u0007\u0010\u009e\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010¥\u0001\u001a\u00020\\2\u0007\u0010¦\u0001\u001a\u00020#2\u0007\u0010§\u0001\u001a\u00020#H\u0016J\t\u0010¨\u0001\u001a\u00020\\H\u0016J\u0011\u0010©\u0001\u001a\u00020\\2\u0006\u0010z\u001a\u00020?H\u0016J\u0011\u0010ª\u0001\u001a\u00020\\2\u0006\u0010z\u001a\u00020?H\u0016J\u0011\u0010«\u0001\u001a\u00020\\2\u0006\u0010z\u001a\u000206H\u0016J\t\u0010¬\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020\\2\u0007\u0010®\u0001\u001a\u00020\u000fH\u0016J\t\u0010¯\u0001\u001a\u00020\u000fH\u0016J\u0017\u0010°\u0001\u001a\u00020\\2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u000f0AH\u0016J\u0017\u0010±\u0001\u001a\u00020\\2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u000f0AH\u0016J\u0012\u0010²\u0001\u001a\u00020\\2\u0007\u0010³\u0001\u001a\u00020CH\u0016J\u0012\u0010´\u0001\u001a\u00020\\2\u0007\u0010³\u0001\u001a\u00020CH\u0016J\u0012\u0010µ\u0001\u001a\u00020\\2\u0007\u0010®\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010¶\u0001\u001a\u00020\\2\u0007\u0010·\u0001\u001a\u00020\u000fH\u0016J\u0015\u0010¸\u0001\u001a\u00020\\2\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\u000b\u0010»\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010¼\u0001\u001a\u00020\\2\u0007\u0010½\u0001\u001a\u00020\u0013H\u0016J\n\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J\t\u0010À\u0001\u001a\u00020\\H\u0016J\t\u0010Á\u0001\u001a\u00020\\H\u0016J\t\u0010Â\u0001\u001a\u00020\\H\u0002J\u0012\u0010Ã\u0001\u001a\u00020\\2\u0007\u0010Ä\u0001\u001a\u00020\u000fH\u0016J\t\u0010Å\u0001\u001a\u00020\\H\u0016J\t\u0010Æ\u0001\u001a\u00020\\H\u0016J\t\u0010Ç\u0001\u001a\u00020\u0003H\u0016J\u001d\u0010È\u0001\u001a\u00020\\2\b\u0010É\u0001\u001a\u00030Ê\u00012\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0016J\u0018\u0010Í\u0001\u001a\u0011\u0012\u0005\u0012\u00030Ê\u0001\u0012\u0005\u0012\u00030Ì\u00010Î\u0001H\u0016J\t\u0010Ï\u0001\u001a\u00020\\H\u0016J\t\u0010Ð\u0001\u001a\u00020\u000fH\u0016J\t\u0010Ñ\u0001\u001a\u00020\\H\u0016J\t\u0010Ò\u0001\u001a\u00020\\H\u0016J\u001c\u0010Ó\u0001\u001a\u00020\\2\b\u0010Ô\u0001\u001a\u00030Õ\u00012\u0007\u0010Ö\u0001\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0A0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0004\n\u0002\u0010GR!\u0010H\u001a\b\u0012\u0004\u0012\u00020J0I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010/\u001a\u0004\bK\u0010LR\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0004\n\u0002\u0010RR\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ø\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer;", "Ltv/danmaku/biliplayerv2/service/interact/biz/container/IChronosInteractContainer;", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "<init>", "(Ltv/danmaku/biliplayerv2/PlayerContainer;)V", "mChronosConfig", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosConfig;", "mApiResolver", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosApiResolver;", "mPackageResult", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/PackageResult;", "mLiveChronosPackage", "Lcom/bilibili/cron/ChronosPackage;", "mChronosEnable", "", "mSaveState", "Ltv/danmaku/biliplayerv2/service/interact/biz/ChronosSaveState;", "mChronosContainer", "Landroid/widget/FrameLayout;", "mChronosView", "Lcom/bilibili/common/chronoscommon/EnhancedChronosView;", "mDanmakuCommandPanels", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "mChronosReadyCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/OnChronosReadyCallback;", "mViewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "mAdDanmakuDelegate", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/AdDanmakuDelegate;", "mThumbnailConfig", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "mCurrentThumbLoader", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader;", "mCurrentThumbId", "", "mCurrentThumbLoader2", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2;", "mStarted", "mPendingLoadThumbnailInfo", "mThumbnailLoaderEnable", "mPendingLoadThumbnailInfo2", "mThumbnailLoader2Enable", "hitChaptersDD", "getHitChaptersDD", "()Z", "hitChaptersDD$delegate", "Lkotlin/Lazy;", "mSegmentSwitchValue", "mForcedChapterGuide", "mEyesProtectionMode", "mDanmakuContainerTranslationY", "", "mDanmakuInteractionObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuInteractionObserver;", "mDanmakuTransformParams", "Ltv/danmaku/render/core/TransformParams;", "mDanmakuFilterContainer", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFilterContainer;", "mViewProgressObserverList", "Ljava/util/LinkedList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/ViewProgressObserver;", "mDanmakuCommandPanelsObserverList", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuCommandPanelsObserver;", "mSegmentSwitchObservers", "Landroidx/lifecycle/Observer;", "mWatchPointsLoadListenerList", "Ltv/danmaku/biliplayerv2/service/interact/biz/IWatchPointsLoadListener;", "mWaitRequestCommands", "mWindowInsetObserver", "tv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$mWindowInsetObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$mWindowInsetObserver$1;", "mSegmentSwitch", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/app/distribution/GetUserPreferenceReply;", "getMSegmentSwitch", "()Lcom/bilibili/lib/moss/api/MossResponseHandler;", "mSegmentSwitch$delegate", "mApiResolveCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosApiResolver$ResolveCallback;", "mRenderContainerMatrixChangedObserver", "tv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$mRenderContainerMatrixChangedObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$mRenderContainerMatrixChangedObserver$1;", "mChronosLocalServiceImpl", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;", "mChronosRemoteServiceImpl", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IChronosRemoteService;", "mLocalHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalHandler;", "mRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "initChronos", "", "dispatchDanmakuCommandPanelsChanged", "danmakuCommands", "notifyWatchPointsLoaded", "pointsList", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "runChronosPackage", "chronosPackage", "md5", "aid", "", "cid", "runPackageForLive", "pkg", "addDanmaku", "dmId", "type", "", "extra", "", "emoExtra", "", "", "registerChronosReadyCallback", "callback", "unregisterChronosReadyCallback", "setThumbnailConfig", "config", "registerViewProgressObserver", "observer", "unregisterViewProgressObserver", "cloneMultiDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer;", "content", "Landroid/content/Context;", "multiDanmakuCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/IMultiDanmakuCallback;", "setDanmakuViewOffset", "offsetY", "getLocalHandler", "getRemoteHandler", "getAdDanmakuDelegate", "getDanmakuCommandPanelList", "getChronosView", "hasPackageResult", "loadViewProgress", "fragmentParam", "Lcom/bapis/bilibili/app/viewunite/v1/FragmentParam;", "fragmentOffset", "simplify", "loadCommandPanel", "loadThumbnailIfNeed", "loadThumbnailIfNeed2", "reportDanmaku", "danmakuId", "reason", "shieldUser", "shieldUserId", "oid", "needReportAndGetBlockData", "blockUser", "rResponse", "Lcom/bilibili/okretro/GeneralResponse;", "dmContent", "setChronosEnable", "enable", "getThumbnailFetcher", "getThumbnailFetcher2", "hasThumbnails", "hasThumbnails2", "setThumbnailEnable", "setThumbnail2Enable", "onWorkInfoChange", "workId", "videoId", "clearInteractContainer", "addDanmakuCommandPanelsObserver", "removeDanmakuCommandPanelsObserver", "addDanmakuInteractionObserver", "removeDanmakuInteractionObserver", "setSegmentSwitchValue", "value", "getSegmentSwitchValue", "addSegmentSwitchObserver", "removeSegmentSwitchObserver", "addWatchPointsLoadListener", "listener", "removeWatchPointsLoadListener", "setForcedChapterGuide", "setEyesProtectionMode", "mode", "onAttachByShared", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "getViewProgressDetail", "bindChronosContainer", "container", "getChronosContainer", "Landroid/view/ViewGroup;", "init", "restore", "setChronosNecessaryInfo", "releaseChronos", "saveState", "onStart", "onStop", "getPlayerContainer", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "getSceneAndBizParams", "Lkotlin/Pair;", "clearChronosPackage", "isChronosValid", "showDanmaku", "hideDanmaku", "onIJKFrameRendered", "info", "Ltv/danmaku/biliplayerv2/service/FrameRenderedInfo;", "isHdr", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosInteractContainer implements IChronosInteractContainer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChronosInteractContainer";
    private final Lazy hitChaptersDD$delegate;
    private AdDanmakuDelegate mAdDanmakuDelegate;
    private final ChronosApiResolver.ResolveCallback mApiResolveCallback;
    private ChronosApiResolver mApiResolver;
    private final ChronosConfig mChronosConfig;
    private FrameLayout mChronosContainer;
    private boolean mChronosEnable;
    private final IChronosLocalService mChronosLocalServiceImpl;
    private OnChronosReadyCallback mChronosReadyCallback;
    private final IChronosRemoteService mChronosRemoteServiceImpl;
    private EnhancedChronosView mChronosView;
    private String mCurrentThumbId;
    private ThumbnailLoader mCurrentThumbLoader;
    private ThumbnailLoader2 mCurrentThumbLoader2;
    private CommandsPanel mDanmakuCommandPanels;
    private final LinkedList<DanmakuCommandPanelsObserver> mDanmakuCommandPanelsObserverList;
    private float mDanmakuContainerTranslationY;
    private final DanmakuFilterContainer mDanmakuFilterContainer;
    private DanmakuInteractionObserver mDanmakuInteractionObserver;
    private TransformParams mDanmakuTransformParams;
    private boolean mEyesProtectionMode;
    private boolean mForcedChapterGuide;
    private ChronosPackage mLiveChronosPackage;
    private ILocalHandler mLocalHandler;
    private PackageResult mPackageResult;
    private boolean mPendingLoadThumbnailInfo;
    private boolean mPendingLoadThumbnailInfo2;
    private IRemoteHandler mRemoteHandler;
    private final ChronosInteractContainer$mRenderContainerMatrixChangedObserver$1 mRenderContainerMatrixChangedObserver;
    private ChronosSaveState mSaveState;
    private final Lazy mSegmentSwitch$delegate;
    private final LinkedList<Observer<Boolean>> mSegmentSwitchObservers;
    private boolean mSegmentSwitchValue;
    private boolean mStarted;
    private ThumbnailConfig mThumbnailConfig;
    private boolean mThumbnailLoader2Enable;
    private boolean mThumbnailLoaderEnable;
    private ViewProgressDetail mViewProgressDetail;
    private final LinkedList<ViewProgressObserver> mViewProgressObserverList;
    private boolean mWaitRequestCommands;
    private final LinkedList<IWatchPointsLoadListener> mWatchPointsLoadListenerList;
    private ChronosInteractContainer$mWindowInsetObserver$1 mWindowInsetObserver;
    private final PlayerContainer playerContainer;

    /* JADX WARN: Type inference failed for: r0v14, types: [tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mRenderContainerMatrixChangedObserver$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mWindowInsetObserver$1] */
    public ChronosInteractContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.playerContainer = playerContainer;
        this.mChronosConfig = new ChronosConfig();
        this.mApiResolver = new ChronosApiResolver();
        this.mChronosEnable = ChronosConfigManager.INSTANCE.isChronosAvailable();
        this.mChronosContainer = new FrameLayout(this.playerContainer.getContext(), null);
        this.mAdDanmakuDelegate = new AdDanmakuDelegate();
        this.mCurrentThumbId = "";
        this.mThumbnailLoaderEnable = true;
        this.hitChaptersDD$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean hitChaptersDD_delegate$lambda$0;
                hitChaptersDD_delegate$lambda$0 = ChronosInteractContainer.hitChaptersDD_delegate$lambda$0();
                return Boolean.valueOf(hitChaptersDD_delegate$lambda$0);
            }
        });
        this.mDanmakuFilterContainer = new DanmakuFilterContainer();
        this.mViewProgressObserverList = new LinkedList<>();
        this.mDanmakuCommandPanelsObserverList = new LinkedList<>();
        this.mSegmentSwitchObservers = new LinkedList<>();
        this.mWatchPointsLoadListenerList = new LinkedList<>();
        this.mWaitRequestCommands = true;
        this.mWindowInsetObserver = new IWindowInsetObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mWindowInsetObserver$1
            @Override // tv.danmaku.biliplayerv2.service.IWindowInsetObserver
            public void onWindowInsetChanged(WindowInset windowInset) {
                IRemoteHandler iRemoteHandler;
                Intrinsics.checkNotNullParameter(windowInset, "windowInset");
                iRemoteHandler = ChronosInteractContainer.this.mRemoteHandler;
                iRemoteHandler.onWindowInsetChanged(windowInset);
            }
        };
        this.mSegmentSwitch$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$$ExternalSyntheticLambda2
            public final Object invoke() {
                ChronosInteractContainer$mSegmentSwitch$2$1 mSegmentSwitch_delegate$lambda$0;
                mSegmentSwitch_delegate$lambda$0 = ChronosInteractContainer.mSegmentSwitch_delegate$lambda$0(ChronosInteractContainer.this);
                return mSegmentSwitch_delegate$lambda$0;
            }
        });
        this.mApiResolveCallback = new ChronosApiResolver.ResolveCallback() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mApiResolveCallback$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver.ResolveCallback
            public void onViewProgressChange(ViewProgressDetail viewProgressDetail) {
                Collection collection;
                ChronosInteractContainer.this.mViewProgressDetail = viewProgressDetail;
                collection = ChronosInteractContainer.this.mViewProgressObserverList;
                Collection $this$toTypedArray$iv = collection;
                Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new ViewProgressObserver[0]);
                for (Object element$iv : $this$forEach$iv) {
                    ViewProgressObserver it = (ViewProgressObserver) element$iv;
                    it.onUpdate(viewProgressDetail);
                }
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver.ResolveCallback
            public void onPackageResolveSuccess(PackageResult result, long aid, long cid) {
                PlayerContainer playerContainer2;
                String md5;
                boolean z;
                boolean z2;
                boolean hitChaptersDD;
                Chronos chronos;
                PlayerContainer playerContainer3;
                MossResponseHandler<GetUserPreferenceReply> mSegmentSwitch;
                VideoGuide videoGuide;
                VideoViewPoint videoPoint;
                Intrinsics.checkNotNullParameter(result, "result");
                ViewProgressDetail viewProgressDetail = result.getViewProgressDetail();
                boolean z3 = true;
                if ((viewProgressDetail == null || (videoGuide = viewProgressDetail.getVideoGuide()) == null || (videoPoint = videoGuide.getVideoPoint()) == null || !videoPoint.getPointPermanent()) ? false : true) {
                    playerContainer3 = ChronosInteractContainer.this.playerContainer;
                    PlayerCloudConfig cloudConfig = playerContainer3.getPlayerSettingService().getCloudConfig();
                    String valueOf = String.valueOf(aid);
                    String valueOf2 = String.valueOf(cid);
                    mSegmentSwitch = ChronosInteractContainer.this.getMSegmentSwitch();
                    cloudConfig.getSegmentProgress(valueOf, valueOf2, mSegmentSwitch);
                }
                playerContainer2 = ChronosInteractContainer.this.playerContainer;
                Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer2).getCurrentPlayableParams();
                Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
                if (displayParams == null || displayParams.getAvid() != aid) {
                    z3 = false;
                }
                if (z3 && displayParams.getCid() == cid) {
                    ChronosInteractContainer.this.mPackageResult = result;
                    ChronosInteractContainer chronosInteractContainer = ChronosInteractContainer.this;
                    ChronosPackage chronosPackage = result.getChronosPackage();
                    ViewProgressDetail viewProgressDetail2 = result.getViewProgressDetail();
                    if (viewProgressDetail2 == null || (chronos = viewProgressDetail2.getChronos()) == null || (md5 = chronos.getMd5()) == null) {
                        md5 = result.getMd5();
                    }
                    chronosInteractContainer.runChronosPackage(chronosPackage, md5, aid, cid);
                    z = ChronosInteractContainer.this.mPendingLoadThumbnailInfo;
                    if (z) {
                        ChronosInteractContainer.this.mPendingLoadThumbnailInfo = false;
                        ChronosInteractContainer.this.loadThumbnailIfNeed();
                    }
                    z2 = ChronosInteractContainer.this.mPendingLoadThumbnailInfo2;
                    if (!z2) {
                        hitChaptersDD = ChronosInteractContainer.this.getHitChaptersDD();
                        if (!hitChaptersDD) {
                            return;
                        }
                    }
                    ChronosInteractContainer.this.mPendingLoadThumbnailInfo2 = false;
                    ChronosInteractContainer.this.loadThumbnailIfNeed2();
                    return;
                }
                DanmakuLogger.INSTANCE.logChronos("resolve result aid: " + aid + " cid: " + cid + " but current playing aid: " + (displayParams != null ? Long.valueOf(displayParams.getAvid()) : null) + " cid: " + (displayParams != null ? Long.valueOf(displayParams.getCid()) : null));
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosApiResolver.ResolveCallback
            public void onCommandPanelsResolveSuccess(CommandsPanel result, long aid, long cid) {
                PlayerContainer playerContainer2;
                Video.DisplayParams displayParams;
                playerContainer2 = ChronosInteractContainer.this.playerContainer;
                Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer2).getCurrentPlayableParams();
                if (currentPlayableParams != null && (displayParams = currentPlayableParams.getDisplayParams()) != null && displayParams.getAvid() == aid && displayParams.getCid() == cid) {
                    ChronosInteractContainer.this.mDanmakuCommandPanels = result;
                    if (result != null) {
                        ChronosInteractContainer.this.dispatchDanmakuCommandPanelsChanged(result);
                    }
                }
            }
        };
        this.mRenderContainerMatrixChangedObserver = new RenderContainerMatrixChangedObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mRenderContainerMatrixChangedObserver$1
            @Override // tv.danmaku.biliplayerv2.service.RenderContainerMatrixChangedObserver
            public void onChanged(TransformParams transformParams) {
                float f;
                IRemoteHandler iRemoteHandler;
                PlayerContainer playerContainer2;
                float f2;
                f = ChronosInteractContainer.this.mDanmakuContainerTranslationY;
                if (!(f == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) && transformParams != null) {
                    float translationY = transformParams.getTranslationY();
                    f2 = ChronosInteractContainer.this.mDanmakuContainerTranslationY;
                    transformParams.setTranslationY(translationY + f2);
                }
                ChronosInteractContainer.this.mDanmakuTransformParams = transformParams;
                iRemoteHandler = ChronosInteractContainer.this.mRemoteHandler;
                playerContainer2 = ChronosInteractContainer.this.playerContainer;
                iRemoteHandler.onVideoSizeChanged(playerContainer2.getRenderContainerService().getRenderViewBounds(), transformParams);
            }
        };
        this.mChronosLocalServiceImpl = new IChronosLocalService() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mChronosLocalServiceImpl$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public /* synthetic */ int getNetWorkState() {
                int value;
                value = NetworkPlugin.State.STATE_WIFI.getValue();
                return value;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public Pair<ChronosScene, ChronosBiz> getSceneAndBiz() {
                ChronosConfig chronosConfig;
                ChronosConfig chronosConfig2;
                chronosConfig = ChronosInteractContainer.this.mChronosConfig;
                ChronosScene chronosScene = chronosConfig.getChronosScene();
                chronosConfig2 = ChronosInteractContainer.this.mChronosConfig;
                return new Pair<>(chronosScene, chronosConfig2.getChronosBiz());
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public String getPackageSandBoxDirectory() {
                EnhancedChronosView enhancedChronosView;
                PackageResult packageResult;
                ChronosPackage chronosPackage;
                ChronosPackage currentPackage;
                String sandBoxDirectory;
                enhancedChronosView = ChronosInteractContainer.this.mChronosView;
                if (enhancedChronosView == null || (currentPackage = enhancedChronosView.getCurrentPackage()) == null || (sandBoxDirectory = currentPackage.getSandBoxDirectory()) == null) {
                    packageResult = ChronosInteractContainer.this.mPackageResult;
                    String sandBoxDirectory2 = (packageResult == null || (chronosPackage = packageResult.getChronosPackage()) == null) ? null : chronosPackage.getSandBoxDirectory();
                    return sandBoxDirectory2 == null ? "" : sandBoxDirectory2;
                }
                return sandBoxDirectory;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public boolean getChronosAbConfig(String key) {
                ChronosConfig chronosConfig;
                Intrinsics.checkNotNullParameter(key, "key");
                chronosConfig = ChronosInteractContainer.this.mChronosConfig;
                return chronosConfig.getConfig(key);
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public void dispatchTouchEvent(MotionEvent event) {
                EnhancedChronosView enhancedChronosView;
                enhancedChronosView = ChronosInteractContainer.this.mChronosView;
                if (enhancedChronosView != null) {
                    enhancedChronosView.dispatchTouchEvent(event);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
                r1 = r4.this$0.mChronosView;
             */
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void syncUIMode(String uiMode) {
                EnhancedChronosView enhancedChronosView;
                EnhancedChronosView enhancedChronosView2;
                Intrinsics.checkNotNullParameter(uiMode, "uiMode");
                boolean z = true;
                boolean touchable = Intrinsics.areEqual(uiMode, UpdateUIMode.INTERACTIVE) || Intrinsics.areEqual(uiMode, UpdateUIMode.INTERACTIVE_WITHOUT_TOAST);
                enhancedChronosView = ChronosInteractContainer.this.mChronosView;
                if (enhancedChronosView == null || enhancedChronosView.isTouchable() != touchable) {
                    z = false;
                }
                if (z || enhancedChronosView2 == null) {
                    return;
                }
                enhancedChronosView2.setTouchable(touchable);
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public AdDanmakuDelegate getAdDanmakuDelegate() {
                AdDanmakuDelegate adDanmakuDelegate;
                adDanmakuDelegate = ChronosInteractContainer.this.mAdDanmakuDelegate;
                return adDanmakuDelegate;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public void reportDanmaku(String danmakuId, String reason, boolean shieldUser, String shieldUserId, String oid, boolean needReportAndGetBlockData, boolean blockUser, GeneralResponse<String> generalResponse, String dmContent) {
                PlayerContainer playerContainer2;
                PlayerContainer playerContainer3;
                Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
                Intrinsics.checkNotNullParameter(reason, "reason");
                Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
                HashMap param = new HashMap();
                param.put("report_reason", reason);
                param.put("dmid", danmakuId);
                HashMap hashMap = param;
                String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
                if (currentPolarisActionId == null) {
                    currentPolarisActionId = "";
                }
                hashMap.put("action_id", currentPolarisActionId);
                Neurons.reportClick(false, EventId.player_neuron_danmaku_report_submit, param);
                playerContainer2 = ChronosInteractContainer.this.playerContainer;
                playerContainer2.getPlayerSettingService().putBoolean(DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, shieldUser);
                DanmakuLogger.INSTANCE.logService("ChronosDanmakuReport: danmakuId: " + danmakuId + ", reason: " + reason + ", shieldUser: " + shieldUser + ", shieldUserId: " + shieldUserId);
                ChronosDanmakuInteractiveWrapper chronosDanmakuInteractiveWrapper = new ChronosDanmakuInteractiveWrapper();
                playerContainer3 = ChronosInteractContainer.this.playerContainer;
                chronosDanmakuInteractiveWrapper.reportDanmaku(playerContainer3, danmakuId, oid, reason, shieldUser, shieldUserId, new ChronosInteractContainer$mChronosLocalServiceImpl$1$reportDanmaku$1(ChronosInteractContainer.this), needReportAndGetBlockData, blockUser, generalResponse, dmContent);
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public ViewProgressDetail getViewProgressDetail() {
                ViewProgressDetail viewProgressDetail;
                viewProgressDetail = ChronosInteractContainer.this.mViewProgressDetail;
                return viewProgressDetail;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public boolean needShowChronosProgress() {
                boolean z;
                z = ChronosInteractContainer.this.mSegmentSwitchValue;
                return z;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public void hideControlContainer() {
                DanmakuInteractionObserver danmakuInteractionObserver;
                danmakuInteractionObserver = ChronosInteractContainer.this.mDanmakuInteractionObserver;
                if (danmakuInteractionObserver != null) {
                    danmakuInteractionObserver.hideControlContainer();
                }
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public boolean forcedChapterGuide() {
                boolean z;
                z = ChronosInteractContainer.this.mForcedChapterGuide;
                return z;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public boolean eyesProtectionMode() {
                boolean z;
                z = ChronosInteractContainer.this.mEyesProtectionMode;
                return z;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public TransformParams getDanmakuTransformParams() {
                TransformParams transformParams;
                transformParams = ChronosInteractContainer.this.mDanmakuTransformParams;
                return transformParams;
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
            public DanmakuFilterContainer getDanmakuFilterContainer() {
                DanmakuFilterContainer danmakuFilterContainer;
                danmakuFilterContainer = ChronosInteractContainer.this.mDanmakuFilterContainer;
                return danmakuFilterContainer;
            }
        };
        this.mChronosRemoteServiceImpl = new IChronosRemoteService() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mChronosRemoteServiceImpl$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IChronosRemoteService
            public Point getChronosSize() {
                EnhancedChronosView enhancedChronosView;
                EnhancedChronosView enhancedChronosView2;
                EnhancedChronosView enhancedChronosView3;
                enhancedChronosView = ChronosInteractContainer.this.mChronosView;
                if (enhancedChronosView == null) {
                    return null;
                }
                enhancedChronosView2 = ChronosInteractContainer.this.mChronosView;
                Intrinsics.checkNotNull(enhancedChronosView2);
                int width = enhancedChronosView2.getWidth();
                enhancedChronosView3 = ChronosInteractContainer.this.mChronosView;
                Intrinsics.checkNotNull(enhancedChronosView3);
                return new Point(width, enhancedChronosView3.getHeight());
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IChronosRemoteService
            public DanmakuFilterContainer getDanmakuFilterContainer() {
                DanmakuFilterContainer danmakuFilterContainer;
                danmakuFilterContainer = ChronosInteractContainer.this.mDanmakuFilterContainer;
                return danmakuFilterContainer;
            }
        };
        this.mLocalHandler = new LocalServiceHandler(this.mChronosLocalServiceImpl);
        this.mRemoteHandler = new RemoteServiceHandler(this.mChronosRemoteServiceImpl);
        this.mRemoteHandler.onBindPlayerContainer(this.playerContainer);
        this.mLocalHandler.onBindPlayerContainer(this.playerContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHitChaptersDD() {
        return ((Boolean) this.hitChaptersDD$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitChaptersDD_delegate$lambda$0() {
        return DeviceDecision.INSTANCE.getBoolean("dd_united_detail_chapters_translate", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MossResponseHandler<GetUserPreferenceReply> getMSegmentSwitch() {
        return (MossResponseHandler) this.mSegmentSwitch$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChronosInteractContainer$mSegmentSwitch$2$1 mSegmentSwitch_delegate$lambda$0(ChronosInteractContainer this$0) {
        return new ChronosInteractContainer$mSegmentSwitch$2$1(this$0);
    }

    private final void initChronos() {
        Object version;
        if (this.mChronosView == null) {
            DanmakuLogger.INSTANCE.logChronos("init chronos");
            try {
                version = EnhancedChronosPackageRunner.Companion.getVersion();
            } catch (Throwable e) {
                DanmakuLogger.INSTANCE.error("init chronos failed, cause " + e.getMessage());
                CrashReporter.INSTANCE.postCaughtException(e);
                version = Unit.INSTANCE;
            }
            try {
                DanmakuLogger.INSTANCE.logChronos("chronos engine version=" + version);
                if (this.mChronosConfig.chronosUseSurfaceView()) {
                    this.mChronosView = new EnhancedChronosView(this.playerContainer.getContext(), RenderMode.Surface, (TransparencyMode) null, true, false, false, 36, (DefaultConstructorMarker) null);
                    DanmakuLogger.INSTANCE.logChronos("chronos use surfaceView");
                } else {
                    this.mChronosView = new EnhancedChronosView(this.playerContainer.getContext(), RenderMode.Texture, (TransparencyMode) null, true, false, false, 36, (DefaultConstructorMarker) null);
                    DanmakuLogger.INSTANCE.logChronos("chronos use textureView");
                }
                EnhancedChronosView enhancedChronosView = this.mChronosView;
                if (enhancedChronosView != null) {
                    enhancedChronosView.setTouchable(false);
                }
                EnhancedChronosViewKt.addView(this.mChronosContainer, this.mChronosView, 0, new ViewGroup.LayoutParams(-1, -1));
                EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner = this.mChronosView;
                if (enhancedChronosPackageRunner != null) {
                    this.mRemoteHandler.initChronosView(enhancedChronosPackageRunner);
                    this.mLocalHandler.initChronosView(enhancedChronosPackageRunner);
                    ChronosShareManager.INSTANCE.config(enhancedChronosPackageRunner);
                    DanmakuLogger.INSTANCE.logChronos("init chronos finish");
                    OnChronosReadyCallback onChronosReadyCallback = this.mChronosReadyCallback;
                    if (onChronosReadyCallback != null) {
                        onChronosReadyCallback.onChronosReady();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } catch (Throwable e2) {
                DanmakuLogger.INSTANCE.error("init chronos failed, cause " + e2.getMessage());
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            DanmakuLogger danmakuLogger = DanmakuLogger.INSTANCE;
            EnhancedChronosView enhancedChronosView2 = this.mChronosView;
            danmakuLogger.error("init chronos but some reason chronosView:" + enhancedChronosView2 + " container:" + this.mChronosContainer);
        }
        this.mStarted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchDanmakuCommandPanelsChanged(CommandsPanel danmakuCommands) {
        Collection $this$toTypedArray$iv = this.mDanmakuCommandPanelsObserverList;
        Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new DanmakuCommandPanelsObserver[0]);
        for (Object element$iv : $this$forEach$iv) {
            DanmakuCommandPanelsObserver it = (DanmakuCommandPanelsObserver) element$iv;
            it.onDataSetChanged(danmakuCommands);
        }
    }

    public final void notifyWatchPointsLoaded(List<ChronosThumbnailInfo.WatchPoint> list) {
        List pointsList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Collection $this$toTypedArray$iv = this.mWatchPointsLoadListenerList;
        Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new IWatchPointsLoadListener[0]);
        for (Object element$iv : $this$forEach$iv) {
            IWatchPointsLoadListener it = (IWatchPointsLoadListener) element$iv;
            it.onLoaded(pointsList);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void runChronosPackage(ChronosPackage chronosPackage, String md5, long aid, long cid) {
        if (chronosPackage == null) {
            DanmakuLogger.INSTANCE.error("run package failed, cause package null");
            clearChronosPackage();
            return;
        }
        try {
            DanmakuLogger.INSTANCE.logChronos("try run pkg:" + chronosPackage.getInfo() + ", md5=" + md5);
            EnhancedChronosView enhancedChronosView = this.mChronosView;
            boolean z = false;
            if (enhancedChronosView != null && enhancedChronosView.isValid()) {
                z = true;
            }
            if (!z) {
                DanmakuLogger.INSTANCE.error("run package failed, cause chronos view not ready");
                return;
            }
            EnhancedChronosPackageRunner enhancedChronosPackageRunner = this.mChronosView;
            Intrinsics.checkNotNull(enhancedChronosPackageRunner);
            if (EnhancedChronosPackageRunner.runPackage$default(enhancedChronosPackageRunner, chronosPackage, md5, (Map) null, 4, (Object) null)) {
                DanmakuLogger.INSTANCE.logChronos("run package success");
            } else {
                DanmakuLogger.INSTANCE.error("run package failed, cause gl failure");
            }
            ChronosSaveState it = this.mSaveState;
            if (it != null) {
                Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
                Video.DanmakuResolveParams danmakuParams = currentPlayableParams != null ? currentPlayableParams.getDanmakuResolveParams() : null;
                if (danmakuParams != null && danmakuParams.getAvid() == it.getWorkId() && danmakuParams.getCid() == it.getVideoId() && it.getRemoteToken() != null) {
                    this.mRemoteHandler.restorePackage(it.getRemoteToken());
                }
            }
            this.mSaveState = null;
            IRemoteHandler iRemoteHandler = this.mRemoteHandler;
            PackageResult packageResult = this.mPackageResult;
            iRemoteHandler.configChronos(packageResult != null ? packageResult.getViewProgressDetail() : null, aid, cid);
            this.mAdDanmakuDelegate.configExposureRequest(aid, cid);
        } catch (Throwable e) {
            DanmakuLogger.INSTANCE.error("run package failed, cause " + e.getMessage());
            CrashReporter.INSTANCE.postCaughtException(e);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void runPackageForLive(ChronosPackage pkg) {
        if (pkg == null) {
            clearChronosPackage();
            return;
        }
        try {
            if (!Intrinsics.areEqual(this.mLiveChronosPackage, pkg)) {
                this.mLiveChronosPackage = pkg;
            }
            DanmakuLogger.INSTANCE.logChronos("try run live pkg:" + pkg.getInfo());
            EnhancedChronosView enhancedChronosView = this.mChronosView;
            boolean z = true;
            if (!(enhancedChronosView != null && enhancedChronosView.isValid())) {
                DanmakuLogger.INSTANCE.error("run live package failed, cause chronos view not ready");
                return;
            }
            EnhancedChronosPackageRunner enhancedChronosPackageRunner = this.mChronosView;
            if (enhancedChronosPackageRunner == null || !EnhancedChronosPackageRunner.runPackage$default(enhancedChronosPackageRunner, pkg, (String) null, (Map) null, 6, (Object) null)) {
                z = false;
            }
            if (z) {
                DanmakuLogger.INSTANCE.logChronos("run live package success");
            } else {
                DanmakuLogger.INSTANCE.error("run live package failed, cause gl failure");
            }
            ChronosSaveState it = this.mSaveState;
            if (it != null) {
                Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
                Video.DanmakuResolveParams danmakuParams = currentPlayableParams != null ? currentPlayableParams.getDanmakuResolveParams() : null;
                if (danmakuParams != null && danmakuParams.getAvid() == it.getWorkId() && danmakuParams.getCid() == it.getVideoId() && it.getRemoteToken() != null) {
                    this.mRemoteHandler.restorePackage(it.getRemoteToken());
                }
            }
            this.mSaveState = null;
        } catch (Throwable e) {
            DanmakuLogger.INSTANCE.error("run live package failed, cause " + e.getMessage());
            CrashReporter.INSTANCE.postCaughtException(e);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void addDanmaku(String dmId, int type, Object extra) {
        this.mRemoteHandler.addDanmaku(dmId, type, extra);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void addDanmaku(String dmId, int type, Object extra, Map<String, byte[]> map) {
        Map emoExtra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        this.mRemoteHandler.addDanmaku(dmId, type, extra, emoExtra);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void registerChronosReadyCallback(OnChronosReadyCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mChronosReadyCallback = callback;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void unregisterChronosReadyCallback() {
        this.mChronosReadyCallback = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setThumbnailConfig(ThumbnailConfig config) {
        ThumbnailLoader2 thumbnailLoader2;
        ThumbnailLoader thumbnailLoader;
        if (this.mCurrentThumbLoader != null && (thumbnailLoader = this.mCurrentThumbLoader) != null) {
            thumbnailLoader.setConfig(config);
        }
        if (this.mCurrentThumbLoader2 != null && (thumbnailLoader2 = this.mCurrentThumbLoader2) != null) {
            thumbnailLoader2.setConfig(config);
        }
        this.mThumbnailConfig = config;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void registerViewProgressObserver(ViewProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mViewProgressObserverList.contains(observer)) {
            this.mViewProgressObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void unregisterViewProgressObserver(ViewProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mViewProgressObserverList.remove(observer);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc A[Catch: Exception -> 0x0151, TryCatch #1 {Exception -> 0x0151, blocks: (B:24:0x00af, B:26:0x00b3, B:34:0x00c8, B:36:0x00cc, B:39:0x00d4, B:41:0x00df, B:43:0x00e5, B:49:0x00fc, B:51:0x0122, B:53:0x0126, B:55:0x012d, B:56:0x0139, B:45:0x00ef, B:47:0x00f3, B:30:0x00bd, B:32:0x00c1), top: B:68:0x00af, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4 A[Catch: Exception -> 0x0151, TryCatch #1 {Exception -> 0x0151, blocks: (B:24:0x00af, B:26:0x00b3, B:34:0x00c8, B:36:0x00cc, B:39:0x00d4, B:41:0x00df, B:43:0x00e5, B:49:0x00fc, B:51:0x0122, B:53:0x0126, B:55:0x012d, B:56:0x0139, B:45:0x00ef, B:47:0x00f3, B:30:0x00bd, B:32:0x00c1), top: B:68:0x00af, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[Catch: Exception -> 0x0151, TryCatch #1 {Exception -> 0x0151, blocks: (B:24:0x00af, B:26:0x00b3, B:34:0x00c8, B:36:0x00cc, B:39:0x00d4, B:41:0x00df, B:43:0x00e5, B:49:0x00fc, B:51:0x0122, B:53:0x0126, B:55:0x012d, B:56:0x0139, B:45:0x00ef, B:47:0x00f3, B:30:0x00bd, B:32:0x00c1), top: B:68:0x00af, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122 A[Catch: Exception -> 0x0151, TryCatch #1 {Exception -> 0x0151, blocks: (B:24:0x00af, B:26:0x00b3, B:34:0x00c8, B:36:0x00cc, B:39:0x00d4, B:41:0x00df, B:43:0x00e5, B:49:0x00fc, B:51:0x0122, B:53:0x0126, B:55:0x012d, B:56:0x0139, B:45:0x00ef, B:47:0x00f3, B:30:0x00bd, B:32:0x00c1), top: B:68:0x00af, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014d A[Catch: Exception -> 0x016e, TryCatch #0 {Exception -> 0x016e, blocks: (B:23:0x0051, B:57:0x013e, B:59:0x014d, B:62:0x0152, B:24:0x00af, B:26:0x00b3, B:34:0x00c8, B:36:0x00cc, B:39:0x00d4, B:41:0x00df, B:43:0x00e5, B:49:0x00fc, B:51:0x0122, B:53:0x0126, B:55:0x012d, B:56:0x0139, B:45:0x00ef, B:47:0x00f3, B:30:0x00bd, B:32:0x00c1), top: B:67:0x0051, inners: #1 }] */
    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiDanmakuPlayer cloneMultiDanmaku(Context content, final IMultiDanmakuCallback multiDanmakuCallback) {
        ChronosPackage chronosPackage;
        ChronosPackage currentPackage;
        PackageResult packageResult;
        String md5;
        Chronos chronos;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(multiDanmakuCallback, "multiDanmakuCallback");
        EnhancedChronosView enhancedChronosView = this.mChronosView;
        if ((enhancedChronosView != null ? enhancedChronosView.getCurrentPackage() : null) == null) {
            PackageResult packageResult2 = this.mPackageResult;
            if ((packageResult2 != null ? packageResult2.getChronosPackage() : null) == null) {
                DanmakuLogger.INSTANCE.error("copy multi danmakuView error:null package");
                return null;
            }
        }
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
        if (displayParams == null) {
            DanmakuLogger.INSTANCE.error("copy multi danmakuView error:null params");
            return null;
        }
        try {
            EnhancedChronosPackageRunner<?> enhancedChronosRenderer = new EnhancedChronosRenderer<>(content, true, false, 4, (DefaultConstructorMarker) null);
            SampleLocalServiceHandler localHandler = new SampleLocalServiceHandler(new IChronosLocalService() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$cloneMultiDanmaku$localHandler$1
                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public /* synthetic */ void dispatchTouchEvent(MotionEvent motionEvent) {
                    IChronosLocalService.CC.$default$dispatchTouchEvent(this, motionEvent);
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public /* synthetic */ AdDanmakuDelegate getAdDanmakuDelegate() {
                    return IChronosLocalService.CC.$default$getAdDanmakuDelegate(this);
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public /* synthetic */ int getNetWorkState() {
                    int value;
                    value = NetworkPlugin.State.STATE_WIFI.getValue();
                    return value;
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public /* synthetic */ void reportDanmaku(String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse generalResponse, String str5) {
                    IChronosLocalService.CC.$default$reportDanmaku(this, str, str2, z, str3, str4, z2, z3, generalResponse, str5);
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public /* synthetic */ void syncUIMode(String str) {
                    Intrinsics.checkNotNullParameter(str, "uiMode");
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public Pair<ChronosScene, ChronosBiz> getSceneAndBiz() {
                    IChronosLocalService iChronosLocalService;
                    ChronosScene scene = IMultiDanmakuCallback.this.getScene();
                    iChronosLocalService = this.mChronosLocalServiceImpl;
                    return new Pair<>(scene, iChronosLocalService.getSceneAndBiz().getSecond());
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public String getPackageSandBoxDirectory() {
                    IChronosLocalService iChronosLocalService;
                    iChronosLocalService = this.mChronosLocalServiceImpl;
                    return iChronosLocalService.getPackageSandBoxDirectory();
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public boolean getChronosAbConfig(String key) {
                    IChronosLocalService iChronosLocalService;
                    Intrinsics.checkNotNullParameter(key, "key");
                    iChronosLocalService = this.mChronosLocalServiceImpl;
                    return iChronosLocalService.getChronosAbConfig(key);
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public ViewProgressDetail getViewProgressDetail() {
                    IChronosLocalService iChronosLocalService;
                    iChronosLocalService = this.mChronosLocalServiceImpl;
                    return iChronosLocalService.getViewProgressDetail();
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public boolean needShowChronosProgress() {
                    IChronosLocalService iChronosLocalService;
                    iChronosLocalService = this.mChronosLocalServiceImpl;
                    return iChronosLocalService.needShowChronosProgress();
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public void hideControlContainer() {
                    DanmakuInteractionObserver danmakuInteractionObserver;
                    danmakuInteractionObserver = this.mDanmakuInteractionObserver;
                    if (danmakuInteractionObserver != null) {
                        danmakuInteractionObserver.hideControlContainer();
                    }
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public boolean forcedChapterGuide() {
                    return false;
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public boolean eyesProtectionMode() {
                    return false;
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public TransformParams getDanmakuTransformParams() {
                    TransformParams transformParams;
                    transformParams = this.mDanmakuTransformParams;
                    return transformParams;
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService
                public DanmakuFilterContainer getDanmakuFilterContainer() {
                    DanmakuFilterContainer danmakuFilterContainer;
                    danmakuFilterContainer = this.mDanmakuFilterContainer;
                    return danmakuFilterContainer;
                }
            });
            ChronosShareManager.INSTANCE.config(enhancedChronosRenderer);
            RemoteServiceHandler remoteHandler = new RemoteServiceHandler(new IChronosRemoteService() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$cloneMultiDanmaku$remoteHandler$1
                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IChronosRemoteService
                public Point getChronosSize() {
                    return null;
                }

                @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IChronosRemoteService
                public DanmakuFilterContainer getDanmakuFilterContainer() {
                    DanmakuFilterContainer danmakuFilterContainer;
                    danmakuFilterContainer = ChronosInteractContainer.this.mDanmakuFilterContainer;
                    return danmakuFilterContainer;
                }
            });
            MultiDanmakuPlayer danmakuPlayer = new MultiDanmakuPlayer(enhancedChronosRenderer, localHandler, remoteHandler);
            danmakuPlayer.start(this.playerContainer);
            localHandler.initChronosView(enhancedChronosRenderer);
            remoteHandler.initChronosView(enhancedChronosRenderer);
            localHandler.setMultiDanmakuPlayer(multiDanmakuCallback);
            DanmakuParams danmakuParams = this.playerContainer.getInteractLayerService().getDanmakuParams();
            remoteHandler.updateDanmakuParam(danmakuParams, true);
            try {
                PackageResult packageResult3 = this.mPackageResult;
                if (packageResult3 != null) {
                    currentPackage = packageResult3.getChronosPackage();
                    if (currentPackage == null) {
                    }
                    chronosPackage = currentPackage;
                    packageResult = this.mPackageResult;
                    if ((packageResult != null ? packageResult.getChronosPackage() : null) != null) {
                        PackageResult packageResult4 = this.mPackageResult;
                        Intrinsics.checkNotNull(packageResult4);
                        ViewProgressDetail viewProgressDetail = packageResult4.getViewProgressDetail();
                        md5 = (viewProgressDetail == null || (chronos = viewProgressDetail.getChronos()) == null) ? null : chronos.getMd5();
                    } else {
                        EnhancedChronosView enhancedChronosView2 = this.mChronosView;
                        md5 = enhancedChronosView2 != null ? enhancedChronosView2.getCurrentPackageMd5() : null;
                    }
                    EnhancedChronosPackageRunner.runPackage$default(enhancedChronosRenderer, chronosPackage, md5, (Map) null, 4, (Object) null);
                    remoteHandler.updateCurrentWorkChanged(String.valueOf(displayParams.getAvid()), String.valueOf(displayParams.getCid()));
                    if (this.mPackageResult != null) {
                        PackageResult packageResult5 = this.mPackageResult;
                        remoteHandler.configChronos(packageResult5 != null ? packageResult5.getViewProgressDetail() : null, displayParams.getAvid(), displayParams.getCid());
                    }
                    remoteHandler.onSegmentSettingChanged(this.mSegmentSwitchValue);
                    if (this.playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true)) {
                        remoteHandler.filtersChanged();
                    }
                    return danmakuPlayer;
                }
                EnhancedChronosView enhancedChronosView3 = this.mChronosView;
                if (enhancedChronosView3 != null) {
                    currentPackage = enhancedChronosView3.getCurrentPackage();
                    chronosPackage = currentPackage;
                    packageResult = this.mPackageResult;
                    if ((packageResult != null ? packageResult.getChronosPackage() : null) != null) {
                    }
                    EnhancedChronosPackageRunner.runPackage$default(enhancedChronosRenderer, chronosPackage, md5, (Map) null, 4, (Object) null);
                    remoteHandler.updateCurrentWorkChanged(String.valueOf(displayParams.getAvid()), String.valueOf(displayParams.getCid()));
                    if (this.mPackageResult != null) {
                    }
                    remoteHandler.onSegmentSettingChanged(this.mSegmentSwitchValue);
                    if (this.playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true)) {
                    }
                    return danmakuPlayer;
                }
                chronosPackage = null;
                packageResult = this.mPackageResult;
                if ((packageResult != null ? packageResult.getChronosPackage() : null) != null) {
                }
                EnhancedChronosPackageRunner.runPackage$default(enhancedChronosRenderer, chronosPackage, md5, (Map) null, 4, (Object) null);
                remoteHandler.updateCurrentWorkChanged(String.valueOf(displayParams.getAvid()), String.valueOf(displayParams.getCid()));
                if (this.mPackageResult != null) {
                }
                remoteHandler.onSegmentSettingChanged(this.mSegmentSwitchValue);
                if (this.playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true)) {
                }
                return danmakuPlayer;
            } catch (Exception ex) {
                DanmakuLogger.INSTANCE.error("copy multi danmakuView run package error:" + ex);
                danmakuPlayer.release();
                return null;
            }
        } catch (Exception e) {
            DanmakuLogger.INSTANCE.error("copy multi danmakuView error:" + e);
            return null;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setDanmakuViewOffset(float offsetY) {
        if (!(this.mChronosContainer.getTranslationY() == offsetY)) {
            this.mChronosContainer.setTranslationY(offsetY);
            Rect bounds = this.playerContainer.getRenderContainerService().getRenderViewBounds();
            TransformParams transform = new TransformParams();
            transform.setRotation(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            transform.setScaleX(1.0f);
            transform.setScaleY(1.0f);
            transform.setTranslationX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            transform.setTranslationY(-offsetY);
            this.mDanmakuContainerTranslationY = -offsetY;
            this.mRemoteHandler.onVideoSizeChanged(bounds, transform);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public ILocalHandler getLocalHandler() {
        return this.mLocalHandler;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public IRemoteHandler getRemoteHandler() {
        return this.mRemoteHandler;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public AdDanmakuDelegate getAdDanmakuDelegate() {
        return this.mAdDanmakuDelegate;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public CommandsPanel getDanmakuCommandPanelList() {
        return this.mDanmakuCommandPanels;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public EnhancedChronosView getChronosView() {
        return this.mChronosView;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public boolean hasPackageResult() {
        return this.mPackageResult != null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void loadViewProgress(FragmentParam fragmentParam, long fragmentOffset, boolean simplify, Map<String, String> map) {
        Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(extra, "extra");
        if (!this.mChronosEnable) {
            DanmakuLogger.INSTANCE.error("try request viewProgress but chronos is disable");
            return;
        }
        Video.PlayableParams playableParam = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        Video.DisplayParams displayParam = playableParam != null ? playableParam.getDisplayParams() : null;
        if (playableParam == null || displayParam == null) {
            return;
        }
        String from = playableParam.getFrom();
        boolean z = false;
        if (from != null && from.equals("live")) {
            z = true;
        }
        if (z) {
            return;
        }
        this.mApiResolver.resolve(displayParam.getAvid(), displayParam.getCid(), playableParam.getBizType(), playableParam.getDanmakuResolveParams(), fragmentParam, fragmentOffset, extra, simplify);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void loadCommandPanel() {
        Video.DisplayParams displayParam;
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        if (currentPlayableParams == null || (displayParam = currentPlayableParams.getDisplayParams()) == null) {
            return;
        }
        if (displayParam.getMid() > 0) {
            if (this.mWaitRequestCommands) {
                this.mApiResolver.resolveCommandPanels(displayParam.getAvid(), displayParam.getCid(), displayParam.getMid());
                this.mWaitRequestCommands = false;
                return;
            }
            return;
        }
        this.mWaitRequestCommands = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        if (r4 != false) goto L30;
     */
    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadThumbnailIfNeed() {
        ThumbnailLoader thumbnailLoader;
        ChronosThumbnailInfo thumbnailInfo;
        if (!this.mThumbnailLoaderEnable) {
            BLog.i(TAG, "loadThumbnailIfNeed, not enable");
            return;
        }
        Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        if (playableParams == null) {
            return;
        }
        String id = playableParams.id();
        if (TextUtils.equals(id, this.mCurrentThumbId)) {
            ThumbnailLoader thumbnailLoader2 = this.mCurrentThumbLoader;
            boolean z = false;
            if (!(thumbnailLoader2 != null && thumbnailLoader2.getMState() == 0)) {
                ThumbnailLoader thumbnailLoader3 = this.mCurrentThumbLoader;
                if (!(thumbnailLoader3 != null && thumbnailLoader3.getMState() == 2)) {
                    ThumbnailLoader thumbnailLoader4 = this.mCurrentThumbLoader;
                    if (thumbnailLoader4 != null && thumbnailLoader4.getMState() == 3) {
                        z = true;
                    }
                }
            }
            ThumbnailLoader thumbnailLoader5 = this.mCurrentThumbLoader;
            notifyWatchPointsLoaded((thumbnailLoader5 == null || (thumbnailInfo = thumbnailLoader5.getThumbnailInfo()) == null) ? null : thumbnailInfo.getWatchPoints());
            return;
        }
        if (hasPackageResult()) {
            this.mCurrentThumbId = id;
            ThumbnailLoader thumbnailLoader6 = this.mCurrentThumbLoader;
            if (thumbnailLoader6 != null) {
                thumbnailLoader6.cancel();
            }
            this.mCurrentThumbLoader = new ThumbnailLoader(new WeakReference(this), playableParams);
            ThumbnailLoader thumbnailLoader7 = this.mCurrentThumbLoader;
            if (thumbnailLoader7 != null) {
                thumbnailLoader7.load();
            }
            ThumbnailConfig it = this.mThumbnailConfig;
            if (it == null || (thumbnailLoader = this.mCurrentThumbLoader) == null) {
                return;
            }
            thumbnailLoader.setConfig(it);
            return;
        }
        this.mPendingLoadThumbnailInfo = true;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void loadThumbnailIfNeed2() {
        ThumbnailLoader2 thumbnailLoader2;
        if (!this.mThumbnailLoader2Enable) {
            BLog.i(TAG, "loadThumbnailIfNeed2, not enable");
            return;
        }
        Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        if (playableParams == null) {
            return;
        }
        long cid = playableParams.getDisplayParams().getCid();
        ThumbnailLoader2 currentLoader2 = this.mCurrentThumbLoader2;
        if (!getHitChaptersDD() && currentLoader2 != null) {
            if (!currentLoader2.canUpdateThumbnail(cid)) {
                ChronosThumbnailInfo thumbnailInfo = currentLoader2.getThumbnailInfo();
                notifyWatchPointsLoaded(thumbnailInfo != null ? thumbnailInfo.getWatchPoints() : null);
            }
        } else if (hasPackageResult()) {
            FragmentActivity activity = ContextUtilKt.findFragmentActivityOrNull(this.playerContainer.getContext());
            if (activity != null) {
                ThumbnailLoader2 loader2 = new ThumbnailLoader2(activity);
                loader2.updateThumbnailInfo(cid, getViewProgressDetail());
                this.mCurrentThumbLoader2 = loader2;
                ThumbnailConfig it = this.mThumbnailConfig;
                if (it != null && (thumbnailLoader2 = this.mCurrentThumbLoader2) != null) {
                    thumbnailLoader2.setConfig(it);
                }
                ChronosThumbnailInfo thumbnailInfo2 = loader2.getThumbnailInfo();
                notifyWatchPointsLoaded(thumbnailInfo2 != null ? thumbnailInfo2.getWatchPoints() : null);
            }
        } else {
            this.mPendingLoadThumbnailInfo2 = true;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void reportDanmaku(String danmakuId, String reason, boolean shieldUser, String shieldUserId, String oid, boolean needReportAndGetBlockData, boolean blockUser, GeneralResponse<String> generalResponse, String dmContent) {
        Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        this.mChronosLocalServiceImpl.reportDanmaku(danmakuId, reason, shieldUser, shieldUserId, oid, needReportAndGetBlockData, blockUser, generalResponse, dmContent);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setChronosEnable(boolean enable) {
        if (ChronosConfigManager.INSTANCE.isChronosAvailable()) {
            this.mChronosEnable = enable;
            DanmakuLogger.INSTANCE.logService("set chronos enable: " + enable);
        } else {
            DanmakuLogger.INSTANCE.logService("chronos is disable, maybe x86 device");
        }
        if (!this.mChronosEnable) {
            clearChronosPackage();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public ThumbnailLoader getThumbnailFetcher() {
        return this.mCurrentThumbLoader;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public ThumbnailLoader2 getThumbnailFetcher2() {
        return this.mCurrentThumbLoader2;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public boolean hasThumbnails() {
        if (this.mThumbnailLoaderEnable) {
            ThumbnailLoader thumbnailLoader = this.mCurrentThumbLoader;
            if ((thumbnailLoader != null ? thumbnailLoader.getThumbnailInfo() : null) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public boolean hasThumbnails2() {
        if (this.mThumbnailLoader2Enable) {
            ThumbnailLoader2 thumbnailLoader2 = this.mCurrentThumbLoader2;
            if ((thumbnailLoader2 != null ? thumbnailLoader2.getThumbnailInfo() : null) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setThumbnailEnable(boolean enable) {
        this.mThumbnailLoaderEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setThumbnail2Enable(boolean enable) {
        this.mThumbnailLoader2Enable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void onWorkInfoChange(String workId, String videoId) {
        Intrinsics.checkNotNullParameter(workId, "workId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.mRemoteHandler.updateCurrentWorkChanged(workId, videoId);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void clearInteractContainer() {
        if (!this.mStarted && this.mSaveState != null) {
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ChronosInteractContainer.this.restore();
                }
            });
        } else {
            IInteractLayerService $this$clearInteractContainer_u24lambda_u241 = this.playerContainer.getInteractLayerService();
            if ($this$clearInteractContainer_u24lambda_u241.getMainSubtitle() != null || $this$clearInteractContainer_u24lambda_u241.getViceSubtitle() != null) {
                $this$clearInteractContainer_u24lambda_u241.loadSubtitle(null, null);
            }
            $this$clearInteractContainer_u24lambda_u241.getDanmakuParams().clear();
        }
        this.mViewProgressDetail = null;
        this.mSegmentSwitchValue = false;
        this.mPackageResult = null;
        this.mCurrentThumbId = "";
        ThumbnailLoader2 thumbnailLoader2 = this.mCurrentThumbLoader2;
        if (thumbnailLoader2 != null) {
            thumbnailLoader2.reset();
        }
        this.mCurrentThumbLoader2 = null;
        this.mLiveChronosPackage = null;
        this.mSaveState = null;
        ThumbnailLoader thumbnailLoader = this.mCurrentThumbLoader;
        if (thumbnailLoader != null) {
            thumbnailLoader.release();
        }
        if (this.mDanmakuCommandPanels != null) {
            this.mDanmakuCommandPanels = null;
            dispatchDanmakuCommandPanelsChanged(null);
        }
        this.mWaitRequestCommands = true;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void addDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mDanmakuCommandPanelsObserverList.contains(observer)) {
            this.mDanmakuCommandPanelsObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void removeDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuCommandPanelsObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void addDanmakuInteractionObserver(DanmakuInteractionObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuInteractionObserver = observer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void removeDanmakuInteractionObserver() {
        this.mDanmakuInteractionObserver = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setSegmentSwitchValue(boolean value) {
        this.mSegmentSwitchValue = value;
        Collection $this$toTypedArray$iv = this.mSegmentSwitchObservers;
        Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new Observer[0]);
        for (Object element$iv : $this$forEach$iv) {
            Observer it = (Observer) element$iv;
            it.onChanged(Boolean.valueOf(value));
        }
        this.mRemoteHandler.onSegmentSettingChanged(value);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public boolean getSegmentSwitchValue() {
        return this.mSegmentSwitchValue;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void addSegmentSwitchObserver(Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mSegmentSwitchObservers.contains(observer)) {
            this.mSegmentSwitchObservers.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void removeSegmentSwitchObserver(Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mSegmentSwitchObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void addWatchPointsLoadListener(IWatchPointsLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.mWatchPointsLoadListenerList.contains(listener)) {
            this.mWatchPointsLoadListenerList.add(listener);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void removeWatchPointsLoadListener(IWatchPointsLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mWatchPointsLoadListenerList.remove(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setForcedChapterGuide(boolean value) {
        if (this.mForcedChapterGuide != value) {
            this.mRemoteHandler.onForcedChapterGuide(value);
        }
        this.mForcedChapterGuide = value;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setEyesProtectionMode(boolean mode) {
        if (this.mEyesProtectionMode != mode) {
            this.mRemoteHandler.onEyesProtectionModeChanged(mode);
        }
        this.mEyesProtectionMode = mode;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void onAttachByShared(PlayerSharingBundle bundle) {
        this.mStarted = false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public ViewProgressDetail getViewProgressDetail() {
        return this.mViewProgressDetail;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void bindChronosContainer(final FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        container.addView(this.mChronosContainer);
        IRenderLayer.Type $this$bindChronosContainer_u24lambda_u240 = IRenderContainerService.CC.addRenderLayer$default(this.playerContainer.getRenderContainerService(), new IRenderLayer() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$bindChronosContainer$1
            @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
            public View view() {
                return container;
            }

            @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
            public int align() {
                return 2;
            }

            @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
            public IRenderLayer.Type type() {
                return IRenderLayer.Type.SurfaceView;
            }

            @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
            public boolean interruptWhenTypeNotCompatible() {
                return false;
            }

            @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
            public void onViewPortUpdate(Rect viewPort, int panelWidth, int panelHeight) {
                IRemoteHandler iRemoteHandler;
                ILocalHandler iLocalHandler;
                Intrinsics.checkNotNullParameter(viewPort, "viewPort");
                iRemoteHandler = this.mRemoteHandler;
                iRemoteHandler.onViewPortUpdate(viewPort);
                iLocalHandler = this.mLocalHandler;
                iLocalHandler.onViewPortUpdate(viewPort);
            }
        }, 0, 2, null);
        this.mChronosConfig.setLayerSupportSurfaceView($this$bindChronosContainer_u24lambda_u240 == IRenderLayer.Type.SurfaceView);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public ViewGroup getChronosContainer() {
        return this.mChronosContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void init() {
        if (this.mStarted) {
            DanmakuLogger.INSTANCE.logChronos("chronos view is started");
            return;
        }
        initChronos();
        setChronosNecessaryInfo();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void restore() {
        Chronos chronos;
        initChronos();
        setChronosNecessaryInfo();
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        String str = null;
        Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
        if (this.mChronosView != null && this.mPackageResult != null && displayParams != null) {
            PackageResult packageResult = this.mPackageResult;
            Intrinsics.checkNotNull(packageResult);
            ChronosPackage chronosPackage = packageResult.getChronosPackage();
            PackageResult packageResult2 = this.mPackageResult;
            Intrinsics.checkNotNull(packageResult2);
            ViewProgressDetail viewProgressDetail = packageResult2.getViewProgressDetail();
            if (viewProgressDetail != null && (chronos = viewProgressDetail.getChronos()) != null) {
                str = chronos.getMd5();
            }
            runChronosPackage(chronosPackage, str, displayParams.getAvid(), displayParams.getCid());
        }
    }

    private final void setChronosNecessaryInfo() {
        DanmakuParams danmakuParams = this.playerContainer.getInteractLayerService().getDanmakuParams();
        this.mRemoteHandler.updateDanmakuParam(danmakuParams, true);
        setSceneAndBizParams(this.mChronosConfig.getChronosScene(), this.mChronosConfig.getChronosBiz());
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void releaseChronos(boolean saveState) {
        ChronosSaveState chronosSaveState;
        DanmakuLogger.INSTANCE.logChronos("release chronos");
        if (this.mChronosView == null) {
            return;
        }
        if (saveState) {
            Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
            Video.DanmakuResolveParams danmakuParams = currentPlayableParams != null ? currentPlayableParams.getDanmakuResolveParams() : null;
            if (danmakuParams != null) {
                chronosSaveState = new ChronosSaveState(this.mRemoteHandler.onSaveState(), danmakuParams.getAvid(), danmakuParams.getCid());
            } else {
                chronosSaveState = null;
            }
        } else {
            chronosSaveState = null;
        }
        this.mSaveState = chronosSaveState;
        EnhancedChronosViewKt.removeView(this.mChronosContainer, this.mChronosView);
        EnhancedChronosView enhancedChronosView = this.mChronosView;
        if (enhancedChronosView != null) {
            enhancedChronosView.release();
        }
        this.mRemoteHandler.toBackground();
        this.mChronosView = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void onStart() {
        if (!this.mChronosEnable) {
            DanmakuLogger.INSTANCE.logService("chronos not available, maybe device x86");
            return;
        }
        DanmakuLogger.INSTANCE.logService("chronos service start");
        ILocalHandler.CC.onStart$default(this.mLocalHandler, false, 1, null);
        IRemoteHandler.CC.onStart$default(this.mRemoteHandler, false, 1, null);
        this.mApiResolver.setResolveCallback(this.mApiResolveCallback);
        this.mAdDanmakuDelegate.setExposureRequestHandler(new Function3() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit onStart$lambda$0;
                onStart$lambda$0 = ChronosInteractContainer.onStart$lambda$0(ChronosInteractContainer.this, (List) obj, ((Long) obj2).longValue(), ((Long) obj3).longValue());
                return onStart$lambda$0;
            }
        });
        this.playerContainer.getRenderContainerService().addRenderContainerChangedObserver(this.mRenderContainerMatrixChangedObserver);
        this.playerContainer.getActivityStateService().registerWindowInset(this.mWindowInsetObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$0(ChronosInteractContainer this$0, List danmaku, long avid, long cid) {
        Intrinsics.checkNotNullParameter(danmaku, "danmaku");
        this$0.mRemoteHandler.adDanmakuExposureRequest(danmaku, avid, cid);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void onStop() {
        this.mLocalHandler.onStop();
        this.mRemoteHandler.onStop();
        this.playerContainer.getRenderContainerService().removeRenderContainerChangedObserver(this.mRenderContainerMatrixChangedObserver);
        this.playerContainer.getActivityStateService().unregisterWindowInset(this.mWindowInsetObserver);
        this.mApiResolver.release();
        this.mAdDanmakuDelegate.release();
        ThumbnailLoader thumbnailLoader = this.mCurrentThumbLoader;
        if (thumbnailLoader != null) {
            thumbnailLoader.release();
        }
        ThumbnailLoader2 thumbnailLoader2 = this.mCurrentThumbLoader2;
        if (thumbnailLoader2 != null) {
            thumbnailLoader2.reset();
        }
        this.mCurrentThumbLoader2 = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public PlayerContainer getPlayerContainer() {
        return this.playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void setSceneAndBizParams(ChronosScene scene, ChronosBiz biz) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        Intrinsics.checkNotNullParameter(biz, "biz");
        this.mChronosConfig.setChronosScene(scene);
        this.mChronosConfig.setChronosBiz(biz);
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(this.playerContainer).getCurrentPlayableParams();
        Video.ReportCommonParams reportParams = currentPlayableParams != null ? currentPlayableParams.getReportCommonParams() : null;
        SceneBizChange.Request req = new SceneBizChange.Request();
        req.setBiz(Integer.valueOf(biz.getValue()));
        req.setScene(Integer.valueOf(scene.getValue()));
        req.setSpmId(reportParams != null ? reportParams.getSpmid() : null);
        req.setFromSpmId(reportParams != null ? reportParams.getFromSpmid() : null);
        req.setTrackId(reportParams != null ? reportParams.getTrackId() : null);
        this.mRemoteHandler.onSceneAndBizChanged(req);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public Pair<ChronosScene, ChronosBiz> getSceneAndBizParams() {
        return new Pair<>(this.mChronosConfig.getChronosScene(), this.mChronosConfig.getChronosBiz());
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void clearChronosPackage() {
        try {
            DanmakuLogger.INSTANCE.logChronos("clear chronos package");
            EnhancedChronosPackageRunner enhancedChronosPackageRunner = this.mChronosView;
            if (enhancedChronosPackageRunner != null) {
                EnhancedChronosPackageRunner.runPackage$default(enhancedChronosPackageRunner, (ChronosPackage) null, (String) null, (Map) null, 6, (Object) null);
            }
        } catch (Exception e) {
            DanmakuLogger.INSTANCE.error("clear chronos package failed because " + e.getMessage());
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public boolean isChronosValid() {
        EnhancedChronosView enhancedChronosView = this.mChronosView;
        return enhancedChronosView != null && enhancedChronosView.isValid();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer
    public void showDanmaku() {
        this.mRemoteHandler.onDanmakuVisibleChanged(true);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer
    public void hideDanmaku() {
        this.mRemoteHandler.onDanmakuVisibleChanged(false);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer
    public void onIJKFrameRendered(FrameRenderedInfo info, boolean isHdr) {
        Intrinsics.checkNotNullParameter(info, "info");
        EnhancedChronosView enhancedChronosView = this.mChronosView;
        if (enhancedChronosView != null) {
            enhancedChronosView.updateIJKFrameInfo(info.getTextureId(), info.getTextureWidth(), info.getTextureHeight(), info.getTimeUs(), isHdr);
        }
    }

    /* compiled from: ChronosInteractContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}