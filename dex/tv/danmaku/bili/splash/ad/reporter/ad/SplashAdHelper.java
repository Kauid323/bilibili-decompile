package tv.danmaku.bili.splash.ad.reporter.ad;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.adcommon.basic.Motion;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.WxProgramInfo;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.gripper.api.ad.core.GAdClick;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdReport;
import com.bilibili.gripper.api.ad.core.click.IAdUriNavigate;
import com.bilibili.gripper.api.ad.core.report.ExtraParams;
import com.bilibili.gripper.api.ad.core.report.IAdReportHelper;
import com.bilibili.gripper.api.ad.core.report.IReportPreset;
import com.bilibili.gripper.api.ad.core.report.MapReportPreset;
import com.bilibili.gripper.api.ad.core.report.ReportPresetKt;
import com.bilibili.gripper.api.ad.core.report.SimpleAdReportPreset;
import com.bilibili.gripper.api.ad.core.report.UIExtraParams;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.resmanager.DownloadBizType;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.button.model.DegradeType;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashAdHelper.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J\u0017\u0010$\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b&J\u001f\u0010'\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\b)J\u0017\u0010*\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b+J\u001f\u0010,\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\b-J\u001a\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005J \u00101\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bJ\"\u00105\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u0002032\b\u00100\u001a\u0004\u0018\u00010\u0005J\u0010\u00106\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u00107\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001f\u00108\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b;J\u0018\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020\u0019J+\u0010?\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010=\u001a\u00020\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bAJI\u0010B\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u0002032\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\bI\u0010JJS\u0010B\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00052\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u0002032\b\b\u0002\u0010L\u001a\u00020\u00192\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\bI\u0010MJ\u0017\u0010N\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bOJ!\u0010P\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bQJA\u0010R\u001a\u00020%2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020\b2\b\b\u0002\u0010U\u001a\u00020\b2\b\b\u0002\u0010V\u001a\u00020\bH\u0000¢\u0006\u0002\bWJ'\u0010X\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bH\u0000¢\u0006\u0002\b[J\u001f\u0010\\\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010]\u001a\u00020\bH\u0000¢\u0006\u0002\b^J\u0012\u0010_\u001a\u00020\u00052\b\u0010`\u001a\u0004\u0018\u00010\u0005H\u0002J=\u0010a\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020:2\u0006\u0010f\u001a\u00020\u0019H\u0000¢\u0006\u0002\bgJ\u000e\u0010h\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0015\u0010i\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\bjJ\u001d\u0010k\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020mH\u0000¢\u0006\u0002\bnJ%\u0010o\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\u0019H\u0000¢\u0006\u0002\bsJ\u000e\u0010t\u001a\u00020%2\u0006\u0010u\u001a\u00020\u0019J\u000e\u0010v\u001a\u00020%2\u0006\u0010w\u001a\u000203J\u000e\u0010x\u001a\u00020%2\u0006\u0010w\u001a\u000203J\u0015\u0010y\u001a\u00020%2\u0006\u0010z\u001a\u000203H\u0000¢\u0006\u0002\b{J\u0017\u0010|\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b}J-\u0010~\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u007f\u001a\u00020\u00192\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0003\b\u0081\u0001J+\u0010\u0082\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u00020\u0019H\u0000¢\u0006\u0003\b\u0085\u0001J\"\u0010\u0086\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0083\u0001\u001a\u000203H\u0000¢\u0006\u0003\b\u0087\u0001J\u0019\u0010\u0088\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0003\b\u0089\u0001J\"\u0010\u008a\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b\u008b\u0001J\u0019\u0010\u008c\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0003\b\u008d\u0001J\"\u0010\u008e\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0083\u0001\u001a\u000203H\u0000¢\u0006\u0003\b\u008f\u0001J$\u0010\u0090\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u0091\u0001J\u0017\u0010\u0092\u0001\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0003\b\u0093\u0001J\u0019\u0010\u0094\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0003\b\u0095\u0001J\u0017\u0010\u0096\u0001\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0003\b\u0097\u0001J \u0010\u0098\u0001\u001a\u00020%2\u0007\u0010\u0080\u0001\u001a\u00020\b2\u000e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u009a\u0001J8\u0010\u009b\u0001\u001a\u00020%2\u0007\u0010\u009c\u0001\u001a\u0002032\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u001f\u0010\u009f\u0001\u001a\u00020%2\u000e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u0002030\u009a\u0001H\u0000¢\u0006\u0003\b¡\u0001J\u0018\u0010¢\u0001\u001a\u00020%2\u0007\u0010£\u0001\u001a\u000203H\u0000¢\u0006\u0003\b¤\u0001J3\u0010¥\u0001\u001a\u00020%2\u0010\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u000203\u0018\u00010\u009a\u00012\u0010\u0010§\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u009a\u0001H\u0000¢\u0006\u0003\b¨\u0001J \u0010©\u0001\u001a\u00020%2\u0007\u0010ª\u0001\u001a\u0002032\u0006\u0010/\u001a\u00020\u0005H\u0000¢\u0006\u0003\b«\u0001J\u001c\u0010¬\u0001\u001a\u00020%2\u0007\u0010\u00ad\u0001\u001a\u0002032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005J)\u0010®\u0001\u001a\u00020%2\u0007\u0010\u00ad\u0001\u001a\u0002032\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005J\u001a\u0010¯\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0080\u0001\u001a\u00020\bJd\u0010°\u0001\u001a\u00020%2\u0007\u0010±\u0001\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010²\u0001\u001a\u0002032\u0007\u0010³\u0001\u001a\u00020\b2\u0007\u0010´\u0001\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\b2\u0007\u0010µ\u0001\u001a\u00020\u00192\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\b\u0010\u0080\u0001\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b·\u0001J\u0019\u0010¸\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0003\b¹\u0001J\"\u0010º\u0001\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0000¢\u0006\u0003\b»\u0001J \u0010¼\u0001\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0007\u0010½\u0001\u001a\u000203H\u0000¢\u0006\u0003\b¾\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¿\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/reporter/ad/SplashAdHelper;", "", "<init>", "()V", "TAG", "", "URI_PARAM_FROM_SPMID", "DOWNLOAD_TYPE_NETWORK", "", "CON_VIDEO_JUMP_NORMAL_BUTTON_CLICK", "CON_VIDEO_JUMP_CLICK", "CON_VIDEO_JUMP_PLAY_COMPLETE", "CON_VIDEO_JUMP_FULL_SCREEN_SLIDE", "CON_VIDEO_JUMP_EGG_VIDEO_PLAY_COMPLETE", "CON_VIDEO_VOICE_CLOSE", "CON_VIDEO_VOICE_OPEN", "lastSplashRequestId", "getLastSplashRequestId$adsplash_debug", "()Ljava/lang/String;", "setLastSplashRequestId$adsplash_debug", "(Ljava/lang/String;)V", "IS_NEW_SPLASH", "reportTouchSpotJob", "Lkotlinx/coroutines/Job;", "handleAdJump", "", "context", "Landroid/content/Context;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "schemeUrl", "jumpUrl", "prioritySchemeUrl", "priorityJumpUrl", "wxProgramInfo", "Lcom/bilibili/adcommon/data/model/WxProgramInfo;", "reportSecondPageVideoShowSuccess", "", "reportSecondPageVideoShowSuccess$adsplash_debug", "reportSecondPageVideoJump", "type", "reportSecondPageVideoJump$adsplash_debug", "reportSecondPageVideoClose", "reportSecondPageVideoClose$adsplash_debug", "reportSecondPageSoundButtonClick", "reportSecondPageSoundButtonClick$adsplash_debug", "reportMiddlePageShow", PeakTaskDefine.AD_CB, "pageUrl", "reportMiddlePageExit", "playTime", "", "closeType", "reportMiddlePageClick", "adReportMiddlePageExposed", "adReportMiddlePageClicked", "adSplashSkip", "adShowTime", "", "adSplashSkip$adsplash_debug", "stockReport", "openEvent", "isDeepLink", "adReportSplashExposed", "eventFrom", "adReportSplashExposed$adsplash_debug", "adReportSplashClicked", "withFrom", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "buttonId", "showTimeBeforeClick", "cardIndex", "adReportSplashClicked$adsplash_debug", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;ZLtv/danmaku/bili/splash/ad/button/model/SplashActionType;Ljava/lang/String;JLjava/lang/Integer;)V", "from", "doThirdReport", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;ZLjava/lang/String;Ljava/lang/String;JZLjava/lang/Integer;)V", "adSplashDownloadSuccess", "adSplashDownloadSuccess$adsplash_debug", "adSplashSlideFail", "adSplashSlideFail$adsplash_debug", "reportSplashInteract", "distance", "triggerDistance", "angle", "triggerAngle", "reportSplashInteract$adsplash_debug", "reportSplashTwist", "axis", "twistType", "reportSplashTwist$adsplash_debug", "reportSplashDefaultWordExpose", "notShowReason", "reportSplashDefaultWordExpose$adsplash_debug", "appendFromSpmid", "original", "adSplashClickPositionReport", "width", "height", "positionX", "positionY", "hasGuideButton", "adSplashClickPositionReport$adsplash_debug", "adSplashSlideFailed", "adSplashOutsideClick", "adSplashOutsideClick$adsplash_debug", "adSplashButtonUIClick", "splashGuideButton", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "adSplashButtonUIClick$adsplash_debug", "adSplashButtonLottieDegradeEvent", "degradeType", "Ltv/danmaku/bili/splash/ad/button/model/DegradeType;", "isSecondPage", "adSplashButtonLottieDegradeEvent$adsplash_debug", "adSplashCacheUIEvent", "over60", "reportSplashCacheSize", "usedSize", "reportEffectiveSplashCacheSize", "adSplashCodeRequestUIEvent", "size", "adSplashCodeRequestUIEvent$adsplash_debug", "reportSplashEggShow", "reportSplashEggShow$adsplash_debug", "reportSplashTopViewTransitionShow", "success", "reason", "reportSplashTopViewTransitionShow$adsplash_debug", "reportSplashEggClick", "showTime", "enableJump", "reportSplashEggClick$adsplash_debug", "reportSplashEggClose", "reportSplashEggClose$adsplash_debug", "reportSplashEggPlayDone", "reportSplashEggPlayDone$adsplash_debug", "reportSplashEggShowFail", "reportSplashEggShowFail$adsplash_debug", "reportSplashClickableEggShow", "reportSplashClickableEggShow$adsplash_debug", "reportSplashClickableEggClick", "reportSplashClickableEggClick$adsplash_debug", "reportSplashClickableEggShowFailed", "reportSplashClickableEggShowFailed$adsplash_debug", "adSplashRealtimeFinishUIEvent", "adSplashRealtimeFinishUIEvent$adsplash_debug", "adSplashRealtimeFailUIEvent", "adSplashRealtimeFailUIEvent$adsplash_debug", "reportRealtimeMatShow", "reportRealtimeMatShow$adsplash_debug", "reportSplashResourcesDelete", "resources", "", "reportNewProgramSplashReceive", "keepId", "videoState", "imageState", "reportSplashOrderDelete", "ids", "reportSplashOrderDelete$adsplash_debug", "reportPreloadDataExpired", "timeDifference", "reportPreloadDataExpired$adsplash_debug", "reportNewKeepIdReceive", "keepIds", "splashList", "reportNewKeepIdReceive$adsplash_debug", "reportVideoPlay", "duration", "reportVideoPlay$adsplash_debug", "reportLiveReservationSuc", "liveReservationId", "reportLiveReservationFail", "reportSplashSecondPageEggShowFail", "reportSplashOrderSelectFilterEvent", "step", "splashId", "index", "splashRequestId", "isRealShow", "Ltv/danmaku/bili/splash/ad/reporter/ad/SplashOrderFilterReason;", "reportSplashOrderSelectFilterEvent$adsplash_debug", "reportTopVideoTransitionSuccess", "reportTopVideoTransitionSuccess$adsplash_debug", "reportTopVideoTransitionDownSuccess", "reportTopVideoTransitionDownSuccess$adsplash_debug", "reportVideoFirstRenderCostMs", "timeMs", "reportVideoFirstRenderCostMs$adsplash_debug", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashAdHelper {
    public static final String CON_VIDEO_JUMP_CLICK = "1";
    public static final String CON_VIDEO_JUMP_EGG_VIDEO_PLAY_COMPLETE = "4";
    public static final String CON_VIDEO_JUMP_FULL_SCREEN_SLIDE = "3";
    public static final String CON_VIDEO_JUMP_NORMAL_BUTTON_CLICK = "0";
    public static final String CON_VIDEO_JUMP_PLAY_COMPLETE = "2";
    public static final String CON_VIDEO_VOICE_CLOSE = "0";
    public static final String CON_VIDEO_VOICE_OPEN = "1";
    private static final int DOWNLOAD_TYPE_NETWORK = 1;
    private static final String IS_NEW_SPLASH = "new_splash";
    private static final String TAG = "[Splash]SplashAdHelper";
    private static final String URI_PARAM_FROM_SPMID = "from_spmid";
    private static volatile String lastSplashRequestId;
    private static Job reportTouchSpotJob;
    public static final SplashAdHelper INSTANCE = new SplashAdHelper();
    public static final int $stable = 8;

    /* compiled from: SplashAdHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SplashActionType.values().length];
            try {
                iArr[SplashActionType.SLIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SplashActionType.BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SplashActionType.SHAKE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SplashActionType.ROTATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SplashActionType.ROTATE_BALL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[SplashActionType.ROTATE_BALL_THRESHOLD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[SplashActionType.EGG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[SplashActionType.CLICKABLE_EGG.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SplashAdHelper() {
    }

    public final String getLastSplashRequestId$adsplash_debug() {
        return lastSplashRequestId;
    }

    public final void setLastSplashRequestId$adsplash_debug(String str) {
        lastSplashRequestId = str;
    }

    public final boolean handleAdJump(Context context, SplashOrder splash, String schemeUrl, String jumpUrl, String prioritySchemeUrl, String priorityJumpUrl, WxProgramInfo wxProgramInfo) {
        IClickInfo clickInfo;
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        RouteRequest mainRequest = new RouteRequest.Builder(Uri.parse("bilibili://root")).build();
        if (!splash.getRuntimeExtra().isHotSplash()) {
            BLRouter.routeTo(mainRequest, context);
        }
        Function1 action = new Function1() { // from class: tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String handleAdJump$lambda$0;
                handleAdJump$lambda$0 = SplashAdHelper.handleAdJump$lambda$0((String) obj);
                return handleAdJump$lambda$0;
            }
        };
        WxProgramInfo wxProgramInfo2 = null;
        UIExtraParams $this$handleAdJump_u24lambda_u241 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$handleAdJump_u24lambda_u241.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_callup_degrade", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$handleAdJump_u24lambda_u241);
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        GAdClick gAdClick = GAdCoreKt.getGAdClick();
        IReportPreset mapReportPreset = new MapReportPreset(MapsKt.mapOf(TuplesKt.to(IS_NEW_SPLASH, "1")));
        IAdUriNavigate.NavigateInfo[] navigateInfoArr = new IAdUriNavigate.NavigateInfo[2];
        String str = (String) action.invoke(prioritySchemeUrl);
        String str2 = (String) action.invoke(priorityJumpUrl);
        String userCancelJumpUrl = splash.getUserCancelJumpUrl();
        navigateInfoArr[0] = new IAdUriNavigate.NavigateInfo(str, str2, (String) action.invoke(userCancelJumpUrl == null || StringsKt.isBlank(userCancelJumpUrl) ? priorityJumpUrl : splash.getUserCancelJumpUrl()), splash.getCancelJumpType() == 1, splash.getEnableDoubleJump(), wxProgramInfo);
        String str3 = (String) action.invoke(schemeUrl);
        String str4 = (String) action.invoke(jumpUrl);
        String userCancelJumpUrl2 = splash.getUserCancelJumpUrl();
        String str5 = (String) action.invoke(userCancelJumpUrl2 == null || StringsKt.isBlank(userCancelJumpUrl2) ? jumpUrl : splash.getUserCancelJumpUrl());
        boolean enableDoubleJump = splash.getEnableDoubleJump();
        boolean z = splash.getCancelJumpType() == 1;
        if (adInfo != null && (clickInfo = adInfo.getClickInfo()) != null) {
            wxProgramInfo2 = clickInfo.wxProgramInfo();
        }
        navigateInfoArr[1] = new IAdUriNavigate.NavigateInfo(str3, str4, str5, z, enableDoubleJump, wxProgramInfo2);
        return gAdClick.navigate(context, adInfo, mapReportPreset, navigateInfoArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleAdJump$lambda$0(String it) {
        return INSTANCE.appendFromSpmid(it);
    }

    public final void reportSecondPageVideoShowSuccess$adsplash_debug(SplashOrder splash) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(splash.getAdCb(), (String) null);
        ReportPresetKt.add(simpleAdReportPreset, IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        UIExtraParams $this$reportSecondPageVideoShowSuccess_u24lambda_u241 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("con_video_show_suc");
        $this$reportSecondPageVideoShowSuccess_u24lambda_u241.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit2 = Unit.INSTANCE;
        gAdReport.uiEvent(ReportEvent.EVENT_TYPE_SHOW, simpleAdReportPreset, $this$reportSecondPageVideoShowSuccess_u24lambda_u241);
    }

    public final void reportSecondPageVideoJump$adsplash_debug(SplashOrder splash, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSecondPageVideoJump_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("con_video_callup_suc").TYPE(type);
        $this$reportSecondPageVideoJump_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSecondPageVideoJump_u24lambda_u240);
    }

    public final void reportSecondPageVideoClose$adsplash_debug(SplashOrder splash) {
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSecondPageVideoClose_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("con_video_close");
        $this$reportSecondPageVideoClose_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSecondPageVideoClose_u24lambda_u240);
    }

    public final void reportSecondPageSoundButtonClick$adsplash_debug(SplashOrder splash, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSecondPageSoundButtonClick_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("voice_click").TYPE(type);
        $this$reportSecondPageSoundButtonClick_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSecondPageSoundButtonClick_u24lambda_u240);
    }

    public final void reportMiddlePageShow(String adCb, String pageUrl) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(adCb, (String) null);
        UIExtraParams $this$reportMiddlePageShow_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("resume_playback_page");
        $this$reportMiddlePageShow_u24lambda_u240.getExtra().putString("page_url", pageUrl == null ? "" : pageUrl);
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent(ReportEvent.EVENT_TYPE_SHOW, simpleAdReportPreset, $this$reportMiddlePageShow_u24lambda_u240);
    }

    public final void reportMiddlePageExit(String adCb, long playTime, int closeType) {
        UIExtraParams $this$reportMiddlePageExit_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportMiddlePageExit_u24lambda_u240.getExtra().putString("play_time", String.valueOf(playTime));
        $this$reportMiddlePageExit_u24lambda_u240.getExtra().putString("close_type", String.valueOf(closeType));
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("resume_playback_page_close", new SimpleAdReportPreset(adCb, (String) null), $this$reportMiddlePageExit_u24lambda_u240);
    }

    public final void reportMiddlePageClick(String adCb, long playTime, String pageUrl) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(adCb, (String) null);
        UIExtraParams $this$reportMiddlePageClick_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("resume_playback_page");
        $this$reportMiddlePageClick_u24lambda_u240.getExtra().putString("play_time", String.valueOf(playTime));
        $this$reportMiddlePageClick_u24lambda_u240.getExtra().putString("page_url", pageUrl == null ? "" : pageUrl);
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("click", simpleAdReportPreset, $this$reportMiddlePageClick_u24lambda_u240);
    }

    public final void adReportMiddlePageExposed(SplashOrder splash) {
        if (splash != null) {
            IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
            IAdReportInfo adReportInfo = adInfo != null ? adInfo.getReportInfo() : null;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new SplashAdHelper$adReportMiddlePageExposed$1$1(adReportInfo, splash, null), 3, (Object) null);
        }
    }

    public final void adReportMiddlePageClicked(SplashOrder splash) {
        if (splash != null) {
            IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
            IAdReportInfo adReportInfo = adInfo != null ? adInfo.getReportInfo() : null;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new SplashAdHelper$adReportMiddlePageClicked$1$1(adReportInfo, splash, null), 3, (Object) null);
        }
    }

    public final void adSplashSkip$adsplash_debug(SplashOrder splash, float adShowTime) {
        if (splash != null && splash.isAdLoc()) {
            ExtraParams extraParams = new ExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
            Bundle $this$adSplashSkip_u24lambda_u240_u240_u240 = extraParams.getExtra();
            $this$adSplashSkip_u24lambda_u240_u240_u240.putString("splash_request_id", splash.getRuntimeExtra().getSplashRequestId());
            $this$adSplashSkip_u24lambda_u240_u240_u240.putString("show_time", String.valueOf(adShowTime));
            $this$adSplashSkip_u24lambda_u240_u240_u240.putString(IS_NEW_SPLASH, "1");
            GAdReport gAdReport = GAdCoreKt.getGAdReport();
            IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
            gAdReport.splashSkip(adInfo != null ? adInfo.getReportInfo() : null, extraParams);
        }
    }

    public static /* synthetic */ void stockReport$default(SplashAdHelper splashAdHelper, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        splashAdHelper.stockReport(str, z);
    }

    public final void stockReport(String openEvent, boolean isDeepLink) {
        Intrinsics.checkNotNullParameter(openEvent, "openEvent");
        BLog.i(TAG, "stockReport openEvent = " + openEvent);
        SplashOrder stockSplash = new SplashOrder(0L, 0L, 0, 0, 0, 0, 0, 0L, 0L, 0L, null, null, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, (int) SplashReportConfig.INSTANCE.getSourceId(), 0, null, SplashReportConfig.INSTANCE.getResourceId(), String.valueOf(System.currentTimeMillis()), null, false, true, null, false, null, 0, 0, 0.0f, 0L, 0L, 0L, null, null, 0, false, false, 0, null, 0, 0, null, null, null, null, null, 0, null, null, false, null, 0L, null, null, 0, false, 0L, false, -838860801, -2, 15, null);
        stockSplash.getRuntimeExtra().setSplashRequestId(lastSplashRequestId);
        stockSplash.getRuntimeExtra().setFromCalledUp(isDeepLink);
        adReportSplashExposed$adsplash_debug$default(this, stockSplash, openEvent, null, 4, null);
        SplashCustomReporterKt.reportSplashStock(Intrinsics.areEqual(openEvent, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT), isDeepLink);
    }

    public static /* synthetic */ void adReportSplashExposed$adsplash_debug$default(SplashAdHelper splashAdHelper, SplashOrder splashOrder, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        splashAdHelper.adReportSplashExposed$adsplash_debug(splashOrder, str, str2);
    }

    public final void adReportSplashExposed$adsplash_debug(SplashOrder splash, String openEvent, String eventFrom) {
        Intrinsics.checkNotNullParameter(openEvent, "openEvent");
        if (splash != null && splash.isAdLoc()) {
            IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
            IAdReportInfo adReportInfo = adInfo != null ? adInfo.getReportInfo() : null;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new SplashAdHelper$adReportSplashExposed$1$1(adReportInfo, splash, openEvent, eventFrom, splash, null), 3, (Object) null);
        }
    }

    public static /* synthetic */ void adReportSplashClicked$adsplash_debug$default(SplashAdHelper splashAdHelper, SplashOrder splashOrder, boolean z, SplashActionType splashActionType, String str, long j, Integer num, int i, Object obj) {
        String str2;
        Integer num2;
        if ((i & 8) == 0) {
            str2 = str;
        } else {
            str2 = null;
        }
        if ((i & 32) == 0) {
            num2 = num;
        } else {
            num2 = null;
        }
        splashAdHelper.adReportSplashClicked$adsplash_debug(splashOrder, z, splashActionType, str2, j, num2);
    }

    public final void adReportSplashClicked$adsplash_debug(SplashOrder splash, boolean withFrom, SplashActionType actionType, String buttonId, long showTimeBeforeClick, Integer cardIndex) {
        String feedEventFrom;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        switch (WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()]) {
            case 1:
                feedEventFrom = "ad_splash_button_slide_success";
                break;
            case 2:
                feedEventFrom = "ad_splash_button";
                break;
            case 3:
                feedEventFrom = "ad_splash_shake";
                break;
            case 4:
                feedEventFrom = "ad_splash_revolve";
                break;
            case 5:
                feedEventFrom = "ad_splash_revolve_ball";
                break;
            case 6:
                feedEventFrom = "ad_splash_revolve_ball_threshold";
                break;
            case 7:
                feedEventFrom = "splash_egg";
                break;
            case 8:
                feedEventFrom = "splash_clickable_egg";
                break;
            default:
                feedEventFrom = "ad_splash_card";
                break;
        }
        adReportSplashClicked$adsplash_debug(splash, withFrom, feedEventFrom, buttonId, showTimeBeforeClick, true, cardIndex);
    }

    public final void adReportSplashClicked$adsplash_debug(SplashOrder splash, boolean withFrom, String from, String buttonId, long showTimeBeforeClick, boolean doThirdReport, Integer cardIndex) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (splash != null && splash.isAdLoc()) {
            IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
            IAdReportInfo adReportInfo = adInfo != null ? adInfo.getReportInfo() : null;
            ExtraParams $this$adReportSplashClicked_u24lambda_u240_u240 = new ExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
            Bundle $this$adReportSplashClicked_u24lambda_u240_u240_u240 = $this$adReportSplashClicked_u24lambda_u240_u240.getExtra();
            $this$adReportSplashClicked_u24lambda_u240_u240_u240.putString("splash_request_id", splash.getRuntimeExtra().getSplashRequestId());
            $this$adReportSplashClicked_u24lambda_u240_u240_u240.putLong("show_time", showTimeBeforeClick);
            if (withFrom) {
                $this$adReportSplashClicked_u24lambda_u240_u240_u240.putString("event_from", from);
            }
            String str = buttonId;
            if (!(str == null || StringsKt.isBlank(str))) {
                $this$adReportSplashClicked_u24lambda_u240_u240_u240.putString("splash_button_id", buttonId);
            }
            $this$adReportSplashClicked_u24lambda_u240_u240_u240.putString("is_out_open_deeplink", String.valueOf(splash.getRuntimeExtra().isFromCalledUp() ? 1 : 0));
            if (cardIndex != null) {
                $this$adReportSplashClicked_u24lambda_u240_u240_u240.putString("card_index", String.valueOf(cardIndex.intValue()));
            }
            $this$adReportSplashClicked_u24lambda_u240_u240_u240.putString(IS_NEW_SPLASH, "1");
            GAdCoreKt.getGAdReport().event("click", adReportInfo, $this$adReportSplashClicked_u24lambda_u240_u240);
            Unit unit = Unit.INSTANCE;
            Job job = reportTouchSpotJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            if (doThirdReport) {
                IAdReportHelper.-CC.clickedMMAWithRequestId$default(GAdCoreKt.getGAdReport(), adReportInfo, (Motion) null, (String) null, 4, (Object) null);
            }
        }
    }

    public final void adSplashDownloadSuccess$adsplash_debug(String adCb) {
        String str = adCb;
        if (str == null || StringsKt.isBlank(str)) {
            BLog.i(TAG, "adSplashDownloadSuccess, adCb = null");
            return;
        }
        UIExtraParams $this$adSplashDownloadSuccess_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$adSplashDownloadSuccess_u24lambda_u240.DOWNLOAD_TYPE(1);
        $this$adSplashDownloadSuccess_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("cre_dl_suc", new SimpleAdReportPreset(adCb, (String) null), $this$adSplashDownloadSuccess_u24lambda_u240);
    }

    public static /* synthetic */ void adSplashSlideFail$adsplash_debug$default(SplashAdHelper splashAdHelper, SplashOrder splashOrder, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        splashAdHelper.adSplashSlideFail$adsplash_debug(splashOrder, str);
    }

    public final void adSplashSlideFail$adsplash_debug(SplashOrder splash, String eventFrom) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Ref.ObjectRef extraParams = new Ref.ObjectRef();
        if (eventFrom != null) {
            UIExtraParams $this$adSplashSlideFail_u24lambda_u240_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM(eventFrom);
            $this$adSplashSlideFail_u24lambda_u240_u240.getExtra().putString(IS_NEW_SPLASH, "1");
            extraParams.element = $this$adSplashSlideFail_u24lambda_u240_u240;
        }
        GAdCoreKt.getGAdReport().uiEvent("splash_slide_fail", new SimpleAdReportPreset(splash.getAdCb(), (String) null), (UIExtraParams) extraParams.element);
    }

    public static /* synthetic */ void reportSplashInteract$adsplash_debug$default(SplashAdHelper splashAdHelper, SplashOrder splashOrder, float f, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            splashOrder = null;
        }
        splashAdHelper.reportSplashInteract$adsplash_debug(splashOrder, (i4 & 2) != 0 ? 0.0f : f, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) == 0 ? i3 : 0);
    }

    public final void reportSplashInteract$adsplash_debug(SplashOrder splash, float distance, int triggerDistance, int angle, int triggerAngle) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        String adCb = splash != null ? splash.getAdCb() : null;
        UIExtraParams $this$reportSplashInteract_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SPLASH_DISTANCE(String.valueOf((int) distance)).SPLASH_TRIGGER_DISTANCE(String.valueOf(triggerDistance)).SPLASH_ANGLE(String.valueOf(angle)).SPLASH_TRIGGER_ANGLE(String.valueOf(triggerAngle));
        $this$reportSplashInteract_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_interact_event", new SimpleAdReportPreset(adCb, (String) null), $this$reportSplashInteract_u24lambda_u240);
    }

    public final void reportSplashTwist$adsplash_debug(SplashOrder splash, int axis, int twistType) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        String adCb = splash != null ? splash.getAdCb() : null;
        UIExtraParams $this$reportSplashTwist_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SPLASH_TWIST_AXIS(String.valueOf(axis)).SPLASH_TWIST_TYPE(String.valueOf(twistType));
        $this$reportSplashTwist_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_interact_twist", new SimpleAdReportPreset(adCb, (String) null), $this$reportSplashTwist_u24lambda_u240);
    }

    public final void reportSplashDefaultWordExpose$adsplash_debug(SplashOrder splash, int notShowReason) {
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSplashDefaultWordExpose_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SPLASH_ID(String.valueOf(splash.getId())).SPLASH_SEARCH_WORD(splash.getKeyword()).SPLASH_SEARCH_WORD_NOT_SHOW_REASON(String.valueOf(notShowReason));
        $this$reportSplashDefaultWordExpose_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("search_show_suc", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashDefaultWordExpose_u24lambda_u240);
    }

    private final String appendFromSpmid(String original) {
        String str = original;
        boolean z = false;
        if (str == null || str.length() == 0) {
            return "";
        }
        Uri uri = Uri.parse(original);
        if (AppConfig.isBiliDomain(uri)) {
            Uri.Builder $this$appendFromSpmid_u24lambda_u240 = uri.buildUpon();
            String queryParameter = uri.getQueryParameter("from_spmid");
            if (queryParameter == null || queryParameter.length() == 0) {
                z = true;
            }
            if (z) {
                $this$appendFromSpmid_u24lambda_u240.appendQueryParameter("from_spmid", BusinessSplashDefineKt.SPLASH_SPMID);
            }
            String uri2 = $this$appendFromSpmid_u24lambda_u240.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "run(...)");
            return uri2;
        }
        return original;
    }

    public final void adSplashClickPositionReport$adsplash_debug(SplashOrder splash, int width, int height, float positionX, float positionY, boolean hasGuideButton) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Bundle $this$adSplashClickPositionReport_u24lambda_u240 = new Bundle();
        $this$adSplashClickPositionReport_u24lambda_u240.putString("platform_name", "Android");
        $this$adSplashClickPositionReport_u24lambda_u240.putString("screen_size", width + "*" + height);
        float f = 100;
        $this$adSplashClickPositionReport_u24lambda_u240.putString("click_position_x", String.valueOf(MathKt.roundToInt((positionX / width) * f)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString("click_position_y", String.valueOf(MathKt.roundToInt((positionY / height) * f)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString("full_screen", "0");
        $this$adSplashClickPositionReport_u24lambda_u240.putString("top_safe_zone", "0");
        $this$adSplashClickPositionReport_u24lambda_u240.putString("bottom_safe_zone", "0");
        boolean isFullscreen = ExtSplashOrderKt.isFullScreen(splash);
        $this$adSplashClickPositionReport_u24lambda_u240.putString("button_zone", (isFullscreen || hasGuideButton) ? "0" : String.valueOf(ListExtentionsKt.toPx(48)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString("brand_zone", isFullscreen ? "0" : String.valueOf((int) (height / 8.0f)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString(IS_NEW_SPLASH, "1");
        UIExtraParams extraParams = new UIExtraParams($this$adSplashClickPositionReport_u24lambda_u240);
        GAdCoreKt.getGAdReport().uiEvent("click_position", new SimpleAdReportPreset(splash.getAdCb(), splash.getJumpUrl()), extraParams);
    }

    public final void adSplashSlideFailed(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("ad_splash_button_slide_failed");
        extraParams.getExtra().putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.getAdCb(), splash.getJumpUrl()), extraParams);
    }

    public final void adSplashOutsideClick$adsplash_debug(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("ad_splash_card");
        extraParams.getExtra().putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.getAdCb(), splash.getJumpUrl()), extraParams);
    }

    public final void adSplashButtonUIClick$adsplash_debug(SplashOrder splash, SplashGuideButton splashGuideButton) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("ad_splash_button");
        extraParams.getExtra().putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.getAdCb(), splashGuideButton.getJumpUrl()), extraParams);
    }

    public final void adSplashButtonLottieDegradeEvent$adsplash_debug(SplashOrder splash, DegradeType degradeType, boolean isSecondPage) {
        String eventFrom;
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(degradeType, "degradeType");
        if (isSecondPage) {
            eventFrom = "splash_second";
        } else {
            eventFrom = splash.isRealTimeSplash() ? "realtime" : "local";
        }
        UIExtraParams $this$adSplashButtonLottieDegradeEvent_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).DEGRADE_TYPE(degradeType.getValue()).EVENT_FROM(eventFrom);
        $this$adSplashButtonLottieDegradeEvent_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("lottie_button_degraded", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$adSplashButtonLottieDegradeEvent_u24lambda_u240);
    }

    public final void adSplashCacheUIEvent(boolean over60) {
        if (over60) {
            GAdReport gAdReport = GAdCoreKt.getGAdReport();
            UIExtraParams $this$adSplashCacheUIEvent_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
            $this$adSplashCacheUIEvent_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
            Unit unit = Unit.INSTANCE;
            gAdReport.uiEvent("splash_cache_60m", (IReportPreset) null, $this$adSplashCacheUIEvent_u24lambda_u240);
            return;
        }
        GAdReport gAdReport2 = GAdCoreKt.getGAdReport();
        UIExtraParams $this$adSplashCacheUIEvent_u24lambda_u241 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$adSplashCacheUIEvent_u24lambda_u241.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit2 = Unit.INSTANCE;
        gAdReport2.uiEvent("splash_cache_40m", (IReportPreset) null, $this$adSplashCacheUIEvent_u24lambda_u241);
    }

    public final void reportSplashCacheSize(long usedSize) {
        double currentSize = (usedSize / 1024.0d) / 1024.0d;
        DecimalFormat format = new DecimalFormat("#.#");
        format.setRoundingMode(RoundingMode.HALF_UP);
        UIExtraParams uIExtraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        String format2 = format.format(currentSize);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        UIExtraParams params = uIExtraParams.SPLASH_CURRENT_SIZE(format2).SPLASH_OVERALL_SIZE(String.valueOf(DownloadBizType.Splash.getMaxSizeMB()));
        params.getExtra().putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("splash_cache_monitor", (IReportPreset) null, params);
    }

    public final void reportEffectiveSplashCacheSize(long usedSize) {
        double currentSize = (usedSize / 1024.0d) / 1024.0d;
        DecimalFormat format = new DecimalFormat("#.#");
        format.setRoundingMode(RoundingMode.HALF_UP);
        UIExtraParams uIExtraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        String format2 = format.format(currentSize);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        UIExtraParams params = uIExtraParams.SPLASH_CURRENT_SIZE(format2).SPLASH_OVERALL_SIZE(String.valueOf(DownloadBizType.EffectSplash.getMaxSizeMB()));
        params.getExtra().putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("splash_cache_monitor_effect", (IReportPreset) null, params);
    }

    public final void adSplashCodeRequestUIEvent$adsplash_debug(long size) {
        if (size >= 0) {
            UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_LIST_COUNT(String.valueOf(size));
            extraParams.getExtra().putString(IS_NEW_SPLASH, "1");
            extraParams.getExtra().putString("mixin_banner", DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() ? "1" : "0");
            GAdCoreKt.getGAdReport().uiEvent("splash_cold_request_success", (IReportPreset) null, extraParams);
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$adSplashCodeRequestUIEvent_u24lambda_u241 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$adSplashCodeRequestUIEvent_u24lambda_u241.getExtra().putString(IS_NEW_SPLASH, "1");
        $this$adSplashCodeRequestUIEvent_u24lambda_u241.getExtra().putString("mixin_banner", DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() ? "1" : "0");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_cold_request_fail", (IReportPreset) null, $this$adSplashCodeRequestUIEvent_u24lambda_u241);
    }

    public final void reportSplashEggShow$adsplash_debug(SplashOrder splash) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggShow");
        UIExtraParams $this$reportSplashEggShow_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashEggShow_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_show", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashEggShow_u24lambda_u240);
    }

    public static /* synthetic */ void reportSplashTopViewTransitionShow$adsplash_debug$default(SplashAdHelper splashAdHelper, SplashOrder splashOrder, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        splashAdHelper.reportSplashTopViewTransitionShow$adsplash_debug(splashOrder, z, str);
    }

    public final void reportSplashTopViewTransitionShow$adsplash_debug(SplashOrder splash, boolean success, String reason) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(splash.getAdCb(), (String) null);
        UIExtraParams $this$reportSplashTopViewTransitionShow_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashTopViewTransitionShow_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        $this$reportSplashTopViewTransitionShow_u24lambda_u240.getExtra().putString(ReportEvent.EVENT_TYPE_SHOW, success ? "1" : "0");
        if (reason != null) {
            $this$reportSplashTopViewTransitionShow_u24lambda_u240.getExtra().putString("reason", reason);
        }
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_top_transition_show", simpleAdReportPreset, $this$reportSplashTopViewTransitionShow_u24lambda_u240);
    }

    public final void reportSplashEggClick$adsplash_debug(SplashOrder splash, long showTime, boolean enableJump) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggClick, showTime = " + showTime + ", enableJump = " + enableJump);
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(splash.getAdCb(), (String) null);
        UIExtraParams $this$reportSplashEggClick_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(showTime);
        $this$reportSplashEggClick_u24lambda_u240.getExtra().putString("enable_jump", enableJump ? "1" : "0");
        $this$reportSplashEggClick_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_egg_click", simpleAdReportPreset, $this$reportSplashEggClick_u24lambda_u240);
    }

    public final void reportSplashEggClose$adsplash_debug(SplashOrder splash, long showTime) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggClose, showTime = " + showTime);
        UIExtraParams $this$reportSplashEggClose_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(showTime);
        $this$reportSplashEggClose_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_close", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashEggClose_u24lambda_u240);
    }

    public final void reportSplashEggPlayDone$adsplash_debug(SplashOrder splash) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggPlayDone");
        UIExtraParams $this$reportSplashEggPlayDone_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashEggPlayDone_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_play_done", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashEggPlayDone_u24lambda_u240);
    }

    public final void reportSplashEggShowFail$adsplash_debug(SplashOrder splash, int reason) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggShowFail, reason = " + reason);
        UIExtraParams $this$reportSplashEggShowFail_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashEggShowFail_u24lambda_u240.getExtra().putString("reason", String.valueOf(reason));
        $this$reportSplashEggShowFail_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_show_fail", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashEggShowFail_u24lambda_u240);
    }

    public final void reportSplashClickableEggShow$adsplash_debug(SplashOrder splash) {
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSplashClickableEggShow_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashClickableEggShow_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_clickable_egg_show", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashClickableEggShow_u24lambda_u240);
    }

    public final void reportSplashClickableEggClick$adsplash_debug(SplashOrder splash, long showTime) {
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSplashClickableEggClick_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(showTime);
        $this$reportSplashClickableEggClick_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_clickable_egg_click", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashClickableEggClick_u24lambda_u240);
    }

    public static /* synthetic */ void reportSplashClickableEggShowFailed$adsplash_debug$default(SplashAdHelper splashAdHelper, SplashOrder splashOrder, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "1";
        }
        splashAdHelper.reportSplashClickableEggShowFailed$adsplash_debug(splashOrder, str);
    }

    public final void reportSplashClickableEggShowFailed$adsplash_debug(SplashOrder splash, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSplashClickableEggShowFailed_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashClickableEggShowFailed_u24lambda_u240.getExtra().putString("reason", reason);
        $this$reportSplashClickableEggShowFailed_u24lambda_u240.getExtra().putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_clickable_egg_show_fail", new SimpleAdReportPreset(splash.getAdCb(), (String) null), $this$reportSplashClickableEggShowFailed_u24lambda_u240);
    }

    public final void adSplashRealtimeFinishUIEvent$adsplash_debug(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240 = extraParams.getExtra();
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splash.getId()));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString("cardtype", String.valueOf(splash.getCardType()));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString("splash_pic_size", String.valueOf(splash.getRuntimeExtra().getLocalSplashImageSize()));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString("splash_video_size", String.valueOf(splash.getRuntimeExtra().getLocalSplashVideoSize()));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString(ExtSplashOrderKt.isVideo(splash) ? "video_from" : "event_from", ExtSplashOrderKt.isVideo(splash) ? splash.getRuntimeExtra().getVideoFrom() : splash.getRuntimeExtra().getImageFrom());
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("realtime_mat_load_finish", new SimpleAdReportPreset(splash.getAdCb(), (String) null), extraParams);
    }

    public final void adSplashRealtimeFailUIEvent$adsplash_debug(SplashOrder splash) {
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240 = extraParams.getExtra();
        $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splash != null ? Long.valueOf(splash.getId()) : null));
        $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240.putString("cardtype", String.valueOf(splash != null ? Integer.valueOf(splash.getCardType()) : null));
        $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("realtime_mat_load_fail", new SimpleAdReportPreset(splash != null ? splash.getAdCb() : null, (String) null), extraParams);
    }

    public final void reportRealtimeMatShow$adsplash_debug(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportRealtimeMatShow_u24lambda_u240_u240 = extraParams.getExtra();
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splash.getId()));
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString("cardtype", String.valueOf(splash.getCardType()));
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString(ExtSplashOrderKt.isVideo(splash) ? "video_from" : "pic_from", ExtSplashOrderKt.isVideo(splash) ? splash.getRuntimeExtra().getVideoFrom() : splash.getRuntimeExtra().getImageFrom());
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("realtime_mat_load_show", new SimpleAdReportPreset(splash.getAdCb(), (String) null), extraParams);
    }

    public final void reportSplashResourcesDelete(int reason, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "resources");
        String md5 = CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        BLog.i(TAG, "reportSplashResourcesDelete, reason = " + reason + ", md5 = " + md5);
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$reportSplashResourcesDelete_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashResourcesDelete_u24lambda_u240_u240 = $this$reportSplashResourcesDelete_u24lambda_u240.getExtra();
        $this$reportSplashResourcesDelete_u24lambda_u240_u240.putString("delete_reason", String.valueOf(reason));
        $this$reportSplashResourcesDelete_u24lambda_u240_u240.putString("md5", md5);
        $this$reportSplashResourcesDelete_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_material_delete", (IReportPreset) null, $this$reportSplashResourcesDelete_u24lambda_u240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportNewProgramSplashReceive(long keepId, String videoState, String imageState, String adCb) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(adCb, (String) null);
        boolean z = true;
        UIExtraParams $this$reportNewProgramSplashReceive_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportNewProgramSplashReceive_u24lambda_u240_u240 = $this$reportNewProgramSplashReceive_u24lambda_u240.getExtra();
        String str = videoState;
        if (!(str == null || StringsKt.isBlank(str))) {
            $this$reportNewProgramSplashReceive_u24lambda_u240_u240.putString("video", videoState);
        }
        String str2 = imageState;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            z = false;
        }
        if (!z) {
            $this$reportNewProgramSplashReceive_u24lambda_u240_u240.putString("image", imageState);
        }
        $this$reportNewProgramSplashReceive_u24lambda_u240_u240.putString("id", String.valueOf(keepId));
        $this$reportNewProgramSplashReceive_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("keep_cre_new", simpleAdReportPreset, $this$reportNewProgramSplashReceive_u24lambda_u240);
    }

    public final void reportSplashOrderDelete$adsplash_debug(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        if (list.isEmpty()) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$reportSplashOrderDelete_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashOrderDelete_u24lambda_u240_u240 = $this$reportSplashOrderDelete_u24lambda_u240.getExtra();
        $this$reportSplashOrderDelete_u24lambda_u240_u240.putString("id", CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        $this$reportSplashOrderDelete_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_cre_delete", (IReportPreset) null, $this$reportSplashOrderDelete_u24lambda_u240);
    }

    public final void reportPreloadDataExpired$adsplash_debug(long timeDifference) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$reportPreloadDataExpired_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportPreloadDataExpired_u24lambda_u240_u240 = $this$reportPreloadDataExpired_u24lambda_u240.getExtra();
        $this$reportPreloadDataExpired_u24lambda_u240_u240.putString("time_difference", String.valueOf(timeDifference));
        $this$reportPreloadDataExpired_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_preload_expired", (IReportPreset) null, $this$reportPreloadDataExpired_u24lambda_u240);
    }

    public final void reportNewKeepIdReceive$adsplash_debug(List<Long> list, List<SplashOrder> list2) {
        String imageState;
        List<Long> list3 = list;
        boolean z = false;
        if (list3 == null || list3.isEmpty()) {
            return;
        }
        List<SplashOrder> list4 = list2;
        if ((list4 == null || list4.isEmpty()) ? true : true) {
            return;
        }
        Set idSet = new HashSet(list);
        for (SplashOrder splash : list2) {
            if (idSet.contains(Long.valueOf(splash.getId()))) {
                String videoState = "new";
                if (BusinessSplashResHelper.INSTANCE.isResourceExistByHash(splash.getVideoHash())) {
                    videoState = "local";
                }
                if (!BusinessSplashResHelper.INSTANCE.isResourceExistByHash(splash.getImageHash())) {
                    imageState = "new";
                } else {
                    imageState = "local";
                }
                if (ExtSplashOrderKt.isOnlyImageSplash(splash)) {
                    reportNewProgramSplashReceive(splash.getId(), null, imageState, splash.getAdCb());
                } else if (ExtSplashOrderKt.isOnlyVideoSplash(splash)) {
                    reportNewProgramSplashReceive(splash.getId(), videoState, null, splash.getAdCb());
                } else if (ExtSplashOrderKt.isImageVideoMixCardType(splash)) {
                    reportNewProgramSplashReceive(splash.getId(), videoState, imageState, splash.getAdCb());
                }
            }
        }
    }

    public final void reportVideoPlay$adsplash_debug(long duration, String adCb) {
        Intrinsics.checkNotNullParameter(adCb, PeakTaskDefine.AD_CB);
        UIExtraParams uiExtraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(duration);
        Bundle $this$reportVideoPlay_u24lambda_u240_u240 = uiExtraParams.getExtra();
        $this$reportVideoPlay_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        GAdCoreKt.getGAdReport().uiEvent("splash_video_play", new SimpleAdReportPreset(adCb, ""), uiExtraParams);
    }

    public static /* synthetic */ void reportLiveReservationSuc$default(SplashAdHelper splashAdHelper, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        splashAdHelper.reportLiveReservationSuc(j, str);
    }

    public final void reportLiveReservationSuc(long liveReservationId, String adCb) {
        UIExtraParams $this$reportLiveReservationSuc_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportLiveReservationSuc_u24lambda_u240_u240 = $this$reportLiveReservationSuc_u24lambda_u240.getExtra();
        $this$reportLiveReservationSuc_u24lambda_u240_u240.putString("live_reservation_id", String.valueOf(liveReservationId));
        $this$reportLiveReservationSuc_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("live_reservation_suc", new SimpleAdReportPreset(adCb, (String) null), $this$reportLiveReservationSuc_u24lambda_u240);
    }

    public static /* synthetic */ void reportLiveReservationFail$default(SplashAdHelper splashAdHelper, long j, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        splashAdHelper.reportLiveReservationFail(j, str, str2);
    }

    public final void reportLiveReservationFail(long liveReservationId, String reason, String adCb) {
        UIExtraParams $this$reportLiveReservationFail_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportLiveReservationFail_u24lambda_u240_u240 = $this$reportLiveReservationFail_u24lambda_u240.getExtra();
        $this$reportLiveReservationFail_u24lambda_u240_u240.putString("live_reservation_id", String.valueOf(liveReservationId));
        $this$reportLiveReservationFail_u24lambda_u240_u240.putString("reason", reason);
        $this$reportLiveReservationFail_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("live_reservation_fail", new SimpleAdReportPreset(adCb, (String) null), $this$reportLiveReservationFail_u24lambda_u240);
    }

    public final void reportSplashSecondPageEggShowFail(SplashOrder splash, int reason) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(adInfo != null ? adInfo.getReportInfo() : null);
        UIExtraParams $this$reportSplashSecondPageEggShowFail_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashSecondPageEggShowFail_u24lambda_u240_u240 = $this$reportSplashSecondPageEggShowFail_u24lambda_u240.getExtra();
        $this$reportSplashSecondPageEggShowFail_u24lambda_u240_u240.putString("reason", String.valueOf(reason));
        $this$reportSplashSecondPageEggShowFail_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_click_egg_show_fail", reportPreset, $this$reportSplashSecondPageEggShowFail_u24lambda_u240);
    }

    public static /* synthetic */ void reportSplashOrderSelectFilterEvent$adsplash_debug$default(SplashAdHelper splashAdHelper, int i, SplashOrder splashOrder, long j, int i2, String str, int i3, boolean z, String str2, SplashOrderFilterReason splashOrderFilterReason, int i4, Object obj) {
        String str3;
        if ((i4 & BR.cover) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        splashAdHelper.reportSplashOrderSelectFilterEvent$adsplash_debug(i, splashOrder, j, i2, str, i3, z, str3, splashOrderFilterReason);
    }

    public final void reportSplashOrderSelectFilterEvent$adsplash_debug(int step, SplashOrder splash, long splashId, int index, String splashRequestId, int openEvent, boolean isRealShow, String adCb, SplashOrderFilterReason reason) {
        IAdInfo adInfo;
        Intrinsics.checkNotNullParameter(splashRequestId, "splashRequestId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset((splash == null || (adInfo = ExtSplashOrderKt.adInfo(splash)) == null) ? null : adInfo.getReportInfo());
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(adCb, (String) null);
        }
        UIExtraParams $this$reportSplashOrderSelectFilterEvent_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240 = $this$reportSplashOrderSelectFilterEvent_u24lambda_u240.getExtra();
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("step", String.valueOf(step));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("splash_request_id", splashRequestId);
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("source_id", String.valueOf(SplashReportConfig.INSTANCE.getSourceId()));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("resource_id", String.valueOf(SplashReportConfig.INSTANCE.getResourceId()));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splashId));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("index", String.valueOf(index));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("reason", String.valueOf(reason.getReason()));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("open_event", String.valueOf(openEvent));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("is_real_show", String.valueOf(isRealShow));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_show_filter", reportPreset, $this$reportSplashOrderSelectFilterEvent_u24lambda_u240);
    }

    public final void reportTopVideoTransitionSuccess$adsplash_debug(SplashOrder splash) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(adInfo != null ? adInfo.getReportInfo() : null);
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.getAdCb(), (String) null);
        }
        UIExtraParams $this$reportTopVideoTransitionSuccess_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportTopVideoTransitionSuccess_u24lambda_u240_u240 = $this$reportTopVideoTransitionSuccess_u24lambda_u240.getExtra();
        $this$reportTopVideoTransitionSuccess_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("top_video_transition", reportPreset, $this$reportTopVideoTransitionSuccess_u24lambda_u240);
    }

    public final void reportTopVideoTransitionDownSuccess$adsplash_debug(SplashOrder splash, int reason) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(adInfo != null ? adInfo.getReportInfo() : null);
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.getAdCb(), (String) null);
        }
        UIExtraParams $this$reportTopVideoTransitionDownSuccess_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportTopVideoTransitionDownSuccess_u24lambda_u240_u240 = $this$reportTopVideoTransitionDownSuccess_u24lambda_u240.getExtra();
        $this$reportTopVideoTransitionDownSuccess_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        $this$reportTopVideoTransitionDownSuccess_u24lambda_u240_u240.putString("reason", String.valueOf(reason));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("top_video_transition_down", reportPreset, $this$reportTopVideoTransitionDownSuccess_u24lambda_u240);
    }

    public final void reportVideoFirstRenderCostMs$adsplash_debug(SplashOrder splash, long timeMs) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo(splash);
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(adInfo != null ? adInfo.getReportInfo() : null);
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.getAdCb(), (String) null);
        }
        UIExtraParams $this$reportVideoFirstRenderCostMs_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM(UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Bundle $this$reportVideoFirstRenderCostMs_u24lambda_u240_u240 = $this$reportVideoFirstRenderCostMs_u24lambda_u240.getExtra();
        $this$reportVideoFirstRenderCostMs_u24lambda_u240_u240.putString("first_frame_render_ms", String.valueOf(timeMs));
        $this$reportVideoFirstRenderCostMs_u24lambda_u240_u240.putString(IS_NEW_SPLASH, "1");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("first_frame_render", reportPreset, $this$reportVideoFirstRenderCostMs_u24lambda_u240);
    }
}