package tv.danmaku.bili.ui.splash.utils;

import BottomSheetItemData$;
import com.alibaba.fastjson.TypeReference;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastJsonUtil.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\r\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/ObjectInfo;", "", "field", "Ljava/lang/reflect/Field;", "value", "typeReference", "Lcom/alibaba/fastjson/TypeReference;", "isList", "", "<init>", "(Ljava/lang/reflect/Field;Ljava/lang/Object;Lcom/alibaba/fastjson/TypeReference;Z)V", "getField", "()Ljava/lang/reflect/Field;", "getValue", "()Ljava/lang/Object;", "getTypeReference", "()Lcom/alibaba/fastjson/TypeReference;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ObjectInfo {
    private final Field field;
    private final boolean isList;
    private final TypeReference<?> typeReference;
    private final Object value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObjectInfo copy$default(ObjectInfo objectInfo, Field field, Object obj, TypeReference typeReference, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            field = objectInfo.field;
        }
        if ((i & 2) != 0) {
            obj = objectInfo.value;
        }
        if ((i & 4) != 0) {
            typeReference = objectInfo.typeReference;
        }
        if ((i & 8) != 0) {
            z = objectInfo.isList;
        }
        return objectInfo.copy(field, obj, typeReference, z);
    }

    public final Field component1() {
        return this.field;
    }

    public final Object component2() {
        return this.value;
    }

    public final TypeReference<?> component3() {
        return this.typeReference;
    }

    public final boolean component4() {
        return this.isList;
    }

    public final ObjectInfo copy(Field field, Object obj, TypeReference<?> typeReference, boolean z) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(typeReference, "typeReference");
        return new ObjectInfo(field, obj, typeReference, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectInfo) {
            ObjectInfo objectInfo = (ObjectInfo) obj;
            return Intrinsics.areEqual(this.field, objectInfo.field) && Intrinsics.areEqual(this.value, objectInfo.value) && Intrinsics.areEqual(this.typeReference, objectInfo.typeReference) && this.isList == objectInfo.isList;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.field.hashCode() * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31) + this.typeReference.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isList);
    }

    public String toString() {
        Field field = this.field;
        Object obj = this.value;
        TypeReference<?> typeReference = this.typeReference;
        return "ObjectInfo(field=" + field + ", value=" + obj + ", typeReference=" + typeReference + ", isList=" + this.isList + ")";
    }

    public ObjectInfo(Field field, Object value, TypeReference<?> typeReference, boolean isList) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(typeReference, "typeReference");
        this.field = field;
        this.value = value;
        this.typeReference = typeReference;
        this.isList = isList;
    }

    public final Field getField() {
        return this.field;
    }

    public final Object getValue() {
        return this.value;
    }

    public final TypeReference<?> getTypeReference() {
        return this.typeReference;
    }

    public final boolean isList() {
        return this.isList;
    }
}