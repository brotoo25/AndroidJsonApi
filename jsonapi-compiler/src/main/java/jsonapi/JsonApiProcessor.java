package jsonapi;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.MethodSpec;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static javax.lang.model.SourceVersion.latestSupported;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.tools.Diagnostic.Kind.ERROR;

/**
 * Created by broto on 22/02/16.
 */

@AutoService(Processor.class)
public class JsonApiProcessor extends AbstractProcessor{

    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(JsonApiResource.class.getCanonicalName());
        types.add(JsonApiRelationship.class.getCanonicalName());

        return types;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(JsonApiResource.class)) {
            // Our annotation is defined with @Target(value=TYPE). Therefore, we can assume that
            // this annotatedElement is a TypeElement.
            TypeElement annotatedClass = (TypeElement) annotatedElement;
        }

        return true;
    }

    private static MethodSpec makeSetMethod(String field) {
        return methodBuilder("set" + toCamelCase(field))
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addStatement("this." + field + "= " + field)
                .returns(void.class)
                .build();
    }

    private static MethodSpec makeGetMethod(String field) {
        return methodBuilder("get" + toCamelCase(field))
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addStatement("return " + field)
                .returns(String.class)
                .build();
    }

    private static String toCamelCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

    private void error(Element element, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        processingEnv.getMessager().printMessage(ERROR, message, element);
    }
}
