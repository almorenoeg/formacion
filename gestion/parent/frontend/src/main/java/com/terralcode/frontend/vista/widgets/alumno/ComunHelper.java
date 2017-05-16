/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.terralcode.frontend.vista.widgets.alumno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author almoreno
 */
public class ComunHelper {
private static final Pattern cifPattern = Pattern.compile("[[A-H][J-N][P-S]UVW][0-9]{7}[0-9A-J]");
private static final String CONTROL_SOLO_NUMEROS = "ABEH"; // Sólo admiten números como caracter de control
private static final String CONTROL_SOLO_LETRAS = "KPQS"; // Sólo admiten letras como caracter de control
private static final String CONTROL_NUMERO_A_LETRA = "JABCDEFGHI"; // Conversión de dígito a letra de control.

    public static boolean validarNif7Digitos(String nif) {
        try {
            if (!cifPattern.matcher(nif).matches()) {
                // No cumple el patrón
                return false;
            }

            int parA = 0;
            for (int i = 2; i < 8; i += 2) {
                final int digito = Character.digit(nif.charAt(i), 10);
                if (digito < 0) {
                    return false;
                }
                parA += digito;
            }

            int nonB = 0;
            for (int i = 1; i < 9; i += 2) {
                final int digito = Character.digit(nif.charAt(i), 10);
                if (digito < 0) {
                    return false;
                }
                int nn = 2 * digito;
                if (nn > 9) {
                    nn = 1 + (nn - 10);
                }
                nonB += nn;
            }

            final int parcialC = parA + nonB;
            final int digitoE = parcialC % 10;
            final int digitoD = (digitoE > 0) ? (10 - digitoE) : 0;
            final char letraIni = nif.charAt(0);
            final char caracterFin = nif.charAt(8);

            final boolean esControlValido
                    = // ¿el caracter de control es válido como letra?
                    (CONTROL_SOLO_NUMEROS.indexOf(letraIni) < 0 && CONTROL_NUMERO_A_LETRA.charAt(digitoD) == caracterFin)
                    || // ¿el caracter de control es válido como dígito?
                    (CONTROL_SOLO_LETRAS.indexOf(letraIni) < 0 && digitoD == Character.digit(caracterFin, 10));
            return esControlValido;

        } catch (Exception e) {
            return false;
        }
    }

//    public static boolean isNifNie(String nif) {
//
//        _log.debug("NIF " + nif);
//        //si es NIE, eliminar la x,y,z inicial para tratarlo como nif
//        if (nif.toUpperCase().startsWith("X") || nif.toUpperCase().startsWith("Y") || nif.toUpperCase().startsWith("Z")) {
//            nif = nif.substring(1);
//        }
//
//        Pattern nifPattern
//                = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
//        Matcher m = nifPattern.matcher(nif);
//        if (m.matches()) {
//            String letra = m.group(2);
////Extraer letra del NIF
//            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
//            int dni = Integer.parseInt(m.group(1));
//            dni = dni % 23;
//            String reference = letras.substring(dni, dni + 1);
//
//            if (reference.equalsIgnoreCase(letra)) {
//                _log.debug("son iguales. Es NIF. " + letra + " " + reference);
//                return true;
//            } else {
//                _log.debug("NO son iguales. NO es NIF. " + letra + " " + reference);
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
}
