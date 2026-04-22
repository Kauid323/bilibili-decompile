package j$.util.stream;

import j$.util.ConversionRuntimeException;
import j$.util.stream.Collector;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;

public class StreamApiFlips {
    public static RuntimeException exceptionCharacteristics(Object suffix) {
        throw ConversionRuntimeException.exception("java.util.stream.Collector.Characteristics", suffix);
    }

    public static Set<?> flipCharacteristicSet(Set<?> characteristicSet) {
        if (characteristicSet == null || characteristicSet.isEmpty()) {
            return characteristicSet;
        }
        HashSet<Object> convertedSet = new HashSet<>();
        Object guineaPig = characteristicSet.iterator().next();
        if (guineaPig instanceof Collector.Characteristics) {
            for (Object item : characteristicSet) {
                try {
                    Collector.Characteristics characteristics = (Collector.Characteristics) item;
                    convertedSet.add(Collector.Characteristics.EnumConversion.convert(characteristics));
                } catch (ClassCastException cce) {
                    throw exceptionCharacteristics(cce);
                }
            }
            return convertedSet;
        } else if (guineaPig instanceof Collector.Characteristics) {
            for (Object item2 : characteristicSet) {
                try {
                    Collector.Characteristics characteristics2 = (Collector.Characteristics) item2;
                    convertedSet.add(Collector.Characteristics.EnumConversion.convert(characteristics2));
                } catch (ClassCastException cce2) {
                    throw exceptionCharacteristics(cce2);
                }
            }
            return convertedSet;
        } else {
            throw exceptionCharacteristics(guineaPig.getClass());
        }
    }
}