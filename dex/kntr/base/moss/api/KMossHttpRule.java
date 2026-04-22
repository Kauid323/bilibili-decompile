package kntr.base.moss.api;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossHttpRule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006\""}, d2 = {"Lkntr/base/moss/api/KMossHttpRule;", "", "verb", "Lkntr/base/moss/api/KHttpVerb;", "pattern", "", "pathBindings", "", "Lkntr/base/moss/api/KHttpBinding;", "bodyBinding", "isAsteriskBody", "", "<init>", "(Lkntr/base/moss/api/KHttpVerb;Ljava/lang/String;Ljava/util/List;Lkntr/base/moss/api/KHttpBinding;Z)V", "getVerb", "()Lkntr/base/moss/api/KHttpVerb;", "getPattern", "()Ljava/lang/String;", "getPathBindings", "()Ljava/util/List;", "getBodyBinding", "()Lkntr/base/moss/api/KHttpBinding;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossHttpRule {
    private final KHttpBinding bodyBinding;
    private final boolean isAsteriskBody;
    private final List<KHttpBinding> pathBindings;
    private final String pattern;
    private final KHttpVerb verb;

    public static /* synthetic */ KMossHttpRule copy$default(KMossHttpRule kMossHttpRule, KHttpVerb kHttpVerb, String str, List list, KHttpBinding kHttpBinding, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            kHttpVerb = kMossHttpRule.verb;
        }
        if ((i & 2) != 0) {
            str = kMossHttpRule.pattern;
        }
        String str2 = str;
        List<KHttpBinding> list2 = list;
        if ((i & 4) != 0) {
            list2 = kMossHttpRule.pathBindings;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            kHttpBinding = kMossHttpRule.bodyBinding;
        }
        KHttpBinding kHttpBinding2 = kHttpBinding;
        if ((i & 16) != 0) {
            z = kMossHttpRule.isAsteriskBody;
        }
        return kMossHttpRule.copy(kHttpVerb, str2, list3, kHttpBinding2, z);
    }

    public final KHttpVerb component1() {
        return this.verb;
    }

    public final String component2() {
        return this.pattern;
    }

    public final List<KHttpBinding> component3() {
        return this.pathBindings;
    }

    public final KHttpBinding component4() {
        return this.bodyBinding;
    }

    public final boolean component5() {
        return this.isAsteriskBody;
    }

    public final KMossHttpRule copy(KHttpVerb kHttpVerb, String str, List<KHttpBinding> list, KHttpBinding kHttpBinding, boolean z) {
        Intrinsics.checkNotNullParameter(kHttpVerb, "verb");
        Intrinsics.checkNotNullParameter(str, "pattern");
        Intrinsics.checkNotNullParameter(list, "pathBindings");
        return new KMossHttpRule(kHttpVerb, str, list, kHttpBinding, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KMossHttpRule) {
            KMossHttpRule kMossHttpRule = (KMossHttpRule) obj;
            return this.verb == kMossHttpRule.verb && Intrinsics.areEqual(this.pattern, kMossHttpRule.pattern) && Intrinsics.areEqual(this.pathBindings, kMossHttpRule.pathBindings) && Intrinsics.areEqual(this.bodyBinding, kMossHttpRule.bodyBinding) && this.isAsteriskBody == kMossHttpRule.isAsteriskBody;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.verb.hashCode() * 31) + this.pattern.hashCode()) * 31) + this.pathBindings.hashCode()) * 31) + (this.bodyBinding == null ? 0 : this.bodyBinding.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAsteriskBody);
    }

    public String toString() {
        KHttpVerb kHttpVerb = this.verb;
        String str = this.pattern;
        List<KHttpBinding> list = this.pathBindings;
        KHttpBinding kHttpBinding = this.bodyBinding;
        return "KMossHttpRule(verb=" + kHttpVerb + ", pattern=" + str + ", pathBindings=" + list + ", bodyBinding=" + kHttpBinding + ", isAsteriskBody=" + this.isAsteriskBody + ")";
    }

    public KMossHttpRule(KHttpVerb verb, String pattern, List<KHttpBinding> list, KHttpBinding bodyBinding, boolean isAsteriskBody) {
        Intrinsics.checkNotNullParameter(verb, "verb");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(list, "pathBindings");
        this.verb = verb;
        this.pattern = pattern;
        this.pathBindings = list;
        this.bodyBinding = bodyBinding;
        this.isAsteriskBody = isAsteriskBody;
    }

    public final KHttpVerb getVerb() {
        return this.verb;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final List<KHttpBinding> getPathBindings() {
        return this.pathBindings;
    }

    public final KHttpBinding getBodyBinding() {
        return this.bodyBinding;
    }

    public final boolean isAsteriskBody() {
        return this.isAsteriskBody;
    }
}