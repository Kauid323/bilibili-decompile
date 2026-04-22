package kntr.common.paragraph.input;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.input.content.AssetContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/common/paragraph/input/RichTextContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$insertAsset$4$1", f = "RichTextStateMachine.kt", i = {0, 0, 0, 0, 0, 0}, l = {241}, m = "invokeSuspend", n = {"it", "$this$forEach$iv", "element$iv", "asset", "$i$f$forEach", "$i$a$-forEach-RichTextStateMachine$insertAsset$4$1$2"}, s = {"L$0", "L$1", "L$4", "L$5", "I$0", "I$1"}, v = 1)
public final class RichTextStateMachine$insertAsset$4$1 extends SuspendLambda implements Function2<RichTextContent, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ RichTextStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextStateMachine$insertAsset$4$1(RichTextStateMachine richTextStateMachine, Continuation<? super RichTextStateMachine$insertAsset$4$1> continuation) {
        super(2, continuation);
        this.this$0 = richTextStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> richTextStateMachine$insertAsset$4$1 = new RichTextStateMachine$insertAsset$4$1(this.this$0, continuation);
        richTextStateMachine$insertAsset$4$1.L$0 = obj;
        return richTextStateMachine$insertAsset$4$1;
    }

    public final Object invoke(RichTextContent richTextContent, Continuation<? super Unit> continuation) {
        return create(richTextContent, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ff  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ef -> B:24:0x00f8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        RichTextStateMachine richTextStateMachine;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Iterator it;
        RichTextStateMachine$insertAsset$4$1 richTextStateMachine$insertAsset$4$1;
        RichTextStateMachine$insertAsset$4$1 richTextStateMachine$insertAsset$4$12;
        Iterable $this$forEach$iv2;
        RichTextStateMachine richTextStateMachine2;
        Iterator it2;
        int $i$f$forEach2;
        RichTextContent it3 = (RichTextContent) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = it3.getAssetMap$core_debug().values();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    AssetContent assetContent = (AssetContent) item$iv$iv;
                    destination$iv$iv.add(assetContent.getUploadState());
                }
                Iterable $this$filterIsInstance$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : $this$filterIsInstance$iv) {
                    if (element$iv$iv instanceof OriginAssetUploadState) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                Iterable $this$forEach$iv3 = (List) destination$iv$iv2;
                richTextStateMachine = this.this$0;
                $this$forEach$iv = $this$forEach$iv3;
                $i$f$forEach = 0;
                it = $this$forEach$iv3.iterator();
                richTextStateMachine$insertAsset$4$1 = this;
                break;
            case 1:
                int i = this.I$1;
                int $i$f$forEach3 = this.I$0;
                OriginAssetUploadState originAssetUploadState = (OriginAssetUploadState) this.L$5;
                Object obj = this.L$4;
                ResultKt.throwOnFailure($result);
                $this$forEach$iv2 = (Iterable) this.L$1;
                richTextStateMachine2 = (RichTextStateMachine) this.L$2;
                it2 = (Iterator) this.L$3;
                $i$f$forEach2 = $i$f$forEach3;
                richTextStateMachine$insertAsset$4$12 = this;
                richTextStateMachine$insertAsset$4$1 = richTextStateMachine$insertAsset$4$12;
                $i$f$forEach = $i$f$forEach2;
                it = it2;
                richTextStateMachine = richTextStateMachine2;
                $this$forEach$iv = $this$forEach$iv2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object element$iv = it.next();
            OriginAssetUploadState asset = (OriginAssetUploadState) element$iv;
            StartAsset startAsset = new StartAsset(asset.getAsset(), asset.getUseOrigin());
            richTextStateMachine$insertAsset$4$1.L$0 = SpillingKt.nullOutSpilledVariable(it3);
            richTextStateMachine$insertAsset$4$1.L$1 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
            richTextStateMachine$insertAsset$4$1.L$2 = richTextStateMachine;
            richTextStateMachine$insertAsset$4$1.L$3 = it;
            richTextStateMachine$insertAsset$4$1.L$4 = SpillingKt.nullOutSpilledVariable(element$iv);
            richTextStateMachine$insertAsset$4$1.L$5 = SpillingKt.nullOutSpilledVariable(asset);
            richTextStateMachine$insertAsset$4$1.I$0 = $i$f$forEach;
            richTextStateMachine$insertAsset$4$1.I$1 = 0;
            richTextStateMachine$insertAsset$4$1.label = 1;
            if (richTextStateMachine.dispatch(startAsset, richTextStateMachine$insertAsset$4$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            int i2 = $i$f$forEach;
            richTextStateMachine$insertAsset$4$12 = richTextStateMachine$insertAsset$4$1;
            $this$forEach$iv2 = $this$forEach$iv;
            richTextStateMachine2 = richTextStateMachine;
            it2 = it;
            $i$f$forEach2 = i2;
            richTextStateMachine$insertAsset$4$1 = richTextStateMachine$insertAsset$4$12;
            $i$f$forEach = $i$f$forEach2;
            it = it2;
            richTextStateMachine = richTextStateMachine2;
            $this$forEach$iv = $this$forEach$iv2;
            if (!it.hasNext()) {
                return Unit.INSTANCE;
            }
        }
    }
}