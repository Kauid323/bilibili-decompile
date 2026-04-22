package tv.danmaku.biliplayerv2.service.interact.biz;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import bili.resource.common.R;
import com.bapis.bilibili.app.viewunite.v1.FragmentParam;
import com.bapis.bilibili.community.service.dm.v1.Command;
import com.bapis.bilibili.community.service.dm.v1.CommandDm;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bapis.bilibili.community.service.dm.v1.SubtitleRole;
import com.bapis.bilibili.community.service.dm.v1.VideoSubtitle;
import com.bilibili.api.BiliApiException;
import com.bilibili.common.chronoscommon.EnhancedChronosView;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.pvtracker.PageViewTracker;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver;
import tv.danmaku.biliplayerv2.service.DraggingProgressObserver;
import tv.danmaku.biliplayerv2.service.FrameRenderedInfo;
import tv.danmaku.biliplayerv2.service.IMediaCenterObserver;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.SeekService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.AdDanmakuDelegate;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.CommandDanmakuSent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.OnlineInfoChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PreferenceChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.IMultiDanmakuCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuInteractiveWrapper;
import tv.danmaku.biliplayerv2.service.interact.biz.share.ChronosShareManager;
import tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver;
import tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService;
import tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService;
import tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiCallback;
import tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiResponse;
import tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiService;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsDanmaku;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsPanel;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.interact.core.model.MockDanmakuParams;
import tv.danmaku.biliplayerv2.service.interact.core.sender.DanmakuSendParams;
import tv.danmaku.biliplayerv2.service.interact.core.sender.IDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailConfig;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.service.kvo.PlayerKVOService;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver;
import tv.danmaku.biliplayerv2.utils.DanmakuReportHelper;
import tv.danmaku.biliplayerv2.utils.DanmakuSubtitleHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCodecHelper;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: InteractLayerService.kt */
@Metadata(d1 = {"\u0000Ð\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\nSVY\\_behkn\u0018\u0000 »\u00032\u00020\u00012\u00020\u0002:\u0004º\u0003»\u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010p\u001a\u00020qH\u0002J\u0012\u0010r\u001a\u00020q2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0018\u0010u\u001a\u00020q2\u0006\u0010v\u001a\u00020\u00172\u0006\u0010w\u001a\u00020\nH\u0002J\u001d\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010z0y2\u0006\u0010{\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010|J\u0010\u0010}\u001a\u00020q2\u0006\u0010~\u001a\u00020\nH\u0002J\u000b\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020q2\u0007\u0010\u0082\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020q2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u001d\u0010\u0084\u0001\u001a\u00020q2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\t\u0010\u0087\u0001\u001a\u00020qH\u0016J\t\u0010\u0088\u0001\u001a\u000203H\u0002J\t\u0010\u0089\u0001\u001a\u000201H\u0002J\u0012\u0010\u008a\u0001\u001a\u0002062\u0007\u0010\u008b\u0001\u001a\u000206H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020q2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020q2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0002J\t\u0010\u008f\u0001\u001a\u00020qH\u0002J\u0013\u0010\u0092\u0001\u001a\u00020q2\b\u0010\u0093\u0001\u001a\u00030\u0091\u0001H\u0016J\n\u0010\u0094\u0001\u001a\u00030\u0091\u0001H\u0016J\b\u0010P\u001a\u00020\nH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u0014\u0010\u0097\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0016J\u0014\u0010\u0099\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0016J\t\u0010\u009a\u0001\u001a\u00020qH\u0002J\t\u0010\u009b\u0001\u001a\u00020qH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020\n2\u0007\u0010\u009d\u0001\u001a\u00020HH\u0002J\t\u0010\u009e\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020q2\u0007\u0010\u009d\u0001\u001a\u00020HH\u0002J\u001f\u0010 \u0001\u001a\u00020\n2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001H\u0016J\u001f\u0010¥\u0001\u001a\u00020\n2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001H\u0016J4\u0010¦\u0001\u001a\u00020\n2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010§\u0001\u001a\u00020\u00172\u0014\u0010¨\u0001\u001a\u000f\u0012\u0004\u0012\u00020;\u0012\u0005\u0012\u00030©\u000108H\u0016J\u0012\u0010ª\u0001\u001a\u00020q2\u0007\u0010«\u0001\u001a\u00020\nH\u0016J\t\u0010¬\u0001\u001a\u00020\nH\u0016J\u0015\u0010\u00ad\u0001\u001a\u00020q2\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\u001c\u0010°\u0001\u001a\u00020q2\u0011\u0010±\u0001\u001a\f\u0012\u0005\u0012\u00030³\u0001\u0018\u00010²\u0001H\u0002J\u0015\u0010´\u0001\u001a\u00020\n2\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\u0013\u0010·\u0001\u001a\u00020q2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0016J\t\u0010º\u0001\u001a\u00020\nH\u0016J\t\u0010»\u0001\u001a\u00020qH\u0016J\t\u0010¼\u0001\u001a\u00020qH\u0016J\u0015\u0010½\u0001\u001a\u00020q2\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001H\u0016J\t\u0010À\u0001\u001a\u00020\nH\u0016J\t\u0010Á\u0001\u001a\u000201H\u0016J\t\u0010Â\u0001\u001a\u000203H\u0016J\u0013\u0010Ã\u0001\u001a\u00020q2\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0016J\t\u0010Æ\u0001\u001a\u00020\bH\u0016J\t\u0010Ç\u0001\u001a\u00020\nH\u0016J\u0012\u0010È\u0001\u001a\u00020q2\u0007\u0010É\u0001\u001a\u00020\nH\u0016J\t\u0010Ê\u0001\u001a\u00020\nH\u0016J\u0019\u0010Ë\u0001\u001a\u00020q2\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020\n0Í\u0001H\u0016J\u0019\u0010Î\u0001\u001a\u00020q2\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020\n0Í\u0001H\u0016J\u0012\u0010Ï\u0001\u001a\u00020q2\u0007\u0010É\u0001\u001a\u00020\nH\u0016J\u0012\u0010Ð\u0001\u001a\u00020q2\u0007\u0010Ñ\u0001\u001a\u00020\nH\u0016J\t\u0010Ò\u0001\u001a\u00020qH\u0016J\t\u0010Ó\u0001\u001a\u00020qH\u0016J\f\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001H\u0016J\f\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001H\u0016J\t\u0010Ø\u0001\u001a\u00020\nH\u0016J\t\u0010Ù\u0001\u001a\u00020\nH\u0016J\u0012\u0010Ú\u0001\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u0012\u0010Û\u0001\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u0013\u0010Ü\u0001\u001a\u00020q2\b\u0010Ì\u0001\u001a\u00030Ý\u0001H\u0016J\u0013\u0010Þ\u0001\u001a\u00020q2\b\u0010Ì\u0001\u001a\u00030Ý\u0001H\u0016J\u0012\u0010ß\u0001\u001a\u00020q2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0016J\u0013\u0010à\u0001\u001a\u00020q2\b\u0010Ì\u0001\u001a\u00030á\u0001H\u0016J\t\u0010â\u0001\u001a\u00020qH\u0016J \u0010ã\u0001\u001a\u0005\u0018\u00010ä\u00012\b\u0010¨\u0001\u001a\u00030¢\u00012\b\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\u0012\u0010ç\u0001\u001a\u00020q2\u0007\u0010è\u0001\u001a\u000206H\u0016J)\u0010é\u0001\u001a\u00020q2\t\u0010ê\u0001\u001a\u0004\u0018\u00010;2\u0007\u0010§\u0001\u001a\u00020\u00172\n\u0010ë\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016JA\u0010é\u0001\u001a\u00020q2\t\u0010ê\u0001\u001a\u0004\u0018\u00010;2\u0007\u0010§\u0001\u001a\u00020\u00172\n\u0010ë\u0001\u001a\u0005\u0018\u00010©\u00012\u0016\u0010ì\u0001\u001a\u0011\u0012\u0004\u0012\u00020;\u0012\u0005\u0012\u00030í\u0001\u0018\u000108H\u0016J\u0013\u0010î\u0001\u001a\u00020q2\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0016J\t\u0010ñ\u0001\u001a\u00020qH\u0016J\u0015\u0010ò\u0001\u001a\u00020q2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010ó\u0001H\u0016J$\u0010ô\u0001\u001a\u00020q2\u0007\u0010õ\u0001\u001a\u00020\u00192\u0007\u0010ö\u0001\u001a\u00020\u00192\u0007\u0010÷\u0001\u001a\u00020;H\u0016JB\u0010ø\u0001\u001a\u00020q2\t\u0010ù\u0001\u001a\u0004\u0018\u00010\n2\u0007\u0010õ\u0001\u001a\u00020\u00192\u0007\u0010ö\u0001\u001a\u00020\u00192\t\u0010÷\u0001\u001a\u0004\u0018\u00010;2\t\u0010ú\u0001\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0003\u0010û\u0001J6\u0010ü\u0001\u001a\u00020q\"\u0005\b\u0000\u0010ý\u00012\u0007\u0010\u009d\u0001\u001a\u00020H2\u0015\u0010É\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u0003Hý\u00010y\"\u0003Hý\u0001H\u0016¢\u0006\u0003\u0010þ\u0001J\u001e\u0010ÿ\u0001\u001a\u00020\n2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010¨\u0001\u001a\u00020;H\u0016J\t\u0010\u0080\u0002\u001a\u00020\nH\u0016J\u0012\u0010\u0081\u0002\u001a\u00020q2\u0007\u0010\u0082\u0002\u001a\u00020\nH\u0016J\u000b\u0010\u0083\u0002\u001a\u0004\u0018\u00010@H\u0016J\u000b\u0010\u0084\u0002\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010\u0085\u0002\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\t\u0010\u0086\u0002\u001a\u00020\nH\u0016J\u0012\u0010\u0087\u0002\u001a\u00020q2\u0007\u0010\u0088\u0002\u001a\u00020\u0017H\u0016J\t\u0010\u0089\u0002\u001a\u00020\u0017H\u0016J\u000b\u0010\u008a\u0002\u001a\u0004\u0018\u00010@H\u0016J\u001f\u0010\u008b\u0002\u001a\u00020q2\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010@2\t\u0010\u008d\u0002\u001a\u0004\u0018\u00010@H\u0016J\u001b\u0010\u008e\u0002\u001a\u00020q2\u0007\u0010\u008f\u0002\u001a\u00020\n2\u0007\u0010\u0090\u0002\u001a\u00020\nH\u0016J\t\u0010\u0091\u0002\u001a\u00020qH\u0016J\t\u0010\u0092\u0002\u001a\u00020qH\u0016J\t\u0010\u0093\u0002\u001a\u00020qH\u0016J\u001d\u0010\u0094\u0002\u001a\u00020q2\u0007\u0010\u0095\u0002\u001a\u00020;2\t\u0010É\u0001\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010\u0096\u0002\u001a\u00020q2\u0007\u0010\u0097\u0002\u001a\u00020\nH\u0016J\t\u0010\u0098\u0002\u001a\u00020\nH\u0016J\u0012\u0010\u0099\u0002\u001a\u00020q2\u0007\u0010\u009a\u0002\u001a\u00020\nH\u0016J\t\u0010\u009b\u0002\u001a\u00020\nH\u0016J\u0012\u0010\u009c\u0002\u001a\u00020q2\u0007\u0010\u009d\u0002\u001a\u00020;H\u0016J\u0015\u0010\u009e\u0002\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;08H\u0016J\u0012\u0010\u009f\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020\"H\u0016J\u0012\u0010 \u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020\"H\u0016J\u0012\u0010¡\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020$H\u0016J\u0012\u0010¢\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020$H\u0016J\u0012\u0010£\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020&H\u0016J\u0012\u0010¤\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020&H\u0016J\u000b\u0010¥\u0002\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010¦\u0002\u001a\u00020q2\u0007\u0010§\u0002\u001a\u00020EH\u0016J\u0012\u0010¨\u0002\u001a\u00020q2\u0007\u0010É\u0001\u001a\u00020\nH\u0016J\u001d\u0010©\u0002\u001a\u00020q2\b\u0010ª\u0002\u001a\u00030«\u00022\b\u0010¬\u0002\u001a\u00030\u00ad\u0002H\u0016Jg\u0010®\u0002\u001a\u00020q2\u0007\u0010¯\u0002\u001a\u00020;2\u0007\u0010°\u0002\u001a\u00020;2\u0007\u0010±\u0002\u001a\u00020\n2\u0007\u0010²\u0002\u001a\u00020;2\t\u0010³\u0002\u001a\u0004\u0018\u00010;2\u0007\u0010´\u0002\u001a\u00020\n2\u0007\u0010µ\u0002\u001a\u00020\n2\u0010\u0010¶\u0002\u001a\u000b\u0012\u0004\u0012\u00020;\u0018\u00010·\u00022\t\u0010¸\u0002\u001a\u0004\u0018\u00010;H\u0016J\u0013\u0010¹\u0002\u001a\u00020q2\b\u0010Ì\u0001\u001a\u00030º\u0002H\u0016J\u0013\u0010»\u0002\u001a\u00020q2\b\u0010Ì\u0001\u001a\u00030º\u0002H\u0016J<\u0010¼\u0002\u001a\u00020q2\t\u0010²\u0002\u001a\u0004\u0018\u00010;2\t\u0010½\u0002\u001a\u0004\u0018\u00010;2\t\u0010¾\u0002\u001a\u0004\u0018\u00010\u00192\n\u0010¿\u0002\u001a\u0005\u0018\u00010À\u0002H\u0016¢\u0006\u0003\u0010Á\u0002J\u0012\u0010Â\u0002\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J<\u0010Ã\u0002\u001a\u00020q2\n\u0010Ä\u0002\u001a\u0005\u0018\u00010Å\u00022\u0007\u0010Æ\u0002\u001a\u00020\u00192\u0007\u0010Ç\u0002\u001a\u00020\n2\u0013\u0010ë\u0001\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;08H\u0016J\t\u0010È\u0002\u001a\u00020qH\u0016J-\u0010É\u0002\u001a\u00020q2\u0007\u0010§\u0001\u001a\u00020\u00172\u0007\u0010Ê\u0002\u001a\u00020\u00192\u0007\u0010Ë\u0002\u001a\u00020\u00192\u0007\u0010Ì\u0002\u001a\u00020\nH\u0016J$\u0010Í\u0002\u001a\u00020q2\u0007\u0010§\u0001\u001a\u00020\u00172\u0007\u0010Î\u0002\u001a\u00020\u00192\u0007\u0010Ì\u0002\u001a\u00020\nH\u0016J\u0014\u0010Ï\u0002\u001a\u00020q2\t\u0010Ð\u0002\u001a\u0004\u0018\u00010*H\u0016J\u0014\u0010Ñ\u0002\u001a\u00020q2\t\u0010Ò\u0002\u001a\u0004\u0018\u00010,H\u0016J\f\u0010Ó\u0002\u001a\u0005\u0018\u00010Ô\u0002H\u0016J\f\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u0002H\u0016J\f\u0010×\u0002\u001a\u0005\u0018\u00010Ø\u0002H\u0016J\f\u0010Ù\u0002\u001a\u0005\u0018\u00010Ú\u0002H\u0016J\f\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u0002H\u0016J\u0012\u0010Ý\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010Þ\u0002\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010ß\u0002\u001a\u00020q2\b\u0010Ò\u0002\u001a\u00030à\u0002H\u0016J\u0013\u0010á\u0002\u001a\u00020q2\b\u0010Ò\u0002\u001a\u00030à\u0002H\u0016J\u0012\u0010â\u0002\u001a\u000b\u0012\u0004\u0012\u00020z\u0018\u00010ã\u0002H\u0016J\u0013\u0010ä\u0002\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020\u0017H\u0016J\u001a\u0010å\u0002\u001a\u00020q2\u0007\u0010æ\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ç\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010é\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ê\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ë\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ì\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010í\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010î\u0002\u001a\u00020q2\u0007\u0010ï\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ð\u0002\u001a\u00020q2\u0007\u0010ñ\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ò\u0002\u001a\u00020q2\u0007\u0010è\u0002\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ó\u0002\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ô\u0002\u001a\u00020q2\u0007\u0010õ\u0002\u001a\u0002062\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ö\u0002\u001a\u00020q2\u0007\u0010÷\u0002\u001a\u0002062\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ø\u0002\u001a\u00020q2\u0007\u0010ù\u0002\u001a\u0002062\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ú\u0002\u001a\u00020q2\u0007\u0010ù\u0002\u001a\u0002062\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010û\u0002\u001a\u00020q2\u0007\u0010ü\u0002\u001a\u00020\u00172\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010ý\u0002\u001a\u00020q2\u0007\u0010\u008b\u0001\u001a\u0002062\u0006\u0010~\u001a\u00020\nH\u0016J\u001a\u0010þ\u0002\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\n2\u0006\u0010~\u001a\u00020\nH\u0016J\u0012\u0010ÿ\u0002\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u0013\u0010\u0080\u0003\u001a\u00020q2\b\u0010\u0081\u0003\u001a\u00030\u0082\u0003H\u0016J\u001e\u0010\u0083\u0003\u001a\u00020q2\r\u0010\u0084\u0003\u001a\b\u0012\u0004\u0012\u00020;0yH\u0016¢\u0006\u0003\u0010\u0085\u0003J\u0019\u0010\u0086\u0003\u001a\u00020q2\u000e\u0010\u0087\u0003\u001a\t\u0012\u0004\u0012\u00020\u00190ã\u0002H\u0016J\u0012\u0010\u0088\u0003\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0089\u0003\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u0014\u0010\u008a\u0003\u001a\u00020q2\t\u0010÷\u0001\u001a\u0004\u0018\u00010;H\u0016J\u000b\u0010\u008b\u0003\u001a\u0004\u0018\u00010;H\u0016J\u000b\u0010\u008c\u0003\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010\u008d\u0003\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020(H\u0016J\u0012\u0010\u008e\u0003\u001a\u00020q2\u0007\u0010Ì\u0001\u001a\u00020(H\u0016J\u001a\u0010\u008f\u0003\u001a\u00020q2\u0007\u0010ù\u0001\u001a\u00020\u00172\u0006\u0010~\u001a\u00020\nH\u0016J\t\u0010\u0090\u0003\u001a\u00020\u0017H\u0016J\u001a\u0010\u0091\u0003\u001a\u00020q2\u0007\u0010\u0092\u0003\u001a\u00020\u00172\u0006\u0010~\u001a\u00020\nH\u0016J\u001e\u0010\u0093\u0003\u001a\u00020q2\u0013\u0010\u0094\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001708H\u0016J\u0015\u0010\u0095\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001708H\u0016J\u001a\u0010\u0096\u0003\u001a\u00020q2\t\u0010ª\u0002\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0003\u0010\u0097\u0003J\u0017\u0010\u0098\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u000108H\u0002J\t\u0010\u0099\u0003\u001a\u00020\u0017H\u0016J'\u0010®\u0002\u001a\u00020q2\u0007\u0010°\u0002\u001a\u00020;2\u0007\u0010±\u0002\u001a\u00020\n2\n\u0010\u009a\u0003\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J\u001d\u0010\u009b\u0003\u001a\u00020q2\t\u0010\u009c\u0003\u001a\u0004\u0018\u00010;2\u0007\u0010\u009d\u0003\u001a\u00020\u0017H\u0002J\n\u0010\u009e\u0003\u001a\u00030\u009f\u0003H\u0016J\u001b\u0010 \u0003\u001a\u00020q2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010s\u001a\u00020tH\u0016J!\u0010¡\u0003\u001a\u00020q2\n\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0082\u00032\n\u0010¢\u0003\u001a\u0005\u0018\u00010£\u0003H\u0016J\u0014\u0010¤\u0003\u001a\u00020q2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010¥\u0003\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\t\u0010¦\u0003\u001a\u00020\nH\u0016J\u0012\u0010§\u0003\u001a\u00020q2\u0007\u0010\u0096\u0001\u001a\u00020\nH\u0016J\u000b\u0010¨\u0003\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010©\u0003\u001a\u00020q2\t\u0010£\u0001\u001a\u0004\u0018\u00010OH\u0016J\u000b\u0010ª\u0003\u001a\u0004\u0018\u00010OH\u0016J\u001b\u0010«\u0003\u001a\u00020q2\u0010\u0010¬\u0003\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00ad\u0003H\u0016J\u001b\u0010®\u0003\u001a\u00020q2\u0010\u0010¬\u0003\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00ad\u0003H\u0016J\f\u0010¯\u0003\u001a\u0005\u0018\u00010°\u0003H\u0016J\t\u0010±\u0003\u001a\u00020qH\u0016J\u0011\u0010¸\u0003\u001a\u00020q2\u0006\u0010~\u001a\u00020\nH\u0016J\u0011\u0010¹\u0003\u001a\u00020q2\u0006\u0010~\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010!\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\"0\"  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\"0\"\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010#\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010$0$  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010$0$\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010%\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010&0&  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010&0&\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010'\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010(0(  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010(0(\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020605X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010=j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010F\u001a\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001708X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0004\n\u0002\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0010\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ZR\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]R\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`R\u0010\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010cR\u0010\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010fR\u0010\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0004\n\u0002\u0010iR\u0010\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0004\n\u0002\u0010lR\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010oR\u0010\u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010²\u0003\u001a\u00020\nX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0003\u0010´\u0003\"\u0006\bµ\u0003\u0010¶\u0003R\u0012\u0010·\u0003\u001a\u0005\u0018\u00010À\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¼\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService;", "Ltv/danmaku/biliplayerv2/service/interact/core/InteractCoreService;", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mInteractContainer", "Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer;", "mEnableReply", "", "mDmVideoSeekingEnable", "mNeedRenderStartCheck", "mPendingAutomaticViewProgressRequest", "mIsForbidCloseSubtitle", "mSwitchRestoredFromShared", "mDanmakuSwitchShareEnable", "mSubtitleStateShareEnable", "mIsInlineMode", "mSubtitleShowInSettingWidget", "mMonopolizeTap", "mSubtitleAvailable", "mSeniorModeSwitch", "", "mSendScene", "", "Ljava/lang/Long;", "mDanmakuReplyObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuReplyObserver;", "mWatchPointObserverList", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/WatchPointObserver;", "kotlin.jvm.PlatformType", "mDanmakuParamsChangedObservers", "Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuParamsChangeObserver;", "mSubtitleChangedObservers", "Ltv/danmaku/biliplayerv2/service/interact/biz/ISubtitleChangedObserver;", "mDanmakuSettingsChangedObservers", "Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuSettingsChangedObserver;", "mDanmakuSeniorModeChangeObserverList", "Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuSeniorModeChangeObserver;", "mPlayerCardStatusSyncFromPlayerListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/PlayerCardStatusSyncFromPlayerListener;", "mPlayerCardStatusSyncListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/PlayerCardStatusSyncListener;", "mSeekServiceClient", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "Ltv/danmaku/biliplayerv2/service/SeekService;", "mDanmakuParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "mDanmakuSwitchParams", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuSwitchParams;", "mScreenDomainAvailableRange", "Lkotlin/Pair;", "", "mAiBlockLevelTransferMap", "", "mIsHdrResource", "mDanmakuExposureSpmid", "", "mBlockedDmIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mMainSubtitle", "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "mViceSubtitle", "mSharedSubtitle", "Ltv/danmaku/biliplayerv2/service/interact/biz/SharedSubtitle;", "mDanmakuInputClickInterceptor", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuInputClickInterceptor;", "mDisableDanmakuOptions", "Ljava/util/HashSet;", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;", "Lkotlin/collections/HashSet;", "mFixedDanmakuOptions", "mDanmakuPlayerPanelSelectionText", "mSubtitleBottomMargin", "mIsCustomSubtitleMargin", "mMockParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/MockDanmakuParams;", "bilingualSwitchEnabled", "mDefaultLevelMap", "mDanmakuVisibleObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mDanmakuVisibleObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mDanmakuVisibleObserver$1;", "mControlContainerVisibleObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mControlContainerVisibleObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mControlContainerVisibleObserver$1;", "mVideoPlayEventListener", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mVideoPlayEventListener$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mVideoPlayEventListener$1;", "mRenderStartObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mRenderStartObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mRenderStartObserver$1;", "mMediaCenterObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mMediaCenterObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mMediaCenterObserver$1;", "mMediaResourceObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mMediaResourceObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mMediaResourceObserver$1;", "mPlayerProgressObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mPlayerProgressObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mPlayerProgressObserver$1;", "mDraggingProgressObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mDraggingProgressObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mDraggingProgressObserver$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mPlayerStateObserver$1;", "mPlayerSettingsObserver", "tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mPlayerSettingsObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$mPlayerSettingsObserver$1;", "reportSubtitleSetting", "", "tryRestoreDanmakuPlayer", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "notifyWatchPointChanged", "progress", "fromDragging", "findCurrentPointAndChapter", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "positionMS", "(I)[Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "notifyWatchPointOnDragging", "fromUser", "getViewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "bindPlayerContainer", "playerContainer", "onStart", "onAttachByShared", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onStop", "createDanmakuSwitchParams", "createDanmakuParams", "ensureDanmakuSpeed", "speed", "syncDanmakuSwitchKVO", "visible", "syncInlineDanmakuSwitchKVO", "updateDanmakuSeniorModeSwitch", "subtitleKeyConfig", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$SubtitleKeyConfig;", "putSubtitleKeyConfig", "config", "getSubtitleKeyConfig", "enableBilingualSwitch", "enable", "chooseMainSubtitle", "force", "chooseViceSubtitle", "reportSubtitleLan", "dispatchDanmakuParamsChanged", "checkOptionFixedOrDisable", "name", "bilingualSwitchOn", "notifyDanmakuSettingsChanged", "sendDanmaku", "context", "Landroid/content/Context;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/sender/DanmakuSendParams;", "sendDanmakuV2", "sendCommandDanmaku", "type", "content", "", "setInlineMode", "isInline", "isInlineMode", "setDmViewReply", "reply", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "setCommandDanmaku", "commandDmsList", "", "Lcom/bapis/bilibili/community/service/dm/v1/CommandDm;", "startFromShared", "danmakuResolveParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "bindDanmakuContainer", "container", "Landroid/widget/FrameLayout;", "isDanmakuForbidden", "clearChronosPackage", "clearDanmaku", "runPackageForLive", "pkg", "Lcom/bilibili/cron/ChronosPackage;", "isChronosValid", "getDanmakuParams", "getDanmakuSwitchParams", "setVisibleRect", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "getChronosInteractContainer", "getSegmentSwitchVisibility", "setSegmentSwitchValue", "value", "getSegmentSwitchValue", "addSegmentSwitchObserver", "observer", "Landroidx/lifecycle/Observer;", "removeSegmentSwitchObserver", "setForcedChapterGuide", "setEyesProtectionMode", "mode", "loadThumbnailIfNeed", "loadThumbnailIfNeed2", "getThumbnailFetcher", "Ltv/danmaku/biliplayerv2/service/ThumbnailLoader;", "getThumbnailFetcher2", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2;", "hasThumbnails", "hasThumbnails2", "setThumbnailEnable", "setThumbnail2Enable", "registerViewProgressObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/ViewProgressObserver;", "unregisterViewProgressObserver", "setChronosVisible", "addDanmakuInteractionObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuInteractionObserver;", "removeDanmakuInteractionObserver", "cloneMultiDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer;", "multiDanmakuCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/IMultiDanmakuCallback;", "setDanmakuViewOffset", "offsetY", "addDanmaku", "dmId", "extra", "emoExtra", "", "registerChronosReadyCallback", "onChronosReadyCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/OnChronosReadyCallback;", "unregisterChronosReadyCallback", "setThumbnailConfig", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "sendOnlineInfoDanmaku", "aid", "cid", "text", "setOnlineInfo", "switch", "logo", "(Ljava/lang/Boolean;JJLjava/lang/String;Ljava/lang/String;)V", "setDanmakuOptions", "T", "(Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;[Ljava/lang/Object;)V", "sendUpDanmaku", "isSubtitleShowInSettingWidget", "setSubtitleShowInSettingWidget", "show", "getMainSubtitle", "getViceSubtitle", "setCustomSubtitleMargin", "isCustomSubtitleMargin", "updateSubtitleDrawRect", "bottomFix", "getSubtitleBottomMargin", "getInitViceSubtitle", "loadSubtitle", "mainSubtitle", "viceSubtitle", "recordSelectedSubtitle", "isShare", "isManual", "dispatchSubtitleModeChanged", "dispatchSubtitleDragChanged", "dispatchSubtitleLargeChanged", "onPreferenceChanged", "key", "setSubtitleAvailable", "available", "isSubtitleAvailable", "setForbidCloseSubtitle", "forbid", "isForbidCloseSubtitle", "setDanmakuExposureSpmid", "spmid", "getDanmakuReportCommonParameters", "addDanmakuParamsChangedObserver", "removeDanmakuParamsChangedObserver", "addSubtitleChangedObserver", "removeSubtitleChangedObserver", "addDanmakuSettingsChangedObserver", "removeDanmakuSettingsChangedObserver", "getDanmakuInputClickInterceptor", "setDanmakuInputClickInterceptor", "interceptor", "setDanmakuMonopolizeTap", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "reportDanmaku", "danmakuId", "reason", "shieldUser", "shieldUserId", "oid", "needReportAndGetBlockData", "blockUser", "rResponse", "Lcom/bilibili/okretro/GeneralResponse;", "dmContent", "addDanmakuCommandPanelsObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuCommandPanelsObserver;", "removeDanmakuCommandPanelsObserver", "appendFilters", "regexFilter", "nativeId", "onSuccess", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Runnable;)V", "setChronosEnable", "reloadViewProgress", "fragmentParam", "Lcom/bapis/bilibili/app/viewunite/v1/FragmentParam;", "fragmentOffset", "simplify", "loadCommandPanel", "syncStandardCardStatus", "activityId", "reserveId", "status", "syncStandardCardStatusFromPlayer", "id", "setSyncCardStatusFromPlayerListener", "fromPlayerListener", "setSyncCardStatusListener", "listener", "getLocalHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalHandler;", "getRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "getAdDanmakuDelegate", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/AdDanmakuDelegate;", "getDanmakuCommandPanel", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "getRenderViewBitmap", "Landroid/graphics/Bitmap;", "registerWatchPointsChangeObserver", "unregisterWatchPointsChangeObserver", "addWatchPointsLoadListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/IWatchPointsLoadListener;", "removeWatchPointsLoadListener", "getWatchPoints", "", "findWatchPointByPosition", "switchAiRecommendedSwitch", "aiRecommendedSwitch", "setBlockRepeat", "block", "setBlockTop", "setBlockScroll", "setBlockBottom", "setBlockColorful", "setBlockSpecial", "setDanmakuAvoidScript", "avoidScript", "setDanmakuAvoidFigure", "avoidFigure", "setBlockFixed", "setBlackWordsEnable", "setDanmakuOpacity", "opacity", "setScaleFactor", "factor", "setDanmakuDomain", "domain", "setDanmakuDisplayDomain", "setDanmakuDensity", "density", "setDanmakuSpeed", "setDanmakuFoldSwitchEnable", "setBlockList", "blockDanmakuOnScreen", "item", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "blockUsers", "users", "([Ljava/lang/String;)V", "blockDmids", "dmids", "setDanmakuSwitchShareEnable", "setSubtitleStateShareEnable", "setDanmakuPlayerPanelSelectionText", "getDanmakuPlayerPanelSelectionText", "getDanmakuForbiddenDescribe", "registerDanmakuSeniorModeChangeObserve", "unregisterDanmakuSeniorModeChangeObserve", "changeDanmakuSeniorModeSwitch", "getDanmakuSeniorModeSwitch", "setAiBlockLevel", "level", "setAiBlockLevelMap", "levelTransferMap", "getAiBlockLevelMap", "setDanmakuSendCustomScene", "(Ljava/lang/Long;)V", "getLevelMapFromKV", "getAiBlockLevel", "danmaku", "showToast", "message", "location", "serviceConfig", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "onCollectSharedParams", "recallDanmaku", "callback", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuRecallCallback;", "setDanmakuReplyObserver", "enableReply", "isEnableReply", "setDmVideoSeekingEnable", "getDanmakuReplyObserver", "setMockDanmakuParams", "getMockDanmakuParams", "registerChronosMessageHandler", "handler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "unregisterChronosMessageHandler", "getChronosMessageSender", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/protocol/IChronosRpcSender;", "resetPreferences", "automaticViewProgressRequestDisabled", "getAutomaticViewProgressRequestDisabled", "()Z", "setAutomaticViewProgressRequestDisabled", "(Z)V", "pendingDanmakuVisible", "showDanmaku", "hideDanmaku", "SubtitleKeyConfig", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InteractLayerService extends InteractCoreService implements IInteractLayerService {
    public static final String CLEAR_CHRONOS_ID = "0";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SHARE_CHRONOS_CONTENT = "KEY_SHARE_CHRONOS_CONTENT";
    public static final String TAG = "InteractLayerService";
    private boolean automaticViewProgressRequestDisabled;
    private Map<Integer, Integer> mAiBlockLevelTransferMap;
    private ArrayList<Long> mBlockedDmIds;
    private String mDanmakuExposureSpmid;
    private DanmakuInputClickInterceptor mDanmakuInputClickInterceptor;
    private DanmakuParams mDanmakuParams;
    private String mDanmakuPlayerPanelSelectionText;
    private DanmakuReplyObserver mDanmakuReplyObserver;
    private DanmakuSwitchParams mDanmakuSwitchParams;
    private boolean mDanmakuSwitchShareEnable;
    private boolean mDmVideoSeekingEnable;
    private boolean mEnableReply;
    private ChronosInteractContainer mInteractContainer;
    private boolean mIsCustomSubtitleMargin;
    private boolean mIsForbidCloseSubtitle;
    private boolean mIsHdrResource;
    private boolean mIsInlineMode;
    private SubtitleItem mMainSubtitle;
    private MockDanmakuParams mMockParams;
    private boolean mMonopolizeTap;
    private boolean mPendingAutomaticViewProgressRequest;
    private PlayerCardStatusSyncFromPlayerListener mPlayerCardStatusSyncFromPlayerListener;
    private PlayerCardStatusSyncListener mPlayerCardStatusSyncListener;
    private PlayerContainer mPlayerContainer;
    private Long mSendScene;
    private int mSeniorModeSwitch;
    private SharedSubtitle mSharedSubtitle;
    private int mSubtitleBottomMargin;
    private boolean mSubtitleStateShareEnable;
    private boolean mSwitchRestoredFromShared;
    private SubtitleItem mViceSubtitle;
    private Runnable pendingDanmakuVisible;
    private boolean mNeedRenderStartCheck = true;
    private boolean mSubtitleShowInSettingWidget = true;
    private boolean mSubtitleAvailable = true;
    private final Collections.SafeIteratorList<WatchPointObserver> mWatchPointObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IDanmakuParamsChangeObserver> mDanmakuParamsChangedObservers = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<ISubtitleChangedObserver> mSubtitleChangedObservers = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IDanmakuSettingsChangedObserver> mDanmakuSettingsChangedObservers = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IDanmakuSeniorModeChangeObserver> mDanmakuSeniorModeChangeObserverList = Collections.safeIteratorList(new LinkedList());
    private final PlayerServiceManager.Client<SeekService> mSeekServiceClient = new PlayerServiceManager.Client<>();
    private Pair<Float, Float> mScreenDomainAvailableRange = new Pair<>(Float.valueOf((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN), Float.valueOf(2.0f));
    private final HashSet<DanmakuConfig.DanmakuOptionName> mDisableDanmakuOptions = new HashSet<>();
    private final HashSet<DanmakuConfig.DanmakuOptionName> mFixedDanmakuOptions = new HashSet<>();
    private boolean bilingualSwitchEnabled = true;
    private final Map<Integer, Integer> mDefaultLevelMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, 3), TuplesKt.to(2, 4), TuplesKt.to(3, 8)});
    private final InteractLayerService$mDanmakuVisibleObserver$1 mDanmakuVisibleObserver = new DanmakuVisibleObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mDanmakuVisibleObserver$1
        @Override // tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver
        public void onDanmakuVisibleChanged(boolean visible, boolean fromUser) {
            boolean z;
            if (fromUser) {
                z = InteractLayerService.this.mIsInlineMode;
                if (z) {
                    InteractLayerService.this.syncInlineDanmakuSwitchKVO(visible);
                } else {
                    InteractLayerService.this.syncDanmakuSwitchKVO(visible);
                }
            }
        }
    };
    private final InteractLayerService$mControlContainerVisibleObserver$1 mControlContainerVisibleObserver = new ControlContainerVisibleObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mControlContainerVisibleObserver$1
        @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
        public /* synthetic */ void onControlContainerImmersiveChanged(int i, boolean z) {
            ControlContainerVisibleObserver.CC.$default$onControlContainerImmersiveChanged(this, i, z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r0.hasSubtitleHeight() == true) goto L9;
         */
        @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onControlContainerVisibleChanged(boolean visible) {
            SubtitleItem subtitleItem;
            boolean z;
            PlayerContainer playerContainer;
            if (InteractLayerService.this.isCustomSubtitleMargin()) {
                return;
            }
            subtitleItem = InteractLayerService.this.mMainSubtitle;
            if (subtitleItem != null) {
                z = true;
            }
            z = false;
            if (z) {
                return;
            }
            if (visible) {
                InteractLayerService interactLayerService = InteractLayerService.this;
                playerContainer = InteractLayerService.this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                interactLayerService.updateSubtitleDrawRect(playerContainer.getControlContainerService().getBottomSubtitleBlock());
                return;
            }
            InteractLayerService.this.updateSubtitleDrawRect(0);
        }
    };
    private final InteractLayerService$mVideoPlayEventListener$1 mVideoPlayEventListener = new VideoDirectorObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mVideoPlayEventListener$1
        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onItemCompleted(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onItemStart(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "item");
        }

        @Override // tv.danmaku.biliplayerv2.service.ResolveListener
        public /* synthetic */ void onResolveFailed(Video.PlayableParams playableParams, String str) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.ResolveListener
        public /* synthetic */ void onResolveSucceed(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
            if (r2.isChronosValid() != false) goto L14;
         */
        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemWillChange(Video.PlayableParams playableParams, Video.PlayableParams old) {
            ChronosInteractContainer chronosInteractContainer;
            ChronosInteractContainer chronosInteractContainer2;
            ChronosInteractContainer chronosInteractContainer3;
            Intrinsics.checkNotNullParameter(playableParams, "new");
            InteractLayerService.this.mNeedRenderStartCheck = true;
            if (old == null) {
                chronosInteractContainer3 = InteractLayerService.this.mInteractContainer;
                if (chronosInteractContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                    chronosInteractContainer3 = null;
                }
            }
            chronosInteractContainer = InteractLayerService.this.mInteractContainer;
            if (chronosInteractContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer = null;
            }
            chronosInteractContainer.onWorkInfoChange("0", "0");
            chronosInteractContainer2 = InteractLayerService.this.mInteractContainer;
            if (chronosInteractContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer2 = null;
            }
            chronosInteractContainer2.clearInteractContainer();
            InteractLayerService.this.pendingDanmakuVisible = null;
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public void onPlayableParamsChanged(Video.PlayableParams playableParams) {
            ChronosInteractContainer chronosInteractContainer;
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            chronosInteractContainer = InteractLayerService.this.mInteractContainer;
            if (chronosInteractContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer = null;
            }
            chronosInteractContainer.loadCommandPanel();
        }
    };
    private final InteractLayerService$mRenderStartObserver$1 mRenderStartObserver = new IRenderStartObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mRenderStartObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public /* synthetic */ void onAudioRenderStart() {
            IRenderStartObserver.CC.$default$onAudioRenderStart(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onVideoRenderStart() {
            boolean z;
            ChronosInteractContainer chronosInteractContainer;
            ChronosInteractContainer chronosInteractContainer2;
            PlayerContainer playerContainer;
            ChronosInteractContainer chronosInteractContainer3;
            z = InteractLayerService.this.mNeedRenderStartCheck;
            ChronosInteractContainer chronosInteractContainer4 = null;
            if (z) {
                playerContainer = InteractLayerService.this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
                Video.DanmakuResolveParams danmakuParams = currentPlayableParams != null ? currentPlayableParams.getDanmakuResolveParams() : null;
                if (danmakuParams != null && danmakuParams.getAvid() > 0 && danmakuParams.getCid() > 0) {
                    chronosInteractContainer3 = InteractLayerService.this.mInteractContainer;
                    if (chronosInteractContainer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                        chronosInteractContainer3 = null;
                    }
                    chronosInteractContainer3.onWorkInfoChange(String.valueOf(danmakuParams.getAvid()), String.valueOf(danmakuParams.getCid()));
                }
            }
            chronosInteractContainer = InteractLayerService.this.mInteractContainer;
            if (chronosInteractContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer = null;
            }
            chronosInteractContainer.init();
            boolean needViewProgress = InteractLayerService.this.getAutomaticViewProgressRequestDisabled() ? InteractLayerService.this.mPendingAutomaticViewProgressRequest : InteractLayerService.this.mNeedRenderStartCheck;
            if (needViewProgress) {
                IInteractLayerService.CC.reloadViewProgress$default(InteractLayerService.this, false, null, 3, null);
                chronosInteractContainer2 = InteractLayerService.this.mInteractContainer;
                if (chronosInteractContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                } else {
                    chronosInteractContainer4 = chronosInteractContainer2;
                }
                chronosInteractContainer4.loadCommandPanel();
            }
            InteractLayerService.this.reportSubtitleSetting();
            InteractLayerService.this.mNeedRenderStartCheck = false;
        }
    };
    private final InteractLayerService$mMediaCenterObserver$1 mMediaCenterObserver = new IMediaCenterObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mMediaCenterObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onPlayerReconnect() {
            IMediaCenterObserver.CC.$default$onPlayerReconnect(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onRestoreFromMediaCenterTerminate() {
            IMediaCenterObserver.CC.$default$onRestoreFromMediaCenterTerminate(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onTerminateByMediaCenter() {
            ChronosInteractContainer chronosInteractContainer;
            BLog.i(InteractLayerService.TAG, "terminate by media center");
            chronosInteractContainer = InteractLayerService.this.mInteractContainer;
            if (chronosInteractContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer = null;
            }
            chronosInteractContainer.releaseChronos(true);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onPreparedFromMediaCenterTerminate() {
            ChronosInteractContainer chronosInteractContainer;
            BLog.i(InteractLayerService.TAG, "prepared for new lifecycle");
            chronosInteractContainer = InteractLayerService.this.mInteractContainer;
            if (chronosInteractContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer = null;
            }
            chronosInteractContainer.restore();
        }
    };
    private final InteractLayerService$mMediaResourceObserver$1 mMediaResourceObserver = new IMediaResourceObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mMediaResourceObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public /* synthetic */ boolean onPrepared(MediaResource mediaResource) {
            return IMediaResourceObserver.CC.$default$onPrepared(this, mediaResource);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public void onUpdated(MediaResource resource) {
            IMediaResourceObserver.CC.$default$onUpdated(this, resource);
            InteractLayerService.this.mIsHdrResource = resource != null ? resource.isHdr() : false;
        }
    };
    private final InteractLayerService$mPlayerProgressObserver$1 mPlayerProgressObserver = new PlayerProgressObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mPlayerProgressObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerProgressObserver
        public void onPlayerProgressChange(int progress, int duration) {
            InteractLayerService.this.notifyWatchPointChanged(progress, false);
        }
    };
    private final InteractLayerService$mDraggingProgressObserver$1 mDraggingProgressObserver = new DraggingProgressObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mDraggingProgressObserver$1
        @Override // tv.danmaku.biliplayerv2.service.DraggingProgressObserver
        public void onDraggingByUserChanged(boolean fromUser) {
            boolean z;
            InteractLayerService.this.notifyWatchPointOnDragging(fromUser);
            z = InteractLayerService.this.mDmVideoSeekingEnable;
            if (z) {
                long type = fromUser ? 1L : 3L;
                IRemoteHandler remoteHandler = InteractLayerService.this.getRemoteHandler();
                if (remoteHandler != null) {
                    remoteHandler.onVideoSeeking(0L, type);
                }
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.DraggingProgressObserver
        public void onDraggingProgressChanged(int progress, int duration) {
            boolean z;
            IRemoteHandler remoteHandler;
            InteractLayerService.this.notifyWatchPointChanged(progress, true);
            z = InteractLayerService.this.mDmVideoSeekingEnable;
            if (!z || (remoteHandler = InteractLayerService.this.getRemoteHandler()) == null) {
                return;
            }
            remoteHandler.onVideoSeeking(progress, 2L);
        }
    };
    private final InteractLayerService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            PlayerContainer playerContainer;
            switch (state) {
                case 3:
                    InteractLayerService.this.loadThumbnailIfNeed();
                    InteractLayerService.this.loadThumbnailIfNeed2();
                    return;
                case 6:
                    DanmakuReportHelper danmakuReportHelper = DanmakuReportHelper.INSTANCE;
                    playerContainer = InteractLayerService.this.mPlayerContainer;
                    if (playerContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer = null;
                    }
                    danmakuReportHelper.reportAllDanmakuSetting(playerContainer, InteractLayerService.this.getDanmakuParams(), 2);
                    return;
                default:
                    return;
            }
        }
    };
    private final InteractLayerService$mPlayerSettingsObserver$1 mPlayerSettingsObserver = new PlayerSettingChangeObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$mPlayerSettingsObserver$1
        @Override // tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver
        public void onChange(String key) {
            PlayerContainer playerContainer;
            Intrinsics.checkNotNullParameter(key, "key");
            if (Intrinsics.areEqual(key, DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST)) {
                DanmakuParams danmakuParams = InteractLayerService.this.getDanmakuParams();
                playerContainer = InteractLayerService.this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                danmakuParams.setDanmakuBlackWordsEnable(playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true));
            }
        }
    };
    private SubtitleKeyConfig subtitleKeyConfig = new SubtitleKeyConfig(null, null, null, 7, null);

    /* compiled from: InteractLayerService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DanmakuConfig.DanmakuOptionName.values().length];
            try {
                iArr[DanmakuConfig.DanmakuOptionName.DUPLICATE_MERGING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.BLOCK_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.BLOCK_SCROLL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.BLOCK_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.BLOCK_COLORFUL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.BLOCK_SPECIAL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.TRANSPARENCY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.TEXTSIZE_SCALE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.SCREEN_DOMAIN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[DanmakuConfig.DanmakuOptionName.SCROLL_DURATION_FACTOR.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public /* synthetic */ void reloadViewProgress(boolean z, Map map) {
        IInteractLayerService.CC.$default$reloadViewProgress(this, z, map);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public /* synthetic */ void setDanmakuReplyHandler(Function4 function4) {
        IInteractLayerService.CC.$default$setDanmakuReplyHandler(this, function4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportSubtitleSetting() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        boolean editStatus = playerContainer.getPlayerSettingService().getCloudConfig().enableFeedbackSubtitle();
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        boolean dragStatus = playerContainer3.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_DRAG, false);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_neuron_subtitle_setting_status, "edit_status", editStatus ? "1" : "0", "drag_status", dragStatus ? "1" : "0", LoginSceneProcessor.SCENE_KEY, "1"));
    }

    private final void tryRestoreDanmakuPlayer(PlayerSharingBundle bundle) {
        boolean danmakuVisible;
        Boolean danmakuSwitch;
        if (bundle == null) {
            return;
        }
        InteractShareContent shareContent = (InteractShareContent) PlayerSharingBundle.getSharableObject$default(bundle, KEY_SHARE_CHRONOS_CONTENT, false, 2, null);
        boolean chronosSwitch = shareContent != null ? shareContent.getChronosSwitch() : false;
        this.mSwitchRestoredFromShared = (shareContent != null ? shareContent.getDanmakuSwitch() : null) != null && chronosSwitch;
        this.mDanmakuParams = shareContent != null ? shareContent.getDanmakuParams() : null;
        this.mDanmakuExposureSpmid = shareContent != null ? shareContent.getDanmakuExposureSpmid() : null;
        this.mSharedSubtitle = shareContent != null ? shareContent.getSharedSubtitle() : null;
        if (this.mSwitchRestoredFromShared) {
            if (shareContent == null || (danmakuSwitch = shareContent.getDanmakuSwitch()) == null) {
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                danmakuVisible = playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_SWITCH, true);
            } else {
                danmakuVisible = danmakuSwitch.booleanValue();
            }
            IInteractCoreService.CC.setDanmakuVisible$default(this, danmakuVisible, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyWatchPointChanged(int progress, final boolean fromDragging) {
        if (this.mWatchPointObserverList.isEmpty()) {
            return;
        }
        List<ChronosThumbnailInfo.WatchPoint> watchPoints = getWatchPoints();
        if (watchPoints == null || watchPoints.isEmpty()) {
            return;
        }
        final ChronosThumbnailInfo.WatchPoint[] points = findCurrentPointAndChapter(progress);
        this.mWatchPointObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                InteractLayerService.notifyWatchPointChanged$lambda$0(points, fromDragging, (WatchPointObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyWatchPointChanged$lambda$0(ChronosThumbnailInfo.WatchPoint[] $points, boolean $fromDragging, WatchPointObserver it) {
        it.onWatchPointChanged($points[0], $points[1], $fromDragging);
    }

    private final ChronosThumbnailInfo.WatchPoint[] findCurrentPointAndChapter(int positionMS) {
        ChronosThumbnailInfo.WatchPoint[] result = new ChronosThumbnailInfo.WatchPoint[2];
        Iterable watchPoints = getWatchPoints();
        if (watchPoints == null) {
            return result;
        }
        int positionS = (positionMS + 999) / IjkMediaCodecInfo.RANK_MAX;
        boolean stopChange = false;
        Iterable $this$forEach$iv = watchPoints;
        for (Object element$iv : $this$forEach$iv) {
            ChronosThumbnailInfo.WatchPoint it = (ChronosThumbnailInfo.WatchPoint) element$iv;
            if (positionS >= it.getFrom() && positionS <= it.getTo()) {
                if (it.getType() == 1 || it.getType() == 10) {
                    result[0] = it;
                    stopChange = true;
                } else {
                    if (!stopChange) {
                        result[0] = it;
                    }
                    if (it.getType() == 2) {
                        result[1] = it;
                    }
                }
            }
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyWatchPointOnDragging(final boolean fromUser) {
        if (getWatchPoints() == null) {
            return;
        }
        this.mWatchPointObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda13
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((WatchPointObserver) obj).onDraggingListener(fromUser);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public ViewProgressDetail getViewProgressDetail() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getViewProgressDetail();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        this.mInteractContainer = new ChronosInteractContainer(playerContainer);
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        setInteractContainer(chronosInteractContainer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        registerDanmakuVisibleObserver(this.mDanmakuVisibleObserver);
        tryRestoreDanmakuPlayer(bundle);
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.onStart();
        PlayerContainerKt.getPlayDirector(playerContainer).addVideoDirectorObserver(this.mVideoPlayEventListener);
        playerContainer.getPlayerCoreService().addRenderStartObserver(this.mRenderStartObserver);
        playerContainer.getPlayerCoreService().addMediaCenterObserver(this.mMediaCenterObserver);
        playerContainer.getPlayerCoreService().addMediaResourceObserver(this.mMediaResourceObserver);
        playerContainer.getPlayerCoreService().registerState(this.mPlayerStateObserver, 3, 6);
        playerContainer.getControlContainerService().registerControlContainerVisible(this.mControlContainerVisibleObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        playerContainer2.getPlayerSettingService().addPlayerSettingChangeObserver(this.mPlayerSettingsObserver, DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST);
        playerContainer.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(SeekService.class), this.mSeekServiceClient);
        SeekService $this$onStart_u24lambda_u240 = this.mSeekServiceClient.getService();
        if ($this$onStart_u24lambda_u240 != null) {
            $this$onStart_u24lambda_u240.registerPlayerProgressObserver(this.mPlayerProgressObserver);
            $this$onStart_u24lambda_u240.registerDraggingProgress(this.mDraggingProgressObserver);
        }
        if (!DeviceDecision.INSTANCE.getBoolean("player.disable_send_rendered_frame", true)) {
            playerContainer.getRenderContainerService().setFrameRenderedListener(new Function1() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit onStart$lambda$1;
                    onStart$lambda$1 = InteractLayerService.onStart$lambda$1(InteractLayerService.this, (FrameRenderedInfo) obj);
                    return onStart$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStart$lambda$1(InteractLayerService this$0, FrameRenderedInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ChronosInteractContainer chronosInteractContainer = this$0.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.onIJKFrameRendered(it, this$0.mIsHdrResource);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.onAttachByShared(bundle);
        tryRestoreDanmakuPlayer(bundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        DanmakuLogger.INSTANCE.logService("interact service stop");
        this.pendingDanmakuVisible = null;
        unregisterDanmakuVisibleObserver(this.mDanmakuVisibleObserver);
        playerContainer.getControlContainerService().unregisterControlContainerVisible(this.mControlContainerVisibleObserver);
        this.mDanmakuSeniorModeChangeObserverList.clear();
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        IChronosInteractContainer.CC.releaseChronos$default(chronosInteractContainer, false, 1, null);
        ChronosInteractContainer chronosInteractContainer2 = this.mInteractContainer;
        if (chronosInteractContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer2 = null;
        }
        chronosInteractContainer2.onStop();
        ChronosShareManager.INSTANCE.clear();
        playerContainer.getPlayerCoreService().removeRenderStartObserver(this.mRenderStartObserver);
        PlayerContainerKt.getPlayDirector(playerContainer).removeVideoDirectorObserver(this.mVideoPlayEventListener);
        playerContainer.getPlayerCoreService().removeMediaCenterObserver(this.mMediaCenterObserver);
        playerContainer.getPlayerCoreService().removeMediaResourceObserver(this.mMediaResourceObserver);
        playerContainer.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
        playerContainer.getControlContainerService().unregisterControlContainerVisible(this.mControlContainerVisibleObserver);
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        playerContainer2.getPlayerSettingService().removePlayerSettingChangeObserver(this.mPlayerSettingsObserver);
        playerContainer.getPlayerServiceManager().unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(SeekService.class), this.mSeekServiceClient);
        SeekService $this$onStop_u24lambda_u240 = this.mSeekServiceClient.getService();
        if ($this$onStop_u24lambda_u240 != null) {
            $this$onStop_u24lambda_u240.unregisterPlayerProgressObserver(this.mPlayerProgressObserver);
            $this$onStop_u24lambda_u240.unregisterDraggingProgress(this.mDraggingProgressObserver);
        }
        this.mPlayerCardStatusSyncListener = null;
        this.mPlayerCardStatusSyncFromPlayerListener = null;
    }

    private final DanmakuSwitchParams createDanmakuSwitchParams() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        IPlayerSettingService settingsService = playerContainer.getPlayerSettingService();
        DanmakuSwitchParams params = new DanmakuSwitchParams(settingsService);
        params.setInlineDanmakuSwitch$biliplayerv2_debug(settingsService.getBoolean(DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH, true));
        return params;
    }

    private final DanmakuParams createDanmakuParams() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        IPlayerSettingService settingService = playerContainer.getPlayerSettingService();
        DanmakuParams danmakuParams = new DanmakuParams();
        danmakuParams.setDanmakuMonospaced(settingService.getCloudConfig().enableDanmakuMonospaced());
        danmakuParams.setDanmakuTextStyle(settingService.getInt(DanmakuKeys.KEY_DANMAKU_TEXT_STYLE, -1));
        danmakuParams.setDanmakuTextStyleBold(true);
        danmakuParams.setDanmakuStorkeWidthScaling(settingService.getFloat(DanmakuKeys.KEY_DANMAKU_STROKE_WIDTH_SCALING, 0.8f));
        danmakuParams.setDanmakuRecommandEnable(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH, true));
        danmakuParams.setDanmakuBlockLevelV2(settingService.getInt(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2, 1));
        Integer num = getAiBlockLevelMap().get(Integer.valueOf(danmakuParams.getDanmakuBlockLevelV2()));
        danmakuParams.setDanmakuBlockLevel(num != null ? num.intValue() : 3);
        danmakuParams.setDanmakuDuplicateMerging(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, false));
        danmakuParams.setDanmakuBlockTop(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKTOP, false));
        danmakuParams.setDanmakuBlockBottom(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM, false));
        danmakuParams.setDanmakuBlockScroll(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, false));
        danmakuParams.setDanmakuBlockColorful(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, false));
        danmakuParams.setDanmakuBlockSpecial(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, false));
        danmakuParams.setDanmakuTextSizeScaleFactor(settingService.getFloat(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, 1.0f));
        danmakuParams.setDanmakuAlphaFactor(settingService.getFloat(DanmakuKeys.PREF_DANMAKU_OPACITY, 0.8f));
        danmakuParams.setDanmakuScreenDomain(settingService.getFloat(DanmakuKeys.PREF_DANMAKU_DOMAIN, 1.0f));
        danmakuParams.setDanmakuDuration(ensureDanmakuSpeed(settingService.getFloat(DanmakuKeys.PREF_DANMAKU_SPEED, 7.0f)));
        danmakuParams.setDanmakuDisplayDomain(settingService.getFloat(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN, 0.25f));
        danmakuParams.setDanmakuDensity(settingService.getInt(DanmakuKeys.PREF_DANMAKU_DENSITY, 0));
        danmakuParams.setEnableDanmakuFold(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_FOLD, true));
        danmakuParams.setDanmakuBlockFixed(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED, false));
        danmakuParams.setDanmakuAvoidScript(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT, false));
        danmakuParams.setDanmakuAvoidFigure(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE, true));
        danmakuParams.setDanmakuBlackWordsEnable(settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true));
        return danmakuParams;
    }

    private final float ensureDanmakuSpeed(float speed) {
        if (speed == 0.45f) {
            return 4.0f;
        }
        if (speed == 0.65f) {
            return 5.5f;
        }
        if (speed == 0.9f) {
            return 7.0f;
        }
        if (speed == 1.3f) {
            return 8.5f;
        }
        if (speed == 1.6f) {
            return 10.0f;
        }
        return speed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncDanmakuSwitchKVO(boolean visible) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_SWITCH, visible);
        PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_SWITCH, new PlayerKVOService.DanmakuSwitchReqParams(visible, !getDanmakuSwitchParams().getDanmakuSwitch()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncInlineDanmakuSwitchKVO(boolean visible) {
        getDanmakuSwitchParams().setInlineDanmakuSwitch$biliplayerv2_debug(visible);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH, visible);
        PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH, Boolean.valueOf(visible));
    }

    private final void updateDanmakuSeniorModeSwitch() {
        int i;
        DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
        DanmuPlayerViewConfig config = dmViewReply != null ? dmViewReply.getPlayerConfig() : null;
        if (config != null && config.hasDanmukuPlayerConfig()) {
            i = config.getDanmukuPlayerConfig().getPlayerDanmakuSeniorModeSwitch();
        } else {
            i = 0;
        }
        this.mSeniorModeSwitch = i;
    }

    /* compiled from: InteractLayerService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$SubtitleKeyConfig;", "", "keySubtitleSwitchOn", "", "keySubtitleLanMain", "keySubtitleLanVice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKeySubtitleSwitchOn", "()Ljava/lang/String;", "getKeySubtitleLanMain", "getKeySubtitleLanVice", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubtitleKeyConfig {
        private final String keySubtitleLanMain;
        private final String keySubtitleLanVice;
        private final String keySubtitleSwitchOn;

        public SubtitleKeyConfig() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SubtitleKeyConfig copy$default(SubtitleKeyConfig subtitleKeyConfig, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitleKeyConfig.keySubtitleSwitchOn;
            }
            if ((i & 2) != 0) {
                str2 = subtitleKeyConfig.keySubtitleLanMain;
            }
            if ((i & 4) != 0) {
                str3 = subtitleKeyConfig.keySubtitleLanVice;
            }
            return subtitleKeyConfig.copy(str, str2, str3);
        }

        public final String component1() {
            return this.keySubtitleSwitchOn;
        }

        public final String component2() {
            return this.keySubtitleLanMain;
        }

        public final String component3() {
            return this.keySubtitleLanVice;
        }

        public final SubtitleKeyConfig copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "keySubtitleSwitchOn");
            Intrinsics.checkNotNullParameter(str2, "keySubtitleLanMain");
            Intrinsics.checkNotNullParameter(str3, "keySubtitleLanVice");
            return new SubtitleKeyConfig(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubtitleKeyConfig) {
                SubtitleKeyConfig subtitleKeyConfig = (SubtitleKeyConfig) obj;
                return Intrinsics.areEqual(this.keySubtitleSwitchOn, subtitleKeyConfig.keySubtitleSwitchOn) && Intrinsics.areEqual(this.keySubtitleLanMain, subtitleKeyConfig.keySubtitleLanMain) && Intrinsics.areEqual(this.keySubtitleLanVice, subtitleKeyConfig.keySubtitleLanVice);
            }
            return false;
        }

        public int hashCode() {
            return (((this.keySubtitleSwitchOn.hashCode() * 31) + this.keySubtitleLanMain.hashCode()) * 31) + this.keySubtitleLanVice.hashCode();
        }

        public String toString() {
            String str = this.keySubtitleSwitchOn;
            String str2 = this.keySubtitleLanMain;
            return "SubtitleKeyConfig(keySubtitleSwitchOn=" + str + ", keySubtitleLanMain=" + str2 + ", keySubtitleLanVice=" + this.keySubtitleLanVice + ")";
        }

        public SubtitleKeyConfig(String keySubtitleSwitchOn, String keySubtitleLanMain, String keySubtitleLanVice) {
            Intrinsics.checkNotNullParameter(keySubtitleSwitchOn, "keySubtitleSwitchOn");
            Intrinsics.checkNotNullParameter(keySubtitleLanMain, "keySubtitleLanMain");
            Intrinsics.checkNotNullParameter(keySubtitleLanVice, "keySubtitleLanVice");
            this.keySubtitleSwitchOn = keySubtitleSwitchOn;
            this.keySubtitleLanMain = keySubtitleLanMain;
            this.keySubtitleLanVice = keySubtitleLanVice;
        }

        public /* synthetic */ SubtitleKeyConfig(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? DanmakuKeys.KEY_DANMAKU_SUBTITLE_SWITCH_ON : str, (i & 2) != 0 ? DanmakuKeys.KEY_DANMAKU_SUBTITLE_LAN_MAIN : str2, (i & 4) != 0 ? DanmakuKeys.KEY_DANMAKU_SUBTITLE_LAN_VICE : str3);
        }

        public final String getKeySubtitleSwitchOn() {
            return this.keySubtitleSwitchOn;
        }

        public final String getKeySubtitleLanMain() {
            return this.keySubtitleLanMain;
        }

        public final String getKeySubtitleLanVice() {
            return this.keySubtitleLanVice;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void putSubtitleKeyConfig(SubtitleKeyConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.subtitleKeyConfig = config;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public SubtitleKeyConfig getSubtitleKeyConfig() {
        return this.subtitleKeyConfig;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean bilingualSwitchEnabled() {
        return this.bilingualSwitchEnabled;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void enableBilingualSwitch(boolean enable) {
        this.bilingualSwitchEnabled = enable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x014f, code lost:
        if (r2.getPlayerSettingService().getBoolean(r13.subtitleKeyConfig.getKeySubtitleSwitchOn(), false) == false) goto L90;
     */
    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SubtitleItem chooseMainSubtitle(boolean force) {
        Object element$iv;
        boolean z;
        DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
        SubtitleItem subtitleItem = null;
        if ((dmViewReply != null && dmViewReply.hasSubtitle()) && isSubtitleAvailable()) {
            DmViewReply dmViewReply2 = getDanmakuParams().getDmViewReply();
            VideoSubtitle subtitles = dmViewReply2 != null ? dmViewReply2.getSubtitle() : null;
            Intrinsics.checkNotNull(subtitles);
            List subtitlesList = subtitles.getSubtitlesList();
            if (subtitlesList == null || subtitlesList.isEmpty()) {
                this.mMainSubtitle = null;
                return null;
            }
            if (force) {
                DmViewReply dmViewReply3 = getDanmakuParams().getDmViewReply();
                VideoSubtitle subtitle = dmViewReply3 != null ? dmViewReply3.getSubtitle() : null;
                Intrinsics.checkNotNull(subtitle);
                Iterable subtitlesList2 = subtitle.getSubtitlesList();
                Intrinsics.checkNotNullExpressionValue(subtitlesList2, "getSubtitlesList(...)");
                Iterable $this$firstOrNull$iv = subtitlesList2;
                Iterator it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        SubtitleItem it2 = (SubtitleItem) element$iv;
                        if (it2.getRole() == SubtitleRole.Main) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                SubtitleItem forceSelectedMainSubtitle = (SubtitleItem) element$iv;
                if (forceSelectedMainSubtitle != null) {
                    this.mMainSubtitle = forceSelectedMainSubtitle;
                    return this.mMainSubtitle;
                }
            }
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            if (!playerContainer.getPlayerSettingService().getBoolean(this.subtitleKeyConfig.getKeySubtitleSwitchOn(), true)) {
                this.mMainSubtitle = null;
                return null;
            }
            PlayerContainer playerContainer2 = this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer2 = null;
            }
            String subtitle2 = playerContainer2.getPlayerSettingService().getString(this.subtitleKeyConfig.getKeySubtitleLanMain(), "");
            if (subtitle2.length() > 0) {
                List $this$indexOfFirst$iv = subtitles.getSubtitlesList();
                Intrinsics.checkNotNullExpressionValue($this$indexOfFirst$iv, "getSubtitlesList(...)");
                int index$iv = 0;
                Iterator it3 = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object item$iv = it3.next();
                        SubtitleItem it4 = (SubtitleItem) item$iv;
                        if (Intrinsics.areEqual(it4.getLan(), subtitle2)) {
                            break;
                        }
                        index$iv++;
                    } else {
                        index$iv = -1;
                        break;
                    }
                }
                int subtitlePos = index$iv;
                if (subtitlePos == -1) {
                    DanmakuSubtitleHelper danmakuSubtitleHelper = DanmakuSubtitleHelper.INSTANCE;
                    SubtitleItem subtitleItem2 = this.mPlayerContainer;
                    if (subtitleItem2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        subtitleItem = subtitleItem2;
                    }
                    subtitleItem = danmakuSubtitleHelper.choseLocalSubtitleLan(subtitleItem, subtitles);
                } else {
                    subtitleItem = DanmakuSubtitleHelper.INSTANCE.choseSubtitleByLanguage(((SubtitleItem) subtitles.getSubtitlesList().get(subtitlePos)).getLan(), subtitles);
                }
            } else {
                if (DanmakuSubtitleHelper.INSTANCE.isAssistAISubtitleVideo(subtitles.getSubtitlesList())) {
                    PlayerContainer playerContainer3 = this.mPlayerContainer;
                    if (playerContainer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer3 = null;
                    }
                }
                DanmakuSubtitleHelper danmakuSubtitleHelper2 = DanmakuSubtitleHelper.INSTANCE;
                SubtitleItem subtitleItem3 = this.mPlayerContainer;
                if (subtitleItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    subtitleItem = subtitleItem3;
                }
                subtitleItem = danmakuSubtitleHelper2.choseLocalSubtitleLan(subtitleItem, subtitles);
            }
        }
        SubtitleItem mainSubtitle = subtitleItem;
        this.mMainSubtitle = mainSubtitle;
        return mainSubtitle;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public SubtitleItem chooseViceSubtitle(boolean force) {
        Object element$iv;
        boolean z;
        DmViewReply dmReply = getDanmakuParams().getDmViewReply();
        DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
        SubtitleItem viceSubtitle = null;
        VideoSubtitle subtitles = dmViewReply != null ? dmViewReply.getSubtitle() : null;
        if (this.bilingualSwitchEnabled) {
            if (dmReply == null || subtitles == null || subtitles.getSubtitlesList() == null || subtitles.getSubtitlesList().isEmpty()) {
                this.mViceSubtitle = null;
                return null;
            }
            if (force) {
                DmViewReply dmViewReply2 = getDanmakuParams().getDmViewReply();
                VideoSubtitle subtitle = dmViewReply2 != null ? dmViewReply2.getSubtitle() : null;
                Intrinsics.checkNotNull(subtitle);
                Iterable subtitlesList = subtitle.getSubtitlesList();
                Intrinsics.checkNotNullExpressionValue(subtitlesList, "getSubtitlesList(...)");
                Iterable $this$firstOrNull$iv = subtitlesList;
                Iterator it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        SubtitleItem it2 = (SubtitleItem) element$iv;
                        if (it2.getRole() == SubtitleRole.Secondary) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                SubtitleItem forceSelectedViceSubtitle = (SubtitleItem) element$iv;
                if (forceSelectedViceSubtitle != null) {
                    this.mViceSubtitle = forceSelectedViceSubtitle;
                    return this.mViceSubtitle;
                }
            }
            if (dmReply.hasSubtitle() && isSubtitleAvailable() && bilingualSwitchOn()) {
                if (subtitles.getSubtitlesList().size() < 2) {
                    this.mViceSubtitle = null;
                    return null;
                }
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                String subtitle2 = playerContainer.getPlayerSettingService().getString(this.subtitleKeyConfig.getKeySubtitleLanVice(), "");
                int subtitlePos = -1;
                if (subtitle2.length() > 0) {
                    List $this$indexOfFirst$iv = subtitles.getSubtitlesList();
                    Intrinsics.checkNotNullExpressionValue($this$indexOfFirst$iv, "getSubtitlesList(...)");
                    int index$iv = 0;
                    Iterator it3 = $this$indexOfFirst$iv.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object item$iv = it3.next();
                            SubtitleItem it4 = (SubtitleItem) item$iv;
                            if (Intrinsics.areEqual(it4.getLan(), subtitle2)) {
                                break;
                            }
                            index$iv++;
                        } else {
                            index$iv = -1;
                            break;
                        }
                    }
                    int subtitlePos2 = index$iv;
                    if (subtitlePos2 == -1) {
                        List $this$indexOfFirst$iv2 = subtitles.getSubtitlesList();
                        Intrinsics.checkNotNullExpressionValue($this$indexOfFirst$iv2, "getSubtitlesList(...)");
                        int index$iv2 = 0;
                        Iterator it5 = $this$indexOfFirst$iv2.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            Object item$iv2 = it5.next();
                            SubtitleItem it6 = (SubtitleItem) item$iv2;
                            String lan = it6.getLan();
                            SubtitleItem subtitleItem = this.mMainSubtitle;
                            if (!Intrinsics.areEqual(lan, subtitleItem != null ? subtitleItem.getLan() : null)) {
                                subtitlePos = index$iv2;
                                break;
                            }
                            index$iv2++;
                        }
                        subtitlePos2 = subtitlePos;
                    }
                    viceSubtitle = DanmakuSubtitleHelper.INSTANCE.choseSubtitleByLanguage(((SubtitleItem) subtitles.getSubtitlesList().get(subtitlePos2)).getLan(), subtitles);
                } else {
                    List $this$indexOfFirst$iv3 = subtitles.getSubtitlesList();
                    Intrinsics.checkNotNullExpressionValue($this$indexOfFirst$iv3, "getSubtitlesList(...)");
                    int index$iv3 = 0;
                    Iterator it7 = $this$indexOfFirst$iv3.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            break;
                        }
                        Object item$iv3 = it7.next();
                        SubtitleItem it8 = (SubtitleItem) item$iv3;
                        String lan2 = it8.getLan();
                        SubtitleItem subtitleItem2 = this.mMainSubtitle;
                        if (!Intrinsics.areEqual(lan2, subtitleItem2 != null ? subtitleItem2.getLan() : null)) {
                            subtitlePos = index$iv3;
                            break;
                        }
                        index$iv3++;
                    }
                    viceSubtitle = DanmakuSubtitleHelper.INSTANCE.choseSubtitleByLanguage(((SubtitleItem) subtitles.getSubtitlesList().get(subtitlePos)).getLan(), subtitles);
                }
            }
            this.mViceSubtitle = viceSubtitle;
            return viceSubtitle;
        }
        return null;
    }

    private final void reportSubtitleLan() {
        VideoSubtitle subtitle;
        int subtitlesCount;
        String bilingualStatus;
        String lanCode;
        String aiStatus;
        String type;
        PlayerContainer playerContainer;
        DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
        if (dmViewReply == null || (subtitle = dmViewReply.getSubtitle()) == null || (subtitlesCount = subtitle.getSubtitlesCount()) == 0) {
            return;
        }
        boolean bilingualSwitchOn = bilingualSwitchOn();
        if (bilingualSwitchOn) {
            bilingualStatus = "1";
        } else {
            bilingualStatus = "0";
        }
        SubtitleItem mainSubtitle = this.mMainSubtitle;
        SubtitleItem viceSubtitle = this.mViceSubtitle;
        if (!bilingualSwitchOn || subtitlesCount == 1) {
            String lanCode2 = (mainSubtitle == null || (r10 = mainSubtitle.getLan()) == null) ? "0" : "0";
            String aiStatus2 = String.valueOf(mainSubtitle != null ? mainSubtitle.getAiStatus() : null);
            String type2 = String.valueOf(mainSubtitle != null ? mainSubtitle.getType() : null);
            lanCode = lanCode2;
            aiStatus = aiStatus2;
            type = type2;
        } else {
            String lanCode3 = (mainSubtitle != null ? mainSubtitle.getLan() : null) + "," + (viceSubtitle != null ? viceSubtitle.getLan() : null);
            String aiStatus3 = (mainSubtitle != null ? mainSubtitle.getAiStatus() : null) + "," + (viceSubtitle != null ? viceSubtitle.getAiStatus() : null);
            String type3 = (mainSubtitle != null ? mainSubtitle.getType() : null) + "," + (viceSubtitle != null ? viceSubtitle.getType() : null);
            lanCode = lanCode3;
            aiStatus = aiStatus3;
            type = type3;
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        boolean bigSubtitlesStatus = playerContainer2.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_LARGE, false);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        } else {
            playerContainer = playerContainer3;
        }
        playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_neuron_subtitle_language, "language_code", lanCode, "bilingual_subtitles_status", bilingualStatus, LoginSceneProcessor.SCENE_KEY, "1", "type", type, "aiStatus", aiStatus, "bigSubtitlesStatus", bigSubtitlesStatus ? "1" : "0"));
    }

    private final void dispatchDanmakuParamsChanged() {
        final DanmakuParams params = getDanmakuParams();
        this.mDanmakuParamsChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda5
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IDanmakuParamsChangeObserver) obj).onChanged(DanmakuParams.this);
            }
        });
    }

    private final boolean checkOptionFixedOrDisable(DanmakuConfig.DanmakuOptionName name) {
        if (this.mDisableDanmakuOptions.contains(name) || this.mFixedDanmakuOptions.contains(name)) {
            return true;
        }
        return false;
    }

    private final boolean bilingualSwitchOn() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        return playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_MULTI, false);
    }

    private final void notifyDanmakuSettingsChanged(final DanmakuConfig.DanmakuOptionName name) {
        final DanmakuParams params = getDanmakuParams();
        this.mDanmakuSettingsChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda4
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IDanmakuSettingsChangedObserver) obj).onParamChanged(DanmakuConfig.DanmakuOptionName.this, params);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService, tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public boolean sendDanmaku(Context context, DanmakuSendParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Long l = this.mSendScene;
        if (l != null) {
            l.longValue();
            return sendDanmakuV2(context, params);
        }
        InteractLayerService $this$sendDanmaku_u24lambda_u241 = this;
        IDanmakuSender danmakuSender = $this$sendDanmaku_u24lambda_u241.getDanmakuSender();
        PlayerContainer playerContainer = $this$sendDanmaku_u24lambda_u241.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        return danmakuSender.send(playerContainer, context, params);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService, tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public boolean sendDanmakuV2(Context context, DanmakuSendParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Long l = this.mSendScene;
        if (l != null) {
            long it = l.longValue();
            IDanmakuSender danmakuSender = getDanmakuSender();
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            return danmakuSender.sendV2(playerContainer, context, params, Long.valueOf(it));
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService, tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public boolean sendCommandDanmaku(Context context, int type, Map<String, ? extends Object> map) {
        Map content = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(content, "content");
        IDanmakuSender danmakuSender = getDanmakuSender();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        return danmakuSender.sendCommandDanmaku(playerContainer, context, type, content, this.mSendScene);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setInlineMode(boolean isInline) {
        this.mIsInlineMode = isInline;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isInlineMode() {
        return this.mIsInlineMode;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDmViewReply(final DmViewReply reply) {
        SubtitleItem viceSubtitle;
        PlayerLog.i(TAG, "setDmViewReply");
        getDanmakuParams().setDmViewReply(reply);
        PlayerContainer playerContainer = null;
        if (reply == null) {
            loadSubtitle(null, null);
            PlayerContainer playerContainer2 = this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer = playerContainer2;
            }
            boolean showLocal = playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.PREF_DANMAKU_SWITCH, true);
            if (showLocal) {
                showDanmaku(false);
            } else {
                hideDanmaku(false);
            }
            dispatchDanmakuParamsChanged();
            return;
        }
        if (reply.hasCommand()) {
            Command command = reply.getCommand();
            setCommandDanmaku(command != null ? command.getCommandDmsList() : null);
        }
        if (ConfigManager.Companion.isHitFF("player.damaku.senior.mode")) {
            updateDanmakuSeniorModeSwitch();
            this.mDanmakuSeniorModeChangeObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda2
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    InteractLayerService.setDmViewReply$lambda$0(InteractLayerService.this, (IDanmakuSeniorModeChangeObserver) obj);
                }
            });
        }
        getDanmakuSwitchParams().setDmviewReply(reply);
        HandlerThreads.post(1, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                InteractLayerService.setDmViewReply$lambda$1(InteractLayerService.this, reply);
            }
        });
        PlayerKVOService playerKVOService = PlayerKVOService.INSTANCE;
        DanmuPlayerViewConfig playerConfig = reply.getPlayerConfig();
        Intrinsics.checkNotNullExpressionValue(playerConfig, "getPlayerConfig(...)");
        playerKVOService.applyKVOToLocal(playerConfig, this, this.mSwitchRestoredFromShared);
        this.mSwitchRestoredFromShared = false;
        SharedSubtitle sharedSubtitle = this.mSharedSubtitle;
        if (this.mSubtitleStateShareEnable && sharedSubtitle != null) {
            SubtitleItem mainShareSubtitle = sharedSubtitle.getMain();
            SubtitleItem viceShareSubtitle = sharedSubtitle.getVice();
            VideoSubtitle subtitleList = reply.getSubtitle();
            SubtitleItem mainSubtitle = DanmakuSubtitleHelper.INSTANCE.containsSubtitle(subtitleList, mainShareSubtitle);
            if (mainSubtitle != null) {
                viceSubtitle = DanmakuSubtitleHelper.INSTANCE.containsSubtitle(subtitleList, viceShareSubtitle);
            } else {
                viceSubtitle = null;
            }
            loadSubtitle(mainSubtitle, viceSubtitle);
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer3 = null;
            }
            String subtitle = playerContainer3.getPlayerSettingService().getString(this.subtitleKeyConfig.getKeySubtitleLanMain(), "");
            if (subtitle.length() > 0) {
                IInteractLayerService.CC.recordSelectedSubtitle$default(this, true, false, 2, null);
            }
        } else {
            loadSubtitle(chooseMainSubtitle(true), chooseViceSubtitle(true));
        }
        this.mSharedSubtitle = null;
        dispatchDanmakuParamsChanged();
        Runnable runnable = this.pendingDanmakuVisible;
        if (runnable != null) {
            runnable.run();
        }
        this.pendingDanmakuVisible = null;
        if (this.mMainSubtitle != null) {
            reportSubtitleLan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDmViewReply$lambda$0(InteractLayerService this$0, IDanmakuSeniorModeChangeObserver it) {
        it.onSwitchChange(this$0.mSeniorModeSwitch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDmViewReply$lambda$1(InteractLayerService this$0, DmViewReply $reply) {
        DanmakuReportHelper danmakuReportHelper = DanmakuReportHelper.INSTANCE;
        PlayerContainer playerContainer = this$0.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        danmakuReportHelper.reportAllDanmakuSetting(playerContainer, this$0.getDanmakuParams(), 1);
        PlayerLog.i(TAG, "setDmViewReply " + $reply.getPlayerConfig().getDanmukuPlayerConfig());
    }

    private final void setCommandDanmaku(List<CommandDm> list) {
        List<CommandDm> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List list3 = new ArrayList();
        List<CommandDm> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            CommandDm it = (CommandDm) element$iv;
            CommandsDanmaku commandDm = new CommandsDanmaku();
            commandDm.setId(it.getId());
            commandDm.setOid(it.getOid());
            commandDm.setMid(it.getMid());
            commandDm.setCommand(it.getCommand());
            commandDm.setContent(it.getContent());
            commandDm.setProgress(it.getProgress());
            commandDm.setCtime(it.getCtime());
            commandDm.setMtime(it.getMtime());
            commandDm.setExtra(it.getExtra());
            commandDm.setIdStr(it.getIdstr());
            list3.add(commandDm);
        }
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        IRemoteHandler remoteHandler = chronosInteractContainer.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.setCommandDanmakus(list3);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean startFromShared(Video.DanmakuResolveParams danmakuResolveParams) {
        if (isDanmakuEnable()) {
            if (isDanmakuVisible()) {
                showDanmaku(false);
            } else {
                hideDanmaku(false);
            }
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void bindDanmakuContainer(FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.bindChronosContainer(container);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isDanmakuForbidden() {
        DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
        if (dmViewReply != null) {
            return dmViewReply.getClosed();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void clearChronosPackage() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.clearChronosPackage();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void clearDanmaku() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.onWorkInfoChange("0", "0");
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void runPackageForLive(ChronosPackage pkg) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.runPackageForLive(pkg);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isChronosValid() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.isChronosValid();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public DanmakuParams getDanmakuParams() {
        DanmakuParams danmakuParams = this.mDanmakuParams;
        if (danmakuParams == null) {
            DanmakuParams $this$getDanmakuParams_u24lambda_u240 = createDanmakuParams();
            this.mDanmakuParams = $this$getDanmakuParams_u24lambda_u240;
            return $this$getDanmakuParams_u24lambda_u240;
        }
        return danmakuParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public DanmakuSwitchParams getDanmakuSwitchParams() {
        DanmakuSwitchParams danmakuSwitchParams = this.mDanmakuSwitchParams;
        if (danmakuSwitchParams == null) {
            DanmakuSwitchParams $this$getDanmakuSwitchParams_u24lambda_u240 = createDanmakuSwitchParams();
            this.mDanmakuSwitchParams = $this$getDanmakuSwitchParams_u24lambda_u240;
            return $this$getDanmakuSwitchParams_u24lambda_u240;
        }
        return danmakuSwitchParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setVisibleRect(DanmakuConfigChange.VisibleRect visibleRect) {
        Intrinsics.checkNotNullParameter(visibleRect, "visibleRect");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        ChronosInteractContainer chronosInteractContainer2 = null;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        ILocalHandler localHandler = chronosInteractContainer.getLocalHandler();
        if (localHandler != null) {
            localHandler.setVisibleRect(visibleRect);
        }
        ChronosInteractContainer chronosInteractContainer3 = this.mInteractContainer;
        if (chronosInteractContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
        } else {
            chronosInteractContainer2 = chronosInteractContainer3;
        }
        IRemoteHandler remoteHandler = chronosInteractContainer2.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.setVisibleRect(visibleRect);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public ChronosInteractContainer getChronosInteractContainer() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            return null;
        }
        return chronosInteractContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean getSegmentSwitchVisibility() {
        ChronosThumbnailInfo thumbnailInfo;
        ChronosThumbnailInfo thumbnailInfo2;
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        ChronosInteractContainer chronosInteractContainer2 = null;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        if (chronosInteractContainer.hasThumbnails2()) {
            ChronosInteractContainer chronosInteractContainer3 = this.mInteractContainer;
            if (chronosInteractContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            } else {
                chronosInteractContainer2 = chronosInteractContainer3;
            }
            ThumbnailLoader2 thumbnailFetcher2 = chronosInteractContainer2.getThumbnailFetcher2();
            if (thumbnailFetcher2 == null || (thumbnailInfo2 = thumbnailFetcher2.getThumbnailInfo()) == null) {
                return false;
            }
            return thumbnailInfo2.getSegmentSwitchVisibility();
        }
        ChronosInteractContainer chronosInteractContainer4 = this.mInteractContainer;
        if (chronosInteractContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
        } else {
            chronosInteractContainer2 = chronosInteractContainer4;
        }
        ThumbnailLoader thumbnailFetcher = chronosInteractContainer2.getThumbnailFetcher();
        if (thumbnailFetcher == null || (thumbnailInfo = thumbnailFetcher.getThumbnailInfo()) == null) {
            return false;
        }
        return thumbnailInfo.getSegmentSwitchVisibility();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSegmentSwitchValue(boolean value) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setSegmentSwitchValue(value);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean getSegmentSwitchValue() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getSegmentSwitchValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addSegmentSwitchObserver(Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.addSegmentSwitchObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeSegmentSwitchObserver(Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.removeSegmentSwitchObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setForcedChapterGuide(boolean value) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setForcedChapterGuide(value);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setEyesProtectionMode(boolean mode) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setEyesProtectionMode(mode);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void loadThumbnailIfNeed() {
        SeekService service = this.mSeekServiceClient.getService();
        boolean z = false;
        if (service != null && service.isThumbnailEnable()) {
            z = true;
        }
        if (!z) {
            return;
        }
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.loadThumbnailIfNeed();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void loadThumbnailIfNeed2() {
        SeekService service = this.mSeekServiceClient.getService();
        boolean z = false;
        if (service != null && service.isThumbnailEnable()) {
            z = true;
        }
        if (!z) {
            return;
        }
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.loadThumbnailIfNeed2();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public tv.danmaku.biliplayerv2.service.ThumbnailLoader getThumbnailFetcher() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getThumbnailFetcher();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public ThumbnailLoader2 getThumbnailFetcher2() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getThumbnailFetcher2();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean hasThumbnails() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.hasThumbnails();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean hasThumbnails2() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.hasThumbnails2();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setThumbnailEnable(boolean enable) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setThumbnailEnable(enable);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setThumbnail2Enable(boolean enable) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setThumbnail2Enable(enable);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void registerViewProgressObserver(ViewProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.registerViewProgressObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void unregisterViewProgressObserver(ViewProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.unregisterViewProgressObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setChronosVisible(boolean visible) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.getChronosContainer().setVisibility(visible ? 0 : 8);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addDanmakuInteractionObserver(DanmakuInteractionObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.addDanmakuInteractionObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeDanmakuInteractionObserver() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.removeDanmakuInteractionObserver();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public MultiDanmakuPlayer cloneMultiDanmaku(Context content, IMultiDanmakuCallback multiDanmakuCallback) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(multiDanmakuCallback, "multiDanmakuCallback");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.cloneMultiDanmaku(content, multiDanmakuCallback);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuViewOffset(float offsetY) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setDanmakuViewOffset(offsetY);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addDanmaku(String dmId, int type, Object extra) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.addDanmaku(dmId, type, extra);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addDanmaku(String dmId, int type, Object extra, Map<String, byte[]> map) {
        Map emoExtra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.addDanmaku(dmId, type, extra, emoExtra);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void registerChronosReadyCallback(OnChronosReadyCallback onChronosReadyCallback) {
        Intrinsics.checkNotNullParameter(onChronosReadyCallback, "onChronosReadyCallback");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.registerChronosReadyCallback(onChronosReadyCallback);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void unregisterChronosReadyCallback() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.unregisterChronosReadyCallback();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setThumbnailConfig(ThumbnailConfig config) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setThumbnailConfig(config);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void sendOnlineInfoDanmaku(long aid, long cid, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        CommandDanmakuSent.Request req = new CommandDanmakuSent.Request();
        req.setDanmakuId(aid + "_" + cid);
        PlayerContainer playerContainer = this.mPlayerContainer;
        ChronosInteractContainer chronosInteractContainer = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        req.setAppearanceTime(Long.valueOf(playerContainer.getPlayerCoreService().getCurrentPosition()));
        req.setCommand("#ONLINESPECIAL#");
        req.setContent(text);
        req.setExtra("{}");
        req.setVideoId(String.valueOf(aid));
        ChronosInteractContainer chronosInteractContainer2 = this.mInteractContainer;
        if (chronosInteractContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
        } else {
            chronosInteractContainer = chronosInteractContainer2;
        }
        IRemoteHandler remoteHandler = chronosInteractContainer.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.sendOnlineDanmaku(req);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setOnlineInfo(Boolean bool, long aid, long cid, String text, String logo) {
        OnlineInfoChange.Request req = new OnlineInfoChange.Request();
        req.setEnabled(bool);
        req.setWorkId(String.valueOf(aid));
        req.setVideoId(String.valueOf(cid));
        boolean z = false;
        if (text != null) {
            if (text.length() > 0) {
                z = true;
            }
        }
        if (z) {
            req.setViewerContent(text);
            req.setIconUrl(logo);
        }
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        IRemoteHandler remoteHandler = chronosInteractContainer.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.onOnlineInfoChanged(req);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public <T> void setDanmakuOptions(final DanmakuConfig.DanmakuOptionName name, T... tArr) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tArr, "value");
        if (this.mDisableDanmakuOptions.contains(name) || this.mFixedDanmakuOptions.contains(name)) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[name.ordinal()]) {
            case 1:
                if (!(tArr.length == 0) && (tArr[0] instanceof Boolean)) {
                    T t = tArr[0];
                    Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Boolean");
                    IInteractLayerService.CC.setBlockRepeat$default(this, ((Boolean) t).booleanValue(), false, 2, null);
                    break;
                }
                break;
            case 2:
                if (!(tArr.length == 0) && (tArr[0] instanceof Boolean)) {
                    T t2 = tArr[0];
                    Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Boolean");
                    IInteractLayerService.CC.setBlockTop$default(this, ((Boolean) t2).booleanValue(), false, 2, null);
                    break;
                }
                break;
            case 3:
                if (!(tArr.length == 0) && (tArr[0] instanceof Boolean)) {
                    T t3 = tArr[0];
                    Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type kotlin.Boolean");
                    IInteractLayerService.CC.setBlockScroll$default(this, ((Boolean) t3).booleanValue(), false, 2, null);
                    break;
                }
                break;
            case 4:
                if (!(tArr.length == 0) && (tArr[0] instanceof Boolean)) {
                    T t4 = tArr[0];
                    Intrinsics.checkNotNull(t4, "null cannot be cast to non-null type kotlin.Boolean");
                    IInteractLayerService.CC.setBlockBottom$default(this, ((Boolean) t4).booleanValue(), false, 2, null);
                    break;
                }
                break;
            case 5:
                if (!(tArr.length == 0) && (tArr[0] instanceof Boolean)) {
                    T t5 = tArr[0];
                    Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type kotlin.Boolean");
                    IInteractLayerService.CC.setBlockColorful$default(this, ((Boolean) t5).booleanValue(), false, 2, null);
                    break;
                }
                break;
            case 6:
                if (!(tArr.length == 0) && (tArr[0] instanceof Boolean)) {
                    T t6 = tArr[0];
                    Intrinsics.checkNotNull(t6, "null cannot be cast to non-null type kotlin.Boolean");
                    IInteractLayerService.CC.setBlockSpecial$default(this, ((Boolean) t6).booleanValue(), false, 2, null);
                    break;
                }
                break;
            case 7:
                if (!(tArr.length == 0) && (tArr[0] instanceof Float)) {
                    T t7 = tArr[0];
                    Intrinsics.checkNotNull(t7, "null cannot be cast to non-null type kotlin.Float");
                    IInteractLayerService.CC.setDanmakuOpacity$default(this, ((Float) t7).floatValue(), false, 2, null);
                    break;
                }
                break;
            case 8:
                if (!(tArr.length == 0) && (tArr[0] instanceof Float)) {
                    T t8 = tArr[0];
                    Intrinsics.checkNotNull(t8, "null cannot be cast to non-null type kotlin.Float");
                    IInteractLayerService.CC.setScaleFactor$default(this, ((Float) t8).floatValue(), false, 2, null);
                    break;
                }
                break;
            case 9:
                if (!(tArr.length == 0) && (tArr[0] instanceof Float)) {
                    T t9 = tArr[0];
                    Intrinsics.checkNotNull(t9, "null cannot be cast to non-null type kotlin.Float");
                    IInteractLayerService.CC.setDanmakuDomain$default(this, ((Float) t9).floatValue(), false, 2, null);
                    break;
                }
                break;
            case 10:
                if (!(tArr.length == 0) && (tArr[0] instanceof Float)) {
                    T t10 = tArr[0];
                    Intrinsics.checkNotNull(t10, "null cannot be cast to non-null type kotlin.Float");
                    IInteractLayerService.CC.setDanmakuSpeed$default(this, ((Float) t10).floatValue(), false, 2, null);
                    break;
                }
                break;
        }
        final DanmakuParams params = getDanmakuParams();
        this.mDanmakuSettingsChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda7
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IDanmakuSettingsChangedObserver) obj).onParamChanged(DanmakuConfig.DanmakuOptionName.this, params);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean sendUpDanmaku(Context context, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        IDanmakuSender danmakuSender = getDanmakuSender();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        return danmakuSender.sendUpDanmaku(playerContainer, context, content, this.mSendScene);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isSubtitleShowInSettingWidget() {
        return this.mSubtitleShowInSettingWidget;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSubtitleShowInSettingWidget(boolean show) {
        this.mSubtitleShowInSettingWidget = show;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public SubtitleItem getMainSubtitle() {
        return this.mMainSubtitle;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public SubtitleItem getViceSubtitle() {
        return this.mViceSubtitle;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setCustomSubtitleMargin(boolean enable) {
        this.mIsCustomSubtitleMargin = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isCustomSubtitleMargin() {
        return this.mIsCustomSubtitleMargin;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void updateSubtitleDrawRect(final int bottomFix) {
        this.mSubtitleBottomMargin = bottomFix;
        BLog.d(TAG, "mSubtitleBottomMargin set to: " + bottomFix);
        this.mSubtitleChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda16
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((ISubtitleChangedObserver) obj).onSubtitleDrawRectChanged(bottomFix);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public int getSubtitleBottomMargin() {
        return this.mSubtitleBottomMargin;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public SubtitleItem getInitViceSubtitle() {
        SubtitleItem subtitleItem = this.mViceSubtitle;
        return subtitleItem == null ? IInteractLayerService.CC.chooseViceSubtitle$default(this, false, 1, null) : subtitleItem;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void loadSubtitle(SubtitleItem mainSubtitle, SubtitleItem viceSubtitle) {
        this.mMainSubtitle = mainSubtitle;
        this.mViceSubtitle = viceSubtitle;
        this.mSubtitleChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda12
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                InteractLayerService.loadSubtitle$lambda$0(InteractLayerService.this, (ISubtitleChangedObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadSubtitle$lambda$0(InteractLayerService this$0, ISubtitleChangedObserver it) {
        it.onSubtitleChanged(this$0.mMainSubtitle, this$0.mViceSubtitle);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void recordSelectedSubtitle(boolean isShare, boolean isManual) {
        String lan;
        String lan2;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        IPlayerSettingService settingService = playerContainer.getPlayerSettingService();
        boolean isMultiOpen = this.mViceSubtitle != null;
        SubtitleItem mainSubtitle = this.mMainSubtitle;
        SubtitleItem viceSubtitle = this.mViceSubtitle;
        String str = "";
        if (isMultiOpen) {
            if (isManual && this.mMainSubtitle != null) {
                settingService.putString(this.subtitleKeyConfig.getKeySubtitleLanMain(), (mainSubtitle == null || (r9 = mainSubtitle.getLan()) == null) ? "" : "");
                String keySubtitleLanVice = this.subtitleKeyConfig.getKeySubtitleLanVice();
                if (viceSubtitle != null && (lan2 = viceSubtitle.getLan()) != null) {
                    str = lan2;
                }
                settingService.putString(keySubtitleLanVice, str);
                settingService.putBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_MULTI, true);
            }
        } else {
            if (isManual && this.mMainSubtitle != null) {
                String keySubtitleLanMain = this.subtitleKeyConfig.getKeySubtitleLanMain();
                if (mainSubtitle != null && (lan = mainSubtitle.getLan()) != null) {
                    str = lan;
                }
                settingService.putString(keySubtitleLanMain, str);
            }
            DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
            VideoSubtitle subtitle = dmViewReply != null ? dmViewReply.getSubtitle() : null;
            boolean isMultiList = (subtitle != null ? subtitle.getSubtitlesCount() : 0) > 1;
            boolean hasMatchList = DanmakuSubtitleHelper.INSTANCE.needCheckBilingualSubtitle(subtitle != null ? subtitle.getSubtitlesList() : null);
            if (!isMultiList && mainSubtitle == null && hasMatchList) {
                settingService.putBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_MULTI, false);
            }
        }
        if (isShare) {
            settingService.putBoolean(this.subtitleKeyConfig.getKeySubtitleSwitchOn(), mainSubtitle != null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void dispatchSubtitleModeChanged() {
        this.mSubtitleChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda6
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                InteractLayerService.dispatchSubtitleModeChanged$lambda$0(InteractLayerService.this, (ISubtitleChangedObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchSubtitleModeChanged$lambda$0(InteractLayerService this$0, ISubtitleChangedObserver it) {
        it.onSubtitleChanged(this$0.mMainSubtitle, this$0.mViceSubtitle);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void dispatchSubtitleDragChanged() {
        this.mSubtitleChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda8
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                InteractLayerService.dispatchSubtitleDragChanged$lambda$0(InteractLayerService.this, (ISubtitleChangedObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchSubtitleDragChanged$lambda$0(InteractLayerService this$0, ISubtitleChangedObserver it) {
        it.onSubtitleChanged(this$0.mMainSubtitle, this$0.mViceSubtitle);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void dispatchSubtitleLargeChanged() {
        this.mSubtitleChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda9
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                InteractLayerService.dispatchSubtitleLargeChanged$lambda$0(InteractLayerService.this, (ISubtitleChangedObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchSubtitleLargeChanged$lambda$0(InteractLayerService this$0, ISubtitleChangedObserver it) {
        it.onSubtitleChanged(this$0.mMainSubtitle, this$0.mViceSubtitle);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void onPreferenceChanged(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreferenceChange.Request req = new PreferenceChange.Request();
        req.setKey(key);
        req.setValue(value);
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        IRemoteHandler remoteHandler = chronosInteractContainer.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.onPreferenceChanged(req);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSubtitleAvailable(boolean available) {
        this.mSubtitleAvailable = available;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isSubtitleAvailable() {
        return this.mSubtitleAvailable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setForbidCloseSubtitle(boolean forbid) {
        this.mIsForbidCloseSubtitle = forbid;
        if (getDanmakuParams().getDmViewReply() != null) {
            SubtitleItem newSubtitleItem = IInteractLayerService.CC.chooseMainSubtitle$default(this, false, 1, null);
            if (!Intrinsics.areEqual(newSubtitleItem, this.mMainSubtitle)) {
                loadSubtitle(newSubtitleItem, null);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isForbidCloseSubtitle() {
        return this.mIsForbidCloseSubtitle;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuExposureSpmid(String spmid) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        this.mDanmakuExposureSpmid = spmid;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public Map<String, String> getDanmakuReportCommonParameters() {
        Video.DisplayParams it;
        Map $this$getDanmakuReportCommonParameters_u24lambda_u240 = MapsKt.createMapBuilder();
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        $this$getDanmakuReportCommonParameters_u24lambda_u240.put("playersessionid", playerContainer.getReporterService().getSession());
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer2).getCurrentPlayableParams();
        if (currentPlayableParams != null && (it = currentPlayableParams.getDisplayParams()) != null) {
            $this$getDanmakuReportCommonParameters_u24lambda_u240.put("avid", String.valueOf(it.getAvid()));
            $this$getDanmakuReportCommonParameters_u24lambda_u240.put("cid", String.valueOf(it.getCid()));
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(MapsKt.build($this$getDanmakuReportCommonParameters_u24lambda_u240));
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addDanmakuParamsChangedObserver(IDanmakuParamsChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuParamsChangedObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeDanmakuParamsChangedObserver(IDanmakuParamsChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuParamsChangedObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addSubtitleChangedObserver(ISubtitleChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mSubtitleChangedObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeSubtitleChangedObserver(ISubtitleChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mSubtitleChangedObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addDanmakuSettingsChangedObserver(IDanmakuSettingsChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuSettingsChangedObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeDanmakuSettingsChangedObserver(IDanmakuSettingsChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuSettingsChangedObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public DanmakuInputClickInterceptor getDanmakuInputClickInterceptor() {
        return this.mDanmakuInputClickInterceptor;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuInputClickInterceptor(DanmakuInputClickInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.mDanmakuInputClickInterceptor = interceptor;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuMonopolizeTap(boolean value) {
        this.mMonopolizeTap = value;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSceneAndBizParams(ChronosScene scene, ChronosBiz biz) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        Intrinsics.checkNotNullParameter(biz, "biz");
        BLog.d(TAG, "setSceneAndBizParams scene:" + scene + " biz:" + biz);
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setSceneAndBizParams(scene, biz);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void reportDanmaku(String danmakuId, String reason, boolean shieldUser, String shieldUserId, String oid, boolean needReportAndGetBlockData, boolean blockUser, GeneralResponse<String> generalResponse, String dmContent) {
        Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.reportDanmaku(danmakuId, reason, shieldUser, shieldUserId, oid, needReportAndGetBlockData, blockUser, generalResponse, dmContent);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.addDanmakuCommandPanelsObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.removeDanmakuCommandPanelsObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void appendFilters(String shieldUserId, String regexFilter, Long nativeId, Runnable onSuccess) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        IRemoteHandler remoteHandler = chronosInteractContainer.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.appendFilters(shieldUserId, regexFilter, nativeId, onSuccess);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setChronosEnable(boolean enable) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.setChronosEnable(enable);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void reloadViewProgress(FragmentParam fragmentParam, long fragmentOffset, boolean simplify, Map<String, String> map) {
        Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(extra, "extra");
        if (getAutomaticViewProgressRequestDisabled()) {
            ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
            if (chronosInteractContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer = null;
            }
            if (chronosInteractContainer.isChronosValid()) {
                this.mPendingAutomaticViewProgressRequest = false;
                ChronosInteractContainer chronosInteractContainer2 = this.mInteractContainer;
                if (chronosInteractContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                    chronosInteractContainer2 = null;
                }
                chronosInteractContainer2.loadViewProgress(fragmentParam, fragmentOffset, simplify, extra);
                return;
            }
            this.mPendingAutomaticViewProgressRequest = true;
            return;
        }
        ChronosInteractContainer chronosInteractContainer3 = this.mInteractContainer;
        if (chronosInteractContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer3 = null;
        }
        chronosInteractContainer3.loadViewProgress(fragmentParam, fragmentOffset, simplify, extra);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void loadCommandPanel() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.loadCommandPanel();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void syncStandardCardStatus(int type, long activityId, long reserveId, boolean status) {
        PlayerCardStatusSyncListener playerCardStatusSyncListener = this.mPlayerCardStatusSyncListener;
        if (playerCardStatusSyncListener != null) {
            playerCardStatusSyncListener.syncPlayerCardStatus(type, activityId, reserveId, status);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void syncStandardCardStatusFromPlayer(int type, long id, boolean status) {
        PlayerCardStatusSyncFromPlayerListener playerCardStatusSyncFromPlayerListener = this.mPlayerCardStatusSyncFromPlayerListener;
        if (playerCardStatusSyncFromPlayerListener != null) {
            playerCardStatusSyncFromPlayerListener.syncPlayerCardStatusFromPlayer(type, id, status);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSyncCardStatusFromPlayerListener(PlayerCardStatusSyncFromPlayerListener fromPlayerListener) {
        this.mPlayerCardStatusSyncFromPlayerListener = fromPlayerListener;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSyncCardStatusListener(PlayerCardStatusSyncListener listener) {
        this.mPlayerCardStatusSyncListener = listener;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public ILocalHandler getLocalHandler() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getLocalHandler();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public IRemoteHandler getRemoteHandler() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getRemoteHandler();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public AdDanmakuDelegate getAdDanmakuDelegate() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getAdDanmakuDelegate();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public CommandsPanel getDanmakuCommandPanel() {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        return chronosInteractContainer.getDanmakuCommandPanelList();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public Bitmap getRenderViewBitmap() {
        Bitmap snapshot;
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        EnhancedChronosView cv = chronosInteractContainer.getChronosView();
        if (cv != null) {
            synchronized (cv) {
                snapshot = cv.snapshot();
            }
            return snapshot;
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void registerWatchPointsChangeObserver(WatchPointObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mWatchPointObserverList.contains(observer)) {
            this.mWatchPointObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void unregisterWatchPointsChangeObserver(WatchPointObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mWatchPointObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void addWatchPointsLoadListener(IWatchPointsLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.addWatchPointsLoadListener(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void removeWatchPointsLoadListener(IWatchPointsLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        chronosInteractContainer.removeWatchPointsLoadListener(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public List<ChronosThumbnailInfo.WatchPoint> getWatchPoints() {
        ChronosThumbnailInfo thumbnailInfo;
        ChronosThumbnailInfo thumbnailInfo2;
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        List<ChronosThumbnailInfo.WatchPoint> list = null;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        if (chronosInteractContainer.hasThumbnails2()) {
            ChronosInteractContainer chronosInteractContainer2 = this.mInteractContainer;
            if (chronosInteractContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
                chronosInteractContainer2 = null;
            }
            ThumbnailLoader2 thumbnailFetcher2 = chronosInteractContainer2.getThumbnailFetcher2();
            if (thumbnailFetcher2 != null && (thumbnailInfo2 = thumbnailFetcher2.getThumbnailInfo()) != null) {
                list = thumbnailInfo2.getWatchPoints();
            }
            return EnhancedUnmodifiabilityKt.unmodifiable(list);
        }
        ChronosInteractContainer chronosInteractContainer3 = this.mInteractContainer;
        if (chronosInteractContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer3 = null;
        }
        ThumbnailLoader thumbnailFetcher = chronosInteractContainer3.getThumbnailFetcher();
        if (thumbnailFetcher != null && (thumbnailInfo = thumbnailFetcher.getThumbnailInfo()) != null) {
            list = thumbnailInfo.getWatchPoints();
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(list);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public ChronosThumbnailInfo.WatchPoint findWatchPointByPosition(int positionMS) {
        Iterable watchPoints = getWatchPoints();
        if (watchPoints == null) {
            return null;
        }
        int positionS = (positionMS + 999) / IjkMediaCodecInfo.RANK_MAX;
        ChronosThumbnailInfo.WatchPoint watchPoint = null;
        Iterable $this$forEach$iv = watchPoints;
        for (Object element$iv : $this$forEach$iv) {
            ChronosThumbnailInfo.WatchPoint it = (ChronosThumbnailInfo.WatchPoint) element$iv;
            if (positionS >= it.getFrom() && positionS <= it.getTo()) {
                if (it.getType() == 1 || it.getType() == 10) {
                    return it;
                }
                watchPoint = it;
            }
        }
        return watchPoint;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void switchAiRecommendedSwitch(boolean aiRecommendedSwitch, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.DANMAKU_RECOMMAND;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuRecommandEnable(aiRecommendedSwitch);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH, aiRecommendedSwitch);
        if (fromUser) {
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH, Boolean.valueOf(aiRecommendedSwitch));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockRepeat(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.DUPLICATE_MERGING;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuDuplicateMerging(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockTop(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_TOP;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockTop(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKTOP, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKTOP, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockScroll(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_SCROLL;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockScroll(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockBottom(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_BOTTOM;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockBottom(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockColorful(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_COLORFUL;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockColorful(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockSpecial(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_SPECIAL;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockSpecial(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuAvoidScript(boolean avoidScript, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.AVOID_SCRIPT;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuAvoidScript(avoidScript);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT, avoidScript);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT, Boolean.valueOf(avoidScript));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuAvoidFigure(boolean avoidFigure, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.AVOID_FIGURE;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuAvoidFigure(avoidFigure);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE, avoidFigure);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE, Boolean.valueOf(avoidFigure));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockFixed(boolean block, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_FIXED;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockFixed(block);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED, block);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED, Boolean.valueOf(block));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlackWordsEnable(boolean enable, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLACK_WORDS;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlackWordsEnable(enable);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, enable);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, Boolean.valueOf(enable));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuOpacity(float opacity, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.TRANSPARENCY;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        ClosedFloatingPointRange range = RangesKt.rangeTo(fromUser ? 0.2f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        if (range.contains(Float.valueOf(opacity))) {
            getDanmakuParams().setDanmakuAlphaFactor(opacity);
        } else {
            PlayerLog.i(TAG, "set TRANSPARENCY error " + opacity + ", fromUser " + fromUser);
        }
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_OPACITY, opacity);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_OPACITY, Float.valueOf(opacity));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setScaleFactor(float factor, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.TEXTSIZE_SCALE;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        boolean z = false;
        if (0.5f <= factor && factor <= 2.0f) {
            z = true;
        }
        if (z) {
            getDanmakuParams().setDanmakuTextSizeScaleFactor(factor);
        } else {
            PlayerLog.i(TAG, "set TEXTSIZE_SCALE error " + factor);
        }
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, factor);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, Float.valueOf(factor));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuDomain(float domain, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.SCREEN_DOMAIN;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        float floatValue = ((Number) this.mScreenDomainAvailableRange.getFirst()).floatValue();
        boolean z = false;
        if (domain <= ((Number) this.mScreenDomainAvailableRange.getSecond()).floatValue() && floatValue <= domain) {
            z = true;
        }
        if (z) {
            getDanmakuParams().setDanmakuScreenDomain(domain);
        }
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_DOMAIN, domain);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_DOMAIN, Float.valueOf(domain));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuDisplayDomain(float domain, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.DISPLAY_DOMAIN;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuDisplayDomain(domain);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN, domain);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN, Integer.valueOf(MathKt.roundToInt(100 * domain)));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuDensity(int density, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.DENSITY;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuDensity(density);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putInt(DanmakuKeys.PREF_DANMAKU_DENSITY, density);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_DENSITY, Integer.valueOf(density));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuSpeed(float speed, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.SCROLL_DURATION_FACTOR;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuDuration(speed);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_SPEED, PlayerKVOService.INSTANCE.ensureDanmakuSpeed(speed));
            int kvoSpeed = PlayerKVOService.INSTANCE.translateLocalSpeedToKVO(speed);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_SPEED, Integer.valueOf(kvoSpeed));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuFoldSwitchEnable(boolean enable, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.DANMUKU_FOLD;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setEnableDanmakuFold(enable);
        if (fromUser) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_FOLD, enable);
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_FOLD, Boolean.valueOf(enable));
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setBlockList(boolean enable) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, enable);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void blockDanmakuOnScreen(CommentItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_DANMAKU_ON_SCREEN;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void blockUsers(String[] users) {
        Intrinsics.checkNotNullParameter(users, "users");
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.BLOCK_USER;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        notifyDanmakuSettingsChanged(name);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void blockDmids(List<Long> list) {
        List dmids = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(dmids, "dmids");
        if (dmids.isEmpty()) {
            ArrayList<Long> arrayList = this.mBlockedDmIds;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.mBlockedDmIds = null;
            return;
        }
        if (this.mBlockedDmIds == null) {
            this.mBlockedDmIds = new ArrayList<>();
        }
        ArrayList<Long> arrayList2 = this.mBlockedDmIds;
        if (arrayList2 != null) {
            arrayList2.addAll(dmids);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuSwitchShareEnable(boolean enable) {
        this.mDanmakuSwitchShareEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setSubtitleStateShareEnable(boolean enable) {
        this.mSubtitleStateShareEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuPlayerPanelSelectionText(String text) {
        this.mDanmakuPlayerPanelSelectionText = text;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public String getDanmakuPlayerPanelSelectionText() {
        return this.mDanmakuPlayerPanelSelectionText;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public String getDanmakuForbiddenDescribe() {
        DmViewReply dmViewReply = getDanmakuParams().getDmViewReply();
        if (dmViewReply != null) {
            return dmViewReply.getInputPlaceholder();
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void registerDanmakuSeniorModeChangeObserve(IDanmakuSeniorModeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mDanmakuSeniorModeChangeObserverList.contains(observer)) {
            this.mDanmakuSeniorModeChangeObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void unregisterDanmakuSeniorModeChangeObserve(IDanmakuSeniorModeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDanmakuSeniorModeChangeObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void changeDanmakuSeniorModeSwitch(final int i, boolean fromUser) {
        if (fromUser) {
            PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_SENIOR_MODE_SWITCH, Integer.valueOf(i));
        }
        this.mSeniorModeSwitch = i;
        this.mDanmakuSeniorModeChangeObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda11
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IDanmakuSeniorModeChangeObserver) obj).onSwitchChange(i);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public int getDanmakuSeniorModeSwitch() {
        return this.mSeniorModeSwitch;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setAiBlockLevel(int level, boolean fromUser) {
        DanmakuConfig.DanmakuOptionName name = DanmakuConfig.DanmakuOptionName.DANMAKU_RECOMMAND;
        if (checkOptionFixedOrDisable(name)) {
            return;
        }
        getDanmakuParams().setDanmakuBlockLevelV2(level);
        if (getAiBlockLevelMap().containsKey(Integer.valueOf(level))) {
            DanmakuParams danmakuParams = getDanmakuParams();
            Integer num = getAiBlockLevelMap().get(Integer.valueOf(level));
            danmakuParams.setDanmakuBlockLevel(num != null ? num.intValue() : -1);
            if (fromUser) {
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                playerContainer.getPlayerSettingService().putInt(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2, level);
                PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2, Integer.valueOf(level));
            }
            BLog.d("block_level_error", "set ai block level: " + getDanmakuParams().getDanmakuBlockLevel());
            notifyDanmakuSettingsChanged(name);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setAiBlockLevelMap(Map<Integer, Integer> map) {
        Map levelTransferMap = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(levelTransferMap, "levelTransferMap");
        this.mAiBlockLevelTransferMap = levelTransferMap;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putString(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_MAP, levelTransferMap.toString());
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public Map<Integer, Integer> getAiBlockLevelMap() {
        Map $this$getAiBlockLevelMap_u24lambda_u240 = this.mAiBlockLevelTransferMap;
        if ($this$getAiBlockLevelMap_u24lambda_u240 != null) {
            return EnhancedUnmodifiabilityKt.unmodifiable($this$getAiBlockLevelMap_u24lambda_u240);
        }
        Map $this$getAiBlockLevelMap_u24lambda_u241 = getLevelMapFromKV();
        if ($this$getAiBlockLevelMap_u24lambda_u241 != null && !$this$getAiBlockLevelMap_u24lambda_u241.isEmpty()) {
            return EnhancedUnmodifiabilityKt.unmodifiable($this$getAiBlockLevelMap_u24lambda_u241);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(this.mDefaultLevelMap);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuSendCustomScene(Long scene) {
        this.mSendScene = scene;
    }

    private final Map<Integer, Integer> getLevelMapFromKV() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        HashMap hashMap = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        String mapStr = playerContainer.getPlayerSettingService().getString(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_MAP, "");
        HashMap result = new HashMap();
        try {
            Map $this$getLevelMapFromKV_u24lambda_u240 = (Map) new Gson().fromJson(mapStr, Map.class);
            Iterable $this$forEach$iv = $this$getLevelMapFromKV_u24lambda_u240.entrySet();
            for (Object element$iv : $this$forEach$iv) {
                Map.Entry it = (Map.Entry) element$iv;
                result.put(Integer.valueOf(Integer.parseInt((String) it.getKey())), Integer.valueOf((int) ((Number) it.getValue()).doubleValue()));
            }
            hashMap = result;
        } catch (Throwable th) {
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(hashMap);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public int getAiBlockLevel() {
        return getDanmakuParams().getDanmakuBlockLevelV2();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void reportDanmaku(String reason, boolean shieldUser, CommentItem danmaku) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (danmaku == null || danmaku.getDmId() == null) {
            return;
        }
        String dmId = danmaku.getDmId();
        HashMap param = new HashMap();
        param.put("report_reason", reason);
        param.put("dmid", dmId);
        HashMap hashMap = param;
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        hashMap.put("scm_action_id", currentPolarisActionId);
        Neurons.reportClick(false, EventId.player_neuron_danmaku_report_submit, param);
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putBoolean(DanmakuKeys.KEY_DANMAKU_REPORT_SHIELD_CHECKED, shieldUser);
        ChronosDanmakuInteractiveWrapper chronosDanmakuInteractiveWrapper = new ChronosDanmakuInteractiveWrapper();
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer3;
        }
        Intrinsics.checkNotNull(dmId);
        String str = danmaku.mDamakuSenderHash;
        ChronosDanmakuInteractiveWrapper.reportDanmaku$default(chronosDanmakuInteractiveWrapper, playerContainer2, dmId, null, reason, shieldUser, str == null ? "" : str, new InteractLayerService$reportDanmaku$1(this), false, false, null, null, IjkCodecHelper.IJKCODEC_H265_WIDTH, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String message, int location) {
        if (message == null) {
            return;
        }
        PlayerToast toast = new PlayerToast.Builder().toastItemType(17).location(location).duration(PlayerToastConfig.DURATION_3).setExtraString(PlayerToastConfig.EXTRA_TITLE, message).build();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getToastService().showToast(toast);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public PlayerServiceManager.ServiceConfig serviceConfig() {
        return PlayerServiceManager.ServiceConfig.Companion.obtain(true);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        InteractShareContent shareContent = new InteractShareContent();
        if (this.mDanmakuSwitchShareEnable) {
            shareContent.setDanmakuSwitch(Boolean.valueOf(isDanmakuVisible()));
            shareContent.setDanmakuExposureSpmid(this.mDanmakuExposureSpmid);
        }
        if (this.mSubtitleStateShareEnable) {
            shareContent.setSharedSubtitle(new SharedSubtitle(this.mMainSubtitle, this.mViceSubtitle));
        }
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        shareContent.setChronosSwitch(chronosInteractContainer.hasPackageResult());
        bundle.putSharableObject(KEY_SHARE_CHRONOS_CONTENT, shareContent);
        ChronosInteractContainer chronosInteractContainer2 = this.mInteractContainer;
        if (chronosInteractContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer2 = null;
        }
        chronosInteractContainer2.releaseChronos(true);
        this.pendingDanmakuVisible = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void recallDanmaku(final CommentItem item, final DanmakuRecallCallback callback) {
        Video.DisplayParams displayParams;
        if (item == null || TextUtils.isEmpty(item.mRemoteDmId)) {
            return;
        }
        Object createService = ServiceGenerator.createService(InteractApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        InteractApiService interactApiService = (InteractApiService) createService;
        PlayerContainer playerContainer = this.mPlayerContainer;
        Long l = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        String accessKey = BiliAccounts.get(playerContainer.getContext()).getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer2).getCurrentPlayableParams();
        if (currentPlayableParams != null && (displayParams = currentPlayableParams.getDisplayParams()) != null) {
            l = Long.valueOf(displayParams.getCid());
        }
        BiliCall call = InteractApiService.CC.recall$default(interactApiService, accessKey, String.valueOf(l), item.mRemoteDmId.toString(), 0, 8, null);
        call.enqueue(new InteractApiCallback() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$recallDanmaku$1
            public boolean isCancel() {
                return false;
            }

            public void onError(Throwable t) {
                PlayerContainer playerContainer3;
                String errMessage;
                Intrinsics.checkNotNullParameter(t, "t");
                if (!(t instanceof BiliApiException)) {
                    playerContainer3 = InteractLayerService.this.mPlayerContainer;
                    if (playerContainer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer3 = null;
                    }
                    errMessage = playerContainer3.getContext().getString(R.string.common_global_string_88);
                } else {
                    errMessage = t.getMessage();
                }
                DanmakuRecallCallback danmakuRecallCallback = callback;
                boolean z = false;
                if (danmakuRecallCallback != null && !danmakuRecallCallback.isShowToastWhenResult()) {
                    z = true;
                }
                if (!z) {
                    InteractLayerService.this.showToast(t.getMessage(), 33);
                }
                DanmakuRecallCallback danmakuRecallCallback2 = callback;
                if (danmakuRecallCallback2 != null) {
                    danmakuRecallCallback2.onRecallError(errMessage);
                }
            }

            @Override // tv.danmaku.biliplayerv2.service.interact.core.api.InteractApiCallback
            public void onDataSuccess(InteractApiResponse response) {
                PlayerContainer playerContainer3;
                PlayerContainer playerContainer4;
                boolean z = true;
                InteractLayerService.this.setDanmakuOptions(DanmakuConfig.DanmakuOptionName.BLOCK_DANMAKU_ON_SCREEN, item);
                playerContainer3 = InteractLayerService.this.mPlayerContainer;
                PlayerContainer playerContainer5 = null;
                if (playerContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer3 = null;
                }
                IRemoteHandler remoteHandler = playerContainer3.getInteractLayerService().getRemoteHandler();
                if (remoteHandler != null) {
                    String dmId = item.getDmId();
                    Intrinsics.checkNotNullExpressionValue(dmId, "getDmId(...)");
                    remoteHandler.reCallDanmaku(dmId);
                }
                DanmakuRecallCallback danmakuRecallCallback = callback;
                if (danmakuRecallCallback == null || danmakuRecallCallback.isShowToastWhenResult()) {
                    z = false;
                }
                if (!z) {
                    InteractLayerService interactLayerService = InteractLayerService.this;
                    playerContainer4 = InteractLayerService.this.mPlayerContainer;
                    if (playerContainer4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer5 = playerContainer4;
                    }
                    interactLayerService.showToast(playerContainer5.getContext().getString(R.string.common_global_string_126), 33);
                }
                DanmakuRecallCallback danmakuRecallCallback2 = callback;
                if (danmakuRecallCallback2 != null) {
                    danmakuRecallCallback2.onRecallSuccess(item);
                }
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDanmakuReplyObserver(DanmakuReplyObserver observer) {
        this.mDanmakuReplyObserver = observer;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void enableReply(boolean enable) {
        this.mEnableReply = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean isEnableReply() {
        return this.mEnableReply;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setDmVideoSeekingEnable(boolean enable) {
        this.mDmVideoSeekingEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public DanmakuReplyObserver getDanmakuReplyObserver() {
        return this.mDanmakuReplyObserver;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setMockDanmakuParams(MockDanmakuParams params) {
        this.mMockParams = params;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public MockDanmakuParams getMockDanmakuParams() {
        return this.mMockParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void registerChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        ILocalHandler localHandler = chronosInteractContainer.getLocalHandler();
        if (localHandler != null) {
            localHandler.registerChronosMessageHandler(chronosRequestHandler);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void unregisterChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        ILocalHandler localHandler = chronosInteractContainer.getLocalHandler();
        if (localHandler != null) {
            localHandler.unregisterChronosMessageHandler(chronosRequestHandler);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public IChronosRpcSender getChronosMessageSender() {
        IRemoteHandler remoteHandler = getRemoteHandler();
        if (remoteHandler != null) {
            return remoteHandler.getChronosMessageSender();
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void resetPreferences() {
        BLog.i(TAG, "Reset danmaku preferences.");
        DanmakuParams params = getDanmakuParams();
        params.reset();
        if (this.mSeniorModeSwitch != 0) {
            this.mSeniorModeSwitch = 3;
            this.mDanmakuSeniorModeChangeObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda15
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((IDanmakuSeniorModeChangeObserver) obj).onSwitchChange(3);
                }
            });
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_DISPLAY_DOMAIN, params.getDanmakuDisplayDomain());
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_OPACITY, params.getDanmakuAlphaFactor());
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer4 = null;
        }
        playerContainer4.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, params.getDanmakuTextSizeScaleFactor());
        PlayerContainer playerContainer5 = this.mPlayerContainer;
        if (playerContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer5 = null;
        }
        playerContainer5.getPlayerSettingService().putFloat(DanmakuKeys.PREF_DANMAKU_SPEED, PlayerKVOService.INSTANCE.ensureDanmakuSpeed(params.getDanmakuDuration()));
        PlayerContainer playerContainer6 = this.mPlayerContainer;
        if (playerContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer6 = null;
        }
        playerContainer6.getPlayerSettingService().putInt(DanmakuKeys.PREF_DANMAKU_DENSITY, params.getDanmakuDensity());
        PlayerContainer playerContainer7 = this.mPlayerContainer;
        if (playerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer7 = null;
        }
        playerContainer7.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKFIXED, params.getDanmakuBlockFixed());
        PlayerContainer playerContainer8 = this.mPlayerContainer;
        if (playerContainer8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer8 = null;
        }
        playerContainer8.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, params.isDanmakuBlockScroll());
        PlayerContainer playerContainer9 = this.mPlayerContainer;
        if (playerContainer9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer9 = null;
        }
        playerContainer9.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, params.isDanmakuBlockColorful());
        PlayerContainer playerContainer10 = this.mPlayerContainer;
        if (playerContainer10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer10 = null;
        }
        playerContainer10.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, params.isDanmakuBlockSpecial());
        PlayerContainer playerContainer11 = this.mPlayerContainer;
        if (playerContainer11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer11 = null;
        }
        playerContainer11.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_FOLD, params.getEnableDanmakuFold());
        PlayerContainer playerContainer12 = this.mPlayerContainer;
        if (playerContainer12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer12 = null;
        }
        playerContainer12.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, params.isDanmakuDuplicateMerging());
        PlayerContainer playerContainer13 = this.mPlayerContainer;
        if (playerContainer13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer13 = null;
        }
        playerContainer13.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_AVOID_FIGURE, params.getDanmakuAvoidFigure());
        PlayerContainer playerContainer14 = this.mPlayerContainer;
        if (playerContainer14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer14;
        }
        playerContainer2.getPlayerSettingService().putBoolean(DanmakuKeys.PREF_DANMAKU_AVOID_SCRIPT, params.getDanmakuAvoidScript());
        PlayerKVOService.INSTANCE.syncParamsBatched(params.getKVOParamsMap(this.mSeniorModeSwitch));
        Iterable list = CollectionsKt.listOf(new DanmakuConfig.DanmakuOptionName[]{DanmakuConfig.DanmakuOptionName.DISPLAY_DOMAIN, DanmakuConfig.DanmakuOptionName.TRANSPARENCY, DanmakuConfig.DanmakuOptionName.TEXTSIZE_SCALE, DanmakuConfig.DanmakuOptionName.SCROLL_DURATION_FACTOR, DanmakuConfig.DanmakuOptionName.DENSITY, DanmakuConfig.DanmakuOptionName.BLOCK_FIXED, DanmakuConfig.DanmakuOptionName.BLOCK_SCROLL, DanmakuConfig.DanmakuOptionName.BLOCK_COLORFUL, DanmakuConfig.DanmakuOptionName.BLOCK_SPECIAL, DanmakuConfig.DanmakuOptionName.DANMUKU_FOLD, DanmakuConfig.DanmakuOptionName.DUPLICATE_MERGING, DanmakuConfig.DanmakuOptionName.AVOID_SCRIPT, DanmakuConfig.DanmakuOptionName.AVOID_FIGURE});
        Iterable $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            DanmakuConfig.DanmakuOptionName it = (DanmakuConfig.DanmakuOptionName) element$iv;
            notifyDanmakuSettingsChanged(it);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public boolean getAutomaticViewProgressRequestDisabled() {
        return this.automaticViewProgressRequestDisabled;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService
    public void setAutomaticViewProgressRequestDisabled(boolean z) {
        this.automaticViewProgressRequestDisabled = z;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService, tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void showDanmaku(final boolean fromUser) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        ChronosScene scene = (ChronosScene) chronosInteractContainer.getSceneAndBizParams().component1();
        if (getDanmakuParams().getDmViewReply() != null || scene == ChronosScene.SCENE_OFFLINE) {
            super.showDanmaku(fromUser);
            return;
        }
        BLog.i(TAG, "Pending showDanmaku, fromUser: " + fromUser);
        this.pendingDanmakuVisible = new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                super/*tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService*/.showDanmaku(fromUser);
            }
        };
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService, tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService
    public void hideDanmaku(final boolean fromUser) {
        ChronosInteractContainer chronosInteractContainer = this.mInteractContainer;
        if (chronosInteractContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractContainer");
            chronosInteractContainer = null;
        }
        ChronosScene scene = (ChronosScene) chronosInteractContainer.getSceneAndBizParams().component1();
        if (getDanmakuParams().getDmViewReply() != null || scene == ChronosScene.SCENE_OFFLINE) {
            super.hideDanmaku(fromUser);
            return;
        }
        BLog.i(TAG, "Pending hideDanmaku, fromUser: " + fromUser);
        this.pendingDanmakuVisible = new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                super/*tv.danmaku.biliplayerv2.service.interact.core.InteractCoreService*/.hideDanmaku(fromUser);
            }
        };
    }

    /* compiled from: InteractLayerService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$Companion;", "", "<init>", "()V", "TAG", "", InteractLayerService.KEY_SHARE_CHRONOS_CONTENT, "CLEAR_CHRONOS_ID", "openDanmakuBlockListWhenClosed", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void openDanmakuBlockListWhenClosed(PlayerContainer playerContainer) {
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
            IPlayerSettingService settingService = playerContainer.getPlayerSettingService();
            if (!settingService.getBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true)) {
                settingService.putBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true);
                PlayerKVOService.INSTANCE.syncKVOToRemote(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, true);
            }
        }
    }
}