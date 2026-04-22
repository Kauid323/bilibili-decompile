package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadContext;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteContext;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.WritersKt;
import kotlin.reflect.jvm.internal.impl.km.internal.common.KmModuleFragment;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmModuleFragmentExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignatureKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: JvmMetadataExtensions.kt */
public final class JvmMetadataExtensions implements MetadataExtensions {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00aa, code lost:
        if (r2 == null) goto L24;
     */
    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readClassExtensions(KmClass kmClass, ProtoBuf.Class proto, ReadContext c) {
        String str;
        Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmClassExtension ext = JvmExtensionNodesKt.getJvm(kmClass);
        Iterable annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        Iterable $this$mapTo$iv = annotationList;
        Collection destination$iv = kmClass.getAnnotations();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(ReadUtilsKt.readAnnotation(it, c.getStrings()));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName = JvmProtoBuf.anonymousObjectOriginName;
        Intrinsics.checkNotNullExpressionValue(anonymousObjectOriginName, "anonymousObjectOriginName");
        Integer anonymousObjectOriginName2 = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, anonymousObjectOriginName);
        if (anonymousObjectOriginName2 != null) {
            ext.setAnonymousObjectOriginName(c.get(anonymousObjectOriginName2.intValue()));
        }
        for (ProtoBuf.Property property : (List) proto.getExtension(JvmProtoBuf.classLocalVariable)) {
            List<KmProperty> localDelegatedProperties = ext.getLocalDelegatedProperties();
            Intrinsics.checkNotNull(property);
            localDelegatedProperties.add(ReadersKt.toKmProperty(property, c));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = JvmProtoBuf.classModuleName;
        Intrinsics.checkNotNullExpressionValue(classModuleName, "classModuleName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, classModuleName);
        if (num != null) {
            int p0 = num.intValue();
            str = c.get(p0);
        }
        str = "main";
        ext.setModuleName(str);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags = JvmProtoBuf.jvmClassFlags;
        Intrinsics.checkNotNullExpressionValue(jvmClassFlags, "jvmClassFlags");
        Integer num2 = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, jvmClassFlags);
        if (num2 != null) {
            ext.setJvmFlags(num2.intValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005a, code lost:
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readPackageExtensions(KmPackage kmPackage, ProtoBuf.Package proto, ReadContext c) {
        String str;
        Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPackageExtension ext = JvmExtensionNodesKt.getJvm(kmPackage);
        for (ProtoBuf.Property property : (List) proto.getExtension(JvmProtoBuf.packageLocalVariable)) {
            List<KmProperty> localDelegatedProperties = ext.getLocalDelegatedProperties();
            Intrinsics.checkNotNull(property);
            localDelegatedProperties.add(ReadersKt.toKmProperty(property, c));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = JvmProtoBuf.packageModuleName;
        Intrinsics.checkNotNullExpressionValue(packageModuleName, "packageModuleName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, packageModuleName);
        if (num != null) {
            int p0 = num.intValue();
            str = c.get(p0);
        }
        str = "main";
        ext.setModuleName(str);
    }

    public void readModuleFragmentExtensions(KmModuleFragment kmModuleFragment, ProtoBuf.PackageFragment proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readFunctionExtensions(KmFunction kmFunction, ProtoBuf.Function proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmFunctionExtension ext = JvmExtensionNodesKt.getJvm(kmFunction);
        Iterable $this$mapTo$iv = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv, "getAnnotationList(...)");
        Collection destination$iv = kmFunction.getAnnotations();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(ReadUtilsKt.readAnnotation(it, c.getStrings()));
        }
        Iterable $this$mapTo$iv2 = proto.getExtensionReceiverAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv2, "getExtensionReceiverAnnotationList(...)");
        Collection destination$iv2 = kmFunction.getExtensionReceiverParameterAnnotations();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.Annotation it2 = (ProtoBuf.Annotation) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(ReadUtilsKt.readAnnotation(it2, c.getStrings()));
        }
        JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature(proto, c.getStrings(), c.getTypes());
        ext.setSignature(jvmMethodSignature != null ? JvmMemberSignatureKt.wrapAsPublic(jvmMethodSignature) : null);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName = JvmProtoBuf.lambdaClassOriginName;
        Intrinsics.checkNotNullExpressionValue(lambdaClassOriginName, "lambdaClassOriginName");
        Integer lambdaClassOriginName2 = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, lambdaClassOriginName);
        if (lambdaClassOriginName2 != null) {
            ext.setLambdaClassOriginName(c.get(lambdaClassOriginName2.intValue()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readPropertyExtensions(KmProperty kmProperty, ProtoBuf.Property proto, ReadContext c) {
        JvmMethodSignature jvmMethodSignature;
        JvmMethodSignature jvmMethodSignature2;
        JvmMethodSignature jvmMethodSignature3;
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPropertyExtension ext = JvmExtensionNodesKt.getJvm(kmProperty);
        Iterable $this$mapTo$iv = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv, "getAnnotationList(...)");
        Collection destination$iv = kmProperty.getAnnotations();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(ReadUtilsKt.readAnnotation(it, c.getStrings()));
        }
        Iterable $this$mapTo$iv2 = proto.getGetterAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv2, "getGetterAnnotationList(...)");
        Collection destination$iv2 = kmProperty.getGetter().getAnnotations();
        for (Object item$iv2 : $this$mapTo$iv2) {
            ProtoBuf.Annotation it2 = (ProtoBuf.Annotation) item$iv2;
            Intrinsics.checkNotNull(it2);
            destination$iv2.add(ReadUtilsKt.readAnnotation(it2, c.getStrings()));
        }
        KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            Iterable $this$mapTo$iv3 = proto.getSetterAnnotationList();
            Intrinsics.checkNotNullExpressionValue($this$mapTo$iv3, "getSetterAnnotationList(...)");
            Collection destination$iv3 = setter.getAnnotations();
            for (Object item$iv3 : $this$mapTo$iv3) {
                ProtoBuf.Annotation it3 = (ProtoBuf.Annotation) item$iv3;
                Intrinsics.checkNotNull(it3);
                destination$iv3.add(ReadUtilsKt.readAnnotation(it3, c.getStrings()));
            }
            List<KmAnnotation> list = (List) destination$iv3;
        }
        Iterable $this$mapTo$iv4 = proto.getExtensionReceiverAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv4, "getExtensionReceiverAnnotationList(...)");
        Collection destination$iv4 = kmProperty.getExtensionReceiverParameterAnnotations();
        for (Object item$iv4 : $this$mapTo$iv4) {
            ProtoBuf.Annotation it4 = (ProtoBuf.Annotation) item$iv4;
            Intrinsics.checkNotNull(it4);
            destination$iv4.add(ReadUtilsKt.readAnnotation(it4, c.getStrings()));
        }
        Iterable $this$mapTo$iv5 = proto.getBackingFieldAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv5, "getBackingFieldAnnotationList(...)");
        Collection destination$iv5 = kmProperty.getBackingFieldAnnotations();
        for (Object item$iv5 : $this$mapTo$iv5) {
            ProtoBuf.Annotation it5 = (ProtoBuf.Annotation) item$iv5;
            Intrinsics.checkNotNull(it5);
            destination$iv5.add(ReadUtilsKt.readAnnotation(it5, c.getStrings()));
        }
        Iterable $this$mapTo$iv6 = proto.getDelegateFieldAnnotationList();
        Intrinsics.checkNotNullExpressionValue($this$mapTo$iv6, "getDelegateFieldAnnotationList(...)");
        Collection destination$iv6 = kmProperty.getDelegateFieldAnnotations();
        for (Object item$iv6 : $this$mapTo$iv6) {
            ProtoBuf.Annotation it6 = (ProtoBuf.Annotation) item$iv6;
            Intrinsics.checkNotNull(it6);
            destination$iv6.add(ReadUtilsKt.readAnnotation(it6, c.getStrings()));
        }
        JvmMemberSignature.Field fieldSignature = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, proto, c.getStrings(), c.getTypes(), false, 8, null);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature propertySignature2 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        JvmMethodSignature jvmMethodSignature4 = null;
        JvmProtoBuf.JvmMethodSignature getterSignature = (propertySignature2 == null || !propertySignature2.hasGetter()) ? null : propertySignature2.getGetter();
        JvmProtoBuf.JvmMethodSignature setterSignature = (propertySignature2 == null || !propertySignature2.hasSetter()) ? null : propertySignature2.getSetter();
        Object extension = proto.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        ext.setJvmFlags(((Number) extension).intValue());
        ext.setFieldSignature(fieldSignature != null ? JvmMemberSignatureKt.wrapAsPublic(fieldSignature) : null);
        if (getterSignature != null) {
            JvmProtoBuf.JvmMethodSignature $this$readPropertyExtensions_u24lambda_u246 = getterSignature;
            jvmMethodSignature = new JvmMethodSignature(c.get($this$readPropertyExtensions_u24lambda_u246.getName()), c.get($this$readPropertyExtensions_u24lambda_u246.getDesc()));
        } else {
            jvmMethodSignature = null;
        }
        ext.setGetterSignature(jvmMethodSignature);
        if (setterSignature != null) {
            JvmProtoBuf.JvmMethodSignature $this$readPropertyExtensions_u24lambda_u247 = setterSignature;
            jvmMethodSignature2 = new JvmMethodSignature(c.get($this$readPropertyExtensions_u24lambda_u247.getName()), c.get($this$readPropertyExtensions_u24lambda_u247.getDesc()));
        } else {
            jvmMethodSignature2 = null;
        }
        ext.setSetterSignature(jvmMethodSignature2);
        JvmProtoBuf.JvmMethodSignature syntheticMethod = (propertySignature2 == null || !propertySignature2.hasSyntheticMethod()) ? null : propertySignature2.getSyntheticMethod();
        if (syntheticMethod != null) {
            JvmProtoBuf.JvmMethodSignature $this$readPropertyExtensions_u24lambda_u248 = syntheticMethod;
            jvmMethodSignature3 = new JvmMethodSignature(c.get($this$readPropertyExtensions_u24lambda_u248.getName()), c.get($this$readPropertyExtensions_u24lambda_u248.getDesc()));
        } else {
            jvmMethodSignature3 = null;
        }
        ext.setSyntheticMethodForAnnotations(jvmMethodSignature3);
        JvmProtoBuf.JvmMethodSignature delegateMethod = (propertySignature2 == null || !propertySignature2.hasDelegateMethod()) ? null : propertySignature2.getDelegateMethod();
        if (delegateMethod != null) {
            JvmProtoBuf.JvmMethodSignature $this$readPropertyExtensions_u24lambda_u249 = delegateMethod;
            jvmMethodSignature4 = new JvmMethodSignature(c.get($this$readPropertyExtensions_u24lambda_u249.getName()), c.get($this$readPropertyExtensions_u24lambda_u249.getDesc()));
        }
        ext.setSyntheticMethodForDelegate(jvmMethodSignature4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readConstructorExtensions(KmConstructor kmConstructor, ProtoBuf.Constructor proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmConstructorExtension ext = JvmExtensionNodesKt.getJvm(kmConstructor);
        Iterable annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        Iterable $this$mapTo$iv = annotationList;
        Collection destination$iv = kmConstructor.getAnnotations();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(ReadUtilsKt.readAnnotation(it, c.getStrings()));
        }
        JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature(proto, c.getStrings(), c.getTypes());
        ext.setSignature(jvmConstructorSignature != null ? JvmMemberSignatureKt.wrapAsPublic(jvmConstructorSignature) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf.TypeParameter proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeParameterExtension ext = JvmExtensionNodesKt.getJvm(kmTypeParameter);
        for (ProtoBuf.Annotation annotation : (List) proto.getExtension(JvmProtoBuf.typeParameterAnnotation)) {
            List<KmAnnotation> annotations = ext.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            annotations.add(ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readEnumEntryExtensions(KmEnumEntry kmEnumEntry, ProtoBuf.EnumEntry proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmEnumEntry, "kmEnumEntry");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        for (ProtoBuf.Annotation annotation : proto.getAnnotationList()) {
            List<KmAnnotation> annotations = kmEnumEntry.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            annotations.add(ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeExtensions(KmType kmType, ProtoBuf.Type proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmType, "kmType");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeExtension ext = JvmExtensionNodesKt.getJvm(kmType);
        Object extension = proto.getExtension(JvmProtoBuf.isRaw);
        Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        ext.setRaw(((Boolean) extension).booleanValue());
        for (ProtoBuf.Annotation annotation : (List) proto.getExtension(JvmProtoBuf.typeAnnotation)) {
            List<KmAnnotation> annotations = ext.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            annotations.add(ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeAliasExtensions(KmTypeAlias kmTypeAlias, ProtoBuf.TypeAlias proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "kmTypeAlias");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readValueParameterExtensions(KmValueParameter kmValueParameter, ProtoBuf.ValueParameter proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "kmValueParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        Iterable $this$mapTo$iv = annotationList;
        Collection destination$iv = kmValueParameter.getAnnotations();
        for (Object item$iv : $this$mapTo$iv) {
            ProtoBuf.Annotation it = (ProtoBuf.Annotation) item$iv;
            Intrinsics.checkNotNull(it);
            destination$iv.add(ReadUtilsKt.readAnnotation(it, c.getStrings()));
        }
    }

    public void writeClassExtensions(KmClass kmClass, ProtoBuf.Class.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmClassExtension $this$writeClassExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(kmClass);
        Iterable $this$map$iv = kmClass.getAnnotations();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(WriteUtilsKt.writeAnnotation((KmAnnotation) item$iv$iv, c.getStrings()).build());
        }
        proto.addAllAnnotation((List) destination$iv$iv);
        String it = $this$writeClassExtensions_u24lambda_u240.getAnonymousObjectOriginName();
        if (it != null) {
            proto.setExtension(JvmProtoBuf.anonymousObjectOriginName, Integer.valueOf(c.get(it)));
        }
        Iterable $this$forEach$iv = $this$writeClassExtensions_u24lambda_u240.getLocalDelegatedProperties();
        for (Object element$iv : $this$forEach$iv) {
            proto.addExtension(JvmProtoBuf.classLocalVariable, WritersKt.writeProperty(c, (KmProperty) element$iv).build());
        }
        String moduleName = $this$writeClassExtensions_u24lambda_u240.getModuleName();
        if (moduleName != null && !Intrinsics.areEqual(moduleName, "main")) {
            proto.setExtension(JvmProtoBuf.classModuleName, Integer.valueOf(c.get(moduleName)));
        }
        if ($this$writeClassExtensions_u24lambda_u240.getJvmFlags() != 0) {
            proto.setExtension(JvmProtoBuf.jvmClassFlags, Integer.valueOf($this$writeClassExtensions_u24lambda_u240.getJvmFlags()));
        }
    }

    public void writePackageExtensions(KmPackage kmPackage, ProtoBuf.Package.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPackageExtension $this$writePackageExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(kmPackage);
        Iterable $this$forEach$iv = $this$writePackageExtensions_u24lambda_u240.getLocalDelegatedProperties();
        for (Object element$iv : $this$forEach$iv) {
            KmProperty it = (KmProperty) element$iv;
            proto.addExtension(JvmProtoBuf.packageLocalVariable, WritersKt.writeProperty(c, it).build());
        }
        String name = $this$writePackageExtensions_u24lambda_u240.getModuleName();
        if (name != null && !Intrinsics.areEqual(name, "main")) {
            proto.setExtension(JvmProtoBuf.packageModuleName, Integer.valueOf(c.get(name)));
        }
    }

    public void writeModuleFragmentExtensions(KmModuleFragment kmModuleFragment, ProtoBuf.PackageFragment.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    public void writeFunctionExtensions(KmFunction kmFunction, ProtoBuf.Function.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmFunctionExtension $this$writeFunctionExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(kmFunction);
        Iterable $this$map$iv = kmFunction.getAnnotations();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(WriteUtilsKt.writeAnnotation((KmAnnotation) item$iv$iv, c.getStrings()).build());
        }
        proto.addAllAnnotation((List) destination$iv$iv);
        Iterable $this$map$iv2 = kmFunction.getExtensionReceiverParameterAnnotations();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            destination$iv$iv2.add(WriteUtilsKt.writeAnnotation((KmAnnotation) item$iv$iv2, c.getStrings()).build());
        }
        proto.addAllExtensionReceiverAnnotation((List) destination$iv$iv2);
        JvmMethodSignature it = $this$writeFunctionExtensions_u24lambda_u240.getSignature();
        if (it != null) {
            proto.setExtension(JvmProtoBuf.methodSignature, toJvmMethodSignature(it, c));
        }
        String it2 = $this$writeFunctionExtensions_u24lambda_u240.getLambdaClassOriginName();
        if (it2 != null) {
            proto.setExtension(JvmProtoBuf.lambdaClassOriginName, Integer.valueOf(c.get(it2)));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writePropertyExtensions(KmProperty kmProperty, ProtoBuf.Property.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPropertyExtension $this$writePropertyExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(kmProperty);
        Iterable $this$map$iv = kmProperty.getAnnotations();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KmAnnotation it = (KmAnnotation) item$iv$iv;
            destination$iv$iv.add(WriteUtilsKt.writeAnnotation(it, c.getStrings()).build());
        }
        proto.addAllAnnotation((List) destination$iv$iv);
        Iterable $this$map$iv2 = kmProperty.getGetter().getAnnotations();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            KmAnnotation it2 = (KmAnnotation) item$iv$iv2;
            destination$iv$iv2.add(WriteUtilsKt.writeAnnotation(it2, c.getStrings()).build());
        }
        proto.addAllGetterAnnotation((List) destination$iv$iv2);
        KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            Iterable $this$map$iv3 = setter.getAnnotations();
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
            for (Object item$iv$iv3 : $this$map$iv3) {
                KmAnnotation it3 = (KmAnnotation) item$iv$iv3;
                destination$iv$iv3.add(WriteUtilsKt.writeAnnotation(it3, c.getStrings()).build());
            }
            proto.addAllSetterAnnotation((List) destination$iv$iv3);
        }
        Iterable $this$map$iv4 = kmProperty.getExtensionReceiverParameterAnnotations();
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
        for (Object item$iv$iv4 : $this$map$iv4) {
            KmAnnotation it4 = (KmAnnotation) item$iv$iv4;
            destination$iv$iv4.add(WriteUtilsKt.writeAnnotation(it4, c.getStrings()).build());
        }
        proto.addAllExtensionReceiverAnnotation((List) destination$iv$iv4);
        Iterable $this$map$iv5 = kmProperty.getBackingFieldAnnotations();
        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
        for (Object item$iv$iv5 : $this$map$iv5) {
            KmAnnotation it5 = (KmAnnotation) item$iv$iv5;
            destination$iv$iv5.add(WriteUtilsKt.writeAnnotation(it5, c.getStrings()).build());
        }
        proto.addAllBackingFieldAnnotation((List) destination$iv$iv5);
        Iterable $this$map$iv6 = kmProperty.getDelegateFieldAnnotations();
        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
        for (Object item$iv$iv6 : $this$map$iv6) {
            KmAnnotation it6 = (KmAnnotation) item$iv$iv6;
            destination$iv$iv6.add(WriteUtilsKt.writeAnnotation(it6, c.getStrings()).build());
        }
        proto.addAllDelegateFieldAnnotation((List) destination$iv$iv6);
        JvmProtoBuf.JvmPropertySignature.Builder composedSignature = JvmProtoBuf.JvmPropertySignature.newBuilder();
        Intrinsics.checkNotNullExpressionValue(composedSignature, "newBuilder(...)");
        boolean hasSignature = false;
        if ($this$writePropertyExtensions_u24lambda_u240.getFieldSignature() != null) {
            hasSignature = true;
            JvmProtoBuf.JvmFieldSignature.Builder field = JvmProtoBuf.JvmFieldSignature.newBuilder();
            JvmFieldSignature fieldSignature = $this$writePropertyExtensions_u24lambda_u240.getFieldSignature();
            Intrinsics.checkNotNull(fieldSignature);
            field.setName(c.get(fieldSignature.getName()));
            JvmFieldSignature fieldSignature2 = $this$writePropertyExtensions_u24lambda_u240.getFieldSignature();
            Intrinsics.checkNotNull(fieldSignature2);
            field.setDesc(c.get(fieldSignature2.getDescriptor()));
            composedSignature.setField(field.build());
        }
        if ($this$writePropertyExtensions_u24lambda_u240.getGetterSignature() != null) {
            hasSignature = true;
            JvmMethodSignature getterSignature = $this$writePropertyExtensions_u24lambda_u240.getGetterSignature();
            Intrinsics.checkNotNull(getterSignature);
            composedSignature.setGetter(toJvmMethodSignature(getterSignature, c));
        }
        if ($this$writePropertyExtensions_u24lambda_u240.getSetterSignature() != null) {
            hasSignature = true;
            JvmMethodSignature setterSignature = $this$writePropertyExtensions_u24lambda_u240.getSetterSignature();
            Intrinsics.checkNotNull(setterSignature);
            composedSignature.setSetter(toJvmMethodSignature(setterSignature, c));
        }
        if (hasSignature && $this$writePropertyExtensions_u24lambda_u240.getSyntheticMethodForAnnotations() != null) {
            JvmMethodSignature syntheticMethodForAnnotations = $this$writePropertyExtensions_u24lambda_u240.getSyntheticMethodForAnnotations();
            Intrinsics.checkNotNull(syntheticMethodForAnnotations);
            composedSignature.setSyntheticMethod(toJvmMethodSignature(syntheticMethodForAnnotations, c));
        }
        if (hasSignature && $this$writePropertyExtensions_u24lambda_u240.getSyntheticMethodForDelegate() != null) {
            JvmMethodSignature syntheticMethodForDelegate = $this$writePropertyExtensions_u24lambda_u240.getSyntheticMethodForDelegate();
            Intrinsics.checkNotNull(syntheticMethodForDelegate);
            composedSignature.setDelegateMethod(toJvmMethodSignature(syntheticMethodForDelegate, c));
        }
        int jvmFlags = $this$writePropertyExtensions_u24lambda_u240.getJvmFlags();
        Integer num = (Integer) ProtoBuf.Property.getDefaultInstance().getExtension(JvmProtoBuf.flags);
        if (num == null || jvmFlags != num.intValue()) {
            proto.setExtension(JvmProtoBuf.flags, Integer.valueOf($this$writePropertyExtensions_u24lambda_u240.getJvmFlags()));
        }
        if (hasSignature) {
            proto.setExtension(JvmProtoBuf.propertySignature, composedSignature.build());
        }
    }

    public void writeConstructorExtensions(KmConstructor kmConstructor, ProtoBuf.Constructor.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmConstructorExtension $this$writeConstructorExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(kmConstructor);
        Iterable $this$map$iv = kmConstructor.getAnnotations();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(WriteUtilsKt.writeAnnotation((KmAnnotation) item$iv$iv, c.getStrings()).build());
        }
        proto.addAllAnnotation((List) destination$iv$iv);
        JvmMethodSignature it = $this$writeConstructorExtensions_u24lambda_u240.getSignature();
        if (it != null) {
            proto.setExtension(JvmProtoBuf.constructorSignature, toJvmMethodSignature(it, c));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writeTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf.TypeParameter.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeParameterExtension $this$writeTypeParameterExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(kmTypeParameter);
        Iterable $this$forEach$iv = $this$writeTypeParameterExtensions_u24lambda_u240.getAnnotations();
        for (Object element$iv : $this$forEach$iv) {
            KmAnnotation annotation = (KmAnnotation) element$iv;
            proto.addExtension(JvmProtoBuf.typeParameterAnnotation, WriteUtilsKt.writeAnnotation(annotation, c.getStrings()).build());
        }
    }

    public void writeEnumEntryExtensions(KmEnumEntry enumEntry, ProtoBuf.EnumEntry.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(enumEntry, "enumEntry");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$forEach$iv = enumEntry.getAnnotations();
        for (Object element$iv : $this$forEach$iv) {
            KmAnnotation annotation = (KmAnnotation) element$iv;
            proto.addAnnotation(WriteUtilsKt.writeAnnotation(annotation, c.getStrings()).build());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writeTypeExtensions(KmType type, ProtoBuf.Type.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeExtension $this$writeTypeExtensions_u24lambda_u240 = JvmExtensionNodesKt.getJvm(type);
        if ($this$writeTypeExtensions_u24lambda_u240.isRaw()) {
            proto.setExtension(JvmProtoBuf.isRaw, true);
        }
        Iterable $this$forEach$iv = $this$writeTypeExtensions_u24lambda_u240.getAnnotations();
        for (Object element$iv : $this$forEach$iv) {
            KmAnnotation annotation = (KmAnnotation) element$iv;
            proto.addExtension(JvmProtoBuf.typeAnnotation, WriteUtilsKt.writeAnnotation(annotation, c.getStrings()).build());
        }
    }

    public void writeTypeAliasExtensions(KmTypeAlias typeAlias, ProtoBuf.TypeAlias.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(typeAlias, "typeAlias");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writeValueParameterExtensions(KmValueParameter valueParameter, ProtoBuf.ValueParameter.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(valueParameter, "valueParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        Iterable $this$map$iv = valueParameter.getAnnotations();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KmAnnotation it = (KmAnnotation) item$iv$iv;
            destination$iv$iv.add(WriteUtilsKt.writeAnnotation(it, c.getStrings()).build());
        }
        proto.addAllAnnotation((List) destination$iv$iv);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmClassExtension createClassExtension() {
        return new JvmClassExtension();
    }

    public KmPackageExtension createPackageExtension() {
        return new JvmPackageExtension();
    }

    public KmModuleFragmentExtension createModuleFragmentExtensions() {
        return new KmModuleFragmentExtension() { // from class: kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmMetadataExtensions$createModuleFragmentExtensions$1
            private final KmExtensionType type = new KmExtensionType(Reflection.getOrCreateKotlinClass(KmModuleFragmentExtension.class));

            @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
            public KmExtensionType getType() {
                return this.type;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmFunctionExtension createFunctionExtension() {
        return new JvmFunctionExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmPropertyExtension createPropertyExtension() {
        return new JvmPropertyExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmConstructorExtension createConstructorExtension() {
        return new JvmConstructorExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmTypeParameterExtension createTypeParameterExtension() {
        return new JvmTypeParameterExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmEnumEntryExtension createEnumEntryExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmTypeExtension createTypeExtension() {
        return new JvmTypeExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmTypeAliasExtension createTypeAliasExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmValueParameterExtension createValueParameterExtension() {
        return null;
    }

    private final JvmProtoBuf.JvmMethodSignature toJvmMethodSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature $this$toJvmMethodSignature, WriteContext c) {
        JvmProtoBuf.JvmMethodSignature.Builder $this$toJvmMethodSignature_u24lambda_u240 = JvmProtoBuf.JvmMethodSignature.newBuilder();
        $this$toJvmMethodSignature_u24lambda_u240.setName(c.get($this$toJvmMethodSignature.getName()));
        $this$toJvmMethodSignature_u24lambda_u240.setDesc(c.get($this$toJvmMethodSignature.getDescriptor()));
        JvmProtoBuf.JvmMethodSignature build = $this$toJvmMethodSignature_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}