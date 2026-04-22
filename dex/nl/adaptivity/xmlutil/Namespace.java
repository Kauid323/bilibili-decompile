package nl.adaptivity.xmlutil;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import nl.adaptivity.xmlutil.Namespace;
import nl.adaptivity.xmlutil.XmlEvent;

/* compiled from: Namespace.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\t\u0010\u0006\u001a\u00020\u0003H\u0096\u0002J\t\u0010\t\u001a\u00020\u0003H\u0096\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lnl/adaptivity/xmlutil/Namespace;", "", "prefix", "", "getPrefix", "()Ljava/lang/String;", "component1", "namespaceURI", "getNamespaceURI", "component2", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Namespace {
    public static final Companion Companion = Companion.$$INSTANCE;

    String component1();

    String component2();

    String getNamespaceURI();

    String getPrefix();

    /* compiled from: Namespace.kt */
    /* renamed from: nl.adaptivity.xmlutil.Namespace$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = Namespace.Companion;
        }
    }

    /* compiled from: Namespace.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static String component1(Namespace $this) {
            return $this.getPrefix();
        }

        @Deprecated
        public static String component2(Namespace $this) {
            return $this.getNamespaceURI();
        }
    }

    /* compiled from: Namespace.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lnl/adaptivity/xmlutil/Namespace$Companion;", "Lkotlinx/serialization/KSerializer;", "Lnl/adaptivity/xmlutil/Namespace;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion implements KSerializer<Namespace> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SerialDescriptor descriptor;

        private Companion() {
        }

        static {
            String simpleName = Reflection.getOrCreateKotlinClass(Namespace.class).getSimpleName();
            Intrinsics.checkNotNull(simpleName);
            descriptor = SerialDescriptorsKt.buildClassSerialDescriptor(simpleName, new SerialDescriptor[0], new Function1() { // from class: nl.adaptivity.xmlutil.Namespace$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit descriptor$lambda$0;
                    descriptor$lambda$0 = Namespace.Companion.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
                    return descriptor$lambda$0;
                }
            });
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "prefix", StringSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "namespaceURI", StringSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public Namespace deserialize(Decoder decoder) {
            String str;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            String str2 = null;
            String str3 = null;
            SerialDescriptor descriptor$iv = descriptor;
            CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
            for (int index = composite$iv.decodeElementIndex(descriptor); index != -1; index = composite$iv.decodeElementIndex(descriptor)) {
                switch (index) {
                    case 0:
                        str2 = composite$iv.decodeStringElement(descriptor, index);
                        break;
                    case 1:
                        str3 = composite$iv.decodeStringElement(descriptor, index);
                        break;
                }
            }
            Unit unit = Unit.INSTANCE;
            composite$iv.endStructure(descriptor$iv);
            String str4 = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefix");
                str = null;
            } else {
                str = str2;
            }
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("namespaceUri");
            } else {
                str4 = str3;
            }
            return new XmlEvent.NamespaceImpl(str, str4);
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, Namespace value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor$iv = descriptor;
            CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
            composite$iv.encodeStringElement(descriptor, 0, value.getPrefix());
            composite$iv.encodeStringElement(descriptor, 1, value.getNamespaceURI());
            composite$iv.endStructure(descriptor$iv);
        }
    }
}