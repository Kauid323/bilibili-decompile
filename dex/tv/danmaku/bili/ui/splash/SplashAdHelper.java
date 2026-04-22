package tv.danmaku.bili.ui.splash;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.adcommon.basic.Motion;
import com.bilibili.adcommon.config.DDConfig;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.WxProgramInfo;
import com.bilibili.gripper.api.ad.core.GAdClick;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdReport;
import com.bilibili.gripper.api.ad.core.click.IAdUriNavigate;
import com.bilibili.gripper.api.ad.core.report.ExtraParams;
import com.bilibili.gripper.api.ad.core.report.IAdReportHelper;
import com.bilibili.gripper.api.ad.core.report.IAdUIEventReporter;
import com.bilibili.gripper.api.ad.core.report.IReportPreset;
import com.bilibili.gripper.api.ad.core.report.ReportPresetKt;
import com.bilibili.gripper.api.ad.core.report.SimpleAdReportPreset;
import com.bilibili.gripper.api.ad.core.report.UIExtraParams;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.splash.ad.button.model.DegradeType;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.splash.ad.config.SplashConstantKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.event.EventSplashData;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SplashAdHelper.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002¨\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010#\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010%\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010&\u001a\u00020\u0005H\u0007J\u0012\u0010'\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010(\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010&\u001a\u00020\u0005H\u0007J\u001a\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0005J \u0010,\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\bJ\"\u00100\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010\u0005J$\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u00103\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u000205H\u0007J\u001a\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\u0018H\u0007J\u000e\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;J&\u0010<\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u00020\u00052\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010>\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010?\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJG\u0010@\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010E\u001a\u00020.2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010GJQ\u0010@\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010A\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010E\u001a\u00020.2\b\b\u0002\u0010I\u001a\u00020\u00182\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010JJ\u0012\u0010K\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010L\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005H\u0007J<\u0010M\u001a\u00020$2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010N\u001a\u0002052\b\b\u0002\u0010O\u001a\u00020\b2\b\b\u0002\u0010P\u001a\u00020\b2\b\b\u0002\u0010Q\u001a\u00020\bH\u0007J\"\u0010R\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\bH\u0007J\u001a\u0010U\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010V\u001a\u00020\bH\u0007J\u001c\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010\u00052\b\u0010Y\u001a\u0004\u0018\u00010\u0005H\u0007J8\u0010Z\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u0002052\u0006\u0010^\u001a\u0002052\u0006\u0010_\u001a\u00020\u0018H\u0007J\u000e\u0010`\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010a\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010b\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020dH\u0007J \u0010e\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0018H\u0007J\u0010\u0010i\u001a\u00020$2\u0006\u0010j\u001a\u00020\u0018H\u0007J\u0010\u0010k\u001a\u00020$2\u0006\u0010l\u001a\u00020.H\u0007J\u000e\u0010m\u001a\u00020$2\u0006\u0010l\u001a\u00020.J\u0010\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u00020.H\u0007J\u0017\u0010p\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\bqJ'\u0010r\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010s\u001a\u00020.2\u0006\u0010t\u001a\u00020\u0018H\u0000¢\u0006\u0002\buJ\u001f\u0010v\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010s\u001a\u00020.H\u0000¢\u0006\u0002\bwJ\u0017\u0010x\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\byJ\u0018\u0010z\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010{\u001a\u00020\bJ\u0017\u0010|\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\b}J\u001a\u0010~\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010s\u001a\u00020.H\u0007J\"\u0010\u007f\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010{\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u0080\u0001J.\u0010\u0081\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0007\u0010\u0082\u0001\u001a\u00020\u00182\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0003\b\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0013\u0010\u0085\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0011\u0010\u0086\u0001\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001f\u0010\u0087\u0001\u001a\u00020$2\u0006\u0010{\u001a\u00020\b2\u000e\u0010\u0088\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0089\u0001J8\u0010\u008a\u0001\u001a\u00020$2\u0007\u0010\u008b\u0001\u001a\u00020.2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\u0019\u0010\u008e\u0001\u001a\u00020$2\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020.0\u0089\u0001H\u0007J\u0010\u0010\u0090\u0001\u001a\u00020$2\u0007\u0010\u0091\u0001\u001a\u00020.J\u001e\u0010\u0092\u0001\u001a\u00020$2\u0007\u0010\u0093\u0001\u001a\u00020.2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J*\u0010\u0094\u0001\u001a\u00020$2\u0007\u0010\u0093\u0001\u001a\u00020.2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\u0019\u0010\u0095\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010{\u001a\u00020\bJ_\u0010\u0096\u0001\u001a\u00020$2\u0007\u0010\u0097\u0001\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0007\u0010\u0098\u0001\u001a\u00020.2\u0007\u0010\u0099\u0001\u001a\u00020\b2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\b2\u0007\u0010\u009b\u0001\u001a\u00020\u00182\u0007\u0010{\u001a\u00030\u009c\u00012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\u0019\u0010\u009d\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0003\b\u009e\u0001J!\u0010\u009f\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010{\u001a\u00020\bH\u0000¢\u0006\u0003\b \u0001J!\u0010¡\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0003\b¢\u0001J!\u0010£\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0003\b¤\u0001J\"\u0010¥\u0001\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0007\u0010¦\u0001\u001a\u00020.H\u0000¢\u0006\u0003\b§\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006©\u0001"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashAdHelper;", "", "<init>", "()V", "TAG", "", "URI_PARAM_FROM_SPMID", "DOWNLOAD_TYPE_NETWORK", "", "CON_VIDEO_JUMP_NORMAL_BUTTON_CLICK", "CON_VIDEO_JUMP_CLICK", "CON_VIDEO_JUMP_PLAY_COMPLETE", "CON_VIDEO_JUMP_FULL_SCREEN_SLIDE", "CON_VIDEO_JUMP_EGG_VIDEO_PLAY_COMPLETE", "CON_VIDEO_VOICE_CLOSE", "CON_VIDEO_VOICE_OPEN", "lastSplashRequestId", "getLastSplashRequestId", "()Ljava/lang/String;", "setLastSplashRequestId", "(Ljava/lang/String;)V", "reportTouchSpotJob", "Lkotlinx/coroutines/Job;", "handleAdJump", "", "context", "Landroid/content/Context;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "schemeUrl", "jumpUrl", "prioritySchemeUrl", "priorityJumpUrl", "wxProgramInfo", "Lcom/bilibili/adcommon/data/model/WxProgramInfo;", "reportSecondPageVideoShowSuccess", "", "reportSecondPageVideoJump", "type", "reportSecondPageVideoClose", "reportSecondPageSoundButtonClick", "reportMiddlePageShow", PeakTaskDefine.AD_CB, "pageUrl", "reportMiddlePageExit", "playTime", "", "closeType", "reportMiddlePageClick", "onJumpCallBack", "event", "adSplashSkip", "adShowTime", "", "stockReport", "openEvent", "isDeepLink", "adReportEventSplashExposed", "eventSplashData", "Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "adReportSplashExposed", "eventFrom", "adReportMiddlePageExposed", "adReportMiddlePageClicked", "adReportSplashClicked", "withFrom", "actionType", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashActionType;", "buttonId", "showTimeBeforeClick", "cardIndex", "(Ltv/danmaku/bili/ui/splash/ad/model/Splash;ZLtv/danmaku/bili/ui/splash/ad/button/model/SplashActionType;Ljava/lang/String;JLjava/lang/Integer;)V", "from", "doThirdReport", "(Ltv/danmaku/bili/ui/splash/ad/model/Splash;ZLjava/lang/String;Ljava/lang/String;JZLjava/lang/Integer;)V", "adSplashDownloadSuccess", "adSplashSlideFail", "reportSplashInteract", "distance", "triggerDistance", "angle", "triggerAngle", "reportSplashTwist", "axis", "twistType", "reportSplashDefaultWordExpose", "notShowReason", "appendFromSpmid", RankRouter.RankConst.TYPE_ORIGINAL, "spmid", "adSplashClickPositionReport", "width", "height", "positionX", "positionY", "hasGuideButton", "adSplashSlideFailed", "adSplashOutsideClick", "adSplashButtonUIClick", "splashGuideButton", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "adSplashButtonLottieDegradeEvent", "degradeType", "Ltv/danmaku/bili/ui/splash/ad/button/model/DegradeType;", "isSecondPage", "adSplashCacheUIEvent", "over60", "reportSplashCacheSize", "usedSize", "reportEffectiveSplashCacheSize", "adSplashCodeRequestUIEvent", "size", "reportSplashEggShow", "reportSplashEggShow$splash_debug", "reportSplashEggClick", "showTime", "enableJump", "reportSplashEggClick$splash_debug", "reportSplashEggClose", "reportSplashEggClose$splash_debug", "reportSplashEggPlayDone", "reportSplashEggPlayDone$splash_debug", "reportSplashEggShowFail", "reason", "reportSplashClickableEggShow", "reportSplashClickableEggShow$splash_debug", "reportSplashClickableEggClick", "reportSplashClickableEggShowFailed", "reportSplashClickableEggShowFailed$splash_debug", "reportSplashTopViewTransitionShow", "success", "reportSplashTopViewTransitionShow$splash_debug", "adSplashRealtimeFinishUIEvent", "adSplashRealtimeFailUIEvent", "reportRealtimeMatShow", "reportSplashResourcesDelete", "resources", "", "reportNewProgramSplashReceive", "keepId", "videoState", "imageState", "reportSplashOrderDelete", "ids", "reportPreloadDataExpired", "timeDifference", "reportLiveReservationSuc", "liveReservationId", "reportLiveReservationFail", "reportSplashSecondPageEggShowFail", "reportSplashOrderSelectFilterEvent", "step", "splashId", "index", "splashRequestId", "isRealShow", "Ltv/danmaku/bili/ui/splash/SplashOrderFilterReason;", "reportTopVideoTransitionSuccess", "reportTopVideoTransitionSuccess$splash_debug", "reportTopVideoTransitionDownSuccess", "reportTopVideoTransitionDownSuccess$splash_debug", "reportVideoPlaySecondFee", "reportVideoPlaySecondFee$splash_debug", "reportVideoPlaySecondUi", "reportVideoPlaySecondUi$splash_debug", "reportVideoFirstRenderCostMs", "timeMs", "reportVideoFirstRenderCostMs$splash_debug", "SplashAdCallUpEvent", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashAdHelper {
    public static final String CON_VIDEO_JUMP_CLICK = "1";
    public static final String CON_VIDEO_JUMP_EGG_VIDEO_PLAY_COMPLETE = "4";
    public static final String CON_VIDEO_JUMP_FULL_SCREEN_SLIDE = "3";
    public static final String CON_VIDEO_JUMP_NORMAL_BUTTON_CLICK = "0";
    public static final String CON_VIDEO_JUMP_PLAY_COMPLETE = "2";
    public static final String CON_VIDEO_VOICE_CLOSE = "0";
    public static final String CON_VIDEO_VOICE_OPEN = "1";
    private static final int DOWNLOAD_TYPE_NETWORK = 1;
    private static final String TAG = "[Splash]SplashAdHelper";
    private static final String URI_PARAM_FROM_SPMID = "from_spmid";
    private static volatile String lastSplashRequestId;
    private static Job reportTouchSpotJob;
    public static final SplashAdHelper INSTANCE = new SplashAdHelper();
    public static final int $stable = 8;

    /* compiled from: SplashAdHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean z, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "from");
        adReportSplashClicked$default(splash, z, str, null, j, false, null, 104, null);
    }

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean z, String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "from");
        adReportSplashClicked$default(splash, z, str, str2, j, false, null, 96, null);
    }

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean z, String str, String str2, long j, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "from");
        adReportSplashClicked$default(splash, z, str, str2, j, z2, null, 64, null);
    }

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean z, SplashActionType splashActionType, long j) {
        Intrinsics.checkNotNullParameter(splashActionType, "actionType");
        adReportSplashClicked$default(splash, z, splashActionType, null, j, null, 40, null);
    }

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean z, SplashActionType splashActionType, String str, long j) {
        Intrinsics.checkNotNullParameter(splashActionType, "actionType");
        adReportSplashClicked$default(splash, z, splashActionType, str, j, null, 32, null);
    }

    @JvmStatic
    public static final void adReportSplashExposed(Splash splash, String str) {
        Intrinsics.checkNotNullParameter(str, "openEvent");
        adReportSplashExposed$default(splash, str, null, 4, null);
    }

    private SplashAdHelper() {
    }

    public final String getLastSplashRequestId() {
        return lastSplashRequestId;
    }

    public final void setLastSplashRequestId(String str) {
        lastSplashRequestId = str;
    }

    /* compiled from: SplashAdHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashAdHelper$SplashAdCallUpEvent;", "", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface SplashAdCallUpEvent {
        public static final String CALLUP_FAIL_NA_NOT_INSTALL = "callup_fail_NA_not_install";
        public static final String CALLUP_FAIL_NA_USER_CANCEL = "callup_fail_NA_user_cancel";
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String NA_CALLUP_FAIL = "NA_callup_fail";
        public static final String NA_CALLUP_SUC = "NA_callup_suc";

        /* compiled from: SplashAdHelper.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashAdHelper$SplashAdCallUpEvent$Companion;", "", "<init>", "()V", "NA_CALLUP_SUC", "", "NA_CALLUP_FAIL", "CALLUP_FAIL_NA_USER_CANCEL", "CALLUP_FAIL_NA_NOT_INSTALL", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String CALLUP_FAIL_NA_NOT_INSTALL = "callup_fail_NA_not_install";
            public static final String CALLUP_FAIL_NA_USER_CANCEL = "callup_fail_NA_user_cancel";
            public static final String NA_CALLUP_FAIL = "NA_callup_fail";
            public static final String NA_CALLUP_SUC = "NA_callup_suc";

            private Companion() {
            }
        }
    }

    @JvmStatic
    public static final boolean handleAdJump(Context context, Splash splash, String schemeUrl, String jumpUrl, String prioritySchemeUrl, String priorityJumpUrl, WxProgramInfo wxProgramInfo) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(splash, "splash");
        RouteRequest mainRequest = new RouteRequest.Builder(Uri.parse("bilibili://root")).build();
        if (!splash.isHotSplash) {
            BLRouter.routeTo(mainRequest, context2);
        }
        Function1 action = new Function1() { // from class: tv.danmaku.bili.ui.splash.SplashAdHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String appendFromSpmid;
                appendFromSpmid = SplashAdHelper.appendFromSpmid((String) obj, SplashConstantKt.SPLASH_SPMID);
                return appendFromSpmid;
            }
        };
        GAdCoreKt.getGAdReport().uiEvent("splash_callup_degrade", new SimpleAdReportPreset(splash.adCb, (String) null));
        GAdClick gAdClick = GAdCoreKt.getGAdClick();
        IAdInfo adInfo = splash.getAdInfo();
        IAdUriNavigate.NavigateInfo[] navigateInfoArr = new IAdUriNavigate.NavigateInfo[2];
        String str = (String) action.invoke(prioritySchemeUrl);
        String str2 = (String) action.invoke(priorityJumpUrl);
        String str3 = splash.userCancelJumpUrl;
        navigateInfoArr[0] = new IAdUriNavigate.NavigateInfo(str, str2, (String) action.invoke(str3 == null || StringsKt.isBlank(str3) ? priorityJumpUrl : splash.userCancelJumpUrl), splash.cancelJumpType == 1, splash.enableDoubleJump, wxProgramInfo);
        String str4 = (String) action.invoke(schemeUrl);
        String str5 = (String) action.invoke(jumpUrl);
        String str6 = splash.userCancelJumpUrl;
        String str7 = (String) action.invoke(str6 == null || StringsKt.isBlank(str6) ? jumpUrl : splash.userCancelJumpUrl);
        boolean z = splash.enableDoubleJump;
        boolean z2 = splash.cancelJumpType == 1;
        IClickInfo clickInfo = splash.getAdInfo().getClickInfo();
        navigateInfoArr[1] = new IAdUriNavigate.NavigateInfo(str4, str5, str7, z2, z, clickInfo != null ? clickInfo.wxProgramInfo() : null);
        return gAdClick.navigate(context2, adInfo, (IReportPreset) null, navigateInfoArr);
    }

    @JvmStatic
    public static final void reportSecondPageVideoShowSuccess(Splash splash) {
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("show", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("con_video_show_suc"));
    }

    @JvmStatic
    public static final void reportSecondPageVideoJump(Splash splash, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("con_video_callup_suc").TYPE(type));
    }

    @JvmStatic
    public static final void reportSecondPageVideoClose(Splash splash) {
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("con_video_close"));
    }

    @JvmStatic
    public static final void reportSecondPageSoundButtonClick(Splash splash, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("voice_click").TYPE(type));
    }

    public final void reportMiddlePageShow(String adCb, String pageUrl) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(adCb, (String) null);
        UIExtraParams $this$reportMiddlePageShow_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("resume_playback_page");
        $this$reportMiddlePageShow_u24lambda_u240.getExtra().putString("page_url", pageUrl == null ? "" : pageUrl);
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("show", simpleAdReportPreset, $this$reportMiddlePageShow_u24lambda_u240);
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

    @JvmStatic
    public static final void onJumpCallBack(String event, Splash splash, String jumpUrl) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent(event, new SimpleAdReportPreset(splash.adCb, jumpUrl));
    }

    @JvmStatic
    public static final void adSplashSkip(Splash splash, float adShowTime) {
        if (splash != null && splash.isAdLoc) {
            ExtraParams extraParams = new ExtraParams.ExtraBuilder().SPLASH_REQUEST_ID(splash.splashRequestId).SHOW_TIME(adShowTime).build();
            GAdCoreKt.getGAdReport().splashSkip(splash.getAdInfo().getReportInfo(), extraParams);
        }
    }

    public static /* synthetic */ void stockReport$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        stockReport(str, z);
    }

    @JvmStatic
    public static final void stockReport(String openEvent, boolean isDeepLink) {
        Intrinsics.checkNotNullParameter(openEvent, "openEvent");
        BLog.i(TAG, "stockReport openEvent = " + openEvent);
        Splash stockSplash = new Splash();
        stockSplash.isAdLoc = true;
        stockSplash.resourceId = 926L;
        stockSplash.source = 929;
        stockSplash.requestId = String.valueOf(System.currentTimeMillis());
        stockSplash.splashRequestId = lastSplashRequestId;
        stockSplash.isFromCalledUp = isDeepLink;
        adReportSplashExposed$default(stockSplash, openEvent, null, 4, null);
        SplashCustomReporterKt.reportSplashStock(Intrinsics.areEqual(openEvent, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT), isDeepLink);
    }

    public final void adReportEventSplashExposed(EventSplashData eventSplashData) {
        String eventFrom;
        Intrinsics.checkNotNullParameter(eventSplashData, "eventSplashData");
        Splash eventSplash = new Splash();
        boolean z = true;
        eventSplash.isAdLoc = true;
        eventSplash.resourceId = 926L;
        eventSplash.source = 929;
        switch (eventSplashData.getEventType()) {
            case 0:
                eventFrom = "birthday";
                break;
            case 1:
                eventFrom = "register";
                break;
            case 2:
                eventFrom = "event";
                break;
            default:
                eventFrom = null;
                break;
        }
        String str = eventFrom;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (z) {
            BLog.i("SplashAdHelper", "report event splash expose failed, event from is null");
        } else {
            adReportSplashExposed(eventSplash, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD, eventFrom);
        }
    }

    public static /* synthetic */ void adReportSplashExposed$default(Splash splash, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        adReportSplashExposed(splash, str, str2);
    }

    @JvmStatic
    public static final void adReportSplashExposed(Splash splash, String openEvent, String eventFrom) {
        Intrinsics.checkNotNullParameter(openEvent, "openEvent");
        if (splash != null && splash.isAdLoc) {
            IAdReportInfo adReportInfo = splash.getAdInfo().getReportInfo();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new SplashAdHelper$adReportSplashExposed$1$1(splash, openEvent, eventFrom, adReportInfo, splash, null), 3, (Object) null);
        }
    }

    public final void adReportMiddlePageExposed(Splash splash) {
        if (splash != null) {
            IAdReportInfo adReportInfo = splash.getAdInfo().getReportInfo();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new SplashAdHelper$adReportMiddlePageExposed$1$1(adReportInfo, splash, null), 3, (Object) null);
        }
    }

    public final void adReportMiddlePageClicked(Splash splash) {
        if (splash != null) {
            IAdReportInfo adReportInfo = splash.getAdInfo().getReportInfo();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new SplashAdHelper$adReportMiddlePageClicked$1$1(adReportInfo, splash, null), 3, (Object) null);
        }
    }

    public static /* synthetic */ void adReportSplashClicked$default(Splash splash, boolean z, SplashActionType splashActionType, String str, long j, Integer num, int i, Object obj) {
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
        adReportSplashClicked(splash, z, splashActionType, str2, j, num2);
    }

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean withFrom, SplashActionType actionType, String buttonId, long showTimeBeforeClick, Integer cardIndex) {
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
        adReportSplashClicked(splash, withFrom, feedEventFrom, buttonId, showTimeBeforeClick, true, cardIndex);
    }

    public static /* synthetic */ void adReportSplashClicked$default(Splash splash, boolean z, String str, String str2, long j, boolean z2, Integer num, int i, Object obj) {
        adReportSplashClicked(splash, z, str, (i & 8) != 0 ? null : str2, j, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : num);
    }

    @JvmStatic
    public static final void adReportSplashClicked(Splash splash, boolean withFrom, String from, String buttonId, long showTimeBeforeClick, boolean doThirdReport, Integer cardIndex) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (splash != null && splash.isAdLoc) {
            IAdReportInfo adReportInfo = splash.getAdInfo().getReportInfo();
            ExtraParams.ExtraBuilder extraParams = new ExtraParams.ExtraBuilder().SPLASH_REQUEST_ID(splash.splashRequestId).SHOW_TIME(showTimeBeforeClick);
            if (withFrom) {
                extraParams.EVENT_FROM(from);
            }
            if (buttonId != null) {
                extraParams.SPLASH_BUTTON_ID(buttonId);
            }
            GAdReport gAdReport = GAdCoreKt.getGAdReport();
            ExtraParams $this$adReportSplashClicked_u24lambda_u240_u240 = extraParams.build();
            $this$adReportSplashClicked_u24lambda_u240_u240.getExtra().putString("is_out_open_deeplink", String.valueOf(splash.isFromCalledUp ? 1 : 0));
            if (cardIndex != null) {
                $this$adReportSplashClicked_u24lambda_u240_u240.getExtra().putString("card_index", String.valueOf(cardIndex.intValue()));
            }
            Unit unit = Unit.INSTANCE;
            gAdReport.event("click", adReportInfo, $this$adReportSplashClicked_u24lambda_u240_u240);
            Unit unit2 = Unit.INSTANCE;
            Job job = reportTouchSpotJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            if (doThirdReport) {
                IAdReportHelper.-CC.clickedMMAWithRequestId$default(GAdCoreKt.getGAdReport(), adReportInfo, (Motion) null, (String) null, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void adSplashDownloadSuccess(String adCb) {
        String str = adCb;
        if (str == null || StringsKt.isBlank(str)) {
            BLog.i(TAG, "adSplashDownloadSuccess, adCb = null");
            return;
        }
        UIExtraParams $this$adSplashDownloadSuccess_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$adSplashDownloadSuccess_u24lambda_u240.DOWNLOAD_TYPE(1);
        GAdCoreKt.getGAdReport().uiEvent("cre_dl_suc", new SimpleAdReportPreset(adCb, (String) null), $this$adSplashDownloadSuccess_u24lambda_u240);
    }

    public static /* synthetic */ void adSplashSlideFail$default(Splash splash, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        adSplashSlideFail(splash, str);
    }

    @JvmStatic
    public static final void adSplashSlideFail(Splash splash, String eventFrom) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        UIExtraParams uIExtraParams = null;
        if (eventFrom != null) {
            uIExtraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM(eventFrom);
        }
        GAdCoreKt.getGAdReport().uiEvent("splash_slide_fail", new SimpleAdReportPreset(splash.adCb, (String) null), uIExtraParams);
    }

    public static /* synthetic */ void reportSplashInteract$default(Splash splash, float f, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            splash = null;
        }
        if ((i4 & 2) != 0) {
            f = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        if ((i4 & 4) != 0) {
            i = 0;
        }
        if ((i4 & 8) != 0) {
            i2 = 0;
        }
        if ((i4 & 16) != 0) {
            i3 = 0;
        }
        reportSplashInteract(splash, f, i, i2, i3);
    }

    @JvmStatic
    public static final void reportSplashInteract(Splash splash, float distance, int triggerDistance, int angle, int triggerAngle) {
        GAdCoreKt.getGAdReport().uiEvent("splash_interact_event", new SimpleAdReportPreset(splash != null ? splash.adCb : null, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SPLASH_DISTANCE(String.valueOf((int) distance)).SPLASH_TRIGGER_DISTANCE(String.valueOf(triggerDistance)).SPLASH_ANGLE(String.valueOf(angle)).SPLASH_TRIGGER_ANGLE(String.valueOf(triggerAngle)));
    }

    @JvmStatic
    public static final void reportSplashTwist(Splash splash, int axis, int twistType) {
        GAdCoreKt.getGAdReport().uiEvent("splash_interact_twist", new SimpleAdReportPreset(splash != null ? splash.adCb : null, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SPLASH_TWIST_AXIS(String.valueOf(axis)).SPLASH_TWIST_TYPE(String.valueOf(twistType)));
    }

    @JvmStatic
    public static final void reportSplashDefaultWordExpose(Splash splash, int notShowReason) {
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("search_show_suc", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SPLASH_ID(String.valueOf(splash.id)).SPLASH_SEARCH_WORD(splash.keyword).SPLASH_SEARCH_WORD_NOT_SHOW_REASON(String.valueOf(notShowReason)));
    }

    @JvmStatic
    public static final String appendFromSpmid(String original, String spmid) {
        String str = original;
        boolean z = false;
        if (str == null || str.length() == 0) {
            return "";
        }
        Uri uri = Uri.parse(original);
        if (AppConfig.isBiliDomain(uri)) {
            Uri.Builder $this$appendFromSpmid_u24lambda_u240 = uri.buildUpon();
            String queryParameter = uri.getQueryParameter("from_spmid");
            boolean z2 = queryParameter == null || queryParameter.length() == 0;
            String str2 = spmid;
            if (str2 == null || str2.length() == 0) {
                z = true;
            }
            if ((!z) & z2) {
                $this$appendFromSpmid_u24lambda_u240.appendQueryParameter("from_spmid", spmid);
            }
            String uri2 = $this$appendFromSpmid_u24lambda_u240.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "run(...)");
            return uri2;
        }
        return original;
    }

    @JvmStatic
    public static final void adSplashClickPositionReport(Splash splash, int width, int height, float positionX, float positionY, boolean hasGuideButton) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Bundle $this$adSplashClickPositionReport_u24lambda_u240 = new Bundle();
        $this$adSplashClickPositionReport_u24lambda_u240.putString("platform_name", "Android");
        $this$adSplashClickPositionReport_u24lambda_u240.putString("screen_size", width + "*" + height);
        float f = 100;
        $this$adSplashClickPositionReport_u24lambda_u240.putString("click_position_x", String.valueOf(MathKt.roundToInt((positionX / width) * f)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString("click_position_y", String.valueOf(MathKt.roundToInt((positionY / height) * f)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString("full_screen", "0");
        $this$adSplashClickPositionReport_u24lambda_u240.putString("top_safe_zone", "0");
        $this$adSplashClickPositionReport_u24lambda_u240.putString("bottom_safe_zone", "0");
        boolean isFullscreen = splash.isFullscreen();
        $this$adSplashClickPositionReport_u24lambda_u240.putString("button_zone", (isFullscreen || hasGuideButton) ? "0" : String.valueOf(UiUtils.dp2Px(48)));
        $this$adSplashClickPositionReport_u24lambda_u240.putString("brand_zone", isFullscreen ? "0" : String.valueOf((int) (height / 8.0f)));
        UIExtraParams extraParams = new UIExtraParams($this$adSplashClickPositionReport_u24lambda_u240);
        GAdCoreKt.getGAdReport().uiEvent("click_position", new SimpleAdReportPreset(splash.adCb, splash.jumpUrl), extraParams);
    }

    public final void adSplashSlideFailed(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("ad_splash_button_slide_failed");
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.adCb, splash.jumpUrl), extraParams);
    }

    @JvmStatic
    public static final void adSplashOutsideClick(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("ad_splash_card");
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.adCb, splash.jumpUrl), extraParams);
    }

    @JvmStatic
    public static final void adSplashButtonUIClick(Splash splash, SplashGuideButton splashGuideButton) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("ad_splash_button");
        GAdCoreKt.getGAdReport().uiEvent("click", new SimpleAdReportPreset(splash.adCb, splashGuideButton.getJumpUrl()), extraParams);
    }

    @JvmStatic
    public static final void adSplashButtonLottieDegradeEvent(Splash splash, DegradeType degradeType, boolean isSecondPage) {
        String eventFrom;
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(degradeType, "degradeType");
        if (isSecondPage) {
            eventFrom = "splash_second";
        } else {
            eventFrom = splash.isRealTimeSplash ? "realtime" : "local";
        }
        GAdCoreKt.getGAdReport().uiEvent("lottie_button_degraded", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).DEGRADE_TYPE(degradeType.getValue()).EVENT_FROM(eventFrom));
    }

    @JvmStatic
    public static final void adSplashCacheUIEvent(boolean over60) {
        if (over60) {
            IAdUIEventReporter.-CC.uiEvent$default(GAdCoreKt.getGAdReport(), "splash_cache_60m", (IReportPreset) null, (Function1) null, 6, (Object) null);
        } else {
            IAdUIEventReporter.-CC.uiEvent$default(GAdCoreKt.getGAdReport(), "splash_cache_40m", (IReportPreset) null, (Function1) null, 6, (Object) null);
        }
    }

    @JvmStatic
    public static final void reportSplashCacheSize(long usedSize) {
        double currentSize = (usedSize / 1024.0d) / 1024.0d;
        DecimalFormat format = new DecimalFormat("#.#");
        format.setRoundingMode(RoundingMode.HALF_UP);
        UIExtraParams uIExtraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        String format2 = format.format(currentSize);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        UIExtraParams params = uIExtraParams.SPLASH_CURRENT_SIZE(format2).SPLASH_OVERALL_SIZE(String.valueOf(DownloadBizType.Splash.getMaxSizeMB()));
        GAdCoreKt.getGAdReport().uiEvent("splash_cache_monitor", params);
    }

    public final void reportEffectiveSplashCacheSize(long usedSize) {
        double currentSize = (usedSize / 1024.0d) / 1024.0d;
        DecimalFormat format = new DecimalFormat("#.#");
        format.setRoundingMode(RoundingMode.HALF_UP);
        UIExtraParams uIExtraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        String format2 = format.format(currentSize);
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        UIExtraParams params = uIExtraParams.SPLASH_CURRENT_SIZE(format2).SPLASH_OVERALL_SIZE(String.valueOf(DownloadBizType.EffectSplash.getMaxSizeMB()));
        GAdCoreKt.getGAdReport().uiEvent("splash_cache_monitor_effect", params);
    }

    @JvmStatic
    public static final void adSplashCodeRequestUIEvent(long size) {
        if (size >= 0) {
            UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_LIST_COUNT(String.valueOf(size));
            extraParams.getExtra().putString("mixin_banner", DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() ? "1" : "0");
            GAdCoreKt.getGAdReport().uiEvent("splash_cold_request_success", extraParams);
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$adSplashCodeRequestUIEvent_u24lambda_u241 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$adSplashCodeRequestUIEvent_u24lambda_u241.getExtra().putString("mixin_banner", DDConfig.INSTANCE.getSplashTopViewBannerMixinExp() ? "1" : "0");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_cold_request_fail", $this$adSplashCodeRequestUIEvent_u24lambda_u241);
    }

    public final void reportSplashEggShow$splash_debug(Splash splash) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggShow");
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_show", new SimpleAdReportPreset(splash.adCb, (String) null));
    }

    public final void reportSplashEggClick$splash_debug(Splash splash, long showTime, boolean enableJump) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggClick, showTime = " + showTime + ", enableJump = " + enableJump);
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(splash.adCb, (String) null);
        UIExtraParams $this$reportSplashEggClick_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(showTime);
        $this$reportSplashEggClick_u24lambda_u240.getExtra().putString("enable_jump", enableJump ? "1" : "0");
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_egg_click", simpleAdReportPreset, $this$reportSplashEggClick_u24lambda_u240);
    }

    public final void reportSplashEggClose$splash_debug(Splash splash, long showTime) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggClose, showTime = " + showTime);
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_close", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(showTime));
    }

    public final void reportSplashEggPlayDone$splash_debug(Splash splash) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggPlayDone");
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_play_done", new SimpleAdReportPreset(splash.adCb, (String) null));
    }

    public final void reportSplashEggShowFail(Splash splash, int reason) {
        if (splash == null) {
            return;
        }
        BLog.i(TAG, "reportSplashEggShowFail, reason = " + reason);
        UIExtraParams $this$reportSplashEggShowFail_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashEggShowFail_u24lambda_u240.getExtra().putString("reason", String.valueOf(reason));
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_egg_show_fail", new SimpleAdReportPreset(splash.adCb, (String) null), $this$reportSplashEggShowFail_u24lambda_u240);
    }

    public final void reportSplashClickableEggShow$splash_debug(Splash splash) {
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("splash_clickable_egg_show", new SimpleAdReportPreset(splash.adCb, (String) null));
    }

    @JvmStatic
    public static final void reportSplashClickableEggClick(Splash splash, long showTime) {
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().uiEvent("splash_clickable_egg_click", new SimpleAdReportPreset(splash.adCb, (String) null), new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).SHOW_TIME(showTime));
    }

    public static /* synthetic */ void reportSplashClickableEggShowFailed$splash_debug$default(SplashAdHelper splashAdHelper, Splash splash, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "1";
        }
        splashAdHelper.reportSplashClickableEggShowFailed$splash_debug(splash, str);
    }

    public final void reportSplashClickableEggShowFailed$splash_debug(Splash splash, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (splash == null) {
            return;
        }
        UIExtraParams $this$reportSplashClickableEggShowFailed_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashClickableEggShowFailed_u24lambda_u240.getExtra().putString("reason", reason);
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("splash_clickable_egg_show_fail", new SimpleAdReportPreset(splash.adCb, (String) null), $this$reportSplashClickableEggShowFailed_u24lambda_u240);
    }

    public static /* synthetic */ void reportSplashTopViewTransitionShow$splash_debug$default(SplashAdHelper splashAdHelper, Splash splash, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        splashAdHelper.reportSplashTopViewTransitionShow$splash_debug(splash, z, str);
    }

    public final void reportSplashTopViewTransitionShow$splash_debug(Splash splash, boolean success, String reason) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset simpleAdReportPreset = new SimpleAdReportPreset(splash.adCb, (String) null);
        UIExtraParams $this$reportSplashTopViewTransitionShow_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashTopViewTransitionShow_u24lambda_u240.getExtra().putString("show", success ? "1" : "0");
        if (reason != null) {
            $this$reportSplashTopViewTransitionShow_u24lambda_u240.getExtra().putString("reason", reason);
        }
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_top_transition_show", simpleAdReportPreset, $this$reportSplashTopViewTransitionShow_u24lambda_u240);
    }

    @JvmStatic
    public static final void adSplashRealtimeFinishUIEvent(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240 = extraParams.getExtra();
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splash.id));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString("cardtype", String.valueOf(splash.cardType));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString("splash_pic_size", String.valueOf(splash.localSplashImageSize));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString("splash_video_size", String.valueOf(splash.localSplashVideoSize));
        $this$adSplashRealtimeFinishUIEvent_u24lambda_u240_u240.putString(splash.isVideo() ? "video_from" : "event_from", splash.isVideo() ? splash.videoFrom : splash.imageFrom);
        GAdCoreKt.getGAdReport().uiEvent("realtime_mat_load_finish", new SimpleAdReportPreset(splash.adCb, (String) null), extraParams);
    }

    @JvmStatic
    public static final void adSplashRealtimeFailUIEvent(Splash splash) {
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240 = extraParams.getExtra();
        $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splash != null ? Long.valueOf(splash.id) : null));
        $this$adSplashRealtimeFailUIEvent_u24lambda_u240_u240.putString("cardtype", String.valueOf(splash != null ? Integer.valueOf(splash.cardType) : null));
        GAdCoreKt.getGAdReport().uiEvent("realtime_mat_load_fail", new SimpleAdReportPreset(splash != null ? splash.adCb : null, (String) null), extraParams);
    }

    @JvmStatic
    public static final void reportRealtimeMatShow(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        UIExtraParams extraParams = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportRealtimeMatShow_u24lambda_u240_u240 = extraParams.getExtra();
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splash.id));
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString("cardtype", String.valueOf(splash.cardType));
        $this$reportRealtimeMatShow_u24lambda_u240_u240.putString(splash.isVideo() ? "video_from" : "pic_from", splash.isVideo() ? splash.videoFrom : splash.imageFrom);
        GAdCoreKt.getGAdReport().uiEvent("realtime_mat_load_show", new SimpleAdReportPreset(splash.adCb, (String) null), extraParams);
    }

    public final void reportSplashResourcesDelete(int reason, List<String> list) {
        List resources = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(resources, "resources");
        String md5 = CollectionsKt.joinToString$default(resources, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        BLog.i(TAG, "reportSplashResourcesDelete, reason = " + reason + ", md5 = " + md5);
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$reportSplashResourcesDelete_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashResourcesDelete_u24lambda_u240_u240 = $this$reportSplashResourcesDelete_u24lambda_u240.getExtra();
        $this$reportSplashResourcesDelete_u24lambda_u240_u240.putString("delete_reason", String.valueOf(reason));
        $this$reportSplashResourcesDelete_u24lambda_u240_u240.putString("md5", md5);
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_material_delete", $this$reportSplashResourcesDelete_u24lambda_u240);
    }

    public static /* synthetic */ void reportNewProgramSplashReceive$default(long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        reportNewProgramSplashReceive(j, str, str2, str3);
    }

    @JvmStatic
    public static final void reportNewProgramSplashReceive(long keepId, String videoState, String imageState, String adCb) {
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
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("keep_cre_new", simpleAdReportPreset, $this$reportNewProgramSplashReceive_u24lambda_u240);
    }

    @JvmStatic
    public static final void reportSplashOrderDelete(List<Long> list) {
        List ids = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(ids, "ids");
        if (ids.isEmpty()) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$reportSplashOrderDelete_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashOrderDelete_u24lambda_u240_u240 = $this$reportSplashOrderDelete_u24lambda_u240.getExtra();
        $this$reportSplashOrderDelete_u24lambda_u240_u240.putString("id", CollectionsKt.joinToString$default(ids, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_cre_delete", $this$reportSplashOrderDelete_u24lambda_u240);
    }

    public final void reportPreloadDataExpired(long timeDifference) {
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        UIExtraParams $this$reportPreloadDataExpired_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportPreloadDataExpired_u24lambda_u240_u240 = $this$reportPreloadDataExpired_u24lambda_u240.getExtra();
        $this$reportPreloadDataExpired_u24lambda_u240_u240.putString("time_difference", String.valueOf(timeDifference));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_preload_expired", $this$reportPreloadDataExpired_u24lambda_u240);
    }

    public static /* synthetic */ void reportLiveReservationSuc$default(long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        reportLiveReservationSuc(j, str);
    }

    @JvmStatic
    public static final void reportLiveReservationSuc(long liveReservationId, String adCb) {
        UIExtraParams $this$reportLiveReservationSuc_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportLiveReservationSuc_u24lambda_u240_u240 = $this$reportLiveReservationSuc_u24lambda_u240.getExtra();
        $this$reportLiveReservationSuc_u24lambda_u240_u240.putString("live_reservation_id", String.valueOf(liveReservationId));
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("live_reservation_suc", new SimpleAdReportPreset(adCb, (String) null), $this$reportLiveReservationSuc_u24lambda_u240);
    }

    public static /* synthetic */ void reportLiveReservationFail$default(long j, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        reportLiveReservationFail(j, str, str2);
    }

    @JvmStatic
    public static final void reportLiveReservationFail(long liveReservationId, String reason, String adCb) {
        UIExtraParams $this$reportLiveReservationFail_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportLiveReservationFail_u24lambda_u240_u240 = $this$reportLiveReservationFail_u24lambda_u240.getExtra();
        $this$reportLiveReservationFail_u24lambda_u240_u240.putString("live_reservation_id", String.valueOf(liveReservationId));
        $this$reportLiveReservationFail_u24lambda_u240_u240.putString("reason", reason);
        Unit unit = Unit.INSTANCE;
        GAdCoreKt.getGAdReport().uiEvent("live_reservation_fail", new SimpleAdReportPreset(adCb, (String) null), $this$reportLiveReservationFail_u24lambda_u240);
    }

    public final void reportSplashSecondPageEggShowFail(Splash splash, int reason) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(splash.getAdInfo().getReportInfo());
        UIExtraParams $this$reportSplashSecondPageEggShowFail_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportSplashSecondPageEggShowFail_u24lambda_u240.getExtra().putString("reason", String.valueOf(reason));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_click_egg_show_fail", reportPreset, $this$reportSplashSecondPageEggShowFail_u24lambda_u240);
    }

    public static /* synthetic */ void reportSplashOrderSelectFilterEvent$default(int i, Splash splash, long j, int i2, String str, int i3, boolean z, SplashOrderFilterReason splashOrderFilterReason, String str2, int i4, Object obj) {
        String str3;
        if ((i4 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        reportSplashOrderSelectFilterEvent(i, splash, j, i2, str, i3, z, splashOrderFilterReason, str3);
    }

    @JvmStatic
    public static final void reportSplashOrderSelectFilterEvent(int step, Splash splash, long splashId, int index, String splashRequestId, int openEvent, boolean isRealShow, SplashOrderFilterReason reason, String adCb) {
        IAdInfo adInfo;
        Intrinsics.checkNotNullParameter(reason, "reason");
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset((splash == null || (adInfo = splash.getAdInfo()) == null) ? null : adInfo.getReportInfo());
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(adCb, (String) null);
        }
        UIExtraParams $this$reportSplashOrderSelectFilterEvent_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        Bundle $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240 = $this$reportSplashOrderSelectFilterEvent_u24lambda_u240.getExtra();
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("step", String.valueOf(step));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("splash_request_id", splashRequestId == null ? "" : splashRequestId);
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("source_id", String.valueOf(SplashReportConfig.INSTANCE.getSourceId()));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("resource_id", String.valueOf(SplashReportConfig.INSTANCE.getResourceId()));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString(PeakTaskDefine.SPLASH_ID, String.valueOf(splashId));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("index", String.valueOf(index));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("reason", String.valueOf(reason.getReason()));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("open_event", String.valueOf(openEvent));
        $this$reportSplashOrderSelectFilterEvent_u24lambda_u240_u240.putString("is_real_show", String.valueOf(isRealShow ? 1 : 0));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("splash_show_filter", reportPreset, $this$reportSplashOrderSelectFilterEvent_u24lambda_u240);
    }

    public final void reportTopVideoTransitionSuccess$splash_debug(Splash splash) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(splash.getAdInfo().getReportInfo());
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.adCb, (String) null);
        }
        gAdReport.uiEvent("top_video_transition", reportPreset);
    }

    public final void reportTopVideoTransitionDownSuccess$splash_debug(Splash splash, int reason) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(splash.getAdInfo().getReportInfo());
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.adCb, (String) null);
        }
        UIExtraParams $this$reportTopVideoTransitionDownSuccess_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
        $this$reportTopVideoTransitionDownSuccess_u24lambda_u240.getExtra().putString("reason", String.valueOf(reason));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("top_video_transition_down", reportPreset, $this$reportTopVideoTransitionDownSuccess_u24lambda_u240);
    }

    public final void reportVideoPlaySecondFee$splash_debug(Splash splash, String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (splash == null) {
            return;
        }
        GAdCoreKt.getGAdReport().dedupEvent(event.toString(), splash.getAdInfo().getReportInfo(), (ExtraParams) null);
    }

    public final void reportVideoPlaySecondUi$splash_debug(Splash splash, String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        String str = event.toString();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(splash.getAdInfo().getReportInfo());
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.adCb, (String) null);
        }
        gAdReport.uiEvent(str, reportPreset, new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("splash"));
    }

    public final void reportVideoFirstRenderCostMs$splash_debug(Splash splash, long timeMs) {
        if (splash == null) {
            return;
        }
        GAdReport gAdReport = GAdCoreKt.getGAdReport();
        IReportPreset reportPreset = ReportPresetKt.toReportPreset(splash.getAdInfo().getReportInfo());
        if (reportPreset == null) {
            reportPreset = (IReportPreset) new SimpleAdReportPreset(splash.adCb, (String) null);
        }
        UIExtraParams $this$reportVideoFirstRenderCostMs_u24lambda_u240 = new UIExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null).EVENT_FROM("splash");
        Bundle $this$reportVideoFirstRenderCostMs_u24lambda_u240_u240 = $this$reportVideoFirstRenderCostMs_u24lambda_u240.getExtra();
        $this$reportVideoFirstRenderCostMs_u24lambda_u240_u240.putString("first_frame_render_ms", String.valueOf(timeMs));
        Unit unit = Unit.INSTANCE;
        gAdReport.uiEvent("first_frame_render", reportPreset, $this$reportVideoFirstRenderCostMs_u24lambda_u240);
    }
}