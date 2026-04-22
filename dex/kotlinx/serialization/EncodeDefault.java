package kotlinx.serialization;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* compiled from: Annotations.kt */
@Target({})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/EncodeDefault;", "", "mode", "Lkotlinx/serialization/EncodeDefault$Mode;", "()Lkotlinx/serialization/EncodeDefault$Mode;", "Mode", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncodeDefault {

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/EncodeDefault$Mode;", "", "(Ljava/lang/String;I)V", "ALWAYS", "NEVER", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ExperimentalSerializationApi
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum Mode {
        ALWAYS,
        NEVER
    }

    Mode mode() default Mode.ALWAYS;
}