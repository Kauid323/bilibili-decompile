package c.t.m.g;

import java.util.Arrays;
import java.util.List;

/* compiled from: TML */
public class y4 {
    public static volatile y4 e;
    public float a = 0.0f;
    public float b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f124c = 100.0f;
    public boolean d = false;

    public static y4 a() {
        if (e == null) {
            synchronized (y4.class) {
                if (e == null) {
                    e = new y4();
                }
            }
        }
        return e;
    }

    public boolean a(List<Float> list, int i) {
        float f;
        if (list.size() >= 5) {
            int size = list.size();
            float[] fArr = new float[size];
            int i2 = 0;
            while (true) {
                f = 0.0f;
                if (i2 >= size) {
                    break;
                }
                Float f2 = list.get(i2);
                if (f2 != null) {
                    f = f2.floatValue();
                }
                fArr[i2] = f;
                i2++;
            }
            Arrays.sort(fArr);
            float[] fArr2 = new float[5];
            for (int i3 = 0; i3 < 5; i3++) {
                fArr2[i3] = fArr[(size - 1) - i3];
                f += fArr2[i3];
            }
            float f3 = f / 5.0f;
            float f4 = fArr2[0];
            int i4 = (f3 > 22.0f ? 1 : (f3 == 22.0f ? 0 : -1));
            if (this.b < f3) {
                this.b = f3;
            }
            if (this.f124c > f3) {
                this.f124c = f3;
            }
            this.a = f3;
            if (f3 - f3 > 2.0f) {
                this.d = false;
            }
            if (f3 > (this.b + this.f124c) / 2.0f) {
                this.d = true;
            } else if (i4 < 0) {
                this.d = false;
            }
        }
        return this.d;
    }
}