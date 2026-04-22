package kntr.app.game.steam.background;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: SteamGameBackground.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lkntr/app/game/steam/background/HSL;", RoomRecommendViewModel.EMPTY_CURSOR, "h", RoomRecommendViewModel.EMPTY_CURSOR, "s", "l", "<init>", "(FFF)V", "getH", "()F", "getS", "getL", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HSL {
    public static final int $stable = 0;
    private final float h;
    private final float l;
    private final float s;

    public static /* synthetic */ HSL copy$default(HSL hsl, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = hsl.h;
        }
        if ((i & 2) != 0) {
            f2 = hsl.s;
        }
        if ((i & 4) != 0) {
            f3 = hsl.l;
        }
        return hsl.copy(f, f2, f3);
    }

    public final float component1() {
        return this.h;
    }

    public final float component2() {
        return this.s;
    }

    public final float component3() {
        return this.l;
    }

    public final HSL copy(float f, float f2, float f3) {
        return new HSL(f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HSL) {
            HSL hsl = (HSL) obj;
            return Float.compare(this.h, hsl.h) == 0 && Float.compare(this.s, hsl.s) == 0 && Float.compare(this.l, hsl.l) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.h) * 31) + Float.floatToIntBits(this.s)) * 31) + Float.floatToIntBits(this.l);
    }

    public String toString() {
        float f = this.h;
        float f2 = this.s;
        return "HSL(h=" + f + ", s=" + f2 + ", l=" + this.l + ")";
    }

    public HSL(float h, float s, float l) {
        this.h = h;
        this.s = s;
        this.l = l;
    }

    public final float getH() {
        return this.h;
    }

    public final float getS() {
        return this.s;
    }

    public final float getL() {
        return this.l;
    }
}