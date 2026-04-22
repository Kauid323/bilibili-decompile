package tv.danmaku.bili.sms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.accountui.R;
import com.bilibili.app.accountui.databinding.BiliAppDialogLoginEulaBinding;
import com.bilibili.app.comm.list.widget.dialog.LoadingDialog;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.accountsui.AutoCompleteHelper;
import com.bilibili.lib.accountsui.CountryCode;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import com.bilibili.lib.accountsui.facebook.FacebookLoginManager;
import com.bilibili.lib.accountsui.google.GoogleLoginManager;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.sms.ISmsLoginPresenter;
import com.bilibili.lib.accountsui.sms.ISmsLoginReporter;
import com.bilibili.lib.accountsui.sms.ISmsLoginView;
import com.bilibili.lib.accountsui.sms.SmsLoginPresenter;
import com.bilibili.lib.accountsui.utils.ILoginLimitUpdate;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.module.main.innerpush.IShowPushWhenPageDestroy;
import com.bilibili.pvtracker.IPvTracker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.fullscreen.service.SmsLoginService;
import tv.danmaku.bili.helper.LoginLifecycleObserver;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.quick.ui.LoginQuickButton;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.sms.SmsLoginController;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.answer.AnswerDialogTransferActivity;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.LoginAnswerDialogHelper;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;
import tv.danmaku.bili.ui.util.AccountUtils;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.utils.TimeCounter;

