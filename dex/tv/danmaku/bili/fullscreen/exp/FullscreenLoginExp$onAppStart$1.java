package tv.danmaku.bili.fullscreen.exp;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.dialogmanager.DialogManagerExtKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageDisplay;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: FullscreenLoginExp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp$onAppStart$1", f = "FullscreenLoginExp.kt", i = {}, l = {BR.danmakuTvText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FullscreenLoginExp$onAppStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Context $context;
    final /* synthetic */ LoginExpType $exp;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginExp$onAppStart$1(FragmentActivity fragmentActivity, Context context, LoginExpType loginExpType, Continuation<? super FullscreenLoginExp$onAppStart$1> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$context = context;
        this.$exp = loginExpType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenLoginExp$onAppStart$1(this.$activity, this.$context, this.$exp, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DialogManagerExtKt.showInDialogManager$default(this.$activity, "login_fullscreen_exp", 2048, false, new AnonymousClass1(this.$context, this.$exp, null), (Continuation) this, 8, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullscreenLoginExp.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp$onAppStart$1$1", f = "FullscreenLoginExp.kt", i = {0}, l = {160, BR.emotionBadgeVisible}, m = "invokeSuspend", n = {FavoritesConstsKt.SPMID}, s = {"L$0"}, v = 1)
    /* renamed from: tv.danmaku.bili.fullscreen.exp.FullscreenLoginExp$onAppStart$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ LoginExpType $exp;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, LoginExpType loginExpType, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$context = context;
            this.$exp = loginExpType;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$exp, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00c8 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            boolean checkExpLoginDialogShow;
            String spmid;
            Object $result2;
            LoginPageType lowest;
            Iterator it;
            Object element$iv;
            LoginPageType loginPageType;
            LoginPageType it2;
            RouteRequest it3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    checkExpLoginDialogShow = FullscreenLoginExp.INSTANCE.checkExpLoginDialogShow();
                    if (checkExpLoginDialogShow && !BiliAccounts.get(this.$context).isLogin()) {
                        OnePassLoginPathLinkManager.INSTANCE.onPhase("app.start-up.again.0", OnePassLoginPhaseType.Trigger.INSTANCE);
                        FullscreenLoginExp.INSTANCE.setExpLoginDialogShown(true);
                        Context context = this.$context;
                        Intrinsics.checkNotNull(context);
                        this.L$0 = "app.start-up.again.0";
                        this.label = 1;
                        Object loginPageTypes$default = StartLoginPageKt.getLoginPageTypes$default(context, "app.start-up.again.0", CollectionsKt.listOf(LoginPageDisplay.Dialog), null, null, (Continuation) this, 24, null);
                        if (loginPageTypes$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        spmid = "app.start-up.again.0";
                        $result2 = $result;
                        $result = loginPageTypes$default;
                        Iterable loginTypes = (List) $result;
                        if (!this.$exp.getShowSms()) {
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_HIT_LOGIN_EXPERIMENT);
                            lowest = LoginPageType.SmsLoginDialog;
                        } else if (this.$exp.getShowOnepass()) {
                            OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE);
                            lowest = LoginPageType.QuickLoginDialog;
                        } else {
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_HIT_LOGIN_EXPERIMENT);
                            lowest = LoginPageType.Invalid;
                        }
                        Iterable $this$firstOrNull$iv = loginTypes;
                        it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = null;
                            } else {
                                element$iv = it.next();
                                LoginPageType it4 = (LoginPageType) element$iv;
                                if (it4.ordinal() <= lowest.ordinal()) {
                                    it2 = 1;
                                    continue;
                                } else {
                                    it2 = null;
                                    continue;
                                }
                                if (it2 != null) {
                                }
                            }
                        }
                        LoginPageType it5 = (LoginPageType) element$iv;
                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Login exp " + this.$exp + ", lowest login type: " + lowest + ", filterred login type " + it5);
                        loginPageType = (LoginPageType) element$iv;
                        if (loginPageType == null) {
                            Context context2 = this.$context;
                            Intrinsics.checkNotNull(context2);
                            Bundle $this$invokeSuspend_u24lambda_u242 = new Bundle();
                            $this$invokeSuspend_u24lambda_u242.putParcelable(FullscreenLoginExp.KEY_LOGIN_EXP, this.$exp);
                            Unit unit = Unit.INSTANCE;
                            this.L$0 = null;
                            this.label = 2;
                            $result = LoginPageType.buildLoginRequest$default(loginPageType, context2, spmid, null, $this$invokeSuspend_u24lambda_u242, (Continuation) this, 4, null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it3 = (RouteRequest) $result;
                            if (it3 == null) {
                                BLRouter.routeTo(it3, this.$context);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    String spmid2 = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    spmid = spmid2;
                    $result2 = $result;
                    Iterable loginTypes2 = (List) $result;
                    if (!this.$exp.getShowSms()) {
                    }
                    Iterable $this$firstOrNull$iv2 = loginTypes2;
                    it = $this$firstOrNull$iv2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                        }
                        
                    }