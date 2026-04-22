package tv.danmaku.bili.normal.ui;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import bili.resource.account.R;
import com.bilibili.app.accountui.databinding.BiliAppDialogLoginEulaBinding;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginIspHelper;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: LoginEulaDialogViewDelegate.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJv\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e2\u0006\u0010 \u001a\u00020!H\u0007J`\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/normal/ui/LoginEulaDialogViewDelegate;", "", "view", "Lcom/bilibili/app/accountui/databinding/BiliAppDialogLoginEulaBinding;", "<init>", "(Lcom/bilibili/app/accountui/databinding/BiliAppDialogLoginEulaBinding;)V", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "agreementLinkHelper", "Ltv/danmaku/bili/ui/AgreementLinkHelper;", "clicked", "", ReportEvent.EVENT_TYPE_SHOW, "", LoginReporterV2.PAGE_FROM_KEY, "", "isPhoneLogin", "triggerType", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "triggerButtonId", "", "extraParams", "", "ispCode", "onPositiveClick", "Lkotlin/Function0;", "onNegativeClick", "linkClickLinkItemListener", "Ltv/danmaku/bili/ui/AgreementLinkHelper$ClickLinkItemListener;", "(Ljava/lang/String;ZLtv/danmaku/bili/normal/ui/EulaTriggerType;ILjava/util/Map;Ljava/lang/String;Ltv/danmaku/bili/ui/AgreementLinkHelper$ClickLinkItemListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClickId", "getShowId", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginEulaDialogViewDelegate {
    public static final int $stable = 8;
    private final AgreementLinkHelper agreementLinkHelper;
    private boolean clicked;
    private final BiliAppDialogLoginEulaBinding view;

    public final void show(String str, Function0<Unit> function0, Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener) {
        Intrinsics.checkNotNullParameter(str, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(clickLinkItemListener, "linkClickLinkItemListener");
        show$default(this, str, false, null, 0, null, null, function0, function02, clickLinkItemListener, 62, null);
    }

    public final void show(String str, boolean z, Function0<Unit> function0, Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener) {
        Intrinsics.checkNotNullParameter(str, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(clickLinkItemListener, "linkClickLinkItemListener");
        show$default(this, str, z, null, 0, null, null, function0, function02, clickLinkItemListener, 60, null);
    }

    public final void show(String str, boolean z, EulaTriggerType eulaTriggerType, int i, Map<String, String> map, Function0<Unit> function0, Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener) {
        Intrinsics.checkNotNullParameter(str, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(eulaTriggerType, "triggerType");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(clickLinkItemListener, "linkClickLinkItemListener");
        show$default(this, str, z, eulaTriggerType, i, map, null, function0, function02, clickLinkItemListener, 32, null);
    }

    public final void show(String str, boolean z, EulaTriggerType eulaTriggerType, int i, Function0<Unit> function0, Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener) {
        Intrinsics.checkNotNullParameter(str, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(eulaTriggerType, "triggerType");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(clickLinkItemListener, "linkClickLinkItemListener");
        show$default(this, str, z, eulaTriggerType, i, null, null, function0, function02, clickLinkItemListener, 48, null);
    }

    public final void show(String str, boolean z, EulaTriggerType eulaTriggerType, Function0<Unit> function0, Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener) {
        Intrinsics.checkNotNullParameter(str, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(eulaTriggerType, "triggerType");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(clickLinkItemListener, "linkClickLinkItemListener");
        show$default(this, str, z, eulaTriggerType, 0, null, null, function0, function02, clickLinkItemListener, 56, null);
    }

    public LoginEulaDialogViewDelegate(BiliAppDialogLoginEulaBinding view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.agreementLinkHelper = new AgreementLinkHelper(getContext());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LoginEulaDialogViewDelegate(View v) {
        this(r0);
        Intrinsics.checkNotNullParameter(v, "v");
        BiliAppDialogLoginEulaBinding bind = BiliAppDialogLoginEulaBinding.bind(v);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
    }

    private final Context getContext() {
        Context context = this.view.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    public static /* synthetic */ void show$default(LoginEulaDialogViewDelegate loginEulaDialogViewDelegate, String str, boolean z, EulaTriggerType eulaTriggerType, int i, Map map, String str2, Function0 function0, Function0 function02, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener, int i2, Object obj) {
        boolean z2 = (i2 & 2) != 0 ? false : z;
        EulaTriggerType eulaTriggerType2 = (i2 & 4) != 0 ? EulaTriggerType.Submit : eulaTriggerType;
        loginEulaDialogViewDelegate.show(str, z2, eulaTriggerType2, (i2 & 8) != 0 ? eulaTriggerType2.getBtnId() : i, (i2 & 16) != 0 ? null : map, (i2 & 32) != 0 ? null : str2, function0, function02, clickLinkItemListener);
    }

    public final void show(final String page, boolean isPhoneLogin, final EulaTriggerType triggerType, int triggerButtonId, final Map<String, String> map, String ispCode, final Function0<Unit> function0, final Function0<Unit> function02, AgreementLinkHelper.ClickLinkItemListener linkClickLinkItemListener) {
        String string;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        Intrinsics.checkNotNullParameter(function0, "onPositiveClick");
        Intrinsics.checkNotNullParameter(function02, "onNegativeClick");
        Intrinsics.checkNotNullParameter(linkClickLinkItemListener, "linkClickLinkItemListener");
        boolean z3 = false;
        this.clicked = false;
        if (isPhoneLogin) {
            String str = ispCode;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String ispAgreement = LoginIspHelper.INSTANCE.getIspCarrierText(getContext(), ispCode);
                String str2 = ispAgreement;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    string = getContext().getString(R.string.account_global_string_156, ispAgreement);
                } else {
                    string = getContext().getString(R.string.account_global_string_125);
                }
            } else {
                string = getContext().getString(R.string.account_global_string_125);
            }
        } else {
            string = getContext().getString(R.string.account_global_string_116);
        }
        Intrinsics.checkNotNull(string);
        String showText = string;
        String it = getShowId(page);
        if (StringsKt.isBlank(it)) {
            it = null;
        }
        if (it != null) {
            LoginReporterV2.Show.report(it, MapsKt.plus(MapsKt.mapOf(TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, triggerType.getReportTypeValue())), map == null ? MapsKt.emptyMap() : map));
        }
        if (isPhoneLogin) {
            String str3 = ispCode;
            if (str3 == null || StringsKt.isBlank(str3)) {
                z3 = true;
            }
            if (!z3) {
                this.agreementLinkHelper.attachLinkContentAgreement(this.view.agreement, showText, ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Lb6), ispCode, linkClickLinkItemListener);
                this.view.buttonNegative.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LoginEulaDialogViewDelegate.show$lambda$2(LoginEulaDialogViewDelegate.this, page, triggerType, map, function02, view);
                    }
                });
                this.view.close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LoginEulaDialogViewDelegate.show$lambda$3(LoginEulaDialogViewDelegate.this, page, triggerType, map, function02, view);
                    }
                });
                this.view.buttonPositive.setText(triggerButtonId);
                this.view.buttonPositive.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LoginEulaDialogViewDelegate.show$lambda$4(LoginEulaDialogViewDelegate.this, page, triggerType, map, function0, view);
                    }
                });
            }
        }
        this.agreementLinkHelper.attachLinkContentAgreement(this.view.agreement, showText, ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Lb6), linkClickLinkItemListener);
        this.view.buttonNegative.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEulaDialogViewDelegate.show$lambda$2(LoginEulaDialogViewDelegate.this, page, triggerType, map, function02, view);
            }
        });
        this.view.close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEulaDialogViewDelegate.show$lambda$3(LoginEulaDialogViewDelegate.this, page, triggerType, map, function02, view);
            }
        });
        this.view.buttonPositive.setText(triggerButtonId);
        this.view.buttonPositive.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEulaDialogViewDelegate.show$lambda$4(LoginEulaDialogViewDelegate.this, page, triggerType, map, function0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(LoginEulaDialogViewDelegate this$0, String $page, EulaTriggerType $triggerType, Map $extraParams, Function0 $onNegativeClick, View it) {
        if (this$0.clicked) {
            return;
        }
        this$0.clicked = true;
        LoginReporterV2.Click.report(this$0.getClickId($page), MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("is_agree", "0"), TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, $triggerType.getReportTypeValue())}), $extraParams == null ? MapsKt.emptyMap() : $extraParams));
        $onNegativeClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3(LoginEulaDialogViewDelegate this$0, String $page, EulaTriggerType $triggerType, Map $extraParams, Function0 $onNegativeClick, View it) {
        if (this$0.clicked) {
            return;
        }
        this$0.clicked = true;
        LoginReporterV2.Click.report(this$0.getClickId($page), MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("is_agree", "0"), TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, $triggerType.getReportTypeValue())}), $extraParams == null ? MapsKt.emptyMap() : $extraParams));
        $onNegativeClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$4(LoginEulaDialogViewDelegate this$0, String $page, EulaTriggerType $triggerType, Map $extraParams, Function0 $onPositiveClick, View it) {
        if (this$0.clicked) {
            return;
        }
        this$0.clicked = true;
        LoginReporterV2.Click.report(this$0.getClickId($page), MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("is_agree", "1"), TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, $triggerType.getReportTypeValue())}), $extraParams == null ? MapsKt.emptyMap() : $extraParams));
        $onPositiveClick.invoke();
    }

    public static /* synthetic */ Object show$default(LoginEulaDialogViewDelegate loginEulaDialogViewDelegate, String str, boolean z, EulaTriggerType eulaTriggerType, int i, Map map, String str2, AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener, Continuation continuation, int i2, Object obj) {
        boolean z2 = (i2 & 2) != 0 ? false : z;
        EulaTriggerType eulaTriggerType2 = (i2 & 4) != 0 ? EulaTriggerType.Submit : eulaTriggerType;
        return loginEulaDialogViewDelegate.show(str, z2, eulaTriggerType2, (i2 & 8) != 0 ? eulaTriggerType2.getBtnId() : i, (i2 & 16) != 0 ? null : map, (i2 & 32) != 0 ? null : str2, clickLinkItemListener, continuation);
    }

    public final Object show(String page, boolean isPhoneLogin, EulaTriggerType triggerType, int triggerButtonId, Map<String, String> map, String ispCode, AgreementLinkHelper.ClickLinkItemListener linkClickLinkItemListener, Continuation<? super Boolean> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation it = safeContinuation;
        show(page, isPhoneLogin, triggerType, triggerButtonId, map, ispCode, new Function0<Unit>() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$show$7$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1236invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1236invoke() {
                Continuation<Boolean> continuation2 = it;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(true));
            }
        }, new Function0<Unit>() { // from class: tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate$show$7$2
            public /* bridge */ /* synthetic */ Object invoke() {
                m1237invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1237invoke() {
                Continuation<Boolean> continuation2 = it;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(false));
            }
        }, linkClickLinkItemListener);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final String getClickId(String page) {
        String format = String.format(LoginReporterV2.PROVISIOM_CLICK, Arrays.copyOf(new Object[]{page}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final String getShowId(String page) {
        if (StringsKt.isBlank(page)) {
            return "";
        }
        String format = String.format(LoginReporterV2.PROVISIOM_SHOW, Arrays.copyOf(new Object[]{page}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}