package com.sb.utils;

import com.sb.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private DataProviderUtils() {
    }

    private static List<Map<String, String>> list = new ArrayList<>();

    @SuppressWarnings("DataProviderReturnType")
    @DataProvider(parallel = true)
    public static Object[] getData(Method method) {
        String testname = method.getName();
        if(list.isEmpty()){
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
        }
        List<Map<String, String>> iterationList = new ArrayList<>();

        for (Map<String, String> stringStringMap : list) {
            if ((stringStringMap.get("testname").equalsIgnoreCase(testname)) &&
                    stringStringMap.get("execute").equalsIgnoreCase("yes")) {
                iterationList.add(stringStringMap);
            }
        }
        return iterationList.toArray();
    }
}
