package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: SplashGuideButton.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bk\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010&\u001a\u00020\u001d\u0012\b\b\u0002\u0010'\u001a\u00020\u001d\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u0012\b\b\u0002\u00100\u001a\u00020\u001d\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u00103\u001a\u00020\u001d\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u0017¢\u0006\u0004\b6\u00107J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017HÆ\u0003J\u0012\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u001dHÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u001dHÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u001dHÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u001dHÆ\u0003J\u0012\u0010\u009e\u0001\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u0017HÆ\u0003J\u0096\u0004\u0010\u009f\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010 \u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010&\u001a\u00020\u001d2\b\b\u0002\u0010'\u001a\u00020\u001d2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u001d2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00103\u001a\u00020\u001d2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u0017HÆ\u0001J\u0016\u0010 \u0001\u001a\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010£\u0001\u001a\u00020\u001dHÖ\u0001J\n\u0010¤\u0001\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010>R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010>R\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010>R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010;R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010;R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010>R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010>R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010>R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010MR\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010;R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010>R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010>R\u0016\u0010\u001c\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010>R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010>R\u0016\u0010 \u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010>R\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010>R\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010>R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010>R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010>R\u0016\u0010&\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010SR\u0016\u0010'\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010SR\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010>R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010>R\u0016\u0010*\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010;R\u0016\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010;R\u0016\u0010,\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010;R\u0018\u0010-\u001a\u0004\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0016\u0010/\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u00109R\u0016\u00100\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010SR\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010>R\u0018\u00102\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010>R\u0016\u00103\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010SR\u001e\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010MR\u001c\u0010k\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010>\"\u0004\bm\u0010nR\u001c\u0010o\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010>\"\u0004\bq\u0010n¨\u0006¥\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "", "id", "", "x", "", "y", "bgColor", "", "textColor", "secondaryTextColor", "guideInstructions", "secondaryGuideInstructions", "guideInstructionsNew", "width", "height", "fontRatio", "jumpUrl", "schema", "schemaTitle", "schemaTitleNew", "schemaPackageName", "schemaList", "", "relatedIds", "slideThreshold", "sideBorderColor", "guideImageUrl", "interactStyle", "", "jumpImageUrl", "schemaImageUrl", "expandRatio", "logoUrl", "logoImageMD5", "guideImageMD5", "jumpImageMD5", "schemaImageMD5", "guideMaterialType", "extInteractStyle", "brandCardTitle", "brandCardDesc", "twistSpeed", "twistAngle", "twistReverseAngle", "twistStrategy", "Ltv/danmaku/bili/splash/ad/model/SplashTwistStrategy;", "activityTime", "timeShowType", "sideHoleBgColor", "sideHoleBorderColor", "degradeType", "shopCards", "Ltv/danmaku/bili/splash/ad/model/SplashShopCard;", "<init>", "(JFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;FLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;FFFLtv/danmaku/bili/splash/ad/model/SplashTwistStrategy;JILjava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getId", "()J", "getX", "()F", "getY", "getBgColor", "()Ljava/lang/String;", "getTextColor", "getSecondaryTextColor", "getGuideInstructions", "getSecondaryGuideInstructions", "getGuideInstructionsNew", "getWidth", "getHeight", "getFontRatio", "getJumpUrl", "getSchema", "getSchemaTitle", "getSchemaTitleNew", "getSchemaPackageName", "getSchemaList", "()Ljava/util/List;", "getRelatedIds", "getSlideThreshold", "getSideBorderColor", "getGuideImageUrl", "getInteractStyle", "()I", "getJumpImageUrl", "getSchemaImageUrl", "getExpandRatio", "getLogoUrl", "getLogoImageMD5", "getGuideImageMD5", "getJumpImageMD5", "getSchemaImageMD5", "getGuideMaterialType", "getExtInteractStyle", "getBrandCardTitle", "getBrandCardDesc", "getTwistSpeed", "getTwistAngle", "getTwistReverseAngle", "getTwistStrategy", "()Ltv/danmaku/bili/splash/ad/model/SplashTwistStrategy;", "getActivityTime", "getTimeShowType", "getSideHoleBgColor", "getSideHoleBorderColor", "getDegradeType", "getShopCards", "actualUsedImageUrl", "getActualUsedImageUrl", "setActualUsedImageUrl", "(Ljava/lang/String;)V", "actualUsedImageHash", "getActualUsedImageHash", "setActualUsedImageHash", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "copy", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashGuideButton {
    public static final int $stable = 8;
    @SerializedName("activity_time")
    private final long activityTime;
    private transient String actualUsedImageHash;
    private transient String actualUsedImageUrl;
    @SerializedName("bg_color")
    private final String bgColor;
    @SerializedName("brand_card_desc")
    private final String brandCardDesc;
    @SerializedName("brand_card_title")
    private final String brandCardTitle;
    @SerializedName("degrade_type")
    private final int degradeType;
    @SerializedName("click_expand_ratio")
    private final float expandRatio;
    @SerializedName("ext_interact_style")
    private final int extInteractStyle;
    @SerializedName("font_ratio")
    private final float fontRatio;
    @SerializedName("guide_image_md5")
    private final String guideImageMD5;
    @SerializedName("guide_image_url")
    private final String guideImageUrl;
    @SerializedName("guide_instructions")
    private final String guideInstructions;
    @SerializedName("guide_instructions_new")
    private final String guideInstructionsNew;
    @SerializedName("guide_material_type")
    private final int guideMaterialType;
    @SerializedName("height")
    private final float height;
    @SerializedName("id")
    private final long id;
    @SerializedName("interact_style")
    private final int interactStyle;
    @SerializedName("jump_image_md5")
    private final String jumpImageMD5;
    @SerializedName("jump_image_url")
    private final String jumpImageUrl;
    @SerializedName("jump_url")
    private final String jumpUrl;
    @SerializedName("logo_image_md5")
    private final String logoImageMD5;
    @SerializedName("logo_image_url")
    private final String logoUrl;
    @SerializedName("related_ids")
    private final List<Long> relatedIds;
    @SerializedName("schema")
    private final String schema;
    @SerializedName("schema_image_md5")
    private final String schemaImageMD5;
    @SerializedName("schema_image_url")
    private final String schemaImageUrl;
    @SerializedName("schema_list")
    private final List<String> schemaList;
    @SerializedName("schema_package_name")
    private final String schemaPackageName;
    @SerializedName("schema_title")
    private final String schemaTitle;
    @SerializedName("schema_title_new")
    private final String schemaTitleNew;
    @SerializedName("secondary_guide_instructions")
    private final String secondaryGuideInstructions;
    @SerializedName("secondary_text_color")
    private final String secondaryTextColor;
    @SerializedName("cards")
    private final List<SplashShopCard> shopCards;
    @SerializedName("slide_border_color")
    private final String sideBorderColor;
    @SerializedName("slide_ball_bg_color")
    private final String sideHoleBgColor;
    @SerializedName("slide_ball_border_color")
    private final String sideHoleBorderColor;
    @SerializedName("slide_threshold_value")
    private final float slideThreshold;
    @SerializedName("text_color")
    private final String textColor;
    @SerializedName("time_show_type")
    private final int timeShowType;
    @SerializedName("twist_angle")
    private final float twistAngle;
    @SerializedName("twist_reverse_angle")
    private final float twistReverseAngle;
    @SerializedName("twist_speed")
    private final float twistSpeed;
    @SerializedName("twist_strategy")
    private final SplashTwistStrategy twistStrategy;
    @SerializedName("width")
    private final float width;
    @SerializedName("x")
    private final float x;
    @SerializedName("y")
    private final float y;

    public SplashGuideButton() {
        this(0L, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, 0.0f, null, null, 0, null, null, 0.0f, null, null, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, null, 0L, 0, null, null, 0, null, -1, 8191, null);
    }

    public final long component1() {
        return this.id;
    }

    public final float component10() {
        return this.width;
    }

    public final float component11() {
        return this.height;
    }

    public final float component12() {
        return this.fontRatio;
    }

    public final String component13() {
        return this.jumpUrl;
    }

    public final String component14() {
        return this.schema;
    }

    public final String component15() {
        return this.schemaTitle;
    }

    public final String component16() {
        return this.schemaTitleNew;
    }

    public final String component17() {
        return this.schemaPackageName;
    }

    public final List<String> component18() {
        return this.schemaList;
    }

    public final List<Long> component19() {
        return this.relatedIds;
    }

    public final float component2() {
        return this.x;
    }

    public final float component20() {
        return this.slideThreshold;
    }

    public final String component21() {
        return this.sideBorderColor;
    }

    public final String component22() {
        return this.guideImageUrl;
    }

    public final int component23() {
        return this.interactStyle;
    }

    public final String component24() {
        return this.jumpImageUrl;
    }

    public final String component25() {
        return this.schemaImageUrl;
    }

    public final float component26() {
        return this.expandRatio;
    }

    public final String component27() {
        return this.logoUrl;
    }

    public final String component28() {
        return this.logoImageMD5;
    }

    public final String component29() {
        return this.guideImageMD5;
    }

    public final float component3() {
        return this.y;
    }

    public final String component30() {
        return this.jumpImageMD5;
    }

    public final String component31() {
        return this.schemaImageMD5;
    }

    public final int component32() {
        return this.guideMaterialType;
    }

    public final int component33() {
        return this.extInteractStyle;
    }

    public final String component34() {
        return this.brandCardTitle;
    }

    public final String component35() {
        return this.brandCardDesc;
    }

    public final float component36() {
        return this.twistSpeed;
    }

    public final float component37() {
        return this.twistAngle;
    }

    public final float component38() {
        return this.twistReverseAngle;
    }

    public final SplashTwistStrategy component39() {
        return this.twistStrategy;
    }

    public final String component4() {
        return this.bgColor;
    }

    public final long component40() {
        return this.activityTime;
    }

    public final int component41() {
        return this.timeShowType;
    }

    public final String component42() {
        return this.sideHoleBgColor;
    }

    public final String component43() {
        return this.sideHoleBorderColor;
    }

    public final int component44() {
        return this.degradeType;
    }

    public final List<SplashShopCard> component45() {
        return this.shopCards;
    }

    public final String component5() {
        return this.textColor;
    }

    public final String component6() {
        return this.secondaryTextColor;
    }

    public final String component7() {
        return this.guideInstructions;
    }

    public final String component8() {
        return this.secondaryGuideInstructions;
    }

    public final String component9() {
        return this.guideInstructionsNew;
    }

    public final SplashGuideButton copy(long j, float f, float f2, String str, String str2, String str3, String str4, String str5, String str6, float f3, float f4, float f5, String str7, String str8, String str9, String str10, String str11, List<String> list, List<Long> list2, float f6, String str12, String str13, int i, String str14, String str15, float f7, String str16, String str17, String str18, String str19, String str20, int i2, int i3, String str21, String str22, float f8, float f9, float f10, SplashTwistStrategy splashTwistStrategy, long j2, int i4, String str23, String str24, int i5, List<SplashShopCard> list3) {
        return new SplashGuideButton(j, f, f2, str, str2, str3, str4, str5, str6, f3, f4, f5, str7, str8, str9, str10, str11, list, list2, f6, str12, str13, i, str14, str15, f7, str16, str17, str18, str19, str20, i2, i3, str21, str22, f8, f9, f10, splashTwistStrategy, j2, i4, str23, str24, i5, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashGuideButton) {
            SplashGuideButton splashGuideButton = (SplashGuideButton) obj;
            return this.id == splashGuideButton.id && Float.compare(this.x, splashGuideButton.x) == 0 && Float.compare(this.y, splashGuideButton.y) == 0 && Intrinsics.areEqual(this.bgColor, splashGuideButton.bgColor) && Intrinsics.areEqual(this.textColor, splashGuideButton.textColor) && Intrinsics.areEqual(this.secondaryTextColor, splashGuideButton.secondaryTextColor) && Intrinsics.areEqual(this.guideInstructions, splashGuideButton.guideInstructions) && Intrinsics.areEqual(this.secondaryGuideInstructions, splashGuideButton.secondaryGuideInstructions) && Intrinsics.areEqual(this.guideInstructionsNew, splashGuideButton.guideInstructionsNew) && Float.compare(this.width, splashGuideButton.width) == 0 && Float.compare(this.height, splashGuideButton.height) == 0 && Float.compare(this.fontRatio, splashGuideButton.fontRatio) == 0 && Intrinsics.areEqual(this.jumpUrl, splashGuideButton.jumpUrl) && Intrinsics.areEqual(this.schema, splashGuideButton.schema) && Intrinsics.areEqual(this.schemaTitle, splashGuideButton.schemaTitle) && Intrinsics.areEqual(this.schemaTitleNew, splashGuideButton.schemaTitleNew) && Intrinsics.areEqual(this.schemaPackageName, splashGuideButton.schemaPackageName) && Intrinsics.areEqual(this.schemaList, splashGuideButton.schemaList) && Intrinsics.areEqual(this.relatedIds, splashGuideButton.relatedIds) && Float.compare(this.slideThreshold, splashGuideButton.slideThreshold) == 0 && Intrinsics.areEqual(this.sideBorderColor, splashGuideButton.sideBorderColor) && Intrinsics.areEqual(this.guideImageUrl, splashGuideButton.guideImageUrl) && this.interactStyle == splashGuideButton.interactStyle && Intrinsics.areEqual(this.jumpImageUrl, splashGuideButton.jumpImageUrl) && Intrinsics.areEqual(this.schemaImageUrl, splashGuideButton.schemaImageUrl) && Float.compare(this.expandRatio, splashGuideButton.expandRatio) == 0 && Intrinsics.areEqual(this.logoUrl, splashGuideButton.logoUrl) && Intrinsics.areEqual(this.logoImageMD5, splashGuideButton.logoImageMD5) && Intrinsics.areEqual(this.guideImageMD5, splashGuideButton.guideImageMD5) && Intrinsics.areEqual(this.jumpImageMD5, splashGuideButton.jumpImageMD5) && Intrinsics.areEqual(this.schemaImageMD5, splashGuideButton.schemaImageMD5) && this.guideMaterialType == splashGuideButton.guideMaterialType && this.extInteractStyle == splashGuideButton.extInteractStyle && Intrinsics.areEqual(this.brandCardTitle, splashGuideButton.brandCardTitle) && Intrinsics.areEqual(this.brandCardDesc, splashGuideButton.brandCardDesc) && Float.compare(this.twistSpeed, splashGuideButton.twistSpeed) == 0 && Float.compare(this.twistAngle, splashGuideButton.twistAngle) == 0 && Float.compare(this.twistReverseAngle, splashGuideButton.twistReverseAngle) == 0 && Intrinsics.areEqual(this.twistStrategy, splashGuideButton.twistStrategy) && this.activityTime == splashGuideButton.activityTime && this.timeShowType == splashGuideButton.timeShowType && Intrinsics.areEqual(this.sideHoleBgColor, splashGuideButton.sideHoleBgColor) && Intrinsics.areEqual(this.sideHoleBorderColor, splashGuideButton.sideHoleBorderColor) && this.degradeType == splashGuideButton.degradeType && Intrinsics.areEqual(this.shopCards, splashGuideButton.shopCards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + (this.bgColor == null ? 0 : this.bgColor.hashCode())) * 31) + (this.textColor == null ? 0 : this.textColor.hashCode())) * 31) + (this.secondaryTextColor == null ? 0 : this.secondaryTextColor.hashCode())) * 31) + (this.guideInstructions == null ? 0 : this.guideInstructions.hashCode())) * 31) + (this.secondaryGuideInstructions == null ? 0 : this.secondaryGuideInstructions.hashCode())) * 31) + (this.guideInstructionsNew == null ? 0 : this.guideInstructionsNew.hashCode())) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.fontRatio)) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.schema == null ? 0 : this.schema.hashCode())) * 31) + (this.schemaTitle == null ? 0 : this.schemaTitle.hashCode())) * 31) + (this.schemaTitleNew == null ? 0 : this.schemaTitleNew.hashCode())) * 31) + (this.schemaPackageName == null ? 0 : this.schemaPackageName.hashCode())) * 31) + (this.schemaList == null ? 0 : this.schemaList.hashCode())) * 31) + (this.relatedIds == null ? 0 : this.relatedIds.hashCode())) * 31) + Float.floatToIntBits(this.slideThreshold)) * 31) + (this.sideBorderColor == null ? 0 : this.sideBorderColor.hashCode())) * 31) + (this.guideImageUrl == null ? 0 : this.guideImageUrl.hashCode())) * 31) + this.interactStyle) * 31) + (this.jumpImageUrl == null ? 0 : this.jumpImageUrl.hashCode())) * 31) + (this.schemaImageUrl == null ? 0 : this.schemaImageUrl.hashCode())) * 31) + Float.floatToIntBits(this.expandRatio)) * 31) + (this.logoUrl == null ? 0 : this.logoUrl.hashCode())) * 31) + (this.logoImageMD5 == null ? 0 : this.logoImageMD5.hashCode())) * 31) + (this.guideImageMD5 == null ? 0 : this.guideImageMD5.hashCode())) * 31) + (this.jumpImageMD5 == null ? 0 : this.jumpImageMD5.hashCode())) * 31) + (this.schemaImageMD5 == null ? 0 : this.schemaImageMD5.hashCode())) * 31) + this.guideMaterialType) * 31) + this.extInteractStyle) * 31) + (this.brandCardTitle == null ? 0 : this.brandCardTitle.hashCode())) * 31) + (this.brandCardDesc == null ? 0 : this.brandCardDesc.hashCode())) * 31) + Float.floatToIntBits(this.twistSpeed)) * 31) + Float.floatToIntBits(this.twistAngle)) * 31) + Float.floatToIntBits(this.twistReverseAngle)) * 31) + (this.twistStrategy == null ? 0 : this.twistStrategy.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.activityTime)) * 31) + this.timeShowType) * 31) + (this.sideHoleBgColor == null ? 0 : this.sideHoleBgColor.hashCode())) * 31) + (this.sideHoleBorderColor == null ? 0 : this.sideHoleBorderColor.hashCode())) * 31) + this.degradeType) * 31) + (this.shopCards != null ? this.shopCards.hashCode() : 0);
    }

    public String toString() {
        long j = this.id;
        float f = this.x;
        float f2 = this.y;
        String str = this.bgColor;
        String str2 = this.textColor;
        String str3 = this.secondaryTextColor;
        String str4 = this.guideInstructions;
        String str5 = this.secondaryGuideInstructions;
        String str6 = this.guideInstructionsNew;
        float f3 = this.width;
        float f4 = this.height;
        float f5 = this.fontRatio;
        String str7 = this.jumpUrl;
        String str8 = this.schema;
        String str9 = this.schemaTitle;
        String str10 = this.schemaTitleNew;
        String str11 = this.schemaPackageName;
        List<String> list = this.schemaList;
        List<Long> list2 = this.relatedIds;
        float f6 = this.slideThreshold;
        String str12 = this.sideBorderColor;
        String str13 = this.guideImageUrl;
        int i = this.interactStyle;
        String str14 = this.jumpImageUrl;
        String str15 = this.schemaImageUrl;
        float f7 = this.expandRatio;
        String str16 = this.logoUrl;
        String str17 = this.logoImageMD5;
        String str18 = this.guideImageMD5;
        String str19 = this.jumpImageMD5;
        String str20 = this.schemaImageMD5;
        int i2 = this.guideMaterialType;
        int i3 = this.extInteractStyle;
        String str21 = this.brandCardTitle;
        String str22 = this.brandCardDesc;
        float f8 = this.twistSpeed;
        float f9 = this.twistAngle;
        float f10 = this.twistReverseAngle;
        SplashTwistStrategy splashTwistStrategy = this.twistStrategy;
        long j2 = this.activityTime;
        int i4 = this.timeShowType;
        String str23 = this.sideHoleBgColor;
        String str24 = this.sideHoleBorderColor;
        int i5 = this.degradeType;
        return "SplashGuideButton(id=" + j + ", x=" + f + ", y=" + f2 + ", bgColor=" + str + ", textColor=" + str2 + ", secondaryTextColor=" + str3 + ", guideInstructions=" + str4 + ", secondaryGuideInstructions=" + str5 + ", guideInstructionsNew=" + str6 + ", width=" + f3 + ", height=" + f4 + ", fontRatio=" + f5 + ", jumpUrl=" + str7 + ", schema=" + str8 + ", schemaTitle=" + str9 + ", schemaTitleNew=" + str10 + ", schemaPackageName=" + str11 + ", schemaList=" + list + ", relatedIds=" + list2 + ", slideThreshold=" + f6 + ", sideBorderColor=" + str12 + ", guideImageUrl=" + str13 + ", interactStyle=" + i + ", jumpImageUrl=" + str14 + ", schemaImageUrl=" + str15 + ", expandRatio=" + f7 + ", logoUrl=" + str16 + ", logoImageMD5=" + str17 + ", guideImageMD5=" + str18 + ", jumpImageMD5=" + str19 + ", schemaImageMD5=" + str20 + ", guideMaterialType=" + i2 + ", extInteractStyle=" + i3 + ", brandCardTitle=" + str21 + ", brandCardDesc=" + str22 + ", twistSpeed=" + f8 + ", twistAngle=" + f9 + ", twistReverseAngle=" + f10 + ", twistStrategy=" + splashTwistStrategy + ", activityTime=" + j2 + ", timeShowType=" + i4 + ", sideHoleBgColor=" + str23 + ", sideHoleBorderColor=" + str24 + ", degradeType=" + i5 + ", shopCards=" + this.shopCards + ")";
    }

    public SplashGuideButton(long id, float x, float y, String bgColor, String textColor, String secondaryTextColor, String guideInstructions, String secondaryGuideInstructions, String guideInstructionsNew, float width, float height, float fontRatio, String jumpUrl, String schema, String schemaTitle, String schemaTitleNew, String schemaPackageName, List<String> list, List<Long> list2, float slideThreshold, String sideBorderColor, String guideImageUrl, int interactStyle, String jumpImageUrl, String schemaImageUrl, float expandRatio, String logoUrl, String logoImageMD5, String guideImageMD5, String jumpImageMD5, String schemaImageMD5, int guideMaterialType, int extInteractStyle, String brandCardTitle, String brandCardDesc, float twistSpeed, float twistAngle, float twistReverseAngle, SplashTwistStrategy twistStrategy, long activityTime, int timeShowType, String sideHoleBgColor, String sideHoleBorderColor, int degradeType, List<SplashShopCard> list3) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.secondaryTextColor = secondaryTextColor;
        this.guideInstructions = guideInstructions;
        this.secondaryGuideInstructions = secondaryGuideInstructions;
        this.guideInstructionsNew = guideInstructionsNew;
        this.width = width;
        this.height = height;
        this.fontRatio = fontRatio;
        this.jumpUrl = jumpUrl;
        this.schema = schema;
        this.schemaTitle = schemaTitle;
        this.schemaTitleNew = schemaTitleNew;
        this.schemaPackageName = schemaPackageName;
        this.schemaList = list;
        this.relatedIds = list2;
        this.slideThreshold = slideThreshold;
        this.sideBorderColor = sideBorderColor;
        this.guideImageUrl = guideImageUrl;
        this.interactStyle = interactStyle;
        this.jumpImageUrl = jumpImageUrl;
        this.schemaImageUrl = schemaImageUrl;
        this.expandRatio = expandRatio;
        this.logoUrl = logoUrl;
        this.logoImageMD5 = logoImageMD5;
        this.guideImageMD5 = guideImageMD5;
        this.jumpImageMD5 = jumpImageMD5;
        this.schemaImageMD5 = schemaImageMD5;
        this.guideMaterialType = guideMaterialType;
        this.extInteractStyle = extInteractStyle;
        this.brandCardTitle = brandCardTitle;
        this.brandCardDesc = brandCardDesc;
        this.twistSpeed = twistSpeed;
        this.twistAngle = twistAngle;
        this.twistReverseAngle = twistReverseAngle;
        this.twistStrategy = twistStrategy;
        this.activityTime = activityTime;
        this.timeShowType = timeShowType;
        this.sideHoleBgColor = sideHoleBgColor;
        this.sideHoleBorderColor = sideHoleBorderColor;
        this.degradeType = degradeType;
        this.shopCards = list3;
    }

    public /* synthetic */ SplashGuideButton(long j, float f, float f2, String str, String str2, String str3, String str4, String str5, String str6, float f3, float f4, float f5, String str7, String str8, String str9, String str10, String str11, List list, List list2, float f6, String str12, String str13, int i, String str14, String str15, float f7, String str16, String str17, String str18, String str19, String str20, int i2, int i3, String str21, String str22, float f8, float f9, float f10, SplashTwistStrategy splashTwistStrategy, long j2, int i4, String str23, String str24, int i5, List list3, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0L : j, (i6 & 2) != 0 ? 0.0f : f, (i6 & 4) != 0 ? 0.0f : f2, (i6 & 8) != 0 ? null : str, (i6 & 16) != 0 ? null : str2, (i6 & 32) != 0 ? null : str3, (i6 & 64) != 0 ? null : str4, (i6 & BR.cover) != 0 ? null : str5, (i6 & BR.hallEnterHotText) != 0 ? null : str6, (i6 & BR.roleType) != 0 ? 0.0f : f3, (i6 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? 0.0f : f4, (i6 & 2048) != 0 ? 0.22f : f5, (i6 & 4096) != 0 ? null : str7, (i6 & 8192) != 0 ? null : str8, (i6 & RingBuffer.CONSUME_SIZE) != 0 ? null : str9, (i6 & 32768) != 0 ? null : str10, (i6 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? null : str11, (i6 & 131072) != 0 ? null : list, (i6 & 262144) != 0 ? null : list2, (i6 & 524288) != 0 ? 0.0f : f6, (i6 & 1048576) != 0 ? null : str12, (i6 & 2097152) != 0 ? null : str13, (i6 & 4194304) != 0 ? 0 : i, (i6 & 8388608) != 0 ? null : str14, (i6 & 16777216) != 0 ? null : str15, (i6 & 33554432) != 0 ? 0.0f : f7, (i6 & 67108864) != 0 ? null : str16, (i6 & 134217728) != 0 ? null : str17, (i6 & 268435456) != 0 ? null : str18, (i6 & 536870912) != 0 ? null : str19, (i6 & 1073741824) != 0 ? null : str20, (i6 & Integer.MIN_VALUE) != 0 ? 0 : i2, (i7 & 1) != 0 ? 0 : i3, (i7 & 2) != 0 ? null : str21, (i7 & 4) != 0 ? null : str22, (i7 & 8) != 0 ? -1.0f : f8, (i7 & 16) == 0 ? f9 : -1.0f, (i7 & 32) != 0 ? 0.0f : f10, (i7 & 64) != 0 ? null : splashTwistStrategy, (i7 & BR.cover) != 0 ? 0L : j2, (i7 & BR.hallEnterHotText) != 0 ? 0 : i4, (i7 & BR.roleType) != 0 ? null : str23, (i7 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? null : str24, (i7 & 2048) == 0 ? i5 : 0, (i7 & 4096) != 0 ? null : list3);
    }

    public final long getId() {
        return this.id;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getSecondaryTextColor() {
        return this.secondaryTextColor;
    }

    public final String getGuideInstructions() {
        return this.guideInstructions;
    }

    public final String getSecondaryGuideInstructions() {
        return this.secondaryGuideInstructions;
    }

    public final String getGuideInstructionsNew() {
        return this.guideInstructionsNew;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getFontRatio() {
        return this.fontRatio;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSchemaTitle() {
        return this.schemaTitle;
    }

    public final String getSchemaTitleNew() {
        return this.schemaTitleNew;
    }

    public final String getSchemaPackageName() {
        return this.schemaPackageName;
    }

    public final List<String> getSchemaList() {
        return this.schemaList;
    }

    public final List<Long> getRelatedIds() {
        return this.relatedIds;
    }

    public final float getSlideThreshold() {
        return this.slideThreshold;
    }

    public final String getSideBorderColor() {
        return this.sideBorderColor;
    }

    public final String getGuideImageUrl() {
        return this.guideImageUrl;
    }

    public final int getInteractStyle() {
        return this.interactStyle;
    }

    public final String getJumpImageUrl() {
        return this.jumpImageUrl;
    }

    public final String getSchemaImageUrl() {
        return this.schemaImageUrl;
    }

    public final float getExpandRatio() {
        return this.expandRatio;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getLogoImageMD5() {
        return this.logoImageMD5;
    }

    public final String getGuideImageMD5() {
        return this.guideImageMD5;
    }

    public final String getJumpImageMD5() {
        return this.jumpImageMD5;
    }

    public final String getSchemaImageMD5() {
        return this.schemaImageMD5;
    }

    public final int getGuideMaterialType() {
        return this.guideMaterialType;
    }

    public final int getExtInteractStyle() {
        return this.extInteractStyle;
    }

    public final String getBrandCardTitle() {
        return this.brandCardTitle;
    }

    public final String getBrandCardDesc() {
        return this.brandCardDesc;
    }

    public final float getTwistSpeed() {
        return this.twistSpeed;
    }

    public final float getTwistAngle() {
        return this.twistAngle;
    }

    public final float getTwistReverseAngle() {
        return this.twistReverseAngle;
    }

    public final SplashTwistStrategy getTwistStrategy() {
        return this.twistStrategy;
    }

    public final long getActivityTime() {
        return this.activityTime;
    }

    public final int getTimeShowType() {
        return this.timeShowType;
    }

    public final String getSideHoleBgColor() {
        return this.sideHoleBgColor;
    }

    public final String getSideHoleBorderColor() {
        return this.sideHoleBorderColor;
    }

    public final int getDegradeType() {
        return this.degradeType;
    }

    public final List<SplashShopCard> getShopCards() {
        return this.shopCards;
    }

    public final String getActualUsedImageUrl() {
        return this.actualUsedImageUrl;
    }

    public final void setActualUsedImageUrl(String str) {
        this.actualUsedImageUrl = str;
    }

    public final String getActualUsedImageHash() {
        return this.actualUsedImageHash;
    }

    public final void setActualUsedImageHash(String str) {
        this.actualUsedImageHash = str;
    }
}