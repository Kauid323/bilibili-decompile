package tv.danmaku.bili.core.test;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import bolts.Task;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.fd_service.active.FreeDataActivator;
import com.bilibili.fd_service.isp.FdIspManager;
import com.bilibili.fd_service.utils.AssertUtil;
import com.bilibili.fd_service.utils.LogPrinter;
import com.bilibili.freedata.debug.FdErrorMockManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.lib.tf.TfActivateStatus;
import com.bilibili.lib.tf.TfProvider;
import com.bilibili.lib.tf.TfQueryResp;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.TfType;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.lib.tf.TfWay;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.moduleservice.freedata.FreedataDemiwareService;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;

/* compiled from: FdDebugActivity.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0084\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010hH\u0014J\u0010\u0010i\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010m\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010n\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010o\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010p\u001a\u00020f2\u0006\u0010q\u001a\u00020rH\u0002J\u0010\u0010s\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010t\u001a\u00020f2\u0006\u0010j\u001a\u00020kH\u0002J\b\u0010u\u001a\u00020fH\u0002J\b\u0010v\u001a\u00020fH\u0002J\b\u0010w\u001a\u00020fH\u0003J\u0018\u0010x\u001a\u00020f2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020rH\u0016J\u0018\u0010|\u001a\u00020f2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020rH\u0002J\u0018\u0010}\u001a\u00020f2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020rH\u0002J\b\u0010~\u001a\u00020fH\u0002J\b\u0010\u007f\u001a\u00020fH\u0003J\u0014\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\tR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\u0015R\u001b\u0010 \u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b!\u0010\u0015R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b.\u0010+R\u001b\u00100\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b1\u0010\u0015R\u001b\u00103\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b4\u0010\u0015R\u001b\u00106\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b7\u0010\u0015R\u001b\u00109\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b:\u0010\u0015R\u001b\u0010<\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000b\u001a\u0004\b=\u0010\u0015R\u001b\u0010?\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\b@\u0010\u0015R\u001b\u0010B\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bC\u0010\u0015R\u001b\u0010E\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bF\u0010\u0015R\u001b\u0010H\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u000b\u001a\u0004\bI\u0010+R\u001b\u0010K\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u000b\u001a\u0004\bL\u0010+R\u001b\u0010N\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u000b\u001a\u0004\bO\u0010\u0015R\u001b\u0010Q\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bR\u0010\u0015R\u001b\u0010T\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u000b\u001a\u0004\bV\u0010WR\u001b\u0010Y\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u000b\u001a\u0004\b[\u0010\\R\u000e\u0010^\u001a\u00020_X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u000b\u001a\u0004\bb\u0010c¨\u0006\u0085\u0001"}, d2 = {"Ltv/danmaku/bili/core/test/FdDebugActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "<init>", "()V", "mTvNetState", "Landroid/widget/TextView;", "getMTvNetState", "()Landroid/widget/TextView;", "mTvNetState$delegate", "Lkotlin/Lazy;", "mTvActiveState", "getMTvActiveState", "mTvActiveState$delegate", "mTvSimOpt", "getMTvSimOpt", "mTvSimOpt$delegate", "btnActiveMobile", "Landroid/widget/Button;", "getBtnActiveMobile", "()Landroid/widget/Button;", "btnActiveMobile$delegate", "btnActiveTelecom", "getBtnActiveTelecom", "btnActiveTelecom$delegate", "btnActiveUnicomPkg", "getBtnActiveUnicomPkg", "btnActiveUnicomPkg$delegate", "btnActiveUnicomCard", "getBtnActiveUnicomCard", "btnActiveUnicomCard$delegate", "btnMockUrlProcess", "getBtnMockUrlProcess", "btnMockUrlProcess$delegate", "mEtErrorCode", "Landroid/widget/EditText;", "getMEtErrorCode", "()Landroid/widget/EditText;", "mEtErrorCode$delegate", "mSwitchError", "Landroid/widget/Switch;", "getMSwitchError", "()Landroid/widget/Switch;", "mSwitchError$delegate", "mSwitchCloseActiveWhenNetChange", "getMSwitchCloseActiveWhenNetChange", "mSwitchCloseActiveWhenNetChange$delegate", "btnPrintStorageData", "getBtnPrintStorageData", "btnPrintStorageData$delegate", "btnClearStorageData", "getBtnClearStorageData", "btnClearStorageData$delegate", "btnIspTest", "getBtnIspTest", "btnIspTest$delegate", "btnFreeDataCondition", "getBtnFreeDataCondition", "btnFreeDataCondition$delegate", "btnTfRules", "getBtnTfRules", "btnTfRules$delegate", "btnSyncTelecom", "getBtnSyncTelecom", "btnSyncTelecom$delegate", "btnActiveUnicomDemiwarePkg", "getBtnActiveUnicomDemiwarePkg", "btnActiveUnicomDemiwarePkg$delegate", "btnPrintUnicomDemiwarePkg", "getBtnPrintUnicomDemiwarePkg", "btnPrintUnicomDemiwarePkg$delegate", "switchFreeData", "getSwitchFreeData", "switchFreeData$delegate", "switchSyncSataWhenNetChange", "getSwitchSyncSataWhenNetChange", "switchSyncSataWhenNetChange$delegate", "autoActiveCUForce", "getAutoActiveCUForce", "autoActiveCUForce$delegate", "autoActiveCMForce", "getAutoActiveCMForce", "autoActiveCMForce$delegate", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "mProgressDialog", "Landroid/app/ProgressDialog;", "getMProgressDialog", "()Landroid/app/ProgressDialog;", "mProgressDialog$delegate", "tfProvider", "Lcom/bilibili/lib/tf/TfProvider;", "validity", "", "getValidity", "()J", "validity$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "printUnicomDemiwarePkg", "v", "Landroid/view/View;", "autoActiveForceCu", "autoActiveForceCm", "activeUnicomDemiwarePkg", "syncTelecom", "setSyncStateSwitchChecked", "check", "", "onClick", "printStorage", "showProgressDialog", "hideProgressDialog", ReportUtilKt.POS_UPDATE, "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "closeSyncWhenNetChange", "closeActiveWhenNetChange", "updateSyncSwitch", "mockUrlProcess", "getType", "Lcom/bilibili/fd_service/FreeDataManager$ResType;", "type", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FdDebugActivity extends BaseAppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String TAG = "tf.FdDebugActivity";
    public static final long UPDATE_DELAY_TIME = 2000;
    private TfProvider tfProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy mTvNetState$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda6
        public final Object invoke() {
            TextView mTvNetState_delegate$lambda$0;
            mTvNetState_delegate$lambda$0 = FdDebugActivity.mTvNetState_delegate$lambda$0(FdDebugActivity.this);
            return mTvNetState_delegate$lambda$0;
        }
    });
    private final Lazy mTvActiveState$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda18
        public final Object invoke() {
            TextView mTvActiveState_delegate$lambda$0;
            mTvActiveState_delegate$lambda$0 = FdDebugActivity.mTvActiveState_delegate$lambda$0(FdDebugActivity.this);
            return mTvActiveState_delegate$lambda$0;
        }
    });
    private final Lazy mTvSimOpt$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda26
        public final Object invoke() {
            TextView mTvSimOpt_delegate$lambda$0;
            mTvSimOpt_delegate$lambda$0 = FdDebugActivity.mTvSimOpt_delegate$lambda$0(FdDebugActivity.this);
            return mTvSimOpt_delegate$lambda$0;
        }
    });
    private final Lazy btnActiveMobile$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda27
        public final Object invoke() {
            Button btnActiveMobile_delegate$lambda$0;
            btnActiveMobile_delegate$lambda$0 = FdDebugActivity.btnActiveMobile_delegate$lambda$0(FdDebugActivity.this);
            return btnActiveMobile_delegate$lambda$0;
        }
    });
    private final Lazy btnActiveTelecom$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda28
        public final Object invoke() {
            Button btnActiveTelecom_delegate$lambda$0;
            btnActiveTelecom_delegate$lambda$0 = FdDebugActivity.btnActiveTelecom_delegate$lambda$0(FdDebugActivity.this);
            return btnActiveTelecom_delegate$lambda$0;
        }
    });
    private final Lazy btnActiveUnicomPkg$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda29
        public final Object invoke() {
            Button btnActiveUnicomPkg_delegate$lambda$0;
            btnActiveUnicomPkg_delegate$lambda$0 = FdDebugActivity.btnActiveUnicomPkg_delegate$lambda$0(FdDebugActivity.this);
            return btnActiveUnicomPkg_delegate$lambda$0;
        }
    });
    private final Lazy btnActiveUnicomCard$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda30
        public final Object invoke() {
            Button btnActiveUnicomCard_delegate$lambda$0;
            btnActiveUnicomCard_delegate$lambda$0 = FdDebugActivity.btnActiveUnicomCard_delegate$lambda$0(FdDebugActivity.this);
            return btnActiveUnicomCard_delegate$lambda$0;
        }
    });
    private final Lazy btnMockUrlProcess$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda31
        public final Object invoke() {
            Button btnMockUrlProcess_delegate$lambda$0;
            btnMockUrlProcess_delegate$lambda$0 = FdDebugActivity.btnMockUrlProcess_delegate$lambda$0(FdDebugActivity.this);
            return btnMockUrlProcess_delegate$lambda$0;
        }
    });
    private final Lazy mEtErrorCode$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda32
        public final Object invoke() {
            EditText mEtErrorCode_delegate$lambda$0;
            mEtErrorCode_delegate$lambda$0 = FdDebugActivity.mEtErrorCode_delegate$lambda$0(FdDebugActivity.this);
            return mEtErrorCode_delegate$lambda$0;
        }
    });
    private final Lazy mSwitchError$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda34
        public final Object invoke() {
            Switch mSwitchError_delegate$lambda$0;
            mSwitchError_delegate$lambda$0 = FdDebugActivity.mSwitchError_delegate$lambda$0(FdDebugActivity.this);
            return mSwitchError_delegate$lambda$0;
        }
    });
    private final Lazy mSwitchCloseActiveWhenNetChange$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda7
        public final Object invoke() {
            Switch mSwitchCloseActiveWhenNetChange_delegate$lambda$0;
            mSwitchCloseActiveWhenNetChange_delegate$lambda$0 = FdDebugActivity.mSwitchCloseActiveWhenNetChange_delegate$lambda$0(FdDebugActivity.this);
            return mSwitchCloseActiveWhenNetChange_delegate$lambda$0;
        }
    });
    private final Lazy btnPrintStorageData$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda8
        public final Object invoke() {
            Button btnPrintStorageData_delegate$lambda$0;
            btnPrintStorageData_delegate$lambda$0 = FdDebugActivity.btnPrintStorageData_delegate$lambda$0(FdDebugActivity.this);
            return btnPrintStorageData_delegate$lambda$0;
        }
    });
    private final Lazy btnClearStorageData$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda9
        public final Object invoke() {
            Button btnClearStorageData_delegate$lambda$0;
            btnClearStorageData_delegate$lambda$0 = FdDebugActivity.btnClearStorageData_delegate$lambda$0(FdDebugActivity.this);
            return btnClearStorageData_delegate$lambda$0;
        }
    });
    private final Lazy btnIspTest$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda10
        public final Object invoke() {
            Button btnIspTest_delegate$lambda$0;
            btnIspTest_delegate$lambda$0 = FdDebugActivity.btnIspTest_delegate$lambda$0(FdDebugActivity.this);
            return btnIspTest_delegate$lambda$0;
        }
    });
    private final Lazy btnFreeDataCondition$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda12
        public final Object invoke() {
            Button btnFreeDataCondition_delegate$lambda$0;
            btnFreeDataCondition_delegate$lambda$0 = FdDebugActivity.btnFreeDataCondition_delegate$lambda$0(FdDebugActivity.this);
            return btnFreeDataCondition_delegate$lambda$0;
        }
    });
    private final Lazy btnTfRules$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda13
        public final Object invoke() {
            Button btnTfRules_delegate$lambda$0;
            btnTfRules_delegate$lambda$0 = FdDebugActivity.btnTfRules_delegate$lambda$0(FdDebugActivity.this);
            return btnTfRules_delegate$lambda$0;
        }
    });
    private final Lazy btnSyncTelecom$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda14
        public final Object invoke() {
            Button btnSyncTelecom_delegate$lambda$0;
            btnSyncTelecom_delegate$lambda$0 = FdDebugActivity.btnSyncTelecom_delegate$lambda$0(FdDebugActivity.this);
            return btnSyncTelecom_delegate$lambda$0;
        }
    });
    private final Lazy btnActiveUnicomDemiwarePkg$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda15
        public final Object invoke() {
            Button btnActiveUnicomDemiwarePkg_delegate$lambda$0;
            btnActiveUnicomDemiwarePkg_delegate$lambda$0 = FdDebugActivity.btnActiveUnicomDemiwarePkg_delegate$lambda$0(FdDebugActivity.this);
            return btnActiveUnicomDemiwarePkg_delegate$lambda$0;
        }
    });
    private final Lazy btnPrintUnicomDemiwarePkg$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda16
        public final Object invoke() {
            Button btnPrintUnicomDemiwarePkg_delegate$lambda$0;
            btnPrintUnicomDemiwarePkg_delegate$lambda$0 = FdDebugActivity.btnPrintUnicomDemiwarePkg_delegate$lambda$0(FdDebugActivity.this);
            return btnPrintUnicomDemiwarePkg_delegate$lambda$0;
        }
    });
    private final Lazy switchFreeData$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda17
        public final Object invoke() {
            Switch switchFreeData_delegate$lambda$0;
            switchFreeData_delegate$lambda$0 = FdDebugActivity.switchFreeData_delegate$lambda$0(FdDebugActivity.this);
            return switchFreeData_delegate$lambda$0;
        }
    });
    private final Lazy switchSyncSataWhenNetChange$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda19
        public final Object invoke() {
            Switch switchSyncSataWhenNetChange_delegate$lambda$0;
            switchSyncSataWhenNetChange_delegate$lambda$0 = FdDebugActivity.switchSyncSataWhenNetChange_delegate$lambda$0(FdDebugActivity.this);
            return switchSyncSataWhenNetChange_delegate$lambda$0;
        }
    });
    private final Lazy autoActiveCUForce$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda20
        public final Object invoke() {
            Button autoActiveCUForce_delegate$lambda$0;
            autoActiveCUForce_delegate$lambda$0 = FdDebugActivity.autoActiveCUForce_delegate$lambda$0(FdDebugActivity.this);
            return autoActiveCUForce_delegate$lambda$0;
        }
    });
    private final Lazy autoActiveCMForce$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda21
        public final Object invoke() {
            Button autoActiveCMForce_delegate$lambda$0;
            autoActiveCMForce_delegate$lambda$0 = FdDebugActivity.autoActiveCMForce_delegate$lambda$0(FdDebugActivity.this);
            return autoActiveCMForce_delegate$lambda$0;
        }
    });
    private final Lazy mHandler$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda23
        public final Object invoke() {
            Handler mHandler_delegate$lambda$0;
            mHandler_delegate$lambda$0 = FdDebugActivity.mHandler_delegate$lambda$0(FdDebugActivity.this);
            return mHandler_delegate$lambda$0;
        }
    });
    private final Lazy mProgressDialog$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda24
        public final Object invoke() {
            ProgressDialog mProgressDialog_delegate$lambda$0;
            mProgressDialog_delegate$lambda$0 = FdDebugActivity.mProgressDialog_delegate$lambda$0(FdDebugActivity.this);
            return mProgressDialog_delegate$lambda$0;
        }
    });
    private final Lazy validity$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda25
        public final Object invoke() {
            long validity_delegate$lambda$0;
            validity_delegate$lambda$0 = FdDebugActivity.validity_delegate$lambda$0();
            return Long.valueOf(validity_delegate$lambda$0);
        }
    });

    /* compiled from: FdDebugActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TfProvider.values().length];
            try {
                iArr[TfProvider.UNICOM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TfProvider.MOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TfProvider.TELECOM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TfTypeExt.values().length];
            try {
                iArr2[TfTypeExt.U_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[TfTypeExt.U_PKG.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[TfTypeExt.T_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[TfTypeExt.T_PKG.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[TfTypeExt.C_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[TfTypeExt.C_PKG.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr2[TfTypeExt.NA_TYPE_EXT.ordinal()] = 7;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    private final TextView getMTvNetState() {
        Object value = this.mTvNetState$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvNetState_delegate$lambda$0(FdDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.tv_fd_net_state);
    }

    private final TextView getMTvActiveState() {
        Object value = this.mTvActiveState$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvActiveState_delegate$lambda$0(FdDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.tv_fd_active_state);
    }

    private final TextView getMTvSimOpt() {
        Object value = this.mTvSimOpt$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTvSimOpt_delegate$lambda$0(FdDebugActivity this$0) {
        return (TextView) this$0.findViewById(R.id.tv_fd_sim_opt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnActiveMobile_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_active_mobile);
    }

    private final Button getBtnActiveMobile() {
        Object value = this.btnActiveMobile$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnActiveTelecom_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_active_telecom);
    }

    private final Button getBtnActiveTelecom() {
        Object value = this.btnActiveTelecom$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnActiveUnicomPkg_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_active_unicom_pkg);
    }

    private final Button getBtnActiveUnicomPkg() {
        Object value = this.btnActiveUnicomPkg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnActiveUnicomCard_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_active_unicom_card);
    }

    private final Button getBtnActiveUnicomCard() {
        Object value = this.btnActiveUnicomCard$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnMockUrlProcess_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_mock_url_process);
    }

    private final Button getBtnMockUrlProcess() {
        Object value = this.btnMockUrlProcess$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    private final EditText getMEtErrorCode() {
        Object value = this.mEtErrorCode$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (EditText) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditText mEtErrorCode_delegate$lambda$0(FdDebugActivity this$0) {
        return (EditText) this$0.findViewById(R.id.ed_error_code);
    }

    private final Switch getMSwitchError() {
        Object value = this.mSwitchError$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch mSwitchError_delegate$lambda$0(FdDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.switch_error);
    }

    private final Switch getMSwitchCloseActiveWhenNetChange() {
        Object value = this.mSwitchCloseActiveWhenNetChange$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch mSwitchCloseActiveWhenNetChange_delegate$lambda$0(FdDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.switch_close_active_when_net_change);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnPrintStorageData_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_print_storage_data);
    }

    private final Button getBtnPrintStorageData() {
        Object value = this.btnPrintStorageData$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnClearStorageData_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_clear_storage_data);
    }

    private final Button getBtnClearStorageData() {
        Object value = this.btnClearStorageData$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnIspTest_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_isp_test);
    }

    private final Button getBtnIspTest() {
        Object value = this.btnIspTest$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnFreeDataCondition_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_free_data_condition);
    }

    private final Button getBtnFreeDataCondition() {
        Object value = this.btnFreeDataCondition$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnTfRules_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_tf_rules);
    }

    private final Button getBtnTfRules() {
        Object value = this.btnTfRules$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnSyncTelecom_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_sync_telecom);
    }

    private final Button getBtnSyncTelecom() {
        Object value = this.btnSyncTelecom$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnActiveUnicomDemiwarePkg_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_active_unicom_pkg_demiware);
    }

    private final Button getBtnActiveUnicomDemiwarePkg() {
        Object value = this.btnActiveUnicomDemiwarePkg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button btnPrintUnicomDemiwarePkg_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_print_unicom_pkg_demiware);
    }

    private final Button getBtnPrintUnicomDemiwarePkg() {
        Object value = this.btnPrintUnicomDemiwarePkg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    private final Switch getSwitchFreeData() {
        Object value = this.switchFreeData$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch switchFreeData_delegate$lambda$0(FdDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.switch_free_data);
    }

    private final Switch getSwitchSyncSataWhenNetChange() {
        Object value = this.switchSyncSataWhenNetChange$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Switch) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Switch switchSyncSataWhenNetChange_delegate$lambda$0(FdDebugActivity this$0) {
        return (Switch) this$0.findViewById(R.id.switch_close_sync_when_net_change);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button autoActiveCUForce_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_auto_active_cu_force);
    }

    private final Button getAutoActiveCUForce() {
        Object value = this.autoActiveCUForce$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Button autoActiveCMForce_delegate$lambda$0(FdDebugActivity this$0) {
        return (Button) this$0.findViewById(R.id.btn_auto_active_cm_force);
    }

    private final Button getAutoActiveCMForce() {
        Object value = this.autoActiveCMForce$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mHandler_delegate$lambda$0(final FdDebugActivity this$0) {
        return new Handler(this$0.getMainLooper(), new Handler.Callback() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda35
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean mHandler_delegate$lambda$0$0;
                mHandler_delegate$lambda$0$0 = FdDebugActivity.mHandler_delegate$lambda$0$0(FdDebugActivity.this, message);
                return mHandler_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mHandler_delegate$lambda$0$0(FdDebugActivity this$0, Message it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.update();
        this$0.hideProgressDialog();
        return false;
    }

    private final ProgressDialog getMProgressDialog() {
        return (ProgressDialog) this.mProgressDialog$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressDialog mProgressDialog_delegate$lambda$0(FdDebugActivity this$0) {
        return new ProgressDialog((Context) this$0);
    }

    private final long getValidity() {
        return ((Number) this.validity$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long validity_delegate$lambda$0() {
        int hours = BR.displayingBanner;
        try {
            String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "freedata.free_hours", (Object) null, 2, (Object) null);
            if (str != null) {
                hours = Integer.parseInt(str);
            }
        } catch (Exception e) {
        }
        LogPrinter.i(TAG, "freedata.free_hours = " + hours);
        return hours * 60 * 60 * 1000;
    }

    /* compiled from: FdDebugActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/core/test/FdDebugActivity$Companion;", "", "<init>", "()V", "TAG", "", "UPDATE_DELAY_TIME", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freedata_activity_debug);
        getMEtErrorCode().setVisibility(8);
        getBtnActiveMobile().setOnClickListener(this);
        getBtnActiveTelecom().setOnClickListener(this);
        getBtnActiveUnicomPkg().setOnClickListener(this);
        getBtnActiveUnicomCard().setOnClickListener(this);
        getBtnMockUrlProcess().setOnClickListener(this);
        getBtnPrintStorageData().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FdDebugActivity.this.printStorage(view);
            }
        });
        getBtnClearStorageData().setOnClickListener(this);
        getBtnIspTest().setOnClickListener(this);
        getBtnFreeDataCondition().setOnClickListener(this);
        getBtnTfRules().setOnClickListener(this);
        getBtnSyncTelecom().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FdDebugActivity.this.syncTelecom(view);
            }
        });
        getAutoActiveCUForce().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FdDebugActivity.this.autoActiveForceCu(view);
            }
        });
        getAutoActiveCMForce().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FdDebugActivity.this.autoActiveForceCm(view);
            }
        });
        getBtnActiveUnicomDemiwarePkg().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FdDebugActivity.this.activeUnicomDemiwarePkg(view);
            }
        });
        getBtnPrintUnicomDemiwarePkg().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FdDebugActivity.this.printUnicomDemiwarePkg(view);
            }
        });
        findViewById(R.id.btn_enter).setOnClickListener(this);
        getMSwitchError().setOnCheckedChangeListener(this);
        getSwitchSyncSataWhenNetChange().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda41
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FdDebugActivity.this.closeSyncWhenNetChange(compoundButton, z);
            }
        });
        getMSwitchCloseActiveWhenNetChange().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FdDebugActivity.this.closeActiveWhenNetChange(compoundButton, z);
            }
        });
        getSwitchFreeData().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FdDebugActivity.onCreate$lambda$0(FdDebugActivity.this, compoundButton, z);
            }
        });
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(FdDebugActivity this$0, CompoundButton buttonView, boolean isChecked) {
        TfProvider provider = FdIspManager.getInstance().getProvider((Context) this$0);
        Intrinsics.checkNotNullExpressionValue(provider, "getProvider(...)");
        this$0.tfProvider = provider;
        FreeDataManager freeDataManager = FreeDataManager.getInstance();
        TfProvider tfProvider = this$0.tfProvider;
        if (tfProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tfProvider");
            tfProvider = null;
        }
        freeDataManager.setServiceSwitchStatus(tfProvider, isChecked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printUnicomDemiwarePkg(View v) {
        Log.i(TAG, FreeDataManager.getInstance().checkDemiwareCondition().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoActiveForceCu(View v) {
        setSyncStateSwitchChecked(true);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit autoActiveForceCu$lambda$0;
                autoActiveForceCu$lambda$0 = FdDebugActivity.autoActiveForceCu$lambda$0();
                return autoActiveForceCu$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit autoActiveForceCu$lambda$0() {
        FreeDataActivator.Companion.get().activateUser(AppConfig.HOST_UNICOM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoActiveForceCm(View v) {
        setSyncStateSwitchChecked(true);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit autoActiveForceCm$lambda$0;
                autoActiveForceCm$lambda$0 = FdDebugActivity.autoActiveForceCm$lambda$0();
                return autoActiveForceCm$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit autoActiveForceCm$lambda$0() {
        FreeDataActivator.Companion.get().activateUser(NetworkUtilsKt.NETWORK_TYPE_MOBILE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void activeUnicomDemiwarePkg(View v) {
        TfActivateStatus oriStatus = FreeDataManager.getInstance().getCacheActivateStatus(TfProvider.UNICOM);
        String userMob = oriStatus != null ? oriStatus.getUserMob() : null;
        String fakeId = oriStatus != null ? oriStatus.getFakeId() : null;
        if (fakeId == null) {
            ToastHelper.showToast((Context) this, "免流激活失败，没有获取到fakeId", 0);
            return;
        }
        if (userMob == null) {
            userMob = fakeId;
        }
        TfActivateStatus build = TfActivateStatus.newBuilder().setProvider(TfProvider.UNICOM).setUserMob(userMob).setFakeId(fakeId).setProductId("81117").setWay(TfWay.UNICOM_CDN).setTypeExt(TfTypeExt.U_PKG).setType(TfType.PACKAGE).setProductDesc(getString(com.bilibili.fd_service.wrapper.R.string.main_core_unicom_demiware_desc)).build();
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type com.bilibili.lib.tf.TfActivateStatus");
        TfActivateStatus status = build;
        FreeDataManager.getInstance().activate(status, true);
        getMHandler().sendMessageDelayed(Message.obtain(), UPDATE_DELAY_TIME);
        try {
            FreedataDemiwareService bean = (FreedataDemiwareService) ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(FreedataDemiwareService.class), (String) null, 1, (Object) null);
            if (bean != null) {
                bean.callbackFreedataDemiwareActive();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncTelecom(View v) {
        setSyncStateSwitchChecked(true);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda22
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit syncTelecom$lambda$0;
                syncTelecom$lambda$0 = FdDebugActivity.syncTelecom$lambda$0();
                return syncTelecom$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncTelecom$lambda$0() {
        FreeDataActivator.Companion.get().activateUser("telecom");
        return Unit.INSTANCE;
    }

    private final void setSyncStateSwitchChecked(boolean check) {
        getSwitchSyncSataWhenNetChange().setChecked(check);
        closeSyncWhenNetChange(getSwitchSyncSataWhenNetChange(), check);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == R.id.btn_active_mobile) {
            TfActivateStatus build = TfActivateStatus.newBuilder().setProvider(TfProvider.MOBILE).setUserMob("123").setProductId("81137").setWay(TfWay.IP).setTypeExt(TfTypeExt.C_CARD).setType(TfType.CARD).setProductDesc("移动不知道什么卡").build();
            Intrinsics.checkNotNull(build, "null cannot be cast to non-null type com.bilibili.lib.tf.TfActivateStatus");
            TfActivateStatus status = build;
            FreeDataManager.getInstance().activate(status, false);
            getMHandler().sendMessageDelayed(Message.obtain(), UPDATE_DELAY_TIME);
            showProgressDialog();
        } else if (id == R.id.btn_active_telecom) {
            TfActivateStatus build2 = TfActivateStatus.newBuilder().setProvider(TfProvider.TELECOM).setUserMob("123").setProductId("81137").setWay(TfWay.IP).setTypeExt(TfTypeExt.T_CARD).setType(TfType.CARD).setProductDesc("电信不知道什么卡").build();
            Intrinsics.checkNotNull(build2, "null cannot be cast to non-null type com.bilibili.lib.tf.TfActivateStatus");
            TfActivateStatus status2 = build2;
            FreeDataManager.getInstance().activate(status2, false);
            getMHandler().sendMessageDelayed(Message.obtain(), UPDATE_DELAY_TIME);
            showProgressDialog();
        } else if (id == R.id.btn_active_unicom_card) {
            TfActivateStatus build3 = TfActivateStatus.newBuilder().setProvider(TfProvider.UNICOM).setUserMob("123").setProductId("81137").setWay(TfWay.IP).setTypeExt(TfTypeExt.U_CARD).setType(TfType.CARD).setProductDesc("联通不知道什么卡").build();
            Intrinsics.checkNotNull(build3, "null cannot be cast to non-null type com.bilibili.lib.tf.TfActivateStatus");
            TfActivateStatus status3 = build3;
            FreeDataManager.getInstance().activate(status3, false);
            getMHandler().sendMessageDelayed(Message.obtain(), UPDATE_DELAY_TIME);
            showProgressDialog();
        } else if (id == R.id.btn_active_unicom_pkg) {
            TfActivateStatus build4 = TfActivateStatus.newBuilder().setProvider(TfProvider.UNICOM).setUserMob("123456").setProductId("979").setWay(TfWay.UNICOM_CDN).setTypeExt(TfTypeExt.U_PKG).setType(TfType.PACKAGE).setProductDesc("15元包").build();
            Intrinsics.checkNotNull(build4, "null cannot be cast to non-null type com.bilibili.lib.tf.TfActivateStatus");
            TfActivateStatus status4 = build4;
            FreeDataManager.getInstance().activate(status4, false);
            getMHandler().sendMessageDelayed(Message.obtain(), UPDATE_DELAY_TIME);
            showProgressDialog();
        } else if (id == R.id.btn_enter) {
            try {
                FdErrorMockManager.INSTANCE.setDebug(getMSwitchError().isChecked());
                FdErrorMockManager fdErrorMockManager = FdErrorMockManager.INSTANCE;
                Integer valueOf = Integer.valueOf(getMEtErrorCode().getText().toString());
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                fdErrorMockManager.setErrorCode(valueOf.intValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (id == R.id.btn_mock_url_process) {
            mockUrlProcess();
        } else if (id == R.id.btn_clear_storage_data) {
            FreeDataManager.getInstance().clearActive();
        } else if (id == R.id.btn_isp_test) {
            String getIsp = FdIspManager.getInstance().getIsp((Context) this);
            LogPrinter.i(TAG, "getIsp " + getIsp);
            FdIspManager.getInstance().getIspAsync((Context) this, new FdIspManager.FdIspCallback() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda3
                public final void onIspResult(String str) {
                    FdDebugActivity.onClick$lambda$0(str);
                }
            });
            String localIsp = FdIspManager.getInstance().getIspFromLocal((Context) this);
            LogPrinter.i(TAG, "getIspFromLocal " + localIsp);
            FdIspManager.getInstance().getIspFromServer(new FdIspManager.FdIspCallback() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda4
                public final void onIspResult(String str) {
                    FdDebugActivity.onClick$lambda$1(str);
                }
            });
        } else if (id == R.id.btn_free_data_condition) {
            TfQueryResp freeDataCondition = FreeDataManager.getInstance().getFreeDataCondition();
            Intrinsics.checkNotNullExpressionValue(freeDataCondition, "getFreeDataCondition(...)");
            LogPrinter.i(TAG, freeDataCondition.toString());
        } else if (id == R.id.btn_tf_rules) {
            Uri parse = Uri.parse("bilibili://debugenv/freedata/tfrules");
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest routerRequest = new RouteRequest.Builder(parse).build();
            BLRouter.routeTo(routerRequest, (Context) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$0(String it) {
        LogPrinter.i(TAG, "getIspAsync " + it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$1(String it) {
        LogPrinter.i(TAG, "getIspFromServer " + it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printStorage(View v) {
        TfActivateStatus activateStatus = FreeDataManager.getInstance().getActivateStatus();
        if (activateStatus == null) {
            activateStatus = "null";
        }
        LogPrinter.i(TAG, "current Status:" + activateStatus);
        TfActivateStatus cacheActivateStatus = FreeDataManager.getInstance().getCacheActivateStatus(TfProvider.TELECOM);
        if (cacheActivateStatus == null) {
            cacheActivateStatus = "null";
        }
        LogPrinter.i(TAG, "TELECOM Status:" + cacheActivateStatus);
        TfActivateStatus cacheActivateStatus2 = FreeDataManager.getInstance().getCacheActivateStatus(TfProvider.UNICOM);
        if (cacheActivateStatus2 == null) {
            cacheActivateStatus2 = "null";
        }
        LogPrinter.i(TAG, "UNICOM Status:" + cacheActivateStatus2);
        String cacheActivateStatus3 = FreeDataManager.getInstance().getCacheActivateStatus(TfProvider.MOBILE);
        LogPrinter.i(TAG, "CMOBILE Status:" + ((Object) (cacheActivateStatus3 != null ? cacheActivateStatus3 : "null")));
        LogPrinter.i(TAG, "TELECOM two Status:" + FreeDataManager.getInstance().getActivateStatusString(TfProvider.TELECOM));
        LogPrinter.i(TAG, "UNICOM two Status:" + FreeDataManager.getInstance().getActivateStatusString(TfProvider.UNICOM));
        LogPrinter.i(TAG, "CMOBILE two Status:" + FreeDataManager.getInstance().getActivateStatusString(TfProvider.MOBILE));
    }

    private final void showProgressDialog() {
        if (!getMProgressDialog().isShowing()) {
            getMProgressDialog().show();
        }
    }

    private final void hideProgressDialog() {
        if (getMProgressDialog().isShowing()) {
            getMProgressDialog().dismiss();
        }
    }

    private final void update() {
        String str;
        String str2;
        TfQueryResp condition = FreeDataManager.getInstance().getFreeDataCondition();
        Intrinsics.checkNotNullExpressionValue(condition, "getFreeDataCondition(...)");
        String status = "not activated";
        if (condition.getIsValid()) {
            TfProvider provider = condition.getProvider();
            switch (provider == null ? -1 : WhenMappings.$EnumSwitchMapping$0[provider.ordinal()]) {
                case 1:
                    str2 = "unicom, activated";
                    break;
                case 2:
                    str2 = "mobile, activated";
                    break;
                case 3:
                    str2 = "telecom, activated";
                    break;
                default:
                    str2 = "not activated";
                    break;
            }
            status = str2;
        }
        getMTvActiveState().setText("Status: " + status);
        TextView mTvNetState = getMTvNetState();
        TfTypeExt typeExt = condition.getTypeExt();
        switch (typeExt != null ? WhenMappings.$EnumSwitchMapping$1[typeExt.ordinal()] : -1) {
            case 1:
                str = "unicom card";
                break;
            case 2:
                str = "unicom pkg";
                break;
            case 3:
                str = "telecom card";
                break;
            case 4:
                str = "telecom pkg";
                break;
            case 5:
                str = "mobile card";
                break;
            case 6:
                str = "mobile pkg";
                break;
            case 7:
                str = "not free data net";
                break;
            default:
                str = "unknow";
                break;
        }
        mTvNetState.setText("free data net ：" + str);
        TfProvider provider2 = FdIspManager.getInstance().getProvider((Context) this);
        Intrinsics.checkNotNullExpressionValue(provider2, "getProvider(...)");
        this.tfProvider = provider2;
        TextView mTvSimOpt = getMTvSimOpt();
        TfProvider tfProvider = this.tfProvider;
        if (tfProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tfProvider");
            tfProvider = null;
        }
        mTvSimOpt.setText("sim card: " + tfProvider.name());
        boolean isDebug = FdErrorMockManager.INSTANCE.isDebug();
        getMSwitchError().setChecked(isDebug);
        getMEtErrorCode().setVisibility(isDebug ? 0 : 8);
        if (isDebug) {
            getMEtErrorCode().setText(String.valueOf(FdErrorMockManager.INSTANCE.getErrorCode()));
        }
        getSwitchFreeData().setChecked(FreeDataManager.getInstance().getServiceSwitchStatus(condition.getTypeExt()));
        updateSyncSwitch();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        getMEtErrorCode().setVisibility(isChecked ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeSyncWhenNetChange(CompoundButton buttonView, boolean isChecked) {
        BiliGlobalPreferenceHelper.getInstance((Context) this).edit().putBoolean("debuge_freedata_sync_switch", isChecked).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeActiveWhenNetChange(CompoundButton buttonView, boolean isChecked) {
        BiliGlobalPreferenceHelper.getInstance((Context) this).edit().putBoolean("debuge_freedata_active_switch", isChecked).apply();
    }

    private final void updateSyncSwitch() {
        getSwitchSyncSataWhenNetChange().setChecked(BiliGlobalPreferenceHelper.getInstance((Context) this).optBoolean("debuge_freedata_sync_switch", false));
        getMSwitchCloseActiveWhenNetChange().setChecked(BiliGlobalPreferenceHelper.getInstance((Context) this).optBoolean("debuge_freedata_active_switch", false));
    }

    private final void mockUrlProcess() {
        new Thread(new Runnable() { // from class: tv.danmaku.bili.core.test.FdDebugActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FdDebugActivity.mockUrlProcess$lambda$0(FdDebugActivity.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mockUrlProcess$lambda$0(FdDebugActivity this$0) {
        String testUrlsString = AssertUtil.getFromAssets("test_url.json");
        JSONArray array = new JSONArray(testUrlsString);
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            String url = jsonObject.optString("url");
            FreeDataManager.ResType type = this$0.getType(jsonObject.optInt("type", 1));
            LogPrinter.i(TAG, "start processUrl = " + url);
            long start = System.currentTimeMillis();
            TfTransformResp result = FreeDataManager.getInstance().processUrl((Context) this$0, type, url);
            Intrinsics.checkNotNullExpressionValue(result, "processUrl(...)");
            long cost = System.currentTimeMillis() - start;
            LogPrinter.i(TAG, "processUrl cost = " + cost + "  result =\n " + result);
        }
    }

    private final FreeDataManager.ResType getType(int type) {
        switch (type) {
            case 1:
                return FreeDataManager.ResType.RES_FILE;
            case 2:
                return FreeDataManager.ResType.RES_VIDEO;
            case 3:
                return FreeDataManager.ResType.RES_MUSIC;
            case 4:
                return FreeDataManager.ResType.RES_DANMAKU;
            case 5:
                return FreeDataManager.ResType.RES_DANMASK;
            case 6:
                return FreeDataManager.ResType.RES_RTMP;
            default:
                return FreeDataManager.ResType.RES_FILE;
        }
    }
}