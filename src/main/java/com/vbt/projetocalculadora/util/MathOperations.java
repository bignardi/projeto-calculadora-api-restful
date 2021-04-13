package com.vbt.projetocalculadora.util;

public class MathOperations {

    // Converte para Double
    public Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    // Verifica se o tipo é numérico
    public Boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
