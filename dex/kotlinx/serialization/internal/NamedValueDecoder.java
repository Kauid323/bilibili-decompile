package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.apache.commons.io.FilenameUtils;

/* compiled from: Tagged.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0004J\u0014\u0010\u000e\u001a\u00020\u0002*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0004¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "()V", "composeName", "parentName", "childName", "elementName", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "nested", "nestedName", "getTag", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@InternalSerializationApi
public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final String getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return nested(elementName($this$getTag, index));
    }

    protected final String nested(String nestedName) {
        Intrinsics.checkNotNullParameter(nestedName, "nestedName");
        String currentTagOrNull = getCurrentTagOrNull();
        if (currentTagOrNull == null) {
            currentTagOrNull = "";
        }
        return composeName(currentTagOrNull, nestedName);
    }

    protected String elementName(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return descriptor.getElementName(index);
    }

    protected String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return parentName.length() == 0 ? childName : parentName + FilenameUtils.EXTENSION_SEPARATOR + childName;
    }
}