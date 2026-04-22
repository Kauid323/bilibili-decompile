package kotlinx.android.parcel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import kotlin.jvm.internal.RepeatableContainer;
import kotlinx.android.parcel.Parceler;

/* compiled from: TypeParceler.kt */
@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u00032\u00020\u0004B\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/android/parcel/TypeParceler;", "T", "P", "Lkotlinx/android/parcel/Parceler;", "", "parcelize-runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
public @interface TypeParceler<T, P extends Parceler<? super T>> {

    /* compiled from: TypeParceler.kt */
    @Target({ElementType.TYPE})
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @RepeatableContainer
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public @interface Container {
        TypeParceler[] value();
    }
}