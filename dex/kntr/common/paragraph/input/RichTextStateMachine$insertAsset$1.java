package kntr.common.paragraph.input;

import com.bilibili.blens.TypeKt;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.paragraph.input.content.TextContentLensKt;
import kntr.common.paragraph.input.content.TextRange;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/input/RichTextContent;", "action", "Lkntr/common/paragraph/input/RichTextAction$AddAsset;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$insertAsset$1", f = "RichTextStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichTextStateMachine$insertAsset$1 extends SuspendLambda implements Function3<RichTextAction.AddAsset, State<RichTextContent>, Continuation<? super ChangedState<? extends RichTextContent>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RichTextStateMachine$insertAsset$1(Continuation<? super RichTextStateMachine$insertAsset$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(RichTextAction.AddAsset addAsset, State<RichTextContent> state, Continuation<? super ChangedState<RichTextContent>> continuation) {
        RichTextStateMachine$insertAsset$1 richTextStateMachine$insertAsset$1 = new RichTextStateMachine$insertAsset$1(continuation);
        richTextStateMachine$insertAsset$1.L$0 = addAsset;
        richTextStateMachine$insertAsset$1.L$1 = state;
        return richTextStateMachine$insertAsset$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        RichTextAction.AddAsset action;
        Iterable $this$map$iv;
        boolean z;
        Object answer$iv;
        RichTextAction.AddAsset action2 = (RichTextAction.AddAsset) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action2.getAsset().isEmpty()) {
                    return state.noChange();
                }
                RichTextContent snapshot = (RichTextContent) state.getSnapshot();
                final Map assetMap = MapsKt.toMutableMap(snapshot.getAssetMap$core_debug());
                Iterable $this$map$iv2 = action2.getAsset();
                boolean z2 = false;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    SelectedAsset it = (SelectedAsset) item$iv$iv;
                    Asset asset = it.getAsset();
                    Object value$iv = assetMap.get(asset);
                    if (value$iv == null) {
                        action = action2;
                        $this$map$iv = $this$map$iv2;
                        z = z2;
                        answer$iv = new AssetContent(new OriginAssetUploadState(it.getAsset(), it.getUseOrigin()));
                        assetMap.put(asset, answer$iv);
                    } else {
                        action = action2;
                        $this$map$iv = $this$map$iv2;
                        z = z2;
                        answer$iv = value$iv;
                    }
                    destination$iv$iv.add((AssetContent) answer$iv);
                    action2 = action;
                    $this$map$iv2 = $this$map$iv;
                    z2 = z;
                }
                final List assetContent = (List) destination$iv$iv;
                int it2 = snapshot.getCurrentFocus();
                final int currentFocus = RangesKt.coerceIn(it2 == -1 ? snapshot.getContentList().size() - 1 : it2, 0, snapshot.getContentList().size() - 1);
                ParagraphContent originContent = snapshot.getContentList().get(currentFocus);
                if (originContent instanceof TextContent) {
                    Pair splitList = ((TextContent) originContent).splitForInsertingAsset();
                    List $this$invokeSuspend_u24lambda_u242 = CollectionsKt.createListBuilder();
                    $this$invokeSuspend_u24lambda_u242.addAll(snapshot.getContentList().subList(0, currentFocus));
                    TextContent it3 = splitList.getFirst();
                    if (it3 != null) {
                        Boxing.boxBoolean($this$invokeSuspend_u24lambda_u242.add(it3));
                    }
                    $this$invokeSuspend_u24lambda_u242.addAll(assetContent);
                    TextContent it4 = splitList.getSecond();
                    if (it4 != null) {
                        Boxing.boxBoolean($this$invokeSuspend_u24lambda_u242.add(it4));
                    }
                    $this$invokeSuspend_u24lambda_u242.addAll(snapshot.getContentList().subList(currentFocus + 1, snapshot.getContentList().size()));
                    if (CollectionsKt.lastOrNull($this$invokeSuspend_u24lambda_u242) instanceof AssetContent) {
                        $this$invokeSuspend_u24lambda_u242.add(new TextContent("", null, null, 6, null));
                    }
                    final List newList = CollectionsKt.build($this$invokeSuspend_u24lambda_u242);
                    return state.mutate(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$insertAsset$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            RichTextContent invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = RichTextStateMachine$insertAsset$1.invokeSuspend$lambda$3(newList, currentFocus, assetContent, assetMap, (RichTextContent) obj);
                            return invokeSuspend$lambda$3;
                        }
                    });
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichTextContent invokeSuspend$lambda$3(final List $newList, final int $currentFocus, final List $assetContent, final Map $assetMap, RichTextContent $this$mutate) {
        return (RichTextContent) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$insertAsset$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$3$0;
                invokeSuspend$lambda$3$0 = RichTextStateMachine$insertAsset$1.invokeSuspend$lambda$3$0($newList, $currentFocus, $assetContent, $assetMap, (CopyScope) obj);
                return invokeSuspend$lambda$3$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3$0(List $newList, int $currentFocus, List $assetContent, Map $assetMap, CopyScope $this$copy) {
        $this$copy.set(RichTextContentLensKt.getContentList(RichTextContent.Companion), $newList);
        int start = $assetContent.size() + $currentFocus;
        List $this$indexOfFirst$iv = $newList.subList(start, $newList.size());
        int index$iv = 0;
        Iterator it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                ParagraphContent it2 = (ParagraphContent) item$iv;
                if (it2 instanceof TextContent) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        final int focus = RangesKt.coerceAtLeast(index$iv, 0) + start;
        $this$copy.set(RichTextContentLensKt.getCurrentFocus(RichTextContent.Companion), Integer.valueOf(focus));
        $this$copy.set(RichTextContentLensKt.getFocusConsumed(RichTextContent.Companion), false);
        $this$copy.set(TextContentLensKt.getSelection(TypeKt.nullableCast(com.bilibili.blens.CollectionsKt.single(RichTextContentLensKt.getContentList(RichTextContent.Companion), new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$insertAsset$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int invokeSuspend$lambda$3$0$1;
                invokeSuspend$lambda$3$0$1 = RichTextStateMachine$insertAsset$1.invokeSuspend$lambda$3$0$1(focus, (List) obj);
                return Integer.valueOf(invokeSuspend$lambda$3$0$1);
            }
        }), Reflection.getOrCreateKotlinClass(TextContent.class))), new TextRange(0));
        $this$copy.set(RichTextContentLensKt.getAssetMap(RichTextContent.Companion), MapsKt.toMap($assetMap));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$3$0$1(int $focus, List $this$single) {
        return $focus;
    }
}