package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: WriteMode.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001aS\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u0002H\u0005\"\b\b\u0002\u0010\u0007*\u0002H\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000bH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"carrierDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "module", "Lkotlinx/serialization/modules/SerializersModule;", "selectMapMode", "T", "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-json"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WriteModeKt {
    public static final WriteMode switchMode(Json $this$switchMode, SerialDescriptor desc) {
        WriteMode writeMode;
        Intrinsics.checkNotNullParameter($this$switchMode, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        SerialKind kind = desc.getKind();
        if (kind instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            return WriteMode.LIST;
        }
        if (!Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor keyDescriptor$iv = carrierDescriptor(desc.getElementDescriptor(0), $this$switchMode.getSerializersModule());
        SerialKind keyKind$iv = keyDescriptor$iv.getKind();
        if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind$iv, SerialKind.ENUM.INSTANCE)) {
            writeMode = WriteMode.MAP;
        } else if ($this$switchMode.getConfiguration().getAllowStructuredMapKeys()) {
            writeMode = WriteMode.LIST;
        } else {
            throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
        }
        return writeMode;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, java.lang.Object] */
    public static final <T, R1 extends T, R2 extends T> T selectMapMode(Json $this$selectMapMode, SerialDescriptor mapDescriptor, Function0<? extends R1> ifMap, Function0<? extends R2> ifList) {
        Intrinsics.checkNotNullParameter($this$selectMapMode, "<this>");
        Intrinsics.checkNotNullParameter(mapDescriptor, "mapDescriptor");
        Intrinsics.checkNotNullParameter(ifMap, "ifMap");
        Intrinsics.checkNotNullParameter(ifList, "ifList");
        SerialDescriptor keyDescriptor = carrierDescriptor(mapDescriptor.getElementDescriptor(0), $this$selectMapMode.getSerializersModule());
        SerialKind keyKind = keyDescriptor.getKind();
        if ((keyKind instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind, SerialKind.ENUM.INSTANCE)) {
            return ifMap.invoke();
        }
        if ($this$selectMapMode.getConfiguration().getAllowStructuredMapKeys()) {
            return ifList.invoke();
        }
        throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor);
    }

    public static final SerialDescriptor carrierDescriptor(SerialDescriptor $this$carrierDescriptor, SerializersModule module) {
        SerialDescriptor carrierDescriptor;
        Intrinsics.checkNotNullParameter($this$carrierDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        if (Intrinsics.areEqual($this$carrierDescriptor.getKind(), SerialKind.CONTEXTUAL.INSTANCE)) {
            SerialDescriptor contextualDescriptor = ContextAwareKt.getContextualDescriptor(module, $this$carrierDescriptor);
            if (contextualDescriptor != null && (carrierDescriptor = carrierDescriptor(contextualDescriptor, module)) != null) {
                return carrierDescriptor;
            }
        } else if ($this$carrierDescriptor.isInline()) {
            return carrierDescriptor($this$carrierDescriptor.getElementDescriptor(0), module);
        }
        return $this$carrierDescriptor;
    }
}