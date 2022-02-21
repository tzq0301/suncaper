package cn.tzq0301.t2;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Sub implements Calculator {
    @Override
    public BigDecimal compute(BigDecimal num1, BigDecimal num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            throw new IllegalArgumentException("参数不能为 null");
        }

        return num1.subtract(num2);
    }
}
