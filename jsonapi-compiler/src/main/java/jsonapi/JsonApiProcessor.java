package jsonapi;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
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
import javax.lang.model.element.VariableElement;

import static com.squareup.javapoet.JavaFile.builder;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static com.squareup.javapoet.TypeName.get;
import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.SourceVersion.latestSupported;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.tools.Diagnostic.Kind.ERROR;
import static jsonapi.Utils.getPackageName;

/**
 * Created by broto on 22/02/16.
 */

@AutoService(Processor.class)
public class JsonApiProcessor extends AbstractProcessor {

    private static final String PREFIX = "JsonApi$";
    private Messager messager;
    private ProcessingEnvironment processingEnv;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.processingEnv = processingEnv;
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


            String packageName = getPackageName(processingEnv.getElementUtils(), annotatedClass);

            try {
                TypeSpec generatedClass = generateClass(annotatedClass);
                JavaFile javaFile = builder(packageName, generatedClass).build();

                javaFile.writeTo(processingEnv.getFiler());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public TypeSpec generateClass(TypeElement typeElement) {
        TypeSpec.Builder builder = classBuilder(PREFIX + typeElement.getSimpleName().toString())
                .addModifiers(PUBLIC);

        for (Element element : typeElement.getEnclosedElements()) {
            if (!(element instanceof VariableElement)) {
                continue;
            }
            VariableElement variableElement = (VariableElement) element;

            builder.addField(get(variableElement.asType()), variableElement.getSimpleName().toString());
            builder.addMethod(makeGetMethod(variableElement));
            builder.addMethod(makeSetMethod(variableElement));
        }

        builder.addField(String.class, "id");
        builder.addMethod(makeSetMethod("id"));
        builder.addMethod(makeGetMethod("id", String.class));

        builder.addField(String.class, "type");
        builder.addMethod(makeSetMethod("type"));
        builder.addMethod(makeGetMethod("type", String.class));

        return builder.build();
    }

    private MethodSpec makeSetMethod(String field) {
        return methodBuilder("set" + toCamelCase(field))
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addStatement("this." + field + " = " + field)
                .returns(void.class)
                .build();
    }

    private MethodSpec makeSetMethod(VariableElement variableElement) {
        return methodBuilder("set" + toCamelCase(variableElement.getSimpleName().toString()))
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addStatement("this." + variableElement.getSimpleName().toString() + " = " + variableElement.getSimpleName().toString())
                .returns(void.class)
                .build();
    }

    private MethodSpec makeGetMethod(String field, Class type) {
        return methodBuilder("get" + toCamelCase(field))
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addStatement("return " + field)
                .returns(type)
                .build();
    }

    private MethodSpec makeGetMethod(VariableElement variableElement) {
        return methodBuilder("get" + toCamelCase(variableElement.getSimpleName().toString()))
                .addJavadoc("@return string suitable for {@param instance}'s toString()")
                .addModifiers(PUBLIC)
                .addStatement("return " + variableElement.getSimpleName().toString())
                .returns(get(variableElement.asType()))
                .build();
    }

    private String toCamelCase(String s) {
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
