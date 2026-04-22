package tv.danmaku.bili.fullscreen.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.accountsui.fast.FastLoginUserHelper;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fast.FastReLoginActivityKt;
import tv.danmaku.bili.fullscreen.FullscreenLoginActivityKt;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LoginPageType.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH @¢\u0006\u0004\b\u001f\u0010 J8\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070&2\b\b\u0002\u0010'\u001a\u00020(H\u0086@¢\u0006\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006*"}, d2 = {"Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "", "display", "Ltv/danmaku/bili/fullscreen/route/LoginPageDisplay;", "needPhoneInfo", "", "type", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "<init>", "(Ljava/lang/String;ILtv/danmaku/bili/fullscreen/route/LoginPageDisplay;ZLtv/danmaku/bili/fullscreen/route/ValidLoginType;)V", "getDisplay", "()Ltv/danmaku/bili/fullscreen/route/LoginPageDisplay;", "getNeedPhoneInfo", "()Z", "getType", "()Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "Invalid", "FastReLoginFullscreen", "PhoneOnePassFullscreen", "SmsFullscreen", "PwdFullscreen", "FastReLoginDialog", "QuickLoginDialog", "SmsLoginDialog", "SmsLoginPage", "PwdLoginPage", "PwdNoSmsLoginPage", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", FavoritesConstsKt.SPMID, "", "validTypes", "", InnerPushReceiverKt.KEY_EXTRA, "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class LoginPageType {
    private final LoginPageDisplay display;
    private final boolean needPhoneInfo;
    private final ValidLoginType type;
    public static final LoginPageType Invalid = new LoginPageType("Invalid", 0) { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType.Invalid
        {
            LoginPageDisplay loginPageDisplay = LoginPageDisplay.FullscreenOld;
            ValidLoginType validLoginType = ValidLoginType.None;
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return new RouteRequest.Builder("");
        }
    };
    public static final LoginPageType FastReLoginFullscreen = new FastReLoginFullscreen("FastReLoginFullscreen", 1);
    public static final LoginPageType PhoneOnePassFullscreen = new PhoneOnePassFullscreen("PhoneOnePassFullscreen", 2);
    public static final LoginPageType SmsFullscreen = new SmsFullscreen("SmsFullscreen", 3);
    public static final LoginPageType PwdFullscreen = new PwdFullscreen("PwdFullscreen", 4);
    public static final LoginPageType FastReLoginDialog = new FastReLoginDialog("FastReLoginDialog", 5);
    public static final LoginPageType QuickLoginDialog = new LoginPageType("QuickLoginDialog", 6) { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType.QuickLoginDialog
        {
            LoginPageDisplay loginPageDisplay = LoginPageDisplay.Dialog;
            ValidLoginType validLoginType = ValidLoginType.QuickLogin;
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return RouteRequestKt.toRouteRequest(RouteUtilKt.LOGIN_QUICK_ROUTE).newBuilder();
        }
    };
    public static final LoginPageType SmsLoginDialog = new LoginPageType("SmsLoginDialog", 7) { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType.SmsLoginDialog
        {
            LoginPageDisplay loginPageDisplay = LoginPageDisplay.Dialog;
            ValidLoginType validLoginType = ValidLoginType.SmsLogin;
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return RouteRequestKt.toRouteRequest(RouteUtilKt.LOGIN_SMS_DIALOG).newBuilder();
        }
    };
    public static final LoginPageType SmsLoginPage = new SmsLoginPage("SmsLoginPage", 8);
    public static final LoginPageType PwdLoginPage = new PwdLoginPage("PwdLoginPage", 9);
    public static final LoginPageType PwdNoSmsLoginPage = new PwdNoSmsLoginPage("PwdNoSmsLoginPage", 10);
    private static final /* synthetic */ LoginPageType[] $VALUES = $values();
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    private static final /* synthetic */ LoginPageType[] $values() {
        return new LoginPageType[]{Invalid, FastReLoginFullscreen, PhoneOnePassFullscreen, SmsFullscreen, PwdFullscreen, FastReLoginDialog, QuickLoginDialog, SmsLoginDialog, SmsLoginPage, PwdLoginPage, PwdNoSmsLoginPage};
    }

    public /* synthetic */ LoginPageType(String str, int i, LoginPageDisplay loginPageDisplay, boolean z, ValidLoginType validLoginType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, loginPageDisplay, z, validLoginType);
    }

    public static EnumEntries<LoginPageType> getEntries() {
        return $ENTRIES;
    }

    public static LoginPageType valueOf(String str) {
        return (LoginPageType) Enum.valueOf(LoginPageType.class, str);
    }

    public static LoginPageType[] values() {
        return (LoginPageType[]) $VALUES.clone();
    }

    public abstract Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation);

    private LoginPageType(String $enum$name, int $enum$ordinal, LoginPageDisplay display, boolean needPhoneInfo, ValidLoginType type) {
        this.display = display;
        this.needPhoneInfo = needPhoneInfo;
        this.type = type;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ LoginPageType(String str, int i, LoginPageDisplay loginPageDisplay, boolean z, ValidLoginType validLoginType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, loginPageDisplay, r4, validLoginType);
        boolean z2;
        if ((i2 & 2) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
    }

    public final LoginPageDisplay getDisplay() {
        return this.display;
    }

    public final boolean getNeedPhoneInfo() {
        return this.needPhoneInfo;
    }

    public final ValidLoginType getType() {
        return this.type;
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.FastReLoginFullscreen", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class FastReLoginFullscreen extends LoginPageType {
        FastReLoginFullscreen(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.Fullscreen, false, ValidLoginType.FastReLogin, 2, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            LoginPageType$FastReLoginFullscreen$getLoginRequest$1 loginPageType$FastReLoginFullscreen$getLoginRequest$1;
            SimpleAccountItem simpleAccountItem;
            Object obj;
            if (continuation instanceof LoginPageType$FastReLoginFullscreen$getLoginRequest$1) {
                loginPageType$FastReLoginFullscreen$getLoginRequest$1 = (LoginPageType$FastReLoginFullscreen$getLoginRequest$1) continuation;
                if ((loginPageType$FastReLoginFullscreen$getLoginRequest$1.label & Integer.MIN_VALUE) != 0) {
                    loginPageType$FastReLoginFullscreen$getLoginRequest$1.label -= Integer.MIN_VALUE;
                    Object $result = loginPageType$FastReLoginFullscreen$getLoginRequest$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (loginPageType$FastReLoginFullscreen$getLoginRequest$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            FastLoginInfo fastLoginInfo = BiliAccounts.get(context).getFastLoginInfo();
                            if (fastLoginInfo == null) {
                                simpleAccountItem = null;
                                break;
                            } else {
                                FastLoginUserHelper fastLoginUserHelper = FastLoginUserHelper.INSTANCE;
                                long mid = fastLoginInfo.getMid();
                                loginPageType$FastReLoginFullscreen$getLoginRequest$1.label = 1;
                                Object loadUserInfo = fastLoginUserHelper.loadUserInfo(context, mid, loginPageType$FastReLoginFullscreen$getLoginRequest$1);
                                if (loadUserInfo == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = loadUserInfo;
                                simpleAccountItem = (SimpleAccountItem) obj;
                                break;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            simpleAccountItem = (SimpleAccountItem) obj;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    final SimpleAccountItem account = simpleAccountItem;
                    return new RouteRequest.Builder(FullscreenLoginActivityKt.FullscreenLoginPageUrl).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$FastReLoginFullscreen$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit loginRequest$lambda$1;
                            loginRequest$lambda$1 = LoginPageType.FastReLoginFullscreen.getLoginRequest$lambda$1(account, (MutableBundleLike) obj2);
                            return loginRequest$lambda$1;
                        }
                    }).flags(33554432);
                }
            }
            loginPageType$FastReLoginFullscreen$getLoginRequest$1 = new LoginPageType$FastReLoginFullscreen$getLoginRequest$1(this, continuation);
            Object $result2 = loginPageType$FastReLoginFullscreen$getLoginRequest$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (loginPageType$FastReLoginFullscreen$getLoginRequest$1.label) {
            }
            final SimpleAccountItem account2 = simpleAccountItem;
            return new RouteRequest.Builder(FullscreenLoginActivityKt.FullscreenLoginPageUrl).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$FastReLoginFullscreen$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit loginRequest$lambda$1;
                    loginRequest$lambda$1 = LoginPageType.FastReLoginFullscreen.getLoginRequest$lambda$1(account2, (MutableBundleLike) obj2);
                    return loginRequest$lambda$1;
                }
            }).flags(33554432);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$1(SimpleAccountItem $account, MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            Bundle bundle = new Bundle();
            bundle.putParcelable(FastReLoginActivityKt.KEY_ACCOUNT, (Parcelable) $account);
            bundle.putParcelable(FullscreenLoginActivityKt.KEY_PAGE_START_AT, ValidLoginType.FastReLogin);
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.PhoneOnePassFullscreen", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class PhoneOnePassFullscreen extends LoginPageType {
        PhoneOnePassFullscreen(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.Fullscreen, true, ValidLoginType.QuickLogin, null);
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return new RouteRequest.Builder(FullscreenLoginActivityKt.FullscreenLoginPageUrl).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$PhoneOnePassFullscreen$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit loginRequest$lambda$0;
                    loginRequest$lambda$0 = LoginPageType.PhoneOnePassFullscreen.getLoginRequest$lambda$0((MutableBundleLike) obj);
                    return loginRequest$lambda$0;
                }
            }).flags(33554432);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            Bundle bundle = new Bundle();
            bundle.putParcelable(FullscreenLoginActivityKt.KEY_PAGE_START_AT, ValidLoginType.QuickLogin);
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.SmsFullscreen", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class SmsFullscreen extends LoginPageType {
        SmsFullscreen(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.Fullscreen, false, ValidLoginType.SmsLogin, 2, null);
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return new RouteRequest.Builder(FullscreenLoginActivityKt.FullscreenLoginPageUrl).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$SmsFullscreen$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit loginRequest$lambda$0;
                    loginRequest$lambda$0 = LoginPageType.SmsFullscreen.getLoginRequest$lambda$0((MutableBundleLike) obj);
                    return loginRequest$lambda$0;
                }
            }).flags(33554432);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            Bundle bundle = new Bundle();
            bundle.putParcelable(FullscreenLoginActivityKt.KEY_PAGE_START_AT, ValidLoginType.SmsLogin);
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.PwdFullscreen", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class PwdFullscreen extends LoginPageType {
        PwdFullscreen(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.Fullscreen, false, ValidLoginType.PwdLogin, 2, null);
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return new RouteRequest.Builder(FullscreenLoginActivityKt.FullscreenLoginPageUrl).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$PwdFullscreen$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit loginRequest$lambda$0;
                    loginRequest$lambda$0 = LoginPageType.PwdFullscreen.getLoginRequest$lambda$0((MutableBundleLike) obj);
                    return loginRequest$lambda$0;
                }
            }).flags(33554432);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            Bundle bundle = new Bundle();
            bundle.putParcelable(FullscreenLoginActivityKt.KEY_PAGE_START_AT, ValidLoginType.PwdLogin);
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.FastReLoginDialog", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class FastReLoginDialog extends LoginPageType {
        FastReLoginDialog(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.Dialog, false, ValidLoginType.FastReLogin, 2, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            LoginPageType$FastReLoginDialog$getLoginRequest$1 loginPageType$FastReLoginDialog$getLoginRequest$1;
            SimpleAccountItem simpleAccountItem;
            Object obj;
            if (continuation instanceof LoginPageType$FastReLoginDialog$getLoginRequest$1) {
                loginPageType$FastReLoginDialog$getLoginRequest$1 = (LoginPageType$FastReLoginDialog$getLoginRequest$1) continuation;
                if ((loginPageType$FastReLoginDialog$getLoginRequest$1.label & Integer.MIN_VALUE) != 0) {
                    loginPageType$FastReLoginDialog$getLoginRequest$1.label -= Integer.MIN_VALUE;
                    Object $result = loginPageType$FastReLoginDialog$getLoginRequest$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (loginPageType$FastReLoginDialog$getLoginRequest$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            FastLoginInfo fastLoginInfo = BiliAccounts.get(context).getFastLoginInfo();
                            if (fastLoginInfo == null) {
                                simpleAccountItem = null;
                                break;
                            } else {
                                FastLoginUserHelper fastLoginUserHelper = FastLoginUserHelper.INSTANCE;
                                long mid = fastLoginInfo.getMid();
                                loginPageType$FastReLoginDialog$getLoginRequest$1.label = 1;
                                Object loadUserInfo = fastLoginUserHelper.loadUserInfo(context, mid, loginPageType$FastReLoginDialog$getLoginRequest$1);
                                if (loadUserInfo == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = loadUserInfo;
                                simpleAccountItem = (SimpleAccountItem) obj;
                                break;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            simpleAccountItem = (SimpleAccountItem) obj;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    final SimpleAccountItem account = simpleAccountItem;
                    return new RouteRequest.Builder(RouteUtilKt.LOGIN_FAST_ROUTE).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$FastReLoginDialog$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit loginRequest$lambda$1;
                            loginRequest$lambda$1 = LoginPageType.FastReLoginDialog.getLoginRequest$lambda$1(account, (MutableBundleLike) obj2);
                            return loginRequest$lambda$1;
                        }
                    }).flags(33554432);
                }
            }
            loginPageType$FastReLoginDialog$getLoginRequest$1 = new LoginPageType$FastReLoginDialog$getLoginRequest$1(this, continuation);
            Object $result2 = loginPageType$FastReLoginDialog$getLoginRequest$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (loginPageType$FastReLoginDialog$getLoginRequest$1.label) {
            }
            final SimpleAccountItem account2 = simpleAccountItem;
            return new RouteRequest.Builder(RouteUtilKt.LOGIN_FAST_ROUTE).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$FastReLoginDialog$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit loginRequest$lambda$1;
                    loginRequest$lambda$1 = LoginPageType.FastReLoginDialog.getLoginRequest$lambda$1(account2, (MutableBundleLike) obj2);
                    return loginRequest$lambda$1;
                }
            }).flags(33554432);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$1(SimpleAccountItem $account, MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            Bundle bundle = new Bundle();
            bundle.putParcelable(FastReLoginActivityKt.KEY_ACCOUNT, (Parcelable) $account);
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.SmsLoginPage", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class SmsLoginPage extends LoginPageType {
        SmsLoginPage(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.FullscreenOld, false, ValidLoginType.SmsLogin, 2, null);
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return RouteRequestKt.toRouteRequest("bilibili://login/origin").newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$SmsLoginPage$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit loginRequest$lambda$0;
                    loginRequest$lambda$0 = LoginPageType.SmsLoginPage.getLoginRequest$lambda$0((MutableBundleLike) obj);
                    return loginRequest$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_DIRECT, "true");
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_ENABLE, "true");
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.PwdLoginPage", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class PwdLoginPage extends LoginPageType {
        PwdLoginPage(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.FullscreenOld, false, ValidLoginType.PwdLogin, 2, null);
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return RouteRequestKt.toRouteRequest("bilibili://login/origin").newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$PwdLoginPage$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit loginRequest$lambda$0;
                    loginRequest$lambda$0 = LoginPageType.PwdLoginPage.getLoginRequest$lambda$0((MutableBundleLike) obj);
                    return loginRequest$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_DIRECT, "false");
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_ENABLE, "true");
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LoginPageType.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0090@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tv/danmaku/bili/fullscreen/route/LoginPageType.PwdNoSmsLoginPage", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "getLoginRequest", "Lcom/bilibili/lib/blrouter/RouteRequest$Builder;", "context", "Landroid/content/Context;", "getLoginRequest$accountui_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class PwdNoSmsLoginPage extends LoginPageType {
        PwdNoSmsLoginPage(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, LoginPageDisplay.FullscreenOld, false, ValidLoginType.PwdLogin, 2, null);
        }

        @Override // tv.danmaku.bili.fullscreen.route.LoginPageType
        public Object getLoginRequest$accountui_apinkDebug(Context context, Continuation<? super RouteRequest.Builder> continuation) {
            return RouteRequestKt.toRouteRequest("bilibili://login/origin").newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$PwdNoSmsLoginPage$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit loginRequest$lambda$0;
                    loginRequest$lambda$0 = LoginPageType.PwdNoSmsLoginPage.getLoginRequest$lambda$0((MutableBundleLike) obj);
                    return loginRequest$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit getLoginRequest$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_DIRECT, "false");
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_ENABLE, "true");
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object buildLoginRequest$default(LoginPageType loginPageType, Context context, String str, List list, Bundle bundle, Continuation continuation, int i, Object obj) {
        List<ValidLoginType> list2;
        Bundle bundle2;
        if (obj == null) {
            if ((i & 4) == 0) {
                list2 = list;
            } else {
                list2 = ValidLoginType.Companion.getAllValues();
            }
            if ((i & 8) == 0) {
                bundle2 = bundle;
            } else {
                bundle2 = new Bundle();
            }
            return loginPageType.buildLoginRequest(context, str, list2, bundle2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildLoginRequest");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object buildLoginRequest(Context context, String spmid, List<? extends ValidLoginType> list, final Bundle extra, Continuation<? super RouteRequest> continuation) {
        LoginPageType$buildLoginRequest$1 loginPageType$buildLoginRequest$1;
        Object loginRequest$accountui_apinkDebug;
        final String spmid2;
        final List validTypes;
        if (continuation instanceof LoginPageType$buildLoginRequest$1) {
            loginPageType$buildLoginRequest$1 = (LoginPageType$buildLoginRequest$1) continuation;
            if ((loginPageType$buildLoginRequest$1.label & Integer.MIN_VALUE) != 0) {
                loginPageType$buildLoginRequest$1.label -= Integer.MIN_VALUE;
                Object $result = loginPageType$buildLoginRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginPageType$buildLoginRequest$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loginPageType$buildLoginRequest$1.L$0 = spmid;
                        loginPageType$buildLoginRequest$1.L$1 = list;
                        loginPageType$buildLoginRequest$1.L$2 = extra;
                        loginPageType$buildLoginRequest$1.label = 1;
                        loginRequest$accountui_apinkDebug = getLoginRequest$accountui_apinkDebug(context, loginPageType$buildLoginRequest$1);
                        if (loginRequest$accountui_apinkDebug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        spmid2 = spmid;
                        validTypes = list;
                        break;
                    case 1:
                        validTypes = (List) loginPageType$buildLoginRequest$1.L$1;
                        spmid2 = (String) loginPageType$buildLoginRequest$1.L$0;
                        ResultKt.throwOnFailure($result);
                        extra = (Bundle) loginPageType$buildLoginRequest$1.L$2;
                        loginRequest$accountui_apinkDebug = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((RouteRequest.Builder) loginRequest$accountui_apinkDebug).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit buildLoginRequest$lambda$0;
                        buildLoginRequest$lambda$0 = LoginPageType.buildLoginRequest$lambda$0(spmid2, validTypes, extra, (MutableBundleLike) obj);
                        return buildLoginRequest$lambda$0;
                    }
                }).build();
            }
        }
        loginPageType$buildLoginRequest$1 = new LoginPageType$buildLoginRequest$1(this, continuation);
        Object $result2 = loginPageType$buildLoginRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginPageType$buildLoginRequest$1.label) {
        }
        return ((RouteRequest.Builder) loginRequest$accountui_apinkDebug).extras(new Function1() { // from class: tv.danmaku.bili.fullscreen.route.LoginPageType$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildLoginRequest$lambda$0;
                buildLoginRequest$lambda$0 = LoginPageType.buildLoginRequest$lambda$0(spmid2, validTypes, extra, (MutableBundleLike) obj);
                return buildLoginRequest$lambda$0;
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildLoginRequest$lambda$0(String $spmid, List $validTypes, Bundle $extra, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        Bundle bundle = $this$extras.getBundle(str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putAll($extra);
        bundle.putParcelableArrayList(StartLoginPageKt.KEY_VALID_TYPES, new ArrayList<>($validTypes));
        String str2 = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str2, "KEY_DEFAULT_EXTRA_BUNDLE");
        $this$extras.put(str2, bundle);
        $this$extras.put("from_spmid", $spmid);
        $this$extras.put("smsEnable", String.valueOf($validTypes.contains(ValidLoginType.SmsLogin)));
        return Unit.INSTANCE;
    }
}