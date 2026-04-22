package tv.danmaku.bili.moss;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Switch;
import com.bilibili.base.BiliContext;
import com.bilibili.base.SharedPreferencesHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.ui.BaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.moss.test.cases.bandwidth.HeartbeatTestKt;
import tv.danmaku.bili.moss.test.cases.bandwidth.SpaceTestKt;
import tv.danmaku.bili.moss.test.cases.bandwidth.SplashTestKt;
import tv.danmaku.bili.moss.test.cases.stream.AppPushTestKt;
import tv.danmaku.bili.moss.test.cases.stream.LogUploadTestKt;
import tv.danmaku.bili.moss.test.cases.stream.ModTestKt;
import tv.danmaku.bili.moss.test.cases.stream.RoomTestKt;
import tv.danmaku.bili.moss.test.cases.unary.DfmTestKt;
import tv.danmaku.bili.moss.test.cases.unary.ProbeTestKt;
import tv.danmaku.bili.moss.test.cases.unary.RegionTestKt;
import tv.danmaku.bili.moss.test.cases.unary.SearchTestKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.OptionsKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoBodyKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoDeleteKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoErrorKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoKt;
import tv.danmaku.bili.moss.test.cases.unary.rest.app.EchoPatchKt;
import tv.danmaku.bili.moss.test.cases.unary.ticket.TicketServiceKt;
import tv.danmaku.bili.moss.test.configs.MossDevConfig;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: MossConfigFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\"H\u0002J\u0010\u0010e\u001a\u00020c2\u0006\u0010d\u001a\u00020\"H\u0002J\u0010\u0010f\u001a\u00020c2\u0006\u0010d\u001a\u00020\"H\u0002J\u000e\u0010g\u001a\u00020c2\u0006\u0010d\u001a\u00020\"J\u000e\u0010h\u001a\u00020c2\u0006\u0010d\u001a\u00020\"J\u000e\u0010i\u001a\u00020c2\u0006\u0010d\u001a\u00020\"J\u000e\u0010j\u001a\u00020c2\u0006\u0010d\u001a\u00020\"J\u000e\u0010k\u001a\u00020c2\u0006\u0010d\u001a\u00020\"J\u000e\u0010l\u001a\u00020c2\u0006\u0010m\u001a\u00020\"J\u000e\u0010n\u001a\u00020c2\u0006\u0010m\u001a\u00020\"J\u000e\u0010o\u001a\u00020c2\u0006\u0010m\u001a\u00020\"J\u000e\u0010p\u001a\u00020c2\u0006\u0010m\u001a\u00020\"J\b\u0010d\u001a\u00020\"H\u0002J\u001a\u0010q\u001a\u00020c2\u0006\u0010r\u001a\u00020[2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010s\u001a\u00020cH\u0002J\b\u0010t\u001a\u00020cH\u0002J\b\u0010u\u001a\u00020cH\u0002J\b\u0010v\u001a\u00020cH\u0002J\b\u0010w\u001a\u00020cH\u0002J\b\u0010x\u001a\u00020cH\u0002J\b\u0010y\u001a\u00020cH\u0002J\b\u0010z\u001a\u00020cH\u0002J\b\u0010{\u001a\u00020cH\u0002J\b\u0010|\u001a\u00020cH\u0002J\b\u0010}\u001a\u00020cH\u0002J\b\u0010~\u001a\u00020cH\u0002J\u0011\u0010\u007f\u001a\u00020c2\u0007\u0010\u0080\u0001\u001a\u00020\"H\u0002J\t\u0010\u0081\u0001\u001a\u00020cH\u0002J\u0012\u0010\u0082\u0001\u001a\u00020c2\u0007\u0010\u0083\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0084\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0085\u0001\u001a\u00020cH\u0002J\t\u0010\u0086\u0001\u001a\u00020cH\u0002J\t\u0010\u0087\u0001\u001a\u00020cH\u0002J\t\u0010\u0088\u0001\u001a\u00020cH\u0002J\t\u0010\u0089\u0001\u001a\u00020cH\u0002J\t\u0010\u008a\u0001\u001a\u00020cH\u0002J\u009c\u0001\u0010\u008b\u0001\u001a\u00020c2C\u0010\u008c\u0001\u001a>\u0012\u0016\u0012\u00140\u008e\u0001¢\u0006\u000e\b\u008f\u0001\u0012\t\b\u0090\u0001\u0012\u0004\b\b(\u0006\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u008f\u0001\u0012\n\b\u0090\u0001\u0012\u0005\b\b(\u0091\u0001\u0012\u0004\u0012\u00020c0\u008d\u0001j\u0003`\u0092\u00012C\u0010\u0093\u0001\u001a>\u0012\u0016\u0012\u00140\u008e\u0001¢\u0006\u000e\b\u008f\u0001\u0012\t\b\u0090\u0001\u0012\u0004\b\b(\u0006\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u008f\u0001\u0012\n\b\u0090\u0001\u0012\u0005\b\b(\u0091\u0001\u0012\u0004\u0012\u00020c0\u008d\u0001j\u0003`\u0092\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0005H\u0003J\t\u0010\u0094\u0001\u001a\u00020cH\u0002J\t\u0010\u0095\u0001\u001a\u00020cH\u0002J\u001b\u0010\u0096\u0001\u001a\u00020c2\u0007\u0010\u0097\u0001\u001a\u00020*2\u0007\u0010\u0098\u0001\u001a\u00020*H\u0002J\t\u0010\u0099\u0001\u001a\u00020cH\u0002J\t\u0010\u009a\u0001\u001a\u00020cH\u0002J\t\u0010\u009b\u0001\u001a\u00020cH\u0002J\t\u0010\u009c\u0001\u001a\u00020cH\u0002J\t\u0010\u009d\u0001\u001a\u00020cH\u0002J\t\u0010\u009e\u0001\u001a\u00020cH\u0002J\t\u0010\u009f\u0001\u001a\u00020cH\u0002J\t\u0010 \u0001\u001a\u00020cH\u0002J\t\u0010¡\u0001\u001a\u00020cH\u0002J\t\u0010¢\u0001\u001a\u00020cH\u0002J\t\u0010£\u0001\u001a\u00020cH\u0002J\t\u0010¤\u0001\u001a\u00020cH\u0002J\t\u0010¥\u0001\u001a\u00020cH\u0002J\t\u0010¦\u0001\u001a\u00020cH\u0002J\t\u0010§\u0001\u001a\u00020cH\u0002J\t\u0010¨\u0001\u001a\u00020cH\u0002J\t\u0010©\u0001\u001a\u00020cH\u0002J\t\u0010ª\u0001\u001a\u00020cH\u0002J\t\u0010«\u0001\u001a\u00020cH\u0002J\t\u0010¬\u0001\u001a\u00020cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u000208X\u0082.¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u0003R\u000e\u0010<\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u00ad\u0001"}, d2 = {"Ltv/danmaku/bili/moss/MossConfigFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "TAG", "", "context", "Landroid/app/Application;", "helper", "Lcom/bilibili/base/SharedPreferencesHelper;", "mScroll", "Landroid/widget/ScrollView;", "mToolEnable", "Landroid/widget/Switch;", "mBizBrpcEnable", "mTestFailover", "mTestDowngrade", "mTestBlockingApi", "mTestCount", "Landroid/widget/EditText;", "mTestSerial", "mTestSerialInterval", "mTestUat", "mTestTimeoutInSeconds", "mTestQuic", "mTestNewChannel", "mTestFallbackGrpcEncoding", "mTestHttpDns", "mTestOkHttpBridge", "mTestBroadcastPort", "mTestBroadcastHeartbeatInterval", "mTestBroadcastHeartbeatRetryInterval", "mTestBroadcastHeartbeatEnable", "failover", "", "blockingApi", "downgrade", "count", "", "serial", "serialInterval", "SERIAL_INTERVAL_IN_MS", "", "uat", "timeoutInSeconds", "quic", "newChannel", "fallbackGrpcEncoding", "httpdns", "broadcastPort", "broadcastHeartbeatInterval", "broadcastHeartbeatRetryInterval", "broadcastHeartbeatEnable", "roomId", "mTestSuggestEditKeyword", "mTestSuggestNormal", "Landroid/widget/Button;", "mTestSuggestNonExist", "mTestSuggestMalformed", "getMTestSuggestMalformed$annotations", "mTestSuggestRetrofit", "mTestRegionNormal", "mTestProbeCode", "mTestDfmSegEdit", "mTestDfmSeg", "mTestBroadcastStart", "mTestBroadcastStop", "mTestLogUploadWatch", "mTestLogUploadUnwatch", "mTestAddRegister", "mTestAdd", "mTestAddUnregister", "mTestModRegister", "mTestModUnregister", "mTestAppPushRegister", "mTestAppPushUnregister", "mTestRoomIdEdit", "mTestRoomJoin", "mTestRoomLeave", "mTestRoomOnline", "mTestBwHeartbeat", "mTestBwSplash", "mTestBwArchive", "mRestContentTypeForm", "mRestEcho", "mRestEchoBody", "mRestEchoDelete", "mRestEchoPatch", "mRestEchoError", "mGetTicket", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setAllEnable", "", "enable", "setBizEnable", "setTestEnable", "setTestSuggestEnable", "setTestRegionEnable", "setTestProbeEnable", "setTestDfmEnable", "setTestLogUploadEnable", "setTestRoomEnable", "enabled", "setTestBandwidthEnable", "setTestRestEnable", "setTestTicketEnable", "onViewCreated", "view", "initBiz", "initTest", "initTestSuggest", "initTestRegion", "initTestProbe", "intTestDfm", "initTestBandwidth", "initTestLogUpload", "initTestRoom", "initTestRest", "initTestTicket", "initTool", "withToolEnable", "toolEnable", "scroll", "printTestTarget", "method", "getKeyword", "testSuggestNoraml", "testSuggestNoExist", "testSuggestMalformed", "testBwHeartbeat", "testBwSplash", "testBwArchive", "doTest", "syncTest", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "str", "Ltv/danmaku/bili/moss/TestCase1;", "asyncTest", "testRegionNormal", "testProbeCode", "testDfmSeg", "aid", "cid", "testBroadcastStart", "testBroadcastStop", "testLogUploadWatch", "testLogUploadUnwatch", "testLogUploadAddRegister", "testLogUploadAdd", "testLogUploadAddUnregister", "testModRegister", "testModUnregister", "testAppPushRegister", "testAppPushUnregister", "testRoomJoin", "testRoomLeave", "testRoomOnline", "testRestEcho", "testRestEchoBody", "testRestEchoDelete", "testRestEchoPatch", "testRestEchoError", "testGetTicket", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MossConfigFragment extends BaseFragment {
    public static final int $stable = 8;
    private final long SERIAL_INTERVAL_IN_MS;
    private final String TAG = "moss.config";
    private boolean blockingApi;
    private boolean broadcastHeartbeatEnable;
    private int broadcastHeartbeatInterval;
    private int broadcastHeartbeatRetryInterval;
    private int broadcastPort;
    private final Application context;
    private int count;
    private boolean downgrade;
    private boolean failover;
    private boolean fallbackGrpcEncoding;
    private final SharedPreferencesHelper helper;
    private boolean httpdns;
    private Switch mBizBrpcEnable;
    private Button mGetTicket;
    private Switch mRestContentTypeForm;
    private Button mRestEcho;
    private Button mRestEchoBody;
    private Button mRestEchoDelete;
    private Button mRestEchoError;
    private Button mRestEchoPatch;
    private ScrollView mScroll;
    private Button mTestAdd;
    private Button mTestAddRegister;
    private Button mTestAddUnregister;
    private Button mTestAppPushRegister;
    private Button mTestAppPushUnregister;
    private Switch mTestBlockingApi;
    private Switch mTestBroadcastHeartbeatEnable;
    private EditText mTestBroadcastHeartbeatInterval;
    private EditText mTestBroadcastHeartbeatRetryInterval;
    private EditText mTestBroadcastPort;
    private Button mTestBroadcastStart;
    private Button mTestBroadcastStop;
    private Button mTestBwArchive;
    private Button mTestBwHeartbeat;
    private Button mTestBwSplash;
    private EditText mTestCount;
    private Button mTestDfmSeg;
    private EditText mTestDfmSegEdit;
    private Switch mTestDowngrade;
    private Switch mTestFailover;
    private Switch mTestFallbackGrpcEncoding;
    private Switch mTestHttpDns;
    private Button mTestLogUploadUnwatch;
    private Button mTestLogUploadWatch;
    private Button mTestModRegister;
    private Button mTestModUnregister;
    private Switch mTestNewChannel;
    private Switch mTestOkHttpBridge;
    private Button mTestProbeCode;
    private Switch mTestQuic;
    private Button mTestRegionNormal;
    private EditText mTestRoomIdEdit;
    private Button mTestRoomJoin;
    private Button mTestRoomLeave;
    private Button mTestRoomOnline;
    private Switch mTestSerial;
    private Switch mTestSerialInterval;
    private EditText mTestSuggestEditKeyword;
    private Button mTestSuggestMalformed;
    private Button mTestSuggestNonExist;
    private Button mTestSuggestNormal;
    private Button mTestSuggestRetrofit;
    private EditText mTestTimeoutInSeconds;
    private Switch mTestUat;
    private Switch mToolEnable;
    private boolean newChannel;
    private boolean quic;
    private String roomId;
    private boolean serial;
    private boolean serialInterval;
    private long timeoutInSeconds;
    private boolean uat;

    private static /* synthetic */ void getMTestSuggestMalformed$annotations() {
    }

    public MossConfigFragment() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        this.context = application;
        this.helper = new SharedPreferencesHelper(this.context, BLKV.getBLSharedPreferences$default(FoundationAlias.getFapp(), "moss", true, 0, 4, (Object) null));
        this.count = 1;
        this.SERIAL_INTERVAL_IN_MS = 10000L;
        this.timeoutInSeconds = 60L;
        this.fallbackGrpcEncoding = true;
        this.httpdns = true;
        this.broadcastPort = 7824;
        this.broadcastHeartbeatInterval = 60;
        this.broadcastHeartbeatRetryInterval = 15;
        this.broadcastHeartbeatEnable = true;
        this.roomId = "test://2233";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.bili_app_fragment_brpc_config, container, false);
        View findViewById = view.findViewById(R.id.scroll);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ScrollView");
        this.mScroll = (ScrollView) findViewById;
        View findViewById2 = view.findViewById(R.id.tool_enable);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.Switch");
        this.mToolEnable = (Switch) findViewById2;
        View findViewById3 = view.findViewById(R.id.biz_brpc_enable);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.Switch");
        this.mBizBrpcEnable = (Switch) findViewById3;
        View findViewById4 = view.findViewById(R.id.test_failover);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestFailover = (Switch) findViewById4;
        View findViewById5 = view.findViewById(R.id.test_downgrade);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestDowngrade = (Switch) findViewById5;
        View findViewById6 = view.findViewById(R.id.test_blocking_api);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestBlockingApi = (Switch) findViewById6;
        View findViewById7 = view.findViewById(R.id.edit_test_count);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestCount = (EditText) findViewById7;
        View findViewById8 = view.findViewById(R.id.brpc_test_serial);
        Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestSerial = (Switch) findViewById8;
        View findViewById9 = view.findViewById(R.id.brpc_test_serial_interval);
        Intrinsics.checkNotNull(findViewById9, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestSerialInterval = (Switch) findViewById9;
        View findViewById10 = view.findViewById(R.id.brpc_test_uat);
        Intrinsics.checkNotNull(findViewById10, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestUat = (Switch) findViewById10;
        View findViewById11 = view.findViewById(R.id.edit_test_timeout);
        Intrinsics.checkNotNull(findViewById11, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestTimeoutInSeconds = (EditText) findViewById11;
        View findViewById12 = view.findViewById(R.id.brpc_test_quic);
        Intrinsics.checkNotNull(findViewById12, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestQuic = (Switch) findViewById12;
        View findViewById13 = view.findViewById(R.id.brpc_test_new_channel);
        Intrinsics.checkNotNull(findViewById13, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestNewChannel = (Switch) findViewById13;
        View findViewById14 = view.findViewById(R.id.brpc_test_fallback_grpc_encoding);
        Intrinsics.checkNotNull(findViewById14, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestFallbackGrpcEncoding = (Switch) findViewById14;
        View findViewById15 = view.findViewById(R.id.brpc_test_httpdns);
        Intrinsics.checkNotNull(findViewById15, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestHttpDns = (Switch) findViewById15;
        View findViewById16 = view.findViewById(R.id.brpc_test_okhttp_bridge);
        Intrinsics.checkNotNull(findViewById16, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestOkHttpBridge = (Switch) findViewById16;
        View findViewById17 = view.findViewById(R.id.edit_test_broadcast_port);
        Intrinsics.checkNotNull(findViewById17, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestBroadcastPort = (EditText) findViewById17;
        View findViewById18 = view.findViewById(R.id.edit_test_broadcast_heartbeat);
        Intrinsics.checkNotNull(findViewById18, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestBroadcastHeartbeatInterval = (EditText) findViewById18;
        View findViewById19 = view.findViewById(R.id.edit_test_broadcast_heartbeat_retry);
        Intrinsics.checkNotNull(findViewById19, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestBroadcastHeartbeatRetryInterval = (EditText) findViewById19;
        View findViewById20 = view.findViewById(R.id.test_broadcast_heartbeat_enable);
        Intrinsics.checkNotNull(findViewById20, "null cannot be cast to non-null type android.widget.Switch");
        this.mTestBroadcastHeartbeatEnable = (Switch) findViewById20;
        View findViewById21 = view.findViewById(R.id.edit_test_suggest_keyword);
        Intrinsics.checkNotNull(findViewById21, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestSuggestEditKeyword = (EditText) findViewById21;
        View findViewById22 = view.findViewById(R.id.test_suggest_normal);
        Intrinsics.checkNotNull(findViewById22, "null cannot be cast to non-null type android.widget.Button");
        this.mTestSuggestNormal = (Button) findViewById22;
        View findViewById23 = view.findViewById(R.id.test_suggest_nonexist);
        Intrinsics.checkNotNull(findViewById23, "null cannot be cast to non-null type android.widget.Button");
        this.mTestSuggestNonExist = (Button) findViewById23;
        View findViewById24 = view.findViewById(R.id.test_suggest_malformed);
        Intrinsics.checkNotNull(findViewById24, "null cannot be cast to non-null type android.widget.Button");
        this.mTestSuggestMalformed = (Button) findViewById24;
        View findViewById25 = view.findViewById(R.id.test_suggest_retrofit);
        Intrinsics.checkNotNull(findViewById25, "null cannot be cast to non-null type android.widget.Button");
        this.mTestSuggestRetrofit = (Button) findViewById25;
        View findViewById26 = view.findViewById(R.id.test_region_normal);
        Intrinsics.checkNotNull(findViewById26, "null cannot be cast to non-null type android.widget.Button");
        this.mTestRegionNormal = (Button) findViewById26;
        View findViewById27 = view.findViewById(R.id.test_probe_code);
        Intrinsics.checkNotNull(findViewById27, "null cannot be cast to non-null type android.widget.Button");
        this.mTestProbeCode = (Button) findViewById27;
        View findViewById28 = view.findViewById(R.id.edit_test_dfm_aid_cid);
        Intrinsics.checkNotNull(findViewById28, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestDfmSegEdit = (EditText) findViewById28;
        View findViewById29 = view.findViewById(R.id.test_dfm_reg_mobile);
        Intrinsics.checkNotNull(findViewById29, "null cannot be cast to non-null type android.widget.Button");
        this.mTestDfmSeg = (Button) findViewById29;
        View findViewById30 = view.findViewById(R.id.test_broadcast_start);
        Intrinsics.checkNotNull(findViewById30, "null cannot be cast to non-null type android.widget.Button");
        this.mTestBroadcastStart = (Button) findViewById30;
        View findViewById31 = view.findViewById(R.id.test_broadcast_stop);
        Intrinsics.checkNotNull(findViewById31, "null cannot be cast to non-null type android.widget.Button");
        this.mTestBroadcastStop = (Button) findViewById31;
        View findViewById32 = view.findViewById(R.id.test_log_upload_watch);
        Intrinsics.checkNotNull(findViewById32, "null cannot be cast to non-null type android.widget.Button");
        this.mTestLogUploadWatch = (Button) findViewById32;
        View findViewById33 = view.findViewById(R.id.test_log_upload_unwatch);
        Intrinsics.checkNotNull(findViewById33, "null cannot be cast to non-null type android.widget.Button");
        this.mTestLogUploadUnwatch = (Button) findViewById33;
        View findViewById34 = view.findViewById(R.id.test_log_upload_add_register);
        Intrinsics.checkNotNull(findViewById34, "null cannot be cast to non-null type android.widget.Button");
        this.mTestAddRegister = (Button) findViewById34;
        View findViewById35 = view.findViewById(R.id.test_log_upload_add);
        Intrinsics.checkNotNull(findViewById35, "null cannot be cast to non-null type android.widget.Button");
        this.mTestAdd = (Button) findViewById35;
        View findViewById36 = view.findViewById(R.id.test_log_upload_add_unregister);
        Intrinsics.checkNotNull(findViewById36, "null cannot be cast to non-null type android.widget.Button");
        this.mTestAddUnregister = (Button) findViewById36;
        View findViewById37 = view.findViewById(R.id.test_broadcast_mod_register);
        Intrinsics.checkNotNull(findViewById37, "null cannot be cast to non-null type android.widget.Button");
        this.mTestModRegister = (Button) findViewById37;
        View findViewById38 = view.findViewById(R.id.test_broadcast_mod_unregister);
        Intrinsics.checkNotNull(findViewById38, "null cannot be cast to non-null type android.widget.Button");
        this.mTestModUnregister = (Button) findViewById38;
        View findViewById39 = view.findViewById(R.id.test_broadcast_app_push_register);
        Intrinsics.checkNotNull(findViewById39, "null cannot be cast to non-null type android.widget.Button");
        this.mTestAppPushRegister = (Button) findViewById39;
        View findViewById40 = view.findViewById(R.id.test_broadcast_app_push_unregister);
        Intrinsics.checkNotNull(findViewById40, "null cannot be cast to non-null type android.widget.Button");
        this.mTestAppPushUnregister = (Button) findViewById40;
        View findViewById41 = view.findViewById(R.id.edit_test_room_id);
        Intrinsics.checkNotNull(findViewById41, "null cannot be cast to non-null type android.widget.EditText");
        this.mTestRoomIdEdit = (EditText) findViewById41;
        View findViewById42 = view.findViewById(R.id.test_room_join);
        Intrinsics.checkNotNull(findViewById42, "null cannot be cast to non-null type android.widget.Button");
        this.mTestRoomJoin = (Button) findViewById42;
        View findViewById43 = view.findViewById(R.id.test_room_leave);
        Intrinsics.checkNotNull(findViewById43, "null cannot be cast to non-null type android.widget.Button");
        this.mTestRoomLeave = (Button) findViewById43;
        View findViewById44 = view.findViewById(R.id.test_room_online);
        Intrinsics.checkNotNull(findViewById44, "null cannot be cast to non-null type android.widget.Button");
        this.mTestRoomOnline = (Button) findViewById44;
        View findViewById45 = view.findViewById(R.id.test_bandwidth_heartbeat);
        Intrinsics.checkNotNull(findViewById45, "null cannot be cast to non-null type android.widget.Button");
        this.mTestBwHeartbeat = (Button) findViewById45;
        View findViewById46 = view.findViewById(R.id.test_bandwidth_splash);
        Intrinsics.checkNotNull(findViewById46, "null cannot be cast to non-null type android.widget.Button");
        this.mTestBwSplash = (Button) findViewById46;
        View findViewById47 = view.findViewById(R.id.test_bandwidth_space_archive);
        Intrinsics.checkNotNull(findViewById47, "null cannot be cast to non-null type android.widget.Button");
        this.mTestBwArchive = (Button) findViewById47;
        View findViewById48 = view.findViewById(R.id.test_rest_content_type_form);
        Intrinsics.checkNotNull(findViewById48, "null cannot be cast to non-null type android.widget.Switch");
        this.mRestContentTypeForm = (Switch) findViewById48;
        View findViewById49 = view.findViewById(R.id.rest_echo);
        Intrinsics.checkNotNull(findViewById49, "null cannot be cast to non-null type android.widget.Button");
        this.mRestEcho = (Button) findViewById49;
        View findViewById50 = view.findViewById(R.id.rest_echo_body);
        Intrinsics.checkNotNull(findViewById50, "null cannot be cast to non-null type android.widget.Button");
        this.mRestEchoBody = (Button) findViewById50;
        View findViewById51 = view.findViewById(R.id.rest_echo_delete);
        Intrinsics.checkNotNull(findViewById51, "null cannot be cast to non-null type android.widget.Button");
        this.mRestEchoDelete = (Button) findViewById51;
        View findViewById52 = view.findViewById(R.id.rest_echo_patch);
        Intrinsics.checkNotNull(findViewById52, "null cannot be cast to non-null type android.widget.Button");
        this.mRestEchoPatch = (Button) findViewById52;
        View findViewById53 = view.findViewById(R.id.rest_echo_error);
        Intrinsics.checkNotNull(findViewById53, "null cannot be cast to non-null type android.widget.Button");
        this.mRestEchoError = (Button) findViewById53;
        View findViewById54 = view.findViewById(R.id.get_ticket);
        Intrinsics.checkNotNull(findViewById54, "null cannot be cast to non-null type android.widget.Button");
        this.mGetTicket = (Button) findViewById54;
        return view;
    }

    private final void setAllEnable(boolean enable) {
        Switch r0 = this.mToolEnable;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolEnable");
            r0 = null;
        }
        r0.setEnabled(enable);
        setBizEnable(enable);
        setTestEnable(enable);
        setTestSuggestEnable(enable);
        setTestRegionEnable(enable);
        setTestProbeEnable(enable);
        setTestDfmEnable(enable);
        setTestLogUploadEnable(enable);
        setTestRoomEnable(enable);
        setTestBandwidthEnable(enable);
        setTestRestEnable(enable);
        setTestTicketEnable(enable);
    }

    private final void setBizEnable(boolean enable) {
        Switch r0 = this.mBizBrpcEnable;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBizBrpcEnable");
            r0 = null;
        }
        r0.setEnabled(enable);
    }

    private final void setTestEnable(boolean enable) {
        Switch r0 = this.mTestFailover;
        Switch r1 = null;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestFailover");
            r0 = null;
        }
        r0.setEnabled(enable);
        Switch r02 = this.mTestDowngrade;
        if (r02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDowngrade");
            r02 = null;
        }
        r02.setEnabled(enable);
        Switch r03 = this.mTestBlockingApi;
        if (r03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBlockingApi");
            r03 = null;
        }
        r03.setEnabled(enable);
        EditText editText = this.mTestCount;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestCount");
            editText = null;
        }
        editText.setEnabled(enable);
        Switch r04 = this.mTestSerial;
        if (r04 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSerial");
            r04 = null;
        }
        r04.setEnabled(enable);
        Switch r05 = this.mTestSerialInterval;
        if (r05 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSerialInterval");
            r05 = null;
        }
        r05.setEnabled(enable);
        Switch r06 = this.mTestUat;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestUat");
            r06 = null;
        }
        r06.setEnabled(enable);
        EditText editText2 = this.mTestTimeoutInSeconds;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestTimeoutInSeconds");
            editText2 = null;
        }
        editText2.setEnabled(enable);
        Switch r07 = this.mTestQuic;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestQuic");
            r07 = null;
        }
        r07.setEnabled(enable);
        Switch r08 = this.mTestNewChannel;
        if (r08 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestNewChannel");
            r08 = null;
        }
        r08.setEnabled(enable);
        Switch r09 = this.mTestFallbackGrpcEncoding;
        if (r09 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestFallbackGrpcEncoding");
            r09 = null;
        }
        r09.setEnabled(enable);
        Switch r010 = this.mTestHttpDns;
        if (r010 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestHttpDns");
            r010 = null;
        }
        r010.setEnabled(enable);
        Switch r011 = this.mTestOkHttpBridge;
        if (r011 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestOkHttpBridge");
            r011 = null;
        }
        r011.setEnabled(enable);
        EditText editText3 = this.mTestBroadcastPort;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastPort");
            editText3 = null;
        }
        editText3.setEnabled(enable);
        EditText editText4 = this.mTestBroadcastHeartbeatInterval;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatInterval");
            editText4 = null;
        }
        editText4.setEnabled(enable);
        EditText editText5 = this.mTestBroadcastHeartbeatRetryInterval;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatRetryInterval");
            editText5 = null;
        }
        editText5.setEnabled(enable);
        Switch r012 = this.mTestBroadcastHeartbeatEnable;
        if (r012 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatEnable");
        } else {
            r1 = r012;
        }
        r1.setEnabled(enable);
    }

    public final void setTestSuggestEnable(boolean enable) {
        EditText editText = this.mTestSuggestEditKeyword;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestEditKeyword");
            editText = null;
        }
        editText.setEnabled(enable);
        Button button2 = this.mTestSuggestNormal;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestNormal");
            button2 = null;
        }
        button2.setEnabled(enable);
        Button button3 = this.mTestSuggestNonExist;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestNonExist");
            button3 = null;
        }
        button3.setEnabled(enable);
        Button button4 = this.mTestSuggestMalformed;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestMalformed");
            button4 = null;
        }
        button4.setEnabled(enable);
        Button button5 = this.mTestSuggestRetrofit;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestRetrofit");
        } else {
            button = button5;
        }
        button.setEnabled(enable);
    }

    public final void setTestRegionEnable(boolean enable) {
        Button button = this.mTestRegionNormal;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRegionNormal");
            button = null;
        }
        button.setEnabled(enable);
    }

    public final void setTestProbeEnable(boolean enable) {
        Button button = this.mTestProbeCode;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestProbeCode");
            button = null;
        }
        button.setEnabled(enable);
    }

    public final void setTestDfmEnable(boolean enable) {
        EditText editText = this.mTestDfmSegEdit;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDfmSegEdit");
            editText = null;
        }
        editText.setEnabled(enable);
        Button button2 = this.mTestDfmSeg;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDfmSeg");
        } else {
            button = button2;
        }
        button.setEnabled(enable);
    }

    public final void setTestLogUploadEnable(boolean enable) {
        Button button = this.mTestBroadcastStart;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastStart");
            button = null;
        }
        button.setEnabled(enable);
        Button button3 = this.mTestBroadcastStop;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastStop");
            button3 = null;
        }
        button3.setEnabled(enable);
        Button button4 = this.mTestLogUploadWatch;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestLogUploadWatch");
            button4 = null;
        }
        button4.setEnabled(enable);
        Button button5 = this.mTestLogUploadUnwatch;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestLogUploadUnwatch");
            button5 = null;
        }
        button5.setEnabled(enable);
        Button button6 = this.mTestAddRegister;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAddRegister");
            button6 = null;
        }
        button6.setEnabled(enable);
        Button button7 = this.mTestAdd;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAdd");
            button7 = null;
        }
        button7.setEnabled(enable);
        Button button8 = this.mTestAddUnregister;
        if (button8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAddUnregister");
            button8 = null;
        }
        button8.setEnabled(enable);
        Button button9 = this.mTestModRegister;
        if (button9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestModRegister");
            button9 = null;
        }
        button9.setEnabled(enable);
        Button button10 = this.mTestModUnregister;
        if (button10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestModUnregister");
            button10 = null;
        }
        button10.setEnabled(enable);
        Button button11 = this.mTestAppPushRegister;
        if (button11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAppPushRegister");
            button11 = null;
        }
        button11.setEnabled(enable);
        Button button12 = this.mTestAppPushUnregister;
        if (button12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAppPushUnregister");
        } else {
            button2 = button12;
        }
        button2.setEnabled(enable);
    }

    public final void setTestRoomEnable(boolean enabled) {
        EditText editText = this.mTestRoomIdEdit;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomIdEdit");
            editText = null;
        }
        editText.setEnabled(enabled);
        Button button2 = this.mTestRoomJoin;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomJoin");
            button2 = null;
        }
        button2.setEnabled(enabled);
        Button button3 = this.mTestRoomLeave;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomLeave");
            button3 = null;
        }
        button3.setEnabled(enabled);
        Button button4 = this.mTestRoomOnline;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomOnline");
        } else {
            button = button4;
        }
        button.setEnabled(enabled);
    }

    public final void setTestBandwidthEnable(boolean enabled) {
        Button button = this.mTestBwHeartbeat;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBwHeartbeat");
            button = null;
        }
        button.setEnabled(enabled);
        Button button3 = this.mTestBwSplash;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBwSplash");
            button3 = null;
        }
        button3.setEnabled(enabled);
        Button button4 = this.mTestBwArchive;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBwArchive");
        } else {
            button2 = button4;
        }
        button2.setEnabled(enabled);
    }

    public final void setTestRestEnable(boolean enabled) {
        Switch r0 = this.mRestContentTypeForm;
        Button button = null;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestContentTypeForm");
            r0 = null;
        }
        r0.setEnabled(enabled);
        Button button2 = this.mRestEcho;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEcho");
            button2 = null;
        }
        button2.setEnabled(enabled);
        Button button3 = this.mRestEchoBody;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoBody");
            button3 = null;
        }
        button3.setEnabled(enabled);
        Button button4 = this.mRestEchoDelete;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoDelete");
            button4 = null;
        }
        button4.setEnabled(enabled);
        Button button5 = this.mRestEchoPatch;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoPatch");
            button5 = null;
        }
        button5.setEnabled(enabled);
        Button button6 = this.mRestEchoError;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoError");
        } else {
            button = button6;
        }
        button.setEnabled(enabled);
    }

    public final void setTestTicketEnable(boolean enabled) {
        Button button = this.mGetTicket;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGetTicket");
            button = null;
        }
        button.setEnabled(enabled);
    }

    private final boolean enable() {
        Boolean enable = MossDevConfig.INSTANCE.getEnable();
        return enable != null ? enable.booleanValue() : MossDevConfig.INSTANCE.getDEF_ENABLE();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!enable()) {
            BLog.e(this.TAG, "Moss debug tool is for debug build only.");
            setAllEnable(false);
            return;
        }
        initBiz();
        initTest();
        initTestSuggest();
        initTestRegion();
        initTestProbe();
        intTestDfm();
        initTestLogUpload();
        initTestRoom();
        initTestBandwidth();
        initTestRest();
        initTestTicket();
        initTool();
        scroll();
    }

    private final void initBiz() {
        boolean bizBrpcEnable = this.helper.optBoolean("brpc_debug_biz_brpc_enable", true);
        Switch r1 = this.mBizBrpcEnable;
        Switch r2 = null;
        if (r1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBizBrpcEnable");
            r1 = null;
        }
        r1.setChecked(bizBrpcEnable);
        Switch r12 = this.mBizBrpcEnable;
        if (r12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBizBrpcEnable");
        } else {
            r2 = r12;
        }
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda67
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initBiz$lambda$0(MossConfigFragment.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBiz$lambda$0(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Biz brpc set enable = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_biz_brpc_enable", isChecked);
    }

    private final void initTest() {
        this.failover = this.helper.optBoolean("brpc_debug_failover", false);
        Switch r0 = this.mTestFailover;
        Switch r3 = null;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestFailover");
            r0 = null;
        }
        r0.setChecked(this.failover);
        Switch r02 = this.mTestFailover;
        if (r02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestFailover");
            r02 = null;
        }
        r02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$0(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.downgrade = this.helper.optBoolean("brpc_debug_downgrade", false);
        Switch r03 = this.mTestDowngrade;
        if (r03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDowngrade");
            r03 = null;
        }
        r03.setChecked(this.downgrade);
        Switch r04 = this.mTestDowngrade;
        if (r04 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDowngrade");
            r04 = null;
        }
        r04.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda16
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$1(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.blockingApi = this.helper.optBoolean("brpc_debug_test_blocking_api", false);
        Switch r05 = this.mTestBlockingApi;
        if (r05 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBlockingApi");
            r05 = null;
        }
        r05.setChecked(this.blockingApi);
        Switch r06 = this.mTestBlockingApi;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBlockingApi");
            r06 = null;
        }
        r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$2(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.count = this.helper.optInteger("brpc_debug_test_count", 1);
        EditText editText = this.mTestCount;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestCount");
            editText = null;
        }
        editText.setText(String.valueOf(this.count));
        EditText editText2 = this.mTestCount;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestCount");
            editText2 = null;
        }
        editText2.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.moss.MossConfigFragment$initTest$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SharedPreferencesHelper sharedPreferencesHelper;
                Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(s));
                int c = intOrNull != null ? intOrNull.intValue() : 1;
                sharedPreferencesHelper = MossConfigFragment.this.helper;
                sharedPreferencesHelper.setInteger("brpc_debug_test_count", c);
                MossConfigFragment.this.count = c;
            }
        });
        this.serial = this.helper.optBoolean("brpc_debug_test_serial", false);
        Switch r07 = this.mTestSerial;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSerial");
            r07 = null;
        }
        r07.setChecked(this.serial);
        Switch r08 = this.mTestSerial;
        if (r08 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSerial");
            r08 = null;
        }
        r08.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda18
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$3(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.serialInterval = this.helper.optBoolean("brpc_debug_test_serial_interval", false);
        Switch r09 = this.mTestSerialInterval;
        if (r09 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSerialInterval");
            r09 = null;
        }
        r09.setChecked(this.serialInterval);
        Switch r010 = this.mTestSerialInterval;
        if (r010 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSerialInterval");
            r010 = null;
        }
        r010.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda19
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$4(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.uat = this.helper.optBoolean("brpc_debug_test_uat", false);
        Switch r011 = this.mTestUat;
        if (r011 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestUat");
            r011 = null;
        }
        r011.setChecked(this.uat);
        Switch r012 = this.mTestUat;
        if (r012 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestUat");
            r012 = null;
        }
        r012.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda20
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$5(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.timeoutInSeconds = this.helper.optLong("brpc_debug_test_timeout_in_seconds", 60L);
        EditText editText3 = this.mTestTimeoutInSeconds;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestTimeoutInSeconds");
            editText3 = null;
        }
        editText3.setText(String.valueOf(this.timeoutInSeconds));
        EditText editText4 = this.mTestTimeoutInSeconds;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestTimeoutInSeconds");
            editText4 = null;
        }
        editText4.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.moss.MossConfigFragment$initTest$8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SharedPreferencesHelper sharedPreferencesHelper;
                Long longOrNull = StringsKt.toLongOrNull(String.valueOf(s));
                long t = longOrNull != null ? longOrNull.longValue() : 60L;
                sharedPreferencesHelper = MossConfigFragment.this.helper;
                sharedPreferencesHelper.setLong("brpc_debug_test_timeout_in_seconds", t);
                MossConfigFragment.this.timeoutInSeconds = t;
            }
        });
        this.quic = this.helper.optBoolean("brpc_debug_test_quic", false);
        Switch r013 = this.mTestQuic;
        if (r013 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestQuic");
            r013 = null;
        }
        r013.setChecked(this.quic);
        Switch r014 = this.mTestQuic;
        if (r014 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestQuic");
            r014 = null;
        }
        r014.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda21
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$6(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.newChannel = this.helper.optBoolean("brpc_debug_test_new_channel", false);
        Switch r015 = this.mTestNewChannel;
        if (r015 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestNewChannel");
            r015 = null;
        }
        r015.setChecked(this.newChannel);
        Switch r016 = this.mTestNewChannel;
        if (r016 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestNewChannel");
            r016 = null;
        }
        r016.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda23
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$7(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.fallbackGrpcEncoding = this.helper.optBoolean("brpc_debug_test_fallback_grpc_encoding", true);
        Switch r017 = this.mTestFallbackGrpcEncoding;
        if (r017 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestFallbackGrpcEncoding");
            r017 = null;
        }
        r017.setChecked(this.fallbackGrpcEncoding);
        Switch r018 = this.mTestFallbackGrpcEncoding;
        if (r018 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestFallbackGrpcEncoding");
            r018 = null;
        }
        r018.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda24
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$8(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.httpdns = this.helper.optBoolean("brpc_debug_test_native_httpdns", true);
        Switch r019 = this.mTestHttpDns;
        if (r019 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestHttpDns");
            r019 = null;
        }
        r019.setChecked(this.httpdns);
        Switch r020 = this.mTestHttpDns;
        if (r020 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestHttpDns");
            r020 = null;
        }
        r020.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda25
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$9(MossConfigFragment.this, compoundButton, z);
            }
        });
        this.broadcastPort = this.helper.optInteger("moss_debug_test_broadcast_port", 7824);
        EditText editText5 = this.mTestBroadcastPort;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastPort");
            editText5 = null;
        }
        editText5.setText(String.valueOf(this.broadcastPort));
        EditText editText6 = this.mTestBroadcastPort;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastPort");
            editText6 = null;
        }
        editText6.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.moss.MossConfigFragment$initTest$13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SharedPreferencesHelper sharedPreferencesHelper;
                Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(s));
                int v = intOrNull != null ? intOrNull.intValue() : 7824;
                sharedPreferencesHelper = MossConfigFragment.this.helper;
                sharedPreferencesHelper.setInteger("moss_debug_test_broadcast_port", v);
                MossConfigFragment.this.broadcastPort = v;
            }
        });
        this.broadcastHeartbeatInterval = this.helper.optInteger("moss_debug_test_broadcast_heartbeat_seconds", 60);
        EditText editText7 = this.mTestBroadcastHeartbeatInterval;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatInterval");
            editText7 = null;
        }
        editText7.setText(String.valueOf(this.broadcastHeartbeatInterval));
        EditText editText8 = this.mTestBroadcastHeartbeatInterval;
        if (editText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatInterval");
            editText8 = null;
        }
        editText8.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.moss.MossConfigFragment$initTest$14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SharedPreferencesHelper sharedPreferencesHelper;
                Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(s));
                int v = intOrNull != null ? intOrNull.intValue() : 60;
                sharedPreferencesHelper = MossConfigFragment.this.helper;
                sharedPreferencesHelper.setInteger("moss_debug_test_broadcast_heartbeat_seconds", v);
                MossConfigFragment.this.broadcastHeartbeatInterval = v;
            }
        });
        this.broadcastHeartbeatRetryInterval = this.helper.optInteger("moss_debug_test_broadcast_heartbeat_retry_seconds", 15);
        EditText editText9 = this.mTestBroadcastHeartbeatRetryInterval;
        if (editText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatRetryInterval");
            editText9 = null;
        }
        editText9.setText(String.valueOf(this.broadcastHeartbeatRetryInterval));
        EditText editText10 = this.mTestBroadcastHeartbeatRetryInterval;
        if (editText10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatRetryInterval");
            editText10 = null;
        }
        editText10.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.moss.MossConfigFragment$initTest$15
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SharedPreferencesHelper sharedPreferencesHelper;
                Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(s));
                int v = intOrNull != null ? intOrNull.intValue() : 15;
                sharedPreferencesHelper = MossConfigFragment.this.helper;
                sharedPreferencesHelper.setInteger("moss_debug_test_broadcast_heartbeat_retry_seconds", v);
                MossConfigFragment.this.broadcastHeartbeatRetryInterval = v;
            }
        });
        this.broadcastHeartbeatEnable = this.helper.optBoolean("moss_debug_test_broadcast_heartbeat_enable", true);
        Switch r021 = this.mTestBroadcastHeartbeatEnable;
        if (r021 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatEnable");
            r021 = null;
        }
        r021.setChecked(this.broadcastHeartbeatEnable);
        Switch r022 = this.mTestBroadcastHeartbeatEnable;
        if (r022 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastHeartbeatEnable");
        } else {
            r3 = r022;
        }
        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda15
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTest$lambda$10(MossConfigFragment.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$0(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Failover set enable = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_failover", isChecked);
        this$0.failover = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$1(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Downgrade set enable = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_downgrade", isChecked);
        this$0.downgrade = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$2(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Tracker details using listeners = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_blocking_api", isChecked);
        this$0.blockingApi = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$3(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test serial = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_serial", isChecked);
        this$0.serial = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$4(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test serial with interval = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_serial_interval", isChecked);
        this$0.serialInterval = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$5(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test with uat host = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_uat", isChecked);
        this$0.uat = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$6(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test with quic = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_quic", isChecked);
        this$0.quic = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$7(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test with new channel = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_new_channel", isChecked);
        this$0.newChannel = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$8(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test with fallback grpc encoding = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_fallback_grpc_encoding", isChecked);
        this$0.fallbackGrpcEncoding = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$9(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test with httpdns = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_test_native_httpdns", isChecked);
        this$0.httpdns = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTest$lambda$10(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test broadcast with heartbeat = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("moss_debug_test_broadcast_heartbeat_enable", isChecked);
        this$0.broadcastHeartbeatEnable = isChecked;
    }

    private final void initTestSuggest() {
        Button button = this.mTestSuggestNormal;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestNormal");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestSuggest$lambda$0(MossConfigFragment.this, view);
            }
        });
        Button button3 = this.mTestSuggestNonExist;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestNonExist");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestSuggest$lambda$1(MossConfigFragment.this, view);
            }
        });
        Button button4 = this.mTestSuggestMalformed;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestMalformed");
        } else {
            button2 = button4;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestSuggest$lambda$2(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestSuggest$lambda$0(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("suggestNoraml");
        this$0.testSuggestNoraml();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestSuggest$lambda$1(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("suggestNonExist");
        this$0.testSuggestNoExist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestSuggest$lambda$2(MossConfigFragment this$0, View it) {
        this$0.printTestTarget("suggestMalformed");
        this$0.testSuggestMalformed();
    }

    private final void initTestRegion() {
        Button button = this.mTestRegionNormal;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRegionNormal");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRegion$lambda$0(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRegion$lambda$0(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("regionNoraml");
        this$0.testRegionNormal();
    }

    private final void initTestProbe() {
        Button button = this.mTestProbeCode;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestProbeCode");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestProbe$lambda$0(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestProbe$lambda$0(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("probeCode");
        this$0.testProbeCode();
    }

    private final void intTestDfm() {
        Button button = this.mTestDfmSeg;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDfmSeg");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda78
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.intTestDfm$lambda$0(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intTestDfm$lambda$0(MossConfigFragment this$0, View v) {
        Long longOrNull;
        Long longOrNull2;
        this$0.printTestTarget("dfmSegMobile");
        EditText editText = this$0.mTestDfmSegEdit;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestDfmSegEdit");
            editText = null;
        }
        List array = StringsKt.split$default(StringsKt.trim(editText.getText().toString()).toString(), new String[]{","}, false, 0, 6, (Object) null);
        long j = 0;
        long aid = (array.isEmpty() || (longOrNull2 = StringsKt.toLongOrNull(StringsKt.trim((String) array.get(0)).toString())) == null) ? 0L : longOrNull2.longValue();
        if (array.size() > 1 && (longOrNull = StringsKt.toLongOrNull(StringsKt.trim((String) array.get(1)).toString())) != null) {
            j = longOrNull.longValue();
        }
        long cid = j;
        this$0.testDfmSeg(aid, cid);
    }

    private final void initTestBandwidth() {
        Button button = this.mTestBwHeartbeat;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBwHeartbeat");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestBandwidth$lambda$0(MossConfigFragment.this, view);
            }
        });
        Button button3 = this.mTestBwSplash;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBwSplash");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestBandwidth$lambda$1(MossConfigFragment.this, view);
            }
        });
        Button button4 = this.mTestBwArchive;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBwArchive");
        } else {
            button2 = button4;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestBandwidth$lambda$2(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestBandwidth$lambda$0(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("bwHeartbeat");
        this$0.testBwHeartbeat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestBandwidth$lambda$1(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("bwSplash");
        this$0.testBwSplash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestBandwidth$lambda$2(MossConfigFragment this$0, View it) {
        this$0.printTestTarget("bwArchive");
        this$0.testBwArchive();
    }

    private final void initTestLogUpload() {
        Button button = this.mTestBroadcastStart;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastStart");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$0(MossConfigFragment.this, view);
            }
        });
        Button button3 = this.mTestBroadcastStop;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestBroadcastStop");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$1(MossConfigFragment.this, view);
            }
        });
        Button button4 = this.mTestLogUploadWatch;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestLogUploadWatch");
            button4 = null;
        }
        button4.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$2(MossConfigFragment.this, view);
            }
        });
        Button button5 = this.mTestLogUploadUnwatch;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestLogUploadUnwatch");
            button5 = null;
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$3(MossConfigFragment.this, view);
            }
        });
        Button button6 = this.mTestAddRegister;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAddRegister");
            button6 = null;
        }
        button6.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda55
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$4(MossConfigFragment.this, view);
            }
        });
        Button button7 = this.mTestAdd;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAdd");
            button7 = null;
        }
        button7.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda66
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$5(MossConfigFragment.this, view);
            }
        });
        Button button8 = this.mTestAddUnregister;
        if (button8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAddUnregister");
            button8 = null;
        }
        button8.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda77
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$6(MossConfigFragment.this, view);
            }
        });
        Button button9 = this.mTestModRegister;
        if (button9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestModRegister");
            button9 = null;
        }
        button9.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda88
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$7(MossConfigFragment.this, view);
            }
        });
        Button button10 = this.mTestModUnregister;
        if (button10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestModUnregister");
            button10 = null;
        }
        button10.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda97
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$8(MossConfigFragment.this, view);
            }
        });
        Button button11 = this.mTestAppPushRegister;
        if (button11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAppPushRegister");
            button11 = null;
        }
        button11.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$9(MossConfigFragment.this, view);
            }
        });
        Button button12 = this.mTestAppPushUnregister;
        if (button12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestAppPushUnregister");
        } else {
            button2 = button12;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestLogUpload$lambda$10(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$0(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("broadcastStart");
        this$0.testBroadcastStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$1(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("broadcastStop");
        this$0.testBroadcastStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$2(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("logUploadWatch");
        this$0.testLogUploadWatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$3(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("logUploadUnwatch");
        this$0.testLogUploadUnwatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$4(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("AddRegister");
        this$0.testLogUploadAddRegister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$5(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("Add");
        this$0.testLogUploadAdd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$6(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("AddUnregister");
        this$0.testLogUploadAddUnregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$7(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("ModRegister");
        this$0.testModRegister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$8(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("ModUnregister");
        this$0.testModUnregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$9(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("AppPushRegister");
        this$0.testAppPushRegister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestLogUpload$lambda$10(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("AppPushUnregister");
        this$0.testAppPushUnregister();
    }

    private final void initTestRoom() {
        String optString = this.helper.optString("moss_debug_test_broadcast_room_id", "test://2233");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        this.roomId = optString;
        EditText editText = this.mTestRoomIdEdit;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomIdEdit");
            editText = null;
        }
        editText.setText(this.roomId);
        EditText editText2 = this.mTestRoomIdEdit;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomIdEdit");
            editText2 = null;
        }
        editText2.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.moss.MossConfigFragment$initTestRoom$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                SharedPreferencesHelper sharedPreferencesHelper;
                String v = StringsKt.trim(String.valueOf(s)).toString();
                sharedPreferencesHelper = MossConfigFragment.this.helper;
                sharedPreferencesHelper.setString("moss_debug_test_broadcast_room_id", v);
                MossConfigFragment.this.roomId = v;
            }
        });
        Button button2 = this.mTestRoomJoin;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomJoin");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRoom$lambda$0(MossConfigFragment.this, view);
            }
        });
        Button button3 = this.mTestRoomLeave;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomLeave");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRoom$lambda$1(MossConfigFragment.this, view);
            }
        });
        Button button4 = this.mTestRoomOnline;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestRoomOnline");
        } else {
            button = button4;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRoom$lambda$2(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRoom$lambda$0(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("RoomJoin");
        this$0.testRoomJoin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRoom$lambda$1(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("RoomLeave");
        this$0.testRoomLeave();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRoom$lambda$2(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("RoomOnline");
        this$0.testRoomOnline();
    }

    private final void initTestRest() {
        Switch r0 = this.mRestContentTypeForm;
        Button button = null;
        if (r0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestContentTypeForm");
            r0 = null;
        }
        r0.setChecked(OptionsKt.getFormType());
        Switch r02 = this.mRestContentTypeForm;
        if (r02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestContentTypeForm");
            r02 = null;
        }
        r02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda89
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTestRest$lambda$0(MossConfigFragment.this, compoundButton, z);
            }
        });
        Button button2 = this.mRestEcho;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEcho");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRest$lambda$1(MossConfigFragment.this, view);
            }
        });
        Button button3 = this.mRestEchoBody;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoBody");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda91
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRest$lambda$2(MossConfigFragment.this, view);
            }
        });
        Button button4 = this.mRestEchoDelete;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoDelete");
            button4 = null;
        }
        button4.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda92
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRest$lambda$3(MossConfigFragment.this, view);
            }
        });
        Button button5 = this.mRestEchoPatch;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoPatch");
            button5 = null;
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRest$lambda$4(MossConfigFragment.this, view);
            }
        });
        Button button6 = this.mRestEchoError;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRestEchoError");
        } else {
            button = button6;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestRest$lambda$5(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRest$lambda$0(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Test rest content type form = %b.", Boolean.valueOf(isChecked));
        OptionsKt.setFormType(isChecked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRest$lambda$1(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("RestEcho");
        this$0.testRestEcho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRest$lambda$2(MossConfigFragment this$0, View v) {
        this$0.printTestTarget("RestEchoBody");
        this$0.testRestEchoBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRest$lambda$3(MossConfigFragment this$0, View it) {
        this$0.printTestTarget("RestEchoDelete");
        this$0.testRestEchoDelete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRest$lambda$4(MossConfigFragment this$0, View it) {
        this$0.printTestTarget("RestEchoPatch");
        this$0.testRestEchoPatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestRest$lambda$5(MossConfigFragment this$0, View it) {
        this$0.printTestTarget("RestEchoError");
        this$0.testRestEchoError();
    }

    private final void initTestTicket() {
        Button button = this.mGetTicket;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGetTicket");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MossConfigFragment.initTestTicket$lambda$0(MossConfigFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTestTicket$lambda$0(MossConfigFragment this$0, View it) {
        this$0.printTestTarget("GetTicket");
        this$0.testGetTicket();
    }

    private final void initTool() {
        boolean toolEnable = this.helper.optBoolean("brpc_debug_tool_enable", false);
        Switch r1 = this.mToolEnable;
        Switch r2 = null;
        if (r1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolEnable");
            r1 = null;
        }
        r1.setChecked(toolEnable);
        withToolEnable(toolEnable);
        Switch r12 = this.mToolEnable;
        if (r12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolEnable");
        } else {
            r2 = r12;
        }
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda65
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MossConfigFragment.initTool$lambda$0(MossConfigFragment.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTool$lambda$0(MossConfigFragment this$0, CompoundButton buttonView, boolean isChecked) {
        BLog.vfmt(this$0.TAG, "Tool set enable = %b.", Boolean.valueOf(isChecked));
        this$0.helper.setBoolean("brpc_debug_tool_enable", isChecked);
        this$0.withToolEnable(isChecked);
    }

    private final void withToolEnable(boolean toolEnable) {
        setBizEnable(toolEnable);
        setTestEnable(toolEnable);
        setTestSuggestEnable(toolEnable);
        setTestRegionEnable(toolEnable);
        setTestProbeEnable(toolEnable);
        setTestDfmEnable(toolEnable);
        setTestLogUploadEnable(toolEnable);
        setTestRoomEnable(toolEnable);
        setTestBandwidthEnable(toolEnable);
        setTestRestEnable(toolEnable);
        setTestTicketEnable(toolEnable);
    }

    private final void scroll() {
        ScrollView scrollView = this.mScroll;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScroll");
            scrollView = null;
        }
        scrollView.post(new Runnable() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda83
            @Override // java.lang.Runnable
            public final void run() {
                MossConfigFragment.scroll$lambda$0(MossConfigFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scroll$lambda$0(MossConfigFragment this$0) {
        ScrollView scrollView = this$0.mScroll;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScroll");
            scrollView = null;
        }
        scrollView.fullScroll(BR.coverHorizontal);
    }

    private final void printTestTarget(String method) {
        BLog.vfmt(this.TAG, "Moss test %s, downgrade=%b, blockingApi=%b, count=%d, serial=%b.", method, Boolean.valueOf(this.downgrade), Boolean.valueOf(this.blockingApi), Integer.valueOf(this.count), Boolean.valueOf(this.serial));
    }

    private final String getKeyword() {
        EditText editText = this.mTestSuggestEditKeyword;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTestSuggestEditKeyword");
            editText = null;
        }
        return editText.getText().toString();
    }

    private final void testSuggestNoraml() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda35
            public final Object invoke(Object obj, Object obj2) {
                Unit testSuggestNoraml$lambda$0;
                testSuggestNoraml$lambda$0 = MossConfigFragment.testSuggestNoraml$lambda$0((Context) obj, (String) obj2);
                return testSuggestNoraml$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda36
            public final Object invoke(Object obj, Object obj2) {
                Unit testSuggestNoraml$lambda$1;
                testSuggestNoraml$lambda$1 = MossConfigFragment.testSuggestNoraml$lambda$1((Context) obj, (String) obj2);
                return testSuggestNoraml$lambda$1;
            }
        }, getKeyword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testSuggestNoraml$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SearchTestKt.testSuggestSync(context, keyword);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testSuggestNoraml$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SearchTestKt.testSuggestAsync(context, keyword);
        return Unit.INSTANCE;
    }

    private final void testSuggestNoExist() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda59
            public final Object invoke(Object obj, Object obj2) {
                Unit testSuggestNoExist$lambda$0;
                testSuggestNoExist$lambda$0 = MossConfigFragment.testSuggestNoExist$lambda$0((Context) obj, (String) obj2);
                return testSuggestNoExist$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda60
            public final Object invoke(Object obj, Object obj2) {
                Unit testSuggestNoExist$lambda$1;
                testSuggestNoExist$lambda$1 = MossConfigFragment.testSuggestNoExist$lambda$1((Context) obj, (String) obj2);
                return testSuggestNoExist$lambda$1;
            }
        }, getKeyword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testSuggestNoExist$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SearchTestKt.testNoExistSync(context, keyword);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testSuggestNoExist$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SearchTestKt.testNoExistAsync(context, keyword);
        return Unit.INSTANCE;
    }

    private final void testSuggestMalformed() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit testSuggestMalformed$lambda$0;
                testSuggestMalformed$lambda$0 = MossConfigFragment.testSuggestMalformed$lambda$0((Context) obj, (String) obj2);
                return testSuggestMalformed$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit testSuggestMalformed$lambda$1;
                testSuggestMalformed$lambda$1 = MossConfigFragment.testSuggestMalformed$lambda$1((Context) obj, (String) obj2);
                return testSuggestMalformed$lambda$1;
            }
        }, getKeyword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testSuggestMalformed$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SearchTestKt.testMalformedSync(context, keyword);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testSuggestMalformed$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SearchTestKt.testMalformedAsync(context, keyword);
        return Unit.INSTANCE;
    }

    private final void testBwHeartbeat() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda54
            public final Object invoke(Object obj, Object obj2) {
                Unit testBwHeartbeat$lambda$0;
                testBwHeartbeat$lambda$0 = MossConfigFragment.testBwHeartbeat$lambda$0((Context) obj, (String) obj2);
                return testBwHeartbeat$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda56
            public final Object invoke(Object obj, Object obj2) {
                Unit testBwHeartbeat$lambda$1;
                testBwHeartbeat$lambda$1 = MossConfigFragment.testBwHeartbeat$lambda$1((Context) obj, (String) obj2);
                return testBwHeartbeat$lambda$1;
            }
        }, getKeyword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBwHeartbeat$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        HeartbeatTestKt.testHeartbeatSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBwHeartbeat$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        HeartbeatTestKt.testHeartbeatAsync();
        return Unit.INSTANCE;
    }

    private final void testBwSplash() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda84
            public final Object invoke(Object obj, Object obj2) {
                Unit testBwSplash$lambda$0;
                testBwSplash$lambda$0 = MossConfigFragment.testBwSplash$lambda$0((Context) obj, (String) obj2);
                return testBwSplash$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda85
            public final Object invoke(Object obj, Object obj2) {
                Unit testBwSplash$lambda$1;
                testBwSplash$lambda$1 = MossConfigFragment.testBwSplash$lambda$1((Context) obj, (String) obj2);
                return testBwSplash$lambda$1;
            }
        }, getKeyword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBwSplash$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SplashTestKt.testSplashSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBwSplash$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SplashTestKt.testSplashAsync();
        return Unit.INSTANCE;
    }

    private final void testBwArchive() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda49
            public final Object invoke(Object obj, Object obj2) {
                Unit testBwArchive$lambda$0;
                testBwArchive$lambda$0 = MossConfigFragment.testBwArchive$lambda$0((Context) obj, (String) obj2);
                return testBwArchive$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda50
            public final Object invoke(Object obj, Object obj2) {
                Unit testBwArchive$lambda$1;
                testBwArchive$lambda$1 = MossConfigFragment.testBwArchive$lambda$1((Context) obj, (String) obj2);
                return testBwArchive$lambda$1;
            }
        }, getKeyword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBwArchive$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SpaceTestKt.testSpaceSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBwArchive$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        SpaceTestKt.testSpaceAsync();
        return Unit.INSTANCE;
    }

    private final void doTest(final Function2<? super Context, ? super String, Unit> function2, Function2<? super Context, ? super String, Unit> function22, final String str) {
        if (this.failover) {
            ToastHelper.showToastShort(getContext(), bili.resource.homepage.R.string.homepage_global_string_328);
        }
        if (this.serial) {
            if (!this.blockingApi) {
                ToastHelper.showToastShort(getContext(), bili.resource.homepage.R.string.homepage_global_string_175);
            }
            new Thread(new Runnable() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    MossConfigFragment.doTest$lambda$0(MossConfigFragment.this, function2, str);
                }
            }).start();
            return;
        }
        int i = this.count;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.blockingApi) {
                new Thread(new Runnable() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        MossConfigFragment.doTest$lambda$1(function2, this, str);
                    }
                }).start();
            } else {
                function22.invoke(this.context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doTest$lambda$0(MossConfigFragment this$0, Function2 $syncTest, String $str) {
        int i = this$0.count;
        for (int i2 = 0; i2 < i; i2++) {
            $syncTest.invoke(this$0.context, $str);
            if (this$0.serialInterval) {
                Thread.sleep(this$0.SERIAL_INTERVAL_IN_MS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doTest$lambda$1(Function2 $syncTest, MossConfigFragment this$0, String $str) {
        $syncTest.invoke(this$0.context, $str);
    }

    private final void testRegionNormal() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda32
            public final Object invoke(Object obj, Object obj2) {
                Unit testRegionNormal$lambda$0;
                testRegionNormal$lambda$0 = MossConfigFragment.testRegionNormal$lambda$0((Context) obj, (String) obj2);
                return testRegionNormal$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda34
            public final Object invoke(Object obj, Object obj2) {
                Unit testRegionNormal$lambda$1;
                testRegionNormal$lambda$1 = MossConfigFragment.testRegionNormal$lambda$1((Context) obj, (String) obj2);
                return testRegionNormal$lambda$1;
            }
        }, "hans");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRegionNormal$lambda$0(Context context, String lang) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lang, "lang");
        RegionTestKt.testRegionSync(context, lang);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRegionNormal$lambda$1(Context context, String lang) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lang, "lang");
        RegionTestKt.testRegionAsync(context, lang);
        return Unit.INSTANCE;
    }

    private final void testProbeCode() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda68
            public final Object invoke(Object obj, Object obj2) {
                Unit testProbeCode$lambda$0;
                testProbeCode$lambda$0 = MossConfigFragment.testProbeCode$lambda$0((Context) obj, (String) obj2);
                return testProbeCode$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda69
            public final Object invoke(Object obj, Object obj2) {
                Unit testProbeCode$lambda$1;
                testProbeCode$lambda$1 = MossConfigFragment.testProbeCode$lambda$1((Context) obj, (String) obj2);
                return testProbeCode$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testProbeCode$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        ProbeTestKt.testCodeSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testProbeCode$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        ProbeTestKt.testCodeAsync(context);
        return Unit.INSTANCE;
    }

    private final void testDfmSeg(final long aid, final long cid) {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2) {
                Unit testDfmSeg$lambda$0;
                testDfmSeg$lambda$0 = MossConfigFragment.testDfmSeg$lambda$0(aid, cid, (Context) obj, (String) obj2);
                return testDfmSeg$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2) {
                Unit testDfmSeg$lambda$1;
                testDfmSeg$lambda$1 = MossConfigFragment.testDfmSeg$lambda$1(aid, cid, (Context) obj, (String) obj2);
                return testDfmSeg$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testDfmSeg$lambda$0(long $aid, long $cid, Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        DfmTestKt.testDfmSegSync($aid, $cid);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testDfmSeg$lambda$1(long $aid, long $cid, Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        DfmTestKt.testDfmSegAsync($aid, $cid);
        return Unit.INSTANCE;
    }

    private final void testBroadcastStart() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda26
            public final Object invoke(Object obj, Object obj2) {
                Unit testBroadcastStart$lambda$0;
                testBroadcastStart$lambda$0 = MossConfigFragment.testBroadcastStart$lambda$0((Context) obj, (String) obj2);
                return testBroadcastStart$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda27
            public final Object invoke(Object obj, Object obj2) {
                Unit testBroadcastStart$lambda$1;
                testBroadcastStart$lambda$1 = MossConfigFragment.testBroadcastStart$lambda$1((Context) obj, (String) obj2);
                return testBroadcastStart$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBroadcastStart$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testBoadcastStartSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBroadcastStart$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testBroadcastStartAsync(context);
        return Unit.INSTANCE;
    }

    private final void testBroadcastStop() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda61
            public final Object invoke(Object obj, Object obj2) {
                Unit testBroadcastStop$lambda$0;
                testBroadcastStop$lambda$0 = MossConfigFragment.testBroadcastStop$lambda$0((Context) obj, (String) obj2);
                return testBroadcastStop$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda62
            public final Object invoke(Object obj, Object obj2) {
                Unit testBroadcastStop$lambda$1;
                testBroadcastStop$lambda$1 = MossConfigFragment.testBroadcastStop$lambda$1((Context) obj, (String) obj2);
                return testBroadcastStop$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBroadcastStop$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testBoadcastStopSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testBroadcastStop$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testBroadcastStopAsync(context);
        return Unit.INSTANCE;
    }

    private final void testLogUploadWatch() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda81
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadWatch$lambda$0;
                testLogUploadWatch$lambda$0 = MossConfigFragment.testLogUploadWatch$lambda$0((Context) obj, (String) obj2);
                return testLogUploadWatch$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda82
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadWatch$lambda$1;
                testLogUploadWatch$lambda$1 = MossConfigFragment.testLogUploadWatch$lambda$1((Context) obj, (String) obj2);
                return testLogUploadWatch$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadWatch$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadWatchSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadWatch$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadWatchAsync(context);
        return Unit.INSTANCE;
    }

    private final void testLogUploadUnwatch() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda95
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadUnwatch$lambda$0;
                testLogUploadUnwatch$lambda$0 = MossConfigFragment.testLogUploadUnwatch$lambda$0((Context) obj, (String) obj2);
                return testLogUploadUnwatch$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda96
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadUnwatch$lambda$1;
                testLogUploadUnwatch$lambda$1 = MossConfigFragment.testLogUploadUnwatch$lambda$1((Context) obj, (String) obj2);
                return testLogUploadUnwatch$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadUnwatch$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadUnwatchSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadUnwatch$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadUnwatchAsync(context);
        return Unit.INSTANCE;
    }

    private final void testLogUploadAddRegister() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda12
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadAddRegister$lambda$0;
                testLogUploadAddRegister$lambda$0 = MossConfigFragment.testLogUploadAddRegister$lambda$0((Context) obj, (String) obj2);
                return testLogUploadAddRegister$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadAddRegister$lambda$1;
                testLogUploadAddRegister$lambda$1 = MossConfigFragment.testLogUploadAddRegister$lambda$1((Context) obj, (String) obj2);
                return testLogUploadAddRegister$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadAddRegister$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadAddRegisterSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadAddRegister$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadAddRegisterAsync(context);
        return Unit.INSTANCE;
    }

    private final void testLogUploadAdd() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda63
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadAdd$lambda$0;
                testLogUploadAdd$lambda$0 = MossConfigFragment.testLogUploadAdd$lambda$0((Context) obj, (String) obj2);
                return testLogUploadAdd$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda64
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadAdd$lambda$1;
                testLogUploadAdd$lambda$1 = MossConfigFragment.testLogUploadAdd$lambda$1((Context) obj, (String) obj2);
                return testLogUploadAdd$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadAdd$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadAddSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadAdd$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadAddAsync(context);
        return Unit.INSTANCE;
    }

    private final void testLogUploadAddUnregister() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda75
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadAddUnregister$lambda$0;
                testLogUploadAddUnregister$lambda$0 = MossConfigFragment.testLogUploadAddUnregister$lambda$0((Context) obj, (String) obj2);
                return testLogUploadAddUnregister$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda76
            public final Object invoke(Object obj, Object obj2) {
                Unit testLogUploadAddUnregister$lambda$1;
                testLogUploadAddUnregister$lambda$1 = MossConfigFragment.testLogUploadAddUnregister$lambda$1((Context) obj, (String) obj2);
                return testLogUploadAddUnregister$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadAddUnregister$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadAddUnregisterSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testLogUploadAddUnregister$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        LogUploadTestKt.testLogUploadAddUnregisterAsync(context);
        return Unit.INSTANCE;
    }

    private final void testModRegister() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda28
            public final Object invoke(Object obj, Object obj2) {
                Unit testModRegister$lambda$0;
                testModRegister$lambda$0 = MossConfigFragment.testModRegister$lambda$0((Context) obj, (String) obj2);
                return testModRegister$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda29
            public final Object invoke(Object obj, Object obj2) {
                Unit testModRegister$lambda$1;
                testModRegister$lambda$1 = MossConfigFragment.testModRegister$lambda$1((Context) obj, (String) obj2);
                return testModRegister$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testModRegister$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        ModTestKt.testModRegisterSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testModRegister$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        ModTestKt.testModRegisterAsync(context);
        return Unit.INSTANCE;
    }

    private final void testModUnregister() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit testModUnregister$lambda$0;
                testModUnregister$lambda$0 = MossConfigFragment.testModUnregister$lambda$0((Context) obj, (String) obj2);
                return testModUnregister$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit testModUnregister$lambda$1;
                testModUnregister$lambda$1 = MossConfigFragment.testModUnregister$lambda$1((Context) obj, (String) obj2);
                return testModUnregister$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testModUnregister$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        ModTestKt.testModUnregisterSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testModUnregister$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        ModTestKt.testModUnregisterAsync(context);
        return Unit.INSTANCE;
    }

    private final void testAppPushRegister() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda57
            public final Object invoke(Object obj, Object obj2) {
                Unit testAppPushRegister$lambda$0;
                testAppPushRegister$lambda$0 = MossConfigFragment.testAppPushRegister$lambda$0((Context) obj, (String) obj2);
                return testAppPushRegister$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda58
            public final Object invoke(Object obj, Object obj2) {
                Unit testAppPushRegister$lambda$1;
                testAppPushRegister$lambda$1 = MossConfigFragment.testAppPushRegister$lambda$1((Context) obj, (String) obj2);
                return testAppPushRegister$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testAppPushRegister$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        AppPushTestKt.testAppPushRegisterSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testAppPushRegister$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        AppPushTestKt.testAppPushRegisterAsync(context);
        return Unit.INSTANCE;
    }

    private final void testAppPushUnregister() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda86
            public final Object invoke(Object obj, Object obj2) {
                Unit testAppPushUnregister$lambda$0;
                testAppPushUnregister$lambda$0 = MossConfigFragment.testAppPushUnregister$lambda$0((Context) obj, (String) obj2);
                return testAppPushUnregister$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda87
            public final Object invoke(Object obj, Object obj2) {
                Unit testAppPushUnregister$lambda$1;
                testAppPushUnregister$lambda$1 = MossConfigFragment.testAppPushUnregister$lambda$1((Context) obj, (String) obj2);
                return testAppPushUnregister$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testAppPushUnregister$lambda$0(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        AppPushTestKt.testAppPushUnregisterSync(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testAppPushUnregister$lambda$1(Context context, String arg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arg, LoginReporterV2.APP_ONEPASS_GUIDE_KEY);
        AppPushTestKt.testAppPushUnregisterAsync(context);
        return Unit.INSTANCE;
    }

    private final void testRoomJoin() {
        RoomTestKt.testRoomJoinAsync(this.roomId);
    }

    private final void testRoomLeave() {
        RoomTestKt.testRoomLeaveAsync(this.roomId);
    }

    private final void testRoomOnline() {
        RoomTestKt.testRoomOnlineAsync(this.roomId);
    }

    private final void testRestEcho() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda46
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEcho$lambda$0;
                testRestEcho$lambda$0 = MossConfigFragment.testRestEcho$lambda$0((Context) obj, (String) obj2);
                return testRestEcho$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda47
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEcho$lambda$1;
                testRestEcho$lambda$1 = MossConfigFragment.testRestEcho$lambda$1((Context) obj, (String) obj2);
                return testRestEcho$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEcho$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoKt.testEchoSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEcho$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoKt.testEchoAsync();
        return Unit.INSTANCE;
    }

    private final void testRestEchoBody() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda73
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoBody$lambda$0;
                testRestEchoBody$lambda$0 = MossConfigFragment.testRestEchoBody$lambda$0((Context) obj, (String) obj2);
                return testRestEchoBody$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda74
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoBody$lambda$1;
                testRestEchoBody$lambda$1 = MossConfigFragment.testRestEchoBody$lambda$1((Context) obj, (String) obj2);
                return testRestEchoBody$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoBody$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoBodyKt.testEchoBodySync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoBody$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoBodyKt.testEchoBodyAsync();
        return Unit.INSTANCE;
    }

    private final void testRestEchoDelete() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda70
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoDelete$lambda$0;
                testRestEchoDelete$lambda$0 = MossConfigFragment.testRestEchoDelete$lambda$0((Context) obj, (String) obj2);
                return testRestEchoDelete$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda71
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoDelete$lambda$1;
                testRestEchoDelete$lambda$1 = MossConfigFragment.testRestEchoDelete$lambda$1((Context) obj, (String) obj2);
                return testRestEchoDelete$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoDelete$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoDeleteKt.testEchoDeleteSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoDelete$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoDeleteKt.testEchoDeleteAsync();
        return Unit.INSTANCE;
    }

    private final void testRestEchoPatch() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda79
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoPatch$lambda$0;
                testRestEchoPatch$lambda$0 = MossConfigFragment.testRestEchoPatch$lambda$0((Context) obj, (String) obj2);
                return testRestEchoPatch$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda80
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoPatch$lambda$1;
                testRestEchoPatch$lambda$1 = MossConfigFragment.testRestEchoPatch$lambda$1((Context) obj, (String) obj2);
                return testRestEchoPatch$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoPatch$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoPatchKt.testEchoPatchSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoPatch$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoPatchKt.testEchoPatchAsync();
        return Unit.INSTANCE;
    }

    private final void testRestEchoError() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda30
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoError$lambda$0;
                testRestEchoError$lambda$0 = MossConfigFragment.testRestEchoError$lambda$0((Context) obj, (String) obj2);
                return testRestEchoError$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda31
            public final Object invoke(Object obj, Object obj2) {
                Unit testRestEchoError$lambda$1;
                testRestEchoError$lambda$1 = MossConfigFragment.testRestEchoError$lambda$1((Context) obj, (String) obj2);
                return testRestEchoError$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoError$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoErrorKt.testEchoErrorSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testRestEchoError$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        EchoErrorKt.testEchoErrorAsync();
        return Unit.INSTANCE;
    }

    private final void testGetTicket() {
        doTest(new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda43
            public final Object invoke(Object obj, Object obj2) {
                Unit testGetTicket$lambda$0;
                testGetTicket$lambda$0 = MossConfigFragment.testGetTicket$lambda$0((Context) obj, (String) obj2);
                return testGetTicket$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.moss.MossConfigFragment$$ExternalSyntheticLambda45
            public final Object invoke(Object obj, Object obj2) {
                Unit testGetTicket$lambda$1;
                testGetTicket$lambda$1 = MossConfigFragment.testGetTicket$lambda$1((Context) obj, (String) obj2);
                return testGetTicket$lambda$1;
            }
        }, "na");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testGetTicket$lambda$0(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        TicketServiceKt.testGetTicketSync();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit testGetTicket$lambda$1(Context context, String keyword) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        TicketServiceKt.testGetTicketAsync();
        return Unit.INSTANCE;
    }
}