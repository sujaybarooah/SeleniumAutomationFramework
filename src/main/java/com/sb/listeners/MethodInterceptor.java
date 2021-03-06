package com.sb.listeners;

import com.sb.constants.FrameworkConstants;
import com.sb.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list =ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());
        List <IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringStringMap : list) {
                if ((method.getMethod().getMethodName().equalsIgnoreCase(stringStringMap.get("testname")))
                        && (stringStringMap.get("execute").equalsIgnoreCase("yes"))) {
                    method.getMethod().setDescription(stringStringMap.get("testdescription"));
                    method.getMethod().setInvocationCount(Integer.parseInt(stringStringMap.get("count")));
                    method.getMethod().setPriority(Integer.parseInt(stringStringMap.get("priority")));
                    result.add(method);
                }
            }
        }
        return result;
    }
}