/* compiled from: SmsLoginDialogActivityV2.kt */
@Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u0000 Ð\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002Ð\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\u0012\u0010[\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\b\u0010\\\u001a\u00020XH\u0002J\b\u0010]\u001a\u00020XH\u0002J\b\u0010^\u001a\u00020XH\u0002J\b\u0010_\u001a\u00020XH\u0002J\b\u0010`\u001a\u00020XH\u0002J\u0010\u0010a\u001a\u00020X2\u0006\u0010b\u001a\u000208H\u0002J\b\u0010c\u001a\u00020XH\u0002J\u000e\u0010d\u001a\u00020XH\u0082@¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u000208H\u0082@¢\u0006\u0002\u0010eJ\u0010\u0010g\u001a\u0004\u0018\u00010hH\u0082@¢\u0006\u0002\u0010eJ\b\u0010i\u001a\u00020XH\u0002J\u0010\u0010j\u001a\u00020X2\u0006\u0010k\u001a\u000208H\u0002J\u0010\u0010l\u001a\u00020<2\u0006\u0010k\u001a\u000208H\u0002J\b\u0010m\u001a\u00020XH\u0002J\u0010\u0010n\u001a\u00020X2\u0006\u0010o\u001a\u00020\u0012H\u0002J\u0016\u0010p\u001a\u00020X2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020X0rH\u0002J\b\u0010s\u001a\u00020XH\u0002J\u0010\u0010t\u001a\u00020X2\u0006\u0010u\u001a\u000208H\u0002J\f\u0010v\u001a\u00020w*\u000208H\u0002J\u0010\u0010x\u001a\u00020X2\u0006\u0010o\u001a\u00020\u0012H\u0002J\u0010\u0010y\u001a\u00020X2\u0006\u0010b\u001a\u000208H\u0002J\b\u0010z\u001a\u00020XH\u0002J\u0010\u0010{\u001a\u00020X2\u0006\u0010|\u001a\u000208H\u0002J\b\u0010{\u001a\u00020XH\u0016J\b\u0010}\u001a\u00020XH\u0002J\b\u0010~\u001a\u00020XH\u0002J&\u0010\u007f\u001a\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020w2\u0007\u0010\u0081\u0001\u001a\u00020w2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0014J\t\u0010\u0084\u0001\u001a\u00020XH\u0014J#\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00012\t\b\u0001\u0010\u0088\u0001\u001a\u00020wH\u0002J\u001e\u0010\u0089\u0001\u001a\u00020X2\u0007\u0010\u008a\u0001\u001a\u00020w2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020X2\u0007\u0010\u008e\u0001\u001a\u00020wH\u0016J\u0014\u0010\u008d\u0001\u001a\u00020X2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010<H\u0016J\t\u0010\u0090\u0001\u001a\u00020XH\u0016J\t\u0010\u0091\u0001\u001a\u00020XH\u0016J%\u0010\u0092\u0001\u001a\u00020X2\u001a\u0010\u0093\u0001\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010\u0094\u0001H\u0016J.\u0010\u0095\u0001\u001a\u00020X2\u0007\u0010\u0096\u0001\u001a\u00020w2\u001a\u0010\u0097\u0001\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010\u0094\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020XH\u0016J\u0014\u0010\u0099\u0001\u001a\u00020X2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010<H\u0016J\t\u0010\u009b\u0001\u001a\u00020XH\u0016J\t\u0010\u009c\u0001\u001a\u00020XH\u0016J\u0014\u0010\u009d\u0001\u001a\u00020X2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010\u009d\u0001\u001a\u00020X2\u0007\u0010\u008e\u0001\u001a\u00020wH\u0016J\t\u0010\u009f\u0001\u001a\u00020XH\u0016J\u0012\u0010 \u0001\u001a\u00020X2\u0007\u0010¡\u0001\u001a\u000208H\u0016J\t\u0010¢\u0001\u001a\u00020XH\u0016J\t\u0010£\u0001\u001a\u00020XH\u0016J\u0012\u0010¤\u0001\u001a\u00020X2\u0007\u0010¥\u0001\u001a\u00020wH\u0016J\t\u0010¦\u0001\u001a\u00020XH\u0016J\t\u0010§\u0001\u001a\u00020XH\u0016J\t\u0010¨\u0001\u001a\u00020XH\u0016J\n\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\u0011\u0010{\u001a\u00020X2\u0007\u0010«\u0001\u001a\u00020wH\u0016J\t\u0010¬\u0001\u001a\u00020XH\u0016J\t\u0010\u00ad\u0001\u001a\u00020XH\u0002J\u0015\u0010®\u0001\u001a\u00020X2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0016J\u0013\u0010±\u0001\u001a\u00020X2\b\u0010«\u0001\u001a\u00030ª\u0001H\u0016J\u0015\u0010²\u0001\u001a\u00020X2\n\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0002J#\u0010³\u0001\u001a\u00020X2\u0018\u0010\u0097\u0001\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\u0006\u0012\u0004\u0018\u00010<0\u0094\u0001H\u0016J,\u0010´\u0001\u001a\u00020X2\u0007\u0010\u0096\u0001\u001a\u00020w2\u0018\u0010\u0097\u0001\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\u0006\u0012\u0004\u0018\u00010<0\u0094\u0001H\u0016J\t\u0010µ\u0001\u001a\u00020XH\u0016J\u0015\u0010¶\u0001\u001a\u00020X2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0016J\t\u0010¹\u0001\u001a\u00020<H\u0016J\t\u0010º\u0001\u001a\u00020ZH\u0016J\t\u0010»\u0001\u001a\u00020XH\u0014J\t\u0010¼\u0001\u001a\u000208H\u0016J'\u0010½\u0001\u001a \u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0¾\u0001j\u000f\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<`¿\u0001H\u0002J\u0014\u0010À\u0001\u001a\u0002082\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010Â\u0001\u001a\u00020X2\b\u0010o\u001a\u0004\u0018\u00010\u0014H\u0016J\u001d\u0010Ã\u0001\u001a\u00020X2\b\u0010o\u001a\u0004\u0018\u00010\u00142\b\u0010Ä\u0001\u001a\u00030Å\u0001H\u0016J\u0014\u0010Æ\u0001\u001a\u0002082\t\u0010Ç\u0001\u001a\u0004\u0018\u00010<H\u0002J\u001d\u0010È\u0001\u001a\u00020X2\u0007\u0010«\u0001\u001a\u00020w2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010<H\u0016J\t\u0010É\u0001\u001a\u00020XH\u0016J\u0012\u0010¬\u0001\u001a\u00020X2\u0007\u0010Ê\u0001\u001a\u000208H\u0016J\u0012\u0010Ë\u0001\u001a\u00020X2\u0007\u0010Ì\u0001\u001a\u000208H\u0002J#\u0010Í\u0001\u001a\u00020X2\u0007\u0010«\u0001\u001a\u00020<2\t\u0010Î\u0001\u001a\u0004\u0018\u00010wH\u0016¢\u0006\u0003\u0010Ï\u0001R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010G\u001a\u0004\u0018\u00010<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u0010J\u001a\u0004\u0018\u00010<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010IR\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ñ\u0001"}, d2 = {"Ltv/danmaku/bili/sms/SmsLoginDialogActivityV2;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Lcom/bilibili/lib/accountsui/sms/ISmsLoginView;", "Lcom/bilibili/lib/accountsui/captcha/JsBridgeCallHandlerSecure$CaptchaCallback;", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "Lcom/bilibili/pvtracker/IPvTracker;", "Ltv/danmaku/bili/sms/Satisfied;", "Ltv/danmaku/bili/utils/TimeCounter$TimeCounterCallback;", "Lcom/bilibili/lib/accountsui/sms/ISmsLoginReporter;", "Lcom/bilibili/module/main/innerpush/IShowPushWhenPageDestroy;", "<init>", "()V", "mLoginButton", "Ltv/danmaku/bili/quick/ui/LoginQuickButton;", "mPhoneEditText", "Landroid/widget/EditText;", "mCodeEditText", "mCountryCodeContainer", "Landroid/view/View;", "mCountryCodeTextView", "Landroid/widget/TextView;", "mGetCodeBtn", "mCountryCodeArrow", "Landroid/widget/ImageView;", "mPhoneNumberContainer", "mGetCodeContainer", "Landroid/view/ViewGroup;", "mAgreementLinkText", "mClearPhoneNum", "mClearCode", "mPwdLogin", "mGoogleLogin", "mFaceBookLogin", "mPasswordOversea", "mOverseaContainer", "mClose", "mRootContainer", "mTitle", "eulaGroup", "Lcom/bilibili/app/accountui/databinding/BiliAppDialogLoginEulaBinding;", "eulaDelegate", "Ltv/danmaku/bili/normal/ui/LoginEulaDialogViewDelegate;", "mPresenter", "Lcom/bilibili/lib/accountsui/sms/ISmsLoginPresenter;", "mGoogleLoginManager", "Lcom/bilibili/lib/accountsui/google/GoogleLoginManager;", "mFacebookLoginManager", "Lcom/bilibili/lib/accountsui/facebook/FacebookLoginManager;", "mSmsLoginController", "Ltv/danmaku/bili/sms/SmsLoginController;", "mDialogContainer", "mLoginRegPopView", "mLoginRegCheckBox", "Landroid/widget/CheckBox;", "mLoginRegCheckBoxContainer", "mAnyRegFlag", "", "checkBoxClick", "goOtherPage", "mFrom", "", "mSmpId", "mPromptScene", "mEnableCommit", "mSmsCacheLoginInfo", "Lcom/bilibili/lib/accountsui/AutoCompleteHelper$SmsLoginInfo;", "fullscreenLoginExp", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "loginNewRoute", "isActivityDie", "()Z", "pagePv", "getPagePv", "()Ljava/lang/String;", "routeUri", "getRouteUri", "clickEulaLinkListener", "Ltv/danmaku/bili/ui/AgreementLinkHelper$ClickLinkItemListener;", "clickEulaLinkListener2", "clickEulaLinkListener3", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uiScope", "loadingDialog", "Lcom/bilibili/app/comm/list/widget/dialog/LoadingDialog;", "loginType", "mIsOversea", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "initSmsLoginController", "initPresenter", "initActivity", "findViews", "clearViews", "enableNextOperation", "enable", "initViews", "handleOversea", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOversea", "getInfoLogin", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "updateRegInfo", "updateAgreement", "init", "getAgreementLinkString", "loadCache", "onLoginClick", "view", "checkLoginReg", "login", "Lkotlin/Function0;", "doLogin", "setEulaDialogVisibility", ReportEvent.EVENT_TYPE_SHOW, "toVisibility", "", "getCode", "setInputEnable", "increaseSmsShowTimes", "finish", "skipCheck", "googleLogin", "facebookLogin", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "tintDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", GarbJsBridgeCallHandlerKt.PURE_THEME, "onItemLinkClick", "itemId", "eulaTriggerType", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "showTip", "resId", "message", "showCountryChoiceDialog", "hideCountryChoiceDialog", "sendSmsWithGeeCaptcha", "innerMap", "", "sendSmsWithImageCaptcha", "callbackId", "param", "tryNotifyImageCaptchaSuccess", "showCaptchaDialog", "url", "hideCaptchaDialog", "focusToCaptchaEdit", "showProgress", AuthResultCbHelper.ARGS_MSG, "hideProgress", "onCountryCodeUpdate", "success", "warningPhoneNum", "warningCaptcha", "onLoginAfterRegisterSuccess", "inRegAudit", "startTimer", "stopTimer", "alertVipStatusIfNeed", "getDefaultCountryCode", "Lcom/bilibili/lib/accountsui/CountryCode;", LoginReporterV2.Show.SIGNUP_KEY_CODE, "onLoginSuccess", "handleNextAnswerDialog", "onLoginIntercept", "verifyBundle", "Lcom/bilibili/lib/accounts/VerifyBundle;", "onReceiveSelectCountry", "refreshViewByCountryCode", "replyWithGeeCaptcha", "replyWithImageCaptcha", "closeCaptchaDialog", "onChange", "topic", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "getPvEventId", "getPvExtra", "onResume", "shouldReport", "getTrackCommonValue", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isSatisfied", "input", "onCountDownFinish", "onCountDown", "second", "", "isPhoneLegal", "phone", "callbackCaptchaDialog", "onRegisterSuccess", "isNew", "showLoading", "isShow", "onGetLoginStatus", "status", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginDialogActivityV2 extends BaseAppCompatActivity implements ISmsLoginView, JsBridgeCallHandlerSecure.CaptchaCallback, PassportObserver, IPvTracker, Satisfied, TimeCounter.TimeCounterCallback, ISmsLoginReporter, IShowPushWhenPageDestroy {
    private static final String TAG = "SmsLoginDialogActivityV";
    private LoginEulaDialogViewDelegate eulaDelegate;
    private BiliAppDialogLoginEulaBinding eulaGroup;
    private boolean goOtherPage;
    private LoadingDialog loadingDialog;
    private boolean loginNewRoute;
    private TextView mAgreementLinkText;
    private boolean mAnyRegFlag;
    private View mClearCode;
    private View mClearPhoneNum;
    private View mClose;
    private EditText mCodeEditText;
    private ImageView mCountryCodeArrow;
    private View mCountryCodeContainer;
    private TextView mCountryCodeTextView;
    private ViewGroup mDialogContainer;
    private View mFaceBookLogin;
    private FacebookLoginManager mFacebookLoginManager;
    private String mFrom;
    private TextView mGetCodeBtn;
    private ViewGroup mGetCodeContainer;
    private View mGoogleLogin;
    private GoogleLoginManager mGoogleLoginManager;
    private boolean mIsOversea;
    private LoginQuickButton mLoginButton;
    private CheckBox mLoginRegCheckBox;
    private View mLoginRegCheckBoxContainer;
    private View mLoginRegPopView;
    private View mOverseaContainer;
    private View mPasswordOversea;
    private EditText mPhoneEditText;
    private View mPhoneNumberContainer;
    private ISmsLoginPresenter mPresenter;
    private String mPromptScene;
    private TextView mPwdLogin;
    private View mRootContainer;
    private String mSmpId;
    private AutoCompleteHelper.SmsLoginInfo mSmsCacheLoginInfo;
    private SmsLoginController mSmsLoginController;
    private View mTitle;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private boolean checkBoxClick = true;
    private boolean mEnableCommit = true;
    private LoginExpType fullscreenLoginExp = LoginExpType.CONTROL;
    private final AgreementLinkHelper.ClickLinkItemListener clickEulaLinkListener = new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda8
        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
        public final void onItemLinkClick(int i) {
            SmsLoginDialogActivityV2.this.onItemLinkClick(i, null);
        }
    };
    private final AgreementLinkHelper.ClickLinkItemListener clickEulaLinkListener2 = new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda9
        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
        public final void onItemLinkClick(int i) {
            SmsLoginDialogActivityV2.clickEulaLinkListener2$lambda$0(SmsLoginDialogActivityV2.this, i);
        }
    };
    private final AgreementLinkHelper.ClickLinkItemListener clickEulaLinkListener3 = new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda10
        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
        public final void onItemLinkClick(int i) {
            SmsLoginDialogActivityV2.clickEulaLinkListener3$lambda$0(SmsLoginDialogActivityV2.this, i);
        }
    };
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private final CoroutineScope uiScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private String loginType = "sms";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    /* compiled from: SmsLoginDialogActivityV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/sms/SmsLoginDialogActivityV2$Companion;", "", "<init>", "()V", "TAG", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean isActivityDie() {
        return isFinishing();
    }

    public String getPagePv() {
        return this.mPromptScene;
    }

    public String getRouteUri() {
        return AccountUtils.Companion.getRouterFrom((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickEulaLinkListener2$lambda$0(SmsLoginDialogActivityV2 this$0, int itemId) {
        this$0.onItemLinkClick(itemId, EulaTriggerType.GetSms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickEulaLinkListener3$lambda$0(SmsLoginDialogActivityV2 this$0, int itemId) {
        this$0.onItemLinkClick(itemId, EulaTriggerType.Submit);
    }

    protected void onCreate(Bundle savedInstanceState) {
        String str;
        LoginExpType loginExpType;
        Bundle extras;
        Bundle bundle;
        Bundle extras2;
        Bundle bundle2;
        Bundle extras3;
        Bundle extras4;
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.bili_app_dialog_sms_login);
        Intent intent = getIntent();
        String str2 = null;
        this.mFrom = (intent == null || (extras4 = intent.getExtras()) == null) ? null : extras4.getString("from");
        String str3 = this.mFrom;
        if (Intrinsics.areEqual(str3, "home")) {
            str = LoginReporterV2.Show.SMS_LOGIN_DIALOG_FROM_HOME;
        } else {
            str = Intrinsics.areEqual(str3, SmsLoginDialogUtilKt.FROM_USER_CENTER) ? LoginReporterV2.Show.SMS_LOGIN_DIALOG_FROM_USER_CENTER : null;
        }
        this.mSmpId = str;
        Intent intent2 = getIntent();
        this.mPromptScene = (intent2 == null || (extras3 = intent2.getExtras()) == null) ? null : extras3.getString(LoginOriginalActivityV2.KEY_PROMPT_SCENE);
        Intent intent3 = getIntent();
        if (intent3 == null || (extras2 = intent3.getExtras()) == null || (bundle2 = extras2.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) == null || (loginExpType = (LoginExpType) bundle2.getParcelable(FullscreenLoginExp.KEY_LOGIN_EXP)) == null) {
            loginExpType = LoginExpType.CONTROL;
        }
        this.fullscreenLoginExp = loginExpType;
        Intent intent4 = getIntent();
        if (intent4 != null && (extras = intent4.getExtras()) != null && (bundle = extras.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) != null) {
            str2 = bundle.getString(StartLoginPageKt.KEY_LOGIN_ROUTE_NEW);
        }
        this.loginNewRoute = Boolean.parseBoolean(str2);
        BLog.i(TAG, "Fullscreen login exp: " + this.fullscreenLoginExp + ", new route: " + this.loginNewRoute);
        initPresenter();
        initSmsLoginController();
        findViews();
        initViews();
        initActivity();
        BiliAccounts.get((Context) this).subscribe(this, new Topic[]{Topic.SIGN_IN, Topic.ACCOUNT_SWITCH});
        LoginAnswerDialogHelper.INSTANCE.newLoginCountDownLaunch();
        getLifecycle().addObserver(LoginLifecycleObserver.INSTANCE);
        this.checkBoxClick = true;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.onLoginPageEnter(this, application, LoginUIType.SMS_DIALOG);
        increaseSmsShowTimes();
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        LoginReportHelper.setTrackParams(this.mPresenter);
    }

    private final void initSmsLoginController() {
        SmsLoginController smsLoginController = new SmsLoginController() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$initSmsLoginController$1
            @Override // tv.danmaku.bili.sms.SmsLoginController
            public boolean isActivityDie() {
                return SmsLoginDialogActivityV2.this.isActivityDie();
            }

            @Override // tv.danmaku.bili.sms.SmsLoginController
            public TimeCounter.TimeCounterCallback getTimerCallback() {
                return SmsLoginDialogActivityV2.this;
            }
        };
        smsLoginController.onCreate((Context) this, this.mPresenter);
        this.mSmsLoginController = smsLoginController;
        this.mGoogleLoginManager = new GoogleLoginManager(LoginReportHelper.INSTANCE.getLoginSessionId(), LoginReportHelper.INSTANCE.getFromSpmid(), LoginReportHelper.INSTANCE.getGuideId(), LoginReportHelper.INSTANCE.getExtend());
        this.mFacebookLoginManager = new FacebookLoginManager((FragmentActivity) this, LoginReportHelper.INSTANCE.getLoginSessionId(), LoginReportHelper.INSTANCE.getFromSpmid(), LoginReportHelper.INSTANCE.getGuideId(), LoginReportHelper.INSTANCE.getExtend());
    }

    private final void initPresenter() {
        ISmsLoginPresenter smsLoginPresenter = new SmsLoginPresenter((Context) this, this, this);
        smsLoginPresenter.setLoginProxy(new SmsLoginController.SmsLoginRedirectProxy() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$initPresenter$1$1
            @Override // tv.danmaku.bili.sms.SmsLoginController.SmsLoginRedirectProxy
            public void startActivityForResult(Intent intent, int requestCode) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                SmsLoginDialogActivityV2.this.startActivityForResult(intent, requestCode);
            }
        });
        smsLoginPresenter.setScene("popup");
        this.mPresenter = smsLoginPresenter;
    }

    private final void initActivity() {
        Editable text;
        boolean z = false;
        StatusBarCompat.tintStatusBar(getWindow(), 0);
        ViewGroup viewGroup = this.mDialogContainer;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SmsLoginDialogActivityV2.initActivity$lambda$0(SmsLoginDialogActivityV2.this);
                }
            }, 200L);
        }
        final EditText $this$initActivity_u24lambda_u241 = this.mPhoneEditText;
        if ($this$initActivity_u24lambda_u241 != null) {
            EditText editText = this.mPhoneEditText;
            if (editText != null && (text = editText.getText()) != null && StringsKt.isBlank(text)) {
                z = true;
            }
            if (z) {
                $this$initActivity_u24lambda_u241.postDelayed(new Runnable() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmsLoginDialogActivityV2.initActivity$lambda$1$0($this$initActivity_u24lambda_u241);
                    }
                }, 100L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initActivity$lambda$0(final SmsLoginDialogActivityV2 this$0) {
        ViewGroup $this$initActivity_u24lambda_u240_u240 = this$0.mDialogContainer;
        if ($this$initActivity_u24lambda_u240_u240 != null) {
            ObjectAnimator anim = ObjectAnimator.ofFloat($this$initActivity_u24lambda_u240_u240, "alpha", 0.0f, 1.0f);
            anim.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$initActivity$1$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    ViewGroup viewGroup;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    viewGroup = SmsLoginDialogActivityV2.this.mDialogContainer;
                    if (viewGroup != null) {
                        viewGroup.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
            anim.setDuration(100L);
            anim.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initActivity$lambda$1$0(EditText $this_apply) {
        $this_apply.requestFocus();
        InputMethodManagerHelper.showSoftInput($this_apply.getContext(), $this_apply, 1);
    }

    private final void findViews() {
        this.mClose = findViewById(R.id.close);
        if (this.fullscreenLoginExp.getSmsSkippable()) {
            View view = this.mClose;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.mClose;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        this.mLoginButton = (LoginQuickButton) findViewById(R.id.btn_login);
        this.mPhoneEditText = (EditText) findViewById(R.id.phone_number);
        this.mClearPhoneNum = findViewById(R.id.clear_phonenum);
        this.mClearCode = findViewById(R.id.clear_code);
        this.mCodeEditText = (EditText) findViewById(R.id.code);
        this.mCountryCodeContainer = findViewById(R.id.country_code_container);
        this.mGetCodeBtn = (TextView) findViewById(R.id.get_code);
        this.mPwdLogin = (TextView) findViewById(R.id.btn_change_account);
        this.mCountryCodeArrow = (ImageView) findViewById(R.id.country_code_arrow);
        this.mPhoneNumberContainer = findViewById(R.id.phone_number_container);
        this.mGetCodeContainer = (ViewGroup) findViewById(R.id.code_container);
        this.mAgreementLinkText = (TextView) findViewById(R.id.tv_login_agreement);
        this.mCountryCodeTextView = (TextView) findViewById(R.id.country_code_text);
        this.mRootContainer = findViewById(R.id.root);
        this.mDialogContainer = (ViewGroup) findViewById(R.id.dialog_container);
        this.mLoginRegCheckBox = (CheckBox) findViewById(R.id.log_reg_checkbox);
        this.mLoginRegCheckBoxContainer = findViewById(R.id.log_reg_checkbox_container);
        LoginRegHelper.initOnChangeListener$default(this.mLoginRegCheckBox, null, 2, null);
        this.mLoginRegPopView = findViewById(R.id.login_reg_pop);
        this.mTitle = findViewById(R.id.title);
        BiliAppDialogLoginEulaBinding it = BiliAppDialogLoginEulaBinding.bind(findViewById(R.id.eula_group));
        Intrinsics.checkNotNull(it);
        this.eulaDelegate = new LoginEulaDialogViewDelegate(it);
        this.eulaGroup = it;
        this.mOverseaContainer = findViewById(R.id.oversea_container);
        this.mGoogleLogin = findViewById(R.id.google_login);
        this.mFaceBookLogin = findViewById(R.id.facebook_login);
        this.mPasswordOversea = findViewById(R.id.password_login);
    }

    private final void clearViews() {
        this.mClose = null;
        this.mLoginButton = null;
        this.mPhoneEditText = null;
        this.mClearPhoneNum = null;
        this.mClearCode = null;
        this.mCodeEditText = null;
        this.mCountryCodeContainer = null;
        this.mGetCodeBtn = null;
        this.mPwdLogin = null;
        this.mCountryCodeArrow = null;
        this.mPhoneNumberContainer = null;
        this.mGetCodeContainer = null;
        this.mAgreementLinkText = null;
        this.mCountryCodeTextView = null;
        this.mRootContainer = null;
        this.mDialogContainer = null;
        this.mLoginRegCheckBox = null;
        this.mLoginRegCheckBoxContainer = null;
        this.mLoginRegPopView = null;
        this.mTitle = null;
        this.eulaGroup = null;
        this.eulaDelegate = null;
    }

    private final void enableNextOperation(boolean enable) {
        EditText editText = this.mPhoneEditText;
        if (editText != null) {
            editText.setEnabled(enable);
        }
        TextView textView = this.mGetCodeBtn;
        if (textView != null) {
            textView.setClickable(enable);
        }
    }

    private final void initViews() {
        TimeCounter timer;
        setInputEnable(true);
        ArrayList inputs = new ArrayList(2);
        View view = this.mTitle;
        if (view != null) {
            view.setVisibility(0);
        }
        LoginQuickButton $this$initViews_u24lambda_u240 = this.mLoginButton;
        if ($this$initViews_u24lambda_u240 != null) {
            $this$initViews_u24lambda_u240.setBackgroundResource(R.drawable.selector_sms_login_button);
            $this$initViews_u24lambda_u240.setTextColor(ContextCompat.getColorStateList($this$initViews_u24lambda_u240.getContext(), R.color.bili_app_sms_login_btn_text_color));
            $this$initViews_u24lambda_u240.setEnabled(false);
            $this$initViews_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SmsLoginDialogActivityV2.this.onLoginClick(view2);
                }
            });
            $this$initViews_u24lambda_u240.setText(bili.resource.account.R.string.account_global_string_34);
        }
        final EditText $this$initViews_u24lambda_u241 = this.mPhoneEditText;
        if ($this$initViews_u24lambda_u241 != null) {
            SmsLoginDialogUtilKt.bindClearButton($this$initViews_u24lambda_u241, this.mClearPhoneNum);
            SmsLoginDialogUtilKt.enableIfSatisfied($this$initViews_u24lambda_u241, this.mGetCodeBtn, this);
            inputs.add(new WeakReference($this$initViews_u24lambda_u241));
            SmsLoginDialogUtilKt.changeTextBgColorBeforeTextChange($this$initViews_u24lambda_u241, this.mPhoneNumberContainer, Integer.valueOf(R.drawable.bili_app_dialog_sms_login_input_background));
            $this$initViews_u24lambda_u241.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda3
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    SmsLoginDialogActivityV2.initViews$lambda$1$0(SmsLoginDialogActivityV2.this, $this$initViews_u24lambda_u241, view2, z);
                }
            });
        }
        final EditText $this$initViews_u24lambda_u242 = this.mCodeEditText;
        if ($this$initViews_u24lambda_u242 != null) {
            SmsLoginDialogUtilKt.bindClearButton($this$initViews_u24lambda_u242, this.mClearCode);
            inputs.add(new WeakReference($this$initViews_u24lambda_u242));
            SmsLoginDialogUtilKt.changeTextBgColorBeforeTextChange($this$initViews_u24lambda_u242, this.mGetCodeContainer, Integer.valueOf(R.drawable.bili_app_dialog_sms_login_input_background));
            SmsLoginDialogUtilKt.performClickAfterParseText(this.mCodeEditText, (View) this.mLoginButton);
            $this$initViews_u24lambda_u242.setOnKeyListener(new View.OnKeyListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$initViews$3$1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    LoginQuickButton loginQuickButton;
                    LoginQuickButton loginQuickButton2;
                    if (keyCode == 66) {
                        loginQuickButton = SmsLoginDialogActivityV2.this.mLoginButton;
                        if (loginQuickButton != null && loginQuickButton.isEnabled()) {
                            loginQuickButton2 = SmsLoginDialogActivityV2.this.mLoginButton;
                            if (loginQuickButton2 != null) {
                                loginQuickButton2.performClick();
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
            $this$initViews_u24lambda_u242.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda4
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    SmsLoginDialogActivityV2.initViews$lambda$2$0(SmsLoginDialogActivityV2.this, $this$initViews_u24lambda_u242, view2, z);
                }
            });
        }
        View view2 = this.mCountryCodeContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SmsLoginDialogActivityV2.initViews$lambda$3(SmsLoginDialogActivityV2.this, view3);
                }
            });
        }
        SmsLoginDialogUtilKt.bindLoginButton(inputs, (View) this.mLoginButton);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$initViews$5(this, null), 3, (Object) null);
        TextView $this$initViews_u24lambda_u244 = this.mGetCodeBtn;
        if ($this$initViews_u24lambda_u244 != null) {
            $this$initViews_u24lambda_u244.setEnabled(false);
            SmsLoginController smsLoginController = this.mSmsLoginController;
            if (smsLoginController != null && (timer = smsLoginController.getTimer()) != null) {
                timer.attachTv($this$initViews_u24lambda_u244);
            }
            $this$initViews_u24lambda_u244.setText($this$initViews_u24lambda_u244.getContext().getString(bili.resource.account.R.string.account_global_string_21));
            $this$initViews_u24lambda_u244.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SmsLoginDialogActivityV2.this.getCode(view3);
                }
            });
        }
        View $this$initViews_u24lambda_u245 = this.mClose;
        if ($this$initViews_u24lambda_u245 != null) {
            $this$initViews_u24lambda_u245.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SmsLoginDialogActivityV2.initViews$lambda$5$0(SmsLoginDialogActivityV2.this, view3);
                }
            });
        }
        enableNextOperation(false);
        View view3 = this.mCountryCodeContainer;
        if (view3 != null) {
            view3.setClickable(false);
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        updateRegInfo();
        updateAgreement(true);
        loadCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1$0(SmsLoginDialogActivityV2 this$0, EditText $this_apply, View view, boolean focus) {
        int i;
        View view2 = this$0.mClearPhoneNum;
        if (view2 != null) {
            if (focus) {
                Editable text = $this_apply.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (!StringsKt.isBlank(text)) {
                    i = 0;
                    view2.setVisibility(i);
                }
            }
            i = 8;
            view2.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2$0(SmsLoginDialogActivityV2 this$0, EditText $this_apply, View view, boolean focus) {
        int i;
        View view2 = this$0.mClearCode;
        if (view2 != null) {
            if (focus) {
                Editable text = $this_apply.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (!StringsKt.isBlank(text)) {
                    i = 0;
                    view2.setVisibility(i);
                }
            }
            i = 8;
            view2.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3(SmsLoginDialogActivityV2 this$0, View it) {
        ISmsLoginPresenter iSmsLoginPresenter = this$0.mPresenter;
        if (iSmsLoginPresenter != null) {
            iSmsLoginPresenter.choiceCountry();
        }
        LoginReporterV2.Click.report(LoginReporterV2.Click.CLICK_SMS_LOGIN_DIALOG_CHOOSE_COUNTRY_BUTTON, this$0.getTrackCommonValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$0(SmsLoginDialogActivityV2 this$0, View it) {
        this$0.finish();
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_CLICK_CLOSE, this$0.getTrackCommonValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleOversea(Continuation<? super Unit> continuation) {
        SmsLoginDialogActivityV2$handleOversea$1 smsLoginDialogActivityV2$handleOversea$1;
        final SmsLoginDialogActivityV2 smsLoginDialogActivityV2;
        Object isOversea;
        boolean isOversea2;
        TextView pwdLogin;
        Object infoLogin;
        final SmsLoginDialogActivityV2 smsLoginDialogActivityV22;
        View pwdLogin2;
        TInfoLogin infoLogin2;
        TInfoLogin.LoginBean loginBean;
        TInfoLogin.LoginBean.SnsLoginBean snsLoginBean;
        TInfoLogin.LoginBean loginBean2;
        TInfoLogin.LoginBean.SnsLoginBean snsLoginBean2;
        if (continuation instanceof SmsLoginDialogActivityV2$handleOversea$1) {
            smsLoginDialogActivityV2$handleOversea$1 = (SmsLoginDialogActivityV2$handleOversea$1) continuation;
            if ((smsLoginDialogActivityV2$handleOversea$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginDialogActivityV2$handleOversea$1.label -= Integer.MIN_VALUE;
                Object $result = smsLoginDialogActivityV2$handleOversea$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (smsLoginDialogActivityV2$handleOversea$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        smsLoginDialogActivityV2 = this;
                        smsLoginDialogActivityV2$handleOversea$1.label = 1;
                        isOversea = smsLoginDialogActivityV2.isOversea(smsLoginDialogActivityV2$handleOversea$1);
                        if (isOversea == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        smsLoginDialogActivityV2 = this;
                        ResultKt.throwOnFailure($result);
                        isOversea = $result;
                        break;
                    case 2:
                        smsLoginDialogActivityV22 = this;
                        pwdLogin2 = (View) smsLoginDialogActivityV2$handleOversea$1.L$0;
                        ResultKt.throwOnFailure($result);
                        infoLogin = $result;
                        infoLogin2 = (TInfoLogin) infoLogin;
                        if (infoLogin2 == null && (loginBean2 = infoLogin2.login) != null && (snsLoginBean2 = loginBean2.sns) != null && snsLoginBean2.google) {
                            ViewGroup container = (ViewGroup) smsLoginDialogActivityV22.findViewById(R.id.google_login_container);
                            if (container != null) {
                                container.setVisibility(8);
                            }
                        } else {
                            View view = smsLoginDialogActivityV22.mGoogleLogin;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            View view2 = smsLoginDialogActivityV22.mGoogleLogin;
                            if (view2 != null) {
                                view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda19
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view3) {
                                        SmsLoginDialogActivityV2.handleOversea$lambda$0(SmsLoginDialogActivityV2.this, view3);
                                    }
                                });
                            }
                        }
                        if (infoLogin2 != null || (loginBean = infoLogin2.login) == null || (snsLoginBean = loginBean.sns) == null || !snsLoginBean.facebook) {
                            z = false;
                        }
                        if (z) {
                            ViewGroup container2 = (ViewGroup) smsLoginDialogActivityV22.findViewById(R.id.facebook_login_container);
                            if (container2 != null) {
                                container2.setVisibility(8);
                            }
                        } else {
                            View view3 = smsLoginDialogActivityV22.mFaceBookLogin;
                            if (view3 != null) {
                                view3.setVisibility(0);
                            }
                            View view4 = smsLoginDialogActivityV22.mFaceBookLogin;
                            if (view4 != null) {
                                view4.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda20
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view5) {
                                        SmsLoginDialogActivityV2.handleOversea$lambda$1(SmsLoginDialogActivityV2.this, view5);
                                    }
                                });
                            }
                        }
                        pwdLogin = pwdLogin2;
                        smsLoginDialogActivityV2 = smsLoginDialogActivityV22;
                        if (pwdLogin != null) {
                            pwdLogin.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view5) {
                                    SmsLoginDialogActivityV2.handleOversea$lambda$2(SmsLoginDialogActivityV2.this, view5);
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                isOversea2 = ((Boolean) isOversea).booleanValue();
                pwdLogin = !isOversea2 ? smsLoginDialogActivityV2.mPasswordOversea : smsLoginDialogActivityV2.mPwdLogin;
                if (isOversea2) {
                    TextView textView = smsLoginDialogActivityV2.mPwdLogin;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    View view5 = smsLoginDialogActivityV2.mOverseaContainer;
                    if (view5 != null) {
                        view5.setVisibility(8);
                    }
                    if (pwdLogin != null) {
                    }
                    return Unit.INSTANCE;
                }
                smsLoginDialogActivityV2.mIsOversea = true;
                TextView textView2 = smsLoginDialogActivityV2.mPwdLogin;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                View view6 = smsLoginDialogActivityV2.mOverseaContainer;
                if (view6 != null) {
                    view6.setVisibility(0);
                }
                smsLoginDialogActivityV2$handleOversea$1.L$0 = pwdLogin;
                smsLoginDialogActivityV2$handleOversea$1.label = 2;
                infoLogin = smsLoginDialogActivityV2.getInfoLogin(smsLoginDialogActivityV2$handleOversea$1);
                if (infoLogin == coroutine_suspended) {
                    return coroutine_suspended;
                }
                smsLoginDialogActivityV22 = smsLoginDialogActivityV2;
                pwdLogin2 = pwdLogin;
                infoLogin2 = (TInfoLogin) infoLogin;
                if (infoLogin2 == null && (loginBean2 = infoLogin2.login) != null && (snsLoginBean2 = loginBean2.sns) != null && snsLoginBean2.google) {
                }
                if (infoLogin2 != null) {
                }
                z = false;
                if (z) {
                }
                pwdLogin = pwdLogin2;
                smsLoginDialogActivityV2 = smsLoginDialogActivityV22;
                if (pwdLogin != null) {
                }
                return Unit.INSTANCE;
            }
        }
        smsLoginDialogActivityV2$handleOversea$1 = new SmsLoginDialogActivityV2$handleOversea$1(this, continuation);
        Object $result2 = smsLoginDialogActivityV2$handleOversea$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (smsLoginDialogActivityV2$handleOversea$1.label) {
        }
        isOversea2 = ((Boolean) isOversea).booleanValue();
        if (!isOversea2) {
        }
        if (isOversea2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOversea$lambda$0(final SmsLoginDialogActivityV2 this$0, View it) {
        this$0.checkLoginReg(new Function0() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda14
            public final Object invoke() {
                Unit handleOversea$lambda$0$0;
                handleOversea$lambda$0$0 = SmsLoginDialogActivityV2.handleOversea$lambda$0$0(SmsLoginDialogActivityV2.this);
                return handleOversea$lambda$0$0;
            }
        });
        HashMap track = this$0.getTrackCommonValue();
        track.put("type", ConstsKt.SP_GOOGLE);
        LoginReporterV2.Click.report(LoginReporterV2.Click.CLICK_SMS_LOGIN_DIALOG_TO_PWD_LOGIN_BUTTON, track);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleOversea$lambda$0$0(SmsLoginDialogActivityV2 this$0) {
        this$0.googleLogin();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOversea$lambda$1(final SmsLoginDialogActivityV2 this$0, View it) {
        this$0.checkLoginReg(new Function0() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda18
            public final Object invoke() {
                Unit handleOversea$lambda$1$0;
                handleOversea$lambda$1$0 = SmsLoginDialogActivityV2.handleOversea$lambda$1$0(SmsLoginDialogActivityV2.this);
                return handleOversea$lambda$1$0;
            }
        });
        HashMap track = this$0.getTrackCommonValue();
        track.put("type", "facebook");
        LoginReporterV2.Click.report(LoginReporterV2.Click.CLICK_SMS_LOGIN_DIALOG_TO_PWD_LOGIN_BUTTON, track);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleOversea$lambda$1$0(SmsLoginDialogActivityV2 this$0) {
        this$0.facebookLogin();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOversea$lambda$2(SmsLoginDialogActivityV2 this$0, View it) {
        BuildersKt.launch$default(this$0.uiScope, (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$handleOversea$4$1(this$0, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object isOversea(Continuation<? super Boolean> continuation) {
        SmsLoginDialogActivityV2$isOversea$1 smsLoginDialogActivityV2$isOversea$1;
        Object infoLogin;
        SmsLoginDialogActivityV2 smsLoginDialogActivityV2;
        TInfoLogin infoLogin2;
        TInfoLogin.LoginBean loginBean;
        TInfoLogin.LoginBean.SnsLoginBean snsLoginBean;
        if (continuation instanceof SmsLoginDialogActivityV2$isOversea$1) {
            smsLoginDialogActivityV2$isOversea$1 = (SmsLoginDialogActivityV2$isOversea$1) continuation;
            if ((smsLoginDialogActivityV2$isOversea$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginDialogActivityV2$isOversea$1.label -= Integer.MIN_VALUE;
                Object $result = smsLoginDialogActivityV2$isOversea$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (smsLoginDialogActivityV2$isOversea$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        smsLoginDialogActivityV2$isOversea$1.label = 1;
                        infoLogin = getInfoLogin(smsLoginDialogActivityV2$isOversea$1);
                        if (infoLogin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        smsLoginDialogActivityV2 = this;
                        break;
                    case 1:
                        smsLoginDialogActivityV2 = this;
                        ResultKt.throwOnFailure($result);
                        infoLogin = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                infoLogin2 = (TInfoLogin) infoLogin;
                boolean netTypeUnavailable = StringsKt.isBlank(LoginQuickManager.INSTANCE.getNetType((Context) smsLoginDialogActivityV2));
                BLog.i(TAG, "isOversea -> infoLogin = " + infoLogin2 + ", netTypeUnavailable=" + netTypeUnavailable);
                if (((infoLogin2 != null || (loginBean = infoLogin2.login) == null || (snsLoginBean = loginBean.sns) == null) ? 0 : snsLoginBean.rank) != 0 || !netTypeUnavailable) {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            }
        }
        smsLoginDialogActivityV2$isOversea$1 = new SmsLoginDialogActivityV2$isOversea$1(this, continuation);
        Object $result2 = smsLoginDialogActivityV2$isOversea$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (smsLoginDialogActivityV2$isOversea$1.label) {
        }
        infoLogin2 = (TInfoLogin) infoLogin;
        boolean netTypeUnavailable2 = StringsKt.isBlank(LoginQuickManager.INSTANCE.getNetType((Context) smsLoginDialogActivityV2));
        BLog.i(TAG, "isOversea -> infoLogin = " + infoLogin2 + ", netTypeUnavailable=" + netTypeUnavailable2);
        if (((infoLogin2 != null || (loginBean = infoLogin2.login) == null || (snsLoginBean = loginBean.sns) == null) ? 0 : snsLoginBean.rank) != 0) {
        }
        z2 = false;
        return Boxing.boxBoolean(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getInfoLogin(Continuation<? super TInfoLogin> continuation) {
        SmsLoginDialogActivityV2$getInfoLogin$1 smsLoginDialogActivityV2$getInfoLogin$1;
        Object suspendGetLoginTypeForSwitch$default;
        if (continuation instanceof SmsLoginDialogActivityV2$getInfoLogin$1) {
            smsLoginDialogActivityV2$getInfoLogin$1 = (SmsLoginDialogActivityV2$getInfoLogin$1) continuation;
            if ((smsLoginDialogActivityV2$getInfoLogin$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginDialogActivityV2$getInfoLogin$1.label -= Integer.MIN_VALUE;
                Object $result = smsLoginDialogActivityV2$getInfoLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (smsLoginDialogActivityV2$getInfoLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        boolean fromSwitch = Intrinsics.areEqual(this.mFrom, OnePassLoginReportManagerKt.SPM_ID_CHANGE_ACCOUNT);
                        LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                        boolean z = fromSwitch;
                        smsLoginDialogActivityV2$getInfoLogin$1.label = 1;
                        suspendGetLoginTypeForSwitch$default = LoginRuleProcessor.suspendGetLoginTypeForSwitch$default(loginRuleProcessor, false, false, z, smsLoginDialogActivityV2$getInfoLogin$1, 3, null);
                        if (suspendGetLoginTypeForSwitch$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        suspendGetLoginTypeForSwitch$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                TInfoLogin infoLogin = (TInfoLogin) ((Pair) suspendGetLoginTypeForSwitch$default).component2();
                return infoLogin;
            }
        }
        smsLoginDialogActivityV2$getInfoLogin$1 = new SmsLoginDialogActivityV2$getInfoLogin$1(this, continuation);
        Object $result2 = smsLoginDialogActivityV2$getInfoLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (smsLoginDialogActivityV2$getInfoLogin$1.label) {
        }
        TInfoLogin infoLogin2 = (TInfoLogin) ((Pair) suspendGetLoginTypeForSwitch$default).component2();
        return infoLogin2;
    }

    private final void updateRegInfo() {
        View view = this.mLoginRegPopView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SmsLoginDialogActivityV2.updateRegInfo$lambda$0(SmsLoginDialogActivityV2.this, view2);
                }
            });
        }
        TextView textView = this.mAgreementLinkText;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SmsLoginDialogActivityV2.updateRegInfo$lambda$1(SmsLoginDialogActivityV2.this, view2);
                }
            });
        }
        View view2 = this.mLoginRegCheckBoxContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SmsLoginDialogActivityV2.updateRegInfo$lambda$2(SmsLoginDialogActivityV2.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegInfo$lambda$0(SmsLoginDialogActivityV2 this$0, View it) {
        CheckBox $this$updateRegInfo_u24lambda_u240_u240 = this$0.mLoginRegCheckBox;
        if ($this$updateRegInfo_u24lambda_u240_u240 != null && LoginRegHelper.checkViewVisibleAndUnCheck($this$updateRegInfo_u24lambda_u240_u240)) {
            $this$updateRegInfo_u24lambda_u240_u240.setChecked(true);
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN2, this$0.mLoginRegCheckBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegInfo$lambda$1(SmsLoginDialogActivityV2 this$0, View it) {
        CheckBox $this$updateRegInfo_u24lambda_u241_u240 = this$0.mLoginRegCheckBox;
        if ($this$updateRegInfo_u24lambda_u241_u240 != null) {
            $this$updateRegInfo_u24lambda_u241_u240.setChecked(!$this$updateRegInfo_u24lambda_u241_u240.isChecked());
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN2, this$0.mLoginRegCheckBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRegInfo$lambda$2(SmsLoginDialogActivityV2 this$0, View it) {
        CheckBox $this$updateRegInfo_u24lambda_u242_u240 = this$0.mLoginRegCheckBox;
        if ($this$updateRegInfo_u24lambda_u242_u240 != null) {
            $this$updateRegInfo_u24lambda_u242_u240.setChecked(!$this$updateRegInfo_u24lambda_u242_u240.isChecked());
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN2, this$0.mLoginRegCheckBox);
    }

    private final void updateAgreement(boolean init) {
        TextView $this$updateAgreement_u24lambda_u240 = this.mAgreementLinkText;
        if ($this$updateAgreement_u24lambda_u240 != null) {
            AgreementLinkHelper helper = new AgreementLinkHelper($this$updateAgreement_u24lambda_u240.getContext());
            helper.attachLinkContentAgreement($this$updateAgreement_u24lambda_u240, getAgreementLinkString(init), ContextCompat.getColor($this$updateAgreement_u24lambda_u240.getContext(), com.bilibili.lib.theme.R.color.Lb6), this.clickEulaLinkListener);
        }
    }

    private final String getAgreementLinkString(boolean init) {
        boolean showCheckBox;
        if (init) {
            showCheckBox = LoginRegHelper.INSTANCE.getLoginRegStrategy().showReg((Context) this);
        } else {
            CheckBox checkBox = this.mLoginRegCheckBox;
            showCheckBox = checkBox != null && checkBox.getVisibility() == 0;
        }
        String string = getString(showCheckBox ? bili.resource.account.R.string.account_global_string_137 : bili.resource.account.R.string.account_global_string_127);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void loadCache() {
        AutoCompleteHelper.SmsLoginInfo $this$loadCache_u24lambda_u240;
        ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
        if (iSmsLoginPresenter == null || ($this$loadCache_u24lambda_u240 = iSmsLoginPresenter.loadCache()) == null) {
            $this$loadCache_u24lambda_u240 = null;
        } else {
            EditText editText = this.mPhoneEditText;
            if (editText != null) {
                editText.setText($this$loadCache_u24lambda_u240.mPhoneNum);
            }
            EditText editText2 = this.mPhoneEditText;
            if (editText2 != null) {
                editText2.setSelection($this$loadCache_u24lambda_u240.mPhoneNum.length());
            }
            TextView textView = this.mGetCodeBtn;
            if (textView != null) {
                textView.setEnabled(true);
            }
            enableNextOperation(true);
            CountryCode countryCode = $this$loadCache_u24lambda_u240.mCountryCode;
            if (TextUtils.isEmpty(countryCode.countryId) && !TextUtils.isEmpty(countryCode.oldCountryId)) {
                countryCode.countryId = countryCode.oldCountryId;
            }
            refreshViewByCountryCode(countryCode);
            ISmsLoginPresenter iSmsLoginPresenter2 = this.mPresenter;
            if (iSmsLoginPresenter2 != null) {
                Intrinsics.checkNotNull(countryCode);
                iSmsLoginPresenter2.setCountryCode(countryCode);
            }
        }
        this.mSmsCacheLoginInfo = $this$loadCache_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoginClick(View view) {
        if (!this.mEnableCommit) {
            return;
        }
        HashMap $this$onLoginClick_u24lambda_u240 = getTrackCommonValue();
        String isShow = LoginRegHelper.getProvisionReportValue((Context) this);
        $this$onLoginClick_u24lambda_u240.put(LoginReporterV2.SHOW_PROVISION_KEY, isShow);
        if (Intrinsics.areEqual("1", isShow)) {
            $this$onLoginClick_u24lambda_u240.put("is_agree", LoginRegHelper.getAgreeReportValue(this.mLoginRegCheckBox));
        }
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_CLICK_LOGIN_BUTTON, $this$onLoginClick_u24lambda_u240);
        checkLoginReg(new Function0() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda12
            public final Object invoke() {
                Unit onLoginClick$lambda$1;
                onLoginClick$lambda$1 = SmsLoginDialogActivityV2.onLoginClick$lambda$1(SmsLoginDialogActivityV2.this);
                return onLoginClick$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoginClick$lambda$1(SmsLoginDialogActivityV2 this$0) {
        this$0.doLogin();
        return Unit.INSTANCE;
    }

    private final void checkLoginReg(Function0<Unit> function0) {
        if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$checkLoginReg$1(this, function0, null), 3, (Object) null);
        } else {
            function0.invoke();
        }
    }

    private final void doLogin() {
        ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
        if (iSmsLoginPresenter != null) {
            EditText editText = this.mPhoneEditText;
            String valueOf = String.valueOf(editText != null ? editText.getText() : null);
            EditText editText2 = this.mCodeEditText;
            iSmsLoginPresenter.submit(valueOf, String.valueOf(editText2 != null ? editText2.getText() : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEulaDialogVisibility(boolean show) {
        ConstraintLayout root;
        ViewGroup viewGroup = this.mDialogContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(toVisibility(!show));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCode(View view) {
        Editable text;
        EditText editText = this.mPhoneEditText;
        boolean z = false;
        if (editText != null && (text = editText.getText()) != null && (!StringsKt.isBlank(text))) {
            z = true;
        }
        if (z) {
            boolean uncheck = LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox);
            HashMap $this$getCode_u24lambda_u240 = getTrackCommonValue();
            $this$getCode_u24lambda_u240.put("is_agree", uncheck ? "0" : "1");
            LoginReporterV2.Click.report(LoginReporterV2.Click.CLICK_SMS_LOGIN_DIALOG_GET_CODE_BUTTON, $this$getCode_u24lambda_u240);
            if (uncheck) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$getCode$2(this, null), 3, (Object) null);
                return;
            }
            ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
            if (iSmsLoginPresenter != null) {
                EditText editText2 = this.mPhoneEditText;
                iSmsLoginPresenter.sendCaptcha(String.valueOf(editText2 != null ? editText2.getText() : null));
            }
        }
    }

    private final void setInputEnable(boolean enable) {
        Drawable arrow = ContextCompat.getDrawable((Context) this, com.bilibili.app.comm.baseres.R.drawable.ic_spread);
        int color = enable ? com.bilibili.lib.theme.R.color.Ga7 : com.bilibili.lib.theme.R.color.Ga4;
        ViewGroup $this$setInputEnable_u24lambda_u240 = this.mGetCodeContainer;
        if ($this$setInputEnable_u24lambda_u240 != null) {
            ViewCompat.setBackground($this$setInputEnable_u24lambda_u240, ContextCompat.getDrawable($this$setInputEnable_u24lambda_u240.getContext(), R.drawable.bili_app_dialog_sms_login_input_background));
            $this$setInputEnable_u24lambda_u240.setEnabled(enable);
        }
        View $this$setInputEnable_u24lambda_u241 = this.mPhoneNumberContainer;
        if ($this$setInputEnable_u24lambda_u241 != null) {
            ViewCompat.setBackground($this$setInputEnable_u24lambda_u241, ContextCompat.getDrawable($this$setInputEnable_u24lambda_u241.getContext(), R.drawable.bili_app_dialog_sms_login_input_background));
            $this$setInputEnable_u24lambda_u241.setEnabled(enable);
        }
        ImageView imageView = this.mCountryCodeArrow;
        if (imageView != null) {
            imageView.setImageDrawable(tintDrawable(arrow, ContextCompat.getColor((Context) this, color)));
        }
        TextView textView = this.mCountryCodeTextView;
        if (textView != null) {
            textView.setEnabled(enable);
        }
        EditText editText = this.mPhoneEditText;
        if (editText != null) {
            editText.setEnabled(enable);
        }
        EditText editText2 = this.mCodeEditText;
        if (editText2 != null) {
            editText2.setEnabled(enable);
        }
        TextView textView2 = this.mGetCodeBtn;
        if (textView2 != null) {
            textView2.setEnabled(enable);
        }
        View view = this.mCountryCodeContainer;
        if (view != null) {
            view.setClickable(enable);
        }
        View view2 = this.mClearPhoneNum;
        if (view2 != null) {
            view2.setClickable(enable);
        }
        View view3 = this.mClearCode;
        if (view3 != null) {
            view3.setClickable(enable);
        }
        TextView $this$setInputEnable_u24lambda_u242 = this.mPwdLogin;
        if ($this$setInputEnable_u24lambda_u242 != null) {
            $this$setInputEnable_u24lambda_u242.setClickable(enable);
            $this$setInputEnable_u24lambda_u242.setTextColor(ContextCompat.getColor($this$setInputEnable_u24lambda_u242.getContext(), enable ? com.bilibili.lib.theme.R.color.Ga8 : com.bilibili.lib.theme.R.color.Ga5));
        }
        TextView $this$setInputEnable_u24lambda_u243 = this.mAgreementLinkText;
        if ($this$setInputEnable_u24lambda_u243 != null) {
            if (enable) {
                updateAgreement(false);
            } else {
                $this$setInputEnable_u24lambda_u243.setText(getAgreementLinkString(false));
            }
        }
    }

    private final void increaseSmsShowTimes() {
        ILoginLimitUpdate iLoginLimitUpdate;
        String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
        if (Intrinsics.areEqual(fromSpmid, "enter_homepage")) {
            ILoginLimitUpdate iLoginLimitUpdate2 = (ILoginLimitUpdate) BLRouter.INSTANCE.get(ILoginLimitUpdate.class, "homepage");
            if (iLoginLimitUpdate2 != null) {
                iLoginLimitUpdate2.updateSms((Context) this);
            }
        } else if (!Intrinsics.areEqual(fromSpmid, LoginReporterV2.Error.SP_MID_ENTER_MY_INFO) || (iLoginLimitUpdate = (ILoginLimitUpdate) BLRouter.INSTANCE.get(ILoginLimitUpdate.class, "home_user_center")) == null) {
        } else {
            iLoginLimitUpdate.updateSms((Context) this);
        }
    }

    private final void finish(boolean skipCheck) {
        if (this.fullscreenLoginExp.getSmsSkippable() || BiliAccounts.get((Context) this).isLogin() || skipCheck) {
            super.finish();
            overridePendingTransition(R.anim.login_quick_dialog_alpha_in, R.anim.login_quick_dialog_alpha_out);
        }
    }

    public void finish() {
        finish(false);
    }

    private final void googleLogin() {
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$googleLogin$1(this, null), 3, (Object) null);
    }

    private final void facebookLogin() {
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SmsLoginDialogActivityV2$facebookLogin$1(this, null), 3, (Object) null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode + " , resultCode = " + resultCode);
        if (requestCode == 204) {
            if (resultCode == -1) {
                setResult(-1);
            }
            finish();
        }
    }

    protected void onDestroy() {
        LoginQuickButton loginQuickButton = this.mLoginButton;
        if (loginQuickButton != null) {
            loginQuickButton.hideProgress();
        }
        super.onDestroy();
        ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
        if (iSmsLoginPresenter != null) {
            iSmsLoginPresenter.cancelTasks();
        }
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.onDestroy();
        }
        BiliAccounts.get((Context) this).unsubscribeAllWithSwitch(this);
        LoginAnswerDialogHelper.INSTANCE.clearLoginCountDownLaunch();
        MainDialogManager.showNextDialog("login_guide", false, (Context) this);
        getLifecycle().removeObserver(LoginLifecycleObserver.INSTANCE);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.onLoginPageExit(this, application, LoginUIType.SMS_DIALOG);
        clearViews();
    }

    private final Drawable tintDrawable(Drawable drawable, int color) {
        if (drawable == null) {
            return null;
        }
        Drawable wrapper = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrapper, color);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemLinkClick(int itemId, EulaTriggerType eulaTriggerType) {
        this.mAnyRegFlag = true;
        HashMap<String, String> trackCommonValue = getTrackCommonValue();
        String reportTypeValue = eulaTriggerType != null ? eulaTriggerType.getReportTypeValue() : null;
        if (reportTypeValue == null) {
            reportTypeValue = "";
        }
        Map map = MapsKt.plus(trackCommonValue, MapsKt.mapOf(TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, reportTypeValue)));
        switch (itemId) {
            case 2:
                LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_CLICK_USER_AGREEMENT, map);
                return;
            case 3:
                LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_CLICK_PRIVACY, map);
                return;
            default:
                return;
        }
    }

    public void showTip(int resId) {
        showTip(getString(resId));
    }

    public void showTip(String message) {
        String str = message;
        if (!(str == null || str.length() == 0)) {
            ToastHelper.showToast((Context) this, message, 0);
        }
    }

    public void showCountryChoiceDialog() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.showCountryChoiceDialog();
        }
    }

    public void hideCountryChoiceDialog() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.hideCountryChoiceDialog();
        }
    }

    public void sendSmsWithGeeCaptcha(Map<String, String> map) {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.sendSmsWithGeeCaptcha(map);
        }
    }

    public void sendSmsWithImageCaptcha(int callbackId, Map<String, String> map) {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.sendSmsWithImageCaptcha(callbackId, map);
        }
    }

    public void tryNotifyImageCaptchaSuccess() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.tryNotifyImageCaptchaSuccess();
        }
    }

    public void showCaptchaDialog(String url) {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.showCaptchaDialog(url, new Function0() { // from class: tv.danmaku.bili.sms.SmsLoginDialogActivityV2$$ExternalSyntheticLambda13
                public final Object invoke() {
                    Unit showCaptchaDialog$lambda$0;
                    showCaptchaDialog$lambda$0 = SmsLoginDialogActivityV2.showCaptchaDialog$lambda$0(SmsLoginDialogActivityV2.this);
                    return showCaptchaDialog$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCaptchaDialog$lambda$0(SmsLoginDialogActivityV2 this$0) {
        LoginReporterV2.Show.report(LoginReporterV2.Show.SMS_LOGIN_DIALOG_VERIFICATION_SHOW, this$0.getTrackCommonValue());
        return Unit.INSTANCE;
    }

    public void hideCaptchaDialog() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.hideCaptchaDialog();
        }
    }

    public void focusToCaptchaEdit() {
        EditText editText = this.mCodeEditText;
        if (editText != null) {
            editText.setText("");
        }
        EditText editText2 = this.mCodeEditText;
        if (editText2 != null) {
            editText2.requestFocus();
        }
        InputMethodManagerHelper.showSoftInput((Context) this, this.mCodeEditText, 1);
    }

    public void showProgress(String msg) {
        setInputEnable(false);
        LoginQuickButton loginQuickButton = this.mLoginButton;
        if (loginQuickButton != null) {
            loginQuickButton.showProgress();
        }
    }

    public void showProgress(int resId) {
        showProgress(getString(resId));
    }

    public void hideProgress() {
        setInputEnable(true);
        LoginQuickButton loginQuickButton = this.mLoginButton;
        if (loginQuickButton != null) {
            loginQuickButton.hideProgress();
        }
    }

    public void onCountryCodeUpdate(boolean success) {
        View view = this.mCountryCodeContainer;
        if (view != null) {
            view.setClickable(true);
        }
        if (this.mSmsCacheLoginInfo != null) {
            return;
        }
        ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
        refreshViewByCountryCode(iSmsLoginPresenter != null ? iSmsLoginPresenter.getSelectedCountryCode() : null);
        enableNextOperation(true);
    }

    public void warningPhoneNum() {
        View $this$warningPhoneNum_u24lambda_u240 = this.mPhoneNumberContainer;
        if ($this$warningPhoneNum_u24lambda_u240 != null) {
            ViewCompat.setBackground($this$warningPhoneNum_u24lambda_u240, ContextCompat.getDrawable($this$warningPhoneNum_u24lambda_u240.getContext(), R.drawable.bili_app_dialog_sms_input_background_error));
        }
    }

    public void warningCaptcha() {
        ViewGroup $this$warningCaptcha_u24lambda_u240 = this.mGetCodeContainer;
        if ($this$warningCaptcha_u24lambda_u240 != null) {
            ViewCompat.setBackground($this$warningCaptcha_u24lambda_u240, ContextCompat.getDrawable($this$warningCaptcha_u24lambda_u240.getContext(), R.drawable.bili_app_dialog_sms_input_background_error));
        }
    }

    public void onLoginAfterRegisterSuccess(int inRegAudit) {
        if (inRegAudit != 1 && !LoginSceneProcessor.followingGuideEnable()) {
            showTip(bili.resource.account.R.string.account_global_string_66);
        }
    }

    public void startTimer() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.startTimer();
        }
    }

    public void stopTimer() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.stopTimer();
        }
    }

    public void alertVipStatusIfNeed() {
        AccountInfo myInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        if (myInfo != null && myInfo.getVipInfo() != null && myInfo.getVipInfo().isFrozen()) {
            showTip(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1303);
        }
    }

    public CountryCode getDefaultCountryCode() {
        CountryCode defaultCountryCode;
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null && (defaultCountryCode = smsLoginController.getDefaultCountryCode()) != null) {
            return defaultCountryCode;
        }
        return SmsLoginController.Companion.getNullDefaultCountryCode();
    }

    public void finish(int code) {
        setResult(code);
        finish();
    }

    public void onLoginSuccess() {
        this.mEnableCommit = false;
        handleNextAnswerDialog();
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.processLoginSuccess(application, LoginUIType.SMS_DIALOG);
    }

    private final void handleNextAnswerDialog() {
        LoginAnswerDialogHelper.INSTANCE.setNeedShowAnswerDialog((Context) this, true, AnswerDialogTransferActivity.FROM_SMS_DIALOG, "app.sms-login2.0.0");
        LoginAnswerDialogHelper.INSTANCE.clearLoginCountDownLaunch();
    }

    public void onLoginIntercept(VerifyBundle verifyBundle) {
    }

    public void onReceiveSelectCountry(CountryCode code) {
        Intrinsics.checkNotNullParameter(code, LoginReporterV2.Show.SIGNUP_KEY_CODE);
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_SET_COUNTRY_CODE, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.Click.SIGNUP_KEY_COUNTRY, code.id));
        refreshViewByCountryCode(code);
    }

    private final void refreshViewByCountryCode(CountryCode code) {
        TextView textView;
        if (code != null && (textView = this.mCountryCodeTextView) != null) {
            textView.setText(code.countryId == null ? "" : "+" + code.countryId);
        }
        TextView textView2 = this.mGetCodeBtn;
        if (textView2 != null) {
            textView2.setEnabled(isSatisfied(this.mPhoneEditText));
        }
    }

    public void replyWithGeeCaptcha(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.replyWithGeeCaptcha(map);
        }
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_VERIFICATION_SUCCESS, getTrackCommonValue());
    }

    public void replyWithImageCaptcha(int callbackId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.replyWithImageCaptcha(callbackId, map);
        }
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_VERIFICATION_SUCCESS, getTrackCommonValue());
    }

    public void closeCaptchaDialog() {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.closeCaptchaDialog();
        }
        LoginReporterV2.Click.report(LoginReporterV2.Click.SMS_LOGIN_DIALOG_VERIFICATION_CLOSE, getTrackCommonValue());
    }

    public void onChange(Topic topic) {
        if ((topic == Topic.SIGN_IN || topic == Topic.ACCOUNT_SWITCH) && !Intrinsics.areEqual(BiliContext.topActivity(), this)) {
            finish();
        }
    }

    public String getPvEventId() {
        return LoginReporterV2.Show.PVID_SMS_LOGIN_DIALOG;
    }

    public Bundle getPvExtra() {
        Bundle $this$getPvExtra_u24lambda_u240 = LoginReportHelper.buildCommonBundle();
        String $this$getPvExtra_u24lambda_u240_u240 = this.mSmpId;
        if ($this$getPvExtra_u24lambda_u240_u240 != null) {
            $this$getPvExtra_u24lambda_u240.putString(FavoritesConstsKt.SPMID, $this$getPvExtra_u24lambda_u240_u240);
        }
        $this$getPvExtra_u24lambda_u240.putString(LoginReporterV2.SHOW_PROVISION_KEY, LoginRegHelper.getProvisionReportValue((Context) this));
        return $this$getPvExtra_u24lambda_u240;
    }

    protected void onResume() {
        super.onResume();
        if (this.checkBoxClick && (!this.mAnyRegFlag || !LoginRegHelper.isAnyPageLoginReg())) {
            this.checkBoxClick = false;
            LoginRegHelper.updateRegCheckbox(this.mLoginRegCheckBox, this.mLoginRegCheckBoxContainer);
        }
        if (this.goOtherPage) {
            LoginRegHelper.updateRegCheckbox(this.mLoginRegCheckBox, this.mLoginRegCheckBoxContainer);
            this.goOtherPage = false;
            return;
        }
        this.mAnyRegFlag = false;
    }

    public boolean shouldReport() {
        return this.mSmpId != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, String> getTrackCommonValue() {
        HashMap map = new HashMap();
        String $this$getTrackCommonValue_u24lambda_u240 = this.mSmpId;
        if ($this$getTrackCommonValue_u24lambda_u240 != null) {
            map.put(FavoritesConstsKt.SPMID, $this$getTrackCommonValue_u24lambda_u240);
        }
        map.put("type", this.loginType);
        map.put("is_oversea", this.mIsOversea ? "1" : "0");
        return map;
    }

    @Override // tv.danmaku.bili.sms.Satisfied
    public boolean isSatisfied(EditText input) {
        Editable text;
        return isPhoneLegal((input == null || (text = input.getText()) == null) ? null : text.toString());
    }

    public void onCountDownFinish(TextView view) {
        if (view != null) {
            view.setTextColor(ContextCompat.getColorStateList(view.getContext(), R.color.bili_app_sms_login_get_code_text_color));
            EditText editText = this.mPhoneEditText;
            boolean clickable = isPhoneLegal(String.valueOf(editText != null ? editText.getText() : null));
            view.setClickable(clickable);
            view.setEnabled(clickable);
            view.setText(getString(bili.resource.account.R.string.account_global_string_30));
        }
    }

    public void onCountDown(TextView view, long second) {
        if (view != null) {
            view.setClickable(false);
        }
        if (view != null) {
            view.setText(getResources().getQuantityString(bili.resource.account.R.plurals.account_global_string_418, (int) second, String.valueOf(second)));
        }
        if (view != null) {
            view.setTextColor(ContextCompat.getColor((Context) this, com.bilibili.lib.theme.R.color.Ga4));
        }
    }

    private final boolean isPhoneLegal(String phone) {
        ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
        CountryCode countryCode = iSmsLoginPresenter != null ? iSmsLoginPresenter.getSelectedCountryCode() : null;
        if (Intrinsics.areEqual(SmsLoginService.AREA_CODE_MAINLAND, countryCode != null ? countryCode.countryId : null)) {
            return phone != null && phone.length() == 11;
        }
        return true;
    }

    public void callbackCaptchaDialog(int code, String message) {
        SmsLoginController smsLoginController = this.mSmsLoginController;
        if (smsLoginController != null) {
            smsLoginController.callbackCaptchaDialog(code, message);
        }
    }

    public void onRegisterSuccess() {
        HashMap map = LoginReporterV2.generateSingleParamMaps("method", "9");
        map.putAll(getTrackCommonValue());
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW, map);
    }

    public void onLoginSuccess(boolean isNew) {
        HashMap<String, String> generateSingleParamMaps = isNew ? LoginReporterV2.generateSingleParamMaps("method", LoginReporterV2.Show.LOGIN_SUCCEED_NO_ACCOUNT_FROM_SMS_LOGIN_DIALOG) : LoginReporterV2.generateSingleParamMaps("method", LoginReporterV2.Show.LOGIN_SUCCEED_SMS_NO_IDENTITY_FROM_SMS_LOGIN_DIALOG);
        generateSingleParamMaps.putAll(getTrackCommonValue());
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, generateSingleParamMaps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading(boolean isShow) {
        if (this.loadingDialog == null) {
            LoadingDialog.Companion companion = LoadingDialog.Companion;
            String string = getString(bili.resource.account.R.string.account_global_string_89);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.loadingDialog = companion.withContent(string);
        }
        try {
            if (isShow) {
                LoadingDialog dialog = this.loadingDialog;
                if (dialog == null) {
                    return;
                }
                if (!dialog.isAdded()) {
                    dialog.showNow(getSupportFragmentManager(), "loading");
                } else {
                    dialog.dismissAllowingStateLoss();
                }
            } else {
                LoadingDialog loadingDialog = this.loadingDialog;
                if (loadingDialog != null) {
                    loadingDialog.dismissAllowingStateLoss();
                }
            }
        } catch (Exception e) {
            BLog.e(TAG, "show loading dialog error, msg = " + e.getMessage());
        }
    }

    public void onGetLoginStatus(String code, Integer status) {
        Intrinsics.checkNotNullParameter(code, LoginReporterV2.Show.SIGNUP_KEY_CODE);
        HashMap $this$onGetLoginStatus_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps(LoginReporterV2.Show.SIGNUP_KEY_CODE, code);
        String str = this.mPromptScene;
        if (str == null) {
            str = "";
        }
        $this$onGetLoginStatus_u24lambda_u240.put("refer_click", str);
        if (status != null) {
            int it = status.intValue();
            $this$onGetLoginStatus_u24lambda_u240.put("login_status", String.valueOf(it));
        }
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_SMS_LOGIN_GETSTATUS_2_SHOW, $this$onGetLoginStatus_u24lambda_u240);
    }
}