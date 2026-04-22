package tv.danmaku.bili.eula;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.accountui.R;
import com.bilibili.app.accountui.databinding.BiliAppDialogEulaBinding;
import com.bilibili.app.accountui.databinding.BiliAppDialogLoginEulaBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: LoginEulaDialog.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016Jd\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010#\u001a\u00020$J|\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010&2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010'\u001a\u00020(Jh\u0010\u0013\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010&2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\n¨\u0006/"}, d2 = {"Ltv/danmaku/bili/eula/LoginEulaDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "delegate", "Ltv/danmaku/bili/normal/ui/LoginEulaDialogViewDelegate;", "value", "Lcom/bilibili/app/accountui/databinding/BiliAppDialogEulaBinding;", "binding", "setBinding", "(Lcom/bilibili/app/accountui/databinding/BiliAppDialogEulaBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", ReportEvent.EVENT_TYPE_SHOW, "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "pageType", "", "isPhoneLogin", "", "triggerType", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "triggerButtonId", "", "ispCode", "onPositiveClick", "Lkotlin/Function0;", "onNegativeClick", "linkClickLinkItemListener", "Ltv/danmaku/bili/ui/AgreementLinkHelper$ClickLinkItemListener;", "extraParams", "", "eulaItemListener", "Ltv/danmaku/bili/eula/EulaLinkItemListener;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;ZLtv/danmaku/bili/normal/ui/EulaTriggerType;ILjava/util/Map;Ljava/lang/String;Ltv/danmaku/bili/ui/AgreementLinkHelper$ClickLinkItemListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitView", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroyView", "warpListener", "itemListener", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginEulaDialog extends DialogFragment {
    public static final int $stable = 8;
    private BiliAppDialogEulaBinding binding;
    private LoginEulaDialogViewDelegate delegate;

    private final void setBinding(BiliAppDialogEulaBinding value) {
        LoginEulaDialogViewDelegate loginEulaDialogViewDelegate;
        this.binding = value;
        if (value != null) {
            BiliAppDialogLoginEulaBinding biliAppDialogLoginEulaBinding = value.eulaGroup;
            Intrinsics.checkNotNullExpressionValue(biliAppDialogLoginEulaBinding, "eulaGroup");
            loginEulaDialogViewDelegate = new LoginEulaDialogViewDelegate(biliAppDialogLoginEulaBinding);
        } else {
            loginEulaDialogViewDelegate = null;
        }
        this.delegate = loginEulaDialogViewDelegate;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BiliAppDialogEulaBinding it = BiliAppDialogEulaBinding.inflate(inflater, container, false);
        setBinding(it);
        FrameLayout root = it.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "let(...)");
        return root;
    }

    public static /* synthetic */ void show$default(LoginEulaDialog loginEulaDialog, FragmentManager fragmentManager, String str, boolean z, EulaTriggerType eulaTriggerType, int i, String str2, Function0 function0, Function0 function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener, int i2, Object obj) {
        boolean z2 = (i2 & 4) != 0 ? false : z;
        EulaTriggerType eulaTriggerType2 = (i2 & 8) != 0 ? EulaTriggerType.Submit : eulaTriggerType;
        loginEulaDialog.show(fragmentManager, str, z2, eulaTriggerType2, (i2 & 16) != 0 ? eulaTriggerType2.getBtnId() : i, (i2 & 32) != 0 ? null : str2, function0, function02, clickLinkItemListener);
    }

    public final void show(FragmentManager fragmentManager, String pageType, boolean isPhoneLogin, EulaTriggerType triggerType, int triggerButtonId, String ispCode, Function0<Unit> function0, Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener linkClickLinkItemListener) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(linkClickLinkItemListener, "linkClickLinkItemListener");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new LoginEulaDialog$show$1(this, fragmentManager, pageType, isPhoneLogin, triggerType, triggerButtonId, ispCode, linkClickLinkItemListener, function0, function02, null), 3, (Object) null);
    }

    public static /* synthetic */ void show$default(LoginEulaDialog loginEulaDialog, FragmentManager fragmentManager, String str, boolean z, EulaTriggerType eulaTriggerType, int i, Map map, String str2, Function0 function0, Function0 function02, EulaLinkItemListener eulaLinkItemListener, int i2, Object obj) {
        boolean z2 = (i2 & 4) != 0 ? false : z;
        EulaTriggerType eulaTriggerType2 = (i2 & 8) != 0 ? EulaTriggerType.Submit : eulaTriggerType;
        loginEulaDialog.show(fragmentManager, str, z2, eulaTriggerType2, (i2 & 16) != 0 ? eulaTriggerType2.getBtnId() : i, (i2 & 32) != 0 ? null : map, (i2 & 64) != 0 ? null : str2, function0, function02, eulaLinkItemListener);
    }

    public final void show(FragmentManager fragmentManager, String pageType, boolean isPhoneLogin, EulaTriggerType triggerType, int triggerButtonId, Map<String, String> map, String ispCode, Function0<Unit> function0, Function0<Unit> function02, EulaLinkItemListener eulaItemListener) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(eulaItemListener, "eulaItemListener");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new LoginEulaDialog$show$2(this, fragmentManager, pageType, isPhoneLogin, triggerType, triggerButtonId, map, ispCode, eulaItemListener, function0, function02, null), 3, (Object) null);
    }

    public static /* synthetic */ Object show$default(LoginEulaDialog loginEulaDialog, FragmentManager fragmentManager, String str, boolean z, EulaTriggerType eulaTriggerType, int i, Map map, String str2, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener, Continuation continuation, int i2, Object obj) {
        boolean z2 = (i2 & 4) != 0 ? false : z;
        EulaTriggerType eulaTriggerType2 = (i2 & 8) != 0 ? EulaTriggerType.Submit : eulaTriggerType;
        return loginEulaDialog.show(fragmentManager, str, z2, eulaTriggerType2, (i2 & 16) != 0 ? eulaTriggerType2.getBtnId() : i, (i2 & 32) != 0 ? null : map, (i2 & 64) != 0 ? null : str2, clickLinkItemListener, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object show(FragmentManager fragmentManager, String str, boolean isPhoneLogin, EulaTriggerType triggerType, int i, Map<String, String> map, String ispCode, AgreementLinkHelper.ClickLinkItemListener linkClickLinkItemListener, Continuation<? super Boolean> continuation) {
        LoginEulaDialog$show$3 loginEulaDialog$show$3;
        LoginEulaDialog$show$3 loginEulaDialog$show$32;
        String pageType;
        int triggerButtonId;
        boolean z;
        AgreementLinkHelper.ClickLinkItemListener linkClickLinkItemListener2;
        boolean isPhoneLogin2;
        Map extraParams;
        EulaTriggerType triggerType2;
        String ispCode2;
        LoginEulaDialog loginEulaDialog;
        LoginEulaDialogViewDelegate loginEulaDialogViewDelegate;
        boolean z2;
        Object show;
        LoginEulaDialog loginEulaDialog2;
        Throwable th;
        if (continuation instanceof LoginEulaDialog$show$3) {
            loginEulaDialog$show$3 = (LoginEulaDialog$show$3) continuation;
            if ((loginEulaDialog$show$3.label & Integer.MIN_VALUE) != 0) {
                loginEulaDialog$show$3.label -= Integer.MIN_VALUE;
                loginEulaDialog$show$32 = loginEulaDialog$show$3;
                Object $result = loginEulaDialog$show$32.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginEulaDialog$show$32.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        pageType = str;
                        triggerButtonId = i;
                        setStyle(2, R.style.Login_Sms_Dialog_Eula);
                        show(fragmentManager, "LoginEulaDialog");
                        loginEulaDialog$show$32.L$0 = pageType;
                        loginEulaDialog$show$32.L$1 = triggerType;
                        loginEulaDialog$show$32.L$2 = map;
                        loginEulaDialog$show$32.L$3 = ispCode;
                        loginEulaDialog$show$32.L$4 = linkClickLinkItemListener;
                        loginEulaDialog$show$32.Z$0 = isPhoneLogin;
                        loginEulaDialog$show$32.I$0 = triggerButtonId;
                        z = true;
                        loginEulaDialog$show$32.label = 1;
                        if (waitView(loginEulaDialog$show$32) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        linkClickLinkItemListener2 = linkClickLinkItemListener;
                        isPhoneLogin2 = isPhoneLogin;
                        extraParams = map;
                        triggerType2 = triggerType;
                        ispCode2 = ispCode;
                        loginEulaDialog = this;
                        try {
                            loginEulaDialogViewDelegate = loginEulaDialog.delegate;
                            if (loginEulaDialogViewDelegate != null) {
                                z2 = isPhoneLogin2 ? z : false;
                                loginEulaDialog$show$32.L$0 = null;
                                loginEulaDialog$show$32.L$1 = null;
                                loginEulaDialog$show$32.L$2 = null;
                                loginEulaDialog$show$32.L$3 = null;
                                loginEulaDialog$show$32.L$4 = null;
                                loginEulaDialog$show$32.label = 2;
                                show = loginEulaDialogViewDelegate.show(pageType, z2, triggerType2, triggerButtonId, (Map<String, String>) extraParams, ispCode2, linkClickLinkItemListener2, (Continuation<? super Boolean>) loginEulaDialog$show$32);
                                if (show == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                z2 = ((Boolean) show).booleanValue();
                            }
                            loginEulaDialog.dismiss();
                            return Boxing.boxBoolean(z2);
                        } catch (Throwable th2) {
                            th = th2;
                            loginEulaDialog2 = loginEulaDialog;
                            loginEulaDialog2.dismiss();
                            throw th;
                        }
                    case 1:
                        int triggerButtonId2 = loginEulaDialog$show$32.I$0;
                        isPhoneLogin2 = loginEulaDialog$show$32.Z$0;
                        Map extraParams2 = (Map) loginEulaDialog$show$32.L$2;
                        ResultKt.throwOnFailure($result);
                        triggerButtonId = triggerButtonId2;
                        linkClickLinkItemListener2 = (AgreementLinkHelper.ClickLinkItemListener) loginEulaDialog$show$32.L$4;
                        ispCode2 = (String) loginEulaDialog$show$32.L$3;
                        extraParams = extraParams2;
                        triggerType2 = (EulaTriggerType) loginEulaDialog$show$32.L$1;
                        pageType = (String) loginEulaDialog$show$32.L$0;
                        z = true;
                        loginEulaDialog = this;
                        loginEulaDialogViewDelegate = loginEulaDialog.delegate;
                        if (loginEulaDialogViewDelegate != null) {
                        }
                        loginEulaDialog.dismiss();
                        return Boxing.boxBoolean(z2);
                    case 2:
                        loginEulaDialog2 = this;
                        try {
                            ResultKt.throwOnFailure($result);
                            loginEulaDialog = loginEulaDialog2;
                            show = $result;
                            z2 = ((Boolean) show).booleanValue();
                            loginEulaDialog.dismiss();
                            return Boxing.boxBoolean(z2);
                        } catch (Throwable th3) {
                            th = th3;
                            loginEulaDialog2.dismiss();
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        loginEulaDialog$show$3 = new LoginEulaDialog$show$3(this, continuation);
        loginEulaDialog$show$32 = loginEulaDialog$show$3;
        Object $result2 = loginEulaDialog$show$32.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginEulaDialog$show$32.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitView(Continuation<? super Unit> continuation) {
        LoginEulaDialog$waitView$1 loginEulaDialog$waitView$1;
        Object coroutine_suspended;
        LoginEulaDialog loginEulaDialog;
        if (continuation instanceof LoginEulaDialog$waitView$1) {
            loginEulaDialog$waitView$1 = (LoginEulaDialog$waitView$1) continuation;
            if ((loginEulaDialog$waitView$1.label & Integer.MIN_VALUE) != 0) {
                loginEulaDialog$waitView$1.label -= Integer.MIN_VALUE;
                Object $result = loginEulaDialog$waitView$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginEulaDialog$waitView$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loginEulaDialog = this;
                        break;
                    case 1:
                        loginEulaDialog = this;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (loginEulaDialog.delegate == null && JobKt.isActive(loginEulaDialog$waitView$1.getContext())) {
                    loginEulaDialog$waitView$1.label = 1;
                    if (HandlerDispatcherKt.awaitFrame(loginEulaDialog$waitView$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        loginEulaDialog$waitView$1 = new LoginEulaDialog$waitView$1(this, continuation);
        Object $result2 = loginEulaDialog$waitView$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginEulaDialog$waitView$1.label) {
        }
        while (loginEulaDialog.delegate == null) {
            loginEulaDialog$waitView$1.label = 1;
            if (HandlerDispatcherKt.awaitFrame(loginEulaDialog$waitView$1) == coroutine_suspended) {
            }
        }
        return Unit.INSTANCE;
    }

    public void onDestroyView() {
        super.onDestroyView();
        setBinding(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AgreementLinkHelper.ClickLinkItemListener warpListener(final EulaLinkItemListener itemListener) {
        return new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.eula.LoginEulaDialog$$ExternalSyntheticLambda0
            @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
            public final void onItemLinkClick(int i) {
                LoginEulaDialog.warpListener$lambda$0(EulaLinkItemListener.this, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warpListener$lambda$0(EulaLinkItemListener $itemListener, int it) {
        EulaLinkType.Help help;
        switch (it) {
            case 1:
                help = new EulaLinkType.Help("");
                break;
            case 2:
                help = new EulaLinkType.Agreement("");
                break;
            case 3:
                help = new EulaLinkType.Privacy("");
                break;
            case 4:
                help = new EulaLinkType.IspAgreement("");
                break;
            default:
                help = new EulaLinkType.Help("");
                break;
        }
        EulaLinkType type = help;
        $itemListener.onItemLinkClick(type);
    }
}