package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JvmNameResolver(JvmProtoBuf.StringTableTypes types, String[] strings) {
        super(strings, r2, JvmNameResolverKt.toExpandedRecordsList($this$_init__u24lambda_u240));
        Set set;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(strings, "strings");
        List $this$_init__u24lambda_u240 = types.getLocalNameList();
        if ($this$_init__u24lambda_u240.isEmpty()) {
            set = SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNull($this$_init__u24lambda_u240);
            set = CollectionsKt.toSet($this$_init__u24lambda_u240);
        }
        List $this$_init__u24lambda_u2402 = types.getRecordList();
        Intrinsics.checkNotNullExpressionValue($this$_init__u24lambda_u2402, "getRecordList(...)");
        this.types = types;
    }
}