package tv.danmaku.bili.quick.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.accountui.R;
import com.bilibili.app.accountui.databinding.BiliAppDialogLoginEulaBinding;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.accountsui.LoginRedirectProxy;
import com.bilibili.lib.accountsui.quick.IQuickLoginView;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginPresenter;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.accountsui.quick.core.ILoginOnePass;
import com.bilibili.lib.accountsui.utils.ILoginLimitUpdate;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.module.account.ILoginExperiment;
import com.bilibili.module.account.LoginExperimentHelperKt;
import com.bilibili.module.main.innerpush.IShowPushWhenPageDestroy;
import com.bilibili.pvtracker.IPvTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.helper.LoginLifecycleObserver;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;
import tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.LoginIspHelper;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.answer.AnswerDialogTransferActivity;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.LoginAnswerDialogHelper;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.ui.util.AccountUtils;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.utils.reporter.CenterStyleLoginQuickReporter;
import tv.danmaku.bili.utils.reporter.ILoginQuickReporter;

/* compiled from: LoginQuickActivityV2.kt */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 Ï\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002Ï\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0083\u0001\u001a\u00030\u0084\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0014J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\u0016\u0010\u0089\u0001\u001a\u00030\u0084\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0014J\n\u0010\u008a\u0001\u001a\u00030\u0084\u0001H\u0002J\n\u0010\u008b\u0001\u001a\u00030\u0084\u0001H\u0014J\t\u0010\u008e\u0001\u001a\u00020SH\u0014J%\u0010\u008f\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u000b2\u0007\u0010\u0091\u0001\u001a\u00020\u00042\u0007\u0010\u0092\u0001\u001a\u00020;H\u0002J\u0012\u0010\u0093\u0001\u001a\u00020D2\u0007\u0010\u0092\u0001\u001a\u00020;H\u0002J\n\u0010\u0094\u0001\u001a\u00030\u0088\u0001H\u0014J\n\u0010\u0095\u0001\u001a\u00030\u0084\u0001H\u0014J\n\u0010\u0096\u0001\u001a\u00030\u0084\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0084\u0001H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u0084\u0001H\u0014J\n\u0010\u0099\u0001\u001a\u00030\u0084\u0001H\u0002J\n\u0010\u009a\u0001\u001a\u00030\u0084\u0001H\u0014J\u0014\u0010\u009b\u0001\u001a\u00030\u0084\u00012\b\u0010\u009c\u0001\u001a\u00030\u0088\u0001H\u0016J\u0013\u0010\u009d\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u009e\u0001\u001a\u00020/H\u0016J\n\u0010\u009f\u0001\u001a\u00030\u0084\u0001H\u0002J\u0013\u0010 \u0001\u001a\u00030\u0084\u00012\u0007\u0010¡\u0001\u001a\u00020;H\u0002J\u000e\u0010¢\u0001\u001a\u00030\u0088\u0001*\u00020;H\u0002J*\u0010£\u0001\u001a\u00030\u0084\u00012\b\u0010¤\u0001\u001a\u00030\u0088\u00012\b\u0010¥\u0001\u001a\u00030\u0088\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0014J\u0013\u0010¨\u0001\u001a\u00030\u0084\u00012\u0007\u0010©\u0001\u001a\u00020;H\u0002J\n\u0010¨\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010ª\u0001\u001a\u00030\u0084\u0001H\u0016J\u0014\u0010«\u0001\u001a\u00030\u0084\u00012\b\u0010¬\u0001\u001a\u00030\u0088\u0001H\u0016J\u0013\u0010«\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u00ad\u0001\u001a\u00020DH\u0016J\n\u0010®\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u0084\u0001H\u0016J\t\u0010°\u0001\u001a\u00020;H\u0016J\n\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0016\u0010³\u0001\u001a\u00030\u0084\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0016J\n\u0010¶\u0001\u001a\u00030\u0084\u0001H\u0016J2\u0010·\u0001\u001a\u00030\u0084\u00012\b\u0010¸\u0001\u001a\u00030\u0088\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010D2\u0011\u0010º\u0001\u001a\f\u0018\u00010»\u0001j\u0005\u0018\u0001`¼\u0001H\u0016J\n\u0010½\u0001\u001a\u00030\u0084\u0001H\u0002J\t\u0010¾\u0001\u001a\u00020DH\u0016J\t\u0010¿\u0001\u001a\u00020DH\u0016J\n\u0010À\u0001\u001a\u00030\u0086\u0001H\u0016J\u0014\u0010Á\u0001\u001a\u00030\u0084\u00012\b\u0010¬\u0001\u001a\u00030\u0088\u0001H\u0016J\u0015\u0010Á\u0001\u001a\u00030\u0084\u00012\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010DH\u0016J\n\u0010Â\u0001\u001a\u00030\u0084\u0001H\u0004J\u001e\u0010Ã\u0001\u001a\u00030\u0084\u00012\b\u00104\u001a\u0004\u0018\u00010/2\b\u0010¬\u0001\u001a\u00030\u0088\u0001H\u0004J\b\u0010Ä\u0001\u001a\u00030\u0084\u0001J\t\u0010Å\u0001\u001a\u00020;H\u0016J\u001a\u0010Æ\u0001\u001a\u00030\u0084\u00012\t\u0010Ç\u0001\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0002\u0010PJ\u0013\u0010È\u0001\u001a\u00030\u0084\u00012\u0007\u0010Ç\u0001\u001a\u00020;H\u0002J\t\u0010É\u0001\u001a\u00020;H\u0002J\u0016\u0010Ê\u0001\u001a\u00030\u0084\u00012\n\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0016J\u000f\u0010Í\u0001\u001a\u0004\u0018\u00010D*\u00020\u0017H\u0004J\n\u0010Î\u0001\u001a\u00030\u0084\u0001H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001c\u00107\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR\u001e\u0010L\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010=\"\u0004\bZ\u0010?R\u001c\u0010[\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R\u001c\u0010^\u001a\u0004\u0018\u00010_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001c\u0010d\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00101\"\u0004\bf\u00103R\u001c\u0010g\u001a\u0004\u0018\u00010hX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001a\u0010m\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010=\"\u0004\bo\u0010?R\u001e\u0010p\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bq\u0010N\"\u0004\br\u0010PR\u001c\u0010s\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010F\"\u0004\bu\u0010HR\u000e\u0010v\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u007f\u001a\u0004\u0018\u00010D8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010FR\u0018\u0010\u0081\u0001\u001a\u0004\u0018\u00010D8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010FR\u0017\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010\u008d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ð\u0001"}, d2 = {"Ltv/danmaku/bili/quick/ui/LoginQuickActivityV2;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/bilibili/lib/accountsui/quick/IQuickLoginView;", "Ltv/danmaku/bili/ui/AgreementLinkHelper$ClickLinkItemListener;", "Lcom/bilibili/pvtracker/IPvTracker;", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "Lcom/bilibili/module/main/innerpush/IShowPushWhenPageDestroy;", "<init>", "()V", "mTvPhoneNum", "Landroid/widget/TextView;", "getMTvPhoneNum", "()Landroid/widget/TextView;", "setMTvPhoneNum", "(Landroid/widget/TextView;)V", "mBtnLoginQuick", "Ltv/danmaku/bili/quick/ui/LoginQuickButton;", "getMBtnLoginQuick", "()Ltv/danmaku/bili/quick/ui/LoginQuickButton;", "setMBtnLoginQuick", "(Ltv/danmaku/bili/quick/ui/LoginQuickButton;)V", "mLoginQuickPresenter", "Lcom/bilibili/lib/accountsui/quick/QuickLoginPresenter;", "getMLoginQuickPresenter", "()Lcom/bilibili/lib/accountsui/quick/QuickLoginPresenter;", "setMLoginQuickPresenter", "(Lcom/bilibili/lib/accountsui/quick/QuickLoginPresenter;)V", "mTitle", "getMTitle", "setMTitle", "mBtnChangeWay", "getMBtnChangeWay", "setMBtnChangeWay", "mAgreementTv", "getMAgreementTv", "setMAgreementTv", "mSubTitle", "getMSubTitle", "setMSubTitle", "mContainer", "Landroid/view/ViewGroup;", "getMContainer", "()Landroid/view/ViewGroup;", "setMContainer", "(Landroid/view/ViewGroup;)V", "mContainerLogin", "Landroid/view/View;", "getMContainerLogin", "()Landroid/view/View;", "setMContainerLogin", "(Landroid/view/View;)V", "containerAnswer", "getContainerAnswer", "setContainerAnswer", "mClose", "getMClose", "setMClose", "mIsLoginGuide", "", "getMIsLoginGuide", "()Z", "setMIsLoginGuide", "(Z)V", "mIsProcessing", "getMIsProcessing", "setMIsProcessing", "mPromptScene", "", "getMPromptScene", "()Ljava/lang/String;", "setMPromptScene", "(Ljava/lang/String;)V", "mOutRoute", "getMOutRoute", "setMOutRoute", "mEnableSms", "getMEnableSms", "()Ljava/lang/Boolean;", "setMEnableSms", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mReporter", "Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;", "getMReporter", "()Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;", "setMReporter", "(Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;)V", "mSmsDirect", "getMSmsDirect", "setMSmsDirect", "mLoginRegPopView", "getMLoginRegPopView", "setMLoginRegPopView", "mLoginRegCheckBox", "Landroid/widget/CheckBox;", "getMLoginRegCheckBox", "()Landroid/widget/CheckBox;", "setMLoginRegCheckBox", "(Landroid/widget/CheckBox;)V", "mLoginRegCheckBoxContainer", "getMLoginRegCheckBoxContainer", "setMLoginRegCheckBoxContainer", "agreementLinkHelper", "Ltv/danmaku/bili/ui/AgreementLinkHelper;", "getAgreementLinkHelper", "()Ltv/danmaku/bili/ui/AgreementLinkHelper;", "setAgreementLinkHelper", "(Ltv/danmaku/bili/ui/AgreementLinkHelper;)V", "mAnyRegFlag", "getMAnyRegFlag", "setMAnyRegFlag", "mLoginExperiment", "getMLoginExperiment", "setMLoginExperiment", "mLoginExperimentValue", "getMLoginExperimentValue", "setMLoginExperimentValue", "checkBoxClick", "goOtherPage", "eulaGroup", "Lcom/bilibili/app/accountui/databinding/BiliAppDialogLoginEulaBinding;", "eulaDelegate", "Ltv/danmaku/bili/normal/ui/LoginEulaDialogViewDelegate;", "loginFullscreenExp", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "loginNewRoute", "pagePv", "getPagePv", "routeUri", "getRouteUri", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLayoutRes", "", "onPostCreate", "updateRegInfo", "onResume", "finishRunnable", "Lkotlin/Function0;", "getReporter", "attachLinkContentAgreement", "agreementText", "l", "init", "getCarrierText", "getViewStyle", "adjustEnterPendingTransition", "findViews", "clearViews", "adjustWindow", "setTitle", "onDestroy", "onItemLinkClick", "itemId", "onClick", "v", "doLogin", "setEulaDialogVisibility", ReportEvent.EVENT_TYPE_SHOW, "toVisibility", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "finish", "skipCheck", "alertVipStatusIfNeed", "showTip", "resId", "message", "showProgress", "hideProgress", "isProgressing", "getActivity", "Landroid/app/Activity;", "onLoginIntercept", "verifyBundle", "Lcom/bilibili/lib/accounts/VerifyBundle;", "onLoginSuccess", "onQuickLoginFail", "errorType", "errorMsg", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleNextAnswerDialog", "getLoginSpmid", "getPvEventId", "getPvExtra", "changeToAnswerMode", "hideLoginContent", "alphaAnimAttachClick", "answer", "shouldGoToAnswer", "changeLoginWay", "loginSmsEnable", "routeOtherLoginWay", "changeWayIntercept", "onChange", "topic", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "ispReportFlag", "increaseOnePassShowTimes", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class LoginQuickActivityV2 extends BaseAppCompatActivity implements View.OnClickListener, IQuickLoginView, AgreementLinkHelper.ClickLinkItemListener, IPvTracker, PassportObserver, IShowPushWhenPageDestroy {
    public static final String INTENT_KEY_LOGIN_EXPERIMENT = "loginExperiment";
    public static final String INTENT_KEY_LOGIN_EXPERIMENT_VALUE = "loginExperimentValue";
    public static final String INTENT_KEY_LOGIN_GUIDE_ENABLE = "loginGuideEnable";
    public static final String INTENT_KEY_LOGIN_GUIDE_SKIP_TIME = "loginGuideSkipTime";
    public static final String INTENT_KEY_OUT_ROUTE = "outRoute";
    public static final String INTENT_KEY_QUICK_ENABLE = "quickEnable";
    public static final String INTENT_KEY_SMS_DIRECT = "smsDirect";
    public static final String INTENT_KEY_SMS_ENABLE = "smsEnable";
    public static final int REQ_CODE_SECOND_VERIFY = 204;
    public static final String URL_ANSWER = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
    private AgreementLinkHelper agreementLinkHelper;
    private View containerAnswer;
    private LoginEulaDialogViewDelegate eulaDelegate;
    private BiliAppDialogLoginEulaBinding eulaGroup;
    private boolean goOtherPage;
    private boolean loginNewRoute;
    private TextView mAgreementTv;
    private boolean mAnyRegFlag;
    private TextView mBtnChangeWay;
    private LoginQuickButton mBtnLoginQuick;
    private View mClose;
    private ViewGroup mContainer;
    private View mContainerLogin;
    private boolean mIsLoginGuide;
    private boolean mIsProcessing;
    private String mLoginExperimentValue;
    private QuickLoginPresenter mLoginQuickPresenter;
    private CheckBox mLoginRegCheckBox;
    private View mLoginRegCheckBoxContainer;
    private View mLoginRegPopView;
    private String mOutRoute;
    private String mPromptScene;
    private ILoginQuickReporter mReporter;
    private boolean mSmsDirect;
    private TextView mSubTitle;
    private TextView mTitle;
    private TextView mTvPhoneNum;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private Boolean mEnableSms = false;
    private Boolean mLoginExperiment = false;
    private boolean checkBoxClick = true;
    private LoginExpType loginFullscreenExp = LoginExpType.CONTROL;
    private final Function0<Unit> finishRunnable = new Function0() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda3
        public final Object invoke() {
            Unit finishRunnable$lambda$0;
            finishRunnable$lambda$0 = LoginQuickActivityV2.finishRunnable$lambda$0(LoginQuickActivityV2.this);
            return finishRunnable$lambda$0;
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public final TextView getMTvPhoneNum() {
        return this.mTvPhoneNum;
    }

    public final void setMTvPhoneNum(TextView textView) {
        this.mTvPhoneNum = textView;
    }

    public final LoginQuickButton getMBtnLoginQuick() {
        return this.mBtnLoginQuick;
    }

    public final void setMBtnLoginQuick(LoginQuickButton loginQuickButton) {
        this.mBtnLoginQuick = loginQuickButton;
    }

    public final QuickLoginPresenter getMLoginQuickPresenter() {
        return this.mLoginQuickPresenter;
    }

    public final void setMLoginQuickPresenter(QuickLoginPresenter quickLoginPresenter) {
        this.mLoginQuickPresenter = quickLoginPresenter;
    }

    public final TextView getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(TextView textView) {
        this.mTitle = textView;
    }

    public final TextView getMBtnChangeWay() {
        return this.mBtnChangeWay;
    }

    public final void setMBtnChangeWay(TextView textView) {
        this.mBtnChangeWay = textView;
    }

    public final TextView getMAgreementTv() {
        return this.mAgreementTv;
    }

    public final void setMAgreementTv(TextView textView) {
        this.mAgreementTv = textView;
    }

    public final TextView getMSubTitle() {
        return this.mSubTitle;
    }

    public final void setMSubTitle(TextView textView) {
        this.mSubTitle = textView;
    }

    public final ViewGroup getMContainer() {
        return this.mContainer;
    }

    public final void setMContainer(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    public final View getMContainerLogin() {
        return this.mContainerLogin;
    }

    public final void setMContainerLogin(View view) {
        this.mContainerLogin = view;
    }

    public final View getContainerAnswer() {
        return this.containerAnswer;
    }

    public final void setContainerAnswer(View view) {
        this.containerAnswer = view;
    }

    public final View getMClose() {
        return this.mClose;
    }

    public final void setMClose(View view) {
        this.mClose = view;
    }

    public final boolean getMIsLoginGuide() {
        return this.mIsLoginGuide;
    }

    public final void setMIsLoginGuide(boolean z) {
        this.mIsLoginGuide = z;
    }

    public final boolean getMIsProcessing() {
        return this.mIsProcessing;
    }

    public final void setMIsProcessing(boolean z) {
        this.mIsProcessing = z;
    }

    public final String getMPromptScene() {
        return this.mPromptScene;
    }

    public final void setMPromptScene(String str) {
        this.mPromptScene = str;
    }

    public final String getMOutRoute() {
        return this.mOutRoute;
    }

    public final void setMOutRoute(String str) {
        this.mOutRoute = str;
    }

    public final Boolean getMEnableSms() {
        return this.mEnableSms;
    }

    public final void setMEnableSms(Boolean bool) {
        this.mEnableSms = bool;
    }

    public final ILoginQuickReporter getMReporter() {
        return this.mReporter;
    }

    public final void setMReporter(ILoginQuickReporter iLoginQuickReporter) {
        this.mReporter = iLoginQuickReporter;
    }

    public final boolean getMSmsDirect() {
        return this.mSmsDirect;
    }

    public final void setMSmsDirect(boolean z) {
        this.mSmsDirect = z;
    }

    public final View getMLoginRegPopView() {
        return this.mLoginRegPopView;
    }

    public final void setMLoginRegPopView(View view) {
        this.mLoginRegPopView = view;
    }

    public final CheckBox getMLoginRegCheckBox() {
        return this.mLoginRegCheckBox;
    }

    public final void setMLoginRegCheckBox(CheckBox checkBox) {
        this.mLoginRegCheckBox = checkBox;
    }

    public final View getMLoginRegCheckBoxContainer() {
        return this.mLoginRegCheckBoxContainer;
    }

    public final void setMLoginRegCheckBoxContainer(View view) {
        this.mLoginRegCheckBoxContainer = view;
    }

    public final AgreementLinkHelper getAgreementLinkHelper() {
        return this.agreementLinkHelper;
    }

    public final void setAgreementLinkHelper(AgreementLinkHelper agreementLinkHelper) {
        this.agreementLinkHelper = agreementLinkHelper;
    }

    public final boolean getMAnyRegFlag() {
        return this.mAnyRegFlag;
    }

    public final void setMAnyRegFlag(boolean z) {
        this.mAnyRegFlag = z;
    }

    public final Boolean getMLoginExperiment() {
        return this.mLoginExperiment;
    }

    public final void setMLoginExperiment(Boolean bool) {
        this.mLoginExperiment = bool;
    }

    public final String getMLoginExperimentValue() {
        return this.mLoginExperimentValue;
    }

    public final void setMLoginExperimentValue(String str) {
        this.mLoginExperimentValue = str;
    }

    public String getPagePv() {
        return this.mPromptScene;
    }

    public String getRouteUri() {
        return AccountUtils.Companion.getRouterFrom((Activity) this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        LoginExpType loginExpType;
        Bundle extras;
        Bundle it;
        Bundle $this$onCreate_u24lambda_u240_u240;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (it = intent.getExtras()) != null && ($this$onCreate_u24lambda_u240_u240 = it.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) != null) {
            it.putAll($this$onCreate_u24lambda_u240_u240);
        }
        Intent intent2 = getIntent();
        Bundle extraBundle = (intent2 == null || (extras = intent2.getExtras()) == null) ? null : extras.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE);
        this.mSmsDirect = BundleUtil.getBoolean(getIntent().getExtras(), INTENT_KEY_SMS_DIRECT, new boolean[]{false});
        this.mIsLoginGuide = BundleUtil.getBoolean(getIntent().getExtras(), INTENT_KEY_LOGIN_GUIDE_ENABLE, new boolean[]{false});
        Intent intent3 = getIntent();
        this.mPromptScene = intent3 != null ? intent3.getStringExtra(LoginOriginalActivityV2.KEY_PROMPT_SCENE) : null;
        this.mOutRoute = getIntent().getStringExtra(INTENT_KEY_OUT_ROUTE);
        this.mEnableSms = Boolean.valueOf(BundleUtil.getBoolean(getIntent().getExtras(), "smsEnable", new boolean[]{false}));
        this.mLoginExperiment = Boolean.valueOf(BundleUtil.getBoolean(getIntent().getExtras(), INTENT_KEY_LOGIN_EXPERIMENT, new boolean[]{false}));
        this.mLoginExperimentValue = BundleUtil.getString(getIntent().getExtras(), INTENT_KEY_LOGIN_EXPERIMENT_VALUE, new String[0]);
        if (extraBundle == null || (loginExpType = (LoginExpType) extraBundle.getParcelable(FullscreenLoginExp.KEY_LOGIN_EXP)) == null) {
            loginExpType = LoginExpType.CONTROL;
        }
        this.loginFullscreenExp = loginExpType;
        this.loginNewRoute = Boolean.parseBoolean(BundleUtil.getString(extraBundle, StartLoginPageKt.KEY_LOGIN_ROUTE_NEW, new String[]{"false"}));
        BLog.i("LoginQuickActivityV2", "Fullscreen login exp: " + this.loginFullscreenExp + ", new route: " + this.loginNewRoute);
        this.mReporter = getReporter();
        this.mLoginQuickPresenter = new QuickLoginPresenter(this, this.mReporter);
        setContentView(getLayoutRes());
        findViews();
        this.agreementLinkHelper = new AgreementLinkHelper((Context) this);
        TextView textView = this.mAgreementTv;
        Intrinsics.checkNotNull(textView);
        attachLinkContentAgreement(textView, this, true);
        updateRegInfo();
        QuickLoginPresenter quickLoginPresenter = this.mLoginQuickPresenter;
        Intrinsics.checkNotNull(quickLoginPresenter);
        quickLoginPresenter.registerPassportObs();
        QuickLoginPresenter quickLoginPresenter2 = this.mLoginQuickPresenter;
        Intrinsics.checkNotNull(quickLoginPresenter2);
        quickLoginPresenter2.setPromptScene(this.mPromptScene);
        QuickLoginPresenter quickLoginPresenter3 = this.mLoginQuickPresenter;
        Intrinsics.checkNotNull(quickLoginPresenter3);
        quickLoginPresenter3.setLoginProxy(new LoginRedirectProxy.DefaultLoginRedirectProxy() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$onCreate$2
            public boolean jumpVerifyPage(int status, Intent intent4) {
                Intrinsics.checkNotNullParameter(intent4, "intent");
                switch (status) {
                    case 0:
                    case 1:
                        LoginQuickActivityV2.this.startActivityForResult(intent4, 204);
                        return true;
                    case 2:
                        LoginQuickActivityV2.this.startActivity(intent4);
                        LoginQuickActivityV2.this.finish();
                        return true;
                    default:
                        return false;
                }
            }

            public boolean onLoginInterceptFinish(int status) {
                if (status == 2) {
                    return true;
                }
                return false;
            }
        });
        String $this$onCreate_u24lambda_u241 = this.mPromptScene;
        if ($this$onCreate_u24lambda_u241 != null) {
            Log.i("LoginQuickActivityV2", "prompt scene is " + $this$onCreate_u24lambda_u241);
        }
        adjustWindow();
        setTitle();
        adjustEnterPendingTransition();
        BiliAccounts.get(getActivity()).subscribe(this, new Topic[]{Topic.SIGN_IN, Topic.ACCOUNT_SWITCH});
        LoginAnswerDialogHelper.INSTANCE.newLoginCountDownLaunch();
        Intent intent4 = getIntent();
        long loginGuideSkipTime = BundleUtil.getLong(intent4 != null ? intent4.getExtras() : null, INTENT_KEY_LOGIN_GUIDE_SKIP_TIME, new long[]{0});
        if (loginGuideSkipTime > 0) {
            final Function0<Unit> function0 = this.finishRunnable;
            HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            }, loginGuideSkipTime);
        }
        getLifecycle().addObserver(LoginLifecycleObserver.INSTANCE);
        this.checkBoxClick = true;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.onLoginPageEnter(this, application, LoginUIType.QUICK_DIALOG);
        LoginAnswerDialogHelper.INSTANCE.setAnswerDialogLoginExperimentParam((Context) this, Intrinsics.areEqual(this.mLoginExperiment, true), this.mLoginExperimentValue);
        ILoginExperiment loginExperimentHelper = LoginExperimentHelperKt.getLoginExperimentHelper();
        if (loginExperimentHelper != null) {
            loginExperimentHelper.setLoginExperiment(Intrinsics.areEqual(this.mLoginExperiment, true));
        }
        increaseOnePassShowTimes();
    }

    public int getLayoutRes() {
        return R.layout.bili_app_dialog_quick_login;
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        LoginReportHelper.setTrackParams(this.mLoginQuickPresenter);
        OnePassLoginPathLinkManager onePassLoginPathLinkManager = OnePassLoginPathLinkManager.INSTANCE;
        String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
        if (fromSpmid == null) {
            fromSpmid = "";
        }
        onePassLoginPathLinkManager.onPhase(fromSpmid, new OnePassLoginPhaseType.DisplayLoginDialog(LoginReportHelper.INSTANCE.getLoginSessionId()));
    }

    private final void updateRegInfo() {
        TextView textView = this.mAgreementTv;
        Intrinsics.checkNotNull(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginQuickActivityV2.updateRegInfo$lambda$0(LoginQuickActivityV2.this, view);
            }
        });
        View view = this.mLoginRegPopView;
        Intrinsics.checkNotNull(view);
        view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginQuickActivityV2.updateRegInfo$lambda$1(LoginQuickActivityV2.this, view2);
            }
        });
        View view2 = this.mLoginRegCheckBoxContainer;
        Intrinsics.checkNotNull(view2);
        view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LoginQuickActivityV2.updateRegInfo$lambda$2(LoginQuickActivityV2.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegInfo$lambda$0(LoginQuickActivityV2 this$0, View it) {
        CheckBox $this$updateRegInfo_u24lambda_u240_u240 = this$0.mLoginRegCheckBox;
        if ($this$updateRegInfo_u24lambda_u240_u240 != null) {
            $this$updateRegInfo_u24lambda_u240_u240.setChecked(!$this$updateRegInfo_u24lambda_u240_u240.isChecked());
        }
        ILoginQuickReporter iLoginQuickReporter = this$0.mReporter;
        if (iLoginQuickReporter != null) {
            iLoginQuickReporter.reportRegCheckboxClick(this$0.mLoginRegCheckBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegInfo$lambda$1(LoginQuickActivityV2 this$0, View it) {
        CheckBox $this$updateRegInfo_u24lambda_u241_u240 = this$0.mLoginRegCheckBox;
        if ($this$updateRegInfo_u24lambda_u241_u240 != null && LoginRegHelper.checkViewVisibleAndUnCheck($this$updateRegInfo_u24lambda_u241_u240)) {
            $this$updateRegInfo_u24lambda_u241_u240.setChecked(true);
        }
        ILoginQuickReporter iLoginQuickReporter = this$0.mReporter;
        if (iLoginQuickReporter != null) {
            iLoginQuickReporter.reportRegCheckboxClick(this$0.mLoginRegCheckBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegInfo$lambda$2(LoginQuickActivityV2 this$0, View it) {
        CheckBox $this$updateRegInfo_u24lambda_u242_u240 = this$0.mLoginRegCheckBox;
        if ($this$updateRegInfo_u24lambda_u242_u240 != null) {
            $this$updateRegInfo_u24lambda_u242_u240.setChecked(!$this$updateRegInfo_u24lambda_u242_u240.isChecked());
        }
        ILoginQuickReporter iLoginQuickReporter = this$0.mReporter;
        if (iLoginQuickReporter != null) {
            iLoginQuickReporter.reportRegCheckboxClick(this$0.mLoginRegCheckBox);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.checkBoxClick && (!this.mAnyRegFlag || !LoginRegHelper.isAnyPageLoginReg())) {
            this.checkBoxClick = false;
            LoginRegHelper.updateRegCheckbox(this.mLoginRegCheckBox, this.mLoginRegCheckBoxContainer);
        }
        if (this.goOtherPage) {
            this.goOtherPage = false;
            LoginRegHelper.updateRegCheckbox(this.mLoginRegCheckBox, this.mLoginRegCheckBoxContainer);
            return;
        }
        this.mAnyRegFlag = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit finishRunnable$lambda$0(LoginQuickActivityV2 this$0) {
        this$0.finish();
        return Unit.INSTANCE;
    }

    protected ILoginQuickReporter getReporter() {
        return new CenterStyleLoginQuickReporter(this.mPromptScene, this.mLoginExperimentValue);
    }

    private final void attachLinkContentAgreement(TextView agreementText, AgreementLinkHelper.ClickLinkItemListener l, boolean init) {
        int color = ContextCompat.getColor((Context) this, com.bilibili.lib.theme.R.color.Lb6);
        AgreementLinkHelper agreementLinkHelper = this.agreementLinkHelper;
        if (agreementLinkHelper != null) {
            String carrierText = getCarrierText(init);
            ILoginOnePass.IspFlag ispFlag = LoginQuickManager.INSTANCE.ispFlag();
            agreementLinkHelper.attachLinkContentAgreement(agreementText, carrierText, color, ispFlag != null ? ispFlag.getIspName() : null, l);
        }
    }

    private final String getCarrierText(boolean init) {
        boolean isCheckBoxShow;
        if (init) {
            isCheckBoxShow = LoginRegHelper.INSTANCE.getLoginRegStrategy().showReg((Context) this);
        } else {
            CheckBox checkBox = this.mLoginRegCheckBox;
            isCheckBoxShow = checkBox != null && checkBox.getVisibility() == 0;
        }
        LoginIspHelper loginIspHelper = LoginIspHelper.INSTANCE;
        Context context = (Context) this;
        ILoginOnePass.IspFlag ispFlag = LoginQuickManager.INSTANCE.ispFlag();
        String agreementName = loginIspHelper.getIspCarrierText(context, ispFlag != null ? ispFlag.getIspName() : null);
        if (agreementName != null) {
            String str = agreementName.length() > 0 ? agreementName : null;
            if (str != null) {
                String it = str;
                String string = isCheckBoxShow ? getString(bili.resource.account.R.string.account_global_string_80, new Object[]{it}) : getString(bili.resource.account.R.string.account_global_string_90, new Object[]{it});
                if (string != null) {
                    return string;
                }
            }
        }
        return "";
    }

    protected int getViewStyle() {
        return 1;
    }

    protected void adjustEnterPendingTransition() {
        overridePendingTransition(R.anim.login_quick_dialog_alpha_in, R.anim.login_quick_dialog_alpha_out);
    }

    private final void findViews() {
        this.mTvPhoneNum = (TextView) findViewById(R.id.tv_phonenum);
        this.mBtnLoginQuick = (LoginQuickButton) findViewById(R.id.btn_login_quick);
        this.mBtnChangeWay = (TextView) findViewById(R.id.btn_change_account);
        this.mAgreementTv = (TextView) findViewById(R.id.tv_login_agreement);
        this.mSubTitle = (TextView) findViewById(R.id.tv_subcontent);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.mContainer = (ViewGroup) findViewById(R.id.container);
        this.mContainerLogin = findViewById(R.id.container_login);
        this.containerAnswer = findViewById(R.id.layout_answer);
        LoginQuickButton loginQuickButton = this.mBtnLoginQuick;
        if (loginQuickButton != null) {
            loginQuickButton.setOnClickListener(this);
        }
        TextView textView = this.mBtnChangeWay;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.mClose = findViewById(R.id.btn_close);
        View view = this.mClose;
        if (view != null) {
            view.setOnClickListener(this);
        }
        if (this.loginFullscreenExp.getShowOnepass()) {
            View view2 = this.mClose;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            View view3 = this.mClose;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        TextView textView2 = this.mTvPhoneNum;
        if (textView2 != null) {
            QuickLoginPresenter quickLoginPresenter = this.mLoginQuickPresenter;
            textView2.setText(quickLoginPresenter != null ? quickLoginPresenter.getPhoneNum() : null);
        }
        this.mLoginRegCheckBox = (CheckBox) findViewById(R.id.log_reg_checkbox);
        this.mLoginRegCheckBoxContainer = findViewById(R.id.log_reg_checkbox_container);
        LoginRegHelper.initOnChangeListener$default(this.mLoginRegCheckBox, null, 2, null);
        this.mLoginRegPopView = findViewById(R.id.login_reg_pop);
        BiliAppDialogLoginEulaBinding it = BiliAppDialogLoginEulaBinding.bind(findViewById(R.id.eula_group));
        Intrinsics.checkNotNull(it);
        this.eulaDelegate = new LoginEulaDialogViewDelegate(it);
        this.eulaGroup = it;
        TextView textView3 = this.mTitle;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    private final void clearViews() {
        this.mTvPhoneNum = null;
        this.mBtnLoginQuick = null;
        this.mBtnChangeWay = null;
        this.mAgreementTv = null;
        this.mSubTitle = null;
        this.mTitle = null;
        this.mContainer = null;
        this.mContainerLogin = null;
        this.mClose = null;
        this.mLoginRegCheckBox = null;
        this.mLoginRegCheckBoxContainer = null;
        this.mLoginRegPopView = null;
        this.containerAnswer = null;
        this.eulaGroup = null;
        this.eulaDelegate = null;
    }

    protected void adjustWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        int width = Companion.dp2Px(BR.headerTitle);
        window.setLayout(width, -2);
    }

    private final void setTitle() {
        TextView textView;
        if (TextUtils.isEmpty(this.mPromptScene)) {
            return;
        }
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        String promptStr = BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getString(LoginRuleProcessor.PREF_KEY_SCENE_PROMPT, "");
        if (TextUtils.isEmpty(promptStr)) {
            return;
        }
        JSONObject promptJSON = JSONObject.parseObject(promptStr);
        String title = promptJSON != null ? promptJSON.getString(this.mPromptScene) : null;
        if (!TextUtils.isEmpty(title) && (textView = this.mTitle) != null) {
            textView.setText(title);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        QuickLoginPresenter $this$onDestroy_u24lambda_u240 = this.mLoginQuickPresenter;
        if ($this$onDestroy_u24lambda_u240 != null) {
            $this$onDestroy_u24lambda_u240.cancelTasks();
            $this$onDestroy_u24lambda_u240.unRegisterPassportObs();
        }
        BiliAccounts.get(getActivity()).unsubscribeAllWithSwitch(this);
        LoginAnswerDialogHelper.INSTANCE.clearLoginCountDownLaunch();
        if (this.mIsLoginGuide) {
            MainDialogManager.showNextDialog("login_guide", false, (Context) this);
        }
        getLifecycle().removeObserver(LoginLifecycleObserver.INSTANCE);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.onLoginPageExit(this, application, LoginUIType.QUICK_DIALOG);
        clearViews();
    }

    @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
    public void onItemLinkClick(int itemId) {
        this.mAnyRegFlag = true;
        ILoginQuickReporter iLoginQuickReporter = this.mReporter;
        if (iLoginQuickReporter != null) {
            QuickLoginPresenter quickLoginPresenter = this.mLoginQuickPresenter;
            iLoginQuickReporter.reportLinkClick(itemId, (quickLoginPresenter == null || (r1 = ispReportFlag(quickLoginPresenter)) == null) ? "" : "");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        ILoginQuickReporter iLoginQuickReporter;
        ILoginQuickReporter iLoginQuickReporter2;
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == R.id.btn_change_account) {
            ILoginQuickReporter iLoginQuickReporter3 = this.mReporter;
            if (iLoginQuickReporter3 != null) {
                QuickLoginPresenter quickLoginPresenter = this.mLoginQuickPresenter;
                iLoginQuickReporter3.reportChangeLoginWayClick(quickLoginPresenter != null ? ispReportFlag(quickLoginPresenter) : null);
            }
            changeLoginWay(this.mEnableSms);
            if (this.mIsLoginGuide && (iLoginQuickReporter2 = this.mReporter) != null) {
                iLoginQuickReporter2.reportLoginGuideChangeLoginWay();
            }
            this.goOtherPage = true;
        } else if (id == R.id.btn_login_quick) {
            ILoginQuickReporter iLoginQuickReporter4 = this.mReporter;
            if (iLoginQuickReporter4 != null) {
                QuickLoginPresenter quickLoginPresenter2 = this.mLoginQuickPresenter;
                iLoginQuickReporter4.reportLoginClick(quickLoginPresenter2 != null ? ispReportFlag(quickLoginPresenter2) : null, LoginRegHelper.getProvisionReportValue((Context) this), LoginRegHelper.getAgreeReportValue(this.mLoginRegCheckBox));
            }
            if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new LoginQuickActivityV2$onClick$1(this, null), 3, (Object) null);
            } else {
                doLogin();
            }
        } else if (id == R.id.btn_close) {
            finish();
            ILoginQuickReporter iLoginQuickReporter5 = this.mReporter;
            if (iLoginQuickReporter5 != null) {
                QuickLoginPresenter quickLoginPresenter3 = this.mLoginQuickPresenter;
                iLoginQuickReporter5.reportCloseClick(quickLoginPresenter3 != null ? ispReportFlag(quickLoginPresenter3) : null);
            }
            if (!this.mIsLoginGuide || (iLoginQuickReporter = this.mReporter) == null) {
                return;
            }
            iLoginQuickReporter.reportLoginGuideClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doLogin() {
        ILoginQuickReporter iLoginQuickReporter;
        QuickLoginPresenter quickLoginPresenter = this.mLoginQuickPresenter;
        if (quickLoginPresenter != null) {
            quickLoginPresenter.login(QuickLoginTag.MAIN);
        }
        final Function0<Unit> function0 = this.finishRunnable;
        HandlerThreads.remove(0, new Runnable() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
        if (!this.mIsLoginGuide || (iLoginQuickReporter = this.mReporter) == null) {
            return;
        }
        iLoginQuickReporter.reportLoginGuideClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEulaDialogVisibility(boolean show) {
        ConstraintLayout root;
        View view = this.mContainerLogin;
        if (view != null) {
            view.setVisibility(toVisibility(!show));
        }
        BiliAppDialogLoginEulaBinding biliAppDialogLoginEulaBinding = this.eulaGroup;
        if (biliAppDialogLoginEulaBinding == null || (root = biliAppDialogLoginEulaBinding.getRoot()) == null) {
            return;
        }
        root.setVisibility(toVisibility(show));
    }

    private final int toVisibility(boolean $this$toVisibility) {
        if ($this$toVisibility) {
            return 0;
        }
        return 8;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 204) {
            if (resultCode == -1) {
                setResult(-1);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finish(boolean skipCheck) {
        if (!this.loginFullscreenExp.getShowOnepass() || BiliAccounts.get((Context) this).isLogin() || skipCheck) {
            super.finish();
            overridePendingTransition(R.anim.login_quick_dialog_alpha_in, R.anim.login_quick_dialog_alpha_out);
        }
    }

    public void finish() {
        finish(false);
    }

    public void alertVipStatusIfNeed() {
        AccountInfo myInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        if (myInfo != null && myInfo.getVipInfo() != null && myInfo.getVipInfo().isFrozen()) {
            BLog.i("LoginQuickActivityV2", "account is forzen");
            showTip(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1303);
        }
    }

    public void showTip(int resId) {
        ToastHelper.showToastShort((Context) this, resId);
    }

    public void showTip(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            ToastHelper.showToastShort((Context) this, message);
        }
    }

    public void showProgress() {
        this.mIsProcessing = true;
        LoginQuickButton loginQuickButton = this.mBtnLoginQuick;
        if (loginQuickButton != null) {
            loginQuickButton.setClickable(false);
        }
        LoginQuickButton loginQuickButton2 = this.mBtnLoginQuick;
        if (loginQuickButton2 != null) {
            loginQuickButton2.showProgress();
        }
        TextView textView = this.mBtnChangeWay;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(com.bilibili.lib.theme.R.color.Ga5));
        }
        TextView textView2 = this.mBtnChangeWay;
        if (textView2 != null) {
            textView2.setClickable(false);
        }
        TextView textView3 = this.mAgreementTv;
        if (textView3 != null) {
            textView3.setText(getCarrierText(false));
        }
    }

    public void hideProgress() {
        this.mIsProcessing = false;
        LoginQuickButton loginQuickButton = this.mBtnLoginQuick;
        if (loginQuickButton != null) {
            loginQuickButton.setClickable(true);
        }
        LoginQuickButton loginQuickButton2 = this.mBtnLoginQuick;
        if (loginQuickButton2 != null) {
            loginQuickButton2.hideProgress();
        }
        TextView textView = this.mBtnChangeWay;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(com.bilibili.lib.theme.R.color.Ga8));
        }
        TextView textView2 = this.mBtnChangeWay;
        if (textView2 != null) {
            textView2.setClickable(true);
        }
        TextView it = this.mAgreementTv;
        if (it != null) {
            attachLinkContentAgreement(it, this, false);
        }
    }

    public boolean isProgressing() {
        return this.mIsProcessing;
    }

    public Activity getActivity() {
        return (Activity) this;
    }

    public void onLoginIntercept(VerifyBundle verifyBundle) {
    }

    public void onLoginSuccess() {
        handleNextAnswerDialog();
        Application it = BiliContext.application();
        if (it != null) {
            LoginSuccessProcessorKt.processLoginSuccess(it, LoginUIType.QUICK_DIALOG);
        }
        if (isFinishing() || isDestroyCalled()) {
            return;
        }
        RouteRequest $this$onLoginSuccess_u24lambda_u241 = RouteUtilKt.getForwardRequest(getIntent());
        if ($this$onLoginSuccess_u24lambda_u241 != null) {
            BLRouter.routeTo($this$onLoginSuccess_u24lambda_u241, (Context) this);
        }
        finish();
    }

    public void onQuickLoginFail(int errorType, String errorMsg, Exception exception) {
        ILoginExperiment loginExperimentHelper = LoginExperimentHelperKt.getLoginExperimentHelper();
        if (loginExperimentHelper != null) {
            loginExperimentHelper.setLoginExperiment(false);
        }
        if ((exception instanceof AccountException) && ((AccountException) exception).code() == 86015) {
            changeLoginWay(false);
        } else {
            changeLoginWay(this.mEnableSms);
        }
        finish();
    }

    private final void handleNextAnswerDialog() {
        if (!LoginSceneProcessor.INSTANCE.answerGuideEnable()) {
            LoginAnswerDialogHelper.setNeedShowAnswerDialog$default(LoginAnswerDialogHelper.INSTANCE, (Context) this, false, null, null, 12, null);
        } else {
            LoginAnswerDialogHelper.INSTANCE.setNeedShowAnswerDialog((Context) this, true, AnswerDialogTransferActivity.FROM_QUICK, getLoginSpmid());
        }
        LoginAnswerDialogHelper.INSTANCE.clearLoginCountDownLaunch();
    }

    public String getLoginSpmid() {
        return LoginReporterV2.PV.APP_ONEPASS_LOGIN;
    }

    public String getPvEventId() {
        return LoginReporterV2.PV.APP_ONEPASS_LOGIN_PV;
    }

    public Bundle getPvExtra() {
        Bundle bundle = LoginReportHelper.buildCommonBundle();
        QuickLoginPresenter quickLoginPresenter = this.mLoginQuickPresenter;
        bundle.putString(LoginReporterV2.APP_ONEPASS_KEY_OPERATOR, quickLoginPresenter != null ? ispReportFlag(quickLoginPresenter) : null);
        bundle.putString("refer_click", this.mPromptScene);
        bundle.putString(LoginReporterV2.SHOW_PROVISION_KEY, LoginRegHelper.getProvisionReportValue((Context) this));
        String it = this.mLoginExperimentValue;
        if (it != null) {
            bundle.putString("scene", it);
        }
        return bundle;
    }

    public void changeToAnswerMode(final int resId) {
        View view = this.mContainerLogin;
        if (view == null) {
            return;
        }
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.73f);
        anim.setDuration(200L);
        hideLoginContent();
        anim.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$changeToAnswerMode$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                View mContainerLogin = LoginQuickActivityV2.this.getMContainerLogin();
                if (mContainerLogin != null) {
                    mContainerLogin.setVisibility(4);
                }
                View it = LoginQuickActivityV2.this.getContainerAnswer();
                if (it != null) {
                    LoginQuickActivityV2 loginQuickActivityV2 = LoginQuickActivityV2.this;
                    int i = resId;
                    ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams l = (FrameLayout.LayoutParams) layoutParams;
                    l.topMargin = LoginQuickActivityV2.Companion.dp2Px(36);
                    l.bottomMargin = LoginQuickActivityV2.Companion.dp2Px(36);
                    it.setLayoutParams(l);
                    it.setVisibility(0);
                    loginQuickActivityV2.alphaAnimAttachClick(it, i);
                }
            }
        });
        anim.start();
    }

    public void changeToAnswerMode(String message) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hideLoginContent() {
        TextView textView = this.mTvPhoneNum;
        if (textView != null) {
            textView.setVisibility(4);
        }
        LoginQuickButton loginQuickButton = this.mBtnLoginQuick;
        if (loginQuickButton != null) {
            loginQuickButton.setVisibility(4);
        }
        TextView textView2 = this.mBtnChangeWay;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        TextView textView3 = this.mTitle;
        if (textView3 != null) {
            textView3.setVisibility(4);
        }
        TextView textView4 = this.mAgreementTv;
        if (textView4 != null) {
            textView4.setVisibility(4);
        }
        View view = this.mClose;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void alphaAnimAttachClick(View containerAnswer, int resId) {
        if (containerAnswer != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginQuickActivityV2.alphaAnimAttachClick$lambda$0(LoginQuickActivityV2.this, view);
                }
            };
            LoginQuickButton btnLogin = (LoginQuickButton) containerAnswer.findViewById(R.id.btn_answer);
            btnLogin.setText(bili.resource.account.R.string.account_global_string_39);
            btnLogin.setOnClickListener(onClickListener);
            View btnClose = containerAnswer.findViewById(R.id.btn_close);
            View btnSkip = containerAnswer.findViewById(R.id.tv_answer_giveup);
            View btnAnswer = containerAnswer.findViewById(R.id.btn_answer);
            TextView tvTitle = (TextView) containerAnswer.findViewById(R.id.tv_title);
            tvTitle.setText(getString(resId));
            View tvSubContent = containerAnswer.findViewById(R.id.tv_subcontent);
            btnClose.setOnClickListener(onClickListener);
            btnSkip.setOnClickListener(onClickListener);
            ObjectAnimator anim01 = ObjectAnimator.ofFloat(tvTitle, "alpha", 0.0f, 1.0f);
            ObjectAnimator anim02 = ObjectAnimator.ofFloat(btnAnswer, "alpha", 0.0f, 1.0f);
            ObjectAnimator anim03 = ObjectAnimator.ofFloat(btnSkip, "alpha", 0.0f, 1.0f);
            ObjectAnimator anim04 = ObjectAnimator.ofFloat(btnClose, "alpha", 0.0f, 1.0f);
            ObjectAnimator anim05 = ObjectAnimator.ofFloat(tvSubContent, "alpha", 0.0f, 1.0f);
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(anim01).with(anim02).with(anim03).with(anim04).with(anim05);
            animSet.setDuration(300L);
            animSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void alphaAnimAttachClick$lambda$0(LoginQuickActivityV2 this$0, View it) {
        int id = it.getId();
        if (id != R.id.btn_close) {
            if (id != R.id.btn_answer) {
                if (id == R.id.tv_answer_giveup) {
                    this$0.finish();
                    return;
                }
                return;
            }
            this$0.answer();
            return;
        }
        this$0.finish();
    }

    public final void answer() {
        setResult(-1);
        finish();
        Uri parse = Uri.parse("activity://main/web/ap");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        BLRouter.routeTo(new RouteRequest.Builder(parse).data(Uri.parse("https://www.bilibili.com/h5/newbie/entry?navhide=1")).build(), (Context) this);
    }

    public boolean shouldGoToAnswer() {
        return false;
    }

    private final void changeLoginWay(Boolean loginSmsEnable) {
        if (changeWayIntercept()) {
            return;
        }
        if (this.loginNewRoute) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new LoginQuickActivityV2$changeLoginWay$1(this, null), 3, (Object) null);
        } else {
            routeOtherLoginWay(Intrinsics.areEqual(loginSmsEnable, true));
        }
    }

    private final void routeOtherLoginWay(boolean loginSmsEnable) {
        Context context = (Context) this;
        Boolean valueOf = Boolean.valueOf(loginSmsEnable);
        Boolean valueOf2 = Boolean.valueOf(this.mSmsDirect);
        Bundle extras = getIntent().getExtras();
        RouteUtilKt.routeToLoginOriginActivityV2$default(context, valueOf, valueOf2, 33554432, extras != null ? extras.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE) : null, this.mPromptScene, getRouteUri(), this.mLoginExperiment, false, BR.hallEnterHotText, null);
    }

    private final boolean changeWayIntercept() {
        if (!TextUtils.isEmpty(this.mOutRoute)) {
            try {
                String str = this.mOutRoute;
                Intrinsics.checkNotNull(str);
                RouteRequest request = RouteRequestKt.toRouteRequest(str).newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.quick.ui.LoginQuickActivityV2$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit changeWayIntercept$lambda$0;
                        changeWayIntercept$lambda$0 = LoginQuickActivityV2.changeWayIntercept$lambda$0(LoginQuickActivityV2.this, (MutableBundleLike) obj);
                        return changeWayIntercept$lambda$0;
                    }
                }).flags(33554432).build();
                BLRouter.routeTo(request, (Context) this);
                finish();
                return true;
            } catch (ClassNotFoundException e) {
                BLog.i("Exception " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit changeWayIntercept$lambda$0(LoginQuickActivityV2 this$0, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("smsEnable", String.valueOf(this$0.mEnableSms));
        $this$extras.put("quickEnable", "true");
        String str = this$0.mPromptScene;
        if (str == null) {
            str = "";
        }
        $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, str);
        String routeUri = this$0.getRouteUri();
        $this$extras.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, routeUri != null ? routeUri : "");
        return Unit.INSTANCE;
    }

    public void onChange(Topic topic) {
        if ((topic == Topic.SIGN_IN || topic == Topic.ACCOUNT_SWITCH) && !Intrinsics.areEqual(BiliContext.topActivity(), this)) {
            finish();
            overridePendingTransition(0, 0);
        }
    }

    /* compiled from: LoginQuickActivityV2.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/quick/ui/LoginQuickActivityV2$Companion;", "", "<init>", "()V", "REQ_CODE_SECOND_VERIFY", "", "URL_ANSWER", "", "INTENT_KEY_OUT_ROUTE", "INTENT_KEY_SMS_ENABLE", "INTENT_KEY_SMS_DIRECT", "INTENT_KEY_QUICK_ENABLE", "INTENT_KEY_LOGIN_GUIDE_ENABLE", "INTENT_KEY_LOGIN_GUIDE_SKIP_TIME", "INTENT_KEY_LOGIN_EXPERIMENT", "INTENT_KEY_LOGIN_EXPERIMENT_VALUE", "dp2Px", "dp", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int dp2Px(int dp) {
            return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String ispReportFlag(QuickLoginPresenter $this$ispReportFlag) {
        Intrinsics.checkNotNullParameter($this$ispReportFlag, "<this>");
        ILoginOnePass.IspFlag ispFlag = LoginQuickManager.INSTANCE.ispFlag();
        if (ispFlag != null) {
            return ispFlag.ispReportFlag();
        }
        return null;
    }

    private final void increaseOnePassShowTimes() {
        ILoginLimitUpdate iLoginLimitUpdate;
        String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
        if (Intrinsics.areEqual(fromSpmid, "enter_homepage")) {
            ILoginLimitUpdate iLoginLimitUpdate2 = (ILoginLimitUpdate) BLRouter.INSTANCE.get(ILoginLimitUpdate.class, "homepage");
            if (iLoginLimitUpdate2 != null) {
                iLoginLimitUpdate2.updateOnePass((Context) this);
            }
        } else if (!Intrinsics.areEqual(fromSpmid, LoginReporterV2.Error.SP_MID_ENTER_MY_INFO) || (iLoginLimitUpdate = (ILoginLimitUpdate) BLRouter.INSTANCE.get(ILoginLimitUpdate.class, "home_user_center")) == null) {
        } else {
            iLoginLimitUpdate.updateOnePass((Context) this);
        }
    }
}