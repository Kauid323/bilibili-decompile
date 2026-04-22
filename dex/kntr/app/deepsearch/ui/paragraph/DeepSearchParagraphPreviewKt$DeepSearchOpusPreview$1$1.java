package kntr.app.deepsearch.ui.paragraph;

import androidx.compose.runtime.MutableState;
import com.bapis.bilibili.app.archive.middleware.v1.KPlayerArgs;
import com.bapis.bilibili.app.dynamic.common.KTranslateSwitch;
import com.bapis.bilibili.app.dynamic.v2.KAdParam;
import com.bapis.bilibili.app.dynamic.v2.KConfig;
import com.bapis.bilibili.app.dynamic.v2.KModule;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KOpusDetailReq;
import com.bapis.bilibili.app.dynamic.v2.KOpusDetailResp;
import com.bapis.bilibili.app.dynamic.v2.KOpusItem;
import com.bapis.bilibili.app.dynamic.v2.KOpusMoss;
import com.bapis.bilibili.app.dynamic.v2.KOpusType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchParagraphPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1", f = "DeepSearchParagraphPreview.kt", i = {0, 0, 0}, l = {50}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $opus_id;
    final /* synthetic */ MutableState<List<KModuleParagraph>> $paragraph$delegate;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1(String str, MutableState<List<KModuleParagraph>> mutableState, Continuation<? super DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1> continuation) {
        super(2, continuation);
        this.$opus_id = str;
        this.$paragraph$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1 = new DeepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1(this.$opus_id, this.$paragraph$delegate, continuation);
        deepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1.L$0 = obj;
        return deepSearchParagraphPreviewKt$DeepSearchOpusPreview$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        List emptyList;
        Iterable modules;
        Object opusDetail;
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$opus_id;
                    Result.Companion companion = Result.Companion;
                    KOpusMoss kOpusMoss = new KOpusMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    KOpusDetailReq kOpusDetailReq = new KOpusDetailReq((KOpusType) null, Long.parseLong(str), 0L, (String) null, 0, 0, (KPlayerArgs) null, (KConfig) null, (KAdParam) null, (String) null, (String) null, (KTranslateSwitch) null, 4093, (DefaultConstructorMarker) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                    this.I$0 = 0;
                    this.label = 1;
                    opusDetail = kOpusMoss.opusDetail(kOpusDetailReq, this);
                    if (opusDetail != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$1;
                    ResultKt.throwOnFailure($result);
                    opusDetail = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = Result.constructor-impl((KOpusDetailResp) opusDetail);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        MutableState<List<KModuleParagraph>> mutableState = this.$paragraph$delegate;
        if (Result.exceptionOrNull-impl(obj) == null) {
            KOpusDetailResp resp = (KOpusDetailResp) obj;
            KOpusItem opusItem = resp.getOpusItem();
            if (opusItem != null && (modules = opusItem.getModules()) != null) {
                Iterable $this$mapNotNull$iv = modules;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    KModule it = (KModule) element$iv$iv$iv;
                    KModule.KModuleParagraph moduleItem = it.getModuleItem();
                    KOpusDetailResp resp2 = resp;
                    KModule.KModuleParagraph kModuleParagraph = moduleItem instanceof KModule.KModuleParagraph ? moduleItem : null;
                    if (kModuleParagraph != null) {
                        destination$iv$iv.add(kModuleParagraph);
                    }
                    resp = resp2;
                }
                Iterable $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    KModule.KModuleParagraph it2 = (KModule.KModuleParagraph) item$iv$iv;
                    destination$iv$iv2.add(it2.getValue());
                }
                emptyList = (List) destination$iv$iv2;
                mutableState.setValue(emptyList);
            }
            emptyList = CollectionsKt.emptyList();
            mutableState.setValue(emptyList);
        }
        return Unit.INSTANCE;
    }
}