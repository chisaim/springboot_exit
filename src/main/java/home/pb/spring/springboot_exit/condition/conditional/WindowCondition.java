package home.pb.spring.springboot_exit.condition.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowCondition implements Condition {
    //返回true，才会执行
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //操作系统是Windows的,这个地方的Linux必须是首字母大写的，否则匹配条件不成立，造成后面Bean注入为空，造成空指针异常。
        return conditionContext.getEnvironment().getProperty("os.name").contains("Windows");

    }
}
