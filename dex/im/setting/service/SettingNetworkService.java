package im.setting.service;

import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.request.forms.FormBuildersKt;
import io.ktor.http.Parameters;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.reflect.KType;

/* compiled from: SettingNetworkService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lim/setting/service/SettingNetworkService;", "", "<init>", "()V", "stopGroup", "Lkotlin/Result;", "", "stopGroup-IoAF18A$logic_debug", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingNetworkService {
    public static final int $stable = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x0032, B:37:0x00a9, B:39:0x00b4, B:40:0x00bc, B:14:0x0038, B:26:0x0068, B:33:0x0090, B:15:0x003d, B:23:0x0053, B:20:0x004a), top: B:43:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x0032, B:37:0x00a9, B:39:0x00b4, B:40:0x00bc, B:14:0x0038, B:26:0x0068, B:33:0x0090, B:15:0x003d, B:23:0x0053, B:20:0x004a), top: B:43:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x0032, B:37:0x00a9, B:39:0x00b4, B:40:0x00bc, B:14:0x0038, B:26:0x0068, B:33:0x0090, B:15:0x003d, B:23:0x0053, B:20:0x004a), top: B:43:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x0032, B:37:0x00a9, B:39:0x00b4, B:40:0x00bc, B:14:0x0038, B:26:0x0068, B:33:0x0090, B:15:0x003d, B:23:0x0053, B:20:0x004a), top: B:43:0x0021 }] */
    /* renamed from: stopGroup-IoAF18A$logic_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3411stopGroupIoAF18A$logic_debug(Continuation<? super Result<Unit>> continuation) {
        Continuation<Object> settingNetworkService$stopGroup$1;
        Object suspendGetKtorHttpClient;
        Object submitForm;
        KType kType;
        Object bodyNullable;
        try {
            if (continuation instanceof SettingNetworkService$stopGroup$1) {
                settingNetworkService$stopGroup$1 = (SettingNetworkService$stopGroup$1) continuation;
                if ((settingNetworkService$stopGroup$1.label & Integer.MIN_VALUE) != 0) {
                    settingNetworkService$stopGroup$1.label -= Integer.MIN_VALUE;
                    Object $result = settingNetworkService$stopGroup$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (settingNetworkService$stopGroup$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            settingNetworkService$stopGroup$1.label = 1;
                            suspendGetKtorHttpClient = KtorClientKt.suspendGetKtorHttpClient(settingNetworkService$stopGroup$1);
                            if (suspendGetKtorHttpClient == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            settingNetworkService$stopGroup$1.label = 2;
                            submitForm = FormBuildersKt.submitForm((HttpClient) suspendGetKtorHttpClient, "https://api.vc.bilibili.com/link_group/v1/group/disable_fans_group", (r12 & 2) != 0 ? Parameters.Companion.getEmpty() : null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0061: INVOKE  (r1v6 'submitForm' java.lang.Object) = 
                                  (wrap: io.ktor.client.HttpClient : 0x0053: CHECK_CAST (r1v5 io.ktor.client.HttpClient A[REMOVE]) = (io.ktor.client.HttpClient) (r1v4 'suspendGetKtorHttpClient' java.lang.Object))
                                  ("https://api.vc.bilibili.com/link_group/v1/group/disable_fans_group")
                                  (wrap: io.ktor.http.Parameters : ?: TERNARYnull = ((wrap: int : 0x0000: ARITH  (r13v1 int A[REMOVE]) = (r12v0 int) & (2 int)) != (0 int)) ? (wrap: io.ktor.http.Parameters : 0x000a: INVOKE  
                                  (wrap: io.ktor.http.Parameters$Companion : 0x0004: SGET   io.ktor.http.Parameters.Companion io.ktor.http.Parameters$Companion)
                                 type: VIRTUAL call: io.ktor.http.Parameters.Companion.getEmpty():io.ktor.http.Parameters) : (null io.ktor.http.Parameters))
                                  (wrap: boolean : ?: TERNARYnull = ((wrap: int : 0x000d: ARITH  (r8v1 int A[REMOVE]) = (r12v0 int) & (4 int)) != (0 int)) ? false : false)
                                  (wrap: kotlin.jvm.functions.Function1 : ?: TERNARYnull = ((wrap: int : 0x0015: ARITH  (r8v2 int A[REMOVE]) = (r12v0 int) & (8 int)) != (0 int)) ? (wrap: kotlin.jvm.functions.Function1 : 0x001e: CONSTRUCTOR   call: io.ktor.client.request.forms.FormBuildersKt$$ExternalSyntheticLambda1.<init>():void type: CONSTRUCTOR) : (null kotlin.jvm.functions.Function1))
                                  (r0v2 'settingNetworkService$stopGroup$1' kotlin.coroutines.Continuation<java.lang.Object> A[D('$continuation' kotlin.coroutines.Continuation)])
                                 type: STATIC call: io.ktor.client.request.forms.FormBuildersKt.submitForm(io.ktor.client.HttpClient, java.lang.String, io.ktor.http.Parameters, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object in method: im.setting.service.SettingNetworkService.stopGroup-IoAF18A$logic_debug(kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>>):java.lang.Object, file: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.ktor.client.request.forms.FormBuildersKt$$ExternalSyntheticLambda1, state: NOT_LOADED
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
                                	... 39 more
                                */
                            /*
                                this = this;
                                boolean r0 = r13 instanceof im.setting.service.SettingNetworkService$stopGroup$1
                                if (r0 == 0) goto L14
                                r0 = r13
                                im.setting.service.SettingNetworkService$stopGroup$1 r0 = (im.setting.service.SettingNetworkService$stopGroup$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L14
                                int r1 = r0.label
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L19
                            L14:
                                im.setting.service.SettingNetworkService$stopGroup$1 r0 = new im.setting.service.SettingNetworkService$stopGroup$1
                                r0.<init>(r12, r13)
                            L19:
                                java.lang.Object r9 = r0.result
                                java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r0.label
                                switch(r1) {
                                    case 0: goto L45;
                                    case 1: goto L3d;
                                    case 2: goto L38;
                                    case 3: goto L2c;
                                    default: goto L24;
                                }
                            L24:
                                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                                r0.<init>(r1)
                                throw r0
                            L2c:
                                int r1 = r0.I$0
                                java.lang.Object r2 = r0.L$0
                                io.ktor.client.statement.HttpResponse r2 = (io.ktor.client.statement.HttpResponse) r2
                                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L42
                                r3 = r9
                                goto La7
                            L38:
                                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L42
                                r1 = r9
                                goto L68
                            L3d:
                                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L42
                                r1 = r9
                                goto L53
                            L42:
                                r1 = move-exception
                                goto Lbd
                            L45:
                                kotlin.ResultKt.throwOnFailure(r9)
                                r1 = 1
                                r0.label = r1     // Catch: java.lang.Throwable -> L42
                                java.lang.Object r1 = com.bilibili.ktor.KtorClientKt.suspendGetKtorHttpClient(r0)     // Catch: java.lang.Throwable -> L42
                                if (r1 != r10) goto L53
                                return r10
                            L53:
                                io.ktor.client.HttpClient r1 = (io.ktor.client.HttpClient) r1     // Catch: java.lang.Throwable -> L42
                                java.lang.String r2 = "https://api.vc.bilibili.com/link_group/v1/group/disable_fans_group"
                                r3 = 2
                                r0.label = r3     // Catch: java.lang.Throwable -> L42
                                r3 = 0
                                r4 = 0
                                r5 = 0
                                r7 = 14
                                r8 = 0
                                r6 = r0
                                java.lang.Object r1 = io.ktor.client.request.forms.FormBuildersKt.submitForm$default(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L42
                                if (r1 != r10) goto L68
                                return r10
                            L68:
                                io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1     // Catch: java.lang.Throwable -> L42
                                r2 = r1
                                r1 = 0
                                io.ktor.client.call.HttpClientCall r3 = r2.getCall()     // Catch: java.lang.Throwable -> L42
                                r4 = 0
                                java.lang.Class<com.bilibili.ktor.KApiResponse> r5 = com.bilibili.ktor.KApiResponse.class
                                kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)     // Catch: java.lang.Throwable -> L42
                                r6 = 0
                                java.lang.Class<com.bilibili.ktor.KApiResponse> r7 = com.bilibili.ktor.KApiResponse.class
                                kotlin.reflect.KTypeProjection$Companion r8 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L8c
                                java.lang.Class<kotlin.Unit> r11 = kotlin.Unit.class
                                kotlin.reflect.KType r11 = kotlin.jvm.internal.Reflection.nullableTypeOf(r11)     // Catch: java.lang.Throwable -> L8c
                                kotlin.reflect.KTypeProjection r8 = r8.invariant(r11)     // Catch: java.lang.Throwable -> L8c
                                kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7, r8)     // Catch: java.lang.Throwable -> L8c
                                goto L8f
                            L8c:
                                r7 = move-exception
                                r8 = 0
                                r7 = r8
                            L8f:
                                io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo     // Catch: java.lang.Throwable -> L42
                                r6.<init>(r5, r7)     // Catch: java.lang.Throwable -> L42
                                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch: java.lang.Throwable -> L42
                                r0.L$0 = r4     // Catch: java.lang.Throwable -> L42
                                r0.I$0 = r1     // Catch: java.lang.Throwable -> L42
                                r4 = 3
                                r0.label = r4     // Catch: java.lang.Throwable -> L42
                                java.lang.Object r3 = r3.bodyNullable(r6, r0)     // Catch: java.lang.Throwable -> L42
                                if (r3 != r10) goto La7
                                return r10
                            La7:
                                if (r3 == 0) goto Lb4
                                com.bilibili.ktor.KApiResponse r3 = (com.bilibili.ktor.KApiResponse) r3     // Catch: java.lang.Throwable -> L42
                                kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L42
                                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
                                java.lang.Object r1 = kotlin.Result.constructor-impl(r1)     // Catch: java.lang.Throwable -> L42
                                return r1
                            Lb4:
                                java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L42
                                java.lang.String r4 = "null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kotlin.Unit?>"
                                r3.<init>(r4)     // Catch: java.lang.Throwable -> L42
                                throw r3     // Catch: java.lang.Throwable -> L42
                            Lbd:
                                kotlin.Result$Companion r2 = kotlin.Result.Companion
                                java.lang.Object r2 = kotlin.ResultKt.createFailure(r1)
                                java.lang.Object r2 = kotlin.Result.constructor-impl(r2)
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: im.setting.service.SettingNetworkService.m3411stopGroupIoAF18A$logic_debug(kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }