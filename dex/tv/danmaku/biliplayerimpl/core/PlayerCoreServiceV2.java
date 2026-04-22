package tv.danmaku.biliplayerimpl.core;

import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.media.resource.DashMediaIndex;
import com.bilibili.lib.media.resource.DashResource;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.PlayerCodecConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.clock.PlayerTimer;
import tv.danmaku.biliplayerv2.PlayerSharedState;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.BufferingObserver;
import tv.danmaku.biliplayerv2.service.IAssetUpdateObserver;
import tv.danmaku.biliplayerv2.service.ICurrentPositionInterceptor;
import tv.danmaku.biliplayerv2.service.IDurationInterceptor;
import tv.danmaku.biliplayerv2.service.IMediaCenterObserver;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IPlayerClockChangedObserver;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerLoopObserver;
import tv.danmaku.biliplayerv2.service.IPlayerPerformanceListener;
import tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver;
import tv.danmaku.biliplayerv2.service.IPlayerSourceObserver;
import tv.danmaku.biliplayerv2.service.IPlayerSpeedChangedObserver;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.ISeekInterceptor;
import tv.danmaku.biliplayerv2.service.IStartStreamIdSelector;
import tv.danmaku.biliplayerv2.service.OnAssetUpdateListener;
import tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener;
import tv.danmaku.biliplayerv2.service.OnRawDataWriteObserver;
import tv.danmaku.biliplayerv2.service.OnTrackInfoObserver;
import tv.danmaku.biliplayerv2.service.PlayerErrorObserver;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerSeekObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.PlayerVolumeChangeObserver;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.lock.DisablePlayLock;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.utils.PlayerOnlineParamHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.ijk.IjkMediaPlayerTrackerHelp;
import tv.danmaku.videoplayer.core.share.MediaPlayerShareParam;
import tv.danmaku.videoplayer.core.share.SharableObject;
import tv.danmaku.videoplayer.coreV2.ABRManagerKt;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayParams;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;
import tv.danmaku.videoplayer.coreV2.transformer.IMediaItemTransformer;
import tv.danmaku.videoplayer.coreV2.transformer.IjkMediaItemTransformer;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;
import tv.danmaku.videoplayer.coreV2.transformer.P2PParams;

