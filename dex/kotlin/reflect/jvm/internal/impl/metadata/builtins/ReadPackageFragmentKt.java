package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* compiled from: readPackageFragment.kt */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream $this$readBuiltinsPackageFragment) {
        ProtoBuf.PackageFragment proto;
        Intrinsics.checkNotNullParameter($this$readBuiltinsPackageFragment, "<this>");
        InputStream inputStream = $this$readBuiltinsPackageFragment;
        try {
            InputStream stream = inputStream;
            BuiltInsBinaryVersion version = BuiltInsBinaryVersion.Companion.readFrom(stream);
            if (version.isCompatibleWithCurrentCompilerVersion()) {
                ExtensionRegistryLite p0 = ExtensionRegistryLite.newInstance();
                BuiltInsProtoBuf.registerAllExtensions(p0);
                proto = ProtoBuf.PackageFragment.parseFrom(stream, p0);
            } else {
                proto = null;
            }
            Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> pair = TuplesKt.to(proto, version);
            CloseableKt.closeFinally(inputStream, null);
            return pair;
        } finally {
        }
    }
}