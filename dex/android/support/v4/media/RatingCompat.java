package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.compose.material3.MenuKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel p) {
            return new RatingCompat(p.readInt(), p.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int size) {
            return new RatingCompat[size];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public @interface Style {
    }

    RatingCompat(int ratingStyle, float rating) {
        this.mRatingStyle = ratingStyle;
        this.mRatingValue = rating;
    }

    public String toString() {
        return "Rating:style=" + this.mRatingStyle + " rating=" + (this.mRatingValue < MenuKt.ClosedAlphaTarget ? "unrated" : String.valueOf(this.mRatingValue));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mRatingStyle);
        dest.writeFloat(this.mRatingValue);
    }

    public static RatingCompat newUnratedRating(int ratingStyle) {
        switch (ratingStyle) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(ratingStyle, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public static RatingCompat newHeartRating(boolean hasHeart) {
        return new RatingCompat(1, hasHeart ? 1.0f : MenuKt.ClosedAlphaTarget);
    }

    public static RatingCompat newThumbRating(boolean thumbIsUp) {
        return new RatingCompat(2, thumbIsUp ? 1.0f : MenuKt.ClosedAlphaTarget);
    }

    public static RatingCompat newStarRating(int starRatingStyle, float starRating) {
        float maxRating;
        switch (starRatingStyle) {
            case 3:
                maxRating = 3.0f;
                break;
            case 4:
                maxRating = 4.0f;
                break;
            case 5:
                maxRating = 5.0f;
                break;
            default:
                Log.e(TAG, "Invalid rating style (" + starRatingStyle + ") for a star rating");
                return null;
        }
        if (starRating < MenuKt.ClosedAlphaTarget || starRating > maxRating) {
            Log.e(TAG, "Trying to set out of range star-based rating");
            return null;
        }
        return new RatingCompat(starRatingStyle, starRating);
    }

    public static RatingCompat newPercentageRating(float percent) {
        if (percent < MenuKt.ClosedAlphaTarget || percent > 100.0f) {
            Log.e(TAG, "Invalid percentage-based rating value");
            return null;
        }
        return new RatingCompat(6, percent);
    }

    public boolean isRated() {
        return this.mRatingValue >= MenuKt.ClosedAlphaTarget;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public boolean hasHeart() {
        return this.mRatingStyle == 1 && this.mRatingValue == 1.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public float getStarRating() {
        switch (this.mRatingStyle) {
            case 3:
            case 4:
            case 5:
                if (isRated()) {
                    return this.mRatingValue;
                }
                return RATING_NOT_RATED;
            default:
                return RATING_NOT_RATED;
        }
    }

    public float getPercentRating() {
        if (this.mRatingStyle != 6 || !isRated()) {
            return RATING_NOT_RATED;
        }
        return this.mRatingValue;
    }

    public static RatingCompat fromRating(Object ratingObj) {
        RatingCompat rating;
        if (ratingObj == null) {
            return null;
        }
        int ratingStyle = Api19Impl.getRatingStyle((Rating) ratingObj);
        if (Api19Impl.isRated((Rating) ratingObj)) {
            switch (ratingStyle) {
                case 1:
                    rating = newHeartRating(Api19Impl.hasHeart((Rating) ratingObj));
                    break;
                case 2:
                    rating = newThumbRating(Api19Impl.isThumbUp((Rating) ratingObj));
                    break;
                case 3:
                case 4:
                case 5:
                    rating = newStarRating(ratingStyle, Api19Impl.getStarRating((Rating) ratingObj));
                    break;
                case 6:
                    rating = newPercentageRating(Api19Impl.getPercentRating((Rating) ratingObj));
                    break;
                default:
                    return null;
            }
        } else {
            rating = newUnratedRating(ratingStyle);
        }
        rating.mRatingObj = ratingObj;
        return rating;
    }

    public Object getRating() {
        if (this.mRatingObj == null) {
            if (isRated()) {
                switch (this.mRatingStyle) {
                    case 1:
                        this.mRatingObj = Api19Impl.newHeartRating(hasHeart());
                        break;
                    case 2:
                        this.mRatingObj = Api19Impl.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.mRatingObj = Api19Impl.newStarRating(this.mRatingStyle, getStarRating());
                        break;
                    case 6:
                        this.mRatingObj = Api19Impl.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.mRatingObj = Api19Impl.newUnratedRating(this.mRatingStyle);
            }
        }
        return this.mRatingObj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static int getRatingStyle(Rating rating) {
            return rating.getRatingStyle();
        }

        static boolean isRated(Rating rating) {
            return rating.isRated();
        }

        static boolean hasHeart(Rating rating) {
            return rating.hasHeart();
        }

        static boolean isThumbUp(Rating rating) {
            return rating.isThumbUp();
        }

        static float getStarRating(Rating rating) {
            return rating.getStarRating();
        }

        static float getPercentRating(Rating rating) {
            return rating.getPercentRating();
        }

        static Rating newHeartRating(boolean hasHeart) {
            return Rating.newHeartRating(hasHeart);
        }

        static Rating newThumbRating(boolean thumbIsUp) {
            return Rating.newThumbRating(thumbIsUp);
        }

        static Rating newStarRating(int starRatingStyle, float starRating) {
            return Rating.newStarRating(starRatingStyle, starRating);
        }

        static Rating newPercentageRating(float percent) {
            return Rating.newPercentageRating(percent);
        }

        static Rating newUnratedRating(int ratingStyle) {
            return Rating.newUnratedRating(ratingStyle);
        }
    }
}