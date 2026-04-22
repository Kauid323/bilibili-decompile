package tv.danmaku.bili.videopage.common.helper;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bilibili.app.comm.supermenu.report.SuperMenuReportHelper;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONObject;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: VideoDetailReporter.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\bB\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b;\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0084\u0002\u0085\u0002B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J0\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0015J*\u0010\u0016\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\r\u001a\u00020\u0015H\u0007J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0015H\u0007J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0015H\u0007J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0007J \u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0007J(\u0010(\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0007J \u0010+\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020$H\u0007J0\u0010.\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010)\u001a\u00020$2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0007J0\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010)\u001a\u00020$2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020-H\u0007J&\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0005J\u000e\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0005J2\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005J2\u0010?\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u000bJ\u0006\u0010A\u001a\u00020\u000bJ\u0016\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005JÔ\u0001\u0010E\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\u00152\b\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u00152\b\u0010Q\u001a\u0004\u0018\u00010\u00052\b\u0010R\u001a\u0004\u0018\u00010\u00052\u0006\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020$2\b\b\u0002\u0010Z\u001a\u00020\u00152\b\b\u0002\u0010[\u001a\u00020\u00052\b\b\u0002\u0010\\\u001a\u00020-JÔ\u0001\u0010]\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\u00152\b\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u00152\b\u0010Q\u001a\u0004\u0018\u00010\u00052\u0006\u0010^\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u00052\u0006\u0010T\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020$2\b\b\u0002\u0010Z\u001a\u00020\u00152\b\b\u0002\u0010[\u001a\u00020\u00052\b\b\u0002\u0010\\\u001a\u00020-J,\u0010_\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010Y\u001a\u00020$2\b\b\u0002\u0010Z\u001a\u00020\u0015J\u0016\u0010`\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u0005J(\u0010b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u00052\b\u0010c\u001a\u0004\u0018\u00010\u0005J>\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u0005J>\u0010j\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u0005J>\u0010k\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020-J\u000e\u0010n\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020pJ\u001e\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010s\u001a\u00020$J\u001e\u0010t\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020$2\u0006\u0010v\u001a\u00020\u00052\u0006\u0010o\u001a\u00020pJ\u001e\u0010w\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020$2\u0006\u0010v\u001a\u00020\u00052\u0006\u0010o\u001a\u00020pJ\u0006\u0010x\u001a\u00020\u000bJ\u0006\u0010y\u001a\u00020\u000bJ\u000e\u0010z\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u0005J\u0010\u0010{\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\b\u0010|\u001a\u00020\u000bH\u0007J\u001c\u0010}\u001a\u00020\u000b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010~\u001a\u00020-J\u0012\u0010\u007f\u001a\u00020\u000b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005J6\u0010\u0080\u0001\u001a\u00020\u000b2\u0007\u0010\u0081\u0001\u001a\u00020-2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0082\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0083\u0001J$\u0010\u0084\u0001\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u00152\u0007\u0010\u0085\u0001\u001a\u00020-2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0086\u0001\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020$J8\u0010\u0088\u0001\u001a\u00020\u000b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u008a\u0001\u001a\u00020$2\b\u0010H\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u008b\u0001\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010\u0005J7\u0010\u008c\u0001\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u00052\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010a\u001a\u0004\u0018\u00010\u00052\b\u0010H\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0015J:\u0010\u008d\u0001\u001a\u00020\u000b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010a\u001a\u0004\u0018\u00010\u00052\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0090\u0001\u001a\u00020\u0015J+\u0010\u0091\u0001\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u00020$2\b\u0010a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0015J-\u0010\u0092\u0001\u001a\u00020\u000b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u00020$2\b\u0010a\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0090\u0001\u001a\u00020\u0015J<\u0010\u0093\u0001\u001a\u00020\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J<\u0010\u0097\u0001\u001a\u00020\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J<\u0010\u0099\u0001\u001a\u00020\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J<\u0010\u009b\u0001\u001a\u00020\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J\u0011\u0010\u009c\u0001\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0005J\u0011\u0010\u009d\u0001\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0005J%\u0010\u009e\u0001\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u001b\u0010\u009f\u0001\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J\u001b\u0010 \u0001\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J%\u0010¡\u0001\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J\t\u0010¢\u0001\u001a\u00020\u000bH\u0007J=\u0010¢\u0001\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010U\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020p2\u0007\u0010¤\u0001\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010¦\u0001\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u0015J6\u0010§\u0001\u001a\u00020\u000b2\u0007\u0010¨\u0001\u001a\u00020\u00052\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\tH\u0003J6\u0010©\u0001\u001a\u00020\u000b2\u0007\u0010¨\u0001\u001a\u00020\u00052\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\tH\u0003J:\u0010ª\u0001\u001a\u00020\u000b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005JE\u0010¬\u0001\u001a\u00020\u000b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J%\u0010®\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J:\u0010¯\u0001\u001a\u00020\u000b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J:\u0010°\u0001\u001a\u00020\u000b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J:\u0010±\u0001\u001a\u00020\u000b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J:\u0010²\u0001\u001a\u00020\u000b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005JN\u0010³\u0001\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u00052\t\u0010´\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0007\u0010¶\u0001\u001a\u00020$J%\u0010·\u0001\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005J8\u0010¸\u0001\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u00052\t\u0010´\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010a\u001a\u00020\u0005JK\u0010¹\u0001\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010º\u0001\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010»\u0001\u001a\u0004\u0018\u00010\u0005J\u0007\u0010¼\u0001\u001a\u00020\u000bJ\t\u0010½\u0001\u001a\u00020\u000bH\u0007J&\u0010¾\u0001\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u0005J0\u0010À\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0007\u0010Á\u0001\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J0\u0010Â\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ã\u0001\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J'\u0010Ä\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J'\u0010Å\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J'\u0010Æ\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J'\u0010Ç\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J:\u0010È\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\u0007\u0010É\u0001\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007JG\u0010Ê\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010É\u0001\u001a\u00020-2\t\b\u0002\u0010^\u001a\u00030Ë\u0001H\u0007J'\u0010Ì\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J2\u0010Í\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010Î\u0001\u001a\u00020-H\u0007J0\u0010Ï\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ð\u0001\u001a\u00020-H\u0007J1\u0010Ñ\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J1\u0010Ò\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010Ó\u0001\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0007J*\u0010Õ\u0001\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0007J*\u0010Ö\u0001\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0007J]\u0010×\u0001\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ø\u0001\u001a\u00020\u00052\u0007\u0010Ù\u0001\u001a\u00020$2\u0007\u0010Ú\u0001\u001a\u00020\u00052\u0007\u0010£\u0001\u001a\u00020p2\u000b\b\u0002\u0010Û\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0003\u0010Ý\u0001J=\u0010Þ\u0001\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ø\u0001\u001a\u00020\u00052\u0007\u0010Ù\u0001\u001a\u00020$2\u0007\u0010Ú\u0001\u001a\u00020\u00052\u0007\u0010ß\u0001\u001a\u00020-J\u001b\u0010à\u0001\u001a\u00020\u000b2\u0007\u0010á\u0001\u001a\u00020\u00052\u0007\u0010â\u0001\u001a\u00020\u0005H\u0007J\u001a\u0010ã\u0001\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u00052\u0007\u0010ä\u0001\u001a\u00020\u0005H\u0007J\u0011\u0010å\u0001\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0007J<\u0010æ\u0001\u001a\u00020\u000b2\u0007\u0010¨\u0001\u001a\u00020\u00052\u0007\u0010ç\u0001\u001a\u00020\u00052\u0007\u0010è\u0001\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0012\u0010é\u0001\u001a\u00020\u000b2\u0007\u0010ê\u0001\u001a\u00020-H\u0007J\u001e\u0010ë\u0001\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u00052\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010í\u0001\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u00052\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0005H\u0007J/\u0010î\u0001\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ú\u0001\u001a\u00020\u0015H\u0007J(\u0010ï\u0001\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0005H\u0007J2\u0010ð\u0001\u001a\u00020\u000b2\u0007\u0010ñ\u0001\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0007J*\u0010ò\u0001\u001a\u00020\u000b2\u0007\u0010ñ\u0001\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0007JO\u0010ó\u0001\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u00052\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010R\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00152\u0007\u0010õ\u0001\u001a\u00020$2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010ö\u0001JG\u0010÷\u0001\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u00052\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010R\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00152\u0007\u0010õ\u0001\u001a\u00020$2\u0006\u0010=\u001a\u00020\u0015H\u0007¢\u0006\u0003\u0010ø\u0001JQ\u0010ù\u0001\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u00052\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010R\u001a\u00020\u00052\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00152\u0006\u0010=\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010û\u0001Jb\u0010ü\u0001\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u00052\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010R\u001a\u00020\u00052\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00152\u0007\u0010õ\u0001\u001a\u00020$2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010ý\u0001J\u0007\u0010þ\u0001\u001a\u00020\u000bJ6\u0010ÿ\u0001\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0082\u0002\u001a\u00020\u0005J.\u0010\u0083\u0002\u001a\u00020\u000b2\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0082\u0002\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0086\u0002"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/VideoDetailReporter;", "", "<init>", "()V", "TABLE_GENERAL_EVENT", "", "TABLE_H5_AUTOPLAY", "sShareMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportAddToFavBox", "", "cid", "avid", "daid", "daidStatus", "defaultPL", "plNum", "reportAddToFavBoxSeasonChecked", "reportDownloadToLogin", "reportDownloadClickV2", "", "reportVideoDetailsBack", "story", "backWay", "reportPartyRelatedShow", "url", "reportPartyRelatedClick", "reportH5AutoPlayIfNeed", "uri", "Landroid/net/Uri;", "reportDownloadPartClick", "avId", "reportDownloadVipDialogShow", "reportDownloadVipDialogClick", "button", "", "reportDownloadOperation", "action", "videoQuality", "reportUgcVipDialogShow", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, LoginSceneProcessor.SCENE_KEY, "reportUgcVipDialogClick", "isCancel", "", "reportUgcCachingClick", "isVipDownload", "audioType", "hasDolbyOption", "reportUgcCachingButtonClick", "content", "reportDescCopy", "param", "state", "spmid", "reportAudioShow", "audioId", "reportAudioClick", "reportFollowShow", "follow", "upMid", RankRouter.BundleKey.AUTHOR_SPACE_MID, "reportFollowClick", "reportVideoDetailTagMoreClick", "reportVideoDetailTagEditClick", "reportTagEditReportReason", "tagId", "reason", "reportVideoDetailRelatedVideoShow", "itemId", "position", "from", "fromAvid", "goto", "gotoAvid", "trackId", "topicTrackId", "materialId", "uniqueId", "fromSourceType", "fromSourceId", "fromType", "game_status", "relatedVideoPage", "style", "refreshStyle", "level", "recommendReason", "pageType", "seasonId", "gameListName", "hasGameWiki", "reportVideoDetailRelatedVideoClick", "area", "reportVideoDetailRelatedVideoWatchLater", "reportVideoDetailDescTagClick", "type", "reportVideoDetailTagClick", "scheme", "reportVideoDetailTopicTabEndClick", "tabId", "tabName", "urlType", "tabUrl", "upId", "reportVideoDetailTopicTabClick", "reportVideoDetailTopicTabShow", "tabUri", "isAnchor", "reportRelatedVideoTabBackTop", "offset", "", "reportIntroPanelShow", "aid", "showType", "reportRelatedVideoButtonShow", "buttonType", "buttonName", "reportRelatedVideoButtonClick", "reportRelatedVideoNetFailShow", "reportRelatedVideoNetFailClick", "reportRelatedVideoEndShow", "reportVideoDetailCommentTabShow", "reportViewFailShow", "reportDetailsDanmakuInputClick", "isNft", "reportDetailsDanmakuInputClear", "reportDetailsDanmakuSwitch", "value", "extras", "", "reportDetailsDanmakuSendSuccess", "isUnreviewed", "reportCoinsClick", "result", "reportVideoRelateShow", "itemAvId", "minPosition", "fromAvId", "reportVideoRecommendShow", "reportVideoRecommendClick", "clickedItemAvid", "args4", "detailPageAvid", "reportPgcRecommendShow", "reportPgcRecommendClick", "reportFollowCardImgClick", "trackid", "target_id", "space_fid", "reportFollowCardFollowClick", "follow_fid", "reportFollowCardChangeClick", "list_id", "reportFollowCardCloseClick", "reportPopularTagShow", "reportPopularTagClick", "reportOnlineInfo", "reportDescriptionBgmClick", "reportDescriptionStickerClick", "reportDescriptionAtPartClick", "reportVideoDetailCommentTabClick", "percent", "playingStatus", "reportIntroTabSelect", "switchType", "innerReportClick", "eventId", "innerReportExposure", "reportStaffGroupFollow", "pos", "reportStaffGroupAvatarClick", "nickName", "reportStaffGroupArrowClick", "reportStaffGroupDetailUnFollow", "reportStaffGroupDetailFollow", "reportStaffGroupDetailAvatarClick", "reportStaffGroupDetailFollowGroup", "reportSeasonDetailEpisodeClick", "sectionId", "epId", "seasonType", "reportSeasonDetailCloseBtnClick", "reportSeasonDetailSectionClick", "reportSeasonDetailShow", "hasSectionId", "seasonPay", "reportUgcPopupSharePromptShow", "reportCreateFavBox", "reportSubscribeSeason", "actionResult", "clickLike", "like", "clickDisLike", "dislike", "clickCoin", "clickFavorite", "clickLiveLabel", "exposureLiveLabel", "exposureUpperAvatar", "isLive", "clickUpper", "Ltv/danmaku/bili/videopage/common/helper/VideoDetailReporter$UpperArea;", "clickPageMore", "clickPage", "fromSubPage", "clickTrippleLike", "isSuccess", "clickFollow", "clickUnFollow", "onLiveSubscribeShow", "sid", "onClickLiveSubscribe", "onClickLiveSubscribeClose", "onShareClickReport", "channel", "strategy", "time", "shareFloat", "floatTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;FLjava/lang/String;Ljava/lang/Long;)V", "onShareShowReport", "isVertical", "onNoteListShow", "oid", "number", "onNoteListItemClick", "noteId", "onNoteListEditClick", "onWatchpointItemClicked", "startTime", "endTime", "onSegmentSwitchClicked", "enable", "reportScreenShotTaken", "tab", "reportScreenShotShareHit", "onShareBubbleClick", "onShareBubbleShow", "onUpGuardianSectionClick", "up_mid", "onUpGuardianSectionShow", "reportVideoDetailRelatedVideoThreePointClick", "paramId", "clickType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;)V", "reportVideoDetailRelatedVideoShareShow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJ)V", "reportUgcRelatedVideoThreePointShareOptionClick", WatchLaterReporterKt.KEY_OPTION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;)V", "reportUgcRelatedVideoDislikeItemCancelClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;Ljava/lang/String;)V", "reportDropRelatedVideoCard", "reportSlangPediaPanelShow", "operId", "buzzwordId", "source", "reportSlangPediaPanelClose", "UpperArea", "VideoEvent", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoDetailReporter {
    private static final String TABLE_GENERAL_EVENT = "000225";
    private static final String TABLE_H5_AUTOPLAY = "000377";
    public static final VideoDetailReporter INSTANCE = new VideoDetailReporter();
    private static final HashMap<String, String> sShareMap = new HashMap<>();

    /* compiled from: VideoDetailReporter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/VideoDetailReporter$UpperArea;", "", "<init>", "(Ljava/lang/String;I)V", "AVATAR", "HOT_AREA", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum UpperArea {
        AVATAR,
        HOT_AREA;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<UpperArea> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: VideoDetailReporter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpperArea.values().length];
            try {
                iArr[UpperArea.AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UpperArea.HOT_AREA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private VideoDetailReporter() {
    }

    static {
        sShareMap.put(SplashCustomReporterKt.STATE_CANCEL, "1");
        sShareMap.put("SINA", "2");
        sShareMap.put("WEIXIN", "3");
        sShareMap.put("WEIXIN_MONMENT", "4");
        sShareMap.put("QQ", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE);
        sShareMap.put("QZONE", ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
        sShareMap.put("COPY", "7");
        sShareMap.put("GENERIC", ConstsKt.ARG_FULL_PKG_DOWNLOAD_FAILURE);
        sShareMap.put("biliDynamic", ConstsKt.ARG_FULL_PKG_START_INSTALL);
        sShareMap.put("biliIm", ConstsKt.ARG_STATE_DIALOG_SHOW);
    }

    @JvmStatic
    public static final void reportAddToFavBox(String cid, String avid, String daid, String daidStatus, String defaultPL, String plNum) {
        Map map = new HashMap(6);
        map.put("cid", cid);
        map.put("avid", avid);
        map.put("daid", daid);
        map.put("daid_status", daidStatus);
        map.put("defaultpl", defaultPL);
        map.put("plnum", plNum);
        Neurons.reportClick(false, "main.ugc-video-detail.collection-popwindow.2.click", map);
    }

    @JvmStatic
    public static final void reportAddToFavBoxSeasonChecked(String cid, String avid, String daid, String daidStatus) {
        Map map = new HashMap(4);
        map.put("cid", cid);
        map.put("avid", avid);
        map.put("daid", daid);
        map.put("daid_status", daidStatus);
        Neurons.reportClick(false, "main.ugc-video-detail.collection-popwindow.drama.click", map);
    }

    public final void reportDownloadToLogin() {
        VideoEvent event = new VideoEvent();
        event.setEventId("public.login.0.0.pv");
        event.setEventType("pv");
        event.setArgs1("main.video-detail.more.download-button.click");
        event.setArgs2("1");
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportDownloadClickV2(long cid) {
        if (cid <= 0) {
            return;
        }
        VideoEvent event = new VideoEvent();
        event.setEventId("main.video-detail.more.download-button.click");
        event.setEventType("click");
        event.setArgs1(String.valueOf(cid));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public static /* synthetic */ void reportVideoDetailsBack$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        reportVideoDetailsBack(str, str2, str3);
    }

    @JvmStatic
    public static final void reportVideoDetailsBack(String avid, String story, String backWay) {
        Map extension = new HashMap(2);
        extension.put("avid", avid == null ? "" : avid);
        extension.put("is_story", story == null ? "0" : story);
        extension.put("back_way", backWay == null ? "1" : backWay);
        Neurons.reportClick(false, "player.ugc-video-detail.button-back.type.click", extension);
    }

    public final void reportPartyRelatedShow(String avid, String url) {
        Map extension = new HashMap(2);
        extension.put("avid", avid);
        extension.put("url", url);
        Neurons.reportExposure$default(false, "player.ugc-video-detail.recommend-video.0.show", extension, (List) null, 8, (Object) null);
    }

    public final void reportPartyRelatedClick(String avid, String url) {
        Map extension = new HashMap(2);
        extension.put("avid", avid);
        extension.put("url", url);
        Neurons.reportClick(false, "player.ugc-video-detail.recommend-video.0.click", extension);
    }

    @JvmStatic
    public static final void reportH5AutoPlayIfNeed(final Uri uri, final long avid) {
        if (uri == null) {
            return;
        }
        final String value = uri.getQueryParameter("h5awaken");
        if (TextUtils.isEmpty(value)) {
            return;
        }
        HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.videopage.common.helper.VideoDetailReporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VideoDetailReporter.reportH5AutoPlayIfNeed$lambda$0(value, uri, avid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportH5AutoPlayIfNeed$lambda$0(String $value, Uri $uri, long $avid) {
        try {
            byte[] decode = Base64.decode($value, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
            String queryDecode = new String(decode, Charsets.UTF_8);
            Uri newUri = new Uri.Builder().scheme($uri.getScheme()).authority($uri.getAuthority()).path($uri.getPath()).encodedQuery(queryDecode).build();
            JSONObject argsJson = new JSONObject();
            String uri = newUri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            Collection $this$toTypedArray$iv = new Regex("\\?").split(uri, 0);
            argsJson.put(PerformanceConstants.EXTRA_KEY_SCHEMA, ((String[]) $this$toTypedArray$iv.toArray(new String[0]))[0]).put("pvid", newUri.getQueryParameter("pvid")).put("isAutoOpen", newUri.getQueryParameter("isAutoOpen"));
            String ua = newUri.getQueryParameter("ua");
            String bsource = newUri.getQueryParameter("bsource");
            InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
            String valueOf = String.valueOf($avid);
            String str = "";
            String encode = TextUtils.isEmpty(ua) ? "" : Uri.encode(ua);
            if (!TextUtils.isEmpty(bsource)) {
                str = Uri.encode(bsource);
            }
            infoEyesManager.report2(true, "000377", new String[]{"video_detail", valueOf, encode, str, Uri.encode(argsJson.toString())});
        } catch (Exception e) {
        }
    }

    @JvmStatic
    public static final void reportDownloadPartClick(long avId) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vdown_vinfo_downloadpage_part_click");
        event.setEventType("click");
        event.setArgs1(String.valueOf(avId));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    @JvmStatic
    public static final void reportDownloadVipDialogShow(long cid) {
        if (cid <= 0) {
            return;
        }
        VideoEvent event = new VideoEvent();
        event.setEventId("main.video-detail.vip-guide.0.show");
        event.setEventType("show");
        event.setArgs1(String.valueOf(cid));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    @JvmStatic
    public static final void reportDownloadVipDialogClick(long cid, int button) {
        if (cid <= 0) {
            return;
        }
        VideoEvent event = new VideoEvent();
        event.setEventId("main.video-detail.vip-guide.*.click");
        event.setEventType("click");
        event.setArgs1(String.valueOf(cid));
        event.setArgs2(String.valueOf(button));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    @JvmStatic
    public static final void reportDownloadOperation(long cid, int action, int videoQuality) {
        if (cid <= 0 || videoQuality <= 0) {
            return;
        }
        VideoEvent event = new VideoEvent();
        event.setEventId("main.video-detail.download.*.click");
        event.setEventType("click");
        event.setArgs1(String.valueOf(cid));
        event.setArgs2(String.valueOf(action));
        event.setArgs3(String.valueOf(videoQuality));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    @JvmStatic
    public static final void reportUgcVipDialogShow(long avid, long cid, int quality, int scene) {
        Map extension = new HashMap();
        extension.put("avid", String.valueOf(avid));
        extension.put("cid", String.valueOf(cid));
        extension.put(AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, String.valueOf(quality));
        extension.put(LoginSceneProcessor.SCENE_KEY, String.valueOf(scene));
        Neurons.reportExposure$default(false, "main.ugc-video-detail.vipcache.0.show", extension, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void reportUgcVipDialogClick(long avid, boolean isCancel, int scene) {
        Map extension = new HashMap();
        extension.put("avid", String.valueOf(avid));
        extension.put("content", isCancel ? "1" : "2");
        extension.put(LoginSceneProcessor.SCENE_KEY, String.valueOf(scene));
        Neurons.reportClick(false, "main.ugc-video-detail.vipcache.0.click", extension);
    }

    @JvmStatic
    public static final void reportUgcCachingClick(long cid, int quality, boolean isVipDownload, int audioType, boolean hasDolbyOption) {
        Map extension = new HashMap();
        extension.put("cid", String.valueOf(cid));
        extension.put(AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, String.valueOf(quality));
        extension.put("vipdownload", isVipDownload ? "1" : "2");
        if (!hasDolbyOption) {
            extension.put("tone-quality", "");
        } else {
            extension.put("tone-quality", audioType != -1 ? "2" : "1");
        }
        Neurons.reportClick(false, "main.ugc-video-detail.caching.content.click", extension);
    }

    @JvmStatic
    public static final void reportUgcCachingButtonClick(String content, long avid, int quality, int audioType, boolean hasDolbyOption) {
        Intrinsics.checkNotNullParameter(content, "content");
        Map extension = new HashMap();
        extension.put("content", content);
        extension.put(AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, String.valueOf(quality));
        extension.put("avid", String.valueOf(avid));
        if (!hasDolbyOption) {
            extension.put("tone-quality", "");
        } else {
            extension.put("tone-quality", audioType == -1 ? "1" : "2");
        }
        Neurons.reportClick(false, "main.ugc-video-detail.caching.button.click", extension);
    }

    public final void reportDescCopy(String param, String avid, String state, String spmid) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        HashMap extension = new HashMap(4);
        extension.put("copy_type", param);
        extension.put("avid", avid);
        extension.put("contribution_state", state);
        extension.put("spmid", spmid);
        Neurons.reportClick(false, "player.ugc-video-detail.video-information.copy.click", extension);
    }

    public final void reportAudioShow(String audioId) {
        Intrinsics.checkNotNullParameter(audioId, "audioId");
        HashMap extension = new HashMap();
        extension.put("audio_id", audioId);
        Neurons.reportExposure$default(false, "main.ugc-video-detail.audio.audio-card.show", extension, (List) null, 8, (Object) null);
    }

    public final void reportAudioClick(String audioId) {
        Intrinsics.checkNotNullParameter(audioId, "audioId");
        HashMap extension = new HashMap();
        extension.put("audio_id", audioId);
        Neurons.reportClick(false, "main.ugc-video-detail.audio.audio-card.click", extension);
    }

    public final void reportFollowShow(boolean follow, String upMid, String avid, String mid, String spmid) {
        String state;
        Intrinsics.checkNotNullParameter(mid, RankRouter.BundleKey.AUTHOR_SPACE_MID);
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        if (follow) {
            state = "follow";
        } else {
            state = "unfollow";
        }
        HashMap extension = new HashMap();
        extension.put("upmid", upMid == null ? "" : upMid);
        extension.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        extension.put("aid", avid != null ? avid : "");
        extension.put("state", state);
        extension.put("spmid", spmid);
        Neurons.reportExposure$default(false, "main.ugc-video-detail.video-information.follow.show", extension, (List) null, 8, (Object) null);
    }

    public final void reportFollowClick(String upMid, String avid, String mid, String state, String spmid) {
        Intrinsics.checkNotNullParameter(mid, RankRouter.BundleKey.AUTHOR_SPACE_MID);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        HashMap extension = new HashMap();
        extension.put("upmid", upMid == null ? "" : upMid);
        extension.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        extension.put("aid", avid != null ? avid : "");
        extension.put("state", state);
        extension.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.video-information.follow.click", extension);
    }

    public final void reportVideoDetailTagMoreClick() {
        innerReportClick("player.ugc-video-detail.tag.more.click", new HashMap());
    }

    public final void reportVideoDetailTagEditClick() {
        innerReportClick("player.ugc-video-detail.tag.press.click", new HashMap());
    }

    public final void reportTagEditReportReason(String tagId, String reason) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        HashMap param = new HashMap();
        param.put("tag_id", tagId);
        param.put("reason", reason);
        innerReportClick("player.ugc-video-detail.tag.tag.click", param);
    }

    public final void reportVideoDetailRelatedVideoShow(String itemId, int position, int from, long fromAvid, String str, long gotoAvid, String trackId, String topicTrackId, long materialId, String uniqueId, long fromSourceType, String fromSourceId, String fromType, long game_status, long relatedVideoPage, String style, String refreshStyle, String level, String recommendReason, int pageType, long seasonId, String gameListName, boolean hasGameWiki) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(refreshStyle, "refreshStyle");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
        Intrinsics.checkNotNullParameter(gameListName, "gameListName");
        HashMap param = new HashMap();
        param.put("item_id", itemId == null ? "" : itemId);
        param.put("relatedvideo_position", String.valueOf(position));
        param.put("from", String.valueOf(from));
        param.put("from_av", String.valueOf(fromAvid));
        param.put("goto", str == null ? "" : str);
        param.put("avid", String.valueOf(gotoAvid));
        param.put("track_id", trackId == null ? "" : trackId);
        param.put("topic_track_id", topicTrackId == null ? "" : topicTrackId);
        param.put(ChronosDanmakuSender.KEY_CMTIME_ID, String.valueOf(materialId));
        param.put("unique_id", uniqueId == null ? "" : uniqueId);
        param.put("from_source_type", String.valueOf(fromSourceType));
        param.put("from_source_id", fromSourceId == null ? "" : fromSourceId);
        param.put("from_type", fromType == null ? "" : fromType);
        param.put("game_status", String.valueOf(game_status));
        param.put("page", String.valueOf(relatedVideoPage));
        param.put(VideoOfflineManager.EXTRA_PLAYLIST_TYPE, String.valueOf(pageType));
        param.put("season_id", seasonId != 0 ? String.valueOf(seasonId) : "");
        param.put("style", style);
        param.put("refresh_type", refreshStyle);
        param.put("game_list_name", gameListName);
        param.put("level", level);
        param.put("has_wiki", hasGameWiki ? "1" : "0");
        param.put("recommend_reason", recommendReason);
        innerReportExposure("player.ugc-video-detail.relatedvideo.0.show", param);
    }

    public final void reportVideoDetailRelatedVideoClick(String itemId, int position, int from, long fromAvid, String str, long gotoAvid, String trackId, String topicTrackId, long materialId, String uniqueId, long fromSourceType, String fromSourceId, String area, String fromType, long relatedVideoPage, String style, String refreshStyle, String level, String recommendReason, int pageType, long seasonId, String gameListName, boolean hasGameWiki) {
        Intrinsics.checkNotNullParameter(area, "area");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(refreshStyle, "refreshStyle");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(recommendReason, "recommendReason");
        Intrinsics.checkNotNullParameter(gameListName, "gameListName");
        HashMap param = new HashMap();
        param.put("item_id", itemId == null ? "" : itemId);
        param.put("relatedvideo_position", String.valueOf(position));
        param.put("from", String.valueOf(from));
        param.put("from_av", String.valueOf(fromAvid));
        param.put("goto", str == null ? "" : str);
        param.put("avid", String.valueOf(gotoAvid));
        param.put("track_id", trackId == null ? "" : trackId);
        param.put("topic_track_id", topicTrackId == null ? "" : topicTrackId);
        param.put(ChronosDanmakuSender.KEY_CMTIME_ID, String.valueOf(materialId));
        param.put("unique_id", uniqueId == null ? "" : uniqueId);
        param.put("from_source_type", String.valueOf(fromSourceType));
        param.put("from_source_id", fromSourceId == null ? "" : fromSourceId);
        param.put("area", area);
        param.put("from_type", fromType == null ? "" : fromType);
        param.put("page", String.valueOf(relatedVideoPage));
        param.put(VideoOfflineManager.EXTRA_PLAYLIST_TYPE, String.valueOf(pageType));
        param.put("season_id", seasonId != 0 ? String.valueOf(seasonId) : "");
        param.put("style", style);
        param.put("refresh_type", refreshStyle);
        param.put("level", level);
        param.put("game_list_name", gameListName);
        param.put("has_wiki", hasGameWiki ? "1" : "0");
        param.put("recommend_reason", recommendReason);
        innerReportClick("player.ugc-video-detail.relatedvideo.0.click", param);
    }

    public static /* synthetic */ void reportVideoDetailRelatedVideoWatchLater$default(VideoDetailReporter videoDetailReporter, String str, String str2, int i, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j = 0;
        }
        videoDetailReporter.reportVideoDetailRelatedVideoWatchLater(str, str2, i3, j);
    }

    public final void reportVideoDetailRelatedVideoWatchLater(String fromAvid, String avid, int pageType, long seasonId) {
        Intrinsics.checkNotNullParameter(fromAvid, "fromAvid");
        HashMap param = new HashMap();
        param.put("from_av", fromAvid);
        param.put("avid", avid == null ? "" : avid);
        param.put(VideoOfflineManager.EXTRA_PLAYLIST_TYPE, String.valueOf(pageType));
        param.put("season_id", seasonId != 0 ? String.valueOf(seasonId) : "");
        innerReportClick("player.ugc-video-detail.relatedvideo.watchlater.click", param);
    }

    public final void reportVideoDetailDescTagClick(String tagId, String type) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(type, "type");
        HashMap param = new HashMap();
        param.put("tag_id", tagId);
        param.put("interact_type", type);
        innerReportClick("main.ugc-video-detail.video-information.tag.click", param);
    }

    public final void reportVideoDetailTagClick(String avid, String tagId, String type, String scheme) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(type, "type");
        HashMap param = new HashMap();
        param.put("avid", avid);
        param.put("tag_id", tagId);
        param.put("tag_type", type);
        param.put("activity_scheme", scheme == null ? "" : scheme);
        innerReportClick("player.ugc-video-detail.tag.click.click", param);
    }

    public final void reportVideoDetailTopicTabEndClick(String tabId, String tabName, String urlType, String tabUrl, String avid, String cid, String upId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(urlType, "urlType");
        Intrinsics.checkNotNullParameter(tabUrl, "tabUrl");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(upId, "upId");
        HashMap param = new HashMap();
        param.put("tab_id", tabId);
        param.put(WatchLaterReporterKt.KEY_TAB_NAME, tabName);
        param.put("url_type", urlType);
        param.put("tab_url", tabUrl);
        param.put("avid", avid);
        param.put("cid", cid);
        param.put("up_id", upId);
        innerReportClick("player.ugc-video-detail.tab.customized-end.click", param);
    }

    public final void reportVideoDetailTopicTabClick(String tabId, String tabName, String urlType, String tabUrl, String avid, String cid, String upId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(urlType, "urlType");
        Intrinsics.checkNotNullParameter(tabUrl, "tabUrl");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(upId, "upId");
        HashMap param = new HashMap();
        param.put("tab_id", tabId);
        param.put(WatchLaterReporterKt.KEY_TAB_NAME, tabName);
        param.put("url_type", urlType);
        param.put("tab_url", tabUrl);
        param.put("avid", avid);
        param.put("cid", cid);
        param.put("up_id", upId);
        innerReportClick("player.ugc-video-detail.tab.customized.click", param);
    }

    public final void reportVideoDetailTopicTabShow(String tabId, String tabName, String avid, String cid, String upId, String tabUri, boolean isAnchor) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(upId, "upId");
        Intrinsics.checkNotNullParameter(tabUri, "tabUri");
        HashMap param = new HashMap();
        param.put("tab_id", tabId);
        param.put(WatchLaterReporterKt.KEY_TAB_NAME, tabName);
        param.put("avid", avid);
        param.put("cid", cid);
        param.put("up_id", upId);
        param.put("tab_url", tabUri);
        param.put("is_anchor", isAnchor ? "1" : "0");
        innerReportExposure("player.ugc-video-detail.tab.customized.show", param);
    }

    public final void reportRelatedVideoTabBackTop(float offset) {
        HashMap param = new HashMap();
        param.put("offset", String.valueOf(offset));
        innerReportClick("player.ugc-video-detail.relatedvideo.tab-back-top.click", param);
    }

    public final void reportIntroPanelShow(long aid, long cid, int showType) {
        HashMap param = new HashMap();
        param.put("aid", String.valueOf(aid));
        param.put("cid", String.valueOf(cid));
        param.put("show_type", String.valueOf(showType));
        innerReportExposure("main.ugc-video-detail.video-information.panel.show", param);
    }

    public final void reportRelatedVideoButtonShow(int buttonType, String buttonName, float offset) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        HashMap param = new HashMap();
        param.put("button_type", String.valueOf(buttonType));
        param.put("button_name", buttonName);
        param.put("offset", String.valueOf(offset));
        innerReportExposure("player.ugc-video-detail.relatedvideo.suspension-button.show", param);
    }

    public final void reportRelatedVideoButtonClick(int buttonType, String buttonName, float offset) {
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        HashMap param = new HashMap();
        param.put("button_type", String.valueOf(buttonType));
        param.put("button_name", buttonName);
        param.put("offset", String.valueOf(offset));
        innerReportClick("player.ugc-video-detail.relatedvideo.suspension-button.click", param);
    }

    public final void reportRelatedVideoNetFailShow() {
        HashMap param = new HashMap();
        innerReportExposure("player.ugc-video-detail.relatedvideo.net-fail.show", param);
    }

    public final void reportRelatedVideoNetFailClick() {
        HashMap param = new HashMap();
        innerReportClick("player.ugc-video-detail.relatedvideo.net-fail.click", param);
    }

    public final void reportRelatedVideoEndShow(String topicTrackId) {
        Intrinsics.checkNotNullParameter(topicTrackId, "topicTrackId");
        HashMap param = new HashMap();
        param.put("topic_track_id", topicTrackId);
        innerReportExposure("player.ugc-video-detail.relatedvideo.end-module.show", param);
    }

    @JvmStatic
    public static final void reportVideoDetailCommentTabShow(String avid) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        HashMap params = new HashMap();
        params.put("avid", avid);
        innerReportExposure("player.ugc-video-detail.tab.comments-intro.show", params);
    }

    @JvmStatic
    public static final void reportViewFailShow() {
        HashMap param = new HashMap();
        innerReportExposure("player.player-error.player-error.0.show", param);
    }

    public static /* synthetic */ void reportDetailsDanmakuInputClick$default(VideoDetailReporter videoDetailReporter, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        videoDetailReporter.reportDetailsDanmakuInputClick(str, z);
    }

    public final void reportDetailsDanmakuInputClick(String spmid, boolean isNft) {
        HashMap param = new HashMap();
        if (spmid != null) {
            param.put("spmid", spmid);
        }
        param.put("if_nft", isNft ? "1" : "2");
        innerReportClick("player.ugc-video-detail.dm-textarea.0.click", param);
    }

    public static /* synthetic */ void reportDetailsDanmakuInputClear$default(VideoDetailReporter videoDetailReporter, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        videoDetailReporter.reportDetailsDanmakuInputClear(str);
    }

    public final void reportDetailsDanmakuInputClear(String spmid) {
        HashMap param = new HashMap();
        if (spmid != null) {
            param.put("spmid", spmid);
        }
        innerReportClick("player.ugc-video-detail.dm-clear.0.click", param);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportDetailsDanmakuSwitch$default(VideoDetailReporter videoDetailReporter, boolean z, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        videoDetailReporter.reportDetailsDanmakuSwitch(z, str, map);
    }

    public final void reportDetailsDanmakuSwitch(boolean value, String spmid, Map<String, String> map) {
        HashMap param = new HashMap();
        param.put("switch", value ? "1" : "2");
        if (spmid != null) {
            param.put("spmid", spmid);
        }
        if (map != null) {
            param.putAll(map);
        }
        innerReportClick("player.ugc-video-detail.danmaku-switch.0.click", param);
    }

    public static /* synthetic */ void reportDetailsDanmakuSendSuccess$default(VideoDetailReporter videoDetailReporter, long j, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        videoDetailReporter.reportDetailsDanmakuSendSuccess(j, z, str);
    }

    public final void reportDetailsDanmakuSendSuccess(long upMid, boolean isUnreviewed, String spmid) {
        HashMap param = new HashMap();
        if (spmid != null) {
            param.put("spmid", spmid);
        }
        param.put("status", upMid == BiliAccounts.get(BiliContext.application()).mid() ? "1" : "2");
        param.put("audit_status", isUnreviewed ? "1" : "0");
        innerReportClick("player.ugc-video-detail.dm-send.0.click", param);
    }

    public final void reportCoinsClick(long avId, int result) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vinfo_coins_click");
        event.setEventType("click");
        event.setArgs1(String.valueOf(avId));
        event.setArgs2(String.valueOf(result));
        event.setArgs4("2");
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportVideoRelateShow(String itemAvId, int minPosition, String from, long fromAvId, String trackId) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vinfo_video_relate_show");
        event.setEventType("show");
        event.setArgs1(itemAvId == null ? "" : itemAvId);
        event.setArgs2(String.valueOf(minPosition));
        event.setArgs3(from == null ? "" : from);
        event.setArgs4(String.valueOf(fromAvId));
        event.setArgs5(trackId != null ? trackId : "");
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportVideoRecommendShow(String itemId, String trackId, String type, String from, long avid) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vinfo_video_rcmd_card_view");
        event.setEventType("show");
        event.setArgs1(itemId);
        event.setArgs2(trackId);
        event.setArgs3(type);
        event.setArgs4(from);
        event.setArgs5(String.valueOf(avid));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportVideoRecommendClick(String clickedItemAvid, String trackId, String type, String args4, long detailPageAvid) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vinfo_video_rcmd_click");
        event.setEventType("click");
        event.setArgs1(clickedItemAvid);
        event.setArgs2(trackId);
        if (!TextUtils.isEmpty(type)) {
            event.setArgs3(type);
        }
        if (!TextUtils.isEmpty(args4)) {
            event.setArgs4(args4);
        }
        event.setArgs5(String.valueOf(detailPageAvid));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportPgcRecommendShow(String itemId, int position, String type, long avid) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vinfo_video_pgc_card_view");
        event.setEventType("show");
        event.setArgs1(itemId);
        event.setArgs2(String.valueOf(position));
        if (!TextUtils.isEmpty(type)) {
            event.setArgs3(type);
        }
        event.setArgs5(String.valueOf(avid));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportPgcRecommendClick(String clickedItemAvid, int position, String type, long detailPageAvid) {
        VideoEvent event = new VideoEvent();
        event.setEventId("vinfo_video_pgc_card_click");
        event.setEventType("click");
        event.setArgs1(clickedItemAvid);
        event.setArgs2(String.valueOf(position));
        if (!TextUtils.isEmpty(type)) {
            event.setArgs3(type);
        }
        event.setArgs5(String.valueOf(detailPageAvid));
        InfoEyesManager infoEyesManager = InfoEyesManager.getInstance();
        String[] asArgs = event.asArgs();
        infoEyesManager.report2(false, "000225", (String[]) Arrays.copyOf(asArgs, asArgs.length));
    }

    public final void reportFollowCardImgClick(String trackid, String mid, String target_id, String space_fid, String spmid) {
        Map params = new HashMap(5);
        params.put("trackid", trackid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        params.put("target_id", target_id);
        params.put("space_fid", space_fid);
        params.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.follow-recommend.card-img.click", params);
    }

    public final void reportFollowCardFollowClick(String trackid, String mid, String target_id, String follow_fid, String spmid) {
        Map params = new HashMap(5);
        params.put("trackid", trackid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        params.put("target_id", target_id);
        params.put("follow_fid", follow_fid);
        params.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.follow-recommend.follow.click", params);
    }

    public final void reportFollowCardChangeClick(String trackid, String mid, String target_id, String list_id, String spmid) {
        Map params = new HashMap(5);
        params.put("trackid", trackid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        params.put("target_id", target_id);
        params.put("list_id", list_id);
        params.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.follow-recommend.change.click", params);
    }

    public final void reportFollowCardCloseClick(String trackid, String mid, String target_id, String list_id, String spmid) {
        Map params = new HashMap(5);
        params.put("trackid", trackid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        params.put("target_id", target_id);
        params.put("list_id", list_id);
        params.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.follow-recommend.close.click", params);
    }

    public final void reportPopularTagShow(String spmid) {
        Map params = new HashMap(1);
        params.put("spmid", spmid);
        Neurons.reportExposure$default(false, "main.ugc-video-detail.hot-tag.0.show", params, (List) null, 8, (Object) null);
    }

    public final void reportPopularTagClick(String spmid) {
        Map params = new HashMap(1);
        params.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.hot-tag.0.click", params);
    }

    public final void reportOnlineInfo(String spmid, String aid, String cid) {
        Map params = new HashMap(4);
        params.put("avid", aid);
        params.put("cid", cid);
        params.put("spmid", spmid);
        Neurons.reportExposure$default(false, "main.ugc-video-detail.online.0.show", params, (List) null, 8, (Object) null);
    }

    public final void reportDescriptionBgmClick(String avid, String spmid) {
        Map params = new HashMap(3);
        params.put("avid", avid);
        params.put("spmid", spmid);
        params.put("link_type", "1");
        Neurons.reportClick(false, "main.ugc-video-detail.video-information.hyperlink.click", params);
    }

    public final void reportDescriptionStickerClick(String avid, String spmid) {
        Map params = new HashMap(3);
        params.put("avid", avid);
        params.put("spmid", spmid);
        params.put("link_type", "2");
        Neurons.reportClick(false, "main.ugc-video-detail.video-information.hyperlink.click", params);
    }

    public final void reportDescriptionAtPartClick(String avid, String mid, String spmid) {
        Map params = new HashMap(3);
        params.put("avid", avid);
        params.put("target_mid", mid);
        params.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.video-information.at.click", params);
    }

    @JvmStatic
    public static final void reportVideoDetailCommentTabClick() {
        innerReportClick("player.ugc-video-detail.tab.comments.click", new HashMap());
    }

    @JvmStatic
    public static final void reportVideoDetailCommentTabClick(long avid, int style, long cid, float percent, String playingStatus, String trackId) {
        Intrinsics.checkNotNullParameter(playingStatus, "playingStatus");
        HashMap params = new HashMap();
        params.put("avid", String.valueOf(avid));
        params.put("is_intro_style", String.valueOf(style));
        params.put("cid", String.valueOf(cid));
        params.put("progress", String.valueOf(percent));
        params.put("playing_status", playingStatus);
        params.put("track_id", trackId == null ? "" : trackId);
        innerReportClick("player.ugc-video-detail.tab.comments.click", params);
    }

    public final void reportIntroTabSelect(int switchType, long avid) {
        HashMap params = new HashMap();
        params.put("avid", String.valueOf(avid));
        params.put("switch_type", String.valueOf(switchType));
        innerReportClick("player.ugc-video-detail.tab.introduction.click", params);
    }

    @JvmStatic
    private static final void innerReportClick(String eventId, HashMap<String, String> hashMap) {
        Neurons.reportClick(true, eventId, hashMap);
    }

    @JvmStatic
    private static final void innerReportExposure(String eventId, HashMap<String, String> hashMap) {
        Neurons.reportExposure$default(true, eventId, hashMap, (List) null, 8, (Object) null);
    }

    public final void reportStaffGroupFollow(String pos, String aid, String cid, String mid, String spmid) {
        Map ps = new HashMap(5);
        ps.put("pos_id", pos);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-id.*.click", ps);
    }

    public final void reportStaffGroupAvatarClick(String pos, String aid, String cid, String mid, String nickName, String spmid) {
        Map ps = new HashMap(5);
        ps.put("pos_id", pos);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        if (nickName != null) {
            ps.put("nick_name", nickName);
        }
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-id.up-head.click", ps);
    }

    public final void reportStaffGroupArrowClick(String aid, String cid, String spmid) {
        Map ps = new HashMap(3);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-id.right-btn.click", ps);
    }

    public final void reportStaffGroupDetailUnFollow(String pos, String aid, String cid, String mid, String spmid) {
        Map ps = new HashMap(5);
        ps.put("pos_id", pos);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-list-id.unfollow-click.click", ps);
    }

    public final void reportStaffGroupDetailFollow(String pos, String aid, String cid, String mid, String spmid) {
        Map ps = new HashMap(5);
        ps.put("pos_id", pos);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-list-id.*.click", ps);
    }

    public final void reportStaffGroupDetailAvatarClick(String pos, String aid, String cid, String mid, String spmid) {
        Map ps = new HashMap(5);
        ps.put("pos_id", pos);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-list-id.up-head.click", ps);
    }

    public final void reportStaffGroupDetailFollowGroup(String pos, String aid, String cid, String mid, String spmid) {
        Map ps = new HashMap(5);
        ps.put("pos_id", pos);
        ps.put("aid", aid);
        ps.put("cid", cid);
        ps.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid);
        ps.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.up-create-team-list-id.set-group.click", ps);
    }

    public final void reportSeasonDetailEpisodeClick(String seasonId, String sectionId, String epId, String avid, String fromAvid, String spmid, int seasonType) {
        Map extension = new HashMap(8);
        extension.put("daid", seasonId);
        extension.put("sectionid", sectionId);
        extension.put("episodeid", epId);
        extension.put("avid", avid);
        extension.put("from_avid", fromAvid);
        extension.put("drama_type", "2");
        extension.put("drama_describe", "0");
        extension.put("spmid", spmid);
        extension.put("type", String.valueOf(seasonType));
        Neurons.reportClick(false, "main.ugc-video-detail.ugc-video-drama-detail.float-drama.click", extension);
    }

    public final void reportSeasonDetailCloseBtnClick(String seasonId, String fromAvid, String spmid) {
        Map extension = new HashMap(5);
        extension.put("daid", seasonId);
        extension.put("from_avid", fromAvid);
        extension.put("drama_type", "2");
        extension.put("drama_describe", "0");
        extension.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.ugc-video-drama-detail.close-sectionid.click", extension);
    }

    public final void reportSeasonDetailSectionClick(String seasonId, String sectionId, String fromAvid, String spmid, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Map extension = new HashMap(6);
        extension.put("daid", seasonId);
        extension.put("sectionid", sectionId);
        extension.put("from_avid", fromAvid);
        extension.put("type", type);
        extension.put("drama_describe", "0");
        extension.put("which_page", "2");
        extension.put("spmid", spmid);
        Neurons.reportClick(false, "main.ugc-video-detail.ugc-video-drama-detail.sectionid.click", extension);
    }

    public final void reportSeasonDetailShow(String seasonId, String fromAvid, String spmid, String hasSectionId, String type, String seasonPay) {
        Map extension = new HashMap(5);
        extension.put("daid", seasonId);
        extension.put("from_avid", fromAvid);
        extension.put("drama_type", "2");
        extension.put("drama_describe", "0");
        extension.put("spmid", spmid);
        extension.put("type", type);
        extension.put("has_sectionid", hasSectionId);
        extension.put("season_pay", seasonPay);
        Neurons.reportExposure$default(false, "main.ugc-video-detail.ugc-video-drama-detail.slelected-floats.show", extension, (List) null, 8, (Object) null);
    }

    public final void reportUgcPopupSharePromptShow() {
        Neurons.reportExposure$default(false, "main.ugc-video-detail.user-action.goto-share-toast.show", (Map) null, (List) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void reportCreateFavBox() {
        Neurons.reportClick$default(false, EventId.main_neuron_favorite_popwindow_click, (Map) null, 4, (Object) null);
    }

    public final void reportSubscribeSeason(String daid, String fromAvid, String actionResult) {
        Map map = new HashMap(3);
        map.put("daid", daid);
        map.put("from_avid", fromAvid);
        map.put("action_result", actionResult);
        Neurons.reportClick(false, "main.ugc-video-detail.ugc-video-drama-detail.orderbutton.click", map);
    }

    @JvmStatic
    public static final void clickLike(String aid, String cid, boolean like, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("type", like ? "2" : "1");
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.like.click", params);
    }

    @JvmStatic
    public static final void clickDisLike(String aid, String cid, boolean dislike, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("type", dislike ? "2" : "1");
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.unlike.click", params);
    }

    @JvmStatic
    public static final void clickCoin(String aid, String cid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.coin.click", params);
    }

    @JvmStatic
    public static final void clickFavorite(String aid, String cid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.fav.click", params);
    }

    @JvmStatic
    public static final void clickLiveLabel(String aid, String cid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.up-info.on-air.click", params);
    }

    @JvmStatic
    public static final void exposureLiveLabel(String aid, String cid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportExposure$default(false, "main.ugc-video-detail.up-info.on-air.show", params, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void exposureUpperAvatar(String aid, String cid, String mid, boolean isLive, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid == null ? "" : mid);
        params.put("status", isLive ? "1" : "2");
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportExposure$default(false, "main.ugc-video-detail.up-info.head.show", params, (List) null, 8, (Object) null);
    }

    public static /* synthetic */ void clickUpper$default(String str, String str2, String str3, String str4, boolean z, UpperArea upperArea, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            upperArea = UpperArea.AVATAR;
        }
        clickUpper(str, str2, str3, str4, z2, upperArea);
    }

    @JvmStatic
    public static final void clickUpper(String aid, String cid, String mid, String spmid, boolean isLive, UpperArea area) {
        Intrinsics.checkNotNullParameter(area, "area");
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid == null ? "" : mid);
        params.put("spmid", spmid != null ? spmid : "");
        String str = "1";
        params.put("status", isLive ? "1" : "2");
        HashMap hashMap = params;
        switch (WhenMappings.$EnumSwitchMapping$0[area.ordinal()]) {
            case 1:
                break;
            default:
                throw new NoWhenBranchMatchedException();
            case 2:
                str = "2";
                break;
        }
        hashMap.put("area", str);
        Neurons.reportClick(false, "main.ugc-video-detail.up-info.gravatar.click", params);
    }

    @JvmStatic
    public static final void clickPageMore(String aid, String cid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.multi-p.more.click", params);
    }

    public static /* synthetic */ void clickPage$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        clickPage(str, str2, str3, z);
    }

    @JvmStatic
    public static final void clickPage(String aid, String cid, String spmid, boolean fromSubPage) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("sub_page", fromSubPage ? "1" : "2");
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.multi-p.p.click", params);
    }

    @JvmStatic
    public static final void clickTrippleLike(String aid, String cid, String spmid, boolean isSuccess) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put("type", isSuccess ? "1" : "2");
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.highlyrec.click", params);
    }

    @JvmStatic
    public static final void clickFollow(String aid, String cid, String mid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid == null ? "" : mid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.follow.click", params);
    }

    @JvmStatic
    public static final void clickUnFollow(String aid, String cid, String mid, String spmid) {
        HashMap params = new HashMap();
        params.put("aid", aid == null ? "" : aid);
        params.put("cid", cid == null ? "" : cid);
        params.put(RankRouter.BundleKey.AUTHOR_SPACE_MID, mid == null ? "" : mid);
        params.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, "main.ugc-video-detail.user-action.unfollow.click", params);
    }

    @JvmStatic
    public static final void onLiveSubscribeShow(String upMid, String avid, long sid) {
        Intrinsics.checkNotNullParameter(upMid, "upMid");
        Intrinsics.checkNotNullParameter(avid, "avid");
        HashMap params = new HashMap();
        params.put("up_mid", upMid);
        params.put("avid", avid);
        params.put("live_booking_id", String.valueOf(sid));
        Neurons.reportExposure$default(false, "main.ugc-video-detail.orderbar.0.show", params, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void onClickLiveSubscribe(String upMid, String avid, String state, long sid) {
        Intrinsics.checkNotNullParameter(upMid, "upMid");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(state, "state");
        HashMap params = new HashMap();
        params.put("up_mid", upMid);
        params.put("avid", avid);
        params.put("action_result", state);
        params.put("live_booking_id", String.valueOf(sid));
        Neurons.reportClick(false, "main.ugc-video-detail.orderbar.0.click", params);
    }

    @JvmStatic
    public static final void onClickLiveSubscribeClose(String upMid, String avid, String state, long sid) {
        Intrinsics.checkNotNullParameter(upMid, "upMid");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(state, "state");
        HashMap params = new HashMap();
        params.put("up_mid", upMid);
        params.put("avid", avid);
        params.put("state", state);
        params.put("live_booking_id", String.valueOf(sid));
        Neurons.reportClick(false, "main.ugc-video-detail.orderbar.close.click", params);
    }

    public final void onShareClickReport(String spmid, String avid, String channel, int strategy, String time, float percent, String shareFloat, Long floatTime) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(time, "time");
        HashMap param = new HashMap();
        if (!TextUtils.isEmpty(channel) && !TextUtils.equals(channel, "default")) {
            param.put("share_button", channel);
            param.put("triggerparameter", String.valueOf(strategy));
            param.put("triggeroppo", time + "s");
        } else {
            param.put("share_button", "default");
            param.put("triggerparameter", "0");
            param.put("triggeroppo", "0");
        }
        param.put("share_detail_type", "1");
        param.put("share_detail_id", avid != null ? avid : "0");
        param.put(MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE, ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
        param.put("play_percent", String.valueOf(percent));
        param.put("spmid", spmid);
        if (shareFloat != null) {
            param.put("share_float", shareFloat);
        }
        if (floatTime != null) {
            long it = floatTime.longValue();
            param.put("float_time", String.valueOf(it));
        }
        Neurons.reportClick(false, "main.ugc-video-detail.interaction.0.click", param);
    }

    public final void onShareShowReport(String spmid, String avid, String channel, int strategy, String time, boolean isVertical) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(time, "time");
        HashMap param = new HashMap();
        if (!TextUtils.isEmpty(channel) && !TextUtils.equals(channel, "default")) {
            param.put("share_button", channel);
            param.put("triggerparameter", String.valueOf(strategy));
            param.put("triggeroppo", time + "s");
        } else {
            param.put("share_button", "default");
            param.put("triggerparameter", "0");
            param.put("triggeroppo", "0");
        }
        param.put("spmid", spmid);
        param.put("avid", avid != null ? avid : "0");
        param.put("player_is_vertical", isVertical ? "2" : "1");
        SuperMenuReportHelper.reportShareButtonShow(param);
    }

    @JvmStatic
    public static final void onNoteListShow(String oid, String number) {
        Intrinsics.checkNotNullParameter(oid, "oid");
        Intrinsics.checkNotNullParameter(number, "number");
        HashMap params = new HashMap();
        params.put("avid", oid);
        params.put("number", number);
        Neurons.reportExposure$default(false, "main.ugc-video-detail.notelist.0.show", params, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void onNoteListItemClick(String position, String noteId) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        HashMap params = new HashMap();
        params.put("position", position);
        params.put("note_id", noteId);
        Neurons.reportClick(false, "main.ugc-video-detail.notelist.note-card.click", params);
    }

    @JvmStatic
    public static final void onNoteListEditClick(String avid) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        HashMap params = new HashMap();
        params.put("avid", avid);
        Neurons.reportClick(false, "main.ugc-video-detail.notelist.take-notes.click", params);
    }

    @JvmStatic
    public static final void onWatchpointItemClicked(String eventId, String startTime, String endTime, String content, String avid, String cid) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        HashMap params = new HashMap();
        params.put("starttime", startTime);
        params.put("endtime", endTime);
        params.put("content", content);
        if (Intrinsics.areEqual(eventId, EventId.player_neuron_watchpoint_half_screen_item_click)) {
            params.put("avid", avid);
            params.put("cid", cid);
        }
        Neurons.reportClick(false, eventId, params);
    }

    @JvmStatic
    public static final void onSegmentSwitchClicked(boolean enable) {
        HashMap params = new HashMap();
        params.put("switch", enable ? "1" : "2");
        Neurons.reportClick(false, EventId.player_neuron_resident_chapter_switch_half_click, params);
    }

    @JvmStatic
    public static final void reportScreenShotTaken(String spmid, String tab) {
        HashMap params = new HashMap();
        params.put("spmid", spmid == null ? "" : spmid);
        params.put("tab", tab != null ? tab : "");
        Neurons.reportClick(false, "main.ugc-video-detail.screenshot.0.click", params);
    }

    @JvmStatic
    public static final void reportScreenShotShareHit(String spmid, String tab) {
        HashMap params = new HashMap();
        params.put("spmid", spmid == null ? "" : spmid);
        params.put("tab", tab != null ? tab : "");
        Neurons.reportClick(false, "main.ugc-video-detail.screenshot-share.0.click", params);
    }

    @JvmStatic
    public static final void onShareBubbleClick(String spmid, String avid, String shareFloat, long time) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        HashMap param = new HashMap();
        param.put("spmid", spmid);
        param.put("avid", avid == null ? "0" : avid);
        param.put("share_float", shareFloat == null ? "default" : shareFloat);
        param.put("float_time", String.valueOf(time));
        Neurons.reportClick(false, "main.public-community.share-float.all.click", param);
    }

    @JvmStatic
    public static final void onShareBubbleShow(String avid, String spmid, String channel) {
        HashMap param = new HashMap();
        param.put("avid", avid == null ? "" : avid);
        param.put("spmid", spmid != null ? spmid : "");
        param.put("share_float", channel == null ? "default" : channel);
        Neurons.reportExposure$default(false, "main.public-community.share-float.all.show", param, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void onUpGuardianSectionClick(String up_mid, String avid, String cid, String scene, String position) {
        Intrinsics.checkNotNullParameter(up_mid, "up_mid");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        Intrinsics.checkNotNullParameter(position, "position");
        HashMap param = new HashMap();
        param.put("up_mid", up_mid);
        param.put("avid", avid);
        param.put("cid", cid);
        param.put(LoginSceneProcessor.SCENE_KEY, scene);
        param.put("position", position);
        Neurons.reportClick(false, "player.ugc-video-detail.up-guard.0.click", param);
    }

    @JvmStatic
    public static final void onUpGuardianSectionShow(String up_mid, String avid, String cid, String scene) {
        Intrinsics.checkNotNullParameter(up_mid, "up_mid");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        HashMap param = new HashMap();
        param.put("up_mid", up_mid);
        param.put("avid", avid);
        param.put("cid", cid);
        param.put(LoginSceneProcessor.SCENE_KEY, scene);
        Neurons.reportExposure$default(false, "player.ugc-video-detail.up-guard.0.show", param, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void reportVideoDetailRelatedVideoThreePointClick(String str, String paramId, String fromType, Long fromAvid, int clickType, long upMid, String style) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(style, "style");
        HashMap param = new HashMap();
        param.put("goto", str == null ? "" : str);
        param.put("param", paramId != null ? paramId : "");
        param.put("from_type", fromType);
        param.put("from_avid", String.valueOf(fromAvid));
        param.put(WatchLaterReporterKt.KEY_CLICK_TYPE, String.valueOf(clickType));
        param.put("up_mid", String.valueOf(upMid));
        param.put("panel_type", "1");
        param.put("style", style);
        Neurons.reportClick(false, "player.ugc-video-detail.relatedvideo.three-point.click", param);
    }

    @JvmStatic
    public static final void reportVideoDetailRelatedVideoShareShow(String str, String paramId, String fromType, Long fromAvid, int clickType, long upMid) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        HashMap param = new HashMap();
        param.put("goto", str == null ? "" : str);
        param.put("param", paramId != null ? paramId : "");
        param.put("from_type", fromType);
        param.put("from_avid", String.valueOf(fromAvid));
        param.put(WatchLaterReporterKt.KEY_CLICK_TYPE, String.valueOf(clickType));
        param.put("up_mid", String.valueOf(upMid));
        param.put("panel_type", "1");
        Neurons.reportExposure$default(false, "player.ugc-video-detail.relatedvideo.share.show", param, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void reportUgcRelatedVideoThreePointShareOptionClick(String str, String paramId, String fromType, String option, Long fromAvid, long upMid, String style) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(style, "style");
        HashMap param = new HashMap();
        param.put("goto", str == null ? "" : str);
        param.put("param", paramId == null ? "" : paramId);
        param.put("from_type", fromType);
        param.put(WatchLaterReporterKt.KEY_OPTION, option != null ? option : "");
        param.put("from_avid", String.valueOf(fromAvid));
        param.put("up_mid", String.valueOf(upMid));
        param.put("panel_type", "1");
        param.put("style", style);
        Neurons.reportClick(false, "player.ugc-video-detail.relatedvideo.three-point-share-option.click", param);
    }

    @JvmStatic
    public static final void reportUgcRelatedVideoDislikeItemCancelClick(String str, String paramId, String fromType, String option, Long fromAvid, int clickType, long upMid, String action, String style) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(style, "style");
        HashMap param = new HashMap();
        param.put("goto", str == null ? "" : str);
        param.put("param", paramId == null ? "" : paramId);
        param.put("from_type", fromType);
        param.put(WatchLaterReporterKt.KEY_OPTION, option != null ? option : "");
        param.put("from_avid", String.valueOf(fromAvid));
        param.put(WatchLaterReporterKt.KEY_CLICK_TYPE, String.valueOf(clickType));
        param.put("up_mid", String.valueOf(upMid));
        param.put("action", action);
        param.put("panel_type", "1");
        param.put("style", style);
        Neurons.reportClick(false, "player.ugc-video-detail.relatedvideo.repeal-bar.click", param);
    }

    public final void reportDropRelatedVideoCard() {
        innerReportExposure("player.ugc-video-detail.relatedvideo.drop-card.show", new HashMap());
    }

    public final void reportSlangPediaPanelShow(String avid, String cid, String operId, String buzzwordId, String source) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(source, "source");
        HashMap param = new HashMap();
        param.put("avid", avid);
        param.put("cid", cid);
        param.put("oper_id", operId == null ? "" : operId);
        param.put("buzzword_id", buzzwordId != null ? buzzwordId : "");
        param.put("source", source);
        Neurons.reportExposure$default(false, EventId.player_neuron_dm_terrier_detail_show, param, (List) null, 8, (Object) null);
    }

    public final void reportSlangPediaPanelClose(String operId, String buzzwordId, String source, String type) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(type, "type");
        HashMap param = new HashMap();
        param.put("oper_id", operId == null ? "" : operId);
        param.put("buzzword_id", buzzwordId != null ? buzzwordId : "");
        param.put("source", source);
        param.put("type", type);
        Neurons.reportClick(false, EventId.player_neuron_dm_terrier_detail_close, param);
    }

    /* compiled from: VideoDetailReporter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d¢\u0006\u0002\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/VideoDetailReporter$VideoEvent;", "", "<init>", "()V", "eventId", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "eventType", "getEventType", "setEventType", "args1", "getArgs1", "setArgs1", "args2", "getArgs2", "setArgs2", "args3", "getArgs3", "setArgs3", "args4", "getArgs4", "setArgs4", "args5", "getArgs5", "setArgs5", "asArgs", "", "()[Ljava/lang/String;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class VideoEvent {
        private String args1;
        private String args2;
        private String args3;
        private String args4;
        private String args5;
        private String eventId;
        private String eventType;

        public final String getEventId() {
            return this.eventId;
        }

        public final void setEventId(String str) {
            this.eventId = str;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final void setEventType(String str) {
            this.eventType = str;
        }

        public final String getArgs1() {
            return this.args1;
        }

        public final void setArgs1(String str) {
            this.args1 = str;
        }

        public final String getArgs2() {
            return this.args2;
        }

        public final void setArgs2(String str) {
            this.args2 = str;
        }

        public final String getArgs3() {
            return this.args3;
        }

        public final void setArgs3(String str) {
            this.args3 = str;
        }

        public final String getArgs4() {
            return this.args4;
        }

        public final void setArgs4(String str) {
            this.args4 = str;
        }

        public final String getArgs5() {
            return this.args5;
        }

        public final void setArgs5(String str) {
            this.args5 = str;
        }

        public final String[] asArgs() {
            String str = this.eventId;
            if (str == null) {
                str = "";
            }
            String encode = Uri.encode(str);
            Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
            String str2 = this.eventType;
            if (str2 == null) {
                str2 = "";
            }
            String encode2 = Uri.encode(str2);
            Intrinsics.checkNotNullExpressionValue(encode2, "encode(...)");
            String str3 = this.args1;
            if (str3 == null) {
                str3 = "";
            }
            String encode3 = Uri.encode(str3);
            Intrinsics.checkNotNullExpressionValue(encode3, "encode(...)");
            String str4 = this.args2;
            if (str4 == null) {
                str4 = "";
            }
            String encode4 = Uri.encode(str4);
            Intrinsics.checkNotNullExpressionValue(encode4, "encode(...)");
            String str5 = this.args3;
            if (str5 == null) {
                str5 = "";
            }
            String encode5 = Uri.encode(str5);
            Intrinsics.checkNotNullExpressionValue(encode5, "encode(...)");
            String str6 = this.args4;
            if (str6 == null) {
                str6 = "";
            }
            String encode6 = Uri.encode(str6);
            Intrinsics.checkNotNullExpressionValue(encode6, "encode(...)");
            String str7 = this.args5;
            String encode7 = Uri.encode(str7 != null ? str7 : "");
            Intrinsics.checkNotNullExpressionValue(encode7, "encode(...)");
            return new String[]{encode, encode2, encode3, encode4, encode5, encode6, encode7};
        }
    }
}