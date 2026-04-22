package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;

/* compiled from: ReturnValue.kt */
@Target({ElementType.METHOD})
@MustBeDocumented
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlin/IgnorableReturnValue;", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnorableReturnValue {
}