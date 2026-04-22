package tv.danmaku.ijk.media.player.render.output;

import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public interface IOprationRenderer {
    BiliSize getTransformSize();

    void setAspectRatio(int i);

    void setMirror(int i, boolean z);

    void setRotation(float f);

    void setRotation(float f, float f2, float f3);

    void setScale(float f);

    void setScale(float f, float f2, float f3);

    void setScreenSize(int i, int i2);

    void setTextureSize(int i, int i2);

    void setTranslate(float f, float f2);

    void setTranslate(int i, int i2);
}