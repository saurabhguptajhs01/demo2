package TestNGExample;

import org.testng.IDataProviderMethod.*;
import org.testng.annotations.Ignore;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/* 
public class SampleDataInterceptor implements IDataProviderInterceptor {
    @Override
    public Iterator<Object[]> intercept(
            Iterator<Object[]> original, IDataProviderMethod dataProviderMethod,
                                        ITestNGMethod method, ITestContext iTestContext) {
        // The test method would have custom attributes. From them look for a custom attribute
        // whose name is "filter". It's value would the fully qualified class name that
        // can be instantiated using reflection and then used to filter the data provider
        // provided data set.
        Optional<String> found = Arrays.stream(method.getAttributes())
                .filter(it -> "filter".equalsIgnoreCase(it.name()))
                .flatMap(it -> Arrays.stream(it.values()))
                .findFirst();
        if (found.isPresent()) {
            String clazzName = found.get();
            Predicate<Object> predicate = predicate(clazzName);
            Spliterator<Object[]> split = Spliterators.spliteratorUnknownSize(original, Spliterator.ORDERED);
            return StreamSupport.stream(split,false)
                    .filter(predicate)
                    .collect(Collectors.toList())
                    .iterator();
        }
        return original;
    }

    private static Predicate<Object> predicate(String clazzName) {
        try {
            return (Predicate<Object>) Class.forName(clazzName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return input -> true;
        }
    }
}
*/