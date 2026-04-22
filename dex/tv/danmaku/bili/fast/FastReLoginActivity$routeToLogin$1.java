package tv.danmaku.bili.fast;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageDisplay;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.report.LoginReportHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fast.FastReLoginActivity$routeToLogin$1", f = "FastReLoginActivity.kt", i = {}, l = {BR.followIconDrawable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastReLoginActivity$routeToLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FastReLoginActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastReLoginActivity$routeToLogin$1(FastReLoginActivity fastReLoginActivity, Continuation<? super FastReLoginActivity$routeToLogin$1> continuation) {
        super(2, continuation);
        this.this$0 = fastReLoginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FastReLoginActivity$routeToLogin$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loginPageRequest;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Context context = (Context) this.this$0;
                String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
                if (fromSpmid == null) {
                    fromSpmid = "";
                }
                LoginPageType loginPageType = LoginPageType.FastReLoginDialog;
                this.label = 1;
                loginPageRequest = StartLoginPageKt.getLoginPageRequest(context, fromSpmid, (r14 & 4) != 0 ? LoginPageDisplay.Companion.getDefaultArray() : null, (r14 & 8) != 0 ? LoginPageType.Invalid : loginPageType, (r14 & 16) != 0 ? ValidLoginType.Companion.getAllValues() : null, (r14 & 32) != 0 ? 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: INVOKE  (r1v5 'loginPageRequest' java.lang.Object) = 
                      (r3v1 'context' android.content.Context)
                      (r1v4 'fromSpmid' java.lang.String)
                      (wrap: java.lang.Iterable : ?: TERNARYnull = ((wrap: int : 0x0000: ARITH  (r15v1 int A[REMOVE]) = (r14v0 int) & (4 int)) != (0 int)) ? (wrap: java.util.List<tv.danmaku.bili.fullscreen.route.LoginPageDisplay> : 0x000c: INVOKE  
                      (wrap: tv.danmaku.bili.fullscreen.route.LoginPageDisplay$Companion : 0x0004: SGET   tv.danmaku.bili.fullscreen.route.LoginPageDisplay.Companion tv.danmaku.bili.fullscreen.route.LoginPageDisplay$Companion)
                     type: VIRTUAL call: tv.danmaku.bili.fullscreen.route.LoginPageDisplay.Companion.getDefaultArray():java.util.List) : (null java.lang.Iterable))
                      (wrap: tv.danmaku.bili.fullscreen.route.LoginPageType : ?: TERNARYnull = ((wrap: int : 0x000f: ARITH  (r9v1 int A[REMOVE]) = (r14v0 int) & (8 int)) != (0 int)) ? (wrap: tv.danmaku.bili.fullscreen.route.LoginPageType : 0x0015: SGET   tv.danmaku.bili.fullscreen.route.LoginPageType.Invalid tv.danmaku.bili.fullscreen.route.LoginPageType) : (r6v0 'loginPageType' tv.danmaku.bili.fullscreen.route.LoginPageType))
                      (wrap: java.lang.Iterable : ?: TERNARYnull = ((wrap: int : 0x0018: ARITH  (r9v2 int A[REMOVE]) = (r14v0 int) & (16 int)) != (0 int)) ? (wrap: java.util.List<tv.danmaku.bili.fullscreen.route.ValidLoginType> : 0x0025: INVOKE  
                      (wrap: tv.danmaku.bili.fullscreen.route.ValidLoginType$Companion : 0x001c: SGET   tv.danmaku.bili.fullscreen.route.ValidLoginType.Companion tv.danmaku.bili.fullscreen.route.ValidLoginType$Companion)
                     type: VIRTUAL call: tv.danmaku.bili.fullscreen.route.ValidLoginType.Companion.getAllValues():java.util.List) : (null java.lang.Iterable))
                      (wrap: kotlin.jvm.functions.Function1 : ?: TERNARYnull = ((wrap: int : 0x0028: ARITH  (r9v3 int A[REMOVE]) = (r14v0 int) & (32 int)) != (0 int)) ? (wrap: kotlin.jvm.functions.Function1 : 0x0031: CONSTRUCTOR   call: tv.danmaku.bili.fullscreen.route.StartLoginPageKt$$ExternalSyntheticLambda1.<init>():void type: CONSTRUCTOR) : (null kotlin.jvm.functions.Function1))
                      (wrap: kotlin.coroutines.Continuation : 0x002f: CHECK_CAST (r9v1 kotlin.coroutines.Continuation A[REMOVE]) = (kotlin.coroutines.Continuation) (r12v0 'this' tv.danmaku.bili.fast.FastReLoginActivity$routeToLogin$1 A[IMMUTABLE_TYPE, THIS]))
                     type: STATIC call: tv.danmaku.bili.fullscreen.route.StartLoginPageKt.getLoginPageRequest(android.content.Context, java.lang.String, java.lang.Iterable, tv.danmaku.bili.fullscreen.route.LoginPageType, java.lang.Iterable, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object in method: tv.danmaku.bili.fast.FastReLoginActivity$routeToLogin$1.invokeSuspend(java.lang.Object):java.lang.Object, file: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: tv.danmaku.bili.fullscreen.route.StartLoginPageKt$$ExternalSyntheticLambda1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1142)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:535)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	... 21 more
                    */
                /*
                    this = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r12.label
                    r2 = 1
                    switch(r1) {
                        case 0: goto L17;
                        case 1: goto L12;
                        default: goto La;
                    }
                La:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L12:
                    kotlin.ResultKt.throwOnFailure(r13)
                    r0 = r13
                    goto L42
                L17:
                    kotlin.ResultKt.throwOnFailure(r13)
                    tv.danmaku.bili.fast.FastReLoginActivity r1 = r12.this$0
                    r3 = r1
                    android.content.Context r3 = (android.content.Context) r3
                    tv.danmaku.bili.report.LoginReportHelper r1 = tv.danmaku.bili.report.LoginReportHelper.INSTANCE
                    java.lang.String r1 = r1.getFromSpmid()
                    if (r1 != 0) goto L2a
                    java.lang.String r1 = ""
                L2a:
                    r4 = r1
                    tv.danmaku.bili.fullscreen.route.LoginPageType r6 = tv.danmaku.bili.fullscreen.route.LoginPageType.FastReLoginDialog
                    r9 = r12
                    kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                    r12.label = r2
                    r5 = 0
                    r7 = 0
                    r8 = 0
                    r10 = 52
                    r11 = 0
                    java.lang.Object r1 = tv.danmaku.bili.fullscreen.route.StartLoginPageKt.getLoginPageRequest$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                    if (r1 != r0) goto L40
                    return r0
                L40:
                    r0 = r13
                    r13 = r1
                L42:
                    com.bilibili.lib.blrouter.RouteRequest r13 = (com.bilibili.lib.blrouter.RouteRequest) r13
                    if (r13 == 0) goto L5d
                L47:
                    tv.danmaku.bili.fast.FastReLoginActivity r1 = r12.this$0
                    r3 = 0
                    com.bilibili.lib.blrouter.RouteRequest$Builder r4 = r13.newBuilder()
                    r5 = 33554432(0x2000000, float:9.403955E-38)
                    com.bilibili.lib.blrouter.RouteRequest$Builder r4 = r4.flags(r5)
                    com.bilibili.lib.blrouter.RouteRequest r4 = r4.build()
                    android.content.Context r1 = (android.content.Context) r1
                    com.bilibili.lib.blrouter.BLRouter.routeTo(r4, r1)
                L5d:
                    tv.danmaku.bili.fast.FastReLoginActivity r13 = r12.this$0
                    tv.danmaku.bili.fast.FastReLoginActivity.access$finish(r13, r2)
                    kotlin.Unit r13 = kotlin.Unit.INSTANCE
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.fast.FastReLoginActivity$routeToLogin$1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }