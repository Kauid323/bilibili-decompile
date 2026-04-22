package android.content.res;

import android.content.Context;
import android.content.pm.PackageParser;
import android.content.res.Resources;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material.MenuKt;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;
import de.robv.android.xposed.callbacks.XCallback;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import xposed.dummy.XResourcesSuperClass;
import xposed.dummy.XTypedArraySuperClass;

public class XResources extends XResourcesSuperClass {
    private static final String EXTRA_XML_INSTANCE_DETAILS = "xmlInstanceDetails";
    private boolean mIsObjectInited;
    private String mPackageName;
    private byte[] mReplacementsCache;
    private String mResDir;
    private static final SparseArray<HashMap<String, Object>> sReplacements = new SparseArray<>();
    private static final SparseArray<HashMap<String, ResourceNames>> sResourceNames = new SparseArray<>();
    private static final byte[] sSystemReplacementsCache = new byte[256];
    private static final HashMap<String, byte[]> sReplacementsCacheMap = new HashMap<>();
    private static final SparseArray<ColorStateList> sColorStateListCache = new SparseArray<>(0);
    private static final SparseArray<HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>>> sLayoutCallbacks = new SparseArray<>();
    private static final WeakHashMap<XmlResourceParser, XMLInstanceDetails> sXmlInstanceDetails = new WeakHashMap<>();
    private static final ThreadLocal<LinkedList<XC_MethodHook.MethodHookParam>> sIncludedLayouts = new ThreadLocal<LinkedList<XC_MethodHook.MethodHookParam>>() { // from class: android.content.res.XResources.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public LinkedList<XC_MethodHook.MethodHookParam> initialValue() {
            return new LinkedList<>();
        }
    };
    private static final HashMap<String, Long> sResDirLastModified = new HashMap<>();
    private static final HashMap<String, String> sResDirPackageNames = new HashMap<>();
    private static ThreadLocal<Object> sLatestResKey = null;

    private static native void rewriteXmlReferencesNative(long j, XResources xResources, Resources resources);

    private XResources() {
        throw new UnsupportedOperationException();
    }

    public void initObject(String resDir) {
        if (this.mIsObjectInited) {
            throw new IllegalStateException("Object has already been initialized");
        }
        this.mResDir = resDir;
        this.mPackageName = getPackageName(resDir);
        if (resDir != null) {
            synchronized (sReplacementsCacheMap) {
                this.mReplacementsCache = sReplacementsCacheMap.get(resDir);
                if (this.mReplacementsCache == null) {
                    this.mReplacementsCache = new byte[128];
                    sReplacementsCacheMap.put(resDir, this.mReplacementsCache);
                }
            }
        }
        this.mIsObjectInited = true;
    }

    public boolean isFirstLoad() {
        synchronized (sReplacements) {
            if (this.mResDir == null) {
                return false;
            }
            Long lastModification = Long.valueOf(new File(this.mResDir).lastModified());
            Long oldModified = sResDirLastModified.get(this.mResDir);
            if (lastModification.equals(oldModified)) {
                return false;
            }
            sResDirLastModified.put(this.mResDir, lastModification);
            if (oldModified == null) {
                return true;
            }
            for (int i = 0; i < sReplacements.size(); i++) {
                sReplacements.valueAt(i).remove(this.mResDir);
            }
            Arrays.fill(this.mReplacementsCache, (byte) 0);
            return true;
        }
    }

    public static void setPackageNameForResDir(String packageName, String resDir) {
        synchronized (sResDirPackageNames) {
            sResDirPackageNames.put(resDir, packageName);
        }
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    private static String getPackageName(String resDir) {
        if (resDir == null) {
            return "android";
        }
        synchronized (sResDirPackageNames) {
            try {
                try {
                    String packageName = sResDirPackageNames.get(resDir);
                    if (packageName != null) {
                        return packageName;
                    }
                    try {
                        PackageParser.PackageLite pkgInfo = PackageParser.parsePackageLite(new File(resDir), 0);
                        if (pkgInfo != null && pkgInfo.packageName != null) {
                            Log.w("Xposed", "Package name for " + resDir + " had to be retrieved via parser");
                            String packageName2 = pkgInfo.packageName;
                            setPackageNameForResDir(packageName2, resDir);
                            return packageName2;
                        }
                        throw new IllegalStateException("Could not determine package name for " + resDir);
                    } catch (PackageParser.PackageParserException e) {
                        throw new IllegalStateException("Could not determine package name for " + resDir, e);
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public static String getPackageNameDuringConstruction() {
        Object key;
        if (sLatestResKey == null || (key = sLatestResKey.get()) == null) {
            throw new IllegalStateException("This method can only be called during getTopLevelResources()");
        }
        String resDir = (String) XposedHelpers.getObjectField(key, "mResDir");
        return getPackageName(resDir);
    }

    public static void init(ThreadLocal<Object> latestResKey) throws Exception {
        sLatestResKey = latestResKey;
        XposedHelpers.findAndHookMethod(LayoutInflater.class, "inflate", new Object[]{XmlPullParser.class, ViewGroup.class, Boolean.TYPE, new XC_MethodHook() { // from class: android.content.res.XResources.2
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                if (!param.hasThrowable()) {
                    synchronized (XResources.sXmlInstanceDetails) {
                        try {
                            try {
                                XMLInstanceDetails details = (XMLInstanceDetails) XResources.sXmlInstanceDetails.get(param.args[0]);
                                if (details != null) {
                                    XC_LayoutInflated.LayoutInflatedParam liparam = new XC_LayoutInflated.LayoutInflatedParam(details.callbacks);
                                    liparam.view = (View) param.getResult();
                                    liparam.resNames = details.resNames;
                                    liparam.variant = details.variant;
                                    liparam.res = details.res;
                                    XCallback.callAll(liparam);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                }
            }
        }});
        XC_MethodHook parseIncludeHook = new XC_MethodHook() { // from class: android.content.res.XResources.3
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                ((LinkedList) XResources.sIncludedLayouts.get()).push(param);
            }

            protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                XMLInstanceDetails details;
                ((LinkedList) XResources.sIncludedLayouts.get()).pop();
                if (!param.hasThrowable() && (details = (XMLInstanceDetails) param.getObjectExtra(XResources.EXTRA_XML_INSTANCE_DETAILS)) != null) {
                    XC_LayoutInflated.LayoutInflatedParam liparam = new XC_LayoutInflated.LayoutInflatedParam(details.callbacks);
                    ViewGroup group = (ViewGroup) param.args[2];
                    liparam.view = group.getChildAt(group.getChildCount() - 1);
                    liparam.resNames = details.resNames;
                    liparam.variant = details.variant;
                    liparam.res = details.res;
                    XCallback.callAll(liparam);
                }
            }
        };
        XposedHelpers.findAndHookMethod(LayoutInflater.class, "parseInclude", new Object[]{XmlPullParser.class, Context.class, View.class, AttributeSet.class, parseIncludeHook});
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class ResourceNames {
        public final String fullName;
        public final int id;
        public final String name;
        public final String pkg;
        public final String type;

        private ResourceNames(int id, String pkg, String name, String type) {
            this.id = id;
            this.pkg = pkg;
            this.name = name;
            this.type = type;
            this.fullName = pkg + ":" + type + "/" + name;
        }

        public boolean equals(String pkg, String name, String type, int id) {
            return (pkg == null || pkg.equals(this.pkg)) && (name == null || name.equals(this.name)) && ((type == null || type.equals(this.type)) && (id == 0 || id == this.id));
        }
    }

    private ResourceNames getResourceNames(int id) {
        return new ResourceNames(id, getResourcePackageName(id), getResourceTypeName(id), getResourceEntryName(id));
    }

    private static ResourceNames getSystemResourceNames(int id) {
        Resources sysRes = getSystem();
        return new ResourceNames(id, sysRes.getResourcePackageName(id), sysRes.getResourceTypeName(id), sysRes.getResourceEntryName(id));
    }

    private static void putResourceNames(String resDir, ResourceNames resNames) {
        int id = resNames.id;
        synchronized (sResourceNames) {
            HashMap<String, ResourceNames> inner = sResourceNames.get(id);
            if (inner == null) {
                inner = new HashMap<>();
                sResourceNames.put(id, inner);
            }
            synchronized (inner) {
                inner.put(resDir, resNames);
            }
        }
    }

    public void setReplacement(int id, Object replacement) {
        setReplacement(id, replacement, this);
    }

    @Deprecated
    public void setReplacement(String fullName, Object replacement) {
        int id = getIdentifier(fullName, null, null);
        if (id == 0) {
            throw new Resources.NotFoundException(fullName);
        }
        setReplacement(id, replacement, this);
    }

    public void setReplacement(String pkg, String type, String name, Object replacement) {
        int id = getIdentifier(name, type, pkg);
        if (id == 0) {
            throw new Resources.NotFoundException(pkg + ":" + type + "/" + name);
        }
        setReplacement(id, replacement, this);
    }

    public static void setSystemWideReplacement(int id, Object replacement) {
        setReplacement(id, replacement, null);
    }

    @Deprecated
    public static void setSystemWideReplacement(String fullName, Object replacement) {
        int id = getSystem().getIdentifier(fullName, null, null);
        if (id == 0) {
            throw new Resources.NotFoundException(fullName);
        }
        setReplacement(id, replacement, null);
    }

    public static void setSystemWideReplacement(String pkg, String type, String name, Object replacement) {
        int id = getSystem().getIdentifier(name, type, pkg);
        if (id == 0) {
            throw new Resources.NotFoundException(pkg + ":" + type + "/" + name);
        }
        setReplacement(id, replacement, null);
    }

    private static void setReplacement(int id, Object replacement, XResources res) {
        String resDir = res != null ? res.mResDir : null;
        if (id == 0) {
            throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
        }
        if (resDir == null && id >= 2130706432) {
            throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
        }
        if (!(replacement instanceof Drawable)) {
            if (id < 2130706432) {
                int cacheKey = ((id & 458752) >> 11) | ((id & 248) >> 3);
                synchronized (sSystemReplacementsCache) {
                    byte[] bArr = sSystemReplacementsCache;
                    bArr[cacheKey] = (byte) ((1 << (id & 7)) | bArr[cacheKey]);
                }
            } else {
                int cacheKey2 = ((id & 458752) >> 12) | ((id & MenuKt.InTransitionDuration) >> 3);
                synchronized (res.mReplacementsCache) {
                    byte[] bArr2 = res.mReplacementsCache;
                    bArr2[cacheKey2] = (byte) ((1 << (id & 7)) | bArr2[cacheKey2]);
                }
            }
            synchronized (sReplacements) {
                HashMap<String, Object> inner = sReplacements.get(id);
                if (inner == null) {
                    inner = new HashMap<>();
                    sReplacements.put(id, inner);
                }
                inner.put(resDir, replacement);
            }
            return;
        }
        throw new IllegalArgumentException("Drawable replacements are deprecated since Xposed 2.1. Use DrawableLoader instead.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getReplacement(int i) {
        HashMap<String, Object> hashMap;
        if (i <= 0) {
            return null;
        }
        if (i < 2130706432) {
            if ((sSystemReplacementsCache[((i & 458752) >> 11) | ((i & 248) >> 3)] & (1 << (i & 7))) == 0) {
                return null;
            }
        } else if (this.mResDir != null) {
            if ((this.mReplacementsCache[((i & 458752) >> 12) | ((i & MenuKt.InTransitionDuration) >> 3)] & (1 << (i & 7))) == 0) {
                return null;
            }
        }
        synchronized (sReplacements) {
            hashMap = sReplacements.get(i);
        }
        if (hashMap == null) {
            return null;
        }
        synchronized (hashMap) {
            Object obj = hashMap.get(this.mResDir);
            if (obj == null && this.mResDir != null) {
                return hashMap.get(null);
            }
            return obj;
        }
    }

    public XmlResourceParser getAnimation(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            boolean loadedFromCache = isXmlCached(repRes, repId);
            XmlResourceParser result = repRes.getAnimation(repId);
            if (!loadedFromCache) {
                long parseState = XposedHelpers.getLongField(result, "mParseState");
                rewriteXmlReferencesNative(parseState, this, repRes);
            }
            return result;
        }
        return super.getAnimation(id);
    }

    public boolean getBoolean(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof Boolean) {
            return ((Boolean) replacement).booleanValue();
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getBoolean(repId);
        }
        return super.getBoolean(id);
    }

    public int getColor(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof Integer) {
            return ((Integer) replacement).intValue();
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getColor(repId);
        }
        return super.getColor(id);
    }

    public ColorStateList getColorStateList(int id) throws Resources.NotFoundException {
        ColorStateList result;
        Object replacement = getReplacement(id);
        if (replacement instanceof ColorStateList) {
            return (ColorStateList) replacement;
        }
        if (replacement instanceof Integer) {
            int color = ((Integer) replacement).intValue();
            synchronized (sColorStateListCache) {
                result = sColorStateListCache.get(color);
                if (result == null) {
                    result = ColorStateList.valueOf(color);
                    sColorStateListCache.put(color, result);
                }
            }
            return result;
        } else if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getColorStateList(repId);
        } else {
            return super.getColorStateList(id);
        }
    }

    public float getDimension(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof DimensionReplacement) {
            return ((DimensionReplacement) replacement).getDimension(getDisplayMetrics());
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getDimension(repId);
        }
        return super.getDimension(id);
    }

    public int getDimensionPixelOffset(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof DimensionReplacement) {
            return ((DimensionReplacement) replacement).getDimensionPixelOffset(getDisplayMetrics());
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getDimensionPixelOffset(repId);
        }
        return super.getDimensionPixelOffset(id);
    }

    public int getDimensionPixelSize(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof DimensionReplacement) {
            return ((DimensionReplacement) replacement).getDimensionPixelSize(getDisplayMetrics());
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getDimensionPixelSize(repId);
        }
        return super.getDimensionPixelSize(id);
    }

    public Drawable getDrawable(int id) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(id);
                if (replacement instanceof DrawableLoader) {
                    Drawable result = ((DrawableLoader) replacement).newDrawable(this, id);
                    if (result != null) {
                        return result;
                    }
                } else if (replacement instanceof Integer) {
                    return new ColorDrawable(((Integer) replacement).intValue());
                } else {
                    if (replacement instanceof XResForwarder) {
                        Resources repRes = ((XResForwarder) replacement).getResources();
                        int repId = ((XResForwarder) replacement).getId();
                        return repRes.getDrawable(repId);
                    }
                }
            }
            return super.getDrawable(id);
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawable");
        }
    }

    public Drawable getDrawable(int id, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(id);
                if (replacement instanceof DrawableLoader) {
                    Drawable result = ((DrawableLoader) replacement).newDrawable(this, id);
                    if (result != null) {
                        return result;
                    }
                } else if (replacement instanceof Integer) {
                    return new ColorDrawable(((Integer) replacement).intValue());
                } else {
                    if (replacement instanceof XResForwarder) {
                        Resources repRes = ((XResForwarder) replacement).getResources();
                        int repId = ((XResForwarder) replacement).getId();
                        return repRes.getDrawable(repId);
                    }
                }
            }
            return super.getDrawable(id, theme);
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawable");
        }
    }

    public Drawable getDrawable(int id, Resources.Theme theme, boolean supportComposedIcons) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawable") == 1) {
                Object replacement = getReplacement(id);
                if (replacement instanceof DrawableLoader) {
                    Drawable result = ((DrawableLoader) replacement).newDrawable(this, id);
                    if (result != null) {
                        return result;
                    }
                } else if (replacement instanceof Integer) {
                    return new ColorDrawable(((Integer) replacement).intValue());
                } else {
                    if (replacement instanceof XResForwarder) {
                        Resources repRes = ((XResForwarder) replacement).getResources();
                        int repId = ((XResForwarder) replacement).getId();
                        return repRes.getDrawable(repId);
                    }
                }
            }
            return super.getDrawable(id, theme, supportComposedIcons);
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawable");
        }
    }

    public Drawable getDrawableForDensity(int id, int density) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(id);
                if (replacement instanceof DrawableLoader) {
                    Drawable result = ((DrawableLoader) replacement).newDrawableForDensity(this, id, density);
                    if (result != null) {
                        return result;
                    }
                } else if (replacement instanceof Integer) {
                    return new ColorDrawable(((Integer) replacement).intValue());
                } else {
                    if (replacement instanceof XResForwarder) {
                        Resources repRes = ((XResForwarder) replacement).getResources();
                        int repId = ((XResForwarder) replacement).getId();
                        return repRes.getDrawableForDensity(repId, density);
                    }
                }
            }
            return super.getDrawableForDensity(id, density);
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
        }
    }

    public Drawable getDrawableForDensity(int id, int density, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(id);
                if (replacement instanceof DrawableLoader) {
                    Drawable result = ((DrawableLoader) replacement).newDrawableForDensity(this, id, density);
                    if (result != null) {
                        return result;
                    }
                } else if (replacement instanceof Integer) {
                    return new ColorDrawable(((Integer) replacement).intValue());
                } else {
                    if (replacement instanceof XResForwarder) {
                        Resources repRes = ((XResForwarder) replacement).getResources();
                        int repId = ((XResForwarder) replacement).getId();
                        return repRes.getDrawableForDensity(repId, density);
                    }
                }
            }
            return super.getDrawableForDensity(id, density, theme);
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
        }
    }

    public Drawable getDrawableForDensity(int id, int density, Resources.Theme theme, boolean supportComposedIcons) throws Resources.NotFoundException {
        try {
            if (XposedHelpers.incrementMethodDepth("getDrawableForDensity") == 1) {
                Object replacement = getReplacement(id);
                if (replacement instanceof DrawableLoader) {
                    Drawable result = ((DrawableLoader) replacement).newDrawableForDensity(this, id, density);
                    if (result != null) {
                        return result;
                    }
                } else if (replacement instanceof Integer) {
                    return new ColorDrawable(((Integer) replacement).intValue());
                } else {
                    if (replacement instanceof XResForwarder) {
                        Resources repRes = ((XResForwarder) replacement).getResources();
                        int repId = ((XResForwarder) replacement).getId();
                        return repRes.getDrawableForDensity(repId, density);
                    }
                }
            }
            return super.getDrawableForDensity(id, density, theme, supportComposedIcons);
        } finally {
            XposedHelpers.decrementMethodDepth("getDrawableForDensity");
        }
    }

    public float getFraction(int id, int base, int pbase) {
        Object replacement = getReplacement(id);
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getFraction(repId, base, pbase);
        }
        return super.getFraction(id, base, pbase);
    }

    public int getInteger(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof Integer) {
            return ((Integer) replacement).intValue();
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getInteger(repId);
        }
        return super.getInteger(id);
    }

    public int[] getIntArray(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof int[]) {
            return (int[]) replacement;
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getIntArray(repId);
        }
        return super.getIntArray(id);
    }

    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        XmlResourceParser layout;
        HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> hashMap;
        XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet;
        String str;
        Object replacement = getReplacement(i);
        if (replacement instanceof XResForwarder) {
            XResForwarder xResForwarder = (XResForwarder) replacement;
            Resources resources = xResForwarder.getResources();
            int id = xResForwarder.getId();
            boolean isXmlCached = isXmlCached(resources, id);
            layout = resources.getLayout(id);
            if (!isXmlCached) {
                rewriteXmlReferencesNative(XposedHelpers.getLongField(layout, "mParseState"), this, resources);
            }
        } else {
            layout = super.getLayout(i);
        }
        synchronized (sLayoutCallbacks) {
            hashMap = sLayoutCallbacks.get(i);
        }
        if (hashMap != null) {
            synchronized (hashMap) {
                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> copyOnWriteSortedSet2 = hashMap.get(this.mResDir);
                if (copyOnWriteSortedSet2 == null && this.mResDir != null) {
                    copyOnWriteSortedSet = hashMap.get(null);
                } else {
                    copyOnWriteSortedSet = copyOnWriteSortedSet2;
                }
            }
            if (copyOnWriteSortedSet != null) {
                String str2 = "layout";
                TypedValue typedValue = (TypedValue) XposedHelpers.getObjectField(this, "mTmpValue");
                getValue(i, typedValue, true);
                if (typedValue.type == 3) {
                    String[] split = typedValue.string.toString().split("/", 3);
                    if (split.length == 3) {
                        str2 = split[1];
                    } else {
                        XposedBridge.log("Unexpected resource path \"" + typedValue.string.toString() + "\" for resource id 0x" + Integer.toHexString(i));
                    }
                    str = str2;
                } else {
                    XposedBridge.log(new Resources.NotFoundException("Could not find file name for resource id 0x") + Integer.toHexString(i));
                    str = "layout";
                }
                synchronized (sXmlInstanceDetails) {
                    synchronized (sResourceNames) {
                        HashMap<String, ResourceNames> hashMap2 = sResourceNames.get(i);
                        if (hashMap2 != null) {
                            synchronized (hashMap2) {
                                XMLInstanceDetails xMLInstanceDetails = new XMLInstanceDetails(hashMap2.get(this.mResDir), str, copyOnWriteSortedSet);
                                sXmlInstanceDetails.put(layout, xMLInstanceDetails);
                                XC_MethodHook.MethodHookParam peek = sIncludedLayouts.get().peek();
                                if (peek != null) {
                                    peek.setObjectExtra(EXTRA_XML_INSTANCE_DETAILS, xMLInstanceDetails);
                                }
                            }
                        }
                    }
                }
            }
        }
        return layout;
    }

    public Movie getMovie(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getMovie(repId);
        }
        return super.getMovie(id);
    }

    public CharSequence getQuantityText(int id, int quantity) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getQuantityText(repId, quantity);
        }
        return super.getQuantityText(id, quantity);
    }

    public String[] getStringArray(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof String[]) {
            return (String[]) replacement;
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getStringArray(repId);
        }
        return super.getStringArray(id);
    }

    public CharSequence getText(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof CharSequence) {
            return (CharSequence) replacement;
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getText(repId);
        }
        return super.getText(id);
    }

    public CharSequence getText(int id, CharSequence def) {
        Object replacement = getReplacement(id);
        if (replacement instanceof CharSequence) {
            return (CharSequence) replacement;
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getText(repId, def);
        }
        return super.getText(id, def);
    }

    public CharSequence[] getTextArray(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof CharSequence[]) {
            return (CharSequence[]) replacement;
        }
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            return repRes.getTextArray(repId);
        }
        return super.getTextArray(id);
    }

    public XmlResourceParser getXml(int id) throws Resources.NotFoundException {
        Object replacement = getReplacement(id);
        if (replacement instanceof XResForwarder) {
            Resources repRes = ((XResForwarder) replacement).getResources();
            int repId = ((XResForwarder) replacement).getId();
            boolean loadedFromCache = isXmlCached(repRes, repId);
            XmlResourceParser result = repRes.getXml(repId);
            if (!loadedFromCache) {
                long parseState = XposedHelpers.getLongField(result, "mParseState");
                rewriteXmlReferencesNative(parseState, this, repRes);
            }
            return result;
        }
        return super.getXml(id);
    }

    private static boolean isXmlCached(Resources res, int id) {
        int[] mCachedXmlBlockIds = (int[]) XposedHelpers.getObjectField(res, "mCachedXmlBlockIds");
        synchronized (mCachedXmlBlockIds) {
            for (int cachedId : mCachedXmlBlockIds) {
                if (cachedId == id) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f A[Catch: Exception -> 0x0075, TryCatch #1 {Exception -> 0x0075, blocks: (B:2:0x0000, B:4:0x000b, B:10:0x0015, B:12:0x0023, B:22:0x0036, B:24:0x003c, B:27:0x005f, B:29:0x0066, B:31:0x006c), top: B:38:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int translateResId(int id, XResources origRes, Resources repRes) {
        TypedValue tmpValue;
        boolean z;
        try {
            String entryName = repRes.getResourceEntryName(id);
            String entryType = repRes.getResourceTypeName(id);
            String origPackage = origRes.mPackageName;
            int origResId = 0;
            try {
                origResId = origRes.getIdentifier(entryName, entryType, origPackage);
            } catch (Resources.NotFoundException e) {
            }
            boolean repResDefined = false;
            try {
                tmpValue = new TypedValue();
                repRes.getValue(id, tmpValue, false);
            } catch (Resources.NotFoundException e2) {
            }
            if (tmpValue.type == 18) {
                if (tmpValue.data == 0) {
                    z = false;
                    repResDefined = z;
                    if (repResDefined && origResId == 0 && !entryType.equals("id")) {
                        XposedBridge.log(entryType + "/" + entryName + " is neither defined in module nor in original resources");
                        return 0;
                    }
                    if (origResId == 0) {
                        origResId = getFakeResId(repRes, id);
                    }
                    if (repResDefined && !entryType.equals("id")) {
                        origRes.setReplacement(origResId, new XResForwarder(repRes, id));
                    }
                    return origResId;
                }
            }
            z = true;
            repResDefined = z;
            if (repResDefined) {
            }
            if (origResId == 0) {
            }
            if (repResDefined) {
                origRes.setReplacement(origResId, new XResForwarder(repRes, id));
            }
            return origResId;
        } catch (Exception e3) {
            XposedBridge.log(e3);
            return id;
        }
    }

    public static int getFakeResId(String resName) {
        return (resName.hashCode() & 16777215) | 2113929216;
    }

    public static int getFakeResId(Resources res, int id) {
        return getFakeResId(res.getResourceName(id));
    }

    public int addResource(Resources res, int id) {
        int fakeId = getFakeResId(res, id);
        synchronized (sReplacements) {
            if (sReplacements.indexOfKey(fakeId) < 0) {
                setReplacement(fakeId, new XResForwarder(res, id));
            }
        }
        return fakeId;
    }

    private static int translateAttrId(String attrName, XResources origRes) {
        String origPackage = origRes.mPackageName;
        try {
            int origAttrId = origRes.getIdentifier(attrName, "attr", origPackage);
            return origAttrId;
        } catch (Resources.NotFoundException e) {
            XposedBridge.log("Attribute " + attrName + " not found in original resources");
            return 0;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class XTypedArray extends XTypedArraySuperClass {
        private XTypedArray() {
            super((Resources) null, (int[]) null, (int[]) null, 0);
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(int index, boolean defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof Boolean) {
                return ((Boolean) replacement).booleanValue();
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getBoolean(repId);
            }
            return super.getBoolean(index, defValue);
        }

        public int getColor(int index, int defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof Integer) {
                return ((Integer) replacement).intValue();
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getColor(repId);
            }
            return super.getColor(index, defValue);
        }

        public ColorStateList getColorStateList(int index) {
            ColorStateList result;
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof ColorStateList) {
                return (ColorStateList) replacement;
            }
            if (replacement instanceof Integer) {
                int color = ((Integer) replacement).intValue();
                synchronized (XResources.sColorStateListCache) {
                    result = (ColorStateList) XResources.sColorStateListCache.get(color);
                    if (result == null) {
                        result = ColorStateList.valueOf(color);
                        XResources.sColorStateListCache.put(color, result);
                    }
                }
                return result;
            } else if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getColorStateList(repId);
            } else {
                return super.getColorStateList(index);
            }
        }

        public float getDimension(int index, float defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getDimension(repId);
            }
            return super.getDimension(index, defValue);
        }

        public int getDimensionPixelOffset(int index, int defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getDimensionPixelOffset(repId);
            }
            return super.getDimensionPixelOffset(index, defValue);
        }

        public int getDimensionPixelSize(int index, int defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getDimensionPixelSize(repId);
            }
            return super.getDimensionPixelSize(index, defValue);
        }

        public Drawable getDrawable(int index) {
            int resId = getResourceId(index, 0);
            XResources xres = (XResources) getResources();
            Object replacement = xres.getReplacement(resId);
            if (replacement instanceof DrawableLoader) {
                try {
                    Drawable result = ((DrawableLoader) replacement).newDrawable(xres, resId);
                    if (result != null) {
                        return result;
                    }
                } catch (Throwable t) {
                    XposedBridge.log(t);
                }
            } else if (replacement instanceof Integer) {
                return new ColorDrawable(((Integer) replacement).intValue());
            } else {
                if (replacement instanceof XResForwarder) {
                    Resources repRes = ((XResForwarder) replacement).getResources();
                    int repId = ((XResForwarder) replacement).getId();
                    return repRes.getDrawable(repId);
                }
            }
            return super.getDrawable(index);
        }

        public float getFloat(int index, float defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getDimension(repId);
            }
            return super.getFloat(index, defValue);
        }

        public float getFraction(int index, int base, int pbase, float defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getFraction(repId, base, pbase);
            }
            return super.getFraction(index, base, pbase, defValue);
        }

        public int getInt(int index, int defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof Integer) {
                return ((Integer) replacement).intValue();
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getInteger(repId);
            }
            return super.getInt(index, defValue);
        }

        public int getInteger(int index, int defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof Integer) {
                return ((Integer) replacement).intValue();
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getInteger(repId);
            }
            return super.getInteger(index, defValue);
        }

        public int getLayoutDimension(int index, int defValue) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getDimensionPixelSize(repId);
            }
            return super.getLayoutDimension(index, defValue);
        }

        public int getLayoutDimension(int index, String name) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getDimensionPixelSize(repId);
            }
            return super.getLayoutDimension(index, name);
        }

        public String getString(int index) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof CharSequence) {
                return replacement.toString();
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getString(repId);
            }
            return super.getString(index);
        }

        public CharSequence getText(int index) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof CharSequence) {
                return (CharSequence) replacement;
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getText(repId);
            }
            return super.getText(index);
        }

        public CharSequence[] getTextArray(int index) {
            Object replacement = ((XResources) getResources()).getReplacement(getResourceId(index, 0));
            if (replacement instanceof CharSequence[]) {
                return (CharSequence[]) replacement;
            }
            if (replacement instanceof XResForwarder) {
                Resources repRes = ((XResForwarder) replacement).getResources();
                int repId = ((XResForwarder) replacement).getId();
                return repRes.getTextArray(repId);
            }
            return super.getTextArray(index);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static abstract class DrawableLoader {
        public abstract Drawable newDrawable(XResources xResources, int i) throws Throwable;

        public Drawable newDrawableForDensity(XResources res, int id, int density) throws Throwable {
            return newDrawable(res, id);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class DimensionReplacement {
        private final int mUnit;
        private final float mValue;

        public DimensionReplacement(float value, int unit) {
            this.mValue = value;
            this.mUnit = unit;
        }

        public float getDimension(DisplayMetrics metrics) {
            return TypedValue.applyDimension(this.mUnit, this.mValue, metrics);
        }

        public int getDimensionPixelOffset(DisplayMetrics metrics) {
            return (int) TypedValue.applyDimension(this.mUnit, this.mValue, metrics);
        }

        public int getDimensionPixelSize(DisplayMetrics metrics) {
            float f = TypedValue.applyDimension(this.mUnit, this.mValue, metrics);
            int res = (int) (0.5f + f);
            if (res != 0) {
                return res;
            }
            if (this.mValue == androidx.compose.material3.MenuKt.ClosedAlphaTarget) {
                return 0;
            }
            return this.mValue > androidx.compose.material3.MenuKt.ClosedAlphaTarget ? 1 : -1;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    private class XMLInstanceDetails {
        public final XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks;
        public final XResources res;
        public final ResourceNames resNames;
        public final String variant;

        private XMLInstanceDetails(ResourceNames resNames, String variant, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks) {
            this.res = XResources.this;
            this.resNames = resNames;
            this.variant = variant;
            this.callbacks = callbacks;
        }
    }

    public XC_LayoutInflated.Unhook hookLayout(int id, XC_LayoutInflated callback) {
        return hookLayoutInternal(this.mResDir, id, getResourceNames(id), callback);
    }

    @Deprecated
    public XC_LayoutInflated.Unhook hookLayout(String fullName, XC_LayoutInflated callback) {
        int id = getIdentifier(fullName, null, null);
        if (id == 0) {
            throw new Resources.NotFoundException(fullName);
        }
        return hookLayout(id, callback);
    }

    public XC_LayoutInflated.Unhook hookLayout(String pkg, String type, String name, XC_LayoutInflated callback) {
        int id = getIdentifier(name, type, pkg);
        if (id == 0) {
            throw new Resources.NotFoundException(pkg + ":" + type + "/" + name);
        }
        return hookLayout(id, callback);
    }

    public static XC_LayoutInflated.Unhook hookSystemWideLayout(int id, XC_LayoutInflated callback) {
        if (id >= 2130706432) {
            throw new IllegalArgumentException("ids >= 0x7f000000 are app specific and cannot be set for the framework");
        }
        return hookLayoutInternal(null, id, getSystemResourceNames(id), callback);
    }

    @Deprecated
    public static XC_LayoutInflated.Unhook hookSystemWideLayout(String fullName, XC_LayoutInflated callback) {
        int id = getSystem().getIdentifier(fullName, null, null);
        if (id == 0) {
            throw new Resources.NotFoundException(fullName);
        }
        return hookSystemWideLayout(id, callback);
    }

    public static XC_LayoutInflated.Unhook hookSystemWideLayout(String pkg, String type, String name, XC_LayoutInflated callback) {
        int id = getSystem().getIdentifier(name, type, pkg);
        if (id == 0) {
            throw new Resources.NotFoundException(pkg + ":" + type + "/" + name);
        }
        return hookSystemWideLayout(id, callback);
    }

    private static XC_LayoutInflated.Unhook hookLayoutInternal(String resDir, int id, ResourceNames resNames, XC_LayoutInflated callback) {
        if (id == 0) {
            throw new IllegalArgumentException("id 0 is not an allowed resource identifier");
        }
        synchronized (sLayoutCallbacks) {
            try {
                try {
                    HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> inner = sLayoutCallbacks.get(id);
                    if (inner == null) {
                        inner = new HashMap<>();
                        sLayoutCallbacks.put(id, inner);
                    }
                    synchronized (inner) {
                        try {
                            try {
                                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks = inner.get(resDir);
                                if (callbacks == null) {
                                    callbacks = new XposedBridge.CopyOnWriteSortedSet<>();
                                    inner.put(resDir, callbacks);
                                }
                                callbacks.add(callback);
                                putResourceNames(resDir, resNames);
                                callback.getClass();
                                return new XC_LayoutInflated.Unhook(callback, resDir, id);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static void unhookLayout(String resDir, int id, XC_LayoutInflated callback) {
        synchronized (sLayoutCallbacks) {
            try {
                try {
                    HashMap<String, XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated>> inner = sLayoutCallbacks.get(id);
                    if (inner == null) {
                        return;
                    }
                    synchronized (inner) {
                        try {
                            try {
                                XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> callbacks = inner.get(resDir);
                                if (callbacks == null) {
                                    return;
                                }
                                callbacks.remove(callback);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}