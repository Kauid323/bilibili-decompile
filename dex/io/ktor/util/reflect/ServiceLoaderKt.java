package io.ktor.util.reflect;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import io.ktor.utils.io.InternalAPI;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: ServiceLoader.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "T", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "loadServices", "()Ljava/util/List;", "loadServiceOrNull", "()Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ServiceLoaderKt {
    @InternalAPI
    public static final /* synthetic */ <T> List<T> loadServices() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Intrinsics.reifiedOperationMarker(4, "T");
        Iterator it = ServiceLoader.load(Object.class, Object.class.getClassLoader()).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return SequencesKt.toList(SequencesKt.asSequence(it));
    }

    @InternalAPI
    public static final /* synthetic */ <T> T loadServiceOrNull() {
        Intrinsics.reifiedOperationMarker(4, "T");
        Intrinsics.reifiedOperationMarker(4, "T");
        Iterator it = ServiceLoader.load(Object.class, Object.class.getClassLoader()).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return (T) SequencesKt.firstOrNull(SequencesKt.asSequence(it));
    }
}