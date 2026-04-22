package tv.danmaku.bili.core.test;

import android.view.View;
import com.bilibili.homepage.HomeTabInfo;
import com.bilibili.homepage.HomeTabService;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.ForceUpdateHomeTab$onClick$1", f = "MainTestPageActivity.kt", i = {}, l = {BR.errorVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ForceUpdateHomeTab$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeTabService $service;
    final /* synthetic */ View $view;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceUpdateHomeTab$onClick$1(HomeTabService homeTabService, View view, Continuation<? super ForceUpdateHomeTab$onClick$1> continuation) {
        super(2, continuation);
        this.$service = homeTabService;
        this.$view = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForceUpdateHomeTab$onClick$1(this.$service, this.$view, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
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
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:365)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:313)
        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
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
        */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 1
            switch(r1) {
                case 0: goto L19;
                case 1: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L12:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L17
            r0 = r12
            goto L2d
        L17:
            r0 = move-exception
            goto L32
        L19:
            kotlin.ResultKt.throwOnFailure(r12)
            com.bilibili.homepage.HomeTabService r1 = r11.$service     // Catch: java.lang.Exception -> L17
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: java.lang.Exception -> L17
            r11.label = r2     // Catch: java.lang.Exception -> L17
            java.lang.Object r1 = r1.updateTabsFromRemote(r3)     // Catch: java.lang.Exception -> L17
            if (r1 != r0) goto L2b
            return r0
        L2b:
            r0 = r12
            r12 = r1
        L2d:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Exception -> L30
            goto L39
        L30:
            r12 = move-exception
            r12 = r0
        L32:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r10 = r0
            r0 = r12
            r12 = r10
        L39:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L40:
            boolean r1 = r12.hasNext()
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L64
            java.lang.Object r1 = r12.next()
            r5 = r1
            com.bilibili.homepage.HomeTabInfo r5 = (com.bilibili.homepage.HomeTabInfo) r5
            r6 = 0
            java.lang.String r7 = r5.getTab_url()
            r8 = 0
            if (r7 == 0) goto L61
            java.lang.String r9 = "bilibili://campus/home_tab"
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r7, r9, r8, r3, r4)
            if (r2 != r7) goto L61
            r8 = r2
        L61:
            if (r8 == 0) goto L40
            goto L65
        L64:
            r1 = r4
        L65:
            com.bilibili.homepage.HomeTabInfo r1 = (com.bilibili.homepage.HomeTabInfo) r1
            r12 = r1
            if (r12 == 0) goto L79
            java.lang.String r1 = r12.getHome_tab_url()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.bilibili.lib.blrouter.RouteRequest r1 = com.bilibili.lib.blrouter.RouteRequestKt.toRouteRequest(r1)
            com.bilibili.lib.blrouter.BLRouter.routeTo$default(r1, r4, r3, r4)
            goto L85
        L79:
            android.view.View r12 = r11.$view
            android.content.Context r12 = r12.getContext()
            java.lang.String r1 = "没有找到校园tab"
            com.bilibili.droid.ToastHelper.showToastShort(r12, r1)
        L85:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.core.test.ForceUpdateHomeTab$onClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}