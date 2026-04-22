package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;

/* compiled from: AbstractAnnotationLoader.kt */
public abstract class AbstractAnnotationLoader<A> implements AnnotationLoader<A> {
    private final SerializerExtensionProtocol protocol;

    /* compiled from: AbstractAnnotationLoader.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractAnnotationLoader(SerializerExtensionProtocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SerializerExtensionProtocol getProtocol() {
        return this.protocol;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class container) {
        Intrinsics.checkNotNullParameter(container, "container");
        List annotations = (List) container.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (annotations == null) {
            annotations = CollectionsKt.emptyList();
        }
        List $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation proto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(proto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer container, MessageLite proto, AnnotatedCallableKind kind) {
        Iterable annotations;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (proto instanceof ProtoBuf.Constructor) {
            annotations = (List) ((ProtoBuf.Constructor) proto).getExtension(this.protocol.getConstructorAnnotation());
        } else if (proto instanceof ProtoBuf.Function) {
            annotations = (List) ((ProtoBuf.Function) proto).getExtension(this.protocol.getFunctionAnnotation());
        } else if (proto instanceof ProtoBuf.Property) {
            switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1:
                    annotations = (List) ((ProtoBuf.Property) proto).getExtension(this.protocol.getPropertyAnnotation());
                    break;
                case 2:
                    annotations = (List) ((ProtoBuf.Property) proto).getExtension(this.protocol.getPropertyGetterAnnotation());
                    break;
                case 3:
                    annotations = (List) ((ProtoBuf.Property) proto).getExtension(this.protocol.getPropertySetterAnnotation());
                    break;
                default:
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(("Unknown message: " + proto).toString());
        }
        if (annotations == null) {
            annotations = CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation annotationProto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(annotationProto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer container, ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        GeneratedMessageLite.GeneratedExtension it = this.protocol.getPropertyBackingFieldAnnotation();
        Iterable iterable = it != null ? (List) proto.getExtension(it) : null;
        if (iterable == null) {
            iterable = CollectionsKt.emptyList();
        }
        Iterable annotations = iterable;
        Iterable $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation annotationProto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(annotationProto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer container, ProtoBuf.Property proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        GeneratedMessageLite.GeneratedExtension it = this.protocol.getPropertyDelegatedFieldAnnotation();
        Iterable iterable = it != null ? (List) proto.getExtension(it) : null;
        if (iterable == null) {
            iterable = CollectionsKt.emptyList();
        }
        Iterable annotations = iterable;
        Iterable $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation annotationProto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(annotationProto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer container, ProtoBuf.EnumEntry proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        List annotations = (List) proto.getExtension(this.protocol.getEnumEntryAnnotation());
        if (annotations == null) {
            annotations = CollectionsKt.emptyList();
        }
        List $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation annotationProto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(annotationProto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer container, MessageLite callableProto, AnnotatedCallableKind kind, int parameterIndex, ProtoBuf.ValueParameter proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(proto, "proto");
        List annotations = (List) proto.getExtension(this.protocol.getParameterAnnotation());
        if (annotations == null) {
            annotations = CollectionsKt.emptyList();
        }
        List $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation annotationProto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(annotationProto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer container, MessageLite proto, AnnotatedCallableKind kind) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Iterable iterable = null;
        if (proto instanceof ProtoBuf.Function) {
            GeneratedMessageLite.GeneratedExtension it = this.protocol.getFunctionExtensionReceiverAnnotation();
            if (it != null) {
                iterable = (List) ((ProtoBuf.Function) proto).getExtension(it);
            }
        } else if (proto instanceof ProtoBuf.Property) {
            switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    GeneratedMessageLite.GeneratedExtension it2 = this.protocol.getPropertyExtensionReceiverAnnotation();
                    if (it2 != null) {
                        iterable = (List) ((ProtoBuf.Property) proto).getExtension(it2);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
        } else {
            throw new IllegalStateException(("Unknown message: " + proto).toString());
        }
        if (iterable == null) {
            iterable = CollectionsKt.emptyList();
        }
        Iterable annotations = iterable;
        Iterable $this$map$iv = annotations;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation annotationProto = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(annotationProto, container.getNameResolver()));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadContextParameterAnnotations(ProtoContainer container, MessageLite callableProto, AnnotatedCallableKind kind, int parameterIndex, ProtoBuf.ValueParameter proto) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        Intrinsics.checkNotNullParameter(kind, "kind");
        List<A> loadValueParameterAnnotations = proto != null ? loadValueParameterAnnotations(container, callableProto, kind, parameterIndex, proto) : null;
        return loadValueParameterAnnotations == null ? CollectionsKt.emptyList() : loadValueParameterAnnotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type proto, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Iterable iterable = (List) proto.getExtension(this.protocol.getTypeAnnotation());
        if (iterable == null) {
            iterable = CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = iterable;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(it, nameResolver));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter proto, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Iterable iterable = (List) proto.getExtension(this.protocol.getTypeParameterAnnotation());
        if (iterable == null) {
            iterable = CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = iterable;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv$iv;
            destination$iv$iv.add(loadAnnotation(it, nameResolver));
        }
        return (List) destination$iv$iv;
    }
}