package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import bolts.Continuation;
import bolts.Task;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReply;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bilibili.common.chronoscommon.EnhancedChronosPackageRunner;
import com.bilibili.common.chronoscommon.message.DispatcherContext;
import com.bilibili.common.chronoscommon.plugins.HttpPlugin;
import com.bilibili.common.chronoscommon.plugins.UnzipPlugin;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.videodownload.LocalDMResource;
import com.bilibili.moduleservice.videodownload.VideoDownloadService;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.RpcException;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetCurrentWorkSource;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDanmakuFilter;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDeviceInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetDmView;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetFeatureLists;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetLocalDanmaku;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetSceneAndBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetVideoSize;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetViewProgress;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NativeLogger;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.URLRequest;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UnzipFile;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateCurrentWork;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateDanmakuSwitch;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.UpdateFullscreenState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.IMultiDanmakuCallback;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.TransformParams;

/* compiled from: LocalServiceHandler.kt */
@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0002\u0082\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J^\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010F\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010G2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J\u0010\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\u0014H\u0016J\b\u0010J\u001a\u000208H\u0016J\u009e\u0001\u0010K\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010L2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`E2>\u0010M\u001a:\u0012\u0015\u0012\u0013\u0018\u00010N¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(O\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002080<j\u0002`QH\u0016J\u009e\u0001\u0010R\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010S2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`E2>\u0010M\u001a:\u0012\u0015\u0012\u0013\u0018\u00010N¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(O\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002080<j\u0002`QH\u0016J¨\u0001\u0010T\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010W2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`E2>\u0010M\u001a:\u0012\u0015\u0012\u0013\u0018\u00010N¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(O\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002080<j\u0002`QH\u0016J^\u0010X\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010Y2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J\u009e\u0001\u0010Z\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010[2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`E2>\u0010M\u001a:\u0012\u0015\u0012\u0013\u0018\u00010N¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(O\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002080<j\u0002`QH\u0016J^\u0010\\\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010]2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0017J^\u0010^\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010_2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010`\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010a2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010b\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010c2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010d\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010e2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010f\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010g2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J\u009e\u0001\u0010h\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010i2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`E2>\u0010M\u001a:\u0012\u0015\u0012\u0013\u0018\u00010N¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(O\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002080<j\u0002`QH\u0016J^\u0010j\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010k2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010l\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010m2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J^\u0010n\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010o2J\u0010;\u001aF\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012!\u0012\u001f\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0018\u00010A¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080<j\u0002`EH\u0016J\u0010\u0010p\u001a\u0002082\u0006\u0010q\u001a\u000206H\u0016J\u0010\u0010r\u001a\u0002082\u0006\u0010s\u001a\u00020\nH\u0016J\b\u0010t\u001a\u000208H\u0016J\u0010\u0010u\u001a\u0002082\u0006\u0010v\u001a\u00020/H\u0016J\u0010\u0010w\u001a\u0002082\u0006\u0010x\u001a\u00020yH\u0016J\u0016\u0010z\u001a\u0002082\f\u0010{\u001a\b\u0012\u0002\b\u0003\u0018\u00010|H\u0016J\u0018\u0010}\u001a\u0002082\u000e\u0010~\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\"H\u0016J\u0018\u0010\u007f\u001a\u0002082\u000e\u0010~\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\"H\u0016J\u0012\u0010\u0080\u0001\u001a\u0002082\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRH\u0010\u001f\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\"0 j\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\"`#X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0083\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/SampleLocalServiceHandler;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ISampleLocalService;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ISampleLocalHandler;", "chronosService", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;)V", "getChronosService", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "getMPlayerContainer", "()Ltv/danmaku/biliplayerv2/PlayerContainer;", "setMPlayerContainer", "(Ltv/danmaku/biliplayerv2/PlayerContainer;)V", "chronosHttpClient", "Lcom/bilibili/common/chronoscommon/plugins/HttpPlugin$Client;", "multiDanmakuCallBack", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/IMultiDanmakuCallback;", "mRpcInvokeObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;", "getMRpcInvokeObserver", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;", "setMRpcInvokeObserver", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;)V", "mMessageHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageHandler;", "getMMessageHandler", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageHandler;", "setMMessageHandler", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageHandler;)V", "mBusinessMessageHandler", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "Lkotlin/collections/HashMap;", "getMBusinessMessageHandler", "()Ljava/util/HashMap;", "displayDensity", "", "getDisplayDensity", "()F", "setDisplayDensity", "(F)V", "mTransformParams", "Ltv/danmaku/render/core/TransformParams;", "mChronosViewPort", "Landroid/graphics/Rect;", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "mVisibleRect", "mVisibleRectX", "mVisibleRectY", "mMultiDanmaku", "", "nativeLogger", "", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NativeLogger$Request;", "onComplete", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "", "", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerComplete;", "updateVideoSize", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetVideoSize$Request;", "registerRpcInvokeObserver", "observer", "unregisterRpcInvokeObserver", "getCurrentWorkInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Request;", "onError", "", "code", "description", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosHandlerError;", "updateCurrentWork", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateCurrentWork$Request;", "httpUrlRequest", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/URLRequest$Request;", "dispatcherContext", "Lcom/bilibili/common/chronoscommon/message/DispatcherContext;", "updateDanmakuSwitch", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateDanmakuSwitch$Request;", "unzipFile", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UnzipFile$Request;", "updatePlayerFullScreenState", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdateFullscreenState$Request;", "getSceneAndBiz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetSceneAndBiz$Request;", "getDmView", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDmView$Request;", "getDanmakuConfig", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$Request;", "getDanmakuFilter", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuFilter$Request;", "getViewProgress", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetViewProgress$Request;", "getLocalDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetLocalDanmaku$Request;", "getDeviceInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDeviceInfo$Request;", "getFeatureLists", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetFeatureLists$Request;", "getCurrentWorkSource", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetCurrentWorkSource$Request;", "onStart", "multiPlayer", "onBindPlayerContainer", "playerContainer", "onStop", "onViewPortUpdate", "viewPort", "setVisibleRect", "rect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "initChronosView", "chronosView", "Lcom/bilibili/common/chronoscommon/EnhancedChronosPackageRunner;", "registerChronosMessageHandler", "handler", "unregisterChronosMessageHandler", "setMultiDanmakuPlayer", "callBack", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class SampleLocalServiceHandler implements ISampleLocalService, ISampleLocalHandler {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "LocalServiceHandler";
    private final HttpPlugin.Client chronosHttpClient;
    private final IChronosLocalService chronosService;
    private float displayDensity;
    private final HashMap<Class<?>, ChronosRequestHandler<?, ?>> mBusinessMessageHandler;
    private Rect mChronosViewPort;
    private ExecutorService mExecutorService;
    private ChronosMessageHandler mMessageHandler;
    private boolean mMultiDanmaku;
    protected PlayerContainer mPlayerContainer;
    private RpcInvokeObserver mRpcInvokeObserver;
    private TransformParams mTransformParams;
    private Rect mVisibleRect;
    private float mVisibleRectX;
    private float mVisibleRectY;
    private IMultiDanmakuCallback multiDanmakuCallBack;

    public SampleLocalServiceHandler(IChronosLocalService chronosService) {
        Intrinsics.checkNotNullParameter(chronosService, "chronosService");
        this.chronosService = chronosService;
        this.chronosHttpClient = new HttpPlugin.Client();
        this.mBusinessMessageHandler = new HashMap<>();
        this.displayDensity = 1.0f;
    }

    public final IChronosLocalService getChronosService() {
        return this.chronosService;
    }

    /* compiled from: LocalServiceHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/SampleLocalServiceHandler$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PlayerContainer getMPlayerContainer() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null) {
            return playerContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        return null;
    }

    protected final void setMPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "<set-?>");
        this.mPlayerContainer = playerContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RpcInvokeObserver getMRpcInvokeObserver() {
        return this.mRpcInvokeObserver;
    }

    protected final void setMRpcInvokeObserver(RpcInvokeObserver rpcInvokeObserver) {
        this.mRpcInvokeObserver = rpcInvokeObserver;
    }

    protected final ChronosMessageHandler getMMessageHandler() {
        return this.mMessageHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMMessageHandler(ChronosMessageHandler chronosMessageHandler) {
        this.mMessageHandler = chronosMessageHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HashMap<Class<?>, ChronosRequestHandler<?, ?>> getMBusinessMessageHandler() {
        return this.mBusinessMessageHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getDisplayDensity() {
        return this.displayDensity;
    }

    protected final void setDisplayDensity(float f) {
        this.displayDensity = f;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void nativeLogger(NativeLogger.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Integer level = req != null ? req.getLevel() : null;
        if (level != null && level.intValue() == 0) {
            BLog.e("LocalServiceHandler", req.getInfo());
        } else if (level != null && level.intValue() == 1) {
            BLog.w("LocalServiceHandler", req.getInfo());
        } else if (level != null && level.intValue() == 2) {
            BLog.i("LocalServiceHandler", req.getInfo());
        } else if (level != null && level.intValue() == 3) {
            BLog.d("LocalServiceHandler", req.getInfo());
        } else if (level != null && level.intValue() == 4) {
            BLog.v("LocalServiceHandler", req.getInfo());
        }
        function2.invoke((Object) null, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void updateVideoSize(GetVideoSize.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        GetVideoSize.Response transform;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        IMultiDanmakuCallback iMultiDanmakuCallback = this.multiDanmakuCallBack;
        GetVideoSize.Response size = iMultiDanmakuCallback != null ? iMultiDanmakuCallback.getVideoSize() : null;
        if (size != null) {
            function2.invoke(size, (Object) null);
        }
        this.mTransformParams = this.chronosService.getDanmakuTransformParams();
        TransformParams it = this.mTransformParams;
        if (it != null) {
            transform = new GetVideoSize.Response();
            Rect renderBounds = getMPlayerContainer().getRenderContainerService().getRenderViewBounds();
            transform.setOrigin(new float[]{renderBounds.left / this.displayDensity, renderBounds.top / this.displayDensity});
            transform.setRotation(Float.valueOf((float) Math.toRadians(it.getRotation())));
            transform.setScale(new float[]{it.getScaleX(), it.getScaleY()});
            transform.setSize(new int[]{(int) (renderBounds.width() / this.displayDensity), (int) (renderBounds.height() / this.displayDensity)});
            transform.setTranslation(new float[]{it.getTranslationX() / this.displayDensity, it.getTranslationY() / this.displayDensity});
        } else {
            transform = null;
        }
        function2.invoke(transform, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void registerRpcInvokeObserver(RpcInvokeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mRpcInvokeObserver = observer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void unregisterRpcInvokeObserver() {
        this.mRpcInvokeObserver = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getCurrentWorkInfo(GetWorkInfo.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Long duration;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        IMultiDanmakuCallback iMultiDanmakuCallback = this.multiDanmakuCallBack;
        GetWorkInfo.Response result = iMultiDanmakuCallback != null ? iMultiDanmakuCallback.getWorkInfo() : null;
        if (result == null || ((duration = result.getDuration()) != null && duration.longValue() == 0)) {
            function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), "workInfo is null or illegal duration");
        } else {
            function2.invoke(result, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void updateCurrentWork(UpdateCurrentWork.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        IMultiDanmakuCallback iMultiDanmakuCallback = this.multiDanmakuCallBack;
        GetWorkInfo.Response workInfo = iMultiDanmakuCallback != null ? iMultiDanmakuCallback.getWorkInfo() : null;
        UpdateCurrentWork.Response result = new UpdateCurrentWork.Response();
        result.setWorkId(workInfo != null ? workInfo.getWorkId() : null);
        result.setVideoId(workInfo != null ? workInfo.getVideoId() : null);
        if (workInfo == null) {
            function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), "workInfo is null");
        } else {
            function2.invoke(result, (Object) null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void httpUrlRequest(final URLRequest.Request req, DispatcherContext dispatcherContext, final Function2<Object, ? super Map<String, byte[]>, Unit> function2, final Function2<? super Integer, ? super String, Unit> function22) {
        String url;
        String url2;
        Boolean ungzip;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        HttpPlugin.Request.Builder withHeaders = new HttpPlugin.Request.Builder().withHeaders(req != null ? req.getHeader() : null);
        String packageSandBoxDirectory = this.chronosService.getPackageSandBoxDirectory();
        String str = "";
        if (packageSandBoxDirectory == null) {
            packageSandBoxDirectory = "";
        }
        HttpPlugin.Request.Builder withFormat = withHeaders.withDestPath(packageSandBoxDirectory).withParams(req != null ? req.getParameters() : null).withFiles(req != null ? req.getFiles() : null).withFormat((req == null || (r2 = req.getFormat()) == null) ? "raw" : "raw");
        boolean z = false;
        HttpPlugin.Request.Builder withUngzip = withFormat.withUngzip((req == null || (ungzip = req.getUngzip()) == null) ? false : ungzip.booleanValue());
        if (req != null) {
            z = Intrinsics.areEqual(req.getScmActionId(), true);
        }
        HttpPlugin.Request.Builder request = withUngzip.withSCMActionId((!z || dispatcherContext == null) ? null : dispatcherContext.getSCMActionId());
        if (StringsKt.equals(HttpPlugin.Request.Method.POST.getValue(), req != null ? req.getMethod() : null, true)) {
            if (req != null && (url2 = req.getUrl()) != null) {
                str = url2;
            }
            request.post(str);
        } else {
            if (req != null && (url = req.getUrl()) != null) {
                str = url;
            }
            request.get(str);
        }
        this.chronosHttpClient.enqueue(request.build(), new HttpPlugin.Callback() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler$httpUrlRequest$1
            public void onSuccess(HttpPlugin.Response response) {
                String str2;
                byte[] bytes;
                Intrinsics.checkNotNullParameter(response, "response");
                URLRequest.Response urlResult = new URLRequest.Response();
                urlResult.setCode(response.getCode());
                urlResult.setHeader(response.getHeaders());
                HttpPlugin.Response.Body body = response.getBody();
                HashMap hashMap = null;
                urlResult.setContent(body != null ? body.getContent() : null);
                URLRequest.Request request2 = URLRequest.Request.this;
                if (request2 == null || (str2 = request2.getFormat()) == null) {
                    str2 = HttpPlugin.Request.Companion != null ? "raw" : null;
                }
                urlResult.setFormat(str2);
                HttpPlugin.Response.Body body2 = response.getBody();
                if (body2 != null && (bytes = body2.getBinary()) != null) {
                    HashMap map = new HashMap();
                    map.put("response", bytes);
                    hashMap = map;
                }
                HashMap extras = hashMap;
                function2.invoke(urlResult, extras);
            }

            public void onError(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                Function2<Integer, String, Unit> function23 = function22;
                String message = throwable.getMessage();
                if (message == null) {
                    message = String.valueOf(throwable.getCause());
                }
                function23.invoke(-1, message);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void updateDanmakuSwitch(UpdateDanmakuSwitch.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Boolean enabled;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req != null && (enabled = req.getEnabled()) != null) {
            boolean it = enabled.booleanValue();
            if (it) {
                getMPlayerContainer().getInteractLayerService().showDanmaku(false);
            } else {
                getMPlayerContainer().getInteractLayerService().hideDanmaku(false);
            }
        }
        UpdateDanmakuSwitch.Response response = new UpdateDanmakuSwitch.Response();
        response.setEnabled(Boolean.valueOf(getMPlayerContainer().getInteractLayerService().isDanmakuVisible()));
        function2.invoke(response, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void unzipFile(UnzipFile.Request req, final Function2<Object, ? super Map<String, byte[]>, Unit> function2, final Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        UnzipPlugin.Desc desc = new UnzipPlugin.Desc.Builder().withSrcDir(this.chronosService.getPackageSandBoxDirectory()).withSrcPath(req != null ? req.getZipFile() : null).withDestPath(req != null ? req.getExtractPath() : null).withSecurity(req != null ? req.getSecurity() : null).build();
        UnzipPlugin.INSTANCE.unzip(desc, new Function1() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit unzipFile$lambda$0;
                unzipFile$lambda$0 = SampleLocalServiceHandler.unzipFile$lambda$0(function2, (String) obj);
                return unzipFile$lambda$0;
            }
        }, new Function1() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit unzipFile$lambda$1;
                unzipFile$lambda$1 = SampleLocalServiceHandler.unzipFile$lambda$1(function22, (Throwable) obj);
                return unzipFile$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unzipFile$lambda$0(Function2 $onComplete, String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        UnzipFile.Response unzipResult = new UnzipFile.Response();
        unzipResult.setSuccess(true);
        unzipResult.setPath(path);
        $onComplete.invoke(unzipResult, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unzipFile$lambda$1(Function2 $onError, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Integer valueOf = Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR);
        String message = throwable.getMessage();
        if (message == null) {
            message = String.valueOf(throwable.getCause());
        }
        $onError.invoke(valueOf, message);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void updatePlayerFullScreenState(UpdateFullscreenState.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        if (req == null) {
            return;
        }
        RpcInvokeObserver it = this.mRpcInvokeObserver;
        if (it != null) {
            UpdateFullscreenState.Response result = it.updateFullscreenState(req.getFullscreen(), req.getLock());
            function2.invoke(result, (Object) null);
            return;
        }
        SampleLocalServiceHandler $this$updatePlayerFullScreenState_u24lambda_u241 = this;
        UpdateFullscreenState.Response response = new UpdateFullscreenState.Response();
        boolean isFullscreen = $this$updatePlayerFullScreenState_u24lambda_u241.getMPlayerContainer().getControlContainerService().getScreenModeType() == ScreenModeType.LANDSCAPE_FULLSCREEN;
        response.setFullscreen(Boolean.valueOf(isFullscreen));
        response.setLock(req.getLock());
        function2.invoke(response, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getSceneAndBiz(GetSceneAndBiz.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Pair pair = this.chronosService.getSceneAndBiz();
        GetSceneAndBiz.Response result = new GetSceneAndBiz.Response();
        result.setScene(Integer.valueOf(((ChronosScene) pair.getFirst()).getValue()));
        result.setBiz(Integer.valueOf(((ChronosBiz) pair.getSecond()).getValue()));
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
        Video.ReportCommonParams reportParams = currentPlayableParams != null ? currentPlayableParams.getReportCommonParams() : null;
        result.setSpmId(reportParams != null ? reportParams.getSpmid() : null);
        result.setFromSpmId(reportParams != null ? reportParams.getFromSpmid() : null);
        result.setTrackId(reportParams != null ? reportParams.getTrackId() : null);
        BLog.d("LocalServiceHandler", "getSceneAndBiz: scene=" + result.getScene() + ", biz=" + result.getBiz());
        function2.invoke(result, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getDmView(GetDmView.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        DanmakuParams danmakuParams = getMPlayerContainer().getInteractLayerService().getDanmakuParams();
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
        HashMap extras = null;
        Video.DanmakuResolveParams dmParams = currentPlayableParams != null ? currentPlayableParams.getDanmakuResolveParams() : null;
        GetDmView.Response result = new GetDmView.Response();
        result.setWorkId(dmParams != null ? String.valueOf(dmParams.getAvid()) : null);
        result.setVideoId(dmParams != null ? String.valueOf(dmParams.getCid()) : null);
        DmViewReply reply = danmakuParams.getDmViewReply();
        if (reply != null) {
            HashMap map = new HashMap();
            map.put("reply", reply.toByteArray());
            extras = map;
        }
        BLog.i("dmview params error", "workid=" + result.getWorkId() + ", videoid=" + result.getVideoId());
        BLog.i("LocalServiceHandler", "ChronosMonitor-1-6-3 GetDmView: " + result);
        function2.invoke(result, extras);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r1.hasSubtitleHeight() == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final float getDanmakuConfig$calculateSubtitleBottomMargin(SampleLocalServiceHandler this$0) {
        boolean z;
        int bottomBlock;
        int bottomBlock2;
        if (this$0.mMultiDanmaku) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        IInteractLayerService danmakuService = this$0.getMPlayerContainer().getInteractLayerService();
        if (danmakuService.isCustomSubtitleMargin()) {
            bottomBlock2 = danmakuService.getSubtitleBottomMargin();
        } else {
            SubtitleItem mainSubtitle = danmakuService.getMainSubtitle();
            if (mainSubtitle != null) {
                z = true;
            }
            z = false;
            if (z) {
                bottomBlock = danmakuService.getSubtitleBottomMargin();
            } else if (this$0.getMPlayerContainer().getControlContainerService().isShowing()) {
                bottomBlock = this$0.getMPlayerContainer().getControlContainerService().getBottomSubtitleBlock();
            } else {
                bottomBlock = 0;
            }
            int panelContainerHeight = this$0.getMPlayerContainer().getInteractLayerService().getChronosInteractContainer().getChronosContainer().getHeight();
            Rect rect = this$0.mChronosViewPort;
            int chronosViewPortHeight = rect != null ? rect.height() : 0;
            Rect rect2 = this$0.mChronosViewPort;
            int top = rect2 != null ? rect2.top : 0;
            int viewPortTranslate = RangesKt.coerceAtLeast((panelContainerHeight - chronosViewPortHeight) - top, 0);
            bottomBlock2 = viewPortTranslate + bottomBlock;
        }
        return bottomBlock2 / this$0.displayDensity;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getDanmakuConfig(GetDanmakuConfig.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Rect renderBounds;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        PlayerContainer $this$getDanmakuConfig_u24lambda_u240 = getMPlayerContainer();
        int containerWidth = getMPlayerContainer().getInteractLayerService().getChronosInteractContainer().getChronosContainer().getWidth();
        int containerHeight = getMPlayerContainer().getInteractLayerService().getChronosInteractContainer().getChronosContainer().getHeight();
        Rect it = this.mVisibleRect;
        if (it != null) {
            renderBounds = new Rect(0, 0, MathKt.roundToInt(it.right * this.displayDensity), MathKt.roundToInt(it.bottom * this.displayDensity));
        } else {
            renderBounds = new Rect(0, 0, containerWidth, containerHeight);
        }
        GetDanmakuConfig.Response.Companion companion = GetDanmakuConfig.Response.Companion;
        Context context = $this$getDanmakuConfig_u24lambda_u240.getContext();
        DanmakuParams danmakuParams = $this$getDanmakuConfig_u24lambda_u240.getInteractLayerService().getDanmakuParams();
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector($this$getDanmakuConfig_u24lambda_u240).getCurrentPlayableParams();
        GetDanmakuConfig.Response result = companion.create(context, danmakuParams, currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null, $this$getDanmakuConfig_u24lambda_u240.getInteractLayerService().getMainSubtitle(), $this$getDanmakuConfig_u24lambda_u240.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_MASK_SWITCH, true), $this$getDanmakuConfig_u24lambda_u240.getPlayerSettingService().getCloudConfig(), renderBounds, this.displayDensity, getDanmakuConfig$calculateSubtitleBottomMargin(this), this.mVisibleRectX, this.mVisibleRectY, $this$getDanmakuConfig_u24lambda_u240.getInteractLayerService().getInitViceSubtitle(), $this$getDanmakuConfig_u24lambda_u240.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_DRAG, false), Integer.valueOf(getMPlayerContainer().getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_LARGE, false) ? 2 : 1));
        BLog.i("LocalServiceHandler", "ChronosMonitor-0-C-0 GetDanmakuConfig: " + result);
        function2.invoke(result, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getDanmakuFilter(GetDanmakuFilter.Request req, final Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        DanmakuParams danmakuParams = getMPlayerContainer().getInteractLayerService().getDanmakuParams();
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
        Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
        BLog.d("danmaku filter sync", "block scroll from getDanmakuFilter=" + danmakuParams.isDanmakuBlockScroll());
        boolean enableShield = getMPlayerContainer().getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true);
        final GetDanmakuFilter.Response danmakuFilterConfig = GetDanmakuFilter.Response.Companion.create(danmakuParams, displayParams);
        final Context context = getMPlayerContainer().getContext();
        if (enableShield) {
            Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Triple danmakuFilter$lambda$0;
                    danmakuFilter$lambda$0 = SampleLocalServiceHandler.getDanmakuFilter$lambda$0(SampleLocalServiceHandler.this, context);
                    return danmakuFilter$lambda$0;
                }
            }).continueWith(new Continuation<Triple<? extends List<String>, ? extends List<String>, ? extends List<String>>, Unit>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler$getDanmakuFilter$2
                public /* bridge */ /* synthetic */ Object then(Task p0) {
                    m2255then((Task<Triple<List<String>, List<String>, List<String>>>) p0);
                    return Unit.INSTANCE;
                }

                /* renamed from: then  reason: collision with other method in class */
                public void m2255then(Task<Triple<List<String>, List<String>, List<String>>> task) {
                    Triple result;
                    Intrinsics.checkNotNullParameter(task, "task");
                    if (task.isFaulted() || task.isCancelled() || (result = (Triple) task.getResult()) == null) {
                        return;
                    }
                    GetDanmakuFilter.Response response = GetDanmakuFilter.Response.this;
                    Collection $this$toTypedArray$iv = (Collection) result.getFirst();
                    response.setUserHashBlockList((String[]) $this$toTypedArray$iv.toArray(new String[0]));
                    GetDanmakuFilter.Response response2 = GetDanmakuFilter.Response.this;
                    Collection $this$toTypedArray$iv2 = (Collection) result.getSecond();
                    response2.setRegexBlockList((String[]) $this$toTypedArray$iv2.toArray(new String[0]));
                    GetDanmakuFilter.Response response3 = GetDanmakuFilter.Response.this;
                    Collection $this$toTypedArray$iv3 = (Collection) result.getThird();
                    response3.setContentBlockList((String[]) $this$toTypedArray$iv3.toArray(new String[0]));
                    BLog.i("LocalServiceHandler", "ChronosMonitor-0-C-0 GetDanmakuFilter: " + GetDanmakuFilter.Response.this);
                    function2.invoke(GetDanmakuFilter.Response.this, (Object) null);
                }
            }, Task.UI_THREAD_EXECUTOR);
            return;
        }
        danmakuFilterConfig.setUserHashBlockList(new String[0]);
        danmakuFilterConfig.setRegexBlockList(new String[0]);
        danmakuFilterConfig.setContentBlockList(new String[0]);
        BLog.i("LocalServiceHandler", "ChronosMonitor-0-C-0 GetDanmakuFilter: " + danmakuFilterConfig);
        function2.invoke(danmakuFilterConfig, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Triple getDanmakuFilter$lambda$0(SampleLocalServiceHandler this$0, Context $context) {
        return this$0.chronosService.getDanmakuFilterContainer().resolveDanamkuFilters($context, null, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getViewProgress(GetViewProgress.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
        Video.DisplayParams displayParams = currentPlayableParams != null ? currentPlayableParams.getDisplayParams() : null;
        GetViewProgress.Response result = new GetViewProgress.Response();
        result.setWorkId(displayParams != null ? String.valueOf(displayParams.getAvid()) : null);
        result.setVideoId(displayParams != null ? String.valueOf(displayParams.getCid()) : null);
        ViewProgressDetail detail = this.chronosService.getViewProgressDetail();
        if (detail != null) {
            HashMap map = new HashMap();
            Object originData = detail.getOriginData();
            ViewProgressReply it = originData instanceof ViewProgressReply ? (ViewProgressReply) originData : null;
            if (it != null) {
                map.put("unitereply", it.toByteArray());
            }
            Object originData2 = detail.getOriginData();
            extras = originData2 instanceof com.bapis.bilibili.app.view.v1.ViewProgressReply ? (com.bapis.bilibili.app.view.v1.ViewProgressReply) originData2 : null;
            if (extras != null) {
                map.put("reply", extras.toByteArray());
            }
            extras = map;
        }
        BLog.i("LocalServiceHandler", "ChronosMonitor-1-1-3 GetViewProgress: " + result);
        function2.invoke(result, extras);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getLocalDanmaku(GetLocalDanmaku.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        String videoId;
        String workId;
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        GetLocalDanmaku.Response result = new GetLocalDanmaku.Response();
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(getMPlayerContainer()).getCurrentPlayableParams();
        Video.DanmakuResolveParams danmakuParams = currentPlayableParams != null ? currentPlayableParams.getDanmakuResolveParams() : null;
        final Long avid = (req == null || (workId = req.getWorkId()) == null) ? null : StringsKt.toLongOrNull(workId);
        final Long cid = (req == null || (videoId = req.getVideoId()) == null) ? null : StringsKt.toLongOrNull(videoId);
        final Ref.IntRef page = new Ref.IntRef();
        final Ref.ObjectRef seasonId = new Ref.ObjectRef();
        final Ref.LongRef epId = new Ref.LongRef();
        if (danmakuParams != null) {
            if (danmakuParams.getSeasonId() > 0) {
                seasonId.element = String.valueOf(danmakuParams.getSeasonId());
                epId.element = danmakuParams.getEpid();
            }
            page.element = danmakuParams.getPage();
        }
        final VideoDownloadService service = (VideoDownloadService) BLRouter.INSTANCE.get(VideoDownloadService.class, "default");
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newFixedThreadPool(1);
        }
        BLog.i("LocalServiceHandler", "getLocalDanmaku avid=" + avid + ", cid=" + cid + ", page=" + page.element + ", epId=" + epId.element + ", seasonId=" + seasonId.element);
        if (this.mExecutorService != null) {
            ExecutorService executorService = this.mExecutorService;
            boolean z = false;
            if (executorService != null && !executorService.isShutdown()) {
                z = true;
            }
            if (z) {
                ExecutorService executorService2 = this.mExecutorService;
                Intrinsics.checkNotNull(executorService2);
                Future offlineDanmakus = executorService2.submit(new Callable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler$$ExternalSyntheticLambda3
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        OfflineDanmakus localDanmaku$lambda$1;
                        localDanmaku$lambda$1 = SampleLocalServiceHandler.getLocalDanmaku$lambda$1(service, this, avid, cid, page, epId, seasonId);
                        return localDanmaku$lambda$1;
                    }
                });
                Intrinsics.checkNotNullExpressionValue(offlineDanmakus, "submit(...)");
                OfflineDanmakus offlineDanmakusResult = (OfflineDanmakus) offlineDanmakus.get();
                result.setWorkId(offlineDanmakusResult.getAvid());
                result.setVideoId(offlineDanmakusResult.getCid());
                result.setFormat(offlineDanmakusResult.getFormat());
                byte[] danmakus = offlineDanmakusResult.getDanmakus();
                BLog.i("LocalServiceHandler", "get local danmakus result, danmakus size: " + (danmakus != null ? Integer.valueOf(danmakus.length) : null));
                if (danmakus != null) {
                    HashMap map = new HashMap();
                    map.put("danmaku", danmakus);
                    BLog.i("LocalServiceHandler", "getLocalDanmaku success, workId=" + result.getWorkId() + ", videoId=" + result.getVideoId() + " format=" + result.getFormat());
                    function2.invoke(result, map);
                    return;
                }
                function22.invoke(Integer.valueOf((int) RpcException.NATIVE_RUNTIME_ERROR), "get local offline danmakus failed");
                return;
            }
        }
        function2.invoke(result, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineDanmakus getLocalDanmaku$lambda$1(VideoDownloadService $service, SampleLocalServiceHandler this$0, Long $avid, Long $cid, Ref.IntRef $page, Ref.LongRef $epId, Ref.ObjectRef $seasonId) {
        LocalDMResource localDMResource;
        OfflineDanmakus offlineDms = new OfflineDanmakus();
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if ($service != null) {
            try {
                try {
                    try {
                        try {
                            try {
                                localDMResource = $service.resolveDanmaku(this$0.getMPlayerContainer().getContext(), $avid, $cid, Integer.valueOf($page.element), Long.valueOf($epId.element), (String) $seasonId.element, "", "");
                            } catch (Exception e) {
                                e = e;
                                BLog.e("LocalServiceHandler", "get local offline danmakus failed, because " + e);
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly(outputStream);
                                return offlineDms;
                            }
                        } catch (Throwable th) {
                            th = th;
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        BLog.e("LocalServiceHandler", "get local offline danmakus failed, because " + e);
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(outputStream);
                        return offlineDms;
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    BLog.e("LocalServiceHandler", "get local offline danmakus failed, because " + e);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                    return offlineDms;
                } catch (Throwable th3) {
                    th = th3;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            localDMResource = null;
        }
        FileInputStream fileInputStream = localDMResource != null ? localDMResource.getFileInputStream() : null;
        if (fileInputStream != null) {
            offlineDms.setAvid(String.valueOf($avid));
            offlineDms.setCid(String.valueOf($cid));
            offlineDms.setFormat(localDMResource.getFormat());
            inputStream = fileInputStream;
            byte[] buffer = new byte[1024];
            while (true) {
                int it = ((FileInputStream) inputStream).read(buffer);
                if (it == -1) {
                    break;
                }
                outputStream.write(buffer, 0, it);
            }
            offlineDms.setDanmakus(outputStream.toByteArray());
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
        return offlineDms;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getDeviceInfo(GetDeviceInfo.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        WindowInset windowInset = getMPlayerContainer().getActivityStateService().getWindowInset();
        GetDeviceInfo.Response result = new GetDeviceInfo.Response();
        GetDeviceInfo.SafeArea safeArea = new GetDeviceInfo.SafeArea();
        safeArea.setTop(Float.valueOf(DpUtils.px2dp(getMPlayerContainer().getContext(), windowInset.getTopPadding())));
        safeArea.setLeft(Float.valueOf(DpUtils.px2dp(getMPlayerContainer().getContext(), windowInset.getLeftPadding())));
        safeArea.setRight(Float.valueOf(DpUtils.px2dp(getMPlayerContainer().getContext(), windowInset.getRightPadding())));
        safeArea.setBottom(Float.valueOf(DpUtils.px2dp(getMPlayerContainer().getContext(), windowInset.getBottomPadding())));
        result.setSafeArea(safeArea);
        function2.invoke(result, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getFeatureLists(GetFeatureLists.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        GetFeatureLists.Response result = new GetFeatureLists.Response();
        result.setChapterGuide(Boolean.valueOf(this.chronosService.needShowChronosProgress()));
        result.setForcedChapterGuide(Boolean.valueOf(this.chronosService.forcedChapterGuide()));
        result.setEyesProtectionMode(Boolean.valueOf(this.chronosService.eyesProtectionMode()));
        function2.invoke(result, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalService
    public void getCurrentWorkSource(GetCurrentWorkSource.Request req, Function2<Object, ? super Map<String, byte[]>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        GetCurrentWorkSource.Response result = new GetCurrentWorkSource.Response();
        result.setVideoUrl(IPlayerCoreService.CC.getCurrentPlayUrl$default(getMPlayerContainer().getPlayerCoreService(), false, 1, null));
        result.setAudioUrl(getMPlayerContainer().getPlayerCoreService().getCurrentPlayUrl(true));
        result.setCurrentQn(Integer.valueOf(getMPlayerContainer().getPlayerCoreService().getCurrentQuality()));
        function2.invoke(result, (Object) null);
    }

    public void onStart(boolean multiPlayer) {
        DisplayMetrics displayMetrics;
        this.mMultiDanmaku = multiPlayer;
        Resources resources = getMPlayerContainer().getContext().getResources();
        this.displayDensity = (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1.0f : displayMetrics.density;
    }

    public void onBindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        setMPlayerContainer(playerContainer);
    }

    public void onStop() {
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdown();
        }
        this.chronosHttpClient.clear();
        this.multiDanmakuCallBack = null;
        this.mVisibleRect = null;
        this.chronosService.getDanmakuFilterContainer().release();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void onViewPortUpdate(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        this.mChronosViewPort = viewPort;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void setVisibleRect(DanmakuConfigChange.VisibleRect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        int[] it = rect.getSize();
        if (it != null) {
            this.mVisibleRect = new Rect(0, 0, it[0], it[1]);
        }
        float[] it2 = rect.getOrigin();
        if (it2 != null) {
            this.mVisibleRectX = it2[0];
            this.mVisibleRectY = it2[1];
        }
    }

    public void initChronosView(EnhancedChronosPackageRunner<?> enhancedChronosPackageRunner) {
        if (enhancedChronosPackageRunner != null) {
            this.mMessageHandler = new ChronosMessageHandler(enhancedChronosPackageRunner, this, this.mBusinessMessageHandler);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void registerChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        if (!this.mBusinessMessageHandler.containsKey(chronosRequestHandler.getRequestClass())) {
            this.mBusinessMessageHandler.put(chronosRequestHandler.getRequestClass(), chronosRequestHandler);
            ChronosMessageHandler chronosMessageHandler = this.mMessageHandler;
            if (chronosMessageHandler != null) {
                chronosMessageHandler.addRequestHandler(chronosRequestHandler);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ISampleLocalHandler
    public void unregisterChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        if (this.mBusinessMessageHandler.containsKey(chronosRequestHandler.getRequestClass())) {
            this.mBusinessMessageHandler.remove(chronosRequestHandler.getRequestClass());
            ChronosMessageHandler chronosMessageHandler = this.mMessageHandler;
            if (chronosMessageHandler != null) {
                chronosMessageHandler.removeRequestHandler(chronosRequestHandler);
            }
        }
    }

    public final void setMultiDanmakuPlayer(IMultiDanmakuCallback callBack) {
        this.multiDanmakuCallBack = callBack;
    }
}