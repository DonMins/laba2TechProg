import java.math.BigInteger;
public enum OperatorEnum {
    OPERATOR_ADDITION, OPERATOR_SUBTRACTION,
    OPERATOR_MULTIPLICATION, OPERATOR_DIVISION,
    OPERATOR_MODULO,
    OPERATOR_UNKNOWN;
    public static final String ERROR_UNKNOWN_OPERATOR =
            "Error! Unexpected operator!";
    public int process(int lhs, int rhs) {
        BigInteger x = BigInteger.valueOf(lhs);
        BigInteger y = BigInteger.valueOf(rhs);
        switch (this) {
            case OPERATOR_ADDITION:
                return x.add(y).intValueExact();
            case OPERATOR_SUBTRACTION:
                return x.subtract(y).intValueExact();
            case OPERATOR_MULTIPLICATION:
                return x.multiply(y).intValueExact();
            case OPERATOR_DIVISION:
                return x.divide(y).intValueExact();
            case OPERATOR_MODULO:
                return x.mod(y).intValueExact();
        }
        throw new
                RuntimeException(ERROR_UNKNOWN_OPERATOR);
    }
}
