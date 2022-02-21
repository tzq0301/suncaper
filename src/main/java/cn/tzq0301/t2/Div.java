package cn.tzq0301.t2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Div implements Calculator {
    @Override
    public BigDecimal compute(BigDecimal num1, BigDecimal num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)) {
            throw new IllegalArgumentException("参数不能为 null");
        }

        if (num2.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("除数不能为 0");
        }

        return num1.divide(num2, 1, RoundingMode.DOWN);
    }
}
