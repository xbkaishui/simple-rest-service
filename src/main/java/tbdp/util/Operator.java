package tbdp.util;

import java.util.Calendar;
import java.util.Date;

public enum Operator {

    ADD("+") {
        @Override
        public Date apply(Date date, DateType type, int amount) {
            Calendar cal = DateFormatUtil.toCalendar(date);
            cal.add(type.getCal(), amount);
            return cal.getTime();
        }
    },

    MINUS("-") {
        @Override
        public Date apply(Date date, DateType type, int amount) {
            Calendar cal = DateFormatUtil.toCalendar(date);
            cal.add(type.getCal(), -amount);
            return cal.getTime();
        }
    };

    String name;

    private Operator(String name) {
        this.name = name;
    }

    public abstract Date apply(Date date, DateType type, int amount);

    public static Operator getOperator(String op) {
        if (op.contains(MINUS.name)) {
            return MINUS;
        } else {
            return ADD;
        }
    }

}
