package tv.danmaku.bili.category;

import android.content.res.Resources;
import android.util.SparseIntArray;

abstract class BaseCategoryManager {
    private static final int FAKE_OFFSET = 65536;
    public static final int T1_ADVERTISE = 165;
    public static final int T1_ALBUM = 65544;
    public static final int T1_ANIMATE = 1;
    public static final int T1_AUDIO = 65543;
    public static final int T1_BANGUMI = 13;
    public static final int T1_BANGUMI_DOMESTIC = 167;
    public static final int T1_CINEMA = 65545;
    public static final int T1_CLIP_VIDEO = 65542;
    public static final int T1_COLUMN = 65541;
    public static final int T1_DANCE = 129;
    public static final int T1_DOCUMENT = 177;
    public static final int T1_FASHION = 155;
    public static final int T1_FUN = 5;
    public static final int T1_GAME = 4;
    public static final int T1_GAME_CENTER = 65539;
    public static final int T1_KICHIKU = 119;
    public static final int T1_LIFE = 160;
    public static final int T1_LIVE = 65537;
    public static final int T1_MALL = 65546;
    public static final int T1_MOVIE = 23;
    public static final int T1_MOVIES = 181;
    public static final int T1_MUSIC = 3;
    public static final int T1_PROMO = 65538;
    public static final int T1_SC = 36;
    public static final int T1_TV = 11;
    public static final int T2_ADVERTISE = 166;
    public static final int T2_BANGUMI_ON_AIR = 33;
    public static final int T2_DOMESTIC_ON_AIR = 153;
    public static final int T2_GAME_CENTER = 65540;
    public static final int T_ROOT = 0;
    private static final SparseIntArray sIconsArray = new SparseIntArray();
    private static String sPKGName;

    static {
        sIconsArray.append(T1_LIVE, R.mipmap.ic_category_live);
        sIconsArray.append(T1_PROMO, R.mipmap.ic_category_promo);
        sIconsArray.append(T1_GAME_CENTER, R.mipmap.ic_category_game_center);
        sIconsArray.append(T1_CLIP_VIDEO, R.mipmap.ic_category_clip_video);
        sIconsArray.append(T2_GAME_CENTER, R.mipmap.ic_category_game_center2);
        sIconsArray.append(T1_COLUMN, R.mipmap.ic_category_column);
        sIconsArray.append(T1_AUDIO, R.mipmap.ic_category_audio);
        sIconsArray.append(T1_ALBUM, R.mipmap.ic_category_album);
        sIconsArray.append(T1_MALL, R.mipmap.ic_category_mall);
        sIconsArray.append(T1_CINEMA, R.mipmap.ic_category_cinema);
        sIconsArray.append(13, R.mipmap.ic_category_t13);
        sIconsArray.append(1, R.mipmap.ic_category_t1);
        sIconsArray.append(167, R.mipmap.ic_category_t167);
        sIconsArray.append(3, R.mipmap.ic_category_t3);
        sIconsArray.append(4, R.mipmap.ic_category_t4);
        sIconsArray.append(5, R.mipmap.ic_category_t5);
        sIconsArray.append(11, R.mipmap.ic_category_t11);
        sIconsArray.append(23, R.mipmap.ic_category_t23);
        sIconsArray.append(36, R.mipmap.ic_category_t36);
        sIconsArray.append(119, R.mipmap.ic_category_t119);
        sIconsArray.append(129, R.mipmap.ic_category_t129);
        sIconsArray.append(155, R.mipmap.ic_category_t155);
        sIconsArray.append(160, R.mipmap.ic_category_t160);
        sIconsArray.append(165, R.mipmap.ic_category_t165);
        sIconsArray.append(181, R.mipmap.ic_category_t181);
    }

    public static int getIconResId(Resources res, int tid) {
        int id = sIconsArray.get(tid);
        if (id != 0) {
            return id;
        }
        if (sPKGName == null) {
            sPKGName = res.getResourcePackageName(R.mipmap.ic_category_live);
        }
        int id2 = res.getIdentifier("ic_category_t" + tid, "mipmap", sPKGName);
        if (id2 == 0) {
            id2 = R.mipmap.ic_category_unknown;
        }
        sIconsArray.put(tid, id2);
        return id2;
    }
}