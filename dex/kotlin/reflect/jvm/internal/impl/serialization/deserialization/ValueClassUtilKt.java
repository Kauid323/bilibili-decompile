package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;

/* compiled from: ValueClassUtil.kt */
public final class ValueClassUtilKt {
    public static final <T extends RigidTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(ProtoBuf.Class $this$loadValueClassRepresentation, boolean tryLoadMultiFieldValueClass, NameResolver nameResolver, TypeTable typeTable, Function1<? super ProtoBuf.Type, ? extends T> typeDeserializer, Function1<? super Name, ? extends T> typeOfPublicProperty) {
        RigidTypeMarker propertyType;
        Intrinsics.checkNotNullParameter($this$loadValueClassRepresentation, "<this>");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
        Intrinsics.checkNotNullParameter(typeOfPublicProperty, "typeOfPublicProperty");
        if ($this$loadValueClassRepresentation.hasInlineClassUnderlyingPropertyName()) {
            Name propertyName = NameResolverUtilKt.getName(nameResolver, $this$loadValueClassRepresentation.getInlineClassUnderlyingPropertyName());
            ProtoBuf.Type inlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType($this$loadValueClassRepresentation, typeTable);
            if ((inlineClassUnderlyingType == null || (propertyType = typeDeserializer.invoke(inlineClassUnderlyingType)) == null) && (propertyType = typeOfPublicProperty.invoke(propertyName)) == null) {
                throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(nameResolver, $this$loadValueClassRepresentation.getFqName()) + " with property " + propertyName).toString());
            }
            return new InlineClassRepresentation(propertyName, propertyType);
        } else if (!tryLoadMultiFieldValueClass || !Flags.IS_VALUE_CLASS.get($this$loadValueClassRepresentation.getFlags()).booleanValue()) {
            return null;
        } else {
            Iterable constructorList = $this$loadValueClassRepresentation.getConstructorList();
            Intrinsics.checkNotNullExpressionValue(constructorList, "getConstructorList(...)");
            Iterable $this$singleOrNull$iv = constructorList;
            Object single$iv = null;
            boolean found$iv = false;
            Iterator<T> it = $this$singleOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    if (!Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) element$iv).getFlags()).booleanValue()) {
                        if (found$iv) {
                            single$iv = null;
                            break;
                        }
                        single$iv = element$iv;
                        found$iv = true;
                    }
                } else if (!found$iv) {
                    single$iv = null;
                }
            }
            ProtoBuf.Constructor primaryConstructor = (ProtoBuf.Constructor) single$iv;
            if (primaryConstructor == null) {
                return null;
            }
            Iterable valueParameterList = primaryConstructor.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
            Iterable $this$map$iv = valueParameterList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ProtoBuf.ValueParameter it2 = (ProtoBuf.ValueParameter) item$iv$iv;
                Name name = NameResolverUtilKt.getName(nameResolver, it2.getName());
                Intrinsics.checkNotNull(it2);
                destination$iv$iv.add(TuplesKt.to(name, typeDeserializer.invoke(ProtoTypeTableUtilKt.type(it2, typeTable))));
            }
            return new MultiFieldValueClassRepresentation((List) destination$iv$iv);
        }
    }
}