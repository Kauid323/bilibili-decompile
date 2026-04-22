package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DescriptorRendererImpl.kt */
final /* synthetic */ class DescriptorRendererImpl$renderFlexibleType$3 extends FunctionReferenceImpl implements Function1<String, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DescriptorRendererImpl$renderFlexibleType$3(Object obj) {
        super(1, obj, DescriptorRendererImpl.class, "escape", "escape(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String p0) {
        String escape;
        Intrinsics.checkNotNullParameter(p0, "p0");
        escape = ((DescriptorRendererImpl) this.receiver).escape(p0);
        return escape;
    }
}