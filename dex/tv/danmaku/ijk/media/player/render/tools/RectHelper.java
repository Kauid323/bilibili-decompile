package tv.danmaku.ijk.media.player.render.tools;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;

public class RectHelper {
    public static Rect computerCenter(BiliSize mainSize, BiliSize rectSize) {
        if (rectSize == null) {
            return null;
        }
        RectF rectF = computerCenterRectF(mainSize, rectSize.getWidth() / rectSize.getHeight(), true);
        return fixedRectF(mainSize, rectF);
    }

    public static Rect computerCenter(BiliSize mainSize, float ratio) {
        RectF rectF = computerCenterRectF(mainSize, ratio, true);
        return fixedRectF(mainSize, rectF);
    }

    public static RectF computerCenterRectF(BiliSize mainSize, float ratio) {
        return computerCenterRectF(mainSize, ratio, true);
    }

    public static RectF computerCenterRectF(BiliSize mainSize, float ratio, boolean keepRatio) {
        if (mainSize == null) {
            return null;
        }
        RectF rect = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, mainSize.getWidth(), mainSize.getHeight());
        if (ratio <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            return rect;
        }
        if (ratio == 1.0f) {
            float min = Math.min(mainSize.getWidth(), mainSize.getHeight());
            rect.bottom = min;
            rect.right = min;
        } else {
            if (ratio > 1.0f && !keepRatio) {
                ratio = 1.0f / ratio;
            }
            float originRatio = mainSize.minMaxRatio();
            int baseRatio = ratio < originRatio ? (char) 1 : 0;
            int baseWidth = mainSize.getWidth() < mainSize.getHeight() ? 1 : 0;
            float[][] wArray = {new float[]{mainSize.getWidth(), mainSize.getHeight() / ratio}, new float[]{mainSize.getHeight() * ratio, mainSize.getWidth()}};
            float[][] hArray = {new float[]{mainSize.getHeight(), mainSize.getWidth() / ratio}, new float[]{mainSize.getWidth() * ratio, mainSize.getHeight()}};
            rect.right = wArray[baseRatio][1 - baseWidth];
            rect.bottom = hArray[baseRatio][baseWidth];
        }
        rect.left = (mainSize.getWidth() - rect.width()) * 0.5f;
        rect.top = (mainSize.getHeight() - rect.height()) * 0.5f;
        rect.right += rect.left;
        rect.bottom += rect.top;
        return rect;
    }

    public static Rect fixedRectF(BiliSize mainSize, RectF corpRect) {
        if (mainSize == null || corpRect == null) {
            return null;
        }
        Rect rect = new Rect();
        rect.top = (int) Math.floor(corpRect.top);
        rect.bottom = (int) Math.floor(corpRect.bottom);
        rect.left = (int) Math.floor(corpRect.left);
        rect.right = (int) Math.floor(corpRect.right);
        if (rect.top < 0) {
            rect.bottom -= rect.top;
            rect.top = 0;
        }
        if (rect.left < 0) {
            rect.right -= rect.left;
            rect.left = 0;
        }
        if (rect.height() > mainSize.getHeight()) {
            rect.bottom = rect.top + mainSize.getHeight();
        }
        if (rect.height() % 2 != 0) {
            rect.bottom--;
        }
        if (rect.width() > mainSize.getWidth()) {
            rect.right = rect.left + mainSize.getWidth();
        }
        if (rect.width() % 2 != 0) {
            rect.right--;
        }
        return rect;
    }

    public static RectF fixedCorpPercentRect(RectF rect, BiliImageOrientation orientation) {
        if (rect == null) {
            return null;
        }
        if (rect.right > 1.0f) {
            rect.right = 1.0f;
        }
        if (rect.bottom > 1.0f) {
            rect.bottom = 1.0f;
        }
        if (rect.left < DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            rect.left = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        if (rect.top < DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            rect.top = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        if (rect.width() > 1.0f) {
            rect.left = 1.0f - rect.right;
        }
        if (rect.height() > 1.0f) {
            rect.top = 1.0f - rect.bottom;
        }
        if (orientation == null) {
            return rect;
        }
        RectF corp = new RectF(rect);
        switch (orientation) {
            case UpMirrored:
                corp.left = 1.0f - rect.right;
                corp.right = corp.left + rect.width();
                break;
            case Down:
                corp.left = 1.0f - rect.right;
                corp.right = corp.left + rect.width();
                corp.bottom = 1.0f - rect.top;
                corp.top = corp.bottom - rect.height();
                break;
            case DownMirrored:
                corp.bottom = 1.0f - rect.top;
                corp.top = corp.bottom - rect.height();
                break;
            case Right:
                corp.left = rect.top;
                corp.right = corp.left + rect.height();
                corp.top = 1.0f - rect.right;
                corp.bottom = corp.top + rect.width();
                break;
            case RightMirrored:
                corp.left = rect.top;
                corp.right = corp.left + rect.height();
                corp.top = rect.left;
                corp.bottom = corp.top + rect.width();
                break;
            case Left:
                corp.left = 1.0f - rect.bottom;
                corp.right = corp.left + rect.height();
                corp.top = rect.left;
                corp.bottom = corp.top + rect.width();
                break;
            case LeftMirrored:
                corp.left = 1.0f - rect.bottom;
                corp.right = corp.left + rect.height();
                corp.top = 1.0f - rect.right;
                corp.bottom = corp.top + rect.width();
                break;
        }
        return corp;
    }

    public static BiliSize computerOutSize(BiliSize size, float ratio, boolean baseLongSide) {
        float rectRatio = size.getRatioFloat();
        if (ratio == rectRatio) {
            return size;
        }
        BiliSize s = BiliSize.create(size);
        if (baseLongSide) {
            if (rectRatio > ratio) {
                s.setHeight(size.getHeight());
                s.setWidth((int) Math.floor(s.getWidth() * ratio));
            } else {
                s.setWidth(size.getWidth());
                s.setHeight((int) Math.floor(s.getWidth() / ratio));
            }
        } else if (rectRatio > ratio) {
            s.setWidth(size.getWidth());
            s.setHeight((int) Math.floor(s.getWidth() / ratio));
        } else {
            s.setHeight(size.getHeight());
            s.setWidth((int) Math.floor(s.getHeight() * ratio));
        }
        return s;
    }

    public static Rect computerOutCenter(Rect rect, float ratio, boolean baseLongSide) {
        Rect oRect = new Rect(rect);
        BiliSize size = computerOutSize(BiliSize.create(rect), ratio, baseLongSide);
        oRect.left -= (size.getWidth() - oRect.width()) / 2;
        oRect.right = oRect.left + size.getWidth();
        oRect.top -= (size.getHeight() - oRect.height()) / 2;
        oRect.bottom = oRect.top + size.getHeight();
        return oRect;
    }

    public static float computerOutScale(Rect rect, float ratio, boolean baseLongSide) {
        Rect oRect = computerOutCenter(rect, ratio, baseLongSide);
        float wScale = oRect.width() / rect.width();
        float hScale = oRect.height() / rect.height();
        if (baseLongSide) {
            return Math.min(wScale, hScale);
        }
        return Math.max(wScale, hScale);
    }

    public static float computeAngle(PointF point, PointF cPoint) {
        float length = getDistanceOfTwoPoints(point, cPoint);
        float hudu = (float) Math.asin(Math.abs(point.y - cPoint.y) / length);
        float ag = (float) ((180.0f * hudu) / 3.141592653589793d);
        if (cPoint.x - point.x <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && cPoint.y - point.y >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ag = 90.0f - ag;
        } else if (cPoint.x - point.x <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && cPoint.y - point.y <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ag += 90.0f;
        } else if (cPoint.x - point.x >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && cPoint.y - point.y <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ag = 270.0f - ag;
        } else if (cPoint.x - point.x >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && cPoint.y - point.y >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ag += 270.0f;
        }
        return ag - 235.0f;
    }

    public static float getDistanceOfTwoPoints(PointF end, PointF start) {
        return getDistanceOfTwoPoints(end.x, end.y, start.x, start.y);
    }

    public static float getDistanceOfTwoPoints(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x1 - x2, 2.0d) + Math.pow(y1 - y2, 2.0d));
    }

    public static Rect computerMinMaxSideInRegionRatio(BiliSize imageSize, float minMaxSideratio) {
        if (imageSize == null || !imageSize.isSize() || minMaxSideratio <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || minMaxSideratio > 1.0f) {
            return null;
        }
        BiliSize aspectRatio = BiliSize.create(imageSize);
        if (imageSize.maxSide() == imageSize.getHeight()) {
            aspectRatio.setWidth((int) (imageSize.getHeight() * minMaxSideratio));
        } else {
            aspectRatio.setHeight((int) (imageSize.getWidth() * minMaxSideratio));
        }
        Rect rect = makeRectWithAspectRatioInsideRect(aspectRatio.evenSize(), new Rect(0, 0, imageSize.getWidth(), imageSize.getHeight()));
        return rect;
    }

    public static RectF minEnclosingRectangle(PointF cPoint, BiliSize size, float degree) {
        PointF vPoint = new PointF(size.getWidth() * 0.5f, size.getHeight() * 0.5f);
        RectF rect = new RectF();
        PointF point = new PointF();
        point.x = -vPoint.x;
        point.y = -vPoint.y;
        mergeEnclosingRectangle(rect, point, degree);
        point.x = vPoint.x;
        point.y = -vPoint.y;
        mergeEnclosingRectangle(rect, point, degree);
        point.x = -vPoint.x;
        point.y = vPoint.y;
        mergeEnclosingRectangle(rect, point, degree);
        point.x = vPoint.x;
        point.y = vPoint.y;
        mergeEnclosingRectangle(rect, point, degree);
        rect.left += cPoint.x;
        rect.top += cPoint.y;
        rect.right += cPoint.x;
        rect.bottom += cPoint.y;
        return rect;
    }

    public static void mergeEnclosingRectangle(RectF rect, PointF point, float degree) {
        PointF rPoint = rotationWithOrigin(point, degree);
        rect.left = Math.min(rect.left, rPoint.x);
        rect.right = Math.max(rect.right, rPoint.x);
        rect.top = Math.min(rect.top, rPoint.y);
        rect.bottom = Math.max(rect.bottom, rPoint.y);
    }

    public static PointF rotationWithOrigin(PointF point, float degree) {
        PointF nRect = new PointF();
        double ang = (degree * 3.141592653589793d) / 180.0d;
        nRect.x = (float) ((point.x * Math.cos(ang)) + (point.y * Math.sin(ang)));
        nRect.y = (float) ((point.y * Math.cos(ang)) - (point.x * Math.sin(ang)));
        return nRect;
    }

    public static Rect rotationWithRotation(Rect rect, BiliSize size, BiliImageOrientation rotation) {
        if (rect == null || size == null || rotation == null || rect.width() <= 0 || rect.height() <= 0 || rect.right > size.getWidth() || rect.bottom > size.getHeight()) {
            return rect;
        }
        switch (rotation) {
            case UpMirrored:
                Rect outRect = new Rect(size.getWidth() - rect.right, rect.top, size.getWidth() - rect.left, rect.bottom);
                return outRect;
            case Down:
                Rect outRect2 = new Rect(size.getWidth() - rect.right, size.getHeight() - rect.bottom, size.getWidth() - rect.left, size.getHeight() - rect.top);
                return outRect2;
            case DownMirrored:
                Rect outRect3 = new Rect(rect.left, size.getHeight() - rect.bottom, rect.right, size.getHeight() - rect.top);
                return outRect3;
            case Right:
                Rect outRect4 = new Rect(rect.top, size.getWidth() - rect.right, rect.bottom, size.getWidth() - rect.left);
                return outRect4;
            case RightMirrored:
                Rect outRect5 = new Rect(rect.top, rect.left, rect.bottom, rect.right);
                return outRect5;
            case Left:
                Rect outRect6 = new Rect(size.getHeight() - rect.bottom, rect.left, size.getHeight() - rect.top, rect.right);
                return outRect6;
            case LeftMirrored:
                Rect outRect7 = new Rect(size.getHeight() - rect.bottom, size.getWidth() - rect.right, size.getHeight() - rect.top, size.getWidth() - rect.left);
                return outRect7;
            default:
                Rect outRect8 = new Rect(rect);
                return outRect8;
        }
    }

    public static RectF rotationWithRotation(RectF rect, BiliImageOrientation rotation) {
        if (rect == null || rotation == null) {
            return rect;
        }
        switch (rotation) {
            case UpMirrored:
                RectF outRect = new RectF(1.0f - rect.right, rect.top, 1.0f - rect.left, rect.bottom);
                return outRect;
            case Down:
                RectF outRect2 = new RectF(1.0f - rect.right, 1.0f - rect.bottom, 1.0f - rect.left, 1.0f - rect.top);
                return outRect2;
            case DownMirrored:
                RectF outRect3 = new RectF(rect.left, 1.0f - rect.bottom, rect.right, 1.0f - rect.top);
                return outRect3;
            case Right:
                RectF outRect4 = new RectF(rect.top, 1.0f - rect.right, rect.bottom, 1.0f - rect.left);
                return outRect4;
            case RightMirrored:
                RectF outRect5 = new RectF(rect.top, rect.left, rect.bottom, rect.right);
                return outRect5;
            case Left:
                RectF outRect6 = new RectF(1.0f - rect.bottom, rect.left, 1.0f - rect.top, rect.right);
                return outRect6;
            case LeftMirrored:
                RectF outRect7 = new RectF(1.0f - rect.bottom, 1.0f - rect.right, 1.0f - rect.top, 1.0f - rect.left);
                return outRect7;
            default:
                RectF outRect8 = new RectF(rect);
                return outRect8;
        }
    }

    public static RectF getRectInParent(BiliSize parentSize, BiliSize subSize, RectF center) {
        RectF rect = new RectF(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, parentSize.getWidth(), parentSize.getHeight());
        if (subSize == null || center == null || parentSize == null) {
            return rect;
        }
        rect.left = (parentSize.getWidth() * center.left) - (subSize.getWidth() * 0.5f);
        rect.top = (parentSize.getHeight() * center.top) - (subSize.getHeight() * 0.5f);
        rect.right = rect.left + (parentSize.getWidth() * center.width());
        rect.bottom = rect.top + (parentSize.getHeight() * center.height());
        return rect;
    }

    public static RectF getRectInParent(RectF parentRect, RectF subPercetRect) {
        if (parentRect == null) {
            return null;
        }
        RectF rect = new RectF(parentRect.left, parentRect.top, parentRect.right, parentRect.bottom);
        if (subPercetRect == null) {
            return rect;
        }
        rect.left += parentRect.width() * subPercetRect.left;
        rect.top += parentRect.height() * subPercetRect.top;
        rect.right = rect.left + (parentRect.width() * subPercetRect.width());
        rect.bottom = rect.top + (parentRect.height() * subPercetRect.height());
        return rect;
    }

    public static Rect makeRectWithAspectRatioInsideRect(BiliSize aspectRatio, Rect boundingRect) {
        if (aspectRatio == null || boundingRect == null) {
            return null;
        }
        BiliSize cacheSize = new BiliSize();
        cacheSize.setWidth(boundingRect.width());
        cacheSize.setHeight((int) Math.floor(cacheSize.getWidth() / aspectRatio.getRatioFloat()));
        if (cacheSize.getHeight() > boundingRect.height()) {
            cacheSize.setHeight(boundingRect.height());
            cacheSize.setWidth((int) Math.floor(cacheSize.getHeight() * aspectRatio.getRatioFloat()));
        }
        Rect rect = new Rect(boundingRect);
        rect.left = boundingRect.left + ((boundingRect.width() - cacheSize.getWidth()) / 2);
        rect.right = rect.left + cacheSize.getWidth();
        rect.top = boundingRect.top + ((boundingRect.height() - cacheSize.getHeight()) / 2);
        rect.bottom = rect.top + cacheSize.getHeight();
        return rect;
    }

    public static double computerPotintDistance(Point aPoint, Point bPoint) {
        if (aPoint == null || bPoint == null) {
            return 0.0d;
        }
        float x = aPoint.x - bPoint.x;
        float y = aPoint.y - bPoint.y;
        return Math.sqrt((x * x) + (y * y));
    }

    public static double computerPotintDistance(PointF aPoint, PointF bPoint) {
        if (aPoint == null || bPoint == null) {
            return 0.0d;
        }
        float x = aPoint.x - bPoint.x;
        float y = aPoint.y - bPoint.y;
        return Math.sqrt((x * x) + (y * y));
    }

    public static float[] textureCoordinates(BiliImageOrientation rotation, RectF rect) {
        if (rect == null || rotation == null) {
            return new float[]{DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f};
        }
        RectF rect2 = rotationWithRotation(rect, rotation);
        float[] t = {rect2.left, rect2.top, rect2.right, t[1], t[0], rect2.bottom, t[2], t[5]};
        return rotateCoordinates(rotation, t);
    }

    public static float[] displayCoordinates(BiliImageOrientation rotation, RectF rect) {
        if (rect == null || rotation == null) {
            return new float[]{DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, 1.0f, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN};
        }
        RectF rect2 = rotationWithRotation(rect, rotation);
        float[] t = {rect2.left, rect2.bottom, rect2.right, t[1], t[0], rect2.top, t[2], t[5]};
        return rotateCoordinates(rotation, t);
    }

    public static float[] textureVertices(BiliImageOrientation rotation, RectF rect) {
        if (rect == null || rotation == null) {
            return new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        }
        RectF rect2 = rotationWithRotation(rect, rotation);
        float[] t = {(rect2.left * 2.0f) - 1.0f, (rect2.top * 2.0f) - 1.0f, (rect2.right * 2.0f) - 1.0f, t[1], t[0], (rect2.bottom * 2.0f) - 1.0f, t[2], t[5]};
        return t;
    }

    public static float[] displayVertices(BiliImageOrientation rotation, RectF rect) {
        if (rect == null || rotation == null) {
            return new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        }
        RectF rect2 = rotationWithRotation(rect, rotation);
        float[] t = {(rect2.left * 2.0f) - 1.0f, 1.0f - (rect2.bottom * 2.0f), (rect2.right * 2.0f) - 1.0f, t[1], t[0], 1.0f - (rect2.top * 2.0f), t[2], t[5]};
        return t;
    }

    private static float[] rotateCoordinates(BiliImageOrientation rotation, float[] t) {
        if (rotation == null || t == null) {
            return t;
        }
        switch (rotation) {
            case UpMirrored:
                return new float[]{t[2], t[3], t[0], t[1], t[6], t[7], t[4], t[5]};
            case Down:
                return new float[]{t[6], t[7], t[4], t[5], t[2], t[3], t[0], t[1]};
            case DownMirrored:
                return new float[]{t[4], t[5], t[6], t[7], t[0], t[1], t[2], t[3]};
            case Right:
                return new float[]{t[4], t[5], t[0], t[1], t[6], t[7], t[2], t[3]};
            case RightMirrored:
                return new float[]{t[0], t[1], t[4], t[5], t[2], t[3], t[6], t[7]};
            case Left:
                return new float[]{t[2], t[3], t[6], t[7], t[0], t[1], t[4], t[5]};
            case LeftMirrored:
                return new float[]{t[6], t[7], t[2], t[3], t[4], t[5], t[0], t[1]};
            default:
                return t;
        }
    }
}