/* compiled from: PlayerCoreServiceV2.kt */
@Metadata(d1 = {"\u0000»\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0003Y`e\b\u0000\u0018\u0000 °\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0004°\u0002±\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010k\u001a\u00020\u000eH\u0016J\b\u0010l\u001a\u00020mH\u0016J\b\u0010n\u001a\u00020mH\u0016J\b\u0010o\u001a\u00020mH\u0016J\b\u0010p\u001a\u00020mH\u0016J\u0018\u0010q\u001a\u00020m2\u0006\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\u000bH\u0016J\u0010\u0010t\u001a\u00020\u000e2\u0006\u0010r\u001a\u00020\u000eH\u0016J\u0010\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020?H\u0016J\u0010\u0010w\u001a\u00020m2\u0006\u0010v\u001a\u00020?H\u0016J\b\u0010x\u001a\u00020\u000eH\u0016J\u0012\u0010y\u001a\u00020m2\b\u0010v\u001a\u0004\u0018\u00010CH\u0016J\b\u0010z\u001a\u00020\u000eH\u0016J\b\u0010{\u001a\u00020\u000eH\u0016J\u0012\u0010|\u001a\u00020m2\b\u0010v\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010}\u001a\u00020\u000e2\u0006\u0010r\u001a\u00020\u000eH\u0002J\b\u0010~\u001a\u00020\u000eH\u0016J\b\u0010\u007f\u001a\u00020TH\u0016J\t\u0010\u0080\u0001\u001a\u00020mH\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0082\u0001\u001a\u000201H\u0002J$\u0010\u0083\u0001\u001a\u00020m2\u0007\u0010\u0082\u0001\u001a\u0002012\u0007\u0010\u0084\u0001\u001a\u00020\u000b2\u0007\u0010\u0085\u0001\u001a\u00020FH\u0016J\t\u0010\u0086\u0001\u001a\u00020mH\u0002J2\u0010\u0083\u0001\u001a\u00020m2\f\u0010\u0087\u0001\u001a\u0007\u0012\u0002\b\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u0002012\u0007\u0010\u0084\u0001\u001a\u00020\u000b2\u0007\u0010\u0085\u0001\u001a\u00020FH\u0016J\u0014\u0010\u008a\u0001\u001a\u00020m2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010NH\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010NH\u0016J\u0013\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0090\u0001\u001a\u00020TH\u0016J\u0012\u0010\u0091\u0001\u001a\u00020m2\u0007\u0010\u0092\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010\u0093\u0001\u001a\u00020m2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\u0013\u0010\u0096\u0001\u001a\u00020m2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J'\u0010\u0097\u0001\u001a\u00020m2\b\u0010\u0094\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010\u009b\u0001\u001a\u00030\u009a\u0001H\u0016J\u0013\u0010\u009c\u0001\u001a\u00020m2\b\u0010\u0094\u0001\u001a\u00030\u0098\u0001H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u000bH\u0016J\u0014\u0010\u009e\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010\u009f\u0001\u001a\u00020LH\u0016J\u0012\u0010 \u0001\u001a\u00020m2\u0007\u0010¡\u0001\u001a\u00020\tH\u0016J\u0012\u0010¢\u0001\u001a\u00020m2\u0007\u0010£\u0001\u001a\u00020\u000bH\u0016J\t\u0010¤\u0001\u001a\u00020\u000bH\u0016J\t\u0010¥\u0001\u001a\u00020\u000eH\u0016J\t\u0010¦\u0001\u001a\u00020\u000eH\u0016J\n\u0010§\u0001\u001a\u00030¨\u0001H\u0016J\t\u0010©\u0001\u001a\u00020\u000eH\u0016J\u001a\u0010ª\u0001\u001a\u00020\u000e2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0003\u0010¬\u0001J\t\u0010\u00ad\u0001\u001a\u00020mH\u0016J\u0012\u0010®\u0001\u001a\u00020\u000b2\u0007\u0010¯\u0001\u001a\u00020\u000eH\u0016J\f\u0010°\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0002J\u0012\u0010±\u0001\u001a\u00020m2\u0007\u0010¯\u0001\u001a\u00020\u000eH\u0016J$\u0010²\u0001\u001a\u00020m2\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010´\u0001\u001a\u00020\u000e2\u0007\u0010µ\u0001\u001a\u00020\u000eH\u0016J\t\u0010¶\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010·\u0001\u001a\u00020m2\u0007\u0010¸\u0001\u001a\u00020\u000eH\u0016J\u0014\u0010¹\u0001\u001a\u00030\u009a\u00012\b\u0010º\u0001\u001a\u00030»\u0001H\u0016J\u001b\u0010¼\u0001\u001a\u00020m2\u0007\u0010´\u0001\u001a\u00020\u000e2\u0007\u0010µ\u0001\u001a\u00020\u000eH\u0016J\t\u0010½\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010¾\u0001\u001a\u00020m2\u0007\u0010¿\u0001\u001a\u00020\u000eH\u0002J\t\u0010À\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010Á\u0001\u001a\u00020m2\u0007\u0010Â\u0001\u001a\u00020\u0007H\u0016J\u001d\u0010Ã\u0001\u001a\u00020m2\b\u0010Ä\u0001\u001a\u00030Å\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0016J\u001f\u0010È\u0001\u001a\u00020m2\b\u0010Ä\u0001\u001a\u00030Å\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\u0015\u0010É\u0001\u001a\u00020m2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0002J\u0015\u0010Ê\u0001\u001a\u00020m2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0002J\u0015\u0010Ë\u0001\u001a\u00020m2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\t\u0010Ì\u0001\u001a\u00020mH\u0016J \u0010Í\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u00112\f\u0010Î\u0001\u001a\u00030¨\u0001\"\u00020\u000eH\u0016J\u0012\u0010Ï\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0011H\u0016J\t\u0010Ð\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010Ñ\u0001\u001a\u00020m2\u0007\u0010Ò\u0001\u001a\u00020\u000bH\u0016J\t\u0010Ó\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010Ô\u0001\u001a\u00020T2\u0007\u0010Õ\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010Ö\u0001\u001a\u00020m2\u0007\u0010×\u0001\u001a\u00020TH\u0016J\u0011\u0010Ø\u0001\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0003\u0010Ù\u0001J\f\u0010Ú\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\t\u0010Û\u0001\u001a\u00020mH\u0016J\u0012\u0010Ü\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010Ý\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010Þ\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010ß\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010à\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010á\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010â\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020%H\u0016J\u0012\u0010ã\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020%H\u0016J\u0012\u0010ä\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020'H\u0016J\u0012\u0010å\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020'H\u0016J\u0012\u0010æ\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010ç\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010è\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020!H\u0016J\u0012\u0010é\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020!H\u0016J\u0012\u0010ê\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020)H\u0016J\u0012\u0010ë\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020)H\u0016J\u000b\u0010ì\u0001\u001a\u0004\u0018\u000101H\u0016J\n\u0010í\u0001\u001a\u00030î\u0001H\u0016J\u0012\u0010ï\u0001\u001a\u00020m2\u0007\u0010\u0089\u0001\u001a\u000201H\u0016J\u0013\u0010ð\u0001\u001a\u00020m2\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016J\u0012\u0010ó\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010ô\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010õ\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010ö\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010÷\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020+H\u0016J\u0012\u0010ø\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020+H\u0016J\u0012\u0010ù\u0001\u001a\u00020m2\u0007\u0010ú\u0001\u001a\u00020\u000eH\u0002J\t\u0010û\u0001\u001a\u00020mH\u0002J\u0012\u0010ü\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u000206H\u0016J\u0012\u0010ý\u0001\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u000206H\u0016J\t\u0010þ\u0001\u001a\u00020\u000bH\u0016J\t\u0010ÿ\u0001\u001a\u00020mH\u0002J\n\u0010\u0080\u0002\u001a\u00030\u0081\u0002H\u0016J\u0012\u0010\u0082\u0002\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u0083\u0002\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u0084\u0002\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020#H\u0016J\u0012\u0010\u0085\u0002\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020#H\u0016J\u0014\u0010\u0086\u0002\u001a\u00020m2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010;H\u0016J\u0014\u0010\u0088\u0002\u001a\u00020m2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010=H\u0016J\u000b\u0010\u0089\u0002\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010\u008a\u0002\u001a\u00020m2\u0007\u0010\u008b\u0002\u001a\u00020\u000bH\u0016J\u001b\u0010\u008c\u0002\u001a\u00020m2\u0007\u0010\u008d\u0002\u001a\u00020T2\u0007\u0010\u008e\u0002\u001a\u00020TH\u0016J\u0015\u0010\u008f\u0002\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020T0SH\u0016J\u0012\u0010\u0090\u0002\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0091\u0002\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020.H\u0016J\n\u0010\u0092\u0002\u001a\u00030\u009a\u0001H\u0016J\"\u0010\u0093\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0088\u00012\u0007\u0010\u0085\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u000201H\u0016J\t\u0010\u009a\u0002\u001a\u00020\u000bH\u0002J\u0014\u0010\u009b\u0002\u001a\u00030\u0096\u00022\b\u0010\u009c\u0002\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010\u009d\u0002\u001a\u00020m2\b\u0010\u009e\u0002\u001a\u00030\u0096\u0002H\u0016J\u0014\u0010\u009f\u0002\u001a\u00020m2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010HH\u0016J)\u0010 \u0002\u001a\u00020\u000b2\u000e\u0010¡\u0002\u001a\t\u0012\u0004\u0012\u00020m0¢\u00022\u000e\u0010£\u0002\u001a\t\u0012\u0004\u0012\u00020m0¢\u0002H\u0016J\u0017\u0010¤\u0002\u001a\u00020m2\f\u0010\u0087\u0001\u001a\u0007\u0012\u0002\b\u00030\u0088\u0001H\u0002J\u0013\u0010¥\u0002\u001a\u00020m2\b\u0010¦\u0002\u001a\u00030§\u0002H\u0002J\u0014\u0010¨\u0002\u001a\u00020m2\t\u0010\u0082\u0001\u001a\u0004\u0018\u000101H\u0002J\u0010\u0010©\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0088\u0001H\u0016J\t\u0010ª\u0002\u001a\u00020\u000bH\u0016J\u0012\u0010«\u0002\u001a\u00020m2\u0007\u0010Ò\u0001\u001a\u00020\u000bH\u0016J\t\u0010¬\u0002\u001a\u00020\u000bH\u0016J\t\u0010\u00ad\u0002\u001a\u00020\u000bH\u0002J\t\u0010®\u0002\u001a\u00020mH\u0002J\u0017\u0010¯\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010SH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000Rh\u0010\f\u001aZ\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u000f*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0010 \u000f*,\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u000f*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0010\u0018\u00010\r0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00130\u0013 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00150\u0015 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00170\u0017 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0018\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00190\u0019 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u001a\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u001b0\u001b \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u001c\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u001d0\u001d \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u001e\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u001f0\u001f \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010 \u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010!0! \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010!0!\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\"\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010#0# \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010#0#\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010$\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010%0% \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010%0%\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010&\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010'0' \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010'0'\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010(\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010)0) \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010)0)\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010*\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010+0+ \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010+0+\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010,\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\t0\t \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\t0\t\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010-\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010.0. \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010.0.\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R2\u00105\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010606 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010606\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010>\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010?0? \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010?0?\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020T0SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ZR\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010fR\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0094\u0002\u001a\u0016\u0012\u0005\u0012\u00030\u0096\u00020\u0095\u0002j\n\u0012\u0005\u0012\u00030\u0096\u0002`\u0097\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0002\u001a\u00030\u0099\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006²\u0002"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2;", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "Ltv/danmaku/biliplayerimpl/core/IPlayerRenderContextService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mMediaPlayContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext;", "mPlayFromSharedEnable", "", "mPlayerStateObserverMap", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorMap;", "", "kotlin.jvm.PlatformType", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "mPlayerSeekObserverList", "Ltv/danmaku/biliplayerv2/service/PlayerSeekObserver;", "mBufferingObserverList", "Ltv/danmaku/biliplayerv2/service/BufferingObserver;", "mSpeedChangedObservers", "Ltv/danmaku/biliplayerv2/service/IPlayerSpeedChangedObserver;", "mLoopObservers", "Ltv/danmaku/biliplayerv2/service/IPlayerLoopObserver;", "mRenderStartObserverList", "Ltv/danmaku/biliplayerv2/service/IRenderStartObserver;", "mPlayerClockObserverList", "Ltv/danmaku/biliplayerv2/service/IPlayerClockChangedObserver;", "mPlayerReleaseObserverList", "Ltv/danmaku/biliplayerv2/service/IPlayerReleaseObserver;", "mMediaCenterObserverList", "Ltv/danmaku/biliplayerv2/service/IMediaCenterObserver;", "mMediaResourceObserverList", "Ltv/danmaku/biliplayerv2/service/IMediaResourceObserver;", "mOnRawDataWriteObserverList", "Ltv/danmaku/biliplayerv2/service/OnRawDataWriteObserver;", "mOnTrackInfoObserverList", "Ltv/danmaku/biliplayerv2/service/OnTrackInfoObserver;", "mAssetUpdateObserverList", "Ltv/danmaku/biliplayerv2/service/IAssetUpdateObserver;", "mPlayerErrorObserverList", "Ltv/danmaku/biliplayerv2/service/PlayerErrorObserver;", "mMultiMediaContexts", "mPlayVolumeChangeObserverList", "Ltv/danmaku/biliplayerv2/service/PlayerVolumeChangeObserver;", "mCurrentPlayerState", "mMediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "mAutoStart", "mMediaItemTransformer", "Ltv/danmaku/videoplayer/coreV2/transformer/IMediaItemTransformer;", "mPlayerSourceObservers", "Ltv/danmaku/biliplayerv2/service/IPlayerSourceObserver;", "mAbsentPlayerByOther", "mRestoringFromShutdownByOthers", "mIsCorePlayerActive", "mAssetUpdateListener", "Ltv/danmaku/biliplayerv2/service/OnAssetUpdateListener;", "mMeteredNetworkUrlHookListener", "Ltv/danmaku/biliplayerv2/service/OnMeteredNetworkUrlHookListener;", "mSeekInterceptorList", "Ltv/danmaku/biliplayerv2/service/ISeekInterceptor;", "mCurrentPositionInterceptor", "Ltv/danmaku/biliplayerv2/service/ICurrentPositionInterceptor;", "mDurationInterceptor", "Ltv/danmaku/biliplayerv2/service/IDurationInterceptor;", "mProjectionScreenAvailable", "mCurrentMediaItemParams", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "mPlayerPerformanceListener", "Ltv/danmaku/biliplayerv2/service/IPlayerPerformanceListener;", "mRestoreState", "Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$RestoreState;", "mMediaPlayParams", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "mStartStreamIdSelector", "Ltv/danmaku/biliplayerv2/service/IStartStreamIdSelector;", "mMiniPlayerAvailable", "mPlayerTimer", "Ltv/danmaku/biliplayerimpl/clock/PlayerTimer;", "playerVolume", "Lkotlin/Pair;", "", "mReconnectIjkTime", "mOnPreparedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "mOnMediaStreamChangedListener", "tv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mOnMediaStreamChangedListener$1", "Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mOnMediaStreamChangedListener$1;", "mOnInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "mSeekCompleteListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "mOnExtraInfoListener", "tv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mOnExtraInfoListener$1", "Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mOnExtraInfoListener$1;", "mOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "mItemUpdateListener", "tv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mItemUpdateListener$1", "Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mItemUpdateListener$1;", "mPlayerClockChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPlayerClockChangedListener;", "mOnRawDataWriteListener", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnRawDataWriteListener;", "getCurrentQuality", "play", "", "pause", "resume", "stop", "seekTo", "position", "accurate", "interceptSeekTarget", "addSeekInterceptor", "interceptor", "removeSeekInterceptor", "getDuration", "setDurationInterceptor", "getRealDuration", "getCurrentPosition", "setCurrentPositionInterceptor", "interceptPosition", "getRealCurrentPosition", "getBufferedPercentage", "resetMediaResource", "checkMediaResource", "resource", "setMediaResource", "autoStart", "itemParams", "resetRestoreState", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "mediaResource", "setStartStreamIdSelector", "selector", "getStartStreamIdSelector", "getCurrentPlayUrl", "", "isAudio", "getVideoFps", "setLooping", "looping", "registerPlayerProgressObserver", "observer", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterPlayerProgressObserver", "registerPlayerProgressRangeObserver", "Ltv/danmaku/biliplayerv2/clock/PlayerProgressRangeObserver;", "startPosition", "", "endPosition", "unregisterPlayerProgressRangeObserver", "isCorePlayerActive", "createMultiMediaContext", "mediaParam", "releaseMultiMediaContext", "mediaContext", "setBufferLimit", "limit", "isBufferLimit", "getDefaultAudioIndex", "getCurrentAudioIndex", "getAudioStreamsIndex", "", "getCurrentAudioStream", "setAudioIndex", "index", "(Ljava/lang/Integer;)I", "resetAudioIndex", "supportQuality", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "getSupportsQuality", "switchQuality", "setDashAuto", "flag", "minQuality", "maxQuality", "getDashAuto", "setAudioStreamId", "id", "getMediaSize", "codec", "Ltv/danmaku/ijk/media/player/IjkMediaAsset$VideoCodecType;", "switchAutoQuality", "isThirdPlayer", "setState", "state", "getState", "bindPlayerContainer", "playerContainer", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onAttachByShared", "ensureMediaContext", "ensureMediaPlayParams", "onStart", "onStop", "registerState", "states", "unregisterState", "supportProjectionScreen", "setProjectionScreenAvailable", "available", "isProjectionScreenAvailable", "getPlaySpeed", "forceFromNative", "setPlaySpeed", "speed", "isVariableResolutionRatio", "()Ljava/lang/Boolean;", "getPlayFailReason", "removeCurrentSource", "addPlayerLoopObserver", "removePlayerLoopObserver", "addPlayerSpeedChangedObserver", "removePlayerSpeedChangedObserver", "addPlayerClockChangedObserver", "removePlayerClockChangedObserver", "addPlayerOnRawDataWriteObserver", "removePlayerOnRawDataWriteObserver", "addPlayerOnTrackInfoObserver", "removePlayerOnTrackInfoObserver", "addPlayerReleaseObserver", "removePlayerReleaseObserver", "addMediaCenterObserver", "removeMediaCenterObserver", "addAssetUpdateObserver", "removeAssetUpdateObserver", "getMediaResource", "getRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "updateMediaResource", "updateP2PParams", "params", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "registerSeekObserver", "unregisterSeekObserver", "registerBufferingState", "unregisterBufferingState", "registerPlayerErrorObserver", "unregisterPlayerErrorObserver", "notifyBufferingStart", "extra", "notifyBufferingEnd", "addPlayerSourceObserver", "removePlayerSourceObserver", "tryToRestoreFromShutDownByOthers", "restorePlayer", "getPlayerCodecConfig", "Lcom/bilibili/lib/media/resource/PlayerCodecConfig;", "addRenderStartObserver", "removeRenderStartObserver", "addMediaResourceObserver", "removeMediaResourceObserver", "setAssetUpdateListener", "listener", "setMeteredNetworkUrlHookListener", "getMeteredNetworkUrlHookListener", "setAudioOnly", "audioOnly", "setVolume", "left", "right", "getVolume", "registerVolumeChangeObserver", "unregisterVolumeChangeObserver", "getTcpSpeed", "createMediaItem", "mDisablePlayLockList", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/lock/DisablePlayLock;", "Lkotlin/collections/ArrayList;", "mDisablePlaySync", "Ljava/lang/Object;", "isDisablePlay", "acquireDisablePlayLock", "name", "releaseDisablePlayLock", "lock", "setPlayerPerformanceListener", "playFromShared", "prepare", "Lkotlin/Function0;", "success", "setMediaItem", "notifyTrackInfo", "mediaPlayer", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "dispatchMediaResourceChanged", "getCurrentMediaItem", "supportMiniPlayer", "setMiniPlayerAvailable", "isMiniPlayerAvailable", "isLiveResource", "setMonitorToMediaPlayer", "getDashAutoRange", "Companion", "RestoreState", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCoreServiceV2 extends AbsCorePlayerService implements IPlayerCoreService, IPlayerRenderContextService {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_SHARE_MEDIA_ITEM_PARAMS = "key_share_media_item_params";
    private static final String KEY_SHARE_MEDIA_PLAY_PARAMS = "key_share_media_play_params";
    private static final String KEY_SHARE_MEDIA_RESOURCE = "key_share_media_resource";
    private static final String KEY_SHARE_PLAY_DURATION = "key_share_player_duration";
    private static final String KEY_SHARE_PLAY_POSITION = "key_share_player_position";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final int MAX_MULTI_MEDIA_CONTEXT = 1;
    private static final int MAX_RECONNECT_IJK_TIMES = 1;
    private static final String TAG = "PlayerCoreServiceV2";
    private boolean mAbsentPlayerByOther;
    private OnAssetUpdateListener mAssetUpdateListener;
    private boolean mAutoStart;
    private MediaItemParams mCurrentMediaItemParams;
    private int mCurrentPlayerState;
    private ICurrentPositionInterceptor mCurrentPositionInterceptor;
    private final ArrayList<DisablePlayLock> mDisablePlayLockList;
    private final Object mDisablePlaySync;
    private IDurationInterceptor mDurationInterceptor;
    private final PlayerCoreServiceV2$mItemUpdateListener$1 mItemUpdateListener;
    private IMediaItemTransformer mMediaItemTransformer;
    private IMediaPlayContext mMediaPlayContext;
    private IMediaPlayParams mMediaPlayParams;
    private MediaResource mMediaResource;
    private OnMeteredNetworkUrlHookListener mMeteredNetworkUrlHookListener;
    private final IMediaPlayer.OnErrorListener mOnErrorListener;
    private final PlayerCoreServiceV2$mOnExtraInfoListener$1 mOnExtraInfoListener;
    private final IMediaPlayer.OnInfoListener mOnInfoListener;
    private final PlayerCoreServiceV2$mOnMediaStreamChangedListener$1 mOnMediaStreamChangedListener;
    private final IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private final IjkMediaPlayer.OnRawDataWriteListener mOnRawDataWriteListener;
    private boolean mPlayFromSharedEnable;
    private final IMediaPlayer.OnPlayerClockChangedListener mPlayerClockChangedListener;
    private PlayerContainerImpl mPlayerContainer;
    private IPlayerPerformanceListener mPlayerPerformanceListener;
    private int mReconnectIjkTime;
    private RestoreState mRestoreState;
    private boolean mRestoringFromShutdownByOthers;
    private final IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener;
    private IStartStreamIdSelector mStartStreamIdSelector;
    private Pair<Float, Float> playerVolume;
    private final Collections.SafeIteratorMap<Integer, Collections.SafeIteratorList<PlayerStateObserver>> mPlayerStateObserverMap = Collections.safeIteratorMap(new HashMap());
    private final Collections.SafeIteratorList<PlayerSeekObserver> mPlayerSeekObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<BufferingObserver> mBufferingObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IPlayerSpeedChangedObserver> mSpeedChangedObservers = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IPlayerLoopObserver> mLoopObservers = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IRenderStartObserver> mRenderStartObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IPlayerClockChangedObserver> mPlayerClockObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IPlayerReleaseObserver> mPlayerReleaseObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IMediaCenterObserver> mMediaCenterObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IMediaResourceObserver> mMediaResourceObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<OnRawDataWriteObserver> mOnRawDataWriteObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<OnTrackInfoObserver> mOnTrackInfoObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<IAssetUpdateObserver> mAssetUpdateObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<PlayerErrorObserver> mPlayerErrorObserverList = Collections.safeIteratorList(new LinkedList());
    private Collections.SafeIteratorList<IMediaPlayContext> mMultiMediaContexts = Collections.safeIteratorList(new ArrayList());
    private final Collections.SafeIteratorList<PlayerVolumeChangeObserver> mPlayVolumeChangeObserverList = Collections.safeIteratorList(new LinkedList());
    private Collections.SafeIteratorList<IPlayerSourceObserver> mPlayerSourceObservers = Collections.safeIteratorList(new ArrayList());
    private boolean mIsCorePlayerActive = true;
    private Collections.SafeIteratorList<ISeekInterceptor> mSeekInterceptorList = Collections.safeIteratorList(new ArrayList());
    private boolean mProjectionScreenAvailable = true;
    private boolean mMiniPlayerAvailable = true;
    private PlayerTimer mPlayerTimer = new PlayerTimer(new WeakReference(this));

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public /* synthetic */ void seekTo(int i) {
        seekTo(i, false);
    }

    /* compiled from: PlayerCoreServiceV2.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$Companion;", "", "<init>", "()V", "TAG", "", "KEY_TIMESTAMP", "KEY_SHARE_MEDIA_PLAY_PARAMS", "KEY_SHARE_PLAY_POSITION", "KEY_SHARE_PLAY_DURATION", "KEY_SHARE_MEDIA_RESOURCE", "KEY_SHARE_MEDIA_ITEM_PARAMS", "MAX_MULTI_MEDIA_CONTEXT", "", "MAX_RECONNECT_IJK_TIMES", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PlayerCoreServiceV2() {
        Float valueOf = Float.valueOf(1.0f);
        this.playerVolume = new Pair<>(valueOf, valueOf);
        this.mOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                PlayerCoreServiceV2.mOnPreparedListener$lambda$0(PlayerCoreServiceV2.this, iMediaPlayer);
            }
        };
        this.mOnMediaStreamChangedListener = new PlayerCoreServiceV2$mOnMediaStreamChangedListener$1(this);
        this.mOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2, Bundle bundle) {
                boolean mOnInfoListener$lambda$0;
                mOnInfoListener$lambda$0 = PlayerCoreServiceV2.mOnInfoListener$lambda$0(PlayerCoreServiceV2.this, iMediaPlayer, i, i2, bundle);
                return mOnInfoListener$lambda$0;
            }
        };
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
                PlayerCoreServiceV2.mSeekCompleteListener$lambda$0(PlayerCoreServiceV2.this, iMediaPlayer);
            }
        };
        this.mOnExtraInfoListener = new PlayerCoreServiceV2$mOnExtraInfoListener$1(this);
        this.mOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                boolean mOnErrorListener$lambda$0;
                mOnErrorListener$lambda$0 = PlayerCoreServiceV2.mOnErrorListener$lambda$0(PlayerCoreServiceV2.this, iMediaPlayer, i, i2);
                return mOnErrorListener$lambda$0;
            }
        };
        this.mItemUpdateListener = new PlayerCoreServiceV2$mItemUpdateListener$1(this);
        this.mPlayerClockChangedListener = new IMediaPlayer.OnPlayerClockChangedListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPlayerClockChangedListener
            public final void onPlayerClockChanged(IMediaPlayer iMediaPlayer, float f, long j) {
                PlayerCoreServiceV2.mPlayerClockChangedListener$lambda$0(PlayerCoreServiceV2.this, iMediaPlayer, f, j);
            }
        };
        this.mOnRawDataWriteListener = new IjkMediaPlayer.OnRawDataWriteListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda6
            @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnRawDataWriteListener
            public final int onRawDataWrite(IMediaPlayer iMediaPlayer, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
                int mOnRawDataWriteListener$lambda$0;
                mOnRawDataWriteListener$lambda$0 = PlayerCoreServiceV2.mOnRawDataWriteListener$lambda$0(PlayerCoreServiceV2.this, iMediaPlayer, bArr, i, i2, i3, i4, i5);
                return mOnRawDataWriteListener$lambda$0;
            }
        };
        this.mDisablePlayLockList = new ArrayList<>();
        this.mDisablePlaySync = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreparedListener$lambda$0(PlayerCoreServiceV2 this$0, IMediaPlayer it) {
        Pair range;
        PlayerLog.i(TAG, "[ijk][callback]player onPrepared");
        PlayerContainerImpl playerContainerImpl = this$0.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.setSharing(false);
        this$0.setPlaySpeed(IPlayerCoreService.CC.getPlaySpeed$default(this$0, false, 1, null));
        boolean autoStart = this$0.mAutoStart;
        this$0.mAutoStart = false;
        if (this$0.mRestoringFromShutdownByOthers && this$0.mRestoreState != null) {
            this$0.mRestoringFromShutdownByOthers = false;
            RestoreState restoreState = this$0.mRestoreState;
            if (restoreState != null && (range = restoreState.getAutoRange()) != null) {
                this$0.setDashAuto(true, ((Number) range.getFirst()).intValue(), ((Number) range.getSecond()).intValue());
            }
            RestoreState restoreState2 = this$0.mRestoreState;
            Integer targetState = restoreState2 != null ? Integer.valueOf(restoreState2.getStateWhenShutdown()) : null;
            this$0.resetRestoreState();
            if (targetState != null && targetState.intValue() == 4) {
                this$0.resume();
                return;
            } else {
                this$0.pause();
                return;
            }
        }
        if (autoStart) {
            this$0.resume();
        } else {
            PlayerLog.w(TAG, "startOnPrepared:" + this$0.mAutoStart);
        }
        Intrinsics.checkNotNull(it);
        this$0.notifyTrackInfo(it);
        MediaResource mediaResource = this$0.mMediaResource;
        if (mediaResource != null) {
            mediaResource.startPosition = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnInfoListener$lambda$0(PlayerCoreServiceV2 this$0, IMediaPlayer iMediaPlayer, int what, int extra, Bundle bundle) {
        long timestamp;
        switch (what) {
            case 3:
                IPlayerPerformanceListener playerPerformanceListener = this$0.mPlayerPerformanceListener;
                PlayerLog.i(TAG, "MEDIA_INFO_VIDEO_RENDERING_START, playerPerformanceListener = " + playerPerformanceListener);
                if (playerPerformanceListener != null) {
                    if (bundle != null) {
                        timestamp = bundle.getLong("timestamp");
                    } else {
                        PlayerLog.e(TAG, "Null bundle???");
                        timestamp = SystemClock.elapsedRealtime();
                    }
                    playerPerformanceListener.onVideoFirstRender(timestamp);
                }
                this$0.mRenderStartObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda0
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IRenderStartObserver) obj).onVideoRenderStart();
                    }
                });
                return true;
            case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                PlayerLog.i(TAG, "buffering start");
                this$0.notifyBufferingStart(extra);
                return true;
            case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                PlayerLog.i(TAG, "buffering end");
                this$0.notifyBufferingEnd();
                return true;
            case 10002:
                this$0.mRenderStartObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda11
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IRenderStartObserver) obj).onAudioRenderStart();
                    }
                });
                return true;
            case IMediaPlayer.MEDIA_INFO_MEDIA_END_PREPARE /* 10102 */:
                if (bundle != null) {
                    long timestamp2 = bundle.getLong("timestamp");
                    IPlayerPerformanceListener iPlayerPerformanceListener = this$0.mPlayerPerformanceListener;
                    if (iPlayerPerformanceListener != null) {
                        iPlayerPerformanceListener.onPlayerPrepared(timestamp2);
                        return true;
                    }
                    return true;
                }
                return true;
            case IMediaPlayer.MEDIA_INFO_MEDIA_STATE_CHANGED /* 10105 */:
                this$0.setState(extra);
                return true;
            case IMediaPlayer.MEDIA_INFO_MEDIA_LOOP /* 10110 */:
                this$0.mLoopObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda22
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IPlayerLoopObserver) obj).onPlayerLooped();
                    }
                });
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSeekCompleteListener$lambda$0(PlayerCoreServiceV2 this$0, final IMediaPlayer mp) {
        final int currPosition = this$0.getCurrentPosition();
        this$0.mPlayerSeekObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda24
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.mSeekCompleteListener$lambda$0$0(IMediaPlayer.this, currPosition, (PlayerSeekObserver) obj);
            }
        });
        PlayerLog.i(TAG, "[player]seek complete " + currPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSeekCompleteListener$lambda$0$0(IMediaPlayer $mp, int $currPosition, PlayerSeekObserver it) {
        if ($mp != null) {
            it.onSeekComplete($currPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnErrorListener$lambda$0(final PlayerCoreServiceV2 this$0, final IMediaPlayer p0, final int p1, final int p2) {
        PlayerLog.e(TAG, "ijk onError:" + p0 + "," + p1 + "," + p2);
        final Pair autoRange = this$0.getDashAutoRange();
        final int state = this$0.getState();
        final int videoStreamId = this$0.getCurrentQuality();
        if (p1 == 10001 && !this$0.isThirdPlayer() && this$0.mReconnectIjkTime < 1 && this$0.mMediaResource != null && this$0.mCurrentMediaItemParams != null) {
            Runnable runnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerCoreServiceV2.mOnErrorListener$lambda$0$0(PlayerCoreServiceV2.this, state, autoRange, videoStreamId);
                }
            };
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                HandlerThreads.post(0, runnable);
            } else {
                runnable.run();
            }
            return true;
        }
        this$0.mAbsentPlayerByOther = true;
        this$0.mRestoreState = new RestoreState(state, Integer.valueOf(videoStreamId), autoRange);
        Runnable runnable2 = new Runnable() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                PlayerCoreServiceV2.mOnErrorListener$lambda$0$1(PlayerCoreServiceV2.this, p0, p1, p2);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            HandlerThreads.post(0, runnable2);
        } else {
            runnable2.run();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnErrorListener$lambda$0$0(PlayerCoreServiceV2 this$0, int $state, Pair $autoRange, int $videoStreamId) {
        MediaItemParams mediaItemParams;
        long currentPosition;
        MediaItemParams mediaItemParams2 = this$0.mCurrentMediaItemParams;
        if (mediaItemParams2 != null && (mediaItemParams = MediaItemParams.copy$default(mediaItemParams2, null, 0, false, 0, false, 0L, false, 0, null, 0L, 0L, false, 0, 0L, 0, 0, 0, false, 0, false, null, null, false, null, null, null, null, false, false, 0L, null, false, false, null, -1, 3, null)) != null) {
            if (!this$0.isLiveResource()) {
                switch ($state) {
                    case 4:
                    case 5:
                        currentPosition = this$0.getCurrentPosition();
                        break;
                    default:
                        currentPosition = 0;
                        break;
                }
                mediaItemParams.setStartPosition(currentPosition);
            }
            mediaItemParams.setRecommendStartQualityRange($autoRange);
            switch ($state) {
                case 4:
                case 5:
                case 6:
                    mediaItemParams.setVideoStreamId($videoStreamId);
                    break;
            }
            IMediaPlayContext iMediaPlayContext = this$0.mMediaPlayContext;
            if (iMediaPlayContext != null) {
                iMediaPlayContext.reset();
            }
            if ($state == 4) {
                this$0.notifyBufferingStart(1);
            }
            mediaItemParams.setRenderAfterPrepare(true);
            this$0.mMediaCenterObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda7
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((IMediaCenterObserver) obj).onPlayerReconnect();
                }
            });
            MediaResource mediaResource = this$0.mMediaResource;
            Intrinsics.checkNotNull(mediaResource);
            this$0.setMediaResource(mediaResource, $state == 4, mediaItemParams);
            this$0.mReconnectIjkTime++;
            PlayerLog.e(TAG, "~~~~~~ ijk onError:disconnect, try restore: " + this$0.mReconnectIjkTime + " state:" + $state + " videoId:" + mediaItemParams.getVideoStreamId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnErrorListener$lambda$0$1(PlayerCoreServiceV2 this$0, final IMediaPlayer $p0, final int $p1, final int $p2) {
        this$0.mPlayerErrorObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda28
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.mOnErrorListener$lambda$0$1$0(IMediaPlayer.this, $p1, $p2, (PlayerErrorObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnErrorListener$lambda$0$1$0(IMediaPlayer $p0, int $p1, int $p2, PlayerErrorObserver it) {
        Intrinsics.checkNotNull($p0);
        it.onPlayerError($p0, $p1, $p2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPlayerClockChangedListener$lambda$0(final PlayerCoreServiceV2 this$0, IMediaPlayer iMediaPlayer, final float speed, final long currentPosition) {
        this$0.mPlayerClockObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda26
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.mPlayerClockChangedListener$lambda$0$0(PlayerCoreServiceV2.this, currentPosition, speed, (IPlayerClockChangedObserver) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPlayerClockChangedListener$lambda$0$0(PlayerCoreServiceV2 this$0, long $currentPosition, float $speed, IPlayerClockChangedObserver it) {
        long position = this$0.interceptPosition((int) $currentPosition);
        PlayerLog.i(TAG, "player clock changed, speed " + $speed + ", ijk real position " + $currentPosition + ", interceptor position " + position);
        it.onPlayerClockChanged($speed, position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int mOnRawDataWriteListener$lambda$0(PlayerCoreServiceV2 this$0, final IMediaPlayer p0, final byte[] p1, final int p2, final int p3, final int p4, final int p5, final int p6) {
        this$0.mOnRawDataWriteObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda27
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.mOnRawDataWriteListener$lambda$0$0(IMediaPlayer.this, p1, p2, p3, p4, p5, p6, (OnRawDataWriteObserver) obj);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnRawDataWriteListener$lambda$0$0(IMediaPlayer $p0, byte[] $p1, int $p2, int $p3, int $p4, int $p5, int $p6, OnRawDataWriteObserver it) {
        Intrinsics.checkNotNull($p0);
        Intrinsics.checkNotNull($p1);
        it.onRawDataWrite($p0, $p1, $p2, $p3, $p4, $p5, $p6);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getCurrentQuality() {
        PlayIndex playIndex;
        switch (getState()) {
            case 3:
            case 4:
            case 5:
            case 6:
                IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
                if (iMediaPlayContext != null) {
                    return iMediaPlayContext.getCurrentVideoStream();
                }
                return 0;
            default:
                MediaResource mediaResource = this.mMediaResource;
                if (mediaResource == null || (playIndex = mediaResource.getPlayIndex()) == null) {
                    return 0;
                }
                return playIndex.mQuality;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void play() {
        PlayerLog.i(TAG, "call player play");
        MediaResource mediaResource = this.mMediaResource;
        MediaItemParams curItemParams = this.mCurrentMediaItemParams;
        if (mediaResource == null || curItemParams == null) {
            PlayerLog.w(TAG, "could not play, because mediaResource is null or currentMediaItemParams is null");
            return;
        }
        IMediaItemTransformer iMediaItemTransformer = this.mMediaItemTransformer;
        MediaItem mediaItem = iMediaItemTransformer != null ? iMediaItemTransformer.createMediaItem(mediaResource, curItemParams, null) : null;
        if (mediaItem == null) {
            PlayerLog.e(TAG, "something error, create mediaItem failed");
            return;
        }
        if (mediaItem instanceof IjkMediaItem) {
            IjkMediaPlayerItem realMediaItem = ((IjkMediaItem) mediaItem).realMediaItem();
            if (realMediaItem != null) {
                realMediaItem.setOnTrackerListener(IjkMediaPlayerTrackerHelp.getInstance());
            }
            IjkMediaPlayerItem realMediaItem2 = ((IjkMediaItem) mediaItem).realMediaItem();
            if (realMediaItem2 != null) {
                realMediaItem2.setAssetUpdateListener(this.mItemUpdateListener);
            }
        }
        if (!this.mRestoringFromShutdownByOthers) {
            this.mAutoStart = true;
        }
        setMediaItem(mediaItem);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void pause() {
        RestoreState restoreState;
        PlayerLog.i(TAG, "call player pause");
        boolean z = false;
        if (this.mRestoringFromShutdownByOthers || this.mMediaPlayContext == null) {
            RestoreState restoreState2 = this.mRestoreState;
            if (restoreState2 != null && restoreState2.getStateWhenShutdown() == 4) {
                z = true;
            }
            if (!z || (restoreState = this.mRestoreState) == null) {
                return;
            }
            restoreState.setStateWhenShutdown(5);
            return;
        }
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.pause();
        }
        if (this.mCurrentPlayerState == 4 || this.mCurrentPlayerState == 100) {
            setState(101);
        } else if (this.mCurrentPlayerState == 2) {
            this.mAutoStart = false;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void resume() {
        PlayerLog.i(TAG, "call player resume");
        if (isDisablePlay()) {
            PlayerLog.i(TAG, "call player resume, but is locked");
        } else if (this.mAbsentPlayerByOther) {
            this.mAbsentPlayerByOther = false;
            RestoreState restoreState = this.mRestoreState;
            if (restoreState != null) {
                restoreState.setStateWhenShutdown(4);
            }
            this.mRestoringFromShutdownByOthers = true;
            play();
        } else if (this.mRestoringFromShutdownByOthers) {
            RestoreState restoreState2 = this.mRestoreState;
            if (restoreState2 != null) {
                restoreState2.setStateWhenShutdown(4);
            }
        } else {
            IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
            if (iMediaPlayContext != null) {
                iMediaPlayContext.resume();
            }
            if (this.mCurrentPlayerState == 3 || this.mCurrentPlayerState == 5 || this.mCurrentPlayerState == 101 || this.mCurrentPlayerState == 6) {
                this.mCurrentPlayerState = 100;
            } else if (this.mCurrentPlayerState <= 2) {
                this.mAutoStart = true;
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void stop() {
        PlayerLog.i(TAG, "call player stop");
        if (this.mRestoringFromShutdownByOthers) {
            PlayerLog.i(TAG, "is restoring from shutdown by others, do nothing");
            return;
        }
        resetRestoreState();
        setState(7);
        removeCurrentSource();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void seekTo(int position, boolean accurate) {
        final int finalPosition = interceptSeekTarget(position);
        this.mPlayerSeekObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda15
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.seekTo$lambda$0(finalPosition, (PlayerSeekObserver) obj);
            }
        });
        if (!isCorePlayerActive() || this.mAbsentPlayerByOther) {
            MediaItemParams mediaItemParams = this.mCurrentMediaItemParams;
            if (mediaItemParams != null) {
                mediaItemParams.setStartPosition(finalPosition);
            }
            restorePlayer();
        }
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.seekTo(finalPosition, accurate);
        }
        PlayerLog.i(TAG, "[player]seek to " + position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void seekTo$lambda$0(int $finalPosition, PlayerSeekObserver it) {
        it.onSeekStart($finalPosition);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int interceptSeekTarget(int position) {
        final Ref.IntRef target = new Ref.IntRef();
        target.element = position;
        this.mSeekInterceptorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda9
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.interceptSeekTarget$lambda$0(target, (ISeekInterceptor) obj);
            }
        });
        return target.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void interceptSeekTarget$lambda$0(Ref.IntRef $target, ISeekInterceptor it) {
        $target.element = it.intercept($target.element);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addSeekInterceptor(ISeekInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        if (this.mSeekInterceptorList.contains(interceptor)) {
            return;
        }
        this.mSeekInterceptorList.add(interceptor);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removeSeekInterceptor(ISeekInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.mSeekInterceptorList.remove(interceptor);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getDuration() {
        int realDuration = getRealDuration();
        IDurationInterceptor interceptor = this.mDurationInterceptor;
        return interceptor == null ? realDuration : interceptor.intercept(realDuration);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setDurationInterceptor(IDurationInterceptor interceptor) {
        this.mDurationInterceptor = interceptor;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getRealDuration() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return (int) iMediaPlayContext.getDuration();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getCurrentPosition() {
        int realPosition = getRealCurrentPosition();
        return interceptPosition(realPosition);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setCurrentPositionInterceptor(ICurrentPositionInterceptor interceptor) {
        this.mCurrentPositionInterceptor = interceptor;
    }

    private final int interceptPosition(int position) {
        ICurrentPositionInterceptor interceptor = this.mCurrentPositionInterceptor;
        return interceptor == null ? position : interceptor.intercept(position);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getRealCurrentPosition() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return (int) iMediaPlayContext.getCurrentPosition();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public float getBufferedPercentage() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        long bufPos = iMediaPlayContext != null ? iMediaPlayContext.getBufferedPosition() : 0L;
        int curPos = getCurrentPosition();
        float percent = ((float) (curPos + bufPos)) / getDuration();
        if (percent > 1.0f) {
            return 1.0f;
        }
        return percent;
    }

    private final void resetMediaResource() {
        if (this.mMediaResource != null || getCurrentMediaItem() != null) {
            removeCurrentSource();
        }
    }

    private final boolean checkMediaResource(final MediaResource resource) {
        final Ref.BooleanRef result = new Ref.BooleanRef();
        result.element = true;
        this.mMediaResourceObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda10
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.checkMediaResource$lambda$0(resource, result, (IMediaResourceObserver) obj);
            }
        });
        if (!resource.isPlayable()) {
            PlayerLog.i(TAG, "prepareMediaResource, current resource is not playable");
            return false;
        }
        return result.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMediaResource$lambda$0(MediaResource $resource, Ref.BooleanRef $result, IMediaResourceObserver it) {
        if (!it.onPrepared($resource)) {
            $result.element = false;
            BLog.i(TAG, "call pause in media resource prepare check");
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setMediaResource(MediaResource resource, boolean autoStart, MediaItemParams itemParams) {
        MediaItem mediaItem;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(itemParams, "itemParams");
        PlayerLog.i(TAG, "setMediaResource, autoStart:" + autoStart);
        if (!checkMediaResource(resource)) {
            resetMediaResource();
            return;
        }
        setState(2);
        this.mMediaResource = resource;
        this.mCurrentMediaItemParams = itemParams;
        this.mAutoStart = autoStart;
        IMediaItemTransformer iMediaItemTransformer = this.mMediaItemTransformer;
        if (iMediaItemTransformer == null || (mediaItem = iMediaItemTransformer.createMediaItem(resource, itemParams, null)) == null) {
            return;
        }
        if (mediaItem instanceof IjkMediaItem) {
            IjkMediaPlayerItem realMediaItem = ((IjkMediaItem) mediaItem).realMediaItem();
            if (realMediaItem != null) {
                realMediaItem.setAssetUpdateListener(this.mItemUpdateListener);
            }
            IjkMediaPlayerItem realMediaItem2 = ((IjkMediaItem) mediaItem).realMediaItem();
            if (realMediaItem2 != null) {
                realMediaItem2.setOnTrackerListener(IjkMediaPlayerTrackerHelp.getInstance());
            }
        }
        setMediaItem(mediaItem);
        resetRestoreState();
        dispatchMediaResourceChanged(resource);
    }

    private final void resetRestoreState() {
        this.mAbsentPlayerByOther = false;
        this.mRestoringFromShutdownByOthers = false;
        this.mRestoreState = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setMediaResource(MediaItem<?> mediaItem, MediaResource mediaResource, boolean autoStart, MediaItemParams itemParams) {
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        Intrinsics.checkNotNullParameter(mediaResource, "mediaResource");
        Intrinsics.checkNotNullParameter(itemParams, "itemParams");
        PlayerLog.i(TAG, "setMediaResource, autoStart:" + autoStart);
        if (!checkMediaResource(mediaResource)) {
            resetMediaResource();
            return;
        }
        setState(2);
        this.mMediaResource = mediaResource;
        this.mAutoStart = autoStart;
        this.mCurrentMediaItemParams = itemParams;
        if (mediaItem instanceof IjkMediaItem) {
            IjkMediaPlayerItem realMediaItem = ((IjkMediaItem) mediaItem).realMediaItem();
            if (realMediaItem != null) {
                realMediaItem.setOnTrackerListener(IjkMediaPlayerTrackerHelp.getInstance());
            }
            IjkMediaPlayerItem realMediaItem2 = ((IjkMediaItem) mediaItem).realMediaItem();
            if (realMediaItem2 != null) {
                realMediaItem2.setAssetUpdateListener(this.mItemUpdateListener);
            }
        }
        setMediaItem(mediaItem);
        resetRestoreState();
        dispatchMediaResourceChanged(mediaResource);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setStartStreamIdSelector(IStartStreamIdSelector selector) {
        this.mStartStreamIdSelector = selector;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public IStartStreamIdSelector getStartStreamIdSelector() {
        return this.mStartStreamIdSelector;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public String getCurrentPlayUrl(boolean isAudio) {
        String currentPlayUrl;
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        return (iMediaPlayContext == null || (currentPlayUrl = iMediaPlayContext.getCurrentPlayUrl(isAudio)) == null) ? "" : currentPlayUrl;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public float getVideoFps() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        return iMediaPlayContext != null ? iMediaPlayContext.getVideoFps() : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setLooping(boolean looping) {
        if (looping && this.mCurrentPlayerState == 6) {
            play();
        }
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setLooping(looping);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerTimer.registerPlayerProgressObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerTimer.unregisterPlayerProgressObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerPlayerProgressRangeObserver(PlayerProgressRangeObserver observer, long startPosition, long endPosition) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerTimer.registerPlayerProgressRangeObserver(observer, startPosition, endPosition);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterPlayerProgressRangeObserver(PlayerProgressRangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerTimer.unregisterPlayerProgressRangeObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean isCorePlayerActive() {
        return this.mIsCorePlayerActive;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public IMediaPlayContext createMultiMediaContext(IMediaPlayParams mediaParam) {
        Intrinsics.checkNotNullParameter(mediaParam, "mediaParam");
        PlayerLog.i(TAG, "obtainMultiMediaContext");
        if (this.mMultiMediaContexts.size() >= 1) {
            PlayerLog.i(TAG, "obtainMediaContext fail, max size:1");
            return null;
        }
        MediaPlayContextImpl playContext = new MediaPlayContextImpl();
        playContext.init(mediaParam);
        this.mMultiMediaContexts.add(playContext);
        return playContext;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void releaseMultiMediaContext(IMediaPlayContext mediaContext) {
        Intrinsics.checkNotNullParameter(mediaContext, "mediaContext");
        PlayerLog.i(TAG, "createMultiMediaContext");
        mediaContext.release();
        Collections.SafeIteratorList<IMediaPlayContext> safeIteratorList = this.mMultiMediaContexts;
        if (safeIteratorList != null) {
            safeIteratorList.remove(mediaContext);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setBufferLimit(boolean limit) {
        PlayerLog.i(TAG, "setBufferControl:" + limit);
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setBufferControl(limit ? 1 : 0);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean isBufferLimit() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        int type = iMediaPlayContext != null ? iMediaPlayContext.getBufferControl() : 0;
        return type != 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getDefaultAudioIndex() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.getDefaultAudioIndex();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getCurrentAudioIndex() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.getCurrentAudioIndex();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int[] getAudioStreamsIndex() {
        int[] audioStreamsIndex;
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        return (iMediaPlayContext == null || (audioStreamsIndex = iMediaPlayContext.getAudioStreamsIndex()) == null) ? new int[0] : audioStreamsIndex;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getCurrentAudioStream() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.getCurrentAudioStream();
        }
        return -1;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int setAudioIndex(Integer index) {
        if (index == null) {
            return -1;
        }
        index.intValue();
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.setAudioIndex(index.intValue());
        }
        return -1;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void resetAudioIndex() {
        IMediaPlayContext iMediaPlayContext;
        IMediaPlayContext it = this.mMediaPlayContext;
        if (it == null || it.getAudioStreamsIndex().length <= 1 || (iMediaPlayContext = this.mMediaPlayContext) == null) {
            return;
        }
        iMediaPlayContext.setAudioIndex(it.getDefaultAudioIndex());
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean supportQuality(int quality) {
        if (quality <= 0) {
            return false;
        }
        int[] supportQualities = getSupportsQuality();
        String arrays = Arrays.toString(supportQualities);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        BLog.d(TAG, "quality " + quality + ", supportQualities: " + arrays);
        if (supportQualities != null) {
            for (int dashQuality : supportQualities) {
                if (quality == dashQuality) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int[] getSupportsQuality() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.getSupportQualities();
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void switchQuality(int quality) {
        PlayerLog.i(TAG, "call player switch quality:" + quality);
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            IMediaPlayControlContext.CC.setVideoStream$default(iMediaPlayContext, quality, 0, 0, 6, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setDashAuto(boolean flag, int minQuality, int maxQuality) {
        PlayerLog.i(TAG, "call player setDashAuto:" + flag + " min:" + minQuality + " max:" + maxQuality);
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setDashAuto(flag, minQuality, maxQuality);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean getDashAuto() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.getDashAuto();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setAudioStreamId(int id) {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setAudioStream(id);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public long getMediaSize(IjkMediaAsset.VideoCodecType codec) {
        int videoQuality;
        Intrinsics.checkNotNullParameter(codec, "codec");
        MediaResource mediaResource = this.mMediaResource;
        if (mediaResource == null || (videoQuality = getCurrentQuality()) == 0) {
            return 0L;
        }
        DashResource dashResource = mediaResource.getDashResource();
        if (dashResource == null) {
            PlayIndex playIndex = mediaResource.getPlayIndex();
            if (playIndex != null) {
                return playIndex.getSize();
            }
            return 0L;
        }
        long videoSize = 0;
        long audioSize = 0;
        List videoList = dashResource.getVideoList();
        if (videoList != null && !videoList.isEmpty()) {
            Iterator it = videoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DashMediaIndex video2 = (DashMediaIndex) it.next();
                if (video2.id == videoQuality) {
                    if (codec == IjkMediaAsset.VideoCodecType.H265) {
                        if (video2.codecId == 12) {
                            videoSize = video2.bytes;
                            break;
                        } else if (video2.codecId == 7) {
                            videoSize = video2.bytes;
                            break;
                        }
                    } else if (codec == IjkMediaAsset.VideoCodecType.H264 && video2.codecId == 7) {
                        videoSize = video2.bytes;
                        break;
                    }
                }
            }
        }
        if (videoSize <= 0) {
            return 0L;
        }
        List audioList = dashResource.getAudioList();
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        int audioQuality = iMediaPlayContext != null ? iMediaPlayContext.getCurrentAudioStream() : -1;
        if (audioList != null && !audioList.isEmpty()) {
            Iterator it2 = audioList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DashMediaIndex audio = (DashMediaIndex) it2.next();
                if (audio.id == audioQuality) {
                    audioSize = audio.bytes;
                    break;
                }
            }
        }
        if (audioSize == 0) {
            List list = audioList;
            if (!(list == null || list.isEmpty())) {
                audioSize = ((DashMediaIndex) audioList.get(0)).bytes;
            }
        }
        return audioSize + videoSize;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void switchAutoQuality(int minQuality, int maxQuality) {
        PlayerLog.i(TAG, "call player auto switch quality:[" + minQuality + "-" + maxQuality + "]");
        int maxQn = maxQuality >= 0 ? maxQuality : PlayerOnlineParamHelper.INSTANCE.getMaxQnForDashAuto();
        if (minQuality <= maxQn) {
            IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
            if (iMediaPlayContext != null) {
                iMediaPlayContext.setVideoStream(0, minQuality, maxQn);
                return;
            }
            return;
        }
        PlayerLog.i(TAG, "auto switch ignore equal quality");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean isThirdPlayer() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        boolean z = false;
        if (iMediaPlayContext != null && iMediaPlayContext.getPlayerType() == 1) {
            z = true;
        }
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(final int state) {
        PlayerLog.i(TAG, "state change, target state = " + state);
        this.mCurrentPlayerState = state;
        if (state == 6) {
            final int position = interceptPosition(getRealDuration());
            this.mPlayerClockObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda17
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    PlayerCoreServiceV2.setState$lambda$0(position, (IPlayerClockChangedObserver) obj);
                }
            });
        }
        Collections.SafeIteratorList receivers = this.mPlayerStateObserverMap.get(Integer.valueOf(state));
        Collections.SafeIteratorList safeIteratorList = receivers;
        if (safeIteratorList == null || safeIteratorList.isEmpty()) {
            return;
        }
        receivers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda18
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((PlayerStateObserver) obj).onPlayerStateChanged(state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setState$lambda$0(int $position, IPlayerClockChangedObserver it) {
        PlayerLog.i(TAG, "play core service to complete, notify player clock changed, current time = " + $position);
        it.onPlayerClockChanged(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $position);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public int getState() {
        switch (this.mCurrentPlayerState) {
            case 100:
                return 4;
            case 101:
                return 5;
            default:
                return this.mCurrentPlayerState;
        }
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        PlayIndex playIndex;
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IMediaPlayContext mediaContext = this.mMediaPlayContext;
        if (mediaContext == null) {
            PlayerLog.w(TAG, "want to shared play, but mediaContext is null");
        } else if (!mediaContext.isPrepared() || !(mediaContext instanceof SharableObject)) {
            PlayerLog.w(TAG, "want to shared play, but mediaContext is not prepared");
        } else {
            IMediaPlayParams mediaPlayParams = this.mMediaPlayParams;
            if (mediaPlayParams == null) {
                PlayerLog.w(TAG, "want to shared play, but mediaPlayParams is null");
            } else if (!(mediaPlayParams instanceof MediaPlayParams)) {
                PlayerLog.w(TAG, "want to shared play, but mediaPlayParams is not MediaPlayParams");
            } else if (sharingType == PlayerSharingType.PLAYER_CORE) {
                IMediaPlayAdapter mediaPlayAdapter = mediaContext.fetchPlayAdapter();
                if (mediaPlayAdapter != null) {
                    bundle.putSharableObject("key_share_player_core", new MediaPlayerShareParam(mediaPlayAdapter));
                    PlayerLog.w(TAG, "share play adapter");
                }
            } else {
                bundle.putSharableObject(KEY_SHARE_MEDIA_PLAY_PARAMS, (SharableObject) mediaPlayParams);
                bundle.putSharableObject("key_share_media_context", (SharableObject) mediaContext);
                float playSpeed$default = IPlayerCoreService.CC.getPlaySpeed$default(this, false, 1, null);
                int state = getState();
                PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
                if (playerContainerImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl = null;
                }
                boolean z = playerContainerImpl.getPlayerSettingService().getBoolean(Player.KEY_LOCKED_PLAYER_SPEED, false);
                MediaResource mediaResource = this.mMediaResource;
                PlayerSharedState sharedState = new PlayerSharedState(playSpeed$default, state, z, (mediaResource == null || (playIndex = mediaResource.getPlayIndex()) == null) ? 0 : playIndex.mQuality);
                bundle.setPlayerSharedState(sharedState);
                bundle.getBundle().putInt(KEY_SHARE_PLAY_POSITION, getCurrentPosition());
                bundle.getBundle().putInt(KEY_SHARE_PLAY_DURATION, getDuration());
                bundle.putSharableObject(KEY_SHARE_MEDIA_RESOURCE, new MediaResourceShareParam(this.mMediaResource));
                bundle.putSharableObject(KEY_SHARE_MEDIA_ITEM_PARAMS, new MediaItemParamsShareParams(this.mCurrentMediaItemParams));
                ((SharableObject) mediaContext).detachByShared();
                this.mMediaPlayContext = null;
                this.mMediaPlayParams = null;
                this.mAbsentPlayerByOther = false;
                this.mRestoringFromShutdownByOthers = false;
                this.mPlayerTimer.stop();
            }
        }
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        if (sharingType == PlayerSharingType.PLAYER_CORE) {
            return;
        }
        ensureMediaPlayParams(bundle);
        ensureMediaContext(bundle);
        this.mCurrentPlayerState = getState();
        if (bundle == null && (this.mCurrentPlayerState == 4 || this.mCurrentPlayerState == 5 || this.mCurrentPlayerState == 2 || this.mCurrentPlayerState == 3)) {
            this.mAutoStart = this.mCurrentPlayerState == 4;
            this.mRestoreState = new RestoreState(this.mCurrentPlayerState, Integer.valueOf(getCurrentQuality()), getDashAutoRange());
            RestoreState restoreState = this.mRestoreState;
            if (restoreState != null) {
                restoreState.setStateWhenShutdown(this.mCurrentPlayerState);
            }
            this.mRestoringFromShutdownByOthers = true;
        }
        setMonitorToMediaPlayer();
        this.mPlayerTimer.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r4.isPlayable() == true) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ensureMediaContext(PlayerSharingBundle bundle) {
        PlayerContainerImpl playerContainerImpl;
        MediaPlayContextImpl playContext;
        PlayerSharedState playerSharedState;
        PlayerSharedState playerSharedState2;
        boolean z;
        MediaResourceShareParam mediaResourceShareParam;
        PlayerContainerImpl playerContainerImpl2 = null;
        boolean z2 = false;
        MediaPlayContextImpl playContext2 = bundle != null ? (MediaPlayContextImpl) PlayerSharingBundle.getSharableObject$default(bundle, "key_share_media_context", false, 2, null) : null;
        if (playContext2 == null) {
            playContext = new MediaPlayContextImpl();
            playContext.incrementRefCount();
            IMediaPlayParams iMediaPlayParams = this.mMediaPlayParams;
            Intrinsics.checkNotNull(iMediaPlayParams);
            playContext.init(iMediaPlayParams);
            this.mPlayFromSharedEnable = false;
        } else {
            PlayerLog.i(TAG, "media-play-context from shared");
            MediaResource mediaResource = (bundle == null || (mediaResourceShareParam = (MediaResourceShareParam) PlayerSharingBundle.getSharableObject$default(bundle, KEY_SHARE_MEDIA_RESOURCE, false, 2, null)) == null) ? null : mediaResourceShareParam.getMediaResource();
            if (playContext2.getCurrentRefCount() > 0) {
                if (mediaResource != null) {
                    z = true;
                }
                z = false;
                if (z && this.mPlayFromSharedEnable) {
                    IMediaPlayParams iMediaPlayParams2 = this.mMediaPlayParams;
                    Intrinsics.checkNotNull(iMediaPlayParams2);
                    playContext2.updatePlayParams(iMediaPlayParams2);
                    playContext2.attachByShared();
                    this.mMediaResource = mediaResource;
                    MediaItemParamsShareParams mediaItemParamsShareParams = (MediaItemParamsShareParams) PlayerSharingBundle.getSharableObject$default(bundle, KEY_SHARE_MEDIA_ITEM_PARAMS, false, 2, null);
                    this.mCurrentMediaItemParams = mediaItemParamsShareParams != null ? mediaItemParamsShareParams.getMMediaItemParams() : null;
                    float sharedSpeed = (bundle != null || (playerSharedState2 = bundle.getPlayerSharedState()) == null) ? 1.0f : playerSharedState2.getSpeedRate();
                    playerContainerImpl = this.mPlayerContainer;
                    if (playerContainerImpl != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl2 = playerContainerImpl;
                    }
                    IPlayerSettingService $this$ensureMediaContext_u24lambda_u240 = playerContainerImpl2.getPlayerSettingService();
                    $this$ensureMediaContext_u24lambda_u240.putFloat(Player.KEY_PLAYER_SPEED, sharedSpeed);
                    if (bundle != null && (playerSharedState = bundle.getPlayerSharedState()) != null) {
                        z2 = playerSharedState.getLockSpeed();
                    }
                    $this$ensureMediaContext_u24lambda_u240.putBoolean(Player.KEY_LOCKED_PLAYER_SPEED, z2);
                    playContext = playContext2;
                }
            }
            playContext2.release();
            playContext2 = new MediaPlayContextImpl();
            playContext2.incrementRefCount();
            IMediaPlayParams iMediaPlayParams3 = this.mMediaPlayParams;
            Intrinsics.checkNotNull(iMediaPlayParams3);
            playContext2.init(iMediaPlayParams3);
            this.mPlayFromSharedEnable = false;
            if (bundle != null) {
            }
            playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl != null) {
            }
            IPlayerSettingService $this$ensureMediaContext_u24lambda_u2402 = playerContainerImpl2.getPlayerSettingService();
            $this$ensureMediaContext_u24lambda_u2402.putFloat(Player.KEY_PLAYER_SPEED, sharedSpeed);
            if (bundle != null) {
                z2 = playerSharedState.getLockSpeed();
            }
            $this$ensureMediaContext_u24lambda_u2402.putBoolean(Player.KEY_LOCKED_PLAYER_SPEED, z2);
            playContext = playContext2;
        }
        this.mMediaPlayContext = playContext;
    }

    private final void ensureMediaPlayParams(PlayerSharingBundle bundle) {
        MediaPlayParams mediaPlayParams;
        PlayerContainerImpl playerContainerImpl = null;
        IMediaPlayParams mediaPlayParams2 = bundle != null ? (IMediaPlayParams) PlayerSharingBundle.getSharableObject$default(bundle, KEY_SHARE_MEDIA_PLAY_PARAMS, false, 2, null) : null;
        if (mediaPlayParams2 == null) {
            this.mPlayFromSharedEnable = false;
            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl = playerContainerImpl2;
            }
            mediaPlayParams = new MediaPlayParams(playerContainerImpl);
        } else {
            PlayerLog.i(TAG, "media play params from shared");
            this.mPlayFromSharedEnable = true;
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl = playerContainerImpl3;
            }
            MediaPlayParams $this$ensureMediaPlayParams_u24lambda_u240 = new MediaPlayParams(playerContainerImpl);
            $this$ensureMediaPlayParams_u24lambda_u240.clone(mediaPlayParams2);
            mediaPlayParams = $this$ensureMediaPlayParams_u24lambda_u240;
        }
        this.mMediaPlayParams = mediaPlayParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        ensureMediaPlayParams(bundle);
        ensureMediaContext(bundle);
        this.mMediaItemTransformer = new IjkMediaItemTransformer();
        setMonitorToMediaPlayer();
        this.mPlayerTimer.init$biliplayerimpl_debug();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        this.mPlayerTimer.release$biliplayerimpl_debug();
        IMediaPlayContext it = this.mMediaPlayContext;
        if (it != null) {
            if (it instanceof SharableObject) {
                ((SharableObject) it).decrementRefCount();
                if (((SharableObject) it).getCurrentRefCount() <= 0) {
                    onStop$releasePlayContext(this, it);
                }
            } else {
                onStop$releasePlayContext(this, it);
            }
        }
        this.mPlayVolumeChangeObserverList.clear();
        this.mPlayerStateObserverMap.clear();
        this.mPlayerSeekObserverList.clear();
        this.mSpeedChangedObservers.clear();
        this.mBufferingObserverList.clear();
        this.mRenderStartObserverList.clear();
        this.mPlayerReleaseObserverList.clear();
        this.mLoopObservers.clear();
        this.mPlayerClockObserverList.clear();
        this.mMediaResourceObserverList.clear();
        this.mOnRawDataWriteObserverList.clear();
        this.mOnTrackInfoObserverList.clear();
        this.mAssetUpdateObserverList.clear();
        this.mMediaItemTransformer = null;
        Collections.SafeIteratorList<IMediaPlayContext> safeIteratorList = this.mMultiMediaContexts;
        if (safeIteratorList != null) {
            safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda25
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((IMediaPlayContext) obj).release();
                }
            });
        }
        this.mMultiMediaContexts.clear();
    }

    private static final void onStop$releasePlayContext(PlayerCoreServiceV2 this$0, IMediaPlayContext context) {
        context.release();
        this$0.mMediaPlayContext = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerState(PlayerStateObserver observer, int... states) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(states, "states");
        if (states.length == 0) {
            return;
        }
        for (int state : states) {
            Collections.SafeIteratorList receivers = this.mPlayerStateObserverMap.get(Integer.valueOf(state));
            if (receivers == null) {
                receivers = Collections.safeIteratorList(new LinkedList());
            }
            if ((receivers == null || receivers.contains(observer)) ? false : true) {
                receivers.add(observer);
                Collections.SafeIteratorMap<Integer, Collections.SafeIteratorList<PlayerStateObserver>> safeIteratorMap = this.mPlayerStateObserverMap;
                Intrinsics.checkNotNullExpressionValue(safeIteratorMap, "mPlayerStateObserverMap");
                safeIteratorMap.put(Integer.valueOf(state), receivers);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterState(final PlayerStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerStateObserverMap.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda14
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerCoreServiceV2.unregisterState$lambda$0(PlayerStateObserver.this, this, (Map.Entry) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterState$lambda$0(PlayerStateObserver $observer, PlayerCoreServiceV2 this$0, Map.Entry it) {
        Collections.SafeIteratorList receivers = (Collections.SafeIteratorList) it.getValue();
        Intrinsics.checkNotNull(receivers);
        if (!receivers.isEmpty() && receivers.contains($observer)) {
            receivers.remove($observer);
            if (receivers.isEmpty()) {
                this$0.mPlayerStateObserverMap.remove(it.getKey());
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean supportProjectionScreen() {
        if (!this.mProjectionScreenAvailable) {
            return false;
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPlayerSettingService().getCloudConfig().supportProjection();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setProjectionScreenAvailable(boolean available) {
        this.mProjectionScreenAvailable = available;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean isProjectionScreenAvailable() {
        return this.mProjectionScreenAvailable;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public float getPlaySpeed(boolean forceFromNative) {
        if (forceFromNative) {
            IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
            if (iMediaPlayContext != null) {
                return iMediaPlayContext.getSpeed();
            }
            return 1.0f;
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPlayerSettingService().getFloat(Player.KEY_PLAYER_SPEED, 1.0f);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setPlaySpeed(final float speed) {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IPlayerSettingService $this$setPlaySpeed_u24lambda_u240 = playerContainerImpl.getPlayerSettingService();
        $this$setPlaySpeed_u24lambda_u240.putFloat(Player.KEY_PLAYER_SPEED, speed);
        if (speed <= 2.0f && $this$setPlaySpeed_u24lambda_u240.getBoolean(Player.KEY_LOCKED_PLAYER_SPEED, false)) {
            $this$setPlaySpeed_u24lambda_u240.putBoolean(Player.KEY_LOCKED_PLAYER_SPEED, false);
        }
        float playerSpeed = speed;
        if (speed == 2.0f) {
            playerSpeed = 1.99f;
        }
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            Float f = (Float) iMediaPlayContext.invokeOp(IMediaPlayAdapter.Ops.OpSwitchSpeed, Float.valueOf(playerSpeed));
        }
        PlayerLog.i(TAG, "[player] player speed type=" + speed);
        this.mSpeedChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda19
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IPlayerSpeedChangedObserver) obj).onChanged(speed);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public Boolean isVariableResolutionRatio() {
        MediaResource mediaResource = this.mMediaResource;
        if (mediaResource != null) {
            return Boolean.valueOf(mediaResource.getVariableResolutionRatio());
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public String getPlayFailReason() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext == null || (mediaPlayControlContext = iMediaPlayContext.getMediaPlayControlContext()) == null) {
            return null;
        }
        return mediaPlayControlContext.getPlayFailReason();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removeCurrentSource() {
        BLog.e(TAG, "removeCurrentSource");
        if ((this.mCurrentPlayerState >= 3 && this.mCurrentPlayerState <= 6) || this.mCurrentPlayerState == 100 || this.mCurrentPlayerState == 101) {
            setState(7);
        }
        this.mMediaResource = null;
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.removeMediaItem(null);
        }
        setState(0);
        resetRestoreState();
        dispatchMediaResourceChanged(null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerLoopObserver(IPlayerLoopObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mLoopObservers.contains(observer)) {
            return;
        }
        this.mLoopObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerLoopObserver(IPlayerLoopObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mLoopObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerSpeedChangedObserver(IPlayerSpeedChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mSpeedChangedObservers.contains(observer)) {
            return;
        }
        this.mSpeedChangedObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerSpeedChangedObserver(IPlayerSpeedChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mSpeedChangedObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerClockChangedObserver(IPlayerClockChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mPlayerClockObserverList.contains(observer)) {
            this.mPlayerClockObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerClockChangedObserver(IPlayerClockChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerClockObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerOnRawDataWriteObserver(OnRawDataWriteObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mOnRawDataWriteObserverList.contains(observer)) {
            this.mOnRawDataWriteObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerOnRawDataWriteObserver(OnRawDataWriteObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mOnRawDataWriteObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerOnTrackInfoObserver(OnTrackInfoObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mOnTrackInfoObserverList.contains(observer)) {
            this.mOnTrackInfoObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerOnTrackInfoObserver(OnTrackInfoObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mOnTrackInfoObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerReleaseObserver(IPlayerReleaseObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mPlayerReleaseObserverList.contains(observer)) {
            this.mPlayerReleaseObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerReleaseObserver(IPlayerReleaseObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerReleaseObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addMediaCenterObserver(IMediaCenterObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mMediaCenterObserverList.contains(observer)) {
            this.mMediaCenterObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removeMediaCenterObserver(IMediaCenterObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mMediaCenterObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addAssetUpdateObserver(IAssetUpdateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mAssetUpdateObserverList.contains(observer)) {
            this.mAssetUpdateObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removeAssetUpdateObserver(IAssetUpdateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mAssetUpdateObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public MediaResource getMediaResource() {
        return this.mMediaResource;
    }

    @Override // tv.danmaku.biliplayerimpl.core.IPlayerRenderContextService
    public IMediaPlayRenderContext getRenderContext() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        Intrinsics.checkNotNull(iMediaPlayContext);
        return iMediaPlayContext;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void updateMediaResource(MediaResource mediaResource) {
        MediaItem curMediaItem;
        IMediaItemTransformer iMediaItemTransformer;
        List videoList;
        Intrinsics.checkNotNullParameter(mediaResource, "mediaResource");
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext == null || (curMediaItem = iMediaPlayContext.getCurrentMediaItem()) == null) {
            return;
        }
        MediaResource oldMediaResource = this.mMediaResource;
        if (!checkMediaResource(mediaResource)) {
            PlayerLog.i(TAG, "update mediaResource value is invalid");
            return;
        }
        this.mMediaResource = mediaResource;
        if (oldMediaResource != null) {
            DashResource dashResource = mediaResource.getDashResource();
            if (((dashResource == null || (videoList = dashResource.getVideoList()) == null) ? 0 : videoList.size()) > 0 && (iMediaItemTransformer = this.mMediaItemTransformer) != null) {
                iMediaItemTransformer.updateMediaItem(curMediaItem, oldMediaResource, mediaResource);
            }
        }
        dispatchMediaResourceChanged(mediaResource);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void updateP2PParams(P2PParams params) {
        MediaItem curMediaItem;
        IjkMediaPlayerItem realMediaItem;
        Intrinsics.checkNotNullParameter(params, "params");
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null && (curMediaItem = iMediaPlayContext.getCurrentMediaItem()) != null && (curMediaItem instanceof IjkMediaItem) && (realMediaItem = ((IjkMediaItem) curMediaItem).realMediaItem()) != null) {
            realMediaItem.setP2pManuscriptInfo(IMediaItemTransformer.Companion.transformP2PParams(params));
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerSeekObserver(PlayerSeekObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mPlayerSeekObserverList.contains(observer)) {
            return;
        }
        this.mPlayerSeekObserverList.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterSeekObserver(PlayerSeekObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerSeekObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerBufferingState(BufferingObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mBufferingObserverList.contains(observer)) {
            return;
        }
        this.mBufferingObserverList.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterBufferingState(BufferingObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mBufferingObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerPlayerErrorObserver(PlayerErrorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mPlayerErrorObserverList.contains(observer)) {
            this.mPlayerErrorObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterPlayerErrorObserver(PlayerErrorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerErrorObserverList.remove(observer);
    }

    private final void notifyBufferingStart(final int extra) {
        this.mBufferingObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda12
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((BufferingObserver) obj).onBufferingStart(extra);
            }
        });
    }

    private final void notifyBufferingEnd() {
        this.mBufferingObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda16
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((BufferingObserver) obj).onBufferingEnd();
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addPlayerSourceObserver(IPlayerSourceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerSourceObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removePlayerSourceObserver(IPlayerSourceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerSourceObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean tryToRestoreFromShutDownByOthers() {
        boolean shutdownByOther = this.mAbsentPlayerByOther;
        RestoreState restoreState = this.mRestoreState;
        Integer stateWhenShutdown = restoreState != null ? Integer.valueOf(restoreState.getStateWhenShutdown()) : null;
        if (shutdownByOther && ((stateWhenShutdown != null && stateWhenShutdown.intValue() == 4) || ((stateWhenShutdown != null && stateWhenShutdown.intValue() == 5) || ((stateWhenShutdown != null && stateWhenShutdown.intValue() == 2) || ((stateWhenShutdown != null && stateWhenShutdown.intValue() == 3) || (stateWhenShutdown != null && stateWhenShutdown.intValue() == 6)))))) {
            PlayerLog.i(TAG, "restore player");
            restorePlayer();
        } else {
            PlayerLog.i(TAG, "state when shutdown by other is " + stateWhenShutdown + ", do not restore");
            resetRestoreState();
        }
        return this.mRestoringFromShutdownByOthers;
    }

    private final void restorePlayer() {
        MediaItem.IStatusListener iStatusListener;
        MediaItem it;
        Integer videoStreamId;
        this.mAbsentPlayerByOther = false;
        this.mRestoringFromShutdownByOthers = true;
        MediaResource mediaResource = this.mMediaResource;
        MediaItemParams mediaItemParams = this.mCurrentMediaItemParams;
        MediaItemParams mediaItemParams2 = null;
        if (mediaItemParams != null) {
            iStatusListener = null;
            mediaItemParams2 = MediaItemParams.copy$default(mediaItemParams, null, 0, false, 0, false, 0L, false, 0, null, 0L, 0L, false, 0, 0L, 0, 0, 0, false, 0, false, null, null, false, null, null, null, null, false, false, 0L, null, false, false, null, -1, 3, null);
        } else {
            iStatusListener = null;
        }
        MediaItemParams curItemParams = mediaItemParams2;
        if (mediaResource == null || curItemParams == null) {
            PlayerLog.w(TAG, "can not restore ijk, because mediaResource is null or currentMediaItemParams is null");
            return;
        }
        RestoreState restoreState = this.mRestoreState;
        if (restoreState != null && restoreState.getStateWhenShutdown() == 6) {
            curItemParams.setForceRenderLastFrame(true);
        }
        RestoreState restoreState2 = this.mRestoreState;
        curItemParams.setRecommendStartQualityRange(restoreState2 != null ? restoreState2.getAutoRange() : iStatusListener);
        RestoreState restoreState3 = this.mRestoreState;
        curItemParams.setVideoStreamId((restoreState3 == null || (videoStreamId = restoreState3.getVideoStreamId()) == null) ? 0 : videoStreamId.intValue());
        IMediaItemTransformer iMediaItemTransformer = this.mMediaItemTransformer;
        if (iMediaItemTransformer != null && (it = iMediaItemTransformer.createMediaItem(mediaResource, curItemParams, iStatusListener)) != null) {
            if (it instanceof IjkMediaItem) {
                IjkMediaPlayerItem realMediaItem = ((IjkMediaItem) it).realMediaItem();
                if (realMediaItem != null) {
                    realMediaItem.setOnTrackerListener(IjkMediaPlayerTrackerHelp.getInstance());
                }
                IjkMediaPlayerItem realMediaItem2 = ((IjkMediaItem) it).realMediaItem();
                if (realMediaItem2 != null) {
                    realMediaItem2.setAssetUpdateListener(this.mItemUpdateListener);
                }
            }
            PlayerLog.i(TAG, "restore ijk context by media item:" + it);
            setMediaItem(it);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public PlayerCodecConfig getPlayerCodecConfig() {
        PlayerCodecConfig result = new PlayerCodecConfig();
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        Integer valueOf = iMediaPlayContext != null ? Integer.valueOf(iMediaPlayContext.getPlayerType()) : null;
        result.mPlayer = (valueOf != null && valueOf.intValue() == 1) ? PlayerCodecConfig.Player.IJK_PLAYER : PlayerCodecConfig.Player.NONE;
        result.mUseIJKMediaCodec = true;
        return result;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addRenderStartObserver(IRenderStartObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mRenderStartObserverList.contains(observer)) {
            return;
        }
        this.mRenderStartObserverList.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removeRenderStartObserver(IRenderStartObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mRenderStartObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void addMediaResourceObserver(IMediaResourceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mMediaResourceObserverList.contains(observer)) {
            return;
        }
        this.mMediaResourceObserverList.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void removeMediaResourceObserver(IMediaResourceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mMediaResourceObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setAssetUpdateListener(OnAssetUpdateListener listener) {
        this.mAssetUpdateListener = listener;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setMeteredNetworkUrlHookListener(OnMeteredNetworkUrlHookListener listener) {
        this.mMeteredNetworkUrlHookListener = listener;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public OnMeteredNetworkUrlHookListener getMeteredNetworkUrlHookListener() {
        return this.mMeteredNetworkUrlHookListener;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setAudioOnly(boolean audioOnly) {
        BLog.i(TAG, "setAudioOnly: " + audioOnly + " :" + (this.mMediaPlayContext != null));
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.invokeOp(IMediaPlayAdapter.Ops.SetAudioOnly, Boolean.valueOf(audioOnly));
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setVolume(final float left, final float right) {
        this.playerVolume = new Pair<>(Float.valueOf(left), Float.valueOf(right));
        this.mPlayVolumeChangeObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda20
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((PlayerVolumeChangeObserver) obj).onVolumeChange(left, right);
            }
        });
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setVolume(left, right);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public Pair<Float, Float> getVolume() {
        return this.playerVolume;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void registerVolumeChangeObserver(PlayerVolumeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mPlayVolumeChangeObserverList.contains(observer)) {
            return;
        }
        this.mPlayVolumeChangeObserverList.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void unregisterVolumeChangeObserver(PlayerVolumeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayVolumeChangeObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public long getTcpSpeed() {
        if (this.mMediaPlayContext != null) {
            IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
            Intrinsics.checkNotNull(iMediaPlayContext);
            Object invokeOp = iMediaPlayContext.invokeOp(IMediaPlayAdapter.Ops.GetTcpSpeed, null);
            Long l = invokeOp instanceof Long ? (Long) invokeOp : null;
            if (l != null) {
                return l.longValue();
            }
            return -1L;
        }
        return -1L;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public MediaItem<?> createMediaItem(MediaItemParams itemParams, MediaResource mediaResource) {
        Intrinsics.checkNotNullParameter(itemParams, "itemParams");
        Intrinsics.checkNotNullParameter(mediaResource, "mediaResource");
        IMediaItemTransformer iMediaItemTransformer = this.mMediaItemTransformer;
        if (iMediaItemTransformer != null) {
            return iMediaItemTransformer.createMediaItem(mediaResource, itemParams, null);
        }
        return null;
    }

    private final boolean isDisablePlay() {
        synchronized (this.mDisablePlaySync) {
            if (!this.mDisablePlayLockList.isEmpty()) {
                Iterator<DisablePlayLock> it = this.mDisablePlayLockList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    DisablePlayLock next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    DisablePlayLock lock = next;
                    if (lock.isHeld()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public DisablePlayLock acquireDisablePlayLock(String name) {
        DisablePlayLock lock;
        Intrinsics.checkNotNullParameter(name, "name");
        synchronized (this.mDisablePlaySync) {
            lock = new DisablePlayLock(name);
            lock.acquire();
            this.mDisablePlayLockList.add(lock);
            BLog.i(TAG, "acquireDisablePlayLock:" + name);
        }
        return lock;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void releaseDisablePlayLock(DisablePlayLock lock) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        synchronized (this.mDisablePlaySync) {
            lock.release();
            this.mDisablePlayLockList.remove(lock);
            BLog.i(TAG, "releaseDisablePlayLock:" + lock.getName());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setPlayerPerformanceListener(IPlayerPerformanceListener listener) {
        this.mPlayerPerformanceListener = listener;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean playFromShared(Function0<Unit> function0, Function0<Unit> function02) {
        IMediaPlayContext iMediaPlayContext;
        IjkMediaPlayerItem realMediaItem;
        PlayerSharedState playerSharedState;
        IMediaPlayContext iMediaPlayContext2;
        Intrinsics.checkNotNullParameter(function0, "prepare");
        Intrinsics.checkNotNullParameter(function02, "success");
        PlayerContainerImpl playerContainerImpl = null;
        PlayerLog.i(TAG, "play from shared, enable: " + this.mPlayFromSharedEnable + ", isPrepared: " + (this.mMediaPlayContext != null ? Boolean.valueOf(iMediaPlayContext.isPrepared()) : null));
        if (this.mPlayFromSharedEnable) {
            IMediaPlayContext iMediaPlayContext3 = this.mMediaPlayContext;
            if (iMediaPlayContext3 != null && iMediaPlayContext3.isPrepared()) {
                this.mPlayFromSharedEnable = false;
                IMediaPlayContext iMediaPlayContext4 = this.mMediaPlayContext;
                if (!(iMediaPlayContext4 != null && iMediaPlayContext4.isPlaying())) {
                    IMediaPlayContext iMediaPlayContext5 = this.mMediaPlayContext;
                    if (!(iMediaPlayContext5 != null && iMediaPlayContext5.isPaused())) {
                        IMediaPlayContext iMediaPlayContext6 = this.mMediaPlayContext;
                        if (!(iMediaPlayContext6 != null && iMediaPlayContext6.isPlayCompleted())) {
                            PlayerLog.w(TAG, "some state error, shared failed. completed: " + (this.mMediaPlayContext != null ? Boolean.valueOf(iMediaPlayContext2.isPlayCompleted()) : null));
                            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
                            if (playerContainerImpl2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            } else {
                                playerContainerImpl = playerContainerImpl2;
                            }
                            playerContainerImpl.setSharing(false);
                            return false;
                        }
                    }
                }
                function0.invoke();
                MediaResource mediaResource = this.mMediaResource;
                if (mediaResource == null || !checkMediaResource(mediaResource)) {
                    PlayerLog.w(TAG, "shared failed. completed: resource error");
                    PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
                    if (playerContainerImpl3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl = playerContainerImpl3;
                    }
                    playerContainerImpl.setSharing(false);
                    resetMediaResource();
                    return false;
                }
                dispatchMediaResourceChanged(mediaResource);
                PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
                if (playerContainerImpl4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl4 = null;
                }
                PlayerSharingBundle sharingBundle = playerContainerImpl4.getPlayerParams().getSharingBundle();
                int targetState = (sharingBundle == null || (playerSharedState = sharingBundle.getPlayerSharedState()) == null) ? 4 : playerSharedState.getPlayerState();
                IMediaPlayContext iMediaPlayContext7 = this.mMediaPlayContext;
                if (iMediaPlayContext7 != null && iMediaPlayContext7.isPlaying()) {
                    targetState = 4;
                } else {
                    IMediaPlayContext iMediaPlayContext8 = this.mMediaPlayContext;
                    if (iMediaPlayContext8 != null && iMediaPlayContext8.isPaused()) {
                        targetState = 5;
                    } else {
                        IMediaPlayContext iMediaPlayContext9 = this.mMediaPlayContext;
                        if (iMediaPlayContext9 != null && iMediaPlayContext9.isPlayCompleted()) {
                            seekTo(0);
                        }
                    }
                }
                PlayerLog.i(TAG, "play from shared, target state: " + targetState);
                if (targetState != 3) {
                    setState(3);
                }
                switch (targetState) {
                    case 4:
                    case 5:
                    case 6:
                        this.mRenderStartObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda29
                            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                            public final void run(Object obj) {
                                ((IRenderStartObserver) obj).onVideoRenderStart();
                            }
                        });
                        break;
                }
                setState(targetState);
                HandlerThreads.postAtFront(4, new Runnable() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda30
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlayerCoreServiceV2.playFromShared$lambda$1(PlayerCoreServiceV2.this);
                    }
                });
                IMediaPlayContext iMediaPlayContext10 = this.mMediaPlayContext;
                MediaItem mediaItem = iMediaPlayContext10 != null ? iMediaPlayContext10.getCurrentMediaItem() : null;
                if ((mediaItem instanceof IjkMediaItem) && (realMediaItem = ((IjkMediaItem) mediaItem).realMediaItem()) != null) {
                    realMediaItem.setAssetUpdateListener(this.mItemUpdateListener);
                }
                function02.invoke();
                PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
                if (playerContainerImpl5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainerImpl = playerContainerImpl5;
                }
                playerContainerImpl.setSharing(false);
                resetRestoreState();
                return true;
            }
        }
        if (this.mRestoringFromShutdownByOthers) {
            function0.invoke();
            restorePlayer();
            function02.invoke();
        }
        this.mPlayFromSharedEnable = false;
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl = playerContainerImpl6;
        }
        playerContainerImpl.setSharing(false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playFromShared$lambda$1(PlayerCoreServiceV2 this$0) {
        float speed;
        if (this$0.mCurrentPlayerState == 4) {
            speed = IPlayerCoreService.CC.getPlaySpeed$default(this$0, false, 1, null);
        } else {
            speed = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        this$0.mPlayerClockChangedListener.onPlayerClockChanged(null, speed, this$0.getRealCurrentPosition());
    }

    private final void setMediaItem(MediaItem<?> mediaItem) {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setMediaItem(mediaItem);
        }
        if (this.mCurrentPlayerState != 2) {
            setState(2);
        }
    }

    private final void notifyTrackInfo(final IMediaPlayer mediaPlayer) {
        if (mediaPlayer instanceof IjkMediaPlayer) {
            this.mOnTrackInfoObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda8
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    PlayerCoreServiceV2.notifyTrackInfo$lambda$0(IMediaPlayer.this, (OnTrackInfoObserver) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyTrackInfo$lambda$0(IMediaPlayer $mediaPlayer, OnTrackInfoObserver it) {
        IjkTrackInfo[] trackInfo = ((IjkMediaPlayer) $mediaPlayer).getTrackInfo();
        Intrinsics.checkNotNullExpressionValue(trackInfo, "getTrackInfo(...)");
        it.onTrackInfo(trackInfo);
    }

    private final void dispatchMediaResourceChanged(final MediaResource resource) {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IPlayerSettingService.CC.updatePlayMenuConfig$default(playerContainerImpl.getPlayerSettingService(), resource != null ? resource.getPlayConfig() : null, false, 2, null);
        this.mMediaResourceObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$$ExternalSyntheticLambda13
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IMediaResourceObserver) obj).onUpdated(resource);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public MediaItem<?> getCurrentMediaItem() {
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            return iMediaPlayContext.getCurrentMediaItem();
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean supportMiniPlayer() {
        if (!this.mMiniPlayerAvailable) {
            return false;
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPlayerSettingService().getCloudConfig().supportMiniPlayer();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public void setMiniPlayerAvailable(boolean available) {
        this.mMiniPlayerAvailable = available;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerCoreService
    public boolean isMiniPlayerAvailable() {
        return this.mMiniPlayerAvailable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLiveResource() {
        PlayIndex playIndex;
        String str;
        MediaResource mediaResource = this.mMediaResource;
        return (mediaResource == null || (playIndex = mediaResource.getPlayIndex()) == null || (str = playIndex.mFrom) == null || !str.equals("live")) ? false : true;
    }

    private final void setMonitorToMediaPlayer() {
        if (this.mMediaPlayContext == null) {
            return;
        }
        IMediaPlayContext iMediaPlayContext = this.mMediaPlayContext;
        if (iMediaPlayContext != null) {
            iMediaPlayContext.setOnPreparedListener(this.mOnPreparedListener);
        }
        IMediaPlayContext iMediaPlayContext2 = this.mMediaPlayContext;
        if (iMediaPlayContext2 != null) {
            iMediaPlayContext2.setOnInfoListener(this.mOnInfoListener);
        }
        IMediaPlayContext iMediaPlayContext3 = this.mMediaPlayContext;
        if (iMediaPlayContext3 != null) {
            iMediaPlayContext3.setOnSeekComplete(this.mSeekCompleteListener);
        }
        IMediaPlayContext iMediaPlayContext4 = this.mMediaPlayContext;
        if (iMediaPlayContext4 != null) {
            iMediaPlayContext4.setOnExtraInfoListener(this.mOnExtraInfoListener);
        }
        IMediaPlayContext iMediaPlayContext5 = this.mMediaPlayContext;
        if (iMediaPlayContext5 != null) {
            iMediaPlayContext5.setOnErrorListener(this.mOnErrorListener);
        }
        IMediaPlayContext iMediaPlayContext6 = this.mMediaPlayContext;
        if (iMediaPlayContext6 != null) {
            iMediaPlayContext6.setPlayerClockChangedListener(this.mPlayerClockChangedListener);
        }
        IMediaPlayContext iMediaPlayContext7 = this.mMediaPlayContext;
        if (iMediaPlayContext7 != null) {
            iMediaPlayContext7.setOnRawDataWriteListener(this.mOnRawDataWriteListener);
        }
        IMediaPlayContext iMediaPlayContext8 = this.mMediaPlayContext;
        if (iMediaPlayContext8 != null) {
            iMediaPlayContext8.setOnMediaStreamChangedListener(this.mOnMediaStreamChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> getDashAutoRange() {
        boolean isAuto = getDashAuto();
        int autoMax = isAuto ? ABRManagerKt.getMaxQn() : -1;
        int autoMin = isAuto ? ABRManagerKt.getMinQn() : -1;
        if (autoMin <= 0 || autoMax <= 0) {
            return null;
        }
        return new Pair<>(Integer.valueOf(autoMin), Integer.valueOf(autoMax));
    }

    /* compiled from: PlayerCoreServiceV2.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$RestoreState;", "", "stateWhenShutdown", "", "videoStreamId", "autoRange", "Lkotlin/Pair;", "<init>", "(ILjava/lang/Integer;Lkotlin/Pair;)V", "getStateWhenShutdown", "()I", "setStateWhenShutdown", "(I)V", "getVideoStreamId", "()Ljava/lang/Integer;", "setVideoStreamId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAutoRange", "()Lkotlin/Pair;", "setAutoRange", "(Lkotlin/Pair;)V", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Lkotlin/Pair;)Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$RestoreState;", "equals", "", "other", "hashCode", "toString", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RestoreState {
        private Pair<Integer, Integer> autoRange;
        private int stateWhenShutdown;
        private Integer videoStreamId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RestoreState copy$default(RestoreState restoreState, int i, Integer num, Pair pair, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = restoreState.stateWhenShutdown;
            }
            if ((i2 & 2) != 0) {
                num = restoreState.videoStreamId;
            }
            if ((i2 & 4) != 0) {
                pair = restoreState.autoRange;
            }
            return restoreState.copy(i, num, pair);
        }

        public final int component1() {
            return this.stateWhenShutdown;
        }

        public final Integer component2() {
            return this.videoStreamId;
        }

        public final Pair<Integer, Integer> component3() {
            return this.autoRange;
        }

        public final RestoreState copy(int i, Integer num, Pair<Integer, Integer> pair) {
            return new RestoreState(i, num, pair);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RestoreState) {
                RestoreState restoreState = (RestoreState) obj;
                return this.stateWhenShutdown == restoreState.stateWhenShutdown && Intrinsics.areEqual(this.videoStreamId, restoreState.videoStreamId) && Intrinsics.areEqual(this.autoRange, restoreState.autoRange);
            }
            return false;
        }

        public int hashCode() {
            return (((this.stateWhenShutdown * 31) + (this.videoStreamId == null ? 0 : this.videoStreamId.hashCode())) * 31) + (this.autoRange != null ? this.autoRange.hashCode() : 0);
        }

        public String toString() {
            int i = this.stateWhenShutdown;
            Integer num = this.videoStreamId;
            return "RestoreState(stateWhenShutdown=" + i + ", videoStreamId=" + num + ", autoRange=" + this.autoRange + ")";
        }

        public RestoreState(int stateWhenShutdown, Integer videoStreamId, Pair<Integer, Integer> pair) {
            this.stateWhenShutdown = stateWhenShutdown;
            this.videoStreamId = videoStreamId;
            this.autoRange = pair;
        }

        public final int getStateWhenShutdown() {
            return this.stateWhenShutdown;
        }

        public final void setStateWhenShutdown(int i) {
            this.stateWhenShutdown = i;
        }

        public final Integer getVideoStreamId() {
            return this.videoStreamId;
        }

        public final void setVideoStreamId(Integer num) {
            this.videoStreamId = num;
        }

        public final Pair<Integer, Integer> getAutoRange() {
            return this.autoRange;
        }

        public final void setAutoRange(Pair<Integer, Integer> pair) {
            this.autoRange = pair;
        }
    }
}