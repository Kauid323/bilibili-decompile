package kntr.app.tribee.publish.core.v2.serviceImpl.create;

import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpusAttachments;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermission;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KCreateCheckTribeeResp;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishNewContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.core.v2.service.TribeeDraftContent;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroReplaceStorageAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.SerializableNodeStorage;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishCreateInitServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishNewContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeePublishCreateInitServiceImpl$initBlock$1$1", f = "TribeePublishCreateInitServiceImpl.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {66, 87, 93, 123}, m = "invokeSuspend", n = {"state", "limitDeferred", "state", "limitDeferred", "limitResult", "limitInfo", "permission", "categories", "selectedCategory", "state", "limitDeferred", "limitResult", "limitInfo", "permission", "categories", "selectedCategory", "draft", "selectedCategory", "state", "limitDeferred", "limitResult", "limitInfo", "permission", "categories", "selectedCategory", "draft", "selectedCategory", "settingItems", "storage"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 1)
public final class TribeePublishCreateInitServiceImpl$initBlock$1$1 extends SuspendLambda implements Function2<State<TribeePublishNewContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ TribeePublishCreateInitServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishCreateInitServiceImpl$initBlock$1$1(TribeePublishCreateInitServiceImpl tribeePublishCreateInitServiceImpl, Continuation<? super TribeePublishCreateInitServiceImpl$initBlock$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeePublishCreateInitServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeePublishCreateInitServiceImpl$initBlock$1$1 = new TribeePublishCreateInitServiceImpl$initBlock$1$1(this.this$0, continuation);
        tribeePublishCreateInitServiceImpl$initBlock$1$1.L$0 = obj;
        return tribeePublishCreateInitServiceImpl$initBlock$1$1;
    }

    public final Object invoke(State<TribeePublishNewContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
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
        */
    /* JADX WARN: Removed duplicated region for block: B:168:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x013f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r47) {
        /*
            Method dump skipped, instructions count: 1550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeePublishCreateInitServiceImpl$initBlock$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$1(State $state, List $categories, KTribeeCategory $selectedCategory, Object $limitResult, TribeePublishNewContent $this$override) {
        KTribeePublishConfig kTribeePublishConfig;
        NodeStorage<OuroDocument> empty = NodeStorage.Companion.getEmpty();
        TribeeInfo tribeeInfo = ((TribeePublishNewContent) $state.getSnapshot()).getTribeeInfo();
        kTribeePublishConfig = TribeePublishCreateInitServiceImplKt.DefaultLimitInfo;
        Throwable m2639exceptionOrNullimpl = Result.m2639exceptionOrNullimpl($limitResult);
        return new TribeePublishContent("", empty, null, tribeeInfo, kTribeePublishConfig, $categories, $selectedCategory, false, null, false, false, false, false, m2639exceptionOrNullimpl != null ? m2639exceptionOrNullimpl.getMessage() : null, 6916, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$4(TribeePublishContent $content, TribeePublishNewContent $this$override) {
        return $content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$5(State $state, KTribeePublishConfig $limitInfo, List $categories, KTribeeCategory $selectedCategory, Map $settingItems, TribeePublishNewContent $this$override) {
        return new TribeePublishContent("", NodeStorage.Companion.getEmpty(), null, ((TribeePublishNewContent) $state.getSnapshot()).getTribeeInfo(), $limitInfo, $categories, $selectedCategory, true, $settingItems, false, false, false, false, null, 14852, null);
    }
}