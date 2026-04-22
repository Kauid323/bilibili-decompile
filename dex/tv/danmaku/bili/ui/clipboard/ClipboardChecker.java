package tv.danmaku.bili.ui.clipboard;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bili.resource.homepage.R;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.login.GrowthLogConsumer;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.utils.ExBilowUtil;
import com.bilibili.opd.app.bizcommon.hybridruntime.web.FlutterWebModCheckerKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.clipboard.ClipboardResp;
import tv.danmaku.bili.ui.main.usergrow.UserGrowManager;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.splash.ClipboardJumpHelper;
import tv.danmaku.bili.ui.splash.LaunchClipboard;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivityKt;
import tv.danmaku.bili.utils.UriSpmidModuleHelper;

/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002yzB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0007J\u0012\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u0005H\u0002J\n\u00108\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u00109\u001a\u000200H\u0007J\u0012\u0010:\u001a\u0002002\b\b\u0002\u0010;\u001a\u00020\u0017H\u0007J\b\u0010<\u001a\u00020\u0017H\u0002J\b\u0010=\u001a\u00020\u0017H\u0002J\u0010\u0010>\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010?\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020\u0005H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0014\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010D\u001a\u0002002\u0006\u0010E\u001a\u00020\u0011H\u0002J\u0010\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020\u0017H\u0002J\u0012\u0010J\u001a\u0002002\b\u0010K\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010L\u001a\u000200H\u0002J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J\u0010\u0010P\u001a\u0002002\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002J\u0018\u0010S\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020\u0005H\u0002J\u0016\u0010T\u001a\u00020\u00172\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020\u0005J \u0010U\u001a\u0002002\u0006\u00107\u001a\u00020V2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020CH\u0003J\u0010\u0010W\u001a\u00020\u00172\b\u0010X\u001a\u0004\u0018\u00010\u0005J \u0010Y\u001a\u00020\u00172\u0006\u00107\u001a\u00020V2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020CH\u0003J\u001a\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]0[0\u0014H\u0002J\u001a\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]0[0\u0014H\u0002J\b\u0010_\u001a\u00020\u0015H\u0002J\u0010\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002J.\u0010c\u001a\u0004\u0018\u00010H2\u0006\u00101\u001a\u0002022\u0006\u0010d\u001a\u00020\u001e2\b\u0010X\u001a\u0004\u0018\u00010\u00052\b\u0010e\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010f\u001a\u000200H\u0007J\u0010\u0010g\u001a\u0002002\u0006\u0010h\u001a\u00020iH\u0002J\u000e\u0010j\u001a\u0002002\u0006\u0010h\u001a\u00020iJ\u001c\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020\u00172\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010n\u001a\u00020\u00172\b\u0010m\u001a\u0004\u0018\u00010\u0005H\u0002J\u0015\u0010q\u001a\u0002002\u0006\u0010o\u001a\u00020pH\u0000¢\u0006\u0002\brJ\u0018\u0010s\u001a\u0002002\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005H\u0002J\"\u0010v\u001a\u0002002\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u00052\b\u0010w\u001a\u0004\u0018\u00010xH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020*0,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardChecker;", "", "<init>", "()V", "TAG", "", "PREF_KEY_CLIPBOARD_RULES", "PREF_KEY_INNER_COPY_CONTENT", "BV_NEW_BUSINESS", "COMMON_JUMP_BUSINESS", "H5_BUVID_PARAM", "SPMID_PARAM", "BSOURCE_PARAM", "UNIQUE_PARAM", "EXTRAS", "mRecognizeResult", "Landroidx/lifecycle/MutableLiveData;", "Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "mPrefetchTask", "Ljava/util/concurrent/Future;", "", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "mBlockJump", "", "mIsChecking", "mIsBackground", "mIsDeeplink", "mIsFirstRequest", "interestChooserOb", "Landroidx/lifecycle/Observer;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "_reportRules", "Ljava/util/regex/Pattern;", "get_reportRules$annotations", "get_reportRules", "()Ljava/util/regex/Pattern;", "_reportRules$delegate", "Lkotlin/Lazy;", "_recognize", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/clipboard/ClipboardResp;", "recognize", "Lkotlinx/coroutines/flow/StateFlow;", "getRecognize", "()Lkotlinx/coroutines/flow/StateFlow;", "init", "", "context", "Landroid/content/Context;", "check", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "tryDecompress", "content", "getResult", "resetResult", "observer", "coldStart", "remoteRuleEnable", "clipboardEnable", "listenCopy", "copyFilter", "getCopyFilterRules", "getClipboardData", "clipboard", "Landroid/content/ClipboardManager;", "dealWithResult", "result", "jumpPage", "clipData", "Ltv/danmaku/bili/ui/clipboard/ClipboardResult;", "isBVNewRulesEnable", "reportBvNewJump", "url", "prefetchRules", "registerActivityCallback", "onAppForeground", "isSplashShowing", "saveRules", "rules", "readRules", "setInnerCopyContent", "isInnerCopy", "processRemote", "", "shouldReport", LoginSceneProcessor.BIZ_KEY, "processLocal", "buildLocalProcedures", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/clipboard/IRegexRecognizer;", "Ltv/danmaku/bili/ui/clipboard/IRegexProcessor;", "buildRemoteProcedures", "buildShareWordRule", "getRemoteRegexRules", ReportEvent.Tag.API, "Ltv/danmaku/bili/ui/clipboard/ClipboardApi;", "fetchJumpResult", "startType", "data", "notifyCheck", "reportClipboardRead", "id", "", "reportClipboardJump", "setFromScheme", "fromScheme", AudioIntentHelper.ARGS_URI, "isUriInWhiteList", "logConsumer", "Lcom/bilibili/login/GrowthLogConsumer;", "injectLogConsumer", "injectLogConsumer$core_apinkDebug", "logI", AppConfig.HOST_TAG, "message", "logE", "t", "", "CompressRule", "Environment", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClipboardChecker {
    public static final int $stable;
    private static final String BSOURCE_PARAM = "bsource";
    public static final String BV_NEW_BUSINESS = "BVNEW";
    public static final String COMMON_JUMP_BUSINESS = "COMMON_JUMP";
    private static final String EXTRAS = "extras";
    private static final String H5_BUVID_PARAM = "h5_buvid";
    private static final String PREF_KEY_CLIPBOARD_RULES = "clipboard.regex_rules";
    private static final String PREF_KEY_INNER_COPY_CONTENT = "clipboard.inner_copy_content";
    private static final String SPMID_PARAM = "spmid";
    public static final String TAG = "ClipboardChecker";
    private static final String UNIQUE_PARAM = "unique_k";
    private static final MutableStateFlow<ClipboardResp> _recognize;
    private static final ClipboardApi api;
    private static Observer<Integer> interestChooserOb;
    private static GrowthLogConsumer logConsumer;
    private static boolean mBlockJump;
    private static boolean mIsBackground;
    private static boolean mIsChecking;
    private static boolean mIsDeeplink;
    private static Future<List<RegexRule>> mPrefetchTask;
    private static final StateFlow<ClipboardResp> recognize;
    public static final ClipboardChecker INSTANCE = new ClipboardChecker();
    private static final MutableLiveData<RecognizeResult> mRecognizeResult = new MutableLiveData<>();
    private static boolean mIsFirstRequest = true;
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private static final Lazy _reportRules$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda10
        public final Object invoke() {
            Pattern _reportRules_delegate$lambda$0;
            _reportRules_delegate$lambda$0 = ClipboardChecker._reportRules_delegate$lambda$0();
            return _reportRules_delegate$lambda$0;
        }
    });

    private static /* synthetic */ void get_reportRules$annotations() {
    }

    @JvmStatic
    public static final void setFromScheme(boolean z) {
        setFromScheme$default(z, null, 2, null);
    }

    private ClipboardChecker() {
    }

    static {
        MutableStateFlow flow = StateFlowKt.MutableStateFlow(ClipboardResp.Unset.INSTANCE);
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new ClipboardChecker$_recognize$1$1(flow, null), 3, (Object) null);
        _recognize = flow;
        recognize = FlowKt.asStateFlow(_recognize);
        Object createService = ServiceGenerator.createService(ClipboardApi.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        api = (ClipboardApi) createService;
        $stable = 8;
    }

    private final Pattern get_reportRules() {
        return (Pattern) _reportRules$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pattern _reportRules_delegate$lambda$0() {
        String regex = DeviceDecision.INSTANCE.dd("dd.clipboard.report_rules", "");
        String str = regex;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return Pattern.compile(regex, 2);
        } catch (Exception e) {
            INSTANCE.logE(TAG, "report rules regex error", e);
            return null;
        }
    }

    public final StateFlow<ClipboardResp> getRecognize() {
        return recognize;
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BiliContext.isMainProcess()) {
            INSTANCE.prefetchRules();
            INSTANCE.registerActivityCallback();
        }
        INSTANCE.listenCopy(context);
    }

    @JvmStatic
    public static final void check(final Environment environment) {
        Object prevValue$iv;
        Object nextValue$iv;
        Object prevValue$iv2;
        Object nextValue$iv2;
        Object prevValue$iv3;
        Object nextValue$iv3;
        Object prevValue$iv4;
        Object nextValue$iv4;
        Object prevValue$iv5;
        Object nextValue$iv5;
        Intrinsics.checkNotNullParameter(environment, "environment");
        INSTANCE.logI(TAG, "start check clipboard");
        MutableStateFlow $this$update$iv = _recognize;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ClipboardResp clipboardResp = (ClipboardResp) prevValue$iv;
            nextValue$iv = (ClipboardResp) ClipboardResp.Start.INSTANCE;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
        try {
            if (mIsChecking) {
                MutableStateFlow $this$update$iv2 = _recognize;
                do {
                    prevValue$iv5 = $this$update$iv2.getValue();
                    ClipboardResp clipboardResp2 = (ClipboardResp) prevValue$iv5;
                    nextValue$iv5 = (ClipboardResp) new ClipboardResp.Failed("Clipboard is checking, please wait.");
                } while (!$this$update$iv2.compareAndSet(prevValue$iv5, nextValue$iv5));
                return;
            }
            mIsChecking = true;
            ClipboardJumpHelper.onClipboardChecking();
            if (!INSTANCE.clipboardEnable()) {
                INSTANCE.logI(TAG, "Clipboard read disable.");
                ClipboardJumpHelper.onClipboardJumped(false);
                mIsChecking = false;
                MutableStateFlow $this$update$iv3 = _recognize;
                do {
                    prevValue$iv4 = $this$update$iv3.getValue();
                    ClipboardResp clipboardResp3 = (ClipboardResp) prevValue$iv4;
                    nextValue$iv4 = (ClipboardResp) new ClipboardResp.Failed("Clipboard read is disabled.");
                } while (!$this$update$iv3.compareAndSet(prevValue$iv4, nextValue$iv4));
                return;
            }
            Object systemService = environment.getContext().getSystemService("clipboard");
            final ClipboardManager clipboard = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboard == null) {
                ClipboardJumpHelper.onClipboardJumped(false);
                mIsChecking = false;
                MutableStateFlow $this$update$iv4 = _recognize;
                do {
                    prevValue$iv3 = $this$update$iv4.getValue();
                    ClipboardResp clipboardResp4 = (ClipboardResp) prevValue$iv3;
                    nextValue$iv3 = (ClipboardResp) new ClipboardResp.Failed("Clipboard manager is null.");
                } while (!$this$update$iv4.compareAndSet(prevValue$iv3, nextValue$iv3));
                return;
            }
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    String check$lambda$4;
                    check$lambda$4 = ClipboardChecker.check$lambda$4(clipboard);
                    return check$lambda$4;
                }
            }).onSuccessTask(new Continuation() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda5
                public final Object then(Task task) {
                    Task check$lambda$5;
                    check$lambda$5 = ClipboardChecker.check$lambda$5(ClipboardChecker.Environment.this, clipboard, task);
                    return check$lambda$5;
                }
            }, Task.UI_THREAD_EXECUTOR).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda6
                public final Object then(Task task) {
                    Unit check$lambda$6;
                    check$lambda$6 = ClipboardChecker.check$lambda$6(ClipboardChecker.Environment.this, clipboard, task);
                    return check$lambda$6;
                }
            }, Task.BACKGROUND_EXECUTOR);
        } catch (Exception e) {
            INSTANCE.logE(TAG, "Clipboard check error happened.", e);
            CrashReporter.INSTANCE.postCaughtException(e);
            MutableStateFlow $this$update$iv5 = _recognize;
            do {
                prevValue$iv2 = $this$update$iv5.getValue();
                ClipboardResp clipboardResp5 = (ClipboardResp) prevValue$iv2;
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                nextValue$iv2 = (ClipboardResp) new ClipboardResp.Failed("Clipboard check exception: " + message);
            } while (!$this$update$iv5.compareAndSet(prevValue$iv2, nextValue$iv2));
            mIsChecking = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String check$lambda$4(ClipboardManager $clipboard) {
        String content = INSTANCE.getClipboardData($clipboard);
        if (content == null) {
            content = "";
        }
        INSTANCE.logI(TAG, "Clipboard start check,content:" + content);
        return content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task check$lambda$5(Environment $environment, ClipboardManager $clipboard, Task it) {
        Object prevValue$iv;
        Object nextValue$iv;
        TaskCompletionSource completionSource = new TaskCompletionSource();
        Object content = it.getResult();
        if (TextUtils.isEmpty((CharSequence) content)) {
            ClipboardJumpHelper.onClipboardJumped(false);
            INSTANCE.logI(TAG, "Empty content.");
            mIsChecking = false;
            completionSource.setCancelled();
            MutableStateFlow $this$update$iv = _recognize;
            do {
                prevValue$iv = $this$update$iv.getValue();
                ClipboardResp clipboardResp = (ClipboardResp) prevValue$iv;
                nextValue$iv = (ClipboardResp) new ClipboardResp.Failed("Clipboard content is empty.");
            } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
            return completionSource.getTask();
        }
        INSTANCE.logI(TAG, "do base64 decode...");
        ClipboardChecker clipboardChecker = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(content, "element");
        String res = clipboardChecker.tryDecompress((String) content);
        if (res != null) {
            content = res;
        }
        INSTANCE.logI(TAG, "base64 decode done...");
        Pattern $this$check_u24lambda_u245_u242 = INSTANCE.get_reportRules();
        if ($this$check_u24lambda_u245_u242 != null) {
            if ($this$check_u24lambda_u245_u242.matcher((CharSequence) content).find()) {
                Neurons.reportClick(true, "main.active.clipboard.get.click", MapsKt.mapOf(TuplesKt.to("text", content)));
            } else {
                INSTANCE.logI(TAG, "not match report rules, content = " + content);
            }
        }
        ClipboardChecker clipboardChecker2 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(content, "element");
        boolean localResult = clipboardChecker2.processLocal((CharSequence) content, $environment, $clipboard);
        if (!localResult) {
            completionSource.setResult(content);
        } else {
            INSTANCE.logI(TAG, "Recognize local rules.");
            mIsChecking = false;
            completionSource.setCancelled();
        }
        return completionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit check$lambda$6(Environment $environment, ClipboardManager $clipboard, Task it) {
        Object prevValue$iv;
        Object nextValue$iv;
        if (!it.isFaulted() && !it.isCancelled()) {
            INSTANCE.logI(TAG, "processRemote...");
            ClipboardChecker clipboardChecker = INSTANCE;
            Object result = it.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
            clipboardChecker.processRemote((CharSequence) result, $environment, $clipboard);
        } else if (it.isFaulted()) {
            INSTANCE.logE(TAG, "Clipboard check error happened.", it.getError());
            MutableStateFlow $this$update$iv = _recognize;
            do {
                prevValue$iv = $this$update$iv.getValue();
                ClipboardResp clipboardResp = (ClipboardResp) prevValue$iv;
                Exception error = it.getError();
                nextValue$iv = (ClipboardResp) new ClipboardResp.Failed("Clipboard check error: " + ((error == null || (r5 = error.getMessage()) == null) ? "Unknown error" : "Unknown error"));
            } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
        }
        mIsChecking = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0044, code lost:
        if (r12 == null) goto L21;
     */
    /* JADX WARN: Type inference failed for: r12v9, types: [tv.danmaku.bili.ui.clipboard.ClipboardChecker$tryDecompress$lambda$0$0$$inlined$parseJson$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String tryDecompress(String content) {
        Object compressRule;
        TimeSource.Monotonic $this$measureTimedValue$iv$iv = TimeSource.Monotonic.INSTANCE;
        long mark$iv$iv = $this$measureTimedValue$iv$iv.markNow-z9LOYto();
        try {
            String it = (String) ConfigManager.Companion.config().get("main.clipboard_compress_rule", JSON.toJSONString(new CompressRule(null, null, null, 7, null)));
            if (it != null) {
                Gson $this$parseJson$iv = new Gson();
                compressRule = (CompressRule) $this$parseJson$iv.fromJson(it, new TypeToken<CompressRule>() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$tryDecompress$lambda$0$0$$inlined$parseJson$1
                }.getType());
            }
            compressRule = new CompressRule(null, null, null, 7, null);
        } catch (Exception e) {
            compressRule = new CompressRule(null, null, null, 7, null);
        }
        Object result$iv$iv = compressRule;
        TimedValue $this$tryDecompress_u24lambda_u241 = new TimedValue(result$iv$iv, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv$iv), (DefaultConstructorMarker) null);
        INSTANCE.logI(TAG, "parse rule within " + Duration.getInWholeMilliseconds-impl($this$tryDecompress_u24lambda_u241.getDuration-UwyO8pc()) + "ms");
        CompressRule compressRule2 = (CompressRule) $this$tryDecompress_u24lambda_u241.getValue();
        String prefix = compressRule2.getPrefix();
        String infix = compressRule2.getInfix();
        String suffix = compressRule2.getSuffix();
        if (StringsKt.startsWith$default(content, prefix, false, 2, (Object) null) && StringsKt.endsWith$default(content, suffix, false, 2, (Object) null)) {
            List dataList = StringsKt.split$default(content, new String[]{" "}, false, 0, 6, (Object) null);
            if (dataList.size() > 1 && StringsKt.startsWith$default((String) dataList.get(1), infix, false, 2, (Object) null)) {
                String temp = ((String) dataList.get(1)).substring(infix.length());
                Intrinsics.checkNotNullExpressionValue(temp, "substring(...)");
                TimeSource.Monotonic $this$measureTimedValue$iv$iv2 = TimeSource.Monotonic.INSTANCE;
                long mark$iv$iv2 = $this$measureTimedValue$iv$iv2.markNow-z9LOYto();
                Object result$iv$iv2 = Base64.decode(temp, 0);
                TimedValue $this$tryDecompress_u24lambda_u243 = new TimedValue(result$iv$iv2, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv$iv2), (DefaultConstructorMarker) null);
                INSTANCE.logI(TAG, "base64 decode content within " + Duration.getInWholeMilliseconds-impl($this$tryDecompress_u24lambda_u243.getDuration-UwyO8pc()) + "ms");
                byte[] arrays = (byte[]) $this$tryDecompress_u24lambda_u243.getValue();
                Intrinsics.checkNotNull(arrays);
                return new String(arrays, Charsets.UTF_8);
            }
        }
        return null;
    }

    /* compiled from: ClipboardChecker.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$CompressRule;", "", "prefix", "", "infix", "suffix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPrefix", "()Ljava/lang/String;", "getInfix", "getSuffix", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CompressRule {
        public static final int $stable = 0;
        private final String infix;
        private final String prefix;
        private final String suffix;

        public CompressRule() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ CompressRule copy$default(CompressRule compressRule, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = compressRule.prefix;
            }
            if ((i & 2) != 0) {
                str2 = compressRule.infix;
            }
            if ((i & 4) != 0) {
                str3 = compressRule.suffix;
            }
            return compressRule.copy(str, str2, str3);
        }

        public final String component1() {
            return this.prefix;
        }

        public final String component2() {
            return this.infix;
        }

        public final String component3() {
            return this.suffix;
        }

        public final CompressRule copy(@JSONField(name = "prefix") String str, @JSONField(name = "infix") String str2, @JSONField(name = "suffix") String str3) {
            Intrinsics.checkNotNullParameter(str, "prefix");
            Intrinsics.checkNotNullParameter(str2, "infix");
            Intrinsics.checkNotNullParameter(str3, "suffix");
            return new CompressRule(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CompressRule) {
                CompressRule compressRule = (CompressRule) obj;
                return Intrinsics.areEqual(this.prefix, compressRule.prefix) && Intrinsics.areEqual(this.infix, compressRule.infix) && Intrinsics.areEqual(this.suffix, compressRule.suffix);
            }
            return false;
        }

        public int hashCode() {
            return (((this.prefix.hashCode() * 31) + this.infix.hashCode()) * 31) + this.suffix.hashCode();
        }

        public String toString() {
            String str = this.prefix;
            String str2 = this.infix;
            return "CompressRule(prefix=" + str + ", infix=" + str2 + ", suffix=" + this.suffix + ")";
        }

        public CompressRule(@JSONField(name = "prefix") String prefix, @JSONField(name = "infix") String infix, @JSONField(name = "suffix") String suffix) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(infix, "infix");
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            this.prefix = prefix;
            this.infix = infix;
            this.suffix = suffix;
        }

        public /* synthetic */ CompressRule(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "2233" : str, (i & 2) != 0 ? "DGYSNS" : str2, (i & 4) != 0 ? "https://m.bilibili.com" : str3);
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getInfix() {
            return this.infix;
        }

        public final String getSuffix() {
            return this.suffix;
        }
    }

    @JvmStatic
    public static final RecognizeResult getResult() {
        return (RecognizeResult) mRecognizeResult.getValue();
    }

    @JvmStatic
    public static final void resetResult() {
        INSTANCE.logI(TAG, "reset mRecognizeResult");
        mRecognizeResult.setValue((Object) null);
    }

    public static /* synthetic */ void observer$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        observer(z);
    }

    @JvmStatic
    public static final void observer(final boolean coldStart) {
        if (!mRecognizeResult.hasObservers()) {
            mRecognizeResult.observeForever(new ClipboardChecker$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit observer$lambda$0;
                    observer$lambda$0 = ClipboardChecker.observer$lambda$0(coldStart, (RecognizeResult) obj);
                    return observer$lambda$0;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$0(boolean $coldStart, RecognizeResult result) {
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new ClipboardChecker$observer$1$1(result, $coldStart, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private final boolean remoteRuleEnable() {
        return Intrinsics.areEqual(ConfigManager.Companion.config().get("clipboard.server_rules_enable", "1"), "1");
    }

    private final boolean clipboardEnable() {
        return Intrinsics.areEqual(ConfigManager.Companion.config().get("clipboard.read_enable", "1"), "1");
    }

    private final void listenCopy(final Context context) {
        try {
            Object systemService = context.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            final ClipboardManager clipboardManager = (ClipboardManager) systemService;
            clipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda11
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    ClipboardChecker.listenCopy$lambda$0(clipboardManager, context);
                }
            });
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenCopy$lambda$0(final ClipboardManager $clipboardManager, final Context $context) {
        if (!BiliContext.isVisible()) {
            return;
        }
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ClipboardChecker.listenCopy$lambda$0$0($clipboardManager, $context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenCopy$lambda$0$0(ClipboardManager $clipboardManager, Context $context) {
        String content = INSTANCE.getClipboardData($clipboardManager);
        if (content != null) {
            if (TextUtils.isEmpty(content)) {
                content = null;
            }
            if (content == null) {
                return;
            }
            INSTANCE.copyFilter($context, content);
        }
    }

    private final void copyFilter(Context context, String content) {
        List copyFilterRules = CollectionsKt.toMutableList(getCopyFilterRules());
        copyFilterRules.add(INSTANCE.buildShareWordRule());
        String result = "";
        Iterator it = copyFilterRules.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RegexRule rule = (RegexRule) it.next();
            try {
                String regex = rule.getRegex();
                if (regex == null) {
                    continue;
                } else {
                    if (TextUtils.isEmpty(regex)) {
                        regex = null;
                    }
                    if (regex != null) {
                        Pattern pattern = Pattern.compile(regex, 2);
                        Matcher matcher = pattern.matcher(content);
                        if (matcher.find()) {
                            result = content;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        if (!TextUtils.isEmpty(result)) {
            logI(TAG, "Inner copy matched.");
            setInnerCopyContent(context, content);
            return;
        }
        setInnerCopyContent(context, "");
    }

    private final List<RegexRule> getCopyFilterRules() {
        Iterable readRules = readRules();
        if (readRules != null) {
            Iterable $this$filter$iv = readRules;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                RegexRule it = (RegexRule) element$iv$iv;
                if (!it.getInnerCopy()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }
        return CollectionsKt.emptyList();
    }

    private final String getClipboardData(ClipboardManager clipboard) {
        ClipData primaryClip;
        if (clipboard == null || (primaryClip = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(clipboard)) == null || primaryClip.getItemCount() <= 0) {
            return "";
        }
        CharSequence text = primaryClip.getItemAt(0).getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithResult(RecognizeResult result) {
        if ((result instanceof RemoteResult) && ((RemoteResult) result).getClipData() != null) {
            ClipboardResult clipData = ((RemoteResult) result).getClipData();
            Intrinsics.checkNotNull(clipData);
            if (!clipData.checkValid()) {
                logI(TAG, "clipData is not valid");
                return;
            } else {
                jumpPage(clipData);
                logI(TAG, "Deal with remote result.");
            }
        } else if ((result instanceof BvResult) && ((BvResult) result).getBvData() != null && !mBlockJump) {
            LaunchClipboard.INSTANCE.checkBvData((BvResult) result);
            logI(TAG, "Deal with bv result.");
        } else if ((result instanceof OpenResult) && ((OpenResult) result).getPlayData() != null && EnvironmentManager.getInstance().isFirstStart()) {
            LaunchClipboard.PlayData playData = ((OpenResult) result).getPlayData();
            LaunchClipboard.INSTANCE.report(playData);
            final Object context = BiliContext.topActivitiy();
            if (context == null && (context = BiliContext.application()) == null) {
                return;
            }
            if (playData != null && playData.valid()) {
                if (!(playData instanceof LaunchClipboard.UrlData)) {
                    HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            ClipboardChecker.dealWithResult$lambda$0(context);
                        }
                    }, 1000L);
                }
                Uri uri = playData.getUri();
                Intrinsics.checkNotNull(uri);
                RouteRequest request = new RouteRequest.Builder(UriSpmidModuleHelper.appendFromSpmid(uri, "main.active.growthhacker.fromcopylink.show")).build();
                BLRouter.routeTo(request, (Context) context);
                ClipboardJumpHelper.onClipboardJumped(true);
                resetResult();
            } else {
                logI(TAG, "open result fail");
            }
            logI(TAG, "Deal with open result");
        }
        mBlockJump = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealWithResult$lambda$0(Object $context) {
        ToastHelper.showToastShort((Context) $context, R.string.homepage_global_string_210);
    }

    private final void jumpPage(final ClipboardResult clipData) {
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        switch (clipData.getMode()) {
            case 1:
                if (mBlockJump) {
                    return;
                }
                MainDialogManager.IDialogInterface dialog = new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda9
                    public final void onShow() {
                        ClipboardChecker.jumpPage$lambda$2(ClipboardResult.this, context);
                    }
                };
                MainDialogManager.DialogManagerInfo $this$jumpPage_u24lambda_u243 = new MainDialogManager.DialogManagerInfo("clipboard", dialog, 1010, false);
                $this$jumpPage_u24lambda_u243.setRepeat(true);
                $this$jumpPage_u24lambda_u243.setMainOnly(clipData.getRule() != 4);
                MainDialogManager.addDialog($this$jumpPage_u24lambda_u243, context);
                logI(TAG, "Clipboard jump page.");
                return;
            case 2:
                MainDialogManager.IDialogInterface dialog2 = new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda8
                    public final void onShow() {
                        ClipboardChecker.jumpPage$lambda$0(ClipboardResult.this, context);
                    }
                };
                MainDialogManager.DialogManagerInfo $this$jumpPage_u24lambda_u241 = new MainDialogManager.DialogManagerInfo("clipboard", dialog2, 1010, false);
                $this$jumpPage_u24lambda_u241.setRepeat(true);
                $this$jumpPage_u24lambda_u241.setMultiProcess(true);
                $this$jumpPage_u24lambda_u241.setMainOnly(clipData.getRule() != 4);
                MainDialogManager.addDialog($this$jumpPage_u24lambda_u241, context);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpPage$lambda$0(ClipboardResult $clipData, Application $context) {
        if (!$clipData.checkPage()) {
            MainDialogManager.showNextDialog("clipboard", false, $context);
            return;
        }
        RouteRequest req = new RouteRequest.Builder(MainRouteUris.ROUTE_ACTIVIRY_USER_GROW).data(Uri.parse($clipData.getUrl())).addFlag(268435456).build();
        BLRouter.routeTo$default(req, (Context) null, 2, (Object) null);
        if ($clipData.isFissionUrl()) {
            UserGrowManager.INSTANCE.reportDialogShow($clipData.getUrl());
        }
        if ($clipData.getLocalId() > 0) {
            INSTANCE.reportClipboardJump($clipData.getLocalId());
        }
        INSTANCE.logI(TAG, "Clipboard show dialog.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpPage$lambda$2(ClipboardResult $clipData, Application $context) {
        if (!$clipData.checkPage()) {
            MainDialogManager.showNextDialog("clipboard", false, $context);
            return;
        }
        if (INSTANCE.shouldReport($clipData.getBusiness())) {
            if (!INSTANCE.isBVNewRulesEnable()) {
                INSTANCE.logI(TAG, "bv new rule disable");
                MainDialogManager.showNextDialog("clipboard", false, $context);
                return;
            }
            INSTANCE.reportBvNewJump($clipData.getUrl());
        }
        String url = $clipData.getUrl();
        Intrinsics.checkNotNull(url);
        RouteRequest req = new RouteRequest.Builder(url).addFlag(268435456).build();
        RouteResponse resp = BLRouter.routeTo$default(req, (Context) null, 2, (Object) null);
        if (!resp.isSuccess()) {
            INSTANCE.logI(TAG, "PAGE_POP_MODE jump failed, message=" + resp.getMessage());
        }
        MainDialogManager.isMainVisible = false;
        MainDialogManager.showNextDialog("clipboard", false, $context);
        if ($clipData.getLocalId() > 0) {
            INSTANCE.reportClipboardJump($clipData.getLocalId());
        }
        if ($clipData.isFissionUrl()) {
            UserGrowManager.INSTANCE.reportDialogShow($clipData.getUrl());
        }
    }

    private final boolean isBVNewRulesEnable() {
        return ConfigManager.Companion.isHitFF("ff_bv_clipboard_new_rules_enable");
    }

    private final void reportBvNewJump(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            Uri uri = Uri.parse(url);
            HashMap $this$reportBvNewJump_u24lambda_u240 = new HashMap();
            Intrinsics.checkNotNull(url);
            $this$reportBvNewJump_u24lambda_u240.put("copy_url", url);
            Iterable queryParameterNames = uri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
            Iterable $this$forEach$iv = queryParameterNames;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                if (it != null) {
                    String str = "";
                    switch (it.hashCode()) {
                        case -824387348:
                            if (!it.equals(H5_BUVID_PARAM)) {
                                break;
                            } else {
                                HashMap hashMap = $this$reportBvNewJump_u24lambda_u240;
                                String queryParameter = uri.getQueryParameter(H5_BUVID_PARAM);
                                if (queryParameter != null) {
                                    str = queryParameter;
                                }
                                hashMap.put(H5_BUVID_PARAM, str);
                                continue;
                            }
                        case -294459523:
                            if (it.equals(UNIQUE_PARAM)) {
                                HashMap hashMap2 = $this$reportBvNewJump_u24lambda_u240;
                                String queryParameter2 = uri.getQueryParameter(UNIQUE_PARAM);
                                if (queryParameter2 != null) {
                                    str = queryParameter2;
                                }
                                hashMap2.put(UNIQUE_PARAM, str);
                                break;
                            } else {
                                continue;
                            }
                        case 109649611:
                            if (it.equals("spmid")) {
                                HashMap hashMap3 = $this$reportBvNewJump_u24lambda_u240;
                                String queryParameter3 = uri.getQueryParameter("spmid");
                                if (queryParameter3 != null) {
                                    str = queryParameter3;
                                }
                                hashMap3.put("spmid", str);
                                break;
                            } else {
                                continue;
                            }
                        case 179508989:
                            if (it.equals(BSOURCE_PARAM)) {
                                HashMap hashMap4 = $this$reportBvNewJump_u24lambda_u240;
                                String queryParameter4 = uri.getQueryParameter(BSOURCE_PARAM);
                                if (queryParameter4 != null) {
                                    str = queryParameter4;
                                }
                                hashMap4.put(BSOURCE_PARAM, str);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
            Neurons.reportExposure$default(false, "main.active.growthhacker.fromcopylink.show", $this$reportBvNewJump_u24lambda_u240, (List) null, 8, (Object) null);
        } catch (Exception e) {
        }
    }

    @JvmStatic
    private static ClipData __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPrimaryClip(Object obj) {
        ClipData.Item itemAt;
        CharSequence text;
        Intrinsics.checkNotNullParameter(obj, "obj");
        ClipData data = ((ClipboardManager) obj).getPrimaryClip();
        String str = null;
        if (!(data instanceof ClipData)) {
            data = null;
        }
        if (data != null && (itemAt = data.getItemAt(0)) != null && (text = itemAt.getText()) != null) {
            str = text.toString();
        }
        BLog.d("privacy", "getPrimaryClip: clipdata = " + str);
        return data;
    }

    private final void prefetchRules() {
        mPrefetchTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List prefetchRules$lambda$0;
                prefetchRules$lambda$0 = ClipboardChecker.prefetchRules$lambda$0();
                return prefetchRules$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List prefetchRules$lambda$0() {
        Object obj;
        List rules;
        List<RegexRule> rules2;
        ClipboardChecker $this$prefetchRules_u24lambda_u240_u240 = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            RegexData resp = (RegexData) ExBilowUtil.extractResponseData(api.fetchRegexRules().execute());
            if (resp == null || (rules2 = resp.getRules()) == null || (rules = CollectionsKt.filterNotNull(rules2)) == null) {
                rules = new ArrayList();
            }
            String parseRules = JSON.toJSONString(rules);
            $this$prefetchRules_u24lambda_u240_u240.logI(TAG, "Clipboard remote rules fetch success. rules: " + parseRules);
            Intrinsics.checkNotNull(parseRules);
            $this$prefetchRules_u24lambda_u240_u240.saveRules(parseRules);
            obj = Result.constructor-impl(rules);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            INSTANCE.logE(TAG, "Clipboard remote rules fetch failed.", it);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (List) obj;
    }

    private final void registerActivityCallback() {
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.IPCActivityStateCallback() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$registerActivityCallback$1
            public void onVisibleCountChanged(int lastVisibleCount, int currentVisibleCount) {
                boolean isSplashShowing;
                boolean z;
                boolean z2;
                if (lastVisibleCount == 0 && currentVisibleCount > lastVisibleCount) {
                    isSplashShowing = ClipboardChecker.INSTANCE.isSplashShowing();
                    if (!isSplashShowing && !UserProtocolHelper.showIntercept && !UserProtocolHelper.isDialogShowing) {
                        z = ClipboardChecker.mIsBackground;
                        if (!z) {
                            z2 = ClipboardChecker.mIsDeeplink;
                            if (!z2) {
                                return;
                            }
                        }
                        ClipboardChecker.INSTANCE.onAppForeground();
                        ClipboardChecker clipboardChecker = ClipboardChecker.INSTANCE;
                        ClipboardChecker.mIsDeeplink = false;
                        ClipboardChecker clipboardChecker2 = ClipboardChecker.INSTANCE;
                        ClipboardChecker.mIsBackground = false;
                    }
                } else if (currentVisibleCount == 0) {
                    ClipboardChecker clipboardChecker3 = ClipboardChecker.INSTANCE;
                    ClipboardChecker.mBlockJump = false;
                    ClipboardChecker clipboardChecker4 = ClipboardChecker.INSTANCE;
                    ClipboardChecker.mIsDeeplink = false;
                    ClipboardChecker clipboardChecker5 = ClipboardChecker.INSTANCE;
                    ClipboardChecker.mIsBackground = true;
                }
            }

            public void onForegroundActivitiesChanged(int lastForegroundCount, int currentForegroundCount) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAppForeground() {
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        logI(TAG, "on app foreground send check clipboard message");
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ClipboardChecker.onAppForeground$lambda$0(context);
            }
        }, 800L);
        observer$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAppForeground$lambda$0(Application $context) {
        INSTANCE.logI(TAG, "Clipboard on app forground check.");
        check(new Environment($context, false, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSplashShowing() {
        IDrawerHost iDrawerHost = BiliContext.topActivitiy();
        if (!HotSplashActivityKt.isHotSplashShowing && !tv.danmaku.bili.splash.ad.page.HotSplashActivityKt.isHotSplashShowing) {
            if ((iDrawerHost instanceof IDrawerHost) && iDrawerHost.isSplashShowing()) {
                return true;
            }
            return false;
        }
        return true;
    }

    private final void saveRules(String rules) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(PREF_KEY_CLIPBOARD_RULES, rules).apply();
    }

    private final List<RegexRule> readRules() {
        Application context = BiliContext.application();
        if (context == null) {
            return null;
        }
        String rulesStr = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_CLIPBOARD_RULES, "");
        if (TextUtils.isEmpty(rulesStr)) {
            return null;
        }
        try {
            return JSON.parseArray(rulesStr, RegexRule.class);
        } catch (Exception e) {
            return null;
        }
    }

    private final void setInnerCopyContent(Context context, String content) {
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(PREF_KEY_INNER_COPY_CONTENT, content).apply();
    }

    public final boolean isInnerCopy(Context context, String content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        return !TextUtils.isEmpty(content) && TextUtils.equals(BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_INNER_COPY_CONTENT, ""), content);
    }

    private final void processRemote(CharSequence content, Environment environment, ClipboardManager clipboard) {
        List procedures = buildRemoteProcedures();
        Iterator<Pair<IRegexRecognizer, IRegexProcessor>> it = procedures.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair procedure = it.next();
            IRegexRecognizer recognizer = (IRegexRecognizer) procedure.getFirst();
            IRegexProcessor processor = (IRegexProcessor) procedure.getSecond();
            String result = recognizer.recognize(content, environment);
            if (result != null) {
                RegexRule regexRule = recognizer.getRegexRule();
                logI(TAG, "recognize result " + result + " , match regex  " + (regexRule != null ? regexRule.getRegex() : null));
                RegexRule regexRule2 = recognizer.getRegexRule();
                if (regexRule2 != null) {
                    if (regexRule2.getId() > 0) {
                        reportClipboardRead(regexRule2.getId());
                    }
                    clipboard.setPrimaryClip(ClipData.newPlainText(null, ""));
                    if (regexRule2.getPopupMode() != 3 && regexRule2.getId() != 1) {
                        if (TextUtils.isEmpty(regexRule2.getUrl())) {
                            if (shouldReport(regexRule2.getBusiness())) {
                                RemoteResult remoteResult = new RemoteResult();
                                ClipboardResult $this$processRemote_u24lambda_u241_u240 = new ClipboardResult();
                                $this$processRemote_u24lambda_u241_u240.setRule(regexRule2.getPopupRule());
                                $this$processRemote_u24lambda_u241_u240.setMode(regexRule2.getPopupMode());
                                $this$processRemote_u24lambda_u241_u240.setUrl(result);
                                $this$processRemote_u24lambda_u241_u240.setLocalId(regexRule2.getId());
                                $this$processRemote_u24lambda_u241_u240.setBusiness(regexRule2.getBusiness());
                                remoteResult.setClipData($this$processRemote_u24lambda_u241_u240);
                                logI(TAG, "Clipboard remote rule " + regexRule2.getId() + " matched. But BV_NEW rules.");
                                mRecognizeResult.postValue(remoteResult);
                                ClipboardJumpHelper.onClipboardJumped(true);
                            }
                        } else {
                            RemoteResult $this$processRemote_u24lambda_u240 = new RemoteResult();
                            ClipboardResult $this$processRemote_u24lambda_u240_u240 = new ClipboardResult();
                            $this$processRemote_u24lambda_u240_u240.setRule(regexRule2.getPopupRule());
                            $this$processRemote_u24lambda_u240_u240.setMode(regexRule2.getPopupMode());
                            $this$processRemote_u24lambda_u240_u240.setUrl(regexRule2.getUrl());
                            $this$processRemote_u24lambda_u240_u240.setLocalId(regexRule2.getId());
                            $this$processRemote_u24lambda_u240_u240.setBusiness(regexRule2.getBusiness());
                            $this$processRemote_u24lambda_u240.setClipData($this$processRemote_u24lambda_u240_u240);
                            logI(TAG, "Clipboard remote rule " + regexRule2.getId() + " matched. But local process.");
                            mRecognizeResult.postValue($this$processRemote_u24lambda_u240);
                            ClipboardJumpHelper.onClipboardJumped(true);
                        }
                    }
                    RecognizeResult remoteResult2 = processor.processAsync(result, regexRule2, environment);
                    if (remoteResult2 != null) {
                        logI(TAG, "Clipboard remote rule " + regexRule2.getId() + " matched.");
                        ClipboardJumpHelper.onClipboardJumped(true);
                        mRecognizeResult.postValue(remoteResult2);
                    }
                }
            }
        }
        ClipboardJumpHelper.onClipboardJumped(false);
    }

    public final boolean shouldReport(String business) {
        return TextUtils.equals(business, BV_NEW_BUSINESS) || TextUtils.equals(business, COMMON_JUMP_BUSINESS);
    }

    private final boolean processLocal(CharSequence content, Environment environment, ClipboardManager clipboard) {
        List procedures = buildLocalProcedures();
        if (procedures.isEmpty()) {
            procedures = null;
        }
        if (procedures == null) {
            return false;
        }
        for (Pair procedure : procedures) {
            IRegexRecognizer recognizer = (IRegexRecognizer) procedure.getFirst();
            IRegexProcessor processor = (IRegexProcessor) procedure.getSecond();
            String result = recognizer.recognize(content, environment);
            if (!TextUtils.isEmpty(result)) {
                clipboard.setPrimaryClip(ClipData.newPlainText(null, ""));
                Intrinsics.checkNotNull(result);
                RecognizeResult recognizeResult = processor.process(result, null, environment);
                if (recognizeResult != null) {
                    logI(TAG, "Clipboard local rules matched.");
                    mRecognizeResult.setValue(recognizeResult);
                    ClipboardJumpHelper.onClipboardJumped(true);
                }
                return true;
            }
        }
        return false;
    }

    private final List<Pair<IRegexRecognizer, IRegexProcessor>> buildLocalProcedures() {
        return CollectionsKt.listOf(new Pair(new LocalOpenRecognizer(), new LocalOpenProcessor()));
    }

    private final List<Pair<IRegexRecognizer, IRegexProcessor>> buildRemoteProcedures() {
        List procedures = new ArrayList();
        Iterable remoteRegexRules = getRemoteRegexRules();
        if (remoteRegexRules != null) {
            Iterable $this$forEach$iv = remoteRegexRules;
            for (Object element$iv : $this$forEach$iv) {
                RegexRule it = (RegexRule) element$iv;
                if (it.getId() == 1) {
                    procedures.add(new Pair(new LocalBvRecognizer(it), new LocalBvProcessor()));
                } else {
                    procedures.add(new Pair(new RemoteActRecognizer(it), new RemoteProcessor()));
                }
            }
        }
        RegexRule $this$buildRemoteProcedures_u24lambda_u241 = new RegexRule();
        $this$buildRemoteProcedures_u24lambda_u241.setRegex(UserGrowManager.FISSION_URL_REGEX);
        $this$buildRemoteProcedures_u24lambda_u241.setStartType(1);
        $this$buildRemoteProcedures_u24lambda_u241.setPopupMode(3);
        procedures.add(new Pair(new RemoteFissionUrlRecognizer($this$buildRemoteProcedures_u24lambda_u241), new RemoteFissionUrlProcessor()));
        RegexRule $this$buildRemoteProcedures_u24lambda_u242 = new RegexRule();
        $this$buildRemoteProcedures_u24lambda_u242.setRegex(UserGrowManager.INSTANCE.getFISSION_WORD_REGEX());
        $this$buildRemoteProcedures_u24lambda_u242.setStartType(3);
        $this$buildRemoteProcedures_u24lambda_u242.setPopupMode(3);
        procedures.add(new Pair(new RemoteWordRecognizer($this$buildRemoteProcedures_u24lambda_u242), new RemoteFissionProcessor()));
        procedures.add(new Pair(new RemoteWordRecognizer(buildShareWordRule()), new RemoteShareProcessor()));
        return procedures;
    }

    private final RegexRule buildShareWordRule() {
        RegexRule $this$buildShareWordRule_u24lambda_u240 = new RegexRule();
        $this$buildShareWordRule_u24lambda_u240.setRegex(UserGrowManager.INSTANCE.getSHARE_WORD_REGEX());
        $this$buildShareWordRule_u24lambda_u240.setStartType(3);
        $this$buildShareWordRule_u24lambda_u240.setInnerCopy(false);
        $this$buildShareWordRule_u24lambda_u240.setPopupMode(3);
        return $this$buildShareWordRule_u24lambda_u240;
    }

    private final List<RegexRule> getRemoteRegexRules() {
        if (remoteRuleEnable()) {
            List rules = readRules();
            if (rules != null) {
                return rules;
            }
            try {
                Future<List<RegexRule>> future = mPrefetchTask;
                if (future != null) {
                    return future.get(1000L, TimeUnit.MILLISECONDS);
                }
                return null;
            } catch (TimeoutException e) {
                BLog.e("Primer", "x/share/clipboardRules timeout");
                return null;
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    /* compiled from: ClipboardChecker.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "", "context", "Landroid/content/Context;", "firstStart", "", "coldStart", "<init>", "(Landroid/content/Context;ZZ)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFirstStart", "()Z", "setFirstStart", "(Z)V", "getColdStart", "setColdStart", "getStartType", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Environment {
        public static final int $stable = 8;
        private boolean coldStart;
        private Context context;
        private boolean firstStart;

        public Environment(Context context, boolean firstStart, boolean coldStart) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.firstStart = firstStart;
            this.coldStart = coldStart;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }

        public final boolean getFirstStart() {
            return this.firstStart;
        }

        public final void setFirstStart(boolean z) {
            this.firstStart = z;
        }

        public final boolean getColdStart() {
            return this.coldStart;
        }

        public final void setColdStart(boolean z) {
            this.coldStart = z;
        }

        public final int getStartType() {
            if (this.firstStart) {
                return 1;
            }
            if (this.coldStart) {
                return 2;
            }
            return 3;
        }
    }

    public final ClipboardResult fetchJumpResult(Context context, int startType, String business, String data) {
        Intrinsics.checkNotNullParameter(context, "context");
        String accessKey = BiliAccounts.get(context).getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        String accessKey2 = accessKey;
        long firstStartTime = EnvironmentManager.getInstance().getFirstRunTime() * 1000;
        try {
            return (ClipboardResult) ExBilowUtil.extractResponseData(api.fetchJumpResult(accessKey2, startType, business, data, firstStartTime).execute());
        } catch (Exception e) {
            return null;
        }
    }

    @JvmStatic
    public static final void notifyCheck() {
        INSTANCE.onAppForeground();
    }

    private final void reportClipboardRead(long id) {
        Neurons.reportExposure$default(false, "main.public-community.clipboard-read.0.show", MapsKt.mapOf(TuplesKt.to("promotion_id", String.valueOf(id))), (List) null, 8, (Object) null);
    }

    public final void reportClipboardJump(long id) {
        Neurons.reportClick(false, "main.public-community.clipboard-jump.0.click", MapsKt.mapOf(TuplesKt.to("promotion_id", String.valueOf(id))));
    }

    public static /* synthetic */ void setFromScheme$default(boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        setFromScheme(z, str);
    }

    @JvmStatic
    public static final void setFromScheme(boolean fromScheme, String uri) {
        mIsDeeplink = fromScheme;
        mBlockJump = fromScheme && !INSTANCE.isUriInWhiteList(uri);
        INSTANCE.logI(TAG, "block clipboard jump: fromScheme=" + fromScheme + ", uri=" + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0002, B:5:0x0016, B:7:0x0029, B:9:0x002e, B:16:0x003b, B:17:0x0042, B:19:0x0048, B:22:0x0057), top: B:26:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isUriInWhiteList(String uri) {
        boolean z;
        try {
            String str = (String) ConfigManager.Companion.config().get("main.clipboard_jump_white_list", "");
            Object obj = null;
            List whiteList = str != null ? StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null) : null;
            List list = whiteList;
            if (list != null && !list.isEmpty()) {
                z = false;
                if (!z) {
                    return false;
                }
                Iterator it = whiteList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String it2 = (String) next;
                    if (UriUtils.equals(uri, it2)) {
                        obj = next;
                        break;
                    }
                }
                return FlutterWebModCheckerKt.isNotNullAndNotEmpty((CharSequence) obj);
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            return false;
        }
    }

    public final void injectLogConsumer$core_apinkDebug(GrowthLogConsumer logConsumer2) {
        Intrinsics.checkNotNullParameter(logConsumer2, "logConsumer");
        logConsumer = logConsumer2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logI(String tag, String message) {
        BLog.i(tag, message);
        GrowthLogConsumer growthLogConsumer = logConsumer;
        if (growthLogConsumer != null) {
            growthLogConsumer.consume(tag, message, 4);
        }
    }

    private final void logE(String tag, String message, Throwable t) {
        BLog.e(tag, message, t);
        GrowthLogConsumer growthLogConsumer = logConsumer;
        if (growthLogConsumer != null) {
            growthLogConsumer.consume(tag, message, 6);
        }
    }
}