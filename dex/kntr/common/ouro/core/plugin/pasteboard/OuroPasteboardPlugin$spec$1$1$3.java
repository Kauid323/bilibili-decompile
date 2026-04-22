package kntr.common.ouro.core.plugin.pasteboard;

import com.bilibili.emoticon.Emote;
import com.bilibili.emoticon.EmoticonSize;
import com.bilibili.emoticon.UpperEmoteInfo;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroInsertTextNodesAction;
import kntr.common.ouro.core.action.OuroReplacePlainNodesWithStoragesAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.SerializableNodeStorage;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.mark.OuroUnmergableMark;
import kntr.common.ouro.core.model.node.EmoteParseResult;
import kntr.common.ouro.core.model.node.LinkParseResult;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroLinkKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.RemoteParseResult;
import kntr.common.ouro.core.pasteboard.Pasteboard;
import kntr.common.ouro.core.pasteboard.PasteboardData;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyle;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kntr.common.ouro.core.reducer.OuroEditActionReducerKt;
import kntr.common.ouro.core.utils.EmoteHelperKt;
import kntr.common.ouro.core.utils.FlowReduxUtilsKt;
import kntr.common.ouro.core.utils.LinkUtilsKt;
import kntr.common.ouro.core.utils.MatchString;
import kntr.common.ouro.core.utils.MatchStringType;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.SerializationUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.BinaryFormat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroPasteboardPlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "action", "Lkntr/common/ouro/core/plugin/pasteboard/OuroPasteAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$3", f = "OuroPasteboardPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroPasteboardPlugin$spec$1$1$3 extends SuspendLambda implements Function3<OuroPasteAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    final /* synthetic */ Function2<OuroAction, Continuation<? super Unit>, Object> $dispatch;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OuroPasteboardPlugin this$0;

    /* compiled from: OuroPasteboardPlugin.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MatchStringType.values().length];
            try {
                iArr[MatchStringType.Text.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[MatchStringType.Emote.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[MatchStringType.Link.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OuroPasteboardPlugin$spec$1$1$3(OuroPasteboardPlugin ouroPasteboardPlugin, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super OuroPasteboardPlugin$spec$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = ouroPasteboardPlugin;
        this.$dispatch = function2;
    }

    public final Object invoke(OuroPasteAction ouroPasteAction, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroPasteboardPlugin$spec$1$1$3 ouroPasteboardPlugin$spec$1$1$3 = new OuroPasteboardPlugin$spec$1$1$3(this.this$0, this.$dispatch, continuation);
        ouroPasteboardPlugin$spec$1$1$3.L$0 = ouroPasteAction;
        ouroPasteboardPlugin$spec$1$1$3.L$1 = state;
        return ouroPasteboardPlugin$spec$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        NodeStorage nodeStorage;
        Iterable $this$map$iv;
        boolean z;
        Iterable $this$mapTo$iv$iv;
        OuroTextElement.Plain plain;
        SerializableNodeStorage this_$iv;
        Map destination$iv$iv$iv;
        Map $this$mapKeys$iv$iv;
        boolean z2;
        Map destination$iv$iv$iv2;
        Map map;
        Iterator<T> it;
        final OuroPasteAction action = (OuroPasteAction) this.L$0;
        final State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PasteboardData data = Pasteboard.INSTANCE.getData();
                if (data == null) {
                    return FlowReduxUtilsKt.noChange(state, action.getDeferred());
                }
                PasteboardData data2 = data;
                final String text = data2.getText();
                if (text.length() == 0) {
                    return FlowReduxUtilsKt.noChange(state, action.getDeferred());
                }
                byte[] it2 = data2.getBytes();
                if (it2 != null) {
                    boolean z3 = false;
                    try {
                        BinaryFormat $this$decodeFromByteArray$iv = SerializationUtilsKt.getOuroProtoBuf();
                        $this$decodeFromByteArray$iv.getSerializersModule();
                        this_$iv = (SerializableNodeStorage) $this$decodeFromByteArray$iv.decodeFromByteArray(SerializableNodeStorage.Companion.serializer(), it2);
                        Map $this$mapKeys$iv$iv2 = this_$iv.getParentMap();
                        Iterable $this$associateByTo$iv$iv$iv$iv = $this$mapKeys$iv$iv2.entrySet();
                        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv$iv2.size()));
                        for (Object element$iv$iv$iv$iv : $this$associateByTo$iv$iv$iv$iv) {
                            try {
                                Map.Entry entry$iv = (Map.Entry) element$iv$iv$iv$iv;
                                OuroNode ouroNode = this_$iv.getNodes().get(entry$iv.getKey());
                                if (ouroNode == null) {
                                    throw new IllegalStateException("Node not found for key: " + entry$iv.getKey());
                                }
                                Map.Entry it$iv$iv$iv = (Map.Entry) element$iv$iv$iv$iv;
                                PasteboardData data3 = data2;
                                try {
                                    LinkedHashMap linkedHashMap2 = linkedHashMap;
                                    linkedHashMap2.put(ouroNode, it$iv$iv$iv.getValue());
                                    linkedHashMap = linkedHashMap2;
                                    data2 = data3;
                                } catch (Exception e) {
                                    e = e;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        Map $this$mapValues$iv$iv = linkedHashMap;
                        boolean z4 = false;
                        try {
                            destination$iv$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv$iv.size()));
                            Iterable $this$associateByTo$iv$iv$iv$iv2 = $this$mapValues$iv$iv.entrySet();
                            for (Object element$iv$iv$iv$iv2 : $this$associateByTo$iv$iv$iv$iv2) {
                                Map.Entry it$iv$iv$iv2 = (Map.Entry) element$iv$iv$iv$iv2;
                                Map $this$mapValues$iv$iv2 = $this$mapValues$iv$iv;
                                Object key = it$iv$iv$iv2.getKey();
                                boolean z5 = z4;
                                Map destination$iv$iv$iv3 = destination$iv$iv$iv;
                                OuroNode ouroNode2 = this_$iv.getNodes().get(((Map.Entry) element$iv$iv$iv$iv2).getValue());
                                OuroNode.Parent parent = ouroNode2 instanceof OuroNode.Parent ? (OuroNode.Parent) ouroNode2 : null;
                                if (parent == null) {
                                    throw new IllegalStateException("Parent not found");
                                }
                                destination$iv$iv$iv.put(key, parent);
                                $this$mapValues$iv$iv = $this$mapValues$iv$iv2;
                                z4 = z5;
                                destination$iv$iv$iv = destination$iv$iv$iv3;
                            }
                            $this$mapKeys$iv$iv = this_$iv.getChildrenMap();
                            z2 = false;
                            destination$iv$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv$iv.size()));
                            Iterable $this$associateByTo$iv$iv$iv$iv3 = $this$mapKeys$iv$iv.entrySet();
                            map = destination$iv$iv$iv2;
                            it = $this$associateByTo$iv$iv$iv$iv3.iterator();
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                    while (true) {
                        if (it.hasNext()) {
                            try {
                                Object element$iv$iv$iv$iv3 = it.next();
                                Map.Entry entry$iv2 = (Map.Entry) element$iv$iv$iv$iv3;
                                Map $this$mapKeys$iv$iv3 = $this$mapKeys$iv$iv;
                                boolean z6 = z2;
                                OuroNode ouroNode3 = this_$iv.getNodes().get(entry$iv2.getKey());
                                if (ouroNode3 != null) {
                                    Map.Entry it$iv$iv$iv3 = (Map.Entry) element$iv$iv$iv$iv3;
                                    Map destination$iv$iv$iv4 = destination$iv$iv$iv2;
                                    Object value = it$iv$iv$iv3.getValue();
                                    LinkedHashMap linkedHashMap3 = map;
                                    linkedHashMap3.put(ouroNode3, value);
                                    map = linkedHashMap3;
                                    $this$mapKeys$iv$iv = $this$mapKeys$iv$iv3;
                                    z2 = z6;
                                    destination$iv$iv$iv2 = destination$iv$iv$iv4;
                                } else {
                                    try {
                                        throw new IllegalStateException("Node not found for key: " + entry$iv2.getKey());
                                    } catch (Exception e5) {
                                        e = e5;
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } else {
                            Map $this$mapValues$iv$iv3 = map;
                            boolean z7 = false;
                            try {
                                Map destination$iv$iv$iv5 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv$iv3.size()));
                                Map $this$mapValuesTo$iv$iv$iv = $this$mapValues$iv$iv3;
                                Iterable $this$associateByTo$iv$iv$iv$iv4 = $this$mapValuesTo$iv$iv$iv.entrySet();
                                for (Object element$iv$iv$iv$iv4 : $this$associateByTo$iv$iv$iv$iv4) {
                                    Map.Entry it$iv$iv$iv4 = (Map.Entry) element$iv$iv$iv$iv4;
                                    Map $this$mapValues$iv$iv4 = $this$mapValues$iv$iv3;
                                    Object key2 = it$iv$iv$iv4.getKey();
                                    boolean z8 = z7;
                                    Map destination$iv$iv$iv6 = destination$iv$iv$iv5;
                                    boolean z9 = z3;
                                    Iterable $this$map$iv$iv = (Iterable) ((Map.Entry) element$iv$iv$iv$iv4).getValue();
                                    Map $this$mapValuesTo$iv$iv$iv2 = $this$mapValuesTo$iv$iv$iv;
                                    try {
                                        Collection destination$iv$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
                                        Iterable $this$mapTo$iv$iv$iv = $this$map$iv$iv;
                                        for (Object item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                                            String childKey$iv = (String) item$iv$iv$iv;
                                            Iterable $this$map$iv$iv2 = $this$map$iv$iv;
                                            Iterable $this$mapTo$iv$iv$iv2 = $this$mapTo$iv$iv$iv;
                                            OuroNode ouroNode4 = this_$iv.getNodes().get(childKey$iv);
                                            if (ouroNode4 == null) {
                                                throw new IllegalStateException("Node not found for key: " + childKey$iv);
                                            }
                                            destination$iv$iv$iv7.add(ouroNode4);
                                            $this$map$iv$iv = $this$map$iv$iv2;
                                            $this$mapTo$iv$iv$iv = $this$mapTo$iv$iv$iv2;
                                        }
                                        destination$iv$iv$iv5.put(key2, (List) destination$iv$iv$iv7);
                                        $this$mapValues$iv$iv3 = $this$mapValues$iv$iv4;
                                        $this$mapValuesTo$iv$iv$iv = $this$mapValuesTo$iv$iv$iv2;
                                        z7 = z8;
                                        destination$iv$iv$iv5 = destination$iv$iv$iv6;
                                        z3 = z9;
                                    } catch (Exception e7) {
                                        e = e7;
                                    }
                                }
                                OuroNode ouroNode5 = this_$iv.getNodes().get(this_$iv.getRoot());
                                if (!(ouroNode5 instanceof OuroDocument)) {
                                    ouroNode5 = null;
                                }
                                OuroDocument ouroDocument = (OuroDocument) ouroNode5;
                                if (ouroDocument == null) {
                                    throw new IllegalStateException("Root node not found or of incorrect type");
                                }
                                nodeStorage = new NodeStorage(ouroDocument, destination$iv$iv$iv, destination$iv$iv$iv5);
                            } catch (Exception e8) {
                                e = e8;
                            }
                        }
                        KLog_androidKt.getKLog().w("OuroPasteboardPlugin", "paste from pasteboard failed: " + e);
                        nodeStorage = null;
                    }
                } else {
                    nodeStorage = null;
                }
                final NodeStorage document = nodeStorage;
                if (document == null) {
                    List res = LinkUtilsKt.extractUris(text);
                    List $this$filter$iv = res;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        if (((MatchString) element$iv$iv).getType() != MatchStringType.Text) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                    }
                    Iterable $this$map$iv2 = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        destination$iv$iv2.add(((MatchString) item$iv$iv).getRawText());
                    }
                    List parseList = (List) destination$iv$iv2;
                    if (parseList.isEmpty()) {
                        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$3$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                OuroState invokeSuspend$lambda$4;
                                invokeSuspend$lambda$4 = OuroPasteboardPlugin$spec$1$1$3.invokeSuspend$lambda$4(OuroPasteAction.this, text, state, (OuroState) obj);
                                return invokeSuspend$lambda$4;
                            }
                        });
                    }
                    List $this$map$iv3 = res;
                    boolean z10 = false;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    Iterable $this$mapTo$iv$iv2 = $this$map$iv3;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                        MatchString it3 = (MatchString) item$iv$iv2;
                        List res2 = res;
                        switch (WhenMappings.$EnumSwitchMapping$0[it3.getType().ordinal()]) {
                            case 1:
                                $this$map$iv = $this$map$iv3;
                                z = z10;
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                plain = new OuroTextElement.Plain(it3.getRawText(), (OuroMarks) null, 2, (DefaultConstructorMarker) null);
                                break;
                            case 2:
                                $this$map$iv = $this$map$iv3;
                                z = z10;
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                plain = new OuroTextElement.Plain(it3.getRawText(), new OuroMarks(OuroUnmergableMark.INSTANCE));
                                break;
                            case 3:
                                $this$map$iv = $this$map$iv3;
                                z = z10;
                                plain = new OuroTextElement.Plain(it3.getRawText(), new OuroMarks(OuroUnderlineMark.INSTANCE, OuroUnmergableMark.INSTANCE));
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        destination$iv$iv3.add(plain);
                        res = res2;
                        $this$map$iv3 = $this$map$iv;
                        z10 = z;
                        $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    }
                    List plainTextNodes = (List) destination$iv$iv3;
                    BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, parseList, plainTextNodes, this.$dispatch, null), 3, (Object) null);
                    return OuroEditActionReducerKt.handleInsertTextNodes(new OuroInsertTextNodesAction(plainTextNodes, action.getRange(), action.getDeferred()), state);
                }
                return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$5;
                        invokeSuspend$lambda$5 = OuroPasteboardPlugin$spec$1$1$3.invokeSuspend$lambda$5(OuroPasteAction.this, document, (OuroState) obj);
                        return invokeSuspend$lambda$5;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OuroPasteboardPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$3$1", f = "OuroPasteboardPlugin.kt", i = {1, 1, 1, 1}, l = {124, 158}, m = "invokeSuspend", n = {"results", "replaceList", "map", "$i$a$-onSuccess-OuroPasteboardPlugin$spec$1$1$3$1$1"}, s = {"L$1", "L$2", "L$3", "I$0"}, v = 1)
    /* renamed from: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<OuroAction, Continuation<? super Unit>, Object> $dispatch;
        final /* synthetic */ List<String> $parseList;
        final /* synthetic */ List<OuroTextElement.Plain> $plainTextNodes;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ OuroPasteboardPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(OuroPasteboardPlugin ouroPasteboardPlugin, List<String> list, List<OuroTextElement.Plain> list2, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = ouroPasteboardPlugin;
            this.$parseList = list;
            this.$plainTextNodes = list2;
            this.$dispatch = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$parseList, this.$plainTextNodes, this.$dispatch, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01d1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            LinkParseService linkParseService;
            Object obj;
            Iterable $this$mapNotNullTo$iv$iv;
            boolean z;
            Iterable $this$forEach$iv$iv$iv;
            Pair pair;
            Pair pair2;
            Throwable error;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    linkParseService = this.this$0.linkParseService;
                    this.label = 1;
                    Object mo1885parsegIAlus = linkParseService.mo1885parsegIAlus(this.$parseList, (Continuation) this);
                    if (mo1885parsegIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = mo1885parsegIAlus;
                    Object obj2 = this.$plainTextNodes;
                    Function2<OuroAction, Continuation<? super Unit>, Object> function2 = this.$dispatch;
                    if (Result.m2643isSuccessimpl(obj)) {
                        List results = (List) obj;
                        if (!results.isEmpty()) {
                            List $this$associateBy$iv = results;
                            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                            for (Object element$iv$iv : $this$associateBy$iv) {
                                RemoteParseResult it = (RemoteParseResult) element$iv$iv;
                                destination$iv$iv.put(it.getRaw(), element$iv$iv);
                            }
                            Object it$iv$iv = (Iterable) obj2;
                            boolean z2 = false;
                            Collection destination$iv$iv2 = new ArrayList();
                            Object $this$mapNotNullTo$iv$iv2 = it$iv$iv;
                            boolean z3 = false;
                            Iterable $this$forEach$iv$iv$iv2 = $this$mapNotNullTo$iv$iv2;
                            Iterator<T> it2 = $this$forEach$iv$iv$iv2.iterator();
                            while (true) {
                                Object $this$mapNotNull$iv = it$iv$iv;
                                if (it2.hasNext()) {
                                    Object element$iv$iv$iv = it2.next();
                                    OuroTextElement.Plain node = (OuroTextElement.Plain) element$iv$iv$iv;
                                    boolean z4 = z2;
                                    RemoteParseResult result = (RemoteParseResult) destination$iv$iv.get(node.getMeta());
                                    if (result == null) {
                                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                        z = z3;
                                        $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv2;
                                        pair2 = null;
                                    } else {
                                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                        if (result instanceof EmoteParseResult) {
                                            z = z3;
                                            $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv2;
                                            pair = TuplesKt.to(node, EmoteHelperKt.nodeStorage$default(new Emote(0L, 0L, 0, 0L, ((EmoteParseResult) result).getRaw(), 0, ((EmoteParseResult) result).getUrl(), (String) null, new Emote.EmoteMeta(Intrinsics.areEqual(((EmoteParseResult) result).getEmoteSize(), "large") ? EmoticonSize.LARGE : EmoticonSize.SMALL, (String) null, (List) null, (String) null, (String) null, 0L, (String) null, (String) null, 254, (DefaultConstructorMarker) null), (Emote.EmoteFlags) null, (Emote.EmoteActivity) null, (String) null, (String) null, (UpperEmoteInfo) null, 16047, (DefaultConstructorMarker) null), null, 1, null));
                                        } else {
                                            z = z3;
                                            $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv2;
                                            if (!(result instanceof LinkParseResult)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            pair = TuplesKt.to(node, OuroLinkKt.createStorage((LinkParseResult) result));
                                        }
                                        pair2 = pair;
                                    }
                                    if (pair2 != null) {
                                        destination$iv$iv2.add(pair2);
                                    }
                                    it$iv$iv = $this$mapNotNull$iv;
                                    z2 = z4;
                                    $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                                    z3 = z;
                                    $this$forEach$iv$iv$iv2 = $this$forEach$iv$iv$iv;
                                } else {
                                    List replaceList = (List) destination$iv$iv2;
                                    if (!replaceList.isEmpty()) {
                                        OuroReplacePlainNodesWithStoragesAction ouroReplacePlainNodesWithStoragesAction = new OuroReplacePlainNodesWithStoragesAction(replaceList, null, 2, null);
                                        this.L$0 = obj;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(results);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(replaceList);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                                        this.I$0 = 0;
                                        this.label = 2;
                                        if (function2.invoke(ouroReplacePlainNodesWithStoragesAction, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    error = Result.m2639exceptionOrNullimpl(obj);
                    if (error != null) {
                        KLog_androidKt.getKLog().w("OuroPasteboardPlugin", "Link parse failed: " + error.getMessage());
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = ((Result) $result).m2645unboximpl();
                    Object obj22 = this.$plainTextNodes;
                    Function2<OuroAction, Continuation<? super Unit>, Object> function22 = this.$dispatch;
                    if (Result.m2643isSuccessimpl(obj)) {
                    }
                    error = Result.m2639exceptionOrNullimpl(obj);
                    if (error != null) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    int i = this.I$0;
                    Map map = (Map) this.L$3;
                    List list = (List) this.L$2;
                    List list2 = (List) this.L$1;
                    obj = this.L$0;
                    ResultKt.throwOnFailure($result);
                    error = Result.m2639exceptionOrNullimpl(obj);
                    if (error != null) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$4(OuroPasteAction $action, String $text, State $state, OuroState $this$mutate) {
        OuroMarks<OuroTextMark> textMarks;
        OuroTextStyle insertTextStyle;
        OuroTextRange range = $action.getRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        OuroState this_$iv = (OuroState) $state.getSnapshot();
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
        OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroTextStyleState)) {
            ouroPluginState = null;
        }
        OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
        if (ouroTextStyleState == null || (insertTextStyle = ouroTextStyleState.getInsertTextStyle()) == null || (textMarks = insertTextStyle.getMarks()) == null) {
            textMarks = OuroMarks.Empty.INSTANCE.getTextMarks();
        }
        return OuroEditActionReducerKt.replaceText($this$mutate, range, null, $text, textMarks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$5(OuroPasteAction $action, final NodeStorage $document, final OuroState $this$mutate) {
        OuroTextRange textRangeAfter;
        final OuroTextRange range = $action.getRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate($this$mutate.getStorage(), range, $this$mutate.getDisplayLengthTransform(), new Function2() { // from class: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$3$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit invokeSuspend$lambda$5$0;
                invokeSuspend$lambda$5$0 = OuroPasteboardPlugin$spec$1$1$3.invokeSuspend$lambda$5$0(NodeStorage.this, range, $this$mutate, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return invokeSuspend$lambda$5$0;
            }
        });
        OuroNode.Selectable it = (OuroNode.Selectable) CollectionsKt.lastOrNull($document.getAllSelectables());
        OuroTextRange newRange = (it == null || (textRangeAfter = OuroNodeStorageUtilsKt.getTextRangeAfter(newStorage, it, $this$mutate.getDisplayLengthTransform())) == null) ? new OuroTextRange(range.getMin(), range.getMin()) : textRangeAfter;
        return OuroState.copy$default($this$mutate, newStorage, newRange, null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$5$0(NodeStorage $document, OuroTextRange $range, OuroState $this_mutate, NodeStorageBuilder $this$mutate, OuroSelection it) {
        OuroEditActionReducerKt.removeSelectedElements($this$mutate, it);
        OuroEditActionReducerKt.insertDocument($this$mutate, $document, $range.getMin(), $this_mutate.getDisplayLengthTransform());
        return Unit.INSTANCE;
    }
}