package onespot.pivotal.devUtils;

import com.google.common.base.Joiner;
import com.google.gson.FieldNamingPolicy;
import onespot.pivotal.api.resources.Epic;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A simple tool to automatically create the XXXFieldNames enums
 * through reflection.  Useful for developers working on the library.
 */
public class DumpFieldNames {
    public static void main(String[] args) {
        Class<?> cls = Epic.class;
        System.out.println("public enum "+cls.getSimpleName()+"FieldNames {");
        System.out.println("   "+
                Joiner.on(',').join(
                        Arrays.stream(cls.getFields())
                                .map(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES::translateName)
                                .collect(Collectors.toList())));
        System.out.println("}");
    }
}
