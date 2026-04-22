package tv.danmaku.biliplayerv2.service.interact.biz;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bapis.bilibili.app.viewunite.v1.FragmentParam;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.GeneralResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.ThumbnailLoader;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.AdDanmakuDelegate;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.IMultiDanmakuCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer;
import tv.danmaku.biliplayerv2.service.interact.core.IInteractCoreService;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsPanel;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.interact.core.model.MockDanmakuParams;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailConfig;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000Ú\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0016\u0010\u001e\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 H\u0016J\u0016\u0010!\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0006H\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0004H\u0016J\u001a\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0016J$\u0010C\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J:\u0010C\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\u0014\u0010J\u001a\u0010\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020\u0004H\u0016J\u0012\u0010R\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010TH&J\u0012\u0010U\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010X\u001a\u00020\u0004H\u0016J\b\u0010Y\u001a\u00020\u0004H\u0016J \u0010Z\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020EH\u0016J?\u0010_\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00062\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0002\u0010bJ\u0012\u0010c\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020\u0004H\u0016J\u0010\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020iH\u0016J/\u0010j\u001a\u00020\u0004\"\u0004\b\u0000\u0010k2\u0006\u0010l\u001a\u00020m2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u0002Hk0n\"\u0002HkH\u0016¢\u0006\u0002\u0010oJ\u001a\u0010p\u001a\u00020\u00062\b\u0010q\u001a\u0004\u0018\u00010=2\u0006\u0010<\u001a\u00020EH\u0016J\u0010\u0010r\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\b\u0010s\u001a\u00020\u0006H\u0016J\u0010\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020GH\u0016J\b\u0010v\u001a\u00020GH\u0016J\b\u0010w\u001a\u00020\u0006H\u0016J\u0010\u0010x\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\u0006H\u0016J\n\u0010z\u001a\u0004\u0018\u00010{H\u0016J\n\u0010|\u001a\u0004\u0018\u00010{H\u0016J\n\u0010}\u001a\u0004\u0018\u00010{H\u0016J\u001d\u0010~\u001a\u00020\u00042\b\u0010\u007f\u001a\u0004\u0018\u00010{2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010{H\u0016J\u001f\u0010\u0081\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u00062\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0086\u0001\u001a\u00020\u0004H\u0016J\u001c\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020E2\b\u0010\u001d\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u00042\u0007\u0010\u008a\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u008e\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020\u00042\u0007\u0010\u0090\u0001\u001a\u00020EH\u0016J\u0015\u0010\u0091\u0001\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0KH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0093\u0001H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0093\u0001H\u0016J\u0012\u0010\u0095\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0096\u0001H\u0016J\u0012\u0010\u0097\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0096\u0001H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0099\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0099\u0001H\u0016J\u0011\u0010\u009b\u0001\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\u00020\u00042\b\u0010\u009f\u0001\u001a\u00030\u009d\u0001H\u0016J\u001d\u0010 \u0001\u001a\u00020\u00042\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001H\u0016Jo\u0010¥\u0001\u001a\u00020\u00042\u0007\u0010¦\u0001\u001a\u00020E2\u0007\u0010§\u0001\u001a\u00020E2\u0007\u0010¨\u0001\u001a\u00020\u00062\u0007\u0010©\u0001\u001a\u00020E2\t\u0010ª\u0001\u001a\u0004\u0018\u00010E2\t\b\u0002\u0010«\u0001\u001a\u00020\u00062\t\b\u0002\u0010¬\u0001\u001a\u00020\u00062\u0012\b\u0002\u0010\u00ad\u0001\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010®\u00012\u000b\b\u0002\u0010¯\u0001\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010°\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030±\u0001H\u0016J\u0012\u0010²\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030±\u0001H\u0016J<\u0010³\u0001\u001a\u00020\u00042\t\u0010©\u0001\u001a\u0004\u0018\u00010E2\t\u0010´\u0001\u001a\u0004\u0018\u00010E2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\\2\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0016¢\u0006\u0003\u0010¸\u0001J\u0011\u0010¹\u0001\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J*\u0010º\u0001\u001a\u00020\u00042\t\b\u0002\u0010»\u0001\u001a\u00020\u00062\u0014\b\u0002\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0KH\u0016JA\u0010º\u0001\u001a\u00020\u00042\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\t\b\u0002\u0010¾\u0001\u001a\u00020\\2\t\b\u0002\u0010»\u0001\u001a\u00020\u00062\u0014\b\u0002\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0KH&J\t\u0010¿\u0001\u001a\u00020\u0004H&J,\u0010À\u0001\u001a\u00020\u00042\u0006\u0010F\u001a\u00020G2\u0007\u0010Á\u0001\u001a\u00020\\2\u0007\u0010Â\u0001\u001a\u00020\\2\u0007\u0010Ã\u0001\u001a\u00020\u0006H\u0016J#\u0010Ä\u0001\u001a\u00020\u00042\u0006\u0010F\u001a\u00020G2\u0007\u0010Å\u0001\u001a\u00020\\2\u0007\u0010Ã\u0001\u001a\u00020\u0006H\u0016J\u0015\u0010Æ\u0001\u001a\u00020\u00042\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0016J\u0015\u0010É\u0001\u001a\u00020\u00042\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0016J\f\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0016J\f\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001H\u0016J\f\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0016J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0016J\f\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001H\u0016Ju\u0010Ö\u0001\u001a\u00020\u00042j\u0010×\u0001\u001ae\u0012\u0014\u0012\u00120E¢\u0006\r\bÙ\u0001\u0012\b\bl\u0012\u0004\b\b(D\u0012\u0014\u0012\u00120E¢\u0006\r\bÙ\u0001\u0012\b\bl\u0012\u0004\b\b(<\u0012\u0015\u0012\u00130\\¢\u0006\u000e\bÙ\u0001\u0012\t\bl\u0012\u0005\b\b(Ú\u0001\u0012\u0015\u0012\u00130E¢\u0006\u000e\bÙ\u0001\u0012\t\bl\u0012\u0005\b\b(Û\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010Ø\u0001H\u0016J\u0012\u0010Ü\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030Ý\u0001H\u0016J\u0012\u0010Þ\u0001\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030Ý\u0001H\u0016J\u0013\u0010ß\u0001\u001a\u00020\u00042\b\u0010Ê\u0001\u001a\u00030à\u0001H\u0016J\u0013\u0010á\u0001\u001a\u00020\u00042\b\u0010Ê\u0001\u001a\u00030à\u0001H\u0016J\u0013\u0010â\u0001\u001a\f\u0012\u0005\u0012\u00030ä\u0001\u0018\u00010ã\u0001H\u0016J\u0015\u0010å\u0001\u001a\u0005\u0018\u00010ä\u00012\u0007\u0010æ\u0001\u001a\u00020GH\u0016J\u001d\u0010ç\u0001\u001a\u00020\u00042\u0007\u0010è\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ê\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ì\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010í\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010î\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ï\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ð\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ñ\u0001\u001a\u00020\u00042\u0007\u0010ò\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ó\u0001\u001a\u00020\u00042\u0007\u0010ô\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010õ\u0001\u001a\u00020\u00042\u0007\u0010ë\u0001\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001c\u0010ö\u0001\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010÷\u0001\u001a\u00020\u00042\u0007\u0010ø\u0001\u001a\u00020B2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ù\u0001\u001a\u00020\u00042\u0007\u0010ú\u0001\u001a\u00020B2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010û\u0001\u001a\u00020\u00042\u0007\u0010ü\u0001\u001a\u00020B2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010ý\u0001\u001a\u00020\u00042\u0007\u0010ü\u0001\u001a\u00020B2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010þ\u0001\u001a\u00020\u00042\u0007\u0010ÿ\u0001\u001a\u00020G2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010\u0080\u0002\u001a\u00020\u00042\u0007\u0010\u0081\u0002\u001a\u00020B2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001c\u0010\u0082\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00062\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u0011\u0010\u0083\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0013\u0010\u0084\u0002\u001a\u00020\u00042\b\u0010\u0085\u0002\u001a\u00030\u0086\u0002H\u0016J\u001e\u0010\u0087\u0002\u001a\u00020\u00042\r\u0010\u0088\u0002\u001a\b\u0012\u0004\u0012\u00020E0nH\u0016¢\u0006\u0003\u0010\u0089\u0002J\u0019\u0010\u008a\u0002\u001a\u00020\u00042\u000e\u0010\u008b\u0002\u001a\t\u0012\u0004\u0012\u00020\\0ã\u0001H\u0016J\u0011\u0010\u008c\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0011\u0010\u008d\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0013\u0010\u008e\u0002\u001a\u00020\u00042\b\u0010^\u001a\u0004\u0018\u00010EH\u0016J\u000b\u0010\u008f\u0002\u001a\u0004\u0018\u00010EH\u0016J\t\u0010\u0090\u0002\u001a\u00020\u0006H\u0016J\u000b\u0010\u0091\u0002\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010\u0092\u0002\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0093\u0002H\u0016J\u0012\u0010\u0094\u0002\u001a\u00020\u00042\u0007\u0010\u001f\u001a\u00030\u0093\u0002H\u0016J\u001c\u0010\u0095\u0002\u001a\u00020\u00042\u0006\u0010`\u001a\u00020G2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0096\u0002\u001a\u00020GH\u0016J\u001a\u0010\u0097\u0002\u001a\u00020\u00042\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0003\u0010\u0098\u0002J\u001d\u0010\u0099\u0002\u001a\u00020\u00042\u0007\u0010\u009a\u0002\u001a\u00020G2\t\b\u0002\u0010é\u0001\u001a\u00020\u0006H\u0016J\u001e\u0010\u009b\u0002\u001a\u00020\u00042\u0013\u0010\u009c\u0002\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020G0KH\u0016J\u0015\u0010\u009d\u0002\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020G0KH\u0016J\t\u0010\u009e\u0002\u001a\u00020GH\u0016J'\u0010¥\u0001\u001a\u00020\u00042\u0007\u0010§\u0001\u001a\u00020E2\u0007\u0010¨\u0001\u001a\u00020\u00062\n\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u0086\u0002H\u0016J!\u0010 \u0002\u001a\u00020\u00042\n\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0086\u00022\n\u0010¡\u0002\u001a\u0005\u0018\u00010¢\u0002H\u0016J\u0014\u0010£\u0002\u001a\u00020\u00042\t\u0010\u001f\u001a\u0005\u0018\u00010¤\u0002H\u0016J\u0011\u0010¥\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\t\u0010¦\u0002\u001a\u00020\u0006H\u0016J\u0011\u0010§\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\f\u0010¨\u0002\u001a\u0005\u0018\u00010¤\u0002H\u0016J\u0017\u0010©\u0002\u001a\u00020\u00042\f\b\u0002\u0010ª\u0002\u001a\u0005\u0018\u00010«\u0002H&J\f\u0010¬\u0002\u001a\u0005\u0018\u00010«\u0002H&J\u001b\u0010\u00ad\u0002\u001a\u00020\u00042\u0010\u0010×\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030®\u0002H&J\u001b\u0010¯\u0002\u001a\u00020\u00042\u0010\u0010×\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030®\u0002H&J\f\u0010°\u0002\u001a\u0005\u0018\u00010±\u0002H&J\t\u0010²\u0002\u001a\u00020\u0004H\u0016J\u0016\u0010¸\u0002\u001a\u0004\u0018\u00010{2\t\b\u0002\u0010¹\u0002\u001a\u00020\u0006H\u0016J\u0016\u0010º\u0002\u001a\u0004\u0018\u00010{2\t\b\u0002\u0010¹\u0002\u001a\u00020\u0006H\u0016J\u0012\u0010»\u0002\u001a\u00020\u00042\u0007\u0010S\u001a\u00030¼\u0002H\u0016J\n\u0010½\u0002\u001a\u00030¼\u0002H\u0016J\u0011\u0010¾\u0002\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006H\u0016J\t\u0010¿\u0002\u001a\u00020\u0006H\u0016R\u001d\u0010³\u0002\u001a\u00020\u0006X¦\u000e¢\u0006\u0010\u001a\u0006\b´\u0002\u0010µ\u0002\"\u0006\b¶\u0002\u0010·\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006À\u0002À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "Ltv/danmaku/biliplayerv2/service/interact/core/IInteractCoreService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "setInlineMode", "", "isInline", "", "isInlineMode", "setDmViewReply", "reply", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReply;", "startFromShared", "danmakuResolveParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "bindDanmakuContainer", "container", "Landroid/widget/FrameLayout;", "getDanmakuParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "getDanmakuSwitchParams", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuSwitchParams;", "setVisibleRect", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "getChronosInteractContainer", "Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer;", "getSegmentSwitchVisibility", "getSegmentSwitchValue", "setSegmentSwitchValue", "value", "addSegmentSwitchObserver", "observer", "Landroidx/lifecycle/Observer;", "removeSegmentSwitchObserver", "setForcedChapterGuide", "setEyesProtectionMode", "mode", "loadThumbnailIfNeed", "loadThumbnailIfNeed2", "getThumbnailFetcher", "Ltv/danmaku/biliplayerv2/service/ThumbnailLoader;", "getThumbnailFetcher2", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2;", "hasThumbnails", "hasThumbnails2", "setThumbnailEnable", "enable", "setThumbnail2Enable", "getViewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "registerViewProgressObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/ViewProgressObserver;", "unregisterViewProgressObserver", "setChronosVisible", "visible", "addDanmakuInteractionObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuInteractionObserver;", "removeDanmakuInteractionObserver", "cloneMultiDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer;", "content", "Landroid/content/Context;", "multiDanmakuCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/IMultiDanmakuCallback;", "setDanmakuViewOffset", "offsetY", "", "addDanmaku", "dmId", "", "type", "", "extra", "", "emoExtra", "", "", "isChronosValid", "registerChronosReadyCallback", "onChronosReadyCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/OnChronosReadyCallback;", "unregisterChronosReadyCallback", "setThumbnailConfig", "config", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "runPackageForLive", "pkg", "Lcom/bilibili/cron/ChronosPackage;", "clearChronosPackage", "clearDanmaku", "sendOnlineInfoDanmaku", "aid", "", "cid", "text", "setOnlineInfo", "switch", "logo", "(Ljava/lang/Boolean;JJLjava/lang/String;Ljava/lang/String;)V", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "bindPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "setDanmakuOptions", "T", "name", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;", "", "(Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;[Ljava/lang/Object;)V", "sendUpDanmaku", "context", "setCustomSubtitleMargin", "isCustomSubtitleMargin", "updateSubtitleDrawRect", "bottomFix", "getSubtitleBottomMargin", "isSubtitleShowInSettingWidget", "setSubtitleShowInSettingWidget", "show", "getMainSubtitle", "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "getViceSubtitle", "getInitViceSubtitle", "loadSubtitle", "mainSubtitle", "viceSubtitle", "recordSelectedSubtitle", "isShare", "isManual", "dispatchSubtitleModeChanged", "dispatchSubtitleDragChanged", "dispatchSubtitleLargeChanged", "onPreferenceChanged", "key", "setSubtitleAvailable", "available", "isSubtitleAvailable", "setForbidCloseSubtitle", "forbid", "isForbidCloseSubtitle", "setDanmakuExposureSpmid", "spmid", "getDanmakuReportCommonParameters", "addDanmakuParamsChangedObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuParamsChangeObserver;", "removeDanmakuParamsChangedObserver", "addSubtitleChangedObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/ISubtitleChangedObserver;", "removeSubtitleChangedObserver", "addDanmakuSettingsChangedObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuSettingsChangedObserver;", "removeDanmakuSettingsChangedObserver", "setDanmakuMonopolizeTap", "getDanmakuInputClickInterceptor", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuInputClickInterceptor;", "setDanmakuInputClickInterceptor", "interceptor", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "reportDanmaku", "danmakuId", "reason", "shieldUser", "shieldUserId", "oid", "needReportAndGetBlockData", "blockUser", "rResponse", "Lcom/bilibili/okretro/GeneralResponse;", "dmContent", "addDanmakuCommandPanelsObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuCommandPanelsObserver;", "removeDanmakuCommandPanelsObserver", "appendFilters", "regexFilter", "nativeId", "onSuccess", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Runnable;)V", "setChronosEnable", "reloadViewProgress", "simplify", "fragmentParam", "Lcom/bapis/bilibili/app/viewunite/v1/FragmentParam;", "fragmentOffset", "loadCommandPanel", "syncStandardCardStatus", "activityId", "reserveId", "status", "syncStandardCardStatusFromPlayer", "id", "setSyncCardStatusFromPlayerListener", "fromPlayerListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/PlayerCardStatusSyncFromPlayerListener;", "setSyncCardStatusListener", "listener", "Ltv/danmaku/biliplayerv2/service/interact/biz/PlayerCardStatusSyncListener;", "getLocalHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalHandler;", "getRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "getAdDanmakuDelegate", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/AdDanmakuDelegate;", "getDanmakuCommandPanel", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "getRenderViewBitmap", "Landroid/graphics/Bitmap;", "setDanmakuReplyHandler", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "progress", "midHash", "registerWatchPointsChangeObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/WatchPointObserver;", "unregisterWatchPointsChangeObserver", "addWatchPointsLoadListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/IWatchPointsLoadListener;", "removeWatchPointsLoadListener", "getWatchPoints", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "findWatchPointByPosition", "positionMS", "switchAiRecommendedSwitch", "aiRecommendedSwitch", "fromUser", "setBlockRepeat", "block", "setBlockTop", "setBlockScroll", "setBlockBottom", "setBlockColorful", "setBlockSpecial", "setDanmakuAvoidScript", "avoidScript", "setDanmakuAvoidFigure", "avoidFigure", "setBlockFixed", "setBlackWordsEnable", "setDanmakuOpacity", "opacity", "setScaleFactor", "factor", "setDanmakuDomain", "domain", "setDanmakuDisplayDomain", "setDanmakuDensity", "density", "setDanmakuSpeed", "speed", "setDanmakuFoldSwitchEnable", "setBlockList", "blockDanmakuOnScreen", "item", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "blockUsers", "users", "([Ljava/lang/String;)V", "blockDmids", "dmids", "setDanmakuSwitchShareEnable", "setSubtitleStateShareEnable", "setDanmakuPlayerPanelSelectionText", "getDanmakuPlayerPanelSelectionText", "isDanmakuForbidden", "getDanmakuForbiddenDescribe", "registerDanmakuSeniorModeChangeObserve", "Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuSeniorModeChangeObserver;", "unregisterDanmakuSeniorModeChangeObserve", "changeDanmakuSeniorModeSwitch", "getDanmakuSeniorModeSwitch", "setDanmakuSendCustomScene", "(Ljava/lang/Long;)V", "setAiBlockLevel", "level", "setAiBlockLevelMap", "levelTransferMap", "getAiBlockLevelMap", "getAiBlockLevel", "danmaku", "recallDanmaku", "callback", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuRecallCallback;", "setDanmakuReplyObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuReplyObserver;", "enableReply", "isEnableReply", "setDmVideoSeekingEnable", "getDanmakuReplyObserver", "setMockDanmakuParams", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/model/MockDanmakuParams;", "getMockDanmakuParams", "registerChronosMessageHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "unregisterChronosMessageHandler", "getChronosMessageSender", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/protocol/IChronosRpcSender;", "resetPreferences", "automaticViewProgressRequestDisabled", "getAutomaticViewProgressRequestDisabled", "()Z", "setAutomaticViewProgressRequestDisabled", "(Z)V", "chooseMainSubtitle", "force", "chooseViceSubtitle", "putSubtitleKeyConfig", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$SubtitleKeyConfig;", "getSubtitleKeyConfig", "enableBilingualSwitch", "bilingualSwitchEnabled", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IInteractLayerService extends IInteractCoreService, IPlayerService {
    void addDanmaku(String str, int i, Object obj);

    void addDanmaku(String str, int i, Object obj, Map<String, byte[]> map);

    void addDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver danmakuCommandPanelsObserver);

    void addDanmakuInteractionObserver(DanmakuInteractionObserver danmakuInteractionObserver);

    void addDanmakuParamsChangedObserver(IDanmakuParamsChangeObserver iDanmakuParamsChangeObserver);

    void addDanmakuSettingsChangedObserver(IDanmakuSettingsChangedObserver iDanmakuSettingsChangedObserver);

    void addSegmentSwitchObserver(Observer<Boolean> observer);

    void addSubtitleChangedObserver(ISubtitleChangedObserver iSubtitleChangedObserver);

    void addWatchPointsLoadListener(IWatchPointsLoadListener iWatchPointsLoadListener);

    void appendFilters(String str, String str2, Long l, Runnable runnable);

    boolean bilingualSwitchEnabled();

    void bindDanmakuContainer(FrameLayout frameLayout);

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    void bindPlayerContainer(PlayerContainer playerContainer);

    void blockDanmakuOnScreen(CommentItem commentItem);

    void blockDmids(List<Long> list);

    void blockUsers(String[] strArr);

    void changeDanmakuSeniorModeSwitch(int i, boolean z);

    SubtitleItem chooseMainSubtitle(boolean z);

    SubtitleItem chooseViceSubtitle(boolean z);

    void clearChronosPackage();

    void clearDanmaku();

    MultiDanmakuPlayer cloneMultiDanmaku(Context context, IMultiDanmakuCallback iMultiDanmakuCallback);

    void dispatchSubtitleDragChanged();

    void dispatchSubtitleLargeChanged();

    void dispatchSubtitleModeChanged();

    void enableBilingualSwitch(boolean z);

    void enableReply(boolean z);

    ChronosThumbnailInfo.WatchPoint findWatchPointByPosition(int i);

    AdDanmakuDelegate getAdDanmakuDelegate();

    int getAiBlockLevel();

    Map<Integer, Integer> getAiBlockLevelMap();

    boolean getAutomaticViewProgressRequestDisabled();

    ChronosInteractContainer getChronosInteractContainer();

    IChronosRpcSender getChronosMessageSender();

    CommandsPanel getDanmakuCommandPanel();

    String getDanmakuForbiddenDescribe();

    DanmakuInputClickInterceptor getDanmakuInputClickInterceptor();

    DanmakuParams getDanmakuParams();

    String getDanmakuPlayerPanelSelectionText();

    DanmakuReplyObserver getDanmakuReplyObserver();

    Map<String, String> getDanmakuReportCommonParameters();

    int getDanmakuSeniorModeSwitch();

    DanmakuSwitchParams getDanmakuSwitchParams();

    SubtitleItem getInitViceSubtitle();

    ILocalHandler getLocalHandler();

    SubtitleItem getMainSubtitle();

    MockDanmakuParams getMockDanmakuParams();

    IRemoteHandler getRemoteHandler();

    Bitmap getRenderViewBitmap();

    boolean getSegmentSwitchValue();

    boolean getSegmentSwitchVisibility();

    int getSubtitleBottomMargin();

    InteractLayerService.SubtitleKeyConfig getSubtitleKeyConfig();

    ThumbnailLoader getThumbnailFetcher();

    ThumbnailLoader2 getThumbnailFetcher2();

    SubtitleItem getViceSubtitle();

    ViewProgressDetail getViewProgressDetail();

    List<ChronosThumbnailInfo.WatchPoint> getWatchPoints();

    boolean hasThumbnails();

    boolean hasThumbnails2();

    boolean isChronosValid();

    boolean isCustomSubtitleMargin();

    boolean isDanmakuForbidden();

    boolean isEnableReply();

    boolean isForbidCloseSubtitle();

    boolean isInlineMode();

    boolean isSubtitleAvailable();

    boolean isSubtitleShowInSettingWidget();

    void loadCommandPanel();

    void loadSubtitle(SubtitleItem subtitleItem, SubtitleItem subtitleItem2);

    void loadThumbnailIfNeed();

    void loadThumbnailIfNeed2();

    void onPreferenceChanged(String str, String str2);

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    void onStart(PlayerSharingBundle playerSharingBundle);

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    void onStop();

    void putSubtitleKeyConfig(InteractLayerService.SubtitleKeyConfig subtitleKeyConfig);

    void recallDanmaku(CommentItem commentItem, DanmakuRecallCallback danmakuRecallCallback);

    void recordSelectedSubtitle(boolean z, boolean z2);

    void registerChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler);

    void registerChronosReadyCallback(OnChronosReadyCallback onChronosReadyCallback);

    void registerDanmakuSeniorModeChangeObserve(IDanmakuSeniorModeChangeObserver iDanmakuSeniorModeChangeObserver);

    void registerViewProgressObserver(ViewProgressObserver viewProgressObserver);

    void registerWatchPointsChangeObserver(WatchPointObserver watchPointObserver);

    void reloadViewProgress(FragmentParam fragmentParam, long j, boolean z, Map<String, String> map);

    void reloadViewProgress(boolean z, Map<String, String> map);

    void removeDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver danmakuCommandPanelsObserver);

    void removeDanmakuInteractionObserver();

    void removeDanmakuParamsChangedObserver(IDanmakuParamsChangeObserver iDanmakuParamsChangeObserver);

    void removeDanmakuSettingsChangedObserver(IDanmakuSettingsChangedObserver iDanmakuSettingsChangedObserver);

    void removeSegmentSwitchObserver(Observer<Boolean> observer);

    void removeSubtitleChangedObserver(ISubtitleChangedObserver iSubtitleChangedObserver);

    void removeWatchPointsLoadListener(IWatchPointsLoadListener iWatchPointsLoadListener);

    void reportDanmaku(String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse<String> generalResponse, String str5);

    void reportDanmaku(String str, boolean z, CommentItem commentItem);

    void resetPreferences();

    void runPackageForLive(ChronosPackage chronosPackage);

    void sendOnlineInfoDanmaku(long j, long j2, String str);

    boolean sendUpDanmaku(Context context, String str);

    void setAiBlockLevel(int i, boolean z);

    void setAiBlockLevelMap(Map<Integer, Integer> map);

    void setAutomaticViewProgressRequestDisabled(boolean z);

    void setBlackWordsEnable(boolean z, boolean z2);

    void setBlockBottom(boolean z, boolean z2);

    void setBlockColorful(boolean z, boolean z2);

    void setBlockFixed(boolean z, boolean z2);

    void setBlockList(boolean z);

    void setBlockRepeat(boolean z, boolean z2);

    void setBlockScroll(boolean z, boolean z2);

    void setBlockSpecial(boolean z, boolean z2);

    void setBlockTop(boolean z, boolean z2);

    void setChronosEnable(boolean z);

    void setChronosVisible(boolean z);

    void setCustomSubtitleMargin(boolean z);

    void setDanmakuAvoidFigure(boolean z, boolean z2);

    void setDanmakuAvoidScript(boolean z, boolean z2);

    void setDanmakuDensity(int i, boolean z);

    void setDanmakuDisplayDomain(float f, boolean z);

    void setDanmakuDomain(float f, boolean z);

    void setDanmakuExposureSpmid(String str);

    void setDanmakuFoldSwitchEnable(boolean z, boolean z2);

    void setDanmakuInputClickInterceptor(DanmakuInputClickInterceptor danmakuInputClickInterceptor);

    void setDanmakuMonopolizeTap(boolean z);

    void setDanmakuOpacity(float f, boolean z);

    <T> void setDanmakuOptions(DanmakuConfig.DanmakuOptionName danmakuOptionName, T... tArr);

    void setDanmakuPlayerPanelSelectionText(String str);

    void setDanmakuReplyHandler(Function4<? super String, ? super String, ? super Long, ? super String, Unit> function4);

    void setDanmakuReplyObserver(DanmakuReplyObserver danmakuReplyObserver);

    void setDanmakuSendCustomScene(Long l);

    void setDanmakuSpeed(float f, boolean z);

    void setDanmakuSwitchShareEnable(boolean z);

    void setDanmakuViewOffset(float f);

    void setDmVideoSeekingEnable(boolean z);

    void setDmViewReply(DmViewReply dmViewReply);

    void setEyesProtectionMode(boolean z);

    void setForbidCloseSubtitle(boolean z);

    void setForcedChapterGuide(boolean z);

    void setInlineMode(boolean z);

    void setMockDanmakuParams(MockDanmakuParams mockDanmakuParams);

    void setOnlineInfo(Boolean bool, long j, long j2, String str, String str2);

    void setScaleFactor(float f, boolean z);

    void setSceneAndBizParams(ChronosScene chronosScene, ChronosBiz chronosBiz);

    void setSegmentSwitchValue(boolean z);

    void setSubtitleAvailable(boolean z);

    void setSubtitleShowInSettingWidget(boolean z);

    void setSubtitleStateShareEnable(boolean z);

    void setSyncCardStatusFromPlayerListener(PlayerCardStatusSyncFromPlayerListener playerCardStatusSyncFromPlayerListener);

    void setSyncCardStatusListener(PlayerCardStatusSyncListener playerCardStatusSyncListener);

    void setThumbnail2Enable(boolean z);

    void setThumbnailConfig(ThumbnailConfig thumbnailConfig);

    void setThumbnailEnable(boolean z);

    void setVisibleRect(DanmakuConfigChange.VisibleRect visibleRect);

    boolean startFromShared(Video.DanmakuResolveParams danmakuResolveParams);

    void switchAiRecommendedSwitch(boolean z, boolean z2);

    void syncStandardCardStatus(int i, long j, long j2, boolean z);

    void syncStandardCardStatusFromPlayer(int i, long j, boolean z);

    void unregisterChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler);

    void unregisterChronosReadyCallback();

    void unregisterDanmakuSeniorModeChangeObserve(IDanmakuSeniorModeChangeObserver iDanmakuSeniorModeChangeObserver);

    void unregisterViewProgressObserver(ViewProgressObserver viewProgressObserver);

    void unregisterWatchPointsChangeObserver(WatchPointObserver watchPointObserver);

    void updateSubtitleDrawRect(int i);

    /* compiled from: IInteractLayerService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$setInlineMode(IInteractLayerService _this, boolean isInline) {
        }

        public static boolean $default$isInlineMode(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setDmViewReply(IInteractLayerService _this, DmViewReply reply) {
        }

        public static boolean $default$startFromShared(IInteractLayerService _this, Video.DanmakuResolveParams danmakuResolveParams) {
            return false;
        }

        public static boolean $default$getSegmentSwitchVisibility(IInteractLayerService _this) {
            return false;
        }

        public static boolean $default$getSegmentSwitchValue(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setSegmentSwitchValue(IInteractLayerService _this, boolean value) {
        }

        public static void $default$setForcedChapterGuide(IInteractLayerService _this, boolean value) {
        }

        public static void $default$setEyesProtectionMode(IInteractLayerService _this, boolean mode) {
        }

        public static void $default$loadThumbnailIfNeed(IInteractLayerService _this) {
        }

        public static void $default$loadThumbnailIfNeed2(IInteractLayerService _this) {
        }

        public static ThumbnailLoader $default$getThumbnailFetcher(IInteractLayerService _this) {
            return null;
        }

        public static ThumbnailLoader2 $default$getThumbnailFetcher2(IInteractLayerService _this) {
            return null;
        }

        public static boolean $default$hasThumbnails(IInteractLayerService _this) {
            return false;
        }

        public static boolean $default$hasThumbnails2(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setThumbnailEnable(IInteractLayerService _this, boolean enable) {
        }

        public static void $default$setThumbnail2Enable(IInteractLayerService _this, boolean enable) {
        }

        public static ViewProgressDetail $default$getViewProgressDetail(IInteractLayerService _this) {
            return null;
        }

        public static void $default$setChronosVisible(IInteractLayerService _this, boolean visible) {
        }

        public static void $default$removeDanmakuInteractionObserver(IInteractLayerService _this) {
        }

        public static MultiDanmakuPlayer $default$cloneMultiDanmaku(IInteractLayerService _this, Context content, IMultiDanmakuCallback multiDanmakuCallback) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(multiDanmakuCallback, "multiDanmakuCallback");
            return null;
        }

        public static void $default$setDanmakuViewOffset(IInteractLayerService _this, float offsetY) {
        }

        public static void $default$addDanmaku(IInteractLayerService _this, String dmId, int type, Object extra) {
        }

        public static boolean $default$isChronosValid(IInteractLayerService _this) {
            return false;
        }

        public static void $default$unregisterChronosReadyCallback(IInteractLayerService _this) {
        }

        public static void $default$runPackageForLive(IInteractLayerService _this, ChronosPackage pkg) {
        }

        public static void $default$clearChronosPackage(IInteractLayerService _this) {
        }

        public static void $default$clearDanmaku(IInteractLayerService _this) {
        }

        public static /* synthetic */ void setOnlineInfo$default(IInteractLayerService iInteractLayerService, Boolean bool, long j, long j2, String str, String str2, int i, Object obj) {
            String str3;
            String str4;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnlineInfo");
            }
            if ((i & 8) == 0) {
                str3 = str;
            } else {
                str3 = null;
            }
            if ((i & 16) == 0) {
                str4 = str2;
            } else {
                str4 = null;
            }
            iInteractLayerService.setOnlineInfo(bool, j, j2, str3, str4);
        }

        public static void $default$setOnlineInfo(IInteractLayerService _this, Boolean bool, long aid, long cid, String text, String logo) {
        }

        public static void $default$onStart(IInteractLayerService _this, PlayerSharingBundle bundle) {
        }

        public static void $default$onStop(IInteractLayerService _this) {
        }

        public static void $default$setDanmakuOptions(IInteractLayerService _this, DanmakuConfig.DanmakuOptionName name, Object... value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
        }

        public static boolean $default$sendUpDanmaku(IInteractLayerService _this, Context context, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return false;
        }

        public static void $default$setCustomSubtitleMargin(IInteractLayerService _this, boolean enable) {
        }

        public static boolean $default$isCustomSubtitleMargin(IInteractLayerService _this) {
            return false;
        }

        public static void $default$updateSubtitleDrawRect(IInteractLayerService _this, int bottomFix) {
        }

        public static int $default$getSubtitleBottomMargin(IInteractLayerService _this) {
            return 0;
        }

        public static boolean $default$isSubtitleShowInSettingWidget(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setSubtitleShowInSettingWidget(IInteractLayerService _this, boolean show) {
        }

        public static SubtitleItem $default$getMainSubtitle(IInteractLayerService _this) {
            return null;
        }

        public static SubtitleItem $default$getViceSubtitle(IInteractLayerService _this) {
            return null;
        }

        public static SubtitleItem $default$getInitViceSubtitle(IInteractLayerService _this) {
            return null;
        }

        public static void $default$loadSubtitle(IInteractLayerService _this, SubtitleItem mainSubtitle, SubtitleItem viceSubtitle) {
        }

        public static /* synthetic */ void recordSelectedSubtitle$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordSelectedSubtitle");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.recordSelectedSubtitle(z, z2);
        }

        public static void $default$recordSelectedSubtitle(IInteractLayerService _this, boolean isShare, boolean isManual) {
        }

        public static void $default$dispatchSubtitleModeChanged(IInteractLayerService _this) {
        }

        public static void $default$dispatchSubtitleDragChanged(IInteractLayerService _this) {
        }

        public static void $default$dispatchSubtitleLargeChanged(IInteractLayerService _this) {
        }

        public static void $default$setSubtitleAvailable(IInteractLayerService _this, boolean available) {
        }

        public static boolean $default$isSubtitleAvailable(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setForbidCloseSubtitle(IInteractLayerService _this, boolean forbid) {
        }

        public static boolean $default$isForbidCloseSubtitle(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setDanmakuMonopolizeTap(IInteractLayerService _this, boolean value) {
        }

        public static DanmakuInputClickInterceptor $default$getDanmakuInputClickInterceptor(IInteractLayerService _this) {
            return null;
        }

        public static void $default$setSceneAndBizParams(IInteractLayerService _this, ChronosScene scene, ChronosBiz biz) {
            Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
            Intrinsics.checkNotNullParameter(biz, "biz");
        }

        public static /* synthetic */ void reportDanmaku$default(IInteractLayerService iInteractLayerService, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse generalResponse, String str5, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDanmaku");
            }
            iInteractLayerService.reportDanmaku(str, str2, z, str3, str4, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? null : generalResponse, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : str5);
        }

        public static void $default$reportDanmaku(IInteractLayerService _this, String danmakuId, String reason, boolean shieldUser, String shieldUserId, String oid, boolean needReportAndGetBlockData, boolean blockUser, GeneralResponse rResponse, String dmContent) {
            Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        }

        public static void $default$appendFilters(IInteractLayerService _this, String shieldUserId, String regexFilter, Long nativeId, Runnable onSuccess) {
        }

        public static void $default$setChronosEnable(IInteractLayerService _this, boolean enable) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reloadViewProgress$default(IInteractLayerService iInteractLayerService, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadViewProgress");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            iInteractLayerService.reloadViewProgress(z, map);
        }

        public static void $default$reloadViewProgress(IInteractLayerService _this, boolean simplify, Map map) {
            Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(extra, "extra");
            reloadViewProgress$default(_this, null, 0L, simplify, extra, 2, null);
        }

        public static /* synthetic */ void reloadViewProgress$default(IInteractLayerService iInteractLayerService, FragmentParam fragmentParam, long j, boolean z, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadViewProgress");
            }
            iInteractLayerService.reloadViewProgress(fragmentParam, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z, (i & 8) != 0 ? MapsKt.emptyMap() : map);
        }

        public static void $default$syncStandardCardStatus(IInteractLayerService _this, int type, long activityId, long reserveId, boolean status) {
        }

        public static void $default$syncStandardCardStatusFromPlayer(IInteractLayerService _this, int type, long id, boolean status) {
        }

        public static void $default$setSyncCardStatusFromPlayerListener(IInteractLayerService _this, PlayerCardStatusSyncFromPlayerListener fromPlayerListener) {
        }

        public static void $default$setSyncCardStatusListener(IInteractLayerService _this, PlayerCardStatusSyncListener listener) {
        }

        public static ILocalHandler $default$getLocalHandler(IInteractLayerService _this) {
            return null;
        }

        public static IRemoteHandler $default$getRemoteHandler(IInteractLayerService _this) {
            return null;
        }

        public static AdDanmakuDelegate $default$getAdDanmakuDelegate(IInteractLayerService _this) {
            return null;
        }

        public static CommandsPanel $default$getDanmakuCommandPanel(IInteractLayerService _this) {
            return null;
        }

        public static Bitmap $default$getRenderViewBitmap(IInteractLayerService _this) {
            return null;
        }

        public static void $default$setDanmakuReplyHandler(IInteractLayerService _this, Function4 handler) {
        }

        public static ChronosThumbnailInfo.WatchPoint $default$findWatchPointByPosition(IInteractLayerService _this, int positionMS) {
            return null;
        }

        public static /* synthetic */ void switchAiRecommendedSwitch$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchAiRecommendedSwitch");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.switchAiRecommendedSwitch(z, z2);
        }

        public static void $default$switchAiRecommendedSwitch(IInteractLayerService _this, boolean aiRecommendedSwitch, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockRepeat$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockRepeat");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockRepeat(z, z2);
        }

        public static void $default$setBlockRepeat(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockTop$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockTop");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockTop(z, z2);
        }

        public static void $default$setBlockTop(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockScroll$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockScroll");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockScroll(z, z2);
        }

        public static void $default$setBlockScroll(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockBottom$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockBottom");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockBottom(z, z2);
        }

        public static void $default$setBlockBottom(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockColorful$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockColorful");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockColorful(z, z2);
        }

        public static void $default$setBlockColorful(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockSpecial$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockSpecial");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockSpecial(z, z2);
        }

        public static void $default$setBlockSpecial(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuAvoidScript$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuAvoidScript");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setDanmakuAvoidScript(z, z2);
        }

        public static void $default$setDanmakuAvoidScript(IInteractLayerService _this, boolean avoidScript, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuAvoidFigure$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuAvoidFigure");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setDanmakuAvoidFigure(z, z2);
        }

        public static void $default$setDanmakuAvoidFigure(IInteractLayerService _this, boolean avoidFigure, boolean fromUser) {
        }

        public static /* synthetic */ void setBlockFixed$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlockFixed");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlockFixed(z, z2);
        }

        public static void $default$setBlockFixed(IInteractLayerService _this, boolean block, boolean fromUser) {
        }

        public static /* synthetic */ void setBlackWordsEnable$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBlackWordsEnable");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setBlackWordsEnable(z, z2);
        }

        public static void $default$setBlackWordsEnable(IInteractLayerService _this, boolean enable, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuOpacity$default(IInteractLayerService iInteractLayerService, float f, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuOpacity");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setDanmakuOpacity(f, z);
        }

        public static void $default$setDanmakuOpacity(IInteractLayerService _this, float opacity, boolean fromUser) {
        }

        public static /* synthetic */ void setScaleFactor$default(IInteractLayerService iInteractLayerService, float f, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaleFactor");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setScaleFactor(f, z);
        }

        public static void $default$setScaleFactor(IInteractLayerService _this, float factor, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuDomain$default(IInteractLayerService iInteractLayerService, float f, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuDomain");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setDanmakuDomain(f, z);
        }

        public static void $default$setDanmakuDomain(IInteractLayerService _this, float domain, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuDisplayDomain$default(IInteractLayerService iInteractLayerService, float f, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuDisplayDomain");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setDanmakuDisplayDomain(f, z);
        }

        public static void $default$setDanmakuDisplayDomain(IInteractLayerService _this, float domain, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuDensity$default(IInteractLayerService iInteractLayerService, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuDensity");
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setDanmakuDensity(i, z);
        }

        public static void $default$setDanmakuDensity(IInteractLayerService _this, int density, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuSpeed$default(IInteractLayerService iInteractLayerService, float f, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuSpeed");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setDanmakuSpeed(f, z);
        }

        public static void $default$setDanmakuSpeed(IInteractLayerService _this, float speed, boolean fromUser) {
        }

        public static /* synthetic */ void setDanmakuFoldSwitchEnable$default(IInteractLayerService iInteractLayerService, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDanmakuFoldSwitchEnable");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            iInteractLayerService.setDanmakuFoldSwitchEnable(z, z2);
        }

        public static void $default$setDanmakuFoldSwitchEnable(IInteractLayerService _this, boolean enable, boolean fromUser) {
        }

        public static void $default$setBlockList(IInteractLayerService _this, boolean enable) {
        }

        public static void $default$blockDmids(IInteractLayerService _this, List list) {
            List dmids = EnhancedUnmodifiabilityKt.unmodifiable(list);
            Intrinsics.checkNotNullParameter(dmids, "dmids");
        }

        public static void $default$setDanmakuSwitchShareEnable(IInteractLayerService _this, boolean enable) {
        }

        public static void $default$setSubtitleStateShareEnable(IInteractLayerService _this, boolean enable) {
        }

        public static void $default$setDanmakuPlayerPanelSelectionText(IInteractLayerService _this, String text) {
        }

        public static String $default$getDanmakuPlayerPanelSelectionText(IInteractLayerService _this) {
            return null;
        }

        public static boolean $default$isDanmakuForbidden(IInteractLayerService _this) {
            return false;
        }

        public static String $default$getDanmakuForbiddenDescribe(IInteractLayerService _this) {
            return null;
        }

        public static /* synthetic */ void changeDanmakuSeniorModeSwitch$default(IInteractLayerService iInteractLayerService, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeDanmakuSeniorModeSwitch");
            }
            if ((i2 & 2) != 0) {
                z = true;
            }
            iInteractLayerService.changeDanmakuSeniorModeSwitch(i, z);
        }

        public static void $default$changeDanmakuSeniorModeSwitch(IInteractLayerService _this, int i, boolean fromUser) {
        }

        public static int $default$getDanmakuSeniorModeSwitch(IInteractLayerService _this) {
            return 0;
        }

        public static void $default$setDanmakuSendCustomScene(IInteractLayerService _this, Long scene) {
        }

        public static /* synthetic */ void setAiBlockLevel$default(IInteractLayerService iInteractLayerService, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAiBlockLevel");
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            iInteractLayerService.setAiBlockLevel(i, z);
        }

        public static void $default$setAiBlockLevel(IInteractLayerService _this, int level, boolean fromUser) {
        }

        public static void $default$setAiBlockLevelMap(IInteractLayerService _this, Map map) {
            Map levelTransferMap = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(levelTransferMap, "levelTransferMap");
        }

        public static int $default$getAiBlockLevel(IInteractLayerService _this) {
            return -1;
        }

        public static void $default$recallDanmaku(IInteractLayerService _this, CommentItem item, DanmakuRecallCallback callback) {
        }

        public static void $default$setDanmakuReplyObserver(IInteractLayerService _this, DanmakuReplyObserver observer) {
        }

        public static void $default$enableReply(IInteractLayerService _this, boolean enable) {
        }

        public static boolean $default$isEnableReply(IInteractLayerService _this) {
            return false;
        }

        public static void $default$setDmVideoSeekingEnable(IInteractLayerService _this, boolean enable) {
        }

        public static DanmakuReplyObserver $default$getDanmakuReplyObserver(IInteractLayerService _this) {
            return null;
        }

        public static /* synthetic */ void setMockDanmakuParams$default(IInteractLayerService iInteractLayerService, MockDanmakuParams mockDanmakuParams, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMockDanmakuParams");
            }
            if ((i & 1) != 0) {
                mockDanmakuParams = null;
            }
            iInteractLayerService.setMockDanmakuParams(mockDanmakuParams);
        }

        public static void $default$resetPreferences(IInteractLayerService _this) {
        }

        public static SubtitleItem $default$chooseMainSubtitle(IInteractLayerService _this, boolean force) {
            return null;
        }

        public static /* synthetic */ SubtitleItem chooseMainSubtitle$default(IInteractLayerService iInteractLayerService, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return iInteractLayerService.chooseMainSubtitle(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chooseMainSubtitle");
        }

        public static SubtitleItem $default$chooseViceSubtitle(IInteractLayerService _this, boolean force) {
            return null;
        }

        public static /* synthetic */ SubtitleItem chooseViceSubtitle$default(IInteractLayerService iInteractLayerService, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return iInteractLayerService.chooseViceSubtitle(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chooseViceSubtitle");
        }

        public static InteractLayerService.SubtitleKeyConfig $default$getSubtitleKeyConfig(IInteractLayerService _this) {
            return new InteractLayerService.SubtitleKeyConfig(null, null, null, 7, null);
        }

        public static void $default$enableBilingualSwitch(IInteractLayerService _this, boolean enable) {
        }

        public static boolean $default$bilingualSwitchEnabled(IInteractLayerService _this) {
            return true;
        }
    }
}