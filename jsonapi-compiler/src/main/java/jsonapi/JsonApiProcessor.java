package jsonapi;

import com.google.auto.service.AutoService;

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

import static javax.lang.model.SourceVersion.latestSupported;
import static javax.tools.Diagnostic.Kind.ERROR;

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
            boolean hasIdField = false, hasTypeField = false;

            TypeElement annotatedClass = (TypeElement) annotatedElement;

            for (Element element : annotatedClass.getEnclosedElements()) {
                if (!(element instanceof VariableElement)) {
                    continue;
                }
                VariableElement variableElement = (VariableElement) element;

                if (variableElement.getSimpleName().toString().equals("id"))
                    hasIdField = true;

                if (variableElement.getSimpleName().toString().equals("type"))
                    hasTypeField = true;
            }

            if (!hasIdField || !hasTypeField) {
                error(annotatedElement, "Object does not hold an Id field or a Type field!");
                return false;
            }
        }

        return true;
    }

    private void error(Element element, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        processingEnv.getMessager().printMessage(ERROR, message, element);
    }
}
