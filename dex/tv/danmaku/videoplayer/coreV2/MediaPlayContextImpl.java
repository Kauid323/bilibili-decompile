package tv.danmaku.videoplayer.coreV2;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.render.IjkNativeWindowHelper;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.videoplayer.core.BuildConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter;
import tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;
import tv.danmaku.videoplayer.core.share.SharableObject;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;

/* compiled from: MediaPlayContextImpl.kt */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002CF\u0018\u0000 ê\u00012\u00020\u00012\u00020\u0002:\u0004ê\u0001ë\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\nH\u0016J\u0010\u0010P\u001a\u00020N2\u0006\u0010O\u001a\u00020\nH\u0016J(\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\fH\u0016J\b\u0010W\u001a\u00020\u001aH\u0016J\b\u0010X\u001a\u00020NH\u0016J\u001e\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\f2\f\u0010[\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002J\u0012\u0010\\\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010^\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010_\u001a\u00020N2\b\u0010`\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010a\u001a\u00020N2\b\u0010`\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010b\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010c\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010d\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010e\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010f\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010g\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u000104H\u0016J\u0014\u0010h\u001a\u00020N2\n\u0010i\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016J\u0016\u0010j\u001a\u00020N2\f\u0010i\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0016J\u0018\u0010k\u001a\u00020N2\u0006\u0010l\u001a\u00020\u001a2\u0006\u0010m\u001a\u00020\u001aH\u0016J\b\u0010n\u001a\u00020\fH\u0002J\u0012\u0010o\u001a\u00020N2\b\u0010p\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010q\u001a\u00020\u00062\n\u0010i\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\b\u0010r\u001a\u00020NH\u0016J\u0010\u0010s\u001a\u00020N2\u0006\u0010t\u001a\u00020\u0010H\u0016J\u0018\u0010s\u001a\u00020N2\u0006\u0010t\u001a\u00020\u00102\u0006\u0010u\u001a\u00020\fH\u0016J\b\u0010v\u001a\u00020\u0010H\u0016J\b\u0010w\u001a\u00020NH\u0016J\b\u0010x\u001a\u00020\fH\u0016J\b\u0010y\u001a\u00020\fH\u0016J\b\u0010z\u001a\u00020\fH\u0016J\b\u0010{\u001a\u00020\fH\u0016J\b\u0010|\u001a\u00020\u0010H\u0016J\b\u0010}\u001a\u00020\u0010H\u0016J\u0010\u0010~\u001a\u00020N2\u0006\u0010\u007f\u001a\u00020\u0013H\u0016J\u000b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020N2\u0007\u0010\u0082\u0001\u001a\u00020\u0018H\u0016J\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020N2\u0007\u0010\u0085\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020N2\u0007\u0010\u0086\u0001\u001a\u00020\u001aH\u0016J\u001b\u0010\u0086\u0001\u001a\u00020N2\u0007\u0010\u0087\u0001\u001a\u00020\u001a2\u0007\u0010\u0088\u0001\u001a\u00020\u001aH\u0016J\u001b\u0010\u0089\u0001\u001a\u00020N2\u0007\u0010\u008a\u0001\u001a\u00020\u000e2\u0007\u0010\u008b\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020N2\u0007\u0010\u008d\u0001\u001a\u00020\u001aH\u0016J-\u0010\u008e\u0001\u001a\u00020N2\u0007\u0010\u0086\u0001\u001a\u00020\u001a2\u0007\u0010\u008a\u0001\u001a\u00020\u000e2\u0007\u0010\u008b\u0001\u001a\u00020\u000e2\u0007\u0010\u008d\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020N2\u0007\u0010\u0090\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0091\u0001\u001a\u00020\f2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J.\u0010\u0094\u0001\u001a\u0005\u0018\u0001H\u0095\u0001\"\u0005\b\u0000\u0010\u0095\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\t\u0010O\u001a\u0005\u0018\u00010\u0096\u0001H\u0016¢\u0006\u0003\u0010\u0097\u0001J\t\u0010\u0098\u0001\u001a\u00020\u001aH\u0016J\t\u0010\u0099\u0001\u001a\u00020\u000eH\u0016J\u0013\u0010\u009a\u0001\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u000100H\u0016J\u0013\u0010\u009b\u0001\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u000102H\u0016J\u0012\u0010\u009c\u0001\u001a\u00020N2\u0007\u0010\u009d\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u009e\u0001\u001a\u00020\u000eH\u0016J\u0013\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\fH\u0016J\t\u0010¢\u0001\u001a\u00020\fH\u0016J\u000f\u0010£\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0016J\t\u0010¤\u0001\u001a\u00020\u001aH\u0016J\t\u0010¥\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¦\u0001\u001a\u00020N2\u0007\u0010§\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010¨\u0001\u001a\u00020N2\u0007\u0010©\u0001\u001a\u00020\fH\u0016J\f\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J$\u0010¬\u0001\u001a\u00020N2\u0007\u0010\u009d\u0001\u001a\u00020\u000e2\u0007\u0010\u00ad\u0001\u001a\u00020\u000e2\u0007\u0010®\u0001\u001a\u00020\u000eH\u0016J$\u0010¯\u0001\u001a\u00020N2\u0007\u0010°\u0001\u001a\u00020\f2\u0007\u0010±\u0001\u001a\u00020\u000e2\u0007\u0010²\u0001\u001a\u00020\u000eH\u0016J\t\u0010³\u0001\u001a\u00020\fH\u0016J\t\u0010´\u0001\u001a\u00020\u000eH\u0016J\u0014\u0010µ\u0001\u001a\u00020N2\t\u0010R\u001a\u0005\u0018\u00010¶\u0001H\u0016J\f\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0016J\f\u0010¹\u0001\u001a\u0005\u0018\u00010 \u0001H\u0016J\t\u0010º\u0001\u001a\u00020NH\u0016J\t\u0010»\u0001\u001a\u00020\u000eH\u0016J\t\u0010¼\u0001\u001a\u00020\u000eH\u0016J3\u0010½\u0001\u001a\u00020\u000e2\b\b\u0002\u0010T\u001a\u00020\u000e2\b\b\u0002\u0010U\u001a\u00020\u000e2\t\b\u0002\u0010¾\u0001\u001a\u00020\u000e2\t\b\u0002\u0010¿\u0001\u001a\u00020\u000eH\u0002J3\u0010À\u0001\u001a\u00020\u000e2\b\b\u0002\u0010T\u001a\u00020\u000e2\b\b\u0002\u0010U\u001a\u00020\u000e2\t\b\u0002\u0010¾\u0001\u001a\u00020\u000e2\t\b\u0002\u0010¿\u0001\u001a\u00020\u000eH\u0002J\t\u0010Á\u0001\u001a\u00020\u000eH\u0016J\t\u0010Â\u0001\u001a\u00020\u000eH\u0016J-\u0010Ã\u0001\u001a\u00020N2\u0007\u0010Ä\u0001\u001a\u00020\u001a2\u0007\u0010Å\u0001\u001a\u00020\u001a2\u0007\u0010Æ\u0001\u001a\u00020\u001a2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0016J)\u0010È\u0001\u001a\u00020N2\n\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u00012\u0007\u0010Ë\u0001\u001a\u00020\f2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010Í\u0001\u001a\u00020NH\u0016J\u000b\u0010Î\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010Ï\u0001\u001a\u00020N2\u0007\u0010Ð\u0001\u001a\u00020\u0006H\u0016J\t\u0010Ñ\u0001\u001a\u00020\u000eH\u0016J\t\u0010Ò\u0001\u001a\u00020\u000eH\u0016J\n\u0010Ó\u0001\u001a\u00030«\u0001H\u0016J\u0012\u0010Ô\u0001\u001a\u00020\u000e2\u0007\u0010Õ\u0001\u001a\u00020\u000eH\u0016J\t\u0010Ö\u0001\u001a\u00020\u000eH\u0016J\t\u0010×\u0001\u001a\u00020NH\u0016J\t\u0010Ø\u0001\u001a\u00020NH\u0016J\u001c\u0010Ù\u0001\u001a\u00020N2\u0007\u0010Ú\u0001\u001a\u00020\f2\b\u0010§\u0001\u001a\u00030Û\u0001H\u0016J\u001a\u0010Ü\u0001\u001a\u00020N2\u000f\u0010Ý\u0001\u001a\n\u0012\u0005\u0012\u00030ß\u00010Þ\u0001H\u0016J\t\u0010à\u0001\u001a\u00020NH\u0016J\u0012\u0010á\u0001\u001a\u00020N2\u0007\u0010â\u0001\u001a\u00020\fH\u0016J\u0013\u0010ã\u0001\u001a\u00020N2\b\u0010Ì\u0001\u001a\u00030ß\u0001H\u0016J\u0015\u0010ä\u0001\u001a\u00020N2\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0016J\u0013\u0010ç\u0001\u001a\u00020N2\b\u0010Ì\u0001\u001a\u00030ß\u0001H\u0016J\u0013\u0010è\u0001\u001a\u00020N2\b\u0010]\u001a\u0004\u0018\u000106H\u0016J\u0007\u0010é\u0001\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u000e\u0010H\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ì\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaPlayContextImpl;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "<init>", "()V", "mCurrentMediaPlayAdapter", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "mMediaPlayAdapterFactory", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayAdapterFactory;", "mMediaPlayParams", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "mInitialed", "", "mCurrentState", "", "mDuration", "", "mLastPosition", "mVideoDisplay", "Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "mCurrentMediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "mVerticesModel", "mCurrentViewPort", "Landroid/graphics/Rect;", "mLeftVolume", "", "mRightVolume", "mTerminateState", "mClock", "Ltv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$Clock;", "mCustomOnPreparedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "mCustomOnBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "mCustomOnVideoSizeChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "mCustomOnCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "mCustomOnInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "mCustomOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "mCustomOnSeekCompleteListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "mCustomOnPlayerClockChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPlayerClockChangedListener;", "mExtraInfoListener", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnExtraInfoListener;", "mCustomMediaStreamChangedListener", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnMediaStreamChangedListener;", "mCustomOnRawDataWriteListener", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnRawDataWriteListener;", "mOnFrameRenderedListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFrameRenderedListener;", "mCustomFirstFrameListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "mOnPreparedListener", "mOnBufferingUpdateListener", "mOnVideoSizeChangedListener", "mOnCompletionListener", "mOnInfoListener", "mOnErrorListener", "mOnSeekCompleteListener", "mOnPlayerClockChangedListener", "mOnRawDataWriteListener", "mOnMediaStreamChangedListener", "tv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$mOnMediaStreamChangedListener$1", "Ltv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$mOnMediaStreamChangedListener$1;", "mMediaPlayerLifeCycleListener", "tv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$mMediaPlayerLifeCycleListener$1", "Ltv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$mMediaPlayerLifeCycleListener$1;", "mFirstFrameListener", "getMediaPlayControlContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayControlContext;", "getMediaPlayRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "init", "", "params", "updatePlayParams", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "ignoreModelChange", "getSpeed", "release", "tryToReleaseMediaItem", "force", "item", "setOnBufferingUpdateListener", "listener", "setOnVideoSizeChangedListener", "setOnPreparedListener", "l", "setOnCompletionListener", "setOnInfoListener", "setOnErrorListener", "setOnSeekComplete", "setPlayerClockChangedListener", "setFirstFrameListener", "setOnRawDataWriteListener", "setMediaItem", "mediaItem", "removeMediaItem", "setVolume", "left", "right", "isInPlaybackState", "releaseCurrentMediaPlayAdapter", "adapter", "createAndInitMediaPlayAdapter", "resume", "seekTo", "position", "accurate", "getBufferedPosition", "pause", "isPaused", "isPlayCompleted", "isPlaying", "isPrepared", "getDuration", "getCurrentPosition", "setVideoDisPlay", "display", "getVideoDisplay", "setDisplayViewPort", "viewPort", "getDisplayViewPort", "setVerticesModel", "mode", "scale", "scaleX", "scaleY", "translate", "tX", "tY", "rotate", "degree", "transform", "flipVideo", "flip", "supportOperator", "op", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;", "invokeOp", "T", "", "(Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;Ljava/lang/Object;)Ljava/lang/Object;", "getBufferedPercentage", "getPlayerType", "setOnExtraInfoListener", "setOnMediaStreamChangedListener", "setAudioStream", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "getCurrentAudioStream", "getCurrentPlayUrl", "", "isAudio", "isIjkPlayer", "getCurrentMediaItem", "getVideoFps", "getBufferControl", "setBufferControl", "type", "setLooping", "looping", "getSupportQualities", "", "setVideoStream", "min", "max", "setDashAuto", "flag", "minQuality", "maxQuality", "getDashAuto", "getCurrentVideoStream", "setOnVideoDisplayCallback", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnVideoDisplayCallback;", "getMediaInfo", "Ltv/danmaku/ijk/media/player/MediaInfo;", "getPlayFailReason", "notifyRefreshFrame", "getVideoHeight", "getVideoWidth", "getAspectWidth", "videoSarNum", "videoSarDen", "getAspectHeight", "getVideoSarDen", "getVideoSarNum", "setBackgroundColor", "red", "green", "blue", "alpha", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "reset", "fetchPlayAdapter", "recoveryPlayAdapter", "mediaPlayAdapter", "getDefaultAudioIndex", "getCurrentAudioIndex", "getAudioStreamsIndex", "setAudioIndex", "index", "getCurrentState", "detachByShared", "attachByShared", "setEnhance", "enable", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$IjkEnhanceType;", "setBlurRectList", "rectList", "", "Landroid/graphics/RectF;", "clearBlurRect", "setEnableMultiRender", "isEnable", "setMultiMainCaptureRect", "setMultiSubWindowSurface", "surface", "Landroid/view/Surface;", "setMultiSubWindowCaptureRect", "setOnFrameRendererListener", "isInitialed", "Companion", "Clock", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayContextImpl extends SharableObject implements IMediaPlayContext {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PlaybackV2::MediaPlayContextImpl";
    private MediaItem<?> mCurrentMediaItem;
    private IMediaPlayAdapter mCurrentMediaPlayAdapter;
    private int mCurrentState;
    private IJKEXTRendererInterface.OnFirstFrameListener mCustomFirstFrameListener;
    private IMediaPlayContext.OnMediaStreamChangedListener mCustomMediaStreamChangedListener;
    private IMediaPlayer.OnBufferingUpdateListener mCustomOnBufferingUpdateListener;
    private IMediaPlayer.OnCompletionListener mCustomOnCompletionListener;
    private IMediaPlayer.OnErrorListener mCustomOnErrorListener;
    private IMediaPlayer.OnInfoListener mCustomOnInfoListener;
    private IMediaPlayer.OnPlayerClockChangedListener mCustomOnPlayerClockChangedListener;
    private IMediaPlayer.OnPreparedListener mCustomOnPreparedListener;
    private IjkMediaPlayer.OnRawDataWriteListener mCustomOnRawDataWriteListener;
    private IMediaPlayer.OnSeekCompleteListener mCustomOnSeekCompleteListener;
    private IMediaPlayer.OnVideoSizeChangedListener mCustomOnVideoSizeChangedListener;
    private long mDuration;
    private IMediaPlayContext.OnExtraInfoListener mExtraInfoListener;
    private boolean mInitialed;
    private long mLastPosition;
    private IMediaPlayAdapterFactory mMediaPlayAdapterFactory;
    private IMediaPlayParams mMediaPlayParams;
    private IJKEXTRendererInterface.OnFrameRenderedListener mOnFrameRenderedListener;
    private int mTerminateState;
    private int mVerticesModel;
    private VideoDisplay mVideoDisplay;
    private Rect mCurrentViewPort = new Rect();
    private float mLeftVolume = -1.0f;
    private float mRightVolume = -1.0f;
    private Clock mClock = new Clock();
    private final IMediaPlayer.OnPreparedListener mOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda0
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public final void onPrepared(IMediaPlayer iMediaPlayer) {
            MediaPlayContextImpl.mOnPreparedListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer);
        }
    };
    private final IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda2
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            MediaPlayContextImpl.mOnBufferingUpdateListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer, i);
        }
    };
    private final IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda3
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            MediaPlayContextImpl.mOnVideoSizeChangedListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer, i, i2, i3, i4);
        }
    };
    private final IMediaPlayer.OnCompletionListener mOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda4
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public final void onCompletion(IMediaPlayer iMediaPlayer) {
            MediaPlayContextImpl.mOnCompletionListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer);
        }
    };
    private final IMediaPlayer.OnInfoListener mOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda5
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2, Bundle bundle) {
            boolean mOnInfoListener$lambda$0;
            mOnInfoListener$lambda$0 = MediaPlayContextImpl.mOnInfoListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer, i, i2, bundle);
            return mOnInfoListener$lambda$0;
        }
    };
    private final IMediaPlayer.OnErrorListener mOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda6
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public final boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            boolean mOnErrorListener$lambda$0;
            mOnErrorListener$lambda$0 = MediaPlayContextImpl.mOnErrorListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer, i, i2);
            return mOnErrorListener$lambda$0;
        }
    };
    private final IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda7
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
            MediaPlayContextImpl.mOnSeekCompleteListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer);
        }
    };
    private final IMediaPlayer.OnPlayerClockChangedListener mOnPlayerClockChangedListener = new IMediaPlayer.OnPlayerClockChangedListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda8
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPlayerClockChangedListener
        public final void onPlayerClockChanged(IMediaPlayer iMediaPlayer, float f, long j) {
            MediaPlayContextImpl.mOnPlayerClockChangedListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer, f, j);
        }
    };
    private final IjkMediaPlayer.OnRawDataWriteListener mOnRawDataWriteListener = new IjkMediaPlayer.OnRawDataWriteListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda9
        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnRawDataWriteListener
        public final int onRawDataWrite(IMediaPlayer iMediaPlayer, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
            int mOnRawDataWriteListener$lambda$0;
            mOnRawDataWriteListener$lambda$0 = MediaPlayContextImpl.mOnRawDataWriteListener$lambda$0(MediaPlayContextImpl.this, iMediaPlayer, bArr, i, i2, i3, i4, i5);
            return mOnRawDataWriteListener$lambda$0;
        }
    };
    private final MediaPlayContextImpl$mOnMediaStreamChangedListener$1 mOnMediaStreamChangedListener = new IMediaPlayContext.OnMediaStreamChangedListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$mOnMediaStreamChangedListener$1
        @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnMediaStreamChangedListener
        public void onVideoStreamChanged(boolean isSuccess, int oldStream, int newStream, boolean fromAuto) {
            IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener;
            onMediaStreamChangedListener = MediaPlayContextImpl.this.mCustomMediaStreamChangedListener;
            if (onMediaStreamChangedListener != null) {
                onMediaStreamChangedListener.onVideoStreamChanged(isSuccess, oldStream, newStream, fromAuto);
            }
        }

        @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnMediaStreamChangedListener
        public void onAudioStreamChanged(boolean isSuccess, int oldStream, int newStream, boolean fromAuto) {
            IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener;
            onMediaStreamChangedListener = MediaPlayContextImpl.this.mCustomMediaStreamChangedListener;
            if (onMediaStreamChangedListener != null) {
                onMediaStreamChangedListener.onAudioStreamChanged(isSuccess, oldStream, newStream, fromAuto);
            }
        }

        @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnMediaStreamChangedListener
        public void onRecommendVideoStreamStarted(int stream) {
            IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener;
            onMediaStreamChangedListener = MediaPlayContextImpl.this.mCustomMediaStreamChangedListener;
            if (onMediaStreamChangedListener != null) {
                onMediaStreamChangedListener.onRecommendVideoStreamStarted(stream);
            }
        }
    };
    private final MediaPlayContextImpl$mMediaPlayerLifeCycleListener$1 mMediaPlayerLifeCycleListener = new IMediaPlayerLifeCycleListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$mMediaPlayerLifeCycleListener$1
        @Override // tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener
        public void onMediaPlayerDidPrepareToPlay(IMediaPlayer mediaPlayer) {
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
        }

        @Override // tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener
        public void onMediaPlayerWillShutDownByOthers(IMediaPlayer mediaPlayer) {
            IMediaPlayContext.OnExtraInfoListener onExtraInfoListener;
            IMediaPlayAdapter adapter;
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            onExtraInfoListener = MediaPlayContextImpl.this.mExtraInfoListener;
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onInfo(1, null);
            }
            MediaPlayContextImpl.this.mTerminateState = 1;
            adapter = MediaPlayContextImpl.this.mCurrentMediaPlayAdapter;
            if (adapter == null) {
                return;
            }
            PlayerLog.i("PlaybackV2::MediaPlayContextImpl", "release current media player adapter, reason[shut down by others]");
            MediaPlayContextImpl.this.mLastPosition = mediaPlayer.getCurrentPosition();
            MediaPlayContextImpl.this.releaseCurrentMediaPlayAdapter(adapter);
        }

        @Override // tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener
        public void onMediaPlayerWillResignActive(IMediaPlayer mediaPlayer) {
            IMediaPlayContext.OnExtraInfoListener onExtraInfoListener;
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            PlayerLog.i("PlaybackV2::MediaPlayContextImpl", "media player will resign active");
            onExtraInfoListener = MediaPlayContextImpl.this.mExtraInfoListener;
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onInfo(3, null);
            }
            MediaPlayContextImpl.this.pause();
        }

        @Override // tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener
        public void onMediaPlayerDidBecomeActive(IMediaPlayer mediaPlayer) {
            IMediaPlayContext.OnExtraInfoListener onExtraInfoListener;
            Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
            PlayerLog.i("PlaybackV2::MediaPlayContextImpl", "media player did become active");
            onExtraInfoListener = MediaPlayContextImpl.this.mExtraInfoListener;
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onInfo(2, null);
            }
            MediaPlayContextImpl.this.resume();
        }
    };
    private final IJKEXTRendererInterface.OnFirstFrameListener mFirstFrameListener = new IJKEXTRendererInterface.OnFirstFrameListener() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda10
        @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface.OnFirstFrameListener
        public final void onFirstFrame() {
            MediaPlayContextImpl.mFirstFrameListener$lambda$0(MediaPlayContextImpl.this);
        }
    };

    /* compiled from: MediaPlayContextImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$Companion;", "", "<init>", "()V", "TAG", "", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPreparedListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer it) {
        IMediaPlayContext.OnExtraInfoListener onExtraInfoListener;
        PlayerLog.i(TAG, "on-prepared:" + it.getDuration());
        this$0.mCurrentState = 2;
        this$0.mLastPosition = 0L;
        this$0.mDuration = it.getDuration();
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this$0.mCustomOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(it, this$0.getVideoWidth(), this$0.getVideoHeight(), 1, 1);
        }
        IMediaPlayer.OnPreparedListener onPreparedListener = this$0.mCustomOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(it);
        }
        if (this$0.mTerminateState == 4 && (onExtraInfoListener = this$0.mExtraInfoListener) != null) {
            onExtraInfoListener.onInfo(5, null);
        }
        boolean z = false;
        this$0.mTerminateState = 0;
        MediaItem<?> mediaItem = this$0.mCurrentMediaItem;
        if (mediaItem != null && mediaItem.getAutoPlayWhenPrepare()) {
            z = true;
        }
        if (z) {
            this$0.mCurrentState = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnBufferingUpdateListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer p0, int p1) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this$0.mCustomOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(p0, p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnVideoSizeChangedListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer p0, int p1, int p2, int p3, int p4) {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this$0.mCustomOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(p0, this$0.getAspectWidth(p1, p2, p3, p4), this$0.getAspectHeight(p1, p2, p3, p4), 1, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnCompletionListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer it) {
        this$0.mLastPosition = it.getCurrentPosition();
        this$0.mCurrentState = 5;
        IMediaPlayer.OnCompletionListener onCompletionListener = this$0.mCustomOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnInfoListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer p0, int p1, int p2, Bundle p3) {
        IMediaPlayer.OnInfoListener onInfoListener = this$0.mCustomOnInfoListener;
        if (onInfoListener != null) {
            return onInfoListener.onInfo(p0, p1, p2, p3);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnErrorListener$lambda$0(final MediaPlayContextImpl this$0, IMediaPlayer p0, int p1, int p2) {
        if (p0 != null) {
            this$0.mLastPosition = p0.getCurrentPosition();
        }
        if (this$0.mLastPosition <= 0) {
            this$0.mLastPosition = this$0.mClock.currentPosition();
        }
        this$0.mClock.clear();
        this$0.mCurrentState = -1;
        IMediaPlayer.OnErrorListener onErrorListener = this$0.mCustomOnErrorListener;
        boolean res = onErrorListener != null ? onErrorListener.onError(p0, p1, p2) : false;
        PlayerLog.e(TAG, "player core hit some error {" + p0 + ", " + p1 + ", " + p2 + "}, release it!!!");
        if (!res) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaPlayContextImpl.mOnErrorListener$lambda$0$0(MediaPlayContextImpl.this);
                    }
                });
                return true;
            }
            this$0.releaseCurrentMediaPlayAdapter(this$0.mCurrentMediaPlayAdapter);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnErrorListener$lambda$0$0(MediaPlayContextImpl this$0) {
        this$0.releaseCurrentMediaPlayAdapter(this$0.mCurrentMediaPlayAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnSeekCompleteListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer it) {
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this$0.mCustomOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnPlayerClockChangedListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer p0, float p1, long p2) {
        this$0.mClock.update(p1, p2);
        IMediaPlayer.OnPlayerClockChangedListener onPlayerClockChangedListener = this$0.mCustomOnPlayerClockChangedListener;
        if (onPlayerClockChangedListener != null) {
            onPlayerClockChangedListener.onPlayerClockChanged(p0, p1, p2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int mOnRawDataWriteListener$lambda$0(MediaPlayContextImpl this$0, IMediaPlayer iMediaPlayer, byte[] bytes, int i, int i2, int i3, int i4, int i5) {
        IjkMediaPlayer.OnRawDataWriteListener onRawDataWriteListener = this$0.mCustomOnRawDataWriteListener;
        if (onRawDataWriteListener != null) {
            return onRawDataWriteListener.onRawDataWrite(iMediaPlayer, bytes, i, i2, i3, i4, i5);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFirstFrameListener$lambda$0(MediaPlayContextImpl this$0) {
        PlayerLog.i(TAG, "first render frame");
        IJKEXTRendererInterface.OnFirstFrameListener onFirstFrameListener = this$0.mCustomFirstFrameListener;
        if (onFirstFrameListener != null) {
            onFirstFrameListener.onFirstFrame();
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public IMediaPlayControlContext getMediaPlayControlContext() {
        return this;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public IMediaPlayRenderContext getMediaPlayRenderContext() {
        return this;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void init(IMediaPlayParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.mInitialed) {
            if (BuildConfig.DEBUG) {
                throw new IllegalStateException("this mediaPlayContext(" + this + ") is already initialed");
            }
            PlayerLog.e(TAG, "this mediaPlayContext(" + this + ") is already initialed");
            return;
        }
        this.mInitialed = true;
        this.mMediaPlayParams = params;
        this.mMediaPlayAdapterFactory = params.mediaPlayAdapterFactory();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void updatePlayParams(IMediaPlayParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.mMediaPlayParams = params;
        this.mMediaPlayAdapterFactory = params.mediaPlayAdapterFactory();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height, boolean ignoreModelChange) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(callback, "callback");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.takeVideoCapture(callback, width, height, ignoreModelChange);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public float getSpeed() {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isInitialed() || (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return 1.0f;
        }
        return mediaPlayControlContext.getSpeed();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void release() {
        if (!this.mInitialed) {
            if (BuildConfig.DEBUG) {
                throw new IllegalStateException("this mediaPlayContext(" + this + ") is not initialed");
            }
            PlayerLog.e(TAG, "this mediaPlayContext(" + this + ") is not initialed");
            return;
        }
        PlayerLog.i(TAG, "release media player context");
        releaseCurrentMediaPlayAdapter(this.mCurrentMediaPlayAdapter);
        setOnCompletionListener(null);
        setOnBufferingUpdateListener(null);
        setOnPreparedListener(null);
        setOnErrorListener(null);
        setOnInfoListener(null);
        setOnSeekComplete(null);
        setPlayerClockChangedListener(null);
        setOnVideoSizeChangedListener(null);
        setOnExtraInfoListener(null);
        setFirstFrameListener(null);
        this.mInitialed = false;
        this.mTerminateState = 0;
    }

    private final void tryToReleaseMediaItem(boolean force, MediaItem<?> mediaItem) {
        if (!force) {
            if (!((mediaItem == null || mediaItem.getKeepAliveRemoveFromPlayer()) ? false : true)) {
                return;
            }
        }
        IMediaPlayContext.OnExtraInfoListener onExtraInfoListener = this.mExtraInfoListener;
        if (onExtraInfoListener != null) {
            onExtraInfoListener.onInfo(7, new MediaItem[]{mediaItem});
        }
        if (mediaItem != null) {
            mediaItem.release(force);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnBufferingUpdateListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnVideoSizeChangedListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener l) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnPreparedListener = l;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener l) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnCompletionListener = l;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnInfoListener(IMediaPlayer.OnInfoListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnInfoListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnErrorListener(IMediaPlayer.OnErrorListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnErrorListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnSeekComplete(IMediaPlayer.OnSeekCompleteListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnSeekCompleteListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setPlayerClockChangedListener(IMediaPlayer.OnPlayerClockChangedListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnPlayerClockChangedListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener listener) {
        this.mCustomFirstFrameListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnRawDataWriteListener(IjkMediaPlayer.OnRawDataWriteListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomOnRawDataWriteListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setMediaItem(MediaItem<?> mediaItem) {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayControlContext mediaPlayControlContext2;
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        if (!isInitialed()) {
            return;
        }
        PlayerLog.i(TAG, "set media-item@" + mediaItem);
        if (!mediaItem.valid()) {
            if (BuildConfig.DEBUG) {
                throw new IllegalStateException("mediaItem is invalid: " + mediaItem);
            }
            PlayerLog.e(TAG, "mediaItem is invalid: " + mediaItem);
        }
        if (Intrinsics.areEqual(mediaItem, this.mCurrentMediaItem)) {
            PlayerLog.e(TAG, "new media item equals current media item");
            return;
        }
        MediaItem<?> mediaItem2 = this.mCurrentMediaItem;
        if (mediaItem2 != null) {
            mediaItem2.setActive$playercore_debug(false);
        }
        mediaItem.setActive$playercore_debug(true);
        MediaItem old = this.mCurrentMediaItem;
        this.mCurrentMediaItem = mediaItem;
        IMediaPlayContext.OnExtraInfoListener onExtraInfoListener = this.mExtraInfoListener;
        if (onExtraInfoListener != null) {
            onExtraInfoListener.onInfo(8, new MediaItem[]{old, mediaItem});
        }
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter != null && iMediaPlayAdapter.supported(mediaItem)) {
            PlayerLog.i(TAG, "cur-adapter supported this media-item, should not create new adapter");
            this.mCurrentState = 1;
            IMediaPlayAdapter iMediaPlayAdapter2 = this.mCurrentMediaPlayAdapter;
            if (iMediaPlayAdapter2 != null && (mediaPlayControlContext2 = iMediaPlayAdapter2.getMediaPlayControlContext()) != null) {
                mediaPlayControlContext2.setMediaItem(mediaItem);
            }
            tryToReleaseMediaItem(false, old);
            return;
        }
        if (this.mCurrentMediaPlayAdapter != null) {
            PlayerLog.i(TAG, "cur-adapter not supported this media-item, release it now");
            releaseCurrentMediaPlayAdapter(this.mCurrentMediaPlayAdapter);
        }
        PlayerLog.i(TAG, "create new adapter");
        this.mCurrentMediaPlayAdapter = createAndInitMediaPlayAdapter(mediaItem);
        IMediaPlayAdapter iMediaPlayAdapter3 = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter3 != null && (mediaPlayControlContext = iMediaPlayAdapter3.getMediaPlayControlContext()) != null) {
            mediaPlayControlContext.setMediaItem(mediaItem);
        }
        this.mCurrentState = 1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void removeMediaItem(MediaItem<?> mediaItem) {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayControlContext mediaPlayControlContext2;
        if (!isInitialed()) {
            return;
        }
        this.mCurrentState = 0;
        if (mediaItem == null) {
            PlayerLog.i(TAG, "remove current media-item@" + this.mCurrentMediaItem);
            IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
            if (iMediaPlayAdapter != null && (mediaPlayControlContext2 = iMediaPlayAdapter.getMediaPlayControlContext()) != null) {
                mediaPlayControlContext2.removeMediaItem(this.mCurrentMediaItem);
            }
            tryToReleaseMediaItem(false, this.mCurrentMediaItem);
            this.mCurrentMediaItem = null;
            return;
        }
        PlayerLog.i(TAG, "remove media-item@" + mediaItem);
        IMediaPlayAdapter iMediaPlayAdapter2 = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter2 == null || (mediaPlayControlContext = iMediaPlayAdapter2.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.removeMediaItem(mediaItem);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setVolume(float left, float right) {
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isInitialed()) {
            return;
        }
        PlayerLog.i(TAG, "setVolume: [left=" + left + "; right=" + right + "]");
        this.mLeftVolume = left;
        this.mRightVolume = right;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.setVolume(left, right);
    }

    private final boolean isInPlaybackState() {
        return (this.mCurrentMediaPlayAdapter == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseCurrentMediaPlayAdapter(IMediaPlayAdapter adapter) {
        PlayerLog.i(TAG, "release media play adapter@" + adapter);
        if (adapter != null) {
            IMediaPlayContext.OnExtraInfoListener onExtraInfoListener = this.mExtraInfoListener;
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onInfo(6, null);
            }
            IMediaPlayer mediaPlayer = adapter.getMediaPlayer();
            PlayerLog.i(TAG, "release adapter@" + adapter);
            adapter.release();
            MediaCenter.INSTANCE.unregisterPlayer(mediaPlayer, this.mMediaPlayerLifeCycleListener);
        }
        tryToReleaseMediaItem(true, this.mCurrentMediaItem);
        this.mCurrentMediaPlayAdapter = null;
        this.mCurrentState = 0;
    }

    private final IMediaPlayAdapter createAndInitMediaPlayAdapter(MediaItem<?> mediaItem) {
        PlayerLog.i(TAG, "create and init media play adapter");
        IMediaPlayAdapterFactory iMediaPlayAdapterFactory = this.mMediaPlayAdapterFactory;
        if (iMediaPlayAdapterFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayAdapterFactory");
            iMediaPlayAdapterFactory = null;
        }
        IMediaPlayParams iMediaPlayParams = this.mMediaPlayParams;
        if (iMediaPlayParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
            iMediaPlayParams = null;
        }
        IMediaPlayAdapter adapter = iMediaPlayAdapterFactory.create(iMediaPlayParams, mediaItem);
        PlayerLog.i(TAG, "current media play adapter@" + adapter);
        IMediaPlayParams iMediaPlayParams2 = this.mMediaPlayParams;
        if (iMediaPlayParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
            iMediaPlayParams2 = null;
        }
        adapter.init(iMediaPlayParams2);
        IMediaPlayer mediaPlayer = adapter.getMediaPlayer();
        MediaCenter mediaCenter = MediaCenter.INSTANCE;
        MediaPlayContextImpl$mMediaPlayerLifeCycleListener$1 mediaPlayContextImpl$mMediaPlayerLifeCycleListener$1 = this.mMediaPlayerLifeCycleListener;
        IMediaPlayParams iMediaPlayParams3 = this.mMediaPlayParams;
        if (iMediaPlayParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
            iMediaPlayParams3 = null;
        }
        mediaCenter.registerPlayer(mediaPlayer, mediaPlayContextImpl$mMediaPlayerLifeCycleListener$1, iMediaPlayParams3.playerType());
        IMediaPlayControlContext mediaPlayControlContext = adapter.getMediaPlayControlContext();
        mediaPlayControlContext.setFirstFrameListener(this.mFirstFrameListener);
        mediaPlayControlContext.setOnPreparedListener(this.mOnPreparedListener);
        mediaPlayControlContext.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
        mediaPlayControlContext.setOnCompletionListener(this.mOnCompletionListener);
        mediaPlayControlContext.setOnErrorListener(this.mOnErrorListener);
        mediaPlayControlContext.setOnInfoListener(this.mOnInfoListener);
        mediaPlayControlContext.setOnSeekComplete(this.mOnSeekCompleteListener);
        mediaPlayControlContext.setPlayerClockChangedListener(this.mOnPlayerClockChangedListener);
        mediaPlayControlContext.setOnMediaStreamChangedListener(this.mOnMediaStreamChangedListener);
        mediaPlayControlContext.setOnRawDataWriteListener(this.mOnRawDataWriteListener);
        adapter.getMediaPlayRenderContext().setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
        adapter.getMediaPlayRenderContext().setOnFrameRendererListener(this.mOnFrameRenderedListener);
        IMediaPlayRenderContext mediaPlayRenderContext = adapter.getMediaPlayRenderContext();
        VideoDisplay videoDisplay = this.mVideoDisplay;
        int i = 0;
        if (videoDisplay != null && videoDisplay.isValid()) {
            VideoDisplay videoDisplay2 = this.mVideoDisplay;
            Intrinsics.checkNotNull(videoDisplay2);
            mediaPlayRenderContext.setVideoDisPlay(videoDisplay2);
        }
        mediaPlayRenderContext.setVerticesModel(this.mVerticesModel);
        mediaPlayRenderContext.setDisplayViewPort(this.mCurrentViewPort);
        if (this.mLeftVolume >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && this.mRightVolume >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            mediaPlayControlContext.setVolume(this.mLeftVolume, this.mRightVolume);
            PlayerLog.i(TAG, "setVolume: [left=" + this.mLeftVolume + "; right=" + this.mRightVolume + "] when ijk created");
        }
        if (this.mTerminateState == 1) {
            IMediaPlayContext.OnExtraInfoListener onExtraInfoListener = this.mExtraInfoListener;
            i = 4;
            if (onExtraInfoListener != null) {
                onExtraInfoListener.onInfo(4, null);
            }
        }
        this.mTerminateState = i;
        return adapter;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void resume() {
        if (!isInitialed() || isPlaying() || !isInPlaybackState()) {
            return;
        }
        PlayerLog.i(TAG, "resume");
        IMediaPlayAdapter adapter = this.mCurrentMediaPlayAdapter;
        if (adapter == null) {
            return;
        }
        adapter.getMediaPlayControlContext().resume();
        this.mCurrentState = 3;
        IMediaPlayParams iMediaPlayParams = this.mMediaPlayParams;
        if (iMediaPlayParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
            iMediaPlayParams = null;
        }
        if (iMediaPlayParams.playerType() != PlayerType.Single) {
            IMediaPlayParams iMediaPlayParams2 = this.mMediaPlayParams;
            if (iMediaPlayParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
                iMediaPlayParams2 = null;
            }
            if (iMediaPlayParams2.playerType() != PlayerType.Exclusive) {
                return;
            }
        }
        MediaCenter mediaCenter = MediaCenter.INSTANCE;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        mediaCenter.activePlayer(iMediaPlayAdapter != null ? iMediaPlayAdapter.getMediaPlayer() : null, this.mMediaPlayerLifeCycleListener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void seekTo(long position) {
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isInitialed() || !isInPlaybackState()) {
            return;
        }
        PlayerLog.i(TAG, "seek[position=" + position + "]");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.seekTo(position);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void seekTo(long position, boolean accurate) {
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isInitialed() || !isInPlaybackState()) {
            return;
        }
        PlayerLog.i(TAG, "seek[position=" + position + " accurate=" + accurate + "]");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.seekTo(position, accurate);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public long getBufferedPosition() {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isInitialed() || !isInPlaybackState() || (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return 0L;
        }
        return mediaPlayControlContext.getBufferedPosition();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void pause() {
        if (!isInitialed() || !isPlaying()) {
            return;
        }
        PlayerLog.i(TAG, "pause");
        IMediaPlayAdapter adapter = this.mCurrentMediaPlayAdapter;
        if (adapter == null) {
            return;
        }
        this.mCurrentState = 4;
        adapter.getMediaPlayControlContext().pause();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public boolean isPaused() {
        return this.mCurrentState == 4;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public boolean isPlayCompleted() {
        return this.mCurrentState == 5;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public boolean isPlaying() {
        return this.mCurrentState == 3;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public boolean isPrepared() {
        return this.mCurrentState == 2 || isPaused() || isPlayCompleted() || isPlaying();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public long getDuration() {
        return this.mDuration;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public long getCurrentPosition() {
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isPrepared()) {
            return this.mLastPosition;
        }
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        return (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) ? this.mLastPosition : mediaPlayControlContext.getCurrentPosition();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setVideoDisPlay(VideoDisplay display) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(display, "display");
        if (!isInitialed()) {
            return;
        }
        PlayerLog.i(TAG, "setVideoDisplay: display@" + display);
        this.mVideoDisplay = display;
        boolean isPlayerNotReady = false;
        boolean isSurfaceValid = display.isValid() && display.getType() == 1;
        if (this.mCurrentMediaPlayAdapter == null || this.mCurrentState == 0) {
            isPlayerNotReady = true;
        }
        if (isSurfaceValid && isPlayerNotReady) {
            SurfaceHolder surfaceHolder = display.getSurfaceHolder();
            IjkNativeWindowHelper.flushSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        }
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setVideoDisPlay(display);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public VideoDisplay getVideoDisplay() {
        return this.mVideoDisplay;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setDisplayViewPort(Rect viewPort) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        if (!isInitialed()) {
            return;
        }
        this.mCurrentViewPort.set(viewPort);
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setDisplayViewPort(viewPort);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public Rect getDisplayViewPort() {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return null;
        }
        return mediaPlayRenderContext.getDisplayViewPort();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setVerticesModel(int mode) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (!isInitialed()) {
            return;
        }
        this.mVerticesModel = mode;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setVerticesModel(mode);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void scale(float scale) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.scale(scale);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void scale(float scaleX, float scaleY) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.scale(scaleX, scaleY);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void translate(int tX, int tY) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.translate(tX, tY);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void rotate(float degree) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.rotate(degree);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void transform(float scale, int tX, int tY, float degree) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.transform(scale, tX, tY, degree);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void flipVideo(boolean flip) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.flipVideo(flip);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public boolean supportOperator(IMediaPlayAdapter.Ops op) {
        IMediaPlayAdapter iMediaPlayAdapter;
        Intrinsics.checkNotNullParameter(op, "op");
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null) {
            return iMediaPlayAdapter.supportOperator(op);
        }
        return false;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public <T> T invokeOp(IMediaPlayAdapter.Ops op, Object params) {
        IMediaPlayAdapter iMediaPlayAdapter;
        Intrinsics.checkNotNullParameter(op, "op");
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null) {
            return (T) iMediaPlayAdapter.invokeOp(op, params);
        }
        return null;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public float getBufferedPercentage() {
        IMediaPlayControlContext mediaPlayControlContext;
        if (!isInitialed()) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        long bufferedPosition = (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) ? 0L : mediaPlayControlContext.getBufferedPosition();
        long duration = getDuration();
        return ((float) bufferedPosition) / ((float) duration);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public int getPlayerType() {
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter != null) {
            return iMediaPlayAdapter.type();
        }
        return 1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public void setOnExtraInfoListener(IMediaPlayContext.OnExtraInfoListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mExtraInfoListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnMediaStreamChangedListener(IMediaPlayContext.OnMediaStreamChangedListener listener) {
        if (!isInitialed()) {
            return;
        }
        this.mCustomMediaStreamChangedListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setAudioStream(int quality) {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.setAudioStream(quality);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int getCurrentAudioStream() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return -1;
        }
        return mediaPlayControlContext.getCurrentAudioStream();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public String getCurrentPlayUrl(boolean isAudio) {
        IMediaPlayControlContext mediaPlayControlContext;
        String currentPlayUrl;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        return (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null || (currentPlayUrl = mediaPlayControlContext.getCurrentPlayUrl(isAudio)) == null) ? "" : currentPlayUrl;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public boolean isIjkPlayer() {
        return getPlayerType() == 1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public MediaItem<?> getCurrentMediaItem() {
        return this.mCurrentMediaItem;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public float getVideoFps() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        return (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : mediaPlayControlContext.getVideoFps();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int getBufferControl() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return 0;
        }
        return mediaPlayControlContext.getBufferControl();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setBufferControl(int type) {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.setBufferControl(type);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setLooping(boolean looping) {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.setLooping(looping);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int[] getSupportQualities() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return null;
        }
        return mediaPlayControlContext.getSupportQualities();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setVideoStream(int quality, int min, int max) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayControlContext mediaPlayControlContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) != null) {
            mediaPlayControlContext.setVideoStream(quality, min, max);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setDashAuto(boolean flag, int minQuality, int maxQuality) {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayControlContext mediaPlayControlContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) != null) {
            mediaPlayControlContext.setDashAuto(flag, minQuality, maxQuality);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public boolean getDashAuto() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return false;
        }
        return mediaPlayControlContext.getDashAuto();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int getCurrentVideoStream() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return -1;
        }
        return mediaPlayControlContext.getCurrentVideoStream();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnVideoDisplayCallback(IjkMediaPlayer.OnVideoDisplayCallback callback) {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return;
        }
        mediaPlayControlContext.setOnVideoDisplayCallback(callback);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public MediaInfo getMediaInfo() {
        IMediaPlayer mediaPlayer;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayer = iMediaPlayAdapter.getMediaPlayer()) == null) {
            return null;
        }
        return mediaPlayer.getMediaInfo();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public String getPlayFailReason() {
        IMediaPlayControlContext mediaPlayControlContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayControlContext = iMediaPlayAdapter.getMediaPlayControlContext()) == null) {
            return null;
        }
        return mediaPlayControlContext.getPlayFailReason();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void notifyRefreshFrame() {
        IMediaPlayAdapter iMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext;
        if (isInitialed() && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null && (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) != null) {
            mediaPlayRenderContext.notifyRefreshFrame();
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoHeight() {
        return getAspectHeight$default(this, 0, 0, 0, 0, 15, null);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoWidth() {
        return getAspectWidth$default(this, 0, 0, 0, 0, 15, null);
    }

    static /* synthetic */ int getAspectWidth$default(MediaPlayContextImpl mediaPlayContextImpl, int i, int i2, int i3, int i4, int i5, Object obj) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayRenderContext mediaPlayRenderContext2;
        IMediaPlayRenderContext mediaPlayRenderContext3;
        IMediaPlayRenderContext mediaPlayRenderContext4;
        if ((i5 & 1) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i = (iMediaPlayAdapter == null || (mediaPlayRenderContext4 = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext4.getVideoWidth();
        }
        if ((i5 & 2) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter2 = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i2 = (iMediaPlayAdapter2 == null || (mediaPlayRenderContext3 = iMediaPlayAdapter2.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext3.getVideoHeight();
        }
        if ((i5 & 4) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter3 = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i3 = (iMediaPlayAdapter3 == null || (mediaPlayRenderContext2 = iMediaPlayAdapter3.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext2.getVideoSarNum();
        }
        if ((i5 & 8) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter4 = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i4 = (iMediaPlayAdapter4 == null || (mediaPlayRenderContext = iMediaPlayAdapter4.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext.getVideoSarDen();
        }
        return mediaPlayContextImpl.getAspectWidth(i, i2, i3, i4);
    }

    private final int getAspectWidth(int width, int height, int videoSarNum, int videoSarDen) {
        if (videoSarNum < 1 || videoSarDen < 1 || width < 1 || height < 1) {
            return width;
        }
        float displayAspectRatio = width / height;
        float ratio = videoSarNum / videoSarDen;
        float h = width / (displayAspectRatio * ratio);
        return (int) (displayAspectRatio * ratio * h);
    }

    static /* synthetic */ int getAspectHeight$default(MediaPlayContextImpl mediaPlayContextImpl, int i, int i2, int i3, int i4, int i5, Object obj) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayRenderContext mediaPlayRenderContext2;
        IMediaPlayRenderContext mediaPlayRenderContext3;
        IMediaPlayRenderContext mediaPlayRenderContext4;
        if ((i5 & 1) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i = (iMediaPlayAdapter == null || (mediaPlayRenderContext4 = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext4.getVideoWidth();
        }
        if ((i5 & 2) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter2 = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i2 = (iMediaPlayAdapter2 == null || (mediaPlayRenderContext3 = iMediaPlayAdapter2.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext3.getVideoHeight();
        }
        if ((i5 & 4) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter3 = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i3 = (iMediaPlayAdapter3 == null || (mediaPlayRenderContext2 = iMediaPlayAdapter3.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext2.getVideoSarNum();
        }
        if ((i5 & 8) != 0) {
            IMediaPlayAdapter iMediaPlayAdapter4 = mediaPlayContextImpl.mCurrentMediaPlayAdapter;
            i4 = (iMediaPlayAdapter4 == null || (mediaPlayRenderContext = iMediaPlayAdapter4.getMediaPlayRenderContext()) == null) ? 0 : mediaPlayRenderContext.getVideoSarDen();
        }
        return mediaPlayContextImpl.getAspectHeight(i, i2, i3, i4);
    }

    private final int getAspectHeight(int width, int height, int videoSarNum, int videoSarDen) {
        if (videoSarNum < 1 || videoSarDen < 1 || width < 1 || height < 1) {
            return height;
        }
        float displayAspectRatio = width / height;
        float ratio = videoSarNum / videoSarDen;
        return (int) (width / (displayAspectRatio * ratio));
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoSarDen() {
        return 1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoSarNum() {
        return 1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setBackgroundColor(red, green, blue, alpha);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect rect) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setBackgroundImage(bitmap, recycle, rect);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public void reset() {
        releaseCurrentMediaPlayAdapter(this.mCurrentMediaPlayAdapter);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public IMediaPlayAdapter fetchPlayAdapter() {
        IMediaPlayAdapter mediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (mediaPlayAdapter == null) {
            return null;
        }
        IMediaPlayer mediaPlayer = mediaPlayAdapter.getMediaPlayer();
        if (!(mediaPlayer instanceof IjkMediaPlayer)) {
            PlayerLog.i(TAG, " is not ijk player, cannot share");
            return null;
        }
        PlayerLog.i(TAG, "fetch media play adapter@" + mediaPlayAdapter);
        MediaCenter.INSTANCE.unregisterPlayer(mediaPlayer, this.mMediaPlayerLifeCycleListener, true);
        IMediaPlayControlContext $this$fetchPlayAdapter_u24lambda_u240 = mediaPlayAdapter.getMediaPlayControlContext();
        $this$fetchPlayAdapter_u24lambda_u240.setOnPreparedListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setFirstFrameListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnCompletionListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnErrorListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnBufferingUpdateListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnInfoListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnSeekComplete(null);
        $this$fetchPlayAdapter_u24lambda_u240.setPlayerClockChangedListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnMediaStreamChangedListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnRawDataWriteListener(null);
        $this$fetchPlayAdapter_u24lambda_u240.setOnVideoDisplayCallback(null);
        IMediaPlayRenderContext $this$fetchPlayAdapter_u24lambda_u241 = mediaPlayAdapter.getMediaPlayRenderContext();
        $this$fetchPlayAdapter_u24lambda_u241.setOnVideoSizeChangedListener(null);
        $this$fetchPlayAdapter_u24lambda_u241.setOnFrameRendererListener(null);
        IMediaPlayRenderContext mediaPlayRenderContext = mediaPlayAdapter.getMediaPlayRenderContext();
        IMediaPlayRenderAdapter renderAdapter = mediaPlayRenderContext instanceof IMediaPlayRenderAdapter ? (IMediaPlayRenderAdapter) mediaPlayRenderContext : null;
        if (renderAdapter != null) {
            renderAdapter.unbindContext();
        }
        this.mCurrentMediaPlayAdapter = null;
        IMediaPlayContext.OnExtraInfoListener onExtraInfoListener = this.mExtraInfoListener;
        if (onExtraInfoListener != null) {
            onExtraInfoListener.onInfo(1, null);
        }
        this.mTerminateState = 1;
        return mediaPlayAdapter;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public void recoveryPlayAdapter(IMediaPlayAdapter mediaPlayAdapter) {
        Intrinsics.checkNotNullParameter(mediaPlayAdapter, "mediaPlayAdapter");
        this.mCurrentMediaPlayAdapter = mediaPlayAdapter;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        IMediaPlayParams iMediaPlayParams = null;
        IMediaPlayRenderContext mediaPlayRenderContext = iMediaPlayAdapter != null ? iMediaPlayAdapter.getMediaPlayRenderContext() : null;
        IMediaPlayRenderAdapter renderAdapter = mediaPlayRenderContext instanceof IMediaPlayRenderAdapter ? (IMediaPlayRenderAdapter) mediaPlayRenderContext : null;
        if (renderAdapter != null) {
            renderAdapter.unbindContext();
        }
        PlayerLog.i(TAG, "recovery media play adapter@" + mediaPlayAdapter);
        IMediaPlayer mediaPlayer = mediaPlayAdapter.getMediaPlayer();
        MediaCenter mediaCenter = MediaCenter.INSTANCE;
        MediaPlayContextImpl$mMediaPlayerLifeCycleListener$1 mediaPlayContextImpl$mMediaPlayerLifeCycleListener$1 = this.mMediaPlayerLifeCycleListener;
        IMediaPlayParams iMediaPlayParams2 = this.mMediaPlayParams;
        if (iMediaPlayParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
        } else {
            iMediaPlayParams = iMediaPlayParams2;
        }
        mediaCenter.registerPlayer(mediaPlayer, mediaPlayContextImpl$mMediaPlayerLifeCycleListener$1, iMediaPlayParams.playerType());
        IMediaPlayControlContext mediaPlayControlContext = mediaPlayAdapter.getMediaPlayControlContext();
        mediaPlayControlContext.setFirstFrameListener(this.mFirstFrameListener);
        mediaPlayControlContext.setOnPreparedListener(this.mOnPreparedListener);
        mediaPlayControlContext.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
        mediaPlayControlContext.setOnCompletionListener(this.mOnCompletionListener);
        mediaPlayControlContext.setOnErrorListener(this.mOnErrorListener);
        mediaPlayControlContext.setOnInfoListener(this.mOnInfoListener);
        mediaPlayControlContext.setOnSeekComplete(this.mOnSeekCompleteListener);
        mediaPlayControlContext.setPlayerClockChangedListener(this.mOnPlayerClockChangedListener);
        mediaPlayControlContext.setOnMediaStreamChangedListener(this.mOnMediaStreamChangedListener);
        mediaPlayControlContext.setOnRawDataWriteListener(this.mOnRawDataWriteListener);
        IMediaPlayRenderContext mediaPlayRenderContext2 = mediaPlayAdapter.getMediaPlayRenderContext();
        mediaPlayRenderContext2.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
        mediaPlayRenderContext2.setOnFrameRendererListener(this.mOnFrameRenderedListener);
        this.mCurrentState = mediaPlayer.isPlaying() ? 3 : 0;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public int getDefaultAudioIndex() {
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter != null) {
            return iMediaPlayAdapter.getDefaultAudioIndex();
        }
        return 0;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public int getCurrentAudioIndex() {
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter != null) {
            return iMediaPlayAdapter.getCurrentAudioIndex();
        }
        return 0;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public int[] getAudioStreamsIndex() {
        int[] audioStreamsIndex;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        return (iMediaPlayAdapter == null || (audioStreamsIndex = iMediaPlayAdapter.getAudioStreamsIndex()) == null) ? new int[0] : audioStreamsIndex;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public int setAudioIndex(int index) {
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter != null) {
            return iMediaPlayAdapter.setAudioIndex(index);
        }
        return -1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext
    public int getCurrentState() {
        return this.mCurrentState;
    }

    @Override // tv.danmaku.videoplayer.core.share.SharableObject
    public void detachByShared() {
        IjkMediaPlayerItem realMediaItem;
        IMediaPlayAdapter iMediaPlayAdapter;
        PlayerLog.i(TAG, "detach-by-shared");
        super.detachByShared();
        IMediaPlayAdapter iMediaPlayAdapter2 = this.mCurrentMediaPlayAdapter;
        if ((iMediaPlayAdapter2 != null ? Intrinsics.areEqual(iMediaPlayAdapter2.invokeOp(IMediaPlayAdapter.Ops.SupportWholeScene, null), true) : false) && (iMediaPlayAdapter = this.mCurrentMediaPlayAdapter) != null) {
            iMediaPlayAdapter.invokeOp(IMediaPlayAdapter.Ops.ExitWholeScene, null);
        }
        IMediaPlayAdapter iMediaPlayAdapter3 = this.mCurrentMediaPlayAdapter;
        IMediaPlayRenderContext mediaPlayRenderContext = iMediaPlayAdapter3 != null ? iMediaPlayAdapter3.getMediaPlayRenderContext() : null;
        IMediaPlayRenderAdapter renderAdapter = mediaPlayRenderContext instanceof IMediaPlayRenderAdapter ? (IMediaPlayRenderAdapter) mediaPlayRenderContext : null;
        if (renderAdapter != null) {
            renderAdapter.unbindContext();
        }
        setOnCompletionListener(null);
        setOnBufferingUpdateListener(null);
        setOnPreparedListener(null);
        setFirstFrameListener(null);
        setOnErrorListener(null);
        setOnInfoListener(null);
        setOnSeekComplete(null);
        setPlayerClockChangedListener(null);
        setOnVideoSizeChangedListener(null);
        setOnExtraInfoListener(null);
        setOnMediaStreamChangedListener(null);
        setOnRawDataWriteListener(null);
        setOnVideoDisplayCallback(null);
        MediaItem mediaItem = this.mCurrentMediaItem;
        if (!(mediaItem instanceof IjkMediaItem) || (realMediaItem = ((IjkMediaItem) mediaItem).realMediaItem()) == null) {
            return;
        }
        realMediaItem.setAssetUpdateListener(null);
    }

    @Override // tv.danmaku.videoplayer.core.share.SharableObject
    public void attachByShared() {
        IMediaPlayer player;
        super.attachByShared();
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (player = iMediaPlayAdapter.getMediaPlayer()) == null) {
            return;
        }
        IMediaPlayParams iMediaPlayParams = this.mMediaPlayParams;
        IMediaPlayParams iMediaPlayParams2 = null;
        if (iMediaPlayParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
            iMediaPlayParams = null;
        }
        if (iMediaPlayParams.playerType() == PlayerType.Exclusive) {
            MediaCenter.INSTANCE.markPlayerAsExclusive(player);
            return;
        }
        MediaCenter mediaCenter = MediaCenter.INSTANCE;
        IMediaPlayParams iMediaPlayParams3 = this.mMediaPlayParams;
        if (iMediaPlayParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayParams");
        } else {
            iMediaPlayParams2 = iMediaPlayParams3;
        }
        mediaCenter.removePlayerExclusiveMark(player, iMediaPlayParams2.playerType());
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setEnhance(boolean enable, IJKEXTRendererInterface.IjkEnhanceType type) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(type, "type");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setEnhance(enable, type);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setBlurRectList(List<? extends RectF> list) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        List rectList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(rectList, "rectList");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setBlurRectList(rectList);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void clearBlurRect() {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.clearBlurRect();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setEnableMultiRender(boolean isEnable) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setEnableMultiRender(isEnable);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setMultiMainCaptureRect(RectF rect) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(rect, "rect");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setMultiMainCaptureRect(rect);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setMultiSubWindowSurface(Surface surface) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setMultiSubWindowSurface(surface);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setMultiSubWindowCaptureRect(RectF rect) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(rect, "rect");
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setMultiSubWindowCaptureRect(rect);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setOnFrameRendererListener(IJKEXTRendererInterface.OnFrameRenderedListener listener) {
        IMediaPlayRenderContext mediaPlayRenderContext;
        this.mOnFrameRenderedListener = listener;
        IMediaPlayAdapter iMediaPlayAdapter = this.mCurrentMediaPlayAdapter;
        if (iMediaPlayAdapter == null || (mediaPlayRenderContext = iMediaPlayAdapter.getMediaPlayRenderContext()) == null) {
            return;
        }
        mediaPlayRenderContext.setOnFrameRendererListener(listener);
    }

    public final boolean isInitialed() {
        if (this.mInitialed) {
            return true;
        }
        PlayerLog.e(TAG, "this mediaPlayContext(" + this + ") is not initialed");
        return false;
    }

    /* compiled from: MediaPlayContextImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaPlayContextImpl$Clock;", "", "<init>", "()V", "mRate", "", "mPosition", "", "mLastUpdateTime", "update", "", "rate", "position", "currentPosition", "clear", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Clock {
        private volatile long mLastUpdateTime;
        private volatile long mPosition;
        private volatile float mRate;

        public final void update(float rate, long position) {
            this.mLastUpdateTime = SystemClock.elapsedRealtime();
            this.mRate = rate;
            this.mPosition = position;
        }

        public final long currentPosition() {
            if (this.mLastUpdateTime == 0) {
                return 0L;
            }
            long res = ((float) this.mPosition) + (((float) (SystemClock.elapsedRealtime() - this.mLastUpdateTime)) * this.mRate);
            return Math.max(res, 0L);
        }

        public final void clear() {
            this.mRate = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            this.mPosition = 0L;
            this.mLastUpdateTime = 0L;
        }
    }
}