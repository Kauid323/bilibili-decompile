package tv.danmaku.ijk.media.player.render.core;

public enum BiliImageOrientation {
    Up(false, 0, 1, false, 0),
    Down(false, 180, 3, false, 1),
    Right(false, 90, 6, true, 2),
    Left(false, 270, 8, true, 3),
    UpMirrored(true, 0, 2, false, 4),
    DownMirrored(true, 180, 4, false, 5),
    RightMirrored(true, 90, 5, true, 6),
    LeftMirrored(true, 270, 7, true, 7);
    
    private int _degree;
    private int _exif_orientation;
    private int _flag;
    private boolean _is_mirrored;
    private boolean _transposed;

    BiliImageOrientation(boolean _is_mirrored, int _degree, int _exif_orientation, boolean _transposed, int _flag) {
        this._is_mirrored = _is_mirrored;
        this._degree = _degree;
        this._exif_orientation = _exif_orientation;
        this._transposed = _transposed;
        this._flag = _flag;
    }

    public boolean isMirrored() {
        return this._is_mirrored;
    }

    public int getDegree() {
        return this._degree;
    }

    public int getExifOrientation() {
        return this._exif_orientation;
    }

    public boolean isTransposed() {
        return this._transposed;
    }

    public int getFlag() {
        return this._flag;
    }

    public boolean isMatch(int degree, boolean isMirrored) {
        return this._degree == degree && this._is_mirrored == isMirrored;
    }

    public static BiliImageOrientation getValue(int degree, boolean isMirrored) {
        BiliImageOrientation[] values;
        int degree2 = degree % 360;
        if (degree2 < 0) {
            degree2 += 360;
        }
        for (BiliImageOrientation item : values()) {
            if (item.isMatch(degree2, isMirrored)) {
                return item;
            }
        }
        return isMirrored ? UpMirrored : Up;
    }

    public static BiliImageOrientation getValue(int exifOrientation) {
        BiliImageOrientation[] values;
        for (BiliImageOrientation item : values()) {
            if (item.getExifOrientation() == exifOrientation) {
                return item;
            }
        }
        return Up;
    }
}