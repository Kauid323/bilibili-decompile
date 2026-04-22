package im.session.model;

import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bapis.bilibili.app.im.v1.KQuickLinkItemTypeSerializer;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnread$;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IMQuickLink.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/model/IMQuickLinkItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/model/IMQuickLinkItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IMQuickLinkItem$$serializer implements GeneratedSerializer<IMQuickLinkItem> {
    public static final IMQuickLinkItem$$serializer INSTANCE = new IMQuickLinkItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.model.IMQuickLinkItem", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement("title", false);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(1));
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(4));
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(2));
        pluginGeneratedSerialDescriptor.addElement("iconForNight", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(3));
        pluginGeneratedSerialDescriptor.addElement("unread", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(5));
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(6));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IMQuickLinkItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(KUnread$.serializer.INSTANCE), KQuickLinkItemTypeSerializer.INSTANCE};
    }

    /* renamed from: deserialize */
    public final IMQuickLinkItem m3323deserialize(Decoder decoder) {
        KUnread kUnread;
        KQuickLinkItemType kQuickLinkItemType;
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            str3 = decodeStringElement;
            kQuickLinkItemType = (KQuickLinkItemType) beginStructure.decodeSerializableElement(serialDescriptor, 5, KQuickLinkItemTypeSerializer.INSTANCE, (Object) null);
            str2 = decodeStringElement4;
            kUnread = (KUnread) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, KUnread$.serializer.INSTANCE, (Object) null);
            str = decodeStringElement3;
            str4 = decodeStringElement2;
            i2 = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            KUnread kUnread2 = null;
            KQuickLinkItemType kQuickLinkItemType2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        continue;
                    case 1:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                        break;
                    case 2:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i3 |= 8;
                        break;
                    case 4:
                        kUnread2 = (KUnread) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, KUnread$.serializer.INSTANCE, kUnread2);
                        i3 |= 16;
                        break;
                    case 5:
                        kQuickLinkItemType2 = (KQuickLinkItemType) beginStructure.decodeSerializableElement(serialDescriptor, 5, KQuickLinkItemTypeSerializer.INSTANCE, kQuickLinkItemType2);
                        i3 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            kUnread = kUnread2;
            kQuickLinkItemType = kQuickLinkItemType2;
            str = str7;
            str2 = str8;
            str3 = str5;
            str4 = str6;
            i2 = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IMQuickLinkItem(i2, str3, str4, str, str2, kUnread, kQuickLinkItemType, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IMQuickLinkItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IMQuickLinkItem.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}