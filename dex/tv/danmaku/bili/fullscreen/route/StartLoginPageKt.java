package tv.danmaku.bili.fullscreen.route;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.service.PhoneService;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: StartLoginPage.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a`\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0086@¢\u0006\u0002\u0010\u0013\u001aL\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0086@¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"KEY_LOGIN_ROUTE_NEW", "", "KEY_VALID_TYPES", "getLoginPageRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", "context", "Landroid/content/Context;", FavoritesConstsKt.SPMID, "displays", "", "Ltv/danmaku/bili/fullscreen/route/LoginPageDisplay;", "topMostType", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "preferredType", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "extraBuilder", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Iterable;Ltv/danmaku/bili/fullscreen/route/LoginPageType;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginPageTypes", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Iterable;Ljava/lang/Iterable;Ltv/danmaku/bili/fullscreen/route/LoginPageType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLoginPageTypes", "(Ljava/lang/Iterable;Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG_LOGINRULE", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StartLoginPageKt {
    public static final String KEY_LOGIN_ROUTE_NEW = "login_route_new";
    public static final String KEY_VALID_TYPES = "login_valid_types";
    public static final String TAG_LOGINRULE = "LoginRule";

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getLoginPageRequest(Context context, String str, Iterable<? extends LoginPageDisplay> iterable, LoginPageType loginPageType, Iterable<? extends ValidLoginType> iterable2, Function1<? super Bundle, Unit> function1, Continuation<? super RouteRequest> continuation) {
        Continuation<? super RouteRequest> startLoginPageKt$getLoginPageRequest$1;
        Context context2;
        String spmid;
        Function1 extraBuilder;
        Object loginPageTypes;
        LoginPageType loginPageType2;
        Object buildLoginRequest;
        if (continuation instanceof StartLoginPageKt$getLoginPageRequest$1) {
            startLoginPageKt$getLoginPageRequest$1 = (StartLoginPageKt$getLoginPageRequest$1) continuation;
            if ((startLoginPageKt$getLoginPageRequest$1.label & Integer.MIN_VALUE) != 0) {
                startLoginPageKt$getLoginPageRequest$1.label -= Integer.MIN_VALUE;
                Object $result2 = startLoginPageKt$getLoginPageRequest$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (startLoginPageKt$getLoginPageRequest$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        context2 = context;
                        spmid = str;
                        extraBuilder = function1;
                        startLoginPageKt$getLoginPageRequest$1.L$0 = context2;
                        startLoginPageKt$getLoginPageRequest$1.L$1 = spmid;
                        startLoginPageKt$getLoginPageRequest$1.L$2 = extraBuilder;
                        startLoginPageKt$getLoginPageRequest$1.label = 1;
                        loginPageTypes = getLoginPageTypes(context2, spmid, iterable, iterable2, loginPageType, startLoginPageKt$getLoginPageRequest$1);
                        if (loginPageTypes == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                        List allTypes2 = (List) loginPageTypes;
                        loginPageType2 = (LoginPageType) CollectionsKt.firstOrNull(allTypes2);
                        if (loginPageType2 != null) {
                            return null;
                        }
                        List $this$map$iv = allTypes2;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            LoginPageType it = (LoginPageType) item$iv$iv;
                            destination$iv$iv.add(it.getType());
                        }
                        ArrayList arrayList = (List) destination$iv$iv;
                        Bundle $this$getLoginPageRequest_u24lambda_u242 = new Bundle();
                        extraBuilder.invoke($this$getLoginPageRequest_u24lambda_u242);
                        Unit unit = Unit.INSTANCE;
                        startLoginPageKt$getLoginPageRequest$1.L$0 = null;
                        startLoginPageKt$getLoginPageRequest$1.L$1 = null;
                        startLoginPageKt$getLoginPageRequest$1.L$2 = null;
                        startLoginPageKt$getLoginPageRequest$1.label = 2;
                        buildLoginRequest = loginPageType2.buildLoginRequest(context2, spmid, arrayList, $this$getLoginPageRequest_u24lambda_u242, startLoginPageKt$getLoginPageRequest$1);
                        if (buildLoginRequest == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                        return (RouteRequest) buildLoginRequest;
                    case 1:
                        ResultKt.throwOnFailure($result2);
                        extraBuilder = (Function1) startLoginPageKt$getLoginPageRequest$1.L$2;
                        spmid = (String) startLoginPageKt$getLoginPageRequest$1.L$1;
                        context2 = (Context) startLoginPageKt$getLoginPageRequest$1.L$0;
                        loginPageTypes = $result2;
                        List allTypes22 = (List) loginPageTypes;
                        loginPageType2 = (LoginPageType) CollectionsKt.firstOrNull(allTypes22);
                        if (loginPageType2 != null) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result2);
                        buildLoginRequest = $result2;
                        return (RouteRequest) buildLoginRequest;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        startLoginPageKt$getLoginPageRequest$1 = new StartLoginPageKt$getLoginPageRequest$1(continuation);
        Object $result22 = startLoginPageKt$getLoginPageRequest$1.result;
        Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (startLoginPageKt$getLoginPageRequest$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getLoginPageRequest$lambda$0(Bundle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:686)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:544)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object getLoginPageTypes(android.content.Context r10, java.lang.String r11, java.lang.Iterable<? extends tv.danmaku.bili.fullscreen.route.LoginPageDisplay> r12, java.lang.Iterable<? extends tv.danmaku.bili.fullscreen.route.ValidLoginType> r13, tv.danmaku.bili.fullscreen.route.LoginPageType r14, kotlin.coroutines.Continuation<? super java.util.List<? extends tv.danmaku.bili.fullscreen.route.LoginPageType>> r15) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.fullscreen.route.StartLoginPageKt.getLoginPageTypes(android.content.Context, java.lang.String, java.lang.Iterable, java.lang.Iterable, tv.danmaku.bili.fullscreen.route.LoginPageType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getLoginPageTypes$default(Context context, String str, Iterable iterable, Iterable iterable2, LoginPageType loginPageType, Continuation continuation, int i, Object obj) {
        List<ValidLoginType> list;
        LoginPageType loginPageType2;
        if ((i & 8) == 0) {
            list = iterable2;
        } else {
            list = ValidLoginType.Companion.getAllValues();
        }
        if ((i & 16) == 0) {
            loginPageType2 = loginPageType;
        } else {
            loginPageType2 = LoginPageType.Invalid;
        }
        return getLoginPageTypes(context, str, iterable, list, loginPageType2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getLoginPageTypes$lambda$1(LoginPageType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getNeedPhoneInfo();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getAllLoginPageTypes(Iterable<? extends LoginPageDisplay> iterable, Iterable<? extends ValidLoginType> iterable2, Continuation<? super List<? extends LoginPageType>> continuation) {
        StartLoginPageKt$getAllLoginPageTypes$1 startLoginPageKt$getAllLoginPageTypes$1;
        Object suspendGetLoginType$default;
        Iterable preferredType;
        Iterable displays;
        TInfoLogin loginInfo;
        if (continuation instanceof StartLoginPageKt$getAllLoginPageTypes$1) {
            startLoginPageKt$getAllLoginPageTypes$1 = (StartLoginPageKt$getAllLoginPageTypes$1) continuation;
            if ((startLoginPageKt$getAllLoginPageTypes$1.label & Integer.MIN_VALUE) != 0) {
                startLoginPageKt$getAllLoginPageTypes$1.label -= Integer.MIN_VALUE;
                Object $result = startLoginPageKt$getAllLoginPageTypes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (startLoginPageKt$getAllLoginPageTypes$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                        startLoginPageKt$getAllLoginPageTypes$1.L$0 = iterable;
                        startLoginPageKt$getAllLoginPageTypes$1.L$1 = iterable2;
                        startLoginPageKt$getAllLoginPageTypes$1.label = 1;
                        suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(loginRuleProcessor, false, false, startLoginPageKt$getAllLoginPageTypes$1, 3, null);
                        if (suspendGetLoginType$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        preferredType = iterable;
                        displays = iterable2;
                        break;
                    case 1:
                        displays = (Iterable) startLoginPageKt$getAllLoginPageTypes$1.L$1;
                        preferredType = (Iterable) startLoginPageKt$getAllLoginPageTypes$1.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendGetLoginType$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                loginInfo = (TInfoLogin) ((Pair) suspendGetLoginType$default).component2();
                if (loginInfo == null) {
                    List remoteType = LoginTypeRuleKt.getLoginTypeList(loginInfo);
                    Collection destination$iv$iv = new ArrayList();
                    for (ValidLoginType validLoginType : displays) {
                        ValidLoginType it = validLoginType;
                        if (remoteType.contains(it)) {
                            destination$iv$iv.add(validLoginType);
                        }
                    }
                    LoginTypeRule rule = new LoginTypeRule((List) destination$iv$iv);
                    return rule.getAllValidLoginPages(preferredType);
                }
                return CollectionsKt.emptyList();
            }
        }
        startLoginPageKt$getAllLoginPageTypes$1 = new StartLoginPageKt$getAllLoginPageTypes$1(continuation);
        Object $result2 = startLoginPageKt$getAllLoginPageTypes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (startLoginPageKt$getAllLoginPageTypes$1.label) {
        }
        loginInfo = (TInfoLogin) ((Pair) suspendGetLoginType$default).component2();
        if (loginInfo == null) {
        }
    }

    public static /* synthetic */ Object getAllLoginPageTypes$default(Iterable iterable, Iterable iterable2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            iterable = LoginPageDisplay.Companion.getDefaultArray();
        }
        if ((i & 2) != 0) {
            iterable2 = ValidLoginType.Companion.getAllValues();
        }
        return getAllLoginPageTypes(iterable, iterable2, continuation);
    }
}