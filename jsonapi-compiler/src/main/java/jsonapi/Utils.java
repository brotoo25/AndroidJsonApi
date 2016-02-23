package jsonapi;

import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by broto on 22/02/16.
 */
public class Utils {

    private Utils() {
        // no instances
    }

    static String getPackageName(Elements elementUtils, TypeElement type) {
        PackageElement pkg = elementUtils.getPackageOf(type);
        return pkg.getQualifiedName().toString();
    }
}
