package tv.danmaku.biliplayerimpl.render;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.moduleservice.player.HDRUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.core.IPlayerRenderContextService;
import tv.danmaku.biliplayerimpl.render.IRenderContainer;
import tv.danmaku.biliplayerimpl.render.RenderContainerService;
import tv.danmaku.biliplayerimpl.render.wholescene.WholeSceneSupervisor;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.FrameRenderedInfo;
import tv.danmaku.biliplayerv2.service.IMediaCenterObserver;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IRenderLayer;
import tv.danmaku.biliplayerv2.service.OnVideoLayerAttachedObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.RenderContainerMatrixChangedObserver;
import tv.danmaku.biliplayerv2.service.RenderLayerTransform;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.render.wholescene.WholeSceneModeChangeObserver;
import tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.ijk.media.player.render.tools.BiliDaltonizer;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.render.core.TextureVideoRenderLayer;
import tv.danmaku.render.core.TransformParams;
import tv.danmaku.render.core.VideoRenderLayerFactory;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaPlayAdapterKt;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: RenderContainerServiceV2.kt */
@Metadata(d1 = {"\u0000Û\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012*\tGJMPSVY\\_\b\u0000\u0018\u0000 ì\u00012\u00020\u00012\u00020\u0002:\u0006ì\u0001í\u0001î\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010a\u001a\u00020<H\u0002J\u0010\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020\u0012H\u0016J\b\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020.H\u0016J\b\u0010g\u001a\u00020.H\u0016J\b\u0010h\u001a\u00020\u0012H\u0016J\u0010\u0010i\u001a\u00020<2\u0006\u0010j\u001a\u00020\u0014H\u0016J$\u0010k\u001a\u00020<2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u000100H\u0016J\b\u0010p\u001a\u00020\u0014H\u0016J\b\u0010q\u001a\u00020\u0014H\u0016J\u0010\u0010r\u001a\u00020<2\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0018\u0010t\u001a\u00020<2\u0006\u0010u\u001a\u0002002\u0006\u0010v\u001a\u00020\u0014H\u0016J\u001a\u0010w\u001a\u00020<2\u0006\u0010u\u001a\u0002002\b\b\u0002\u0010v\u001a\u00020\u0014H\u0002J\u0014\u0010x\u001a\u0004\u0018\u00010\u001a2\b\u0010y\u001a\u0004\u0018\u00010zH\u0002J\b\u0010{\u001a\u000200H\u0016J\u0012\u0010|\u001a\u00020<2\b\u0010}\u001a\u0004\u0018\u00010~H\u0016J\u001a\u0010\u007f\u001a\u00020<2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010}\u001a\u00020~H\u0016J\u001d\u0010\u0082\u0001\u001a\u00020<2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010}\u001a\u0004\u0018\u00010~H\u0016J\t\u0010\u0083\u0001\u001a\u00020<H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020<2\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0016J\u0014\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020<2\u0007\u0010\u008b\u0001\u001a\u00020\u0018H\u0002J\u0014\u0010\u008c\u0001\u001a\u00020<2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0014H\u0016J\u0014\u0010\u008e\u0001\u001a\u00020<2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001eH\u0016J\t\u0010\u0090\u0001\u001a\u00020<H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020<2\u0007\u0010\u0092\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010\u0093\u0001\u001a\u00020<2\u0007\u0010\u0092\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020<2\u0007\u0010\u0092\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020<2\u0007\u0010\u0092\u0001\u001a\u00020\u000eH\u0016J\u001e\u0010\u0096\u0001\u001a\u00020<2\u0007\u0010\u0097\u0001\u001a\u00020\u00142\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020<2\u0007\u0010\u009a\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u009b\u0001\u001a\u00020<H\u0016J\u001d\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u008b\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020.H\u0016J\t\u0010 \u0001\u001a\u00020<H\u0002J\u0013\u0010¡\u0001\u001a\u00020\u00142\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\u0013\u0010¤\u0001\u001a\u00020<2\b\u0010\u008b\u0001\u001a\u00030£\u0001H\u0002J\u0013\u0010¥\u0001\u001a\u00020<2\b\u0010\u008b\u0001\u001a\u00030£\u0001H\u0016J\u0013\u0010¥\u0001\u001a\u00020<2\b\u0010\u008b\u0001\u001a\u00030\u009e\u0001H\u0016J\u001d\u0010¦\u0001\u001a\u00020<2\u0007\u0010§\u0001\u001a\u00020\u001c2\t\b\u0002\u0010¨\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010©\u0001\u001a\u00020<2\t\b\u0002\u0010ª\u0001\u001a\u00020\u0014H\u0002J\u0015\u0010«\u0001\u001a\u00020<2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016J%\u0010®\u0001\u001a\u00020<2\b\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010±\u0001\u001a\u00020.2\u0007\u0010²\u0001\u001a\u00020.H\u0016J\u000b\u0010³\u0001\u001a\u0004\u0018\u00010mH\u0016J\u0012\u0010´\u0001\u001a\u00020<2\u0007\u0010µ\u0001\u001a\u00020\u0014H\u0016J\t\u0010¶\u0001\u001a\u00020\u0014H\u0016J\u0014\u0010·\u0001\u001a\u00020<2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010º\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010»\u0001\u001a\u00020<2\u0007\u0010¹\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010¼\u0001\u001a\u00020<2\u0007\u0010\u008b\u0001\u001a\u00020\u0018H\u0002J\u000b\u0010½\u0001\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010¾\u0001\u001a\u00020\u00182\u0007\u0010¸\u0001\u001a\u00020\u001aH\u0016J\u0013\u0010¿\u0001\u001a\u00020<2\b\u0010¸\u0001\u001a\u00030À\u0001H\u0016J\f\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J5\u0010Ã\u0001\u001a\u00020<2\u0007\u0010Ä\u0001\u001a\u00020.2\u0007\u0010Å\u0001\u001a\u00020.2\u0007\u0010Æ\u0001\u001a\u00020.2\u0007\u0010Ç\u0001\u001a\u00020.2\u0006\u0010v\u001a\u00020\u0014H\u0016J#\u0010È\u0001\u001a\u00020<2\u0007\u0010É\u0001\u001a\u00020.2\u0007\u0010Ê\u0001\u001a\u00020.2\u0006\u0010v\u001a\u00020\u0014H\u0016J\t\u0010Ë\u0001\u001a\u00020.H\u0016J\t\u0010Ì\u0001\u001a\u00020.H\u0016J\u0013\u0010Í\u0001\u001a\u00020<2\b\u0010\u0092\u0001\u001a\u00030Î\u0001H\u0016J\u0013\u0010Ï\u0001\u001a\u00020<2\b\u0010\u0092\u0001\u001a\u00030Î\u0001H\u0016J\u0012\u0010Ð\u0001\u001a\u00020<2\u0007\u0010Ñ\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ò\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ó\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ô\u0001\u001a\u00020<H\u0002J\u0012\u0010Õ\u0001\u001a\u00020<2\u0007\u0010Ñ\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0016J\u001b\u0010×\u0001\u001a\u00020<2\u0007\u0010É\u0001\u001a\u00020e2\u0007\u0010Ê\u0001\u001a\u00020eH\u0016J\u0012\u0010Ø\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u000206H\u0016J\u0012\u0010Ù\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u000206H\u0016J\u0012\u0010Ú\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u000208H\u0016J\u0012\u0010Û\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u000208H\u0016J\f\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J\u0013\u0010Þ\u0001\u001a\u00020\u00142\b\u0010ß\u0001\u001a\u00030Ý\u0001H\u0016J\u0012\u0010à\u0001\u001a\u00020<2\u0007\u0010á\u0001\u001a\u00020eH\u0016J\u0012\u0010â\u0001\u001a\u00020<2\u0007\u0010ã\u0001\u001a\u00020eH\u0016J\u001b\u0010ä\u0001\u001a\u00020<2\u0007\u0010å\u0001\u001a\u00020.2\u0007\u0010æ\u0001\u001a\u00020.H\u0016J-\u0010ç\u0001\u001a\u00020<2\u0007\u0010ã\u0001\u001a\u00020e2\u0007\u0010è\u0001\u001a\u00020.2\u0007\u0010é\u0001\u001a\u00020.2\u0007\u0010á\u0001\u001a\u00020eH\u0016J \u0010ê\u0001\u001a\u00020<2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0018\u00010:H\u0016J\t\u0010ë\u0001\u001a\u00020<H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000e0\u000e \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\n0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u0015\u001a6\u0012\u0014\u0012\u0012 \f*\b\u0018\u00010\u0016R\u00020\u00000\u0016R\u00020\u0000 \f*\u001a\u0012\u0014\u0012\u0012 \f*\b\u0018\u00010\u0016R\u00020\u00000\u0016R\u00020\u0000\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00060%R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.0-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R2\u00105\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010606 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010606\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R2\u00107\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010808 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010808\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001b\u0010A\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bB\u0010CR\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u0010\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0004\n\u0002\u0010KR\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010NR\u0010\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0004\n\u0002\u0010QR\u0010\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0004\n\u0002\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0010\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ZR\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]R\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`R\u000f\u0010¹\u0001\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ï\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/RenderContainerService;", "Ltv/danmaku/biliplayerv2/service/IRenderContainerService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mRenderContainer", "Ltv/danmaku/biliplayerimpl/render/IRenderContainer;", "mRenderMatrixChangedObservers", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/RenderContainerMatrixChangedObserver;", "kotlin.jvm.PlatformType", "mVideoLayerTypeChangedObservers", "Ltv/danmaku/biliplayerv2/service/OnVideoLayerAttachedObserver;", "mCurrentScreenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "mCurrentDisplayAspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "mCurrentFlip", "", "mChildrenLayers", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$RenderLayer;", "mVideoRenderLayer", "Ltv/danmaku/render/core/IVideoRenderLayer;", "mExactlyLayerType", "Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "mRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "mCustomFirstFrameListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "mDispatchViewPortRunnableScheduled", "mShouldResetRenderLayer", "mPendingKeepViewportUntilSurfaceCreated", "mPendingKeepTransform", "mPendingNotifyCustomFirstFrame", "mDispatchViewPortRunnable", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$DispatchViewPortRunnable;", "mTempRenderMatrix", "Landroid/graphics/Matrix;", "mVideoRenderLayerFactory", "Ltv/danmaku/render/core/VideoRenderLayerFactory;", "mWholeSceneSupervisor", "Ltv/danmaku/biliplayerimpl/render/wholescene/WholeSceneSupervisor;", "mOffset", "Lkotlin/Pair;", "", "mPadding", "Landroid/graphics/Rect;", "mCurrentRenderViewport", "mCustomizedViewport", "mVideoChangedWaitRender", "mIsPlayerShutdownByOthers", "mVideoSizeChangedListeners", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "mVideoRenderLayerStateList", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "mFrameRenderedListener", "Lkotlin/Function1;", "Ltv/danmaku/biliplayerv2/service/FrameRenderedInfo;", "", "mRenderContextService", "Ltv/danmaku/biliplayerimpl/core/IPlayerRenderContextService;", "getMRenderContextService", "()Ltv/danmaku/biliplayerimpl/core/IPlayerRenderContextService;", "hitColorEnhanceTexture", "getHitColorEnhanceTexture", "()Z", "hitColorEnhanceTexture$delegate", "Lkotlin/Lazy;", "mPlayerSettingChangeObserver", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mPlayerSettingChangeObserver$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mPlayerSettingChangeObserver$1;", "mMediaResourceObserver", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mMediaResourceObserver$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mMediaResourceObserver$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mPlayerStateObserver$1;", "mMediaCenterObserver", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mMediaCenterObserver$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mMediaCenterObserver$1;", "mMeasureAndLayoutChildHandler", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mMeasureAndLayoutChildHandler$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mMeasureAndLayoutChildHandler$1;", "mRenderLayerChangedListener", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mRenderLayerChangedListener$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mRenderLayerChangedListener$1;", "mCloudConfigObserver", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mCloudConfigObserver$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mCloudConfigObserver$1;", "mVideoSizeChangedListener", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mVideoSizeChangedListener$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mVideoSizeChangedListener$1;", "mVideoRenderLayerStateObserver", "tv/danmaku/biliplayerimpl/render/RenderContainerService$mVideoRenderLayerStateObserver$1", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService$mVideoRenderLayerStateObserver$1;", "adjustWholeSceneMode", "setAspectRatio", "ratio", "getVideoRatio", "", "getVideoHeight", "getVideoWidth", "getAspectRatio", "setLayerAlpha", "alpha", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "supportVideoCapture", "supportFlipVideo", "flipVideo", "reversal", "updateViewPort", "containerRect", "immediately", "updateViewPortInternal", "adjustLayerType", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "getRenderViewBounds", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onAttachByShared", "onStop", "bindPlayerContainer", "playerContainer", "createView", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attachVideoLayer", "layer", "detachVideoLayer", "isRenderLayerSupportTransform", "setFirstFrameListener", "listener", "dispatchMatrixChanged", "addRenderContainerChangedObserver", "observer", "removeRenderContainerChangedObserver", "addVideoLayerAttachedObserver", "removeVideoLayerAttachedObserver", "resetRenderContainer", "withAnim", "Landroid/animation/AnimatorListenerAdapter;", "notifyScreenModeTypeChanged", "screenModeType", "notifyVideoChanged", "addRenderLayer", "Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;", "Ltv/danmaku/biliplayerv2/service/IRenderLayer;", "index", "dumpRenderLayers", "alignVideoLayerView", "view", "Landroid/view/View;", "removeLayer", "removeRenderLayer", "bindRenderContext", "renderContext", "keepViewportUntilSurfaceCreated", "unbindRenderContext", "keepSurfaceForShare", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "takeVideoCaptureEffectively", "setKeepScreenOn", "keep", "useExternalRender", "setExactlyVideoLayerType", "type", "videoScreenNeedSecured", "enableSecureVideoScreen", "secureVideoScreen", "resetVideoRenderLayer", "getCurrentLayerType", "createVideoLayer", "setDaltonism", "Ltv/danmaku/ijk/media/player/render/tools/BiliDaltonizer$ColorBlindnessType;", "getPanelContainer", "Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "setViewportPadding", "left", "top", "right", "bottom", "setViewportOffset", "offsetX", "offsetY", "getViewportOffsetX", "getViewportOffsetY", "addWholeSceneModeChangeObserver", "Ltv/danmaku/biliplayerv2/service/render/wholescene/WholeSceneModeChangeObserver;", "removeWholeSceneModeChangObserver", "enterWholeSceneMode", "fromUser", "supportWholeScene", "shouldAutoEnterWholeSceneMode", "restoreFromShutDownByOthers", "exitWholeSceneMode", "isInWholeSceneMode", "notifyWholeSceneOffset", "removeVideoSizeChangedListener", "addVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "removeVideoRenderLayerStateObserver", "getCurrentLayerTransform", "Ltv/danmaku/biliplayerv2/service/RenderLayerTransform;", "applyCurrentLayerTransform", "transform", "rotateCurrentLayer", "degree", "scaleCurrentLayer", "scale", "translateCurrentLayer", "translationX", "translationY", "transformCurrentLayer", "tX", "tY", "setFrameRenderedListener", "updateFrameRendererListenerState", "Companion", "RenderLayer", "DispatchViewPortRunnable", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderContainerService extends AbsCorePlayerService implements IRenderContainerService {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Render::RenderContainerServiceV2";
    private boolean mCurrentFlip;
    private IJKEXTRendererInterface.OnFirstFrameListener mCustomFirstFrameListener;
    private Rect mCustomizedViewport;
    private boolean mDispatchViewPortRunnableScheduled;
    private IVideoRenderLayer.Type mExactlyLayerType;
    private Function1<? super FrameRenderedInfo, Unit> mFrameRenderedListener;
    private boolean mIsPlayerShutdownByOthers;
    private boolean mPendingKeepTransform;
    private boolean mPendingKeepViewportUntilSurfaceCreated;
    private boolean mPendingNotifyCustomFirstFrame;
    private PlayerContainerImpl mPlayerContainer;
    private IRenderContainer mRenderContainer;
    private IMediaPlayRenderContext mRenderContext;
    private boolean mShouldResetRenderLayer;
    private boolean mVideoChangedWaitRender;
    private IVideoRenderLayer mVideoRenderLayer;
    private VideoRenderLayerFactory mVideoRenderLayerFactory;
    private WholeSceneSupervisor mWholeSceneSupervisor;
    private boolean videoScreenNeedSecured;
    private Collections.SafeIteratorList<RenderContainerMatrixChangedObserver> mRenderMatrixChangedObservers = Collections.safeIteratorList(new LinkedList());
    private Collections.SafeIteratorList<OnVideoLayerAttachedObserver> mVideoLayerTypeChangedObservers = Collections.safeIteratorList(new LinkedList());
    private ScreenModeType mCurrentScreenModeType = ScreenModeType.THUMB;
    private AspectRatio mCurrentDisplayAspectRatio = AspectRatio.RATIO_ADJUST_CONTENT;
    private final Collections.SafeIteratorList<RenderLayer> mChildrenLayers = Collections.safeIteratorList(new LinkedList());
    private final DispatchViewPortRunnable mDispatchViewPortRunnable = new DispatchViewPortRunnable();
    private final Matrix mTempRenderMatrix = new Matrix();
    private Pair<Integer, Integer> mOffset = new Pair<>(0, 0);
    private Rect mPadding = new Rect(0, 0, 0, 0);
    private final Rect mCurrentRenderViewport = new Rect();
    private final Collections.SafeIteratorList<IVideoRenderLayer.OnVideoSizeChangedListener> mVideoSizeChangedListeners = Collections.safeIteratorList(new ArrayList());
    private final Collections.SafeIteratorList<IVideoRenderLayer.VideoRenderLayerStateObserver> mVideoRenderLayerStateList = Collections.safeIteratorList(new ArrayList());
    private final Lazy hitColorEnhanceTexture$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda10
        public final Object invoke() {
            boolean hitColorEnhanceTexture_delegate$lambda$0;
            hitColorEnhanceTexture_delegate$lambda$0 = RenderContainerService.hitColorEnhanceTexture_delegate$lambda$0();
            return Boolean.valueOf(hitColorEnhanceTexture_delegate$lambda$0);
        }
    });
    private final RenderContainerService$mPlayerSettingChangeObserver$1 mPlayerSettingChangeObserver = new PlayerSettingChangeObserver() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mPlayerSettingChangeObserver$1
        @Override // tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver
        public void onChange(String key) {
            boolean z;
            boolean z2;
            AspectRatio aspectRatio;
            Intrinsics.checkNotNullParameter(key, "key");
            PlayerContainerImpl playerContainerImpl = null;
            if (Intrinsics.areEqual(key, Player.KEY_PLAYER_ASPECT)) {
                PlayerContainerImpl playerContainerImpl2 = RenderContainerService.this.mPlayerContainer;
                if (playerContainerImpl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl2 = null;
                }
                IPlayerSettingService playerSettingService = playerContainerImpl2.getPlayerSettingService();
                PlayerContainerImpl playerContainerImpl3 = RenderContainerService.this.mPlayerContainer;
                if (playerContainerImpl3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainerImpl = playerContainerImpl3;
                }
                AspectRatio aspect = AspectRatio.valueOf(playerSettingService.getString(Player.KEY_PLAYER_ASPECT, playerContainerImpl.getPlayerParams().getConfig().getDefaultAspectRatio().toString()));
                aspectRatio = RenderContainerService.this.mCurrentDisplayAspectRatio;
                if (aspectRatio != aspect) {
                    RenderContainerService.this.setAspectRatio(aspect);
                }
            } else if (Intrinsics.areEqual(key, Player.KEY_FLIP_VIDEO_SELECTED)) {
                PlayerContainerImpl playerContainerImpl4 = RenderContainerService.this.mPlayerContainer;
                if (playerContainerImpl4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainerImpl = playerContainerImpl4;
                }
                boolean flip = playerContainerImpl.getPlayerSettingService().getBoolean(Player.KEY_FLIP_VIDEO_SELECTED, false);
                z = RenderContainerService.this.mCurrentFlip;
                if (z != flip) {
                    RenderContainerService renderContainerService = RenderContainerService.this;
                    z2 = RenderContainerService.this.mCurrentFlip;
                    renderContainerService.flipVideo(z2);
                }
            }
        }
    };
    private final RenderContainerService$mMediaResourceObserver$1 mMediaResourceObserver = new IMediaResourceObserver() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mMediaResourceObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public /* synthetic */ void onUpdated(MediaResource mediaResource) {
            IMediaResourceObserver.CC.$default$onUpdated(this, mediaResource);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public boolean onPrepared(MediaResource resource) {
            boolean z;
            IVideoRenderLayer.Type adjustTargetType;
            boolean z2;
            RenderContainerService.this.mIsPlayerShutdownByOthers = false;
            z = RenderContainerService.this.mVideoChangedWaitRender;
            PlayerContainerImpl playerContainerImpl = null;
            if (z) {
                IRenderContainerService.CC.resetRenderContainer$default(RenderContainerService.this, false, null, 2, null);
                RenderContainerService.this.mVideoChangedWaitRender = false;
            }
            adjustTargetType = RenderContainerService.this.adjustLayerType(resource);
            BLog.i("Render::RenderContainerServiceV2", "onPrepared adjustTargetType " + adjustTargetType);
            if (adjustTargetType == null) {
                z2 = RenderContainerService.this.mShouldResetRenderLayer;
                if (z2) {
                    IRenderContainerService.CC.resetRenderContainer$default(RenderContainerService.this, false, null, 2, null);
                    RenderContainerService.this.mShouldResetRenderLayer = false;
                    RenderContainerService renderContainerService = RenderContainerService.this;
                    PlayerContainerImpl playerContainerImpl2 = RenderContainerService.this.mPlayerContainer;
                    if (playerContainerImpl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl = playerContainerImpl2;
                    }
                    renderContainerService.setExactlyVideoLayerType(playerContainerImpl.getPlayerParams().getConfig().getVideoRenderLayerType());
                }
            } else {
                IVideoRenderLayer.Type curType = RenderContainerService.this.getCurrentLayerType();
                if (adjustTargetType != curType) {
                    RenderContainerService.this.mShouldResetRenderLayer = true;
                    IRenderContainerService.CC.resetRenderContainer$default(RenderContainerService.this, false, null, 2, null);
                    RenderContainerService.this.setExactlyVideoLayerType(adjustTargetType);
                }
            }
            return IMediaResourceObserver.CC.$default$onPrepared(this, resource);
        }
    };
    private final RenderContainerService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            boolean z;
            boolean z2;
            IJKEXTRendererInterface.OnFirstFrameListener onFirstFrameListener;
            PlayerContainerImpl playerContainerImpl = null;
            switch (state) {
                case 3:
                    if (!IjkMediaPlayAdapterKt.getHitExternalRenderFirstFrameDD()) {
                        z2 = RenderContainerService.this.mPendingNotifyCustomFirstFrame;
                        if (z2 && RenderContainerService.this.useExternalRender()) {
                            onFirstFrameListener = RenderContainerService.this.mCustomFirstFrameListener;
                            if (onFirstFrameListener != null) {
                                onFirstFrameListener.onFirstFrame();
                            }
                            RenderContainerService.this.mPendingNotifyCustomFirstFrame = false;
                        }
                    }
                    RenderContainerService renderContainerService = RenderContainerService.this;
                    PlayerContainerImpl playerContainerImpl2 = RenderContainerService.this.mPlayerContainer;
                    if (playerContainerImpl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl = playerContainerImpl2;
                    }
                    renderContainerService.flipVideo(playerContainerImpl.getPlayerSettingService().getBoolean(Player.KEY_FLIP_VIDEO_SELECTED, false));
                    z = RenderContainerService.this.mIsPlayerShutdownByOthers;
                    if (z) {
                        RenderContainerService.this.restoreFromShutDownByOthers();
                        return;
                    }
                    return;
                case 4:
                    PlayerContainerImpl playerContainerImpl3 = RenderContainerService.this.mPlayerContainer;
                    if (playerContainerImpl3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl = playerContainerImpl3;
                    }
                    playerContainerImpl.getRenderContainerService().setKeepScreenOn(true);
                    return;
                case 5:
                    PlayerContainerImpl playerContainerImpl4 = RenderContainerService.this.mPlayerContainer;
                    if (playerContainerImpl4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl = playerContainerImpl4;
                    }
                    playerContainerImpl.getRenderContainerService().setKeepScreenOn(false);
                    return;
                case 6:
                    PlayerContainerImpl playerContainerImpl5 = RenderContainerService.this.mPlayerContainer;
                    if (playerContainerImpl5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainerImpl = playerContainerImpl5;
                    }
                    playerContainerImpl.getRenderContainerService().setKeepScreenOn(false);
                    return;
                default:
                    return;
            }
        }
    };
    private final RenderContainerService$mMediaCenterObserver$1 mMediaCenterObserver = new IMediaCenterObserver() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mMediaCenterObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onPlayerReconnect() {
            IMediaCenterObserver.CC.$default$onPlayerReconnect(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onPreparedFromMediaCenterTerminate() {
            IMediaCenterObserver.CC.$default$onPreparedFromMediaCenterTerminate(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onRestoreFromMediaCenterTerminate() {
            IMediaCenterObserver.CC.$default$onRestoreFromMediaCenterTerminate(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onTerminateByMediaCenter() {
            RenderContainerService.this.mIsPlayerShutdownByOthers = true;
        }
    };
    private final RenderContainerService$mMeasureAndLayoutChildHandler$1 mMeasureAndLayoutChildHandler = new IRenderContainer.MeasureAndLayoutChildHandler() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mMeasureAndLayoutChildHandler$1
        @Override // tv.danmaku.biliplayerimpl.render.IRenderContainer.MeasureAndLayoutChildHandler
        public void onLayout(boolean changed, int left, int top, int right, int bottom) {
            PlayerContainerImpl playerContainerImpl;
            Rect rect;
            Rect rect2;
            Rect rect3;
            Rect rect4;
            Rect rect5;
            Rect rect6;
            Rect rect7;
            boolean alignVideoLayerView;
            IRenderContainer container = RenderContainerService.this.mRenderContainer;
            if (container == null) {
                return;
            }
            int childCount = container.getChildCount();
            int i = 0;
            while (true) {
                playerContainerImpl = null;
                if (i >= childCount) {
                    break;
                }
                View child = container.getChildAt(i);
                IVideoRenderLayer iVideoRenderLayer = RenderContainerService.this.mVideoRenderLayer;
                if (!Intrinsics.areEqual(child, iVideoRenderLayer != null ? iVideoRenderLayer.getView() : null)) {
                    alignVideoLayerView = RenderContainerService.this.alignVideoLayerView(child);
                    if (!alignVideoLayerView) {
                        child.layout(left, top, right, bottom);
                    }
                }
                i++;
            }
            PlayerContainerImpl playerContainerImpl2 = RenderContainerService.this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl = playerContainerImpl2;
            }
            if (playerContainerImpl.getPlayerParams().getConfig().getUpdateVideoRenderViewPortEnable()) {
                rect7 = RenderContainerService.this.mCustomizedViewport;
                if (rect7 != null) {
                    return;
                }
            }
            rect = RenderContainerService.this.mCurrentRenderViewport;
            rect.left = 0;
            rect2 = RenderContainerService.this.mCurrentRenderViewport;
            rect2.top = 0;
            rect3 = RenderContainerService.this.mCurrentRenderViewport;
            rect3.right = right - left;
            rect4 = RenderContainerService.this.mCurrentRenderViewport;
            rect4.bottom = bottom - top;
            rect5 = RenderContainerService.this.mCurrentRenderViewport;
            if (!rect5.isEmpty()) {
                RenderContainerService renderContainerService = RenderContainerService.this;
                rect6 = RenderContainerService.this.mCurrentRenderViewport;
                renderContainerService.updateViewPortInternal(rect6, true);
                return;
            }
            PlayerLog.i("Render::RenderContainerServiceV2", "onLayout view_port is empty!!!");
        }

        @Override // tv.danmaku.biliplayerimpl.render.IRenderContainer.MeasureAndLayoutChildHandler
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            boolean alignVideoLayerView;
            IRenderContainer container = RenderContainerService.this.mRenderContainer;
            if (container == null) {
                return;
            }
            int childCount = container.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = container.getChildAt(i);
                IVideoRenderLayer iVideoRenderLayer = RenderContainerService.this.mVideoRenderLayer;
                if (!Intrinsics.areEqual(child, iVideoRenderLayer != null ? iVideoRenderLayer.getView() : null)) {
                    alignVideoLayerView = RenderContainerService.this.alignVideoLayerView(child);
                    if (!alignVideoLayerView) {
                        container.measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    }
                }
            }
        }
    };
    private final RenderContainerService$mRenderLayerChangedListener$1 mRenderLayerChangedListener = new IVideoRenderLayer.OnVideoRenderLayerChangedListener() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mRenderLayerChangedListener$1
        @Override // tv.danmaku.render.core.IVideoRenderLayer.OnVideoRenderLayerChangedListener
        public void onChanged() {
            RenderContainerService.this.dispatchMatrixChanged();
        }
    };
    private final RenderContainerService$mCloudConfigObserver$1 mCloudConfigObserver = new ICloudConfigObserver() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mCloudConfigObserver$1
        @Override // tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver
        public void onCloudConfigChanged() {
            RenderContainerService.this.adjustWholeSceneMode();
        }
    };
    private final RenderContainerService$mVideoSizeChangedListener$1 mVideoSizeChangedListener = new RenderContainerService$mVideoSizeChangedListener$1(this);
    private final RenderContainerService$mVideoRenderLayerStateObserver$1 mVideoRenderLayerStateObserver = new RenderContainerService$mVideoRenderLayerStateObserver$1(this);

    /* compiled from: RenderContainerServiceV2.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IVideoRenderLayer.Type.values().length];
            try {
                iArr[IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[IVideoRenderLayer.Type.TypeTextureViewWithExternalRender.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: RenderContainerServiceV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/RenderContainerService$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPlayerRenderContextService getMRenderContextService() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPlayerRenderContextService$biliplayerimpl_debug();
    }

    private final boolean getHitColorEnhanceTexture() {
        return ((Boolean) this.hitColorEnhanceTexture$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitColorEnhanceTexture_delegate$lambda$0() {
        return DeviceDecision.INSTANCE.getBoolean("dd_player_color_enhance_texture", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustWholeSceneMode() {
        if (supportWholeScene() && shouldAutoEnterWholeSceneMode()) {
            enterWholeSceneMode(false);
        } else if (isInWholeSceneMode()) {
            exitWholeSceneMode(false);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setAspectRatio(AspectRatio ratio) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.setAspectRatio(ratio);
        }
        this.mCurrentDisplayAspectRatio = ratio;
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getPlayerSettingService().putString(Player.KEY_PLAYER_ASPECT, ratio.toString());
        BLog.i(TAG, "setAspectRatio: " + ratio);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public float getVideoRatio() {
        float height = getVideoHeight();
        if (height <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        float width = getVideoWidth();
        if (width <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        return width / height;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public int getVideoHeight() {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            return iVideoRenderLayer.getVideoHeight();
        }
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            return iMediaPlayRenderContext.getVideoHeight();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public int getVideoWidth() {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            return iVideoRenderLayer.getVideoWidth();
        }
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            return iMediaPlayRenderContext.getVideoWidth();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public AspectRatio getAspectRatio() {
        return this.mCurrentDisplayAspectRatio;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setLayerAlpha(boolean alpha) {
        View layer;
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer == null || (layer = iVideoRenderLayer.getView()) == null) {
            return;
        }
        if (layer instanceof SurfaceView) {
            if (alpha) {
                SurfaceHolder holder = ((SurfaceView) layer).getHolder();
                if (holder != null) {
                    holder.setFormat(-2);
                }
                ((SurfaceView) layer).setZOrderMediaOverlay(true);
            } else {
                SurfaceHolder holder2 = ((SurfaceView) layer).getHolder();
                if (holder2 != null) {
                    holder2.setFormat(-1);
                }
                ((SurfaceView) layer).setZOrderMediaOverlay(false);
            }
        } else if (layer instanceof TextureView) {
            ((TextureView) layer).setOpaque(!alpha);
        }
        PlayerLog.i(TAG, "setLayerAlpha: " + alpha);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect rect) {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setBackgroundImage(bitmap, recycle, rect);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean supportVideoCapture() {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            return iVideoRenderLayer.supportCaptureVideo();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean supportFlipVideo() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        if (playerContainerImpl.getPlayerSettingService().getCloudConfig().supportFlip()) {
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            return !(iVideoRenderLayer != null && !iVideoRenderLayer.supportFlip());
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void flipVideo(boolean reversal) {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        boolean z = false;
        if (iVideoRenderLayer != null && iVideoRenderLayer.supportFlip()) {
            z = true;
        }
        if (!z) {
            PlayerLog.i(TAG, "un-support flip!!!");
            return;
        }
        this.mCurrentFlip = reversal;
        IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
        if (iVideoRenderLayer2 != null) {
            iVideoRenderLayer2.flipVideo(reversal);
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getPlayerSettingService().putBoolean(Player.KEY_FLIP_VIDEO_SELECTED, reversal);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void updateViewPort(Rect containerRect, boolean immediately) {
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        if (this.mCurrentRenderViewport != containerRect) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            if (!playerContainerImpl.getPlayerParams().getConfig().getUpdateVideoRenderViewPortEnable()) {
                PlayerLog.i(TAG, "update view_port disable!!!");
                return;
            }
        }
        if (containerRect.isEmpty()) {
            this.mCustomizedViewport = null;
            return;
        }
        this.mCustomizedViewport = containerRect;
        updateViewPortInternal(containerRect, immediately);
    }

    static /* synthetic */ void updateViewPortInternal$default(RenderContainerService renderContainerService, Rect rect, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        renderContainerService.updateViewPortInternal(rect, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViewPortInternal(Rect containerRect, boolean immediately) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        this.mCurrentRenderViewport.set(containerRect);
        this.mDispatchViewPortRunnable.getContainerRect().set(containerRect);
        this.mDispatchViewPortRunnable.getContainerRect().left += ((Number) this.mOffset.getFirst()).intValue();
        this.mDispatchViewPortRunnable.getContainerRect().right += ((Number) this.mOffset.getFirst()).intValue();
        this.mDispatchViewPortRunnable.getContainerRect().top += ((Number) this.mOffset.getSecond()).intValue();
        this.mDispatchViewPortRunnable.getContainerRect().bottom += ((Number) this.mOffset.getSecond()).intValue();
        if (this.mPadding.top != 0 || this.mPadding.left != 0 || this.mPadding.right != 0 || this.mPadding.bottom != 0) {
            if ((this.mDispatchViewPortRunnable.getContainerRect().width() - this.mPadding.left) - this.mPadding.right > 0) {
                this.mDispatchViewPortRunnable.getContainerRect().left += this.mPadding.left;
                this.mDispatchViewPortRunnable.getContainerRect().right -= this.mPadding.right;
            } else {
                this.mDispatchViewPortRunnable.getContainerRect().left = 0;
                this.mDispatchViewPortRunnable.getContainerRect().right = 0;
            }
            if ((this.mDispatchViewPortRunnable.getContainerRect().height() - this.mPadding.top) - this.mPadding.bottom > 0) {
                this.mDispatchViewPortRunnable.getContainerRect().top += this.mPadding.top;
                this.mDispatchViewPortRunnable.getContainerRect().bottom -= this.mPadding.bottom;
            } else {
                this.mDispatchViewPortRunnable.getContainerRect().top = 0;
                this.mDispatchViewPortRunnable.getContainerRect().bottom = 0;
            }
        }
        if (immediately) {
            this.mDispatchViewPortRunnableScheduled = false;
            this.mDispatchViewPortRunnable.run();
        } else if (this.mDispatchViewPortRunnableScheduled) {
        } else {
            this.mDispatchViewPortRunnableScheduled = true;
            IRenderContainer iRenderContainer = this.mRenderContainer;
            if (iRenderContainer != null && (viewTreeObserver2 = iRenderContainer.getViewTreeObserver()) != null) {
                viewTreeObserver2.removeOnGlobalLayoutListener(this.mDispatchViewPortRunnable);
            }
            IRenderContainer iRenderContainer2 = this.mRenderContainer;
            if (iRenderContainer2 == null || (viewTreeObserver = iRenderContainer2.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnGlobalLayoutListener(this.mDispatchViewPortRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IVideoRenderLayer.Type adjustLayerType(MediaResource resource) {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IVideoRenderLayer.Type configuredType = playerContainerImpl.getPlayerParams().getConfig().getVideoRenderLayerType();
        IVideoRenderLayer.Type currentType = this.mExactlyLayerType;
        if (currentType == null) {
            currentType = configuredType;
        }
        boolean z = false;
        boolean isTextureView = currentType == IVideoRenderLayer.Type.TypeTextureView || currentType == IVideoRenderLayer.Type.TypeTextureViewWithExternalRender;
        if (resource != null && resource.isDrm()) {
            switch (configuredType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[configuredType.ordinal()]) {
                case -1:
                case 1:
                    return IVideoRenderLayer.Type.TypeSurfaceView;
                case 0:
                default:
                    return null;
                case 2:
                    return IVideoRenderLayer.Type.TypeTextureView;
            }
        }
        if (resource != null && resource.isHdr()) {
            HDRUtil hDRUtil = (HDRUtil) BLRouter.get$default(BLRouter.INSTANCE, HDRUtil.class, (String) null, 2, (Object) null);
            if (hDRUtil != null && hDRUtil.couldUseExternalRender(resource.isHdrVivid())) {
                BLog.i(TAG, "HDRUtilImpl couldUseExternalRender = true");
                if (getHitColorEnhanceTexture() && isTextureView) {
                    BLog.i(TAG, "hitColorEnhanceTexture");
                    return IVideoRenderLayer.Type.TypeTextureViewWithExternalRender;
                }
                return IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender;
            }
        }
        if (!(resource != null && resource.isHdr())) {
            if (resource != null && resource.isDolbyVision()) {
                z = true;
            }
            if (!z || !IjkOptionsHelper.isSupportDolbyVisionHw()) {
                return null;
            }
        }
        if (getHitColorEnhanceTexture() && isTextureView) {
            BLog.i(TAG, "hitColorEnhanceTexture");
            return IVideoRenderLayer.Type.TypeTextureView;
        }
        return IVideoRenderLayer.Type.TypeSurfaceView;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public Rect getRenderViewBounds() {
        Rect bounds;
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        return (iVideoRenderLayer == null || (bounds = iVideoRenderLayer.getBounds()) == null) ? new Rect() : bounds;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        boolean z;
        Bundle bundle2;
        Bundle bundle3;
        boolean keepViewport = (bundle == null || (bundle3 = bundle.getBundle()) == null) ? false : bundle3.getBoolean("key_share_player_viewport_until_surface_created", false);
        bindRenderContext(getMRenderContextService().getRenderContext(), keepViewport);
        this.mPendingKeepTransform = (bundle == null || (bundle2 = bundle.getBundle()) == null) ? false : bundle2.getBoolean("key_share_player_transform_until_shared", false);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IPlayerSettingService playerSettingService = playerContainerImpl.getPlayerSettingService();
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        this.mCurrentDisplayAspectRatio = AspectRatio.valueOf(playerSettingService.getString(Player.KEY_PLAYER_ASPECT, playerContainerImpl3.getPlayerParams().getConfig().getDefaultAspectRatio().toString()));
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        this.mCurrentFlip = playerContainerImpl4.getPlayerSettingService().getBoolean(Player.KEY_FLIP_VIDEO_SELECTED, false);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        playerContainerImpl5.getPlayerSettingService().addPlayerSettingChangeObserver(this.mPlayerSettingChangeObserver, new String[0]);
        if (bundle == null) {
            z = false;
        } else {
            z = true;
        }
        this.mPendingNotifyCustomFirstFrame = z;
        if (bundle != null) {
            PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
            if (playerContainerImpl6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl6 = null;
            }
            playerContainerImpl6.getPlayerSettingService().putBoolean(Player.KEY_FLIP_VIDEO_SELECTED, bundle.getBundle().getBoolean("key_share_player_flip", this.mCurrentFlip));
            boolean shouldAdjustLayerType = bundle.getBundle().getBoolean("key_share_player_adjust_layer_type", false);
            if (shouldAdjustLayerType) {
                PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
                if (playerContainerImpl7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl7 = null;
                }
                IVideoRenderLayer.Type adjustLayerType = adjustLayerType(playerContainerImpl7.getPlayerCoreService().getMediaResource());
                if (adjustLayerType != null) {
                    this.mExactlyLayerType = adjustLayerType;
                    this.mShouldResetRenderLayer = true;
                }
            }
        }
        PlayerContainerImpl playerContainerImpl8 = this.mPlayerContainer;
        if (playerContainerImpl8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl8 = null;
        }
        playerContainerImpl8.getPlayerSettingService().addCloudConfigObserver(this.mCloudConfigObserver);
        PlayerContainerImpl playerContainerImpl9 = this.mPlayerContainer;
        if (playerContainerImpl9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl9 = null;
        }
        playerContainerImpl9.getPlayerCoreService().addMediaResourceObserver(this.mMediaResourceObserver);
        PlayerContainerImpl playerContainerImpl10 = this.mPlayerContainer;
        if (playerContainerImpl10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl10 = null;
        }
        playerContainerImpl10.getPlayerCoreService().registerState(this.mPlayerStateObserver, 4, 6, 5, 3);
        PlayerContainerImpl playerContainerImpl11 = this.mPlayerContainer;
        if (playerContainerImpl11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl11 = null;
        }
        playerContainerImpl11.getPlayerCoreService().addMediaCenterObserver(this.mMediaCenterObserver);
        this.mWholeSceneSupervisor = new WholeSceneSupervisor();
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        PlayerContainerImpl playerContainerImpl12 = this.mPlayerContainer;
        if (playerContainerImpl12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl12;
        }
        wholeSceneSupervisor.init(playerContainerImpl2);
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        boolean keepTransform = bundle.getBundle().getBoolean("key_share_player_transform_until_shared", false);
        WholeSceneSupervisor wholeSceneSupervisor = null;
        if (!keepTransform) {
            IRenderContainerService.CC.resetRenderContainer$default(this, false, null, 2, null);
        }
        boolean keepSurfaceForShare = bundle.getBundle().getBoolean(PlayerSharingBundle.KEY_SHARE_KEEP_RENDER, false);
        unbindRenderContext(keepSurfaceForShare);
        bundle.getBundle().remove(PlayerSharingBundle.KEY_SHARE_KEEP_RENDER);
        Bundle bundle2 = bundle.getBundle();
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        bundle2.putBoolean("key_share_player_flip", playerContainerImpl.getPlayerSettingService().getBoolean(Player.KEY_FLIP_VIDEO_SELECTED, false));
        this.mRenderContext = null;
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        playerContainerImpl2.getPlayerSettingService().removePlayerSettingChangeObserver(this.mPlayerSettingChangeObserver);
        WholeSceneSupervisor wholeSceneSupervisor2 = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
        } else {
            wholeSceneSupervisor = wholeSceneSupervisor2;
        }
        wholeSceneSupervisor.exitWholeSceneMode(false);
    }

    private static final void onAttachByShared$bindCurrentVideoLayer(RenderContainerService this$0, PlayerSharingBundle $bundle) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        IMediaPlayRenderContext renderContext = this$0.getMRenderContextService().getRenderContext();
        boolean z = false;
        boolean keepViewport = ($bundle == null || (bundle3 = $bundle.getBundle()) == null) ? false : bundle3.getBoolean("key_share_player_viewport_until_surface_created", false);
        this$0.bindRenderContext(renderContext, keepViewport);
        PlayerContainerImpl playerContainerImpl = null;
        Rect viewport = ($bundle == null || (bundle2 = $bundle.getBundle()) == null) ? null : (Rect) bundle2.getParcelable("key_share_player_viewport");
        if (viewport != null && !viewport.isEmpty()) {
            z = true;
        }
        if (z) {
            this$0.updateViewPortInternal(viewport, true);
        }
        boolean flip = ($bundle == null || (bundle = $bundle.getBundle()) == null) ? this$0.mCurrentFlip : bundle.getBoolean("key_share_player_flip", this$0.mCurrentFlip);
        PlayerContainerImpl playerContainerImpl2 = this$0.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl = playerContainerImpl2;
        }
        playerContainerImpl.getPlayerSettingService().putBoolean(Player.KEY_FLIP_VIDEO_SELECTED, flip);
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        this.mDispatchViewPortRunnableScheduled = false;
        this.mPendingKeepTransform = (bundle == null || (bundle3 = bundle.getBundle()) == null) ? false : bundle3.getBoolean("key_share_player_transform_until_shared", false);
        boolean shouldAdjustLayerType = (bundle == null || (bundle2 = bundle.getBundle()) == null) ? false : bundle2.getBoolean("key_share_player_adjust_layer_type", false);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        WholeSceneSupervisor wholeSceneSupervisor = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IVideoRenderLayer.Type adjustLayerType = adjustLayerType(playerContainerImpl.getPlayerCoreService().getMediaResource());
        if (shouldAdjustLayerType && adjustLayerType != null) {
            IVideoRenderLayer videoRenderLayer = this.mVideoRenderLayer;
            IMediaPlayRenderContext renderContext = getMRenderContextService().getRenderContext();
            this.mRenderContext = renderContext;
            if (videoRenderLayer != null) {
                VideoRenderLayerFactory videoRenderLayerFactory = this.mVideoRenderLayerFactory;
                if (videoRenderLayerFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
                    videoRenderLayerFactory = null;
                }
                if (videoRenderLayerFactory.type(videoRenderLayer) == adjustLayerType) {
                    onAttachByShared$bindCurrentVideoLayer(this, bundle);
                }
            }
            PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
            if (playerContainerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl2 = null;
            }
            this.mShouldResetRenderLayer = playerContainerImpl2.getPlayerParams().getConfig().getVideoRenderLayerType() != adjustLayerType;
            setExactlyVideoLayerType(adjustLayerType);
        } else if (this.mShouldResetRenderLayer) {
            this.mShouldResetRenderLayer = false;
            this.mRenderContext = getMRenderContextService().getRenderContext();
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl3 = null;
            }
            setExactlyVideoLayerType(playerContainerImpl3.getPlayerParams().getConfig().getVideoRenderLayerType());
        } else if (this.mVideoRenderLayer == null) {
            VideoRenderLayerFactory videoRenderLayerFactory2 = this.mVideoRenderLayerFactory;
            if (videoRenderLayerFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
                videoRenderLayerFactory2 = null;
            }
            this.mVideoRenderLayer = videoRenderLayerFactory2.create(this.mExactlyLayerType);
            this.mRenderContext = getMRenderContextService().getRenderContext();
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer);
            attachVideoLayer(iVideoRenderLayer);
        } else {
            onAttachByShared$bindCurrentVideoLayer(this, bundle);
        }
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        playerContainerImpl4.getPlayerSettingService().addPlayerSettingChangeObserver(this.mPlayerSettingChangeObserver, new String[0]);
        WholeSceneSupervisor wholeSceneSupervisor2 = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor2 = null;
        }
        if (wholeSceneSupervisor2.shouldAutoEnterWholeSceneMode()) {
            WholeSceneSupervisor wholeSceneSupervisor3 = this.mWholeSceneSupervisor;
            if (wholeSceneSupervisor3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            } else {
                wholeSceneSupervisor = wholeSceneSupervisor3;
            }
            wholeSceneSupervisor.enterWholeSceneMode(false);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        PlayerContainerImpl playerContainerImpl = null;
        unbindRenderContext$default(this, false, 1, null);
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        playerContainerImpl2.getPlayerSettingService().removeCloudConfigObserver(this.mCloudConfigObserver);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getPlayerSettingService().removePlayerSettingChangeObserver(this.mPlayerSettingChangeObserver);
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl4 = null;
        }
        playerContainerImpl4.getPlayerCoreService().removeMediaResourceObserver(this.mMediaResourceObserver);
        PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
        if (playerContainerImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl5 = null;
        }
        playerContainerImpl5.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
        PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
        if (playerContainerImpl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl = playerContainerImpl6;
        }
        playerContainerImpl.getPlayerCoreService().removeMediaCenterObserver(this.mMediaCenterObserver);
        detachVideoLayer(this.mVideoRenderLayer);
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        DefaultVideoRenderLayerFactory defaultVideoRenderLayerFactory;
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        VideoRenderLayerFactory customVideoRenderLayerFactory = playerContainerImpl.getPlayerParams().getVideoRenderLayerFactory();
        if (customVideoRenderLayerFactory != null) {
            defaultVideoRenderLayerFactory = customVideoRenderLayerFactory;
        } else {
            defaultVideoRenderLayerFactory = new DefaultVideoRenderLayerFactory(playerContainer.getPlayerParams());
        }
        this.mVideoRenderLayerFactory = defaultVideoRenderLayerFactory;
    }

    @Override // tv.danmaku.biliplayerv2.service.IWithViewPlayerService
    public ViewGroup createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RenderContainer renderContainer = new RenderContainer(context);
        this.mRenderContainer = renderContainer;
        renderContainer.setMeasureAndLayoutChildHandler(this.mMeasureAndLayoutChildHandler);
        VideoRenderLayerFactory videoRenderLayerFactory = this.mVideoRenderLayerFactory;
        if (videoRenderLayerFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
            videoRenderLayerFactory = null;
        }
        this.mVideoRenderLayer = videoRenderLayerFactory.create(this.mExactlyLayerType);
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        Intrinsics.checkNotNull(iVideoRenderLayer);
        attachVideoLayer(iVideoRenderLayer);
        return renderContainer;
    }

    private final void attachVideoLayer(IVideoRenderLayer layer) {
        VideoRenderLayerFactory videoRenderLayerFactory = this.mVideoRenderLayerFactory;
        WholeSceneSupervisor wholeSceneSupervisor = null;
        if (videoRenderLayerFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
            videoRenderLayerFactory = null;
        }
        PlayerLog.i(TAG, "current video render type:" + videoRenderLayerFactory.type(layer) + " layer: " + layer.getClass());
        layer.setVideoRenderLayerChangedListener(this.mRenderLayerChangedListener);
        layer.addVideoRenderLayerStateObserver(this.mVideoRenderLayerStateObserver);
        if (this.mRenderContext != null) {
            IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
            Intrinsics.checkNotNull(iMediaPlayRenderContext);
            layer.bindRenderContext(iMediaPlayRenderContext, this.mPendingKeepViewportUntilSurfaceCreated);
            this.mPendingKeepViewportUntilSurfaceCreated = false;
        }
        IRenderContainer iRenderContainer = this.mRenderContainer;
        if (iRenderContainer != null) {
            iRenderContainer.addView(layer.getView(), 0);
        }
        if (!this.mCurrentRenderViewport.isEmpty()) {
            updateViewPortInternal$default(this, this.mCurrentRenderViewport, false, 2, null);
        }
        layer.setAspectRatio(this.mCurrentDisplayAspectRatio);
        if (supportFlipVideo()) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            layer.flipVideo(playerContainerImpl.getPlayerSettingService().getBoolean(Player.KEY_FLIP_VIDEO_SELECTED, false));
        }
        layer.addVideoSizeChangedListener(this.mVideoSizeChangedListener);
        WholeSceneSupervisor wholeSceneSupervisor2 = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
        } else {
            wholeSceneSupervisor = wholeSceneSupervisor2;
        }
        wholeSceneSupervisor.setVideoRenderLayer(layer);
        this.mVideoLayerTypeChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((OnVideoLayerAttachedObserver) obj).onAttached();
            }
        });
    }

    private final void detachVideoLayer(IVideoRenderLayer layer) {
        if (layer == null) {
            return;
        }
        layer.setVideoRenderLayerChangedListener(null);
        IRenderContainer iRenderContainer = this.mRenderContainer;
        if (iRenderContainer != null) {
            iRenderContainer.removeView(layer.getView());
        }
        layer.getView().setKeepScreenOn(false);
        if (this.mRenderContext != null) {
            IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
            Intrinsics.checkNotNull(iMediaPlayRenderContext);
            IVideoRenderLayer.CC.unbindRenderContext$default(layer, iMediaPlayRenderContext, false, 2, null);
        }
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        wholeSceneSupervisor.setVideoRenderLayer(null);
        layer.removeVideoSizeChangedListener(this.mVideoSizeChangedListener);
        layer.release();
        this.mVideoRenderLayerStateList.clear();
        layer.removeVideoRenderLayerStateObserver(this.mVideoRenderLayerStateObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean isRenderLayerSupportTransform() {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            return iVideoRenderLayer.supportTransform();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener listener) {
        this.mCustomFirstFrameListener = listener;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setFirstFrameListener(listener);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void dispatchMatrixChanged() {
        final TransformParams transformParams;
        this.mTempRenderMatrix.reset();
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer == null || (transformParams = iVideoRenderLayer.getTransformParams()) == null) {
            return;
        }
        this.mTempRenderMatrix.postRotate(transformParams.getRotation());
        this.mTempRenderMatrix.postScale(transformParams.getScaleX(), transformParams.getScaleY(), transformParams.getPivotX(), transformParams.getPivotY());
        this.mTempRenderMatrix.postTranslate(transformParams.getTranslationX(), transformParams.getTranslationY());
        this.mRenderMatrixChangedObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((RenderContainerMatrixChangedObserver) obj).onChanged(TransformParams.this);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void addRenderContainerChangedObserver(RenderContainerMatrixChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mRenderMatrixChangedObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeRenderContainerChangedObserver(RenderContainerMatrixChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mRenderMatrixChangedObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void addVideoLayerAttachedObserver(OnVideoLayerAttachedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mVideoLayerTypeChangedObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeVideoLayerAttachedObserver(OnVideoLayerAttachedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mVideoLayerTypeChangedObservers.remove(observer);
    }

    private static final boolean resetRenderContainer$hasTransformational(RenderContainerService this$0) {
        IVideoRenderLayer iVideoRenderLayer = this$0.mVideoRenderLayer;
        Intrinsics.checkNotNull(iVideoRenderLayer);
        Pair translate = iVideoRenderLayer.currentTranslate();
        IVideoRenderLayer iVideoRenderLayer2 = this$0.mVideoRenderLayer;
        Intrinsics.checkNotNull(iVideoRenderLayer2);
        if (iVideoRenderLayer2.currentRotate() % ((float) 360) == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            IVideoRenderLayer iVideoRenderLayer3 = this$0.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer3);
            return (((iVideoRenderLayer3.currentScale() > 1.0f ? 1 : (iVideoRenderLayer3.currentScale() == 1.0f ? 0 : -1)) == 0) && ((Number) translate.getFirst()).intValue() == 0 && ((Number) translate.getSecond()).intValue() == 0) ? false : true;
        }
        return true;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void resetRenderContainer(boolean withAnim, AnimatorListenerAdapter listener) {
        if (this.mVideoRenderLayer != null && resetRenderContainer$hasTransformational(this)) {
            if (!withAnim) {
                IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
                Intrinsics.checkNotNull(iVideoRenderLayer);
                iVideoRenderLayer.rotate(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
                Intrinsics.checkNotNull(iVideoRenderLayer2);
                iVideoRenderLayer2.scale(1.0f);
                IVideoRenderLayer iVideoRenderLayer3 = this.mVideoRenderLayer;
                Intrinsics.checkNotNull(iVideoRenderLayer3);
                iVideoRenderLayer3.translate(0, 0);
                return;
            }
            IVideoRenderLayer iVideoRenderLayer4 = this.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer4);
            ValueAnimator scaleAnimator = ValueAnimator.ofFloat(iVideoRenderLayer4.currentScale(), 1.0f);
            scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RenderContainerService.resetRenderContainer$lambda$0(RenderContainerService.this, valueAnimator);
                }
            });
            IVideoRenderLayer iVideoRenderLayer5 = this.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer5);
            ValueAnimator rotateAnimator = ValueAnimator.ofFloat(iVideoRenderLayer5.currentRotate() % 360, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            rotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RenderContainerService.resetRenderContainer$lambda$1(RenderContainerService.this, valueAnimator);
                }
            });
            IVideoRenderLayer iVideoRenderLayer6 = this.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer6);
            final float translateX = ((Number) iVideoRenderLayer6.currentTranslate().getFirst()).intValue();
            IVideoRenderLayer iVideoRenderLayer7 = this.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer7);
            final float translateY = ((Number) iVideoRenderLayer7.currentTranslate().getSecond()).intValue();
            ValueAnimator translateAnimator = ValueAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            translateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RenderContainerService.resetRenderContainer$lambda$2(RenderContainerService.this, translateX, translateY, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.playTogether(scaleAnimator, translateAnimator, rotateAnimator);
            if (listener != null) {
                animatorSet.addListener(listener);
            }
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetRenderContainer$lambda$0(RenderContainerService this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float scale = ((Float) animatedValue).floatValue();
        IVideoRenderLayer iVideoRenderLayer = this$0.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.scale(scale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetRenderContainer$lambda$1(RenderContainerService this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float rotate = ((Float) animatedValue).floatValue();
        IVideoRenderLayer iVideoRenderLayer = this$0.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.rotate(rotate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetRenderContainer$lambda$2(RenderContainerService this$0, float $translateX, float $translateY, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float d = ((Float) animatedValue).floatValue();
        IVideoRenderLayer iVideoRenderLayer = this$0.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.translate((int) (d * $translateX), (int) (d * $translateY));
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void notifyScreenModeTypeChanged(ScreenModeType screenModeType) {
        Intrinsics.checkNotNullParameter(screenModeType, "screenModeType");
        this.mCurrentScreenModeType = screenModeType;
        WholeSceneSupervisor wholeSceneSupervisor = null;
        if (screenModeType == ScreenModeType.THUMB) {
            IRenderContainerService.CC.resetRenderContainer$default(this, false, null, 2, null);
        }
        WholeSceneSupervisor wholeSceneSupervisor2 = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
        } else {
            wholeSceneSupervisor = wholeSceneSupervisor2;
        }
        wholeSceneSupervisor.notifyScreenModeTypeChanged();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void notifyVideoChanged() {
        this.mVideoChangedWaitRender = true;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public IRenderLayer.Type addRenderLayer(final IRenderLayer layer, final int index) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (this.mRenderContainer == null) {
            throw new IllegalStateException("must addRenderLayer after bindRenderContainer");
        }
        final Ref.ObjectRef type = new Ref.ObjectRef();
        type.element = layer.type();
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        boolean videoIsTexture = (iVideoRenderLayer != null ? iVideoRenderLayer.getView() : null) instanceof TextureView;
        if (videoIsTexture && type.element == IRenderLayer.Type.SurfaceView) {
            if (layer.interruptWhenTypeNotCompatible()) {
                throw new IllegalArgumentException("desire type@" + type.element + " not compatible with video layer: TextureView");
            }
            PlayerLog.i(TAG, "desire type: " + IRenderLayer.Type.SurfaceView + ", but not compatible with video layer: TextureView, use textureView");
            type.element = IRenderLayer.Type.TextureView;
        }
        if (type.element == IRenderLayer.Type.SurfaceView) {
            this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda11
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    RenderContainerService.addRenderLayer$lambda$0(index, this, layer, type, (RenderContainerService.RenderLayer) obj);
                }
            });
        } else {
            this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda12
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    RenderContainerService.addRenderLayer$lambda$1(index, this, layer, type, (RenderContainerService.RenderLayer) obj);
                }
            });
        }
        this.mChildrenLayers.add(new RenderLayer(this, layer, (IRenderLayer.Type) type.element, layer.view(), layer.align(), index < 0 ? this.mChildrenLayers.size() : index));
        if (layer.align() == 1) {
            IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
            if (iVideoRenderLayer2 != null) {
                iVideoRenderLayer2.addAlignLayer(layer.view());
            }
            if (index >= 0) {
                IRenderContainer iRenderContainer = this.mRenderContainer;
                if (iRenderContainer != null) {
                    iRenderContainer.addView(layer.view(), index + 1);
                }
            } else {
                IRenderContainer iRenderContainer2 = this.mRenderContainer;
                if (iRenderContainer2 != null) {
                    iRenderContainer2.addView(layer.view());
                }
            }
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
            if (index >= 0) {
                IRenderContainer iRenderContainer3 = this.mRenderContainer;
                if (iRenderContainer3 != null) {
                    iRenderContainer3.addView(layer.view(), index + 1, layoutParams);
                }
            } else {
                IRenderContainer iRenderContainer4 = this.mRenderContainer;
                if (iRenderContainer4 != null) {
                    iRenderContainer4.addView(layer.view(), layoutParams);
                }
            }
        }
        dumpRenderLayers();
        return (IRenderLayer.Type) type.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRenderLayer$lambda$0(int $index, RenderContainerService this$0, IRenderLayer $layer, Ref.ObjectRef $type, RenderLayer it) {
        int acIndex = $index < 0 ? this$0.mChildrenLayers.size() : $index;
        if (acIndex <= it.getIndex()) {
            it.setIndex(it.getIndex() + 1);
        }
        if (it.type() != IRenderLayer.Type.SurfaceView && acIndex > it.getIndex()) {
            if ($layer.interruptWhenTypeNotCompatible()) {
                throw new IllegalArgumentException("desire type@" + $type.element + " not compatible with other layer: " + it.type());
            }
            PlayerLog.i(TAG, "desire type@" + $type.element + " not compatible with other layer: " + it.type());
            $type.element = IRenderLayer.Type.TextureView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRenderLayer$lambda$1(int $index, RenderContainerService this$0, IRenderLayer $layer, Ref.ObjectRef $type, RenderLayer it) {
        int acIndex = $index < 0 ? this$0.mChildrenLayers.size() : $index;
        if (acIndex <= it.getIndex()) {
            it.setIndex(it.getIndex() + 1);
        }
        if (it.type() == IRenderLayer.Type.SurfaceView && acIndex <= it.getIndex()) {
            if ($layer.interruptWhenTypeNotCompatible()) {
                throw new IllegalArgumentException("desire type@" + $type.element + " not compatible with other layer: " + it.type());
            }
            PlayerLog.i(TAG, "desire type@" + $type.element + " not compatible with other layer: " + it.type() + ", this layer could not show");
        }
    }

    private final void dumpRenderLayers() {
        Class<?> cls;
        if (BuildConfig.DEBUG) {
            StringBuilder sb = new StringBuilder("render-layers: ");
            StringBuilder append = sb.append(VideoFile.TREE_END).append("{").append(VideoFile.TREE_END).append("  ").append("video_layer: ");
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            append.append((iVideoRenderLayer == null || (cls = iVideoRenderLayer.getClass()) == null) ? null : cls.getSimpleName()).append(",\n").append("  customer_layers: [\n");
            Iterable temp = new ArrayList(this.mChildrenLayers);
            CollectionsKt.sort((List) temp);
            Iterable $this$forEach$iv = temp;
            for (Object element$iv : $this$forEach$iv) {
                RenderLayer it = (RenderLayer) element$iv;
                sb.append("    " + it.getView().getClass().getSimpleName() + "@" + it.getType() + "@" + it.getIndex()).append(",").append(VideoFile.TREE_END);
            }
            sb.append("  ]").append(VideoFile.TREE_END).append("}");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            PlayerLog.d(TAG, sb2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean alignVideoLayerView(final View view2) {
        final Ref.BooleanRef align = new Ref.BooleanRef();
        this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda13
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                RenderContainerService.alignVideoLayerView$lambda$0(view2, align, (RenderContainerService.RenderLayer) obj);
            }
        });
        return align.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void alignVideoLayerView$lambda$0(View $view, Ref.BooleanRef $align, RenderLayer it) {
        if (Intrinsics.areEqual($view, it.view())) {
            $align.element = it.align() == 1;
        }
    }

    private final void removeLayer(final View layer) {
        final Ref.ObjectRef storeLayer = new Ref.ObjectRef();
        this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda5
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                RenderContainerService.removeLayer$lambda$0(layer, storeLayer, this, (RenderContainerService.RenderLayer) obj);
            }
        });
        if (storeLayer.element != null) {
            this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda6
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    RenderContainerService.removeLayer$lambda$1(storeLayer, (RenderContainerService.RenderLayer) obj);
                }
            });
            this.mChildrenLayers.remove(storeLayer.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeLayer$lambda$0(View $layer, Ref.ObjectRef $storeLayer, RenderContainerService this$0, RenderLayer it) {
        IVideoRenderLayer iVideoRenderLayer;
        if (Intrinsics.areEqual(it.view(), $layer)) {
            $storeLayer.element = it;
            IRenderContainer iRenderContainer = this$0.mRenderContainer;
            if (iRenderContainer != null) {
                iRenderContainer.removeView(it.view());
            }
            if (it.align() != 1 || (iVideoRenderLayer = this$0.mVideoRenderLayer) == null) {
                return;
            }
            iVideoRenderLayer.removeAlignLayer(it.view());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeLayer$lambda$1(Ref.ObjectRef $storeLayer, RenderLayer it) {
        Object obj = $storeLayer.element;
        Intrinsics.checkNotNull(obj);
        if (((RenderLayer) obj).getIndex() < it.getIndex()) {
            it.setIndex(it.getIndex() - 1);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeRenderLayer(View layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        removeLayer(layer);
        IRenderContainer iRenderContainer = this.mRenderContainer;
        if (iRenderContainer != null) {
            iRenderContainer.removeView(layer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeRenderLayer(IRenderLayer layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        removeLayer(layer.view());
        IRenderContainer iRenderContainer = this.mRenderContainer;
        if (iRenderContainer != null) {
            iRenderContainer.removeView(layer.view());
        }
    }

    static /* synthetic */ void bindRenderContext$default(RenderContainerService renderContainerService, IMediaPlayRenderContext iMediaPlayRenderContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        renderContainerService.bindRenderContext(iMediaPlayRenderContext, z);
    }

    private final void bindRenderContext(IMediaPlayRenderContext renderContext, boolean keepViewportUntilSurfaceCreated) {
        this.mRenderContext = renderContext;
        if (this.mVideoRenderLayer != null) {
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            if (iVideoRenderLayer != null) {
                iVideoRenderLayer.bindRenderContext(renderContext, keepViewportUntilSurfaceCreated);
            }
        } else {
            this.mPendingKeepViewportUntilSurfaceCreated = keepViewportUntilSurfaceCreated;
        }
        updateFrameRendererListenerState();
    }

    static /* synthetic */ void unbindRenderContext$default(RenderContainerService renderContainerService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        renderContainerService.unbindRenderContext(z);
    }

    private final void unbindRenderContext(boolean keepSurfaceForShare) {
        IMediaPlayRenderContext it = this.mRenderContext;
        if (it != null) {
            it.setFirstFrameListener(null);
            it.setOnFrameRendererListener(null);
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            if (iVideoRenderLayer != null) {
                iVideoRenderLayer.unbindRenderContext(it, keepSurfaceForShare);
            }
        }
        this.mRenderContext = null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void dispatchTouchEvent(MotionEvent event) {
        IRenderContainer iRenderContainer = this.mRenderContainer;
        if (iRenderContainer != null) {
            iRenderContainer.dispatchTouchEvent(event);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        boolean z = false;
        if (iVideoRenderLayer != null && iVideoRenderLayer.supportCaptureVideo()) {
            z = true;
        }
        if (!z) {
            PlayerLog.i(TAG, "un-support Capture video!!!");
            return;
        }
        IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
        if (iVideoRenderLayer2 != null) {
            iVideoRenderLayer2.takeVideoCapture(new RenderContainerService$takeVideoCapture$1(callback), width, height);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public Bitmap takeVideoCaptureEffectively() {
        if (this.mVideoRenderLayer != null && (this.mVideoRenderLayer instanceof TextureVideoRenderLayer)) {
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            if (iVideoRenderLayer != null) {
                return iVideoRenderLayer.takeVideoCaptureEffectively();
            }
            return null;
        }
        PlayerLog.i(TAG, "un-support Capture video!!!");
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setKeepScreenOn(boolean keep) {
        BLog.i(TAG, "setKeepScreenOn:" + keep);
        IRenderContainer iRenderContainer = this.mRenderContainer;
        if (iRenderContainer != null) {
            iRenderContainer.setKeepScreenOn(keep);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean useExternalRender() {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            return iVideoRenderLayer.useExternalRender();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setExactlyVideoLayerType(IVideoRenderLayer.Type type) {
        boolean shouldRecreateLayer;
        this.mExactlyLayerType = type;
        if (this.mRenderContainer == null) {
            return;
        }
        VideoRenderLayerFactory videoRenderLayerFactory = null;
        if (type != null && this.mVideoRenderLayer != null) {
            VideoRenderLayerFactory videoRenderLayerFactory2 = this.mVideoRenderLayerFactory;
            if (videoRenderLayerFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
                videoRenderLayerFactory2 = null;
            }
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            Intrinsics.checkNotNull(iVideoRenderLayer);
            if (videoRenderLayerFactory2.match(type, iVideoRenderLayer)) {
                shouldRecreateLayer = false;
                if (!shouldRecreateLayer) {
                    VideoRenderLayerFactory videoRenderLayerFactory3 = this.mVideoRenderLayerFactory;
                    if (videoRenderLayerFactory3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
                    } else {
                        videoRenderLayerFactory = videoRenderLayerFactory3;
                    }
                    resetVideoRenderLayer(videoRenderLayerFactory.create(this.mExactlyLayerType));
                    return;
                }
                return;
            }
        }
        shouldRecreateLayer = true;
        if (!shouldRecreateLayer) {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean enableSecureVideoScreen() {
        IVideoRenderLayer.Type layerType = getCurrentLayerType();
        return layerType == IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender || layerType == IVideoRenderLayer.Type.TypeSurfaceView;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void secureVideoScreen(boolean videoScreenNeedSecured) {
        boolean shouldRecreateLayer = videoScreenNeedSecured != this.videoScreenNeedSecured;
        if (shouldRecreateLayer && enableSecureVideoScreen()) {
            this.videoScreenNeedSecured = videoScreenNeedSecured;
            IVideoRenderLayer it = this.mVideoRenderLayer;
            if (it != null) {
                resetVideoRenderLayer(it);
            }
        }
    }

    private final void resetVideoRenderLayer(IVideoRenderLayer layer) {
        detachVideoLayer(this.mVideoRenderLayer);
        this.mVideoRenderLayer = layer;
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        View renderLayerView = iVideoRenderLayer != null ? iVideoRenderLayer.getView() : null;
        if (renderLayerView instanceof TextureView) {
            this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda3
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    RenderContainerService.resetVideoRenderLayer$lambda$0(RenderContainerService.this, (RenderContainerService.RenderLayer) obj);
                }
            });
        }
        if (renderLayerView instanceof SurfaceView) {
            ((SurfaceView) renderLayerView).setSecure(this.videoScreenNeedSecured);
        }
        IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
        Intrinsics.checkNotNull(iVideoRenderLayer2);
        attachVideoLayer(iVideoRenderLayer2);
        this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda4
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                RenderContainerService.resetVideoRenderLayer$lambda$1(RenderContainerService.this, (RenderContainerService.RenderLayer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetVideoRenderLayer$lambda$0(RenderContainerService this$0, RenderLayer it) {
        if (it.type() == IRenderLayer.Type.SurfaceView) {
            IVideoRenderLayer iVideoRenderLayer = this$0.mVideoRenderLayer;
            IRenderLayer.Type type = it.type();
            throw new IllegalArgumentException("video render layer:" + iVideoRenderLayer + " not compat with child layer: {type: " + type + ", layer: " + it.view() + "}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetVideoRenderLayer$lambda$1(RenderContainerService this$0, RenderLayer it) {
        IVideoRenderLayer iVideoRenderLayer;
        if (it.align() != 1 || (iVideoRenderLayer = this$0.mVideoRenderLayer) == null) {
            return;
        }
        iVideoRenderLayer.addAlignLayer(it.view());
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public IVideoRenderLayer.Type getCurrentLayerType() {
        IVideoRenderLayer curLayer = this.mVideoRenderLayer;
        VideoRenderLayerFactory videoRenderLayerFactory = null;
        if (curLayer == null) {
            return null;
        }
        VideoRenderLayerFactory videoRenderLayerFactory2 = this.mVideoRenderLayerFactory;
        if (videoRenderLayerFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
        } else {
            videoRenderLayerFactory = videoRenderLayerFactory2;
        }
        return videoRenderLayerFactory.type(curLayer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public IVideoRenderLayer createVideoLayer(IVideoRenderLayer.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        VideoRenderLayerFactory videoRenderLayerFactory = this.mVideoRenderLayerFactory;
        if (videoRenderLayerFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayerFactory");
            videoRenderLayerFactory = null;
        }
        return videoRenderLayerFactory.create(type);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setDaltonism(BiliDaltonizer.ColorBlindnessType type) {
        IMediaPlayRenderContext iMediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(type, "type");
        if ((getCurrentLayerType() == IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender || getCurrentLayerType() == IVideoRenderLayer.Type.TypeTextureViewWithExternalRender) && (iMediaPlayRenderContext = this.mRenderContext) != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.SwitchDaltonismMode, type);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public IPanelContainer getPanelContainer() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPanelContainer();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setViewportPadding(int left, int top, int right, int bottom, boolean immediately) {
        Rect rect = this.mCustomizedViewport;
        boolean z = false;
        if (rect != null && !rect.isEmpty()) {
            z = true;
        }
        if (z) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            if (playerContainerImpl.getPlayerParams().getConfig().getUpdateVideoRenderViewPortEnable()) {
                BLog.i(TAG, "have set viewport, change viewport to target");
                return;
            }
        }
        Rect newPadding = new Rect(left, top, right, bottom);
        if (Intrinsics.areEqual(this.mPadding, newPadding)) {
            return;
        }
        this.mPadding.set(left, top, right, bottom);
        if (this.mCurrentRenderViewport.isEmpty()) {
            return;
        }
        updateViewPortInternal(this.mCurrentRenderViewport, immediately);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setViewportOffset(int offsetX, int offsetY, boolean immediately) {
        if (((Number) this.mOffset.getFirst()).intValue() == offsetX && ((Number) this.mOffset.getSecond()).intValue() == offsetY) {
            return;
        }
        this.mOffset = new Pair<>(Integer.valueOf(offsetX), Integer.valueOf(offsetY));
        if (this.mCurrentRenderViewport.isEmpty()) {
            return;
        }
        updateViewPortInternal(this.mCurrentRenderViewport, immediately);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public int getViewportOffsetX() {
        return ((Number) this.mOffset.getFirst()).intValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public int getViewportOffsetY() {
        return ((Number) this.mOffset.getSecond()).intValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void addWholeSceneModeChangeObserver(WholeSceneModeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        wholeSceneSupervisor.addWholeSceneModeChangeObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeWholeSceneModeChangObserver(WholeSceneModeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        wholeSceneSupervisor.removeWholeSceneModeChangObserver(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void enterWholeSceneMode(boolean fromUser) {
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        wholeSceneSupervisor.enterWholeSceneMode(fromUser);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean supportWholeScene() {
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        return wholeSceneSupervisor.supportWholeScene();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean shouldAutoEnterWholeSceneMode() {
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        return wholeSceneSupervisor.shouldAutoEnterWholeSceneMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreFromShutDownByOthers() {
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        wholeSceneSupervisor.restoreFromShutDownByOthers();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void exitWholeSceneMode(boolean fromUser) {
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        wholeSceneSupervisor.exitWholeSceneMode(fromUser);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean isInWholeSceneMode() {
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        return wholeSceneSupervisor.isInWholeSceneMode();
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void notifyWholeSceneOffset(float offsetX, float offsetY) {
        IVideoRenderLayer iVideoRenderLayer;
        WholeSceneSupervisor wholeSceneSupervisor = this.mWholeSceneSupervisor;
        if (wholeSceneSupervisor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWholeSceneSupervisor");
            wholeSceneSupervisor = null;
        }
        if (!wholeSceneSupervisor.isInWholeSceneMode() || (iVideoRenderLayer = this.mVideoRenderLayer) == null) {
            return;
        }
        iVideoRenderLayer.notifyWholeSceneOffset(offsetX, offsetY);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeVideoSizeChangedListener(IVideoRenderLayer.OnVideoSizeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoSizeChangedListeners.remove(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void addVideoSizeChangedListener(IVideoRenderLayer.OnVideoSizeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mVideoSizeChangedListeners.contains(listener)) {
            return;
        }
        this.mVideoSizeChangedListeners.add(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void addVideoRenderLayerStateObserver(IVideoRenderLayer.VideoRenderLayerStateObserver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mVideoRenderLayerStateList.contains(listener)) {
            return;
        }
        this.mVideoRenderLayerStateList.add(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void removeVideoRenderLayerStateObserver(IVideoRenderLayer.VideoRenderLayerStateObserver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoRenderLayerStateList.remove(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public RenderLayerTransform getCurrentLayerTransform() {
        IVideoRenderLayer layer = this.mVideoRenderLayer;
        if (layer != null && layer.supportTransform()) {
            Pair<Integer, Integer> currentTranslate = layer.currentTranslate();
            int translationX = ((Number) currentTranslate.component1()).intValue();
            int translationY = ((Number) currentTranslate.component2()).intValue();
            return new RenderLayerTransform(layer.currentScale(), layer.currentRotate(), translationX, translationY);
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public boolean applyCurrentLayerTransform(RenderLayerTransform transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        IVideoRenderLayer layer = this.mVideoRenderLayer;
        if (layer != null && layer.supportTransform()) {
            layer.scale(transform.getScale());
            layer.rotate(transform.getRotate());
            layer.translate(transform.getTranslationX(), transform.getTranslationY());
            return true;
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void rotateCurrentLayer(float degree) {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.rotate(degree);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void scaleCurrentLayer(float scale) {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.scale(scale);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void translateCurrentLayer(int translationX, int translationY) {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.translate(translationX, translationY);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void transformCurrentLayer(float scale, int tX, int tY, float degree) {
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            iVideoRenderLayer.transform(scale, tX, tY, degree);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderContainerService
    public void setFrameRenderedListener(Function1<? super FrameRenderedInfo, Unit> function1) {
        this.mFrameRenderedListener = function1;
        updateFrameRendererListenerState();
    }

    private final void updateFrameRendererListenerState() {
        final Function1 listener = this.mFrameRenderedListener;
        if (listener == null) {
            IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
            if (iMediaPlayRenderContext != null) {
                iMediaPlayRenderContext.setOnFrameRendererListener(null);
                return;
            }
            return;
        }
        IMediaPlayRenderContext iMediaPlayRenderContext2 = this.mRenderContext;
        if (iMediaPlayRenderContext2 != null) {
            iMediaPlayRenderContext2.setOnFrameRendererListener(new IJKEXTRendererInterface.OnFrameRenderedListener() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$$ExternalSyntheticLambda2
                @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface.OnFrameRenderedListener
                public final void invoke(int i, int i2, int i3, long j) {
                    RenderContainerService.updateFrameRendererListenerState$lambda$0(listener, i, i2, i3, j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateFrameRendererListenerState$lambda$0(Function1 $listener, int textureId, int textureWidth, int textureHeight, long timeUs) {
        $listener.invoke(new FrameRenderedInfo(textureId, textureWidth, textureHeight, timeUs));
    }

    /* compiled from: RenderContainerServiceV2.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u00060\u0000R\u00020\u00030\u0002B/\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0016J\u0015\u0010!\u001a\u00020\n2\n\u0010\"\u001a\u00060\u0000R\u00020\u0003H\u0096\u0002R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/RenderContainerService$RenderLayer;", "Ltv/danmaku/biliplayerv2/service/IRenderLayer;", "", "Ltv/danmaku/biliplayerimpl/render/RenderContainerService;", "layer", "type", "Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;", "view", "Landroid/view/View;", "align", "", "index", "<init>", "(Ltv/danmaku/biliplayerimpl/render/RenderContainerService;Ltv/danmaku/biliplayerv2/service/IRenderLayer;Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;Landroid/view/View;II)V", "getLayer", "()Ltv/danmaku/biliplayerv2/service/IRenderLayer;", "getType", "()Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;", "getView", "()Landroid/view/View;", "getAlign", "()I", "getIndex", "setIndex", "(I)V", "interruptWhenTypeNotCompatible", "", "onViewPortUpdate", "", "viewPort", "Landroid/graphics/Rect;", "panelWidth", "panelHeight", "compareTo", "other", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class RenderLayer implements IRenderLayer, Comparable<RenderLayer> {
        private final int align;
        private int index;
        private final IRenderLayer layer;
        final /* synthetic */ RenderContainerService this$0;
        private final IRenderLayer.Type type;

        /* renamed from: view  reason: collision with root package name */
        private final View f27view;

        public RenderLayer(RenderContainerService this$0, IRenderLayer layer, IRenderLayer.Type type, View view2, int align, int index) {
            Intrinsics.checkNotNullParameter(layer, "layer");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(view2, "view");
            this.this$0 = this$0;
            this.layer = layer;
            this.type = type;
            this.f27view = view2;
            this.align = align;
            this.index = index;
        }

        public final IRenderLayer getLayer() {
            return this.layer;
        }

        public final IRenderLayer.Type getType() {
            return this.type;
        }

        public final View getView() {
            return this.f27view;
        }

        public final int getAlign() {
            return this.align;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
        public View view() {
            return this.f27view;
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
        public IRenderLayer.Type type() {
            return this.type;
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
        public boolean interruptWhenTypeNotCompatible() {
            return false;
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
        public int align() {
            return this.align;
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderLayer
        public void onViewPortUpdate(Rect viewPort, int panelWidth, int panelHeight) {
            Intrinsics.checkNotNullParameter(viewPort, "viewPort");
            this.layer.onViewPortUpdate(viewPort, panelWidth, panelHeight);
        }

        @Override // java.lang.Comparable
        public int compareTo(RenderLayer other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return this.index - other.index;
        }
    }

    /* compiled from: RenderContainerServiceV2.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/RenderContainerService$DispatchViewPortRunnable;", "Ljava/lang/Runnable;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "<init>", "(Ltv/danmaku/biliplayerimpl/render/RenderContainerService;)V", "containerRect", "Landroid/graphics/Rect;", "getContainerRect", "()Landroid/graphics/Rect;", "run", "", "onGlobalLayout", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class DispatchViewPortRunnable implements Runnable, ViewTreeObserver.OnGlobalLayoutListener {
        private final Rect containerRect = new Rect();

        public DispatchViewPortRunnable() {
        }

        public final Rect getContainerRect() {
            return this.containerRect;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerContainerImpl playerContainerImpl = RenderContainerService.this.mPlayerContainer;
            PlayerContainerImpl playerContainerImpl2 = null;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPanelContainer panelContainer = playerContainerImpl.getPanelContainer();
            final int panelWidth = panelContainer != null ? panelContainer.getWidth() : 0;
            PlayerContainerImpl playerContainerImpl3 = RenderContainerService.this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl2 = playerContainerImpl3;
            }
            IPanelContainer panelContainer2 = playerContainerImpl2.getPanelContainer();
            final int panelHeight = panelContainer2 != null ? panelContainer2.getHeight() : 0;
            RenderContainerService.this.mChildrenLayers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$DispatchViewPortRunnable$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    RenderContainerService.DispatchViewPortRunnable.run$lambda$0(RenderContainerService.DispatchViewPortRunnable.this, panelWidth, panelHeight, (RenderContainerService.RenderLayer) obj);
                }
            });
            BLog.i(RenderContainerService.TAG, "updateViewport " + this.containerRect);
            IVideoRenderLayer iVideoRenderLayer = RenderContainerService.this.mVideoRenderLayer;
            if (iVideoRenderLayer != null) {
                iVideoRenderLayer.updateViewPort(this.containerRect);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(DispatchViewPortRunnable this$0, int $panelWidth, int $panelHeight, RenderLayer it) {
            it.onViewPortUpdate(this$0.containerRect, $panelWidth, $panelHeight);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            IRenderContainer iRenderContainer = RenderContainerService.this.mRenderContainer;
            if (iRenderContainer != null && (viewTreeObserver = iRenderContainer.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            if (RenderContainerService.this.mDispatchViewPortRunnableScheduled) {
                run();
            }
            RenderContainerService.this.mDispatchViewPortRunnableScheduled = false;
        }
    }
}