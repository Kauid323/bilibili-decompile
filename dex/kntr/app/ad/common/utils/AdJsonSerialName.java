package kntr.app.ad.common.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonExt.kt */
@Target({})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/app/ad/common/utils/AdJsonSerialName;", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "()Ljava/lang/String;", "utils_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdJsonSerialName {

    /* compiled from: JsonExt.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class Impl implements AdJsonSerialName {
        private final /* synthetic */ String value;

        public Impl(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }

        @Override // kntr.app.ad.common.utils.AdJsonSerialName
        public final /* synthetic */ String value() {
            return this.value;
        }
    }

    String value();
}