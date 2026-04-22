package kntr.app.upper.manuscript.cover;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.manuscript.extension.RectF;
import kntr.app.upper.manuscript.extension.ResizeMode;
import kntr.app.upper.manuscript.extension.Size;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoverCropService.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0012\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0011\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0007J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0014\u0010\u001b\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0014\u0010\u001c\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0014\u0010\u001e\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0014\u0010\u001f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010 \u001a\u00020\u0019H\u0002J\u001c\u0010!\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0019H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lkntr/app/upper/manuscript/cover/CoverCropService;", "", "originSize", "Lkntr/app/upper/manuscript/extension/Size;", "cropBound", "Lkntr/app/upper/manuscript/extension/RectF;", "cropStrategy", "", "Lkntr/app/upper/manuscript/cover/CoverCropService$Strategy;", "<init>", "(Lkntr/app/upper/manuscript/extension/Size;Lkntr/app/upper/manuscript/extension/RectF;Ljava/util/List;)V", "builder", "Lkntr/app/upper/manuscript/cover/CoverCropService$Builder;", "(Lkntr/app/upper/manuscript/cover/CoverCropService$Builder;)V", "getOriginSize", "()Lkntr/app/upper/manuscript/extension/Size;", "getCropBound", "()Lkntr/app/upper/manuscript/extension/RectF;", "getCropStrategy", "()Ljava/util/List;", "cropWithArray", "", "()[Lkntr/app/upper/manuscript/extension/RectF;", "crop", "left", "", "width", "right", "top", "height", "bottom", "inside", "targetRatio", "outside", "Companion", "Strategy", "Builder", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CoverCropService {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CoverCropService";
    private final RectF cropBound;
    private final List<Strategy> cropStrategy;
    private final Size originSize;

    /* compiled from: CoverCropService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResizeMode.values().length];
            try {
                iArr[ResizeMode.FIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ResizeMode.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CoverCropService(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CoverCropService(Size originSize, RectF cropBound, List<Strategy> list) {
        this.originSize = originSize;
        this.cropBound = cropBound;
        this.cropStrategy = list;
    }

    public final Size getOriginSize() {
        return this.originSize;
    }

    public final RectF getCropBound() {
        return this.cropBound;
    }

    public final List<Strategy> getCropStrategy() {
        return this.cropStrategy;
    }

    private CoverCropService(Builder builder) {
        this(builder.getOriginSize(), builder.getCropBound(), builder.getCropStrategy());
    }

    /* compiled from: CoverCropService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/upper/manuscript/cover/CoverCropService$Companion;", "", "<init>", "()V", "TAG", "", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CoverCropService.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lkntr/app/upper/manuscript/cover/CoverCropService$Strategy;", "", "mode", "Lkntr/app/upper/manuscript/extension/ResizeMode;", "targetRatio", "", "overlap", "", "<init>", "(Lkntr/app/upper/manuscript/extension/ResizeMode;FZ)V", "getMode", "()Lkntr/app/upper/manuscript/extension/ResizeMode;", "getTargetRatio", "()F", "getOverlap", "()Z", "toString", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Strategy {
        private final ResizeMode mode;
        private final boolean overlap;
        private final float targetRatio;

        public static /* synthetic */ Strategy copy$default(Strategy strategy, ResizeMode resizeMode, float f, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                resizeMode = strategy.mode;
            }
            if ((i & 2) != 0) {
                f = strategy.targetRatio;
            }
            if ((i & 4) != 0) {
                z = strategy.overlap;
            }
            return strategy.copy(resizeMode, f, z);
        }

        public final ResizeMode component1() {
            return this.mode;
        }

        public final float component2() {
            return this.targetRatio;
        }

        public final boolean component3() {
            return this.overlap;
        }

        public final Strategy copy(ResizeMode resizeMode, float f, boolean z) {
            Intrinsics.checkNotNullParameter(resizeMode, "mode");
            return new Strategy(resizeMode, f, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Strategy) {
                Strategy strategy = (Strategy) obj;
                return this.mode == strategy.mode && Float.compare(this.targetRatio, strategy.targetRatio) == 0 && this.overlap == strategy.overlap;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mode.hashCode() * 31) + Float.floatToIntBits(this.targetRatio)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.overlap);
        }

        public Strategy(ResizeMode mode, float targetRatio, boolean overlap) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            this.targetRatio = targetRatio;
            this.overlap = overlap;
        }

        public /* synthetic */ Strategy(ResizeMode resizeMode, float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(resizeMode, f, (i & 4) != 0 ? false : z);
        }

        public final ResizeMode getMode() {
            return this.mode;
        }

        public final float getTargetRatio() {
            return this.targetRatio;
        }

        public final boolean getOverlap() {
            return this.overlap;
        }

        public String toString() {
            ResizeMode resizeMode = this.mode;
            float f = this.targetRatio;
            return "Strategy(mode=" + resizeMode + ", targetRatio=" + f + ", overlap=" + this.overlap + ")";
        }
    }

    /* compiled from: CoverCropService.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rJ\u001f\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u001c\"\u00020\u0013¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00002\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u001c\"\u00020\u0013¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010!\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lkntr/app/upper/manuscript/cover/CoverCropService$Builder;", "", "originSize", "Lkntr/app/upper/manuscript/extension/Size;", "<init>", "(Lkntr/app/upper/manuscript/extension/Size;)V", "getOriginSize", "()Lkntr/app/upper/manuscript/extension/Size;", "value", "", "cropRatio", "getCropRatio", "()F", "Lkntr/app/upper/manuscript/extension/RectF;", "cropBound", "getCropBound", "()Lkntr/app/upper/manuscript/extension/RectF;", "cropStrategy", "", "Lkntr/app/upper/manuscript/cover/CoverCropService$Strategy;", "getCropStrategy", "()Ljava/util/List;", "setCropRatio", "ratio", "setCropBound", "bound", "setCropStrategy", "strategy", "", "([Lkntr/app/upper/manuscript/cover/CoverCropService$Strategy;)Lkntr/app/upper/manuscript/cover/CoverCropService$Builder;", "addCropStrategy", "build", "Lkntr/app/upper/manuscript/cover/CoverCropService;", "ratioToBound", "manuscript_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Builder {
        private RectF cropBound;
        private float cropRatio;
        private final List<Strategy> cropStrategy;
        private final Size originSize;

        public Builder(Size originSize) {
            Intrinsics.checkNotNullParameter(originSize, "originSize");
            this.originSize = originSize;
            this.cropRatio = 1.6f;
            this.cropBound = ratioToBound(this.originSize, this.cropRatio);
            this.cropStrategy = new ArrayList();
        }

        public final Size getOriginSize() {
            return this.originSize;
        }

        public final float getCropRatio() {
            return this.cropRatio;
        }

        public final RectF getCropBound() {
            return this.cropBound;
        }

        public final List<Strategy> getCropStrategy() {
            return this.cropStrategy;
        }

        public final Builder setCropRatio(float ratio) {
            Builder $this$setCropRatio_u24lambda_u240 = this;
            $this$setCropRatio_u24lambda_u240.cropRatio = ratio;
            $this$setCropRatio_u24lambda_u240.setCropBound($this$setCropRatio_u24lambda_u240.ratioToBound($this$setCropRatio_u24lambda_u240.originSize, ratio));
            return this;
        }

        public final Builder setCropBound(RectF bound) {
            Intrinsics.checkNotNullParameter(bound, "bound");
            Builder $this$setCropBound_u24lambda_u240 = this;
            $this$setCropBound_u24lambda_u240.cropBound = bound;
            return this;
        }

        public final Builder setCropStrategy(Strategy... strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            Builder $this$setCropStrategy_u24lambda_u240 = this;
            $this$setCropStrategy_u24lambda_u240.cropStrategy.clear();
            CollectionsKt.addAll($this$setCropStrategy_u24lambda_u240.cropStrategy, strategy);
            return this;
        }

        public final Builder addCropStrategy(Strategy... strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            Builder $this$addCropStrategy_u24lambda_u240 = this;
            CollectionsKt.addAll($this$addCropStrategy_u24lambda_u240.cropStrategy, strategy);
            return this;
        }

        public final CoverCropService build() {
            return new CoverCropService(this, null);
        }

        private final RectF ratioToBound(Size $this$ratioToBound, float ratio) {
            float expectWidth = $this$ratioToBound.getHeight() * ratio;
            float expectHeight = $this$ratioToBound.getWidth() / ratio;
            if (expectWidth > $this$ratioToBound.getWidth()) {
                return new RectF(0.0f, ($this$ratioToBound.getHeight() - expectHeight) / 2.0f, $this$ratioToBound.getWidth(), ($this$ratioToBound.getHeight() + expectHeight) / 2.0f);
            }
            return new RectF(($this$ratioToBound.getWidth() - expectWidth) / 2.0f, 0.0f, ($this$ratioToBound.getWidth() + expectWidth) / 2.0f, $this$ratioToBound.getHeight());
        }
    }

    public final RectF[] cropWithArray() {
        Collection $this$toTypedArray$iv = crop();
        return (RectF[]) $this$toTypedArray$iv.toArray(new RectF[0]);
    }

    public final List<RectF> crop() {
        Object m2636constructorimpl;
        CoverCropService $this$crop_u24lambda_u240;
        RectF actualBound;
        try {
            Result.Companion companion = Result.Companion;
            $this$crop_u24lambda_u240 = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (!$this$crop_u24lambda_u240.cropBound.isValid($this$crop_u24lambda_u240.originSize) || $this$crop_u24lambda_u240.cropStrategy.isEmpty()) {
            Size size = $this$crop_u24lambda_u240.originSize;
            RectF rectF = $this$crop_u24lambda_u240.cropBound;
            throw new Throwable("Crop param invalid! originSize=" + size + ", cropBound=" + rectF + ", cropStrategy=" + $this$crop_u24lambda_u240.cropStrategy);
        }
        ArrayList outputBounds = new ArrayList();
        Iterable $this$onEach$iv = $this$crop_u24lambda_u240.cropStrategy;
        for (Object element$iv : $this$onEach$iv) {
            Strategy it = (Strategy) element$iv;
            switch (WhenMappings.$EnumSwitchMapping$0[it.getMode().ordinal()]) {
                case 1:
                    actualBound = $this$crop_u24lambda_u240.inside($this$crop_u24lambda_u240.cropBound, it.getTargetRatio());
                    break;
                case 2:
                    actualBound = $this$crop_u24lambda_u240.outside($this$crop_u24lambda_u240.cropBound, $this$crop_u24lambda_u240.originSize, it.getTargetRatio());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (it.getOverlap()) {
                actualBound.setLeft(Math.min(actualBound.getLeft(), $this$crop_u24lambda_u240.cropBound.getLeft()));
                actualBound.setTop(Math.min(actualBound.getTop(), $this$crop_u24lambda_u240.cropBound.getTop()));
                actualBound.setRight(Math.max(actualBound.getRight(), $this$crop_u24lambda_u240.cropBound.getRight()));
                actualBound.setBottom(Math.max(actualBound.getBottom(), $this$crop_u24lambda_u240.cropBound.getBottom()));
            }
            outputBounds.add(actualBound);
        }
        m2636constructorimpl = Result.m2636constructorimpl(outputBounds);
        Throwable it2 = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        ArrayList arrayList = m2636constructorimpl;
        if (it2 != null) {
            KLog_androidKt.getKLog().e(TAG, "Crop failed: " + it2.getMessage());
            arrayList = new ArrayList();
        }
        return (List) arrayList;
    }

    private final float left(float $this$left, float width) {
        return $this$left - (width / 2);
    }

    private final float right(float $this$right, float width) {
        return (width / 2) + $this$right;
    }

    private final float top(float $this$top, float height) {
        return $this$top - (height / 2);
    }

    private final float bottom(float $this$bottom, float height) {
        return (height / 2) + $this$bottom;
    }

    private final RectF inside(RectF $this$inside, float targetRatio) {
        float actualWidth;
        float actualHeight;
        if (targetRatio > $this$inside.getRatio()) {
            actualWidth = $this$inside.getWidth();
            actualHeight = $this$inside.getWidth() / targetRatio;
        } else {
            float actualHeight2 = $this$inside.getHeight();
            actualWidth = actualHeight2 * targetRatio;
            actualHeight = $this$inside.getHeight();
        }
        return new RectF(left($this$inside.getCenterX(), actualWidth), top($this$inside.getCenterY(), actualHeight), right($this$inside.getCenterX(), actualWidth), bottom($this$inside.getCenterY(), actualHeight));
    }

    private final RectF outside(RectF $this$outside, Size originSize, float targetRatio) {
        float height;
        float actualHeight;
        float actualWidth;
        float width;
        if (targetRatio > $this$outside.getRatio()) {
            float expectWidth = $this$outside.getHeight() * targetRatio;
            if (left($this$outside.getCenterX(), expectWidth) < 0.0f || right($this$outside.getCenterX(), expectWidth) > originSize.getWidth()) {
                width = $this$outside.getWidth() + ((int) (Math.min($this$outside.getLeft(), originSize.getWidth() - $this$outside.getRight()) * 2));
            } else {
                width = expectWidth;
            }
            actualWidth = width;
            actualHeight = actualWidth / targetRatio;
        } else {
            float expectHeight = $this$outside.getWidth() / targetRatio;
            if (top($this$outside.getCenterY(), expectHeight) < 0.0f || bottom($this$outside.getCenterY(), expectHeight) > originSize.getHeight()) {
                height = $this$outside.getHeight() + ((int) (Math.min($this$outside.getTop(), originSize.getHeight() - $this$outside.getBottom()) * 2));
            } else {
                height = expectHeight;
            }
            actualHeight = height;
            actualWidth = actualHeight * targetRatio;
        }
        return new RectF(left($this$outside.getCenterX(), actualWidth), top($this$outside.getCenterY(), actualHeight), right($this$outside.getCenterX(), actualWidth), bottom($this$outside.getCenterY(), actualHeight));
    }
}