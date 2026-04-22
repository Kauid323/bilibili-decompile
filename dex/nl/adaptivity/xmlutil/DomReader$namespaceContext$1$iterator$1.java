package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import nl.adaptivity.xmlutil.XmlEvent;
import nl.adaptivity.xmlutil.dom2.Attr;
import nl.adaptivity.xmlutil.dom2.Element;
import nl.adaptivity.xmlutil.dom2.NamedNodeMap;
import org.webrtc.H265Utils;

/* compiled from: DomReader.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lnl/adaptivity/xmlutil/Namespace;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "nl.adaptivity.xmlutil.DomReader$namespaceContext$1$iterator$1", f = "DomReader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {178, H265Utils.kLevel6_2}, m = "invokeSuspend", n = {"$this$sequence", "c", "$this$forEachAttr$iv", "l$iv", "idx$iv", "$this$sequence", "c", "$this$forEachAttr$iv", "l$iv", "idx$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
final class DomReader$namespaceContext$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Namespace>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DomReader$namespaceContext$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomReader$namespaceContext$1$iterator$1(DomReader$namespaceContext$1 domReader$namespaceContext$1, Continuation<? super DomReader$namespaceContext$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = domReader$namespaceContext$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DomReader$namespaceContext$1$iterator$1 domReader$namespaceContext$1$iterator$1 = new DomReader$namespaceContext$1$iterator$1(this.this$0, continuation);
        domReader$namespaceContext$1$iterator$1.L$0 = obj;
        return domReader$namespaceContext$1$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Namespace> sequenceScope, Continuation<? super Unit> continuation) {
        return ((DomReader$namespaceContext$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0060 -> B:11:0x0073). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b7 -> B:37:0x00f9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00cb -> B:37:0x00f9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d5 -> B:37:0x00f9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00f6 -> B:36:0x00f8). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        SequenceScope $this$sequence;
        Element c;
        DomReader$namespaceContext$1$iterator$1 domReader$namespaceContext$1$iterator$1;
        int idx$iv;
        NamedNodeMap $this$forEachAttr$iv;
        Element c2;
        int l$iv;
        DomReader$namespaceContext$1$iterator$1 domReader$namespaceContext$1$iterator$12;
        SequenceScope $this$sequence2;
        SequenceScope $this$sequence3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$sequence = (SequenceScope) this.L$0;
                c = this.this$0.currentElement;
                domReader$namespaceContext$1$iterator$1 = this;
                break;
            case 1:
                idx$iv = this.I$1;
                int l$iv2 = this.I$0;
                $this$forEachAttr$iv = (NamedNodeMap) this.L$2;
                Element c3 = (Element) this.L$1;
                SequenceScope $this$sequence4 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure($result);
                SequenceScope $this$sequence5 = $this$sequence4;
                c2 = c3;
                l$iv = l$iv2;
                domReader$namespaceContext$1$iterator$12 = this;
                $this$sequence2 = $this$sequence5;
                idx$iv++;
                if (idx$iv < l$iv) {
                    Attr attr = $this$forEachAttr$iv.item(idx$iv);
                    Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type nl.adaptivity.xmlutil.dom2.Attr");
                    if (Intrinsics.areEqual(attr.getPrefix(), XMLConstants.XMLNS_ATTRIBUTE)) {
                        String localName = attr.getLocalName();
                        if (localName == null) {
                            localName = attr.getName();
                        }
                        XmlEvent.NamespaceImpl namespaceImpl = new XmlEvent.NamespaceImpl(localName, attr.getValue());
                        domReader$namespaceContext$1$iterator$12.L$0 = $this$sequence2;
                        domReader$namespaceContext$1$iterator$12.L$1 = c2;
                        domReader$namespaceContext$1$iterator$12.L$2 = $this$forEachAttr$iv;
                        domReader$namespaceContext$1$iterator$12.I$0 = l$iv;
                        domReader$namespaceContext$1$iterator$12.I$1 = idx$iv;
                        domReader$namespaceContext$1$iterator$12.label = 1;
                        if ($this$sequence2.yield(namespaceImpl, domReader$namespaceContext$1$iterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$sequence5 = $this$sequence2;
                        $this$sequence2 = $this$sequence5;
                        idx$iv++;
                        if (idx$iv < l$iv) {
                        }
                    } else {
                        String prefix = attr.getPrefix();
                        if ((prefix == null || prefix.length() == 0) && Intrinsics.areEqual(attr.getLocalName(), XMLConstants.XMLNS_ATTRIBUTE)) {
                            XmlEvent.NamespaceImpl namespaceImpl2 = new XmlEvent.NamespaceImpl("", attr.getValue());
                            domReader$namespaceContext$1$iterator$12.L$0 = $this$sequence2;
                            domReader$namespaceContext$1$iterator$12.L$1 = c2;
                            domReader$namespaceContext$1$iterator$12.L$2 = $this$forEachAttr$iv;
                            domReader$namespaceContext$1$iterator$12.I$0 = l$iv;
                            domReader$namespaceContext$1$iterator$12.I$1 = idx$iv;
                            domReader$namespaceContext$1$iterator$12.label = 2;
                            if ($this$sequence2.yield(namespaceImpl2, domReader$namespaceContext$1$iterator$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$sequence3 = $this$sequence2;
                            $this$sequence2 = $this$sequence3;
                        }
                        idx$iv++;
                        if (idx$iv < l$iv) {
                            domReader$namespaceContext$1$iterator$1 = domReader$namespaceContext$1$iterator$12;
                            SequenceScope sequenceScope = $this$sequence2;
                            c = c2.getParentElement();
                            $this$sequence = sequenceScope;
                            break;
                        }
                    }
                }
                break;
            case 2:
                idx$iv = this.I$1;
                int l$iv3 = this.I$0;
                $this$forEachAttr$iv = (NamedNodeMap) this.L$2;
                Element c4 = (Element) this.L$1;
                SequenceScope $this$sequence6 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$sequence3 = $this$sequence6;
                c2 = c4;
                l$iv = l$iv3;
                domReader$namespaceContext$1$iterator$12 = this;
                $this$sequence2 = $this$sequence3;
                idx$iv++;
                if (idx$iv < l$iv) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (c != null) {
            NamedNodeMap $this$forEachAttr$iv2 = c.getAttributes();
            l$iv = $this$forEachAttr$iv2.getLength();
            Element element = c;
            $this$sequence2 = $this$sequence;
            $this$forEachAttr$iv = $this$forEachAttr$iv2;
            domReader$namespaceContext$1$iterator$12 = domReader$namespaceContext$1$iterator$1;
            idx$iv = 0;
            c2 = element;
            if (idx$iv < l$iv) {
            }
        } else {
            return Unit.INSTANCE;
        }
    }
}