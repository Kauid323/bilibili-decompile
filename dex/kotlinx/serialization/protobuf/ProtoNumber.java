package kotlinx.serialization.protobuf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlinx.serialization.ExperimentalSerializationApi;

/* compiled from: ProtoTypes.kt */
@Target({})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/protobuf/ProtoNumber;", "", "number", "", "()I", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProtoNumber {

    /* compiled from: ProtoTypes.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class Impl implements ProtoNumber {
        private final /* synthetic */ int number;

        public Impl(int i) {
            this.number = i;
        }

        @Override // kotlinx.serialization.protobuf.ProtoNumber
        public final /* synthetic */ int number() {
            return this.number;
        }
    }

    int number();
}